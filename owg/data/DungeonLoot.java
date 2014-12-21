package owg.data;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ChestGenHooks;

public class DungeonLoot 
{
	public static Random rand;
	public static int nextLoot;
	public static int lootLength = 20;
	
	public static void init(long seed)
	{
		rand = new Random(seed);
		nextLoot = rand.nextInt(lootLength);
	}
	
	public static ItemStack pickItem()
	{
		if(rand.nextInt(6) == 0)
		{
			return ChestGenHooks.getOneItem(ChestGenHooks.DUNGEON_CHEST, rand);
		}
		else
		{
			ItemStack is = null;
			if(nextLoot >= lootLength)
			{
				nextLoot = 0;
			}
			
			switch(nextLoot)
			{
				case 0: is = new ItemStack(Items.water_bucket, 3, 0); break; //bucket water
				case 1: is = new ItemStack(Items.lava_bucket, 3, 0); break; //bucket lava
				case 2: is = new ItemStack(Blocks.dirt, 1, 2); break; //podzol
				case 3: is = new ItemStack(Blocks.sapling, 3, 1); break; //sappling 1
				case 4: is = new ItemStack(Blocks.sapling, 3, 2); break; //sappling 2
				case 5: is = new ItemStack(Blocks.sapling, 3, 3); break; //sappling 3
				case 6: is = new ItemStack(Blocks.sapling, 3, 4); break; //sappling 4
				case 7: is = new ItemStack(Blocks.sapling, 3, 5); break; //sappling 5
				case 8: is = new ItemStack(Blocks.sponge, 5, 0); break; //sponge
				case 9: is = new ItemStack(Blocks.cactus, 1, 0); break; //cactus
				case 10: is = new ItemStack(Blocks.mycelium, 1, 0); break; //mycelium
				case 11: is = new ItemStack(Blocks.clay, 64, 0); break; //clay
				case 12: is = new ItemStack(Items.wheat_seeds, 10, 0); break; //seeds wheat
				case 13: is = new ItemStack(Items.water_bucket, 3, 0); break; //bucket water
				case 14: is = new ItemStack(Items.lava_bucket, 3, 0); break; //bucket lava
				case 15: is = new ItemStack(Items.dye, 1, 3); break; //cocoa seeds
				case 16: is = new ItemStack(Items.melon_seeds, 5, 0); break; //melon wheat
				case 17: is = new ItemStack(Items.pumpkin_seeds, 5, 0); break; //pumpkin wheat
				case 18: is = new ItemStack(Items.carrot, 10, 0); break; //carrot
				case 19: is = new ItemStack(Items.potato, 10, 0); break; //potato
				case 20: is = new ItemStack(Items.reeds, 10, 0); break; //potato
			}
			
			nextLoot++;
			return is;
		}
	}
}
