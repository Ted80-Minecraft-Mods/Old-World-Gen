package owg.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import owg.biomes.BiomeList;
import owg.noise.OldNoiseGeneratorOctaves2;
import owg.util.CellNoise;
import owg.util.PerlinNoise;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.IntCache;

public class ManagerOWG extends WorldChunkManager
{
    private BiomeCache biomeCache;
    private List biomesToSpawnIn;
	
    private static OldNoiseGeneratorOctaves2 field_4194_e;
    private static OldNoiseGeneratorOctaves2 field_4193_f;
    private static OldNoiseGeneratorOctaves2 field_4192_g;
    public static double temperature[]; 
    public static double humidity[];
    public static double field_4196_c[];
    private static int biomeLookupTable[] = new int[4096];	
    
    public static ArrayList<BiomeGenBase> biomeList;
    public static int biomeListLength;
    public static int biomeSetting;
    public static float perlinStrength;
    private static PerlinNoise perlin;
    private static CellNoise biomecell;
    
	protected ManagerOWG()
	{
        this.biomeCache = new BiomeCache(this);
        this.biomesToSpawnIn = new ArrayList();
	}

    public ManagerOWG(World par1World, boolean remote, int biomes)
    {
        this();
        long seed = par1World.getSeed();
        
        if(remote)
        {
			generateBiomeLookup();
	        field_4194_e = new OldNoiseGeneratorOctaves2(new Random(seed * 9871L), 4);
	        field_4193_f = new OldNoiseGeneratorOctaves2(new Random(seed * 39811L), 4);
	        field_4192_g = new OldNoiseGeneratorOctaves2(new Random(seed * 0x84a59L), 2);
	        
	        biomeList = new ArrayList<BiomeGenBase>();
	        biomeSetting = biomes;
	        perlin = new PerlinNoise(seed);
	        biomecell = new CellNoise(seed, (short)0);
			BiomeGenBase[] b = BiomeGenBase.getBiomeGenArray();
			int l = b.length;
			
			if(biomes == 1)
			{
				for(int i = 0; i < l; i++)
				{
					if(b[i] != null && b[i].biomeID > 39 && b[i].biomeID > 128 && b[i].biomeID < 168)
					{
						if(!b[i].biomeName.contains("Ocean") && !b[i].biomeName.contains("River") && !b[i].biomeName.contains("Mushroom") && !b[i].biomeName.contains("Beach") && !b[i].biomeName.contains("Hell") && !b[i].biomeName.contains("Sky"))
						{
							biomeList.add(b[i]);
						}
					}
				}
			}
			else if(biomes == 2)
			{
				for(int i = 0; i < l; i++)
				{
					if(b[i] != null)
					{
						if(!b[i].biomeName.contains("Ocean") && !b[i].biomeName.contains("River") && !b[i].biomeName.contains("Mushroom") && !b[i].biomeName.contains("Beach") && !b[i].biomeName.contains("Hell") && !b[i].biomeName.contains("Sky"))
						{
							biomeList.add(b[i]);
						}
					}
				}
			}
			
			if(biomes > 0)
			{
				biomeListLength = biomeList.size();
				perlinStrength = 1 / (biomeListLength * 2);
			}
        }
    }    

