package PO;

import other.LabelType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "label")
public class Label implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String hotelId;
    private LabelType label;

    public Label() {
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public LabelType getLabel() {
        return label;
    }

    public void setLabel(LabelType label) {
        this.label = label;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
