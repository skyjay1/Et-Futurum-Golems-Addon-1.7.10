package com.golems_addon_futurum.entity;

import com.golems.entity.GolemBase;
import com.golems_addon_futurum.main.FuturumGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityPrismarineGolem extends GolemBase 
{			
	public EntityPrismarineGolem(World world) 
	{
		super(world, 8.0F);
	}
	
	@Override
	protected void entityInit()
	{
		super.entityInit();
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
	
	//THE FOLLOWING USE @Override AND SHOULD BE SET FOR EACH GOLEM
	
	@Override
	protected void applyEntityAttributes() 
	{
	 	super.applyEntityAttributes();
	 	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0D);
	  	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24D);
	}
	
	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 6 + this.rand.nextInt(6);
		//return new ItemStack(Items.prismarine_shard, size);
		return null;
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeStone.soundName;
	}
}
