/*    */ package rikuto.manaita_plus.item;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.util.ITooltipFlag;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemAxe;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.math.RayTraceResult;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import rikuto.manaita_plus.ManaitaPlus;
/*    */ import rikuto.manaita_plus.util.ManaitaPlusUtils;
/*    */ 
/*    */ public class ItemManaitaAxe
/*    */   extends ItemAxe
/*    */   implements IManaitaConfigurable
/*    */ {
/* 28 */   public static final Set<Material> MATERIALS = Sets.newHashSet((Object[])new Material[] { Material.field_151575_d, Material.field_151584_j, Material.field_151585_k, Material.field_151582_l, Material.field_151589_v });
/*    */   
/*    */   public ItemManaitaAxe() {
/* 31 */     super(ItemManaitaSword.MANAITA, Float.MAX_VALUE, -3.0F);
/* 32 */     func_77637_a(ManaitaPlus.tabManaitaPlus);
/*    */   }
/*    */   
/*    */   public float func_150893_a(ItemStack itemStack, IBlockState state) {
/* 36 */     if (!itemStack.func_77978_p().func_74767_n(IManaitaConfigurable.EnumConfig.CAN_HARVEST.func_176610_l()))
/* 37 */       return 0.0F; 
/* 38 */     for (String type : getToolClasses(itemStack)) {
/* 39 */       if (state.func_177230_c().isToolEffective(type, state))
/* 40 */         return this.field_77864_a; 
/* 41 */     }  return super.func_150893_a(itemStack, state);
/*    */   }
/*    */   
/*    */   public boolean func_179218_a(ItemStack itemStack, World world, IBlockState state, BlockPos pos, EntityLivingBase living) {
/* 45 */     if (living != null && living instanceof EntityPlayer && !world.field_72995_K) {
/* 46 */       EntityPlayer player = (EntityPlayer)living;
/* 47 */       NBTTagCompound nbt = player.func_184614_ca().func_77978_p();
/* 48 */       int range = nbt.func_74762_e(IManaitaConfigurable.EnumConfig.DIG_RANGE.func_176610_l()) - 1;
/* 49 */       int depth = nbt.func_74762_e(IManaitaConfigurable.EnumConfig.DIG_DEPTH.func_176610_l()) - 1;
/* 50 */       RayTraceResult traceResult = func_77621_a(world, player, false);
/* 51 */       if (traceResult != null)
/* 52 */         ManaitaPlusUtils.digArea(world, player, pos, traceResult, range, depth, true, MATERIALS); 
/*    */     } 
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   public void func_77663_a(ItemStack itemStack, World world, Entity entity, int slot, boolean isHolding) {
/* 58 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/* 59 */     boolean editSilkTouch = itemStack.func_77942_o() ? itemStack.func_77978_p().func_74764_b(IManaitaConfigurable.EnumConfig.SILKTOUCH.func_176610_l()) : false;
/* 60 */     ManaitaPlusUtils.editEnchantment(itemStack, editSilkTouch);
/*    */   }
/*    */   
/*    */   public void setDamage(ItemStack itemStack, int damage) {
/* 64 */     super.setDamage(itemStack, 0);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77636_d(ItemStack itemStack) {
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_77624_a(ItemStack itemStack, World world, List<String> tooltip, ITooltipFlag flag) {
/* 74 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/* 75 */     ManaitaPlusUtils.addNBTInformation(getConfigs(), itemStack, tooltip);
/*    */   }
/*    */   
/*    */   public List<IManaitaConfigurable.EnumConfig> getConfigs() {
/* 79 */     return new ArrayList<IManaitaConfigurable.EnumConfig>() {
/*    */       
/*    */       };
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\item\ItemManaitaAxe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */