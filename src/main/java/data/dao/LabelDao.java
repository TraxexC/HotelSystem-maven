package data.dao;

import PO.Label;

import java.util.ArrayList;

public interface LabelDao {

    public boolean addLabel(Label label);

    public boolean delLabel(Label label);

    public ArrayList<Label> getLabels(String hotelid);
}
