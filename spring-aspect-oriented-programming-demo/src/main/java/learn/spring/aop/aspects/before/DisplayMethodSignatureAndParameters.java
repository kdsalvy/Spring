package learn.spring.aop.aspects.before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class DisplayMethodSignatureAndParameters {

	@Before("learn.spring.aop.aspects.before.ReusablePointcutAspect.forDaoPackage()")
	public void displayMethodParameter(JoinPoint joinPoint) {
		System.out.println(
				"DisplayMethodSignatureAndParameters.displayMethodParameter()");
		Object[] args = joinPoint.getArgs();
		for (Object obj : args) {
			System.out.println("Parameter: " + obj);
		}
	}

	@Before("learn.spring.aop.aspects.before.ReusablePointcutAspect.forDaoPackage()")
	public void displayMethodSignature(JoinPoint joinPoint) {
		System.out.println(
				"DisplayMethodSignatureAndParameters.displayMethodSignature()");
		Signature sig = joinPoint.getSignature();
		System.out.println("Method Signature: " + sig);
	}
}
