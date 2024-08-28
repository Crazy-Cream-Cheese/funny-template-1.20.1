package com.ccc.funny.util;

import com.ccc.funny.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTable {
    private static final Identifier PLAYER_ID =
            new Identifier("minecraft","entities/player");
    public static void modifierLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (PLAYER_ID.equals(id)){
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(1.0f))
                            .with(ItemEntry.builder(ModItems.DEFECATE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                    tableBuilder.pool(poolBuilder);
            }
        });
    }
}
