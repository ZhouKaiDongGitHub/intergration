package cn.kzhou.test;

import cn.kzhou.dao.Contact;
import cn.kzhou.model.PolicyModel;
import cn.kzhou.model.ReadModel;
import cn.kzhou.service.PolicyService;
import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.internal.parser.Record;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestService {
    @Test
    public void Test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PolicyService policyService = (PolicyService)applicationContext.getBean("policyService");
        //policyService.quaryPolicy(2);


        // create a BeanIO StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file from the working directory
        factory.load("D:\\WorkSpace_IDEA\\test\\src\\main\\resources\\mapping.xml");

        // create a BeanReader to read from "input.csv"
        BeanReader in = factory.createReader("readFile", new File("D:\\WorkSpace_IDEA\\test\\src\\main\\resources\\input.txt"));

        Date appointDate = null;
        int size = 0;
        ReadModel readModel = null;
        while ((readModel = (ReadModel)in.read()) != null) {
            appointDate = readModel.getPpointDate();
            size = readModel.getSize();
            System.out.println(readModel.getPpointDate());
            System.out.println(readModel.getSize());
        }
        List<PolicyModel> policyModels = policyService.quaryPolicy(appointDate,size);
        if(policyModels.size()==0){
            PolicyModel policyModel = new PolicyModel();
            policyModel.setNo(1);
            policyModel.setEffective(new Date());
            policyModel.setExpiration(new Date());
            policyModel.setFees(2552.0);
            policyModel.setPolicyNumber("000001");
            policyModels.add(policyModel);
        }
        // create a BeanWriter to write to "output.csv"
        BeanWriter out = factory.createWriter("writeFile", new File("D:\\WorkSpace_IDEA\\test\\src\\main\\resources\\output.txt"));
        String string ="no    Effective    Expiration    Fees   PolicyNumber";
        out.write("titleString",string);
        Iterator iterator = policyModels.iterator();
        while (iterator.hasNext()){
            PolicyModel policyModel = (PolicyModel)iterator.next();
            out.write("policyModel",policyModel);
        }
        in.close();
        out.flush();
        out.close();
    }
}
