package com.importsource.stacktrace;

/**
 * 用于跟踪方法调用
 * @author Hezf
 *
 */
public class StackTrace {
	public static String trace(Throwable throwable) {
		StackTraceElement[] stackTraces = throwable.getStackTrace();
		// System.out.println(stackTraces.length);
		StringBuffer from = new StringBuffer();
		from.append("depth:");
		from.append(stackTraces.length-1);
		from.append(",");
		for (int i = stackTraces.length - 1; i > 0; i--) {
			StackTraceElement element = stackTraces[i];
			String clazzName = element.getClassName();
			if(i==stackTraces.length - 1){
				try {
					from.append(",");
					from.append(Class.forName(clazzName).newInstance().toString());
					from.append(",");
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// System.out.println(clazzName);
			from.append(clazzName + ">>>");

		}

		// System.out.println(from.toString());
		return from.toString();
	}

	public static void printTrace() {
		System.out.println(trace(new Throwable()));
	}
}
