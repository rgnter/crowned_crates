package xyz.rgnt.crownedcrates.animations.model;

import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.animations.actors.IActor;
import xyz.rgnt.crownedcrates.animations.keyframes.IKeyframe;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Common animation
 */
public class CommonAnimation
    implements IAnimation {

    private final LinkedHashSet<IKeyframe<IActor<?>>> keyframes;


    public CommonAnimation(final @NotNull LinkedHashSet<IKeyframe<IActor<?>>> keyframes) {
        this.keyframes = keyframes;
    }

    @Override
    public @NotNull IKeyframe<IActor<?>> getKeyframe(int tick) {
        return null;
    }

    @Override
    public LinkedHashSet<IKeyframe<IActor<?>>> getKeyframes() {
        return keyframes;
    }
}
