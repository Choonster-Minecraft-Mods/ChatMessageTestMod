package com.choonster.chatmessagetestmod;

import com.choonster.chatmessagetestmod.events.NetworkEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ChatMessageTestMod.MODID, name = "Chat Message Test Mod", clientSideOnly = true)
public class ChatMessageTestMod {
	public static final String MODID = "chatmessagetestmod";

	@Mod.Instance(MODID)
	public static ChatMessageTestMod INSTANCE;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Logger.setLogger(event.getModLog());
		MinecraftForge.EVENT_BUS.register(NetworkEventHandler.INSTANCE);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
