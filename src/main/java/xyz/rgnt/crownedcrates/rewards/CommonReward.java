package xyz.rgnt.crownedcrates.rewards;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.rgnt.crownedcrates.animations.IAnimationController;
import xyz.rgnt.crownedcrates.statics.ThreadStatics;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Builder
public class CommonReward implements IReward {

    @Getter
    private final JavaPlugin pluginInstance;

    private final @NotNull NamespacedKey rewardIdentifier;
    private final @Nullable Permission rewardPermission;

    private final Map<Player, IAnimationController> animations
            = new HashMap<>();

    public CommonReward(final @NotNull JavaPlugin pluginInstance,
                        @NotNull NamespacedKey identifier,
                        @Nullable Permission permission) {
        this.pluginInstance = pluginInstance;
        this.rewardIdentifier = identifier;
        this.rewardPermission = permission;
    }

    @Override
    public void rewardTo(@NotNull Player player, @Nullable Consumer<IReward> rewardConsumer) {
        if(!ThreadStatics.isGameThread()) {
            Bukkit.getScheduler().runTask(getPluginInstance(), () -> this.rewardTo(player, rewardConsumer));
            return;
        }
        // reward player
    }

    @Override
    public @NotNull NamespacedKey getIdentifier() {
        return this.rewardIdentifier;
    }

    @Override
    public @Nullable Permission getPermission() {
        return this.rewardPermission;
    }
}
