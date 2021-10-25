package xyz.rgnt.crownedcrates.animations.actors.builder;

import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.animations.actors.world.BukkitEntityActor;
import xyz.rgnt.crownedcrates.animations.actors.world.BukkitParticleActor;

/**
 * Actor builder interface
 */
public interface IActorBuilder {

    /**
     * Creates entity actor
     *
     * @param entity Entity instance.
     * @param actorIdentifier Actor identifier.
     * @param <T> Type of Entity
     *
     * @return Entity Actor instance
     */
    static @NotNull <T extends Entity> BukkitEntityActor crateEntityActor(final @NotNull T entity,
                                                                          final @NotNull NamespacedKey actorIdentifier) {
        return BukkitEntityActor.of(entity, actorIdentifier);
    }

    /**
     * Creates particle actor
     *
     * @param particle Particle
     * @param actorIdentifier Actor identifier.
     * @param <T> Type of Particle
     * @return
     */
    static @NotNull <T extends Particle> BukkitParticleActor crateParticleActor(@NotNull T particle,
                                                                                final @NotNull NamespacedKey actorIdentifier) {
        return BukkitParticleActor.of(particle, actorIdentifier);
    }

}
