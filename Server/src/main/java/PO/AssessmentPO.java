package PO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AssessmentPO")
public class AssessmentPO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /*
     * userId 评价所属用户id content 评价的信息 type 评价的类型 property 评价的属性 hotelId 对于所在酒店的id
     */
    private String Orderid;
    private String userId;
    String content;
    String type;
    String hotelId;
    int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public AssessmentPO() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    @Id
    public String getOrderId() {
        return Orderid;
    }

    public void setOrderId(String id) {
        this.Orderid = id;
    }

}
