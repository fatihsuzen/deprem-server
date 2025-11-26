package G0;

public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private final int f2473a;

    public b(int i5) {
        this.f2473a = i5;
    }

    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i5 = this.f2473a;
        if (length <= i5) {
            return stackTraceElementArr;
        }
        int i6 = i5 / 2;
        int i7 = i5 - i6;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i5];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i7);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i6, stackTraceElementArr2, i7, i6);
        return stackTraceElementArr2;
    }
}
