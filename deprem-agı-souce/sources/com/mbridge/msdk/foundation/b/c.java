package com.mbridge.msdk.foundation.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f8790a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f8791b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f8792c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f8793d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static int f8794e = 4;

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f8795f;

    /* renamed from: g  reason: collision with root package name */
    private String f8796g;

    /* renamed from: h  reason: collision with root package name */
    private int f8797h = 21;

    /* renamed from: i  reason: collision with root package name */
    private int f8798i = f8791b;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<String> f8799j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private List<String> f8800k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private List<String> f8801l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private List<String> f8802m = new ArrayList();

    public final CopyOnWriteArrayList<CampaignEx> a() {
        return this.f8795f;
    }

    public final String b() {
        return this.f8796g;
    }

    public final String c() {
        ArrayList<String> arrayList = this.f8799j;
        if (arrayList == null) {
            return "";
        }
        return arrayList.toString();
    }

    public final String d() {
        List<String> list = this.f8800k;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final String e() {
        List<String> list = this.f8801l;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final String f() {
        List<String> list = this.f8802m;
        if (list == null) {
            return "";
        }
        return list.toString();
    }

    public final int g() {
        return this.f8798i;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f8795f = copyOnWriteArrayList;
    }

    public final void b(String str) {
        try {
            List<String> list = this.f8800k;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(String str) {
        try {
            ArrayList<String> arrayList = this.f8799j;
            if (arrayList != null) {
                arrayList.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void c(String str) {
        try {
            List<String> list = this.f8801l;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void d(String str) {
        this.f8796g = str;
    }

    public final void a(int i5) {
        this.f8798i = i5;
    }
}
