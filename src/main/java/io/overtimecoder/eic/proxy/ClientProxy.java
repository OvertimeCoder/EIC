package io.overtimecoder.eic.proxy;

import io.overtimecoder.eic.EIC;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        EIC.logger.info("ClientProxy.preInit");
    }
}
