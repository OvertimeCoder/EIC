package io.overtimecoder.eic;

import io.overtimecoder.eic.proxy.CommonProxy;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

import static io.overtimecoder.eic.init.Items.*;

@Mod(modid = EIC.MODID, name = EIC.NAME, version = EIC.VERSION)
public class EIC
{
    public static final String MODID = "eic";
    public static final String NAME = "Electric Industry Craft";
    public static final String VERSION = "1.0";

    public static Logger logger;

    public static final String CLIENT_PROXY = "io.overtimecoder." + MODID + ".proxy.ClientProxy";
    public static final String SERVER_PROXY = "io.overtimecoder." + MODID + ".proxy.ServerProxy";

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.Metadata(MODID)
    public static ModMetadata meta;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModInfo.loadInfo(meta);
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event); // 追記
    }

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(proxy);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(TUNGSTEN);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(TUNGSTEN, 0, new ModelResourceLocation(new ResourceLocation(MODID, "tungsten"), "inventory"));
    }
}
