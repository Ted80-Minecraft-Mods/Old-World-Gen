package owg.deco;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class OldGenPumpkin extends WorldGenerator
{

    public OldGenPumpkin()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        for(int l = 0; l < 64; l++)
        {
            int i1 = (i + random.nextInt(8)) - random.nextInt(8);
            int j1 = (j + random.nextInt(4)) - random.nextInt(4);
            int k1 = (k + random.nextInt(8)) - random.nextInt(8);
            if(world.isAirBlock(i1, j1, k1) && world.getBlock(i1, j1 - 1, k1) == Blocks.grass && Blocks.pumpkin.canPlaceBlockAt(world, i1, j1, k1))
            {
                world.setBlock(i1, j1, k1, Blocks.pumpkin, random.nextInt(4), 2);
            }
        }

        return true;
    }
}
