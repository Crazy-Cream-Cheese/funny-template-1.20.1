package com.ccc.funny.item;

import com.ccc.funny.Funny;
import com.ccc.funny.block.ModBlocks;
import com.ccc.funny.block.ModFluids;
import com.ccc.funny.item.custom.Defecate;
import com.ccc.funny.item.custom.Emesis;
import com.ccc.funny.item.custom.Drink;
import com.ccc.funny.sounds.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DEFECATE = registerItems("defecate",new Defecate(new FabricItemSettings().maxCount(16)));
    public static final Item EMESIS = registerItems("emesis",new Emesis(new FabricItemSettings().food(ModFoodComponents.EMESIS).maxCount(32)));
    public static final Item LEMON = registerItems("lemon",new Item(new FabricItemSettings().food(ModFoodComponents.LEMON)));
    public static final Item Kobe_Bryant_Elbow = registerItems("kobe_bryant_elbow",new AxeItem(ModToolMaterisl.FUNNY, 24, 3.0f, new FabricItemSettings().maxCount(1)));
    public static final Item FUNNY = registerItems("funny",new Item(new FabricItemSettings()));
    public static final Item LEMON_DRINK = registerItems("lemon_drink",new Drink(new FabricItemSettings().food(ModFoodComponents.LEMON_DRINK)));
    public static final Item LemonIcedTeaEssence = registerItems("lemon_iced_tea_essence_ball",new Item(new FabricItemSettings()));
    public static final Item LemonIcedTeaSoul = registerItems("lemon_iced_tea_soul_ball",new Item(new FabricItemSettings()));
    public static final Item Syrup_Bucket = registerItems("syrup_bucket", new BucketItem(ModFluids.Syrup, new Item.Settings().maxCount(1).recipeRemainder(Items.BUCKET)));
    public static final Item PurifiedWater = registerItems("purified_water",new MilkBucketItem(new FabricItemSettings().maxCount(1)));
    public static final Item YouSeeMeDisc = registerItems("you_see_me_disc",new MusicDiscItem(15, ModSounds.YouSeeMe, new FabricItemSettings().maxCount(1), 307));
    public static final Item RED_TEA_LEAVE = registerItems("red_tea_leave",new Item(new FabricItemSettings()));
    public static final Item DRY_RED_TEA_LEAVE = registerItems("dry_red_tea_leave",new Item(new FabricItemSettings()));
    public static final Item RED_TEA_SEED = registerItems("red_tea_seed",new AliasedBlockItem(ModBlocks.RED_TEA_TREE, new FabricItemSettings()));
    public static final Item RED_TEA = registerItems("red_tea",new Drink(new FabricItemSettings().food(ModFoodComponents.RedTea).maxCount(1).recipeRemainder(Items.BUCKET)));
    public static final Item Lemon_Iced_Tea = registerItems("lemon_iced_tea",new Drink(new FabricItemSettings().maxCount(1)));
    public static final Item Lemon_Iced_Tea_Core = registerItems("lemon_iced_tea_core",new Drink(new FabricItemSettings().food(ModFoodComponents.RedTea).maxCount(1)));
    public static final Item Lemon_Iced_Tea_Sword = registerItems("lemon_iced_tea_sword",new SwordItem(ModToolMaterisl.FUNNY, 17, 4.0f, new FabricItemSettings().maxCount(1)));


    private static Item registerItems(String name,Item item) {
        // 在物品注册表中注册物品
        return Registry.register(Registries.ITEM, new Identifier(Funny.MOD_ID, name), item);
    }
    // 注册物品
    public static void registerModItems() {
        // 添加物品到funny
    }
}