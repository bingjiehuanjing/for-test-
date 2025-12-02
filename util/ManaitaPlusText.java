/*    */ package rikuto.manaita_plus.util;
/*    */ 
/*    */ import net.minecraft.util.text.TextFormatting;
/*    */ 
/*    */ public class ManaitaPlusText
/*    */ {
/*  7 */   private static final TextFormatting[] infinity = new TextFormatting[] { TextFormatting.RED, TextFormatting.GOLD, TextFormatting.YELLOW, TextFormatting.GREEN, TextFormatting.AQUA, TextFormatting.BLUE, TextFormatting.LIGHT_PURPLE };
/*    */   
/*    */   public static String makeInfinityText(String input) {
/* 10 */     return formatting(input, infinity, 80.0D);
/*    */   }
/*    */   
/* 13 */   private static final TextFormatting[] mode = new TextFormatting[] { TextFormatting.YELLOW, TextFormatting.YELLOW, TextFormatting.YELLOW, TextFormatting.YELLOW, TextFormatting.YELLOW, TextFormatting.YELLOW, TextFormatting.GOLD, TextFormatting.RED, TextFormatting.YELLOW, TextFormatting.YELLOW, TextFormatting.YELLOW, TextFormatting.YELLOW, TextFormatting.YELLOW, TextFormatting.YELLOW, TextFormatting.GOLD, TextFormatting.RED };
/*    */   
/*    */   public static String makeModeText(String input) {
/* 16 */     return formatting(input, mode, 120.0D);
/*    */   }
/*    */   
/*    */   public static String formatting(String input, TextFormatting[] colours, double delay) {
/* 20 */     StringBuilder sb = new StringBuilder(input.length() * 3);
/* 21 */     if (delay <= 0.0D)
/* 22 */       delay = 0.001D; 
/* 23 */     int offset = (int)Math.floor((System.currentTimeMillis() & 0x3FFFL) / delay) % colours.length;
/* 24 */     for (int i = 0; i < input.length(); i++) {
/* 25 */       char c = input.charAt(i);
/* 26 */       int col = (i + colours.length - offset) % colours.length;
/* 27 */       sb.append(colours[col].toString());
/* 28 */       sb.append(c);
/*    */     } 
/* 30 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plu\\util\ManaitaPlusText.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */