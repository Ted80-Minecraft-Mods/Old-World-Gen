package owg.support;

import net.minecraft.world.biome.BiomeGenBase;

public class SupportTC 
{
	/*
	THAUMCRAFT BIOMES
	
	118: "Tainted Land"
	119: "Magical Forest"
	*/
	
	public static void init()
	{
		BiomeGenBase[] b = BiomeGenBase.getBiomeGenArray();
		
		for(int i = 0; i < 256; i++)
		{
			if(b[i] != null)
			{
				if(b[i].biomeName == "Tainted Land" || b[i].biomeName == "Magical Forest")
				{
					Support.biomes_small.add(b[i]);
				}
			}
		}
	}
}