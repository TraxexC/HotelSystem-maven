package data.dao;

import PO.HotelPO;

import java.util.ArrayList;

public interface HotelDao {

    public boolean add(HotelPO hotel);

    public boolean del(HotelPO hotel);

    public HotelPO get(String hotelId);

    public boolean update(HotelPO hotel);

    public ArrayList<HotelPO> getHotels(String strict);

    public ArrayList<HotelPO> getAllHotels();
}
