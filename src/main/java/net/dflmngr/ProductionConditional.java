package net.dflmngr;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ProductionConditional implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String appEnv = System.getenv("APP_ENV");
		return (appEnv != null && appEnv.equalsIgnoreCase("production"));
	}
}
