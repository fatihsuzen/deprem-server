package com.google.android.gms.internal.measurement;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class N5 {

    /* renamed from: c  reason: collision with root package name */
    private static final N5 f5035c = new N5();

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f5036d = 0;

    /* renamed from: a  reason: collision with root package name */
    private final R5 f5037a = new C1250w5();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap f5038b = new ConcurrentHashMap();

    private N5() {
    }

    public static N5 a() {
        return f5035c;
    }

    public final Q5 b(Class cls) {
        C1152l5.a(cls, "messageType");
        ConcurrentMap concurrentMap = this.f5038b;
        Q5 q5 = (Q5) concurrentMap.get(cls);
        if (q5 == null) {
            q5 = this.f5037a.a(cls);
            C1152l5.a(cls, "messageType");
            Q5 q52 = (Q5) concurrentMap.putIfAbsent(cls, q5);
            if (q52 != null) {
                return q52;
            }
        }
        return q5;
    }
}
