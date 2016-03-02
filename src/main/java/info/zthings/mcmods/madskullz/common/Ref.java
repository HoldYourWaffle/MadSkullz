package info.zthings.mcmods.madskullz.common;

import info.zthings.mcmods.madskullz.blocks.BlockSkull;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class Ref {
	public static final String MODID = "madskullz";
	public static final String VERSION = "BETA-1.1";
	
	public static final String DEBUG_SEPERATOR = "===============================================================";
	
	private static ArrayList<Block> blocks;
	private static ArrayList<Item> items;
	
	public static void init() {
		blocks = new ArrayList<Block>();
		blocks.add(new BlockSkull());
		constructBlocks();
		
		items = new ArrayList<Item>();
		constructItems();
	}
	
	
	private static void constructItems() {
		Iterator<Item> i = getItems().iterator();		
		while (i.hasNext()) {
			Item b = i.next();
			GameRegistry.registerItem(b, b.getUnlocalizedName().substring(5));
		}
	}
	private static void constructBlocks() {
		Iterator<Block> i = getBlocks().iterator();		
		while (i.hasNext()) {
			Block b = i.next();
			GameRegistry.registerBlock(b, b.getUnlocalizedName().substring(5));
		}
	}

	public static ArrayList<Block> getBlocks() {
		return blocks;
	}
	public static ArrayList<Item> getItems() {
		return items;
	}
}
