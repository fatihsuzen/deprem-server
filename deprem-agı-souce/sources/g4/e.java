package g4;

import android.content.SharedPreferences;
import androidx.core.os.EnvironmentCompat;
import h4.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;
import p4.a;

public class e {

    /* renamed from: q  reason: collision with root package name */
    private static final String f22228q = b.i(e.class);

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f22229r = Pattern.compile("^(\\w+)(?:://)(.+?)$");

    /* renamed from: s  reason: collision with root package name */
    private static final Pattern f22230s = Pattern.compile("^[0-9a-f]{16}$");

    /* renamed from: a  reason: collision with root package name */
    private final b f22231a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22232b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22233c;

    /* renamed from: d  reason: collision with root package name */
    private final String f22234d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f22235e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final h4.e f22236f;

    /* renamed from: g  reason: collision with root package name */
    private final String f22237g;

    /* renamed from: h  reason: collision with root package name */
    private final Random f22238h = new Random(new Date().getTime());

    /* renamed from: i  reason: collision with root package name */
    private final d f22239i;

    /* renamed from: j  reason: collision with root package name */
    private d f22240j;

    /* renamed from: k  reason: collision with root package name */
    private long f22241k;

    /* renamed from: l  reason: collision with root package name */
    private long f22242l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f22243m;

    /* renamed from: n  reason: collision with root package name */
    private SharedPreferences f22244n;

    /* renamed from: o  reason: collision with root package name */
    private final LinkedHashSet f22245o;

    /* renamed from: p  reason: collision with root package name */
    private d f22246p;

    protected e(b bVar, f fVar) {
        String str;
        d dVar = new d();
        this.f22239i = dVar;
        this.f22241k = 1800000;
        this.f22242l = 0;
        this.f22245o = new LinkedHashSet();
        this.f22231a = bVar;
        this.f22232b = fVar.c();
        this.f22233c = fVar.e();
        this.f22237g = fVar.f();
        this.f22234d = fVar.d();
        new a(bVar).a(this);
        this.f22243m = g().getBoolean("tracker.optout", false);
        h4.e a5 = bVar.e().a(this);
        this.f22236f = a5;
        a5.a(b());
        dVar.c(c.USER_ID, g().getString("tracker.userid", (String) null));
        String string = g().getString("tracker.visitorid", (String) null);
        if (string == null) {
            string = j();
            g().edit().putString("tracker.visitorid", string).apply();
        }
        dVar.c(c.VISITOR_ID, string);
        dVar.c(c.SESSION_START, "1");
        j4.d d5 = bVar.d();
        int[] a6 = d5.a();
        if (a6 != null) {
            str = String.format("%sx%s", new Object[]{Integer.valueOf(a6[0]), Integer.valueOf(a6[1])});
        } else {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        dVar.c(c.SCREEN_RESOLUTION, str);
        dVar.c(c.USER_AGENT, d5.b());
        dVar.c(c.LANGUAGE, d5.c());
        dVar.c(c.URL_PATH, fVar.d());
    }

    private void h(d dVar) {
        dVar.f(c.SITE_ID, this.f22233c);
        dVar.h(c.RECORD, "1");
        dVar.h(c.API_VERSION, "1");
        dVar.f(c.RANDOM_NUMBER, this.f22238h.nextInt(DefaultOggSeeker.MATCH_BYTE_RANGE));
        dVar.h(c.DATETIME_OF_REQUEST, new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.US).format(new Date()));
        dVar.h(c.SEND_IMAGE, "0");
        c cVar = c.VISITOR_ID;
        dVar.h(cVar, this.f22239i.a(cVar));
        c cVar2 = c.USER_ID;
        dVar.h(cVar2, this.f22239i.a(cVar2));
        c cVar3 = c.SCREEN_RESOLUTION;
        dVar.h(cVar3, this.f22239i.a(cVar3));
        c cVar4 = c.USER_AGENT;
        dVar.h(cVar4, this.f22239i.a(cVar4));
        c cVar5 = c.LANGUAGE;
        dVar.h(cVar5, this.f22239i.a(cVar5));
        c cVar6 = c.URL_PATH;
        String a5 = dVar.a(cVar6);
        if (a5 == null) {
            a5 = this.f22239i.a(cVar6);
        } else if (!f22229r.matcher(a5).matches()) {
            StringBuilder sb = new StringBuilder(this.f22234d);
            if (!this.f22234d.endsWith("/") && !a5.startsWith("/")) {
                sb.append("/");
            } else if (this.f22234d.endsWith("/") && a5.startsWith("/")) {
                a5 = a5.substring(1);
            }
            sb.append(a5);
            a5 = sb.toString();
        }
        this.f22239i.c(cVar6, a5);
        dVar.c(cVar6, a5);
    }

