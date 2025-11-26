package androidx.savedstate.serialization;

import H3.l;
import J3.f;
import J3.o;
import K3.b;
import O3.d;
import W2.s;
import W2.y;
import X2.M;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;

public final class SavedStateEncoder extends b {
    private final SavedStateConfiguration configuration;
    private String key = "";
    private final Bundle savedState;
    private final d serializersModule;

    public SavedStateEncoder(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        t.e(bundle, "savedState");
        t.e(savedStateConfiguration, "configuration");
        this.savedState = bundle;
        this.configuration = savedStateConfiguration;
        this.serializersModule = savedStateConfiguration.getSerializersModule();
    }

    private final void checkDiscriminatorCollisions(Bundle bundle, String str) {
        if (this.configuration.getClassDiscriminatorMode() == 1) {
            boolean r02 = SavedStateReader.m72containsimpl(SavedStateReader.m71constructorimpl(bundle), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            boolean a5 = t.a(str, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            if (r02 && a5) {
                String r42 = SavedStateReader.m142getStringimpl(SavedStateReader.m71constructorimpl(bundle), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                throw new IllegalArgumentException("SavedStateEncoder for " + r42 + " has property '" + str + "' that conflicts with the class discriminator. You can rename a property with @SerialName annotation.");
            }
        }
    }

    private final void encodeBooleanArray(boolean[] zArr) {
        SavedStateWriter.m164putBooleanArrayimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, zArr);
    }

    private final void encodeCharArray(char[] cArr) {
        SavedStateWriter.m166putCharArrayimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, cArr);
    }

    private final void encodeDoubleArray(double[] dArr) {
        SavedStateWriter.m171putDoubleArrayimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, dArr);
    }

    private final void encodeFloatArray(float[] fArr) {
        SavedStateWriter.m173putFloatArrayimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, fArr);
    }

    private final <T> boolean encodeFormatSpecificTypes(l lVar, T t5) {
        if (SavedStateEncoder_androidKt.encodeFormatSpecificTypesOnPlatform(this, lVar, t5)) {
            return true;
        }
        f descriptor = lVar.getDescriptor();
        if (t.a(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            t.c(t5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
            encodeIntList((List) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            t.c(t5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            encodeStringList((List) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            t.c(t5, "null cannot be cast to non-null type kotlin.BooleanArray");
            encodeBooleanArray((boolean[]) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            t.c(t5, "null cannot be cast to non-null type kotlin.CharArray");
            encodeCharArray((char[]) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            t.c(t5, "null cannot be cast to non-null type kotlin.DoubleArray");
            encodeDoubleArray((double[]) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            t.c(t5, "null cannot be cast to non-null type kotlin.FloatArray");
            encodeFloatArray((float[]) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            t.c(t5, "null cannot be cast to non-null type kotlin.IntArray");
            encodeIntArray((int[]) t5);
            return true;
        } else if (t.a(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            t.c(t5, "null cannot be cast to non-null type kotlin.LongArray");
            encodeLongArray((long[]) t5);
            return true;
        } else if (!t.a(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            return false;
        } else {
            t.c(t5, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            encodeStringArray((String[]) t5);
            return true;
        }
    }

    private final void encodeIntArray(int[] iArr) {
        SavedStateWriter.m175putIntArrayimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, iArr);
    }

    private final void encodeIntList(List<Integer> list) {
        SavedStateWriter.m176putIntListimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, list);
    }

    private final void encodeLongArray(long[] jArr) {
        SavedStateWriter.m179putLongArrayimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, jArr);
    }

    private final void encodeStringArray(String[] strArr) {
        SavedStateWriter.m191putStringArrayimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, strArr);
    }

    private final void encodeStringList(List<String> list) {
        SavedStateWriter.m192putStringListimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, list);
    }

    private final void putClassDiscriminatorIfRequired(SavedStateConfiguration savedStateConfiguration, f fVar, Bundle bundle) {
        if (savedStateConfiguration.getClassDiscriminatorMode() != 1 || SavedStateReader.m72containsimpl(SavedStateReader.m71constructorimpl(bundle), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
            return;
        }
        if (t.a(fVar.getKind(), o.a.f18390a) || t.a(fVar.getKind(), o.d.f18393a)) {
            SavedStateWriter.m190putStringimpl(SavedStateWriter.m157constructorimpl(bundle), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, fVar.a());
        }
    }

    public K3.d beginStructure(f fVar) {
        s[] sVarArr;
        t.e(fVar, "descriptor");
        if (t.a(this.key, "")) {
            putClassDiscriminatorIfRequired(this.configuration, fVar, this.savedState);
            return this;
        }
        Map h5 = M.h();
        if (h5.isEmpty()) {
            sVarArr = new s[0];
        } else {
            ArrayList arrayList = new ArrayList(h5.size());
            for (Map.Entry entry : h5.entrySet()) {
                arrayList.add(y.a((String) entry.getKey(), entry.getValue()));
            }
            sVarArr = (s[]) arrayList.toArray(new s[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((s[]) Arrays.copyOf(sVarArr, sVarArr.length));
        SavedStateWriter.m157constructorimpl(bundleOf);
        SavedStateWriter.m184putSavedStateimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, bundleOf);
        putClassDiscriminatorIfRequired(this.configuration, fVar, bundleOf);
        return new SavedStateEncoder(bundleOf, this.configuration);
    }

    public void encodeBoolean(boolean z4) {
        SavedStateWriter.m163putBooleanimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, z4);
    }

    public void encodeByte(byte b5) {
        SavedStateWriter.m174putIntimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, b5);
    }

    public void encodeChar(char c5) {
        SavedStateWriter.m165putCharimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, c5);
    }

    public void encodeDouble(double d5) {
        SavedStateWriter.m170putDoubleimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, d5);
    }

    public boolean encodeElement(f fVar, int i5) {
        t.e(fVar, "descriptor");
        String f5 = fVar.f(i5);
        this.key = f5;
        checkDiscriminatorCollisions(this.savedState, f5);
        return true;
    }

    public void encodeEnum(f fVar, int i5) {
        t.e(fVar, "enumDescriptor");
        SavedStateWriter.m174putIntimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, i5);
    }

    public void encodeFloat(float f5) {
        SavedStateWriter.m172putFloatimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, f5);
    }

    public void encodeInt(int i5) {
        SavedStateWriter.m174putIntimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, i5);
    }

    public void encodeLong(long j5) {
        SavedStateWriter.m178putLongimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, j5);
    }

    public void encodeNull() {
        SavedStateWriter.m180putNullimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key);
    }

    public <T> void encodeSerializableValue(l lVar, T t5) {
        t.e(lVar, "serializer");
        if (!encodeFormatSpecificTypes(lVar, t5)) {
            super.encodeSerializableValue(lVar, t5);
        }
    }

    public void encodeShort(short s5) {
        SavedStateWriter.m174putIntimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, s5);
    }

    public void encodeString(String str) {
        t.e(str, "value");
        SavedStateWriter.m190putStringimpl(SavedStateWriter.m157constructorimpl(this.savedState), this.key, str);
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

    public boolean shouldEncodeElementDefault(f fVar, int i5) {
        t.e(fVar, "descriptor");
        return this.configuration.getEncodeDefaults();
    }
}
