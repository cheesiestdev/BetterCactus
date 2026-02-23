package com.notcheeseful.better_cactus.addon.feature.modules;

import com.notcheeseful.better_cactus.addon.AddonTemplateMain;
import com.dwarslooper.cactus.client.event.EventHandler;
import com.dwarslooper.cactus.client.event.impl.ClientTickEvent;
import com.dwarslooper.cactus.client.feature.module.Module;
import com.dwarslooper.cactus.client.systems.config.settings.group.SettingGroup;
import com.dwarslooper.cactus.client.systems.config.settings.impl.BooleanSetting;
import com.dwarslooper.cactus.client.systems.config.settings.impl.Setting;
import com.dwarslooper.cactus.client.util.game.ChatUtils;

public class Greeter extends Module {

	// This is a boolean setting, added to an example group.
	// You can use the existing mainGroup to add a setting to the main group.

	private final SettingGroup exampleGroup = settings.buildGroup("sad");
	public final Setting<Boolean> sendGreetings = exampleGroup.add(new BooleanSetting("sendGreetings", true));

	public Greeter() {
		super("Greeter", AddonTemplateMain.CHEESE_CATEGORY, new Options());
	}

	@Override
	public void onEnable() {
		// This will get called when the module is enabled

		if(sendGreetings.get()) {
			ChatUtils.infoPrefix("Chessy", "Hello, Player!");
		}
	}

	@Override
	public void onDisable() {
		// This will get called when the module is disabled

		if(sendGreetings.get()) {
			ChatUtils.infoPrefix("Example Module", "See ya later, Example Module");
		}
	}

	@EventHandler
	public void onTick(ClientTickEvent event) {
		// This EventHandler is listening to the ClientTickEvent,
		// which gets called every time the client finishes a game tick
	}

}
