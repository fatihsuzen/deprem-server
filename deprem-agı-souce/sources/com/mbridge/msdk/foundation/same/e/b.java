package com.mbridge.msdk.foundation.same.e;

import android.annotation.SuppressLint;
import android.content.Context;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.ah;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    ThreadPoolExecutor f9284a;

    /* renamed from: b  reason: collision with root package name */
    HashMap<Long, a> f9285b;

    /* renamed from: c  reason: collision with root package name */
    WeakReference<Context> f9286c;

    @SuppressLint({"UseSparseArrays"})
    public b(Context context, int i5) {
        if (ah.a().a("c_t_l_t_p", true)) {
            this.f9284a = c.a();
        } else {
            if (i5 == 0) {
                this.f9284a = new ThreadPoolExecutor(1, 5, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.f9284a = new ThreadPoolExecutor(i5, (i5 * 2) + 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.f9284a.allowCoreThreadTimeOut(true);
        }
        this.f9285b = new HashMap<>();
        this.f9286c = new WeakReference<>(context);
    }

    private synchronized void b(final a aVar, final a.C0087a aVar2) {
        this.f9285b.put(Long.valueOf(aVar.getId()), aVar);
        aVar.setOnStateChangeListener(new a.C0087a() {
            public final void a(a.b bVar) {
                if (bVar == a.b.CANCEL) {
                    b.this.f9285b.remove(Long.valueOf(aVar.getId()));
                } else if (bVar == a.b.FINISH) {
                    b.this.f9285b.remove(Long.valueOf(aVar.getId()));
                } else if (bVar == a.b.RUNNING && b.this.f9286c.get() == null) {
                    b.this.a();
                }
                a.C0087a aVar = aVar2;
                if (aVar != null) {
                    aVar.a(bVar);
                }
            }
        });
    }

    public final void a(a aVar) {
        b(aVar, (a.C0087a) null);
        this.f9284a.execute(aVar);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockFinish
        jadx.core.utils.exceptions.JadxRuntimeException: Dominance frontier not set for block: B:6:0x0021
        	at jadx.core.dex.nodes.BlockNode.lock(BlockNode.java:75)
        	at jadx.core.utils.ImmutableList.forEach(ImmutableList.java:108)
        	at jadx.core.dex.nodes.MethodNode.finishBasicBlocks(MethodNode.java:472)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:27)
        */
    public final synchronized void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.HashMap<java.lang.Long, com.mbridge.msdk.foundation.same.e.a> r0 = r2.f9285b     // Catch:{ Exception -> 0x002b }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x002b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x002b }
        L_0x000b:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x002b }
            if (r1 == 0) goto L_0x0023
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x002b }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Exception -> 0x002b }
            java.lang.Object r1 = r1.getValue()     // Catch:{ Exception -> 0x002b }
            com.mbridge.msdk.foundation.same.e.a r1 = (com.mbridge.msdk.foundation.same.e.a) r1     // Catch:{ Exception -> 0x002b }
            r1.cancel()     // Catch:{ Exception -> 0x002b }
            goto L_0x000b
        L_0x0021:
            r0 = move-exception
            goto L_0x0029
        L_0x0023:
            java.util.HashMap<java.lang.Long, com.mbridge.msdk.foundation.same.e.a> r0 = r2.f9285b     // Catch:{ Exception -> 0x002b }
            r0.clear()     // Catch:{ Exception -> 0x002b }
            goto L_0x002b
        L_0x0029:
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            throw r0
        L_0x002b:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.e.b.a():void");
    }

    @SuppressLint({"UseSparseArrays"})
    public b(Context context) {
        if (ah.a().a("c_t_l_t_p", true)) {
            this.f9284a = c.a();
        } else {
            if (ah.a().a("c_t_p_t_l", true)) {
                int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
                this.f9284a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.f9284a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.f9284a.allowCoreThreadTimeOut(true);
        }
        this.f9285b = new HashMap<>();
        this.f9286c = new WeakReference<>(context);
    }

    public final void a(a aVar, a.C0087a aVar2) {
        b(aVar, aVar2);
        this.f9284a.execute(aVar);
    }
}
