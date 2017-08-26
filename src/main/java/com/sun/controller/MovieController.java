package com.sun.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.sun.entity.User;

/**
 * 客户端调用
 * @author Administrator
 *
 */
@RestController
public class MovieController {
	public static final Logger Logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable int id) {
//		return restTemplate.getForObject("http://localhost:8084/"+id, User.class);
		//由于用了ribbon所以可以用服务名代替ip:prot
		return restTemplate.getForObject("http://microservice-provider-user/"+id, User.class);
	}
	
	@GetMapping("/log-instance")
	public void logUserInstance() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
		//打印当前选择的是哪个节点
		MovieController.Logger.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
	}
}
