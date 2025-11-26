package a4;

import V3.c;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import e4.C2356e;
import e4.C2358g;
import e4.C2359h;
import e4.L;
import e4.Z;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

abstract class d {

    /* renamed from: a  reason: collision with root package name */
    static final c[] f20315a;

    /* renamed from: b  reason: collision with root package name */
    static final Map f20316b = b();

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f20317a;

        /* renamed from: b  reason: collision with root package name */
        private final C2358g f20318b;

        /* renamed from: c  reason: collision with root package name */
        private final int f20319c;

        /* renamed from: d  reason: collision with root package name */
        private int f20320d;

        /* renamed from: e  reason: collision with root package name */
        c[] f20321e;

        /* renamed from: f  reason: collision with root package name */
        int f20322f;

        /* renamed from: g  reason: collision with root package name */
        int f20323g;

        /* renamed from: h  reason: collision with root package name */
        int f20324h;

        a(int i5, Z z4) {
            this(i5, i5, z4);
        }

        private void a() {
            int i5 = this.f20320d;
            int i6 = this.f20324h;
            if (i5 >= i6) {
                return;
            }
            if (i5 == 0) {
                b();
            } else {
                d(i6 - i5);
            }
        }

        private void b() {
            Arrays.fill(this.f20321e, (Object) null);
            this.f20322f = this.f20321e.length - 1;
            this.f20323g = 0;
            this.f20324h = 0;
        }

        private int c(int i5) {
            return this.f20322f + 1 + i5;
        }

