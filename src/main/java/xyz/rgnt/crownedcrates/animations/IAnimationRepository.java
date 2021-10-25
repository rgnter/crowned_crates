package xyz.rgnt.crownedcrates.animations;

import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.rgnt.crownedcrates.animations.impl.repo.CommonAnimationRepository;
import xyz.rgnt.crownedcrates.animations.model.IAnimation;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Repository containing animations.
 * Animations can be added, removed or retrieved from this repository.
 */
@ThreadSafe
public interface IAnimationRepository {

    /**
     * Adds animation to repository of animations
     * @param animId Animation identifier (must be unique)
     * @param animation Animation instance
     *
     * @return Boolean true if animation got registered. Otherwise, returns false.
     */
    boolean addAnimation(@NotNull NamespacedKey animId,
                         @NotNull IAnimation animation);

    /**
     * Removes animation from repository of animations
     * @param animId Animation identifier (
     *
     * @return Boolean true if animation got removed. Otherwise, returns false.
     */
    boolean remAnimation(@NotNull NamespacedKey animId);


    /**
     * @param animId Animation identifier.
     * @return Animation if is registered in repository.
     */
    @Nullable IAnimation getAnimation(@NotNull NamespacedKey animId);



    /**
     * Creates common animation repository
     * @return Animation repository
     */
    static @NotNull IAnimationRepository makeAnimationRepository() {
        return new CommonAnimationRepository();
    }
}
