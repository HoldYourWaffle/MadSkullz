package info.zthings.mcmods.madskullz.handlers;

import info.zthings.mcmods.madskullz.common.Ref;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MadEventHandler {
	@SubscribeEvent
	public void onMobDead(LivingDropsEvent ev) {
		if (ConfigHandler.FLAG_DO_DEBUG_OUTPUT) {
			System.out.println("===============================================================");
			System.out.println("DamageType: " + ev.source.damageType);
			System.out.println("Source: " + ev.source.getSourceOfDamage());
			System.out.println("Source player_inventory[0]: " + ev.source.getSourceOfDamage().getInventory()[0]);
			System.out.println("Source weapon: " + ((EntityPlayer)ev.source.getEntity()).getCurrentEquippedItem().getItem().getUnlocalizedName() );
			System.out.println("===============================================================");
		}
	}
}
