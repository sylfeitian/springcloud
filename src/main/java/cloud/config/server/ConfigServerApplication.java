package cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 启动eureka服务器
 * @author Administrator
 *可以看到只需要使用@EnableEurekaServer注解就可以让应用变为Eureka服务器，
 *这是因为spring boot封装了Eureka Server，让你可以嵌入到应用中直接使用。至于真正的EurekaServer是Netflix公司的开源项目，也是可以单独下载使用的。
 */
@SpringBootApplication
@EnableEurekaServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
