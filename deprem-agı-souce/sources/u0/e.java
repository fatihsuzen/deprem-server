package U0;

import com.google.firebase.installations.i;
import java.util.concurrent.TimeUnit;

class e {

    /* renamed from: d  reason: collision with root package name */
    private static final long f4407d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e  reason: collision with root package name */
    private static final long f4408e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a  reason: collision with root package name */
    private final i f4409a = i.c();

    /* renamed from: b  reason: collision with root package name */
    private long f4410b;

    /* renamed from: c  reason: collision with root package name */
    private int f4411c;

    e() {
    }

    private synchronized long a(int i5) {
        if (!c(i5)) {
            return f4407d;
        }
        return (long) Math.min(Math.pow(2.0d, (double) this.f4411c) + ((double) this.f4409a.e()), (double) f4408e);
    }

    private static boolean c(int i5) {
        if (i5 == 429) {
            return true;
        }
        if (i5 < 500 || i5 >= 600) {
            return false;
        }
        return true;
    }

    private static boolean d(int i5) {
        if ((i5 >= 200 && i5 < 300) || i5 == 401 || i5 == 404) {
            return true;
        }
        return false;
    }

    private synchronized void e() {
        this.f4411c = 0;
    }

    public synchronized boolean b() {
        boolean z4;
        if (this.f4411c == 0 || this.f4409a.a() > this.f4410b) {
            z4 = true;
        } else {
            z4 = false;
        }
        return z4;
    }

    public synchronized void f(int i5) {
        if (d(i5)) {
            e();
            return;
        }
        this.f4411c++;
        this.f4410b = this.f4409a.a() + a(i5);
    }
}
