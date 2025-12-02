/*     */ package rikuto.manaita_plus.gui;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryBasic;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import rikuto.manaita_plus.item.IManaitaConfigurable;
/*     */ import rikuto.manaita_plus.util.ManaitaPlusUtils;
/*     */ 
/*     */ public class ContainerConfig
/*     */   extends Container
/*     */ {
/*  24 */   public IInventory slot = (IInventory)new InventoryBasic("Config", false, 1);
/*     */   
/*     */   public ContainerConfig(InventoryPlayer playerInv, final EntityPlayer player) {
/*  27 */     func_75146_a(new Slot(this.slot, 0, 13, 13) {
/*     */           public boolean func_75214_a(ItemStack itemStack) {
/*  29 */             if (itemStack.func_77973_b() instanceof IManaitaConfigurable) {
/*  30 */               List<IManaitaConfigurable.EnumConfig> configs = ((IManaitaConfigurable)itemStack.func_77973_b()).getConfigs();
/*  31 */               return (configs != null && !configs.isEmpty());
/*     */             } 
/*  33 */             return false; }
/*     */         });
/*     */     int i;
/*  36 */     for (i = 0; i < 4; i++) {
/*  37 */       final EntityEquipmentSlot slot = ManaitaPlusUtils.VALID_EQUIPMENT_SLOTS[i];
/*  38 */       func_75146_a(new Slot((IInventory)playerInv, 36 + 3 - i, 152, 8 + i * 18)
/*     */           {
/*     */             public int func_75219_a() {
/*  41 */               return 1;
/*     */             }
/*     */             
/*     */             public boolean func_75214_a(ItemStack itemStack) {
/*  45 */               return itemStack.func_77973_b().isValidArmor(itemStack, slot, (Entity)player);
/*     */             }
/*     */             
/*     */             public boolean func_82869_a(EntityPlayer playerIn) {
/*  49 */               ItemStack itemStack = func_75211_c();
/*  50 */               return (!itemStack.func_190926_b() && !playerIn.func_184812_l_() && EnchantmentHelper.func_190938_b(itemStack)) ? false : super.func_82869_a(playerIn);
/*     */             }
/*     */             
/*     */             @SideOnly(Side.CLIENT)
/*     */             public String func_178171_c() {
/*  55 */               return ItemArmor.field_94603_a[slot.func_188454_b()];
/*     */             }
/*     */           });
/*     */     } 
/*  59 */     for (i = 0; i < 3; i++) {
/*  60 */       for (int j = 0; j < 9; j++)
/*  61 */         func_75146_a(new Slot((IInventory)playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18)); 
/*  62 */     }  for (int k = 0; k < 9; k++)
/*  63 */       func_75146_a(new Slot((IInventory)playerInv, k, 8 + k * 18, 142)); 
/*  64 */     func_75146_a(new Slot((IInventory)playerInv, 40, 8, 62) {
/*     */           @SideOnly(Side.CLIENT)
/*     */           public String func_178171_c() {
/*  67 */             return "minecraft:items/empty_armor_slot_shield";
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer player) {
/*  73 */     return true;
/*     */   }
/*     */   
/*     */   public void func_75134_a(EntityPlayer player) {
/*  77 */     super.func_75134_a(player);
/*  78 */     if (!player.field_70170_p.field_72995_K)
/*  79 */       func_193327_a(player, player.field_70170_p, this.slot); 
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int index) {
/*  83 */     ItemStack itemStack = ItemStack.field_190927_a;
/*  84 */     Slot slot = this.field_75151_b.get(index);
/*     */     
/*  86 */     if (slot != null && slot.func_75216_d()) {
/*  87 */       ItemStack itemStackInSlot = slot.func_75211_c();
/*  88 */       itemStack = itemStackInSlot.func_77946_l();
/*  89 */       EntityEquipmentSlot equipment = EntityLiving.func_184640_d(itemStack);
/*     */       
/*  91 */       if (index == 0) {
/*  92 */         if (equipment.func_188453_a() == EntityEquipmentSlot.Type.ARMOR && !((Slot)this.field_75151_b.get(4 - equipment.func_188454_b())).func_75216_d()) {
/*  93 */           int i = 4 - equipment.func_188454_b();
/*  94 */           if (!func_75135_a(itemStackInSlot, i, i + 1, false)) {
/*  95 */             return ItemStack.field_190927_a;
/*     */           }
/*  97 */         } else if (equipment == EntityEquipmentSlot.OFFHAND && !((Slot)this.field_75151_b.get(42)).func_75216_d()) {
/*  98 */           if (!func_75135_a(itemStackInSlot, 42, 43, false)) {
/*  99 */             return ItemStack.field_190927_a;
/*     */           }
/* 101 */         } else if (!func_75135_a(itemStackInSlot, 6, 41, true)) {
/* 102 */           return ItemStack.field_190927_a;
/*     */         } 
/* 104 */         slot.func_75220_a(itemStackInSlot, itemStack);
/*     */       }
/* 106 */       else if (index >= 1 && index < 42) {
/* 107 */         if (!func_75135_a(itemStackInSlot, 0, 1, false)) {
/* 108 */           return ItemStack.field_190927_a;
/*     */         }
/* 110 */       } else if (!func_75135_a(itemStackInSlot, 6, 41, false)) {
/* 111 */         return ItemStack.field_190927_a;
/*     */       } 
/* 113 */       if (itemStackInSlot.func_190926_b()) {
/* 114 */         slot.func_75215_d(ItemStack.field_190927_a);
/*     */       } else {
/* 116 */         slot.func_75218_e();
/*     */       } 
/* 118 */       if (itemStackInSlot.func_190916_E() == itemStack.func_190916_E()) {
/* 119 */         return ItemStack.field_190927_a;
/*     */       }
/* 121 */       slot.func_190901_a(player, itemStackInSlot);
/*     */     } 
/* 123 */     return itemStack;
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\gui\ContainerConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */