# stacktrace
a simple util for logging method invocation


## step 1:

you need override `toString`method,and return seqId.

```java
/**
 * 
 * @author Hezf
 *
 */
public class Demo {
    private static String seqId="";
	public static void main(String[] args) {
		seqId = "234sd3ed2dXl1";
		C c = new C();
		c.p();
	}
	
	@Override
	public String toString(){
		return seqId;
	}

}
```
## step 2

you need use `StackTrace` like below, you can get the trace path string.

and ensure that any method called contains trace code like this:

```java
/**
 * 
 * @author Hezf
 *
 */
public class A {
	public void p() {
		StackTrace.printTrace();
		System.out.println("a");
	}

}
```

```java
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
```

##console output:

```log
depth:2,,234sd3ed2dXl1,com.importsource.util.stacktrace.Demo>>>com.importsource.util.stacktrace.C>>>
depth:3,,234sd3ed2dXl1,com.importsource.util.stacktrace.Demo>>>com.importsource.util.stacktrace.C>>>com.importsource.util.stacktrace.B>>>
depth:4,,234sd3ed2dXl1,com.importsource.util.stacktrace.Demo>>>com.importsource.util.stacktrace.C>>>com.importsource.util.stacktrace.B>>>com.importsource.util.stacktrace.A>>>
a
b
c

```
