package com.dslm.handle_cane.datagen;

import com.dslm.handle_cane.util.StaticValue;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.dslm.handle_cane.datagen.LanguageUtil.*;


public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider
{
    
    public LanguageProvider(DataGenerator gen, String locale)
    {
        super(gen, StaticValue.MOD_ID, locale);
    }
    
    @Override
    protected void addTranslations()
    {
        for(String i : StringKey_en.keySet())
        {
            add(i, StringKey_en.get(i));
        }
        for(Item i : ItemKey_en.keySet())
        {
            add(i, ItemKey_en.get(i));
        }
        for(Block i : BlockKey_en.keySet())
        {
            add(i, BlockKey_en.get(i));
        }
        for(MobEffect i : MobEffectKey_en.keySet())
        {
            add(i, MobEffectKey_en.get(i));
        }
        for(EntityType i : EntityType_en.keySet())
        {
            add(i, EntityType_en.get(i));
        }
    }
}