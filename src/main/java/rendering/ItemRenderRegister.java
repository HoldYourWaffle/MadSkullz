package rendering;

import java.util.Iterator;

import info.zthings.mcmods.madskullz.common.Ref;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister {

	public static void registerItemRenderer() {
		Iterator<Item> i = Ref.getItems().iterator();
		
		while (i.hasNext()) {
			reg((Item)i.next());
		}
	}

	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Ref.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
