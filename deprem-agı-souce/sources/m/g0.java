package M;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class g0 extends Fragment implements C0688h {

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap f2923b = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final f0 f2924a = new f0();

    public static g0 f(FragmentActivity fragmentActivity) {
        g0 g0Var;
        WeakHashMap weakHashMap = f2923b;
        WeakReference weakReference = (WeakReference) weakHashMap.get(fragmentActivity);
        if (weakReference != null && (g0Var = (g0) weakReference.get()) != null) {
            return g0Var;
        }
        try {
            g0 g0Var2 = (g0) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SLifecycleFragmentImpl");
            if (g0Var2 == null || g0Var2.isRemoving()) {
                g0Var2 = new g0();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) g0Var2, "SLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(fragmentActivity, new WeakReference(g0Var2));
            return g0Var2;
        } catch (ClassCastException e5) {
            throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e5);
        }
    }

    public final void a(String str, C0687g gVar) {
        this.f2924a.d(str, gVar);
    }

    public final C0687g b(String str, Class cls) {
        return this.f2924a.c(str, cls);
    }

    public final Activity c() {
        return getActivity();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f2924a.e(str, fileDescriptor, printWriter, strArr);
    }

    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        this.f2924a.f(i5, i6, intent);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2924a.g(bundle);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f2924a.h();
    }

    public final void onResume() {
        super.onResume();
        this.f2924a.i();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f2924a.j(bundle);
    }

    public final void onStart() {
        super.onStart();
        this.f2924a.k();
    }

    public final void onStop() {
        super.onStop();
        this.f2924a.l();
    }
}
