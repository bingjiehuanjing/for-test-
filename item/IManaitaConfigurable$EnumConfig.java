/*    */ package rikuto.manaita_plus.item;
/*    */ 
/*    */ import net.minecraft.util.IStringSerializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum EnumConfig
/*    */   implements IStringSerializable
/*    */ {
/* 13 */   DOUBLING("Doubling"),
/* 14 */   SILKTOUCH("SilkTouch"),
/* 15 */   CAN_HARVEST("CanHarvest"),
/* 16 */   DIG_RANGE("DigRange", 14),
/* 17 */   DIG_DEPTH("DigDepth", 27),
/* 18 */   DIG_UNDER_PLAYER("DigUnderPlayer"),
/* 19 */   ATTACK_AREA("AttackArea", 14),
/* 20 */   ATTACK_FRIENDLY_MOB("AttackFriendlyMob"),
/* 21 */   NIGHT_VISION("NightVision"),
/* 22 */   INVISIBILITY("Invisibility"),
/* 23 */   STEP_ASSIST("StepAssist"),
/* 24 */   MOVE_SPEED("MoveSpeed", 8),
/* 25 */   JUMP_BOOST("JumpBoost", 8);
/*    */   
/*    */   private final int type;
/*    */   private final String name;
/*    */   private final int max;
/*    */   
/*    */   EnumConfig(String nameStr) {
/* 32 */     this.type = 0;
/* 33 */     this.name = nameStr;
/* 34 */     this.max = 0;
/*    */   }
/*    */   
/*    */   EnumConfig(String nameStr, int maximum) {
/* 38 */     this.type = 1;
/* 39 */     this.name = nameStr;
/* 40 */     this.max = maximum;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 44 */     return this.name;
/*    */   }
/*    */   
/*    */   public int getType() {
/* 48 */     return this.type;
/*    */   }
/*    */   
/*    */   public String func_176610_l() {
/* 52 */     return this.name;
/*    */   }
/*    */   
/*    */   public int getMax() {
/* 56 */     return this.max;
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\item\IManaitaConfigurable$EnumConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */