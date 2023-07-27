package com.soykeki;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();

        getCommand("store").setExecutor(this);
        getCommand("discord").setExecutor(this);
        getCommand("website").setExecutor(this);
        getCommand("ts").setExecutor(this);

        getLogger().info("Plugin TuPlugin habilitado!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin TuPlugin deshabilitado!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String cmd = command.getName().toLowerCase();

        if (config.contains(cmd)) {
            String link = config.getString(cmd);
            sender.sendMessage("Visita " + link);
            return true;
        } else {
            sender.sendMessage("El comando no está configurado.");
            return false;
        }
    }
}
