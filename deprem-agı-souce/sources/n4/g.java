package n4;

import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

public final class g extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f25530a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f25531b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(String str, String str2, C2308e eVar) {
        super(2, eVar);
        this.f25530a = str;
        this.f25531b = str2;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new g(this.f25530a, this.f25531b, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new g(this.f25530a, this.f25531b, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        h3.C2453b.a(r1, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            c3.C2316b.f()
            W2.u.b(r5)
            java.net.URL r5 = new java.net.URL
            java.lang.String r0 = r4.f25530a
            r5.<init>(r0)
            java.lang.String r0 = r4.f25531b
            java.net.URLConnection r5 = r5.openConnection()
            if (r5 == 0) goto L_0x0061
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5
            java.lang.String r1 = "POST"
            r5.setRequestMethod(r1)
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json"
            r5.setRequestProperty(r1, r2)
            r1 = 1
            r5.setDoOutput(r1)
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter
            java.io.OutputStream r2 = r5.getOutputStream()
            java.lang.String r3 = "UTF-8"
            r1.<init>(r2, r3)
            r1.write(r0)     // Catch:{ all -> 0x005a }
            r1.flush()     // Catch:{ all -> 0x005a }
            W2.J r0 = W2.J.f19942a     // Catch:{ all -> 0x005a }
            r0 = 0
            h3.C2453b.a(r1, r0)
            int r0 = r5.getResponseCode()
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x004a
            r5.disconnect()
            return r5
        L_0x004a:
            java.io.IOException r5 = new java.io.IOException
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.b.b(r0)
            java.lang.String r1 = "HTTP error code: "
            java.lang.String r0 = kotlin.jvm.internal.t.n(r1, r0)
            r5.<init>(r0)
            throw r5
        L_0x005a:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x005c }
        L_0x005c:
            r0 = move-exception
            h3.C2453b.a(r1, r5)
            throw r0
        L_0x0061:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.g.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
