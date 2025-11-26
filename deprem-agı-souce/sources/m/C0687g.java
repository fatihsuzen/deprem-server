package M;

import N.C0722p;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: M.g  reason: case insensitive filesystem */
public abstract class C0687g {

    /* renamed from: a  reason: collision with root package name */
    protected final C0688h f2922a;

    protected C0687g(C0688h hVar) {
        this.f2922a = hVar;
    }

    protected static C0688h c(C0686f fVar) {
        if (fVar.d()) {
            return g0.f(fVar.b());
        }
        if (fVar.c()) {
            return d0.d(fVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public static C0688h d(Activity activity) {
        return c(new C0686f(activity));
    }

    public Activity b() {
        Activity c5 = this.f2922a.c();
        C0722p.k(c5);
        return c5;
    }

    public abstract void e(int i5, int i6, Intent intent);

    public void g() {
    }

    public void h() {
    }

    public void j() {
    }

    public void k() {
    }

    public void f(Bundle bundle) {
    }

    public void i(Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
