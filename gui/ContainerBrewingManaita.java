/*     */ package rikuto.manaita_plus.gui;
/*     */ 
/*     */ import net.minecraft.advancements.CriteriaTriggers;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryBasic;
/*     */ import net.minecraft.inventory.InventoryHelper;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.PotionHelper;
/*     */ import net.minecraft.potion.PotionType;
/*     */ import net.minecraft.potion.PotionUtils;
/*     */ import net.minecraft.util.NonNullList;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
/*     */ import net.minecraftforge.event.ForgeEventFactory;
/*     */ 
/*     */ public class ContainerBrewingManaita
/*     */   extends Container {
/*  24 */   private IInventory outputSlots = (IInventory)new InventoryBasic("BrewingManaita", false, 3);
/*  25 */   private IInventory inputSlots = (IInventory)new InventoryBasic("BrewingManaita", false, 1);
/*     */   private World worldObj;
/*     */   private BlockPos blockPos;
/*     */   private int magnification;
/*  29 */   private NonNullList<ItemStack> brewingItemStacks = NonNullList.func_191197_a(3, ItemStack.field_190927_a);
/*  30 */   private static final int[] OUTPUT_SLOTS = new int[] { 0, 1, 2 };
/*     */   
/*     */   public ContainerBrewingManaita(InventoryPlayer playerInv, World world, BlockPos pos, int doubling) {
/*  33 */     this.worldObj = world;
/*  34 */     this.blockPos = pos;
/*  35 */     this.magnification = doubling;
/*  36 */     func_75146_a(new Potion(this.outputSlots, 0, 56, 51));
/*  37 */     func_75146_a(new Potion(this.outputSlots, 1, 79, 58));
/*  38 */     func_75146_a(new Potion(this.outputSlots, 2, 102, 51));
/*  39 */     func_75146_a(new Ingredient(this.inputSlots, 0, 79, 17));
/*  40 */     for (int i = 0; i < 3; i++) {
/*  41 */       for (int j = 0; j < 9; j++)
/*  42 */         func_75146_a(new Slot((IInventory)playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18)); 
/*  43 */     }  for (int k = 0; k < 9; k++)
/*  44 */       func_75146_a(new Slot((IInventory)playerInv, k, 8 + k * 18, 142)); 
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer player) {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public void func_75142_b() {
/*  52 */     super.func_75142_b();
/*  53 */     if (canBrew())
/*  54 */       brewPotions(); 
/*     */   }
/*     */   
/*     */   private boolean canBrew() {
/*  58 */     for (int i = 0; i < this.outputSlots.func_70302_i_(); i++) {
/*  59 */       this.brewingItemStacks.set(i, this.outputSlots.func_70301_a(i));
/*     */     }
/*  61 */     boolean flag = BrewingRecipeRegistry.canBrew(this.brewingItemStacks, this.inputSlots.func_70301_a(0), OUTPUT_SLOTS);
/*  62 */     if (flag) {
/*  63 */       return true;
/*     */     }
/*  65 */     ItemStack itemStack = this.inputSlots.func_70301_a(0);
/*  66 */     if (itemStack.func_190926_b())
/*  67 */       return false; 
/*  68 */     if (!PotionHelper.func_185205_a(itemStack)) {
/*  69 */       return false;
/*     */     }
/*  71 */     for (int j = 0; j < this.outputSlots.func_70302_i_(); j++) {
/*  72 */       ItemStack potion = this.outputSlots.func_70301_a(j);
/*  73 */       if (!potion.func_190926_b() && PotionHelper.func_185208_a(potion, itemStack))
/*  74 */         return true; 
/*     */     } 
/*  76 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void brewPotions() {
/*  82 */     if (ForgeEventFactory.onPotionAttemptBrew(this.brewingItemStacks)) {
/*     */       return;
/*     */     }
/*  85 */     ItemStack ingredient = this.inputSlots.func_70301_a(0);
/*  86 */     for (int i = 0; i < this.outputSlots.func_70302_i_(); i++) {
/*  87 */       ItemStack potion = this.outputSlots.func_70301_a(i).func_77946_l();
/*  88 */       potion.func_190920_e(1);
/*  89 */       ItemStack output = BrewingRecipeRegistry.getOutput(potion, ingredient);
/*  90 */       if (!output.func_190926_b()) {
/*  91 */         output.func_190920_e(this.outputSlots.func_70301_a(i).func_190916_E() * this.magnification);
/*  92 */         this.outputSlots.func_70299_a(i, output);
/*     */       } 
/*     */     } 
/*  95 */     ingredient.func_190918_g(1);
/*     */     
/*  97 */     if (ingredient.func_77973_b().hasContainerItem(ingredient)) {
/*  98 */       ItemStack itemStack = ingredient.func_77973_b().getContainerItem(ingredient);
/*  99 */       if (ingredient.func_190926_b()) {
/* 100 */         ingredient = itemStack;
/*     */       } else {
/* 102 */         InventoryHelper.func_180173_a(this.worldObj, this.blockPos.func_177958_n(), this.blockPos.func_177956_o(), this.blockPos.func_177952_p(), itemStack);
/*     */       } 
/*     */     } 
/* 105 */     this.inputSlots.func_70299_a(0, ingredient);
/* 106 */     this.worldObj.func_175718_b(1035, this.blockPos, 0);
/* 107 */     ForgeEventFactory.onPotionBrewed(this.brewingItemStacks);
/*     */   }
/*     */   
/*     */   public void func_75134_a(EntityPlayer player) {
/* 111 */     super.func_75134_a(player);
/* 112 */     if (!this.worldObj.field_72995_K) {
/* 113 */       IInventory[] inventories = { this.inputSlots, this.outputSlots };
/* 114 */       for (IInventory inventory : inventories)
/* 115 */         func_193327_a(player, this.worldObj, inventory); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int index) {
/* 120 */     ItemStack itemStack = ItemStack.field_190927_a;
/* 121 */     Slot slot = this.field_75151_b.get(index);
/*     */     
/* 123 */     if (slot != null && slot.func_75216_d()) {
/* 124 */       ItemStack itemStackInSlot = slot.func_75211_c();
/* 125 */       itemStack = itemStackInSlot.func_77946_l();
/*     */       
/* 127 */       if ((index < 0 || index > 2) && index != 3) {
/* 128 */         if (((Slot)this.field_75151_b.get(3)).func_75214_a(itemStackInSlot)) {
/* 129 */           if (!func_75135_a(itemStackInSlot, 3, 4, false)) {
/* 130 */             return ItemStack.field_190927_a;
/*     */           }
/* 132 */         } else if (Potion.canHoldPotion(itemStack)) {
/* 133 */           if (!func_75135_a(itemStackInSlot, 0, 3, false)) {
/* 134 */             return ItemStack.field_190927_a;
/*     */           }
/* 136 */         } else if (index >= 4 && index < 31) {
/* 137 */           if (!func_75135_a(itemStackInSlot, 31, 40, false)) {
/* 138 */             return ItemStack.field_190927_a;
/*     */           }
/* 140 */         } else if (index >= 31 && index < 40) {
/* 141 */           if (!func_75135_a(itemStackInSlot, 4, 31, false)) {
/* 142 */             return ItemStack.field_190927_a;
/*     */           }
/* 144 */         } else if (!func_75135_a(itemStackInSlot, 4, 40, false)) {
/* 145 */           return ItemStack.field_190927_a;
/*     */         } 
/*     */       } else {
/* 148 */         if (!func_75135_a(itemStackInSlot, 4, 40, true)) {
/* 149 */           return ItemStack.field_190927_a;
/*     */         }
/* 151 */         slot.func_75220_a(itemStackInSlot, itemStack);
/*     */       } 
/*     */       
/* 154 */       if (itemStackInSlot.func_190926_b()) {
/* 155 */         slot.func_75215_d(ItemStack.field_190927_a);
/*     */       } else {
/* 157 */         slot.func_75218_e();
/*     */       } 
/* 159 */       if (itemStackInSlot.func_190916_E() == itemStack.func_190916_E()) {
/* 160 */         return ItemStack.field_190927_a;
/*     */       }
/* 162 */       slot.func_190901_a(player, itemStackInSlot);
/*     */     } 
/*     */     
/* 165 */     return itemStack;
/*     */   }
/*     */   
/*     */   static class Ingredient
/*     */     extends Slot {
/*     */     public Ingredient(IInventory inventory, int index, int xPosition, int yPosition) {
/* 171 */       super(inventory, index, xPosition, yPosition);
/*     */     }
/*     */     
/*     */     public boolean func_75214_a(ItemStack itemStack) {
/* 175 */       return BrewingRecipeRegistry.isValidIngredient(itemStack);
/*     */     }
/*     */   }
/*     */   
/*     */   static class Potion
/*     */     extends Slot {
/*     */     public Potion(IInventory inventory, int index, int xPosition, int yPosition) {
/* 182 */       super(inventory, index, xPosition, yPosition);
/*     */     }
/*     */     
/*     */     public boolean func_75214_a(ItemStack itemStack) {
/* 186 */       return canHoldPotion(itemStack);
/*     */     }
/*     */     
/*     */     public ItemStack func_190901_a(EntityPlayer player, ItemStack itemStack) {
/* 190 */       PotionType potionType = PotionUtils.func_185191_c(itemStack);
/* 191 */       if (player instanceof EntityPlayerMP) {
/* 192 */         ForgeEventFactory.onPlayerBrewedPotion(player, itemStack);
/* 193 */         CriteriaTriggers.field_192130_j.func_192173_a((EntityPlayerMP)player, potionType);
/*     */       } 
/* 195 */       super.func_190901_a(player, itemStack);
/* 196 */       return itemStack;
/*     */     }
/*     */     
/*     */     public static boolean canHoldPotion(ItemStack itemStack) {
/* 200 */       ItemStack potion = itemStack.func_77946_l();
/* 201 */       potion.func_190920_e(1);
/* 202 */       return BrewingRecipeRegistry.isValidInput(potion);
/*     */     }
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\gui\ContainerBrewingManaita.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */