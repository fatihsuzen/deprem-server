package M0;

import K0.e;
import K0.f;
import K0.g;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class d implements L0.b {

    /* renamed from: e  reason: collision with root package name */
    private static final K0.d f2947e = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final f f2948f = new b();

    /* renamed from: g  reason: collision with root package name */
    private static final f f2949g = new c();

    /* renamed from: h  reason: collision with root package name */
    private static final b f2950h = new b((a) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map f2951a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map f2952b = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public K0.d f2953c = f2947e;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f2954d = false;

    class a implements K0.a {
        a() {
        }

        public void a(Object obj, Writer writer) {
            e eVar = new e(writer, d.this.f2951a, d.this.f2952b, d.this.f2953c, d.this.f2954d);
            eVar.k(obj, false);
            eVar.u();
        }

        public String b(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    private static final class b implements f {

        /* renamed from: a  reason: collision with root package name */
        private static final DateFormat f2956a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f2956a = simpleDateFormat;
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }

        private b() {
        }

        /* renamed from: b */
        public void a(Date date, g gVar) {
            gVar.b(f2956a.format(date));
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d() {
        m(String.class, f2948f);
        m(Boolean.class, f2949g);
        m(Date.class, f2950h);
    }

    public static /* synthetic */ void c(Object obj, e eVar) {
        throw new K0.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public K0.a i() {
        return new a();
    }

    public d j(L0.a aVar) {
        aVar.a(this);
        return this;
    }

    public d k(boolean z4) {
        this.f2954d = z4;
        return this;
    }

    /* renamed from: l */
    public d a(Class cls, K0.d dVar) {
        this.f2951a.put(cls, dVar);
        this.f2952b.remove(cls);
        return this;
    }

    public d m(Class cls, f fVar) {
        this.f2952b.put(cls, fVar);
        this.f2951a.remove(cls);
        return this;
    }
}
