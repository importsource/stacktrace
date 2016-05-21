package com.importsource.stacktrace;

/**
 * 
 * @author Hezf
 *
 */
public class B {
	private A a = new A();

	public void p() {
		StackTrace.printTrace();
		a.p();
		System.out.println("b");
	}
}
