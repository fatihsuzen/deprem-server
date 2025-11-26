package androidx.window.layout;

import W2.J;
import X2.C2250q;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import com.mbridge.msdk.MBridgeConstans;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class SidecarCompat implements ExtensionInterfaceCompat {
    public static final Companion Companion = new Companion((C2633k) null);
    private static final String TAG = "SidecarCompat";
    private final Map<Activity, ComponentCallbacks> componentCallbackMap;
    /* access modifiers changed from: private */
    public ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback;
    private final SidecarInterface sidecar;
    /* access modifiers changed from: private */
    public final SidecarAdapter sidecarAdapter;
    /* access modifiers changed from: private */
    public final Map<IBinder, Activity> windowListenerRegisteredContexts;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final IBinder getActivityWindowToken$window_release(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final SidecarInterface getSidecarCompat$window_release(Context context) {
            t.e(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final Version getSidecarVersion() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (!TextUtils.isEmpty(apiVersion)) {
                    return Version.Companion.parse(apiVersion);
                }
                return null;
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    private static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        @GuardedBy("mLock")
        private final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo = new WeakHashMap<>();
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface;
        private final ReentrantLock lock = new ReentrantLock();

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
            t.e(extensionCallbackInterface, "callbackInterface");
            this.callbackInterface = extensionCallbackInterface;
        }

        public void onWindowLayoutChanged(Activity activity, WindowLayoutInfo windowLayoutInfo) {
            t.e(activity, "activity");
            t.e(windowLayoutInfo, "newLayout");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!t.a(windowLayoutInfo, this.activityWindowLayoutInfo.get(activity))) {
                    WindowLayoutInfo put = this.activityWindowLayoutInfo.put(activity, windowLayoutInfo);
                    reentrantLock.unlock();
                    this.callbackInterface.onWindowLayoutChanged(activity, windowLayoutInfo);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {
        private final SidecarInterface.SidecarCallback callbackInterface;
        @GuardedBy("lock")
        private SidecarDeviceState lastDeviceState;
        private final ReentrantLock lock = new ReentrantLock();
        @GuardedBy("mLock")
        private final WeakHashMap<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo = new WeakHashMap<>();
        private final SidecarAdapter sidecarAdapter;

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter2, SidecarInterface.SidecarCallback sidecarCallback) {
            t.e(sidecarAdapter2, "sidecarAdapter");
            t.e(sidecarCallback, "callbackInterface");
            this.sidecarAdapter = sidecarAdapter2;
            this.callbackInterface = sidecarCallback;
        }

        public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
            t.e(sidecarDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.sidecarAdapter.isEqualSidecarDeviceState(this.lastDeviceState, sidecarDeviceState)) {
                    this.lastDeviceState = sidecarDeviceState;
                    this.callbackInterface.onDeviceStateChanged(sidecarDeviceState);
                    J j5 = J.f19942a;
                    reentrantLock.unlock();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            t.e(iBinder, "token");
            t.e(sidecarWindowLayoutInfo, "newLayout");
            synchronized (this.lock) {
                if (!this.sidecarAdapter.isEqualSidecarWindowLayoutInfo(this.mActivityWindowLayoutInfo.get(iBinder), sidecarWindowLayoutInfo)) {
                    SidecarWindowLayoutInfo put = this.mActivityWindowLayoutInfo.put(iBinder, sidecarWindowLayoutInfo);
                    this.callbackInterface.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
                }
            }
        }
    }

    private static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {
        private final WeakReference<Activity> activityWeakReference;
        private final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(SidecarCompat sidecarCompat2, Activity activity) {
            t.e(sidecarCompat2, "sidecarCompat");
            t.e(activity, "activity");
            this.sidecarCompat = sidecarCompat2;
            this.activityWeakReference = new WeakReference<>(activity);
        }

        public void onViewAttachedToWindow(View view) {
            t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.activityWeakReference.get();
            IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
            if (activity != null && activityWindowToken$window_release != null) {
                this.sidecarCompat.register(activityWindowToken$window_release, activity);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        }
    }

    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat this$0;

        public TranslatingCallback(SidecarCompat sidecarCompat) {
            t.e(sidecarCompat, "this$0");
            this.this$0 = sidecarCompat;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
            SidecarInterface sidecar;
            t.e(sidecarDeviceState, "newDeviceState");
            SidecarCompat sidecarCompat = this.this$0;
            for (Activity activity : this.this$0.windowListenerRegisteredContexts.values()) {
                IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (!(activityWindowToken$window_release == null || (sidecar = sidecarCompat.getSidecar()) == null)) {
                    sidecarWindowLayoutInfo = sidecar.getWindowLayoutInfo(activityWindowToken$window_release);
                }
                ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p = sidecarCompat.extensionCallback;
                if (access$getExtensionCallback$p != null) {
                    access$getExtensionCallback$p.onWindowLayoutChanged(activity, sidecarCompat.sidecarAdapter.translate(sidecarWindowLayoutInfo, sidecarDeviceState));
                }
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            SidecarDeviceState sidecarDeviceState;
            t.e(iBinder, "windowToken");
            t.e(sidecarWindowLayoutInfo, "newLayout");
            Activity activity = (Activity) this.this$0.windowListenerRegisteredContexts.get(iBinder);
            if (activity == null) {
                Log.w(SidecarCompat.TAG, "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter access$getSidecarAdapter$p = this.this$0.sidecarAdapter;
            SidecarInterface sidecar = this.this$0.getSidecar();
            if (sidecar == null) {
                sidecarDeviceState = null;
            } else {
                sidecarDeviceState = sidecar.getDeviceState();
            }
            if (sidecarDeviceState == null) {
                sidecarDeviceState = new SidecarDeviceState();
            }
            WindowLayoutInfo translate = access$getSidecarAdapter$p.translate(sidecarWindowLayoutInfo, sidecarDeviceState);
            ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p = this.this$0.extensionCallback;
            if (access$getExtensionCallback$p != null) {
                access$getExtensionCallback$p.onWindowLayoutChanged(activity, translate);
            }
        }
    }

    @VisibleForTesting
    public SidecarCompat(@VisibleForTesting SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter2) {
        t.e(sidecarAdapter2, "sidecarAdapter");
        this.sidecar = sidecarInterface;
        this.sidecarAdapter = sidecarAdapter2;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    private final void registerConfigurationChangeListener(Activity activity) {
        if (this.componentCallbackMap.get(activity) == null) {
            SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1 = new SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1(this, activity);
            this.componentCallbackMap.put(activity, sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1);
            activity.registerComponentCallbacks(sidecarCompat$registerConfigurationChangeListener$configChangeObserver$1);
        }
    }

    private final void unregisterComponentCallback(Activity activity) {
        activity.unregisterComponentCallbacks(this.componentCallbackMap.get(activity));
        this.componentCallbackMap.remove(activity);
    }

    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    @VisibleForTesting
    public final WindowLayoutInfo getWindowLayoutInfo(Activity activity) {
        SidecarWindowLayoutInfo sidecarWindowLayoutInfo;
        t.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return new WindowLayoutInfo(C2250q.g());
        }
        SidecarInterface sidecarInterface = this.sidecar;
        SidecarDeviceState sidecarDeviceState = null;
        if (sidecarInterface == null) {
            sidecarWindowLayoutInfo = null;
        } else {
            sidecarWindowLayoutInfo = sidecarInterface.getWindowLayoutInfo(activityWindowToken$window_release);
        }
        SidecarAdapter sidecarAdapter2 = this.sidecarAdapter;
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarDeviceState = sidecarInterface2.getDeviceState();
        }
        if (sidecarDeviceState == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return sidecarAdapter2.translate(sidecarWindowLayoutInfo, sidecarDeviceState);
    }

    public void onWindowLayoutChangeListenerAdded(Activity activity) {
        t.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            register(activityWindowToken$window_release, activity);
            return;
        }
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
    }

    public void onWindowLayoutChangeListenerRemoved(Activity activity) {
        boolean z4;
        SidecarInterface sidecarInterface;
        t.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            SidecarInterface sidecarInterface2 = this.sidecar;
            if (sidecarInterface2 != null) {
                sidecarInterface2.onWindowLayoutChangeListenerRemoved(activityWindowToken$window_release);
            }
            unregisterComponentCallback(activity);
            if (this.windowListenerRegisteredContexts.size() == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.windowListenerRegisteredContexts.remove(activityWindowToken$window_release);
            if (z4 && (sidecarInterface = this.sidecar) != null) {
                sidecarInterface.onDeviceStateListenersChanged(true);
            }
        }
    }

    public final void register(IBinder iBinder, Activity activity) {
        SidecarInterface sidecarInterface;
        t.e(iBinder, "windowToken");
        t.e(activity, "activity");
        this.windowListenerRegisteredContexts.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (this.windowListenerRegisteredContexts.size() == 1 && (sidecarInterface = this.sidecar) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.extensionCallback;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.onWindowLayoutChanged(activity, getWindowLayoutInfo(activity));
        }
        registerConfigurationChangeListener(activity);
    }

    public void setExtensionCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
        t.e(extensionCallbackInterface, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(extensionCallbackInterface);
        SidecarInterface sidecarInterface = this.sidecar;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.sidecarAdapter, new TranslatingCallback(this)));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:60|61|62|63|71|72|73|74|75|(4:77|(2:80|81)|79|98)(2:82|83)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x0106 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0057 A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0059 A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0065 A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007e A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080 A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008a A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a3 A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5 A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00af A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0131 A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0143 A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x015b A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0167 A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0173 A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x017f A[Catch:{ NoSuchFieldError -> 0x00b8, all -> 0x018b }] */
    @android.annotation.SuppressLint({"BanUncheckedReflection"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean validateExtensionInterface() {
        /*
            r9 = this;
            r0 = 0
            androidx.window.sidecar.SidecarInterface r1 = r9.sidecar     // Catch:{ all -> 0x018b }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0009
        L_0x0007:
            r1 = r3
            goto L_0x001c
        L_0x0009:
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x018b }
            if (r1 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            java.lang.String r4 = "setSidecarCallback"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ all -> 0x018b }
            java.lang.Class<androidx.window.sidecar.SidecarInterface$SidecarCallback> r6 = androidx.window.sidecar.SidecarInterface.SidecarCallback.class
            r5[r0] = r6     // Catch:{ all -> 0x018b }
            java.lang.reflect.Method r1 = r1.getMethod(r4, r5)     // Catch:{ all -> 0x018b }
        L_0x001c:
            if (r1 != 0) goto L_0x0020
            r1 = r3
            goto L_0x0024
        L_0x0020:
            java.lang.Class r1 = r1.getReturnType()     // Catch:{ all -> 0x018b }
        L_0x0024:
            java.lang.Class r4 = java.lang.Void.TYPE     // Catch:{ all -> 0x018b }
            boolean r5 = kotlin.jvm.internal.t.a(r1, r4)     // Catch:{ all -> 0x018b }
            if (r5 == 0) goto L_0x017f
            androidx.window.sidecar.SidecarInterface r1 = r9.sidecar     // Catch:{ all -> 0x018b }
            if (r1 != 0) goto L_0x0031
            goto L_0x0034
        L_0x0031:
            r1.getDeviceState()     // Catch:{ all -> 0x018b }
        L_0x0034:
            androidx.window.sidecar.SidecarInterface r1 = r9.sidecar     // Catch:{ all -> 0x018b }
            if (r1 != 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            r1.onDeviceStateListenersChanged(r2)     // Catch:{ all -> 0x018b }
        L_0x003c:
            androidx.window.sidecar.SidecarInterface r1 = r9.sidecar     // Catch:{ all -> 0x018b }
            java.lang.Class<android.os.IBinder> r5 = android.os.IBinder.class
            if (r1 != 0) goto L_0x0044
        L_0x0042:
            r1 = r3
            goto L_0x0055
        L_0x0044:
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x018b }
            if (r1 != 0) goto L_0x004b
            goto L_0x0042
        L_0x004b:
            java.lang.String r6 = "getWindowLayoutInfo"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ all -> 0x018b }
            r7[r0] = r5     // Catch:{ all -> 0x018b }
            java.lang.reflect.Method r1 = r1.getMethod(r6, r7)     // Catch:{ all -> 0x018b }
        L_0x0055:
            if (r1 != 0) goto L_0x0059
            r1 = r3
            goto L_0x005d
        L_0x0059:
            java.lang.Class r1 = r1.getReturnType()     // Catch:{ all -> 0x018b }
        L_0x005d:
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r6 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            boolean r6 = kotlin.jvm.internal.t.a(r1, r6)     // Catch:{ all -> 0x018b }
            if (r6 == 0) goto L_0x0173
            androidx.window.sidecar.SidecarInterface r1 = r9.sidecar     // Catch:{ all -> 0x018b }
            if (r1 != 0) goto L_0x006b
        L_0x0069:
            r1 = r3
            goto L_0x007c
        L_0x006b:
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x018b }
            if (r1 != 0) goto L_0x0072
            goto L_0x0069
        L_0x0072:
            java.lang.String r6 = "onWindowLayoutChangeListenerAdded"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ all -> 0x018b }
            r7[r0] = r5     // Catch:{ all -> 0x018b }
            java.lang.reflect.Method r1 = r1.getMethod(r6, r7)     // Catch:{ all -> 0x018b }
        L_0x007c:
            if (r1 != 0) goto L_0x0080
            r1 = r3
            goto L_0x0084
        L_0x0080:
            java.lang.Class r1 = r1.getReturnType()     // Catch:{ all -> 0x018b }
        L_0x0084:
            boolean r6 = kotlin.jvm.internal.t.a(r1, r4)     // Catch:{ all -> 0x018b }
            if (r6 == 0) goto L_0x0167
            androidx.window.sidecar.SidecarInterface r1 = r9.sidecar     // Catch:{ all -> 0x018b }
            if (r1 != 0) goto L_0x0090
        L_0x008e:
            r1 = r3
            goto L_0x00a1
        L_0x0090:
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x018b }
            if (r1 != 0) goto L_0x0097
            goto L_0x008e
        L_0x0097:
            java.lang.String r6 = "onWindowLayoutChangeListenerRemoved"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ all -> 0x018b }
            r7[r0] = r5     // Catch:{ all -> 0x018b }
            java.lang.reflect.Method r1 = r1.getMethod(r6, r7)     // Catch:{ all -> 0x018b }
        L_0x00a1:
            if (r1 != 0) goto L_0x00a5
            r1 = r3
            goto L_0x00a9
        L_0x00a5:
            java.lang.Class r1 = r1.getReturnType()     // Catch:{ all -> 0x018b }
        L_0x00a9:
            boolean r4 = kotlin.jvm.internal.t.a(r1, r4)     // Catch:{ all -> 0x018b }
            if (r4 == 0) goto L_0x015b
            androidx.window.sidecar.SidecarDeviceState r1 = new androidx.window.sidecar.SidecarDeviceState     // Catch:{ all -> 0x018b }
            r1.<init>()     // Catch:{ all -> 0x018b }
            r4 = 3
            r1.posture = r4     // Catch:{ NoSuchFieldError -> 0x00b8 }
            goto L_0x00e7
        L_0x00b8:
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r5 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r6 = "setPosture"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ all -> 0x018b }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ all -> 0x018b }
            r7[r0] = r8     // Catch:{ all -> 0x018b }
            java.lang.reflect.Method r5 = r5.getMethod(r6, r7)     // Catch:{ all -> 0x018b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x018b }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x018b }
            r7[r0] = r6     // Catch:{ all -> 0x018b }
            r5.invoke(r1, r7)     // Catch:{ all -> 0x018b }
            java.lang.Class<androidx.window.sidecar.SidecarDeviceState> r5 = androidx.window.sidecar.SidecarDeviceState.class
            java.lang.String r6 = "getPosture"
            java.lang.reflect.Method r5 = r5.getMethod(r6, r3)     // Catch:{ all -> 0x018b }
            java.lang.Object r1 = r5.invoke(r1, r3)     // Catch:{ all -> 0x018b }
            if (r1 == 0) goto L_0x0153
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x018b }
            int r1 = r1.intValue()     // Catch:{ all -> 0x018b }
            if (r1 != r4) goto L_0x014b
        L_0x00e7:
            androidx.window.sidecar.SidecarDisplayFeature r1 = new androidx.window.sidecar.SidecarDisplayFeature     // Catch:{ all -> 0x018b }
            r1.<init>()     // Catch:{ all -> 0x018b }
            android.graphics.Rect r4 = r1.getRect()     // Catch:{ all -> 0x018b }
            java.lang.String r5 = "displayFeature.rect"
            kotlin.jvm.internal.t.d(r4, r5)     // Catch:{ all -> 0x018b }
            r1.setRect(r4)     // Catch:{ all -> 0x018b }
            r1.getType()     // Catch:{ all -> 0x018b }
            r1.setType(r2)     // Catch:{ all -> 0x018b }
            androidx.window.sidecar.SidecarWindowLayoutInfo r4 = new androidx.window.sidecar.SidecarWindowLayoutInfo     // Catch:{ all -> 0x018b }
            r4.<init>()     // Catch:{ all -> 0x018b }
            java.util.List r0 = r4.displayFeatures     // Catch:{ NoSuchFieldError -> 0x0106 }
            goto L_0x0139
        L_0x0106:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x018b }
            r5.<init>()     // Catch:{ all -> 0x018b }
            r5.add(r1)     // Catch:{ all -> 0x018b }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r1 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r6 = "setDisplayFeatures"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ all -> 0x018b }
            java.lang.Class<java.util.List> r8 = java.util.List.class
            r7[r0] = r8     // Catch:{ all -> 0x018b }
            java.lang.reflect.Method r1 = r1.getMethod(r6, r7)     // Catch:{ all -> 0x018b }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x018b }
            r6[r0] = r5     // Catch:{ all -> 0x018b }
            r1.invoke(r4, r6)     // Catch:{ all -> 0x018b }
            java.lang.Class<androidx.window.sidecar.SidecarWindowLayoutInfo> r1 = androidx.window.sidecar.SidecarWindowLayoutInfo.class
            java.lang.String r6 = "getDisplayFeatures"
            java.lang.reflect.Method r1 = r1.getMethod(r6, r3)     // Catch:{ all -> 0x018b }
            java.lang.Object r1 = r1.invoke(r4, r3)     // Catch:{ all -> 0x018b }
            if (r1 == 0) goto L_0x0143
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x018b }
            boolean r1 = kotlin.jvm.internal.t.a(r5, r1)     // Catch:{ all -> 0x018b }
            if (r1 == 0) goto L_0x013b
        L_0x0139:
            r0 = r2
            goto L_0x018b
        L_0x013b:
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x018b }
            java.lang.String r2 = "Invalid display feature getter/setter"
            r1.<init>(r2)     // Catch:{ all -> 0x018b }
            throw r1     // Catch:{ all -> 0x018b }
        L_0x0143:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ all -> 0x018b }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>"
            r1.<init>(r2)     // Catch:{ all -> 0x018b }
            throw r1     // Catch:{ all -> 0x018b }
        L_0x014b:
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x018b }
            java.lang.String r2 = "Invalid device posture getter/setter"
            r1.<init>(r2)     // Catch:{ all -> 0x018b }
            throw r1     // Catch:{ all -> 0x018b }
        L_0x0153:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ all -> 0x018b }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Int"
            r1.<init>(r2)     // Catch:{ all -> 0x018b }
            throw r1     // Catch:{ all -> 0x018b }
        L_0x015b:
            java.lang.NoSuchMethodException r2 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x018b }
            java.lang.String r3 = "Illegal return type for 'onWindowLayoutChangeListenerRemoved': "
            java.lang.String r1 = kotlin.jvm.internal.t.n(r3, r1)     // Catch:{ all -> 0x018b }
            r2.<init>(r1)     // Catch:{ all -> 0x018b }
            throw r2     // Catch:{ all -> 0x018b }
        L_0x0167:
            java.lang.NoSuchMethodException r2 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x018b }
            java.lang.String r3 = "Illegal return type for 'onWindowLayoutChangeListenerAdded': "
            java.lang.String r1 = kotlin.jvm.internal.t.n(r3, r1)     // Catch:{ all -> 0x018b }
            r2.<init>(r1)     // Catch:{ all -> 0x018b }
            throw r2     // Catch:{ all -> 0x018b }
        L_0x0173:
            java.lang.NoSuchMethodException r2 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x018b }
            java.lang.String r3 = "Illegal return type for 'getWindowLayoutInfo': "
            java.lang.String r1 = kotlin.jvm.internal.t.n(r3, r1)     // Catch:{ all -> 0x018b }
            r2.<init>(r1)     // Catch:{ all -> 0x018b }
            throw r2     // Catch:{ all -> 0x018b }
        L_0x017f:
            java.lang.NoSuchMethodException r2 = new java.lang.NoSuchMethodException     // Catch:{ all -> 0x018b }
            java.lang.String r3 = "Illegal return type for 'setSidecarCallback': "
            java.lang.String r1 = kotlin.jvm.internal.t.n(r3, r1)     // Catch:{ all -> 0x018b }
            r2.<init>(r1)     // Catch:{ all -> 0x018b }
            throw r2     // Catch:{ all -> 0x018b }
        L_0x018b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.validateExtensionInterface():boolean");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(Companion.getSidecarCompat$window_release(context), new SidecarAdapter((SpecificationComputer.VerificationMode) null, 1, (C2633k) null));
        t.e(context, "context");
    }
}
