/*     */ package rikuto.manaita_plus.item;
/*     */ 
/*     */ import com.google.common.collect.Collections2;
/*     */ import com.google.common.collect.HashMultimap;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Multimap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.util.ITooltipFlag;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.MobEffects;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.EnumHelper;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import rikuto.manaita_plus.ManaitaPlus;
/*     */ import rikuto.manaita_plus.util.ManaitaPlusUtils;
/*     */ 
/*     */ public class ItemManaitaArmor
/*     */   extends ItemArmor
/*     */   implements IManaitaConfigurable
/*     */ {
/*  30 */   public static final ItemArmor.ArmorMaterial MANAITA = EnumHelper.addArmorMaterial("manaita_armor", "", 2147483647, new int[] { 0, 0, 0, 0 }, 2147483647, SoundEvents.field_187722_q, 0.0F);
/*     */   
/*     */   public ItemManaitaArmor(EntityEquipmentSlot slot) {
/*  33 */     super(MANAITA, 0, slot);
/*  34 */     func_77637_a(ManaitaPlus.tabManaitaPlus);
/*     */   }
/*     */   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
/*     */     List<PotionEffect> potions;
/*  38 */     switch (this.field_77881_a) {
/*     */       case HEAD:
/*  40 */         player.func_70050_g(300);
/*  41 */         player.func_71024_bL().func_75122_a(20, 20.0F);
/*  42 */         if (player.func_184582_a(EntityEquipmentSlot.HEAD).func_77978_p().func_74767_n(IManaitaConfigurable.EnumConfig.NIGHT_VISION.func_176610_l()))
/*  43 */           player.func_70690_d(new PotionEffect(MobEffects.field_76439_r, 400, 0)); 
/*     */         break;
/*     */       case CHEST:
/*  46 */         potions = Lists.newArrayList(player.func_70651_bq());
/*  47 */         for (PotionEffect potion : Collections2.filter(potions, potion -> potion.func_188419_a().func_76398_f()))
/*  48 */           player.func_184589_d(potion.func_188419_a()); 
/*     */         break;
/*     */       case LEGS:
/*  51 */         if (player.func_70027_ad())
/*  52 */           player.func_70066_B(); 
/*  53 */         if (player.func_184582_a(EntityEquipmentSlot.LEGS).func_77978_p().func_74767_n(IManaitaConfigurable.EnumConfig.INVISIBILITY.func_176610_l()))
/*  54 */           player.func_70690_d(new PotionEffect(MobEffects.field_76441_p, 11, 0)); 
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
/*  60 */     return "manaita_plus:textures/models/armor/manaita_layer.png";
/*     */   }
/*     */   
/*     */   public void func_77663_a(ItemStack itemStack, World world, Entity entity, int slot, boolean isHolding) {
/*  64 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/*  65 */     boolean editSilkTouch = itemStack.func_77942_o() ? itemStack.func_77978_p().func_74764_b(IManaitaConfigurable.EnumConfig.SILKTOUCH.func_176610_l()) : false;
/*  66 */     ManaitaPlusUtils.editEnchantment(itemStack, editSilkTouch);
/*     */   }
/*     */   
/*     */   public void setDamage(ItemStack itemStack, int damage) {
/*  70 */     super.setDamage(itemStack, 0);
/*     */   }
/*     */   
/*     */   public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack itemStack) {
/*  74 */     return (Multimap<String, AttributeModifier>)HashMultimap.create();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77636_d(ItemStack itemStack) {
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack itemStack, World world, List<String> tooltip, ITooltipFlag flag) {
/*  84 */     ManaitaPlusUtils.setDefaultNBT(getConfigs(), itemStack);
/*  85 */     ManaitaPlusUtils.addNBTInformation(getConfigs(), itemStack, tooltip);
/*     */   }
/*     */   
/*     */   public List<IManaitaConfigurable.EnumConfig> getConfigs() {
/*  89 */     return new ArrayList<IManaitaConfigurable.EnumConfig>() {
/*     */       
/*     */       };
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\item\ItemManaitaArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */