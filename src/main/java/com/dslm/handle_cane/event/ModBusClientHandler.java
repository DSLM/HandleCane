package com.dslm.handle_cane.event;

import com.dslm.handle_cane.Register;
import com.dslm.handle_cane.particle.MotorExitParticle;
import com.dslm.handle_cane.util.StaticValue;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = StaticValue.MOD_ID, value = Dist.CLIENT)
public class ModBusClientHandler
{
    @SubscribeEvent
    public static void onParticleFactoryRegistration(ParticleFactoryRegisterEvent event)
    {
        Minecraft.getInstance().particleEngine.register(Register.MOTOR_EXIT_PARTICLE_TYPE.get(), MotorExitParticle.Provider::new);
    }
}
