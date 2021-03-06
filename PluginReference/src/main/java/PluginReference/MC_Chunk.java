package PluginReference;

/** 
 * Interface representing a Chunk
 */ 			
public interface MC_Chunk
{
	 /** 
     * Get Chunk X Coordinate
     * 
     * @return Chunk X Coordinate (i.e. x >> 4) 
     */ 			
	public int getCX();

	 /** 
     * Get Chunk Z Coordinate
     * 
     * @return Chunk Z Coordinate (i.e. z >> 4) 
     */ 			
	public int getCZ();
}
