package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.C;
import com.squareup.picasso.s;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class u extends ThreadPoolExecutor {

    private static final class a extends FutureTask implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        private final C1587c f13403a;

        a(C1587c cVar) {
            super(cVar, (Object) null);
            this.f13403a = cVar;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            s.f r5 = this.f13403a.r();
            s.f r6 = aVar.f13403a.r();
            if (r5 == r6) {
                return this.f13403a.f13268a - aVar.f13403a.f13268a;
            }
            return r6.ordinal() - r5.ordinal();
        }
    }

    u() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C.c());
    }

    private void b(int i5) {
        setCorePoolSize(i5);
        setMaximumPoolSize(i5);
    }

    /* access modifiers changed from: package-private */
    public void a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            b(3);
            return;
        }
        int type = networkInfo.getType();
        if (type == 0) {
            int subtype = networkInfo.getSubtype();
            switch (subtype) {
                case 1:
                case 2:
                    b(1);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    switch (subtype) {
                        case 12:
                            break;
                        case 13:
                        case 14:
                        case 15:
                            b(3);
                            return;
                        default:
                            b(3);
                            return;
                    }
            }
            b(2);
        } else if (type == 1 || type == 6 || type == 9) {
            b(4);
        } else {
            b(3);
        }
    }

    public Future submit(Runnable runnable) {
        a aVar = new a((C1587c) runnable);
        execute(aVar);
        return aVar;
    }
}
