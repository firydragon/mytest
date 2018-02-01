package cn.itcast.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.Banner;
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		//会出现springboot得启动标识
		//SpringApplication.run(Application.class, args);
		
		//如果需要去掉springboot得启动标识，那么使用下面得代码
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}

}
