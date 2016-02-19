package com.golems_addon_futurum.main;

import com.golems_addon_futurum.entity.EntityMushroomGolem;
import com.golems_addon_futurum.entity.EntityPrismarineGolem;
import com.golems_addon_futurum.entity.EntityRedSandstoneGolem;
import com.golems_addon_futurum.entity.EntitySeaLanternGolem;
import com.golems_addon_futurum.entity.EntitySlimeGolem;

import cpw.mods.fml.common.registry.EntityRegistry;

public class FuturumGolemEntityRegister 
{
	private static int futurumGolemEntityID;

	public static void mainRegistry() 
	{
		futurumGolemEntityID = 0;
		register(EntityMushroomGolem.class, "golem_shroom");
		register(EntityPrismarineGolem.class, "golem_prismarine");
		register(EntityRedSandstoneGolem.class, "golem_red_sandstone");
		register(EntitySeaLanternGolem.class, "golem_sea_lantern");
		register(EntitySlimeGolem.class, "golem_slime");
	}

	private static void register(Class entityClass, String name)
	{
		EntityRegistry.registerModEntity(entityClass, name, ++futurumGolemEntityID, FuturumGolems.instance, 48, 3, true);
	}

}
