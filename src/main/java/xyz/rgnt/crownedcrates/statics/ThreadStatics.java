package xyz.rgnt.crownedcrates.statics;

import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

public class ThreadStatics {

    /**
     * @return Boolean true if current thread is game thread.
     */
    public static boolean isGameThread() {
        return Thread.currentThread().equals(MinecraftServer.getServer().getThread());
    }

}
