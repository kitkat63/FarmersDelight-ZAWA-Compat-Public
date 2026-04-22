package com.farmerszawacompat;

import com.farmerszawacompat.registry.ModBlocks;
import com.farmerszawacompat.registry.ModCreativeModeTabs;
import com.farmerszawacompat.registry.ModItems;
import com.farmerszawacompat.registry.ModMobEffects;
import com.farmerszawacompat.registry.ModPotions;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.BlockState;
import com.farmerszawacompat.block.LegumePlantBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import java.util.List;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.crafting.StrictNBTIngredient;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(FarmersZawaCompatMod.MOD_ID)
public class FarmersZawaCompatMod {
    public static final String MOD_ID = "fdzawacompat";
    private static final ResourceLocation BEAN_PLANT_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "bean_plant");
    private static final ResourceLocation FARMERS_DELIGHT_ORGANIC_COMPOST_ID = ResourceLocation.fromNamespaceAndPath("farmersdelight", "organic_compost");
    private static final TagKey<Item> BUTTERFLIES_TAG = TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MOD_ID, "butterflies"));
    private static final ResourceLocation FAST_FOOD_ADVANCEMENT_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "fast_food");
    private static final ResourceLocation ESCARGOT_RECIPE_ID = ResourceLocation.fromNamespaceAndPath(MOD_ID, "cooking/escargot_from_cooking_pot");

    public FarmersZawaCompatMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.BLOCKS.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModMobEffects.MOB_EFFECTS.register(modBus);
        ModPotions.POTIONS.register(modBus);
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modBus);
        modBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.RAW_RED_BEANS.get(), 0.3f);
            ComposterBlock.COMPOSTABLES.put(ModItems.BOILED_RED_BEANS.get(), 0.65f);

            ItemStack awkwardPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD);
            ItemStack potentSkinPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.POTENT_SKIN.get());
            ItemStack potentSkinExtendedPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.POTENT_SKIN_EXTENDED.get());
            ItemStack potentSkinGlowingPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), ModPotions.POTENT_SKIN_GLOWING.get());

            // Forge BrewingRecipeRegistry entries are consumed by the vanilla Brewing Stand.
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                    StrictNBTIngredient.of(awkwardPotion),
                    Ingredient.of(ModItems.SEA_BUNNY_HEAD.get(), ModItems.SEA_BUNNY_BUTT.get()),
                    potentSkinPotion
            ));
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                    StrictNBTIngredient.of(potentSkinPotion),
                    Ingredient.of(Items.REDSTONE),
                    potentSkinExtendedPotion
            ));
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                    StrictNBTIngredient.of(potentSkinPotion),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    potentSkinGlowingPotion
            ));
        });
    }

    @SubscribeEvent
    public void onPlayerWithPotentSkinHurt(LivingHurtEvent event) {
        if (!(event.getEntity() instanceof net.minecraft.world.entity.player.Player player)) {
            return;
        }
        if (player.level().isClientSide()) {
            return;
        }
        if (!player.hasEffect(ModMobEffects.POTENT_SKIN.get())) {
            return;
        }

        net.minecraft.world.effect.MobEffectInstance instance = player.getEffect(ModMobEffects.POTENT_SKIN.get());
        int amplifier = instance == null ? 0 : instance.getAmplifier();
        int poisonDuration = 20 * (6 + amplifier * 3);

        if (event.getSource().getEntity() instanceof net.minecraft.world.entity.LivingEntity attacker && attacker != player) {
            applyRetaliationPoison(attacker, poisonDuration, amplifier);
        }
        if (event.getSource().getDirectEntity() instanceof net.minecraft.world.entity.LivingEntity directAttacker && directAttacker != player) {
            applyRetaliationPoison(directAttacker, poisonDuration, amplifier);
        }
    }

    private static void applyRetaliationPoison(
            net.minecraft.world.entity.LivingEntity attacker,
            int poisonDuration,
            int amplifier
    ) {
        attacker.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                net.minecraft.world.effect.MobEffects.POISON,
                poisonDuration,
                amplifier
        ));
        attacker.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                net.minecraft.world.effect.MobEffects.GLOWING,
                20 * 5,
                0
        ));
        attacker.hurt(attacker.damageSources().magic(), 1.0f);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void onRightClickBeanPlantCompost(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != InteractionHand.MAIN_HAND || !(event.getLevel() instanceof ServerLevel serverLevel)) {
            return;
        }

        BlockPos pos = event.getPos();
        BlockState state = serverLevel.getBlockState(pos);
        ResourceLocation blockId = ForgeRegistries.BLOCKS.getKey(state.getBlock());
        if (!BEAN_PLANT_ID.equals(blockId) || !isOrganicCompost(event.getItemStack())) {
            return;
        }

        IntegerProperty ageProperty = getAgeLikeProperty(state);
        if (ageProperty == null || isMature(state, ageProperty)) {
            return;
        }

        int nextAge = Math.min(state.getValue(ageProperty) + 1, getMax(ageProperty));
        serverLevel.setBlock(pos, state.setValue(ageProperty, nextAge), 2);
        serverLevel.levelEvent(1505, pos, 0);

        ItemStack heldStack = event.getItemStack();
        if (!event.getEntity().getAbilities().instabuild) {
            heldStack.shrink(1);
        }

        event.setUseBlock(Event.Result.DENY);
        event.setUseItem(Event.Result.DENY);
        event.setCancellationResult(InteractionResult.SUCCESS);
        event.setCanceled(true);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void onRightClickZawaLegumeHarvest(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != InteractionHand.MAIN_HAND || !(event.getLevel() instanceof ServerLevel serverLevel)) {
            return;
        }

        BlockPos pos = event.getPos();
        BlockState state = serverLevel.getBlockState(pos);
        ResourceLocation blockId = ForgeRegistries.BLOCKS.getKey(state.getBlock());
        if (blockId == null || !"zawa".equals(blockId.getNamespace()) || !blockId.getPath().contains("legume")) {
            return;
        }

        IntegerProperty legumeAgeProperty = getNamedIntegerProperty(state, "age");
        if (legumeAgeProperty != null && state.getValue(legumeAgeProperty) < getMax(legumeAgeProperty)) {
            return;
        }

        BlockState compatRegrownState = ModBlocks.LEGUME_BUSH.get().defaultBlockState().setValue(LegumePlantBlock.AGE, 0);
        serverLevel.setBlock(pos, compatRegrownState, 2);

        int dropCount = 1 + serverLevel.random.nextInt(3);
        net.minecraft.world.level.block.Block.popResource(serverLevel, pos, new ItemStack(ModItems.RAW_RED_BEANS.get(), dropCount));
        serverLevel.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(event.getEntity(), compatRegrownState));

        serverLevel.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS,
                1.0F, 0.8F + serverLevel.random.nextFloat() * 0.4F);

        event.setUseBlock(Event.Result.DENY);
        event.setUseItem(Event.Result.DENY);
        event.setCancellationResult(InteractionResult.SUCCESS);
        event.setCanceled(true);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void onRightClickRawButterfly(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != InteractionHand.MAIN_HAND || !(event.getLevel() instanceof ServerLevel serverLevel)) {
            return;
        }

        ItemStack heldStack = event.getItemStack();
        if (!heldStack.is(BUTTERFLIES_TAG) || !event.getEntity().canEat(false)) {
            return;
        }

        event.getEntity().getFoodData().eat(1, 0.1f);
        serverLevel.playSound(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(),
                SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 1.0F, 0.9F + serverLevel.random.nextFloat() * 0.2F);

        if (!event.getEntity().getAbilities().instabuild) {
            heldStack.shrink(1);
        }

        event.getEntity().awardStat(Stats.ITEM_USED.get(heldStack.getItem()));
        event.setCancellationResult(InteractionResult.SUCCESS);
        event.setCanceled(true);
    }

    @SubscribeEvent
    public void onPotionTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (!stack.is(Items.POTION)) {
            return;
        }

        net.minecraft.world.item.alchemy.Potion potion = PotionUtils.getPotion(stack);
        ResourceLocation potionId = ForgeRegistries.POTIONS.getKey(potion);
        if (potionId == null || !MOD_ID.equals(potionId.getNamespace()) || !potionId.getPath().startsWith("potent_skin")) {
            return;
        }

        Component description = Component.translatable("potion." + MOD_ID + "." + potionId.getPath() + ".description");
        if (description.getString().equals("potion." + MOD_ID + "." + potionId.getPath() + ".description")) {
            return;
        }

        List<Component> tooltip = event.getToolTip();
        tooltip.add(Component.empty());
        tooltip.add(description.copy().withStyle(ChatFormatting.GRAY));
    }

    @SubscribeEvent
    public void onPotionBrew(PotionBrewEvent.Pre event) {
        ItemStack ingredient = event.getItem(3);
        if (!ingredient.is(Items.GUNPOWDER) && !ingredient.is(Items.DRAGON_BREATH)) {
            return;
        }

        for (int slot = 0; slot < 3; slot++) {
            ItemStack input = event.getItem(slot);
            if (!input.is(Items.POTION)) {
                continue;
            }

            net.minecraft.world.item.alchemy.Potion potion = PotionUtils.getPotion(input);
            ResourceLocation potionId = ForgeRegistries.POTIONS.getKey(potion);
            if (potionId != null && MOD_ID.equals(potionId.getNamespace()) && potionId.getPath().startsWith("potent_skin")) {
                event.setCanceled(true);
                return;
            }
        }
    }


    @SubscribeEvent
    public void onPlayerLoginEnsureEscargotRecipe(PlayerEvent.PlayerLoggedInEvent event) {
        if (!(event.getEntity() instanceof net.minecraft.server.level.ServerPlayer player)) {
            return;
        }

        net.minecraft.advancements.Advancement fastFoodAdvancement = player.server.getAdvancements().getAdvancement(FAST_FOOD_ADVANCEMENT_ID);
        if (fastFoodAdvancement == null || !player.getAdvancements().getOrStartProgress(fastFoodAdvancement).isDone()) {
            return;
        }

        player.server.getRecipeManager().byKey(ESCARGOT_RECIPE_ID).ifPresent(recipe ->
                player.awardRecipes(java.util.List.of(recipe))
        );
    }

    private static IntegerProperty getAgeLikeProperty(BlockState state) {
        return state.getProperties().stream()
                .filter(p -> p instanceof IntegerProperty)
                .map(p -> (IntegerProperty) p)
                .sorted((a, b) -> {
                    int aScore = getAgeScore(a);
                    int bScore = getAgeScore(b);
                    if (aScore != bScore) {
                        return Integer.compare(bScore, aScore);
                    }
                    return Integer.compare(getMax(b) - getMin(b), getMax(a) - getMin(a));
                })
                .findFirst()
                .orElse(null);
    }

    private static int getAgeScore(IntegerProperty property) {
        String name = property.getName();
        if ("age".equals(name)) {
            return 3;
        }
        if ("stage".equals(name) || "growth".equals(name)) {
            return 2;
        }
        return 1;
    }

    private static IntegerProperty getNamedIntegerProperty(BlockState state, String propertyName) {
        return state.getProperties().stream()
                .filter(p -> p instanceof IntegerProperty && propertyName.equals(p.getName()))
                .map(p -> (IntegerProperty) p)
                .findFirst()
                .orElse(null);
    }

    private static boolean isMature(BlockState state, IntegerProperty ageProperty) {
        return state.getValue(ageProperty) >= getMax(ageProperty);
    }

    private static int getMin(IntegerProperty property) {
        return property.getPossibleValues().stream().mapToInt(Integer::intValue).min().orElse(0);
    }

    private static int getMax(IntegerProperty property) {
        return property.getPossibleValues().stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    private static boolean isOrganicCompost(ItemStack stack) {
        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(stack.getItem());
        return FARMERS_DELIGHT_ORGANIC_COMPOST_ID.equals(itemId);
    }
}
