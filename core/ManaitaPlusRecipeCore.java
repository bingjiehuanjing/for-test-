/*    */ package rikuto.manaita_plus.core;
/*    */ 
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.common.Loader;
/*    */ import net.minecraftforge.fml.common.registry.ForgeRegistries;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ import net.minecraftforge.oredict.ShapedOreRecipe;
/*    */ import rikuto.manaita_plus.recipe.ManaitaSourceRecipe;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ManaitaPlusRecipeCore
/*    */ {
/*    */   public static void registerRecipe() {
/* 18 */     ForgeRegistries.RECIPES.register((new ManaitaSourceRecipe()).setRegistryName(new ResourceLocation("manaita_plus", "source")));
/*    */     
/* 20 */     if (!ManaitaPlusConfigCore.easyMode) {
/* 21 */       ForgeRegistries.RECIPES.register((new ShapedOreRecipe(new ResourceLocation("manaita_plus", "crafting_manaita"), new ItemStack(ManaitaPlusBlockCore.craftingManaita, 1), new Object[] { "YYY", "X X", "YYY", 
/* 22 */               Character.valueOf('X'), Blocks.field_150462_ai, Character.valueOf('Y'), "blockDiamond" })).setRegistryName(new ResourceLocation("manaita_plus", "crafting_manaita")));
/*    */       
/* 24 */       ForgeRegistries.RECIPES.register((new ShapedOreRecipe(new ResourceLocation("manaita_plus", "furnace_manaita"), new ItemStack(ManaitaPlusBlockCore.furnaceManaita, 1), new Object[] { "YYY", "X X", "YYY", 
/* 25 */               Character.valueOf('X'), Blocks.field_150460_al, Character.valueOf('Y'), "blockDiamond" })).setRegistryName(new ResourceLocation("manaita_plus", "furnace_manaita")));
/*    */       
/* 27 */       ForgeRegistries.RECIPES.register((new ShapedOreRecipe(new ResourceLocation("manaita_plus", "brewing_manaita"), new ItemStack(ManaitaPlusBlockCore.brewingManaita, 1), new Object[] { "YYY", "X X", "YYY", 
/* 28 */               Character.valueOf('X'), Items.field_151067_bt, Character.valueOf('Y'), "blockDiamond" })).setRegistryName(new ResourceLocation("manaita_plus", "brewing_manaita")));
/*    */     } else {
/*    */       
/* 31 */       ForgeRegistries.RECIPES.register((new ShapedOreRecipe(new ResourceLocation("manaita_plus", "easy_crafting_manaita"), new ItemStack(ManaitaPlusBlockCore.craftingManaita, 1), new Object[] { "YYY", "X X", "YYY", 
/* 32 */               Character.valueOf('X'), Blocks.field_150462_ai, Character.valueOf('Y'), "cobblestone" })).setRegistryName(new ResourceLocation("manaita_plus", "easy_crafting_manaita")));
/*    */       
/* 34 */       ForgeRegistries.RECIPES.register((new ShapedOreRecipe(new ResourceLocation("manaita_plus", "easy_furnace_manaita"), new ItemStack(ManaitaPlusBlockCore.furnaceManaita, 1), new Object[] { "YYY", "X X", "YYY", 
/* 35 */               Character.valueOf('X'), Blocks.field_150460_al, Character.valueOf('Y'), "cobblestone" })).setRegistryName(new ResourceLocation("manaita_plus", "easy_furnace_manaita")));
/*    */       
/* 37 */       ForgeRegistries.RECIPES.register((new ShapedOreRecipe(new ResourceLocation("manaita_plus", "easy_brewing_manaita"), new ItemStack(ManaitaPlusBlockCore.brewingManaita, 1), new Object[] { "YYY", "X X", "YYY", 
/* 38 */               Character.valueOf('X'), Items.field_151067_bt, Character.valueOf('Y'), "cobblestone" })).setRegistryName(new ResourceLocation("manaita_plus", "easy_brewing_manaita")));
/*    */     } 
/*    */     
/* 41 */     if (Loader.isModLoaded("baubles")) {
/* 42 */       for (int i = 0; i < 8; i++) {
/* 43 */         ForgeRegistries.RECIPES.register((new ShapedOreRecipe(new ResourceLocation("manaita_plus", "ring_crafting_manaita"), new ItemStack(ManaitaPlusItemCore.ringCraftingManaita, 1, i), new Object[] { "XY", "YY", 
/* 44 */                 Character.valueOf('X'), new ItemStack(ManaitaPlusItemCore.portableCraftingManaita, 1, i), Character.valueOf('Y'), "gemDiamond" })).setRegistryName(new ResourceLocation("manaita_plus", "ring_crafting_manaita." + i)));
/*    */         
/* 46 */         ForgeRegistries.RECIPES.register((new ShapedOreRecipe(new ResourceLocation("manaita_plus", "ring_furnace_manaita"), new ItemStack(ManaitaPlusItemCore.ringFurnaceManaita, 1, i), new Object[] { "XY", "YY", 
/* 47 */                 Character.valueOf('X'), new ItemStack(ManaitaPlusItemCore.portableFurnaceManaita, 1, i), Character.valueOf('Y'), "gemDiamond" })).setRegistryName(new ResourceLocation("manaita_plus", "ring_furnace_manaita." + i)));
/*    */         
/* 49 */         ForgeRegistries.RECIPES.register((new ShapedOreRecipe(new ResourceLocation("manaita_plus", "ring_brewing_manaita"), new ItemStack(ManaitaPlusItemCore.ringBrewingManaita, 1, i), new Object[] { "XY", "YY", 
/* 50 */                 Character.valueOf('X'), new ItemStack(ManaitaPlusItemCore.portableBrewingManaita, 1, i), Character.valueOf('Y'), "gemDiamond" })).setRegistryName(new ResourceLocation("manaita_plus", "ring_brewing_manaita." + i)));
/*    */       } 
/*    */     }
/* 53 */     GameRegistry.addSmelting(new ItemStack(ManaitaPlusBlockCore.craftingManaita, 1, 32767), new ItemStack(ManaitaPlusItemCore.source_of_Manaita), 0.0F);
/*    */     
/* 55 */     GameRegistry.addSmelting(new ItemStack(ManaitaPlusBlockCore.furnaceManaita, 1, 32767), new ItemStack(ManaitaPlusItemCore.source_of_Manaita), 0.0F);
/*    */     
/* 57 */     GameRegistry.addSmelting(new ItemStack(ManaitaPlusBlockCore.brewingManaita, 1, 32767), new ItemStack(ManaitaPlusItemCore.source_of_Manaita), 0.0F);
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\core\ManaitaPlusRecipeCore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */