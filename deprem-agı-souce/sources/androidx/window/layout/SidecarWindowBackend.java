package androidx.window.layout;

import W2.J;
import X2.C2250q;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import b.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class SidecarWindowBackend implements WindowBackend {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final boolean DEBUG = false;
    private static final String TAG = "WindowServer";
    /* access modifiers changed from: private */
    public static volatile SidecarWindowBackend globalInstance;
    /* access modifiers changed from: private */
    public static final ReentrantLock globalLock = new ReentrantLock();
    @VisibleForTesting
    @GuardedBy("globalLock")
    private ExtensionInterfaceCompat windowExtension;
    private final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> windowLayoutChangeCallbacks = new CopyOnWriteArrayList<>();

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final SidecarWindowBackend getInstance(Context context) {
            t.e(context, "context");
            if (SidecarWindowBackend.globalInstance == null) {
                ReentrantLock access$getGlobalLock$cp = SidecarWindowBackend.globalLock;
                access$getGlobalLock$cp.lock();
                try {
                    if (SidecarWindowBackend.globalInstance == null) {
                        SidecarWindowBackend.globalInstance = new SidecarWindowBackend(SidecarWindowBackend.Companion.initAndVerifyExtension(context));
                    }
                    J j5 = J.f19942a;
                    access$getGlobalLock$cp.unlock();
                } catch (Throwable th) {
                    access$getGlobalLock$cp.unlock();
                    throw th;
                }
            }
            SidecarWindowBackend access$getGlobalInstance$cp = SidecarWindowBackend.globalInstance;
            t.b(access$getGlobalInstance$cp);
            return access$getGlobalInstance$cp;
        }

        public final ExtensionInterfaceCompat initAndVerifyExtension(Context context) {
            t.e(context, "context");
            try {
                if (isSidecarVersionSupported(SidecarCompat.Companion.getSidecarVersion())) {
                    SidecarCompat sidecarCompat = new SidecarCompat(context);
                    if (!sidecarCompat.validateExtensionInterface()) {
                        return null;
                    }
                    return sidecarCompat;
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        @VisibleForTesting
        public final boolean isSidecarVersionSupported(Version version) {
            if (version != null && version.compareTo(Version.Companion.getVERSION_0_1()) >= 0) {
                return true;
            }
            return false;
        }

        @VisibleForTesting
        public final void resetInstance() {
            SidecarWindowBackend.globalInstance = null;
        }

        private Companion() {
        }
    }

    @VisibleForTesting
    public final class ExtensionListenerImpl implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        final /* synthetic */ SidecarWindowBackend this$0;

        public ExtensionListenerImpl(SidecarWindowBackend sidecarWindowBackend) {
            t.e(sidecarWindowBackend, "this$0");
            this.this$0 = sidecarWindowBackend;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(Activity activity, WindowLayoutInfo windowLayoutInfo) {
            t.e(activity, "activity");
            t.e(windowLayoutInfo, "newLayout");
            Iterator<WindowLayoutChangeCallbackWrapper> it = this.this$0.getWindowLayoutChangeCallbacks().iterator();
            while (it.hasNext()) {
                WindowLayoutChangeCallbackWrapper next = it.next();
                if (t.a(next.getActivity(), activity)) {
                    next.accept(windowLayoutInfo);
                }
            }
        }
    }

    public static final class WindowLayoutChangeCallbackWrapper {
        private final Activity activity;
        private final Consumer<WindowLayoutInfo> callback;
        private final Executor executor;
        private WindowLayoutInfo lastInfo;

        public WindowLayoutChangeCallbackWrapper(Activity activity2, Executor executor2, Consumer<WindowLayoutInfo> consumer) {
            t.e(activity2, "activity");
            t.e(executor2, "executor");
            t.e(consumer, "callback");
            this.activity = activity2;
            this.executor = executor2;
            this.callback = consumer;
        }

        /* access modifiers changed from: private */
        /* renamed from: accept$lambda-0  reason: not valid java name */
        public static final void m204accept$lambda0(WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
            t.e(windowLayoutChangeCallbackWrapper, "this$0");
            t.e(windowLayoutInfo, "$newLayoutInfo");
            windowLayoutChangeCallbackWrapper.callback.accept(windowLayoutInfo);
        }

        public final void accept(WindowLayoutInfo windowLayoutInfo) {
            t.e(windowLayoutInfo, "newLayoutInfo");
            this.lastInfo = windowLayoutInfo;
            this.executor.execute(new i(this, windowLayoutInfo));
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Consumer<WindowLayoutInfo> getCallback() {
            return this.callback;
        }

        public final WindowLayoutInfo getLastInfo() {
            return this.lastInfo;
        }

        public final void setLastInfo(WindowLayoutInfo windowLayoutInfo) {
            this.lastInfo = windowLayoutInfo;
        }
    }

    @VisibleForTesting
    public SidecarWindowBackend(ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.windowExtension = extensionInterfaceCompat;
        ExtensionInterfaceCompat extensionInterfaceCompat2 = this.windowExtension;
        if (extensionInterfaceCompat2 != null) {
            extensionInterfaceCompat2.setExtensionCallback(new ExtensionListenerImpl(this));
        }
    }

    @GuardedBy("sLock")
    private final void callbackRemovedForActivity(Activity activity) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.windowLayoutChangeCallbacks;
        if (!w.a(copyOnWriteArrayList) || !copyOnWriteArrayList.isEmpty()) {
            for (WindowLayoutChangeCallbackWrapper activity2 : copyOnWriteArrayList) {
                if (t.a(activity2.getActivity(), activity)) {
                    return;
                }
            }
        }
        ExtensionInterfaceCompat extensionInterfaceCompat = this.windowExtension;
        if (extensionInterfaceCompat != null) {
            extensionInterfaceCompat.onWindowLayoutChangeListenerRemoved(activity);
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getWindowLayoutChangeCallbacks$annotations() {
    }

    private final boolean isActivityRegistered(Activity activity) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.windowLayoutChangeCallbacks;
        if (w.a(copyOnWriteArrayList) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (WindowLayoutChangeCallbackWrapper activity2 : copyOnWriteArrayList) {
            if (t.a(activity2.getActivity(), activity)) {
                return true;
            }
        }
        return false;
    }

    public final ExtensionInterfaceCompat getWindowExtension() {
        return this.windowExtension;
    }

    public final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> getWindowLayoutChangeCallbacks() {
        return this.windowLayoutChangeCallbacks;
    }

    public void registerLayoutChangeCallback(Activity activity, Executor executor, Consumer<WindowLayoutInfo> consumer) {
        WindowLayoutInfo windowLayoutInfo;
        T t5;
        t.e(activity, "activity");
        t.e(executor, "executor");
        t.e(consumer, "callback");
        ReentrantLock reentrantLock = globalLock;
        reentrantLock.lock();
        try {
            ExtensionInterfaceCompat windowExtension2 = getWindowExtension();
            if (windowExtension2 == null) {
                consumer.accept(new WindowLayoutInfo(C2250q.g()));
                return;
            }
            boolean isActivityRegistered = isActivityRegistered(activity);
            WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = new WindowLayoutChangeCallbackWrapper(activity, executor, consumer);
            getWindowLayoutChangeCallbacks().add(windowLayoutChangeCallbackWrapper);
            if (!isActivityRegistered) {
                windowExtension2.onWindowLayoutChangeListenerAdded(activity);
            } else {
                Iterator<T> it = getWindowLayoutChangeCallbacks().iterator();
                while (true) {
                    windowLayoutInfo = null;
                    if (!it.hasNext()) {
                        t5 = null;
                        break;
                    }
                    t5 = it.next();
                    if (t.a(activity, ((WindowLayoutChangeCallbackWrapper) t5).getActivity())) {
                        break;
                    }
                }
                WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper2 = (WindowLayoutChangeCallbackWrapper) t5;
                if (windowLayoutChangeCallbackWrapper2 != null) {
                    windowLayoutInfo = windowLayoutChangeCallbackWrapper2.getLastInfo();
                }
                if (windowLayoutInfo != null) {
                    windowLayoutChangeCallbackWrapper.accept(windowLayoutInfo);
                }
            }
            J j5 = J.f19942a;
            reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void setWindowExtension(ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.windowExtension = extensionInterfaceCompat;
    }

    public void unregisterLayoutChangeCallback(Consumer<WindowLayoutInfo> consumer) {
        t.e(consumer, "callback");
        synchronized (globalLock) {
            try {
                if (getWindowExtension() != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<WindowLayoutChangeCallbackWrapper> it = getWindowLayoutChangeCallbacks().iterator();
                    while (it.hasNext()) {
                        WindowLayoutChangeCallbackWrapper next = it.next();
                        if (next.getCallback() == consumer) {
                            t.d(next, "callbackWrapper");
                            arrayList.add(next);
                        }
                    }
                    getWindowLayoutChangeCallbacks().removeAll(arrayList);
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        i5++;
                        callbackRemovedForActivity(((WindowLayoutChangeCallbackWrapper) obj).getActivity());
                    }
                    J j5 = J.f19942a;
                }
            } finally {
            }
        }
    }
}
