package xyz.rgnt.crownedcrates.animations.keyframes;

import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.rgnt.crownedcrates.animations.actors.IActor;
import xyz.rgnt.crownedcrates.animations.model.IAnimation;

import java.util.LinkedHashSet;

public interface IKeyframe<T extends IActor<?>> {

    /**
     * @return Relative location transform. Relative to center of animation origin.
     */
    @Nullable Vector getRelativeRotation();

    /**
     *  @return Absolute rotation transform. Relative to center of animation origin.
     */
    @Nullable Vector getRelativeLocation();

    /**
     * @return Absolute location transform.
     */
    @Nullable Vector getAbsoluteLocation();

    /**
     *  @return Absolute rotation transform.
     */
    @Nullable Vector getAbsoluteRotation();


    /**
     * Applies this keyframe state to actor
     * @param actor Actor instance
     */

    void applyKeyframe(@NotNull T actor);

    /**
     * Calculates Tri-Linear interpolation between two keyframes
     * @param other Other keyframe.
     *
     * @param originTick Origin tick of another keyframe
     * @param targetTick Target tick of this keyframe
     *
     * @return Calculated tri-linear interpolation
     */
    static @Nullable <T extends IActor<?>>IKeyframe<T> calculateLerp(@NotNull IKeyframe<T> other,
                                             int originTick, int targetTick) {
        return null;
    }
}
