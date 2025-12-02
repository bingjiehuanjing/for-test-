/*    */ package rikuto.manaita_plus.item;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.util.ITooltipFlag;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ItemSword;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.util.EnumHelper;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import rikuto.manaita_plus.ManaitaPlus;
/*    */ import rikuto.manaita_plus.util.ManaitaPlusUtils;
/*    */ 
/*    */ public class ItemManaitaSword
/*    */   extends ItemSword
/*    */   implements IManaitaConfigurable
/*    */ {
/* 22 */   public static final Item.ToolMaterial MANAITA = EnumHelper.addToolMaterial("manaita_tool", 2147483647, 2147483647, Float.MAX_VALUE, Float.MAX_VALUE, 2147483647);
/*    */   
/*    */   public ItemManaitaSword() {
/* 25 */     super(MANAITA);
/* 26 */     func_77637_a(ManaitaPlus.tabManaitaPlus);
/*    */   }
/*    */   
/*    */   public boolean func_77644_a(ItemStack itemStack, EntityLivingBase living, EntityLivingBase player) {
/* 30 */     if (player.field_70170_p.field_72995_K) {
/* 31 */       return true;
/*    */     }
/* 33 */     double area = (itemStack.func_77978_p().func_74762_e(IManaitaConfigurable.EnumConfig.ATTACK_AREA.func_176610_l()) - 1);
/* 34 */     List<Entity> entities = player.field_70170_p.func_72872_a(Entity.class, living.func_174813_aQ().func_186662_g(area));
/* 35 */     entities.remove(player);
/*    */     
/* 37 */     for (Entity entity : entities) {
/* 38 */       Entity target = ManaitaPlusUtils.getEntity(entity);
/*    */       
/* 40 */       if (target == null || (
/* 41 */         !living.equals(target) && !(target instanceof net.minecraft.entity.monster.IMob) && !itemStack.func_77978_p().func_74767_n(IManaitaConfigurable.EnumConfig.ATTACK_FRIENDLY_MOB.func_176610_l())))
/*    */         continue; 
/* 43 */       ManaitaPlusUtils.instantKill(entity, player);
/*    */     } 
/*    */     
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public void func_77663_a(ItemStack itemStack, World world, Entity entity, int slot, boolean isHolding) {
/* 50 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/* 51 */     boolean editSilkTouch = itemStack.func_77942_o() ? itemStack.func_77978_p().func_74764_b(IManaitaConfigurable.EnumConfig.SILKTOUCH.func_176610_l()) : false;
/* 52 */     ManaitaPlusUtils.editEnchantment(itemStack, editSilkTouch);
/*    */   }
/*    */   
/*    */   public void setDamage(ItemStack itemStack, int damage) {
/* 56 */     super.setDamage(itemStack, 0);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77636_d(ItemStack itemStack) {
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_77624_a(ItemStack itemStack, World world, List<String> tooltip, ITooltipFlag flag) {
/* 66 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/* 67 */     ManaitaPlusUtils.addNBTInformation(getConfigs(), itemStack, tooltip);
/*    */   }
/*    */   
/*    */   public List<IManaitaConfigurable.EnumConfig> getConfigs() {
/* 71 */     return new ArrayList<IManaitaConfigurable.EnumConfig>() {
/*    */       
/*    */       };
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\item\ItemManaitaSword.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */