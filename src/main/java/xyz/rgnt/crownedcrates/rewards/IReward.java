package xyz.rgnt.crownedcrates.rewards;


import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import java.util.function.Consumer;

/**
 * Singular reward.
 */
@ThreadSafe
public interface IReward {

    /**
     * @return Stylized name
     */
    @NotNull Component getSylizedName();

    /**
     * Rewards player.
     *
     * @param player Player instance
     * @param rewardConsumer Consumer applied after reward is given to player.
     */
    void rewardTo(@NotNull Player player,
                @Nullable Consumer<IReward> rewardConsumer
    );

    /**
     * @return Unique crate identifier
     */
    @NotNull NamespacedKey getIdentifier();

    /**
     * @return Crate permission.
     */
    @Nullable Permission getPermission();

}
