/*     */ package rikuto.manaita_plus.gui;
/*     */ 
/*     */ import net.minecraft.advancements.CriteriaTriggers;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.PotionType;
/*     */ import net.minecraft.potion.PotionUtils;
/*     */ import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
/*     */ import net.minecraftforge.event.ForgeEventFactory;
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
/*     */ class Potion
/*     */   extends Slot
/*     */ {
/*     */   public Potion(IInventory inventory, int index, int xPosition, int yPosition) {
/* 182 */     super(inventory, index, xPosition, yPosition);
/*     */   }
/*     */   
/*     */   public boolean func_75214_a(ItemStack itemStack) {
/* 186 */     return canHoldPotion(itemStack);
/*     */   }
/*     */   
/*     */   public ItemStack func_190901_a(EntityPlayer player, ItemStack itemStack) {
/* 190 */     PotionType potionType = PotionUtils.func_185191_c(itemStack);
/* 191 */     if (player instanceof EntityPlayerMP) {
/* 192 */       ForgeEventFactory.onPlayerBrewedPotion(player, itemStack);
/* 193 */       CriteriaTriggers.field_192130_j.func_192173_a((EntityPlayerMP)player, potionType);
/*     */     } 
/* 195 */     super.func_190901_a(player, itemStack);
/* 196 */     return itemStack;
/*     */   }
/*     */   
/*     */   public static boolean canHoldPotion(ItemStack itemStack) {
/* 200 */     ItemStack potion = itemStack.func_77946_l();
/* 201 */     potion.func_190920_e(1);
/* 202 */     return BrewingRecipeRegistry.isValidInput(potion);
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\gui\ContainerBrewingManaita$Potion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */