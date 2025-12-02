/*    */ package rikuto.manaita_plus.block;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemBlockManaita
/*    */   extends ItemBlock {
/*    */   public ItemBlockManaita(Block block) {
/* 10 */     super(block);
/* 11 */     func_77656_e(0);
/* 12 */     func_77627_a(true);
/*    */   }
/*    */   
/*    */   public int func_77647_b(int meta) {
/* 16 */     return meta;
/*    */   }
/*    */   
/*    */   public String func_77667_c(ItemStack itemStack) {
/* 20 */     return (itemStack.func_77952_i() == 0) ? func_77658_a() : (func_77658_a() + "." + BlockManaita.EnumType.fromMetadata(itemStack.func_77952_i()).func_176610_l());
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\block\ItemBlockManaita.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */