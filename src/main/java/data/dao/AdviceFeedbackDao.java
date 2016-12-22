package data.dao;

import PO.AdviceFeedBackPO;

import java.util.ArrayList;

public interface AdviceFeedbackDao {

    public boolean addAdvice(AdviceFeedBackPO advice);

    public boolean updateAdvice(AdviceFeedBackPO advice);

    public ArrayList<AdviceFeedBackPO> getAdvices(String userId, String type);

    public ArrayList<AdviceFeedBackPO> getAllAdvices();
}
