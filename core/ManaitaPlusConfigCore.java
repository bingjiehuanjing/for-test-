/*    */ package rikuto.manaita_plus.core;
/*    */ 
/*    */ import net.minecraftforge.common.config.Configuration;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ import scala.Int;
/*    */ 
/*    */ public class ManaitaPlusConfigCore
/*    */ {
/*    */   public static final String DOUBLING = "Doubling";
/*    */   public static final String MODE = "Mode";
/*    */   public static Configuration cfg;
/* 12 */   public static int craftingDoubling = 64;
/* 13 */   public static int furnaceDoubling = 64;
/* 14 */   public static int brewingDoubling = 64;
/* 15 */   public static int toolsDoubling = 64;
/* 16 */   public static int weaponsDoubling = 64;
/* 17 */   public static int sourceDoubling = 64;
/*    */   public static boolean alwaysManaita = false;
/*    */   public static boolean easyMode = false;
/*    */   
/*    */   public static void loadConfig(FMLPreInitializationEvent event) {
/* 22 */     cfg = new Configuration(event.getSuggestedConfigurationFile(), true);
/* 23 */     syncConfig();
/*    */   }
/*    */   
/*    */   public static void syncConfig() {
/* 27 */     craftingDoubling = cfg.getInt("craftingDoubling", "Doubling", craftingDoubling, 1, Int.MaxValue(), "", "config.manaita_plus.prop.craftingDoubling");
/* 28 */     furnaceDoubling = cfg.getInt("furnaceDoubling", "Doubling", furnaceDoubling, 1, Int.MaxValue(), "", "config.manaita_plus.prop.furnaceDoubling");
/* 29 */     brewingDoubling = cfg.getInt("brewingDoubling", "Doubling", brewingDoubling, 1, Int.MaxValue(), "", "config.manaita_plus.prop.brewingDoubling");
/* 30 */     toolsDoubling = cfg.getInt("toolsDoubling", "Doubling", toolsDoubling, 1, Int.MaxValue(), "", "config.manaita_plus.prop.toolsDoubling");
/* 31 */     weaponsDoubling = cfg.getInt("weaponsDoubling", "Doubling", weaponsDoubling, 1, Int.MaxValue(), "", "config.manaita_plus.prop.weaponsDoubling");
/* 32 */     sourceDoubling = cfg.getInt("sourceDoubling", "Doubling", sourceDoubling, 1, Int.MaxValue(), "", "config.manaita_plus.prop.sourceDoubling");
/* 33 */     alwaysManaita = cfg.getBoolean("alwaysManaita", "Mode", alwaysManaita, "", "config.manaita_plus.prop.alwaysManaita");
/* 34 */     easyMode = cfg.getBoolean("easyMode", "Mode", easyMode, "", "config.manaita_plus.prop.easyMode");
/* 35 */     cfg.save();
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\core\ManaitaPlusConfigCore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */