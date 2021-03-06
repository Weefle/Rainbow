package org.projectrainbow;


import PluginReference.MC_Block;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;


public class BlockWrapper implements MC_Block {

    public Block m_blockObject = null;
    public IBlockState m_blockState = null;

    public BlockWrapper(IBlockState parm) {
        this.m_blockState = parm;
        this.m_blockObject = parm.getBlock();
    }

    public int getId() {
        return Block.getIdFromBlock(this.m_blockObject);
    }

    public int getSubtype() {
        try {
            return this.m_blockObject.getMetaFromState(this.m_blockState);
        } catch (Exception var2) {
            return -1;
        }
    }

    public boolean isLiquid() {
        return this.m_blockObject.getMaterial(m_blockState).isLiquid();
    }

    public boolean isSolid() {
        return this.m_blockObject.getMaterial(m_blockState).isSolid();
    }

    public void setSubtype(int idx) {
        this.m_blockState = this.m_blockObject.getStateFromMeta(idx);
    }
}
