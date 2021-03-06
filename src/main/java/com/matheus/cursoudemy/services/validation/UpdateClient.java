package com.matheus.cursoudemy.services.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = UpdateClientValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)


public @interface UpdateClient {	
 String message() default "validation error";
 Class<?>[] groups() default {};
 Class<? extends Payload>[] payload() default {};
}