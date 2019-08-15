package cn.kzhou.service;
import cn.kzhou.dao.PolicyDao;
import cn.kzhou.model.PolicyModel;

import java.util.Date;
import java.util.List;

//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,timeout = -1)
public class PolicyService {
    private PolicyDao policyDao;

    public List<PolicyModel> quaryPolicy(Date appointDate, int size){

        List<PolicyModel> policyModels =  policyDao.quaryPolicySummary(appointDate,size);
        return policyModels;
    }
    public void setPolicyDao(PolicyDao ordersDao) {
        this.policyDao = ordersDao;
    }

}
