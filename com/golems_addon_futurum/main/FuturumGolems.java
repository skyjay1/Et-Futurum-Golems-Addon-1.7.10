package com.golems_addon_futurum.main;

import com.golems_addon_futurum.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = FuturumGolems.MODID, name = FuturumGolems.NAME, version = FuturumGolems.VERSION, dependencies = "required-after:" + FuturumGolems.DEPENDENCY_MODID, acceptedMinecraftVersions = FuturumGolems.MCVERSION)
public class FuturumGolems 
{
	public static final String MODID = "golems_addon_futurum";
	public static final String DEPENDENCY_MODID = "golems";
	public static final String NAME = "Et Futurum Golems Addon";
	public static final String VERSION = "1.03";
	public static final String MCVERSION = "1.7.10";
	public static final String CLIENT = "com." + MODID + ".proxies.ClientProxy";
	public static final String SERVER = "com." + MODID + ".proxies.CommonProxy";
	
	@Mod.Instance(FuturumGolems.MODID)
	public static FuturumGolems instance;
	
	@SidedProxy(clientSide = FuturumGolems.CLIENT, serverSide = FuturumGolems.SERVER)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) 
	{	
		FuturumConfig.mainRegistry(new Configuration(event.getSuggestedConfigurationFile()));
		FuturumGolemEntityRegister.mainRegistry();
		proxy.registerEntityRenders();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(new EventHandlerCommon());
		proxy.registerEvents();
	}
}

