package net.db0505.biomancybeyondcomprehension.datagen;


import net.db0505.biomancybeyondcomprehension.BiomancyBeyondComprehension;
import net.db0505.biomancybeyondcomprehension.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BiomancyBeyondComprehension.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MALIGNANT_OPTIC_BLOCK);

        simpleBlockWithItem(ModBlocks.BIO_SCRYER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/bio_scryer")));

        horizontalBlock(ModBlocks.SCRYING_EYE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/scrying_eye")));
        itemModelFromBlock(ModBlocks.SCRYING_EYE.get());

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void itemModelFromBlock(Block block) {
        simpleBlockItem(block, new ModelFile.UncheckedModelFile(modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath())));
    }
}
