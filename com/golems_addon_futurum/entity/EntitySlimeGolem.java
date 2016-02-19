package com.golems_addon_futurum.entity;

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
	protected void entityInit()
	{
		super.entityInit();
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
				knockbackTarget(source.getEntity(), FuturumConfig.TWEAK_SLIME * 3 / 5);
			}
		}
	}
	
	private void knockbackTarget(Entity entity, final double KNOCKBACK_FACTOR)
	{
		// debug:
		//System.out.println("applying knockback: vX=" + entity.motionX + "; vY=" + entity.motionY + "; vZ=" + entity.motionZ);
		double dX = (entity.posX - this.posX) * KNOCKBACK_FACTOR;
		double dZ = (entity.posZ - this.posZ) * KNOCKBACK_FACTOR;
		entity.addVelocity(dX, KNOCKBACK_FACTOR / 4, dZ);
		entity.attackEntityFrom(DamageSource.causeMobDamage(this), 0.1F);
		// debug:
		//System.out.println("finished knockback: vX=" + entity.motionX + "; vY=" + entity.motionY + "; vZ=" + entity.motionZ);
	}

	//THE FOLLOWING USE @Override AND SHOULD BE SET FOR EACH GOLEM

	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(85.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.29D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.5D);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 11 + this.rand.nextInt(16);
		return new ItemStack(Items.slime_ball, size);
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeGrass.soundName;
	}
}
