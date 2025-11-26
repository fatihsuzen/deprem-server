package z2;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import kotlin.jvm.internal.C2633k;

public abstract class T {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26520a = new a((C2633k) null);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final void c() {
            Process.killProcess(Process.myPid());
        }

        public final void b() {
            new Handler(Looper.getMainLooper()).postDelayed(new S(), 1000);
        }

        private a() {
        }
    }
}
