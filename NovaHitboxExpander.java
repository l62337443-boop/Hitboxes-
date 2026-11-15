package com.nova.hitbox;

import net.fabricmc.api.ModInitializer;

public final class NovaHitboxExpander implements ModInitializer {
    public static volatile boolean ENABLED = true;
    public static volatile float WIDTH_SCALE = 2.0F;
    public static volatile float HEIGHT_SCALE = 1.5F;

    @Override
    public void onInitialize() {
        // The mixin applies the configured dimensions to living entities.
    }
}
