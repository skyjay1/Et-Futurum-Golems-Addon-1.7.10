package com.golems_addon_futurum.main;

import com.golems.events.GolemPaperAddInfoEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class EventHandlerClient 
{	
	@SubscribeEvent
	public void onAddInfo(GolemPaperAddInfoEvent event)
	{
		String loreIntro = new ChatComponentTranslation(EnumChatFormatting.WHITE + trans("tooltip.et_futurum_materials") + ":").getFormattedText();
		event.infoList.add(loreIntro);
		event.infoList.add(trans("material.prismarine") + ", " + trans("material.sea_lantern") + ",");
		event.infoList.add(trans("material.shroom_block") + ", " + trans("material.slime_block"));
	}
	
	private String trans(String s)
	{
		return StatCollector.translateToLocal(s);
	}
}
