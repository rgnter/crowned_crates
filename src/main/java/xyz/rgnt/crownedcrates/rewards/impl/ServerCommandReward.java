package xyz.rgnt.crownedcrates.rewards.impl;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.rewards.CommonReward;

/**
 * Reward executes server side command
 */
public class ServerCommandReward extends CommonReward {

    public ServerCommandReward(@NotNull JavaPlugin pluginInstance) {
        super(pluginInstance, new NamespacedKey(pluginInstance, "server_command_reward"), null);
    }
}
