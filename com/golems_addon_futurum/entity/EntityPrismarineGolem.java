package com.golems_addon_futurum.entity;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems_addon_futurum.main.FuturumGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFishFood;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class EntityPrismarineGolem extends GolemBase 
{			
	public EntityPrismarineGolem(World world) 
	{
		super(world, 8.0F);
	}
	
	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(FuturumGolems.MODID, "prismarine"));
	}
	
	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		if(this.isInWater())
		{
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.50D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24D);
		}
	}
		
	@Override
	protected void applyAttributes() 
	{
	 	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0D);
	  	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24D);
	}
	
	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)	
	{
		GolemBase.addDropEntry(dropList, Items.fish, rand.nextInt(ItemFishFood.FishType.values().length), 1, 8 + lootingLevel * 2, 20 + lootingLevel * 10);
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeStone.soundName;
	}
}
