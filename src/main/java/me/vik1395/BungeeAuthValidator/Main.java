package me.vik1395.BungeeAuthValidator;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
  public static String host;
  public static String port;
  public static String dbName;
  public static String username;
  public static String pass;
  Tables t;
  
  public void onEnable()
  {
    getServer().getPluginManager().registerEvents(this, this);
    saveDefaultConfig();
    host = getConfig().getString("Host");
    port = getConfig().getString("Port");
    username = getConfig().getString("Username");
    pass = getConfig().getString("Password");
    dbName = getConfig().getString("DBName");
    this.t = new Tables();
    getLogger().info("BungeeAuthValidator has successfully started!");
    getLogger().info("Created by Vik1395");
  }
  
  @EventHandler
  public void onLogin(PlayerLoginEvent ple)
  {
    String name = ple.getPlayer().getName();
    if (this.t.checkPlayerEntry(name))
    {
      String status = this.t.getStatus(name);
      if (status.equalsIgnoreCase("online")) {
        return;
      }
      ple.disallow(PlayerLoginEvent.Result.KICK_OTHER, "You have not authenticated with BungeeAuth!");
    }
    else
    {
      ple.disallow(PlayerLoginEvent.Result.KICK_OTHER, "You have not registered with BungeeAuth!");
    }
  }
}
