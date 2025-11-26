package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.t;

public final class SavedStateWriter {
    private final Bundle source;

    private /* synthetic */ SavedStateWriter(Bundle bundle) {
        this.source = bundle;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ SavedStateWriter m155boximpl(Bundle bundle) {
        return new SavedStateWriter(bundle);
    }

    /* renamed from: clear-impl  reason: not valid java name */
    public static final void m156clearimpl(Bundle bundle) {
        bundle.clear();
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Bundle m157constructorimpl(Bundle bundle) {
        t.e(bundle, "source");
        return bundle;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m158equalsimpl(Bundle bundle, Object obj) {
        return (obj instanceof SavedStateWriter) && t.a(bundle, ((SavedStateWriter) obj).m195unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m159equalsimpl0(Bundle bundle, Bundle bundle2) {
        return t.a(bundle, bundle2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m160hashCodeimpl(Bundle bundle) {
        return bundle.hashCode();
    }

    /* renamed from: putAll-impl  reason: not valid java name */
    public static final void m161putAllimpl(Bundle bundle, Bundle bundle2) {
        t.e(bundle2, TypedValues.TransitionType.S_FROM);
        bundle.putAll(bundle2);
    }

    /* renamed from: putBinder-impl  reason: not valid java name */
    public static final void m162putBinderimpl(Bundle bundle, String str, IBinder iBinder) {
        t.e(str, "key");
        t.e(iBinder, "value");
        bundle.putBinder(str, iBinder);
    }

    /* renamed from: putBoolean-impl  reason: not valid java name */
    public static final void m163putBooleanimpl(Bundle bundle, String str, boolean z4) {
        t.e(str, "key");
        bundle.putBoolean(str, z4);
    }

    /* renamed from: putBooleanArray-impl  reason: not valid java name */
    public static final void m164putBooleanArrayimpl(Bundle bundle, String str, boolean[] zArr) {
        t.e(str, "key");
        t.e(zArr, "value");
        bundle.putBooleanArray(str, zArr);
    }

    /* renamed from: putChar-impl  reason: not valid java name */
    public static final void m165putCharimpl(Bundle bundle, String str, char c5) {
        t.e(str, "key");
        bundle.putChar(str, c5);
    }

    /* renamed from: putCharArray-impl  reason: not valid java name */
    public static final void m166putCharArrayimpl(Bundle bundle, String str, char[] cArr) {
        t.e(str, "key");
        t.e(cArr, "value");
        bundle.putCharArray(str, cArr);
    }

    /* renamed from: putCharSequence-impl  reason: not valid java name */
    public static final void m167putCharSequenceimpl(Bundle bundle, String str, CharSequence charSequence) {
        t.e(str, "key");
        t.e(charSequence, "value");
        bundle.putCharSequence(str, charSequence);
    }

    /* renamed from: putCharSequenceArray-impl  reason: not valid java name */
    public static final void m168putCharSequenceArrayimpl(Bundle bundle, String str, CharSequence[] charSequenceArr) {
        t.e(str, "key");
        t.e(charSequenceArr, "value");
        bundle.putCharSequenceArray(str, charSequenceArr);
    }

    /* renamed from: putCharSequenceList-impl  reason: not valid java name */
    public static final void m169putCharSequenceListimpl(Bundle bundle, String str, List<? extends CharSequence> list) {
        t.e(str, "key");
        t.e(list, "value");
        bundle.putCharSequenceArrayList(str, SavedStateWriterKt.toArrayListUnsafe(list));
    }

    /* renamed from: putDouble-impl  reason: not valid java name */
    public static final void m170putDoubleimpl(Bundle bundle, String str, double d5) {
        t.e(str, "key");
        bundle.putDouble(str, d5);
    }

    /* renamed from: putDoubleArray-impl  reason: not valid java name */
    public static final void m171putDoubleArrayimpl(Bundle bundle, String str, double[] dArr) {
        t.e(str, "key");
        t.e(dArr, "value");
        bundle.putDoubleArray(str, dArr);
    }

    /* renamed from: putFloat-impl  reason: not valid java name */
    public static final void m172putFloatimpl(Bundle bundle, String str, float f5) {
        t.e(str, "key");
        bundle.putFloat(str, f5);
    }

    /* renamed from: putFloatArray-impl  reason: not valid java name */
    public static final void m173putFloatArrayimpl(Bundle bundle, String str, float[] fArr) {
        t.e(str, "key");
        t.e(fArr, "value");
        bundle.putFloatArray(str, fArr);
    }

    /* renamed from: putInt-impl  reason: not valid java name */
    public static final void m174putIntimpl(Bundle bundle, String str, int i5) {
        t.e(str, "key");
        bundle.putInt(str, i5);
    }

    /* renamed from: putIntArray-impl  reason: not valid java name */
    public static final void m175putIntArrayimpl(Bundle bundle, String str, int[] iArr) {
        t.e(str, "key");
        t.e(iArr, "value");
        bundle.putIntArray(str, iArr);
    }

    /* renamed from: putIntList-impl  reason: not valid java name */
    public static final void m176putIntListimpl(Bundle bundle, String str, List<Integer> list) {
        t.e(str, "key");
        t.e(list, "value");
        bundle.putIntegerArrayList(str, SavedStateWriterKt.toArrayListUnsafe(list));
    }

    /* renamed from: putJavaSerializable-impl  reason: not valid java name */
    public static final <T extends Serializable> void m177putJavaSerializableimpl(Bundle bundle, String str, T t5) {
        t.e(str, "key");
        t.e(t5, "value");
        bundle.putSerializable(str, t5);
    }

    /* renamed from: putLong-impl  reason: not valid java name */
    public static final void m178putLongimpl(Bundle bundle, String str, long j5) {
        t.e(str, "key");
        bundle.putLong(str, j5);
    }

    /* renamed from: putLongArray-impl  reason: not valid java name */
    public static final void m179putLongArrayimpl(Bundle bundle, String str, long[] jArr) {
        t.e(str, "key");
        t.e(jArr, "value");
        bundle.putLongArray(str, jArr);
    }

    /* renamed from: putNull-impl  reason: not valid java name */
    public static final void m180putNullimpl(Bundle bundle, String str) {
        t.e(str, "key");
        bundle.putString(str, (String) null);
    }

    /* renamed from: putParcelable-impl  reason: not valid java name */
    public static final <T extends Parcelable> void m181putParcelableimpl(Bundle bundle, String str, T t5) {
        t.e(str, "key");
        t.e(t5, "value");
        bundle.putParcelable(str, t5);
    }

    /* renamed from: putParcelableArray-impl  reason: not valid java name */
    public static final <T extends Parcelable> void m182putParcelableArrayimpl(Bundle bundle, String str, T[] tArr) {
        t.e(str, "key");
        t.e(tArr, "value");
        bundle.putParcelableArray(str, tArr);
    }

    /* renamed from: putParcelableList-impl  reason: not valid java name */
    public static final <T extends Parcelable> void m183putParcelableListimpl(Bundle bundle, String str, List<? extends T> list) {
        t.e(str, "key");
        t.e(list, "value");
        bundle.putParcelableArrayList(str, SavedStateWriterKt.toArrayListUnsafe(list));
    }

    /* renamed from: putSavedState-impl  reason: not valid java name */
    public static final void m184putSavedStateimpl(Bundle bundle, String str, Bundle bundle2) {
        t.e(str, "key");
        t.e(bundle2, "value");
        bundle.putBundle(str, bundle2);
    }

    /* renamed from: putSavedStateArray-impl  reason: not valid java name */
    public static final void m185putSavedStateArrayimpl(Bundle bundle, String str, Bundle[] bundleArr) {
        t.e(str, "key");
        t.e(bundleArr, "value");
        m182putParcelableArrayimpl(bundle, str, (Parcelable[]) bundleArr);
    }

    /* renamed from: putSavedStateList-impl  reason: not valid java name */
    public static final void m186putSavedStateListimpl(Bundle bundle, String str, List<Bundle> list) {
        t.e(str, "key");
        t.e(list, "value");
        m183putParcelableListimpl(bundle, str, list);
    }

    /* renamed from: putSize-impl  reason: not valid java name */
    public static final void m187putSizeimpl(Bundle bundle, String str, Size size) {
        t.e(str, "key");
        t.e(size, "value");
        bundle.putSize(str, size);
    }

    /* renamed from: putSizeF-impl  reason: not valid java name */
    public static final void m188putSizeFimpl(Bundle bundle, String str, SizeF sizeF) {
        t.e(str, "key");
        t.e(sizeF, "value");
        bundle.putSizeF(str, sizeF);
    }

    /* renamed from: putSparseParcelableArray-impl  reason: not valid java name */
    public static final <T extends Parcelable> void m189putSparseParcelableArrayimpl(Bundle bundle, String str, SparseArray<T> sparseArray) {
        t.e(str, "key");
        t.e(sparseArray, "value");
        bundle.putSparseParcelableArray(str, sparseArray);
    }

    /* renamed from: putString-impl  reason: not valid java name */
    public static final void m190putStringimpl(Bundle bundle, String str, String str2) {
        t.e(str, "key");
        t.e(str2, "value");
        bundle.putString(str, str2);
    }

    /* renamed from: putStringArray-impl  reason: not valid java name */
    public static final void m191putStringArrayimpl(Bundle bundle, String str, String[] strArr) {
        t.e(str, "key");
        t.e(strArr, "value");
        bundle.putStringArray(str, strArr);
    }

    /* renamed from: putStringList-impl  reason: not valid java name */
    public static final void m192putStringListimpl(Bundle bundle, String str, List<String> list) {
        t.e(str, "key");
        t.e(list, "value");
        bundle.putStringArrayList(str, SavedStateWriterKt.toArrayListUnsafe(list));
    }

    /* renamed from: remove-impl  reason: not valid java name */
    public static final void m193removeimpl(Bundle bundle, String str) {
        t.e(str, "key");
        bundle.remove(str);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m194toStringimpl(Bundle bundle) {
        return "SavedStateWriter(source=" + bundle + ')';
    }

    public boolean equals(Object obj) {
        return m158equalsimpl(this.source, obj);
    }

    public int hashCode() {
        return m160hashCodeimpl(this.source);
    }

    public String toString() {
        return m194toStringimpl(this.source);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Bundle m195unboximpl() {
        return this.source;
    }
}
