package com.importsource.stacktrace;

/**
 * 
 * @author Hezf
 *
 */
public class C {
	private B b = new B();

	public void p() {
		StackTrace.printTrace();
		b.p();
		System.out.println("c");
	}
}
