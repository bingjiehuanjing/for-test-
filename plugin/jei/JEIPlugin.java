/*    */ package rikuto.manaita_plus.plugin.jei;
/*    */ 
/*    */ import mezz.jei.api.IModPlugin;
/*    */ import mezz.jei.api.IModRegistry;
/*    */ import mezz.jei.api.JEIPlugin;
/*    */ import rikuto.manaita_plus.gui.ContainerBrewingManaita;
/*    */ import rikuto.manaita_plus.gui.ContainerCraftingManaita;
/*    */ import rikuto.manaita_plus.gui.ContainerFurnaceManaita;
/*    */ import rikuto.manaita_plus.gui.GuiBrewingManaita;
/*    */ import rikuto.manaita_plus.gui.GuiCraftingManaita;
/*    */ import rikuto.manaita_plus.gui.GuiFurnaceManaita;
/*    */ 
/*    */ @JEIPlugin
/*    */ public class JEIPlugin
/*    */   implements IModPlugin {
/*    */   public void register(IModRegistry registry) {
/* 17 */     registry.addRecipeClickArea(GuiCraftingManaita.class, 88, 32, 28, 23, new String[] { "minecraft.crafting" });
/* 18 */     registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerCraftingManaita.class, "minecraft.crafting", 1, 9, 10, 36);
/* 19 */     registry.addRecipeClickArea(GuiFurnaceManaita.class, 78, 32, 28, 23, new String[] { "minecraft.smelting" });
/* 20 */     registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerFurnaceManaita.class, "minecraft.smelting", 0, 1, 2, 36);
/* 21 */     registry.addRecipeClickArea(GuiBrewingManaita.class, 97, 16, 14, 30, new String[] { "minecraft.brewing" });
/* 22 */     registry.getRecipeTransferRegistry().addRecipeTransferHandler(ContainerBrewingManaita.class, "minecraft.brewing", 0, 4, 4, 36);
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\plugin\jei\JEIPlugin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */