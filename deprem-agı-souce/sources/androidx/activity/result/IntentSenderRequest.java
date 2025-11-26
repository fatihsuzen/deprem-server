package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new IntentSenderRequest$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((C2633k) null);
    private final Intent fillInIntent;
    private final int flagsMask;
    private final int flagsValues;
    private final IntentSender intentSender;

    public static final class Builder {
        private Intent fillInIntent;
        private int flagsMask;
        private int flagsValues;
        private final IntentSender intentSender;

        @Retention(RetentionPolicy.SOURCE)
        private @interface Flag {
        }

        public Builder(IntentSender intentSender2) {
            t.e(intentSender2, "intentSender");
            this.intentSender = intentSender2;
        }

        public final IntentSenderRequest build() {
            return new IntentSenderRequest(this.intentSender, this.fillInIntent, this.flagsMask, this.flagsValues);
        }

        public final Builder setFillInIntent(Intent intent) {
            this.fillInIntent = intent;
            return this;
        }

        public final Builder setFlags(int i5, int i6) {
            this.flagsValues = i5;
            this.flagsMask = i6;
            return this;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Builder(android.app.PendingIntent r2) {
            /*
                r1 = this;
                java.lang.String r0 = "pendingIntent"
                kotlin.jvm.internal.t.e(r2, r0)
                android.content.IntentSender r2 = r2.getIntentSender()
                java.lang.String r0 = "pendingIntent.intentSender"
                kotlin.jvm.internal.t.d(r2, r0)
                r1.<init>((android.content.IntentSender) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.IntentSenderRequest.Builder.<init>(android.app.PendingIntent):void");
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }

        private Companion() {
        }
    }

    public IntentSenderRequest(IntentSender intentSender2, Intent intent, int i5, int i6) {
        t.e(intentSender2, "intentSender");
        this.intentSender = intentSender2;
        this.fillInIntent = intent;
        this.flagsMask = i5;
        this.flagsValues = i6;
    }

    public int describeContents() {
        return 0;
    }

    public final Intent getFillInIntent() {
        return this.fillInIntent;
    }

    public final int getFlagsMask() {
        return this.flagsMask;
    }

    public final int getFlagsValues() {
        return this.flagsValues;
    }

    public final IntentSender getIntentSender() {
        return this.intentSender;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "dest");
        parcel.writeParcelable(this.intentSender, i5);
        parcel.writeParcelable(this.fillInIntent, i5);
        parcel.writeInt(this.flagsMask);
        parcel.writeInt(this.flagsValues);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntentSenderRequest(IntentSender intentSender2, Intent intent, int i5, int i6, int i7, C2633k kVar) {
        this(intentSender2, (i7 & 2) != 0 ? null : intent, (i7 & 4) != 0 ? 0 : i5, (i7 & 8) != 0 ? 0 : i6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IntentSenderRequest(android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.t.e(r4, r0)
            java.lang.Class<android.content.IntentSender> r0 = android.content.IntentSender.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r4.readParcelable(r0)
            kotlin.jvm.internal.t.b(r0)
            android.content.IntentSender r0 = (android.content.IntentSender) r0
            java.lang.Class<android.content.Intent> r1 = android.content.Intent.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r4.readParcelable(r1)
            android.content.Intent r1 = (android.content.Intent) r1
            int r2 = r4.readInt()
            int r4 = r4.readInt()
            r3.<init>(r0, r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.IntentSenderRequest.<init>(android.os.Parcel):void");
    }
}
