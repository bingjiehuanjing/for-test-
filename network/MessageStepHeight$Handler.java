/*    */ package rikuto.manaita_plus.network;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
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
/*    */   implements IMessageHandler<MessageStepHeight, IMessage>
/*    */ {
/*    */   public IMessage onMessage(final MessageStepHeight stepHeight, MessageContext ctx) {
/* 30 */     Minecraft.func_71410_x().func_152344_a(new Runnable()
/*    */         {
/*    */           public void run() {
/* 33 */             (Minecraft.func_71410_x()).field_71439_g.field_70138_W = stepHeight.height;
/*    */           }
/*    */         });
/* 36 */     return null;
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\network\MessageStepHeight$Handler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */