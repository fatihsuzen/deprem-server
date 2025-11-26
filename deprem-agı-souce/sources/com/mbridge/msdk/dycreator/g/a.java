package com.mbridge.msdk.dycreator.g;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;

public abstract class a extends com.mbridge.msdk.dycreator.c.a {

    /* renamed from: a  reason: collision with root package name */
    protected ConcurrentHashMap<Integer, Object> f8698a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private List<Object> f8699b = new ArrayList();

    public final synchronized void a(Object obj, int i5) {
        if (obj != null) {
            ConcurrentHashMap<Integer, Object> concurrentHashMap = this.f8698a;
            if (concurrentHashMap != null && !concurrentHashMap.containsValue(obj)) {
                this.f8698a.put(Integer.valueOf(i5), obj);
            }
        }
    }

    public final synchronized void a() {
        this.f8698a.clear();
    }
}
