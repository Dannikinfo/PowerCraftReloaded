package powercraft.hologram;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import powercraft.api.annotation.PC_FieldObject;
import powercraft.api.block.PC_Block;
import powercraft.api.item.PC_ItemArmor;
import powercraft.api.item.PC_ItemStack;
import powercraft.launcher.loader.PC_Module;
import powercraft.launcher.loader.PC_Module.PC_Instance;
import powercraft.launcher.loader.PC_ModuleObject;

@PC_Module(name = "Hologram", version = "1.1.1")
public class PChg_App {

	@PC_FieldObject(clazz = PChg_BlockHologramBlockEmpty.class)
	public static PC_Block hologramBlockEmpty;
	@PC_FieldObject(clazz = PChg_BlockHologramBlock.class)
	public static PC_Block hologramBlock;
	@PC_FieldObject(clazz = PChg_BlockHologramField.class)
	public static PC_Block hologramField;
	@PC_FieldObject(clazz = PChg_ItemArmorHologramGlasses.class)
	public static PC_ItemArmor hologramGlasses;
	@PC_Instance
	private static PC_ModuleObject instance;

	public static PChg_App getInstance() {
		return (PChg_App) instance.getModule();
	}

	/*@PC_InitRecipes
	public List<PC_IRecipe> initRecipes(List<PC_IRecipe> recipes) {
		recipes.add(new PC_ShapelessRecipes(new PC_ItemStack(hologramBlock), new PC_ItemStack(hologramBlockEmpty),
				getAllAccepptedBlocksForHologramBlock()));
		recipes.add(new PChg_HologramBackRecipe());
		recipes.add(new PC_ShapedRecipes(new PC_ItemStack(hologramBlockEmpty), " p ", "gcg", "ggg", 'g', Block.glass,
				'c', Block.chest, 'p',
				new PC_ItemStack(PC_BlockRegistry.getPCBlockByName("PCco_BlockPowerCrystal"), 1, -1)));
		recipes.add(new PC_ShapedRecipes(new PC_ItemStack(hologramField), "ggg", "hhh", "ioi", 'i', Item.ingotIron, 'g',
				Block.glass, 'h', new PC_ItemStack(hologramBlockEmpty), 'o',
				new PC_ItemStack(PC_ItemRegistry.getPCItemByName("PCco_ItemOreSniffer"))));
		recipes.add(new PC_ShapedRecipes(new PC_ItemStack(hologramGlasses), "i i", "ghg", 'i', Item.ingotIron, 'g',
				Block.thinGlass, 'h', new PC_ItemStack(hologramField)));
		return recipes;
	}

	public List<PC_ItemStack> getAllAccepptedBlocksForHologramBlock() {
		List<PC_ItemStack> l = new ArrayList<PC_ItemStack>();
		Block b;
		for (int i = 1; i < b.blockBlocks.blocksList.length; i++) {
			if (Block.blocksList[i] != null && Item.itemsList[i] != null) {
				if (Block.renderAsNormalBlock()) {
					l.add(new PC_ItemStack(Block.blocksList[i], 1, -1));
				}
			}
		}
		return l;
	}*/

	public void renderHologramField(PChg_TileEntityHologramField te, double x, double y, double z) {

	}

}