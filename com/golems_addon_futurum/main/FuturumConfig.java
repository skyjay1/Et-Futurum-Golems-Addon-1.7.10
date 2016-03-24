package com.golems_addon_futurum.main;

import net.minecraftforge.common.config.Configuration;

/** Registers the config settings to adjust aspects of this mod **/
public class FuturumConfig 
{
	public static boolean ALLOW_MUSHROOM;
	public static boolean ALLOW_PRISMARINE;
	public static boolean ALLOW_RED_SANDSTONE;
	public static boolean ALLOW_SEA_LANTERN;
	public static boolean ALLOW_SLIME;
	
	public static boolean ALLOW_SLIME_SPECIAL;
	public static boolean ALLOW_MUSHROOM_SPECIAL;

	public static float TWEAK_SLIME;
	public static int TWEAK_MUSHROOM;
	
	private static final String CATEGORY_SPAWNS = "spawns";
	private static final String CATEGORY_ABILITY = "abilities";
	private static final String CATEGORY_TWEAKS = "tweaks";
	
	public static void mainRegistry(Configuration config)
	{
		config.load();
		
		ALLOW_MUSHROOM = config.getBoolean("Allow Mushroom Golem", CATEGORY_SPAWNS, true, 
				"Whether the Mushroom Golem can be constructed.");
		ALLOW_PRISMARINE = config.getBoolean("Allow Prismarine Golem", CATEGORY_SPAWNS, true, 
				"Whether the Prismarine Golem can be constructed.");
		ALLOW_RED_SANDSTONE = config.getBoolean("Allow Red Sandstone Golem", CATEGORY_SPAWNS, true, 
				"Whether the Red Sandstone Golem can be constructed.");
		ALLOW_SEA_LANTERN = config.getBoolean("Allow Sea Lantern Golem", CATEGORY_SPAWNS, true, 
				"Whether the Sea Lantern Golem can be constructed.");
		ALLOW_SLIME = config.getBoolean("Allow Slime Golem", CATEGORY_SPAWNS, true, 
				"Whether the Congealed Slime Golem can be constructed.");
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		ALLOW_SLIME_SPECIAL = config.getBoolean("Allow Slime Golem Special", CATEGORY_ABILITY, true, 
				"Whether the Congealed Slime Golem can apply extra knockback when attacking");
		ALLOW_MUSHROOM_SPECIAL = config.getBoolean("Allow Mushroom Golem Special", CATEGORY_ABILITY, true, 
				"Whether the Mushroom Golem can occasionally plant mushrooms");
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		TWEAK_SLIME = config.getFloat("Slime Golem Knockback", CATEGORY_TWEAKS, 2.1012F, 0.001F, 10.0F, 
				"How powerful the Congealed Slime Golem attack is (Higher Value = Further Knockback)");
		TWEAK_MUSHROOM = config.getInt("Mushroom Golem Interval", CATEGORY_TWEAKS, 420, 2, 24000, 
				"Average ticks between planting mushrooms ");
		
		config.save();
	}
}
