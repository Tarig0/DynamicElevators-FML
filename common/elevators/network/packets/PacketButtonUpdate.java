package elevators.network.packets;

import net.minecraft.src.World;
import elevators.core.DECore;
import elevators.network.ElevatorPacketHandler;
import eurysmods.network.packets.core.PacketIds;
import eurysmods.network.packets.core.PacketPayload;
import eurysmods.network.packets.core.PacketUpdate;

public class PacketButtonUpdate extends PacketUpdate {

	public PacketButtonUpdate() {
		super(PacketIds.UPDATE);
	}
	
	public PacketButtonUpdate(int x, int y, int z, int metadata) {
		this();
		this.setChannel(ElevatorPacketHandler.CHANNELS[ElevatorPacketHandler.BLOCK_UPDATE]);
		this.setPosition(x, y, z, 0);
		this.payload = new PacketPayload(1, 0, 0, 0);
		this.setMetadata(metadata);
	}

	public void setMetadata(int metadata) {
		this.payload.setIntPayload(0, metadata);
	}

	public int getMetadata() {
		return this.payload.getIntPayload(0);
	}

	@Override
	public boolean targetExists(World world) {
		int blockId = world.getBlockId(this.xPosition, this.yPosition, this.zPosition);
		if (blockId == DECore.elevator_button_blockID) {
			return true;
		}
		return false;
	}

}
