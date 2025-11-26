package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE;
    private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
    private static final int BYTE_ARRAY_ALIGNMENT;
    static final long BYTE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_INDEX_SCALE;
    private static final long FLOAT_ARRAY_BASE_OFFSET;
    private static final long FLOAT_ARRAY_INDEX_SCALE;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    private static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    private static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    static final boolean IS_BIG_ENDIAN;
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final MemoryAccessor MEMORY_ACCESSOR = getMemoryAccessor();
    private static final Class<?> MEMORY_CLASS = Android.getMemoryClass();
    private static final long OBJECT_ARRAY_BASE_OFFSET;
    private static final long OBJECT_ARRAY_INDEX_SCALE;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE = getUnsafe();

    private static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        private static int smallAddress(long j5) {
            return (int) j5;
        }

        public void copyMemory(long j5, byte[] bArr, long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j5) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getBooleanBigEndian(obj, j5);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j5);
        }

        public byte getByte(Object obj, long j5) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j5);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j5);
        }

        public double getDouble(Object obj, long j5) {
            return Double.longBitsToDouble(getLong(obj, j5));
        }

        public float getFloat(Object obj, long j5) {
            return Float.intBitsToFloat(getInt(obj, j5));
        }

        public int getInt(long j5) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j5) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j5, boolean z4) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j5, z4);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j5, z4);
            }
        }

        public void putByte(Object obj, long j5, byte b5) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j5, b5);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j5, b5);
            }
        }

        public void putDouble(Object obj, long j5, double d5) {
            putLong(obj, j5, Double.doubleToLongBits(d5));
        }

        public void putFloat(Object obj, long j5, float f5) {
            putInt(obj, j5, Float.floatToIntBits(f5));
        }

        public void putInt(long j5, int i5) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j5, long j6) {
            throw new UnsupportedOperationException();
        }

        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        public void copyMemory(byte[] bArr, long j5, long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(long j5) {
            throw new UnsupportedOperationException();
        }

        public void putByte(long j5, byte b5) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j5, byte[] bArr, long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j5) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getBooleanBigEndian(obj, j5);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j5);
        }

        public byte getByte(Object obj, long j5) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j5);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j5);
        }

        public double getDouble(Object obj, long j5) {
            return Double.longBitsToDouble(getLong(obj, j5));
        }

        public float getFloat(Object obj, long j5) {
            return Float.intBitsToFloat(getInt(obj, j5));
        }

        public int getInt(long j5) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j5) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j5, boolean z4) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j5, z4);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j5, z4);
            }
        }

        public void putByte(Object obj, long j5, byte b5) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j5, b5);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j5, b5);
            }
        }

        public void putDouble(Object obj, long j5, double d5) {
            putLong(obj, j5, Double.doubleToLongBits(d5));
        }

        public void putFloat(Object obj, long j5, float f5) {
            putInt(obj, j5, Float.floatToIntBits(f5));
        }

        public void putInt(long j5, int i5) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j5, long j6) {
            throw new UnsupportedOperationException();
        }

        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        public void copyMemory(byte[] bArr, long j5, long j6, long j7) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(long j5) {
            throw new UnsupportedOperationException();
        }

        public void putByte(long j5, byte b5) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j5, byte[] bArr, long j6, long j7) {
            this.unsafe.copyMemory((Object) null, j5, bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j6, j7);
        }

        public boolean getBoolean(Object obj, long j5) {
            return this.unsafe.getBoolean(obj, j5);
        }

        public byte getByte(Object obj, long j5) {
            return this.unsafe.getByte(obj, j5);
        }

        public double getDouble(Object obj, long j5) {
            return this.unsafe.getDouble(obj, j5);
        }

        public float getFloat(Object obj, long j5) {
            return this.unsafe.getFloat(obj, j5);
        }

        public int getInt(long j5) {
            return this.unsafe.getInt(j5);
        }

        public long getLong(long j5) {
            return this.unsafe.getLong(j5);
        }

        public Object getStaticObject(Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }

        public void putBoolean(Object obj, long j5, boolean z4) {
            this.unsafe.putBoolean(obj, j5, z4);
        }

        public void putByte(Object obj, long j5, byte b5) {
            this.unsafe.putByte(obj, j5, b5);
        }

        public void putDouble(Object obj, long j5, double d5) {
            this.unsafe.putDouble(obj, j5, d5);
        }

        public void putFloat(Object obj, long j5, float f5) {
            this.unsafe.putFloat(obj, j5, f5);
        }

        public void putInt(long j5, int i5) {
            this.unsafe.putInt(j5, i5);
        }

        public void putLong(long j5, long j6) {
            this.unsafe.putLong(j5, j6);
        }

        public boolean supportsUnsafeArrayOperations() {
            Class<Object> cls = Object.class;
            if (!super.supportsUnsafeArrayOperations()) {
                return false;
            }
            try {
                Class<?> cls2 = this.unsafe.getClass();
                Class cls3 = Long.TYPE;
                cls2.getMethod("getByte", new Class[]{cls, cls3});
                cls2.getMethod("putByte", new Class[]{cls, cls3, Byte.TYPE});
                cls2.getMethod("getBoolean", new Class[]{cls, cls3});
                cls2.getMethod("putBoolean", new Class[]{cls, cls3, Boolean.TYPE});
                cls2.getMethod("getFloat", new Class[]{cls, cls3});
                cls2.getMethod("putFloat", new Class[]{cls, cls3, Float.TYPE});
                cls2.getMethod("getDouble", new Class[]{cls, cls3});
                cls2.getMethod("putDouble", new Class[]{cls, cls3, Double.TYPE});
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            if (!super.supportsUnsafeByteBufferOperations()) {
                return false;
            }
            try {
                Class<?> cls = this.unsafe.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", new Class[]{cls2});
                cls.getMethod("putByte", new Class[]{cls2, Byte.TYPE});
                cls.getMethod("getInt", new Class[]{cls2});
                cls.getMethod("putInt", new Class[]{cls2, Integer.TYPE});
                cls.getMethod("getLong", new Class[]{cls2});
                cls.getMethod("putLong", new Class[]{cls2, cls2});
                cls.getMethod("copyMemory", new Class[]{cls2, cls2, cls2});
                Class<Object> cls3 = Object.class;
                cls.getMethod("copyMemory", new Class[]{cls3, cls2, cls3, cls2, cls2});
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        public void copyMemory(byte[] bArr, long j5, long j6, long j7) {
            byte[] bArr2 = bArr;
            this.unsafe.copyMemory(bArr2, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j5, (Object) null, j6, j7);
        }

        public byte getByte(long j5) {
            return this.unsafe.getByte(j5);
        }

        public void putByte(long j5, byte b5) {
            this.unsafe.putByte(j5, b5);
        }
    }

    private static abstract class MemoryAccessor {
        Unsafe unsafe;

        MemoryAccessor(Unsafe unsafe2) {
            this.unsafe = unsafe2;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }

        public abstract void copyMemory(long j5, byte[] bArr, long j6, long j7);

        public abstract void copyMemory(byte[] bArr, long j5, long j6, long j7);

        public abstract boolean getBoolean(Object obj, long j5);

        public abstract byte getByte(long j5);

        public abstract byte getByte(Object obj, long j5);

        public abstract double getDouble(Object obj, long j5);

        public abstract float getFloat(Object obj, long j5);

        public abstract int getInt(long j5);

        public final int getInt(Object obj, long j5) {
            return this.unsafe.getInt(obj, j5);
        }

        public abstract long getLong(long j5);

        public final long getLong(Object obj, long j5) {
            return this.unsafe.getLong(obj, j5);
        }

        public final Object getObject(Object obj, long j5) {
            return this.unsafe.getObject(obj, j5);
        }

        public abstract Object getStaticObject(Field field);

        public final long objectFieldOffset(Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j5, boolean z4);

        public abstract void putByte(long j5, byte b5);

        public abstract void putByte(Object obj, long j5, byte b5);

        public abstract void putDouble(Object obj, long j5, double d5);

        public abstract void putFloat(Object obj, long j5, float f5);

        public abstract void putInt(long j5, int i5);

        public final void putInt(Object obj, long j5, int i5) {
            this.unsafe.putInt(obj, j5, i5);
        }

        public abstract void putLong(long j5, long j6);

        public final void putLong(Object obj, long j5, long j6) {
            this.unsafe.putLong(obj, j5, j6);
        }

        public final void putObject(Object obj, long j5, Object obj2) {
            this.unsafe.putObject(obj, j5, obj2);
        }

        public boolean supportsUnsafeArrayOperations() {
            Class<Class> cls = Class.class;
            Class<Object> cls2 = Object.class;
            Unsafe unsafe2 = this.unsafe;
            if (unsafe2 == null) {
                return false;
            }
            try {
                Class<?> cls3 = unsafe2.getClass();
                cls3.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls3.getMethod("arrayBaseOffset", new Class[]{cls});
                cls3.getMethod("arrayIndexScale", new Class[]{cls});
                Class cls4 = Long.TYPE;
                cls3.getMethod("getInt", new Class[]{cls2, cls4});
                cls3.getMethod("putInt", new Class[]{cls2, cls4, Integer.TYPE});
                cls3.getMethod("getLong", new Class[]{cls2, cls4});
                cls3.getMethod("putLong", new Class[]{cls2, cls4, cls4});
                cls3.getMethod("getObject", new Class[]{cls2, cls4});
                cls3.getMethod("putObject", new Class[]{cls2, cls4, cls2});
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe unsafe2 = this.unsafe;
            if (unsafe2 == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe2.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                if (UnsafeUtil.bufferAddressField() == null) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }
    }

    static {
        boolean z4;
        long arrayBaseOffset = (long) arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
        Class<boolean[]> cls = boolean[].class;
        BOOLEAN_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls);
        BOOLEAN_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls);
        Class<int[]> cls2 = int[].class;
        INT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls2);
        INT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls2);
        Class<long[]> cls3 = long[].class;
        LONG_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls3);
        LONG_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls3);
        Class<float[]> cls4 = float[].class;
        FLOAT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls4);
        FLOAT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls4);
        Class<double[]> cls5 = double[].class;
        DOUBLE_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls5);
        DOUBLE_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls5);
        Class<Object[]> cls6 = Object[].class;
        OBJECT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls6);
        OBJECT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls6);
        BYTE_ARRAY_ALIGNMENT = (int) (arrayBaseOffset & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z4 = true;
        } else {
            z4 = false;
        }
        IS_BIG_ENDIAN = z4;
    }

    private UnsafeUtil() {
    }

    static long addressOffset(ByteBuffer byteBuffer) {
        return MEMORY_ACCESSOR.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    static <T> T allocateInstance(Class<T> cls) {
        try {
            return UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    private static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static Field bufferAddressField() {
        Field field;
        Class<Buffer> cls = Buffer.class;
        if (Android.isOnAndroidDevice() && (field = field(cls, "effectiveDirectAddress")) != null) {
            return field;
        }
        Field field2 = field(cls, "address");
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    static void copyMemory(byte[] bArr, long j5, long j6, long j7) {
        MEMORY_ACCESSOR.copyMemory(bArr, j5, j6, j7);
    }

    static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls3 = MEMORY_CLASS;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long fieldOffset(Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = MEMORY_ACCESSOR) == null) {
            return -1;
        }
        return memoryAccessor.objectFieldOffset(field);
    }

    private static int firstDifferingByteIndexNativeEndian(long j5, long j6) {
        int i5;
        if (IS_BIG_ENDIAN) {
            i5 = Long.numberOfLeadingZeros(j5 ^ j6);
        } else {
            i5 = Long.numberOfTrailingZeros(j5 ^ j6);
        }
        return i5 >> 3;
    }

    static boolean getBoolean(Object obj, long j5) {
        return MEMORY_ACCESSOR.getBoolean(obj, j5);
    }

    /* access modifiers changed from: private */
    public static boolean getBooleanBigEndian(Object obj, long j5) {
        if (getByteBigEndian(obj, j5) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean getBooleanLittleEndian(Object obj, long j5) {
        if (getByteLittleEndian(obj, j5) != 0) {
            return true;
        }
        return false;
    }

    static byte getByte(Object obj, long j5) {
        return MEMORY_ACCESSOR.getByte(obj, j5);
    }

    /* access modifiers changed from: private */
    public static byte getByteBigEndian(Object obj, long j5) {
        return (byte) ((getInt(obj, -4 & j5) >>> ((int) (((~j5) & 3) << 3))) & 255);
    }

    /* access modifiers changed from: private */
    public static byte getByteLittleEndian(Object obj, long j5) {
        return (byte) ((getInt(obj, -4 & j5) >>> ((int) ((j5 & 3) << 3))) & 255);
    }

    static double getDouble(Object obj, long j5) {
        return MEMORY_ACCESSOR.getDouble(obj, j5);
    }

    static float getFloat(Object obj, long j5) {
        return MEMORY_ACCESSOR.getFloat(obj, j5);
    }

    static int getInt(Object obj, long j5) {
        return MEMORY_ACCESSOR.getInt(obj, j5);
    }

    static long getLong(Object obj, long j5) {
        return MEMORY_ACCESSOR.getLong(obj, j5);
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return null;
        }
        if (!Android.isOnAndroidDevice()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (IS_ANDROID_64) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (IS_ANDROID_32) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    static Object getObject(Object obj, long j5) {
        return MEMORY_ACCESSOR.getObject(obj, j5);
    }

    static Object getStaticObject(Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() throws Exception {
                    Class<Unsafe> cls = Unsafe.class;
                    for (Field field : cls.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get((Object) null);
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    /* access modifiers changed from: private */
    public static void logMissingMethod(Throwable th) {
        Logger logger = Logger.getLogger(UnsafeUtil.class.getName());
        Level level = Level.WARNING;
        logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    static int mismatch(byte[] bArr, int i5, byte[] bArr2, int i6, int i7) {
        if (i5 < 0 || i6 < 0 || i7 < 0 || i5 + i7 > bArr.length || i6 + i7 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i8 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            int i9 = (BYTE_ARRAY_ALIGNMENT + i5) & 7;
            while (i8 < i7 && (i9 & 7) != 0) {
                if (bArr[i5 + i8] != bArr2[i6 + i8]) {
                    return i8;
                }
                i8++;
                i9++;
            }
            int i10 = ((i7 - i8) & -8) + i8;
            while (i8 < i10) {
                long j5 = BYTE_ARRAY_BASE_OFFSET;
                long j6 = (long) i8;
                long j7 = getLong((Object) bArr, ((long) i5) + j5 + j6);
                long j8 = getLong((Object) bArr2, j5 + ((long) i6) + j6);
                if (j7 != j8) {
                    return i8 + firstDifferingByteIndexNativeEndian(j7, j8);
                }
                i8 += 8;
            }
        }
        while (i8 < i7) {
            if (bArr[i5 + i8] != bArr2[i6 + i8]) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    static long objectFieldOffset(Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    static void putBoolean(Object obj, long j5, boolean z4) {
        MEMORY_ACCESSOR.putBoolean(obj, j5, z4);
    }

    /* access modifiers changed from: private */
    public static void putBooleanBigEndian(Object obj, long j5, boolean z4) {
        putByteBigEndian(obj, j5, z4 ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void putBooleanLittleEndian(Object obj, long j5, boolean z4) {
        putByteLittleEndian(obj, j5, z4 ? (byte) 1 : 0);
    }

    static void putByte(Object obj, long j5, byte b5) {
        MEMORY_ACCESSOR.putByte(obj, j5, b5);
    }

    /* access modifiers changed from: private */
    public static void putByteBigEndian(Object obj, long j5, byte b5) {
        long j6 = -4 & j5;
        int i5 = getInt(obj, j6);
        int i6 = ((~((int) j5)) & 3) << 3;
        putInt(obj, j6, ((255 & b5) << i6) | (i5 & (~(255 << i6))));
    }

    /* access modifiers changed from: private */
    public static void putByteLittleEndian(Object obj, long j5, byte b5) {
        long j6 = -4 & j5;
        int i5 = (((int) j5) & 3) << 3;
        putInt(obj, j6, ((255 & b5) << i5) | (getInt(obj, j6) & (~(255 << i5))));
    }

    static void putDouble(Object obj, long j5, double d5) {
        MEMORY_ACCESSOR.putDouble(obj, j5, d5);
    }

    static void putFloat(Object obj, long j5, float f5) {
        MEMORY_ACCESSOR.putFloat(obj, j5, f5);
    }

    static void putInt(Object obj, long j5, int i5) {
        MEMORY_ACCESSOR.putInt(obj, j5, i5);
    }

    static void putLong(Object obj, long j5, long j6) {
        MEMORY_ACCESSOR.putLong(obj, j5, j6);
    }

    static void putObject(Object obj, long j5, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j5, obj2);
    }

    private static boolean supportsUnsafeArrayOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeByteBufferOperations();
    }

    static void copyMemory(long j5, byte[] bArr, long j6, long j7) {
        MEMORY_ACCESSOR.copyMemory(j5, bArr, j6, j7);
    }

    static boolean getBoolean(boolean[] zArr, long j5) {
        return MEMORY_ACCESSOR.getBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j5 * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    static byte getByte(byte[] bArr, long j5) {
        return MEMORY_ACCESSOR.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j5);
    }

    static double getDouble(double[] dArr, long j5) {
        return MEMORY_ACCESSOR.getDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j5 * DOUBLE_ARRAY_INDEX_SCALE));
    }

    static float getFloat(float[] fArr, long j5) {
        return MEMORY_ACCESSOR.getFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j5 * FLOAT_ARRAY_INDEX_SCALE));
    }

    static int getInt(int[] iArr, long j5) {
        return MEMORY_ACCESSOR.getInt(iArr, INT_ARRAY_BASE_OFFSET + (j5 * INT_ARRAY_INDEX_SCALE));
    }

    static long getLong(long[] jArr, long j5) {
        return MEMORY_ACCESSOR.getLong(jArr, LONG_ARRAY_BASE_OFFSET + (j5 * LONG_ARRAY_INDEX_SCALE));
    }

    static Object getObject(Object[] objArr, long j5) {
        return MEMORY_ACCESSOR.getObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j5 * OBJECT_ARRAY_INDEX_SCALE));
    }

    static void putBoolean(boolean[] zArr, long j5, boolean z4) {
        MEMORY_ACCESSOR.putBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j5 * BOOLEAN_ARRAY_INDEX_SCALE), z4);
    }

    static void putByte(byte[] bArr, long j5, byte b5) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j5, b5);
    }

    static void putDouble(double[] dArr, long j5, double d5) {
        double[] dArr2 = dArr;
        MEMORY_ACCESSOR.putDouble(dArr2, DOUBLE_ARRAY_BASE_OFFSET + (j5 * DOUBLE_ARRAY_INDEX_SCALE), d5);
    }

    static void putFloat(float[] fArr, long j5, float f5) {
        MEMORY_ACCESSOR.putFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j5 * FLOAT_ARRAY_INDEX_SCALE), f5);
    }

    static void putInt(int[] iArr, long j5, int i5) {
        MEMORY_ACCESSOR.putInt(iArr, INT_ARRAY_BASE_OFFSET + (j5 * INT_ARRAY_INDEX_SCALE), i5);
    }

    static void putLong(long[] jArr, long j5, long j6) {
        long[] jArr2 = jArr;
        MEMORY_ACCESSOR.putLong(jArr2, LONG_ARRAY_BASE_OFFSET + (j5 * LONG_ARRAY_INDEX_SCALE), j6);
    }

    static void putObject(Object[] objArr, long j5, Object obj) {
        MEMORY_ACCESSOR.putObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j5 * OBJECT_ARRAY_INDEX_SCALE), obj);
    }

    static void copyMemory(byte[] bArr, long j5, byte[] bArr2, long j6, long j7) {
        System.arraycopy(bArr, (int) j5, bArr2, (int) j6, (int) j7);
    }

    static byte getByte(long j5) {
        return MEMORY_ACCESSOR.getByte(j5);
    }

    static int getInt(long j5) {
        return MEMORY_ACCESSOR.getInt(j5);
    }

    static long getLong(long j5) {
        return MEMORY_ACCESSOR.getLong(j5);
    }

    static void putByte(long j5, byte b5) {
        MEMORY_ACCESSOR.putByte(j5, b5);
    }

    static void putInt(long j5, int i5) {
        MEMORY_ACCESSOR.putInt(j5, i5);
    }

    static void putLong(long j5, long j6) {
        MEMORY_ACCESSOR.putLong(j5, j6);
    }
}
