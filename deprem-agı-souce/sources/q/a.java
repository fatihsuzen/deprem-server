package Q;

import N.C0715i;
import android.util.Log;
import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f3901a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3902b;

    /* renamed from: c  reason: collision with root package name */
    private final C0715i f3903c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3904d;

    public a(String str, String... strArr) {
        String str2;
        if (r0 == 0) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str3 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str3);
            }
            sb.append("] ");
            str2 = sb.toString();
        }
        this.f3902b = str2;
        this.f3901a = str;
        this.f3903c = new C0715i(str);
        int i5 = 2;
        while (i5 <= 7 && !Log.isLoggable(this.f3901a, i5)) {
            i5++;
        }
        this.f3904d = i5;
    }

    public void a(String str, Object... objArr) {
        if (d(3)) {
            Log.d(this.f3901a, c(str, objArr));
        }
    }

    public void b(String str, Object... objArr) {
        Log.e(this.f3901a, c(str, objArr));
    }

    /* access modifiers changed from: protected */
    public String c(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f3902b.concat(str);
    }

    public boolean d(int i5) {
        if (this.f3904d <= i5) {
            return true;
        }
        return false;
    }
}
