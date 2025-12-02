/*    */ package rikuto.manaita_plus.render;
/*    */ 
/*    */ import javax.annotation.Nonnull;
/*    */ import net.minecraft.block.properties.IProperty;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import rikuto.manaita_plus.block.BlockHook;
/*    */ import rikuto.manaita_plus.tileentity.TileEntityHook;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderHook extends TileEntitySpecialRenderer<TileEntityHook> {
/*    */   public void render(@Nonnull TileEntityHook tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
/* 20 */     if (!tileEntity.func_145837_r()) {
/* 21 */       GlStateManager.func_179094_E();
/* 22 */       GlStateManager.func_179137_b(x, y, z);
/*    */       
/* 24 */       if (!tileEntity.getStack().func_190926_b()) {
/* 25 */         (Minecraft.func_71410_x()).field_71446_o.func_110577_a(TextureMap.field_110575_b);
/* 26 */         tileEntity.getStack().func_77973_b();
/* 27 */         GlStateManager.func_179094_E();
/* 28 */         switch ((EnumFacing)tileEntity.func_145831_w().func_180495_p(tileEntity.func_174877_v()).func_177229_b((IProperty)BlockHook.FACING)) {
/*    */           case NORTH:
/* 30 */             GlStateManager.func_179109_b(0.5F, 0.5F, 0.96875F);
/* 31 */             GlStateManager.func_179114_b(90.0F, 0.0F, 0.0F, 1.0F);
/*    */             break;
/*    */           case SOUTH:
/* 34 */             GlStateManager.func_179109_b(0.5F, 0.5F, 0.03125F);
/* 35 */             GlStateManager.func_179114_b(90.0F, 0.0F, 0.0F, 1.0F);
/*    */             break;
/*    */           case WEST:
/* 38 */             GlStateManager.func_179109_b(0.96875F, 0.5F, 0.5F);
/* 39 */             GlStateManager.func_179114_b(90.0F, 0.0F, 1.0F, 0.0F);
/* 40 */             GlStateManager.func_179114_b(90.0F, 0.0F, 0.0F, 1.0F);
/*    */             break;
/*    */           case EAST:
/* 43 */             GlStateManager.func_179109_b(0.03125F, 0.5F, 0.5F);
/* 44 */             GlStateManager.func_179114_b(90.0F, 0.0F, 1.0F, 0.0F);
/* 45 */             GlStateManager.func_179114_b(90.0F, 0.0F, 0.0F, 1.0F);
/*    */             break;
/*    */         } 
/*    */         
/* 49 */         Minecraft.func_71410_x().func_175599_af().func_181564_a(tileEntity.getStack(), ItemCameraTransforms.TransformType.NONE);
/* 50 */         GlStateManager.func_179121_F();
/*    */       } 
/*    */       
/* 53 */       GlStateManager.func_179121_F();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\render\RenderHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */