package xyz.rgnt.crownedcrates.crates.builder;

import org.bukkit.NamespacedKey;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.crates.CommonCrate;
import xyz.rgnt.crownedcrates.crates.ICrate;
import xyz.rgnt.crownedcrates.rewards.IReward;

import java.util.ArrayList;
import java.util.Arrays;

public class CrateBuilder implements ICrateBuilder {

    private final CommonCrate crate;

    public CrateBuilder(final @NotNull JavaPlugin plugin,
                        final @NotNull NamespacedKey crateIdentifier) {
        this.crate = new CommonCrate(plugin, crateIdentifier, null);
    }

    @Override
    public @NotNull ICrateBuilder withPermission(@NotNull Permission permission) {
        this.crate.setCratePermission(permission);
        return this;
    }

    @Override
    public @NotNull ICrateBuilder withReward(@NotNull IReward reward) {
        this.crate.getRewards().add(reward);
        return this;
    }

    @Override
    public @NotNull ICrateBuilder withReward(@NotNull IReward... rewards) {
        this.crate.getRewards().addAll(Arrays.asList(rewards));
        return this;
    }

    @Override
    public @NotNull ICrate build() {
        return this.crate;
    }
}
