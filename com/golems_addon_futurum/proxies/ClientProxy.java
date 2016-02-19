package com.golems_addon_futurum.proxies;

import com.golems.entity.GolemBase;
import com.golems_addon_futurum.entity.EntityMushroomGolem;
import com.golems_addon_futurum.entity.EntityPrismarineGolem;
import com.golems_addon_futurum.entity.EntityRedSandstoneGolem;
import com.golems_addon_futurum.entity.EntitySeaLanternGolem;
import com.golems_addon_futurum.entity.EntitySlimeGolem;
import com.golems_addon_futurum.main.EventHandlerClient;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy 
{	
	@Override
	public void registerEntityRenders()
	{		
		register(EntityMushroomGolem.class);
		register(EntityPrismarineGolem.class);
		register(EntityRedSandstoneGolem.class);
		register(EntitySeaLanternGolem.class);
		register(EntitySlimeGolem.class);
	}
	
	@Override
	public void registerEvents()
	{
		MinecraftForge.EVENT_BUS.register(new EventHandlerClient());
	}
	
	/**	Registers an entity with the RenderGolem rendering class */
	private void register(Class<? extends GolemBase> golem)
	{
		RenderingRegistry.registerEntityRenderingHandler(golem, new com.golems.renders.RenderGolem());
	}
}
