package t3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;
import kotlin.jvm.internal.t;

/* renamed from: t3.d  reason: case insensitive filesystem */
public final class C2780d {

    /* renamed from: a  reason: collision with root package name */
    public static final C2780d f25887a = new C2780d();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f25888b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f25889c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f25890d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f25891e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f25892f;

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f25893g;

    static {
        Charset forName = Charset.forName(C.UTF8_NAME);
        t.d(forName, "forName(...)");
        f25888b = forName;
        Charset forName2 = Charset.forName(C.UTF16_NAME);
        t.d(forName2, "forName(...)");
        f25889c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        t.d(forName3, "forName(...)");
        f25890d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        t.d(forName4, "forName(...)");
        f25891e = forName4;
        Charset forName5 = Charset.forName(C.ASCII_NAME);
        t.d(forName5, "forName(...)");
        f25892f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        t.d(forName6, "forName(...)");
        f25893g = forName6;
    }

    private C2780d() {
    }
}
