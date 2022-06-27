package com.dslm.handle_cane.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public interface CaneTypeInterface
{
    void checkCane(TickEvent.PlayerTickEvent event, Player player, InteractionHand hand);
    
    void cleanCane(TickEvent.PlayerTickEvent event, Player player, InteractionHand hand);
    
    void checkCaneJump(LivingEvent.LivingJumpEvent event, Player player, InteractionHand hand);
    
    void checkCaneFall(LivingFallEvent event, Player player, InteractionHand hand);
}
