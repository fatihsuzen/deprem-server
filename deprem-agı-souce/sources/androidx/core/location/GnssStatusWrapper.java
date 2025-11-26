package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float getCarrierFrequencyHz(GnssStatus gnssStatus, int i5) {
            return gnssStatus.getCarrierFrequencyHz(i5);
        }

        @DoNotInline
        static boolean hasCarrierFrequencyHz(GnssStatus gnssStatus, int i5) {
            return gnssStatus.hasCarrierFrequencyHz(i5);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static float getBasebandCn0DbHz(GnssStatus gnssStatus, int i5) {
            return gnssStatus.getBasebandCn0DbHz(i5);
        }

        @DoNotInline
        static boolean hasBasebandCn0DbHz(GnssStatus gnssStatus, int i5) {
            return gnssStatus.hasBasebandCn0DbHz(i5);
        }
    }

    GnssStatusWrapper(Object obj) {
        this.mWrapped = C0302d.a(Preconditions.checkNotNull(C0302d.a(obj)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GnssStatusWrapper)) {
            return false;
        }
        return this.mWrapped.equals(((GnssStatusWrapper) obj).mWrapped);
    }

    public float getAzimuthDegrees(int i5) {
        return this.mWrapped.getAzimuthDegrees(i5);
    }

    public float getBasebandCn0DbHz(int i5) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getBasebandCn0DbHz(this.mWrapped, i5);
        }
        throw new UnsupportedOperationException();
    }

    public float getCarrierFrequencyHz(int i5) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getCarrierFrequencyHz(this.mWrapped, i5);
        }
        throw new UnsupportedOperationException();
    }

    public float getCn0DbHz(int i5) {
        return this.mWrapped.getCn0DbHz(i5);
    }

    public int getConstellationType(int i5) {
        return this.mWrapped.getConstellationType(i5);
    }

    public float getElevationDegrees(int i5) {
        return this.mWrapped.getElevationDegrees(i5);
    }

    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    public int getSvid(int i5) {
        return this.mWrapped.getSvid(i5);
    }

    public boolean hasAlmanacData(int i5) {
        return this.mWrapped.hasAlmanacData(i5);
    }

    public boolean hasBasebandCn0DbHz(int i5) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.hasBasebandCn0DbHz(this.mWrapped, i5);
        }
        return false;
    }

    public boolean hasCarrierFrequencyHz(int i5) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasCarrierFrequencyHz(this.mWrapped, i5);
        }
        return false;
    }

    public boolean hasEphemerisData(int i5) {
        return this.mWrapped.hasEphemerisData(i5);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    public boolean usedInFix(int i5) {
        return this.mWrapped.usedInFix(i5);
    }
}
