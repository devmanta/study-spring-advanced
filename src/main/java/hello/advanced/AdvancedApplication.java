package hello.advanced;

import hello.advanced.part2.proxy.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(AppV1Config.class) //나중에 v2, v3 로 바꿀 때, v2, v3만 적용하고 싶어서
//@SpringBootApplication(scanBasePackages = "hello.advanced.part2.proxy.app") //이렇게 명시하면 이 하위 패키지만 componentScan대상이 된다.
public class AdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

}
