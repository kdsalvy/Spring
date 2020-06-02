package learn.spring.aop.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import learn.spring.aop.dao.entity.Account;

@Component("accountDao")
// using error stream just to identify method call from the printouts
public class AccountDAO {

	private String expr;

	public void addAccount() {
		System.out.println("AccountDAO.addAccount()");
	}

	public void addAccount(Account account) {
		System.out.println("AccountDAO.addAccount()");
	}

	public void addAccount(Account account, int index) {
		System.out.println("AccountDAO.addAccount()");
	}

	public List<Account> findAllAccounts() {
		System.out.println("AccountDAO.findAllAccounts()");
		return Arrays.asList(
				new Account(2L, "AfterReturningAspectAccountItem1"),
				new Account(3L, "AfterReturningAspectAccountItem1"));
	}

	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}
}
