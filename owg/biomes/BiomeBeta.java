package owg.biomes;

import java.util.Random;

import owg.deco.OldGenBigTree;
import owg.deco.OldGenForest;
import owg.deco.OldGenTaiga1;
import owg.deco.OldGenTaiga2;
import owg.deco.OldGenTrees;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeBeta extends BiomeGenBase
{
	private int id;

    public BiomeBeta(int par1, int i)
    {
        super(par1);
		id = i;

		if(id == 0 || id == 0)
		{
			spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
		}
	
		if(id == 1 || id == 2 || id == 3 || id == 6)
		{
			spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
		}
		
		if(id == 1 || id == 2 || id == 3 || id == 6)
		{
			spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));
		}
		
		if(id == 7)
		{
			spawnableCreatureList.clear();
			topBlock = Blocks.sand;
			fillerBlock = Blocks.sand;
		}
    }
    
    public WorldGenAbstractTree func_150567_a(Random par1Random)
    {
		if (id == 0)
		{
			if(par1Random.nextInt(3) == 0)
			{
				return new OldGenBigTree(2);
			} else
			{
				return new OldGenTrees(2);
			}
		}
		else if (id == 3) 
		{
			if(par1Random.nextInt(5) == 0)
			{
				return new OldGenForest();
			}
			if(par1Random.nextInt(3) == 0)
			{
				return new OldGenBigTree(2);
			} else
			{
				return new OldGenTrees(2);
			}
		}
		else if (id == 6)
		{
			if (par1Random.nextInt(3) == 0)
			{
				return new OldGenTaiga1();
			}
			else
			{
				return new OldGenTaiga2();
			}
		}	
		else
		{
			if (par1Random.nextInt(10) == 0)
			{
				return new OldGenBigTree(2);
			}
			else
			{
				return new OldGenTrees(2);
			}
		}	
    } 

    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
		if( id == 6 || id == 9 )
		{
			return ColorizerGrass.getGrassColor(0.6F, 0.6F);
		}
		else if( id == 7 )
		{
			return ColorizerFoliage.getFoliageColor(0.8F, 0.2F);
		}
		else
		{
			double d = MathHelper.clamp_float(getFTemp(p_150558_1_, p_150558_2_, p_150558_3_), 0.0F, 1.0F); 
			double d1 = MathHelper.clamp_float(getFloatRainfall(), 0.0F, 1.0F);
			return ColorizerGrass.getGrassColor(d, d1);
		}
    }

    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
		if( id == 6 || id == 9 )
		{
			return ColorizerFoliage.getFoliageColor(0.6F, 0.6F);
		}
		else if( id == 7 )
		{
			return ColorizerFoliage.getFoliageColor(0.8F, 0.2F);
		}
		else
		{
			double d = MathHelper.clamp_float(getFTemp(p_150558_1_, p_150558_2_, p_150558_3_), 0.0F, 1.0F);
			double d1 = MathHelper.clamp_float(getFloatRainfall(), 0.0F, 1.0F);
			return ColorizerFoliage.getFoliageColor(d, d1);
		}
    }    

    @SideOnly(Side.CLIENT)
    public float getFTemp(int p_150564_1_, int p_150564_2_, int p_150564_3_)
    {
        if (p_150564_2_ > 64)
        {
            float var4 = (float)temperatureNoise.func_151601_a((double)p_150564_1_ * 1.0D / 8.0D, (double)p_150564_3_ * 1.0D / 8.0D) * 4.0F;
            return this.temperature - (var4 + (float)p_150564_2_ - 64.0F) * 0.05F / 30.0F;
        }
        else
        {
            return this.temperature;
        }
    }
}
