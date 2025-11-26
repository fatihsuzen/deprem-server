package com.mbridge.msdk.dycreator.bus;

import android.os.Looper;
import android.util.Log;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class EventBus {
    public static String TAG = "Event";

    /* renamed from: a  reason: collision with root package name */
    static ExecutorService f8645a = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    private static volatile EventBus f8646b;

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f8647c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> f8648d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f8649e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, Object> f8650f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private final ThreadLocal<List<Object>> f8651g = new ThreadLocal<List<Object>>() {
        /* access modifiers changed from: protected */
        public /* synthetic */ Object initialValue() {
            return new ArrayList();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final ThreadLocal<BooleanWrapper> f8652h = new ThreadLocal<BooleanWrapper>() {
        /* access modifiers changed from: protected */
        public /* synthetic */ Object initialValue() {
            return new BooleanWrapper();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private String f8653i = "onEvent";

    /* renamed from: j  reason: collision with root package name */
    private final HandlerPoster f8654j = new HandlerPoster(this, Looper.getMainLooper(), 10);

    /* renamed from: k  reason: collision with root package name */
    private final BackgroundPoster f8655k = new BackgroundPoster(this);

    /* renamed from: l  reason: collision with root package name */
    private final AsyncPoster f8656l = new AsyncPoster(this);

    /* renamed from: m  reason: collision with root package name */
    private final SubscriberMethodFinder f8657m = new SubscriberMethodFinder();

    /* renamed from: n  reason: collision with root package name */
    private boolean f8658n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f8659o = true;

    /* renamed from: p  reason: collision with root package name */
    private Map<String, Object> f8660p = new ConcurrentHashMap();

    /* renamed from: com.mbridge.msdk.dycreator.bus.EventBus$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8663a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.mbridge.msdk.dycreator.bus.ThreadMode[] r0 = com.mbridge.msdk.dycreator.bus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8663a = r0
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.PostThread     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8663a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.MainThread     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8663a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.BackgroundThread     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8663a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.Async     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.bus.EventBus.AnonymousClass3.<clinit>():void");
        }
    }

    static final class BooleanWrapper {

        /* renamed from: a  reason: collision with root package name */
        boolean f8664a;

        BooleanWrapper() {
        }
    }

    interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    private void a(Object obj, String str, boolean z4) {
        for (SubscriberMethod a5 : this.f8657m.a(obj.getClass(), str)) {
            a(obj, a5, z4);
        }
    }

    public static void clearCaches() {
        SubscriberMethodFinder.a();
        f8647c.clear();
    }

    public static void clearSkipMethodNameVerifications() {
        SubscriberMethodFinder.clearSkipMethodNameVerifications();
    }

    public static EventBus getDefault() {
        if (f8646b == null) {
            synchronized (EventBus.class) {
                try {
                    if (f8646b == null) {
                        f8646b = new EventBus();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8646b;
    }

    public static void skipMethodNameVerificationFor(Class<?> cls) {
        SubscriberMethodFinder.a(cls);
    }

    public final void configureLogSubscriberExceptions(boolean z4) {
        if (!this.f8658n) {
            this.f8659o = z4;
            return;
        }
        throw new EventBusException("This method must be called before any registration");
    }

    public final Object getStickyEvent(Class<?> cls) {
        Object obj;
        synchronized (this.f8650f) {
            obj = this.f8650f.get(cls);
        }
        return obj;
    }

    public final void post(Object obj) {
        boolean z4;
        CopyOnWriteArrayList copyOnWriteArrayList;
        List list = this.f8651g.get();
        list.add(obj);
        BooleanWrapper booleanWrapper = this.f8652h.get();
        if (!booleanWrapper.f8664a) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z4 = true;
            } else {
                z4 = false;
            }
            booleanWrapper.f8664a = true;
            while (!list.isEmpty()) {
                try {
                    Object remove = list.remove(0);
                    if (remove != null) {
                        Class<?> cls = remove.getClass();
                        List<Class<?>> a5 = a(cls);
                        int size = a5.size();
                        boolean z5 = false;
                        for (int i5 = 0; i5 < size; i5++) {
                            Class cls2 = a5.get(i5);
                            synchronized (this) {
                                copyOnWriteArrayList = this.f8648d.get(cls2);
                            }
                            if (copyOnWriteArrayList != null) {
                                Iterator it = copyOnWriteArrayList.iterator();
                                while (it.hasNext()) {
                                    a((Subscription) it.next(), remove, z4);
                                }
                                z5 = true;
                            }
                        }
                        if (!z5) {
                            Log.d(TAG, "No subscripers registered for event " + cls);
                            if (!(cls == NoSubscriberEvent.class || cls == SubscriberExceptionEvent.class)) {
                                post(new NoSubscriberEvent(this, remove));
                            }
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                } catch (Throwable th) {
                    booleanWrapper.f8664a = false;
                    throw th;
                }
            }
            booleanWrapper.f8664a = false;
        }
    }

    public final void postSticky(Object obj) {
        post(obj);
        synchronized (this.f8650f) {
            this.f8650f.put(obj.getClass(), obj);
        }
    }

    public final void register(Object obj) {
        a(obj, this.f8653i, false);
    }

    public final void registerSticky(Object obj) {
        a(obj, this.f8653i, true);
    }

    public final void release() {
        if (f8646b != null) {
            f8646b = null;
            f8645a = null;
            Map<Class<?>, List<Class<?>>> map = f8647c;
            if (map != null && map.size() > 0) {
                map.clear();
            }
            Map<Class<?>, CopyOnWriteArrayList<Subscription>> map2 = this.f8648d;
            if (map2 != null && map2.size() > 0) {
                this.f8648d.clear();
            }
            Map<Object, List<Class<?>>> map3 = this.f8649e;
            if (map3 != null && map3.size() > 0) {
                this.f8649e.clear();
            }
            Map<Class<?>, Object> map4 = this.f8650f;
            if (map4 != null && map4.size() > 0) {
                this.f8650f.clear();
            }
            Map<String, Object> map5 = this.f8660p;
            if (map5 != null && map5.size() > 0) {
                this.f8660p.clear();
            }
        }
    }

    public final Object removeStickyEvent(Class<?> cls) {
        Object remove;
        synchronized (this.f8650f) {
            remove = this.f8650f.remove(cls);
        }
        return remove;
    }

    public final synchronized void unregister(Object obj, Class<?>... clsArr) {
        try {
            if (clsArr.length != 0) {
                List list = this.f8649e.get(obj);
                if (list != null) {
                    for (Class<?> cls : clsArr) {
                        a(obj, cls);
                        list.remove(cls);
                    }
                    if (list.isEmpty()) {
                        this.f8649e.remove(obj);
                    }
                } else {
                    Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
                }
            } else {
                throw new IllegalArgumentException("Provide at least one event class");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void register(String str, Object obj) {
        Map<String, Object> map = this.f8660p;
        if (map != null && map.containsKey(str)) {
            unregister(this.f8660p.get(str));
        }
        this.f8660p.put(str, obj);
        a(obj, this.f8653i, false);
    }

    public final void registerSticky(Object obj, String str) {
        a(obj, str, true);
    }

    public final void registerSticky(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f8653i, true, cls, clsArr);
    }

    public final synchronized void registerSticky(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        try {
            a(obj, str, true, cls, clsArr);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final boolean removeStickyEvent(Object obj) {
        synchronized (this.f8650f) {
            try {
                Class<?> cls = obj.getClass();
                if (!obj.equals(this.f8650f.get(cls))) {
                    return false;
                }
                this.f8650f.remove(cls);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized void a(Object obj, String str, boolean z4, Class<?> cls, Class<?>... clsArr) {
        try {
            for (SubscriberMethod next : this.f8657m.a(obj.getClass(), str)) {
                if (cls == next.f8677c) {
                    a(obj, next, z4);
                } else if (clsArr != null) {
                    int length = clsArr.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        } else if (clsArr[i5] == next.f8677c) {
                            a(obj, next, z4);
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
            }
        } finally {
            while (true) {
            }
        }
    }

    public final void register(Object obj, String str) {
        a(obj, str, false);
    }

    public final void register(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f8653i, false, cls, clsArr);
    }

    public final synchronized void register(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        try {
            a(obj, str, false, cls, clsArr);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final synchronized void unregister(Object obj) {
        try {
            List<Class> list = this.f8649e.get(obj);
            if (list != null) {
                for (Class a5 : list) {
                    a(obj, (Class<?>) a5);
                }
                this.f8649e.remove(obj);
            } else {
                String str = TAG;
                Log.w(str, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private void a(Object obj, SubscriberMethod subscriberMethod, boolean z4) {
        Object obj2;
        boolean z5 = true;
        this.f8658n = true;
        Class<?> cls = subscriberMethod.f8677c;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f8648d.get(cls);
        Subscription subscription = new Subscription(obj, subscriberMethod);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f8648d.put(cls, copyOnWriteArrayList);
        } else {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (((Subscription) it.next()).equals(subscription)) {
                    throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
                }
            }
        }
        subscriberMethod.f8675a.setAccessible(true);
        copyOnWriteArrayList.add(subscription);
        List list = this.f8649e.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f8649e.put(obj, list);
        }
        list.add(cls);
        if (z4) {
            synchronized (this.f8650f) {
                obj2 = this.f8650f.get(cls);
            }
            if (obj2 != null) {
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    z5 = false;
                }
                a(subscription, obj2, z5);
            }
        }
    }

    public final synchronized void unregister(String str) {
        try {
            Map<String, Object> map = this.f8660p;
            if (map != null && map.containsKey(str)) {
                Object remove = this.f8660p.remove(str);
                List<Class> list = this.f8649e.get(remove);
                if (list != null) {
                    for (Class a5 : list) {
                        a(remove, (Class<?>) a5);
                    }
                    this.f8649e.remove(remove);
                } else {
                    String str2 = TAG;
                    Log.w(str2, "Subscriber to unregister was not registered before: " + remove.getClass());
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private void a(Object obj, Class<?> cls) {
        List list = this.f8648d.get(cls);
        if (list != null) {
            int size = list.size();
            int i5 = 0;
            while (i5 < size) {
                if (((Subscription) list.get(i5)).f8681a == obj) {
                    list.remove(i5);
                    i5--;
                    size--;
                }
                i5++;
            }
        }
    }

    private void a(Subscription subscription, Object obj, boolean z4) {
        int i5 = AnonymousClass3.f8663a[subscription.f8682b.f8676b.ordinal()];
        if (i5 == 1) {
            a(subscription, obj);
        } else if (i5 != 2) {
            if (i5 != 3) {
                if (i5 == 4) {
                    this.f8656l.enqueue(subscription, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + subscription.f8682b.f8676b);
            } else if (z4) {
                this.f8655k.enqueue(subscription, obj);
            } else {
                a(subscription, obj);
            }
        } else if (z4) {
            a(subscription, obj);
        } else {
            this.f8654j.a(subscription, obj);
        }
    }

    private List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = f8647c;
        synchronized (map) {
            try {
                list = map.get(cls);
                if (list == null) {
                    list = new ArrayList<>();
                    for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                        list.add(cls2);
                        a(list, (Class<?>[]) cls2.getInterfaces());
                    }
                    f8647c.put(cls, list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    private static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(PendingPost pendingPost) {
        Object obj = pendingPost.f8670a;
        Subscription subscription = pendingPost.f8671b;
        PendingPost.a(pendingPost);
        a(subscription, obj);
    }

    private void a(Subscription subscription, Object obj) throws Error {
        try {
            subscription.f8682b.f8675a.invoke(subscription.f8681a, new Object[]{obj});
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (obj instanceof SubscriberExceptionEvent) {
                String str = TAG;
                Log.e(str, "SubscriberExceptionEvent subscriber " + subscription.f8681a.getClass() + " threw an exception", cause);
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                String str2 = TAG;
                Log.e(str2, "Initial event " + subscriberExceptionEvent.causingEvent + " caused exception in " + subscriberExceptionEvent.causingSubscriber, subscriberExceptionEvent.throwable);
                return;
            }
            if (this.f8659o) {
                String str3 = TAG;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + subscription.f8681a.getClass(), cause);
            }
            post(new SubscriberExceptionEvent(this, cause, obj, subscription.f8681a));
        } catch (IllegalAccessException e6) {
            throw new IllegalStateException("Unexpected exception", e6);
        }
    }
}
