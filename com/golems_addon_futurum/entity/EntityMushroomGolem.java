package com.golems_addon_futurum.entity;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems.entity.GolemMultiTextured;
import com.golems_addon_futurum.main.FuturumConfig;
import com.golems_addon_futurum.main.FuturumGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class EntityMushroomGolem extends GolemMultiTextured
{			
	private static final String[] shroomTypes = {"red","brown"};

	public EntityMushroomGolem(World world) 
	{
		super(world, 3.0F, Blocks.red_mushroom_block, shroomTypes);
		this.tasks.addTask(0, new EntityAISwimming(this));
	}	
	
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		if(FuturumConfig.ALLOW_MUSHROOM_SPECIAL)
		{
			int x = MathHelper.floor_double(this.posX);
			int y = MathHelper.floor_double(this.posY - 0.20000000298023224D - (double)this.getYOffset());
			int z = MathHelper.floor_double(this.posZ);
			Block blockBelow = this.worldObj.getBlock(x, y, z);

			if(this.worldObj.isAirBlock(x, y + 1, z) && (blockBelow == Blocks.grass  || blockBelow == Blocks.mycelium || blockBelow == Blocks.dirt))
			{
				final int PLANT_CHANCE = FuturumConfig.TWEAK_MUSHROOM;
				if(rand.nextInt(PLANT_CHANCE) == 0)
				{
					setToShroom(this.worldObj, x, y + 1, z);
				}
			}
		}
	}

	private void setToShroom(World world, int x, int y, int z)
	{
		Block toSet = rand.nextBoolean() ? Blocks.brown_mushroom : Blocks.red_mushroom;
		world.setBlock(x, y, z, toSet);	
	}

	@Override
	public String getTexturePrefix() 
	{
		return "shroom";
	}
	
	@Override
	public String getModId() 
	{
		return FuturumGolems.MODID;
	}

	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)	
	{
		int size = 4 + this.rand.nextInt(6 + lootingLevel * 2);
		Block shroom = rand.nextBoolean() ? Blocks.red_mushroom : Blocks.brown_mushroom;
		GolemBase.addGuaranteedDropEntry(dropList, new ItemStack(shroom, size));
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeGrass.soundName;
	}
}
