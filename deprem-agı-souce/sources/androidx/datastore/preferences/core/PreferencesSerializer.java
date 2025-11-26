package androidx.datastore.preferences.core;

import W2.J;
import W2.q;
import X2.C2250q;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.preferences.PreferencesMapCompat;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import b3.C2308e;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import e4.C2357f;
import e4.C2358g;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class PreferencesSerializer implements OkioSerializer<Preferences> {
    public static final PreferencesSerializer INSTANCE = new PreferencesSerializer();
    public static final String fileExtension = "preferences_pb";

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.datastore.preferences.PreferencesProto$Value$ValueCase[] r0 = androidx.datastore.preferences.PreferencesProto.Value.ValueCase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.datastore.preferences.PreferencesProto$Value$ValueCase r1 = androidx.datastore.preferences.PreferencesProto.Value.ValueCase.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.datastore.preferences.PreferencesProto$Value$ValueCase r1 = androidx.datastore.preferences.PreferencesProto.Value.ValueCase.FLOAT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.datastore.preferences.PreferencesProto$Value$ValueCase r1 = androidx.datastore.preferences.PreferencesProto.Value.ValueCase.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.datastore.preferences.PreferencesProto$Value$ValueCase r1 = androidx.datastore.preferences.PreferencesProto.Value.ValueCase.INTEGER     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.datastore.preferences.PreferencesProto$Value$ValueCase r1 = androidx.datastore.preferences.PreferencesProto.Value.ValueCase.LONG     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.datastore.preferences.PreferencesProto$Value$ValueCase r1 = androidx.datastore.preferences.PreferencesProto.Value.ValueCase.STRING     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.datastore.preferences.PreferencesProto$Value$ValueCase r1 = androidx.datastore.preferences.PreferencesProto.Value.ValueCase.STRING_SET     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                androidx.datastore.preferences.PreferencesProto$Value$ValueCase r1 = androidx.datastore.preferences.PreferencesProto.Value.ValueCase.BYTES     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                androidx.datastore.preferences.PreferencesProto$Value$ValueCase r1 = androidx.datastore.preferences.PreferencesProto.Value.ValueCase.VALUE_NOT_SET     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.core.PreferencesSerializer.WhenMappings.<clinit>():void");
        }
    }

    private PreferencesSerializer() {
    }

    private final void addProtoEntryToPreferences(String str, PreferencesProto.Value value, MutablePreferences mutablePreferences) {
        int i5;
        PreferencesProto.Value.ValueCase valueCase = value.getValueCase();
        if (valueCase == null) {
            i5 = -1;
        } else {
            i5 = WhenMappings.$EnumSwitchMapping$0[valueCase.ordinal()];
        }
        switch (i5) {
            case -1:
                throw new CorruptionException("Value case is null.", (Throwable) null, 2, (C2633k) null);
            case 1:
                mutablePreferences.set(PreferencesKeys.booleanKey(str), Boolean.valueOf(value.getBoolean()));
                return;
            case 2:
                mutablePreferences.set(PreferencesKeys.floatKey(str), Float.valueOf(value.getFloat()));
                return;
            case 3:
                mutablePreferences.set(PreferencesKeys.doubleKey(str), Double.valueOf(value.getDouble()));
                return;
            case 4:
                mutablePreferences.set(PreferencesKeys.intKey(str), Integer.valueOf(value.getInteger()));
                return;
            case 5:
                mutablePreferences.set(PreferencesKeys.longKey(str), Long.valueOf(value.getLong()));
                return;
            case 6:
                Preferences.Key<String> stringKey = PreferencesKeys.stringKey(str);
                String string = value.getString();
                t.d(string, "value.string");
                mutablePreferences.set(stringKey, string);
                return;
            case 7:
                Preferences.Key<Set<String>> stringSetKey = PreferencesKeys.stringSetKey(str);
                List<String> stringsList = value.getStringSet().getStringsList();
                t.d(stringsList, "value.stringSet.stringsList");
                mutablePreferences.set(stringSetKey, C2250q.r0(stringsList));
                return;
            case 8:
                Preferences.Key<byte[]> byteArrayKey = PreferencesKeys.byteArrayKey(str);
                byte[] byteArray = value.getBytes().toByteArray();
                t.d(byteArray, "value.bytes.toByteArray()");
                mutablePreferences.set(byteArrayKey, byteArray);
                return;
            case 9:
                throw new CorruptionException("Value not set.", (Throwable) null, 2, (C2633k) null);
            default:
                throw new q();
        }
    }

    private final PreferencesProto.Value getValueProto(Object obj) {
        if (obj instanceof Boolean) {
            GeneratedMessageLite build = PreferencesProto.Value.newBuilder().setBoolean(((Boolean) obj).booleanValue()).build();
            t.d(build, "newBuilder().setBoolean(value).build()");
            return (PreferencesProto.Value) build;
        } else if (obj instanceof Float) {
            GeneratedMessageLite build2 = PreferencesProto.Value.newBuilder().setFloat(((Number) obj).floatValue()).build();
            t.d(build2, "newBuilder().setFloat(value).build()");
            return (PreferencesProto.Value) build2;
        } else if (obj instanceof Double) {
            GeneratedMessageLite build3 = PreferencesProto.Value.newBuilder().setDouble(((Number) obj).doubleValue()).build();
            t.d(build3, "newBuilder().setDouble(value).build()");
            return (PreferencesProto.Value) build3;
        } else if (obj instanceof Integer) {
            GeneratedMessageLite build4 = PreferencesProto.Value.newBuilder().setInteger(((Number) obj).intValue()).build();
            t.d(build4, "newBuilder().setInteger(value).build()");
            return (PreferencesProto.Value) build4;
        } else if (obj instanceof Long) {
            GeneratedMessageLite build5 = PreferencesProto.Value.newBuilder().setLong(((Number) obj).longValue()).build();
            t.d(build5, "newBuilder().setLong(value).build()");
            return (PreferencesProto.Value) build5;
        } else if (obj instanceof String) {
            GeneratedMessageLite build6 = PreferencesProto.Value.newBuilder().setString((String) obj).build();
            t.d(build6, "newBuilder().setString(value).build()");
            return (PreferencesProto.Value) build6;
        } else if (obj instanceof Set) {
            PreferencesProto.Value.Builder newBuilder = PreferencesProto.Value.newBuilder();
            PreferencesProto.StringSet.Builder newBuilder2 = PreferencesProto.StringSet.newBuilder();
            t.c(obj, "null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            GeneratedMessageLite build7 = newBuilder.setStringSet(newBuilder2.addAllStrings((Set) obj)).build();
            t.d(build7, "newBuilder()\n           …                 .build()");
            return (PreferencesProto.Value) build7;
        } else if (obj instanceof byte[]) {
            GeneratedMessageLite build8 = PreferencesProto.Value.newBuilder().setBytes(ByteString.copyFrom((byte[]) obj)).build();
            t.d(build8, "newBuilder().setBytes(By….copyFrom(value)).build()");
            return (PreferencesProto.Value) build8;
        } else {
            throw new IllegalStateException("PreferencesSerializer does not support type: " + obj.getClass().getName());
        }
    }

    public Object readFrom(C2358g gVar, C2308e eVar) throws IOException, CorruptionException {
        PreferencesProto.PreferenceMap readFrom = PreferencesMapCompat.Companion.readFrom(gVar.inputStream());
        MutablePreferences createMutable = PreferencesFactory.createMutable(new Preferences.Pair[0]);
        Map<String, PreferencesProto.Value> preferencesMap = readFrom.getPreferencesMap();
        t.d(preferencesMap, "preferencesProto.preferencesMap");
        for (Map.Entry next : preferencesMap.entrySet()) {
            String str = (String) next.getKey();
            PreferencesProto.Value value = (PreferencesProto.Value) next.getValue();
            PreferencesSerializer preferencesSerializer = INSTANCE;
            t.d(str, RewardPlus.NAME);
            t.d(value, "value");
            preferencesSerializer.addProtoEntryToPreferences(str, value, createMutable);
        }
        return createMutable.toPreferences();
    }

    public Preferences getDefaultValue() {
        return PreferencesFactory.createEmpty();
    }

    public Object writeTo(Preferences preferences, C2357f fVar, C2308e eVar) throws IOException, CorruptionException {
        Map<Preferences.Key<?>, Object> asMap = preferences.asMap();
        PreferencesProto.PreferenceMap.Builder newBuilder = PreferencesProto.PreferenceMap.newBuilder();
        for (Map.Entry next : asMap.entrySet()) {
            newBuilder.putPreferences(((Preferences.Key) next.getKey()).getName(), getValueProto(next.getValue()));
        }
        ((PreferencesProto.PreferenceMap) newBuilder.build()).writeTo(fVar.outputStream());
        return J.f19942a;
    }
}
