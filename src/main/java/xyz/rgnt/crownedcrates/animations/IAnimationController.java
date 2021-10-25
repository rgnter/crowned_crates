package xyz.rgnt.crownedcrates.animations;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.animations.actors.IActor;
import xyz.rgnt.crownedcrates.animations.impl.controllers.CommonAnimationController;
import xyz.rgnt.crownedcrates.animations.model.IAnimation;

import javax.annotation.concurrent.ThreadSafe;

/**
 * Controls actors and their animations.
 * Actors can be added or removed from this controller.
 */
@ThreadSafe
public interface IAnimationController {

    /**
     * Starts animation ticking.
     */

    void start();

    /**
     * Stops animation ticking.
     */
    void stop();

    /**
     * Resets animation state.
     */
    void reset();


    /**
     * Adds actor with its keyframes.
     *
     * @param actor Actor instance
     * @param animation Animation
     */
    void addActor(@NotNull IActor<?> actor,
                  final @NotNull IAnimation animation);

    /**
     * Removes actor with its keyframes.
     *
     * @param actor Actor instance.
     */
    void remActor(final @NotNull IActor<?> actor);

    /**
     * Removes actor with its keyframes.
     *
     * @param actorIdentifier Actor identifier
     */
    void remActor(final @NotNull NamespacedKey actorIdentifier);

    /**
     * Creates world animation controller
     *
     * @param plugin Plugin instance
     * @return Animation controller
     */
    static @NotNull IAnimationController makeWorldAnimationController(
            final @NotNull JavaPlugin plugin) {
        return new CommonAnimationController(plugin);
    }

    /**
     * Creates title animation controller
     *
     * @param plugin Plugin instance
     * @return Animation controller
     */
    static @NotNull IAnimationController makeTitleAnimationController(
            final @NotNull JavaPlugin plugin) {
        return new CommonAnimationController(plugin);
    }

    /**
     * Creates chest animation controller
     *
     * @param plugin Plugin instance
     * @return Animation controller
     */
    static @NotNull IAnimationController makeChestAnimationController(
            final @NotNull JavaPlugin plugin) {
        return new CommonAnimationController(plugin);
    }
}
