package rendering;

import info.zthings.mcmods.madskullz.common.Ref;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class BlockRenderRegister {

	public static void registerBlockRenderer() {
		Iterator<Block> i = Ref.getBlocks().iterator();
		
		while (i.hasNext()) {
			reg((Block)i.next());
		}
	}

	public static void reg(Block block) {
		System.err.println("Calling Block.reg("+block.getUnlocalizedName()+")");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Ref.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}

}
