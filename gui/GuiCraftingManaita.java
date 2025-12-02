/*    */ package rikuto.manaita_plus.gui;
/*    */ 
/*    */ import net.minecraft.client.gui.inventory.GuiCrafting;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class GuiCraftingManaita
/*    */   extends GuiCrafting {
/*    */   private int magnification;
/*    */   
/*    */   public GuiCraftingManaita(InventoryPlayer playerInv, World world, BlockPos pos, int doubling) {
/* 14 */     super(playerInv, world, pos);
/* 15 */     this.magnification = doubling;
/*    */   }
/*    */   
/*    */   protected void func_146979_b(int mouseX, int mouseY) {
/* 19 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.manaita", new Object[0]), 28, 6, 4210752);
/* 20 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
/* 21 */     this.field_146289_q.func_78276_b(this.magnification + "x", 120, 20, 4210752);
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\gui\GuiCraftingManaita.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */