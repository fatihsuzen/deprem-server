package androidx.datastore.preferences.protobuf;

import j$.util.DesugarCollections;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    @Deprecated
    public static final LazyStringList EMPTY;
    private static final LazyStringArrayList EMPTY_LIST;
    private final List<Object> list;

    private static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        private final LazyStringArrayList list;

        ByteArrayListView(LazyStringArrayList lazyStringArrayList) {
            this.list = lazyStringArrayList;
        }

        public int size() {
            return this.list.size();
        }

        public void add(int i5, byte[] bArr) {
            this.list.add(i5, bArr);
            this.modCount++;
        }

        public byte[] get(int i5) {
            return this.list.getByteArray(i5);
        }

        public byte[] remove(int i5) {
            String remove = this.list.remove(i5);
            this.modCount++;
            return LazyStringArrayList.asByteArray(remove);
        }

        public byte[] set(int i5, byte[] bArr) {
            Object access$000 = this.list.setAndReturn(i5, bArr);
            this.modCount++;
            return LazyStringArrayList.asByteArray(access$000);
        }
    }

    private static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        private final LazyStringArrayList list;

        ByteStringListView(LazyStringArrayList lazyStringArrayList) {
            this.list = lazyStringArrayList;
        }

        public int size() {
            return this.list.size();
        }

        public void add(int i5, ByteString byteString) {
            this.list.add(i5, byteString);
            this.modCount++;
        }

        public ByteString get(int i5) {
            return this.list.getByteString(i5);
        }

        public ByteString remove(int i5) {
            String remove = this.list.remove(i5);
            this.modCount++;
            return LazyStringArrayList.asByteString(remove);
        }

        public ByteString set(int i5, ByteString byteString) {
            Object access$300 = this.list.setAndReturn(i5, byteString);
            this.modCount++;
            return LazyStringArrayList.asByteString(access$300);
        }
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(false);
        EMPTY_LIST = lazyStringArrayList;
        EMPTY = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    /* access modifiers changed from: private */
    public static byte[] asByteArray(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return Internal.toByteArray((String) obj);
        }
        return ((ByteString) obj).toByteArray();
    }

    /* access modifiers changed from: private */
    public static ByteString asByteString(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.copyFromUtf8((String) obj);
        }
        return ByteString.copyFrom((byte[]) obj);
    }

    private static String asString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[]) obj);
    }

    public static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    /* access modifiers changed from: private */
    public Object setAndReturn(int i5, ByteString byteString) {
        ensureIsMutable();
        return this.list.set(i5, byteString);
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public boolean addAllByteArray(Collection<byte[]> collection) {
        ensureIsMutable();
        boolean addAll = this.list.addAll(collection);
        this.modCount++;
        return addAll;
    }

    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        ensureIsMutable();
        boolean addAll = this.list.addAll(collection);
        this.modCount++;
        return addAll;
    }

    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    public void clear() {
        ensureIsMutable();
        this.list.clear();
        this.modCount++;
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.util.List<java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getByteArray(int r3) {
        /*
            r2 = this;
            java.util.List<java.lang.Object> r0 = r2.list
            java.lang.Object r0 = r0.get(r3)
            byte[] r1 = asByteArray(r0)
            if (r1 == r0) goto L_0x0011
            java.util.List<java.lang.Object> r0 = r2.list
            r0.set(r3, r1)
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.LazyStringArrayList.getByteArray(int):byte[]");
    }

    public ByteString getByteString(int i5) {
        Object obj = this.list.get(i5);
        ByteString asByteString = asByteString(obj);
        if (asByteString != obj) {
            this.list.set(i5, asByteString);
        }
        return asByteString;
    }

    public Object getRaw(int i5) {
        return this.list.get(i5);
    }

    public List<?> getUnderlyingElements() {
        return DesugarCollections.unmodifiableList(this.list);
    }

    public LazyStringList getUnmodifiableView() {
        if (isModifiable()) {
            return new UnmodifiableLazyStringList(this);
        }
        return this;
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    public void mergeFrom(LazyStringList lazyStringList) {
        ensureIsMutable();
        for (Object next : lazyStringList.getUnderlyingElements()) {
            if (next instanceof byte[]) {
                byte[] bArr = (byte[]) next;
                this.list.add(Arrays.copyOf(bArr, bArr.length));
            } else {
                this.list.add(next);
            }
        }
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public int size() {
        return this.list.size();
    }

    private LazyStringArrayList(boolean z4) {
        super(z4);
        this.list = Collections.EMPTY_LIST;
    }

    public boolean addAll(int i5, Collection<? extends String> collection) {
        ensureIsMutable();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.list.addAll(i5, collection);
        this.modCount++;
        return addAll;
    }

    public String get(int i5) {
        Object obj = this.list.get(i5);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.list.set(i5, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.list.set(i5, stringUtf82);
        }
        return stringUtf82;
    }

    public LazyStringArrayList mutableCopyWithCapacity(int i5) {
        if (i5 >= size()) {
            ArrayList arrayList = new ArrayList(i5);
            arrayList.addAll(this.list);
            return new LazyStringArrayList((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public String set(int i5, String str) {
        ensureIsMutable();
        return asString(this.list.set(i5, str));
    }

    /* access modifiers changed from: private */
    public Object setAndReturn(int i5, byte[] bArr) {
        ensureIsMutable();
        return this.list.set(i5, bArr);
    }

    public void add(int i5, String str) {
        ensureIsMutable();
        this.list.add(i5, str);
        this.modCount++;
    }

    public String remove(int i5) {
        ensureIsMutable();
        Object remove = this.list.remove(i5);
        this.modCount++;
        return asString(remove);
    }

    public LazyStringArrayList(int i5) {
        this((ArrayList<Object>) new ArrayList(i5));
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.list = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    public void set(int i5, ByteString byteString) {
        setAndReturn(i5, byteString);
    }

    /* access modifiers changed from: private */
    public void add(int i5, ByteString byteString) {
        ensureIsMutable();
        this.list.add(i5, byteString);
        this.modCount++;
    }

    public void set(int i5, byte[] bArr) {
        setAndReturn(i5, bArr);
    }

    public LazyStringArrayList(List<String> list2) {
        this((ArrayList<Object>) new ArrayList(list2));
    }

    private LazyStringArrayList(ArrayList<Object> arrayList) {
        this.list = arrayList;
    }

    /* access modifiers changed from: private */
    public void add(int i5, byte[] bArr) {
        ensureIsMutable();
        this.list.add(i5, bArr);
        this.modCount++;
    }

    @CanIgnoreReturnValue
    public boolean add(String str) {
        ensureIsMutable();
        this.list.add(str);
        this.modCount++;
        return true;
    }

    public void add(ByteString byteString) {
        ensureIsMutable();
        this.list.add(byteString);
        this.modCount++;
    }

    public void add(byte[] bArr) {
        ensureIsMutable();
        this.list.add(bArr);
        this.modCount++;
    }
}
