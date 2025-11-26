package androidx.core.os;

import W2.s;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.jvm.internal.t;

public final class BundleKt {
    public static final Bundle bundleOf(s... sVarArr) {
        Bundle bundle = new Bundle(sVarArr.length);
        for (s sVar : sVarArr) {
            String str = (String) sVar.a();
            Object b5 = sVar.b();
            if (b5 == null) {
                bundle.putString(str, (String) null);
            } else if (b5 instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) b5).booleanValue());
            } else if (b5 instanceof Byte) {
                bundle.putByte(str, ((Number) b5).byteValue());
            } else if (b5 instanceof Character) {
                bundle.putChar(str, ((Character) b5).charValue());
            } else if (b5 instanceof Double) {
                bundle.putDouble(str, ((Number) b5).doubleValue());
            } else if (b5 instanceof Float) {
                bundle.putFloat(str, ((Number) b5).floatValue());
            } else if (b5 instanceof Integer) {
                bundle.putInt(str, ((Number) b5).intValue());
            } else if (b5 instanceof Long) {
                bundle.putLong(str, ((Number) b5).longValue());
            } else if (b5 instanceof Short) {
                bundle.putShort(str, ((Number) b5).shortValue());
            } else if (b5 instanceof Bundle) {
                bundle.putBundle(str, (Bundle) b5);
            } else if (b5 instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) b5);
            } else if (b5 instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) b5);
            } else if (b5 instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) b5);
            } else if (b5 instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) b5);
            } else if (b5 instanceof char[]) {
                bundle.putCharArray(str, (char[]) b5);
            } else if (b5 instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) b5);
            } else if (b5 instanceof float[]) {
                bundle.putFloatArray(str, (float[]) b5);
            } else if (b5 instanceof int[]) {
                bundle.putIntArray(str, (int[]) b5);
            } else if (b5 instanceof long[]) {
                bundle.putLongArray(str, (long[]) b5);
            } else if (b5 instanceof short[]) {
                bundle.putShortArray(str, (short[]) b5);
            } else if (b5 instanceof Object[]) {
                Class<?> componentType = b5.getClass().getComponentType();
                t.b(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    t.c(b5, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    bundle.putParcelableArray(str, (Parcelable[]) b5);
                } else if (String.class.isAssignableFrom(componentType)) {
                    t.c(b5, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    bundle.putStringArray(str, (String[]) b5);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    t.c(b5, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    bundle.putCharSequenceArray(str, (CharSequence[]) b5);
                } else if (Serializable.class.isAssignableFrom(componentType)) {
                    bundle.putSerializable(str, (Serializable) b5);
                } else {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + '\"');
                }
            } else if (b5 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) b5);
            } else if (b5 instanceof IBinder) {
                bundle.putBinder(str, (IBinder) b5);
            } else if (b5 instanceof Size) {
                BundleApi21ImplKt.putSize(bundle, str, (Size) b5);
            } else if (b5 instanceof SizeF) {
                BundleApi21ImplKt.putSizeF(bundle, str, (SizeF) b5);
            } else {
                throw new IllegalArgumentException("Illegal value type " + b5.getClass().getCanonicalName() + " for key \"" + str + '\"');
            }
        }
        return bundle;
    }

    public static final Bundle bundleOf() {
        return new Bundle(0);
    }
}
