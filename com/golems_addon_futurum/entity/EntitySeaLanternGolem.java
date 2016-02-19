package com.golems_addon_futurum.entity;

import com.golems.entity.GolemLightProvider;
import com.golems_addon_futurum.main.FuturumGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySeaLanternGolem extends GolemLightProvider
{			
	public EntitySeaLanternGolem(World world) 
	{
		super(world, 4.0F, EnumLightLevel.FULL);
	}
	
	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(FuturumGolems.MODID, "sea_lantern"));
	}

	//THE FOLLOWING USE @Override AND SHOULD BE SET FOR EACH GOLEM

	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.26D);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 1 + this.rand.nextInt(3);
		//return new ItemStack(Blocks.sea_lantern, size);
		return null;
	}
 
	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeGlass.soundName;
	}
}
