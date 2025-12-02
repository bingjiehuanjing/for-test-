/*    */ package rikuto.manaita_plus.network;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ import rikuto.manaita_plus.gui.ContainerConfig;
/*    */ 
/*    */ public class MessageNBT
/*    */   implements IMessage {
/*    */   public int type;
/*    */   public String key;
/*    */   public int valueInt;
/*    */   
/*    */   public MessageNBT() {}
/*    */   
/*    */   public MessageNBT(String name) {
/* 20 */     this.type = 0;
/* 21 */     this.key = name;
/* 22 */     this.valueInt = 0;
/*    */   }
/*    */   
/*    */   public MessageNBT(String name, int value) {
/* 26 */     this.type = 1;
/* 27 */     this.key = name;
/* 28 */     this.valueInt = value;
/*    */   }
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 32 */     this.type = buf.readInt();
/* 33 */     this.key = ByteBufUtils.readUTF8String(buf);
/* 34 */     this.valueInt = buf.readInt();
/*    */   }
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 38 */     buf.writeInt(this.type);
/* 39 */     ByteBufUtils.writeUTF8String(buf, this.key);
/* 40 */     buf.writeInt(this.valueInt);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<MessageNBT, IMessage> {
/*    */     public IMessage onMessage(MessageNBT nbt, MessageContext context) {
/* 46 */       ItemStack itemStack = ((ContainerConfig)(context.getServerHandler()).field_147369_b.field_71070_bA).slot.func_70301_a(0);
/* 47 */       if (!itemStack.func_190926_b())
/* 48 */         switch (nbt.type) {
/*    */           case 0:
/* 50 */             itemStack.func_77978_p().func_74757_a(nbt.key, !itemStack.func_77978_p().func_74767_n(nbt.key));
/*    */             break;
/*    */           case 1:
/* 53 */             itemStack.func_77978_p().func_74768_a(nbt.key, itemStack.func_77978_p().func_74762_e(nbt.key) + nbt.valueInt); break;
/*    */         }  
/* 55 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\network\MessageNBT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */