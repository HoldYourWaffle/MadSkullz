package info.zthings.mcmods.madskullz.handlers;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	private static Configuration cfg;
	
	public static boolean FLAG_DO_DEBUG_OUTPUT;
	
	public static void init(File cfgFile) {
		Configuration config = new Configuration(cfgFile);
        config.load();

        FLAG_DO_DEBUG_OUTPUT = config.get(Configuration.CATEGORY_GENERAL, "DoDebugOutput", false).getBoolean(false);
        
        config.save();
	}
}
