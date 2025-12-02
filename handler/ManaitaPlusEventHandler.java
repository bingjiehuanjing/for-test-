/*     */ package rikuto.manaita_plus.handler;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.util.text.TextFormatting;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.storage.loot.LootEntry;
/*     */ import net.minecraft.world.storage.loot.LootEntryTable;
/*     */ import net.minecraft.world.storage.loot.LootPool;
/*     */ import net.minecraft.world.storage.loot.LootTableList;
/*     */ import net.minecraft.world.storage.loot.RandomValueRange;
/*     */ import net.minecraftforge.event.LootTableLoadEvent;
/*     */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingAttackEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingFallEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.event.entity.player.ItemTooltipEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
/*     */ import net.minecraftforge.event.world.BlockEvent;
/*     */ import net.minecraftforge.fml.client.event.ConfigChangedEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.gameevent.InputEvent;
/*     */ import net.minecraftforge.fml.common.gameevent.PlayerEvent;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import rikuto.manaita_plus.ManaitaPlus;
/*     */ import rikuto.manaita_plus.core.ManaitaPlusConfigCore;
/*     */ import rikuto.manaita_plus.item.IManaitaConfigurable;
/*     */ import rikuto.manaita_plus.network.MessageKey;
/*     */ import rikuto.manaita_plus.network.MessageStepHeight;
/*     */ import rikuto.manaita_plus.proxy.ClientProxy;
/*     */ import rikuto.manaita_plus.util.ManaitaPlusText;
/*     */ import rikuto.manaita_plus.util.ManaitaPlusUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ManaitaPlusEventHandler
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
/*  74 */     if (event.getModID().equals("manaita_plus"))
/*  75 */       ManaitaPlusConfigCore.syncConfig(); 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
/*  80 */     if (ManaitaPlus.update != null)
/*  81 */       ManaitaPlus.update.notifyUpdate((ICommandSender)event.player, Side.CLIENT); 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onKeyInput(InputEvent.KeyInputEvent event) {
/*  86 */     if (ClientProxy.manaitaKey.func_151468_f())
/*  87 */       PacketHandler.INSTANCE.sendToServer((IMessage)new MessageKey((byte)0)); 
/*  88 */     if (ClientProxy.alwaysCraftingManaitaKey.func_151468_f())
/*  89 */       PacketHandler.INSTANCE.sendToServer((IMessage)new MessageKey((byte)1)); 
/*  90 */     if (ClientProxy.alwaysFurnaceManaitaKey.func_151468_f())
/*  91 */       PacketHandler.INSTANCE.sendToServer((IMessage)new MessageKey((byte)2)); 
/*  92 */     if (ClientProxy.alwaysBrewingManaitaKey.func_151468_f())
/*  93 */       PacketHandler.INSTANCE.sendToServer((IMessage)new MessageKey((byte)3)); 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLootTableLoad(LootTableLoadEvent event) {
/*  98 */     if (event.getName() == LootTableList.field_186421_c) {
/*  99 */       LootEntryTable entryTable = new LootEntryTable(new ResourceLocation("manaita_plus", "manaita_treasure"), 1, 0, new net.minecraft.world.storage.loot.conditions.LootCondition[0], "manaita_entry");
/* 100 */       event.getTable().addPool(new LootPool(new LootEntry[] { (LootEntry)entryTable }, new net.minecraft.world.storage.loot.conditions.LootCondition[0], new RandomValueRange(1.0F), new RandomValueRange(0.0F, 0.0F), "manaita_pool"));
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onTooltip(ItemTooltipEvent event) {
/* 106 */     ItemStack itemStack = event.getItemStack();
/* 107 */     Item item = itemStack.func_77973_b();
/* 108 */     List<String> tooltip = event.getToolTip();
/* 109 */     if (item instanceof rikuto.manaita_plus.item.ItemManaitaSword || item instanceof rikuto.manaita_plus.item.ItemManaitaPaxel)
/* 110 */       for (int i = 0; i < tooltip.size(); i++) {
/* 111 */         if (((String)tooltip.get(i)).contains(I18n.func_135052_a("attribute.name.generic.attackDamage", new Object[0]))) {
/* 112 */           tooltip.set(i, " " + ManaitaPlusText.makeInfinityText(I18n.func_135052_a("manaita.infinity_power", new Object[0]))); return;
/*     */         } 
/*     */       }  
/* 115 */     if (item instanceof rikuto.manaita_plus.item.ItemManaitaArmor && itemStack.func_111283_C(((ItemArmor)item).field_77881_a).isEmpty()) {
/* 116 */       int i = event.getFlags().func_194127_a() ? (tooltip.indexOf(TextFormatting.DARK_GRAY + ((ResourceLocation)Item.field_150901_e.func_177774_c(item)).toString()) - (itemStack.func_77951_h() ? 1 : 0)) : tooltip.size();
/* 117 */       tooltip.add(i, "");
/* 118 */       tooltip.add(i + 1, I18n.func_135052_a("item.modifiers." + ((ItemArmor)item).field_77881_a.func_188450_d(), new Object[0]));
/* 119 */       tooltip.add(i + 2, " " + ManaitaPlusText.makeInfinityText(I18n.func_135052_a("manaita.armor", new Object[0])));
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
/* 125 */     World world = event.getWorld();
/* 126 */     BlockPos pos = event.getPos();
/* 127 */     IBlockState state = world.func_180495_p(pos);
/* 128 */     Block block = state.func_177230_c();
/* 129 */     EntityPlayer player = event.getEntityPlayer();
/* 130 */     ItemStack itemStack = event.getItemStack();
/* 131 */     EnumFacing facing = event.getFace();
/* 132 */     Vec3d vec = event.getHitVec();
/* 133 */     if (facing == null || world.field_72995_K || itemStack.func_190926_b() || player.func_184614_ca().func_190926_b() || player.field_71075_bZ.field_75098_d)
/*     */       return; 
/* 135 */     if (state.func_185887_b(world, pos) <= -1.0F && itemStack.func_77973_b() instanceof IManaitaConfigurable && itemStack.func_150998_b(state)) {
/* 136 */       ItemStack drop = block.getPickBlock(state, new RayTraceResult(vec, facing), world, pos, player);
/* 137 */       event.getWorld().func_175655_b(pos, false);
/* 138 */       world.func_72838_d((Entity)new EntityItem(world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), drop));
/* 139 */       itemStack.func_179548_a(world, state, pos, player);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerPickupXp(PlayerPickupXpEvent event) {
/* 145 */     if ((event.getEntityPlayer()).field_70170_p.field_72995_K)
/*     */       return; 
/* 147 */     if (ManaitaPlusUtils.isManaita(event.getEntityPlayer(), true))
/* 148 */       (event.getOrb()).field_70530_e *= ManaitaPlusConfigCore.weaponsDoubling; 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingDrops(LivingDropsEvent event) {
/* 153 */     if (event.getSource().func_76346_g() instanceof EntityPlayer) {
/* 154 */       EntityPlayer player = (EntityPlayer)event.getSource().func_76346_g();
/* 155 */       if (ManaitaPlusUtils.isManaita(player, true) && player.func_70093_af()) {
/* 156 */         List<ItemStack> drops = Lists.newArrayList();
/* 157 */         for (EntityItem drop : event.getDrops()) {
/* 158 */           ItemStack dropItem = drop.func_92059_d();
/* 159 */           dropItem.func_190920_e(dropItem.func_190916_E() * ManaitaPlusConfigCore.weaponsDoubling);
/* 160 */           drops.add(dropItem);
/*     */         } 
/* 162 */         event.getDrops().clear();
/* 163 */         for (ItemStack drop : drops)
/* 164 */           addDrop(event, drop); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addDrop(LivingDropsEvent event, ItemStack dropItem) {
/* 170 */     EntityItem drop = new EntityItem((event.getEntityLiving()).field_70170_p, (event.getEntityLiving()).field_70165_t, (event.getEntityLiving()).field_70163_u, (event.getEntityLiving()).field_70161_v, dropItem);
/* 171 */     drop.func_174869_p();
/* 172 */     event.getDrops().add(drop);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onBlockHarvestDrops(BlockEvent.HarvestDropsEvent event) {
/* 177 */     EntityPlayer player = event.getHarvester();
/* 178 */     if (ManaitaPlusUtils.isManaita(player, true) && player.func_70093_af())
/* 179 */       for (ItemStack drop : event.getDrops())
/* 180 */         drop.func_190920_e(drop.func_190916_E() * ManaitaPlusConfigCore.toolsDoubling);  
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingFall(LivingFallEvent event) {
/* 185 */     if (event.getEntityLiving() instanceof EntityPlayer) {
/* 186 */       EntityPlayer player = (EntityPlayer)event.getEntityLiving();
/* 187 */       ItemStack boots = player.func_184582_a(EntityEquipmentSlot.FEET);
/* 188 */       if ((!boots.func_190926_b() && boots.func_77973_b() instanceof rikuto.manaita_plus.item.ItemManaitaArmor) || ManaitaPlusUtils.isManaitaShield(player))
/* 189 */         event.setCanceled(true); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingAttack(LivingAttackEvent event) {
/* 195 */     if (event.getEntityLiving() instanceof EntityPlayer) {
/* 196 */       EntityPlayer player = (EntityPlayer)event.getEntityLiving();
/* 197 */       if (ManaitaPlusUtils.isManaitaArmor(player) || ManaitaPlusUtils.isManaitaShield(player))
/* 198 */         event.setCanceled(true); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingDeath(LivingDeathEvent event) {
/* 204 */     if (event.getEntityLiving() instanceof EntityPlayer) {
/* 205 */       EntityPlayer player = (EntityPlayer)event.getEntityLiving();
/* 206 */       if (ManaitaPlusUtils.isManaitaArmor(player) || ManaitaPlusUtils.isManaitaShield(player)) {
/* 207 */         event.setCanceled(true);
/* 208 */         player.func_70606_j(player.func_110138_aP());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingHurt(LivingHurtEvent event) {
/* 215 */     if (event.getEntityLiving() instanceof EntityPlayer) {
/* 216 */       EntityPlayer player = (EntityPlayer)event.getEntityLiving();
/* 217 */       if (ManaitaPlusUtils.isManaitaArmor(player) || ManaitaPlusUtils.isManaitaShield(player))
/* 218 */         event.setCanceled(true); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingJump(LivingEvent.LivingJumpEvent event) {
/* 224 */     if (event.getEntityLiving() instanceof EntityPlayer) {
/* 225 */       EntityPlayer player = (EntityPlayer)event.getEntityLiving();
/* 226 */       ItemStack boots = player.func_184582_a(EntityEquipmentSlot.FEET);
/* 227 */       if (!boots.func_190926_b() && boots.func_77973_b() instanceof rikuto.manaita_plus.item.ItemManaitaArmor)
/* 228 */         player.field_70181_x += (boots.func_77978_p().func_74762_e(IManaitaConfigurable.EnumConfig.JUMP_BOOST.func_176610_l()) * 0.1F); 
/*     */     } 
/*     */   }
/*     */   
/* 232 */   public static Map<EntityPlayer, Boolean> playersWithFlight = new WeakHashMap<>();
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
/* 236 */     if (event.getEntityLiving() != null && event.getEntityLiving() instanceof EntityPlayer) {
/* 237 */       EntityPlayer player = (EntityPlayer)event.getEntityLiving();
/* 238 */       ItemStack chestplate = player.func_184582_a(EntityEquipmentSlot.CHEST);
/* 239 */       ItemStack boots = player.func_184582_a(EntityEquipmentSlot.FEET);
/*     */       
/* 241 */       if (ManaitaPlusUtils.isManaitaArmor(player) || ManaitaPlusUtils.isManaitaShield(player)) {
/* 242 */         player.func_70606_j(player.func_110138_aP());
/*     */       }
/* 244 */       if (ManaitaPlusUtils.isManaitaShield(player)) {
/* 245 */         List<Entity> entities = player.field_70170_p.func_72872_a(Entity.class, player.func_174813_aQ().func_186662_g(14.0D));
/* 246 */         for (Entity entity : entities) {
/* 247 */           if (entity instanceof net.minecraft.entity.IProjectile) {
/* 248 */             entity.func_70106_y();
/* 249 */             for (int i = 0; i < 20; i++) {
/* 250 */               entity.field_70170_p.func_175688_a(EnumParticleTypes.EXPLOSION_NORMAL, entity.field_70165_t + entity.field_70170_p.field_73012_v
/* 251 */                   .nextDouble() * entity.field_70130_N * 2.0D - entity.field_70130_N, entity.field_70163_u + entity.field_70170_p.field_73012_v.nextDouble() * entity.field_70131_O, entity.field_70161_v + entity.field_70170_p.field_73012_v.nextDouble() * entity.field_70130_N * 2.0D - entity.field_70130_N, entity.field_70170_p.field_73012_v
/* 252 */                   .nextGaussian() * 0.02D, entity.field_70170_p.field_73012_v.nextGaussian() * 0.02D, entity.field_70170_p.field_73012_v.nextGaussian() * 0.02D, new int[0]);
/*     */             }
/* 254 */             entity.func_184185_a(SoundEvents.field_187658_bx, 1.0F, 2.0F + entity.field_70170_p.field_73012_v.nextFloat() * 0.4F);
/*     */           } 
/*     */         } 
/*     */       } 
/* 258 */       if (!chestplate.func_190926_b() && chestplate.func_77973_b() instanceof rikuto.manaita_plus.item.ItemManaitaArmor) {
/* 259 */         playersWithFlight.put(player, Boolean.valueOf(true));
/* 260 */         player.field_71075_bZ.field_75101_c = true;
/*     */       } else {
/*     */         
/* 263 */         if (!playersWithFlight.containsKey(player))
/* 264 */           playersWithFlight.put(player, Boolean.valueOf(false)); 
/* 265 */         if (((Boolean)playersWithFlight.get(player)).booleanValue()) {
/* 266 */           playersWithFlight.put(player, Boolean.valueOf(false));
/* 267 */           if (!player.field_71075_bZ.field_75098_d) {
/* 268 */             player.field_71075_bZ.field_75101_c = false;
/* 269 */             player.field_71075_bZ.field_75100_b = false;
/* 270 */             if (!player.field_70170_p.field_72995_K) {
/* 271 */               player.func_71016_p();
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 276 */       if (!boots.func_190926_b() && boots.func_77973_b() instanceof rikuto.manaita_plus.item.ItemManaitaArmor && (
/* 277 */         player.field_70122_E || player.field_71075_bZ.field_75100_b || player.func_70055_a(Material.field_151586_h) || player.func_70090_H())) {
/* 278 */         float speed = boots.func_77978_p().func_74762_e(IManaitaConfigurable.EnumConfig.MOVE_SPEED.func_176610_l()) * 0.1F * (player.field_71075_bZ.field_75100_b ? 1.1F : 1.0F) * (player.func_70093_af() ? 0.1F : 1.0F);
/*     */         
/* 280 */         if (player.field_191988_bg > 0.0F) {
/* 281 */           player.func_191958_b(0.0F, 0.0F, 1.0F, speed);
/* 282 */         } else if (player.field_191988_bg < 0.0F) {
/* 283 */           player.func_191958_b(0.0F, 0.0F, 1.0F, -speed * 0.3F);
/* 284 */         }  if (player.field_70702_br != 0.0F) {
/* 285 */           player.func_191958_b(1.0F, 0.0F, 0.0F, speed * 0.5F * Math.signum(player.field_70702_br));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 290 */       if ((event.getEntityLiving()).field_70170_p.field_72995_K && event.getEntityLiving() instanceof EntityPlayerSP) {
/* 291 */         EntityPlayerSP playerSP = (EntityPlayerSP)event.getEntityLiving();
/* 292 */         if (!boots.func_190926_b() && boots.func_77973_b() instanceof rikuto.manaita_plus.item.ItemManaitaArmor && 
/* 293 */           playerSP.field_71075_bZ.field_75100_b) {
/* 294 */           if (playerSP.field_71158_b.field_78899_d)
/* 295 */             playerSP.field_70181_x -= (boots.func_77978_p().func_74762_e(IManaitaConfigurable.EnumConfig.JUMP_BOOST.func_176610_l()) * 0.15F); 
/* 296 */           if (playerSP.field_71158_b.field_78901_c) {
/* 297 */             playerSP.field_70181_x += (boots.func_77978_p().func_74762_e(IManaitaConfigurable.EnumConfig.JUMP_BOOST.func_176610_l()) * 0.15F);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 302 */       if (event.getEntityLiving() instanceof EntityPlayerMP) {
/* 303 */         EntityPlayerMP playerMP = (EntityPlayerMP)event.getEntityLiving();
/* 304 */         if (!boots.func_190926_b() && boots.func_77973_b() instanceof rikuto.manaita_plus.item.ItemManaitaArmor && boots.func_77978_p().func_74767_n(IManaitaConfigurable.EnumConfig.STEP_ASSIST.func_176610_l()) && playerMP.field_70138_W < 1.0625F) {
/* 305 */           playerMP.field_70138_W = 1.0625F;
/* 306 */           PacketHandler.INSTANCE.sendTo((IMessage)new MessageStepHeight(1.0625F), playerMP);
/*     */         }
/* 308 */         else if (playerMP.field_70138_W > 0.6F) {
/* 309 */           playerMP.field_70138_W = 0.6F;
/* 310 */           PacketHandler.INSTANCE.sendTo((IMessage)new MessageStepHeight(0.6F), playerMP);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/* 317 */   private static List<ItemStack> capturedDrops = Lists.newArrayList();
/*     */   private static boolean doItemCapture = false;
/*     */   
/*     */   public static void startItemCapture() {
/* 321 */     doItemCapture = true;
/*     */   }
/*     */   
/*     */   public static void stopItemCapture() {
/* 325 */     doItemCapture = false;
/*     */   }
/*     */   
/*     */   public static boolean isItemCaptureEnabled() {
/* 329 */     return doItemCapture;
/*     */   }
/*     */   
/*     */   public static List<ItemStack> getCapturedDrops() {
/* 333 */     List<ItemStack> drops = new ArrayList<>(capturedDrops);
/* 334 */     capturedDrops.clear();
/* 335 */     return drops;
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onEntityJoinWorld(EntityJoinWorldEvent event) {
/* 340 */     if (doItemCapture && 
/* 341 */       event.getEntity() instanceof EntityItem) {
/* 342 */       capturedDrops.add(((EntityItem)event.getEntity()).func_92059_d());
/* 343 */       event.setCanceled(true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\handler\ManaitaPlusEventHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */