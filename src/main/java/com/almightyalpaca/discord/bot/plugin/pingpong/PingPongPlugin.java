package com.almightyalpaca.discord.bot.plugin.pingpong;

import com.almightyalpaca.discord.bot.system.command.Command;
import com.almightyalpaca.discord.bot.system.command.CommandHandler;
import com.almightyalpaca.discord.bot.system.events.commands.CommandEvent;
import com.almightyalpaca.discord.bot.system.exception.PluginLoadingException;
import com.almightyalpaca.discord.bot.system.exception.PluginUnloadingException;
import com.almightyalpaca.discord.bot.system.plugins.Plugin;
import com.almightyalpaca.discord.bot.system.plugins.PluginInfo;

public class PingPongPlugin extends Plugin {
	class PingCommand extends Command {

		public PingCommand() {
			super("ping", "Ping!", "");
		}

		@CommandHandler(dm = true, guild = true, async = true)
		public void onCommand(final CommandEvent event) {
			event.sendMessage("Pong!");
		}
	}

	class PongCommand extends Command {

		public PongCommand() {
			super("pong", "Pong!", "pong");
		}

		@CommandHandler(dm = true, guild = true)
		public void onCommand(final CommandEvent event) {
			event.sendMessage("Ping!");
		}

	}

	private static final PluginInfo INFO = new PluginInfo("com.almightyalpaca.discord.bot.plugin.pingpong", "1.0.0", "Almighty Alpaca", "Ping Pong Plugin", "Ping Pong!");

	public PingPongPlugin() {
		super(PingPongPlugin.INFO);
	}

	@Override
	public void load() throws PluginLoadingException {
		this.registerCommand(new PingCommand());
		this.registerCommand(new PongCommand());
	}

	@Override
	public void unload() throws PluginUnloadingException {}

}
