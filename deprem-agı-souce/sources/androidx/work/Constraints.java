package androidx.work;

import X2.C2250q;
import X2.T;
import android.annotation.SuppressLint;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.privacysandbox.ads.adservices.adid.a;
import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.work.impl.utils.DurationApi26Impl;
import androidx.work.impl.utils.NetworkRequest30;
import androidx.work.impl.utils.NetworkRequestCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import j$.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class Constraints {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final Constraints NONE = new Constraints((NetworkType) null, false, false, false, 15, (C2633k) null);
    @ColumnInfo(name = "trigger_max_content_delay")
    private final long contentTriggerMaxDelayMillis;
    @ColumnInfo(name = "trigger_content_update_delay")
    private final long contentTriggerUpdateDelayMillis;
    @ColumnInfo(name = "content_uri_triggers")
    private final Set<ContentUriTrigger> contentUriTriggers;
    @ColumnInfo(defaultValue = "x''", name = "required_network_request")
    private final NetworkRequestCompat requiredNetworkRequestCompat;
    @ColumnInfo(name = "required_network_type")
    private final NetworkType requiredNetworkType;
    @ColumnInfo(name = "requires_battery_not_low")
    private final boolean requiresBatteryNotLow;
    @ColumnInfo(name = "requires_charging")
    private final boolean requiresCharging;
    @ColumnInfo(name = "requires_device_idle")
    private final boolean requiresDeviceIdle;
    @ColumnInfo(name = "requires_storage_not_low")
    private final boolean requiresStorageNotLow;

    public static final class Builder {
        private Set<ContentUriTrigger> contentUriTriggers = new LinkedHashSet();
        private NetworkRequestCompat requiredNetworkRequest = new NetworkRequestCompat((Object) null, 1, (C2633k) null);
        private NetworkType requiredNetworkType = NetworkType.NOT_REQUIRED;
        private boolean requiresBatteryNotLow;
        private boolean requiresCharging;
        private boolean requiresDeviceIdle;
        private boolean requiresStorageNotLow;
        private long triggerContentMaxDelay = -1;
        private long triggerContentUpdateDelay = -1;

        public Builder() {
        }

        @RequiresApi(24)
        public final Builder addContentUriTrigger(Uri uri, boolean z4) {
            t.e(uri, "uri");
            this.contentUriTriggers.add(new ContentUriTrigger(uri, z4));
            return this;
        }

        public final Constraints build() {
            Set d5;
            long j5;
            long j6;
            if (Build.VERSION.SDK_INT >= 24) {
                d5 = C2250q.r0(this.contentUriTriggers);
                j5 = this.triggerContentUpdateDelay;
                j6 = this.triggerContentMaxDelay;
            } else {
                d5 = T.d();
                j5 = -1;
                j6 = -1;
            }
            return new Constraints(this.requiredNetworkRequest, this.requiredNetworkType, this.requiresCharging, this.requiresDeviceIdle, this.requiresBatteryNotLow, this.requiresStorageNotLow, j5, j6, d5);
        }

        public final Builder setRequiredNetworkRequest(NetworkRequest networkRequest, NetworkType networkType) {
            t.e(networkRequest, "networkRequest");
            t.e(networkType, "networkType");
            int i5 = Build.VERSION.SDK_INT;
            if (i5 < 28) {
                this.requiredNetworkType = networkType;
                return this;
            } else if (i5 < 31 || NetworkRequest30.INSTANCE.getNetworkSpecifier(networkRequest) == null) {
                this.requiredNetworkRequest = new NetworkRequestCompat(networkRequest);
                this.requiredNetworkType = NetworkType.NOT_REQUIRED;
                return this;
            } else {
                throw new IllegalArgumentException("NetworkRequests with NetworkSpecifiers set aren't supported.");
            }
        }

        public final Builder setRequiredNetworkType(NetworkType networkType) {
            t.e(networkType, "networkType");
            this.requiredNetworkType = networkType;
            this.requiredNetworkRequest = new NetworkRequestCompat((Object) null, 1, (C2633k) null);
            return this;
        }

        public final Builder setRequiresBatteryNotLow(boolean z4) {
            this.requiresBatteryNotLow = z4;
            return this;
        }

        public final Builder setRequiresCharging(boolean z4) {
            this.requiresCharging = z4;
            return this;
        }

        public final Builder setRequiresDeviceIdle(boolean z4) {
            this.requiresDeviceIdle = z4;
            return this;
        }

        public final Builder setRequiresStorageNotLow(boolean z4) {
            this.requiresStorageNotLow = z4;
            return this;
        }

        @RequiresApi(24)
        public final Builder setTriggerContentMaxDelay(long j5, TimeUnit timeUnit) {
            t.e(timeUnit, "timeUnit");
            this.triggerContentMaxDelay = timeUnit.toMillis(j5);
            return this;
        }

        @RequiresApi(24)
        public final Builder setTriggerContentUpdateDelay(long j5, TimeUnit timeUnit) {
            t.e(timeUnit, "timeUnit");
            this.triggerContentUpdateDelay = timeUnit.toMillis(j5);
            return this;
        }

        @RequiresApi(26)
        public final Builder setTriggerContentMaxDelay(Duration duration) {
            t.e(duration, TypedValues.TransitionType.S_DURATION);
            this.triggerContentMaxDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RequiresApi(26)
        public final Builder setTriggerContentUpdateDelay(Duration duration) {
            t.e(duration, TypedValues.TransitionType.S_DURATION);
            this.triggerContentUpdateDelay = DurationApi26Impl.toMillisCompat(duration);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(Constraints constraints) {
            t.e(constraints, "constraints");
            this.requiresCharging = constraints.requiresCharging();
            this.requiresDeviceIdle = constraints.requiresDeviceIdle();
            this.requiredNetworkType = constraints.getRequiredNetworkType();
            this.requiresBatteryNotLow = constraints.requiresBatteryNotLow();
            this.requiresStorageNotLow = constraints.requiresStorageNotLow();
            if (Build.VERSION.SDK_INT >= 24) {
                this.triggerContentUpdateDelay = constraints.getContentTriggerUpdateDelayMillis();
                this.triggerContentMaxDelay = constraints.getContentTriggerMaxDelayMillis();
                this.contentUriTriggers = C2250q.q0(constraints.getContentUriTriggers());
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public static final class ContentUriTrigger {
        private final boolean isTriggeredForDescendants;
        private final Uri uri;

        public ContentUriTrigger(Uri uri2, boolean z4) {
            t.e(uri2, "uri");
            this.uri = uri2;
            this.isTriggeredForDescendants = z4;
        }

        public boolean equals(Object obj) {
            Class<?> cls;
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!t.a(ContentUriTrigger.class, cls)) {
                return false;
            }
            t.c(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            ContentUriTrigger contentUriTrigger = (ContentUriTrigger) obj;
            if (t.a(this.uri, contentUriTrigger.uri) && this.isTriggeredForDescendants == contentUriTrigger.isTriggeredForDescendants) {
                return true;
            }
            return false;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return (this.uri.hashCode() * 31) + a.a(this.isTriggeredForDescendants);
        }

        public final boolean isTriggeredForDescendants() {
            return this.isTriggeredForDescendants;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Constraints(NetworkType networkType, boolean z4, boolean z5, boolean z6, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType, (i5 & 2) != 0 ? false : z4, (i5 & 4) != 0 ? false : z5, (i5 & 8) != 0 ? false : z6);
    }

    @SuppressLint({"NewApi"})
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.a(Constraints.class, obj.getClass())) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.requiresCharging == constraints.requiresCharging && this.requiresDeviceIdle == constraints.requiresDeviceIdle && this.requiresBatteryNotLow == constraints.requiresBatteryNotLow && this.requiresStorageNotLow == constraints.requiresStorageNotLow && this.contentTriggerUpdateDelayMillis == constraints.contentTriggerUpdateDelayMillis && this.contentTriggerMaxDelayMillis == constraints.contentTriggerMaxDelayMillis && t.a(getRequiredNetworkRequest(), constraints.getRequiredNetworkRequest()) && this.requiredNetworkType == constraints.requiredNetworkType) {
            return t.a(this.contentUriTriggers, constraints.contentUriTriggers);
        }
        return false;
    }

    @RequiresApi(24)
    public final long getContentTriggerMaxDelayMillis() {
        return this.contentTriggerMaxDelayMillis;
    }

    @RequiresApi(24)
    public final long getContentTriggerUpdateDelayMillis() {
        return this.contentTriggerUpdateDelayMillis;
    }

    @RequiresApi(24)
    public final Set<ContentUriTrigger> getContentUriTriggers() {
        return this.contentUriTriggers;
    }

    public final NetworkRequest getRequiredNetworkRequest() {
        return this.requiredNetworkRequestCompat.getNetworkRequest();
    }

    public final NetworkRequestCompat getRequiredNetworkRequestCompat$work_runtime_release() {
        return this.requiredNetworkRequestCompat;
    }

    public final NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasContentUriTriggers() {
        if (Build.VERSION.SDK_INT < 24 || !this.contentUriTriggers.isEmpty()) {
            return true;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public int hashCode() {
        int i5;
        long j5 = this.contentTriggerUpdateDelayMillis;
        long j6 = this.contentTriggerMaxDelayMillis;
        int hashCode = ((((((((((((((this.requiredNetworkType.hashCode() * 31) + (this.requiresCharging ? 1 : 0)) * 31) + (this.requiresDeviceIdle ? 1 : 0)) * 31) + (this.requiresBatteryNotLow ? 1 : 0)) * 31) + (this.requiresStorageNotLow ? 1 : 0)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + this.contentUriTriggers.hashCode()) * 31;
        NetworkRequest requiredNetworkRequest = getRequiredNetworkRequest();
        if (requiredNetworkRequest != null) {
            i5 = requiredNetworkRequest.hashCode();
        } else {
            i5 = 0;
        }
        return hashCode + i5;
    }

    public final boolean requiresBatteryNotLow() {
        return this.requiresBatteryNotLow;
    }

    public final boolean requiresCharging() {
        return this.requiresCharging;
    }

    public final boolean requiresDeviceIdle() {
        return this.requiresDeviceIdle;
    }

    public final boolean requiresStorageNotLow() {
        return this.requiresStorageNotLow;
    }

    @SuppressLint({"NewApi"})
    public String toString() {
        return "Constraints{requiredNetworkType=" + this.requiredNetworkType + ", requiresCharging=" + this.requiresCharging + ", requiresDeviceIdle=" + this.requiresDeviceIdle + ", requiresBatteryNotLow=" + this.requiresBatteryNotLow + ", requiresStorageNotLow=" + this.requiresStorageNotLow + ", contentTriggerUpdateDelayMillis=" + this.contentTriggerUpdateDelayMillis + ", contentTriggerMaxDelayMillis=" + this.contentTriggerMaxDelayMillis + ", contentUriTriggers=" + this.contentUriTriggers + ", }";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Ignore
    @SuppressLint({"NewApi"})
    public Constraints(NetworkType networkType, boolean z4, boolean z5, boolean z6) {
        this(networkType, z4, false, z5, z6);
        t.e(networkType, "requiredNetworkType");
    }

    public /* synthetic */ Constraints(NetworkType networkType, boolean z4, boolean z5, boolean z6, boolean z7, int i5, C2633k kVar) {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        NetworkType networkType2;
        Constraints constraints;
        networkType = (i5 & 1) != 0 ? NetworkType.NOT_REQUIRED : networkType;
        z4 = (i5 & 2) != 0 ? false : z4;
        z5 = (i5 & 4) != 0 ? false : z5;
        z6 = (i5 & 8) != 0 ? false : z6;
        if ((i5 & 16) != 0) {
            z8 = false;
            z10 = z5;
            z9 = z6;
            networkType2 = networkType;
            z11 = z4;
            constraints = this;
        } else {
            z8 = z7;
            z9 = z6;
            z11 = z4;
            z10 = z5;
            constraints = this;
            networkType2 = networkType;
        }
        new Constraints(networkType2, z11, z10, z9, z8);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Ignore
    public Constraints(NetworkType networkType, boolean z4, boolean z5, boolean z6, boolean z7) {
        this(networkType, z4, z5, z6, z7, -1, 0, (Set) null, PsExtractor.AUDIO_STREAM, (C2633k) null);
        t.e(networkType, "requiredNetworkType");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Constraints(androidx.work.NetworkType r3, boolean r4, boolean r5, boolean r6, boolean r7, long r8, long r10, java.util.Set r12, int r13, kotlin.jvm.internal.C2633k r14) {
        /*
            r2 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0006
            androidx.work.NetworkType r3 = androidx.work.NetworkType.NOT_REQUIRED
        L_0x0006:
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto L_0x000c
            r4 = r0
        L_0x000c:
            r14 = r13 & 4
            if (r14 == 0) goto L_0x0011
            r5 = r0
        L_0x0011:
            r14 = r13 & 8
            if (r14 == 0) goto L_0x0016
            r6 = r0
        L_0x0016:
            r14 = r13 & 16
            if (r14 == 0) goto L_0x001b
            r7 = r0
        L_0x001b:
            r14 = r13 & 32
            r0 = -1
            if (r14 == 0) goto L_0x0022
            r8 = r0
        L_0x0022:
            r14 = r13 & 64
            if (r14 == 0) goto L_0x0027
            r10 = r0
        L_0x0027:
            r13 = r13 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x002f
            java.util.Set r12 = X2.T.d()
        L_0x002f:
            r14 = r12
            r12 = r10
            r10 = r8
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r12, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Constraints.<init>(androidx.work.NetworkType, boolean, boolean, boolean, boolean, long, long, java.util.Set, int, kotlin.jvm.internal.k):void");
    }

    @RequiresApi(24)
    @Ignore
    public Constraints(NetworkType networkType, boolean z4, boolean z5, boolean z6, boolean z7, long j5, long j6, Set<ContentUriTrigger> set) {
        t.e(networkType, "requiredNetworkType");
        t.e(set, "contentUriTriggers");
        this.requiredNetworkRequestCompat = new NetworkRequestCompat((Object) null, 1, (C2633k) null);
        this.requiredNetworkType = networkType;
        this.requiresCharging = z4;
        this.requiresDeviceIdle = z5;
        this.requiresBatteryNotLow = z6;
        this.requiresStorageNotLow = z7;
        this.contentTriggerUpdateDelayMillis = j5;
        this.contentTriggerMaxDelayMillis = j6;
        this.contentUriTriggers = set;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Constraints(androidx.work.impl.utils.NetworkRequestCompat r12, androidx.work.NetworkType r13, boolean r14, boolean r15, boolean r16, boolean r17, long r18, long r20, java.util.Set r22, int r23, kotlin.jvm.internal.C2633k r24) {
        /*
            r11 = this;
            r0 = r23
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_REQUIRED
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r2 = r0 & 4
            r3 = 0
            if (r2 == 0) goto L_0x0011
            r2 = r3
            goto L_0x0012
        L_0x0011:
            r2 = r14
        L_0x0012:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0018
            r4 = r3
            goto L_0x0019
        L_0x0018:
            r4 = r15
        L_0x0019:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x001f
            r5 = r3
            goto L_0x0021
        L_0x001f:
            r5 = r16
        L_0x0021:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r3 = r17
        L_0x0028:
            r6 = r0 & 64
            r7 = -1
            if (r6 == 0) goto L_0x0030
            r9 = r7
            goto L_0x0032
        L_0x0030:
            r9 = r18
        L_0x0032:
            r6 = r0 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r7 = r20
        L_0x0039:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0053
            java.util.Set r0 = X2.T.d()
            r24 = r0
        L_0x0043:
            r13 = r11
            r14 = r12
            r15 = r1
            r16 = r2
            r19 = r3
            r17 = r4
            r18 = r5
            r22 = r7
            r20 = r9
            goto L_0x0056
        L_0x0053:
            r24 = r22
            goto L_0x0043
        L_0x0056:
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r22, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Constraints.<init>(androidx.work.impl.utils.NetworkRequestCompat, androidx.work.NetworkType, boolean, boolean, boolean, boolean, long, long, java.util.Set, int, kotlin.jvm.internal.k):void");
    }

    public Constraints(NetworkRequestCompat networkRequestCompat, NetworkType networkType, boolean z4, boolean z5, boolean z6, boolean z7, long j5, long j6, Set<ContentUriTrigger> set) {
        t.e(networkRequestCompat, "requiredNetworkRequestCompat");
        t.e(networkType, "requiredNetworkType");
        t.e(set, "contentUriTriggers");
        this.requiredNetworkRequestCompat = networkRequestCompat;
        this.requiredNetworkType = networkType;
        this.requiresCharging = z4;
        this.requiresDeviceIdle = z5;
        this.requiresBatteryNotLow = z6;
        this.requiresStorageNotLow = z7;
        this.contentTriggerUpdateDelayMillis = j5;
        this.contentTriggerMaxDelayMillis = j6;
        this.contentUriTriggers = set;
    }

    @SuppressLint({"NewApi"})
    public Constraints(Constraints constraints) {
        t.e(constraints, "other");
        this.requiresCharging = constraints.requiresCharging;
        this.requiresDeviceIdle = constraints.requiresDeviceIdle;
        this.requiredNetworkRequestCompat = constraints.requiredNetworkRequestCompat;
        this.requiredNetworkType = constraints.requiredNetworkType;
        this.requiresBatteryNotLow = constraints.requiresBatteryNotLow;
        this.requiresStorageNotLow = constraints.requiresStorageNotLow;
        this.contentUriTriggers = constraints.contentUriTriggers;
        this.contentTriggerUpdateDelayMillis = constraints.contentTriggerUpdateDelayMillis;
        this.contentTriggerMaxDelayMillis = constraints.contentTriggerMaxDelayMillis;
    }
}
