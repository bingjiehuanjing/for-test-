/*    */ package rikuto.manaita_plus.tileentity;
/*    */ 
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.inventory.ItemStackHelper;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import net.minecraft.network.play.server.SPacketUpdateTileEntity;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.NonNullList;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class TileEntityHook
/*    */   extends TileEntity
/*    */ {
/* 18 */   private NonNullList<ItemStack> inventory = NonNullList.func_191197_a(1, ItemStack.field_190927_a);
/*    */   
/*    */   public TileEntityHook() {}
/*    */   
/*    */   public TileEntityHook(ItemStack itemStack) {
/* 23 */     this.inventory.set(0, ItemStack.field_190927_a);
/*    */   }
/*    */   
/*    */   public ItemStack getStack() {
/* 27 */     return (ItemStack)this.inventory.get(0);
/*    */   }
/*    */   
/*    */   public ItemStack clearStack() {
/* 31 */     if (!((ItemStack)this.inventory.get(0)).func_190926_b()) {
/* 32 */       ItemStack ItemStack = (ItemStack)this.inventory.get(0);
/* 33 */       this.inventory.set(0, ItemStack.field_190927_a);
/* 34 */       func_70296_d();
/* 35 */       return ItemStack;
/*    */     } 
/* 37 */     return null;
/*    */   }
/*    */   
/*    */   public void setStack(ItemStack itemStack) {
/* 41 */     this.inventory.set(0, itemStack);
/* 42 */     if (!itemStack.func_190926_b())
/* 43 */       itemStack.func_190920_e(1); 
/* 44 */     func_70296_d();
/*    */   }
/*    */   
/*    */   public void func_145839_a(NBTTagCompound nbt) {
/* 48 */     super.func_145839_a(nbt);
/* 49 */     this.inventory = NonNullList.func_191197_a(1, ItemStack.field_190927_a);
/* 50 */     ItemStackHelper.func_191283_b(nbt, this.inventory);
/*    */   }
/*    */   
/*    */   public NBTTagCompound func_189515_b(NBTTagCompound nbt) {
/* 54 */     super.func_189515_b(nbt);
/* 55 */     ItemStackHelper.func_191282_a(nbt, this.inventory);
/* 56 */     return nbt;
/*    */   }
/*    */   
/*    */   public void func_70296_d() {
/* 60 */     super.func_70296_d();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public SPacketUpdateTileEntity func_189518_D_() {
/* 65 */     NBTTagCompound nbt = new NBTTagCompound();
/* 66 */     func_189515_b(nbt);
/* 67 */     return new SPacketUpdateTileEntity(this.field_174879_c, func_145832_p(), nbt);
/*    */   }
/*    */   
/*    */   public NBTTagCompound func_189517_E_() {
/* 71 */     return func_189515_b(new NBTTagCompound());
/*    */   }
/*    */   
/*    */   public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
/* 75 */     func_145839_a(pkt.func_148857_g());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145843_s() {
/* 84 */     super.func_145843_s();
/* 85 */     func_145836_u();
/*    */   }
/*    */   
/*    */   public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
/* 89 */     return (oldState.func_177230_c() != newSate.func_177230_c());
/*    */   }
/*    */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\tileentity\TileEntityHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */