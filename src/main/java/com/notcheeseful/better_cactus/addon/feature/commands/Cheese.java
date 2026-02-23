package com.notcheeseful.better_cactus.addon.feature.commands;

import com.dwarslooper.cactus.client.feature.command.Command;
import com.dwarslooper.cactus.client.util.game.ChatUtils;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.SharedSuggestionProvider;

public class Cheese extends Command {

	public Cheese() {
		super("Chat");
	}

	@Override
	public void build(LiteralArgumentBuilder<SharedSuggestionProvider> builder) {
		builder.then(argument("name", StringArgumentType.greedyString()).executes(context -> {
			ChatUtils.infoPrefix("Chessy", " " + StringArgumentType.getString(context, "name"));
			return SINGLE_SUCCESS;
		}));
	}

}
