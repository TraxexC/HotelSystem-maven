package blservice;

import VO.VipStrategyVO;

public interface VipStrategy_blService {

	public boolean makeVipStrategy(VipStrategyVO vipstrategy);

	public boolean modifyVipStrategy(VipStrategyVO vipstrategy);

	public VipStrategyVO getVipStrategy();

	//����4����5���Ļ�Ա
    public VipStrategyVO getVipstrategy(String city, String district);

    public boolean makeSuperVipStrategy(VipStrategyVO vipStrategyVO);

    public boolean modifuSuperVipStrategy(VipStrategyVO vipStrategyVO);

    public boolean deleteSuperVipStrategy(String city, String district);

    public int getSuperVipNum();

}
