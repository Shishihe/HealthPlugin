package healthplugin.healthplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("healthplugin.feed")) {
                if (args.length == 1) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[0]);
                        target.setFoodLevel(20);
                        target.sendMessage(ChatColor.GREEN + "You have been fed!");
                        player.sendMessage(ChatColor.GREEN + "Successfully fed: " + ChatColor.AQUA + target.getName());
                    } else {
                        player.sendMessage(ChatColor.RED + "This player is currently offline.");
                    }
                } else if (args.length == 0) {
                    player.setFoodLevel(20);
                    player.sendMessage(ChatColor.GREEN + "You successfully fed yourself!");
                } else {
                    player.sendMessage(ChatColor.RED + "Incorrect usage. Try: /feed <Player>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            }
        } else {
            System.out.println("You cannot use this command through console!");
        }
        return false;
    }
}
