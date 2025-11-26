package G0;

import java.util.Stack;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f2475a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2476b;

    /* renamed from: c  reason: collision with root package name */
    public final StackTraceElement[] f2477c;

    /* renamed from: d  reason: collision with root package name */
    public final e f2478d;

    private e(String str, String str2, StackTraceElement[] stackTraceElementArr, e eVar) {
        this.f2475a = str;
        this.f2476b = str2;
        this.f2477c = stackTraceElementArr;
        this.f2478d = eVar;
    }

    public static e a(Throwable th, d dVar) {
        Stack stack = new Stack();
        while (th != null) {
            stack.push(th);
            th = th.getCause();
        }
        e eVar = null;
        while (!stack.isEmpty()) {
            Throwable th2 = (Throwable) stack.pop();
            eVar = new e(th2.getLocalizedMessage(), th2.getClass().getName(), dVar.a(th2.getStackTrace()), eVar);
        }
        return eVar;
    }
}
