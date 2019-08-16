package cn.kzhou.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ModelCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Apache Camel FTP Demo
 */
public class HelloWorld extends RouteBuilder {
    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) throws Exception {
        ModelCamelContext camelContext = new DefaultCamelContext();
        camelContext.start();
        camelContext.addRoutes(new HelloWorld());
    }
    @Override
    public void configure() throws Exception {
        from("ftp://192.168.240.61:21?username=test&password=CMxiaoming950105&binary=true&passiveMode=true&delete=true&delay=50")
                //.process(new HttpProcessor())
                .log(LoggingLevel.INFO, logger,"Downloaded file complete.")
                .to("file:C:/Users/kzhou/Desktop/ftp");
    }
}
