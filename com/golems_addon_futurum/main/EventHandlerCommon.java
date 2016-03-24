package com.golems_addon_futurum.main;

import com.golems.entity.EntityIceGolem;
import com.golems.events.GolemBuildEvent;
import com.golems.main.Config;
import com.golems_addon_futurum.entity.EntityMushroomGolem;
import com.golems_addon_futurum.entity.EntityPrismarineGolem;
import com.golems_addon_futurum.entity.EntityRedSandstoneGolem;
import com.golems_addon_futurum.entity.EntitySeaLanternGolem;
import com.golems_addon_futurum.entity.EntitySlimeGolem;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;

public class EventHandlerCommon 
{
	@SubscribeEvent
	public void onBuildGolem(GolemBuildEvent event)
	{
		String name = event.blockBelow.getUnlocalizedName();	
		// if it has not already been set
		if(event.isGolemNull())
		{
			if(name.equalsIgnoreCase("tile.etfuturum.prismarine_block"))
			{
				event.setGolem(new EntityPrismarineGolem(event.worldObj), FuturumConfig.ALLOW_PRISMARINE);
			}
			else if(name.equalsIgnoreCase("tile.etfuturum.sea_lantern"))
			{
				event.setGolem(new EntitySeaLanternGolem(event.worldObj), FuturumConfig.ALLOW_SEA_LANTERN);
			}
			else if(name.equalsIgnoreCase("tile.etfuturum.red_sandstone"))
			{
				event.setGolem(new EntityRedSandstoneGolem(event.worldObj), FuturumConfig.ALLOW_RED_SANDSTONE);
			}
			else if(name.equalsIgnoreCase("tile.etfuturum.red_mushroom") || name.equalsIgnoreCase("tile.etfuturum.brown_mushroom"))
			{
				event.setGolem(new EntityMushroomGolem(event.worldObj), FuturumConfig.ALLOW_MUSHROOM);
			}
			else if(name.equalsIgnoreCase("tile.etfuturum.slime"))
			{
				event.setGolem(new EntitySlimeGolem(event.worldObj), FuturumConfig.ALLOW_SLIME);
			}
		}
	}
/*
	public static boolean matchesOreDict(Block block, String toCheck)
	{
		ItemStack oreStack = new ItemStack(Item.getItemFromBlock(block));
		ArrayList<ItemStack> stackCheck = OreDictionary.getOres(toCheck);	
		return !stackCheck.isEmpty() && oreStack.equals(stackCheck.get(0));
	}
*/
}
