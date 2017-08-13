package guru.springframework;

import guru.springframework.controller.ConstructorInjectedControler;
import guru.springframework.controller.GetterInjectedControler;
import guru.springframework.controller.MyController;
import guru.springframework.controller.PropertyInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");
		controller.hello();

		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(GetterInjectedControler.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedControler.class).sayHello());
	}
}
