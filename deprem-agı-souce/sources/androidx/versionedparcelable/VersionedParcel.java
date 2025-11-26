package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int i5, String str) {
        switch (i5) {
            case EX_PARCELABLE /*-9*/:
                return (Exception) readParcelable();
            case EX_UNSUPPORTED_OPERATION /*-7*/:
                return new UnsupportedOperationException(str);
            case EX_NETWORK_MAIN_THREAD /*-6*/:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
            default:
                return new RuntimeException("Unknown exception code: " + i5 + " msg " + str);
        }
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.mParcelizerCache.put(cls.getName(), cls3);
        return cls3;
    }

    private Method getReadMethod(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mReadCache.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Class<VersionedParcel> cls = VersionedParcel.class;
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.mReadCache.put(str, declaredMethod);
        return declaredMethod;
    }

    @NonNull
    protected static Throwable getRootCause(@NonNull Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private <T> int getType(T t5) {
        if (t5 instanceof String) {
            return 4;
        }
        if (t5 instanceof Parcelable) {
            return 2;
        }
        if (t5 instanceof VersionedParcelable) {
            return 1;
        }
        if (t5 instanceof Serializable) {
            return 3;
        }
        if (t5 instanceof IBinder) {
            return 5;
        }
        if (t5 instanceof Integer) {
            return 7;
        }
        if (t5 instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t5.getClass().getName() + " cannot be VersionedParcelled");
    }

    private Method getWriteMethod(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.mWriteCache.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class findParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = findParcelClass.getDeclaredMethod("write", new Class[]{cls, VersionedParcel.class});
        this.mWriteCache.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private <T, S extends Collection<T>> S readCollection(S s5) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    s5.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    s5.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    s5.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    s5.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    s5.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return s5;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> collection, int i5) {
        setOutputField(i5);
        writeCollection(collection);
    }

    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e5);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void closeField();

    /* access modifiers changed from: protected */
    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] tArr, int i5) {
        if (!readField(i5)) {
            return tArr;
        }
        return readArray(tArr);
    }

    /* access modifiers changed from: protected */
    public abstract boolean readBoolean();

    public boolean readBoolean(boolean z4, int i5) {
        if (!readField(i5)) {
            return z4;
        }
        return readBoolean();
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i5) {
        if (!readField(i5)) {
            return zArr;
        }
        return readBooleanArray();
    }

    /* access modifiers changed from: protected */
    public abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int i5) {
        if (!readField(i5)) {
            return bundle;
        }
        return readBundle();
    }

    public byte readByte(byte b5, int i5) {
        if (!readField(i5)) {
            return b5;
        }
        return (byte) (readInt() & 255);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i5) {
        if (!readField(i5)) {
            return bArr;
        }
        return readByteArray();
    }

    public char[] readCharArray(char[] cArr, int i5) {
        if (!readField(i5)) {
            return cArr;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        char[] cArr2 = new char[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            cArr2[i6] = (char) readInt();
        }
        return cArr2;
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int i5) {
        if (!readField(i5)) {
            return charSequence;
        }
        return readCharSequence();
    }

    /* access modifiers changed from: protected */
    public abstract double readDouble();

    public double readDouble(double d5, int i5) {
        if (!readField(i5)) {
            return d5;
        }
        return readDouble();
    }

    public double[] readDoubleArray(double[] dArr, int i5) {
        if (!readField(i5)) {
            return dArr;
        }
        return readDoubleArray();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r2 = readExceptionCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Exception readException(java.lang.Exception r1, int r2) {
        /*
            r0 = this;
            boolean r2 = r0.readField(r2)
            if (r2 != 0) goto L_0x0007
            goto L_0x0015
        L_0x0007:
            int r2 = r0.readExceptionCode()
            if (r2 == 0) goto L_0x0015
            java.lang.String r1 = r0.readString()
            java.lang.Exception r1 = r0.readException((int) r2, (java.lang.String) r1)
        L_0x0015:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.versionedparcelable.VersionedParcel.readException(java.lang.Exception, int):java.lang.Exception");
    }

    /* access modifiers changed from: protected */
    public abstract boolean readField(int i5);

    /* access modifiers changed from: protected */
    public abstract float readFloat();

    public float readFloat(float f5, int i5) {
        if (!readField(i5)) {
            return f5;
        }
        return readFloat();
    }

    public float[] readFloatArray(float[] fArr, int i5) {
        if (!readField(i5)) {
            return fArr;
        }
        return readFloatArray();
    }

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (VersionedParcelable) getReadMethod(str).invoke((Object) null, new Object[]{versionedParcel});
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e8);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int readInt();

    public int readInt(int i5, int i6) {
        if (!readField(i6)) {
            return i5;
        }
        return readInt();
    }

    public int[] readIntArray(int[] iArr, int i5) {
        if (!readField(i5)) {
            return iArr;
        }
        return readIntArray();
    }

    public <T> List<T> readList(List<T> list, int i5) {
        if (!readField(i5)) {
            return list;
        }
        return (List) readCollection(new ArrayList());
    }

    /* access modifiers changed from: protected */
    public abstract long readLong();

    public long readLong(long j5, int i5) {
        if (!readField(i5)) {
            return j5;
        }
        return readLong();
    }

    public long[] readLongArray(long[] jArr, int i5) {
        if (!readField(i5)) {
            return jArr;
        }
        return readLongArray();
    }

    public <K, V> Map<K, V> readMap(Map<K, V> map, int i5) {
        if (!readField(i5)) {
            return map;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (readInt != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            readCollection(arrayList);
            readCollection(arrayList2);
            for (int i6 = 0; i6 < readInt; i6++) {
                arrayMap.put(arrayList.get(i6), arrayList2.get(i6));
            }
        }
        return arrayMap;
    }

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t5, int i5) {
        if (!readField(i5)) {
            return t5;
        }
        return readParcelable();
    }

    /* access modifiers changed from: protected */
    public Serializable readSerializable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(readByteArray())) {
                /* access modifiers changed from: protected */
                public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    if (cls != null) {
                        return cls;
                    }
                    return super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e5) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + readString + ")", e5);
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + readString + ")", e6);
        }
    }

    public <T> Set<T> readSet(Set<T> set, int i5) {
        if (!readField(i5)) {
            return set;
        }
        return (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size size, int i5) {
        if (!readField(i5)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF sizeF, int i5) {
        if (!readField(i5)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i5) {
        if (!readField(i5)) {
            return sparseBooleanArray;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(readInt);
        for (int i6 = 0; i6 < readInt; i6++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    /* access modifiers changed from: protected */
    public abstract String readString();

    public String readString(String str, int i5) {
        if (!readField(i5)) {
            return str;
        }
        return readString();
    }

    /* access modifiers changed from: protected */
    public abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int i5) {
        if (!readField(i5)) {
            return iBinder;
        }
        return readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t5, int i5) {
        if (!readField(i5)) {
            return t5;
        }
        return readVersionedParcelable();
    }

    /* access modifiers changed from: protected */
    public abstract void setOutputField(int i5);

    public void setSerializationFlags(boolean z4, boolean z5) {
    }

    public <T> void writeArray(T[] tArr, int i5) {
        setOutputField(i5);
        writeArray(tArr);
    }

    /* access modifiers changed from: protected */
    public abstract void writeBoolean(boolean z4);

    public void writeBoolean(boolean z4, int i5) {
        setOutputField(i5);
        writeBoolean(z4);
    }

    public void writeBooleanArray(boolean[] zArr, int i5) {
        setOutputField(i5);
        writeBooleanArray(zArr);
    }

    /* access modifiers changed from: protected */
    public abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle bundle, int i5) {
        setOutputField(i5);
        writeBundle(bundle);
    }

    public void writeByte(byte b5, int i5) {
        setOutputField(i5);
        writeInt(b5);
    }

    /* access modifiers changed from: protected */
    public abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i5) {
        setOutputField(i5);
        writeByteArray(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract void writeByteArray(byte[] bArr, int i5, int i6);

    public void writeCharArray(char[] cArr, int i5) {
        setOutputField(i5);
        if (cArr != null) {
            writeInt(r4);
            for (char writeInt : cArr) {
                writeInt(writeInt);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public abstract void writeCharSequence(CharSequence charSequence);

    public void writeCharSequence(CharSequence charSequence, int i5) {
        setOutputField(i5);
        writeCharSequence(charSequence);
    }

    /* access modifiers changed from: protected */
    public abstract void writeDouble(double d5);

    public void writeDouble(double d5, int i5) {
        setOutputField(i5);
        writeDouble(d5);
    }

    public void writeDoubleArray(double[] dArr, int i5) {
        setOutputField(i5);
        writeDoubleArray(dArr);
    }

    public void writeException(Exception exc, int i5) {
        int i6;
        setOutputField(i5);
        if (exc == null) {
            writeNoException();
            return;
        }
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i6 = EX_PARCELABLE;
        } else if (exc instanceof SecurityException) {
            i6 = -1;
        } else if (exc instanceof BadParcelableException) {
            i6 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i6 = -3;
        } else if (exc instanceof NullPointerException) {
            i6 = -4;
        } else if (exc instanceof IllegalStateException) {
            i6 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i6 = EX_NETWORK_MAIN_THREAD;
        } else if (exc instanceof UnsupportedOperationException) {
            i6 = EX_UNSUPPORTED_OPERATION;
        } else {
            i6 = 0;
        }
        writeInt(i6);
        if (i6 != 0) {
            writeString(exc.getMessage());
            if (i6 == EX_PARCELABLE) {
                writeParcelable((Parcelable) exc);
            }
        } else if (exc instanceof RuntimeException) {
            throw ((RuntimeException) exc);
        } else {
            throw new RuntimeException(exc);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void writeFloat(float f5);

    public void writeFloat(float f5, int i5) {
        setOutputField(i5);
        writeFloat(f5);
    }

    public void writeFloatArray(float[] fArr, int i5) {
        setOutputField(i5);
        writeFloatArray(fArr);
    }

    /* access modifiers changed from: protected */
    public abstract void writeInt(int i5);

    public void writeInt(int i5, int i6) {
        setOutputField(i6);
        writeInt(i5);
    }

    public void writeIntArray(int[] iArr, int i5) {
        setOutputField(i5);
        writeIntArray(iArr);
    }

    public <T> void writeList(List<T> list, int i5) {
        writeCollection(list, i5);
    }

    /* access modifiers changed from: protected */
    public abstract void writeLong(long j5);

    public void writeLong(long j5, int i5) {
        setOutputField(i5);
        writeLong(j5);
    }

    public void writeLongArray(long[] jArr, int i5) {
        setOutputField(i5);
        writeLongArray(jArr);
    }

    public <K, V> void writeMap(Map<K, V> map, int i5) {
        setOutputField(i5);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(next.getKey());
                arrayList2.add(next.getValue());
            }
            writeCollection(arrayList);
            writeCollection(arrayList2);
        }
    }

    /* access modifiers changed from: protected */
    public void writeNoException() {
        writeInt(0);
    }

    /* access modifiers changed from: protected */
    public abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i5) {
        setOutputField(i5);
        writeParcelable(parcelable);
    }

    public void writeSerializable(Serializable serializable, int i5) {
        setOutputField(i5);
        writeSerializable(serializable);
    }

    public <T> void writeSet(Set<T> set, int i5) {
        writeCollection(set, i5);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size size, int i5) {
        boolean z4;
        setOutputField(i5);
        if (size != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        writeBoolean(z4);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF sizeF, int i5) {
        boolean z4;
        setOutputField(i5);
        if (sizeF != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        writeBoolean(z4);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i5) {
        setOutputField(i5);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            writeInt(sparseBooleanArray.keyAt(i6));
            writeBoolean(sparseBooleanArray.valueAt(i6));
        }
    }

    /* access modifiers changed from: protected */
    public abstract void writeString(String str);

    public void writeString(String str, int i5) {
        setOutputField(i5);
        writeString(str);
    }

    /* access modifiers changed from: protected */
    public abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder iBinder, int i5) {
        setOutputField(i5);
        writeStrongBinder(iBinder);
    }

    /* access modifiers changed from: protected */
    public abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface iInterface, int i5) {
        setOutputField(i5);
        writeStrongInterface(iInterface);
    }

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> void writeToParcel(T t5, VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t5.getClass()).invoke((Object) null, new Object[]{t5, versionedParcel});
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e8);
        }
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i5) {
        setOutputField(i5);
        writeVersionedParcelable(versionedParcelable);
    }

    private <T> void writeCollection(Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
            return;
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    for (T writeVersionedParcelable : collection) {
                        writeVersionedParcelable(writeVersionedParcelable);
                    }
                    return;
                case 2:
                    for (T writeParcelable : collection) {
                        writeParcelable(writeParcelable);
                    }
                    return;
                case 3:
                    for (T writeSerializable : collection) {
                        writeSerializable(writeSerializable);
                    }
                    return;
                case 4:
                    for (T writeString : collection) {
                        writeString(writeString);
                    }
                    return;
                case 5:
                    for (T writeStrongBinder : collection) {
                        writeStrongBinder(writeStrongBinder);
                    }
                    return;
                case 7:
                    for (T intValue : collection) {
                        writeInt(intValue.intValue());
                    }
                    return;
                case 8:
                    for (T floatValue : collection) {
                        writeFloat(floatValue.floatValue());
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString((String) null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e5) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ")", e5);
        }
    }

    /* access modifiers changed from: protected */
    public <T> T[] readArray(T[] tArr) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return arrayList.toArray(tArr);
    }

    /* access modifiers changed from: protected */
    public boolean[] readBooleanArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            zArr[i5] = readInt() != 0;
        }
        return zArr;
    }

    /* access modifiers changed from: protected */
    public double[] readDoubleArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        double[] dArr = new double[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            dArr[i5] = readDouble();
        }
        return dArr;
    }

    /* access modifiers changed from: protected */
    public float[] readFloatArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            fArr[i5] = readFloat();
        }
        return fArr;
    }

    /* access modifiers changed from: protected */
    public int[] readIntArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            iArr[i5] = readInt();
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public long[] readLongArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        long[] jArr = new long[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            jArr[i5] = readLong();
        }
        return jArr;
    }

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return readFromParcel(readString, createSubParcel());
    }

    /* access modifiers changed from: protected */
    public <T> void writeArray(T[] tArr) {
        if (tArr == null) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i5 = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i5 < length) {
                    writeVersionedParcelable((VersionedParcelable) tArr[i5]);
                    i5++;
                }
            } else if (type == 2) {
                while (i5 < length) {
                    writeParcelable((Parcelable) tArr[i5]);
                    i5++;
                }
            } else if (type == 3) {
                while (i5 < length) {
                    writeSerializable((Serializable) tArr[i5]);
                    i5++;
                }
            } else if (type == 4) {
                while (i5 < length) {
                    writeString((String) tArr[i5]);
                    i5++;
                }
            } else if (type == 5) {
                while (i5 < length) {
                    writeStrongBinder((IBinder) tArr[i5]);
                    i5++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void writeBooleanArray(boolean[] zArr) {
        if (zArr != null) {
            writeInt(r0);
            for (boolean z4 : zArr) {
                writeInt(z4 ? 1 : 0);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeByteArray(byte[] bArr, int i5, int i6, int i7) {
        setOutputField(i7);
        writeByteArray(bArr, i5, i6);
    }

    /* access modifiers changed from: protected */
    public void writeDoubleArray(double[] dArr) {
        if (dArr != null) {
            writeInt(r0);
            for (double writeDouble : dArr) {
                writeDouble(writeDouble);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void writeFloatArray(float[] fArr) {
        if (fArr != null) {
            writeInt(r0);
            for (float writeFloat : fArr) {
                writeFloat(writeFloat);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void writeIntArray(int[] iArr) {
        if (iArr != null) {
            writeInt(r0);
            for (int writeInt : iArr) {
                writeInt(writeInt);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void writeLongArray(long[] jArr) {
        if (jArr != null) {
            writeInt(r0);
            for (long writeLong : jArr) {
                writeLong(writeLong);
            }
            return;
        }
        writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString((String) null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel createSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, createSubParcel);
        createSubParcel.closeField();
    }

    private Exception readException(int i5, String str) {
        return createException(i5, str);
    }
}
