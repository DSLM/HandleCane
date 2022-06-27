package com.dslm.handle_cane;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("handle_cane")
public class HandleCane
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public HandleCane()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        
        bus.register(Register.class);
        Register.register(bus);
    }
}
