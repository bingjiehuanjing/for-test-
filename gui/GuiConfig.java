/*     */ package rikuto.manaita_plus.gui;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.inventory.GuiContainer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import rikuto.manaita_plus.handler.PacketHandler;
/*     */ import rikuto.manaita_plus.item.IManaitaConfigurable;
/*     */ import rikuto.manaita_plus.network.MessageNBT;
/*     */ 
/*     */ public class GuiConfig
/*     */   extends GuiContainer
/*     */ {
/*  20 */   private static final ResourceLocation CONFIG_GUI_TEXTURES = new ResourceLocation("manaita_plus:textures/gui/config.png");
/*     */   protected ContainerConfig container;
/*  22 */   protected ItemStack itemStack = ItemStack.field_190927_a;
/*  23 */   protected List<IManaitaConfigurable.EnumConfig> configs = new ArrayList<>();
/*  24 */   protected int index = 0;
/*     */   
/*     */   public GuiConfig(InventoryPlayer playerInv, EntityPlayer player) {
/*  27 */     super(new ContainerConfig(playerInv, player));
/*  28 */     this.container = (ContainerConfig)this.field_147002_h;
/*     */   }
/*     */   
/*     */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
/*  32 */     func_146276_q_();
/*  33 */     super.func_73863_a(mouseX, mouseY, partialTicks);
/*  34 */     func_191948_b(mouseX, mouseY);
/*     */   }
/*     */   
/*     */   protected void func_146979_b(int mouseX, int mouseY) {
/*  38 */     if (this.itemStack.func_190926_b() || !(this.itemStack.func_77973_b() instanceof IManaitaConfigurable) || this.configs == null || this.configs.isEmpty())
/*     */       return; 
/*  40 */     this.field_146289_q.func_78276_b(this.itemStack.func_82833_r(), 34, 16, 4210752);
/*  41 */     IManaitaConfigurable.EnumConfig config = this.configs.get(this.index);
/*  42 */     this.field_146289_q.func_78276_b(config.func_176610_l(), 88 - this.field_146289_q.func_78256_a(config.func_176610_l()) / 2, 40, 4210752);
/*  43 */     if (config.getType() == 1) {
/*  44 */       String value = String.valueOf(this.itemStack.func_77978_p().func_74762_e(config.func_176610_l()));
/*  45 */       if (config == IManaitaConfigurable.EnumConfig.DIG_RANGE || config == IManaitaConfigurable.EnumConfig.ATTACK_AREA) {
/*  46 */         int i = this.itemStack.func_77978_p().func_74762_e(config.func_176610_l()) * 2 - 1;
/*  47 */         value = i + "x" + i;
/*     */       } 
/*  49 */       this.field_146289_q.func_78276_b(value, 88 - this.field_146289_q.func_78256_a(value) / 2, 64, 4210752);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
/*  54 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  55 */     this.field_146297_k.func_110434_K().func_110577_a(CONFIG_GUI_TEXTURES);
/*  56 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/*  57 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/*  58 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */   }
/*     */   
/*     */   protected void func_146284_a(GuiButton button) {
/*  62 */     IManaitaConfigurable.EnumConfig config = this.configs.get(this.index);
/*  63 */     switch (button.field_146127_k) {
/*     */       case 0:
/*  65 */         this.index--;
/*     */         break;
/*     */       case 1:
/*  68 */         this.index++;
/*     */         break;
/*     */       case 2:
/*  71 */         PacketHandler.INSTANCE.sendToServer((IMessage)new MessageNBT(config.func_176610_l()));
/*     */         break;
/*     */       case 3:
/*  74 */         PacketHandler.INSTANCE.sendToServer((IMessage)new MessageNBT(config.func_176610_l(), -1));
/*     */         break;
/*     */       case 4:
/*  77 */         PacketHandler.INSTANCE.sendToServer((IMessage)new MessageNBT(config.func_176610_l(), 1));
/*     */         break;
/*     */     } 
/*     */   }
/*     */   public void func_73866_w_() {
/*  82 */     super.func_73866_w_();
/*  83 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/*  84 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/*  85 */     this.field_146292_n.add(new GuiButton(0, i + 28, j + 34, 20, 20, "<"));
/*  86 */     this.field_146292_n.add(new GuiButton(1, i + 126, j + 34, 20, 20, ">"));
/*  87 */     this.field_146292_n.add(new GuiButton(2, i + 30, j + 58, 114, 20, ""));
/*  88 */     this.field_146292_n.add(new GuiButton(3, i + 36, j + 58, 20, 20, "-"));
/*  89 */     this.field_146292_n.add(new GuiButton(4, i + 118, j + 58, 20, 20, "+"));
/*  90 */     for (Object button : this.field_146292_n)
/*  91 */       ((GuiButton)button).field_146125_m = false; 
/*     */   }
/*     */   
/*     */   public void func_73876_c() {
/*  95 */     super.func_73876_c();
/*  96 */     this.itemStack = this.container.slot.func_70301_a(0);
/*  97 */     if (!this.itemStack.func_190926_b()) {
/*  98 */       if (this.itemStack.func_77973_b() instanceof IManaitaConfigurable) {
/*  99 */         this.configs = ((IManaitaConfigurable)this.itemStack.func_77973_b()).getConfigs();
/*     */       } else {
/* 101 */         this.configs.clear();
/* 102 */         this.index = 0;
/*     */       } 
/*     */     } else {
/*     */       
/* 106 */       this.configs.clear();
/* 107 */       this.index = 0;
/*     */     } 
/*     */     
/* 110 */     if (this.index > 0) {
/* 111 */       ((GuiButton)this.field_146292_n.get(0)).field_146125_m = true;
/*     */     } else {
/* 113 */       ((GuiButton)this.field_146292_n.get(0)).field_146125_m = false;
/* 114 */     }  if (this.configs.size() - 1 > this.index) {
/* 115 */       ((GuiButton)this.field_146292_n.get(1)).field_146125_m = true;
/*     */     } else {
/* 117 */       ((GuiButton)this.field_146292_n.get(1)).field_146125_m = false;
/*     */     } 
/* 119 */     if (!this.configs.isEmpty()) {
/* 120 */       if (((IManaitaConfigurable.EnumConfig)this.configs.get(this.index)).getType() == 0) {
/* 121 */         ((GuiButton)this.field_146292_n.get(2)).field_146125_m = true;
/* 122 */         if (this.itemStack != null) {
/* 123 */           ((GuiButton)this.field_146292_n.get(2)).field_146126_j = String.valueOf(this.itemStack.func_77978_p().func_74767_n(((IManaitaConfigurable.EnumConfig)this.configs.get(this.index)).func_176610_l()));
/*     */         }
/*     */       } else {
/* 126 */         ((GuiButton)this.field_146292_n.get(2)).field_146125_m = false;
/* 127 */       }  if (((IManaitaConfigurable.EnumConfig)this.configs.get(this.index)).getType() == 1) {
/* 128 */         if (this.itemStack.func_77978_p().func_74762_e(((IManaitaConfigurable.EnumConfig)this.configs.get(this.index)).func_176610_l()) > 1) {
/* 129 */           ((GuiButton)this.field_146292_n.get(3)).field_146125_m = true;
/*     */         } else {
/* 131 */           ((GuiButton)this.field_146292_n.get(3)).field_146125_m = false;
/* 132 */         }  if (this.itemStack.func_77978_p().func_74762_e(((IManaitaConfigurable.EnumConfig)this.configs.get(this.index)).func_176610_l()) < ((IManaitaConfigurable.EnumConfig)this.configs.get(this.index)).getMax()) {
/* 133 */           ((GuiButton)this.field_146292_n.get(4)).field_146125_m = true;
/*     */         } else {
/* 135 */           ((GuiButton)this.field_146292_n.get(4)).field_146125_m = false;
/*     */         } 
/*     */       } else {
/* 138 */         ((GuiButton)this.field_146292_n.get(3)).field_146125_m = false;
/* 139 */         ((GuiButton)this.field_146292_n.get(4)).field_146125_m = false;
/*     */       } 
/*     */     } else {
/*     */       
/* 143 */       ((GuiButton)this.field_146292_n.get(2)).field_146125_m = false;
/* 144 */       ((GuiButton)this.field_146292_n.get(3)).field_146125_m = false;
/* 145 */       ((GuiButton)this.field_146292_n.get(4)).field_146125_m = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\gui\GuiConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */