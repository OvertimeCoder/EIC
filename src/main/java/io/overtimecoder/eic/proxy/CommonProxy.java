package io.overtimecoder.eic.proxy;

import io.overtimecoder.eic.EIC;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod.EventBusSubscriber(modid = EIC.MODID)
public abstract class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        EIC.logger.info("CommonProxy.preInit");
    }

    public void init(FMLInitializationEvent event) {
        EIC.logger.info("CommonProxy.init");
    }

    public void postInit(FMLPostInitializationEvent event) {
        EIC.logger.info("CommonProxy.postInit");
    }
}
