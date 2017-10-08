package guru.springframework;

import guru.springframework.models.FakeDataUser;
import guru.springframework.models.FakeJmsData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		FakeDataUser user = (FakeDataUser)ctx.getBean(FakeDataUser.class);

		System.out.println(user.toString());

		FakeJmsData jmsData = (FakeJmsData)ctx.getBean(FakeJmsData.class);

		System.out.println(jmsData.toString());
	}
}
