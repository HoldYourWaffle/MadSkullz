package util;

import info.zthings.mcmods.madskullz.handlers.ConfigHandler;
import net.minecraft.item.ItemStack;

public abstract class UtilMethods {
	public static int getChopChance(ItemStack cei) {
		if (cei == null || !isChopper(cei)) return ConfigHandler.NO_CHOPPER_CHANCE; //no chance (you can't chop someone's head with your fist...
		else return 1;
	}
	
	public static boolean isChopper(ItemStack item) {
		return false;
	}
}
