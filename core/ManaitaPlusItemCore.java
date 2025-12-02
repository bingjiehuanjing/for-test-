/*     */ package rikuto.manaita_plus.core;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.util.ITooltipFlag;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.Loader;
/*     */ import net.minecraftforge.fml.common.registry.ForgeRegistries;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*     */ import rikuto.manaita_plus.ManaitaPlus;
/*     */ import rikuto.manaita_plus.item.ItemManaitaArmor;
/*     */ import rikuto.manaita_plus.item.ItemManaitaAxe;
/*     */ import rikuto.manaita_plus.item.ItemManaitaBow;
/*     */ import rikuto.manaita_plus.item.ItemManaitaHoe;
/*     */ import rikuto.manaita_plus.item.ItemManaitaPaxel;
/*     */ import rikuto.manaita_plus.item.ItemManaitaPickaxe;
/*     */ import rikuto.manaita_plus.item.ItemManaitaShield;
/*     */ import rikuto.manaita_plus.item.ItemManaitaShovel;
/*     */ import rikuto.manaita_plus.item.ItemManaitaSword;
/*     */ import rikuto.manaita_plus.item.ItemPortableManaita;
/*     */ import rikuto.manaita_plus.item.ItemRingManaita;
/*     */ import rikuto.manaita_plus.util.ManaitaPlusText;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ManaitaPlusItemCore
/*     */ {
/*     */   public static Item portableCraftingManaita;
/*     */   public static Item portableFurnaceManaita;
/*     */   public static Item portableBrewingManaita;
/*     */   public static Item ringCraftingManaita;
/*     */   public static Item ringFurnaceManaita;
/*     */   public static Item ringBrewingManaita;
/*     */   public static Item swordManaita;
/*     */   public static Item shovelManaita;
/*     */   public static Item pickaxeManaita;
/*     */   public static Item axeManaita;
/*     */   public static Item hoeManaita;
/*     */   public static Item paxelManaita;
/*     */   public static Item bowManaita;
/*     */   public static Item helmetManaita;
/*     */   public static Item chestplateManaita;
/*     */   public static Item leggingsManaita;
/*     */   public static Item bootsManaita;
/*     */   public static Item shieldManaita;
/*     */   public static Item source_of_Manaita;
/*     */   
/*     */   public static void registerItem() {
/*  55 */     portableCraftingManaita = (Item)(new ItemPortableManaita(1)).func_77655_b("portable_crafting_manaita").setRegistryName(new ResourceLocation("manaita_plus", "portable_crafting_manaita"));
/*  56 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)portableCraftingManaita);
/*     */ 
/*     */ 
/*     */     
/*  60 */     portableFurnaceManaita = (Item)(new ItemPortableManaita(2)).func_77655_b("portable_furnace_manaita").setRegistryName(new ResourceLocation("manaita_plus", "portable_furnace_manaita"));
/*  61 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)portableFurnaceManaita);
/*     */ 
/*     */ 
/*     */     
/*  65 */     portableBrewingManaita = (Item)(new ItemPortableManaita(3)).func_77655_b("portable_brewing_manaita").setRegistryName(new ResourceLocation("manaita_plus", "portable_brewing_manaita"));
/*  66 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)portableBrewingManaita);
/*     */     
/*  68 */     if (Loader.isModLoaded("baubles")) {
/*     */ 
/*     */       
/*  71 */       ringCraftingManaita = (Item)(new ItemRingManaita(1)).func_77655_b("ring_crafting_manaita").setRegistryName(new ResourceLocation("manaita_plus", "ring_crafting_manaita"));
/*  72 */       ForgeRegistries.ITEMS.register((IForgeRegistryEntry)ringCraftingManaita);
/*     */ 
/*     */ 
/*     */       
/*  76 */       ringFurnaceManaita = (Item)(new ItemRingManaita(2)).func_77655_b("ring_furnace_manaita").setRegistryName(new ResourceLocation("manaita_plus", "ring_furnace_manaita"));
/*  77 */       ForgeRegistries.ITEMS.register((IForgeRegistryEntry)ringFurnaceManaita);
/*     */ 
/*     */ 
/*     */       
/*  81 */       ringBrewingManaita = (Item)(new ItemRingManaita(3)).func_77655_b("ring_brewing_manaita").setRegistryName(new ResourceLocation("manaita_plus", "ring_brewing_manaita"));
/*  82 */       ForgeRegistries.ITEMS.register((IForgeRegistryEntry)ringBrewingManaita);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  87 */     swordManaita = (Item)(new ItemManaitaSword()).func_77655_b("manaita_sword").setRegistryName(new ResourceLocation("manaita_plus", "manaita_sword"));
/*  88 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)swordManaita);
/*     */ 
/*     */ 
/*     */     
/*  92 */     shovelManaita = (Item)(new ItemManaitaShovel()).func_77655_b("manaita_shovel").setRegistryName(new ResourceLocation("manaita_plus", "manaita_shovel"));
/*  93 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)shovelManaita);
/*     */ 
/*     */ 
/*     */     
/*  97 */     pickaxeManaita = (Item)(new ItemManaitaPickaxe()).func_77655_b("manaita_pickaxe").setRegistryName(new ResourceLocation("manaita_plus", "manaita_pickaxe"));
/*  98 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)pickaxeManaita);
/*     */ 
/*     */ 
/*     */     
/* 102 */     axeManaita = (Item)(new ItemManaitaAxe()).func_77655_b("manaita_axe").setRegistryName(new ResourceLocation("manaita_plus", "manaita_axe"));
/* 103 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)axeManaita);
/*     */ 
/*     */ 
/*     */     
/* 107 */     hoeManaita = (Item)(new ItemManaitaHoe()).func_77655_b("manaita_hoe").setRegistryName(new ResourceLocation("manaita_plus", "manaita_hoe"));
/* 108 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)hoeManaita);
/*     */ 
/*     */ 
/*     */     
/* 112 */     paxelManaita = (Item)(new ItemManaitaPaxel()).func_77655_b("manaita_paxel").setRegistryName(new ResourceLocation("manaita_plus", "manaita_paxel"));
/* 113 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)paxelManaita);
/*     */ 
/*     */ 
/*     */     
/* 117 */     bowManaita = (Item)(new ItemManaitaBow()).func_77655_b("manaita_bow").setRegistryName(new ResourceLocation("manaita_plus", "manaita_bow"));
/* 118 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)bowManaita);
/*     */ 
/*     */ 
/*     */     
/* 122 */     helmetManaita = (Item)(new ItemManaitaArmor(EntityEquipmentSlot.HEAD)).func_77655_b("manaita_helmet").setRegistryName(new ResourceLocation("manaita_plus", "manaita_helmet"));
/* 123 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)helmetManaita);
/*     */ 
/*     */ 
/*     */     
/* 127 */     chestplateManaita = (Item)(new ItemManaitaArmor(EntityEquipmentSlot.CHEST)).func_77655_b("manaita_chestplate").setRegistryName(new ResourceLocation("manaita_plus", "manaita_chestplate"));
/* 128 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)chestplateManaita);
/*     */ 
/*     */ 
/*     */     
/* 132 */     leggingsManaita = (Item)(new ItemManaitaArmor(EntityEquipmentSlot.LEGS)).func_77655_b("manaita_leggings").setRegistryName(new ResourceLocation("manaita_plus", "manaita_leggings"));
/* 133 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)leggingsManaita);
/*     */ 
/*     */ 
/*     */     
/* 137 */     bootsManaita = (Item)(new ItemManaitaArmor(EntityEquipmentSlot.FEET)).func_77655_b("manaita_boots").setRegistryName(new ResourceLocation("manaita_plus", "manaita_boots"));
/* 138 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)bootsManaita);
/*     */ 
/*     */ 
/*     */     
/* 142 */     shieldManaita = (Item)(new ItemManaitaShield()).func_77655_b("manaita_shield").setRegistryName(new ResourceLocation("manaita_plus", "manaita_shield"));
/* 143 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)shieldManaita);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 159 */     source_of_Manaita = (Item)(new Item() { @SideOnly(Side.CLIENT) public boolean func_77636_d(ItemStack itemStack) { return true; } @SideOnly(Side.CLIENT) public void func_77624_a(ItemStack itemStack, World world, List<String> tooltip, ITooltipFlag flag) { tooltip.add(ManaitaPlusText.makeInfinityText(I18n.func_135052_a("manaita.source", new Object[0]))); } }).func_77637_a(ManaitaPlus.tabManaitaPlus).func_77655_b("source_of_manaita").setRegistryName(new ResourceLocation("manaita_plus", "source_of_manaita"));
/* 160 */     ForgeRegistries.ITEMS.register((IForgeRegistryEntry)source_of_Manaita);
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\core\ManaitaPlusItemCore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */