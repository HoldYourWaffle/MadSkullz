package util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import info.zthings.mcmods.madskullz.handlers.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTSizeTracker;
import net.minecraft.nbt.NBTTagCompound;

public abstract class UtilMethods {
	public static int getChopChance(ItemStack cei) {
		if (cei == null || !isChopper(cei)) return ConfigHandler.INT_NO_CHOPPER_CHANCE; //no chance (you can't chop someone's head with your fist...
		else return 1;
	}
	
	public static boolean isChopper(ItemStack item) {
		return false;
	}

	public static ItemStack getHead(Entity entity) {
		ItemStack stack;
		
		//Setup & return skull-itemstack
		if (entity instanceof EntitySkeleton || entity instanceof EntityZombie || entity instanceof EntityPlayer || entity instanceof EntityCreeper) { //ingame-skulls (or player skulls that don't have to be looked up in register)
			if (entity instanceof EntitySkeleton) { //normal or wither skeleton
				if (((EntitySkeleton)entity).getSkeletonType() == 1) stack = new ItemStack(Items.skull, 1, 1); //if wither skeleton drop that skull
				else stack = new ItemStack(Items.skull, 1, 0); //for all other values drop standard-skeleton-skull
			} else if (entity instanceof EntityZombie) {
				stack = new ItemStack(Items.skull, 1, 2);
			} else if (entity instanceof EntityCreeper) {
				stack = new ItemStack(Items.skull, 1, 4);
			} else { //must be player
				NBTTagCompound nbt = new NBTTagCompound();
				stack = new ItemStack(Items.skull, 1, 3);
				nbt.setString("SkullOwner", ((EntityPlayer)entity).getDisplayNameString());
				stack.setTagCompound(nbt);
			}
		} else { //no ingame-skull --> look user up in register
			NBTTagCompound nbt = new NBTTagCompound();
			stack = new ItemStack(Items.skull, 1, 3);
			//nbt.setString("SkullOwner", sko);
			stack.setTagCompound(nbt);
		}
		return stack;
	}
}
