package com.notcheeseful.better_cactus.addon;
import com.notcheeseful.better_cactus.addon.feature.commands.Cheese;
import com.notcheeseful.better_cactus.addon.feature.modules.ExampleModule;
import com.dwarslooper.cactus.client.addon.v2.ICactusAddon;
import com.dwarslooper.cactus.client.addon.v2.RegistryBus;
import com.dwarslooper.cactus.client.feature.command.Command;
import com.dwarslooper.cactus.client.feature.module.Category;
import com.dwarslooper.cactus.client.feature.module.Module;

import com.notcheeseful.better_cactus.addon.feature.modules.MyFirstModule;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddonTemplateMain implements ICactusAddon {

	public static final Logger LOGGER = LoggerFactory.getLogger("Cactus Addon Template");

	public static final Category CATEGORY = new Category("exampleCategory", Items.DIAMOND.getDefaultInstance());

	@Override
	public void onInitialize(RegistryBus registryBus) {
		// This is called when the addon is initialized. It provides a RegistryBus
		// which will be used to register new features and content

		LOGGER.info("Hello, Cactus!");

		registryBus.register(Category.class, ctx -> CATEGORY);
		registryBus.register(Module.class, ctx -> new ExampleModule());
		registryBus.register(Command.class, ctx -> new Cheese());
		registryBus.register(Module.class, ctx -> new MyFirstModule());

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