	public static double[] getColdTemperatures(double ad[], int i, int j, int k, int l)
    {
        if(ad == null || ad.length < k * l)
        {
            ad = new double[k * l];
        }
        ad = field_4194_e.func_4112_a(ad, i, j, k, l, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        field_4196_c = field_4192_g.func_4112_a(field_4196_c, i, j, k, l, 0.25D, 0.25D, 0.58823529411764708D);
        int i1 = 0;
        for(int j1 = 0; j1 < k; j1++)
        {
            for(int k1 = 0; k1 < l; k1++)
            {
                double d = field_4196_c[i1] * 1.1000000000000001D + 0.5D;
                double d1 = 0.01D;
                double d2 = 1.0D - d1;
                double d3 = (ad[i1] * 0.14999999999999999D + 0.69999999999999996D) * d2 + d * d1;
                d3 = 1.0D - (1.0D - d3) * (1.0D - d3);
                if(d3 < 0.0D)
                {
                    d3 = 0.0D;
                }
                if(d3 > 1.0D)
                {
                    d3 = 1.0D;
                }
                ad[i1] = d3;
                i1++;
            }

        }

        return ad;
    }
	
    public static int[] getBiomesGens(int par1, int par2, int par3, int par4)
    {		
		int[] abiomegenbase = new int[par3 * par4];
		temperature = field_4194_e.func_4112_a(temperature, par1, par2, par3, par3, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
		humidity = field_4193_f.func_4112_a(humidity, par1, par2, par3, par3, 0.05000000074505806D, 0.05000000074505806D, 0.33333333333333331D);
		field_4196_c = field_4192_g.func_4112_a(field_4196_c, par1, par2, par3, par3, 0.25D, 0.25D, 0.58823529411764708D);
		int i1 = 0;
		for(int j1 = 0; j1 < par3; j1++)
		{
			for(int k1 = 0; k1 < par4; k1++)
			{
				double d = field_4196_c[i1] * 1.1000000000000001D + 0.5D;
				double d1 = 0.01D;
				double d2 = 1.0D - d1;
				double d3 = (temperature[i1] * 0.14999999999999999D + 0.69999999999999996D) * d2 + d * d1;
				d1 = 0.002D;
				d2 = 1.0D - d1;
				double d4 = (humidity[i1] * 0.14999999999999999D + 0.5D) * d2 + d * d1;
				d3 = 1.0D - (1.0D - d3) * (1.0D - d3);
				if(d3 < 0.0D)
				{
					d3 = 0.0D;
				}
				if(d4 < 0.0D)
				{
					d4 = 0.0D;
				}
				if(d3 > 1.0D)
				{
					d3 = 1.0D;
				}
				if(d4 > 1.0D)
				{
					d4 = 1.0D;
				}
				temperature[i1] = d3;
				humidity[i1] = d4;
				abiomegenbase[i1++] = getBiomeFromLookup(d3, d4);
			}
		}
		
		if(biomeSetting > 0)
		{
			float h;
			int k11;
			int i2 = 0;
			float off;
			for(int j11 = 0; j11 < par3; j11++)
			{
				for(k11 = 0; k11 < par4; k11++)
				{
					off = perlin.noise2((par1 + j11) / 30F, (par2 + k11) / 30F) * 80 + perlin.noise2((par1 + j11) / 7F, (par2 + k11) / 7F) * 20;
					
					h = (biomecell.noise((par1 + j11 + off) / 250D, (par2 + k11 - off) / 250D, 1D) * 0.5f) + 0.5f;
					h = h < 0f ? 0f : h >= 0.9999999f ? 0.9999999f : h;
					h *= biomeListLength;
					abiomegenbase[i2++] = biomeList.get((int)(h)).biomeID;
				}
			}
		}
		return abiomegenbase;
    }
	
    public static int getBiomeFromLookup(double d, double d1)
    {
        int i = (int)(d * 63D);
        int j = (int)(d1 * 63D);
        return biomeLookupTable[i + j * 64];
    }
	
    public void generateBiomeLookup()  
    {
		for(int i = 0; i < 64; i++)
		{
			for(int j = 0; j < 64; j++)
			{
				biomeLookupTable[i + j * 64] = getBetaBiomes((float)i / 63F, (float)j / 63F);
			}
		}
    }
	
    public int getBetaBiomes(float f, float f1) 
    {
		f1 *= f;
		if(f < 0.1F)
		{
			return BiomeList.OLDtundra.biomeID; 
		}
		if(f1 < 0.2F)
		{
			if(f < 0.5F)
			{
				return BiomeList.OLDtundra.biomeID;
			}
			if(f < 0.95F)
			{
				return BiomeList.OLDsavanna.biomeID;
			} else
			{
				return BiomeList.OLDdesert.biomeID;
			}
		}
		if(f1 > 0.5F && f < 0.7F)
		{
			return BiomeList.OLDswampland.biomeID;
		}
		if(f < 0.5F)
		{
			return BiomeList.OLDtaiga.biomeID;
		}
		if(f < 0.97F)
		{
			if(f1 < 0.35F)
			{
				return BiomeList.OLDshrubland.biomeID;
			} else
			{
				return BiomeList.OLDforest.biomeID;
			}
		}
		if(f1 < 0.45F)
		{
			return BiomeList.OLDplains.biomeID;
		}
		if(f1 < 0.9F)
		{
			return BiomeList.OLDseasonalForest.biomeID;
		} else
		{
			return BiomeList.OLDrainforest.biomeID;
		}
    }
    
    public List getBiomesToSpawnIn()
    {
        return this.biomesToSpawnIn;
    }

    public BiomeGenBase getBiomeGenAt(int par1, int par2)
    {
        return this.biomeCache.getBiomeGenAt(par1, par2);
    }

    public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

		int var6[] = getBiomesGens(par2, par3, par4, par5);

        for (int var7 = 0; var7 < par4 * par5; ++var7)
        {
            float var8 = (float)BiomeGenBase.getBiome(var6[var7]).getIntRainfall() / 65536.0F;

            if (var8 > 1.0F)
            {
                var8 = 1.0F;
            }

            par1ArrayOfFloat[var7] = var8;
        }

        return par1ArrayOfFloat;
    }

    public float getTemperatureAtHeight(float par1, int par2)
    {
        return par1;
    }

    /*public float[] getTemperatures(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

		int var6[] = getBiomesGens(par2, par3, par4, par5);

        for (int var7 = 0; var7 < par4 * par5; ++var7)
        {
            float var8 = (float)BiomeGenBase.func_150568_d(var6[var7]).getIntTemperature() / 65536.0F;

            if (var8 > 1.0F)
            {
                var8 = 1.0F;
            }

            par1ArrayOfFloat[var7] = var8;
        }

        return par1ArrayOfFloat;
    }*/

    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

		int var6[] = getBiomesGens(par2, par3, par4, par5);

        for (int var7 = 0; var7 < par4 * par5; ++var7)
        {
            par1ArrayOfBiomeGenBase[var7] = BiomeGenBase.getBiome(var6[var7]);
        }

        return par1ArrayOfBiomeGenBase;
    }

    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        return this.getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
    }

    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5, boolean par6)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        if (par6 && par4 == 16 && par5 == 16 && (par2 & 15) == 0 && (par3 & 15) == 0)
        {
            BiomeGenBase[] var9 = this.biomeCache.getCachedBiomes(par2, par3);
            System.arraycopy(var9, 0, par1ArrayOfBiomeGenBase, 0, par4 * par5);
            return par1ArrayOfBiomeGenBase;
        }
        else
        {
			int var7[] = getBiomesGens(par2, par3, par4, par5);

            for (int var8 = 0; var8 < par4 * par5; ++var8)
            {
                par1ArrayOfBiomeGenBase[var8] = BiomeGenBase.getBiome(var7[var8]);
            }

            return par1ArrayOfBiomeGenBase;
        }
    }

    public boolean areBiomesViable(int par1, int par2, int par3, List par4List)
    {
    	return false;
    }

    public ChunkPosition findBiomePosition(int p_150795_1_, int p_150795_2_, int p_150795_3_, List p_150795_4_, Random p_150795_5_)
    {
    	return null;
    }

    public void cleanupCache()
    {
        this.biomeCache.cleanupCache();
    }
}