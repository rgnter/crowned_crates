package xyz.rgnt.crownedcrates.animations.impl.controllers;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;
import xyz.rgnt.crownedcrates.animations.IAnimationController;
import xyz.rgnt.crownedcrates.animations.actors.IActor;
import xyz.rgnt.crownedcrates.animations.model.IAnimation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Common implementation of animation controller with actors.
 */
public class CommonAnimationController
        implements IAnimationController {

    @Getter
    private JavaPlugin pluginInstance;

    @Getter
    private volatile BukkitTask tickingTask
            = null;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private volatile AtomicInteger currentTick
            = new AtomicInteger();

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private volatile boolean shouldTick
            = false;

    @Getter
    private final Map<IActor<?>, IAnimation> actors
            = new ConcurrentHashMap<>();

    public CommonAnimationController(final @NotNull JavaPlugin pluginInstance) {
        this.pluginInstance = pluginInstance;
    }

    @Override
    public void start() {
        setShouldTick(true);
        if(this.tickingTask != null)
            Bukkit.getScheduler().cancelTask(this.tickingTask.getTaskId());
        this.tickingTask = Bukkit.getScheduler()
                .runTaskTimerAsynchronously(getPluginInstance(), this::tick, 0, 1);
    }

    @Override
    public void stop() {
        setShouldTick(false);
        if(this.tickingTask != null)
            Bukkit.getScheduler().cancelTask(this.tickingTask.getTaskId());
    }

    @Override
    public void reset() {
        this.currentTick.set(0);
    }


    private void tick() {
        final var tick = this.currentTick.incrementAndGet();
        this.actors.forEach((actor, keyframes) -> {
            final var keyframe = keyframes.getKeyframe(tick);
            if(keyframe == null)
                return;

            keyframe.applyKeyframe(actor);
        });
    }

    public void addActor(@NotNull IActor<?> actor,
                         @NotNull IAnimation animation) {
        this.actors.put(actor, animation);
    }

    @Override
    public void remActor(@NotNull IActor<?> actor) {
        this.actors.remove(actor);
    }

    @Override
    public void remActor(@NotNull NamespacedKey actorIdentifier) {
        this.actors.remove(actorIdentifier); // hash based, so it doesnt matter
    }
}
