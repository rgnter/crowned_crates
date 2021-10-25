package xyz.rgnt.crownedcrates.rewards.impl;

import org.bukkit.NamespacedKey;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.rgnt.crownedcrates.rewards.CommonReward;

/**
 * Reward executes client side command
 */
public class ClientCommandReward extends CommonReward {

    public ClientCommandReward(@NotNull JavaPlugin pluginInstance) {
        super(pluginInstance, new NamespacedKey(pluginInstance, "client_command_reward"), null);
    }
}
