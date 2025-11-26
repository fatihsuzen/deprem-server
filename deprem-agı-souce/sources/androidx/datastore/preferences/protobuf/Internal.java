package androidx.datastore.preferences.protobuf;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

public final class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;
    static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset US_ASCII = Charset.forName(C.ASCII_NAME);
    static final Charset UTF_8 = Charset.forName(C.UTF8_NAME);

    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean z4);

        boolean getBoolean(int i5);

        BooleanList mutableCopyWithCapacity(int i5);

        /* bridge */ /* synthetic */ ProtobufList mutableCopyWithCapacity(int i5);

        @CanIgnoreReturnValue
        boolean setBoolean(int i5, boolean z4);
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double d5);

        double getDouble(int i5);

        DoubleList mutableCopyWithCapacity(int i5);

        /* bridge */ /* synthetic */ ProtobufList mutableCopyWithCapacity(int i5);

        @CanIgnoreReturnValue
        double setDouble(int i5, double d5);
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i5);
    }

    public interface EnumVerifier {
        boolean isInRange(int i5);
    }

    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float f5);

        float getFloat(int i5);

        FloatList mutableCopyWithCapacity(int i5);

        /* bridge */ /* synthetic */ ProtobufList mutableCopyWithCapacity(int i5);

        @CanIgnoreReturnValue
        float setFloat(int i5, float f5);
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int i5);

        int getInt(int i5);

        IntList mutableCopyWithCapacity(int i5);

        /* bridge */ /* synthetic */ ProtobufList mutableCopyWithCapacity(int i5);

        @CanIgnoreReturnValue
        int setInt(int i5, int i6);
    }

    public static class IntListAdapter<T> extends AbstractList<T> {
        private final IntConverter<T> converter;
        private final IntList fromList;

        public interface IntConverter<T> {
            T convert(int i5);
        }

        public IntListAdapter(IntList intList, IntConverter<T> intConverter) {
            this.fromList = intList;
            this.converter = intConverter;
        }

        public T get(int i5) {
            return this.converter.convert(this.fromList.getInt(i5));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {
        private final Converter<F, T> converter;
        private final List<F> fromList;

        public interface Converter<F, T> {
            T convert(F f5);
        }

        public ListAdapter(List<F> list, Converter<F, T> converter2) {
            this.fromList = list;
            this.converter = converter2;
        }

        public T get(int i5) {
            return this.converter.convert(this.fromList.get(i5));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long j5);

        long getLong(int i5);

        LongList mutableCopyWithCapacity(int i5);

        /* bridge */ /* synthetic */ ProtobufList mutableCopyWithCapacity(int i5);

        @CanIgnoreReturnValue
        long setLong(int i5, long j5);
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {
        private final Map<K, RealValue> realMap;
        /* access modifiers changed from: private */
        public final Converter<RealValue, V> valueConverter;

        public interface Converter<A, B> {
            A doBackward(B b5);

            B doForward(A a5);
        }

        private class EntryAdapter implements Map.Entry<K, V> {
            private final Map.Entry<K, RealValue> realEntry;

            public EntryAdapter(Map.Entry<K, RealValue> entry) {
                this.realEntry = entry;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if ((obj instanceof Map.Entry) && getKey().equals(((Map.Entry) obj).getKey()) && getValue().equals(getValue())) {
                    return true;
                }
                return false;
            }

            public K getKey() {
                return this.realEntry.getKey();
            }

            public V getValue() {
                return MapAdapter.this.valueConverter.doForward(this.realEntry.getValue());
            }

            public int hashCode() {
                return this.realEntry.hashCode();
            }

            public V setValue(V v5) {
                RealValue value = this.realEntry.setValue(MapAdapter.this.valueConverter.doBackward(v5));
                if (value == null) {
                    return null;
                }
                return MapAdapter.this.valueConverter.doForward(value);
            }
        }

        private class IteratorAdapter implements Iterator<Map.Entry<K, V>> {
            private final Iterator<Map.Entry<K, RealValue>> realIterator;

            public IteratorAdapter(Iterator<Map.Entry<K, RealValue>> it) {
                this.realIterator = it;
            }

            public boolean hasNext() {
                return this.realIterator.hasNext();
            }

            public void remove() {
                this.realIterator.remove();
            }

            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.realIterator.next());
            }
        }

        private class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, RealValue>> realSet;

            public SetAdapter(Set<Map.Entry<K, RealValue>> set) {
                this.realSet = set;
            }

            public Iterator<Map.Entry<K, V>> iterator() {
                return new IteratorAdapter(this.realSet.iterator());
            }

            public int size() {
                return this.realSet.size();
            }
        }

        public MapAdapter(Map<K, RealValue> map, Converter<RealValue, V> converter) {
            this.realMap = map;
            this.valueConverter = converter;
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(final EnumLiteMap<T> enumLiteMap, final T t5) {
            return new Converter<Integer, T>() {
                public Integer doBackward(T t5) {
                    return Integer.valueOf(t5.getNumber());
                }

                public T doForward(Integer num) {
                    T findValueByNumber = EnumLiteMap.this.findValueByNumber(num.intValue());
                    return findValueByNumber == null ? t5 : findValueByNumber;
                }
            };
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return new SetAdapter(this.realMap.entrySet());
        }

        public V get(Object obj) {
            RealValue realvalue = this.realMap.get(obj);
            if (realvalue == null) {
                return null;
            }
            return this.valueConverter.doForward(realvalue);
        }

        public V put(K k5, V v5) {
            RealValue put = this.realMap.put(k5, this.valueConverter.doBackward(v5));
            if (put == null) {
                return null;
            }
            return this.valueConverter.doForward(put);
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int i5);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(bArr);
    }

    private Internal() {
    }

    public static byte[] byteArrayDefaultValue(String str) {
        return str.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        return ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static ByteString bytesDefaultValue(String str) {
        return ByteString.copyFrom(str.getBytes(ISO_8859_1));
    }

    static <T> T checkNotNull(T t5) {
        t5.getClass();
        return t5;
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }

    public static boolean equals(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (!Arrays.equals(list.get(i5), list2.get(i5))) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        Java8Compatibility.clear(duplicate);
        ByteBuffer duplicate2 = byteBuffer2.duplicate();
        Java8Compatibility.clear(duplicate2);
        return duplicate.equals(duplicate2);
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> cls) {
        try {
            Method method = cls.getMethod("getDefaultInstance", (Class[]) null);
            return (MessageLite) method.invoke(method, (Object[]) null);
        } catch (Exception e5) {
            throw new RuntimeException("Failed to get default instance for " + cls, e5);
        }
    }

    public static int hashBoolean(boolean z4) {
        return z4 ? 1231 : 1237;
    }

    public static int hashCode(List<byte[]> list) {
        int i5 = 1;
        for (byte[] hashCode : list) {
            i5 = (i5 * 31) + hashCode(hashCode);
        }
        return i5;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        int i5 = 1;
        for (ByteBuffer hashCodeByteBuffer : list) {
            i5 = (i5 * 31) + hashCodeByteBuffer(hashCodeByteBuffer);
        }
        return i5;
    }

    public static int hashEnum(EnumLite enumLite) {
        return enumLite.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        int i5 = 1;
        for (EnumLite hashEnum : list) {
            i5 = (i5 * 31) + hashEnum(hashEnum);
        }
        return i5;
    }

    public static int hashLong(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    static Object mergeMessage(Object obj, Object obj2) {
        return ((MessageLite) obj).toBuilder().mergeFrom((MessageLite) obj2).buildPartial();
    }

    static int partialHash(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i5 = (i5 * 31) + bArr[i8];
        }
        return i5;
    }

    public static String stringDefaultValue(String str) {
        return new String(str.getBytes(ISO_8859_1), UTF_8);
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    static <T> T checkNotNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.isValidUtf8(bArr);
    }

    public static int hashCode(byte[] bArr) {
        return hashCode(bArr, 0, bArr.length);
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int partialHash = partialHash(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (partialHash == 0) {
                return 1;
            }
            return partialHash;
        }
        int i5 = 4096;
        if (byteBuffer.capacity() <= 4096) {
            i5 = byteBuffer.capacity();
        }
        byte[] bArr = new byte[i5];
        ByteBuffer duplicate = byteBuffer.duplicate();
        Java8Compatibility.clear(duplicate);
        int capacity = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= i5 ? duplicate.remaining() : i5;
            duplicate.get(bArr, 0, remaining);
            capacity = partialHash(capacity, bArr, 0, remaining);
        }
        if (capacity == 0) {
            return 1;
        }
        return capacity;
    }

    static int hashCode(byte[] bArr, int i5, int i6) {
        int partialHash = partialHash(i6, bArr, i5, i6);
        if (partialHash == 0) {
            return 1;
        }
        return partialHash;
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (!equalsByteBuffer(list.get(i5), list2.get(i5))) {
                return false;
            }
        }
        return true;
    }
}
