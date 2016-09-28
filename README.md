BungeeAuthValidator is a simple **bukkit plugin** that checks if a player joining the server has already authenticated with BungeeAuth. It should be placed in all servers connected to the bungee network, except for Authlobby. All you need to do is enter BungeeAuth's MySQL Database information and the plugin will take care of the rest. This is a very useful plugin as it prevents users from accessing your servers through a different BungeeCord network, thus being able to log in without authenticating. This plugin is not a must, but I highly recommend it to servers with a high potential of facing angry users or hackers ![:)](https://www.spigotmc.org/styles/default/xenforo/clear.png)

Check out BungeeAuth [here](https://www.spigotmc.org/resources/bungeeauth.493/)

Please report any issues with this plugin [HERE](https://github.com/vik1395/BungeeAuthValidator-Minecraft/issues)

If you like my work, please consider donating, I would greatly appreciate it. [![Image](https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=vik1395lp%40gmail%2ecom&lc=US&item_name=Spigot%20Plugins&item_number=LegitPlay%2enet%20Plugin%20Dev&no_note=0&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHostedGuest)

**Config**
-------------
    # BungeeAuthValidator Config File.
    
    # Please enter the details for BungeeAuth's database.
    
    Host: 127.0.0.1
    
    # Please enter the Host of your MySQL Database here.
    
    Port: '3306'
    
    # Please enter the port where your MySQL Database is hosted.
    
    Username: root
    
    # The Username which should be used to auth against the Database.
    
    Password: 'pass'
    
    # The Password which should be used to auth against the Database. If you don't have a password, please leave two quotation marks (') in this field.
    
    DBName: Bungee
    
    #The name of the database where BungeeAuth's Tables shall be created.

This plugin is licensed under [CC Attribution-NonCommercial-ShareAlike 4.0 International](http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en_US).

In very basic terms, Do whatever you want with the code of this plugin, as long as you give credits to the author and/or the plugin itself.
