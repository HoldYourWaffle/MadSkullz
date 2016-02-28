package info.zthings.mcmods.madskullz.common;

import info.zthings.mcmods.madskullz.handlers.ConfigHandler;
import info.zthings.mcmods.madskullz.handlers.MadEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Ref.MODID, version = Ref.VERSION)
public class MadSkullz {
	public static MadEventHandler evHandler = new MadEventHandler();
		
    @EventHandler
    public void preInit(FMLPreInitializationEvent ev) {
    	MinecraftForge.EVENT_BUS.register(evHandler);
    	
    	ConfigHandler.init(ev.getSuggestedConfigurationFile());
    	Ref.init();
    }

}