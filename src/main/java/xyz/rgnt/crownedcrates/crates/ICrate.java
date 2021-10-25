package xyz.rgnt.crownedcrates.crates;

import com.google.common.collect.ImmutableList;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.rgnt.crownedcrates.animations.IAnimationController;
import xyz.rgnt.crownedcrates.rewards.IReward;

import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import java.util.function.Consumer;

/**
 * Singular crate.
 */
@ThreadSafe
public interface ICrate {

    /**
     * @return Stylized name
     */
    @NotNull Component getSylizedName();

    /**
     * Opens crate to player. If player won something, award is given.
     *
     * @param player Player instance
     * @param rewardConsumer Consumer applied after reward is given to player.
     */
    void openTo(@NotNull Player player,
                @Nullable Consumer<IReward> rewardConsumer
    );

    @NotNull ImmutableList<IReward> getPossibleRewards();

    /**
     * @return Unique crate identifier
     */
    @NotNull NamespacedKey getIdentifier();

    /**
     * @return Crate permission.
     */
    @Nullable Permission   getPermission();
}
