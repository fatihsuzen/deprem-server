package n4;

import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

public final class c extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f25522a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(String str, C2308e eVar) {
        super(2, eVar);
        this.f25522a = str;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new c(this.f25522a, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new c(this.f25522a, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        h3.C2453b.a(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r3) {
        /*
            r2 = this;
            c3.C2316b.f()
            W2.u.b(r3)
            java.net.URL r3 = new java.net.URL
            java.lang.String r0 = r2.f25522a
            r3.<init>(r0)
            java.net.URLConnection r3 = r3.openConnection()
            if (r3 == 0) goto L_0x0033
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            java.io.InputStream r3 = r3.getInputStream()
            r1.<init>(r3)
            r0.<init>(r1)
            java.lang.String r3 = h3.C2461j.h(r0)     // Catch:{ all -> 0x002c }
            r1 = 0
            h3.C2453b.a(r0, r1)
            return r3
        L_0x002c:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002e }
        L_0x002e:
            r1 = move-exception
            h3.C2453b.a(r0, r3)
            throw r1
        L_0x0033:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
