/*    */ package rikuto.manaita_plus.gui;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import rikuto.manaita_plus.item.IManaitaConfigurable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Slot
/*    */ {
/*    */   null(IInventory x0, int x1, int x2, int x3) {
/* 27 */     super(x0, x1, x2, x3);
/*    */   } public boolean func_75214_a(ItemStack itemStack) {
/* 29 */     if (itemStack.func_77973_b() instanceof IManaitaConfigurable) {
/* 30 */       List<IManaitaConfigurable.EnumConfig> configs = ((IManaitaConfigurable)itemStack.func_77973_b()).getConfigs();
/* 31 */       return (configs != null && !configs.isEmpty());
/*    */     } 
/* 33 */     return false;
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\gui\ContainerConfig$1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */