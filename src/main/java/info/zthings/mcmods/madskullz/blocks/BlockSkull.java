package info.zthings.mcmods.madskullz.blocks;

import info.zthings.mcmods.madskullz.common.SkullTypes;
import info.zthings.mcmods.madskullz.common.blockstatestuff.IMetaBlockName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockSkull extends Block implements IMetaBlockName {
	public static final PropertyEnum TYPE = PropertyEnum.create("type", SkullTypes.class);

	public BlockSkull() {
		super(Material.circuits);
		this.setUnlocalizedName("skull");
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, SkullTypes.WHITE));
	}
	
	@Override
	public boolean isFullCube() {
		return false;
	}
	
	@Override
	public boolean isFullBlock() {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	protected BlockState createBlockState() {
	    return new BlockState(this, new IProperty[] { TYPE });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return getDefaultState().withProperty(TYPE, meta == 0 ? SkullTypes.WHITE : SkullTypes.BLACK);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
	    SkullTypes type = (SkullTypes) state.getValue(TYPE);
	    return type.getID();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
	    return getMetaFromState(state);
	}
	
	@Override
	public String getSpecialName(ItemStack stack) {
	    return stack.getItemDamage() == 0 ? "white" : "black";
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
	    return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
	
	/* FUTURE
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
	    list.add(new ItemStack(itemIn, 1, 0)); //Meta 0
	    list.add(new ItemStack(itemIn, 1, 1)); //Meta 1
	}*/
}
