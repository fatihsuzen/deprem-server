package androidx.datastore.preferences;

import androidx.annotation.RestrictTo;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import java.io.InputStream;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class PreferencesMapCompat {
    public static final Companion Companion = new Companion((C2633k) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final PreferencesProto.PreferenceMap readFrom(InputStream inputStream) {
            t.e(inputStream, "input");
            try {
                PreferencesProto.PreferenceMap parseFrom = PreferencesProto.PreferenceMap.parseFrom(inputStream);
                t.d(parseFrom, "{\n                Prefer…From(input)\n            }");
                return parseFrom;
            } catch (InvalidProtocolBufferException e5) {
                throw new CorruptionException("Unable to parse preferences proto.", e5);
            }
        }

        private Companion() {
        }
    }
}
