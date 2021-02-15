package healthplugin.healthplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("healthplugin.hpset")) {
                if (args.length == 1 ) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[0]);
                        target.setHealth(20.0);
                        target.sendMessage(ChatColor.GREEN + "You have been healed!");
                        player.sendMessage(ChatColor.GREEN + "Succesfully healed " + ChatColor.AQUA + target.getName());
                    } else {
                        player.sendMessage(ChatColor.RED + "This player is currently not offline.");
                    }
                } else if (args.length == 0){
                    player.setHealth(20.0);
                    player.sendMessage(ChatColor.GREEN + "You successfully healed yourself!");
                } else {
                    player.sendMessage(ChatColor.RED + "Incorrect usage. Try: /heal <Player>");
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
