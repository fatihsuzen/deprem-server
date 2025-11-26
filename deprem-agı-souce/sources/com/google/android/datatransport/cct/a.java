package com.google.android.datatransport.cct;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.DesugarCollections;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import p.C1745c;
import r.g;

public final class a implements g {

    /* renamed from: c  reason: collision with root package name */
    static final String f4766c;

    /* renamed from: d  reason: collision with root package name */
    static final String f4767d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f4768e;

    /* renamed from: f  reason: collision with root package name */
    private static final Set f4769f = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(new C1745c[]{C1745c.b("proto"), C1745c.b("json")})));

    /* renamed from: g  reason: collision with root package name */
    public static final a f4770g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f4771h;

    /* renamed from: a  reason: collision with root package name */
    private final String f4772a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4773b;

    static {
        String a5 = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f4766c = a5;
        String a6 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f4767d = a6;
        String a7 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f4768e = a7;
        f4770g = new a(a5, (String) null);
        f4771h = new a(a6, a7);
    }

    public a(String str, String str2) {
        this.f4772a = str;
        this.f4773b = str2;
    }

    public static a c(byte[] bArr) {
        String str = new String(bArr, Charset.forName(C.UTF8_NAME));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new a(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    public Set a() {
        return f4769f;
    }

    public byte[] b() {
        String str = this.f4773b;
        if (str == null && this.f4772a == null) {
            return null;
        }
        String str2 = this.f4772a;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", new Object[]{"1$", str2, "\\", str}).getBytes(Charset.forName(C.UTF8_NAME));
    }

    public String d() {
        return this.f4773b;
    }

    public String e() {
        return this.f4772a;
    }

    public byte[] getExtras() {
        return b();
    }

    public String getName() {
        return "cct";
    }
}
