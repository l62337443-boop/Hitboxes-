package com.nova.hitbox.client;

import com.nova.hitbox.NovaHitboxExpander;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.LivingEntity;
import org.lwjgl.glfw.GLFW;

public final class NovaHitboxClient implements ClientModInitializer {
    private static KeyBinding toggleKey;

    @Override
    public void onInitializeClient() {
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.nova_hitbox_expander.toggle",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                KeyBinding.Category.MISC
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggleKey.wasPressed()) {
                NovaHitboxExpander.ENABLED = !NovaHitboxExpander.ENABLED;
            }

            // Recalculate dimensions so the changed hitboxes take effect immediately.
            if (client.world != null) {
                for (var entity : client.world.getEntities()) {
                    if (entity instanceof LivingEntity living) {
                        living.calculateDimensions();
                    }
                }
            }
        });
    }
}
