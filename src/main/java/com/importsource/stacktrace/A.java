package com.importsource.stacktrace;

/**
 * 
 * @author Hezf
 *
 */
public class A {
	public void p() {
		System.out.println(StackTrace.trace(new Throwable()));
		System.out.println("a");
	}

}
