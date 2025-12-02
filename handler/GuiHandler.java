/*     */ package rikuto.manaita_plus.handler;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.network.IGuiHandler;
/*     */ import rikuto.manaita_plus.core.ManaitaPlusConfigCore;
/*     */ import rikuto.manaita_plus.gui.ContainerBrewingManaita;
/*     */ import rikuto.manaita_plus.gui.ContainerConfig;
/*     */ import rikuto.manaita_plus.gui.ContainerCraftingManaita;
/*     */ import rikuto.manaita_plus.gui.ContainerFurnaceManaita;
/*     */ import rikuto.manaita_plus.gui.GuiBrewingManaita;
/*     */ import rikuto.manaita_plus.gui.GuiConfig;
/*     */ import rikuto.manaita_plus.gui.GuiCraftingManaita;
/*     */ import rikuto.manaita_plus.gui.GuiFurnaceManaita;
/*     */ 
/*     */ public class GuiHandler
/*     */   implements IGuiHandler
/*     */ {
/*     */   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
/*  21 */     switch (ID) {
/*     */       case 0:
/*  23 */         return new ContainerConfig(player.field_71071_by, player);
/*     */       case 1:
/*  25 */         return new ContainerCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), ManaitaPlusConfigCore.craftingDoubling);
/*     */       case 2:
/*  27 */         return new ContainerCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 2);
/*     */       case 3:
/*  29 */         return new ContainerCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 4);
/*     */       case 4:
/*  31 */         return new ContainerCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 8);
/*     */       case 5:
/*  33 */         return new ContainerCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 16);
/*     */       case 6:
/*  35 */         return new ContainerCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 32);
/*     */       case 7:
/*  37 */         return new ContainerCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 64);
/*     */       case 8:
/*  39 */         return new ContainerCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 9);
/*     */       case 9:
/*  41 */         return new ContainerFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), ManaitaPlusConfigCore.furnaceDoubling);
/*     */       case 10:
/*  43 */         return new ContainerFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 2);
/*     */       case 11:
/*  45 */         return new ContainerFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 4);
/*     */       case 12:
/*  47 */         return new ContainerFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 8);
/*     */       case 13:
/*  49 */         return new ContainerFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 16);
/*     */       case 14:
/*  51 */         return new ContainerFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 32);
/*     */       case 15:
/*  53 */         return new ContainerFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 64);
/*     */       case 16:
/*  55 */         return new ContainerFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 9);
/*     */       case 17:
/*  57 */         return new ContainerBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), ManaitaPlusConfigCore.brewingDoubling);
/*     */       case 18:
/*  59 */         return new ContainerBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 2);
/*     */       case 19:
/*  61 */         return new ContainerBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 4);
/*     */       case 20:
/*  63 */         return new ContainerBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 8);
/*     */       case 21:
/*  65 */         return new ContainerBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 16);
/*     */       case 22:
/*  67 */         return new ContainerBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 32);
/*     */       case 23:
/*  69 */         return new ContainerBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 64);
/*     */       case 24:
/*  71 */         return new ContainerBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 9);
/*     */     } 
/*  73 */     return null;
/*     */   }
/*     */   
/*     */   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
/*  77 */     switch (ID) {
/*     */       case 0:
/*  79 */         return new GuiConfig(player.field_71071_by, player);
/*     */       case 1:
/*  81 */         return new GuiCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), ManaitaPlusConfigCore.craftingDoubling);
/*     */       case 2:
/*  83 */         return new GuiCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 2);
/*     */       case 3:
/*  85 */         return new GuiCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 4);
/*     */       case 4:
/*  87 */         return new GuiCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 8);
/*     */       case 5:
/*  89 */         return new GuiCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 16);
/*     */       case 6:
/*  91 */         return new GuiCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 32);
/*     */       case 7:
/*  93 */         return new GuiCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 64);
/*     */       case 8:
/*  95 */         return new GuiCraftingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 9);
/*     */       case 9:
/*  97 */         return new GuiFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), ManaitaPlusConfigCore.furnaceDoubling);
/*     */       case 10:
/*  99 */         return new GuiFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 2);
/*     */       case 11:
/* 101 */         return new GuiFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 4);
/*     */       case 12:
/* 103 */         return new GuiFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 8);
/*     */       case 13:
/* 105 */         return new GuiFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 16);
/*     */       case 14:
/* 107 */         return new GuiFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 32);
/*     */       case 15:
/* 109 */         return new GuiFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 64);
/*     */       case 16:
/* 111 */         return new GuiFurnaceManaita(player.field_71071_by, world, new BlockPos(x, y, z), 9);
/*     */       case 17:
/* 113 */         return new GuiBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), ManaitaPlusConfigCore.brewingDoubling);
/*     */       case 18:
/* 115 */         return new GuiBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 2);
/*     */       case 19:
/* 117 */         return new GuiBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 4);
/*     */       case 20:
/* 119 */         return new GuiBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 8);
/*     */       case 21:
/* 121 */         return new GuiBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 16);
/*     */       case 22:
/* 123 */         return new GuiBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 32);
/*     */       case 23:
/* 125 */         return new GuiBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 64);
/*     */       case 24:
/* 127 */         return new GuiBrewingManaita(player.field_71071_by, world, new BlockPos(x, y, z), 9);
/*     */     } 
/* 129 */     return null;
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\handler\GuiHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */