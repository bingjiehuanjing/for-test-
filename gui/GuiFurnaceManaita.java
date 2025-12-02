/*    */ package rikuto.manaita_plus.gui;
/*    */ 
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class GuiFurnaceManaita
/*    */   extends GuiContainer {
/* 13 */   private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/furnace.png");
/*    */   private int magnification;
/*    */   
/*    */   public GuiFurnaceManaita(InventoryPlayer playerInv, World world, BlockPos pos, int doubling) {
/* 17 */     super(new ContainerFurnaceManaita(playerInv, world, pos, doubling));
/* 18 */     this.magnification = doubling;
/*    */   }
/*    */   
/*    */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
/* 22 */     func_146276_q_();
/* 23 */     super.func_73863_a(mouseX, mouseY, partialTicks);
/* 24 */     func_191948_b(mouseX, mouseY);
/*    */   }
/*    */   
/*    */   protected void func_146979_b(int mouseX, int mouseY) {
/* 28 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.manaita", new Object[0]), this.field_146999_f / 2 - this.field_146289_q.func_78256_a(I18n.func_135052_a("container.manaita", new Object[0])) / 2, 6, 4210752);
/* 29 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.inventory", new Object[0]), 8, this.field_147000_g - 96 + 2, 4210752);
/* 30 */     this.field_146289_q.func_78276_b(this.magnification + "x", 112, 20, 4210752);
/*    */   }
/*    */   
/*    */   protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
/* 34 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 35 */     this.field_146297_k.func_110434_K().func_110577_a(FURNACE_GUI_TEXTURES);
/* 36 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/* 37 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/* 38 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/*    */     
/* 40 */     int k = 13;
/* 41 */     func_73729_b(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\gui\GuiFurnaceManaita.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */