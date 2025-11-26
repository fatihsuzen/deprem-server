package t3;

import X2.C2250q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.C2639q;
import kotlin.jvm.internal.t;
import q3.C2729e;
import s3.C2751e;
import s3.C2754h;

public final class p implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f25952b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Pattern f25953a;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final int b(int i5) {
            if ((i5 & 2) != 0) {
                return i5 | 64;
            }
            return i5;
        }

        private a() {
        }
    }

    /* synthetic */ class b extends C2639q implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f25954a = new b();

        b() {
            super(1, C2788l.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        /* renamed from: g */
        public final C2788l invoke(C2788l lVar) {
            t.e(lVar, "p0");
            return lVar.next();
        }
    }

    public p(Pattern pattern) {
        t.e(pattern, "nativePattern");
        this.f25953a = pattern;
    }

    public static /* synthetic */ C2788l c(p pVar, CharSequence charSequence, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        return pVar.b(charSequence, i5);
    }

    public static /* synthetic */ C2751e e(p pVar, CharSequence charSequence, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        return pVar.d(charSequence, i5);
    }

    /* access modifiers changed from: private */
    public static final C2788l f(p pVar, CharSequence charSequence, int i5) {
        return pVar.b(charSequence, i5);
    }

    public final C2788l b(CharSequence charSequence, int i5) {
        t.e(charSequence, "input");
        Matcher matcher = this.f25953a.matcher(charSequence);
        t.d(matcher, "matcher(...)");
        return q.d(matcher, i5, charSequence);
    }

    public final C2751e d(CharSequence charSequence, int i5) {
        t.e(charSequence, "input");
        if (i5 >= 0 && i5 <= charSequence.length()) {
            return C2754h.g(new C2791o(this, charSequence, i5), b.f25954a);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i5 + ", input length: " + charSequence.length());
    }

    public final boolean g(CharSequence charSequence) {
        t.e(charSequence, "input");
        return this.f25953a.matcher(charSequence).matches();
    }

    public final String h(CharSequence charSequence, String str) {
        t.e(charSequence, "input");
        t.e(str, "replacement");
        String replaceAll = this.f25953a.matcher(charSequence).replaceAll(str);
        t.d(replaceAll, "replaceAll(...)");
        return replaceAll;
    }

    public final String i(CharSequence charSequence, l lVar) {
        t.e(charSequence, "input");
        t.e(lVar, "transform");
        int i5 = 0;
        C2788l c5 = c(this, charSequence, 0, 2, (Object) null);
        if (c5 == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, i5, c5.b().getStart().intValue());
            sb.append((CharSequence) lVar.invoke(c5));
            i5 = c5.b().getEndInclusive().intValue() + 1;
            c5 = c5.next();
            if (i5 >= length) {
                break;
            }
        } while (c5 != null);
        if (i5 < length) {
            sb.append(charSequence, i5, length);
        }
        String sb2 = sb.toString();
        t.d(sb2, "toString(...)");
        return sb2;
    }

    public final List j(CharSequence charSequence, int i5) {
        t.e(charSequence, "input");
        C2771H.B0(i5);
        Matcher matcher = this.f25953a.matcher(charSequence);
        if (i5 == 1 || !matcher.find()) {
            return C2250q.d(charSequence.toString());
        }
        int i6 = 10;
        if (i5 > 0) {
            i6 = C2729e.e(i5, 10);
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = i5 - 1;
        int i8 = 0;
        do {
            arrayList.add(charSequence.subSequence(i8, matcher.start()).toString());
            i8 = matcher.end();
            if ((i7 >= 0 && arrayList.size() == i7) || !matcher.find()) {
                arrayList.add(charSequence.subSequence(i8, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i8, matcher.start()).toString());
            i8 = matcher.end();
            break;
        } while (!matcher.find());
        arrayList.add(charSequence.subSequence(i8, charSequence.length()).toString());
        return arrayList;
    }

    public String toString() {
        String pattern = this.f25953a.toString();
        t.d(pattern, "toString(...)");
        return pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.t.e(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(...)"
            kotlin.jvm.internal.t.d(r2, r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.p.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p(java.lang.String r2, t3.r r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.t.e(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.t.e(r3, r0)
            t3.p$a r0 = f25952b
            int r3 = r3.b()
            int r3 = r0.b(r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(...)"
            kotlin.jvm.internal.t.d(r2, r3)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.p.<init>(java.lang.String, t3.r):void");
    }
}
