package cn.kzhou.webservice;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import java.util.Collection;

import static javax.swing.UIManager.get;

public class CXFTest {
    // HTTP 405 Method Not Allowed : 请求方式错误,例如,服务端要求使用POST请求,客户端发起请求的时候,使用了PUT请求
    // 保存
    @Test
    public void test1() {
        WebClient
                //服务器地址 : 端口号/项目名/
                // web.xml中cxfServlet指定的地址/applicationContext.xml中指定的地址/类上Path指定的地址/方法上Path指定的地址
                .create("http://localhost:8080/test_parent_war/webservice/userService/user")// 指定请求的地址
                .post(new User(11, "zhansan", 23));
    }

    @Test
    public void test2() {
        WebClient.create("http://localhost:8080/cxf_rs_server/webService/userService/user")
                .query("id", 100)
                .delete();
    }

    public void test3() {
        WebClient.create("http://localhost:8080/cxf_rs_server/webService/userService/user")
                .put(new User(11, "张三", 12));
    }

    //查询所有
    public void test4() {
        Collection<? extends User> collection = WebClient
                .create("http://localhost:8080/cxf_rs_server/webService/userService/user")
                .getCollection(User.class);
        for (User user : collection) {
            System.out.println(user);
        }
    }

    //根据字段查询结果
    @Test
    public void test5() {
        User user = WebClient.create("http://localhost:8080/cxf_rs_server/webService/userService/user")
                .query("id", 11).get(User.class);
        System.out.println(user);
    }

    @Test
    public void test6(){
        User user = WebClient.create("http://localhost:8080/cxf_rs_server/webService/userService/user/\" + 22 + \"/icon")
                .get(User.class);
        System.out.println(user);
    }

    public void test7(){
        WebClient.create("http://localhost:8080/cxf_rs_server/webService/userService/user")
                .type(MediaType.APPLICATION_JSON)

                .accept(MediaType.APPLICATION_JSON)
                .post(new User(11, "张三", 12));
    }
}
