package com.etherealonyx.magusoverhaul;

import com.etherealonyx.magusoverhaul.item.ModItems;
import com.etherealonyx.magusoverhaul.proxy.CommonProxy;

import net.minecraft.init.Blocks;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;

import net.minecraftforge.fml.common.SidedProxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MagusOverhaul.MODID, name = MagusOverhaul.NAME, version = MagusOverhaul.VERSION)
public class MagusOverhaul
{
    public static final String MODID = "magusoverhaul";
    public static final String NAME = "Magus Overhaul";
    public static final String VERSION = "0.0.1";

    public static Logger logger;

    @SidedProxy(serverSide = "com.etherealonyx.magusoverhaul.proxy" +
            ".CommonProxy", clientSide = "com.etherealonyx.magusoverhaul" +
            ".proxy.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.registerCapabilities();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModItems.registerModels();
        }

    }



}