    private void i(d dVar) {
        long j5;
        long j6;
        long j7;
        d dVar2 = dVar;
        SharedPreferences g5 = g();
        synchronized (g5) {
            try {
                SharedPreferences.Editor edit = g5.edit();
                j5 = g().getLong("tracker.visitcount", 0) + 1;
                edit.putLong("tracker.visitcount", j5);
                j6 = g5.getLong("tracker.firstvisit", -1);
                if (j6 == -1) {
                    j6 = System.currentTimeMillis() / 1000;
                    edit.putLong("tracker.firstvisit", j6);
                }
                j7 = g5.getLong("tracker.previousvisit", -1);
                edit.putLong("tracker.previousvisit", System.currentTimeMillis() / 1000);
                edit.apply();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        d dVar3 = this.f22239i;
        c cVar = c.FIRST_VISIT_TIMESTAMP;
        dVar3.g(cVar, j6);
        d dVar4 = this.f22239i;
        c cVar2 = c.TOTAL_NUMBER_OF_VISITS;
        dVar4.g(cVar2, j5);
        if (j7 != -1) {
            this.f22239i.g(c.PREVIOUS_VISIT_TIMESTAMP, j7);
        }
        c cVar3 = c.SESSION_START;
        dVar2.h(cVar3, this.f22239i.a(cVar3));
        dVar2.h(cVar, this.f22239i.a(cVar));
        dVar2.h(cVar2, this.f22239i.a(cVar2));
        c cVar4 = c.PREVIOUS_VISIT_TIMESTAMP;
        dVar2.h(cVar4, this.f22239i.a(cVar4));
    }

    public static String j() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
    }

    public String a() {
        return this.f22232b;
    }

    public d b() {
        if (this.f22246p == null) {
            d b5 = d.b(g().getString("tracker.dispatcher.mode", (String) null));
            this.f22246p = b5;
            if (b5 == null) {
                this.f22246p = d.ALWAYS;
            }
        }
        return this.f22246p;
    }

    public b c() {
        return this.f22231a;
    }

    public String d() {
        return this.f22237g;
    }

    public long e() {
        return g().getLong("tracker.cache.age", 86400000);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f22233c == eVar.f22233c && this.f22232b.equals(eVar.f22232b)) {
            return this.f22237g.equals(eVar.f22237g);
        }
        return false;
    }

    public long f() {
        return g().getLong("tracker.cache.size", 4194304);
    }

    public SharedPreferences g() {
        if (this.f22244n == null) {
            this.f22244n = this.f22231a.h(this);
        }
        return this.f22244n;
    }

    public int hashCode() {
        return (((this.f22232b.hashCode() * 31) + this.f22233c) * 31) + this.f22237g.hashCode();
    }

    public e k(d dVar) {
        synchronized (this.f22235e) {
            try {
                if (System.currentTimeMillis() - this.f22242l > this.f22241k) {
                    this.f22242l = System.currentTimeMillis();
                    i(dVar);
                }
                h(dVar);
                Iterator it = this.f22245o.iterator();
                if (!it.hasNext()) {
                    this.f22240j = dVar;
                    if (!this.f22243m) {
                        this.f22236f.b(dVar);
                        a.b(f22228q).a("Event added to the queue: %s", dVar);
                    } else {
                        a.b(f22228q).a("Event omitted due to opt out: %s", dVar);
                    }
                } else {
                    android.support.v4.media.a.a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }
}
