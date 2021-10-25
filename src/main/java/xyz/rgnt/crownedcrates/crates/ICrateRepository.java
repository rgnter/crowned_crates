package xyz.rgnt.crownedcrates.crates;

import com.google.common.collect.ImmutableList;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Repository containing crates.
 */
public interface ICrateRepository {

    /**
     * Registers & adds crate.
     *
     * @param crate Crate instance.
     * @return Boolean true if crate has been successfully registered & added to world.
     *         Otherwise, returns false.
     */
    public boolean addCrate(
            @NotNull ICrate crate
    );

    /**
     * Unregisters & removes crate.
     *
     * @param crateId Crate identifier.
     * @return Boolean true if crate has been successfully unregistered & removed from world.
     *         Otherwise, returns false.
     */
    public boolean remCrate(
            @NotNull NamespacedKey crateId
    );

    /**
     *
     * @param crateId Crate Identifier
     * @return Crate instance. Returns null if crate is not registered.
     */
    @Nullable ICrate getCrate(
            @NotNull NamespacedKey crateId
    );


    /**
     * @return Immutable list of registered crates.
     */
    @NotNull ImmutableList<ICrate> getRegisteredCrates();



}
