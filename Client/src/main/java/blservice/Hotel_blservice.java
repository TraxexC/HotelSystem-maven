package blservice;

import java.util.ArrayList;
import VO.HotelInfoVO;

public interface Hotel_blservice {
	public HotelInfoVO getHotelInfo(String hotelId);

    public String getHotelGrade(String hotelID);

	public boolean modifyHotelInfo(HotelInfoVO hotelInfo);

	public ArrayList<HotelInfoVO> getListOfHotel(String strict);

	public ArrayList<HotelInfoVO> getAllHotel();

	public boolean addHotel(HotelInfoVO hotel);

	public ArrayList<HotelInfoVO> getListOfHotelPrefer(String userId);

	public ArrayList<HotelInfoVO> getHotelFromName(String text);

    public ArrayList<HotelInfoVO> getHotelFromGrade(ArrayList<HotelInfoVO> list, int grade);

    public ArrayList<HotelInfoVO> getHotelFromPrice(ArrayList<HotelInfoVO> list, int minPrice, int maxPrice);

    public boolean HotelInfoCompletedComfirm(HotelInfoVO hotel);

    public ArrayList<HotelInfoVO> getHotelFromCity(ArrayList<HotelInfoVO> hotelList, String city, String district);
}
