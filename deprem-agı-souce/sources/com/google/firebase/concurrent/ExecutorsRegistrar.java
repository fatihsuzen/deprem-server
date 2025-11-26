package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import q0.C1756a;
import q0.b;
import q0.c;
import q0.d;
import r0.C1786c;
import r0.C1788e;
import r0.F;
import r0.x;
import s0.C1818b;
import s0.C1819c;
import s0.C1820d;
import s0.C1821e;
import s0.C1822f;
import s0.C1823g;
import s0.h;
import s0.i;

@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {

    /* renamed from: a  reason: collision with root package name */
    static final x f7170a = new x(new C1818b());

    /* renamed from: b  reason: collision with root package name */
    static final x f7171b = new x(new C1819c());

    /* renamed from: c  reason: collision with root package name */
    static final x f7172c = new x(new C1820d());

    /* renamed from: d  reason: collision with root package name */
    static final x f7173d = new x(new C1821e());

    public static /* synthetic */ ScheduledExecutorService a(C1788e eVar) {
        return (ScheduledExecutorService) f7171b.get();
    }

    public static /* synthetic */ ScheduledExecutorService e(C1788e eVar) {
        return (ScheduledExecutorService) f7172c.get();
    }

    public static /* synthetic */ ScheduledExecutorService g(C1788e eVar) {
        return (ScheduledExecutorService) f7170a.get();
    }

    private static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i5 = Build.VERSION.SDK_INT;
        detectNetwork.detectResourceMismatches();
        if (i5 >= 26) {
            StrictMode.ThreadPolicy.Builder unused = detectNetwork.detectUnbufferedIo();
        }
        return detectNetwork.penaltyLog().build();
    }

    private static ThreadFactory j(String str, int i5) {
        return new b(str, i5, (StrictMode.ThreadPolicy) null);
    }

    private static ThreadFactory k(String str, int i5, StrictMode.ThreadPolicy threadPolicy) {
        return new b(str, i5, threadPolicy);
    }

    private static StrictMode.ThreadPolicy l() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    /* access modifiers changed from: private */
    public static ScheduledExecutorService m(ExecutorService executorService) {
        return new o(executorService, (ScheduledExecutorService) f7173d.get());
    }

    public List getComponents() {
        Class<C1756a> cls = C1756a.class;
        Class<ScheduledExecutorService> cls2 = ScheduledExecutorService.class;
        Class<ExecutorService> cls3 = ExecutorService.class;
        Class<Executor> cls4 = Executor.class;
        C1786c d5 = C1786c.f(F.a(cls, cls2), F.a(cls, cls3), F.a(cls, cls4)).f(new C1822f()).d();
        Class<b> cls5 = b.class;
        C1786c d6 = C1786c.f(F.a(cls5, cls2), F.a(cls5, cls3), F.a(cls5, cls4)).f(new C1823g()).d();
        Class<c> cls6 = c.class;
        return Arrays.asList(new C1786c[]{d5, d6, C1786c.f(F.a(cls6, cls2), F.a(cls6, cls3), F.a(cls6, cls4)).f(new h()).d(), C1786c.e(F.a(d.class, cls4)).f(new i()).d()});
    }
}
