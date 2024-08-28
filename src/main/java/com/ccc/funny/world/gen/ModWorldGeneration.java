package com.ccc.funny.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen(){
        ModOreGeneration.generateOres();
        ModTreeGeneration.registerTrees();
    }
}
