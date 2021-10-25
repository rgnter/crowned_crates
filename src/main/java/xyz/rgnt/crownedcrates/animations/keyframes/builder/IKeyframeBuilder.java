package xyz.rgnt.crownedcrates.animations.keyframes.builder;

import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.animations.actors.IActor;
import xyz.rgnt.crownedcrates.animations.keyframes.IKeyframe;

import java.util.LinkedHashSet;

/**
 * Keyframe builder interface
 */
public interface IKeyframeBuilder {

    /**
     * @return New keyframe builder
     */
    static @NotNull IKeyframeBuilder make() {
        return new KeyframeBuilder(0);
    }

    /**
     * Applies relative rotation to actor.
     * Relative to center of animation origin.
     * @param rot Rotation
     * @return Builder
     */
    @NotNull IKeyframeBuilder withRelRot(@NotNull Vector rot);

    /**
     * Applies relative rotation to actor.
     * Relative to center of animation origin.
     * @param rot Rotation
     * @return Builder
     */
    @NotNull IKeyframeBuilder withRelRot(@NotNull EulerAngle rot);

    /**
     * Applies relative location to actor.
     * Relative to center of animation origin.
     * @param loc Location
     * @return Builder
     */
    @NotNull IKeyframeBuilder withRelLoc(@NotNull Vector loc);

    /**
     * Applies absolute rotation to actor.
     * @param rot Rotation
     * @return Builder
     */
    @NotNull IKeyframeBuilder withAbsRot(@NotNull Vector rot);


    /**
     * Applies relative rotation to actor.
     * Relative to center of animation origin.
     * @param rot Rotation
     * @return Builder
     */
    @NotNull IKeyframeBuilder withAbsRot(@NotNull EulerAngle rot);

    /**
     * Applies absolute location to actor.
     * @param loc Location
     * @return Builder
     */
    @NotNull IKeyframeBuilder withAbsLoc(@NotNull Vector loc);

    /**
     * Sets new keyframe
     * @param tick Tick time
     * @return Builder
     */
    @NotNull IKeyframeBuilder next(int tick);


    /**
     * @return Keyframes
     */
    @NotNull LinkedHashSet<IKeyframe<IActor<?>>> build();

}
