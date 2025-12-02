/*    */ package rikuto.manaita_plus.recipe;
/*    */ 
/*    */ import net.minecraft.inventory.InventoryCrafting;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.crafting.IRecipe;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.registries.IForgeRegistryEntry;
/*    */ import rikuto.manaita_plus.core.ManaitaPlusConfigCore;
/*    */ import rikuto.manaita_plus.core.ManaitaPlusItemCore;
/*    */ 
/*    */ public class ManaitaSourceRecipe
/*    */   extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {
/*    */   public boolean func_192399_d() {
/* 14 */     return true;
/*    */   }
/*    */   
/*    */   public boolean func_77569_a(InventoryCrafting inventoryCrafting, World world) {
/* 18 */     boolean source = false;
/* 19 */     boolean item = false;
/* 20 */     for (int i = 0; i < inventoryCrafting.func_70302_i_(); i++) {
/* 21 */       ItemStack itemStack = inventoryCrafting.func_70301_a(i);
/* 22 */       if (!itemStack.func_190926_b())
/* 23 */         if (itemStack.func_77973_b() == ManaitaPlusItemCore.source_of_Manaita) {
/* 24 */           if (!source)
/* 25 */           { source = true; }
/* 26 */           else if (!item)
/* 27 */           { item = true; }
/*    */           else
/* 29 */           { return false; } 
/* 30 */         } else if (!item) {
/* 31 */           item = true;
/*    */         } else {
/* 33 */           return false;
/*    */         }  
/*    */     } 
/* 36 */     return (source && item);
/*    */   }
/*    */   
/*    */   public ItemStack func_77572_b(InventoryCrafting inventoryCrafting) {
/* 40 */     ItemStack itemStack = ItemStack.field_190927_a;
/* 41 */     int source = 0;
/* 42 */     for (int i = 0; i < inventoryCrafting.func_70302_i_(); i++) {
/* 43 */       ItemStack itemStackInSlot = inventoryCrafting.func_70301_a(i);
/* 44 */       if (!itemStackInSlot.func_190926_b() && itemStackInSlot.func_77973_b() != ManaitaPlusItemCore.source_of_Manaita)
/* 45 */         itemStack = itemStackInSlot; 
/* 46 */       if (!itemStackInSlot.func_190926_b() && itemStackInSlot.func_77973_b() == ManaitaPlusItemCore.source_of_Manaita)
/* 47 */         source++; 
/*    */     } 
/* 49 */     if (source == 2) {
/* 50 */       ItemStack itemStack1 = new ItemStack(ManaitaPlusItemCore.source_of_Manaita);
/* 51 */       itemStack1.func_190920_e(ManaitaPlusConfigCore.sourceDoubling);
/* 52 */       return itemStack1;
/*    */     } 
/* 54 */     if (itemStack.func_190926_b())
/* 55 */       return ItemStack.field_190927_a; 
/* 56 */     ItemStack result = itemStack.func_77946_l();
/* 57 */     result.func_190920_e(ManaitaPlusConfigCore.sourceDoubling);
/* 58 */     return result;
/*    */   }
/*    */   
/*    */   public boolean func_194133_a(int width, int height) {
/* 62 */     return (width * height >= 2);
/*    */   }
/*    */   
/*    */   public ItemStack func_77571_b() {
/* 66 */     return ItemStack.field_190927_a;
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\recipe\ManaitaSourceRecipe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */