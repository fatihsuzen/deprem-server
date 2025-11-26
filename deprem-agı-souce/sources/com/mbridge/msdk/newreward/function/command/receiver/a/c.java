package com.mbridge.msdk.newreward.function.command.receiver.a;

import com.mbridge.msdk.newreward.a.b.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.a.a f10762a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f10763b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b f10764c;

    /* renamed from: d  reason: collision with root package name */
    private d f10765d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f10766e = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f10767f = false;

    private class a implements b {

        /* renamed from: b  reason: collision with root package name */
        private final c f10771b;

        /* renamed from: c  reason: collision with root package name */
        private final b f10772c;

        public a(c cVar, b bVar) {
            this.f10771b = cVar;
            this.f10772c = bVar;
        }

        public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            if (bVar.a() == 1) {
                if (c.this.f10763b.a() && c.this.f10764c.a() && !this.f10771b.f10767f) {
                    boolean unused = this.f10771b.f10767f = true;
                } else {
                    return;
                }
            }
            this.f10772c.reqFailed(bVar);
        }

        public final void reqSuccessful(Object obj) {
            if (!this.f10771b.f10766e) {
                boolean unused = this.f10771b.f10766e = true;
                this.f10772c.reqSuccessful(obj);
            }
        }
    }

    public c(com.mbridge.msdk.newreward.function.command.a.a aVar) {
        this.f10762a = aVar;
    }

    public final void a(e eVar, final b bVar) {
        int c5 = eVar.c();
        if (c5 == 1) {
            if (this.f10763b == null) {
                a();
            }
            this.f10763b.a(eVar, (b) new a(this, bVar));
        } else if (c5 == 2) {
            if (this.f10765d == null) {
                this.f10765d = new d();
            }
            this.f10765d.a(eVar, new b() {
                public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.reqFailed(bVar);
                    }
                }

                public final void reqSuccessful(Object obj) {
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.reqSuccessful(obj);
                    }
                }
            });
        } else if (c5 == 3) {
            if (this.f10764c == null) {
                this.f10764c = new b(this.f10762a);
            }
            this.f10764c.a(eVar, (b) new a(this, bVar));
        }
    }

    private void a() {
        this.f10763b = new a(this.f10762a);
    }

    public final boolean a(e eVar) {
        if (eVar.c() == 1) {
            if (this.f10763b == null) {
                a();
            }
            return this.f10763b.a(eVar.a(), eVar, eVar.b());
        } else if (eVar.c() == 2) {
            if (this.f10765d == null) {
                this.f10765d = new d();
            }
            return this.f10765d.a(eVar);
        } else if (eVar.c() != 3) {
            return false;
        } else {
            if (this.f10764c == null) {
                this.f10764c = new b(this.f10762a);
            }
            return true;
        }
    }
}
