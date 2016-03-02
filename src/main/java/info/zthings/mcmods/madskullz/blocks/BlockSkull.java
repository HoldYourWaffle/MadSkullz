package info.zthings.mcmods.madskullz.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSkull extends Block {

	public BlockSkull() {
		super(Material.circuits);
		this.setUnlocalizedName("skull");
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
		/*this.setHardness(hardness);
		this.setResistance(resistance);*/
	}
}
