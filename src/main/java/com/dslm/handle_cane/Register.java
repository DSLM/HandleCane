package com.dslm.handle_cane;

import com.dslm.handle_cane.item.BambooCaneItem;
import com.dslm.handle_cane.item.QuadCaneItem;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.dslm.handle_cane.util.StaticValue.MOD_ID;

public class Register
{
    private static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    private static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MOD_ID);
    private static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPES =
            DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, MOD_ID);
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MOD_ID);
    private static final DeferredRegister<MenuType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, MOD_ID);
    private static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);
    private static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MOD_ID);
    
    
    public static final RegistryObject<Item> BAMBOO_CANE_ITEM =
            ITEMS.register("bamboo_cane_item", () -> new BambooCaneItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> QUAD_CANE_ITEM =
            ITEMS.register("quad_cane_item", () -> new QuadCaneItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    
    
    public static final RegistryObject<SimpleParticleType> MOTOR_EXIT_PARTICLE_TYPE =
            PARTICLE_TYPES.register("motor_exit_particle_type", () -> new SimpleParticleType(false));
    
    public static void register(IEventBus bus)
    {
        BLOCKS.register(bus);
        ITEMS.register(bus);
        BLOCK_ENTITIES.register(bus);
        MOB_EFFECTS.register(bus);
        RECIPES.register(bus);
        RECIPE_SERIALIZERS.register(bus);
        CONTAINERS.register(bus);
        ENTITIES.register(bus);
        PARTICLE_TYPES.register(bus);
    }
}
