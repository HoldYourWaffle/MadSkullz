package info.zthings.mcmods.madskullz.handlers;

import info.zthings.mcmods.madskullz.common.Ref;
import info.zthings.mcmods.madskullz.util.UtilMethods;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MadEventHandler {
	@SubscribeEvent
	public void onMobDeath(LivingDropsEvent ev) {
		if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) {
			System.out.println();
			System.out.println(Ref.DEBUG_SEPERATOR);
			System.out.println("DamageType: " + ev.source.damageType);
			System.out.println("Source: " + ev.source.getSourceOfDamage());
			if (ev.source.getEntity() != null) {
				System.out.println("Source entity: " + ev.source.getEntity().getName());
			}
			System.out.println();
		}
		
		DamageSource s = ev.source;
		if (s.getEntity() == null && ConfigHandler.FLAG_DO_DEBUG_OUTPUT) {
			System.out.println(ev.entity.getName() + " was killed by something other than an entity (by "+s.getDamageType()+"), abort event handling");
			System.out.println(Ref.DEBUG_SEPERATOR); //close seperator
			return;
		}
		
		if (s.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)s.getEntity();
			
			if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT && player.getCurrentEquippedItem() != null) System.out.println(ev.entity.getName() + " was killed by player with "+player.getCurrentEquippedItem().getDisplayName());
			else if (player.getCurrentEquippedItem() == null) System.out.println(ev.entity.getName() + " was killed by player with bare hands");
			
			double r = Math.random() * 100; //*100 cause percentages
			int chopChance = UtilMethods.getChopChance(player.getCurrentEquippedItem());
			
			if (r < chopChance) {
				//CHOP!!!
				if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) {
					System.out.println("Head is chopped! (rand="+String.valueOf(r)+"; chance="+String.valueOf(chopChance)+")");
					System.out.println("Dropping head of entity: "+ev.entity.getName());
				}
				ev.entityLiving.entityDropItem(UtilMethods.getHead(ev.entity), 1); //TODO: maybe use y-offset to really drop it from the head?
			} else {
				//NO CHOP :(
				if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) System.out.println("Head wasn't chopped :( (rand="+String.valueOf(r)+"; chance="+String.valueOf(chopChance)+")");
			}
		} else {
			if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) System.out.println(ev.entity.getName() + " was killed by an other entity than player (by "+s.getEntity().getName()+")");
		}
		
		if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) System.out.println(Ref.DEBUG_SEPERATOR);
	}
	
	//TODO: cancel placing against other blocks?
}
