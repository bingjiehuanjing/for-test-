package rikuto.manaita_plus.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IManaita {
  void onHook(World paramWorld, BlockPos paramBlockPos, IBlockState paramIBlockState, EntityPlayer paramEntityPlayer, EnumHand paramEnumHand, EnumFacing paramEnumFacing, float paramFloat1, float paramFloat2, float paramFloat3, Block paramBlock);
}


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\block\IManaita.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */