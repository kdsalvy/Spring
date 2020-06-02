package learn.spring.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import learn.spring.aop.config.DemoConfig;
import learn.spring.aop.dao.AccountDAO;

public class SpringAOPAfterReturningAspectDemo {

	public static void main(String[] args) {
		// read spring config java classes
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				DemoConfig.class);
		// get bean from container
		AccountDAO accountDAO = applicationContext.getBean("accountDao",
				AccountDAO.class);
		// call business method
		accountDAO.findAllAccounts();
		System.out.println("<<============================================>>");
		// closes the context
		applicationContext.close();
	}

}
