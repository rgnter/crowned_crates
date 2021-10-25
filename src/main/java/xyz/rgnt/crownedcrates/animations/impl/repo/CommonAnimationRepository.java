package xyz.rgnt.crownedcrates.animations.impl.repo;

import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.rgnt.crownedcrates.animations.IAnimationRepository;
import xyz.rgnt.crownedcrates.animations.model.IAnimation;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Common implementation of animation repository
 */
public class CommonAnimationRepository
    implements IAnimationRepository {

    private final Map<NamespacedKey, IAnimation> repository
            = new ConcurrentHashMap<>();


    @Override
    public boolean addAnimation(@NotNull NamespacedKey animId,
                                @NotNull IAnimation animation) {
        if(this.repository.containsKey(animId))
            return false;
        this.repository.put(animId, animation);
        return true;
    }

    @Override
    public boolean remAnimation(@NotNull NamespacedKey animId) {
        return repository.remove(animId) == null;
    }

    @Override
    public @Nullable IAnimation getAnimation(@NotNull NamespacedKey animId) {
        return this.repository.get(animId);
    }
}
