package com.notcheeseful.better_cactus.addon;
import com.notcheeseful.better_cactus.addon.feature.commands.Cheese;
import com.notcheeseful.better_cactus.addon.feature.modules.Greeter;
import com.dwarslooper.cactus.client.addon.v2.ICactusAddon;
import com.dwarslooper.cactus.client.addon.v2.RegistryBus;
import com.dwarslooper.cactus.client.feature.command.Command;
import com.dwarslooper.cactus.client.feature.module.Category;
import com.dwarslooper.cactus.client.feature.module.Module;

import com.notcheeseful.better_cactus.addon.feature.modules.FastPlace;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddonTemplateMain implements ICactusAddon {

	public static final Logger LOGGER = LoggerFactory.getLogger("Cactus Addon Template");

	public static final Category CHEESE_CATEGORY = new Category("Cheese", Items.SPONGE.getDefaultInstance());


	@Override
	public void onInitialize(RegistryBus registryBus) {
		// This is called when the addon is initialized. It provides a RegistryBus
		// which will be used to register new features and content

		LOGGER.info("Hello, Cactus!");

		registryBus.register(Category.class, (list, ctx) -> list.add(CHEESE_CATEGORY));
		registryBus.register(Module.class, ctx -> new FastPlace(CHEESE_CATEGORY));
		registryBus.register(Category.class, ctx -> CHEESE_CATEGORY);
		registryBus.register(Module.class, ctx -> new Greeter());
		registryBus.register(Command.class, ctx -> new Cheese());



		LOGGER.info("Template Addon successfully loaded!");
	}

	@Override
	public void onLoadComplete() {
		// This is called when Cactus is fully done initializing
		// This does not mean the game has completely loaded yet
	}

	@Override
	public void onShutdown() {
		// This is called when the client is shutting down
	}
}