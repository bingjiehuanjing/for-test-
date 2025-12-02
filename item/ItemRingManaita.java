/*     */ package rikuto.manaita_plus.item;
/*     */ 
/*     */ import baubles.api.BaubleType;
/*     */ import baubles.api.BaublesApi;
/*     */ import baubles.api.IBauble;
/*     */ import baubles.api.cap.IBaublesItemHandler;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.world.World;
/*     */ import rikuto.manaita_plus.ManaitaPlus;
/*     */ 
/*     */ public class ItemRingManaita
/*     */   extends ItemPortableManaita
/*     */   implements IBauble, IManaitaKey {
/*     */   private boolean RingCraftingManaita = false;
/*     */   private boolean RingFurnaceManaita = false;
/*     */   private boolean RingBrewingManaita = false;
/*     */   
/*     */   public ItemRingManaita(int type) {
/*  26 */     super(type);
/*     */   }
/*     */   
/*     */   public ActionResult<ItemStack> func_77659_a(World world, EntityPlayer player, EnumHand hand) {
/*  30 */     boolean equipped = false;
/*  31 */     ItemStack heldItem = player.func_184586_b(hand);
/*  32 */     ItemStack toEquip = heldItem.func_77946_l();
/*  33 */     toEquip.func_190920_e(1);
/*  34 */     if (player.func_70093_af() && canEquip(toEquip, (EntityLivingBase)player)) {
/*  35 */       IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player); int i;
/*  36 */       for (i = 0; i < baubles.getSlots(); i++) {
/*  37 */         if (baubles.isItemValidForSlot(i, toEquip, (EntityLivingBase)player)) {
/*  38 */           ItemStack itemStackInSlot = baubles.getStackInSlot(i);
/*  39 */           if (itemStackInSlot.func_190926_b()) {
/*  40 */             baubles.setStackInSlot(i, toEquip);
/*  41 */             ((IBauble)heldItem.func_77973_b()).onEquipped(heldItem, (EntityLivingBase)player);
/*  42 */             heldItem.func_190918_g(1);
/*  43 */             equipped = true;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*  48 */       if (!equipped) {
/*  49 */         for (i = 0; i < baubles.getSlots(); i++) {
/*  50 */           if (baubles.isItemValidForSlot(i, toEquip, (EntityLivingBase)player)) {
/*  51 */             ItemStack itemStackInSlot = baubles.getStackInSlot(i);
/*  52 */             if (!itemStackInSlot.func_190926_b() && !toEquip.func_77969_a(itemStackInSlot) && ((IBauble)itemStackInSlot.func_77973_b()).canUnequip(itemStackInSlot, (EntityLivingBase)player)) {
/*  53 */               baubles.setStackInSlot(i, toEquip);
/*  54 */               ((IBauble)heldItem.func_77973_b()).onEquipped(heldItem, (EntityLivingBase)player);
/*  55 */               heldItem.func_190918_g(1);
/*  56 */               ((IBauble)itemStackInSlot.func_77973_b()).onUnequipped(itemStackInSlot, (EntityLivingBase)player);
/*  57 */               if (heldItem.func_190916_E() <= 0)
/*  58 */                 return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackInSlot.func_77946_l()); 
/*  59 */               if (!world.field_72995_K) {
/*  60 */                 if (!player.func_70089_S() || (player instanceof EntityPlayerMP && ((EntityPlayerMP)player).func_193105_t())) {
/*  61 */                   player.func_71019_a(itemStackInSlot, false); break;
/*     */                 } 
/*  63 */                 player.field_71071_by.func_191975_a(world, itemStackInSlot);
/*     */               } 
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } else {
/*  71 */       super.func_77659_a(world, player, hand);
/*  72 */     }  return new ActionResult(EnumActionResult.PASS, heldItem);
/*     */   }
/*     */   
/*     */   public boolean onManaitaKeyPress(World world, EntityPlayer player, ItemStack itemStack) {
/*  76 */     if (!world.field_72995_K && !player.func_70093_af()) {
/*  77 */       if (this.RingCraftingManaita) {
/*  78 */         switch (itemStack.func_77952_i()) {
/*     */           case 0:
/*  80 */             player.openGui(ManaitaPlus.instance, 1, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 1:
/*  83 */             player.openGui(ManaitaPlus.instance, 2, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 2:
/*  86 */             player.openGui(ManaitaPlus.instance, 3, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 3:
/*  89 */             player.openGui(ManaitaPlus.instance, 4, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 4:
/*  92 */             player.openGui(ManaitaPlus.instance, 5, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 5:
/*  95 */             player.openGui(ManaitaPlus.instance, 6, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 6:
/*  98 */             player.openGui(ManaitaPlus.instance, 7, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 7:
/* 101 */             player.openGui(ManaitaPlus.instance, 8, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v); break;
/*     */         } 
/* 103 */         return true;
/*     */       } 
/* 105 */       if (this.RingFurnaceManaita) {
/* 106 */         switch (itemStack.func_77952_i()) {
/*     */           case 0:
/* 108 */             player.openGui(ManaitaPlus.instance, 9, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 1:
/* 111 */             player.openGui(ManaitaPlus.instance, 10, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 2:
/* 114 */             player.openGui(ManaitaPlus.instance, 11, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 3:
/* 117 */             player.openGui(ManaitaPlus.instance, 12, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 4:
/* 120 */             player.openGui(ManaitaPlus.instance, 13, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 5:
/* 123 */             player.openGui(ManaitaPlus.instance, 14, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 6:
/* 126 */             player.openGui(ManaitaPlus.instance, 15, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 7:
/* 129 */             player.openGui(ManaitaPlus.instance, 16, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v); break;
/*     */         } 
/* 131 */         return true;
/*     */       } 
/* 133 */       if (this.RingBrewingManaita) {
/* 134 */         switch (itemStack.func_77952_i()) {
/*     */           case 0:
/* 136 */             player.openGui(ManaitaPlus.instance, 17, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 1:
/* 139 */             player.openGui(ManaitaPlus.instance, 18, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 2:
/* 142 */             player.openGui(ManaitaPlus.instance, 19, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 3:
/* 145 */             player.openGui(ManaitaPlus.instance, 20, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 4:
/* 148 */             player.openGui(ManaitaPlus.instance, 21, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 5:
/* 151 */             player.openGui(ManaitaPlus.instance, 22, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 6:
/* 154 */             player.openGui(ManaitaPlus.instance, 23, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */             break;
/*     */           case 7:
/* 157 */             player.openGui(ManaitaPlus.instance, 24, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v); break;
/*     */         } 
/* 159 */         return true;
/*     */       } 
/*     */     } 
/* 162 */     return false;
/*     */   }
/*     */   
/*     */   public BaubleType getBaubleType(ItemStack itemStack) {
/* 166 */     return BaubleType.RING;
/*     */   }
/*     */   
/*     */   public void onEquipped(ItemStack itemStack, EntityLivingBase player) {
/* 170 */     player.func_184185_a(SoundEvents.field_187716_o, 0.75F, 1.9F);
/* 171 */     switch (this.role) {
/*     */       case 1:
/* 173 */         this.RingCraftingManaita = true;
/*     */         break;
/*     */       case 2:
/* 176 */         this.RingFurnaceManaita = true;
/*     */         break;
/*     */       case 3:
/* 179 */         this.RingBrewingManaita = true;
/*     */         break;
/*     */     } 
/*     */   }
/*     */   public void onUnequipped(ItemStack itemStack, EntityLivingBase player) {
/* 184 */     player.func_184185_a(SoundEvents.field_187716_o, 0.75F, 2.0F);
/* 185 */     switch (this.role) {
/*     */       case 1:
/* 187 */         this.RingCraftingManaita = false;
/*     */         break;
/*     */       case 2:
/* 190 */         this.RingFurnaceManaita = false;
/*     */         break;
/*     */       case 3:
/* 193 */         this.RingBrewingManaita = false;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\item\ItemRingManaita.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */