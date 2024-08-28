package com.ccc.funny;

import com.ccc.funny.block.ModBlocks;
import com.ccc.funny.block.ModFluids;
import com.ccc.funny.block.entity.ModBlockEntities;
import com.ccc.funny.entity.ModEntities;
import com.ccc.funny.entity.custom.KobeBryantEntity;
import com.ccc.funny.item.ModItemGroup;
import com.ccc.funny.item.ModItems;
import com.ccc.funny.recipe.ModRecipe;
import com.ccc.funny.screen.ModScreenHandlers;
import com.ccc.funny.sounds.ModSounds;
import com.ccc.funny.util.ModLootTable;
import com.ccc.funny.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Funny implements ModInitializer {
	// 定义MOD的ID
	public static final String MOD_ID = "funny";
	// 定义LOGGER
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// 初始化方法
	@Override
	public void onInitialize() {
		// 打印一条信息,证明成功加载
		LOGGER.info("If you see this sentence, it proves that you have read the source code or the running logs!");
		// 混合物品
		ModItems.registerModItems();
		// 混合物品组
		ModItemGroup.registerItemGroups();
		// 混合方块
		ModBlocks.registerModBlocks();
		// 混合声音
		ModSounds.registerSounds();
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LEMON_LOG, 50, 30);
		// 向可燃物注册表中添加ModBlocks.LEMON_LOG，设置燃烧值为50，燃烧速度为30
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LEMON_WOOD, 50, 30);
		// 向可燃物注册表中添加ModBlocks.LEMON_WOOD，设置燃烧值为50，燃烧速度为30
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_LEMON_LOG, 75, 50);
		// 向可燃物注册表中添加ModBlocks.STRIPPED_LEMON_LOG，设置燃烧值为75，燃烧速度为50
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_LEMON_WOOD, 75, 50);
		// 向可燃物注册表中添加ModBlocks.STRIPPED_LEMON_WOOD，设置燃烧值为75，燃烧速度为50
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LEMON_LEAVES, 100, 100);
		// 向可燃物注册表中添加ModBlocks.LEMON_LEAVES，设置燃烧值为100，燃烧速度为100
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LEMON_PLANKS, 100, 75);
		// 向可燃物注册表中添加ModBlocks.LEMON_PLANKS，设置燃烧值为100，燃烧速度为75

		StrippableBlockRegistry.register(ModBlocks.LEMON_LOG, ModBlocks.STRIPPED_LEMON_LOG);
		// 注册ModBlocks.LEMON_LOG，将其与ModBlocks.STRIPPED_LEMON_LOG关联
		StrippableBlockRegistry.register(ModBlocks.LEMON_WOOD, ModBlocks.STRIPPED_LEMON_WOOD);
		// 注册ModBlocks.LEMON_WOOD，将其与ModBlocks.STRIPPED_LEMON_WOOD关联
		ModLootTable.modifierLootTables();
		ModFluids.registerModFluids();
		ModScreenHandlers.registerScreenHandlers();
		ModBlockEntities.registerBlockEntities();
		ModRecipe.registerRecipe();

		FuelRegistry.INSTANCE.add(ModBlocks.LEMON_PLANKS, 300);
		FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_LEMON_LOG, 180);
		FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_LEMON_WOOD, 180);
		FuelRegistry.INSTANCE.add(ModBlocks.LEMON_WOOD, 180);
		FuelRegistry.INSTANCE.add(ModBlocks.LEMON_LOG, 180);

		FabricDefaultAttributeRegistry.register(ModEntities.KobeBryant, KobeBryantEntity.createKobeBryantAttributes().build());
		ModWorldGeneration.generateModWorldGen();
	}
}