package com.dslm.handle_cane.datagen;

import com.dslm.handle_cane.util.StaticValue;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

import static com.dslm.handle_cane.datagen.LanguageUtil.*;

public class LanguageZhProvider extends LanguageProvider
{
    
    public LanguageZhProvider(DataGenerator gen, String locale)
    {
        super(gen, StaticValue.MOD_ID, locale);
    }
    
    @Override
    protected void addTranslations()
    {
        for(String i : StringKey_zh.keySet())
        {
            add(i, StringKey_zh.get(i));
        }
        for(Item i : ItemKey_zh.keySet())
        {
            add(i, ItemKey_zh.get(i));
        }
        for(Block i : BlockKey_zh.keySet())
        {
            add(i, BlockKey_zh.get(i));
        }
        for(MobEffect i : MobEffectKey_zh.keySet())
        {
            add(i, MobEffectKey_zh.get(i));
        }
        for(EntityType i : EntityType_zh.keySet())
        {
            add(i, EntityType_zh.get(i));
        }
    }
}