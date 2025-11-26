package androidx.savedstate;

import W2.C2219h;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleCompat;
import androidx.exifinterface.media.ExifInterface;
import b.w;
import j3.C2582a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import q3.C2729e;
import r3.C2733c;

public final class SavedStateReader {
    private final Bundle source;

    private /* synthetic */ SavedStateReader(Bundle bundle) {
        this.source = bundle;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ SavedStateReader m70boximpl(Bundle bundle) {
        return new SavedStateReader(bundle);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Bundle m71constructorimpl(Bundle bundle) {
        t.e(bundle, "source");
        return bundle;
    }

    /* renamed from: contains-impl  reason: not valid java name */
    public static final boolean m72containsimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.containsKey(str);
    }

    /* renamed from: contentDeepEquals-impl  reason: not valid java name */
    public static final boolean m73contentDeepEqualsimpl(Bundle bundle, Bundle bundle2) {
        t.e(bundle2, "other");
        return SavedStateReaderKt__SavedStateReader_androidKt.contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(bundle, bundle2);
    }

    /* renamed from: contentDeepHashCode-impl  reason: not valid java name */
    public static final int m74contentDeepHashCodeimpl(Bundle bundle) {
        return SavedStateReaderKt__SavedStateReader_androidKt.contentDeepHashCode$SavedStateReaderKt__SavedStateReader_androidKt(bundle);
    }

    /* renamed from: contentDeepToString-impl  reason: not valid java name */
    public static final String m75contentDeepToStringimpl(Bundle bundle) {
        StringBuilder sb = new StringBuilder((C2729e.e(bundle.size(), 429496729) * 5) + 2);
        SavedStateReaderKt__SavedStateReader_androidKt.contentDeepToString$SavedStateReaderKt__SavedStateReader_androidKt(bundle, sb, new ArrayList());
        String sb2 = sb.toString();
        t.d(sb2, "toString(...)");
        return sb2;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m76equalsimpl(Bundle bundle, Object obj) {
        return (obj instanceof SavedStateReader) && t.a(bundle, ((SavedStateReader) obj).m154unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m77equalsimpl0(Bundle bundle, Bundle bundle2) {
        return t.a(bundle, bundle2);
    }

    /* renamed from: getBinder-impl  reason: not valid java name */
    public static final IBinder m78getBinderimpl(Bundle bundle, String str) {
        t.e(str, "key");
        IBinder binder = bundle.getBinder(str);
        if (binder != null) {
            return binder;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getBinderOrNull-impl  reason: not valid java name */
    public static final IBinder m79getBinderOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getBinder(str);
    }

    /* renamed from: getBoolean-impl  reason: not valid java name */
    public static final boolean m80getBooleanimpl(Bundle bundle, String str) {
        t.e(str, "key");
        boolean z4 = bundle.getBoolean(str, false);
        if (z4 || !bundle.getBoolean(str, true)) {
            return z4;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getBooleanArray-impl  reason: not valid java name */
    public static final boolean[] m81getBooleanArrayimpl(Bundle bundle, String str) {
        t.e(str, "key");
        boolean[] booleanArray = bundle.getBooleanArray(str);
        if (booleanArray != null) {
            return booleanArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getBooleanArrayOrNull-impl  reason: not valid java name */
    public static final boolean[] m82getBooleanArrayOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getBooleanArray(str);
    }

    /* renamed from: getBooleanOrNull-impl  reason: not valid java name */
    public static final Boolean m83getBooleanOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        boolean z4 = bundle.getBoolean(str, false);
        if (z4 || !bundle.getBoolean(str, true)) {
            return Boolean.valueOf(z4);
        }
        return null;
    }

    /* renamed from: getChar-impl  reason: not valid java name */
    public static final char m84getCharimpl(Bundle bundle, String str) {
        t.e(str, "key");
        char c5 = bundle.getChar(str, 0);
        if (c5 != 0 || bundle.getChar(str, 65535) != 65535) {
            return c5;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getCharArray-impl  reason: not valid java name */
    public static final char[] m85getCharArrayimpl(Bundle bundle, String str) {
        t.e(str, "key");
        char[] charArray = bundle.getCharArray(str);
        if (charArray != null) {
            return charArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getCharArrayOrNull-impl  reason: not valid java name */
    public static final char[] m86getCharArrayOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getCharArray(str);
    }

    /* renamed from: getCharOrNull-impl  reason: not valid java name */
    public static final Character m87getCharOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        char c5 = bundle.getChar(str, 0);
        if (c5 == 0 && bundle.getChar(str, 65535) == 65535) {
            return null;
        }
        return Character.valueOf(c5);
    }

    /* renamed from: getCharSequence-impl  reason: not valid java name */
    public static final CharSequence m88getCharSequenceimpl(Bundle bundle, String str) {
        t.e(str, "key");
        CharSequence charSequence = bundle.getCharSequence(str);
        if (charSequence != null) {
            return charSequence;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getCharSequenceArray-impl  reason: not valid java name */
    public static final CharSequence[] m89getCharSequenceArrayimpl(Bundle bundle, String str) {
        t.e(str, "key");
        CharSequence[] charSequenceArray = bundle.getCharSequenceArray(str);
        if (charSequenceArray != null) {
            return charSequenceArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getCharSequenceArrayOrNull-impl  reason: not valid java name */
    public static final CharSequence[] m90getCharSequenceArrayOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getCharSequenceArray(str);
    }

    /* renamed from: getCharSequenceList-impl  reason: not valid java name */
    public static final List<CharSequence> m91getCharSequenceListimpl(Bundle bundle, String str) {
        t.e(str, "key");
        ArrayList<CharSequence> charSequenceArrayList = bundle.getCharSequenceArrayList(str);
        if (charSequenceArrayList != null) {
            return charSequenceArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getCharSequenceListOrNull-impl  reason: not valid java name */
    public static final List<CharSequence> m92getCharSequenceListOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getCharSequenceArrayList(str);
    }

    /* renamed from: getCharSequenceOrNull-impl  reason: not valid java name */
    public static final CharSequence m93getCharSequenceOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getCharSequence(str);
    }

    /* renamed from: getDouble-impl  reason: not valid java name */
    public static final double m94getDoubleimpl(Bundle bundle, String str) {
        t.e(str, "key");
        double d5 = bundle.getDouble(str, Double.MIN_VALUE);
        if (d5 != Double.MIN_VALUE || bundle.getDouble(str, Double.MAX_VALUE) != Double.MAX_VALUE) {
            return d5;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getDoubleArray-impl  reason: not valid java name */
    public static final double[] m95getDoubleArrayimpl(Bundle bundle, String str) {
        t.e(str, "key");
        double[] doubleArray = bundle.getDoubleArray(str);
        if (doubleArray != null) {
            return doubleArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getDoubleArrayOrNull-impl  reason: not valid java name */
    public static final double[] m96getDoubleArrayOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getDoubleArray(str);
    }

    /* renamed from: getDoubleOrNull-impl  reason: not valid java name */
    public static final Double m97getDoubleOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        double d5 = bundle.getDouble(str, Double.MIN_VALUE);
        if (d5 == Double.MIN_VALUE && bundle.getDouble(str, Double.MAX_VALUE) == Double.MAX_VALUE) {
            return null;
        }
        return Double.valueOf(d5);
    }

    /* renamed from: getFloat-impl  reason: not valid java name */
    public static final float m98getFloatimpl(Bundle bundle, String str) {
        t.e(str, "key");
        float f5 = bundle.getFloat(str, Float.MIN_VALUE);
        if (f5 != Float.MIN_VALUE || bundle.getFloat(str, Float.MAX_VALUE) != Float.MAX_VALUE) {
            return f5;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getFloatArray-impl  reason: not valid java name */
    public static final float[] m99getFloatArrayimpl(Bundle bundle, String str) {
        t.e(str, "key");
        float[] floatArray = bundle.getFloatArray(str);
        if (floatArray != null) {
            return floatArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getFloatArrayOrNull-impl  reason: not valid java name */
    public static final float[] m100getFloatArrayOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getFloatArray(str);
    }

    /* renamed from: getFloatOrNull-impl  reason: not valid java name */
    public static final Float m101getFloatOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        float f5 = bundle.getFloat(str, Float.MIN_VALUE);
        if (f5 == Float.MIN_VALUE && bundle.getFloat(str, Float.MAX_VALUE) == Float.MAX_VALUE) {
            return null;
        }
        return Float.valueOf(f5);
    }

    /* renamed from: getInt-impl  reason: not valid java name */
    public static final int m102getIntimpl(Bundle bundle, String str) {
        t.e(str, "key");
        int i5 = bundle.getInt(str, Integer.MIN_VALUE);
        if (i5 != Integer.MIN_VALUE || bundle.getInt(str, Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i5;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getIntArray-impl  reason: not valid java name */
    public static final int[] m103getIntArrayimpl(Bundle bundle, String str) {
        t.e(str, "key");
        int[] intArray = bundle.getIntArray(str);
        if (intArray != null) {
            return intArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getIntArrayOrNull-impl  reason: not valid java name */
    public static final int[] m104getIntArrayOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getIntArray(str);
    }

    /* renamed from: getIntList-impl  reason: not valid java name */
    public static final List<Integer> m105getIntListimpl(Bundle bundle, String str) {
        t.e(str, "key");
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getIntListOrNull-impl  reason: not valid java name */
    public static final List<Integer> m106getIntListOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getIntegerArrayList(str);
    }

    /* renamed from: getIntOrNull-impl  reason: not valid java name */
    public static final Integer m107getIntOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        int i5 = bundle.getInt(str, Integer.MIN_VALUE);
        if (i5 == Integer.MIN_VALUE && bundle.getInt(str, Integer.MAX_VALUE) == Integer.MAX_VALUE) {
            return null;
        }
        return Integer.valueOf(i5);
    }

    /* renamed from: getJavaSerializable-impl  reason: not valid java name */
    public static final <T extends Serializable> T m109getJavaSerializableimpl(Bundle bundle, String str, C2733c cVar) {
        t.e(str, "key");
        t.e(cVar, "serializableClass");
        T serializable = BundleCompat.getSerializable(bundle, str, C2582a.a(cVar));
        if (serializable != null) {
            return serializable;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getJavaSerializableOrNull-impl  reason: not valid java name */
    public static final <T extends Serializable> T m111getJavaSerializableOrNullimpl(Bundle bundle, String str, C2733c cVar) {
        t.e(str, "key");
        t.e(cVar, "serializableClass");
        return BundleCompat.getSerializable(bundle, str, C2582a.a(cVar));
    }

    /* renamed from: getLong-impl  reason: not valid java name */
    public static final long m112getLongimpl(Bundle bundle, String str) {
        t.e(str, "key");
        long j5 = bundle.getLong(str, Long.MIN_VALUE);
        if (j5 != Long.MIN_VALUE || bundle.getLong(str, Long.MAX_VALUE) != Long.MAX_VALUE) {
            return j5;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getLongArray-impl  reason: not valid java name */
    public static final long[] m113getLongArrayimpl(Bundle bundle, String str) {
        t.e(str, "key");
        long[] longArray = bundle.getLongArray(str);
        if (longArray != null) {
            return longArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getLongArrayOrNull-impl  reason: not valid java name */
    public static final long[] m114getLongArrayOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getLongArray(str);
    }

    /* renamed from: getLongOrNull-impl  reason: not valid java name */
    public static final Long m115getLongOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        long j5 = bundle.getLong(str, Long.MIN_VALUE);
        if (j5 == Long.MIN_VALUE && bundle.getLong(str, Long.MAX_VALUE) == Long.MAX_VALUE) {
            return null;
        }
        return Long.valueOf(j5);
    }

    /* renamed from: getParcelable-impl  reason: not valid java name */
    public static final <T extends Parcelable> T m117getParcelableimpl(Bundle bundle, String str, C2733c cVar) {
        t.e(str, "key");
        t.e(cVar, "parcelableClass");
        T t5 = (Parcelable) BundleCompat.getParcelable(bundle, str, C2582a.a(cVar));
        if (t5 != null) {
            return t5;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getParcelableArray-impl  reason: not valid java name */
    public static final <T extends Parcelable> T[] m119getParcelableArrayimpl(Bundle bundle, String str, C2733c cVar) {
        t.e(str, "key");
        t.e(cVar, "parcelableClass");
        T[] r12 = m121getParcelableArrayOrNullimpl(bundle, str, cVar);
        if (r12 != null) {
            return r12;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getParcelableArrayOrNull-impl  reason: not valid java name */
    public static final <T extends Parcelable> T[] m121getParcelableArrayOrNullimpl(Bundle bundle, String str, C2733c cVar) {
        t.e(str, "key");
        t.e(cVar, "parcelableClass");
        T[] parcelableArray = BundleCompat.getParcelableArray(bundle, str, C2582a.a(cVar));
        if (w.a(parcelableArray)) {
            return parcelableArray;
        }
        return null;
    }

    /* renamed from: getParcelableList-impl  reason: not valid java name */
    public static final <T extends Parcelable> List<T> m123getParcelableListimpl(Bundle bundle, String str, C2733c cVar) {
        t.e(str, "key");
        t.e(cVar, "parcelableClass");
        ArrayList parcelableArrayList = BundleCompat.getParcelableArrayList(bundle, str, C2582a.a(cVar));
        if (parcelableArrayList != null) {
            return parcelableArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getParcelableListOrNull-impl  reason: not valid java name */
    public static final <T extends Parcelable> List<T> m125getParcelableListOrNullimpl(Bundle bundle, String str, C2733c cVar) {
        t.e(str, "key");
        t.e(cVar, "parcelableClass");
        return BundleCompat.getParcelableArrayList(bundle, str, C2582a.a(cVar));
    }

    /* renamed from: getParcelableOrNull-impl  reason: not valid java name */
    public static final <T extends Parcelable> T m127getParcelableOrNullimpl(Bundle bundle, String str, C2733c cVar) {
        t.e(str, "key");
        t.e(cVar, "parcelableClass");
        return (Parcelable) BundleCompat.getParcelable(bundle, str, C2582a.a(cVar));
    }

    /* renamed from: getSavedState-impl  reason: not valid java name */
    public static final Bundle m128getSavedStateimpl(Bundle bundle, String str) {
        t.e(str, "key");
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 != null) {
            return bundle2;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getSavedStateArray-impl  reason: not valid java name */
    public static final Bundle[] m129getSavedStateArrayimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return (Bundle[]) m119getParcelableArrayimpl(bundle, str, M.b(Bundle.class));
    }

    /* renamed from: getSavedStateArrayOrNull-impl  reason: not valid java name */
    public static final Bundle[] m130getSavedStateArrayOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return (Bundle[]) m121getParcelableArrayOrNullimpl(bundle, str, M.b(Bundle.class));
    }

    /* renamed from: getSavedStateList-impl  reason: not valid java name */
    public static final List<Bundle> m131getSavedStateListimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return m123getParcelableListimpl(bundle, str, M.b(Bundle.class));
    }

    /* renamed from: getSavedStateListOrNull-impl  reason: not valid java name */
    public static final List<Bundle> m132getSavedStateListOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return m125getParcelableListOrNullimpl(bundle, str, M.b(Bundle.class));
    }

    /* renamed from: getSavedStateOrNull-impl  reason: not valid java name */
    public static final Bundle m133getSavedStateOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getBundle(str);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static final Size m134getSizeimpl(Bundle bundle, String str) {
        t.e(str, "key");
        Size size = bundle.getSize(str);
        if (size != null) {
            return size;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getSizeF-impl  reason: not valid java name */
    public static final SizeF m135getSizeFimpl(Bundle bundle, String str) {
        t.e(str, "key");
        SizeF sizeF = bundle.getSizeF(str);
        if (sizeF != null) {
            return sizeF;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getSizeFOrNull-impl  reason: not valid java name */
    public static final SizeF m136getSizeFOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getSizeF(str);
    }

    /* renamed from: getSizeOrNull-impl  reason: not valid java name */
    public static final Size m137getSizeOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getSize(str);
    }

    /* renamed from: getSparseParcelableArray-impl  reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m139getSparseParcelableArrayimpl(Bundle bundle, String str, C2733c cVar) {
        t.e(str, "key");
        t.e(cVar, "parcelableClass");
        SparseArray<T> r12 = m141getSparseParcelableArrayOrNullimpl(bundle, str, cVar);
        if (r12 != null) {
            return r12;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getSparseParcelableArrayOrNull-impl  reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m141getSparseParcelableArrayOrNullimpl(Bundle bundle, String str, C2733c cVar) {
        t.e(str, "key");
        t.e(cVar, "parcelableClass");
        return BundleCompat.getSparseParcelableArray(bundle, str, C2582a.a(cVar));
    }

    /* renamed from: getString-impl  reason: not valid java name */
    public static final String m142getStringimpl(Bundle bundle, String str) {
        t.e(str, "key");
        String string = bundle.getString(str);
        if (string != null) {
            return string;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getStringArray-impl  reason: not valid java name */
    public static final String[] m143getStringArrayimpl(Bundle bundle, String str) {
        t.e(str, "key");
        String[] stringArray = bundle.getStringArray(str);
        if (stringArray != null) {
            return stringArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getStringArrayOrNull-impl  reason: not valid java name */
    public static final String[] m144getStringArrayOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getStringArray(str);
    }

    /* renamed from: getStringList-impl  reason: not valid java name */
    public static final List<String> m145getStringListimpl(Bundle bundle, String str) {
        t.e(str, "key");
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList != null) {
            return stringArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new C2219h();
    }

    /* renamed from: getStringListOrNull-impl  reason: not valid java name */
    public static final List<String> m146getStringListOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getStringArrayList(str);
    }

    /* renamed from: getStringOrNull-impl  reason: not valid java name */
    public static final String m147getStringOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        return bundle.getString(str);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m148hashCodeimpl(Bundle bundle) {
        return bundle.hashCode();
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static final boolean m149isEmptyimpl(Bundle bundle) {
        return bundle.isEmpty();
    }

    /* renamed from: isNull-impl  reason: not valid java name */
    public static final boolean m150isNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        if (!m72containsimpl(bundle, str) || bundle.get(str) != null) {
            return false;
        }
        return true;
    }

    /* renamed from: size-impl  reason: not valid java name */
    public static final int m151sizeimpl(Bundle bundle) {
        return bundle.size();
    }

    /* renamed from: toMap-impl  reason: not valid java name */
    public static final Map<String, Object> m152toMapimpl(Bundle bundle) {
        Map d5 = X2.M.d(bundle.size());
        for (String next : bundle.keySet()) {
            t.b(next);
            d5.put(next, bundle.get(next));
        }
        return X2.M.b(d5);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m153toStringimpl(Bundle bundle) {
        return "SavedStateReader(source=" + bundle + ')';
    }

    public boolean equals(Object obj) {
        return m76equalsimpl(this.source, obj);
    }

    public int hashCode() {
        return m148hashCodeimpl(this.source);
    }

    public String toString() {
        return m153toStringimpl(this.source);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Bundle m154unboximpl() {
        return this.source;
    }

    /* renamed from: getJavaSerializable-impl  reason: not valid java name */
    public static final /* synthetic */ <T extends Serializable> T m108getJavaSerializableimpl(Bundle bundle, String str) {
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m109getJavaSerializableimpl(bundle, str, M.b(Serializable.class));
    }

    /* renamed from: getJavaSerializableOrNull-impl  reason: not valid java name */
    public static final /* synthetic */ <T extends Serializable> T m110getJavaSerializableOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m111getJavaSerializableOrNullimpl(bundle, str, M.b(Serializable.class));
    }

    /* renamed from: getParcelable-impl  reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T m116getParcelableimpl(Bundle bundle, String str) {
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m117getParcelableimpl(bundle, str, M.b(Parcelable.class));
    }

    /* renamed from: getParcelableArray-impl  reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T[] m118getParcelableArrayimpl(Bundle bundle, String str) {
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m119getParcelableArrayimpl(bundle, str, M.b(Parcelable.class));
    }

    /* renamed from: getParcelableArrayOrNull-impl  reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T[] m120getParcelableArrayOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m121getParcelableArrayOrNullimpl(bundle, str, M.b(Parcelable.class));
    }

    /* renamed from: getParcelableListOrNull-impl  reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> List<T> m124getParcelableListOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m125getParcelableListOrNullimpl(bundle, str, M.b(Parcelable.class));
    }

    /* renamed from: getParcelableOrNull-impl  reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T m126getParcelableOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m127getParcelableOrNullimpl(bundle, str, M.b(Parcelable.class));
    }

    /* renamed from: getSparseParcelableArray-impl  reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> SparseArray<T> m138getSparseParcelableArrayimpl(Bundle bundle, String str) {
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m139getSparseParcelableArrayimpl(bundle, str, M.b(Parcelable.class));
    }

    /* renamed from: getSparseParcelableArrayOrNull-impl  reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> SparseArray<T> m140getSparseParcelableArrayOrNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m141getSparseParcelableArrayOrNullimpl(bundle, str, M.b(Parcelable.class));
    }

    /* renamed from: getParcelableList-impl  reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> List<T> m122getParcelableListimpl(Bundle bundle, String str) {
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m123getParcelableListimpl(bundle, str, M.b(Parcelable.class));
    }
}
