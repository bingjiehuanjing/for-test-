/*    */ package rikuto.manaita_plus.proxy;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraftforge.common.config.ConfigElement;
/*    */ import net.minecraftforge.fml.client.IModGuiFactory;
/*    */ import net.minecraftforge.fml.client.config.GuiConfig;
/*    */ import net.minecraftforge.fml.client.config.IConfigElement;
/*    */ import rikuto.manaita_plus.core.ManaitaPlusConfigCore;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiFactory
/*    */   implements IModGuiFactory
/*    */ {
/*    */   public void initialize(Minecraft minecraftInstance) {}
/*    */   
/*    */   public boolean hasConfigGui() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public GuiScreen createConfigGui(GuiScreen parentScreen) {
/* 26 */     return (GuiScreen)new ConfigGui(parentScreen);
/*    */   }
/*    */   
/*    */   public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories() {
/* 30 */     return null;
/*    */   }
/*    */   
/*    */   public static class ConfigGui
/*    */     extends GuiConfig {
/*    */     public ConfigGui(GuiScreen parent) {
/* 36 */       super(parent, GuiFactory.getConfigElements(), "manaita_plus", false, false, "Manaita Plus");
/*    */     }
/*    */   }
/*    */   
/*    */   private static List<IConfigElement> getConfigElements() {
/* 41 */     List<IConfigElement> list = Lists.newArrayList();
/* 42 */     for (String category : ManaitaPlusConfigCore.cfg.getCategoryNames())
/* 43 */       list.addAll((new ConfigElement(ManaitaPlusConfigCore.cfg.getCategory(category))).getChildElements()); 
/* 44 */     return list;
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\proxy\GuiFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */