package learn.spring.aop.aspects.before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3) // used for ordering of aspects
public class ReusablePointcutAspect {

	@Pointcut("execution(* learn.spring.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Before("forDaoPackage()")
	public void forDaoPackageUsingReusablePointcutExpr() {
		System.out.println(
				"ReusablePointcutAspect.forDaoPackageUsingReusablePointcutExpr()");
	}

	// pointcuts for getters
	@Pointcut("execution(* learn.spring.aop.dao.*.set*(..))")
	public void forSetterMethodInDaoPackage() {
	}

	// pointcuts for setters
	@Pointcut("execution(* learn.spring.aop.dao.*.get*(..))")
	public void forGetterMethodInDaoPackage() {
	}

	// combining pointcuts and exclude getters and setters from aop
	@Before("forDaoPackage() && !(forGetterMethodInDaoPackage() || forSetterMethodInDaoPackage())")
	public void beforeDaoPackageExceptGetterSetter() {
		System.out.println(
				"ReusablePointcutAspect.beforeDaoPackageExceptGetterSetter()");
	}
}
