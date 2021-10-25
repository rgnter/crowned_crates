package xyz.rgnt.crownedcrates.animations.keyframes.builder;

import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.animations.actors.IActor;
import xyz.rgnt.crownedcrates.animations.keyframes.CommonKeyframe;
import xyz.rgnt.crownedcrates.animations.keyframes.IKeyframe;

import java.util.LinkedHashSet;

public class KeyframeBuilder
    implements IKeyframeBuilder {

    private CommonKeyframe toBuild;
    private final LinkedHashSet<IKeyframe<IActor<?>>> progress
             = new LinkedHashSet<>();

    public KeyframeBuilder(final int tick) {
        next(tick);
    }

    @Override
    public @NotNull IKeyframeBuilder withRelRot(@NotNull Vector rot) {
        this.toBuild.setRelRot(rot);
        return this;
    }

    @Override
    public @NotNull IKeyframeBuilder withRelRot(@NotNull EulerAngle rot) {
        this.toBuild.setRelRot(new Vector(rot.getX(), rot.getY(), rot.getZ()));
        return this;
    }

    @Override
    public @NotNull IKeyframeBuilder withRelLoc(@NotNull Vector loc) {
        this.toBuild.setRelLoc(loc);
        return this;
    }

    @Override
    public @NotNull IKeyframeBuilder withAbsRot(@NotNull Vector rot) {
        this.toBuild.setAbsRot(rot);
        return this;
    }

    @Override
    public @NotNull IKeyframeBuilder withAbsRot(@NotNull EulerAngle rot) {
        this.toBuild.setAbsRot(new Vector(rot.getX(), rot.getY(), rot.getZ()));
        return this;
    }

    @Override
    public @NotNull IKeyframeBuilder withAbsLoc(@NotNull Vector loc) {
        this.toBuild.setAbsLoc(loc);
        return this;
    }

    @Override
    public @NotNull IKeyframeBuilder next(int tick) {
        if(this.toBuild != null)
            this.progress.add(toBuild);
        this.toBuild = new CommonKeyframe(tick);

        return this;
    }

    @Override
    public @NotNull LinkedHashSet<IKeyframe<IActor<?>>> build() {
        return this.progress;
    }
}
