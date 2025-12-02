/*    */ package rikuto.manaita_plus.core;
/*    */ 
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.common.registry.EntityRegistry;
/*    */ import rikuto.manaita_plus.ManaitaPlus;
/*    */ import rikuto.manaita_plus.entity.EntityManaitaArrow;
/*    */ 
/*    */ public class ManaitaPlusEntityCore
/*    */ {
/*    */   public static void registerEntity() {
/* 11 */     EntityRegistry.registerModEntity(new ResourceLocation("manaita_plus", "manaita_arrow"), EntityManaitaArrow.class, "manaita_plus:ManaitaArrow", 1, ManaitaPlus.instance, 256, 10, true);
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\core\ManaitaPlusEntityCore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */