package com.golems_addon_futurum.entity;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems_addon_futurum.main.FuturumConfig;
import com.golems_addon_futurum.main.FuturumGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class EntitySlimeGolem extends GolemBase 
{			
	public EntitySlimeGolem(World world) 
	{
		super(world, 2.5F);
		this.tasks.addTask(0, new EntityAISwimming(this));		
		this.getNavigator().setAvoidsWater(false);
	}

	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(FuturumGolems.MODID, "slime"));
	}

	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		if(super.attackEntityAsMob(entity))
		{
			if(FuturumConfig.ALLOW_SLIME_SPECIAL)
			{
				knockbackTarget(entity, FuturumConfig.TWEAK_SLIME);
			}
			return true;
		}
		return false;
	}

	@Override
	protected void damageEntity(DamageSource source, float amount) 
	{
		if (!this.isEntityInvulnerable())
		{
			super.damageEntity(source, amount);
			if(source.getEntity() != null && FuturumConfig.ALLOW_SLIME_SPECIAL)
			{
				knockbackTarget(source.getEntity(), FuturumConfig.TWEAK_SLIME * 3F / 5F);
			}
		}
	}
	
	private void knockbackTarget(Entity entity, final double KNOCKBACK_FACTOR)
	{
		double dX = Math.signum(entity.posX - this.posX) * KNOCKBACK_FACTOR;
		double dZ = Math.signum(entity.posZ - this.posZ) * KNOCKBACK_FACTOR;
		entity.addVelocity(dX, KNOCKBACK_FACTOR / 4, dZ);
		entity.attackEntityFrom(DamageSource.causeMobDamage(this), 0.1F);
	}

	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.29D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		for(int i = 2 + rand.nextInt(3); i > 0; i--)
		{
			int size = 6 + this.rand.nextInt(4);
			GolemBase.addGuaranteedDropEntry(dropList, new ItemStack(Items.slime_ball, size));
		}
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeGrass.soundName;
	}
}
