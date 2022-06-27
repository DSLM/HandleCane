package com.dslm.handle_cane.datagen;

import com.dslm.handle_cane.Register;
import com.dslm.handle_cane.util.StaticValue;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;

public class LanguageUtil
{
    public static HashMap<String, String> StringKey_en = new HashMap<>();
    public static HashMap<String, String> StringKey_zh = new HashMap<>();
    
    public static HashMap<Item, String> ItemKey_en = new HashMap<>();
    public static HashMap<Item, String> ItemKey_zh = new HashMap<>();
    
    public static HashMap<Block, String> BlockKey_en = new HashMap<>();
    public static HashMap<Block, String> BlockKey_zh = new HashMap<>();
    
    public static HashMap<MobEffect, String> MobEffectKey_en = new HashMap<>();
    public static HashMap<MobEffect, String> MobEffectKey_zh = new HashMap<>();
    
    public static HashMap<EntityType, String> EntityType_en = new HashMap<>();
    public static HashMap<EntityType, String> EntityType_zh = new HashMap<>();
    
    public static void buildLanguage(DataGenerator generator)
    {
        //item
        {
            add(Register.BAMBOO_CANE_ITEM.get(), "Bamboo Cane", "竹杖");
            add(Register.QUAD_CANE_ITEM.get(), "Quad Cane", "四脚杖");
        }
        
        //tooltip
        {
            //参考：《许渊冲经典英译古代诗歌1000首》
            add(String.format("tooltip.%s.%s.%s", StaticValue.MOD_ID, Register.BAMBOO_CANE_ITEM.get(), "1"),
                    "Better than saddled horse I like sandals and cane", "竹杖芒鞋轻胜马");
        }
        
        
        //start generation
        generator.addProvider(new LanguageProvider(generator, "en_us"));
        generator.addProvider(new LanguageZhProvider(generator, "zh_cn"));
    }
    
    private static void add(EntityType key, String en, String zh)
    {
        EntityType_en.put(key, en);
        EntityType_zh.put(key, zh);
    }
    
    public static void add(String key, String en, String zh)
    {
        StringKey_en.put(key, en);
        StringKey_zh.put(key, zh);
    }
    
    public static void add(Item key, String en, String zh)
    {
        ItemKey_en.put(key, en);
        ItemKey_zh.put(key, zh);
    }
    
    public static void add(Block key, String en, String zh)
    {
        BlockKey_en.put(key, en);
        BlockKey_zh.put(key, zh);
    }
    
    public static void add(MobEffect key, String en, String zh)
    {
        MobEffectKey_en.put(key, en);
        MobEffectKey_zh.put(key, zh);
    }
}
