/*    */ package rikuto.manaita_plus.gui;
/*    */ 
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.EntityEquipmentSlot;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
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
/* 38 */     super(x0, x1, x2, x3);
/*    */   }
/*    */   public int func_75219_a() {
/* 41 */     return 1;
/*    */   }
/*    */   
/*    */   public boolean func_75214_a(ItemStack itemStack) {
/* 45 */     return itemStack.func_77973_b().isValidArmor(itemStack, slot, (Entity)player);
/*    */   }
/*    */   
/*    */   public boolean func_82869_a(EntityPlayer playerIn) {
/* 49 */     ItemStack itemStack = func_75211_c();
/* 50 */     return (!itemStack.func_190926_b() && !playerIn.func_184812_l_() && EnchantmentHelper.func_190938_b(itemStack)) ? false : super.func_82869_a(playerIn);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_178171_c() {
/* 55 */     return ItemArmor.field_94603_a[slot.func_188454_b()];
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\gui\ContainerConfig$2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */