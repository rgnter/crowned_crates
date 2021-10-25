package xyz.rgnt.crownedcrates.crates;

import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.Getter;

import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import xyz.rgnt.crownedcrates.animations.IAnimationController;
import xyz.rgnt.crownedcrates.animations.impl.controllers.CommonAnimationController;
import xyz.rgnt.crownedcrates.rewards.IReward;
import xyz.rgnt.crownedcrates.statics.ThreadStatics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


@Builder
public class CommonCrate
        implements ICrate {

    @Getter
    private final JavaPlugin pluginInstance;

    private final @NotNull NamespacedKey crateIdentifier;

    @Setter
    private @Nullable Permission cratePermission;

    @Getter
    private final List<IReward> rewards
            = new ArrayList<>();

    private final Map<Player, IAnimationController> animations
            = new HashMap<>();


    public CommonCrate(final @NotNull JavaPlugin pluginInstance,
                       @NotNull NamespacedKey crateIdentifier,
                       @Nullable Permission cratePermission) {
        this.pluginInstance = pluginInstance;
        this.crateIdentifier = crateIdentifier;
        this.cratePermission = cratePermission;
    }

    @Override
    public void openTo(@NotNull Player player,
                       @Nullable Consumer<IReward> rewardConsumer) {
        if(!ThreadStatics.isGameThread()) {
            Bukkit.getScheduler().runTask(getPluginInstance(), () -> this.openTo(player, rewardConsumer));
            return;
        }

        // create animation controller
        // award player
    }

    @Override
    public @NotNull ImmutableList<IReward> getPossibleRewards() {
        return ImmutableList.copyOf(this.rewards);
    }

    @Override
    public @NotNull NamespacedKey getIdentifier() {
        return this.crateIdentifier;
    }

    @Override
    public @Nullable Permission getPermission() {
        return this.cratePermission;
    }

}
