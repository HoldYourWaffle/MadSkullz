package info.zthings.mcmods.madskullz.handlers;

import util.UtilMethods;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MadEventHandler {
	@SubscribeEvent
	public void onMobDeath(LivingDropsEvent ev) {
		if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) {
			System.out.println("===============================================================");
			System.out.println("DamageType: " + ev.source.damageType);
			System.out.println("Source: " + ev.source.getSourceOfDamage());
			if (ev.source.getEntity() instanceof EntityPlayer) {
				System.out.println("Source weapon: " + ((EntityPlayer)ev.source.getEntity()).getCurrentEquippedItem().getItem().getUnlocalizedName() );
			}
			System.out.println("Source entity: " + ev.source.getEntity().getName());
			System.out.println("===============================================================");
		}
		
		DamageSource s = ev.source;
		
		if (s.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)s.getEntity();
			
			if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT && player.getCurrentEquippedItem() != null) System.out.println("Mob was killed by player with "+player.getCurrentEquippedItem().getDisplayName());
			else if (player.getCurrentEquippedItem() == null) System.out.println("Mob was killed by player with bare hands");
			
			double r = Math.random();
			int chopChance = UtilMethods.getChopChance(player.getCurrentEquippedItem());
			
			if (r < chopChance) {
				//CHOP!!!
				if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) System.out.println("Head is chopped! (rand="+String.valueOf(r)+"; chance="+String.valueOf(chopChance)+")");
			} else {
				//NO CHOP :(
				if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) System.out.println("Head wasn't chopped :( (rand="+String.valueOf(r)+"; chance="+String.valueOf(chopChance)+")");
			}
		} else {
			if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) System.out.println("Mob was killed by an other entity than player ("+s.getEntity().getName()+")" );
		}
	}
}
