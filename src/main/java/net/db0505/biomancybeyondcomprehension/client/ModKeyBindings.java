package net.db0505.biomancybeyondcomprehension.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public final class ModKeyBindings {
    public static final ModKeyBindings INSTANCE = new ModKeyBindings();

    private ModKeyBindings() {}

    private static final String CATEGORY = "key.categories." + BiomancyBeyondComprehension.MOD_ID;

    public final KeyMapping FlyUp = new KeyMapping(
            "key." + BiomancyBeyondComprehension.MOD_ID + ".fly_up",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_SPACE, -1),
            KeyMapping.CATEGORY_GAMEPLAY
    );

    public final KeyMapping FlyDown = new KeyMapping(
            "key." + BiomancyBeyondComprehension.MOD_ID + ".fly_down",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_LSHIFT, -1),
            KeyMapping.CATEGORY_GAMEPLAY
    );
}

