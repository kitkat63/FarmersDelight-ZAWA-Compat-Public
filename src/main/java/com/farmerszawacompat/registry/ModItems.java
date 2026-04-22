package com.farmerszawacompat.registry;

import com.farmerszawacompat.FarmersZawaCompatMod;
import com.farmerszawacompat.item.DescribedItem;
import com.farmerszawacompat.item.RawRedBeansItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FarmersZawaCompatMod.MOD_ID);

    public static final RegistryObject<Item> COOKED_ANTILLES_PINKTOE_TARANTULA = ITEMS.register(
            "cooked_antilles_pinktoe_tarantula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.5f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_BRAZILIAN_BLACK_TARANTULA = ITEMS.register(
            "cooked_brazilian_black_tarantula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.5f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_CHILEAN_ROSEHAIR_TARANTULA = ITEMS.register(
            "cooked_chilean_rosehair_tarantula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.5f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_COBALT_BLUE_TARANTULA = ITEMS.register(
            "cooked_cobalt_blue_tarantula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.5f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_GOLIATH_BIRDEATER_TARANTULA = ITEMS.register(
            "cooked_goliath_birdeater_tarantula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.5f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_GREENBOTTLE_BLUE_TARANTULA = ITEMS.register(
            "cooked_greenbottle_blue_tarantula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.5f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_KING_BABOON_TARANTULA = ITEMS.register(
            "cooked_king_baboon_tarantula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.5f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_MEXICAN_RED_KNEE_TARANTULA = ITEMS.register(
            "cooked_mexican_red_knee_tarantula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.5f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_WESTERN_DESERT_TARANTULA = ITEMS.register(
            "cooked_western_desert_tarantula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.5f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_ARIZONA_BARK_SCORPION = ITEMS.register(
            "cooked_arizona_bark_scorpion",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.35f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_ASIAN_FOREST_SCORPION = ITEMS.register(
            "cooked_asian_forest_scorpion",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.35f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_COMMON_YELLOW_SCORPION = ITEMS.register(
            "cooked_common_yellow_scorpion",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.35f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_EMPEROR_SCORPION = ITEMS.register(
            "cooked_emperor_scorpion",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.35f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_GIANT_HAIRY_SCORPION = ITEMS.register(
            "cooked_giant_hairy_scorpion",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.35f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_NORTHERN_SCORPION = ITEMS.register(
            "cooked_northern_scorpion",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.35f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_RED_CLAW_SCORPION = ITEMS.register(
            "cooked_red_claw_scorpion",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.35f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_MEALWORMS = ITEMS.register(
            "cooked_mealworms",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.6f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_TERMITES = ITEMS.register(
            "cooked_termites",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.45f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_AFRICAN_PRAYING_MANTIS = ITEMS.register(
            "cooked_african_praying_mantis",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_CHINESE_PRAYING_MANTIS = ITEMS.register(
            "cooked_chinese_praying_mantis",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_DEVILS_FLOWER_PRAYING_MANTIS = ITEMS.register(
            "cooked_devils_flower_praying_mantis",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_EUROPEAN_PRAYING_MANTIS = ITEMS.register(
            "cooked_european_praying_mantis",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_GHOST_PRAYING_MANTIS = ITEMS.register(
            "cooked_ghost_praying_mantis",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_ORCHID_PRAYING_MANTIS = ITEMS.register(
            "cooked_orchid_praying_mantis",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
    );



    public static final RegistryObject<Item> COOKED_AFRICAN_LAKE_CICHLID = ITEMS.register(
            "cooked_african_lake_cichlid",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.5f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_ANGELFISH = ITEMS.register(
            "cooked_angelfish",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.5f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_BETTA = ITEMS.register(
            "cooked_betta",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_CLOWNFISH = ITEMS.register(
            "cooked_clownfish",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_CORYDORAS = ITEMS.register(
            "cooked_corydoras",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_GRAMMA = ITEMS.register(
            "cooked_gramma",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_PLECOSTOMUS = ITEMS.register(
            "cooked_plecostomus",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.6f)
                    .build()))
    );

    public static final RegistryObject<Item> RAW_RED_BEANS = ITEMS.register(
            "raw_red_beans",
            () -> new RawRedBeansItem(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.1f)
                    .effect(() -> new net.minecraft.world.effect.MobEffectInstance(net.minecraft.world.effect.MobEffects.POISON, 120, 0), 1.0f)
                    .build()))
    );
    
    public static final RegistryObject<Item> COOKED_BUTTERFLYFISH = ITEMS.register(
            "cooked_butterflyfish",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
    ); 
    
    public static final RegistryObject<Item> COOKED_COWFISH = ITEMS.register(
            "cooked_cowfish",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
    );
 
    public static final RegistryObject<Item> COOKED_SPOTTED_DRUM = ITEMS.register(
            "cooked_spotted_drum",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.5f)
                    .build()))
    );

    public static final RegistryObject<Item> COOKED_SQUIRRELFISH = ITEMS.register(
            "cooked_squirrelfish",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
    );
 
    public static final RegistryObject<Item> COOKED_TRIGGERFISH = ITEMS.register(
            "cooked_triggerfish",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
    );
    
    public static final RegistryObject<Item> COOKED_MOORISH_IDOL = ITEMS.register(
            "cooked_moorish_idol",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
    ); 
    






    public static final RegistryObject<Item> POLLEN_DUST = ITEMS.register(
            "pollen_dust",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> BOILED_RED_BEANS = ITEMS.register(
            "boiled_red_beans",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationMod(0.8f)
                    .build()))
    );


    public static final RegistryObject<Item> BEANS_AND_RICE = ITEMS.register(
            "beans_and_rice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(0.85f)
                    .build()))
    );

    public static final RegistryObject<Item> MEAT_AND_VEGETABLE_SOUP = ITEMS.register(
            "meat_and_vegetable_soup",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(0.9f)
                    .build()))
    );

    public static final RegistryObject<Item> MEALWORM_FRIED_RICE = ITEMS.register(
            "mealworm_fried_rice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(9)
                    .saturationMod(0.8f)
                    .build()))
    );

    public static final RegistryObject<Item> TERMITE_SNACK = ITEMS.register(
            "termite_snack",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.5f)
                    .build()))
    );

    public static final RegistryObject<Item> TERMITE_RICE_SOUP = ITEMS.register(
            "termite_rice_soup",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(9)
                    .saturationMod(0.85f)
                    .build()))
    );

    public static final RegistryObject<Item> REFRIED_BEANS = ITEMS.register(
            "refried_beans",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(0.8f)
                    .build()))
    );

    public static final RegistryObject<Item> SEA_BUNNY_HEAD = ITEMS.register(
            "sea_bunny_head",
            () -> new DescribedItem(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.2f)
                    .build()))
    );

    public static final RegistryObject<Item> SEA_BUNNY_BUTT = ITEMS.register(
            "sea_bunny_butt",
            () -> new DescribedItem(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.2f)
                    .build()))
    );

    public static final RegistryObject<Item> MEALWORM_COOKIE = ITEMS.register(
            "mealworm_cookie",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.4f)
                    .build()))
    );

    public static final RegistryObject<Item> CHOCOLATE_COVERED_SCORPION = ITEMS.register(
            "chocolate_covered_scorpion",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.55f)
                    .build()))
    );

    public static final RegistryObject<Item> CHOCOLATE_COVERED_TARANTULA = ITEMS.register(
            "chocolate_covered_tarantula",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(0.6f)
                    .build()))
    );

    public static final RegistryObject<Item> CANDIED_MANTIS = ITEMS.register(
            "candied_mantis",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(0.65f)
                    .build()))
    );

    public static final RegistryObject<Item> WORM_PROTEIN_PATTY = ITEMS.register(
            "worm_protein_patty",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(0.75f)
                    .build()))
    );

    public static final RegistryObject<Item> MANTIS_AND_WORM_BROTH = ITEMS.register(
            "mantis_and_worm_broth",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(9)
                    .saturationMod(0.9f)
                    .build()))
    );

    public static final RegistryObject<Item> TARANTULA_BEAN_CHILI = ITEMS.register(
            "tarantula_bean_chili",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(0.95f)
                    .build()))
    );

    public static final RegistryObject<Item> INSECT_PROTEIN_WRAP = ITEMS.register(
            "insect_protein_wrap",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(0.8f)
                    .build()))
    );

    public static final RegistryObject<Item> BUGGERS_FEAST = ITEMS.register(
            "buggers_feast",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(12)
                    .saturationMod(1.0f)
                    .build()))
    );

    public static final RegistryObject<Item> ESCARGOT = ITEMS.register(
            "escargot",
            () -> new DescribedItem(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(1.0f)
                    .build()))
    );



    public static final RegistryObject<Item> HORSESHOE_CRAB_EGG_SALAD = ITEMS.register(
            "horseshoe_crab_egg_salad",
            () -> new DescribedItem(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(0.85f)
                    .build()))
    );


    public static final RegistryObject<Item> HORSESHOE_CRAB_ROE = ITEMS.register(
            "horseshoe_crab_roe",
            () -> new DescribedItem(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.15f)
                    .build()))
    );

    public static final RegistryObject<Item> LOGO = ITEMS.register(
            "logo",
            () -> new Item(new Item.Properties())
    );

    private ModItems() {
    }
}
