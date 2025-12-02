/*    */ package rikuto.manaita_plus.item;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.util.ITooltipFlag;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Enchantments;
/*    */ import net.minecraft.item.ItemHoe;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.EnumActionResult;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.EnumHand;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.math.RayTraceResult;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import rikuto.manaita_plus.ManaitaPlus;
/*    */ import rikuto.manaita_plus.util.ManaitaPlusUtils;
/*    */ 
/*    */ public class ItemManaitaHoe
/*    */   extends ItemHoe
/*    */   implements IManaitaConfigurable
/*    */ {
/*    */   public ItemManaitaHoe() {
/* 33 */     super(ItemManaitaSword.MANAITA);
/* 34 */     func_77637_a(ManaitaPlus.tabManaitaPlus);
/*    */   }
/*    */   
/*    */   public EnumActionResult func_180614_a(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 38 */     boolean used = false;
/* 39 */     ItemStack itemStack = player.func_184586_b(hand);
/* 40 */     int range = itemStack.func_77978_p().func_74762_e(IManaitaConfigurable.EnumConfig.DIG_RANGE.func_176610_l()) - 1;
/* 41 */     int x_start = pos.func_177958_n() - range;
/* 42 */     int z_start = pos.func_177952_p() - range;
/* 43 */     for (int i = 0; i <= range * 2; i++) {
/* 44 */       for (int j = 0; j <= range * 2; j++) {
/* 45 */         BlockPos currentPos = new BlockPos(x_start + i, pos.func_177956_o(), z_start + j);
/* 46 */         switch (super.func_180614_a(player, world, currentPos, hand, facing, hitX, hitY, hitZ)) {
/*    */           case PASS:
/* 48 */             if (ManaitaPlusUtils.farm(world, player, currentPos))
/* 49 */               used = true; 
/*    */             break;
/*    */           case SUCCESS:
/* 52 */             used = true;
/*    */             break;
/*    */         } 
/*    */       } 
/*    */     } 
/* 57 */     return used ? EnumActionResult.SUCCESS : EnumActionResult.PASS;
/*    */   }
/*    */   
/*    */   public boolean func_179218_a(ItemStack itemStack, World world, IBlockState state, BlockPos pos, EntityLivingBase living) {
/* 61 */     if (living != null && living instanceof EntityPlayer && !world.field_72995_K) {
/* 62 */       EntityPlayer player = (EntityPlayer)living;
/* 63 */       NBTTagCompound nbt = player.func_184614_ca().func_77978_p();
/* 64 */       int range = nbt.func_74762_e(IManaitaConfigurable.EnumConfig.DIG_RANGE.func_176610_l()) - 1;
/* 65 */       RayTraceResult traceResult = func_77621_a(world, player, false);
/* 66 */       if (traceResult != null)
/* 67 */         ManaitaPlusUtils.digArea(world, player, pos, traceResult, range, 0, true, Sets.newHashSet((Object[])new Material[] { Material.field_151585_k, Material.field_151582_l })); 
/*    */     } 
/* 69 */     return true;
/*    */   }
/*    */   
/*    */   public void func_77663_a(ItemStack itemStack, World world, Entity entity, int slot, boolean isHolding) {
/* 73 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/* 74 */     boolean editSilkTouch = itemStack.func_77942_o() ? itemStack.func_77978_p().func_74764_b(IManaitaConfigurable.EnumConfig.SILKTOUCH.func_176610_l()) : false;
/* 75 */     ManaitaPlusUtils.editEnchantment(itemStack, editSilkTouch);
/*    */     
/* 77 */     if (EnchantmentHelper.func_77506_a(Enchantments.field_185308_t, itemStack) < 10)
/* 78 */       itemStack.func_77966_a(Enchantments.field_185308_t, 10); 
/*    */   }
/*    */   
/*    */   public void setDamage(ItemStack itemStack, int damage) {
/* 82 */     super.setDamage(itemStack, 0);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77636_d(ItemStack itemStack) {
/* 87 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_77624_a(ItemStack itemStack, World world, List<String> tooltip, ITooltipFlag flag) {
/* 92 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/* 93 */     ManaitaPlusUtils.addNBTInformation(getConfigs(), itemStack, tooltip);
/*    */   }
/*    */   
/*    */   public List<IManaitaConfigurable.EnumConfig> getConfigs() {
/* 97 */     return new ArrayList<IManaitaConfigurable.EnumConfig>() {
/*    */       
/*    */       };
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\item\ItemManaitaHoe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */