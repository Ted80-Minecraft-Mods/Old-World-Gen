package owg.data;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
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
				case 0: is = new ItemStack(Item.bucketWater, 3, 0); break; //bucket water
				case 1: is = new ItemStack(Item.bucketLava, 3, 0); break; //bucket lava
				case 3: is = new ItemStack(Block.sapling, 3, 1); break; //sappling 1
				case 4: is = new ItemStack(Block.sapling, 3, 2); break; //sappling 2
				case 5: is = new ItemStack(Block.sapling, 3, 3); break; //sappling 3
				case 8: is = new ItemStack(Block.sponge, 5, 0); break; //sponge
				case 9: is = new ItemStack(Block.cactus, 1, 0); break; //cactus
				case 10: is = new ItemStack(Block.mycelium, 1, 0); break; //mycelium
				case 11: is = new ItemStack(Block.blockClay, 64, 0); break; //clay
				case 12: is = new ItemStack(Item.seeds, 10, 0); break; //seeds wheat
				case 13: is = new ItemStack(Item.bucketWater, 3, 0); break; //bucket water
				case 14: is = new ItemStack(Item.bucketLava, 3, 0); break; //bucket lava
				case 15: is = new ItemStack(Item.dyePowder, 1, 3); break; //cocoa seeds
				case 16: is = new ItemStack(Item.melonSeeds, 5, 0); break; //melon wheat
				case 17: is = new ItemStack(Item.pumpkinSeeds, 5, 0); break; //pumpkin wheat
				case 18: is = new ItemStack(Item.carrot, 10, 0); break; //carrot
				case 19: is = new ItemStack(Item.potato, 10, 0); break; //potato
				case 20: is = new ItemStack(Item.reed, 10, 0); break; //potato
			}
			
			nextLoot++;
			return is;
		}
	}
}
