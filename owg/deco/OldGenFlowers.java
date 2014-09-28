package owg.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class OldGenFlowers extends WorldGenerator
{
    private Block plantBlockId;
    
    public OldGenFlowers(Block b)
    {
        plantBlockId = b;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        for(int l = 0; l < 64; l++)
        {
            int i1 = (i + random.nextInt(8)) - random.nextInt(8);
            int j1 = (j + random.nextInt(4)) - random.nextInt(4);
            int k1 = (k + random.nextInt(8)) - random.nextInt(8);
            
            if(plantBlockId == Blocks.red_mushroom || plantBlockId == Blocks.brown_mushroom)
            {
	            if(world.isAirBlock(i1, j1, k1) && canMushroomStay(world, i1, j1, k1))
	            {
	                world.setBlock(i1, j1, k1, plantBlockId);
	            }
            }
            else
            {
	            if(world.isAirBlock(i1, j1, k1) && plantBlockId.canBlockStay(world, i1, j1, k1))
	            {
	                world.setBlock(i1, j1, k1, plantBlockId);
	            }
            }
        }

        return true;
    }

    public boolean canMushroomStay(World world, int i, int j, int k)
    {
        if(j < 0 || j >= 128)
        {
            return false;
        } 
        else
        {
            return world.getFullBlockLightValue(i, j, k) < 13 && world.getBlock(i, j - 1, k).isOpaqueCube();
        }
    }
}
