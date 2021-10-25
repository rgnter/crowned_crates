package xyz.rgnt.crownedcrates.animations.actors;

import org.bukkit.NamespacedKey;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

/**
 * Animation actor
 *
 * @param <T> Actor type
 */
public interface IActor<T> {


    /**
     * @return Instance of actor type
     */
    @NotNull T instance();

    /**
     * Applies absolute rotation to actor
     * @param rot Rotation vector
     */
    void applyAbsoluteRotation(final @NotNull Vector rot);

    /**
     * Applies absolute location to actor
     * @param loc Location vector
     */
    void applyAbsoluteLocation(final @NotNull Vector loc);

    /**
     * Applies relative rotation to actor
     * @param rot Rotation vector
     */
    void applyRelativeRotation(final @NotNull Vector rot);

    /**
     * Applies relative location to actor
     * @param loc Location vector
     */
    void applyRelativeLocation(final @NotNull Vector loc);




    /**
     * @return Actor identifier
     */
    @NotNull NamespacedKey getActorIdentifier();
}
