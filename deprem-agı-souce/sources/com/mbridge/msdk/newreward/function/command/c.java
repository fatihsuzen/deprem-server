package com.mbridge.msdk.newreward.function.command;

import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private a f10684a;

    /* renamed from: b  reason: collision with root package name */
    private a f10685b;

    public final void a(a aVar) {
        this.f10684a = aVar;
    }

    public final void b(a aVar) {
        if (this.f10685b == null) {
            this.f10685b = aVar;
        }
    }

    public final Object c(Object obj, f fVar) {
        if (this.f10684a == null) {
            return Boolean.FALSE;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f10684a.a(bVar).a();
    }

    public final void d(Object obj) throws MBridgeError {
        if (this.f10684a != null) {
            b bVar = new b();
            bVar.a(f.CHECK_CAMPAIGN_EXCLUDE_INS);
            bVar.a(obj);
            e a5 = this.f10684a.a(bVar);
            if (!a5.b()) {
                throw ((MBridgeError) a5.a());
            }
        }
    }

    public final void e(Object obj) {
        if (this.f10684a != null) {
            b bVar = new b();
            bVar.a(obj);
            bVar.a(f.HANDLER_ALREADY_INSTALL_CAMPAIGN);
            this.f10684a.a(bVar);
        }
    }

    public final void f(Object obj) {
        b bVar = new b();
        bVar.a(obj);
        bVar.a(f.START_LOAD_CHECK);
        this.f10684a.a(bVar);
    }

    public final Object g(Object obj, f fVar) {
        if (this.f10685b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f10685b.a(bVar).a();
    }

    public final Object h(Object obj, f fVar) {
        if (this.f10685b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f10685b.a(bVar).a();
    }

    public final Object i(Object obj, f fVar) {
        if (this.f10685b == null) {
            this.f10685b = new com.mbridge.msdk.newreward.function.command.a.c();
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f10685b.a(bVar).a();
    }

    public final Map a(Object... objArr) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (objArr.length % 2 == 0) {
            for (int i5 = 0; i5 < objArr.length; i5++) {
                if (i5 % 2 == 0) {
                    Object obj = objArr[i5];
                    Object obj2 = objArr[i5 + 1];
                    if (obj == null) {
                        obj = "";
                    }
                    if (obj2 == null) {
                        obj2 = "";
                    }
                    concurrentHashMap.put(obj, obj2);
                }
            }
        }
        return concurrentHashMap;
    }

    public final void b(Object obj, b bVar) {
        if (this.f10684a != null) {
            b bVar2 = new b();
            bVar2.a(obj);
            bVar2.a(f.SMART_LOAD);
            this.f10684a.a(bVar2, bVar);
        }
    }

    public final Object f(Object obj, f fVar) {
        if (this.f10685b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f10685b.a(bVar).a();
    }

    public final void c(Object obj) throws MBridgeError {
        if (this.f10684a != null) {
            b bVar = new b();
            bVar.a(f.CHECK_CAMPAIGN);
            bVar.a(obj);
            e a5 = this.f10684a.a(bVar);
            if (!a5.b()) {
                throw ((MBridgeError) a5.a());
            }
        }
    }

    public final Object e(Object obj, f fVar) {
        if (this.f10685b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f10685b.a(bVar).a();
    }

    public final Object b(Object obj) {
        if (this.f10684a == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(obj);
        bVar.a(f.CANDIDATE_LOAD_ACTION);
        return this.f10684a.a(bVar).a();
    }

    public final Object d(Object obj, f fVar) {
        if (this.f10685b == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f10685b.a(bVar).a();
    }

    public final Object a(Object obj, f fVar) {
        if (this.f10684a == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(obj);
        bVar.a(fVar);
        return this.f10684a.a(bVar).a();
    }

    public final void e(Object obj, b bVar) {
        if (this.f10685b != null) {
            b bVar2 = new b();
            bVar2.a((f) ((Map) obj).get("command_type"));
            bVar2.a(obj);
            this.f10685b.a(bVar2, bVar);
        }
    }

    public final Object b(Object obj, f fVar) {
        if (this.f10684a == null) {
            return Boolean.FALSE;
        }
        b bVar = new b();
        bVar.a(fVar);
        bVar.a(obj);
        return this.f10684a.a(bVar).a();
    }

    public final void c(Object obj, b bVar) {
        if (this.f10684a != null) {
            b bVar2 = new b();
            bVar2.a(obj);
            bVar2.a((f) ((Map) obj).get("command_type"));
            this.f10684a.a(bVar2, bVar);
        }
    }

    public final void d(Object obj, b bVar) {
        if (this.f10685b != null) {
            b bVar2 = new b();
            bVar2.a(obj);
            bVar2.a((f) ((Map) obj).get("command_type"));
            this.f10685b.a(bVar2, bVar);
        }
    }

    public final void a(Object obj, f fVar, b bVar) {
        if (this.f10684a != null) {
            b bVar2 = new b();
            bVar2.a(obj);
            bVar2.a(fVar);
            this.f10684a.a(bVar2, bVar);
        }
    }

    public final void a(Object obj, b bVar) {
        if (this.f10684a != null) {
            b bVar2 = new b();
            bVar2.a(obj);
            bVar2.a(f.NORMAL_LOAD);
            this.f10684a.a(bVar2, bVar);
        }
    }

    public final void a(Object obj) {
        if (this.f10684a != null) {
            b bVar = new b();
            bVar.a(f.SHOW);
            bVar.a(obj);
            this.f10684a.a(bVar);
        }
    }

    public final void a(Object obj, f fVar, Object obj2) {
        b bVar = new b();
        bVar.a(obj2);
        bVar.a(fVar);
        new com.mbridge.msdk.newreward.function.command.a.b(obj).a(bVar);
    }

    public final void a(Object obj, String str) {
        if (this.f10685b == null) {
            this.f10685b = new com.mbridge.msdk.newreward.function.command.a.c();
        }
        b bVar = new b();
        bVar.a(obj);
        this.f10685b.a(bVar, str);
    }
}
