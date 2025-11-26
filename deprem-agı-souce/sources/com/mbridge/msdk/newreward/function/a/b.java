package com.mbridge.msdk.newreward.function.a;

import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f10517a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f10518b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f10519c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f10520d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static int f10521e = 4;

    /* renamed from: f  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.a.b f10522f;

    /* renamed from: g  reason: collision with root package name */
    private String f10523g;

    /* renamed from: h  reason: collision with root package name */
    private int f10524h = 21;

    /* renamed from: i  reason: collision with root package name */
    private int f10525i = f10518b;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<String> f10526j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private List<String> f10527k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private List<String> f10528l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private List<String> f10529m = new ArrayList();

    public final com.mbridge.msdk.newreward.function.c.a.b a() {
        return this.f10522f;
    }

    public final String b() {
        return this.f10523g;
    }

    public final String c() {
        ArrayList<String> arrayList = this.f10526j;
        if (arrayList == null) {
            return "";
        }
        return arrayList.toString();
    }

    public final String d() {
        List<String> list = this.f10527k;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final String e() {
        List<String> list = this.f10528l;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final String f() {
        List<String> list = this.f10529m;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final int g() {
        return this.f10524h;
    }

    public final int h() {
        return this.f10525i;
    }

    public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar) {
        this.f10522f = bVar;
    }

    public final void b(String str) {
        try {
            List<String> list = this.f10527k;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(String str) {
        try {
            ArrayList<String> arrayList = this.f10526j;
            if (arrayList != null) {
                arrayList.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void c(String str) {
        try {
            List<String> list = this.f10528l;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void d(String str) {
        this.f10523g = str;
    }

    public final void a(int i5) {
        this.f10525i = i5;
    }
}
