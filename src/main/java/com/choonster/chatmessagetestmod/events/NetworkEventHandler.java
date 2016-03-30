package com.choonster.chatmessagetestmod.events;

import com.choonster.chatmessagetestmod.Logger;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

/**
 * Handler for {@link FMLNetworkEvent} subclasses.
 * <p>
 * WARNING: These events are fired on a Netty thread rather than the main client/server thread, so the handler methods must not directly interact with normal Minecraft classes.
 * <p>
 * Use {@link IThreadListener#addScheduledTask} to run a task on the main thread where you can safely interact with normal Minecraft classes.
 *
 * @author Choonster
 */
public class NetworkEventHandler {

	public static final NetworkEventHandler INSTANCE = new NetworkEventHandler();

	@SubscribeEvent
	public void clientConnectedToServer(FMLNetworkEvent.ClientConnectedToServerEvent event) {
		Minecraft.getMinecraft().addScheduledTask(() -> {
			Logger.info("Connected to server. Registering EntityEventHandler.");
			MinecraftForge.EVENT_BUS.register(EntityEventHandler.INSTANCE);
		});
	}
}
