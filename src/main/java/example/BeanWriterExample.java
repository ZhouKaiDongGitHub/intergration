package example;

import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.internal.parser.Record;

import java.io.File;
import java.util.Date;

public class BeanWriterExample {
    public static void main(String[] args) throws Exception {
        // create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load("D:\\WorkSpace_IDEA\\test\\src\\main\\java\\example\\mapping.xml");

        Employee employee = new Employee();
        employee.setFirstName("Jennifer");
        employee.setLastName("Jones");
        employee.setTitle("Marketing");
        employee.setSalary(60000);
        employee.setHireDate(new Date());

        // use a StreamFactory to create a BeanWriter
        BeanWriter out = factory.createWriter("employeeFile1", new File("D:\\WorkSpace_IDEA\\test\\src\\main\\java\\example\\employee1.csv"));
        //BeanReader in = factory.createReader("employeeFile1", new File("D:\\WorkSpace_IDEA\\test\\src\\main\\java\\example\\employee1.csv"));
        // write an Employee object directly to the BeanWriter
        out.write("employee2",employee);
        //Record record = new Record();
        //record = (Record) in.read();
        String string ="qqqq    bbbb    vvvv    cccc";
        out.write("employee1",string);
        //in.close();
        out.flush();
        out.close();
    }
}
