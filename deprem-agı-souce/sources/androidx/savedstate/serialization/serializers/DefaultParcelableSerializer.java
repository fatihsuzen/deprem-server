package androidx.savedstate.serialization.serializers;

import android.os.Parcelable;

public final class DefaultParcelableSerializer extends ParcelableSerializer<Parcelable> {
    public static final DefaultParcelableSerializer INSTANCE = new DefaultParcelableSerializer();

    private DefaultParcelableSerializer() {
    }
}
