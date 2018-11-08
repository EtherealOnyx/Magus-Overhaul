package com.etherealonyx.magusoverhaul;

import com.etherealonyx.magusoverhaul.proxy.CommonProxy;

import net.minecraft.init.Blocks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;

import net.minecraftforge.fml.common.SidedProxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


import org.apache.logging.log4j.Logger;

@Mod(modid = MagusOverhaul.MODID, name = MagusOverhaul.NAME, version = MagusOverhaul.VERSION)
public class MagusOverhaul
{
    public static final String MODID = "magusoverhaul";
    public static final String NAME = "Magus Overhaul";
    public static final String VERSION = "0.0.1";

    private static Logger logger;

    @SidedProxy(serverSide = "com.etherealonyx.magusoverhaul.proxy.CommonProxy", clientSide = "com.etherealonyx.magusoverhaul.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
