package PO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "HotelStrategyPO")
public class HotelStrategyPO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String hotelStrategyInfo;
    private String hotelID;
    private String strategyName;

    /**
     * hotelStrategyInfo �Ƶ�������ԵĻ�������
     * hotelID �Ƶ��id
     */
    public HotelStrategyPO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelStrategyInfo() {
        return hotelStrategyInfo;
    }

    public void setHotelStrategyInfo(String hotelStrategyInfo) {
        this.hotelStrategyInfo = hotelStrategyInfo;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

}