        private int d(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.f20321e.length;
                while (true) {
                    length--;
                    i6 = this.f20322f;
                    if (length < i6 || i5 <= 0) {
                        c[] cVarArr = this.f20321e;
                        System.arraycopy(cVarArr, i6 + 1, cVarArr, i6 + 1 + i7, this.f20323g);
                        this.f20322f += i7;
                    } else {
                        int i8 = this.f20321e[length].f20314c;
                        i5 -= i8;
                        this.f20324h -= i8;
                        this.f20323g--;
                        i7++;
                    }
                }
                c[] cVarArr2 = this.f20321e;
                System.arraycopy(cVarArr2, i6 + 1, cVarArr2, i6 + 1 + i7, this.f20323g);
                this.f20322f += i7;
            }
            return i7;
        }

        private C2359h f(int i5) {
            if (h(i5)) {
                return d.f20315a[i5].f20312a;
            }
            int c5 = c(i5 - d.f20315a.length);
            if (c5 >= 0) {
                c[] cVarArr = this.f20321e;
                if (c5 < cVarArr.length) {
                    return cVarArr[c5].f20312a;
                }
            }
            throw new IOException("Header index too large " + (i5 + 1));
        }

        private void g(int i5, c cVar) {
            this.f20317a.add(cVar);
            int i6 = cVar.f20314c;
            if (i5 != -1) {
                i6 -= this.f20321e[c(i5)].f20314c;
            }
            int i7 = this.f20320d;
            if (i6 > i7) {
                b();
                return;
            }
            int d5 = d((this.f20324h + i6) - i7);
            if (i5 == -1) {
                int i8 = this.f20323g + 1;
                c[] cVarArr = this.f20321e;
                if (i8 > cVarArr.length) {
                    c[] cVarArr2 = new c[(cVarArr.length * 2)];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f20322f = this.f20321e.length - 1;
                    this.f20321e = cVarArr2;
                }
                int i9 = this.f20322f;
                this.f20322f = i9 - 1;
                this.f20321e[i9] = cVar;
                this.f20323g++;
            } else {
                this.f20321e[i5 + c(i5) + d5] = cVar;
            }
            this.f20324h += i6;
        }

        private boolean h(int i5) {
            if (i5 < 0 || i5 > d.f20315a.length - 1) {
                return false;
            }
            return true;
        }

        private int i() {
            return this.f20318b.readByte() & 255;
        }

        private void l(int i5) {
            if (h(i5)) {
                this.f20317a.add(d.f20315a[i5]);
                return;
            }
            int c5 = c(i5 - d.f20315a.length);
            if (c5 >= 0) {
                c[] cVarArr = this.f20321e;
                if (c5 < cVarArr.length) {
                    this.f20317a.add(cVarArr[c5]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i5 + 1));
        }

        private void n(int i5) {
            g(-1, new c(f(i5), j()));
        }

        private void o() {
            g(-1, new c(d.a(j()), j()));
        }

        private void p(int i5) {
            this.f20317a.add(new c(f(i5), j()));
        }

        private void q() {
            this.f20317a.add(new c(d.a(j()), j()));
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f20317a);
            this.f20317a.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public C2359h j() {
            boolean z4;
            int i5 = i();
            if ((i5 & 128) == 128) {
                z4 = true;
            } else {
                z4 = false;
            }
            int m5 = m(i5, 127);
            if (z4) {
                return C2359h.w(k.f().c(this.f20318b.readByteArray((long) m5)));
            }
            return this.f20318b.readByteString((long) m5);
        }

        /* access modifiers changed from: package-private */
        public void k() {
            while (!this.f20318b.exhausted()) {
                byte readByte = this.f20318b.readByte();
                byte b5 = readByte & 255;
                if (b5 == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    l(m(b5, 127) - 1);
                } else if (b5 == 64) {
                    o();
                } else if ((readByte & 64) == 64) {
                    n(m(b5, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m5 = m(b5, 31);
                    this.f20320d = m5;
                    if (m5 < 0 || m5 > this.f20319c) {
                        throw new IOException("Invalid dynamic table size update " + this.f20320d);
                    }
                    a();
                } else if (b5 == 16 || b5 == 0) {
                    q();
                } else {
                    p(m(b5, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int m(int i5, int i6) {
            int i7 = i5 & i6;
            if (i7 < i6) {
                return i7;
            }
            int i8 = 0;
            while (true) {
                int i9 = i();
                if ((i9 & 128) == 0) {
                    return i6 + (i9 << i8);
                }
                i6 += (i9 & 127) << i8;
                i8 += 7;
            }
        }

        a(int i5, int i6, Z z4) {
            this.f20317a = new ArrayList();
            c[] cVarArr = new c[8];
            this.f20321e = cVarArr;
            this.f20322f = cVarArr.length - 1;
            this.f20323g = 0;
            this.f20324h = 0;
            this.f20319c = i5;
            this.f20320d = i6;
            this.f20318b = L.d(z4);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final C2356e f20325a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f20326b;

        /* renamed from: c  reason: collision with root package name */
        private int f20327c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f20328d;

        /* renamed from: e  reason: collision with root package name */
        int f20329e;

        /* renamed from: f  reason: collision with root package name */
        int f20330f;

        /* renamed from: g  reason: collision with root package name */
        c[] f20331g;

        /* renamed from: h  reason: collision with root package name */
        int f20332h;

        /* renamed from: i  reason: collision with root package name */
        int f20333i;

        /* renamed from: j  reason: collision with root package name */
        int f20334j;

        b(C2356e eVar) {
            this(4096, true, eVar);
        }

        private void a() {
            int i5 = this.f20330f;
            int i6 = this.f20334j;
            if (i5 >= i6) {
                return;
            }
            if (i5 == 0) {
                b();
            } else {
                c(i6 - i5);
            }
        }

        private void b() {
            Arrays.fill(this.f20331g, (Object) null);
            this.f20332h = this.f20331g.length - 1;
            this.f20333i = 0;
            this.f20334j = 0;
        }

        private int c(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.f20331g.length;
                while (true) {
                    length--;
                    i6 = this.f20332h;
                    if (length < i6 || i5 <= 0) {
                        c[] cVarArr = this.f20331g;
                        System.arraycopy(cVarArr, i6 + 1, cVarArr, i6 + 1 + i7, this.f20333i);
                        c[] cVarArr2 = this.f20331g;
                        int i8 = this.f20332h;
                        Arrays.fill(cVarArr2, i8 + 1, i8 + 1 + i7, (Object) null);
                        this.f20332h += i7;
                    } else {
                        int i9 = this.f20331g[length].f20314c;
                        i5 -= i9;
                        this.f20334j -= i9;
                        this.f20333i--;
                        i7++;
                    }
                }
                c[] cVarArr3 = this.f20331g;
                System.arraycopy(cVarArr3, i6 + 1, cVarArr3, i6 + 1 + i7, this.f20333i);
                c[] cVarArr22 = this.f20331g;
                int i82 = this.f20332h;
                Arrays.fill(cVarArr22, i82 + 1, i82 + 1 + i7, (Object) null);
                this.f20332h += i7;
            }
            return i7;
        }

        private void d(c cVar) {
            int i5 = cVar.f20314c;
            int i6 = this.f20330f;
            if (i5 > i6) {
                b();
                return;
            }
            c((this.f20334j + i5) - i6);
            int i7 = this.f20333i + 1;
            c[] cVarArr = this.f20331g;
            if (i7 > cVarArr.length) {
                c[] cVarArr2 = new c[(cVarArr.length * 2)];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f20332h = this.f20331g.length - 1;
                this.f20331g = cVarArr2;
            }
            int i8 = this.f20332h;
            this.f20332h = i8 - 1;
            this.f20331g[i8] = cVar;
            this.f20333i++;
            this.f20334j += i5;
        }

        /* access modifiers changed from: package-private */
        public void e(int i5) {
            this.f20329e = i5;
            int min = Math.min(i5, 16384);
            int i6 = this.f20330f;
            if (i6 != min) {
                if (min < i6) {
                    this.f20327c = Math.min(this.f20327c, min);
                }
                this.f20328d = true;
                this.f20330f = min;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void f(C2359h hVar) {
            if (!this.f20326b || k.f().e(hVar) >= hVar.F()) {
                h(hVar.F(), 127, 0);
                this.f20325a.F(hVar);
                return;
            }
            C2356e eVar = new C2356e();
            k.f().d(hVar, eVar);
            C2359h y4 = eVar.y();
            h(y4.F(), 127, 128);
            this.f20325a.F(y4);
        }

        /* access modifiers changed from: package-private */
        public void g(List list) {
            int i5;
            int i6;
            if (this.f20328d) {
                int i7 = this.f20327c;
                if (i7 < this.f20330f) {
                    h(i7, 31, 32);
                }
                this.f20328d = false;
                this.f20327c = Integer.MAX_VALUE;
                h(this.f20330f, 31, 32);
            }
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                c cVar = (c) list.get(i8);
                C2359h J4 = cVar.f20312a.J();
                C2359h hVar = cVar.f20313b;
                Integer num = (Integer) d.f20316b.get(J4);
                if (num != null) {
                    int intValue = num.intValue();
                    i5 = intValue + 1;
                    if (i5 > 1 && i5 < 8) {
                        c[] cVarArr = d.f20315a;
                        if (c.n(cVarArr[intValue].f20313b, hVar)) {
                            i6 = i5;
                        } else if (c.n(cVarArr[i5].f20313b, hVar)) {
                            int i9 = i5;
                            i5 = intValue + 2;
                            i6 = i9;
                        }
                    }
                    i6 = i5;
                    i5 = -1;
                } else {
                    i6 = -1;
                    i5 = -1;
                }
                if (i5 == -1) {
                    int i10 = this.f20332h + 1;
                    int length = this.f20331g.length;
                    while (true) {
                        if (i10 >= length) {
                            break;
                        }
                        if (c.n(this.f20331g[i10].f20312a, J4)) {
                            if (c.n(this.f20331g[i10].f20313b, hVar)) {
                                i5 = (i10 - this.f20332h) + d.f20315a.length;
                                break;
                            } else if (i6 == -1) {
                                i6 = (i10 - this.f20332h) + d.f20315a.length;
                            }
                        }
                        i10++;
                    }
                }
                if (i5 != -1) {
                    h(i5, 127, 128);
                } else if (i6 == -1) {
                    this.f20325a.writeByte(64);
                    f(J4);
                    f(hVar);
                    d(cVar);
                } else if (!J4.G(c.f20306d) || c.f20311i.equals(J4)) {
                    h(i6, 63, 64);
                    f(hVar);
                    d(cVar);
                } else {
                    h(i6, 15, 0);
                    f(hVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i5, int i6, int i7) {
            if (i5 < i6) {
                this.f20325a.writeByte(i5 | i7);
                return;
            }
            this.f20325a.writeByte(i7 | i6);
            int i8 = i5 - i6;
            while (i8 >= 128) {
                this.f20325a.writeByte(128 | (i8 & 127));
                i8 >>>= 7;
            }
            this.f20325a.writeByte(i8);
        }

        b(int i5, boolean z4, C2356e eVar) {
            this.f20327c = Integer.MAX_VALUE;
            c[] cVarArr = new c[8];
            this.f20331g = cVarArr;
            this.f20332h = cVarArr.length - 1;
            this.f20333i = 0;
            this.f20334j = 0;
            this.f20329e = i5;
            this.f20330f = i5;
            this.f20326b = z4;
            this.f20325a = eVar;
        }
    }

    static {
        c cVar = new c(c.f20311i, "");
        C2359h hVar = c.f20308f;
        c cVar2 = new c(hVar, ShareTarget.METHOD_GET);
        c cVar3 = new c(hVar, ShareTarget.METHOD_POST);
        C2359h hVar2 = c.f20309g;
        c cVar4 = new c(hVar2, "/");
        c cVar5 = new c(hVar2, "/index.html");
        C2359h hVar3 = c.f20310h;
        c cVar6 = new c(hVar3, "http");
        c cVar7 = new c(hVar3, "https");
        C2359h hVar4 = c.f20307e;
        c cVar8 = cVar;
        c cVar9 = cVar2;
        f20315a = new c[]{cVar8, cVar9, cVar3, cVar4, cVar5, cVar6, cVar7, new c(hVar4, "200"), new c(hVar4, "204"), new c(hVar4, "206"), new c(hVar4, "304"), new c(hVar4, "400"), new c(hVar4, "404"), new c(hVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c(DownloadModel.ETAG, ""), new c("expect", ""), new c("expires", ""), new c(TypedValues.TransitionType.S_FROM, ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c(ToolBar.REFRESH, ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
    }

    static C2359h a(C2359h hVar) {
        int F4 = hVar.F();
        int i5 = 0;
        while (i5 < F4) {
            byte h5 = hVar.h(i5);
            if (h5 < 65 || h5 > 90) {
                i5++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + hVar.L());
            }
        }
        return hVar;
    }

    private static Map b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f20315a.length);
        int i5 = 0;
        while (true) {
            c[] cVarArr = f20315a;
            if (i5 >= cVarArr.length) {
                return DesugarCollections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i5].f20312a)) {
                linkedHashMap.put(cVarArr[i5].f20312a, Integer.valueOf(i5));
            }
            i5++;
        }
    }
}
