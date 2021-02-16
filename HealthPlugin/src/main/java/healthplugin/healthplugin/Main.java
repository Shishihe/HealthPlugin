package healthplugin.healthplugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("HealthPlugin enabled!");

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("hpset").setExecutor(new HpSetCommand());
        getCommand("hphelp").setExecutor(new HpHelpCommand());
        getCommand("feed").setExecutor(new FeedCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("Health plugin disabled!");
    }
}
