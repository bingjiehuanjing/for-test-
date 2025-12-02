/*    */ package rikuto.manaita_plus.network;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ 
/*    */ public class MessageStepHeight
/*    */   implements IMessage {
/*    */   public float height;
/*    */   
/*    */   public MessageStepHeight() {}
/*    */   
/*    */   public MessageStepHeight(float height) {
/* 16 */     this.height = height;
/*    */   }
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 20 */     this.height = buf.readFloat();
/*    */   }
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 24 */     buf.writeFloat(this.height);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<MessageStepHeight, IMessage> {
/*    */     public IMessage onMessage(final MessageStepHeight stepHeight, MessageContext ctx) {
/* 30 */       Minecraft.func_71410_x().func_152344_a(new Runnable()
/*    */           {
/*    */             public void run() {
/* 33 */               (Minecraft.func_71410_x()).field_71439_g.field_70138_W = stepHeight.height;
/*    */             }
/*    */           });
/* 36 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\network\MessageStepHeight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */