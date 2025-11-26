package g4;

import java.net.MalformedURLException;
import java.net.URL;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final String f22247a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22248b;

    /* renamed from: c  reason: collision with root package name */
    private String f22249c;

    /* renamed from: d  reason: collision with root package name */
    private String f22250d;

    public f(String str, int i5, String str2) {
        try {
            new URL(str);
            this.f22247a = str;
            this.f22248b = i5;
            this.f22249c = str2;
        } catch (MalformedURLException e5) {
            throw new RuntimeException(e5);
        }
    }

    public static f b(String str, int i5) {
        return new f(str, i5, "Default Tracker");
    }

    public e a(b bVar) {
        if (this.f22250d == null) {
            this.f22250d = String.format("https://%s/", new Object[]{bVar.c().getPackageName()});
        }
        return new e(bVar, this);
    }

    public String c() {
        return this.f22247a;
    }

    public String d() {
        return this.f22250d;
    }

    public int e() {
        return this.f22248b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f22248b != fVar.f22248b || !this.f22247a.equals(fVar.f22247a) || !this.f22249c.equals(fVar.f22249c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.f22249c;
    }

    public int hashCode() {
        return (((this.f22247a.hashCode() * 31) + this.f22248b) * 31) + this.f22249c.hashCode();
    }
}
