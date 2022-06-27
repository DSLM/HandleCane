package com.dslm.handle_cane.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class BambooCaneItem extends Item implements CaneTypeInterface
{
    public static final UUID CANE_SPEED_ID = UUID.fromString("10d62243-c5e5-4c8e-b964-2e8a47a7adaa");
    
    public BambooCaneItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced)
    {
        tooltipComponents.add(new TranslatableComponent("tooltip.handle_cane.bamboo_cane_item.1").withStyle(style -> style.withColor(TextColor.fromRgb(0x70AA39))));
        
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
    
    @Override
    public void checkCane(TickEvent.PlayerTickEvent event, Player player, InteractionHand hand)
    {
        AttributeModifier caneSpeed = new AttributeModifier(CANE_SPEED_ID, "cane_speed", 0.25, AttributeModifier.Operation.ADDITION);
        if(!player.getAttributes().getInstance(Attributes.MOVEMENT_SPEED).hasModifier(caneSpeed))
        {
            player.getAttributes().getInstance(Attributes.MOVEMENT_SPEED).addPermanentModifier(caneSpeed);
            player.maxUpStep = 3;
        }
    }
    
    @Override
    public void cleanCane(TickEvent.PlayerTickEvent event, Player player, InteractionHand hand)
    {
        if(player.getAttributes().getInstance(Attributes.MOVEMENT_SPEED).getModifier(CANE_SPEED_ID) != null)
        {
            player.getAttributes().getInstance(Attributes.MOVEMENT_SPEED).removeModifier(CANE_SPEED_ID);
            player.maxUpStep = 0.6f;
        }
    }
    
    @Override
    public void checkCaneJump(LivingEvent.LivingJumpEvent event, Player player, InteractionHand hand)
    {
        player.setDeltaMovement(player.getDeltaMovement().add(0, 0.5, 0));
    }
    
    @Override
    public void checkCaneFall(LivingFallEvent event, Player player, InteractionHand hand)
    {
        event.setDistance(0);
    }
}
