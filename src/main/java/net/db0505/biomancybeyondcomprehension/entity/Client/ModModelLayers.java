package net.db0505.biomancybeyondcomprehension.entity.Client;

import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation MALFORMED_FLESH_BLOB_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(BiomancyBeyondComprehension.MOD_ID, "malformed_flesh_blob_layer"), "main");

    public static final ModelLayerLocation FLESH_WEAVER_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(BiomancyBeyondComprehension.MOD_ID, "flesh_weaver_layer"), "main");

    public static final ModelLayerLocation FLESH_DRAGON_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(BiomancyBeyondComprehension.MOD_ID, "flesh_dragon_layer"), "main");
}
