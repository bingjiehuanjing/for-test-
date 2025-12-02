/*    */ package rikuto.manaita_plus.gui;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.ContainerWorkbench;
/*    */ import net.minecraft.inventory.InventoryCraftResult;
/*    */ import net.minecraft.inventory.InventoryCrafting;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.crafting.CraftingManager;
/*    */ import net.minecraft.item.crafting.IRecipe;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.server.SPacketSetSlot;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ContainerCraftingManaita extends ContainerWorkbench {
/*    */   private World worldObj;
/*    */   private int magnification;
/*    */   
/*    */   public ContainerCraftingManaita(InventoryPlayer playerInv, World world, BlockPos pos, int doubling) {
/* 23 */     super(playerInv, world, pos);
/* 24 */     this.worldObj = world;
/* 25 */     this.magnification = doubling;
/*    */   }
/*    */   
/*    */   protected void func_192389_a(World world, EntityPlayer player, InventoryCrafting craftingInv, InventoryCraftResult result) {
/* 29 */     if (!world.field_72995_K) {
/* 30 */       EntityPlayerMP playerMP = (EntityPlayerMP)player;
/* 31 */       ItemStack itemStack = ItemStack.field_190927_a;
/* 32 */       IRecipe iRecipe = CraftingManager.func_192413_b(craftingInv, world);
/* 33 */       if (iRecipe != null) {
/* 34 */         result.func_193056_a(iRecipe);
/* 35 */         itemStack = iRecipe.func_77572_b(craftingInv);
/* 36 */         itemStack.func_190920_e(itemStack.func_190916_E() * this.magnification);
/*    */       } 
/* 38 */       result.func_70299_a(0, itemStack);
/* 39 */       playerMP.field_71135_a.func_147359_a((Packet)new SPacketSetSlot(this.field_75152_c, 0, itemStack));
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer player) {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public ItemStack func_82846_b(EntityPlayer player, int index) {
/* 48 */     ItemStack itemStack = ItemStack.field_190927_a;
/* 49 */     Slot slot = this.field_75151_b.get(index);
/*    */     
/* 51 */     if (slot != null && slot.func_75216_d()) {
/* 52 */       ItemStack itemStackInSlot = slot.func_75211_c();
/* 53 */       itemStack = itemStackInSlot.func_77946_l();
/*    */       
/* 55 */       if (index == 0) {
/* 56 */         itemStackInSlot.func_77973_b().func_77622_d(itemStackInSlot, this.worldObj, player);
/*    */         
/* 58 */         if (!func_75135_a(itemStackInSlot, 10, 46, true)) {
/* 59 */           return ItemStack.field_190927_a;
/*    */         }
/* 61 */         slot.func_75220_a(itemStackInSlot, itemStack);
/*    */       }
/* 63 */       else if (index >= 10 && index < 37) {
/* 64 */         if (!func_75135_a(itemStackInSlot, 37, 46, false)) {
/* 65 */           return ItemStack.field_190927_a;
/*    */         }
/* 67 */       } else if (index >= 37 && index < 46) {
/* 68 */         if (!func_75135_a(itemStackInSlot, 10, 37, false)) {
/* 69 */           return ItemStack.field_190927_a;
/*    */         }
/* 71 */       } else if (!func_75135_a(itemStackInSlot, 10, 46, false)) {
/* 72 */         return ItemStack.field_190927_a;
/*    */       } 
/* 74 */       if (itemStackInSlot.func_190926_b()) {
/* 75 */         slot.func_75215_d(ItemStack.field_190927_a);
/*    */       } else {
/* 77 */         slot.func_75218_e();
/*    */       } 
/* 79 */       if (itemStackInSlot.func_190916_E() == itemStack.func_190916_E()) {
/* 80 */         return ItemStack.field_190927_a;
/*    */       }
/* 82 */       if (index == 0)
/* 83 */         if (!player.func_70089_S() || (player instanceof EntityPlayerMP && ((EntityPlayerMP)player).func_193105_t())) {
/* 84 */           player.func_71019_a(slot.func_190901_a(player, itemStackInSlot), false);
/*    */         } else {
/* 86 */           player.field_71071_by.func_191975_a(this.worldObj, slot.func_190901_a(player, itemStackInSlot));
/*    */         }  
/* 88 */     }  return itemStack;
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\gui\ContainerCraftingManaita.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */