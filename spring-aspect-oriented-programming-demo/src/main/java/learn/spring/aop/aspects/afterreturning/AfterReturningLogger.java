package learn.spring.aop.aspects.afterreturning;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import learn.spring.aop.dao.entity.Account;

@Aspect
@Component
public class AfterReturningLogger {

	@AfterReturning(pointcut = "learn.spring.aop.aspects.before.ReusablePointcutAspect.forDaoPackage()", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint,
			List<Account> result) {
		System.out.println("AfterReturningLogger.afterReturningAdvice()");
		System.out.println(result);
	}

	@AfterReturning(pointcut = "learn.spring.aop.aspects.before.ReusablePointcutAspect.forDaoPackage()", returning = "result")
	public void afterReturningModifyingResultAdvice(JoinPoint joinPoint,
			List<Account> result) {
		System.out.println(
				"AfterReturningLogger.afterReturningModifyingResultAdvice()");
		for (Account account : result) {
			account.setAccountName(account.getAccountName().toUpperCase());
		}
		System.out.println(result);
	}
}
