package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.tracker.network.toolbox.b;
import com.mbridge.msdk.tracker.network.toolbox.j;
import com.mbridge.msdk.tracker.network.toolbox.k;
import com.mbridge.msdk.tracker.network.toolbox.n;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11601a = "m";

    /* renamed from: b  reason: collision with root package name */
    private static volatile m f11602b;

    /* renamed from: c  reason: collision with root package name */
    private v f11603c;

    private m() {
    }

    public static m a() {
        if (f11602b == null) {
            synchronized (m.class) {
                try {
                    if (f11602b == null) {
                        f11602b = new m();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11602b;
    }

    public final v b() {
        if (this.f11603c == null) {
            v a5 = n.a(new b(new k()), (x) null, 10, new j());
            this.f11603c = a5;
            a5.a();
        }
        return this.f11603c;
    }
}
