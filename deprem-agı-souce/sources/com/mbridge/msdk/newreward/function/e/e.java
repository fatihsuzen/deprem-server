package com.mbridge.msdk.newreward.function.e;

import com.mbridge.msdk.newreward.a.b.d;
import com.mbridge.msdk.newreward.a.b.f;
import com.mbridge.msdk.newreward.a.b.g;
import com.mbridge.msdk.newreward.a.b.h;
import com.mbridge.msdk.newreward.a.b.j;
import com.mbridge.msdk.newreward.a.b.k;
import com.mbridge.msdk.newreward.a.b.n;
import com.mbridge.msdk.newreward.function.d.c;
import java.io.IOException;
import java.util.HashMap;

public final class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, b> f10961a = new HashMap<>();

    private static class a implements com.mbridge.msdk.newreward.a.b.b {

        /* renamed from: a  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.b f10962a;

        /* renamed from: b  reason: collision with root package name */
        private final e f10963b;

        /* renamed from: c  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f10964c;

        public a(com.mbridge.msdk.newreward.function.c.a.b bVar, e eVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
            this.f10962a = bVar;
            this.f10963b = eVar;
            this.f10964c = bVar2;
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            com.mbridge.msdk.newreward.function.c.a.b bVar2 = this.f10962a;
            com.mbridge.msdk.newreward.a.b.b bVar3 = this.f10964c;
            if (this.f10963b.f10961a.containsKey(bVar2.f()) && this.f10963b.f10961a.get(bVar2.f()) != null && !((b) this.f10963b.f10961a.get(bVar2.f())).a()) {
                return;
            }
            if (bVar2.y()) {
                if (this.f10963b.f10961a.containsKey(bVar2.f()) && this.f10963b.f10961a.get(bVar2.f()) != null) {
                    ((b) this.f10963b.f10961a.get(bVar2.f())).b(true);
                }
                c.a().b().a(bVar2.c(), bVar2.d(), bVar2.e(), bVar2.g(), 3, this.f10962a);
                bVar3.reqSuccessful(bVar2);
                return;
            }
            if (this.f10963b.f10961a.containsKey(bVar2.f()) && this.f10963b.f10961a.get(bVar2.f()) != null) {
                ((b) this.f10963b.f10961a.get(bVar2.f())).a(true);
            }
            bVar3.reqFailed(bVar);
        }

        public final void reqSuccessful(Object obj) {
            com.mbridge.msdk.newreward.function.c.a.b bVar = this.f10962a;
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f10964c;
            if ((!this.f10963b.f10961a.containsKey(bVar.f()) || this.f10963b.f10961a.get(bVar.f()) == null || ((b) this.f10963b.f10961a.get(bVar.f())).a()) && bVar.y()) {
                if (this.f10963b.f10961a.containsKey(bVar.f()) && this.f10963b.f10961a.get(bVar.f()) != null) {
                    ((b) this.f10963b.f10961a.get(bVar.f())).b(true);
                }
                c.a().b().a(bVar.c(), bVar.d(), bVar.e(), bVar.g(), 3, this.f10962a);
                bVar2.reqSuccessful(bVar);
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f10965a;

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f10966b;

        private b() {
            this.f10965a = false;
            this.f10966b = false;
        }

        public final void a(boolean z4) {
            this.f10966b = z4;
        }

        public final void b(boolean z4) {
            this.f10965a = z4;
        }

        public final boolean a() {
            return !this.f10965a && !this.f10966b;
        }
    }

    public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        this.f10961a.put(bVar.f(), new b());
        a aVar = new a(bVar, this, bVar2);
        try {
            new d().a(bVar, aVar);
        } catch (IOException e5) {
            aVar.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e5.getMessage()));
        }
        for (com.mbridge.msdk.newreward.function.c.a.a next : bVar.u()) {
            a aVar2 = new a(bVar, this, bVar2);
            try {
                new n().a(next, aVar2);
            } catch (IOException e6) {
                aVar2.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e6.getMessage()));
            }
            a aVar3 = new a(bVar, this, bVar2);
            try {
                new com.mbridge.msdk.newreward.a.b.e().a(next, aVar3);
            } catch (IOException e7) {
                aVar3.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e7.getMessage()));
            }
            a aVar4 = new a(bVar, this, bVar2);
            try {
                new f().a(next, aVar4);
            } catch (IOException e8) {
                aVar4.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e8.getMessage()));
            }
            a aVar5 = new a(bVar, this, bVar2);
            try {
                new h().a(next, aVar5);
            } catch (IOException e9) {
                aVar5.reqFailed(new com.mbridge.msdk.foundation.c.b(880020, e9.getMessage()));
            }
            a aVar6 = new a(bVar, this, bVar2);
            try {
                new j().a(next, aVar6);
            } catch (IOException e10) {
                aVar6.reqFailed(new com.mbridge.msdk.foundation.c.b(880000, e10.getMessage()));
            }
            a aVar7 = new a(bVar, this, bVar2);
            try {
                new g().a(next, aVar7);
            } catch (IOException e11) {
                aVar7.reqFailed(new com.mbridge.msdk.foundation.c.b(880000, e11.getMessage()));
            }
            a aVar8 = new a(bVar, this, bVar2);
            try {
                new k().a(next, aVar8);
            } catch (IOException e12) {
                aVar8.reqFailed(new com.mbridge.msdk.foundation.c.b(880000, e12.getMessage()));
            }
        }
    }
}
