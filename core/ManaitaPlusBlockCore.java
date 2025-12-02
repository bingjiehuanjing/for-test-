/*     */ package rikuto.manaita_plus.core;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.common.registry.ForgeRegistries;
/*     */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*     */ import rikuto.manaita_plus.block.BlockHook;
/*     */ import rikuto.manaita_plus.block.BlockManaita;
/*     */ import rikuto.manaita_plus.block.ItemBlockManaita;
/*     */ import rikuto.manaita_plus.tileentity.TileEntityHook;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ManaitaPlusBlockCore
/*     */ {
/*     */   public static Block craftingManaita;
/*     */   public static Block furnaceManaita;
/*     */   public static Block brewingManaita;
/*     */   public static Block hook;
/*     */   public static Block woodenFixedHook;
/*     */   public static Block stoneFixedHook;
/*     */   public static Block ironFixedHook;
/*     */   public static Block goldFixedHook;
/*     */   public static Block diamondFixedHook;
/*     */   public static Block emeraldFixedHook;
/*     */   public static Block redstoneFixedHook;
/*     */   
/*     */   public static void registerBlock() {
/*  33 */     craftingManaita = ((Block)(new BlockManaita()).setRegistryName(new ResourceLocation("manaita_plus", "crafting_manaita"))).func_149663_c("crafting_manaita");
/*  34 */     ForgeRegistries.BLOCKS.register((IForgeRegistryEntry)craftingManaita);
/*  35 */     ForgeRegistries.ITEMS.register((new ItemBlockManaita(craftingManaita)).setRegistryName(craftingManaita.func_149739_a()));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  40 */     furnaceManaita = ((Block)(new BlockManaita()).setRegistryName(new ResourceLocation("manaita_plus", "furnace_manaita"))).func_149663_c("furnace_manaita");
/*  41 */     ForgeRegistries.BLOCKS.register((IForgeRegistryEntry)furnaceManaita);
/*  42 */     ForgeRegistries.ITEMS.register((new ItemBlockManaita(furnaceManaita)).setRegistryName(furnaceManaita.func_149739_a()));
/*     */ 
/*     */ 
/*     */     
/*  46 */     brewingManaita = ((Block)(new BlockManaita()).setRegistryName(new ResourceLocation("manaita_plus", "brewing_manaita"))).func_149663_c("brewing_manaita");
/*  47 */     ForgeRegistries.BLOCKS.register((IForgeRegistryEntry)brewingManaita);
/*  48 */     ForgeRegistries.ITEMS.register((new ItemBlockManaita(brewingManaita)).setRegistryName(brewingManaita.func_149739_a()));
/*     */ 
/*     */ 
/*     */     
/*  52 */     hook = ((Block)(new BlockHook()).setRegistryName(new ResourceLocation("manaita_plus", "hook"))).func_149663_c("hook");
/*  53 */     registerBlockandItemBlock(hook);
/*  54 */     GameRegistry.registerTileEntity(TileEntityHook.class, "te_hook");
/*     */ 
/*     */ 
/*     */     
/*  58 */     woodenFixedHook = ((Block)(new BlockHook()).setRegistryName(new ResourceLocation("manaita_plus", "fixed_hook_wooden"))).func_149663_c("fixed_hook_wooden");
/*  59 */     registerBlockandItemBlock(woodenFixedHook);
/*     */ 
/*     */ 
/*     */     
/*  63 */     stoneFixedHook = ((Block)(new BlockHook()).setRegistryName(new ResourceLocation("manaita_plus", "fixed_hook_stone"))).func_149663_c("fixed_hook_stone");
/*  64 */     registerBlockandItemBlock(stoneFixedHook);
/*     */ 
/*     */ 
/*     */     
/*  68 */     ironFixedHook = ((Block)(new BlockHook()).setRegistryName(new ResourceLocation("manaita_plus", "fixed_hook_iron"))).func_149663_c("fixed_hook_iron");
/*  69 */     registerBlockandItemBlock(ironFixedHook);
/*     */ 
/*     */ 
/*     */     
/*  73 */     goldFixedHook = ((Block)(new BlockHook()).setRegistryName(new ResourceLocation("manaita_plus", "fixed_hook_gold"))).func_149663_c("fixed_hook_gold");
/*  74 */     registerBlockandItemBlock(goldFixedHook);
/*     */ 
/*     */ 
/*     */     
/*  78 */     diamondFixedHook = ((Block)(new BlockHook()).setRegistryName(new ResourceLocation("manaita_plus", "fixed_hook_diamond"))).func_149663_c("fixed_hook_diamond");
/*  79 */     registerBlockandItemBlock(diamondFixedHook);
/*     */ 
/*     */ 
/*     */     
/*  83 */     emeraldFixedHook = ((Block)(new BlockHook()).setRegistryName(new ResourceLocation("manaita_plus", "fixed_hook_emerald"))).func_149663_c("fixed_hook_emerald");
/*  84 */     registerBlockandItemBlock(emeraldFixedHook);
/*     */ 
/*     */ 
/*     */     
/*  88 */     redstoneFixedHook = ((Block)(new BlockHook()).setRegistryName(new ResourceLocation("manaita_plus", "fixed_hook_redstone"))).func_149663_c("fixed_hook_redstone");
/*  89 */     registerBlockandItemBlock(redstoneFixedHook);
/*     */   }
/*     */   
/*     */   private static void registerBlockandItemBlock(Block block) {
/*  93 */     ForgeRegistries.BLOCKS.register((IForgeRegistryEntry)block);
/*  94 */     ItemBlock itemBlock = new ItemBlock(block);
/*  95 */     itemBlock.setRegistryName(block.func_149739_a());
/*  96 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)itemBlock);
/*     */   }
/*     */   
/*     */   public static void registerOreDictionary() {
/* 100 */     OreDictionary.registerOre("manaita", new ItemStack(craftingManaita, 1, 32767));
/* 101 */     OreDictionary.registerOre("manaita", new ItemStack(furnaceManaita, 1, 32767));
/* 102 */     OreDictionary.registerOre("manaita", new ItemStack(brewingManaita, 1, 32767));
/* 103 */     OreDictionary.registerOre("manaitaHook", new ItemStack(hook, 1, 32767));
/* 104 */     OreDictionary.registerOre("manaitaHookWooden", new ItemStack(woodenFixedHook, 1, 32767));
/* 105 */     OreDictionary.registerOre("manaitaHookStone", new ItemStack(stoneFixedHook, 1, 32767));
/* 106 */     OreDictionary.registerOre("manaitaHookIron", new ItemStack(ironFixedHook, 1, 32767));
/* 107 */     OreDictionary.registerOre("manaitaHookGold", new ItemStack(goldFixedHook, 1, 32767));
/* 108 */     OreDictionary.registerOre("manaitaHookDiamond", new ItemStack(diamondFixedHook, 1, 32767));
/* 109 */     OreDictionary.registerOre("manaitaHookEmerald", new ItemStack(emeraldFixedHook, 1, 32767));
/* 110 */     OreDictionary.registerOre("manaitaHookRedstone", new ItemStack(redstoneFixedHook, 1, 32767));
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\core\ManaitaPlusBlockCore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */