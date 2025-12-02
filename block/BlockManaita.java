/*     */ package rikuto.manaita_plus.block;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockHorizontal;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.properties.PropertyDirection;
/*     */ import net.minecraft.block.properties.PropertyEnum;
/*     */ import net.minecraft.block.state.BlockStateContainer;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.BlockRenderLayer;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.IStringSerializable;
/*     */ import net.minecraft.util.NonNullList;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import rikuto.manaita_plus.ManaitaPlus;
/*     */ import rikuto.manaita_plus.core.ManaitaPlusBlockCore;
/*     */ 
/*     */ public class BlockManaita
/*     */   extends Block
/*     */   implements IManaita {
/*  32 */   public static final PropertyDirection FACING = BlockHorizontal.field_185512_D;
/*  33 */   public static final PropertyEnum<EnumType> TYPE = PropertyEnum.func_177709_a("type", EnumType.class);
/*  34 */   protected static final AxisAlignedBB X_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.1875D, 0.9375D, 0.0625D, 0.8125D);
/*  35 */   protected static final AxisAlignedBB Z_AABB = new AxisAlignedBB(0.1875D, 0.0D, 0.0625D, 0.8125D, 0.0625D, 0.9375D);
/*     */   
/*     */   public BlockManaita() {
/*  38 */     super(Material.field_151594_q);
/*  39 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)FACING, (Comparable)EnumFacing.NORTH).func_177226_a((IProperty)TYPE, EnumType.NORMAL));
/*  40 */     func_149647_a(ManaitaPlus.tabManaitaPlus);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_185496_a(IBlockState state, IBlockAccess source, BlockPos pos) {
/*  44 */     EnumFacing enumFacing = (EnumFacing)state.func_177229_b((IProperty)FACING);
/*  45 */     return (enumFacing.func_176740_k() == EnumFacing.Axis.X) ? X_AABB : Z_AABB;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d(IBlockState state) {
/*  49 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c(IBlockState state) {
/*  53 */     return false;
/*     */   }
/*     */   
/*     */   public int func_180651_a(IBlockState state) {
/*  57 */     return ((EnumType)state.func_177229_b((IProperty)TYPE)).getMetadata() & 0x7;
/*     */   }
/*     */   
/*     */   public boolean func_180639_a(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
/*  61 */     if (world.field_72995_K)
/*  62 */       return true; 
/*  63 */     if (this == ManaitaPlusBlockCore.craftingManaita)
/*  64 */       player.openGui(ManaitaPlus.instance, 1, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/*  65 */     if (this == ManaitaPlusBlockCore.furnaceManaita)
/*  66 */       player.openGui(ManaitaPlus.instance, 9, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/*  67 */     if (this == ManaitaPlusBlockCore.brewingManaita)
/*  68 */       player.openGui(ManaitaPlus.instance, 17, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing enumFacing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
/*  73 */     EnumFacing playerFacing = placer.func_174811_aO().func_176746_e();
/*  74 */     return super.getStateForPlacement(world, pos, enumFacing, hitX, hitY, hitZ, meta, placer, hand).func_177226_a((IProperty)FACING, (Comparable)playerFacing);
/*     */   }
/*     */   
/*     */   public boolean func_176196_c(World world, BlockPos pos) {
/*  78 */     return canBePlacedOn(world, pos.func_177977_b());
/*     */   }
/*     */   
/*     */   private boolean canBePlacedOn(World world, BlockPos pos) {
/*  82 */     return world.func_180495_p(pos).func_185917_h();
/*     */   }
/*     */   
/*     */   public void func_189540_a(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
/*  86 */     if (!canBePlacedOn(world, pos.func_177977_b())) {
/*  87 */       func_176226_b(world, pos, state, 0);
/*  88 */       world.func_175698_g(pos);
/*     */     } 
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta) {
/*  93 */     return func_176223_P().func_177226_a((IProperty)FACING, (Comparable)EnumFacing.func_176731_b(((meta & 0x8) == 0) ? 0 : 1)).func_177226_a((IProperty)TYPE, EnumType.fromMetadata(meta & 0x7));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state) {
/*  97 */     int i = ((EnumType)state.func_177229_b((IProperty)TYPE)).getMetadata();
/*  98 */     switch ((EnumFacing)state.func_177229_b((IProperty)FACING)) {
/*     */       case EAST:
/*     */       case WEST:
/* 101 */         i |= 0x8;
/*     */         break;
/*     */     } 
/*     */     
/* 105 */     return i;
/*     */   }
/*     */   
/*     */   protected BlockStateContainer func_180661_e() {
/* 109 */     return new BlockStateContainer(this, new IProperty[] { (IProperty)FACING, (IProperty)TYPE });
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public BlockRenderLayer func_180664_k() {
/* 114 */     return BlockRenderLayer.CUTOUT;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(CreativeTabs creativeTabs, NonNullList<ItemStack> list) {
/* 119 */     for (EnumType enumType : EnumType.values())
/* 120 */       list.add(new ItemStack(this, 1, enumType.getMetadata())); 
/*     */   }
/*     */   
/*     */   public void onHook(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ, Block hook) {
/* 124 */     if (this == ManaitaPlusBlockCore.craftingManaita) {
/* 125 */       if (hook == ManaitaPlusBlockCore.hook)
/* 126 */         player.openGui(ManaitaPlus.instance, 1, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 127 */       if (hook == ManaitaPlusBlockCore.woodenFixedHook)
/* 128 */         player.openGui(ManaitaPlus.instance, 2, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 129 */       if (hook == ManaitaPlusBlockCore.stoneFixedHook)
/* 130 */         player.openGui(ManaitaPlus.instance, 3, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 131 */       if (hook == ManaitaPlusBlockCore.ironFixedHook)
/* 132 */         player.openGui(ManaitaPlus.instance, 4, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 133 */       if (hook == ManaitaPlusBlockCore.goldFixedHook)
/* 134 */         player.openGui(ManaitaPlus.instance, 5, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 135 */       if (hook == ManaitaPlusBlockCore.diamondFixedHook)
/* 136 */         player.openGui(ManaitaPlus.instance, 6, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 137 */       if (hook == ManaitaPlusBlockCore.emeraldFixedHook)
/* 138 */         player.openGui(ManaitaPlus.instance, 7, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 139 */       if (hook == ManaitaPlusBlockCore.redstoneFixedHook)
/* 140 */         player.openGui(ManaitaPlus.instance, 8, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/*     */     } 
/* 142 */     if (this == ManaitaPlusBlockCore.furnaceManaita) {
/* 143 */       if (hook == ManaitaPlusBlockCore.hook)
/* 144 */         player.openGui(ManaitaPlus.instance, 9, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 145 */       if (hook == ManaitaPlusBlockCore.woodenFixedHook)
/* 146 */         player.openGui(ManaitaPlus.instance, 10, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 147 */       if (hook == ManaitaPlusBlockCore.stoneFixedHook)
/* 148 */         player.openGui(ManaitaPlus.instance, 11, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 149 */       if (hook == ManaitaPlusBlockCore.ironFixedHook)
/* 150 */         player.openGui(ManaitaPlus.instance, 12, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 151 */       if (hook == ManaitaPlusBlockCore.goldFixedHook)
/* 152 */         player.openGui(ManaitaPlus.instance, 13, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 153 */       if (hook == ManaitaPlusBlockCore.diamondFixedHook)
/* 154 */         player.openGui(ManaitaPlus.instance, 14, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 155 */       if (hook == ManaitaPlusBlockCore.emeraldFixedHook)
/* 156 */         player.openGui(ManaitaPlus.instance, 15, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 157 */       if (hook == ManaitaPlusBlockCore.redstoneFixedHook)
/* 158 */         player.openGui(ManaitaPlus.instance, 16, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/*     */     } 
/* 160 */     if (this == ManaitaPlusBlockCore.brewingManaita) {
/* 161 */       if (hook == ManaitaPlusBlockCore.hook)
/* 162 */         player.openGui(ManaitaPlus.instance, 17, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 163 */       if (hook == ManaitaPlusBlockCore.woodenFixedHook)
/* 164 */         player.openGui(ManaitaPlus.instance, 18, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 165 */       if (hook == ManaitaPlusBlockCore.stoneFixedHook)
/* 166 */         player.openGui(ManaitaPlus.instance, 19, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 167 */       if (hook == ManaitaPlusBlockCore.ironFixedHook)
/* 168 */         player.openGui(ManaitaPlus.instance, 20, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 169 */       if (hook == ManaitaPlusBlockCore.goldFixedHook)
/* 170 */         player.openGui(ManaitaPlus.instance, 21, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 171 */       if (hook == ManaitaPlusBlockCore.diamondFixedHook)
/* 172 */         player.openGui(ManaitaPlus.instance, 22, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 173 */       if (hook == ManaitaPlusBlockCore.emeraldFixedHook)
/* 174 */         player.openGui(ManaitaPlus.instance, 23, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/* 175 */       if (hook == ManaitaPlusBlockCore.redstoneFixedHook)
/* 176 */         player.openGui(ManaitaPlus.instance, 24, world, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p()); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public enum EnumType
/*     */     implements IStringSerializable {
/* 182 */     NORMAL(0, "normal"),
/* 183 */     WOODEN(1, "wooden"),
/* 184 */     STONE(2, "stone"),
/* 185 */     IRON(3, "iron"),
/* 186 */     GOLD(4, "gold"),
/* 187 */     DIAMOND(5, "diamond"),
/* 188 */     EMERALD(6, "emerald"),
/* 189 */     REDSTONE(7, "redstone");
/*     */     
/* 191 */     private static final EnumType[] META_LOOKUP = new EnumType[(values()).length];
/*     */     private final int meta;
/*     */     private final String name;
/*     */     
/*     */     static {
/* 196 */       for (EnumType enumType : values()) {
/* 197 */         META_LOOKUP[enumType.getMetadata()] = enumType;
/*     */       }
/*     */     }
/*     */     
/*     */     EnumType(int metaNum, String nameStr) {
/* 202 */       this.meta = metaNum;
/* 203 */       this.name = nameStr;
/*     */     }
/*     */     
/*     */     public int getMetadata() {
/* 207 */       return this.meta;
/*     */     }
/*     */     
/*     */     public static EnumType fromMetadata(int meta) {
/* 211 */       if (meta < 0 || meta >= META_LOOKUP.length) {
/* 212 */         meta = 0;
/*     */       }
/* 214 */       return META_LOOKUP[meta];
/*     */     }
/*     */     
/*     */     public String toString() {
/* 218 */       return this.name;
/*     */     }
/*     */     
/*     */     public String func_176610_l() {
/* 222 */       return this.name;
/*     */     }
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\block\BlockManaita.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */