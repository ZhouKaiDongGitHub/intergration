package example;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import java.io.File;

public class BeanReaderExample {
    public static void main(String[] args) throws Exception {
        // create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load("D:\\WorkSpace_IDEA\\test\\src\\main\\java\\example\\mapping.xml");

        // use a StreamFactory to create a BeanReader
        BeanReader in = factory.createReader("employeeFile", new File("D:\\WorkSpace_IDEA\\test\\src\\main\\java\\example\\employee.csv"));
        Employee employee;
        while ((employee = (Employee) in.read()) != null) {
            // process the employee...
            System.out.println(employee.getFirstName());
        }
        in.close();
    }
}
