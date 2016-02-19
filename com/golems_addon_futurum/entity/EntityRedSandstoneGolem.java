package com.golems_addon_futurum.entity;

import com.golems.entity.EntitySandstoneGolem;
import com.golems_addon_futurum.main.FuturumGolems;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityRedSandstoneGolem extends EntitySandstoneGolem
{			
	public EntityRedSandstoneGolem(World world) 
	{
		super(world);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(FuturumGolems.MODID, "red_sandstone"));
	}

	//THE FOLLOWING USE @Override AND SHOULD BE SET FOR EACH GOLEM

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 4 + this.rand.nextInt(8);
		return new ItemStack(Item.getItemFromBlock(Blocks.sand), size, 1);
	}
}
