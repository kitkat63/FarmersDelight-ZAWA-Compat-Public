package com.farmerszawacompat.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DescribedItem extends Item {
    public DescribedItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        Component description = Component.translatable(this.getDescriptionId() + ".description");
        if (!description.getString().equals(this.getDescriptionId() + ".description")) {
            tooltip.add(description.copy().withStyle(ChatFormatting.GRAY));
        }
    }
}
