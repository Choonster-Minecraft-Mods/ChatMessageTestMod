package com.choonster.chatmessagetestmod.events;

import com.choonster.chatmessagetestmod.Logger;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Handler for {@link EntityEvent} subclasses.
 *
 * @author Choonster
 */
public class EntityEventHandler {
	public static final EntityEventHandler INSTANCE = new EntityEventHandler();

	@SubscribeEvent
	public void entityJoinWorld(EntityJoinWorldEvent event) {
		if (event.getEntity() instanceof EntityPlayerSP) {
			Logger.info("Client player joined world. Unregistering EntityEventHandler.");

			final EntityPlayerSP player = (EntityPlayerSP) event.getEntity();
			player.sendChatMessage("/say This is a /say command!");
			player.sendChatMessage("Hello from the client!");

			MinecraftForge.EVENT_BUS.unregister(this);
		}
	}
}
