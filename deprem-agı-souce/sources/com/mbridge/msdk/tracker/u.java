package com.mbridge.msdk.tracker;

import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.tracker.network.e;
import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.w;
import com.mbridge.msdk.tracker.network.z;
import java.util.HashMap;
import java.util.Map;

public final class u<T> extends com.mbridge.msdk.tracker.network.u<T> {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f11753a;

    /* renamed from: b  reason: collision with root package name */
    private u.b f11754b;

    /* renamed from: c  reason: collision with root package name */
    private w.b<T> f11755c;

    /* renamed from: d  reason: collision with root package name */
    private v f11756d;

    /* renamed from: e  reason: collision with root package name */
    private e f11757e;

    public u(String str, int i5) {
        super(i5, str);
    }

    public final void a(v vVar) {
        this.f11756d = vVar;
    }

    public final z b() {
        if (y.a((Object) this.f11757e)) {
            this.f11757e = new e(30000, 5);
        }
        return this.f11757e;
    }

    public final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
        hashMap.put("Charset", C.UTF8_NAME);
        return hashMap;
    }

    public final boolean d() {
        return false;
    }

    public final u.b e() {
        return this.f11754b;
    }

    public u(String str, int i5, int i6) {
        super(i5, str, i6);
    }

    public final void a(u.b bVar) {
        this.f11754b = bVar;
    }

    public final void a(Map<String, String> map) {
        this.f11753a = map;
    }

    public final void a(w.b<T> bVar) {
        this.f11755c = bVar;
    }

    /* access modifiers changed from: protected */
    public final w<T> a(r rVar) {
        return this.f11756d.a(rVar);
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> a() {
        return this.f11753a;
    }

    /* access modifiers changed from: protected */
    public final void a(T t5) {
        w.b<T> bVar = this.f11755c;
        this.f11755c = bVar;
        if (bVar != null) {
            bVar.a(t5);
        }
    }
}
