package healthplugin.healthplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HpSetCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 2) {
                if (player.hasPermission("healthplugin.hpset")) {
                    int hpAmount;
                    try {
                        hpAmount = Integer.parseInt(args[0]);
                        if (hpAmount >= 1 && hpAmount <= 20) {
                            if (Bukkit.getPlayer(args[1]) != null) {
                                Player target = Bukkit.getPlayer(args[1]);
                                target.setHealth(hpAmount);
                                target.sendMessage(ChatColor.GRAY + "Your health has been set to " + ChatColor.AQUA + hpAmount);
                                player.sendMessage(ChatColor.GREEN + "Succesfully set health to " + ChatColor.AQUA + hpAmount + ChatColor.GREEN + " for player " + ChatColor.AQUA + target.getName());
                            } else {
                                player.sendMessage(ChatColor.RED + "This player is currently offline.");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "Incorrect usage. Hp can't be smaller than 1 or bigger than 20");
                        }
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.RED + "Incorrect usage. Hp must be a number.");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
                }
            } else if (args.length == 1) {
                if (player.hasPermission("healthplugin.hpset")) {
                    int hpAmount;
                    try {
                        hpAmount = Integer.parseInt(args[0]);
                        if (hpAmount >= 1 && hpAmount <= 20) {
                            player.setHealth(hpAmount);
                            player.sendMessage(ChatColor.GREEN + "You successfully set your hp to " + ChatColor.AQUA + hpAmount);
                        } else {
                            player.sendMessage(ChatColor.RED + "Incorrect usage. Hp can't be smaller than 1 or bigger than 20");
                        }
                    } catch (NumberFormatException e) {
                        player.sendMessage(ChatColor.RED + "Incorrect usage. Hp must be a number.");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Incorrect arguments. " + ChatColor.GRAY + "Usage: /hpset <hp (min: 1 max:20)> <Player>");
            }
        } else {
            System.out.println("You cannot this command through console!");
        }
        return false;
    }
}
