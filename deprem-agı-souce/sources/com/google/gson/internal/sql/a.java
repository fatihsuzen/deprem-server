package com.google.gson.internal.sql;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.u;
import java.sql.Date;
import java.sql.Timestamp;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7764a;

    /* renamed from: b  reason: collision with root package name */
    public static final DefaultDateTypeAdapter.a f7765b;

    /* renamed from: c  reason: collision with root package name */
    public static final DefaultDateTypeAdapter.a f7766c;

    /* renamed from: d  reason: collision with root package name */
    public static final u f7767d;

    /* renamed from: e  reason: collision with root package name */
    public static final u f7768e;

    /* renamed from: f  reason: collision with root package name */
    public static final u f7769f;

    /* renamed from: com.google.gson.internal.sql.a$a  reason: collision with other inner class name */
    class C0078a extends DefaultDateTypeAdapter.a {
        C0078a(Class cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Date a(java.util.Date date) {
            return new Date(date.getTime());
        }
    }

    class b extends DefaultDateTypeAdapter.a {
        b(Class cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public Timestamp a(java.util.Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z4;
        try {
            Class.forName("java.sql.Date");
            z4 = true;
        } catch (ClassNotFoundException unused) {
            z4 = false;
        }
        f7764a = z4;
        if (z4) {
            f7765b = new C0078a(Date.class);
            f7766c = new b(Timestamp.class);
            f7767d = SqlDateTypeAdapter.f7758b;
            f7768e = SqlTimeTypeAdapter.f7760b;
            f7769f = SqlTimestampTypeAdapter.f7762b;
            return;
        }
        f7765b = null;
        f7766c = null;
        f7767d = null;
        f7768e = null;
        f7769f = null;
    }
}
