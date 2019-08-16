package cn.kzhou.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RouteBuilderExample {

    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("ftp://192.168.240.61:21?username=test&password=CMxiaoming950105&binary=true&passiveMode=true&delete=true&delay=50").
                        to("file:C:/Users/kzhou/Desktop/ftp");
            }
        });
        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
