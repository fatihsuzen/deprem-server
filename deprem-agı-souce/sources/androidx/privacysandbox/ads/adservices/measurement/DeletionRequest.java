package androidx.privacysandbox.ads.adservices.measurement;

import X2.C2250q;
import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import j$.time.Instant;
import j$.time.TimeConversions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@RequiresApi(26)
public final class DeletionRequest {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final int DELETION_MODE_ALL = 0;
    public static final int DELETION_MODE_EXCLUDE_INTERNAL_DATA = 1;
    public static final int MATCH_BEHAVIOR_DELETE = 0;
    public static final int MATCH_BEHAVIOR_PRESERVE = 1;
    private final int deletionMode;
    private final List<Uri> domainUris;
    private final Instant end;
    private final int matchBehavior;
    private final List<Uri> originUris;
    private final Instant start;

    @RequiresApi(26)
    public static final class Builder {
        private final int deletionMode;
        private List<? extends Uri> domainUris = C2250q.g();
        private Instant end;
        private final int matchBehavior;
        private List<? extends Uri> originUris = C2250q.g();
        private Instant start;

        public Builder(int i5, int i6) {
            this.deletionMode = i5;
            this.matchBehavior = i6;
            Instant instant = Instant.MIN;
            t.d(instant, "MIN");
            this.start = instant;
            Instant instant2 = Instant.MAX;
            t.d(instant2, "MAX");
            this.end = instant2;
        }

        public final DeletionRequest build() {
            return new DeletionRequest(this.deletionMode, this.matchBehavior, this.start, this.end, this.domainUris, this.originUris);
        }

        public final Builder setDomainUris(List<? extends Uri> list) {
            t.e(list, "domainUris");
            this.domainUris = list;
            return this;
        }

        public final Builder setEnd(Instant instant) {
            t.e(instant, TtmlNode.END);
            this.end = instant;
            return this;
        }

        public final Builder setOriginUris(List<? extends Uri> list) {
            t.e(list, "originUris");
            this.originUris = list;
            return this;
        }

        public final Builder setStart(Instant instant) {
            t.e(instant, "start");
            this.start = instant;
            return this;
        }
    }

    public static final class Companion {

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface DeletionMode {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface MatchBehavior {
        }

        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public DeletionRequest(int i5, int i6, Instant instant, Instant instant2, List<? extends Uri> list, List<? extends Uri> list2) {
        t.e(instant, "start");
        t.e(instant2, TtmlNode.END);
        t.e(list, "domainUris");
        t.e(list2, "originUris");
        this.deletionMode = i5;
        this.matchBehavior = i6;
        this.start = instant;
        this.end = instant2;
        this.domainUris = list;
        this.originUris = list2;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final android.adservices.measurement.DeletionRequest convertToAdServices$ads_adservices_release() {
        android.adservices.measurement.DeletionRequest a5 = C0416h.a().setDeletionMode(this.deletionMode).setMatchBehavior(this.matchBehavior).setStart(TimeConversions.convert(this.start)).setEnd(TimeConversions.convert(this.end)).setDomainUris(this.domainUris).setOriginUris(this.originUris).build();
        t.d(a5, "Builder()\n            .s…ris)\n            .build()");
        return a5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeletionRequest)) {
            return false;
        }
        DeletionRequest deletionRequest = (DeletionRequest) obj;
        if (this.deletionMode != deletionRequest.deletionMode || !t.a(new HashSet(this.domainUris), new HashSet(deletionRequest.domainUris)) || !t.a(new HashSet(this.originUris), new HashSet(deletionRequest.originUris)) || !t.a(this.start, deletionRequest.start) || !t.a(this.end, deletionRequest.end) || this.matchBehavior != deletionRequest.matchBehavior) {
            return false;
        }
        return true;
    }

    public final int getDeletionMode() {
        return this.deletionMode;
    }

    public final List<Uri> getDomainUris() {
        return this.domainUris;
    }

    public final Instant getEnd() {
        return this.end;
    }

    public final int getMatchBehavior() {
        return this.matchBehavior;
    }

    public final List<Uri> getOriginUris() {
        return this.originUris;
    }

    public final Instant getStart() {
        return this.start;
    }

    public int hashCode() {
        return (((((((((this.deletionMode * 31) + this.domainUris.hashCode()) * 31) + this.originUris.hashCode()) * 31) + this.start.hashCode()) * 31) + this.end.hashCode()) * 31) + this.matchBehavior;
    }

    public String toString() {
        String str;
        String str2;
        if (this.deletionMode == 0) {
            str = "DELETION_MODE_ALL";
        } else {
            str = "DELETION_MODE_EXCLUDE_INTERNAL_DATA";
        }
        if (this.matchBehavior == 0) {
            str2 = "MATCH_BEHAVIOR_DELETE";
        } else {
            str2 = "MATCH_BEHAVIOR_PRESERVE";
        }
        return "DeletionRequest { DeletionMode=" + str + ", MatchBehavior=" + str2 + ", Start=" + this.start + ", End=" + this.end + ", DomainUris=" + this.domainUris + ", OriginUris=" + this.originUris + " }";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeletionRequest(int r8, int r9, j$.time.Instant r10, j$.time.Instant r11, java.util.List r12, java.util.List r13, int r14, kotlin.jvm.internal.C2633k r15) {
        /*
            r7 = this;
            r15 = r14 & 4
            if (r15 == 0) goto L_0x000b
            j$.time.Instant r10 = j$.time.Instant.MIN
            java.lang.String r15 = "MIN"
            kotlin.jvm.internal.t.d(r10, r15)
        L_0x000b:
            r3 = r10
            r10 = r14 & 8
            if (r10 == 0) goto L_0x0017
            j$.time.Instant r11 = j$.time.Instant.MAX
            java.lang.String r10 = "MAX"
            kotlin.jvm.internal.t.d(r11, r10)
        L_0x0017:
            r4 = r11
            r10 = r14 & 16
            if (r10 == 0) goto L_0x0020
            java.util.List r12 = X2.C2250q.g()
        L_0x0020:
            r5 = r12
            r10 = r14 & 32
            if (r10 == 0) goto L_0x0029
            java.util.List r13 = X2.C2250q.g()
        L_0x0029:
            r0 = r7
            r1 = r8
            r2 = r9
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.measurement.DeletionRequest.<init>(int, int, j$.time.Instant, j$.time.Instant, java.util.List, java.util.List, int, kotlin.jvm.internal.k):void");
    }
}
