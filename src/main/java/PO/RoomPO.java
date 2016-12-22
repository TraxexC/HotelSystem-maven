package PO;

import other.RoomType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "RoomPO")
public class RoomPO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /*
     * price ����ĵ���
     * type ���������
     * hotelId ���������ľƵ��id
     * number ���������
     * id �洢ʱ��������
     */
    private int price;
    private RoomType type;
    private String hotelId;
    private int number;
    private int remainNum;
    private String id;

    //room �Ĺ��췽��
    public RoomPO() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(int remainNum) {
        this.remainNum = remainNum;
    }

}
