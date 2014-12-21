package owg.deco;

import java.util.Random;

import owg.data.DungeonLoot;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;

public class OldGenDungeons extends WorldGenerator
{
    public OldGenDungeons()
    {
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        byte byte0 = 3;
        int i = par2Random.nextInt(2) + 2;
        int j = par2Random.nextInt(2) + 2;
        int k = 0;

		for (int l = par3 - i - 1; l <= par3 + i + 1; l++)
		{
			for (int k1 = par4 - 1; k1 <= par4 + byte0 + 1; k1++)
			{
				for (int j2 = par5 - j - 1; j2 <= par5 + j + 1; j2++)
				{
					Material material = par1World.getBlock(l, k1, j2).getMaterial();

					if (k1 == par4 - 1 && !material.isSolid())
					{
						return false;
					}

					if (k1 == par4 + byte0 + 1 && !material.isSolid())
					{
						return false;
					}

					if ((l == par3 - i - 1 || l == par3 + i + 1 || j2 == par5 - j - 1 || j2 == par5 + j + 1) && k1 == par4 && par1World.isAirBlock(l, k1, j2) && par1World.isAirBlock(l, k1 + 1, j2))
					{
						k++;
					}
				}
			}
		}

		if (k < 1 || k > 5)
		{
			return false;
		}
		
        for (int i1 = par3 - i - 1; i1 <= par3 + i + 1; i1++)
        {
            for (int l1 = par4 + byte0; l1 >= par4 - 1; l1--)
            {
                for (int k2 = par5 - j - 1; k2 <= par5 + j + 1; k2++)
                {
                    if (i1 == par3 - i - 1 || l1 == par4 - 1 || k2 == par5 - j - 1 || i1 == par3 + i + 1 || l1 == par4 + byte0 + 1 || k2 == par5 + j + 1)
                    {
                        if (l1 >= 0 && !par1World.getBlock(i1, l1 - 1, k2).getMaterial().isSolid())
                        {
    						par1World.setBlock(i1, l1, k2, Blocks.air);
                            continue;
                        }

                        if (!par1World.getBlock(i1, l1, k2).getMaterial().isSolid())
                        {
                            continue;
                        }

                        if (l1 == par4 - 1 && par2Random.nextInt(4) != 0)
                        {
							par1World.setBlock(i1, l1, k2, Blocks.mossy_cobblestone);
						}
						else
						{
							par1World.setBlock(i1, l1, k2, Blocks.cobblestone);
                        }
                    }
                    else
                    {
						par1World.setBlock(i1, l1, k2, Blocks.air);
                    }
                }
            }
        }

        for (int j1 = 0; j1 < 2; j1++)
        {
            label0:

            for (int i2 = 0; i2 < 3; i2++)
            {
                int l2 = (par3 + par2Random.nextInt(i * 2 + 1)) - i;
                int i3 = par4;
                int j3 = (par5 + par2Random.nextInt(j * 2 + 1)) - j;

                if (!par1World.isAirBlock(l2, i3, j3))
                {
                    continue;
                }

                int k3 = 0;

                if (par1World.getBlock(l2 - 1, i3, j3).getMaterial().isSolid())
                {
                    k3++;
                }

                if (par1World.getBlock(l2 + 1, i3, j3).getMaterial().isSolid())
                {
                    k3++;
                }

                if (par1World.getBlock(l2, i3, j3 - 1).getMaterial().isSolid())
                {
                    k3++;
                }

                if (par1World.getBlock(l2, i3, j3 + 1).getMaterial().isSolid())
                {
                    k3++;
                }

                if (k3 != 1)
                {
                    continue;
                }

				par1World.setBlock(l2, i3, j3, Blocks.chest);
				TileEntityChest tileentitychest = (TileEntityChest)par1World.getTileEntity(l2, i3, j3);

                if (tileentitychest == null)
                {
                    break;
                }

                int l3 = 0;

                do
                {
					
                    if (l3 >= 8)
                    {
                        break label0;
                    }

                    ItemStack itemstack = pickCheckLootItem(par2Random);

                    if (itemstack != null)
                    {
                        tileentitychest.setInventorySlotContents(par2Random.nextInt(tileentitychest.getSizeInventory()), itemstack);
                    }

                    l3++;
                }
                while (true);
            }
        }

        par1World.setBlock(par3, par4, par5, Blocks.mob_spawner);
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)par1World.getTileEntity(par3, par4, par5);


        if (tileentitymobspawner != null)
        {
            tileentitymobspawner.func_145881_a().setEntityName(pickMobSpawner(par2Random));
        }
        else
        {
            System.err.println((new StringBuilder()).append("Failed to fetch mob spawner entity at (").append(par3).append(", ").append(par4).append(", ").append(par5).append(")").toString());
        }

        return true;
    }
	
	private ItemStack pickCheckLootItem(Random random)
	{
		//fix for world gen seed
		int i = random.nextInt(11), r = 0;
		if(i == 1) { r = random.nextInt(4) + 1; }
		else if(i == 3) { r = random.nextInt(4) + 1; }
		else if(i == 4) { r = random.nextInt(4) + 1; }
		else if(i == 5) { r = random.nextInt(4) + 1; }
		else if(i == 7 && random.nextInt(100) == 0) { }
		else if(i == 8 && random.nextInt(2) == 0) { r = random.nextInt(4) + 1; }
		else if(i == 9 && random.nextInt(10) == 0) { r = random.nextInt(2); }
		
		//getting item from DungeonLoot array
		return DungeonLoot.pickItem();
	}

    private String pickMobSpawner(Random random)
    {
        int i = random.nextInt(4);
        if(i == 0)
        {
            return "Skeleton";
        }
        if(i == 1)
        {
            return "Zombie";
        }
        if(i == 2)
        {
            return "Zombie";
        }
        if(i == 3)
        {
            return "Spider";
        } else
        {
            return "";
        }
    }
}
