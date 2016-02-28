package info.zthings.mcmods.madskullz.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import util.UtilMethods;

public class MadEventHandler {
	@SubscribeEvent
	public void onMobDeath(LivingDropsEvent ev) {
		if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) {
			System.out.println();
			System.out.println(UtilMethods.DEBUG_SEPERATOR);
			System.out.println("DamageType: " + ev.source.damageType);
			System.out.println("Source: " + ev.source.getSourceOfDamage());
			if (ev.source.getEntity() instanceof EntityPlayer) {
				System.out.println("Source weapon: " + ((EntityPlayer)ev.source.getEntity()).getCurrentEquippedItem().getItem().getUnlocalizedName() );
			}
			if (ev.source.getEntity() != null) {
				System.out.println("Source entity: " + ev.source.getEntity().getName());
			}
		}
		
		DamageSource s = ev.source;
		if (s.getEntity() == null && ConfigHandler.FLAG_DO_DEBUG_OUTPUT) {
			System.out.println("Mob was killed by something other than an entity (by "+s.getDamageType()+"), abort event handling");
			System.out.println(UtilMethods.DEBUG_SEPERATOR); //close seperator
			return;
		}
		
		if (s.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)s.getEntity();
			
			if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT && player.getCurrentEquippedItem() != null) System.out.println("Mob was killed by player with "+player.getCurrentEquippedItem().getDisplayName());
			else if (player.getCurrentEquippedItem() == null) System.out.println("Mob was killed by player with bare hands");
			
			double r = Math.random() * 100; //*100 cause percentages
			int chopChance = UtilMethods.getChopChance(player.getCurrentEquippedItem());
			
			if (r < chopChance) {
				//CHOP!!!
				if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) {
					System.out.println("Head is chopped! (rand="+String.valueOf(r)+"; chance="+String.valueOf(chopChance)+")");
					System.out.println("Dropping head of entity: "+ev.entity.getName());
				}
			} else {
				//NO CHOP :(
				if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) System.out.println("Head wasn't chopped :( (rand="+String.valueOf(r)+"; chance="+String.valueOf(chopChance)+")");
			}
		} else {
			if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) System.out.println("Mob was killed by an other entity than player (by "+s.getEntity().getName()+")");
		}
		
		if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) System.out.println(UtilMethods.DEBUG_SEPERATOR);
	}
}
