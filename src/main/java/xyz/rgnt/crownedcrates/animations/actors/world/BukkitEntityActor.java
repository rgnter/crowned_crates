package xyz.rgnt.crownedcrates.animations.actors.world;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.animations.actors.IActor;

/**
 * Entity actor in animation.
 */
public record BukkitEntityActor(@NotNull Entity entity,
                                @NotNull NamespacedKey actorIdentifier)
        implements IActor<Entity> {

    @Override
    public @NotNull Entity instance() {
        return entity;
    }

    @Override
    public @NotNull NamespacedKey getActorIdentifier() {
        return actorIdentifier;
    }

    @Override
    public void applyAbsoluteRotation(@NotNull Vector rot) {
        this.instance().setRotation((float) rot.getY(), (float) rot.getZ());
    }

    @Override
    public void applyAbsoluteLocation(@NotNull Vector loc) {
        this.instance().getLocation().set(loc.getX(), loc.getY(), loc.getZ());
    }

    @Override
    public void applyRelativeRotation(@NotNull Vector rot) {
        this.instance().setRotation(this.instance().getLocation().getYaw() + (float) rot.getY(),
                this.instance().getLocation().getPitch() + (float) rot.getZ());
    }

    @Override
    public void applyRelativeLocation(@NotNull Vector loc) {
        this.instance().getLocation().add(loc);
    }

    public static @NotNull <T extends Entity> BukkitEntityActor of(final @NotNull T entity,
                                                                   final @NotNull NamespacedKey actorIdentifier) {
        return new BukkitEntityActor(entity, actorIdentifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BukkitEntityActor that = (BukkitEntityActor) o;

        return actorIdentifier.equals(that.getActorIdentifier());
    }

    @Override
    public int hashCode() {
        return actorIdentifier.hashCode();
    }
}
