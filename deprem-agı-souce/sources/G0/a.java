package G0;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final int f2470a;

    /* renamed from: b  reason: collision with root package name */
    private final d[] f2471b;

    /* renamed from: c  reason: collision with root package name */
    private final b f2472c;

    public a(int i5, d... dVarArr) {
        this.f2470a = i5;
        this.f2471b = dVarArr;
        this.f2472c = new b(i5);
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f2470a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (d dVar : this.f2471b) {
            if (stackTraceElementArr2.length <= this.f2470a) {
                break;
            }
            stackTraceElementArr2 = dVar.a(stackTraceElementArr);
        }
        if (stackTraceElementArr2.length > this.f2470a) {
            return this.f2472c.a(stackTraceElementArr2);
        }
        return stackTraceElementArr2;
    }
}
