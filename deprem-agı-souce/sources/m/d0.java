package M;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class d0 extends Fragment implements C0688h {

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap f2894b = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final f0 f2895a = new f0();

    public static d0 d(Activity activity) {
        d0 d0Var;
        WeakHashMap weakHashMap = f2894b;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (d0Var = (d0) weakReference.get()) != null) {
            return d0Var;
        }
        try {
            d0 d0Var2 = (d0) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (d0Var2 == null || d0Var2.isRemoving()) {
                d0Var2 = new d0();
                activity.getFragmentManager().beginTransaction().add(d0Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(d0Var2));
            return d0Var2;
        } catch (ClassCastException e5) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e5);
        }
    }

    public final void a(String str, C0687g gVar) {
        this.f2895a.d(str, gVar);
    }

    public final C0687g b(String str, Class cls) {
        return this.f2895a.c(str, cls);
    }

    public final Activity c() {
        return getActivity();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f2895a.e(str, fileDescriptor, printWriter, strArr);
    }

    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        this.f2895a.f(i5, i6, intent);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2895a.g(bundle);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f2895a.h();
    }

    public final void onResume() {
        super.onResume();
        this.f2895a.i();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f2895a.j(bundle);
    }

    public final void onStart() {
        super.onStart();
        this.f2895a.k();
    }

    public final void onStop() {
        super.onStop();
        this.f2895a.l();
    }
}
