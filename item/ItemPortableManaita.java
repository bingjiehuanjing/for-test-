/*     */ package rikuto.manaita_plus.item;
/*     */ 
/*     */ import javax.annotation.Nonnull;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.NonNullList;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import rikuto.manaita_plus.ManaitaPlus;
/*     */ 
/*     */ 
/*     */ public class ItemPortableManaita
/*     */   extends Item
/*     */ {
/*     */   protected int role;
/*  22 */   private int meta = 8;
/*     */ 
/*     */   
/*     */   public ItemPortableManaita(int type) {
/*  26 */     func_77637_a(ManaitaPlus.tabManaitaPlus);
/*  27 */     func_77656_e(0);
/*  28 */     func_77627_a(true);
/*  29 */     this.role = type;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150895_a(CreativeTabs creativeTabs, NonNullList<ItemStack> list) {
/*  34 */     if (func_194125_a(creativeTabs))
/*  35 */       for (int i = 0; i < this.meta; i++)
/*  36 */         list.add(new ItemStack(this, 1, i));  
/*     */   }
/*     */   
/*     */   public String func_77667_c(ItemStack itemStack) {
/*  40 */     return func_77658_a() + "." + itemStack.func_77952_i();
/*     */   }
/*     */   
/*     */   public ActionResult<ItemStack> func_77659_a(World world, EntityPlayer player, @Nonnull EnumHand hand) {
/*  44 */     if (!world.field_72995_K)
/*  45 */       switch (this.role) {
/*     */         case 1:
/*  47 */           switch (player.func_184586_b(hand).func_77952_i()) {
/*     */             case 0:
/*  49 */               player.openGui(ManaitaPlus.instance, 1, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 1:
/*  52 */               player.openGui(ManaitaPlus.instance, 2, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 2:
/*  55 */               player.openGui(ManaitaPlus.instance, 3, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 3:
/*  58 */               player.openGui(ManaitaPlus.instance, 4, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 4:
/*  61 */               player.openGui(ManaitaPlus.instance, 5, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 5:
/*  64 */               player.openGui(ManaitaPlus.instance, 6, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 6:
/*  67 */               player.openGui(ManaitaPlus.instance, 7, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 7:
/*  70 */               player.openGui(ManaitaPlus.instance, 8, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v); break;
/*     */           } 
/*     */           break;
/*     */         case 2:
/*  74 */           switch (player.func_184586_b(hand).func_77952_i()) {
/*     */             case 0:
/*  76 */               player.openGui(ManaitaPlus.instance, 9, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 1:
/*  79 */               player.openGui(ManaitaPlus.instance, 10, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 2:
/*  82 */               player.openGui(ManaitaPlus.instance, 11, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 3:
/*  85 */               player.openGui(ManaitaPlus.instance, 12, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 4:
/*  88 */               player.openGui(ManaitaPlus.instance, 13, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 5:
/*  91 */               player.openGui(ManaitaPlus.instance, 14, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 6:
/*  94 */               player.openGui(ManaitaPlus.instance, 15, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 7:
/*  97 */               player.openGui(ManaitaPlus.instance, 16, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v); break;
/*     */           } 
/*     */           break;
/*     */         case 3:
/* 101 */           switch (player.func_184586_b(hand).func_77952_i()) {
/*     */             case 0:
/* 103 */               player.openGui(ManaitaPlus.instance, 17, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 1:
/* 106 */               player.openGui(ManaitaPlus.instance, 18, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 2:
/* 109 */               player.openGui(ManaitaPlus.instance, 19, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 3:
/* 112 */               player.openGui(ManaitaPlus.instance, 20, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 4:
/* 115 */               player.openGui(ManaitaPlus.instance, 21, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 5:
/* 118 */               player.openGui(ManaitaPlus.instance, 22, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 6:
/* 121 */               player.openGui(ManaitaPlus.instance, 23, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */               break;
/*     */             case 7:
/* 124 */               player.openGui(ManaitaPlus.instance, 24, world, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v); break;
/*     */           } 
/*     */           break;
/*     */       }  
/* 128 */     return new ActionResult(EnumActionResult.PASS, player.func_184586_b(hand));
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\item\ItemPortableManaita.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */