package data.dao;

import PO.RoomPO;

import java.util.ArrayList;

public interface RoomDao {
    public ArrayList<RoomPO> getAllRoomPO(String hotel);

    public RoomPO findRoomPO(String roomID);

    public boolean modify(RoomPO roomPO);

    public boolean addRoom(RoomPO roomPO);
}
