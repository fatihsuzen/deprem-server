package x0;

import D0.g;
import j$.util.Objects;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: x0.m  reason: case insensitive filesystem */
class C1917m {

    /* renamed from: d  reason: collision with root package name */
    private static final FilenameFilter f16881d = new C1915k();

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator f16882e = new C1916l();

    /* renamed from: a  reason: collision with root package name */
    private final g f16883a;

    /* renamed from: b  reason: collision with root package name */
    private String f16884b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f16885c = null;

    C1917m(g gVar) {
        this.f16883a = gVar;
    }

    private static void d(g gVar, String str, String str2) {
        if (str != null && str2 != null) {
            try {
                gVar.q(str, "aqs." + str2).createNewFile();
            } catch (IOException e5) {
                u0.g.f().l("Failed to persist App Quality Sessions session id.", e5);
            }
        }
    }

    static String e(g gVar, String str) {
        List r5 = gVar.r(str, f16881d);
        if (!r5.isEmpty()) {
            return ((File) Collections.min(r5, f16882e)).getName().substring(4);
        }
        u0.g.f().k("Unable to read App Quality Sessions session id.");
        return null;
    }

    public synchronized String c(String str) {
        if (Objects.equals(this.f16884b, str)) {
            return this.f16885c;
        }
        return e(this.f16883a, str);
    }

    public synchronized void f(String str) {
        if (!Objects.equals(this.f16885c, str)) {
            d(this.f16883a, this.f16884b, str);
            this.f16885c = str;
        }
    }

    public synchronized void g(String str) {
        if (!Objects.equals(this.f16884b, str)) {
            d(this.f16883a, str, this.f16885c);
            this.f16884b = str;
        }
    }
}
