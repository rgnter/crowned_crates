package xyz.rgnt.crownedcrates.animations.model;

import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.animations.actors.IActor;
import xyz.rgnt.crownedcrates.animations.keyframes.IKeyframe;

import java.util.LinkedHashSet;

/**
 * Animation
 */
public interface IAnimation {

    /**
     * @param tick Tick
     * @return Keyframe for tick
     */
    @NotNull IKeyframe<IActor<?>> getKeyframe(int tick);

    /**
     * @return Animation keyframes
     */
    LinkedHashSet<IKeyframe<IActor<?>>> getKeyframes();


    /**
     * Creates animation from keyfreames.
     *
     * @param keyframes Keyframes
     * @return IAnimation
     */
    static @NotNull IAnimation makeAnimation(final @NotNull LinkedHashSet<IKeyframe<IActor<?>>> keyframes) {
        return new CommonAnimation(keyframes);
    }
}
