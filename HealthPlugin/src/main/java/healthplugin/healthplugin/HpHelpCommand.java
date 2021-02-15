package healthplugin.healthplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HpHelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("healthplugin.help")) {
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Commands of HealthPlugin: \n"
                        + ChatColor.LIGHT_PURPLE + "/hphelp " + ChatColor.GRAY + "- Shows command list. Usage: /hphelp \n"
                        + ChatColor.LIGHT_PURPLE + "/heal " + ChatColor.GRAY + "- Heals player. Usage: /heal <Player> \n"
                        + ChatColor.LIGHT_PURPLE + "/hpset " + ChatColor.GRAY + "- Set player's hp. Usage: /hpset <hp (min: 1 max: 20)> <Player> \n");
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            }
        } else {
            System.out.println("You cannot run this command through console!");
        }
        return false;
    }
}
