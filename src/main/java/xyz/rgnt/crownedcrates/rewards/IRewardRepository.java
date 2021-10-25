package xyz.rgnt.crownedcrates.rewards;

import com.google.common.collect.ImmutableList;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Repository containing rewards.
 */
public interface IRewardRepository {

    /**
     * Registers & adds reward.
     *
     * @param reward Reward instance.
     * @return Boolean true if reward has been successfully registered & added to world.
     *         Otherwise, returns false.
     */
    public boolean addReward(
            @NotNull IReward reward
    );

    /**
     * Unregisters & removes reward.
     *
     * @param rewardId Reward identifier.
     * @return Boolean true if reward has been successfully unregistered & removed from world.
     *         Otherwise, returns false.
     */
    public boolean remReward(
            @NotNull NamespacedKey rewardId
    );

    /**
     *
     * @param rewardId Reward Identifier
     * @return Reward instance. Returns null if reward is not registered.
     */
    @Nullable IReward getReward(
            @NotNull NamespacedKey rewardId
    );


    /**
     * @return Immutable list of registered rewards.
     */
    @NotNull ImmutableList<IReward> getRegisteredRewards();

}
