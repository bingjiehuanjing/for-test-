/*    */ package rikuto.manaita_plus.network;
/*    */ 
/*    */ import baubles.api.BaublesApi;
/*    */ import baubles.api.cap.IBaublesItemHandler;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumHand;
/*    */ import net.minecraftforge.fml.common.Loader;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ import rikuto.manaita_plus.ManaitaPlus;
/*    */ import rikuto.manaita_plus.core.ManaitaPlusConfigCore;
/*    */ import rikuto.manaita_plus.item.IManaitaKey;
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
/*    */   implements IMessageHandler<MessageKey, IMessage>
/*    */ {
/*    */   public IMessage onMessage(MessageKey key, MessageContext context) {
/* 39 */     EntityPlayerMP player = (context.getServerHandler()).field_147369_b;
/* 40 */     switch (key.key) {
/*    */       case 0:
/* 42 */         for (EnumHand enumHand : EnumHand.values()) {
/* 43 */           ItemStack heldItem = player.func_184586_b(enumHand);
/* 44 */           if (!heldItem.func_190926_b() && heldItem.func_77973_b() instanceof IManaitaKey && (
/* 45 */             (IManaitaKey)heldItem.func_77973_b()).onManaitaKeyPress(player.field_70170_p, (EntityPlayer)player, heldItem))
/*    */             // Byte code: goto -> 358 
/*    */         } 
/* 48 */         if (Loader.isModLoaded("baubles")) {
/* 49 */           IBaublesItemHandler baubles = BaublesApi.getBaublesHandler((EntityPlayer)player);
/* 50 */           for (int i = 0; i < baubles.getSlots(); i++) {
/* 51 */             ItemStack itemStackInSlot = baubles.getStackInSlot(i);
/* 52 */             if (!itemStackInSlot.func_190926_b() && itemStackInSlot.func_77973_b() instanceof IManaitaKey && (
/* 53 */               (IManaitaKey)itemStackInSlot.func_77973_b()).onManaitaKeyPress(player.field_70170_p, (EntityPlayer)player, itemStackInSlot))
/*    */               // Byte code: goto -> 358 
/*    */           } 
/*    */         } 
/* 57 */         player.openGui(ManaitaPlus.instance, 0, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*    */         break;
/*    */       case 1:
/* 60 */         if (ManaitaPlusConfigCore.alwaysManaita)
/* 61 */           player.openGui(ManaitaPlus.instance, 1, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v); 
/*    */         break;
/*    */       case 2:
/* 64 */         if (ManaitaPlusConfigCore.alwaysManaita)
/* 65 */           player.openGui(ManaitaPlus.instance, 9, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v); 
/*    */         break;
/*    */       case 3:
/* 68 */         if (ManaitaPlusConfigCore.alwaysManaita)
/* 69 */           player.openGui(ManaitaPlus.instance, 17, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);  break;
/*    */     } 
/* 71 */     return null;
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\network\MessageKey$Handler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */