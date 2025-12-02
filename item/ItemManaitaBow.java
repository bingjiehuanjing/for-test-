/*    */ package rikuto.manaita_plus.item;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.util.ITooltipFlag;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.SoundEvents;
/*    */ import net.minecraft.item.EnumAction;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ActionResult;
/*    */ import net.minecraft.util.EnumActionResult;
/*    */ import net.minecraft.util.EnumHand;
/*    */ import net.minecraft.util.SoundCategory;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import rikuto.manaita_plus.ManaitaPlus;
/*    */ import rikuto.manaita_plus.entity.EntityManaitaArrow;
/*    */ import rikuto.manaita_plus.util.ManaitaPlusUtils;
/*    */ 
/*    */ public class ItemManaitaBow
/*    */   extends Item implements IManaitaConfigurable {
/*    */   public ItemManaitaBow() {
/* 27 */     func_77625_d(1);
/* 28 */     func_77637_a(ManaitaPlus.tabManaitaPlus);
/*    */   }
/*    */   
/*    */   public EnumAction func_77661_b(ItemStack itemStack) {
/* 32 */     return EnumAction.BOW;
/*    */   }
/*    */   
/*    */   public ActionResult<ItemStack> func_77659_a(World world, EntityPlayer player, EnumHand hand) {
/* 36 */     ItemStack itemStack = player.func_184586_b(hand);
/* 37 */     if (!world.field_72995_K) {
/* 38 */       EntityManaitaArrow arrow = new EntityManaitaArrow(world, (EntityLivingBase)player, ManaitaPlusUtils.getEntityLooking((EntityLivingBase)player), itemStack);
/* 39 */       arrow.func_184547_a((Entity)player, player.field_70125_A, player.field_70177_z, 0.0F, 3.0F, 0.0F);
/* 40 */       world.func_72838_d((Entity)arrow);
/*    */     } 
/* 42 */     world.func_184148_a(null, player.field_70165_t, player.field_70163_u, player.field_70161_v, SoundEvents.field_187737_v, SoundCategory.PLAYERS, 1.0F, 1.0F / (field_77697_d.nextFloat() * 0.4F + 1.2F) + 0.5F);
/* 43 */     return new ActionResult(EnumActionResult.SUCCESS, itemStack);
/*    */   }
/*    */   
/*    */   public void func_77663_a(ItemStack itemStack, World world, Entity entity, int slot, boolean isHolding) {
/* 47 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/* 48 */     boolean editSilkTouch = itemStack.func_77942_o() ? itemStack.func_77978_p().func_74764_b(IManaitaConfigurable.EnumConfig.SILKTOUCH.func_176610_l()) : false;
/* 49 */     ManaitaPlusUtils.editEnchantment(itemStack, editSilkTouch);
/*    */   }
/*    */   
/*    */   public void setDamage(ItemStack itemStack, int damage) {
/* 53 */     super.setDamage(itemStack, 0);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77636_d(ItemStack itemStack) {
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_77624_a(ItemStack itemStack, World world, List<String> tooltip, ITooltipFlag flag) {
/* 63 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/* 64 */     ManaitaPlusUtils.addNBTInformation(getConfigs(), itemStack, tooltip);
/*    */   }
/*    */   
/*    */   public List<IManaitaConfigurable.EnumConfig> getConfigs() {
/* 68 */     return new ArrayList<IManaitaConfigurable.EnumConfig>() {
/*    */       
/*    */       };
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\item\ItemManaitaBow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */