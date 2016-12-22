package data.dao;

import PO.AssessmentPO;

import java.util.ArrayList;

public interface AssessmentDao {

    public boolean addAssessment(AssessmentPO assessmentPO);

    public boolean deleAssessment(AssessmentPO assessmentPO);

    public AssessmentPO getAssessment(String orderID);

    public ArrayList<AssessmentPO> getAllAssement(String hotelid);

    public ArrayList<AssessmentPO> getUserASS(String userid);

}
