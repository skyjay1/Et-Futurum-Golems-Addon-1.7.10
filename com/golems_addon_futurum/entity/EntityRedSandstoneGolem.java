package com.golems_addon_futurum.entity;

import java.util.List;

import com.golems.entity.EntitySandstoneGolem;
import com.golems.entity.GolemBase;
import com.golems_addon_futurum.main.FuturumGolems;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class EntityRedSandstoneGolem extends EntitySandstoneGolem
{			
	public EntityRedSandstoneGolem(World world) 
	{
		super(world);
	}

	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(FuturumGolems.MODID, "red_sandstone"));
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		int size = 4 + this.rand.nextInt(8 + lootingLevel * 2);
		GolemBase.addGuaranteedDropEntry(dropList, new ItemStack(Blocks.sand, size, 1));
	}
}
