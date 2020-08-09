package de.tdrstudios.spawn;

import de.tdrstudios.spawn.commands.Pmsg;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Set;

public class SpawnPlugin extends JavaPlugin implements CommandExecutor {

    public static File ConfigFile;
    FileConfiguration config = this.getConfig();
    Location dummyloc;

    @Override
    public void onEnable() {


        System.out.println("[TDRStudios] Spawn Pl wird geladen!");
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        initConfig();
    }

    @Override
    public void onDisable() {


    }

    public void initConfig() {
        config.addDefault("spawnpoint: ", dummyloc);
        this.saveDefaultConfig();

    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        Player p = (Player) sender;
        Location destination = p.getLocation();
        if (cmd.getName().equalsIgnoreCase("setspawn")) {
            if (p.hasPermission("tdrstudios.setspawn")) {

                config.addDefault("spawnpoint", destination);
                config.addDefault("X" , destination.getBlockX());
                config.addDefault("Y" , destination.getBlockY());
                config.addDefault("Z", destination.getBlockZ());
                config.addDefault("world", destination.getWorld());
                config.addDefault("YAW" , destination.getYaw());
                config.addDefault("PICH" , destination.getPitch());

                this.saveConfig();

                Pmsg.send(p, "Set the Spawn to " + destination.getBlockX() + "/" + destination.getBlockZ());


            }

        } else {
            p.sendMessage(Prefix.getNoPerms());
        }
        if(cmd.getName().equalsIgnoreCase("spawn")) {
            if(p.hasPermission("tdrstudios.spawm")) {
               Location spawnpoint;


            }
        }



        return true;

    }
}