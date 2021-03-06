package powercraft.api.network.packet;

import java.io.IOException;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import powercraft.api.inventory.PC_IInventory;
import powercraft.api.network.AbstractMessage.AbstractServerMessage;
import powercraft.api.network.PC_PacketHandler;
import powercraft.api.tileentity.PC_TileEntity;
import powercraft.storage.PCs_ItemCompressor;

public class PC_PacketSyncInvTC_pt1 extends AbstractServerMessage<PC_PacketSyncInvTC_pt1> {

	int x, y, z, slot;

	public PC_PacketSyncInvTC_pt1() {
	}

	public PC_PacketSyncInvTC_pt1(PC_TileEntity te, int slot) {
		if (te != null) {
			this.x = te.xCoord;
			this.y = te.yCoord;
			this.z = te.zCoord;
		} else {
			x = 0;
			y = 0;
			z = 0;
		}
		this.slot = slot;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		slot = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(slot);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		PC_IInventory te = (PC_IInventory) player.worldObj.getTileEntity(x, y, z);
		if (side == Side.SERVER) {
			if (te == null) {
				//PC_IInventory inv = PCis_ItemCompressor.getInventoryFor(player, slot);
				//inv.syncInventory(1, player, slot);
			} else {
				te.syncInventory(1, player, 0);
			}
		}
	}

}
