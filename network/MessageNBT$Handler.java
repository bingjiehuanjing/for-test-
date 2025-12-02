/*    */ package rikuto.manaita_plus.network;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ import rikuto.manaita_plus.gui.ContainerConfig;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Handler
/*    */   implements IMessageHandler<MessageNBT, IMessage>
/*    */ {
/*    */   public IMessage onMessage(MessageNBT nbt, MessageContext context) {
/* 46 */     ItemStack itemStack = ((ContainerConfig)(context.getServerHandler()).field_147369_b.field_71070_bA).slot.func_70301_a(0);
/* 47 */     if (!itemStack.func_190926_b())
/* 48 */       switch (nbt.type) {
/*    */         case 0:
/* 50 */           itemStack.func_77978_p().func_74757_a(nbt.key, !itemStack.func_77978_p().func_74767_n(nbt.key));
/*    */           break;
/*    */         case 1:
/* 53 */           itemStack.func_77978_p().func_74768_a(nbt.key, itemStack.func_77978_p().func_74762_e(nbt.key) + nbt.valueInt); break;
/*    */       }  
/* 55 */     return null;
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\network\MessageNBT$Handler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */