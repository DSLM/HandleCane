package com.dslm.handle_cane.event;

import com.dslm.handle_cane.util.StaticValue;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = StaticValue.MOD_ID)
public class ForgeBusHandler
{
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        if(!CaneProcess.checkCane(event, event.player, InteractionHand.MAIN_HAND))
        {
            if(!CaneProcess.checkCane(event, event.player, InteractionHand.OFF_HAND))
            {
                CaneProcess.cleanCane(event, event.player, InteractionHand.OFF_HAND, null);
            }
        }
    }
    
    @SubscribeEvent
    public static void onPlayerJump(LivingEvent.LivingJumpEvent event)
    {
        if(event.getEntity() instanceof Player player && !CaneProcess.checkCaneJump(event, player, InteractionHand.MAIN_HAND))
        {
            CaneProcess.checkCaneJump(event, player, InteractionHand.OFF_HAND);
        }
    }
    
    @SubscribeEvent
    public static void onPlayerFall(LivingFallEvent event)
    {
        if(event.getEntity() instanceof Player player && !CaneProcess.checkCaneFall(event, player, InteractionHand.MAIN_HAND))
        {
            CaneProcess.checkCaneFall(event, player, InteractionHand.OFF_HAND);
        }
    }
}
