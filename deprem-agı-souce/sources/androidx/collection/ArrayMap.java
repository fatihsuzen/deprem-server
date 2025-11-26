package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.internal.ContainerHelpersKt;
import j$.util.Map;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V>, j$.util.Map {
    @Nullable
    ArrayMap<K, V>.EntrySet mEntrySet;
    @Nullable
    ArrayMap<K, V>.KeySet mKeySet;
    @Nullable
    ArrayMap<K, V>.ValueCollection mValues;

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @NonNull
        public Iterator<Map.Entry<K, V>> iterator() {
            return new MapIterator();
        }

        public int size() {
            return ArrayMap.this.size();
        }
    }

    final class KeyIterator extends IndexBasedArrayIterator<K> {
        KeyIterator() {
            super(ArrayMap.this.size());
        }

        /* access modifiers changed from: protected */
        public K elementAt(int i5) {
            return ArrayMap.this.keyAt(i5);
        }

        /* access modifiers changed from: protected */
        public void removeAt(int i5) {
            ArrayMap.this.removeAt(i5);
        }
    }

    final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int mEnd;
        boolean mEntryValid;
        int mIndex = -1;

        MapIterator() {
            this.mEnd = ArrayMap.this.size() - 1;
        }

        public boolean equals(Object obj) {
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!ContainerHelpersKt.equal(entry.getKey(), ArrayMap.this.keyAt(this.mIndex)) || !ContainerHelpersKt.equal(entry.getValue(), ArrayMap.this.valueAt(this.mIndex))) {
                    return false;
                }
                return true;
            }
        }

        public K getKey() {
            if (this.mEntryValid) {
                return ArrayMap.this.keyAt(this.mIndex);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.mEntryValid) {
                return ArrayMap.this.valueAt(this.mIndex);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            if (this.mIndex < this.mEnd) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i5;
            if (this.mEntryValid) {
                Object keyAt = ArrayMap.this.keyAt(this.mIndex);
                Object valueAt = ArrayMap.this.valueAt(this.mIndex);
                int i6 = 0;
                if (keyAt == null) {
                    i5 = 0;
                } else {
                    i5 = keyAt.hashCode();
                }
                if (valueAt != null) {
                    i6 = valueAt.hashCode();
                }
                return i5 ^ i6;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.mEntryValid) {
                ArrayMap.this.removeAt(this.mIndex);
                this.mIndex--;
                this.mEnd--;
                this.mEntryValid = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v5) {
            if (this.mEntryValid) {
                return ArrayMap.this.setValueAt(this.mIndex, v5);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }

        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.mIndex++;
                this.mEntryValid = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    final class ValueIterator extends IndexBasedArrayIterator<V> {
        ValueIterator() {
            super(ArrayMap.this.size());
        }

        /* access modifiers changed from: protected */
        public V elementAt(int i5) {
            return ArrayMap.this.valueAt(i5);
        }

        /* access modifiers changed from: protected */
        public void removeAt(int i5) {
            ArrayMap.this.removeAt(i5);
        }
    }

    public ArrayMap() {
    }

    static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsKey(@Nullable Object obj) {
        return super.containsKey(obj);
    }

    public boolean containsValue(@Nullable Object obj) {
        return super.containsValue(obj);
    }

    @NonNull
    public Set<Map.Entry<K, V>> entrySet() {
        ArrayMap<K, V>.EntrySet entrySet = this.mEntrySet;
        if (entrySet != null) {
            return entrySet;
        }
        ArrayMap<K, V>.EntrySet entrySet2 = new EntrySet();
        this.mEntrySet = entrySet2;
        return entrySet2;
    }

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    public V get(@Nullable Object obj) {
        return super.get(obj);
    }

    @NonNull
    public Set<K> keySet() {
        ArrayMap<K, V>.KeySet keySet = this.mKeySet;
        if (keySet != null) {
            return keySet;
        }
        ArrayMap<K, V>.KeySet keySet2 = new KeySet();
        this.mKeySet = keySet2;
        return keySet2;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    public void putAll(@NonNull java.util.Map<? extends K, ? extends V> map) {
        ensureCapacity(size() + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public V remove(@Nullable Object obj) {
        return super.remove(obj);
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        int size = size();
        for (Object remove : collection) {
            remove(remove);
        }
        if (size != size()) {
            return true;
        }
        return false;
    }

    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        int size = size();
        for (int size2 = size() - 1; size2 >= 0; size2--) {
            if (!collection.contains(keyAt(size2))) {
                removeAt(size2);
            }
        }
        if (size != size()) {
            return true;
        }
        return false;
    }

    @NonNull
    public Collection<V> values() {
        ArrayMap<K, V>.ValueCollection valueCollection = this.mValues;
        if (valueCollection != null) {
            return valueCollection;
        }
        ArrayMap<K, V>.ValueCollection valueCollection2 = new ValueCollection();
        this.mValues = valueCollection2;
        return valueCollection2;
    }

    public ArrayMap(int i5) {
        super(i5);
    }

    final class KeySet implements Set<K> {
        KeySet() {
        }

        public boolean add(K k5) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(@NonNull Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            ArrayMap.this.clear();
        }

        public boolean contains(Object obj) {
            return ArrayMap.this.containsKey(obj);
        }

        public boolean containsAll(@NonNull Collection<?> collection) {
            return ArrayMap.this.containsAll(collection);
        }

        public boolean equals(Object obj) {
            return ArrayMap.equalsSetHelper(this, obj);
        }

        public int hashCode() {
            int i5;
            int i6 = 0;
            for (int size = ArrayMap.this.size() - 1; size >= 0; size--) {
                Object keyAt = ArrayMap.this.keyAt(size);
                if (keyAt == null) {
                    i5 = 0;
                } else {
                    i5 = keyAt.hashCode();
                }
                i6 += i5;
            }
            return i6;
        }

        public boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        @NonNull
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        public boolean remove(Object obj) {
            int indexOfKey = ArrayMap.this.indexOfKey(obj);
            if (indexOfKey < 0) {
                return false;
            }
            ArrayMap.this.removeAt(indexOfKey);
            return true;
        }

        public boolean removeAll(@NonNull Collection<?> collection) {
            return ArrayMap.this.removeAll(collection);
        }

        public boolean retainAll(@NonNull Collection<?> collection) {
            return ArrayMap.this.retainAll(collection);
        }

        public int size() {
            return ArrayMap.this.size();
        }

        @NonNull
        public Object[] toArray() {
            int size = ArrayMap.this.size();
            Object[] objArr = new Object[size];
            for (int i5 = 0; i5 < size; i5++) {
                objArr[i5] = ArrayMap.this.keyAt(i5);
            }
            return objArr;
        }

        @NonNull
        public <T> T[] toArray(@NonNull T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
            }
            for (int i5 = 0; i5 < size; i5++) {
                tArr[i5] = ArrayMap.this.keyAt(i5);
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
    }

    final class ValueCollection implements Collection<V> {
        ValueCollection() {
        }

        public boolean add(V v5) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(@NonNull Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            ArrayMap.this.clear();
        }

        public boolean contains(Object obj) {
            if (ArrayMap.this.__restricted$indexOfValue(obj) >= 0) {
                return true;
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        @NonNull
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        public boolean remove(Object obj) {
            int __restricted$indexOfValue = ArrayMap.this.__restricted$indexOfValue(obj);
            if (__restricted$indexOfValue < 0) {
                return false;
            }
            ArrayMap.this.removeAt(__restricted$indexOfValue);
            return true;
        }

        public boolean removeAll(@NonNull Collection<?> collection) {
            int size = ArrayMap.this.size();
            int i5 = 0;
            boolean z4 = false;
            while (i5 < size) {
                if (collection.contains(ArrayMap.this.valueAt(i5))) {
                    ArrayMap.this.removeAt(i5);
                    i5--;
                    size--;
                    z4 = true;
                }
                i5++;
            }
            return z4;
        }

        public boolean retainAll(@NonNull Collection<?> collection) {
            int size = ArrayMap.this.size();
            int i5 = 0;
            boolean z4 = false;
            while (i5 < size) {
                if (!collection.contains(ArrayMap.this.valueAt(i5))) {
                    ArrayMap.this.removeAt(i5);
                    i5--;
                    size--;
                    z4 = true;
                }
                i5++;
            }
            return z4;
        }

        public int size() {
            return ArrayMap.this.size();
        }

        @NonNull
        public Object[] toArray() {
            int size = ArrayMap.this.size();
            Object[] objArr = new Object[size];
            for (int i5 = 0; i5 < size; i5++) {
                objArr[i5] = ArrayMap.this.valueAt(i5);
            }
            return objArr;
        }

        @NonNull
        public <T> T[] toArray(@NonNull T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
            }
            for (int i5 = 0; i5 < size; i5++) {
                tArr[i5] = ArrayMap.this.valueAt(i5);
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
    }

    public ArrayMap(@Nullable SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
