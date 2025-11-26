package e4;

import X2.C2250q;
import X2.M;
import java.util.ArrayList;
import java.util.Map;
import k3.l;
import kotlin.jvm.internal.t;

/* renamed from: e4.j  reason: case insensitive filesystem */
public final class C2361j {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f21581a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21582b;

    /* renamed from: c  reason: collision with root package name */
    private final Q f21583c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f21584d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f21585e;

    /* renamed from: f  reason: collision with root package name */
    private final Long f21586f;

    /* renamed from: g  reason: collision with root package name */
    private final Long f21587g;

    /* renamed from: h  reason: collision with root package name */
    private final Map f21588h;

    public C2361j(boolean z4, boolean z5, Q q5, Long l5, Long l6, Long l7, Long l8, Map map) {
        t.e(map, "extras");
        this.f21581a = z4;
        this.f21582b = z5;
        this.f21583c = q5;
        this.f21584d = l5;
        this.f21585e = l6;
        this.f21586f = l7;
        this.f21587g = l8;
        this.f21588h = M.t(map);
    }

    public final Long a() {
        return this.f21586f;
    }

    public final Long b() {
        return this.f21584d;
    }

    public final boolean c() {
        return this.f21582b;
    }

    public final boolean d() {
        return this.f21581a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f21581a) {
            arrayList.add("isRegularFile");
        }
        if (this.f21582b) {
            arrayList.add("isDirectory");
        }
        if (this.f21584d != null) {
            arrayList.add("byteCount=" + this.f21584d);
        }
        if (this.f21585e != null) {
            arrayList.add("createdAt=" + this.f21585e);
        }
        if (this.f21586f != null) {
            arrayList.add("lastModifiedAt=" + this.f21586f);
        }
        if (this.f21587g != null) {
            arrayList.add("lastAccessedAt=" + this.f21587g);
        }
        if (!this.f21588h.isEmpty()) {
            arrayList.add("extras=" + this.f21588h);
        }
        return C2250q.V(arrayList, ", ", "FileMetadata(", ")", 0, (CharSequence) null, (l) null, 56, (Object) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ C2361j(boolean r2, boolean r3, e4.Q r4, java.lang.Long r5, java.lang.Long r6, java.lang.Long r7, java.lang.Long r8, java.util.Map r9, int r10, kotlin.jvm.internal.C2633k r11) {
        /*
            r1 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0006
            r2 = r0
        L_0x0006:
            r11 = r10 & 2
            if (r11 == 0) goto L_0x000b
            r3 = r0
        L_0x000b:
            r11 = r10 & 4
            r0 = 0
            if (r11 == 0) goto L_0x0011
            r4 = r0
        L_0x0011:
            r11 = r10 & 8
            if (r11 == 0) goto L_0x0016
            r5 = r0
        L_0x0016:
            r11 = r10 & 16
            if (r11 == 0) goto L_0x001b
            r6 = r0
        L_0x001b:
            r11 = r10 & 32
            if (r11 == 0) goto L_0x0020
            r7 = r0
        L_0x0020:
            r11 = r10 & 64
            if (r11 == 0) goto L_0x0025
            r8 = r0
        L_0x0025:
            r10 = r10 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x002d
            java.util.Map r9 = X2.M.h()
        L_0x002d:
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.C2361j.<init>(boolean, boolean, e4.Q, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.util.Map, int, kotlin.jvm.internal.k):void");
    }
}
