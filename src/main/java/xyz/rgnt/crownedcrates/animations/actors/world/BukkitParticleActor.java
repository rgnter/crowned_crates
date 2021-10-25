package xyz.rgnt.crownedcrates.animations.actors.world;

import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.animations.actors.IActor;

/**
 * Particle actor in animation.
 */
public record BukkitParticleActor(@NotNull Particle particle,
                                  @NotNull NamespacedKey actorIdentifier)
        implements IActor<Particle> {

    @Override
    public @NotNull Particle instance() {
        return this.particle;
    }

    @Override
    public void applyAbsoluteRotation(@NotNull Vector rot) {

    }

    @Override
    public void applyAbsoluteLocation(@NotNull Vector loc) {

    }

    @Override
    public void applyRelativeRotation(@NotNull Vector rot) {

    }

    @Override
    public void applyRelativeLocation(@NotNull Vector loc) {

    }

    @Override
    public @NotNull NamespacedKey getActorIdentifier() {
        return this.actorIdentifier;
    }

    public static @NotNull <T extends Particle> BukkitParticleActor of(final @NotNull T entity,
                                                                       final @NotNull NamespacedKey actorIdentifier) {
        return new BukkitParticleActor(entity, actorIdentifier);
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
