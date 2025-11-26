package t3;

import X2.C2235b;
import X2.C2236c;
import X2.C2250q;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.t;
import q3.C2728d;
import s3.C2754h;

/* renamed from: t3.m  reason: case insensitive filesystem */
final class C2789m implements C2788l {

    /* renamed from: a  reason: collision with root package name */
    private final Matcher f25942a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f25943b;

    /* renamed from: c  reason: collision with root package name */
    private final C2787k f25944c = new b(this);

    /* renamed from: d  reason: collision with root package name */
    private List f25945d;

    /* renamed from: t3.m$a */
    public static final class a extends C2236c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2789m f25946a;

        a(C2789m mVar) {
            this.f25946a = mVar;
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof String)) {
                return false;
            }
            return g((String) obj);
        }

        public /* bridge */ boolean g(String str) {
            return super.contains(str);
        }

        public int getSize() {
            return this.f25946a.d().groupCount() + 1;
        }

        /* renamed from: i */
        public String get(int i5) {
            String group = this.f25946a.d().group(i5);
            if (group == null) {
                return "";
            }
            return group;
        }

        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return j((String) obj);
        }

        public /* bridge */ int j(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int k(String str) {
            return super.lastIndexOf(str);
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof String)) {
                return -1;
            }
            return k((String) obj);
        }
    }

    /* renamed from: t3.m$b */
    public static final class b extends C2235b implements C2787k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2789m f25947a;

        b(C2789m mVar) {
            this.f25947a = mVar;
        }

        /* access modifiers changed from: private */
        public static final C2786j k(b bVar, int i5) {
            return bVar.j(i5);
        }

        public final /* bridge */ boolean contains(Object obj) {
            boolean z4;
            if (obj == null) {
                z4 = true;
            } else {
                z4 = obj instanceof C2786j;
            }
            if (!z4) {
                return false;
            }
            return i((C2786j) obj);
        }

        public int getSize() {
            return this.f25947a.d().groupCount() + 1;
        }

        public /* bridge */ boolean i(C2786j jVar) {
            return super.contains(jVar);
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator iterator() {
            return C2754h.v(C2250q.D(C2250q.h(this)), new C2790n(this)).iterator();
        }

        public C2786j j(int i5) {
            C2728d c5 = q.f(this.f25947a.d(), i5);
            if (c5.getStart().intValue() < 0) {
                return null;
            }
            String group = this.f25947a.d().group(i5);
            t.d(group, "group(...)");
            return new C2786j(group, c5);
        }
    }

    public C2789m(Matcher matcher, CharSequence charSequence) {
        t.e(matcher, "matcher");
        t.e(charSequence, "input");
        this.f25942a = matcher;
        this.f25943b = charSequence;
    }

    /* access modifiers changed from: private */
    public final MatchResult d() {
        return this.f25942a;
    }

    public List a() {
        if (this.f25945d == null) {
            this.f25945d = new a(this);
        }
        List list = this.f25945d;
        t.b(list);
        return list;
    }

    public C2728d b() {
        return q.e(d());
    }

    public String getValue() {
        String group = d().group();
        t.d(group, "group(...)");
        return group;
    }

    public C2788l next() {
        int i5;
        int end = d().end();
        if (d().end() == d().start()) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        int i6 = end + i5;
        if (i6 > this.f25943b.length()) {
            return null;
        }
        Matcher matcher = this.f25942a.pattern().matcher(this.f25943b);
        t.d(matcher, "matcher(...)");
        return q.d(matcher, i6, this.f25943b);
    }
}
