package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {
    private final SimpleArrayMap<Class<? extends ExtraData>, ExtraData> extraDataMap = new SimpleArrayMap<>();
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ExtraData {
    }

    private static /* synthetic */ void getExtraDataMap$annotations() {
    }

    private static /* synthetic */ void getLifecycleRegistry$annotations() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r4.equals("--list-dumpables") == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (r4.equals("--dump-dumpable") == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        if (android.os.Build.VERSION.SDK_INT < 33) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean shouldSkipDump(java.lang.String[] r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x005e
            int r1 = r4.length
            if (r1 != 0) goto L_0x0007
            goto L_0x005e
        L_0x0007:
            r4 = r4[r0]
            int r1 = r4.hashCode()
            r2 = 1
            switch(r1) {
                case -645125871: goto L_0x004e;
                case 100470631: goto L_0x003d;
                case 472614934: goto L_0x0034;
                case 1159329357: goto L_0x0023;
                case 1455016274: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x005e
        L_0x0012:
            java.lang.String r1 = "--autofill"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x001b
            goto L_0x005e
        L_0x001b:
            int r4 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r4 < r1) goto L_0x0022
            return r2
        L_0x0022:
            return r0
        L_0x0023:
            java.lang.String r1 = "--contentcapture"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x002c
            goto L_0x005e
        L_0x002c:
            int r4 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r4 < r1) goto L_0x0033
            return r2
        L_0x0033:
            return r0
        L_0x0034:
            java.lang.String r1 = "--list-dumpables"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0046
            goto L_0x005e
        L_0x003d:
            java.lang.String r1 = "--dump-dumpable"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0046
            goto L_0x005e
        L_0x0046:
            int r4 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            if (r4 < r1) goto L_0x004d
            return r2
        L_0x004d:
            return r0
        L_0x004e:
            java.lang.String r1 = "--translation"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0057
            goto L_0x005e
        L_0x0057:
            int r4 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r4 < r1) goto L_0x005e
            return r2
        L_0x005e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.ComponentActivity.shouldSkipDump(java.lang.String[]):boolean");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        t.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        View decorView = getWindow().getDecorView();
        t.d(decorView, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        return KeyEventDispatcher.dispatchKeyEvent(this, decorView, this, keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        t.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        View decorView = getWindow().getDecorView();
        t.d(decorView, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T extends ExtraData> T getExtraData(Class<T> cls) {
        t.e(cls, "extraDataClass");
        return (ExtraData) this.extraDataMap.get(cls);
    }

    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.Companion.injectIfNeededIn(this);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onSaveInstanceState(Bundle bundle) {
        t.e(bundle, "outState");
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void putExtraData(ExtraData extraData) {
        t.e(extraData, "extraData");
        this.extraDataMap.put(extraData.getClass(), extraData);
    }

    /* access modifiers changed from: protected */
    public final boolean shouldDumpInternalState(String[] strArr) {
        return !shouldSkipDump(strArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        t.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        return super.dispatchKeyEvent(keyEvent);
    }
}
