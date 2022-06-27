package com.dslm.handle_cane.datagen;

import com.dslm.handle_cane.Register;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider
{
    
    public RecipeProvider(DataGenerator generatorIn)
    {
        super(generatorIn);
    }
    
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        var sticks = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "rods/wooden"));
        var planks = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("minecraft", "planks"));
        
        ShapedRecipeBuilder.shaped(Register.BAMBOO_CANE_ITEM.get())
                .pattern("  a")
                .pattern(" a ")
                .pattern("a  ")
                .define('a', Items.BAMBOO)
                .unlockedBy("has_bamboo", has(Items.BAMBOO))
                .save(consumer, "bamboo_cane_item");
        
        ShapedRecipeBuilder.shaped(Register.BAMBOO_CANE_ITEM.get())
                .pattern(" b ")
                .pattern("bab")
                .pattern(" a ")
                .define('a', sticks)
                .define('b', planks)
                .unlockedBy("has_sticks", has(sticks))
                .save(consumer, "quad_cane_item");
    }
}
