package com.revature.gameshop.auth;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented 
public @interface Auth {
	
	String role() default "none";

}
