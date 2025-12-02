/*    */ package rikuto.manaita_plus.proxy;
/*    */ 
/*    */ import net.minecraft.client.renderer.block.model.ModelResourceLocation;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.model.ModelLoader;
/*    */ import net.minecraftforge.fml.client.registry.ClientRegistry;
/*    */ import net.minecraftforge.fml.client.registry.IRenderFactory;
/*    */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*    */ import net.minecraftforge.fml.common.Loader;
/*    */ import rikuto.manaita_plus.block.BlockManaita;
/*    */ import rikuto.manaita_plus.core.ManaitaPlusBlockCore;
/*    */ import rikuto.manaita_plus.core.ManaitaPlusItemCore;
/*    */ import rikuto.manaita_plus.entity.EntityManaitaArrow;
/*    */ import rikuto.manaita_plus.render.RenderHook;
/*    */ import rikuto.manaita_plus.tileentity.TileEntityHook;
/*    */ 
/*    */ 
/*    */ public class ClientProxy
/*    */   extends CommonProxy
/*    */ {
/* 24 */   public static final KeyBinding manaitaKey = new KeyBinding("key.manaita", 46, "Manaita Plus");
/* 25 */   public static final KeyBinding alwaysCraftingManaitaKey = new KeyBinding("key.always_crafting_manaita", 0, "Manaita Plus");
/* 26 */   public static final KeyBinding alwaysFurnaceManaitaKey = new KeyBinding("key.always_furnace_manaita", 0, "Manaita Plus");
/* 27 */   public static final KeyBinding alwaysBrewingManaitaKey = new KeyBinding("key.always_brewing_manaita", 0, "Manaita Plus");
/*    */   
/*    */   public void init() {
/* 30 */     ClientRegistry.registerKeyBinding(manaitaKey);
/* 31 */     ClientRegistry.registerKeyBinding(alwaysCraftingManaitaKey);
/* 32 */     ClientRegistry.registerKeyBinding(alwaysFurnaceManaitaKey);
/* 33 */     ClientRegistry.registerKeyBinding(alwaysBrewingManaitaKey);
/* 34 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHook.class, (TileEntitySpecialRenderer)new RenderHook());
/*    */   }
/*    */   public void preInit() {
/*    */     int i;
/* 38 */     for (i = 0; i < (BlockManaita.EnumType.values()).length; i++) {
/* 39 */       ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(ManaitaPlusBlockCore.craftingManaita), i, new ModelResourceLocation(new ResourceLocation("manaita_plus", (i == 0) ? "crafting_manaita" : ("crafting_manaita_" + BlockManaita.EnumType.fromMetadata(i).func_176610_l())), "inventory"));
/* 40 */       ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(ManaitaPlusBlockCore.furnaceManaita), i, new ModelResourceLocation(new ResourceLocation("manaita_plus", (i == 0) ? "furnace_manaita" : ("furnace_manaita_" + BlockManaita.EnumType.fromMetadata(i).func_176610_l())), "inventory"));
/* 41 */       ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(ManaitaPlusBlockCore.brewingManaita), i, new ModelResourceLocation(new ResourceLocation("manaita_plus", (i == 0) ? "brewing_manaita" : ("brewing_manaita_" + BlockManaita.EnumType.fromMetadata(i).func_176610_l())), "inventory"));
/*    */     } 
/*    */     
/* 44 */     ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(ManaitaPlusBlockCore.hook), 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "hook"), "inventory"));
/* 45 */     ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(ManaitaPlusBlockCore.woodenFixedHook), 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "fixed_hook_wooden"), "inventory"));
/* 46 */     ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(ManaitaPlusBlockCore.stoneFixedHook), 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "fixed_hook_stone"), "inventory"));
/* 47 */     ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(ManaitaPlusBlockCore.ironFixedHook), 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "fixed_hook_iron"), "inventory"));
/* 48 */     ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(ManaitaPlusBlockCore.goldFixedHook), 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "fixed_hook_gold"), "inventory"));
/* 49 */     ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(ManaitaPlusBlockCore.diamondFixedHook), 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "fixed_hook_diamond"), "inventory"));
/* 50 */     ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(ManaitaPlusBlockCore.emeraldFixedHook), 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "fixed_hook_emerald"), "inventory"));
/* 51 */     ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(ManaitaPlusBlockCore.redstoneFixedHook), 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "fixed_hook_redstone"), "inventory"));
/*    */     
/* 53 */     for (i = 0; i < 8; i++) {
/* 54 */       ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.portableCraftingManaita, i, new ModelResourceLocation(new ResourceLocation("manaita_plus", "portable_crafting_manaita_" + i), "inventory"));
/* 55 */       ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.portableFurnaceManaita, i, new ModelResourceLocation(new ResourceLocation("manaita_plus", "portable_furnace_manaita_" + i), "inventory"));
/* 56 */       ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.portableBrewingManaita, i, new ModelResourceLocation(new ResourceLocation("manaita_plus", "portable_brewing_manaita_" + i), "inventory"));
/*    */       
/* 58 */       if (Loader.isModLoaded("baubles")) {
/* 59 */         ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.ringCraftingManaita, i, new ModelResourceLocation(new ResourceLocation("manaita_plus", "ring_crafting_manaita_" + i), "inventory"));
/* 60 */         ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.ringFurnaceManaita, i, new ModelResourceLocation(new ResourceLocation("manaita_plus", "ring_furnace_manaita_" + i), "inventory"));
/* 61 */         ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.ringBrewingManaita, i, new ModelResourceLocation(new ResourceLocation("manaita_plus", "ring_brewing_manaita_" + i), "inventory"));
/*    */       } 
/*    */     } 
/*    */     
/* 65 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.swordManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_sword"), "inventory"));
/* 66 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.shovelManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_shovel"), "inventory"));
/* 67 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.pickaxeManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_pickaxe"), "inventory"));
/* 68 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.axeManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_axe"), "inventory"));
/* 69 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.hoeManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_hoe"), "inventory"));
/* 70 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.paxelManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_paxel"), "inventory"));
/* 71 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.bowManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_bow"), "inventory"));
/*    */     
/* 73 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.helmetManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_helmet"), "inventory"));
/* 74 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.chestplateManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_chestplate"), "inventory"));
/* 75 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.leggingsManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_leggings"), "inventory"));
/* 76 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.bootsManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_boots"), "inventory"));
/*    */     
/* 78 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.shieldManaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "manaita_shield"), "inventory"));
/*    */     
/* 80 */     ModelLoader.setCustomModelResourceLocation(ManaitaPlusItemCore.source_of_Manaita, 0, new ModelResourceLocation(new ResourceLocation("manaita_plus", "source_of_manaita"), "inventory"));
/*    */ 
/*    */     
/* 83 */     RenderingRegistry.registerEntityRenderingHandler(EntityManaitaArrow.class, net.minecraft.client.renderer.entity.RenderTippedArrow::new);
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\proxy\ClientProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */