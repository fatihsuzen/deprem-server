package M;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import b0.C1007f;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Map;

final class f0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map f2919a = DesugarCollections.synchronizedMap(new ArrayMap());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f2920b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Bundle f2921c;

    f0() {
    }

    /* access modifiers changed from: package-private */
    public final C0687g c(String str, Class cls) {
        return (C0687g) cls.cast(this.f2919a.get(str));
    }

    /* access modifiers changed from: package-private */
    public final void d(String str, C0687g gVar) {
        if (!this.f2919a.containsKey(str)) {
            this.f2919a.put(str, gVar);
            if (this.f2920b > 0) {
                new C1007f(Looper.getMainLooper()).post(new e0(this, gVar, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    /* access modifiers changed from: package-private */
    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (C0687g a5 : this.f2919a.values()) {
            a5.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(int i5, int i6, Intent intent) {
        for (C0687g e5 : this.f2919a.values()) {
            e5.e(i5, i6, intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(Bundle bundle) {
        Bundle bundle2;
        this.f2920b = 1;
        this.f2921c = bundle;
        for (Map.Entry entry : this.f2919a.entrySet()) {
            C0687g gVar = (C0687g) entry.getValue();
            if (bundle != null) {
                bundle2 = bundle.getBundle((String) entry.getKey());
            } else {
                bundle2 = null;
            }
            gVar.f(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        this.f2920b = 5;
        for (C0687g g5 : this.f2919a.values()) {
            g5.g();
        }
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        this.f2920b = 3;
        for (C0687g h5 : this.f2919a.values()) {
            h5.h();
        }
    }

    /* access modifiers changed from: package-private */
    public final void j(Bundle bundle) {
        if (bundle != null) {
            for (Map.Entry entry : this.f2919a.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((C0687g) entry.getValue()).i(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void k() {
        this.f2920b = 2;
        for (C0687g j5 : this.f2919a.values()) {
            j5.j();
        }
    }

    /* access modifiers changed from: package-private */
    public final void l() {
        this.f2920b = 4;
        for (C0687g k5 : this.f2919a.values()) {
            k5.k();
        }
    }
}
