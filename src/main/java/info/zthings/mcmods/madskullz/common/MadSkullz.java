package info.zthings.mcmods.madskullz.common;

import info.zthings.mcmods.madskullz.blocks.TileEntitySkull;
import info.zthings.mcmods.madskullz.handlers.ConfigHandler;
import info.zthings.mcmods.madskullz.handlers.MadEventHandler;
import info.zthings.mcmods.madskullz.proxies.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Ref.MODID, version = Ref.VERSION, name = "MadSkullz")
public class MadSkullz {
	public static MadEventHandler evHandler = new MadEventHandler();
	
	@SidedProxy(clientSide="info.zthings.mcmods.madskullz.proxies.ClientProxy", serverSide="info.zthings.mcmods.madskullz.proxies.ServerProxy")
	public static CommonProxy proxy;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent ev) {
    	MinecraftForge.EVENT_BUS.register(evHandler);
    	
    	ConfigHandler.init(ev.getSuggestedConfigurationFile());
    	
    	GameRegistry.registerBlock(Ref.blockSkull, Ref.blockSkull.getUnlocalizedName().substring(5));
    	GameRegistry.registerTileEntity(TileEntitySkull.class, Ref.MODID + ":skull_tile_entity");
    	
    	proxy.preInit(ev);
    }
    
    @EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}