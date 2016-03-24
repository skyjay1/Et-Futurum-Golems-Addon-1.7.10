package com.golems_addon_futurum.entity;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems.entity.GolemLightProvider;
import com.golems_addon_futurum.main.FuturumGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFishFood;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class EntitySeaLanternGolem extends GolemLightProvider
{			
	public EntitySeaLanternGolem(World world) 
	{
		super(world, 4.0F, EnumLightLevel.FULL);
	}
	
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(FuturumGolems.MODID, "sea_lantern"));
	}

	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.26D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		GolemBase.addDropEntry(dropList, Items.fish, rand.nextInt(ItemFishFood.FishType.values().length), 1, 8 + lootingLevel * 2, 20 + lootingLevel * 10);
	}
 
	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeGlass.soundName;
	}
}
