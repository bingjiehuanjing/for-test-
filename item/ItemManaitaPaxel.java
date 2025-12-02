/*     */ package rikuto.manaita_plus.item;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.util.ITooltipFlag;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemTool;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import rikuto.manaita_plus.ManaitaPlus;
/*     */ import rikuto.manaita_plus.util.ManaitaPlusUtils;
/*     */ 
/*     */ public class ItemManaitaPaxel
/*     */   extends ItemTool
/*     */   implements IManaitaConfigurable
/*     */ {
/*     */   public ItemManaitaPaxel() {
/*  26 */     super(ItemManaitaSword.MANAITA, null);
/*  27 */     func_77637_a(ManaitaPlus.tabManaitaPlus);
/*     */   }
/*     */   
/*     */   public boolean func_77644_a(ItemStack itemStack, EntityLivingBase living, EntityLivingBase player) {
/*  31 */     if (player.field_70170_p.field_72995_K) {
/*  32 */       return true;
/*     */     }
/*  34 */     double area = (itemStack.func_77978_p().func_74762_e(IManaitaConfigurable.EnumConfig.ATTACK_AREA.func_176610_l()) - 1);
/*  35 */     List<Entity> entities = player.field_70170_p.func_72872_a(Entity.class, living.func_174813_aQ().func_186662_g(area));
/*  36 */     entities.remove(player);
/*     */     
/*  38 */     for (Entity entity : entities) {
/*  39 */       Entity target = ManaitaPlusUtils.getEntity(entity);
/*     */       
/*  41 */       if (target == null || (
/*  42 */         !living.equals(target) && !(target instanceof net.minecraft.entity.monster.IMob) && !itemStack.func_77978_p().func_74767_n(IManaitaConfigurable.EnumConfig.ATTACK_FRIENDLY_MOB.func_176610_l())))
/*     */         continue; 
/*  44 */       ManaitaPlusUtils.instantKill(entity, player);
/*     */     } 
/*     */     
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public float func_150893_a(ItemStack itemStack, IBlockState state) {
/*  51 */     return itemStack.func_77978_p().func_74767_n(IManaitaConfigurable.EnumConfig.CAN_HARVEST.func_176610_l()) ? this.field_77864_a : 0.0F;
/*     */   }
/*     */   
/*     */   public boolean func_150897_b(IBlockState state) {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_179218_a(ItemStack itemStack, World world, IBlockState state, BlockPos pos, EntityLivingBase living) {
/*  59 */     if (living != null && living instanceof EntityPlayer && !world.field_72995_K) {
/*  60 */       EntityPlayer player = (EntityPlayer)living;
/*  61 */       NBTTagCompound nbt = player.func_184614_ca().func_77978_p();
/*  62 */       int range = nbt.func_74762_e(IManaitaConfigurable.EnumConfig.DIG_RANGE.func_176610_l()) - 1;
/*  63 */       int depth = nbt.func_74762_e(IManaitaConfigurable.EnumConfig.DIG_DEPTH.func_176610_l()) - 1;
/*  64 */       boolean digUnderPlayer = nbt.func_74767_n(IManaitaConfigurable.EnumConfig.DIG_UNDER_PLAYER.func_176610_l());
/*  65 */       RayTraceResult traceResult = func_77621_a(world, player, false);
/*  66 */       if (traceResult != null)
/*  67 */         ManaitaPlusUtils.digArea(world, player, pos, traceResult, range, depth, digUnderPlayer, null); 
/*     */     } 
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   public void func_77663_a(ItemStack itemStack, World world, Entity entity, int slot, boolean isHolding) {
/*  73 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/*  74 */     boolean editSilkTouch = itemStack.func_77942_o() ? itemStack.func_77978_p().func_74764_b(IManaitaConfigurable.EnumConfig.SILKTOUCH.func_176610_l()) : false;
/*  75 */     ManaitaPlusUtils.editEnchantment(itemStack, editSilkTouch);
/*     */   }
/*     */   
/*     */   public void setDamage(ItemStack itemStack, int damage) {
/*  79 */     super.setDamage(itemStack, 0);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77636_d(ItemStack itemStack) {
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack itemStack, World world, List<String> tooltip, ITooltipFlag flag) {
/*  89 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/*  90 */     ManaitaPlusUtils.addNBTInformation(getConfigs(), itemStack, tooltip);
/*     */   }
/*     */   
/*     */   public List<IManaitaConfigurable.EnumConfig> getConfigs() {
/*  94 */     return new ArrayList<IManaitaConfigurable.EnumConfig>() {
/*     */       
/*     */       };
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\item\ItemManaitaPaxel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */