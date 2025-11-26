package com.mbridge.msdk.tracker.network;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.HashMap;
import java.util.Map;

public abstract class i<T> extends u<T> {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f11593a = "i";

    /* renamed from: b  reason: collision with root package name */
    private final long f11594b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f11595c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f11596d;

    /* renamed from: e  reason: collision with root package name */
    private z f11597e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11598f = false;

    public i(int i5, String str, int i6, String str2, long j5) {
        super(i5, str, i6, str2);
        if (j5 > 0) {
            this.f11594b = j5;
        } else {
            this.f11594b = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        }
    }

    public final void a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            if (this.f11595c == null) {
                this.f11595c = new HashMap();
            }
            try {
                this.f11595c.putAll(map);
            } catch (Exception e5) {
                String str = f11593a;
                af.b(str, "addParams error: " + e5.getMessage());
            }
        }
    }

    public final z b() {
        if (this.f11597e == null) {
            this.f11597e = new e(30000, this.f11594b, 3);
        }
        return this.f11597e;
    }

    public final Map<String, String> c() {
        if (this.f11596d == null) {
            this.f11596d = new HashMap();
        }
        this.f11596d.put("Charset", C.UTF8_NAME);
        return this.f11596d;
    }

    public final boolean d() {
        if (!this.f11598f || !d.a(f(), k())) {
            return false;
        }
        return true;
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f11596d == null) {
                this.f11596d = new HashMap();
            }
            try {
                this.f11596d.put(str, str2);
            } catch (Exception e5) {
                String str3 = f11593a;
                af.b(str3, "addHeader error: " + e5.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> a() {
        if (this.f11595c == null) {
            this.f11595c = new HashMap();
        }
        return this.f11595c;
    }

    public final void a(boolean z4) {
        this.f11598f = z4;
    }
}
