package com.ccc.funny.item;

import com.ccc.funny.Funny;
import com.ccc.funny.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroup {
    public static void registerItemGroups() {
        // 添加物品组到Fart中
    }
    public static final ItemGroup Funny_Group = Registry.register(Registries.ITEM_GROUP, new Identifier(Funny.MOD_ID,"funny_group"), FabricItemGroup.builder().displayName(Text.translatable("itemGroup.fart_group")).icon(()-> new ItemStack(ModItems.FUNNY)).entries((displayContext, entries) -> {
        //注册一个fart物品组
        // 添加物品到物品组中
        entries.add(ModItems.DEFECATE);
        entries.add(ModBlocks.DEFECATE_BLOCK);
        entries.add(ModItems.EMESIS);
        //添加柠檬条目
        entries.add(ModItems.LEMON);
        //添加柠檬原木条目
        entries.add(ModBlocks.LEMON_LOG);
        //添加去皮柠檬木条目
        entries.add(ModBlocks.STRIPPED_LEMON_WOOD);
        //添加去皮柠檬原木条目
        entries.add(ModBlocks.STRIPPED_LEMON_LOG);
        //添加柠檬木板条目
        entries.add(ModBlocks.LEMON_PLANKS);
        //添加柠檬木条目
        entries.add(ModBlocks.LEMON_WOOD);
        //添加柠檬树叶条目
        entries.add(ModBlocks.LEMON_LEAVES);
        entries.add(ModBlocks.StickyLemonIcedTeaBlock);
        entries.add(ModBlocks.FreshLemonIcedTeaBlock);
        entries.add(ModBlocks.LemonIcedTeaEssence);
        entries.add(ModBlocks.LemonIcedTeaSoul);
        entries.add(ModBlocks.LemonTreeSapling);
        entries.add(ModItems.LEMON_DRINK);
        entries.add(ModItems.LemonIcedTeaEssence);
        entries.add(ModItems.LemonIcedTeaSoul);
        entries.add(ModItems.Syrup_Bucket);
        entries.add(ModItems.PurifiedWater);
        entries.add(ModBlocks.FluidHandlingMachines);
        entries.add(ModItems.RED_TEA_SEED);
        entries.add(ModItems.RED_TEA_LEAVE);
        entries.add(ModItems.RED_TEA);
        entries.add(ModItems.DRY_RED_TEA_LEAVE);
        entries.add(ModItems.Kobe_Bryant_Elbow);
        entries.add(ModItems.Lemon_Iced_Tea);
        entries.add(ModItems.Lemon_Iced_Tea_Core);
        entries.add(ModItems.Lemon_Iced_Tea_Sword);

    }).build());
}
