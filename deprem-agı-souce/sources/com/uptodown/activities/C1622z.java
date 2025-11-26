package com.uptodown.activities;

import W2.J;
import W2.u;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import b3.C2308e;
import c3.C2316b;
import com.uptodown.R;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2642B;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import z2.C2940B;
import z2.O;
import z3.D;
import z3.F;
import z3.w;

/* renamed from: com.uptodown.activities.z  reason: case insensitive filesystem */
public final class C1622z extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final w f15206a;

    /* renamed from: b  reason: collision with root package name */
    private final D f15207b;

    /* renamed from: com.uptodown.activities.z$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f15208a;

        public a(ArrayList arrayList) {
            t.e(arrayList, "notificationsRegistry");
            this.f15208a = arrayList;
        }

        public final ArrayList a() {
            return this.f15208a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && t.a(this.f15208a, ((a) obj).f15208a);
        }

        public int hashCode() {
            return this.f15208a.hashCode();
        }

        public String toString() {
            return "NotificationRegistryData(notificationsRegistry=" + this.f15208a + ')';
        }
    }

    /* renamed from: com.uptodown.activities.z$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15209a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15210b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1622z f15211c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, C1622z zVar, C2308e eVar) {
            super(2, eVar);
            this.f15210b = context;
            this.f15211c = zVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f15210b, this.f15211c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15209a == 0) {
                u.b(obj);
                C2940B a5 = C2940B.f26458v.a(this.f15210b);
                a5.a();
                a5.q();
                a5.m();
                this.f15211c.d(this.f15210b);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.z$c */
    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15212a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15213b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f15214c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, int i5, C2308e eVar) {
            super(2, eVar);
            this.f15213b = context;
            this.f15214c = i5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f15213b, this.f15214c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15212a == 0) {
                u.b(obj);
                C2940B a5 = C2940B.f26458v.a(this.f15213b);
                a5.a();
                a5.H(this.f15214c);
                a5.m();
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.z$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15215a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15216b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1622z f15217c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, C1622z zVar, C2308e eVar) {
            super(2, eVar);
            this.f15216b = context;
            this.f15217c = zVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f15216b, this.f15217c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15215a == 0) {
                u.b(obj);
                C2940B a5 = C2940B.f26458v.a(this.f15216b);
                a5.a();
                ArrayList x02 = a5.x0();
                a5.m();
                this.f15217c.f15206a.setValue(new O.c(new a(x02)));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.z$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f15218a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f15219b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2642B f15220c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f15221d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, C2642B b5, String str, C2308e eVar) {
            super(2, eVar);
            this.f15219b = context;
            this.f15220c = b5;
            this.f15221d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f15219b, this.f15220c, this.f15221d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f15218a == 0) {
                u.b(obj);
                C2940B a5 = C2940B.f26458v.a(this.f15219b);
                a5.a();
                C2642B b5 = this.f15220c;
                String string = this.f15219b.getString(R.string.file_deleted_notification, new Object[]{this.f15221d});
                t.d(string, "getString(...)");
                a5.F1(b5, "no_action", string);
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public C1622z() {
        w a5 = F.a(O.a.f26507a);
        this.f15206a = a5;
        this.f15207b = a5;
    }

    public final void b(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new b(context, this, (C2308e) null), 2, (Object) null);
    }

    public final void c(Context context, int i5) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new c(context, i5, (C2308e) null), 2, (Object) null);
    }

    public final void d(Context context) {
        t.e(context, "context");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new d(context, this, (C2308e) null), 2, (Object) null);
    }

    public final D e() {
        return this.f15207b;
    }

    public final void f(Context context, C2642B b5, String str) {
        t.e(context, "context");
        t.e(b5, "notification");
        t.e(str, "dateString");
        C2908y0 unused = C2876i.d(ViewModelKt.getViewModelScope(this), C2865c0.b(), (w3.O) null, new e(context, b5, str, (C2308e) null), 2, (Object) null);
    }
}
