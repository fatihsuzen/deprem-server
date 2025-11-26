package y;

import B.C0628a;
import android.app.job.JobInfo;
import androidx.work.WorkRequest;
import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p.f;
import y.C1932c;

/* renamed from: y.f  reason: case insensitive filesystem */
public abstract class C1935f {

    /* renamed from: y.f$a */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private C0628a f17014a;

        /* renamed from: b  reason: collision with root package name */
        private Map f17015b = new HashMap();

        public a a(f fVar, b bVar) {
            this.f17015b.put(fVar, bVar);
            return this;
        }

        public C1935f b() {
            if (this.f17014a == null) {
                throw new NullPointerException("missing required property: clock");
            } else if (this.f17015b.keySet().size() >= f.values().length) {
                Map map = this.f17015b;
                this.f17015b = new HashMap();
                return C1935f.d(this.f17014a, map);
            } else {
                throw new IllegalStateException("Not all priorities have been configured");
            }
        }

        public a c(C0628a aVar) {
            this.f17014a = aVar;
            return this;
        }
    }

    /* renamed from: y.f$b */
    public static abstract class b {

        /* renamed from: y.f$b$a */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j5);

            public abstract a c(Set set);

            public abstract a d(long j5);
        }

        public static a a() {
            return new C1932c.b().c(Collections.EMPTY_SET);
        }

        /* access modifiers changed from: package-private */
        public abstract long b();

        /* access modifiers changed from: package-private */
        public abstract Set c();

        /* access modifiers changed from: package-private */
        public abstract long d();
    }

    /* renamed from: y.f$c */
    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i5, long j5) {
        long j6;
        int i6 = i5 - 1;
        if (j5 > 1) {
            j6 = j5;
        } else {
            j6 = 2;
        }
        return (long) (Math.pow(3.0d, (double) i6) * ((double) j5) * Math.max(1.0d, Math.log(10000.0d) / Math.log((double) (j6 * ((long) i6)))));
    }

    public static a b() {
        return new a();
    }

    static C1935f d(C0628a aVar, Map map) {
        return new C1931b(aVar, map);
    }

    public static C1935f f(C0628a aVar) {
        return b().a(f.DEFAULT, b.a().b(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).d(86400000).a()).a(f.HIGHEST, b.a().b(1000).d(86400000).a()).a(f.VERY_LOW, b.a().b(86400000).d(86400000).c(i(c.DEVICE_IDLE)).a()).c(aVar).b();
    }

    private static Set i(Object... objArr) {
        return DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(objArr)));
    }

    private void j(JobInfo.Builder builder, Set set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, f fVar, long j5, int i5) {
        builder.setMinimumLatency(g(fVar, j5, i5));
        j(builder, ((b) h().get(fVar)).c());
        return builder;
    }

    /* access modifiers changed from: package-private */
    public abstract C0628a e();

    public long g(f fVar, long j5, int i5) {
        long a5 = j5 - e().a();
        b bVar = (b) h().get(fVar);
        return Math.min(Math.max(a(i5, bVar.b()), a5), bVar.d());
    }

    /* access modifiers changed from: package-private */
    public abstract Map h();
}
