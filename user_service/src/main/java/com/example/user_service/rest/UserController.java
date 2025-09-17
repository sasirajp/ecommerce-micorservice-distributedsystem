package com.example.user_service.rest;

import com.example.user_service.model.MyUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("users/v1")
public class UserController {


    private final RestTemplate restTemplate;
    private final RestTemplate restTemplateExternal;

    public UserController(@Qualifier("eurekaRestTemplate") RestTemplate restTemplate,@Qualifier("plainRestTemplate") RestTemplate restTemplateExternal) {
        this.restTemplate = restTemplate;
        this.restTemplateExternal = restTemplateExternal;
    }

    @GetMapping("user")
    public MyUser getUser() {
        return new MyUser("sasi", 27);
    }

//    fetches orders using eureka server
    @GetMapping("orders")
    public String getUserLatestOrder(@RequestParam("userName") String userName) {
        String response = restTemplate.getForObject(
                "http://order-service/orders/v1/get_order/user?userName={userName}",
                String.class,
                userName
        );
        System.out.println(response);
        return response;
    }

    //    fetches orders using api gateway + eureka server used to get api-gateway service
    @GetMapping("orders2")
    public String getUserLatestOrderGatewayEureka(@RequestParam("userName") String userName) {
        String response = restTemplate.getForObject(
                "http://api-gateway/orders/v1/get_order/user?userName={userName}",
                String.class,
                userName
        );
        System.out.println(response);
        return response;
    }

    @GetMapping("orders3")
    public String getUserLatestOrderGateway(@RequestParam("userName") String userName) {
        String response = restTemplateExternal.getForObject(
                "http://localhost:8080/orders/v1/get_order/user?userName={userName}",
                String.class,
                userName
        );
        System.out.println(response);
        return response;
    }




}
