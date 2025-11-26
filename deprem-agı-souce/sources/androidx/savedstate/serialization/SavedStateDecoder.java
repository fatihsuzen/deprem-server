package androidx.savedstate.serialization;

import J3.f;
import J3.o;
import K3.a;
import K3.c;
import O3.d;
import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import java.util.List;
import kotlin.jvm.internal.t;

public final class SavedStateDecoder extends a {
    private final SavedStateConfiguration configuration;
    private int index;
    private String key = "";
    private final Bundle savedState;
    private final d serializersModule;

    public SavedStateDecoder(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        t.e(bundle, "savedState");
        t.e(savedStateConfiguration, "configuration");
        this.savedState = bundle;
        this.configuration = savedStateConfiguration;
        this.serializersModule = savedStateConfiguration.getSerializersModule();
    }

    private final boolean[] decodeBooleanArray() {
        return SavedStateReader.m81getBooleanArrayimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    private final char[] decodeCharArray() {
        return SavedStateReader.m85getCharArrayimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    private final double[] decodeDoubleArray() {
        return SavedStateReader.m95getDoubleArrayimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    private static final boolean decodeElementIndex$hasDefaultValueDefined(f fVar, int i5) {
        return fVar.i(i5);
    }

    private static final boolean decodeElementIndex$presentInEncoding(SavedStateDecoder savedStateDecoder, f fVar, int i5) {
        return SavedStateReader.m72containsimpl(SavedStateReader.m71constructorimpl(savedStateDecoder.savedState), fVar.f(i5));
    }

    private final float[] decodeFloatArray() {
        return SavedStateReader.m99getFloatArrayimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    private final <T> T decodeFormatSpecificTypes(H3.a aVar) {
        T decodeFormatSpecificTypesOnPlatform = SavedStateDecoder_androidKt.decodeFormatSpecificTypesOnPlatform(this, aVar);
        if (decodeFormatSpecificTypesOnPlatform != null) {
            return decodeFormatSpecificTypesOnPlatform;
        }
        f descriptor = aVar.getDescriptor();
        if (t.a(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            return decodeIntList();
        }
        if (t.a(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            return decodeStringList();
        }
        if (t.a(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            return decodeBooleanArray();
        }
        if (t.a(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            return decodeCharArray();
        }
        if (t.a(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            return decodeDoubleArray();
        }
        if (t.a(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            return decodeFloatArray();
        }
        if (t.a(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            return decodeIntArray();
        }
        if (t.a(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            return decodeLongArray();
        }
        if (t.a(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            return decodeStringArray();
        }
        return null;
    }

    private final int[] decodeIntArray() {
        return SavedStateReader.m103getIntArrayimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    private final List<Integer> decodeIntList() {
        return SavedStateReader.m105getIntListimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    private final long[] decodeLongArray() {
        return SavedStateReader.m113getLongArrayimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    private final String[] decodeStringArray() {
        return SavedStateReader.m143getStringArrayimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    private final List<String> decodeStringList() {
        return SavedStateReader.m145getStringListimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public c beginStructure(f fVar) {
        t.e(fVar, "descriptor");
        if (t.a(this.key, "")) {
            return this;
        }
        return new SavedStateDecoder(SavedStateReader.m128getSavedStateimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key), this.configuration);
    }

    public boolean decodeBoolean() {
        return SavedStateReader.m80getBooleanimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public byte decodeByte() {
        return (byte) SavedStateReader.m102getIntimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public char decodeChar() {
        return SavedStateReader.m84getCharimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public double decodeDouble() {
        return SavedStateReader.m94getDoubleimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public int decodeElementIndex(f fVar) {
        int i5;
        t.e(fVar, "descriptor");
        if (t.a(fVar.getKind(), o.b.f18391a) || t.a(fVar.getKind(), o.c.f18392a)) {
            i5 = SavedStateReader.m151sizeimpl(SavedStateReader.m71constructorimpl(this.savedState));
        } else {
            i5 = fVar.e();
        }
        while (true) {
            int i6 = this.index;
            if (i6 >= i5 || !decodeElementIndex$hasDefaultValueDefined(fVar, i6) || decodeElementIndex$presentInEncoding(this, fVar, this.index)) {
                int i7 = this.index;
            } else {
                this.index++;
            }
        }
        int i72 = this.index;
        if (i72 >= i5) {
            return -1;
        }
        this.key = fVar.f(i72);
        int i8 = this.index;
        this.index = i8 + 1;
        return i8;
    }

    public int decodeEnum(f fVar) {
        t.e(fVar, "enumDescriptor");
        return SavedStateReader.m102getIntimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public float decodeFloat() {
        return SavedStateReader.m98getFloatimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public int decodeInt() {
        return SavedStateReader.m102getIntimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public long decodeLong() {
        return SavedStateReader.m112getLongimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public boolean decodeNotNullMark() {
        return !SavedStateReader.m150isNullimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public <T> T decodeSerializableValue(H3.a aVar) {
        t.e(aVar, "deserializer");
        T decodeFormatSpecificTypes = decodeFormatSpecificTypes(aVar);
        if (decodeFormatSpecificTypes == null) {
            return super.decodeSerializableValue(aVar);
        }
        return decodeFormatSpecificTypes;
    }

    public short decodeShort() {
        return (short) SavedStateReader.m102getIntimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public String decodeString() {
        return SavedStateReader.m142getStringimpl(SavedStateReader.m71constructorimpl(this.savedState), this.key);
    }

    public final String getKey$savedstate_release() {
        return this.key;
    }

    public final Bundle getSavedState$savedstate_release() {
        return this.savedState;
    }

    public d getSerializersModule() {
        return this.serializersModule;
    }
}
