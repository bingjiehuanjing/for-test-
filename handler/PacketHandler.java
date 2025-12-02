/*    */ package rikuto.manaita_plus.handler;
/*    */ 
/*    */ import net.minecraftforge.fml.common.network.NetworkRegistry;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import rikuto.manaita_plus.network.MessageKey;
/*    */ import rikuto.manaita_plus.network.MessageNBT;
/*    */ import rikuto.manaita_plus.network.MessageStepHeight;
/*    */ 
/*    */ 
/*    */ public class PacketHandler
/*    */ {
/* 13 */   public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("manaita_plus");
/*    */   
/*    */   public static void init() {
/* 16 */     INSTANCE.registerMessage(MessageKey.Handler.class, MessageKey.class, 0, Side.SERVER);
/* 17 */     INSTANCE.registerMessage(MessageNBT.Handler.class, MessageNBT.class, 1, Side.SERVER);
/* 18 */     INSTANCE.registerMessage(MessageStepHeight.Handler.class, MessageStepHeight.class, 2, Side.CLIENT);
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\handler\PacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */