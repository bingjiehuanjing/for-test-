/*    */ package rikuto.manaita_plus.util;
/*    */ 
/*    */ import com.google.common.io.ByteStreams;
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.JsonSyntaxException;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.net.URL;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ import net.minecraft.util.text.Style;
/*    */ import net.minecraft.util.text.TextComponentTranslation;
/*    */ import net.minecraft.util.text.event.ClickEvent;
/*    */ import net.minecraftforge.fml.common.Loader;
/*    */ import net.minecraftforge.fml.common.ModContainer;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import rikuto.manaita_plus.ManaitaPlus;
/*    */ 
/*    */ 
/*    */ public class Update
/*    */ {
/* 24 */   private UpdateInfo updateInfo = null;
/* 25 */   private ModContainer container = Loader.instance().activeModContainer();
/*    */   private boolean isCompleted = false;
/*    */   
/*    */   public boolean isCompleted() {
/* 29 */     return this.isCompleted;
/*    */   }
/*    */   
/*    */   public UpdateInfo getUpdateInfo() {
/* 33 */     return this.updateInfo;
/*    */   }
/*    */ 
/*    */   
/*    */   public void checkUpdate() {
/* 38 */     (new Thread("[Manaita Plus]update check") { public void run() {
/*    */           try {
/*    */             String receivedData;
/*    */             List<Map<String, Object>> updateInfoList;
/*    */             try {
/* 43 */               URL url = new URL(ManaitaPlus.meta.updateUrl);
/* 44 */               InputStream con = url.openStream();
/* 45 */               receivedData = new String(ByteStreams.toByteArray(con));
/* 46 */               con.close();
/* 47 */             } catch (IOException e) {
/*    */               return;
/*    */             } 
/*    */             
/*    */             try {
/* 52 */               updateInfoList = (List<Map<String, Object>>)(new Gson()).fromJson(receivedData, List.class);
/* 53 */             } catch (JsonSyntaxException e) {
/*    */               return;
/*    */             } 
/* 56 */             Map<String, String> updateInfoJson = null;
/* 57 */             for (Map<String, Object> map : updateInfoList) {
/* 58 */               updateInfoJson = (Map<String, String>)map.get("1.12.2");
/*    */             }
/* 60 */             if (updateInfoJson == null) {
/*    */               return;
/*    */             }
/* 63 */             String currentVersion = Update.this.container.getVersion();
/* 64 */             String newVersion = updateInfoJson.get("version");
/* 65 */             if (!currentVersion.equals(newVersion)) {
/* 66 */               Update.this.updateInfo = new Update.UpdateInfo();
/* 67 */               Update.this.updateInfo.version = updateInfoJson.get("version");
/* 68 */               Update.this.updateInfo.downloadUrl = updateInfoJson.get("downloadUrl");
/*    */             } 
/*    */           } finally {
/*    */             
/* 72 */             Update.this.isCompleted = true;
/*    */           } 
/*    */         } }
/* 75 */       ).start();
/*    */   }
/*    */   
/*    */   public void notifyUpdate(ICommandSender sender, Side side) {
/* 79 */     if (this.updateInfo != null)
/* 80 */       if (side == Side.SERVER) {
/* 81 */         sender.func_145747_a((ITextComponent)new TextComponentTranslation("manaita_plus.update.server", new Object[] { this.updateInfo.version, this.updateInfo.downloadUrl }));
/*    */       } else {
/* 83 */         Style style = new Style();
/* 84 */         style.func_150241_a(new ClickEvent(ClickEvent.Action.OPEN_URL, this.updateInfo.downloadUrl));
/* 85 */         sender.func_145747_a((new TextComponentTranslation("manaita_plus.update.client", new Object[] { this.updateInfo.version })).func_150255_a(style));
/*    */       }  
/*    */   }
/*    */   
/*    */   public static class UpdateInfo {
/*    */     public String version;
/*    */     public String downloadUrl;
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plu\\util\Update.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */