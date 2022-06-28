package com.dslm.handle_cane.item;

import com.dslm.handle_cane.Register;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class QuadCaneItem extends Item implements CaneTypeInterface
{
    public QuadCaneItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public void checkCane(TickEvent.PlayerTickEvent event, Player player, InteractionHand hand)
    {
        if(player.getDeltaMovement().y() != 0)
        {
            player.setDeltaMovement(player.getDeltaMovement().x(), 0, player.getDeltaMovement().z());
        }
        if(player.getLevel().isClientSide())
        {
            double estimatedAngle = 44.3;
            double estimatedDistance = 0.59;
        
            double fromS = (player.yBodyRot % 360 + (hand == InteractionHand.MAIN_HAND ? 1 : -1) * estimatedAngle) / 180 * Math.PI;
            double x = player.getX() - Math.sin(fromS) * estimatedDistance;
            double y = player.getY();
            double z = player.getZ() + Math.cos(fromS) * estimatedDistance;
            player.getLevel().addParticle(Register.MOTOR_EXIT_PARTICLE_TYPE.get(), x, y, z, 0.0D, -1.0D, 0.0D);
        }
    }
    
    @Override
    public void cleanCane(TickEvent.PlayerTickEvent event, Player player, InteractionHand hand)
    {
    
    }
    
    @Override
    public void checkCaneJump(LivingEvent.LivingJumpEvent event, Player player, InteractionHand hand)
    {
    
    }
    
    @Override
    public void checkCaneFall(LivingFallEvent event, Player player, InteractionHand hand)
    {
    
    }
}
