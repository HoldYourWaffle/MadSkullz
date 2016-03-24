package info.zthings.mcmods.madskullz.proxies;

import info.zthings.mcmods.madskullz.common.MadSkullz;
import info.zthings.mcmods.madskullz.common.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		ModelBakery.addVariantName(Item.getItemFromBlock(MadSkullz.skullBlock), "madskullz:block_properties_black", "madskullz:block_properties_white");
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MadSkullz.skullBlock), 0, new ModelResourceLocation(Ref.MODID + ":" + MadSkullz.skullBlock.getUnlocalizedName().substring(5), "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MadSkullz.skullBlock), 0, new ModelResourceLocation(Ref.MODID + ":block_properties_white", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(MadSkullz.skullBlock), 1, new ModelResourceLocation(Ref.MODID + ":block_properties_black", "inventory"));
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}

}
