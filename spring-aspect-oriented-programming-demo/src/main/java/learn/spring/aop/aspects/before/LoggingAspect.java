package learn.spring.aop.aspects.before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2) // used for ordering of aspects
public class LoggingAspect {

	// this is a execution point cut using point cut expression
	// execution(modifiers-pattern? return-type-pattern? declaring-type-pattern?
	// method-name-pattern(param-pattern) throws pattern?)
	// the pattern is optional if it has ?
	// we can use * in the patterns to match any modifier of that type
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("LoggingAspect.beforeAddAccount()");
	}

	@Before("execution(public void addAccount(*))")
	public void beforeAddAccountAdviceOneParameterWildcard() {
		System.out.println(
				"LoggingAspect.beforeAddAccountAdviceOneParameterWildcard()");
	}

	@Before("execution(public void addAccount(..))")
	public void beforeAddAccountAdviceAnyParametersWildcard() {
		System.out.println(
				"LoggingAspect.beforeAddAccountAdviceAnyParametersWildcard()");
	}

	// Fully qualified class name of the parameter type is required.
	// (Not required for primitive types)
	@Before("execution(public void addAccount(learn.spring.aop.dao.entity.Account, int))")
	public void beforeAddAccountForSpecificParameterType() {
		System.out.println(
				"LoggingAspect.beforeAddAccountForSpecificParameterType()");
	}

	@Before("execution(* learn.spring.aop.dao.*.*(..))")
	public void beforeAnyMethodAnyClassOfAPackage() {
		System.out.println("LoggingAspect.beforeAnyMethodAnyClassOfAPackage()");
	}

	@Before("execution(* add*(..))")
	public void beforeAnyMethodStartingWithAdd() {
		System.out.println("LoggingAspect.beforeAnyMethodStartingWithAdd()");
	}
}
