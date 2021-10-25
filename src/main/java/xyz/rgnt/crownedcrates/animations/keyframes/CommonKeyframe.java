package xyz.rgnt.crownedcrates.animations.keyframes;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.rgnt.crownedcrates.animations.actors.IActor;

/**
 * Keyframe holds information about transformation state of actor
 */

@Setter
public class CommonKeyframe
    implements IKeyframe<IActor<?>> {

    private final int tick;

    private @Nullable Vector relRot
            = null;
    private @Nullable Vector relLoc
            = null;

    private @Nullable Vector absRot
            = null;
    private @Nullable Vector absLoc
            = null;

    public CommonKeyframe(int tick) {
        this.tick = tick;
    }

    @Override
    public @Nullable Vector getRelativeRotation() {
        return this.relRot;
    }

    @Override
    public @Nullable Vector getRelativeLocation() {
        return this.relLoc;
    }

    @Override
    public @Nullable Vector getAbsoluteLocation() {
        return this.absLoc;
    }

    @Override
    public @Nullable Vector getAbsoluteRotation() {
        return this.absRot;
    }

    @Override
    public void applyKeyframe(@NotNull IActor<?> actor) {
        if(this.absRot != null)
            actor.applyAbsoluteRotation(absRot);
        if(this.absLoc != null)
            actor.applyAbsoluteLocation(absLoc);
        if(this.relRot != null)
            actor.applyRelativeRotation(relRot);
        if(this.relLoc != null)
            actor.applyRelativeLocation(relLoc);
    }
}

