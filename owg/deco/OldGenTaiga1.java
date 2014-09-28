// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package owg.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockLeaves, 
//            BlockGrass

public class OldGenTaiga1 extends WorldGenAbstractTree
{

    public OldGenTaiga1()
    {
    	super(false);
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        int l = random.nextInt(5) + 7;
        int i1 = l - random.nextInt(2) - 3;
        int j1 = l - i1;
        int k1 = 1 + random.nextInt(j1 + 1);
        boolean flag = true;
        if(j < 1 || j + l + 1 > 128)
        {
            return false;
        }
        for(int l1 = j; l1 <= j + 1 + l && flag; l1++)
        {
            int j2 = 1;
            if(l1 - j < i1)
            {
                j2 = 0;
            } else
            {
                j2 = k1;
            }
            for(int l2 = i - j2; l2 <= i + j2 && flag; l2++)
            {
                for(int k3 = k - j2; k3 <= k + j2 && flag; k3++)
                {
                    if(l1 >= 0 && l1 < 128)
                    {
                        Block j4 = world.getBlock(l2, l1, k3);
                        if(j4 != Blocks.air && j4 != Blocks.leaves)
                        {
                            flag = false;
                        }
                    } else
                    {
                        flag = false;
                    }
                }

            }

        }

        if(!flag)
        {
            return false;
        }
        Block i2 = world.getBlock(i, j - 1, k);
        if(i2 != Blocks.grass && i2 != Blocks.dirt || j >= 128 - l - 1)
        {
            return false;
        }
        world.setBlock(i, j - 1, k, Blocks.dirt);
        int k2 = 0;
        for(int i3 = j + l; i3 >= j + i1; i3--)
        {
            for(int l3 = i - k2; l3 <= i + k2; l3++)
            {
                int k4 = l3 - i;
                for(int l4 = k - k2; l4 <= k + k2; l4++)
                {
                    int i5 = l4 - k;
                    if((Math.abs(k4) != k2 || Math.abs(i5) != k2 || k2 <= 0) && !world.getBlock(l3, i3, l4).isOpaqueCube())
                    {
                        world.setBlock(l3, i3, l4, Blocks.leaves, 1, 2);
                    }
                }

            }

            if(k2 >= 1 && i3 == j + i1 + 1)
            {
                k2--;
                continue;
            }
            if(k2 < k1)
            {
                k2++;
            }
        }

        for(int j3 = 0; j3 < l - 1; j3++)
        {
            Block i4 = world.getBlock(i, j + j3, k);
            if(i4 == Blocks.air || i4 == Blocks.leaves)
            {
                world.setBlock(i, j + j3, k, Blocks.log, 1, 2);
            }
        }

        return true;
    }
}
