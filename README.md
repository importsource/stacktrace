# Stacktrace
a simple util for logging method invocation


## step 1:

you need override `toString`method,and return seqId.

```java

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

public class A {
	public void p() {
		System.out.println(StackTrace.trace(new Throwable()));
		System.out.println("a");
	}

}
```

```java

public class B {
	private A a = new A();

	public void p() {
		System.out.println(StackTrace.trace(new Throwable()));
		a.p();
	}
}
```

```java
public class C {
	private B b = new B();

	public void p() {
		System.out.println(StackTrace.trace(new Throwable()));
		b.p();
	}
}
```

##console output:

```log

depth:2,,234sd3ed2dXl1,com.importsource.stacktrace.Demo>>>com.importsource.stacktrace.C>>>
depth:3,,234sd3ed2dXl1,com.importsource.stacktrace.Demo>>>com.importsource.stacktrace.C>>>com.importsource.stacktrace.B>>>
depth:4,,234sd3ed2dXl1,com.importsource.stacktrace.Demo>>>com.importsource.stacktrace.C>>>com.importsource.stacktrace.B>>>com.importsource.stacktrace.A>>>
a


```
