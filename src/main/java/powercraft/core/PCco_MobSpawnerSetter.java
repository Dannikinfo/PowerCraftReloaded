package powercraft.core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import powercraft.api.interfaces.PC_IMSG;
import powercraft.api.network.PC_IPacketHandler;
import powercraft.api.reflect.PC_ReflectHelper;
import powercraft.api.registry.PC_GresRegistry;
import powercraft.api.registry.PC_MSGRegistry;
import powercraft.api.tileentity.PC_TileEntity;
import powercraft.api.utils.PC_Utils;
import powercraft.api.utils.PC_VecI;

public class PCco_MobSpawnerSetter implements PC_IPacketHandler, PC_IMSG
{
    @Override
    public boolean handleIncomingPacket(EntityPlayer player, Object[] o)
    {
        TileEntityMobSpawner tems = (TileEntityMobSpawner)player.worldObj.getTileEntity((Integer)o[0], (Integer)o[1], (Integer)o[2]);
        MobSpawnerBaseLogic msbl = tems.func_145881_a();
		msbl.setEntityName((String)o[3]);
        PC_ReflectHelper.setValue(MobSpawnerBaseLogic.class, msbl, 9, null, Entity.class);
        return true;
    }

	@Override
	public Object msg(int msg, Object... obj) {

		switch(msg){
		case PC_MSGRegistry.MSG_ON_ACTIVATOR_USED_ON_BLOCK:
			PC_VecI pos = (PC_VecI)obj[3];
			PC_TileEntity te = new PC_TileEntity();
			te.xCoord = pos.x;
			te.yCoord = pos.y + 1;
			te.zCoord = pos.z;
			if(PC_Utils.getTE((World)obj[2], pos) instanceof TileEntityMobSpawner){
				PC_GresRegistry.openGres("SpawnerEditor", (EntityPlayer)obj[1], te, null);
				return true;
			}
	        return false;
		}
		return null;
	}
}