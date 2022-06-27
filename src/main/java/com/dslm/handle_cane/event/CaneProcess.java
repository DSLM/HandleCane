package com.dslm.handle_cane.event;

import com.dslm.handle_cane.item.CaneTypeInterface;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class CaneProcess
{
    public static List<CaneTypeInterface> canes = null;
    
    public static boolean checkCane(TickEvent.PlayerTickEvent event, Player player, InteractionHand hand)
    {
        if(player.getItemInHand(hand).getItem() instanceof CaneTypeInterface caneType)
        {
            cleanCane(event, player, hand, caneType);
            caneType.checkCane(event, player, hand);
            return true;
        }
        
        return false;
    }
    
    public static void cleanCane(TickEvent.PlayerTickEvent event, Player player, InteractionHand hand, CaneTypeInterface excludeOne)
    {
        if(canes == null)
        {
            canes = ForgeRegistries.ITEMS.getValues().stream()
                    .filter(item -> item instanceof CaneTypeInterface)
                    .map(item -> (CaneTypeInterface) item)
                    .toList();
        }
        
        for(var cane : canes)
        {
            if(excludeOne != null && excludeOne.equals(cane))
            {
                continue;
            }
            cane.cleanCane(event, player, hand);
        }
    }
    
    public static boolean checkCaneJump(LivingEvent.LivingJumpEvent event, Player player, InteractionHand hand)
    {
        if(player.getItemInHand(hand).getItem() instanceof CaneTypeInterface caneType)
        {
            caneType.checkCaneJump(event, player, hand);
            return true;
        }
        
        return false;
    }
    
    public static boolean checkCaneFall(LivingFallEvent event, Player player, InteractionHand hand)
    {
        if(player.getItemInHand(hand).getItem() instanceof CaneTypeInterface caneType)
        {
            caneType.checkCaneFall(event, player, hand);
            return true;
        }
        
        return false;
    }
}
