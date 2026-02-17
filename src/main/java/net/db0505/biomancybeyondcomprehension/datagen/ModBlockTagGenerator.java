package net.db0505.biomancybeyondcomprehension.datagen;

import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BiomancyBeyondComprehension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        /*
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
        .add(ModBlocks.SAPPHIRE_ORE.GET()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SAPPHIRE_ORE.get(),
                    ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                    ModBlocks.RAW_SAPPHIRE_BLOCK.get());
         */

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.MALIGNANT_OPTIC_BLOCK.get());

        /*
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SAPPHIRE_ORE.GET()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.SAPPHIRE_ORE.GET()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SAPPHIRE_ORE.GET()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_ORE.GET()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SAPPHIRE_ORE.GET()).addTag(Tags.Blocks.ORES);

         */
    }
}
