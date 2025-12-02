/*    */ package rikuto.manaita_plus.item;
/*    */ 
/*    */ import net.minecraft.block.BlockDispenser;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.EnumAction;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ActionResult;
/*    */ import net.minecraft.util.EnumActionResult;
/*    */ import net.minecraft.util.EnumHand;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import rikuto.manaita_plus.ManaitaPlus;
/*    */ import rikuto.manaita_plus.util.ManaitaPlusUtils;
/*    */ 
/*    */ public class ItemManaitaShield extends Item {
/*    */   public ItemManaitaShield() {
/* 23 */     func_77625_d(1);
/* 24 */     func_77637_a(ManaitaPlus.tabManaitaPlus);
/* 25 */     func_77656_e(2147483647);
/*    */     
/* 27 */     func_185043_a(new ResourceLocation("blocking"), (itemStack, world, entity) -> 
/* 28 */         (entity != null && entity.func_184587_cr() && entity.func_184607_cu() == itemStack) ? 1.0F : 0.0F);
/* 29 */     BlockDispenser.field_149943_a.func_82595_a(this, ItemArmor.field_96605_cw);
/*    */   }
/*    */   
/*    */   public EnumAction func_77661_b(ItemStack itemStack) {
/* 33 */     return EnumAction.BLOCK;
/*    */   }
/*    */   
/*    */   public int func_77626_a(ItemStack itemStack) {
/* 37 */     return 72000;
/*    */   }
/*    */   
/*    */   public ActionResult<ItemStack> func_77659_a(World world, EntityPlayer player, EnumHand hand) {
/* 41 */     player.func_184598_c(hand);
/* 42 */     return new ActionResult(EnumActionResult.SUCCESS, player.func_184586_b(hand));
/*    */   }
/*    */   
/*    */   public void func_77663_a(ItemStack itemStack, World world, Entity entity, int slot, boolean isHolding) {
/* 46 */     ManaitaPlusUtils.editEnchantment(itemStack, false);
/*    */   }
/*    */   
/*    */   public void setDamage(ItemStack itemStack, int damage) {
/* 50 */     super.setDamage(itemStack, 0);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77636_d(ItemStack itemStack) {
/* 55 */     return false;
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\item\ItemManaitaShield.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */