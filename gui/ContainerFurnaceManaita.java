/*     */ package rikuto.manaita_plus.gui;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryBasic;
/*     */ import net.minecraft.inventory.InventoryCraftResult;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.FurnaceRecipes;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ContainerFurnaceManaita
/*     */   extends Container {
/*  17 */   private IInventory outputSlot = (IInventory)new InventoryCraftResult();
/*  18 */   private IInventory inputSlots = (IInventory)new InventoryBasic("FurnaceManaita", false, 1);
/*     */   private World worldObj;
/*     */   private int magnification;
/*     */   
/*     */   public ContainerFurnaceManaita(InventoryPlayer playerInv, World world, BlockPos pos, int doubling) {
/*  23 */     this.worldObj = world;
/*  24 */     this.magnification = doubling;
/*  25 */     func_75146_a(new Slot(this.inputSlots, 0, 56, 17));
/*  26 */     func_75146_a(new Slot(this.outputSlot, 0, 116, 35) {
/*     */           public boolean func_75214_a(ItemStack itemStack) {
/*  28 */             return false;
/*     */           }
/*     */         });
/*  31 */     for (int i = 0; i < 3; i++) {
/*  32 */       for (int j = 0; j < 9; j++)
/*  33 */         func_75146_a(new Slot((IInventory)playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18)); 
/*  34 */     }  for (int k = 0; k < 9; k++)
/*  35 */       func_75146_a(new Slot((IInventory)playerInv, k, 8 + k * 18, 142)); 
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer player) {
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   public void func_75142_b() {
/*  43 */     super.func_75142_b();
/*  44 */     if (canSmelt())
/*  45 */       smeltItem(); 
/*     */   }
/*     */   
/*     */   private boolean canSmelt() {
/*  49 */     if (this.inputSlots.func_70301_a(0).func_190926_b()) {
/*  50 */       return false;
/*     */     }
/*  52 */     ItemStack itemStack = FurnaceRecipes.func_77602_a().func_151395_a(this.inputSlots.func_70301_a(0));
/*  53 */     if (itemStack.func_190926_b()) {
/*  54 */       return false;
/*     */     }
/*  56 */     if (this.outputSlot.func_70301_a(0).func_190926_b()) {
/*  57 */       return true;
/*     */     }
/*  59 */     if (!this.outputSlot.func_70301_a(0).func_77969_a(itemStack))
/*  60 */       return false; 
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public void smeltItem() {
/*  65 */     ItemStack itemStack = FurnaceRecipes.func_77602_a().func_151395_a(this.inputSlots.func_70301_a(0)).func_77946_l();
/*  66 */     itemStack.func_190920_e(itemStack.func_190916_E() * this.magnification);
/*  67 */     if (this.outputSlot.func_70301_a(0).func_190926_b()) {
/*  68 */       this.outputSlot.func_70299_a(0, itemStack);
/*  69 */     } else if (this.outputSlot.func_70301_a(0).func_77969_a(itemStack)) {
/*  70 */       this.outputSlot.func_70301_a(0).func_190917_f(itemStack.func_190916_E());
/*     */     } 
/*  72 */     if (this.inputSlots.func_70301_a(0).func_190916_E() <= 1) {
/*  73 */       this.inputSlots.func_70299_a(0, ItemStack.field_190927_a);
/*     */     } else {
/*  75 */       this.inputSlots.func_70301_a(0).func_190918_g(1);
/*     */     } 
/*     */   }
/*     */   public void func_75134_a(EntityPlayer player) {
/*  79 */     super.func_75134_a(player);
/*  80 */     if (!this.worldObj.field_72995_K) {
/*  81 */       IInventory[] inventories = { this.inputSlots, this.outputSlot };
/*  82 */       for (IInventory inventory : inventories)
/*  83 */         func_193327_a(player, this.worldObj, inventory); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int index) {
/*  88 */     ItemStack itemStack = ItemStack.field_190927_a;
/*  89 */     Slot slot = this.field_75151_b.get(index);
/*     */     
/*  91 */     if (slot != null && slot.func_75216_d()) {
/*  92 */       ItemStack itemStackInSlot = slot.func_75211_c();
/*  93 */       itemStack = itemStackInSlot.func_77946_l();
/*     */       
/*  95 */       if (index == 1) {
/*  96 */         if (!func_75135_a(itemStackInSlot, 2, 38, true)) {
/*  97 */           return ItemStack.field_190927_a;
/*     */         }
/*  99 */         slot.func_75220_a(itemStackInSlot, itemStack);
/*     */       }
/* 101 */       else if (index != 1 && index != 0) {
/* 102 */         if (!FurnaceRecipes.func_77602_a().func_151395_a(itemStackInSlot).func_190926_b()) {
/* 103 */           if (!func_75135_a(itemStackInSlot, 0, 1, false)) {
/* 104 */             return ItemStack.field_190927_a;
/*     */           }
/* 106 */         } else if (index >= 2 && index < 29) {
/* 107 */           if (!func_75135_a(itemStackInSlot, 29, 38, false)) {
/* 108 */             return ItemStack.field_190927_a;
/*     */           }
/* 110 */         } else if (index >= 29 && index < 38 && !func_75135_a(itemStackInSlot, 2, 29, false)) {
/* 111 */           return ItemStack.field_190927_a;
/*     */         } 
/* 113 */       } else if (!func_75135_a(itemStackInSlot, 2, 38, false)) {
/* 114 */         return ItemStack.field_190927_a;
/*     */       } 
/* 116 */       if (itemStackInSlot.func_190926_b()) {
/* 117 */         slot.func_75215_d(ItemStack.field_190927_a);
/*     */       } else {
/* 119 */         slot.func_75218_e();
/*     */       } 
/* 121 */       if (itemStackInSlot.func_190916_E() == itemStack.func_190916_E()) {
/* 122 */         return ItemStack.field_190927_a;
/*     */       }
/* 124 */       slot.func_190901_a(player, itemStackInSlot);
/*     */     } 
/* 126 */     return itemStack;
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\gui\ContainerFurnaceManaita.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */