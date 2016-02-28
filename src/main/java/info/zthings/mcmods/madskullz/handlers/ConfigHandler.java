package info.zthings.mcmods.madskullz.handlers;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	private static Configuration cfg;
	
	public static boolean FLAG_DO_DEBUG_OUTPUT;
	public static int NO_CHOPPER_CHANCE;
	
	public static void init(File cfgFile) {
		Configuration config = new Configuration(cfgFile);
        config.load();

        FLAG_DO_DEBUG_OUTPUT = config.get(Configuration.CATEGORY_GENERAL, "DoDebugOutput", false).getBoolean(false);
        
        Property prop = config.get("Chances", "NoChopChance", 1);
        prop.comment = "Configuration settings for rarity in percentages\r\n\r\n"
        			 + "Chances for dropping a head with a non-chopping tool";
        
        config.save();
	}
}
