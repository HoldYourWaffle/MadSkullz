package util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import info.zthings.mcmods.madskullz.handlers.ConfigHandler;
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

	public static ItemStack getHead(String name) {
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("SkullOwner", "Herobrine");
		ItemStack stack = new ItemStack(Items.skull, 1, 3);
		stack.setTagCompound(nbt);
		return stack;
	}
}
