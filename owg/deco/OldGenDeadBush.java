package owg.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class OldGenDeadBush extends WorldGenerator
{
    private Block field_28058_a;

    public OldGenDeadBush(Block i)
    {
        field_28058_a = i;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	Block b;
        for(; ((b = world.getBlock(i, j, k)) == Blocks.air || b == Blocks.leaves) && j > 0; j--) { }        
        for(int i1 = 0; i1 < 4; i1++)
        {
            int j1 = (i + random.nextInt(8)) - random.nextInt(8);
            int k1 = (j + random.nextInt(4)) - random.nextInt(4);
            int l1 = (k + random.nextInt(8)) - random.nextInt(8);
            if(world.isAirBlock(j1, k1, l1) && field_28058_a.canBlockStay(world, j1, k1, l1))
            {
                world.setBlock(j1, k1, l1, field_28058_a);
            }
        }

        return true;
    }
}
