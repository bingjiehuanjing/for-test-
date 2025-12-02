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
/*    */ import rikuto.manaita_plus.ManaitaPlus;
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
/*    */ class null
/*    */   extends Thread
/*    */ {
/*    */   null(String x0) {
/* 38 */     super(x0); } public void run() {
/*    */     try {
/*    */       String receivedData;
/*    */       List<Map<String, Object>> updateInfoList;
/*    */       try {
/* 43 */         URL url = new URL(ManaitaPlus.meta.updateUrl);
/* 44 */         InputStream con = url.openStream();
/* 45 */         receivedData = new String(ByteStreams.toByteArray(con));
/* 46 */         con.close();
/* 47 */       } catch (IOException e) {
/*    */         return;
/*    */       } 
/*    */       
/*    */       try {
/* 52 */         updateInfoList = (List<Map<String, Object>>)(new Gson()).fromJson(receivedData, List.class);
/* 53 */       } catch (JsonSyntaxException e) {
/*    */         return;
/*    */       } 
/* 56 */       Map<String, String> updateInfoJson = null;
/* 57 */       for (Map<String, Object> map : updateInfoList) {
/* 58 */         updateInfoJson = (Map<String, String>)map.get("1.12.2");
/*    */       }
/* 60 */       if (updateInfoJson == null) {
/*    */         return;
/*    */       }
/* 63 */       String currentVersion = Update.access$000(Update.this).getVersion();
/* 64 */       String newVersion = updateInfoJson.get("version");
/* 65 */       if (!currentVersion.equals(newVersion)) {
/* 66 */         Update.access$102(Update.this, new Update.UpdateInfo());
/* 67 */         (Update.access$100(Update.this)).version = updateInfoJson.get("version");
/* 68 */         (Update.access$100(Update.this)).downloadUrl = updateInfoJson.get("downloadUrl");
/*    */       } 
/*    */     } finally {
/*    */       
/* 72 */       Update.access$202(Update.this, true);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plu\\util\Update$1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */