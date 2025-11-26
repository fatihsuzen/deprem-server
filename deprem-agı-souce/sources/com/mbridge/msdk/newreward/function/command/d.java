package com.mbridge.msdk.newreward.function.command;

import com.mbridge.msdk.newreward.a.e;
import java.util.HashMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f10686a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, e> f10687b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private c f10688c;

    private d() {
    }

    public static d a() {
        if (f10686a == null) {
            synchronized (d.class) {
                try {
                    if (f10686a == null) {
                        f10686a = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10686a;
    }

    public final c b() {
        return this.f10688c;
    }

    public final void b(String str) {
        this.f10687b.remove(str);
    }

    public final void a(c cVar) {
        this.f10688c = cVar;
    }

    public final e a(String str) {
        return this.f10687b.get(str);
    }

    public final void a(e eVar) {
        if (this.f10687b.get(eVar.G()) == null) {
            this.f10687b.put(eVar.G(), eVar);
        }
    }
}
