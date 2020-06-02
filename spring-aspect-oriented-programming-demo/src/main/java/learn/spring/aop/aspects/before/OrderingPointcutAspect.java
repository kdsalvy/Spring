package learn.spring.aop.aspects.before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // used for ordering of aspects
public class OrderingPointcutAspect {

	@Before("learn.spring.aop.aspects.before.ReusablePointcutAspect.forDaoPackage()")
	public void method1() {
		System.out.println("OrderingPointcutAspect.method1()");
	}
}
