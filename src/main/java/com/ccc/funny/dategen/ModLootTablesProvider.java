package com.ccc.funny.dategen;

import com.ccc.funny.block.ModBlocks;
import com.ccc.funny.block.custom.TeaTreeCrop;
import com.ccc.funny.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;


public class ModLootTablesProvider extends FabricBlockLootTableProvider {
    public ModLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.DEFECATE_BLOCK);
        addDrop(ModBlocks.LEMON_WOOD);
        addDrop(ModBlocks.LEMON_LOG);
        addDrop(ModBlocks.LEMON_PLANKS);
        addDrop(ModBlocks.LEMON_LEAVES, leavesDrops(ModBlocks.LEMON_LEAVES, ModBlocks.LemonTreeSapling, 0.0025f));
        addDrop(ModBlocks.STRIPPED_LEMON_LOG);
        addDrop(ModBlocks.STRIPPED_LEMON_WOOD);
        addDrop(ModBlocks.LemonTreeSapling);
        addDrop(ModBlocks.StickyLemonIcedTeaBlock);
        addDrop(ModBlocks.FreshLemonIcedTeaBlock);
        addDrop(ModBlocks.LemonIcedTeaSoul,copperOreLikeDrops(ModBlocks.LemonIcedTeaSoul, ModItems.LemonIcedTeaSoul));
        addDrop(ModBlocks.LemonIcedTeaEssence,copperOreLikeDrops(ModBlocks.LemonIcedTeaEssence,ModItems.LemonIcedTeaEssence));

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.RED_TEA_TREE).properties(StatePredicate.Builder.create().exactMatch(TeaTreeCrop.AGE,3));
        addDrop(ModBlocks.RED_TEA_TREE, cropDrops(ModBlocks.RED_TEA_TREE, ModItems.RED_TEA_LEAVE, ModItems.RED_TEA_SEED, builder));
    }
    public LootTable.Builder copperOreLikeDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                        ((LeafEntry.Builder) ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f))))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
