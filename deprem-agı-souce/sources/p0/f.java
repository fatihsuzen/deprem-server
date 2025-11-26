package P0;

import P0.j;
import R0.b;
import Z0.i;
import android.content.Context;
import android.util.Base64OutputStream;
import androidx.core.os.UserManagerCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import k0.C1698l;
import k0.C1701o;
import org.json.JSONArray;
import org.json.JSONObject;
import q0.C1756a;
import r0.C1786c;
import r0.C1788e;
import r0.F;
import r0.r;

public class f implements i, j {

    /* renamed from: a  reason: collision with root package name */
    private final b f3877a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f3878b;

    /* renamed from: c  reason: collision with root package name */
    private final b f3879c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f3880d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f3881e;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private f(android.content.Context r7, java.lang.String r8, java.util.Set r9, R0.b r10, java.util.concurrent.Executor r11) {
        /*
            r6 = this;
            r0.x r1 = new r0.x
            P0.c r0 = new P0.c
            r0.<init>(r7, r8)
            r1.<init>(r0)
            r0 = r6
            r5 = r7
            r2 = r9
            r4 = r10
            r3 = r11
            r0.<init>((R0.b) r1, (java.util.Set) r2, (java.util.concurrent.Executor) r3, (R0.b) r4, (android.content.Context) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P0.f.<init>(android.content.Context, java.lang.String, java.util.Set, R0.b, java.util.concurrent.Executor):void");
    }

    public static /* synthetic */ String c(f fVar) {
        Base64OutputStream base64OutputStream;
        GZIPOutputStream gZIPOutputStream;
        String byteArrayOutputStream;
        synchronized (fVar) {
            try {
                p pVar = (p) fVar.f3877a.get();
                List g5 = pVar.g();
                pVar.f();
                JSONArray jSONArray = new JSONArray();
                for (int i5 = 0; i5 < g5.size(); i5++) {
                    q qVar = (q) g5.get(i5);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", qVar.c());
                    jSONObject.put("dates", new JSONArray(qVar.b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
                gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                gZIPOutputStream.write(jSONObject2.toString().getBytes(C.UTF8_NAME));
                gZIPOutputStream.close();
                base64OutputStream.close();
                byteArrayOutputStream = byteArrayOutputStream2.toString(C.UTF8_NAME);
            } catch (Throwable th) {
                throw th;
            }
        }
        return byteArrayOutputStream;
        throw th;
        throw th;
    }

    public static /* synthetic */ p d(Context context, String str) {
        return new p(context, str);
    }

    public static /* synthetic */ f e(F f5, C1788e eVar) {
        return new f((Context) eVar.a(Context.class), ((o0.f) eVar.a(o0.f.class)).o(), eVar.h(g.class), eVar.c(i.class), (Executor) eVar.e(f5));
    }

    public static /* synthetic */ Void f(f fVar) {
        synchronized (fVar) {
            ((p) fVar.f3877a.get()).o(System.currentTimeMillis(), ((i) fVar.f3879c.get()).a());
        }
        return null;
    }

    public static C1786c g() {
        F a5 = F.a(C1756a.class, Executor.class);
        return C1786c.d(f.class, i.class, j.class).b(r.k(Context.class)).b(r.k(o0.f.class)).b(r.o(g.class)).b(r.m(i.class)).b(r.l(a5)).f(new b(a5)).d();
    }

    public C1698l a() {
        if (!UserManagerCompat.isUserUnlocked(this.f3878b)) {
            return C1701o.e("");
        }
        return C1701o.c(this.f3881e, new d(this));
    }

    public synchronized j.a b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        p pVar = (p) this.f3877a.get();
        if (pVar.m(currentTimeMillis)) {
            pVar.k();
            return j.a.GLOBAL;
        }
        return j.a.NONE;
    }

    public C1698l h() {
        if (this.f3880d.size() <= 0) {
            return C1701o.e((Object) null);
        }
        if (!UserManagerCompat.isUserUnlocked(this.f3878b)) {
            return C1701o.e((Object) null);
        }
        return C1701o.c(this.f3881e, new e(this));
    }

    f(b bVar, Set set, Executor executor, b bVar2, Context context) {
        this.f3877a = bVar;
        this.f3880d = set;
        this.f3881e = executor;
        this.f3879c = bVar2;
        this.f3878b = context;
    }
}
