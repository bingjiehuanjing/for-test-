/*     */ package rikuto.manaita_plus.block;
/*     */ 
/*     */ import net.minecraft.util.IStringSerializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum EnumType
/*     */   implements IStringSerializable
/*     */ {
/* 182 */   NORMAL(0, "normal"),
/* 183 */   WOODEN(1, "wooden"),
/* 184 */   STONE(2, "stone"),
/* 185 */   IRON(3, "iron"),
/* 186 */   GOLD(4, "gold"),
/* 187 */   DIAMOND(5, "diamond"),
/* 188 */   EMERALD(6, "emerald"),
/* 189 */   REDSTONE(7, "redstone"); private static final EnumType[] META_LOOKUP;
/*     */   static {
/* 191 */     META_LOOKUP = new EnumType[(values()).length];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     for (EnumType enumType : values())
/* 197 */       META_LOOKUP[enumType.getMetadata()] = enumType; 
/*     */   }
/*     */   private final int meta; private final String name;
/*     */   
/*     */   EnumType(int metaNum, String nameStr) {
/* 202 */     this.meta = metaNum;
/* 203 */     this.name = nameStr;
/*     */   }
/*     */   
/*     */   public int getMetadata() {
/* 207 */     return this.meta;
/*     */   }
/*     */   
/*     */   public static EnumType fromMetadata(int meta) {
/* 211 */     if (meta < 0 || meta >= META_LOOKUP.length) {
/* 212 */       meta = 0;
/*     */     }
/* 214 */     return META_LOOKUP[meta];
/*     */   }
/*     */   
/*     */   public String toString() {
/* 218 */     return this.name;
/*     */   }
/*     */   
/*     */   public String func_176610_l() {
/* 222 */     return this.name;
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\block\BlockManaita$EnumType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */