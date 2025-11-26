package com.mbridge.msdk.dycreator.bus;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class SubscriberMethodFinder {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, List<SubscriberMethod>> f8679a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f8680b = new ConcurrentHashMap();

    SubscriberMethodFinder() {
    }

    public static void clearSkipMethodNameVerifications() {
        f8680b.clear();
    }

    /* access modifiers changed from: package-private */
    public final List<SubscriberMethod> a(Class<?> cls, String str) {
        List<SubscriberMethod> list;
        ThreadMode threadMode;
        String str2 = str;
        String str3 = cls.getName() + '.' + str2;
        Map<String, List<SubscriberMethod>> map = f8679a;
        synchronized (map) {
            list = map.get(str3);
        }
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name = cls2.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                break;
            }
            for (Method method : cls2.getDeclaredMethods()) {
                String name2 = method.getName();
                if (name2.startsWith(str2)) {
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        String substring = name2.substring(str2.length());
                        if (substring.length() == 0) {
                            threadMode = ThreadMode.PostThread;
                        } else if (substring.equals("MainThread")) {
                            threadMode = ThreadMode.MainThread;
                        } else if (substring.equals("BackgroundThread")) {
                            threadMode = ThreadMode.BackgroundThread;
                        } else if (substring.equals("Async")) {
                            threadMode = ThreadMode.Async;
                        } else if (!f8680b.containsKey(cls2)) {
                            throw new EventBusException("Illegal onEvent method, check for typos: " + method);
                        }
                        Class cls3 = parameterTypes[0];
                        sb.setLength(0);
                        sb.append(name2);
                        sb.append('>');
                        sb.append(cls3.getName());
                        if (hashSet.add(sb.toString())) {
                            arrayList.add(new SubscriberMethod(method, threadMode, cls3));
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Map<String, List<SubscriberMethod>> map2 = f8679a;
            synchronized (map2) {
                map2.put(str3, arrayList);
            }
            return arrayList;
        }
        throw new EventBusException("Subscriber " + cls + " has no methods called " + str2);
    }

    static void a() {
        f8679a.clear();
    }

    static void a(Class<?> cls) {
        if (f8679a.isEmpty()) {
            f8680b.put(cls, cls);
            return;
        }
        throw new IllegalStateException("This method must be called before registering anything");
    }
}
