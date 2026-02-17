package net.db0505.biomancybeyondcomprehension.datagen;

import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BiomancyBeyondComprehension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.EYE);
        simpleItem(ModItems.BRAIN);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("later0",
            new ResourceLocation(BiomancyBeyondComprehension.MOD_ID, "item/" + item.getId().getPath()));
    }

}
