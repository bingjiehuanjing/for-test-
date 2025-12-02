/*     */ package rikuto.manaita_plus.block;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.BlockHorizontal;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.properties.PropertyDirection;
/*     */ import net.minecraft.block.state.BlockStateContainer;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockRenderLayer;
/*     */ import net.minecraft.util.EnumBlockRenderType;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import rikuto.manaita_plus.ManaitaPlus;
/*     */ import rikuto.manaita_plus.tileentity.TileEntityHook;
/*     */ 
/*     */ public class BlockHook
/*     */   extends BlockContainer
/*     */ {
/*  34 */   public static final PropertyDirection FACING = BlockHorizontal.field_185512_D;
/*  35 */   protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.875D, 1.0D, 1.0D, 1.0D);
/*  36 */   protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.125D);
/*  37 */   protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.875D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*  38 */   protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.125D, 1.0D, 1.0D);
/*     */   
/*     */   public BlockHook() {
/*  41 */     super(Material.field_151594_q);
/*  42 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)FACING, (Comparable)EnumFacing.NORTH));
/*  43 */     func_149647_a(ManaitaPlus.tabManaitaPlus);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_185496_a(IBlockState state, IBlockAccess source, BlockPos pos) {
/*  47 */     EnumFacing enumFacing = (EnumFacing)state.func_177229_b((IProperty)FACING);
/*  48 */     switch (enumFacing) {
/*     */       case NORTH:
/*  50 */         return NORTH_AABB;
/*     */       case SOUTH:
/*  52 */         return SOUTH_AABB;
/*     */       case WEST:
/*  54 */         return WEST_AABB;
/*     */       case EAST:
/*  56 */         return EAST_AABB;
/*     */     } 
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d(IBlockState state) {
/*  63 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c(IBlockState state) {
/*  67 */     return false;
/*     */   }
/*     */   
/*     */   public EnumBlockRenderType func_149645_b(IBlockState state) {
/*  71 */     return EnumBlockRenderType.MODEL;
/*     */   }
/*     */   
/*     */   public boolean func_180639_a(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
/*  75 */     if (world.field_72995_K)
/*  76 */       return true; 
/*  77 */     if (hand == EnumHand.MAIN_HAND) {
/*  78 */       TileEntityHook tileEntity = (TileEntityHook)world.func_175625_s(pos);
/*  79 */       if (tileEntity != null) {
/*  80 */         if (tileEntity.getStack().func_190926_b()) {
/*  81 */           ItemStack itemStack = player.func_184614_ca();
/*  82 */           if (!itemStack.func_190926_b() && itemStack.func_77973_b() instanceof ItemBlockManaita) {
/*  83 */             tileEntity.setStack(new ItemStack(itemStack.func_77973_b(), 1, itemStack.func_77952_i()));
/*  84 */             tileEntity.func_70296_d();
/*  85 */             world.func_184138_a(pos, state, state, 3);
/*  86 */             if (!player.field_71075_bZ.field_75098_d) {
/*  87 */               itemStack.func_190918_g(1);
/*     */             }
/*     */           }
/*     */         
/*  91 */         } else if (player.func_70093_af()) {
/*  92 */           EntityItem entityItem = new EntityItem(world, player.field_70165_t, player.field_70163_u, player.field_70161_v, tileEntity.getStack());
/*  93 */           if (!player.field_71075_bZ.field_75098_d)
/*  94 */             world.func_72838_d((Entity)entityItem); 
/*  95 */           tileEntity.clearStack();
/*  96 */           tileEntity.func_70296_d();
/*  97 */           world.func_184138_a(pos, state, state, 3);
/*     */         }
/*  99 */         else if (tileEntity.getStack().func_77973_b() instanceof net.minecraft.item.ItemBlock && func_149634_a(tileEntity.getStack().func_77973_b()) instanceof IManaita) {
/* 100 */           ((IManaita)func_149634_a(tileEntity.getStack().func_77973_b())).onHook(world, pos, state, player, hand, side, hitX, hitY, hitZ, (Block)this);
/*     */         } 
/*     */       }
/*     */     } 
/* 104 */     return true;
/*     */   }
/*     */   
/*     */   public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing enumFacing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
/* 108 */     return func_176223_P().func_177226_a((IProperty)FACING, (Comparable)enumFacing);
/*     */   }
/*     */   
/*     */   public boolean func_176198_a(World world, BlockPos pos, EnumFacing enumFacing) {
/* 112 */     switch (enumFacing) {
/*     */       case NORTH:
/*     */       case SOUTH:
/*     */       case WEST:
/*     */       case EAST:
/* 117 */         return canBePlacedAt(world.func_180495_p(pos.func_177972_a(enumFacing.func_176734_d())));
/*     */     } 
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canBePlacedAt(IBlockState state) {
/* 124 */     return (state.func_185917_h() && state.func_185904_a().func_76230_c());
/*     */   }
/*     */   
/*     */   public void func_189540_a(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
/* 128 */     EnumFacing enumFacing = (EnumFacing)state.func_177229_b((IProperty)FACING);
/* 129 */     if (!world.func_180495_p(pos.func_177972_a(enumFacing.func_176734_d())).func_185904_a().func_76220_a()) {
/* 130 */       func_176226_b(world, pos, state, 0);
/* 131 */       world.func_175698_g(pos);
/*     */     } 
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta) {
/* 136 */     EnumFacing enumFacing = null;
/* 137 */     switch (meta)
/*     */     { case 1:
/* 139 */         enumFacing = EnumFacing.EAST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 151 */         return func_176223_P().func_177226_a((IProperty)FACING, (Comparable)enumFacing);case 2: enumFacing = EnumFacing.WEST; return func_176223_P().func_177226_a((IProperty)FACING, (Comparable)enumFacing);case 3: enumFacing = EnumFacing.SOUTH; return func_176223_P().func_177226_a((IProperty)FACING, (Comparable)enumFacing); }  enumFacing = EnumFacing.NORTH; return func_176223_P().func_177226_a((IProperty)FACING, (Comparable)enumFacing);
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state) {
/* 155 */     int i = 0;
/* 156 */     switch ((EnumFacing)state.func_177229_b((IProperty)FACING))
/*     */     { case EAST:
/* 158 */         i = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 170 */         return i;case WEST: i = 2; return i;case SOUTH: i = 3; return i; }  i = 4; return i;
/*     */   }
/*     */   
/*     */   protected BlockStateContainer func_180661_e() {
/* 174 */     return new BlockStateContainer((Block)this, new IProperty[] { (IProperty)FACING });
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta) {
/* 178 */     return (TileEntity)new TileEntityHook();
/*     */   }
/*     */   
/*     */   public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
/* 182 */     List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
/* 183 */     TileEntityHook tileEntity = (TileEntityHook)world.func_175625_s(pos);
/* 184 */     if (tileEntity != null && !tileEntity.getStack().func_190926_b()) {
/* 185 */       ret.add(tileEntity.getStack().func_77946_l());
/*     */     }
/* 187 */     return ret;
/*     */   }
/*     */   
/*     */   public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
/* 191 */     if (willHarvest) {
/* 192 */       return true;
/*     */     }
/* 194 */     return super.removedByPlayer(state, world, pos, player, willHarvest);
/*     */   }
/*     */   
/*     */   public void func_180657_a(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity tileEntity, ItemStack itemStack) {
/* 198 */     super.func_180657_a(world, player, pos, state, tileEntity, itemStack);
/* 199 */     world.func_175698_g(pos);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public BlockRenderLayer func_180664_k() {
/* 204 */     return BlockRenderLayer.CUTOUT;
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\block\BlockHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */