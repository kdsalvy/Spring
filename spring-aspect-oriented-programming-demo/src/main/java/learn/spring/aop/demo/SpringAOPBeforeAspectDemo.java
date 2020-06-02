package learn.spring.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import learn.spring.aop.config.DemoConfig;
import learn.spring.aop.dao.AccountDAO;
import learn.spring.aop.dao.entity.Account;

public class SpringAOPBeforeAspectDemo {

	public static void main(String[] args) {
		// read spring config java classes
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				DemoConfig.class);
		// get bean from container
		AccountDAO accountDAO = applicationContext.getBean("accountDao",
				AccountDAO.class);
		// call business method
		Account account = new Account();
		account.setId(1L);
		accountDAO.setExpr("Expression String");
		System.out.println("<<============================================>>");
		accountDAO.getExpr();
		System.out.println("<<============================================>>");
		account.setAccountName("AspectProgrammingAccount");
		accountDAO.addAccount();
		System.out.println("<<============================================>>");
		accountDAO.addAccount(account);
		System.out.println("<<============================================>>");
		accountDAO.addAccount(account, 1);
		System.out.println("<<============================================>>");
		account.getAccountName();
		account.getId();
		// closes the context
		applicationContext.close();
	}

}
