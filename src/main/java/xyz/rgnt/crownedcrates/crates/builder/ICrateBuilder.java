package xyz.rgnt.crownedcrates.crates.builder;

import org.bukkit.NamespacedKey;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.crates.ICrate;
import xyz.rgnt.crownedcrates.rewards.IReward;

public interface ICrateBuilder {

    /**
     * Sets crate permission
     * @param permission Permission
     * @return Builder
     */
    @NotNull ICrateBuilder withPermission(@NotNull Permission permission);

    /**
     * Adds possible reward to crate.
     * @param reward Reward instance
     * @return Builder
     */
    @NotNull ICrateBuilder withReward(@NotNull IReward reward);

    /**
     * Adds possible rewards to crate.
     * @param rewards Varargs of reward instances
     * @return Builder
     */
    @NotNull ICrateBuilder withReward(@NotNull IReward ... rewards);


    /**
     * @return Crate
     */
    @NotNull ICrate build();

    /**
     * @param plugin Plugin instance
     * @param crateIdentifier Crate identifier
     * @return Crate builder
     */
    static @NotNull ICrateBuilder builder(final @NotNull JavaPlugin plugin,
                                          final @NotNull NamespacedKey crateIdentifier) {
        return new CrateBuilder(plugin, crateIdentifier);
    }

}
