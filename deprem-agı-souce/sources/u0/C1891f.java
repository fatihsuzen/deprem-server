package u0;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.InputStream;
import x0.C1914j;

/* renamed from: u0.f  reason: case insensitive filesystem */
public class C1891f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f16655a;

    /* renamed from: b  reason: collision with root package name */
    private b f16656b = null;

    /* renamed from: u0.f$b */
    private class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f16657a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f16658b;

        private b() {
            int p5 = C1914j.p(C1891f.this.f16655a, "com.google.firebase.crashlytics.unity_version", TypedValues.Custom.S_STRING);
            if (p5 != 0) {
                this.f16657a = "Unity";
                String string = C1891f.this.f16655a.getResources().getString(p5);
                this.f16658b = string;
                g f5 = g.f();
                f5.i("Unity Editor version is: " + string);
            } else if (C1891f.this.c("flutter_assets/NOTICES.Z")) {
                this.f16657a = "Flutter";
                this.f16658b = null;
                g.f().i("Development platform is: Flutter");
            } else {
                this.f16657a = null;
                this.f16658b = null;
            }
        }
    }

    public C1891f(Context context) {
        this.f16655a = context;
    }

    /* access modifiers changed from: private */
    public boolean c(String str) {
        if (this.f16655a.getAssets() == null) {
            return false;
        }
        try {
            InputStream open = this.f16655a.getAssets().open(str);
            if (open != null) {
                open.close();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private b f() {
        if (this.f16656b == null) {
            this.f16656b = new b();
        }
        return this.f16656b;
    }

    public String d() {
        return f().f16657a;
    }

    public String e() {
        return f().f16658b;
    }
}
