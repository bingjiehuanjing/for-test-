/*     */ package rikuto.manaita_plus.util;
/*     */ 
/*     */ import com.google.common.base.Predicate;
/*     */ import com.google.common.base.Predicates;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.IGrowable;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.MultiPartEntityPart;
/*     */ import net.minecraft.entity.ai.attributes.RangedAttribute;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Enchantments;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EntityDamageSource;
/*     */ import net.minecraft.util.EntitySelectors;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IPlantable;
/*     */ import net.minecraftforge.fml.client.FMLClientHandler;
/*     */ import rikuto.manaita_plus.handler.ManaitaPlusEventHandler;
/*     */ import rikuto.manaita_plus.item.IManaitaConfigurable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ManaitaPlusUtils
/*     */ {
/*     */   public static Field recentlyHit;
/*     */   
/*     */   static {
/*     */     try {
/*  53 */       recentlyHit = EntityLivingBase.class.getDeclaredField("recentlyHit");
/*     */     }
/*  55 */     catch (Exception exception) {}
/*     */   }
/*     */   
/*     */   public static void instantKill(Entity entity, EntityLivingBase player) {
/*  59 */     EntityDamageSource entityDamageSource = new EntityDamageSource("player", (Entity)player);
/*  60 */     entity.field_70172_ad = 0;
/*  61 */     entity.func_70097_a((DamageSource)entityDamageSource, 0.0F);
/*     */     
/*  63 */     if (entity instanceof MultiPartEntityPart) {
/*  64 */       Entity entityMulti = (Entity)((MultiPartEntityPart)entity).field_70259_a;
/*  65 */       if (entityMulti != null && entityMulti instanceof EntityLivingBase) {
/*  66 */         entity = entityMulti;
/*     */       }
/*     */     } 
/*  69 */     if (entity instanceof EntityLivingBase) {
/*  70 */       EntityLivingBase living = (EntityLivingBase)entity;
/*  71 */       if (player.field_70170_p.field_72995_K) {
/*     */         return;
/*     */       }
/*  74 */       if (living != null && !living.field_70128_L && living.func_110143_aJ() > 0.0F) {
/*     */         try {
/*  76 */           recentlyHit.setInt(living, 60);
/*     */         }
/*  78 */         catch (Exception exception) {}
/*     */         
/*  80 */         living.func_110142_aN().func_94547_a((DamageSource)entityDamageSource, living.func_110143_aJ(), living.func_110143_aJ());
/*  81 */         living.func_70606_j(0.0F);
/*  82 */         living.func_70645_a((DamageSource)entityDamageSource);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public static void digArea(World world, EntityPlayer player, BlockPos pos, RayTraceResult traceResult, int range, int depth, boolean digUnderPlayer, Set<Material> materials) {
/*     */     BlockPos startPos, endPos;
/*  88 */     EnumFacing facing = traceResult.field_178784_b;
/*     */ 
/*     */ 
/*     */     
/*  92 */     switch (facing) {
/*     */       case DOWN:
/*  94 */         startPos = pos.func_177982_a(-range, 0, -range);
/*  95 */         endPos = pos.func_177982_a(range, depth, range);
/*     */         break;
/*     */       case UP:
/*  98 */         startPos = pos.func_177982_a(-range, -depth, -range);
/*  99 */         endPos = pos.func_177982_a(range, 0, range);
/*     */         break;
/*     */       case NORTH:
/* 102 */         startPos = pos.func_177982_a(-range, -range, 0);
/* 103 */         endPos = pos.func_177982_a(range, range, depth);
/*     */         break;
/*     */       case SOUTH:
/* 106 */         startPos = pos.func_177982_a(-range, -range, -depth);
/* 107 */         endPos = pos.func_177982_a(range, range, 0);
/*     */         break;
/*     */       case EAST:
/* 110 */         startPos = pos.func_177982_a(-depth, -range, -range);
/* 111 */         endPos = pos.func_177982_a(0, range, range);
/*     */         break;
/*     */       
/*     */       default:
/* 115 */         startPos = pos.func_177982_a(0, -range, -range);
/* 116 */         endPos = pos.func_177982_a(depth, range, range);
/*     */         break;
/*     */     } 
/* 119 */     if (!digUnderPlayer && facing != EnumFacing.UP && startPos.func_177956_o() < player.func_180425_c().func_177956_o()) {
/* 120 */       endPos = endPos.func_177982_a(0, player.func_180425_c().func_177956_o() - startPos.func_177956_o(), 0);
/* 121 */       startPos = startPos.func_177982_a(0, player.func_180425_c().func_177956_o() - startPos.func_177956_o(), 0);
/*     */     } 
/*     */     
/* 124 */     ManaitaPlusEventHandler.startItemCapture();
/*     */     
/* 126 */     for (int i = startPos.func_177958_n(); i <= endPos.func_177958_n(); i++) {
/* 127 */       for (int j = startPos.func_177956_o(); j <= endPos.func_177956_o(); j++) {
/* 128 */         for (int k = startPos.func_177952_p(); k <= endPos.func_177952_p(); k++) {
/* 129 */           BlockPos currentPos = new BlockPos(i, j, k);
/* 130 */           IBlockState currentState = world.func_180495_p(currentPos);
/*     */           
/* 132 */           if (materials == null || materials.isEmpty() || materials.contains(currentState.func_185904_a())) {
/*     */ 
/*     */             
/* 135 */             Block currentBlock = currentState.func_177230_c();
/*     */             
/* 137 */             currentBlock.func_176208_a(world, currentPos, currentState, player);
/* 138 */             if (currentBlock.removedByPlayer(currentState, world, currentPos, player, true)) {
/* 139 */               currentBlock.func_176206_d(world, currentPos, currentState);
/* 140 */               currentBlock.func_180657_a(world, player, currentPos, currentState, world.func_175625_s(currentPos), player.func_184614_ca());
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 146 */     ManaitaPlusEventHandler.stopItemCapture();
/* 147 */     List<ItemStack> drops = ManaitaPlusEventHandler.getCapturedDrops();
/* 148 */     compactItemList(drops);
/*     */     
/* 150 */     for (ItemStack drop : drops)
/* 151 */       world.func_72838_d((Entity)new EntityItem(world, player.field_70165_t, player.field_70163_u, player.field_70161_v, drop)); 
/*     */   }
/*     */   
/*     */   public static void compactItemList(List<ItemStack> list) {
/* 155 */     if (list == null || list.isEmpty())
/*     */       return; 
/* 157 */     for (int i = 0; i < list.size(); i++) {
/* 158 */       ItemStack itemStack = list.get(i);
/* 159 */       if (!itemStack.func_190926_b())
/* 160 */         for (int j = i + 1; j < list.size(); j++) {
/* 161 */           ItemStack other = list.get(j);
/* 162 */           if (itemStack.func_77969_a(other)) {
/* 163 */             itemStack.func_190917_f(other.func_190916_E());
/* 164 */             list.set(j, ItemStack.field_190927_a);
/*     */           } 
/*     */         }  
/*     */     } 
/* 168 */     list.removeIf(ItemStack::func_190926_b);
/*     */   }
/*     */   
/*     */   public static boolean farm(World world, EntityPlayer player, BlockPos pos) {
/* 172 */     IBlockState state = world.func_180495_p(pos);
/* 173 */     List<ItemStack> plants = searchPlant(player);
/* 174 */     if (state.func_177230_c() instanceof IGrowable) {
/* 175 */       IGrowable target = (IGrowable)state.func_177230_c();
/* 176 */       if (target.func_176473_a(world, pos, state, world.field_72995_K)) {
/* 177 */         if (!world.field_72995_K) {
/* 178 */           if (target.func_180670_a(world, world.field_73012_v, pos, state))
/* 179 */             target.func_176474_b(world, world.field_73012_v, pos, state); 
/* 180 */           world.func_175718_b(2005, pos, 0);
/*     */         } 
/* 182 */         return true;
/*     */       }
/*     */     
/* 185 */     } else if (plants != null && !plants.isEmpty()) {
/* 186 */       ItemStack itemStack = plants.get(0);
/* 187 */       if (!itemStack.func_190926_b()) {
/* 188 */         IPlantable plant = (IPlantable)itemStack.func_77973_b();
/* 189 */         if (player.func_175151_a(pos.func_177972_a(EnumFacing.UP), EnumFacing.UP, itemStack) && state.func_177230_c().canSustainPlant(state, (IBlockAccess)world, pos, EnumFacing.UP, plant) && world.func_175623_d(pos.func_177984_a())) {
/* 190 */           world.func_180501_a(pos.func_177984_a(), plant.getPlant((IBlockAccess)world, pos), 11);
/* 191 */           itemStack.func_190918_g(1);
/* 192 */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 196 */     return false;
/*     */   }
/*     */   
/*     */   private static List<ItemStack> searchPlant(EntityPlayer player) {
/* 200 */     List<ItemStack> list = Lists.newArrayList();
/* 201 */     for (int i = 0; i < player.field_71071_by.func_70302_i_(); i++) {
/* 202 */       ItemStack itemStack = player.field_71071_by.func_70301_a(i);
/* 203 */       if (itemStack.func_77973_b() instanceof IPlantable)
/* 204 */         list.add(itemStack); 
/*     */     } 
/* 206 */     return list;
/*     */   }
/*     */   
/*     */   public static Entity getEntityLooking(EntityLivingBase living) {
/* 210 */     if (living.field_70170_p.field_72995_K) {
/* 211 */       Minecraft mc = FMLClientHandler.instance().getClient();
/* 212 */       if (mc.field_147125_j != null) {
/* 213 */         return null;
/*     */       }
/*     */     } 
/* 216 */     double distance = ((RangedAttribute)EntityPlayer.REACH_DISTANCE).func_111109_a(Double.MAX_VALUE);
/*     */     
/* 218 */     Vec3d eyeVec = living.func_174824_e(1.0F);
/* 219 */     Vec3d lookVec = living.func_70676_i(1.0F);
/* 220 */     Vec3d sightLimit = eyeVec.func_72441_c(lookVec.field_72450_a * distance, lookVec.field_72448_b * distance, lookVec.field_72449_c * distance);
/* 221 */     AxisAlignedBB playerBB = living.func_174813_aQ().func_72321_a(lookVec.field_72450_a * distance, lookVec.field_72448_b * distance, lookVec.field_72449_c * distance).func_186662_g(1.0D);
/*     */     
/* 223 */     List<Entity> entities = living.field_70170_p.func_175674_a((Entity)living, playerBB, Predicates.and(EntitySelectors.field_180132_d, new Predicate<Entity>()
/*     */           {
/*     */             public boolean apply(Entity entity) {
/* 226 */               if (entity == null)
/* 227 */                 return false; 
/* 228 */               if (!(entity instanceof MultiPartEntityPart)) {
/* 229 */                 if (!(entity instanceof EntityLivingBase))
/* 230 */                   return false; 
/* 231 */                 if (!((EntityLivingBase)entity).func_70089_S())
/* 232 */                   return false; 
/*     */               } 
/* 234 */               return entity.func_70067_L();
/*     */             }
/*     */           }));
/* 237 */     double longestDistance = distance;
/* 238 */     Entity pointedEntity = null;
/*     */     
/* 240 */     for (Entity entity : entities) {
/* 241 */       AxisAlignedBB hitArea = entity.func_174813_aQ().func_186662_g(entity.func_70111_Y());
/* 242 */       RayTraceResult traceResult = hitArea.func_72327_a(eyeVec, sightLimit);
/*     */       
/* 244 */       if (hitArea.func_72318_a(eyeVec)) {
/* 245 */         if (longestDistance >= 0.0D) {
/* 246 */           pointedEntity = entity;
/* 247 */           longestDistance = 0.0D;
/*     */         }  continue;
/*     */       } 
/* 250 */       if (traceResult != null) {
/* 251 */         double distanceToCurrent = eyeVec.func_72438_d(traceResult.field_72307_f);
/*     */         
/* 253 */         if (distanceToCurrent < longestDistance || longestDistance == 0.0D) {
/* 254 */           pointedEntity = entity;
/* 255 */           longestDistance = distanceToCurrent;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 260 */     return pointedEntity;
/*     */   }
/*     */   
/*     */   public static Entity getEntity(Entity entity) {
/* 264 */     if (entity instanceof MultiPartEntityPart)
/* 265 */       return (Entity)((MultiPartEntityPart)entity).field_70259_a; 
/* 266 */     if (entity instanceof EntityLivingBase)
/* 267 */       return entity; 
/* 268 */     return null;
/*     */   }
/*     */   
/*     */   public static void editEnchantment(ItemStack itemStack, boolean editSilkTouch) {
/* 272 */     if (itemStack.func_190926_b())
/*     */       return; 
/* 274 */     Map<Enchantment, Integer> enchMap = EnchantmentHelper.func_82781_a(itemStack);
/* 275 */     for (Enchantment ench : enchMap.keySet()) {
/* 276 */       if (ench.func_190936_d())
/* 277 */         enchMap.remove(ench); 
/* 278 */     }  if (editSilkTouch) {
/* 279 */       if (itemStack.func_77978_p().func_74767_n(IManaitaConfigurable.EnumConfig.SILKTOUCH.func_176610_l())) {
/* 280 */         if (EnchantmentHelper.func_77506_a(Enchantments.field_185306_r, itemStack) < 1) {
/* 281 */           enchMap.put(Enchantments.field_185306_r, Integer.valueOf(1));
/*     */         }
/*     */       } else {
/* 284 */         enchMap.remove(Enchantments.field_185306_r);
/* 285 */       }  if (EnchantmentHelper.func_77506_a(Enchantments.field_185308_t, itemStack) < 10)
/* 286 */         enchMap.put(Enchantments.field_185308_t, Integer.valueOf(10)); 
/*     */     } 
/* 288 */     EnchantmentHelper.func_82782_a(enchMap, itemStack);
/*     */   }
/*     */   
/*     */   public static void setDefaultNBT(List<IManaitaConfigurable.EnumConfig> configs, ItemStack itemStack) {
/* 292 */     if (configs == null || configs.isEmpty() || itemStack.func_190926_b())
/*     */       return; 
/* 294 */     if (!itemStack.func_77942_o())
/* 295 */       itemStack.func_77982_d(new NBTTagCompound()); 
/* 296 */     for (IManaitaConfigurable.EnumConfig config : configs) {
/* 297 */       if (!itemStack.func_77978_p().func_74764_b(config.func_176610_l()))
/* 298 */         switch (config.getType()) {
/*     */           case 0:
/* 300 */             itemStack.func_77978_p().func_74757_a(config.func_176610_l(), (config == IManaitaConfigurable.EnumConfig.CAN_HARVEST));
/*     */           
/*     */           case 1:
/* 303 */             itemStack.func_77978_p().func_74768_a(config.func_176610_l(), 1);
/*     */         }  
/*     */     } 
/*     */   }
/*     */   public static void addNBTInformation(List<IManaitaConfigurable.EnumConfig> configs, ItemStack itemStack, List<String> list) {
/* 308 */     if (configs == null || configs.isEmpty() || itemStack.func_190926_b() || list == null)
/*     */       return; 
/* 310 */     for (IManaitaConfigurable.EnumConfig config : configs) {
/* 311 */       switch (config.getType()) {
/*     */         case 0:
/* 313 */           list.add(ManaitaPlusText.makeModeText(config.func_176610_l() + ": " + (itemStack.func_77978_p().func_74767_n(config.func_176610_l()) ? "ON" : "OFF")));
/*     */         
/*     */         case 1:
/* 316 */           if (config == IManaitaConfigurable.EnumConfig.DIG_RANGE || config == IManaitaConfigurable.EnumConfig.ATTACK_AREA) {
/* 317 */             int i = itemStack.func_77978_p().func_74762_e(config.func_176610_l()) * 2 - 1;
/* 318 */             list.add(ManaitaPlusText.makeModeText(config.func_176610_l() + ": " + i + "x" + i));
/*     */             continue;
/*     */           } 
/* 321 */           list.add(ManaitaPlusText.makeModeText(config.func_176610_l() + ": " + itemStack.func_77978_p().func_74762_e(config.func_176610_l())));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public static boolean isManaita(EntityPlayer player, boolean isDoubling) {
/* 326 */     for (EnumHand hand : EnumHand.values()) {
/* 327 */       if (player != null && !player.func_184586_b(hand).func_190926_b() && player.func_184586_b(hand).func_77973_b() instanceof IManaitaConfigurable && (
/* 328 */         !isDoubling || (player.func_184586_b(hand).func_77942_o() && player.func_184586_b(hand).func_77978_p().func_74764_b(IManaitaConfigurable.EnumConfig.DOUBLING.func_176610_l()) && player.func_184586_b(hand).func_77978_p().func_74767_n(IManaitaConfigurable.EnumConfig.DOUBLING.func_176610_l()))))
/* 329 */         return true; 
/* 330 */     }  return false;
/*     */   }
/*     */   
/* 333 */   public static final EntityEquipmentSlot[] VALID_EQUIPMENT_SLOTS = new EntityEquipmentSlot[] { EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET };
/*     */   
/*     */   public static boolean isManaitaArmor(EntityPlayer player) {
/* 336 */     for (EntityEquipmentSlot slot : VALID_EQUIPMENT_SLOTS) {
/* 337 */       if (player == null || player.func_184582_a(slot).func_190926_b() || !(player.func_184582_a(slot).func_77973_b() instanceof rikuto.manaita_plus.item.ItemManaitaArmor))
/* 338 */         return false; 
/* 339 */     }  return true;
/*     */   }
/*     */   
/*     */   public static boolean isManaitaShield(EntityPlayer player) {
/* 343 */     return (player != null && player.func_184587_cr() && player.func_184607_cu().func_77973_b() instanceof rikuto.manaita_plus.item.ItemManaitaShield);
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plu\\util\ManaitaPlusUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */