package cn.kzhou.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags="订单模块") // Swagger-UI 描述在类上面，可以做分组。
public class OrderController  {

    @RequestMapping(method = RequestMethod.GET, value = "/order/orderInfo/{orderId:.+}")
    @ResponseBody
    @ApiOperation(value = "获取订单") // 让Swagger-UI解析这个接口。
    public OrderInfo getOrderInfo(String orderId) {
        return new OrderInfo();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/order/delOrder.do")
    @ResponseBody
    @ApiOperation(value = "删除订单")
    public BaseResponse delOrder(String orderId) {
        return new BaseResponse();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/order/queryOrderList.do")
    @ResponseBody
    @ApiOperation(value = "查询订单列表")
    public QueryOrderListResponse getOrderInfo(@RequestBody QueryOrderListRequest req) {
        return new QueryOrderListResponse();
    }
}
