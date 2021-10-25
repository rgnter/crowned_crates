package xyz.rgnt.crownedcrates;

import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.animations.IAnimationController;
import xyz.rgnt.crownedcrates.animations.IAnimationRepository;
import xyz.rgnt.crownedcrates.animations.keyframes.builder.IKeyframeBuilder;
import xyz.rgnt.crownedcrates.animations.model.IAnimation;
import xyz.rgnt.crownedcrates.crates.ICrateRepository;
import xyz.rgnt.crownedcrates.rewards.IRewardRepository;

/**
 * Common API interface
 */
public interface CrownedCratesAPI {


    /**
     * @return Crate repository
     */
    @NotNull ICrateRepository getCrates();

    /**
     * @return Reward repository
     */
    @NotNull IRewardRepository getRewards();


    /**
     * @return Animation repository
     */
    @NotNull IAnimationRepository getAnimations();
}
