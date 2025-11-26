package j$.util.concurrent;

import j$.sun.misc.a;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, u {

    /* renamed from: g  reason: collision with root package name */
    public static final int f1289g = Runtime.getRuntime().availableProcessors();

    /* renamed from: h  reason: collision with root package name */
    public static final a f1290h;

    /* renamed from: i  reason: collision with root package name */
    public static final long f1291i;

    /* renamed from: j  reason: collision with root package name */
    public static final long f1292j;

    /* renamed from: k  reason: collision with root package name */
    public static final long f1293k;

    /* renamed from: l  reason: collision with root package name */
    public static final long f1294l;

    /* renamed from: m  reason: collision with root package name */
    public static final long f1295m;

    /* renamed from: n  reason: collision with root package name */
    public static final int f1296n;

    /* renamed from: o  reason: collision with root package name */
    public static final int f1297o;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;

    /* renamed from: a  reason: collision with root package name */
    public volatile transient l[] f1298a;

    /* renamed from: b  reason: collision with root package name */
    public volatile transient l[] f1299b;
    private volatile transient long baseCount;

    /* renamed from: c  reason: collision with root package name */
    public volatile transient c[] f1300c;
    private volatile transient int cellsBusy;

    /* renamed from: d  reason: collision with root package name */
    public transient i f1301d;

    /* renamed from: e  reason: collision with root package name */
    public transient s f1302e;

    /* renamed from: f  reason: collision with root package name */
    public transient e f1303f;
    private volatile transient int sizeCtl;
    private volatile transient int transferIndex;

    public static final int i(int i5) {
        return (i5 ^ (i5 >>> 16)) & Integer.MAX_VALUE;
    }

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", n[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        a aVar = a.f1001b;
        f1290h = aVar;
        f1291i = aVar.h(ConcurrentHashMap.class, "sizeCtl");
        f1292j = aVar.h(ConcurrentHashMap.class, "transferIndex");
        f1293k = aVar.h(ConcurrentHashMap.class, "baseCount");
        f1294l = aVar.h(ConcurrentHashMap.class, "cellsBusy");
        f1295m = aVar.h(c.class, "value");
        f1296n = aVar.a(l[].class);
        int b5 = aVar.b(l[].class);
        if (((b5 - 1) & b5) == 0) {
            f1297o = 31 - Integer.numberOfLeadingZeros(b5);
            Class<LockSupport> cls2 = LockSupport.class;
            Class<m> cls3 = m.class;
            return;
        }
        throw new ExceptionInInitializerError("array index scale not a power of two");
    }

    public static final int l(int i5) {
        int numberOfLeadingZeros = -1 >>> Integer.numberOfLeadingZeros(i5 - 1);
        if (numberOfLeadingZeros < 0) {
            return 1;
        }
        if (numberOfLeadingZeros >= 1073741824) {
            return 1073741824;
        }
        return numberOfLeadingZeros + 1;
    }

    public static Class c(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls != String.class) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces == null) {
                return null;
            }
            for (Type type : genericInterfaces) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    }
                }
            }
            return null;
        }
        return cls;
    }

    public static final l k(l[] lVarArr, int i5) {
        return (l) f1290h.f(lVarArr, (((long) i5) << f1297o) + ((long) f1296n));
    }

    public static final boolean b(l[] lVarArr, int i5, l lVar) {
        return j$.com.android.tools.r8.a.z(f1290h.f1002a, lVarArr, (((long) i5) << f1297o) + ((long) f1296n), lVar);
    }

    public static final void h(l[] lVarArr, int i5, l lVar) {
        f1290h.j(lVarArr, (((long) i5) << f1297o) + ((long) f1296n), lVar);
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i5) {
        this(i5, 0.75f, 1);
    }

    public ConcurrentHashMap(int i5, float f5, int i6) {
        int i7;
        if (f5 <= 0.0f || i5 < 0 || i6 <= 0) {
            throw new IllegalArgumentException();
        }
        long j5 = (long) (((double) (((float) ((long) (i5 < i6 ? i6 : i5))) / f5)) + 1.0d);
        if (j5 >= 1073741824) {
            i7 = 1073741824;
        } else {
            i7 = l((int) j5);
        }
        this.sizeCtl = i7;
    }

    public int size() {
        long j5 = j();
        if (j5 < 0) {
            return 0;
        }
        if (j5 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j5;
    }

    public boolean isEmpty() {
        return j() <= 0;
    }

    public V get(Object obj) {
        int length;
        l k5;
        Object obj2;
        int i5 = i(obj.hashCode());
        l[] lVarArr = this.f1298a;
        if (lVarArr == null || (length = lVarArr.length) <= 0 || (k5 = k(lVarArr, (length - 1) & i5)) == null) {
            return null;
        }
        int i6 = k5.f1323a;
        if (i6 == i5) {
            Object obj3 = k5.f1324b;
            if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                return k5.f1325c;
            }
        } else if (i6 < 0) {
            l a5 = k5.a(i5, obj);
            if (a5 != null) {
                return a5.f1325c;
            }
            return null;
        }
        while (true) {
            k5 = k5.f1326d;
            if (k5 == null) {
                return null;
            }
            if (k5.f1323a != i5 || ((obj2 = k5.f1324b) != obj && (obj2 == null || !obj.equals(obj2)))) {
            }
        }
        return k5.f1325c;
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        obj.getClass();
        l[] lVarArr = this.f1298a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 == null) {
                    break;
                }
                Object obj2 = a5.f1325c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public V put(K k5, V v5) {
        return f(k5, v5, false);
    }

    public final Object f(Object obj, Object obj2, boolean z4) {
        Object obj3;
        Object obj4;
        Object obj5;
        if (obj == null || obj2 == null) {
            throw null;
        }
        int i5 = i(obj.hashCode());
        l[] lVarArr = this.f1298a;
        int i6 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i7 = (length - 1) & i5;
                    l k5 = k(lVarArr, i7);
                    if (k5 != null) {
                        int i8 = k5.f1323a;
                        if (i8 == -1) {
                            lVarArr = d(lVarArr, k5);
                        } else if (z4 && i8 == i5 && (((obj4 = k5.f1324b) == obj || (obj4 != null && obj.equals(obj4))) && (obj5 = k5.f1325c) != null)) {
                            return obj5;
                        } else {
                            synchronized (k5) {
                                try {
                                    if (k(lVarArr, i7) == k5) {
                                        if (i8 >= 0) {
                                            i6 = 1;
                                            l lVar = k5;
                                            while (true) {
                                                if (lVar.f1323a == i5) {
                                                    Object obj6 = lVar.f1324b;
                                                    if (obj6 != obj) {
                                                        if (obj6 != null && obj.equals(obj6)) {
                                                            break;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                                l lVar2 = lVar.f1326d;
                                                if (lVar2 == null) {
                                                    lVar.f1326d = new l(i5, obj, obj2);
                                                    break;
                                                }
                                                i6++;
                                                lVar = lVar2;
                                            }
                                            obj3 = lVar.f1325c;
                                            if (!z4) {
                                                lVar.f1325c = obj2;
                                            }
                                        } else if (k5 instanceof q) {
                                            r e5 = ((q) k5).e(i5, obj, obj2);
                                            if (e5 != null) {
                                                Object obj7 = e5.f1325c;
                                                if (!z4) {
                                                    e5.f1325c = obj2;
                                                }
                                                obj3 = obj7;
                                            } else {
                                                obj3 = null;
                                            }
                                            i6 = 2;
                                        } else if (k5 instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                    obj3 = null;
                                } catch (Throwable th) {
                                    while (true) {
                                        throw th;
                                    }
                                }
                            }
                            if (i6 != 0) {
                                if (i6 >= 8) {
                                    n(lVarArr, i7);
                                }
                                if (obj3 != null) {
                                    return obj3;
                                }
                            }
                        }
                    } else if (b(lVarArr, i7, new l(i5, obj, obj2))) {
                        break;
                    }
                }
            }
            lVarArr = e();
        }
        a(1, i6);
        return null;
    }

    public final void putAll(Map map) {
        o(map.size());
        for (Map.Entry entry : map.entrySet()) {
            f(entry.getKey(), entry.getValue(), false);
        }
    }

    public V remove(Object obj) {
        return g(obj, (Object) null, (Object) null);
    }

    public final Object g(Object obj, Object obj2, Object obj3) {
        int length;
        int i5;
        l k5;
        Object obj4;
        boolean z4;
        r b5;
        int i6 = i(obj.hashCode());
        l[] lVarArr = this.f1298a;
        while (true) {
            if (lVarArr == null || (length = lVarArr.length) == 0 || (k5 = k(lVarArr, i5)) == null) {
                break;
            }
            int i7 = k5.f1323a;
            if (i7 == -1) {
                lVarArr = d(lVarArr, k5);
            } else {
                synchronized (k5) {
                    try {
                        if (k(lVarArr, (i5 = (length - 1) & i6)) == k5) {
                            z4 = true;
                            if (i7 >= 0) {
                                l lVar = null;
                                l lVar2 = k5;
                                while (true) {
                                    if (lVar2.f1323a == i6) {
                                        Object obj5 = lVar2.f1324b;
                                        if (obj5 != obj) {
                                            if (obj5 != null && obj.equals(obj5)) {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                    l lVar3 = lVar2.f1326d;
                                    if (lVar3 == null) {
                                        break;
                                    }
                                    l lVar4 = lVar3;
                                    lVar = lVar2;
                                    lVar2 = lVar4;
                                }
                                obj4 = lVar2.f1325c;
                                if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                    if (obj2 != null) {
                                        lVar2.f1325c = obj2;
                                    } else if (lVar != null) {
                                        lVar.f1326d = lVar2.f1326d;
                                    } else {
                                        h(lVarArr, i5, lVar2.f1326d);
                                    }
                                }
                                obj4 = null;
                            } else if (k5 instanceof q) {
                                q qVar = (q) k5;
                                r rVar = qVar.f1341e;
                                if (rVar != null && (b5 = rVar.b(i6, obj, (Class) null)) != null) {
                                    obj4 = b5.f1325c;
                                    if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                        if (obj2 != null) {
                                            b5.f1325c = obj2;
                                        } else if (qVar.f(b5)) {
                                            h(lVarArr, i5, p(qVar.f1342f));
                                        }
                                    }
                                }
                                obj4 = null;
                            } else if (k5 instanceof m) {
                                throw new IllegalStateException("Recursive update");
                            }
                        }
                        z4 = false;
                        obj4 = null;
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (z4) {
                    if (obj4 != null) {
                        if (obj2 == null) {
                            a(-1, -1);
                        }
                        return obj4;
                    }
                }
            }
        }
        return null;
    }

    public void clear() {
        l lVar;
        l[] lVarArr = this.f1298a;
        long j5 = 0;
        loop0:
        while (true) {
            int i5 = 0;
            while (lVarArr != null && i5 < lVarArr.length) {
                l k5 = k(lVarArr, i5);
                if (k5 == null) {
                    i5++;
                } else {
                    int i6 = k5.f1323a;
                    if (i6 == -1) {
                        lVarArr = d(lVarArr, k5);
                    } else {
                        synchronized (k5) {
                            try {
                                if (k(lVarArr, i5) == k5) {
                                    if (i6 >= 0) {
                                        lVar = k5;
                                    } else {
                                        lVar = k5 instanceof q ? ((q) k5).f1342f : null;
                                    }
                                    while (lVar != null) {
                                        j5--;
                                        lVar = lVar.f1326d;
                                    }
                                    h(lVarArr, i5, (l) null);
                                    i5++;
                                }
                            } finally {
                            }
                        }
                    }
                }
            }
        }
        if (j5 != 0) {
            a(j5, -1);
        }
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [j$.util.concurrent.b, java.util.Set<K>, j$.util.concurrent.i] */
    public Set<K> keySet() {
        i iVar = this.f1301d;
        if (iVar != null) {
            return iVar;
        }
        ? bVar = new b(this);
        this.f1301d = bVar;
        return bVar;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Collection<V>, j$.util.concurrent.b, j$.util.concurrent.s] */
    public Collection<V> values() {
        s sVar = this.f1302e;
        if (sVar != null) {
            return sVar;
        }
        ? bVar = new b(this);
        this.f1302e = bVar;
        return bVar;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [j$.util.concurrent.b, j$.util.concurrent.e, java.util.Set<java.util.Map$Entry<K, V>>] */
    public Set<Map.Entry<K, V>> entrySet() {
        e eVar = this.f1303f;
        if (eVar != null) {
            return eVar;
        }
        ? bVar = new b(this);
        this.f1303f = bVar;
        return bVar;
    }

    public final int hashCode() {
        l[] lVarArr = this.f1298a;
        int i5 = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 == null) {
                    break;
                }
                i5 += a5.f1325c.hashCode() ^ a5.f1324b.hashCode();
            }
        }
        return i5;
    }

    public final String toString() {
        l[] lVarArr = this.f1298a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder("{");
        l a5 = pVar.a();
        if (a5 != null) {
            while (true) {
                Object obj = a5.f1324b;
                Object obj2 = a5.f1325c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                a5 = pVar.a();
                if (a5 == null) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        Object value;
        Object obj2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        l[] lVarArr = this.f1298a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        while (true) {
            l a5 = pVar.a();
            if (a5 != null) {
                Object obj3 = a5.f1325c;
                Object obj4 = map.get(a5.f1324b);
                if (obj4 == null || (obj4 != obj3 && !obj4.equals(obj3))) {
                    return false;
                }
            } else {
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (obj2 = get(key)) == null || (value != obj2 && !value.equals(obj2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        int i5 = 0;
        int i6 = 1;
        while (i6 < 16) {
            i5++;
            i6 <<= 1;
        }
        int i7 = 32 - i5;
        int i8 = i6 - 1;
        Object[] objArr = new n[16];
        for (int i9 = 0; i9 < 16; i9++) {
            objArr[i9] = new ReentrantLock();
        }
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("segments", objArr);
        putFields.put("segmentShift", i7);
        putFields.put("segmentMask", i8);
        objectOutputStream.writeFields();
        l[] lVarArr = this.f1298a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 == null) {
                    break;
                }
                objectOutputStream.writeObject(a5.f1324b);
                objectOutputStream.writeObject(a5.f1325c);
            }
        }
        objectOutputStream.writeObject((Object) null);
        objectOutputStream.writeObject((Object) null);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        long j5;
        int i5;
        long j6;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j7 = 0;
        long j8 = 0;
        l lVar = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            j5 = 1;
            if (readObject != null && readObject2 != null) {
                j8++;
                lVar = new l(i(readObject.hashCode()), readObject, readObject2, lVar);
            }
        }
        if (j8 == 0) {
            this.sizeCtl = 0;
            return;
        }
        long j9 = (long) (((double) (((float) j8) / 0.75f)) + 1.0d);
        if (j9 >= 1073741824) {
            i5 = 1073741824;
        } else {
            i5 = l((int) j9);
        }
        l[] lVarArr = new l[i5];
        int i6 = i5 - 1;
        while (lVar != null) {
            l lVar2 = lVar.f1326d;
            int i7 = lVar.f1323a;
            int i8 = i7 & i6;
            l k5 = k(lVarArr, i8);
            boolean z4 = true;
            if (k5 == null) {
                j6 = j5;
            } else {
                Object obj2 = lVar.f1324b;
                if (k5.f1323a < 0) {
                    if (((q) k5).e(i7, obj2, lVar.f1325c) == null) {
                        j7 += j5;
                    }
                    j6 = j5;
                } else {
                    j6 = j5;
                    l lVar3 = k5;
                    int i9 = 0;
                    while (true) {
                        if (lVar3 == null) {
                            break;
                        } else if (lVar3.f1323a != i7 || ((obj = lVar3.f1324b) != obj2 && (obj == null || !obj2.equals(obj)))) {
                            i9++;
                            lVar3 = lVar3.f1326d;
                        }
                    }
                    z4 = false;
                    if (z4 && i9 >= 8) {
                        j7 += j6;
                        lVar.f1326d = k5;
                        l lVar4 = lVar;
                        r rVar = null;
                        r rVar2 = null;
                        while (lVar4 != null) {
                            r rVar3 = new r(lVar4.f1323a, lVar4.f1324b, lVar4.f1325c, (l) null, (r) null);
                            rVar3.f1347h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.f1326d = rVar3;
                            }
                            lVar4 = lVar4.f1326d;
                            rVar2 = rVar3;
                        }
                        h(lVarArr, i8, new q(rVar));
                    }
                }
                z4 = false;
            }
            if (z4) {
                j7 += j6;
                lVar.f1326d = k5;
                h(lVarArr, i8, lVar);
            }
            lVar = lVar2;
            j5 = j6;
        }
        this.f1298a = lVarArr;
        this.sizeCtl = i5 - (i5 >>> 2);
        this.baseCount = j7;
    }

    public V putIfAbsent(K k5, V v5) {
        return f(k5, v5, true);
    }

    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || g(obj, (Object) null, obj2) == null) ? false : true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj != null && obj2 != null && obj3 != null) {
            return g(obj, obj3, obj2) != null;
        }
        throw null;
    }

    public final Object replace(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return g(obj, obj2, (Object) null);
        }
        throw null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? obj2 : obj3;
    }

    public final void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] lVarArr = this.f1298a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 != null) {
                    biConsumer.accept(a5.f1324b, a5.f1325c);
                } else {
                    return;
                }
            }
        }
    }

    public final void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        l[] lVarArr = this.f1298a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 != null) {
                    Object obj = a5.f1325c;
                    Object obj2 = a5.f1324b;
                    do {
                        Object apply = biFunction.apply(obj2, obj);
                        apply.getClass();
                        if (g(obj2, apply, obj) != null || (obj = get(obj2)) == null) {
                        }
                        Object apply2 = biFunction.apply(obj2, obj);
                        apply2.getClass();
                        break;
                    } while ((obj = get(obj2)) == null);
                } else {
                    return;
                }
            }
        }
    }

    public final Object computeIfAbsent(Object obj, Function function) {
        r b5;
        Object obj2;
        Object obj3;
        if (obj == null || function == null) {
            throw null;
        }
        int i5 = i(obj.hashCode());
        l[] lVarArr = this.f1298a;
        Object obj4 = null;
        int i6 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i7 = (length - 1) & i5;
                    l k5 = k(lVarArr, i7);
                    boolean z4 = true;
                    if (k5 == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            try {
                                if (b(lVarArr, i7, mVar)) {
                                    obj4 = function.apply(obj);
                                    h(lVarArr, i7, obj4 != null ? new l(i5, obj, obj4) : null);
                                    i6 = 1;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (i6 != 0) {
                            break;
                        }
                    } else {
                        int i8 = k5.f1323a;
                        if (i8 == -1) {
                            lVarArr = d(lVarArr, k5);
                        } else if (i8 == i5 && (((obj2 = k5.f1324b) == obj || (obj2 != null && obj.equals(obj2))) && (obj3 = k5.f1325c) != null)) {
                            return obj3;
                        } else {
                            synchronized (k5) {
                                try {
                                    if (k(lVarArr, i7) == k5) {
                                        if (i8 >= 0) {
                                            l lVar = k5;
                                            i6 = 1;
                                            while (true) {
                                                if (lVar.f1323a == i5) {
                                                    Object obj5 = lVar.f1324b;
                                                    if (obj5 != obj) {
                                                        if (obj5 != null && obj.equals(obj5)) {
                                                            break;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                                l lVar2 = lVar.f1326d;
                                                if (lVar2 == null) {
                                                    Object apply = function.apply(obj);
                                                    if (apply == null) {
                                                        z4 = false;
                                                    } else if (lVar.f1326d == null) {
                                                        lVar.f1326d = new l(i5, obj, apply);
                                                    } else {
                                                        throw new IllegalStateException("Recursive update");
                                                    }
                                                    obj4 = apply;
                                                } else {
                                                    i6++;
                                                    lVar = lVar2;
                                                }
                                            }
                                            obj4 = lVar.f1325c;
                                        } else if (k5 instanceof q) {
                                            q qVar = (q) k5;
                                            r rVar = qVar.f1341e;
                                            if (rVar == null || (b5 = rVar.b(i5, obj, (Class) null)) == null) {
                                                obj4 = function.apply(obj);
                                                if (obj4 != null) {
                                                    qVar.e(i5, obj, obj4);
                                                } else {
                                                    z4 = false;
                                                }
                                            } else {
                                                z4 = false;
                                                obj4 = b5.f1325c;
                                            }
                                            i6 = 2;
                                        } else if (k5 instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                    z4 = false;
                                } catch (Throwable th2) {
                                    while (true) {
                                        throw th2;
                                    }
                                }
                            }
                            if (i6 != 0) {
                                if (i6 >= 8) {
                                    n(lVarArr, i7);
                                }
                                if (!z4) {
                                    return obj4;
                                }
                            }
                        }
                    }
                }
            }
            lVarArr = e();
        }
        if (obj4 != null) {
            a(1, i6);
        }
        return obj4;
    }

    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        r b5;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int i5 = i(obj.hashCode());
        l[] lVarArr = this.f1298a;
        int i6 = 0;
        Object obj2 = null;
        int i7 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i8 = (length - 1) & i5;
                    l k5 = k(lVarArr, i8);
                    if (k5 == null) {
                        break;
                    }
                    int i9 = k5.f1323a;
                    if (i9 == -1) {
                        lVarArr = d(lVarArr, k5);
                    } else {
                        synchronized (k5) {
                            try {
                                if (k(lVarArr, i8) == k5) {
                                    if (i9 >= 0) {
                                        i7 = 1;
                                        l lVar = null;
                                        l lVar2 = k5;
                                        while (true) {
                                            if (lVar2.f1323a == i5) {
                                                Object obj3 = lVar2.f1324b;
                                                if (obj3 != obj) {
                                                    if (obj3 != null && obj.equals(obj3)) {
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                            l lVar3 = lVar2.f1326d;
                                            if (lVar3 == null) {
                                                break;
                                            }
                                            i7++;
                                            l lVar4 = lVar3;
                                            lVar = lVar2;
                                            lVar2 = lVar4;
                                        }
                                        obj2 = biFunction.apply(obj, lVar2.f1325c);
                                        if (obj2 != null) {
                                            lVar2.f1325c = obj2;
                                        } else {
                                            l lVar5 = lVar2.f1326d;
                                            if (lVar != null) {
                                                lVar.f1326d = lVar5;
                                            } else {
                                                h(lVarArr, i8, lVar5);
                                            }
                                            i6 = -1;
                                        }
                                    } else if (k5 instanceof q) {
                                        q qVar = (q) k5;
                                        r rVar = qVar.f1341e;
                                        if (!(rVar == null || (b5 = rVar.b(i5, obj, (Class) null)) == null)) {
                                            obj2 = biFunction.apply(obj, b5.f1325c);
                                            if (obj2 != null) {
                                                b5.f1325c = obj2;
                                            } else {
                                                if (qVar.f(b5)) {
                                                    h(lVarArr, i8, p(qVar.f1342f));
                                                }
                                                i6 = -1;
                                            }
                                        }
                                        i7 = 2;
                                    } else if (k5 instanceof m) {
                                        throw new IllegalStateException("Recursive update");
                                    }
                                }
                            } catch (Throwable th) {
                                while (true) {
                                    throw th;
                                }
                            }
                        }
                        if (i7 != 0) {
                            break;
                        }
                    }
                }
            }
            lVarArr = e();
        }
        if (i6 != 0) {
            a((long) i6, i7);
        }
        return obj2;
    }

    public final Object compute(Object obj, BiFunction biFunction) {
        Object obj2;
        Object obj3;
        l lVar;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int i5 = i(obj.hashCode());
        l[] lVarArr = this.f1298a;
        int i6 = 0;
        Object obj4 = null;
        int i7 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i8 = (length - 1) & i5;
                    l k5 = k(lVarArr, i8);
                    if (k5 == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            try {
                                if (b(lVarArr, i8, mVar)) {
                                    obj4 = biFunction.apply(obj, null);
                                    if (obj4 != null) {
                                        lVar = new l(i5, obj, obj4);
                                        i7 = 1;
                                    } else {
                                        lVar = null;
                                    }
                                    h(lVarArr, i8, lVar);
                                    i6 = 1;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (i6 != 0) {
                            break;
                        }
                    } else {
                        int i9 = k5.f1323a;
                        if (i9 == -1) {
                            lVarArr = d(lVarArr, k5);
                        } else {
                            synchronized (k5) {
                                try {
                                    if (k(lVarArr, i8) == k5) {
                                        if (i9 >= 0) {
                                            l lVar2 = null;
                                            l lVar3 = k5;
                                            i6 = 1;
                                            while (true) {
                                                if (lVar3.f1323a == i5) {
                                                    Object obj5 = lVar3.f1324b;
                                                    if (obj5 != obj) {
                                                        if (obj5 != null && obj.equals(obj5)) {
                                                            break;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                                l lVar4 = lVar3.f1326d;
                                                if (lVar4 == null) {
                                                    obj2 = biFunction.apply(obj, null);
                                                    if (obj2 != null) {
                                                        if (lVar3.f1326d == null) {
                                                            lVar3.f1326d = new l(i5, obj, obj2);
                                                            i7 = 1;
                                                        } else {
                                                            throw new IllegalStateException("Recursive update");
                                                        }
                                                    }
                                                } else {
                                                    i6++;
                                                    l lVar5 = lVar4;
                                                    lVar2 = lVar3;
                                                    lVar3 = lVar5;
                                                }
                                            }
                                            Object apply = biFunction.apply(obj, lVar3.f1325c);
                                            if (apply != null) {
                                                lVar3.f1325c = apply;
                                                obj4 = apply;
                                            } else {
                                                l lVar6 = lVar3.f1326d;
                                                if (lVar2 != null) {
                                                    lVar2.f1326d = lVar6;
                                                } else {
                                                    h(lVarArr, i8, lVar6);
                                                }
                                                obj4 = apply;
                                                i7 = -1;
                                            }
                                        } else if (k5 instanceof q) {
                                            q qVar = (q) k5;
                                            r rVar = qVar.f1341e;
                                            r b5 = rVar != null ? rVar.b(i5, obj, (Class) null) : null;
                                            if (b5 == null) {
                                                obj3 = null;
                                            } else {
                                                obj3 = b5.f1325c;
                                            }
                                            obj2 = biFunction.apply(obj, obj3);
                                            if (obj2 != null) {
                                                if (b5 != null) {
                                                    b5.f1325c = obj2;
                                                } else {
                                                    qVar.e(i5, obj, obj2);
                                                    i7 = 1;
                                                }
                                            } else if (b5 != null) {
                                                if (qVar.f(b5)) {
                                                    h(lVarArr, i8, p(qVar.f1342f));
                                                }
                                                i7 = -1;
                                            }
                                            i6 = 1;
                                        } else if (k5 instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                        obj4 = obj2;
                                    }
                                } catch (Throwable th2) {
                                    while (true) {
                                        throw th2;
                                    }
                                }
                            }
                            if (i6 != 0) {
                                if (i6 >= 8) {
                                    n(lVarArr, i8);
                                }
                            }
                        }
                    }
                }
            }
            lVarArr = e();
        }
        if (i7 != 0) {
            a((long) i7, i6);
        }
        return obj4;
    }

    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        int i5;
        r rVar;
        Object obj3;
        Object obj4 = obj;
        Object obj5 = obj2;
        BiFunction biFunction2 = biFunction;
        if (obj4 == null || obj5 == null || biFunction2 == null) {
            throw null;
        }
        int i6 = i(obj4.hashCode());
        l[] lVarArr = this.f1298a;
        int i7 = 0;
        Object obj6 = null;
        int i8 = 0;
        while (true) {
            if (lVarArr != null) {
                int length = lVarArr.length;
                if (length != 0) {
                    int i9 = (length - 1) & i6;
                    l k5 = k(lVarArr, i9);
                    i5 = 1;
                    if (k5 != null) {
                        int i10 = k5.f1323a;
                        if (i10 == -1) {
                            lVarArr = d(lVarArr, k5);
                        } else {
                            synchronized (k5) {
                                try {
                                    if (k(lVarArr, i9) == k5) {
                                        if (i10 >= 0) {
                                            l lVar = null;
                                            l lVar2 = k5;
                                            i7 = 1;
                                            while (true) {
                                                if (lVar2.f1323a == i6) {
                                                    Object obj7 = lVar2.f1324b;
                                                    if (obj7 != obj4) {
                                                        if (obj7 != null && obj4.equals(obj7)) {
                                                            break;
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                                l lVar3 = lVar2.f1326d;
                                                if (lVar3 == null) {
                                                    lVar2.f1326d = new l(i6, obj4, obj5);
                                                    obj6 = obj5;
                                                    i8 = 1;
                                                    break;
                                                }
                                                i7++;
                                                l lVar4 = lVar3;
                                                lVar = lVar2;
                                                lVar2 = lVar4;
                                            }
                                            Object apply = biFunction2.apply(lVar2.f1325c, obj5);
                                            if (apply != null) {
                                                lVar2.f1325c = apply;
                                                obj6 = apply;
                                            } else {
                                                l lVar5 = lVar2.f1326d;
                                                if (lVar != null) {
                                                    lVar.f1326d = lVar5;
                                                } else {
                                                    h(lVarArr, i9, lVar5);
                                                }
                                                obj6 = apply;
                                                i8 = -1;
                                            }
                                        } else if (k5 instanceof q) {
                                            q qVar = (q) k5;
                                            r rVar2 = qVar.f1341e;
                                            if (rVar2 == null) {
                                                rVar = null;
                                            } else {
                                                rVar = rVar2.b(i6, obj4, (Class) null);
                                            }
                                            if (rVar == null) {
                                                obj3 = obj5;
                                            } else {
                                                obj3 = biFunction2.apply(rVar.f1325c, obj5);
                                            }
                                            if (obj3 != null) {
                                                if (rVar != null) {
                                                    rVar.f1325c = obj3;
                                                } else {
                                                    qVar.e(i6, obj4, obj3);
                                                    i8 = 1;
                                                }
                                            } else if (rVar != null) {
                                                if (qVar.f(rVar)) {
                                                    h(lVarArr, i9, p(qVar.f1342f));
                                                }
                                                i8 = -1;
                                            }
                                            i7 = 2;
                                            obj6 = obj3;
                                        } else if (k5 instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                } catch (Throwable th) {
                                    while (true) {
                                        throw th;
                                    }
                                }
                            }
                            if (i7 != 0) {
                                if (i7 >= 8) {
                                    n(lVarArr, i9);
                                }
                                i5 = i8;
                                obj5 = obj6;
                            }
                        }
                    } else if (b(lVarArr, i9, new l(i6, obj4, obj5))) {
                        break;
                    }
                }
            }
            lVarArr = e();
        }
        if (i5 != 0) {
            a((long) i5, i7);
        }
        return obj5;
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    public final l[] e() {
        while (true) {
            l[] lVarArr = this.f1298a;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i5 = this.sizeCtl;
            if (i5 < 0) {
                Thread.yield();
            } else {
                if (f1290h.c(this, f1291i, i5, -1)) {
                    try {
                        l[] lVarArr2 = this.f1298a;
                        if (lVarArr2 != null) {
                            if (lVarArr2.length == 0) {
                            }
                            this.sizeCtl = i5;
                            return lVarArr2;
                        }
                        int i6 = i5 > 0 ? i5 : 16;
                        l[] lVarArr3 = new l[i6];
                        this.f1298a = lVarArr3;
                        i5 = i6 - (i6 >>> 2);
                        lVarArr2 = lVarArr3;
                        this.sizeCtl = i5;
                        return lVarArr2;
                    } catch (Throwable th) {
                        this.sizeCtl = i5;
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (r0.d(r1, r2, r4, r6) == false) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0140, code lost:
        if (r1.f1300c != r6) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0142, code lost:
        r1.f1300c = (j$.util.concurrent.c[]) java.util.Arrays.copyOf(r6, r7 << 1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01ab A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x00c2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(long r25, int r27) {
        /*
            r24 = this;
            r1 = r24
            r8 = r25
            r10 = r27
            j$.util.concurrent.c[] r11 = r1.f1300c
            r12 = 2
            if (r11 != 0) goto L_0x0019
            j$.sun.misc.a r0 = f1290h
            long r2 = f1293k
            long r4 = r1.baseCount
            long r6 = r4 + r8
            boolean r0 = r0.d(r1, r2, r4, r6)
            if (r0 != 0) goto L_0x0049
        L_0x0019:
            r13 = 1
            if (r11 == 0) goto L_0x00a5
            int r0 = r11.length
            int r0 = r0 - r13
            if (r0 < 0) goto L_0x00a5
            j$.util.concurrent.v r2 = j$.util.concurrent.ThreadLocalRandom.f1306f
            java.lang.Object r2 = r2.get()
            j$.util.concurrent.ThreadLocalRandom r2 = (j$.util.concurrent.ThreadLocalRandom) r2
            int r2 = r2.f1309b
            r0 = r0 & r2
            r15 = r11[r0]
            if (r15 == 0) goto L_0x00a5
            j$.sun.misc.a r14 = f1290h
            long r16 = f1295m
            long r2 = r15.value
            long r20 = r2 + r8
            r18 = r2
            boolean r0 = r14.d(r15, r16, r18, r20)
            if (r0 != 0) goto L_0x0041
            goto L_0x00a6
        L_0x0041:
            if (r10 > r13) goto L_0x0045
            goto L_0x01ab
        L_0x0045:
            long r6 = r1.j()
        L_0x0049:
            if (r10 < 0) goto L_0x01ab
        L_0x004b:
            int r4 = r1.sizeCtl
            long r2 = (long) r4
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x01ab
            j$.util.concurrent.l[] r6 = r1.f1298a
            if (r6 == 0) goto L_0x01ab
            int r0 = r6.length
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 >= r2) goto L_0x01ab
            int r0 = java.lang.Integer.numberOfLeadingZeros(r0)
            r2 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 | r2
            if (r4 >= 0) goto L_0x008d
            int r2 = r4 >>> 16
            if (r2 != r0) goto L_0x01ab
            int r2 = r0 + 1
            if (r4 == r2) goto L_0x01ab
            r2 = 65535(0xffff, float:9.1834E-41)
            int r0 = r0 + r2
            if (r4 == r0) goto L_0x01ab
            j$.util.concurrent.l[] r7 = r1.f1299b
            if (r7 == 0) goto L_0x01ab
            int r0 = r1.transferIndex
            if (r0 > 0) goto L_0x007d
            goto L_0x01ab
        L_0x007d:
            j$.sun.misc.a r0 = f1290h
            long r2 = f1291i
            int r5 = r4 + 1
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x00a0
            r1.m(r6, r7)
            goto L_0x00a0
        L_0x008d:
            r2 = r0
            j$.sun.misc.a r0 = f1290h
            r5 = r2
            long r2 = f1291i
            int r5 = r5 << 16
            int r5 = r5 + r12
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x00a0
            r0 = 0
            r1.m(r6, r0)
        L_0x00a0:
            long r6 = r1.j()
            goto L_0x004b
        L_0x00a5:
            r0 = r13
        L_0x00a6:
            j$.util.concurrent.v r2 = j$.util.concurrent.ThreadLocalRandom.f1306f
            java.lang.Object r3 = r2.get()
            j$.util.concurrent.ThreadLocalRandom r3 = (j$.util.concurrent.ThreadLocalRandom) r3
            int r3 = r3.f1309b
            if (r3 != 0) goto L_0x00be
            j$.util.concurrent.ThreadLocalRandom.d()
            java.lang.Object r0 = r2.get()
            j$.util.concurrent.ThreadLocalRandom r0 = (j$.util.concurrent.ThreadLocalRandom) r0
            int r3 = r0.f1309b
            r0 = r13
        L_0x00be:
            r10 = 0
            r11 = r0
            r14 = r3
        L_0x00c1:
            r15 = r10
        L_0x00c2:
            j$.util.concurrent.c[] r6 = r1.f1300c
            if (r6 == 0) goto L_0x016b
            int r7 = r6.length
            if (r7 <= 0) goto L_0x016b
            int r0 = r7 + -1
            r0 = r0 & r14
            r0 = r6[r0]
            if (r0 != 0) goto L_0x0109
            int r0 = r1.cellsBusy
            if (r0 != 0) goto L_0x0107
            j$.util.concurrent.c r6 = new j$.util.concurrent.c
            r6.<init>(r8)
            int r0 = r1.cellsBusy
            if (r0 != 0) goto L_0x0107
            j$.sun.misc.a r0 = f1290h
            long r2 = f1294l
            r4 = 0
            r5 = 1
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x0107
            j$.util.concurrent.c[] r0 = r1.f1300c     // Catch:{ all -> 0x00fb }
            if (r0 == 0) goto L_0x00fd
            int r2 = r0.length     // Catch:{ all -> 0x00fb }
            if (r2 <= 0) goto L_0x00fd
            int r2 = r2 + -1
            r2 = r2 & r14
            r3 = r0[r2]     // Catch:{ all -> 0x00fb }
            if (r3 != 0) goto L_0x00fd
            r0[r2] = r6     // Catch:{ all -> 0x00fb }
            r0 = r13
            goto L_0x00fe
        L_0x00fb:
            r0 = move-exception
            goto L_0x0104
        L_0x00fd:
            r0 = r10
        L_0x00fe:
            r1.cellsBusy = r10
            if (r0 == 0) goto L_0x00c2
            goto L_0x01ab
        L_0x0104:
            r1.cellsBusy = r10
            throw r0
        L_0x0107:
            r15 = r10
            goto L_0x0156
        L_0x0109:
            if (r11 != 0) goto L_0x010d
            r11 = r13
            goto L_0x0156
        L_0x010d:
            j$.sun.misc.a r16 = f1290h
            long r18 = f1295m
            long r2 = r0.value
            long r22 = r2 + r8
            r17 = r0
            r20 = r2
            boolean r0 = r16.d(r17, r18, r20, r22)
            if (r0 == 0) goto L_0x0121
            goto L_0x01ab
        L_0x0121:
            j$.util.concurrent.c[] r0 = r1.f1300c
            if (r0 != r6) goto L_0x0107
            int r0 = f1289g
            if (r7 < r0) goto L_0x012a
            goto L_0x0107
        L_0x012a:
            if (r15 != 0) goto L_0x012e
            r15 = r13
            goto L_0x0156
        L_0x012e:
            int r0 = r1.cellsBusy
            if (r0 != 0) goto L_0x0156
            long r2 = f1294l
            r4 = 0
            r5 = 1
            r0 = r16
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x0156
            j$.util.concurrent.c[] r0 = r1.f1300c     // Catch:{ all -> 0x014d }
            if (r0 != r6) goto L_0x014f
            int r0 = r7 << 1
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r6, r0)     // Catch:{ all -> 0x014d }
            j$.util.concurrent.c[] r0 = (j$.util.concurrent.c[]) r0     // Catch:{ all -> 0x014d }
            r1.f1300c = r0     // Catch:{ all -> 0x014d }
            goto L_0x014f
        L_0x014d:
            r0 = move-exception
            goto L_0x0153
        L_0x014f:
            r1.cellsBusy = r10
            goto L_0x00c1
        L_0x0153:
            r1.cellsBusy = r10
            throw r0
        L_0x0156:
            int r0 = r14 << 13
            r0 = r0 ^ r14
            int r2 = r0 >>> 17
            r0 = r0 ^ r2
            int r2 = r0 << 5
            r0 = r0 ^ r2
            j$.util.concurrent.v r2 = j$.util.concurrent.ThreadLocalRandom.f1306f
            java.lang.Object r2 = r2.get()
            j$.util.concurrent.ThreadLocalRandom r2 = (j$.util.concurrent.ThreadLocalRandom) r2
            r2.f1309b = r0
            r14 = r0
            goto L_0x01ac
        L_0x016b:
            int r0 = r1.cellsBusy
            if (r0 != 0) goto L_0x019d
            j$.util.concurrent.c[] r0 = r1.f1300c
            if (r0 != r6) goto L_0x019d
            j$.sun.misc.a r0 = f1290h
            long r2 = f1294l
            r4 = 0
            r5 = 1
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x019d
            j$.util.concurrent.c[] r0 = r1.f1300c     // Catch:{ all -> 0x0192 }
            if (r0 != r6) goto L_0x0194
            j$.util.concurrent.c[] r0 = new j$.util.concurrent.c[r12]     // Catch:{ all -> 0x0192 }
            r2 = r14 & 1
            j$.util.concurrent.c r3 = new j$.util.concurrent.c     // Catch:{ all -> 0x0192 }
            r3.<init>(r8)     // Catch:{ all -> 0x0192 }
            r0[r2] = r3     // Catch:{ all -> 0x0192 }
            r1.f1300c = r0     // Catch:{ all -> 0x0192 }
            r0 = r13
            goto L_0x0195
        L_0x0192:
            r0 = move-exception
            goto L_0x019a
        L_0x0194:
            r0 = r10
        L_0x0195:
            r1.cellsBusy = r10
            if (r0 == 0) goto L_0x01ac
            goto L_0x01ab
        L_0x019a:
            r1.cellsBusy = r10
            throw r0
        L_0x019d:
            j$.sun.misc.a r0 = f1290h
            long r2 = f1293k
            long r4 = r1.baseCount
            long r6 = r4 + r8
            boolean r0 = r0.d(r1, r2, r4, r6)
            if (r0 == 0) goto L_0x01ac
        L_0x01ab:
            return
        L_0x01ac:
            r1 = r24
            goto L_0x00c2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.a(long, int):void");
    }

    public final l[] d(l[] lVarArr, l lVar) {
        int i5;
        if (!(lVar instanceof g)) {
            return this.f1298a;
        }
        l[] lVarArr2 = ((g) lVar).f1316e;
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(lVarArr.length) | 32768;
        while (true) {
            if (lVarArr2 == this.f1299b && this.f1298a == lVarArr && (i5 = this.sizeCtl) < 0 && (i5 >>> 16) == numberOfLeadingZeros && i5 != numberOfLeadingZeros + 1 && i5 != 65535 + numberOfLeadingZeros && this.transferIndex > 0) {
                if (f1290h.c(this, f1291i, i5, i5 + 1)) {
                    m(lVarArr, lVarArr2);
                    break;
                }
            }
        }
        return lVarArr2;
    }

    public final void o(int i5) {
        int length;
        int l5 = i5 >= 536870912 ? 1073741824 : l(i5 + (i5 >>> 1) + 1);
        while (true) {
            int i6 = this.sizeCtl;
            if (i6 >= 0) {
                l[] lVarArr = this.f1298a;
                if (lVarArr != null && (length = lVarArr.length) != 0) {
                    if (l5 <= i6 || length >= 1073741824) {
                        break;
                    } else if (lVarArr == this.f1298a) {
                        if (f1290h.c(this, f1291i, i6, ((Integer.numberOfLeadingZeros(length) | 32768) << 16) + 2)) {
                            m(lVarArr, (l[]) null);
                        }
                    }
                } else {
                    int i7 = i6 > l5 ? i6 : l5;
                    if (f1290h.c(this, f1291i, i6, -1)) {
                        try {
                            if (this.f1298a == lVarArr) {
                                this.f1298a = new l[i7];
                                i6 = i7 - (i7 >>> 2);
                            }
                            this.sizeCtl = i6;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            this.sizeCtl = i6;
                            throw th2;
                        }
                    }
                }
            } else {
                break;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v11, resolved type: j$.util.concurrent.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v12, resolved type: j$.util.concurrent.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: j$.util.concurrent.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v13, resolved type: j$.util.concurrent.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: j$.util.concurrent.l} */
    /* JADX WARNING: type inference failed for: r10v10, types: [j$.util.concurrent.l] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(j$.util.concurrent.l[] r31, j$.util.concurrent.l[] r32) {
        /*
            r30 = this;
            r1 = r30
            r6 = r31
            int r7 = r6.length
            int r0 = f1289g
            r8 = 1
            if (r0 <= r8) goto L_0x000e
            int r2 = r7 >>> 3
            int r2 = r2 / r0
            goto L_0x000f
        L_0x000e:
            r2 = r7
        L_0x000f:
            r9 = 16
            if (r2 >= r9) goto L_0x0015
            r10 = r9
            goto L_0x0016
        L_0x0015:
            r10 = r2
        L_0x0016:
            if (r32 != 0) goto L_0x0028
            int r0 = r7 << 1
            j$.util.concurrent.l[] r0 = new j$.util.concurrent.l[r0]     // Catch:{ all -> 0x0022 }
            r1.f1299b = r0
            r1.transferIndex = r7
            r11 = r0
            goto L_0x002a
        L_0x0022:
            r0 = 2147483647(0x7fffffff, float:NaN)
            r1.sizeCtl = r0
            return
        L_0x0028:
            r11 = r32
        L_0x002a:
            int r12 = r11.length
            j$.util.concurrent.g r13 = new j$.util.concurrent.g
            r13.<init>(r11)
            r15 = r8
            r0 = 0
            r2 = 0
            r16 = 0
        L_0x0035:
            r3 = -1
            if (r15 == 0) goto L_0x0079
            int r0 = r0 + -1
            if (r0 >= r2) goto L_0x003e
            if (r16 == 0) goto L_0x0043
        L_0x003e:
            r18 = r0
            r17 = r2
            goto L_0x0074
        L_0x0043:
            int r4 = r1.transferIndex
            if (r4 > 0) goto L_0x004a
            r0 = r3
        L_0x0048:
            r15 = 0
            goto L_0x0035
        L_0x004a:
            r3 = r0
            j$.sun.misc.a r0 = f1290h
            r5 = r2
            r17 = r3
            long r2 = f1292j
            if (r4 <= r10) goto L_0x005f
            int r18 = r4 - r10
            r29 = r17
            r17 = r5
            r5 = r18
            r18 = r29
            goto L_0x0064
        L_0x005f:
            r18 = r17
            r17 = r5
            r5 = 0
        L_0x0064:
            boolean r0 = r0.c(r1, r2, r4, r5)
            r2 = r5
            if (r0 == 0) goto L_0x006f
            int r4 = r4 + -1
            r0 = r4
            goto L_0x0048
        L_0x006f:
            r2 = r17
            r0 = r18
            goto L_0x0035
        L_0x0074:
            r2 = r17
            r0 = r18
            goto L_0x0048
        L_0x0079:
            r17 = r2
            r2 = 0
            if (r0 < 0) goto L_0x0084
            if (r0 >= r7) goto L_0x0084
            int r4 = r0 + r7
            if (r4 < r12) goto L_0x008e
        L_0x0084:
            r20 = r7
            r18 = r8
            r19 = r9
            r21 = r10
            goto L_0x019f
        L_0x008e:
            j$.util.concurrent.l r5 = k(r6, r0)
            if (r5 != 0) goto L_0x00a3
            boolean r2 = b(r6, r0, r13)
            r15 = r2
            r20 = r7
            r18 = r8
            r19 = r9
            r21 = r10
            goto L_0x01d3
        L_0x00a3:
            r18 = r8
            int r8 = r5.f1323a
            if (r8 != r3) goto L_0x00b3
            r20 = r7
            r19 = r9
            r21 = r10
            r15 = r18
            goto L_0x01d3
        L_0x00b3:
            monitor-enter(r5)
            j$.util.concurrent.l r3 = k(r6, r0)     // Catch:{ all -> 0x00d1 }
            if (r3 != r5) goto L_0x0195
            if (r8 < 0) goto L_0x0114
            r3 = r8 & r7
            j$.util.concurrent.l r8 = r5.f1326d     // Catch:{ all -> 0x00d1 }
            r15 = r5
        L_0x00c1:
            if (r8 == 0) goto L_0x00d4
            r19 = r9
            int r9 = r8.f1323a     // Catch:{ all -> 0x00d1 }
            r9 = r9 & r7
            if (r9 == r3) goto L_0x00cc
            r15 = r8
            r3 = r9
        L_0x00cc:
            j$.util.concurrent.l r8 = r8.f1326d     // Catch:{ all -> 0x00d1 }
            r9 = r19
            goto L_0x00c1
        L_0x00d1:
            r0 = move-exception
            goto L_0x019d
        L_0x00d4:
            r19 = r9
            if (r3 != 0) goto L_0x00db
            r3 = r2
            r2 = r15
            goto L_0x00dc
        L_0x00db:
            r3 = r15
        L_0x00dc:
            r8 = r5
        L_0x00dd:
            if (r8 == r15) goto L_0x0103
            int r9 = r8.f1323a     // Catch:{ all -> 0x00d1 }
            java.lang.Object r14 = r8.f1324b     // Catch:{ all -> 0x00d1 }
            r20 = r7
            java.lang.Object r7 = r8.f1325c     // Catch:{ all -> 0x00d1 }
            r21 = r9 & r20
            if (r21 != 0) goto L_0x00f4
            r21 = r10
            j$.util.concurrent.l r10 = new j$.util.concurrent.l     // Catch:{ all -> 0x00d1 }
            r10.<init>(r9, r14, r7, r2)     // Catch:{ all -> 0x00d1 }
            r2 = r10
            goto L_0x00fc
        L_0x00f4:
            r21 = r10
            j$.util.concurrent.l r10 = new j$.util.concurrent.l     // Catch:{ all -> 0x00d1 }
            r10.<init>(r9, r14, r7, r3)     // Catch:{ all -> 0x00d1 }
            r3 = r10
        L_0x00fc:
            j$.util.concurrent.l r8 = r8.f1326d     // Catch:{ all -> 0x00d1 }
            r7 = r20
            r10 = r21
            goto L_0x00dd
        L_0x0103:
            r20 = r7
            r21 = r10
            h(r11, r0, r2)     // Catch:{ all -> 0x00d1 }
            h(r11, r4, r3)     // Catch:{ all -> 0x00d1 }
            h(r6, r0, r13)     // Catch:{ all -> 0x00d1 }
        L_0x0110:
            r15 = r18
            goto L_0x019b
        L_0x0114:
            r20 = r7
            r19 = r9
            r21 = r10
            boolean r3 = r5 instanceof j$.util.concurrent.q     // Catch:{ all -> 0x00d1 }
            if (r3 == 0) goto L_0x019b
            r3 = r5
            j$.util.concurrent.q r3 = (j$.util.concurrent.q) r3     // Catch:{ all -> 0x00d1 }
            j$.util.concurrent.r r7 = r3.f1342f     // Catch:{ all -> 0x00d1 }
            r8 = r2
            r9 = r8
            r10 = r7
            r14 = 0
            r15 = 0
            r7 = r9
        L_0x0129:
            if (r10 == 0) goto L_0x0164
            r28 = r3
            int r3 = r10.f1323a     // Catch:{ all -> 0x00d1 }
            j$.util.concurrent.r r22 = new j$.util.concurrent.r     // Catch:{ all -> 0x00d1 }
            r23 = r3
            java.lang.Object r3 = r10.f1324b     // Catch:{ all -> 0x00d1 }
            r24 = r3
            java.lang.Object r3 = r10.f1325c     // Catch:{ all -> 0x00d1 }
            r26 = 0
            r27 = 0
            r25 = r3
            r22.<init>(r23, r24, r25, r26, r27)     // Catch:{ all -> 0x00d1 }
            r3 = r22
            r22 = r23 & r20
            if (r22 != 0) goto L_0x0154
            r3.f1347h = r9     // Catch:{ all -> 0x00d1 }
            if (r9 != 0) goto L_0x014e
            r2 = r3
            goto L_0x0150
        L_0x014e:
            r9.f1326d = r3     // Catch:{ all -> 0x00d1 }
        L_0x0150:
            int r14 = r14 + 1
            r9 = r3
            goto L_0x015f
        L_0x0154:
            r3.f1347h = r8     // Catch:{ all -> 0x00d1 }
            if (r8 != 0) goto L_0x015a
            r7 = r3
            goto L_0x015c
        L_0x015a:
            r8.f1326d = r3     // Catch:{ all -> 0x00d1 }
        L_0x015c:
            int r15 = r15 + 1
            r8 = r3
        L_0x015f:
            j$.util.concurrent.l r10 = r10.f1326d     // Catch:{ all -> 0x00d1 }
            r3 = r28
            goto L_0x0129
        L_0x0164:
            r28 = r3
            r3 = 6
            if (r14 > r3) goto L_0x016e
            j$.util.concurrent.l r2 = p(r2)     // Catch:{ all -> 0x00d1 }
            goto L_0x0179
        L_0x016e:
            if (r15 == 0) goto L_0x0177
            j$.util.concurrent.q r8 = new j$.util.concurrent.q     // Catch:{ all -> 0x00d1 }
            r8.<init>(r2)     // Catch:{ all -> 0x00d1 }
            r2 = r8
            goto L_0x0179
        L_0x0177:
            r2 = r28
        L_0x0179:
            if (r15 > r3) goto L_0x0180
            j$.util.concurrent.l r3 = p(r7)     // Catch:{ all -> 0x00d1 }
            goto L_0x018a
        L_0x0180:
            if (r14 == 0) goto L_0x0188
            j$.util.concurrent.q r3 = new j$.util.concurrent.q     // Catch:{ all -> 0x00d1 }
            r3.<init>(r7)     // Catch:{ all -> 0x00d1 }
            goto L_0x018a
        L_0x0188:
            r3 = r28
        L_0x018a:
            h(r11, r0, r2)     // Catch:{ all -> 0x00d1 }
            h(r11, r4, r3)     // Catch:{ all -> 0x00d1 }
            h(r6, r0, r13)     // Catch:{ all -> 0x00d1 }
            goto L_0x0110
        L_0x0195:
            r20 = r7
            r19 = r9
            r21 = r10
        L_0x019b:
            monitor-exit(r5)     // Catch:{ all -> 0x00d1 }
            goto L_0x01d3
        L_0x019d:
            monitor-exit(r5)     // Catch:{ all -> 0x00d1 }
            throw r0
        L_0x019f:
            if (r16 == 0) goto L_0x01ad
            r1.f1299b = r2
            r1.f1298a = r11
            int r0 = r20 << 1
            int r2 = r20 >>> 1
            int r0 = r0 - r2
            r1.sizeCtl = r0
            return
        L_0x01ad:
            r14 = r0
            j$.sun.misc.a r0 = f1290h
            long r2 = f1291i
            int r4 = r1.sizeCtl
            int r5 = r4 + -1
            boolean r0 = r0.c(r1, r2, r4, r5)
            if (r0 == 0) goto L_0x01d2
            int r4 = r4 + -2
            int r0 = java.lang.Integer.numberOfLeadingZeros(r20)
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 | r1
            int r0 = r0 << 16
            if (r4 == r0) goto L_0x01cb
            return
        L_0x01cb:
            r15 = r18
            r16 = r15
            r0 = r20
            goto L_0x01d3
        L_0x01d2:
            r0 = r14
        L_0x01d3:
            r1 = r30
            r2 = r17
            r8 = r18
            r9 = r19
            r7 = r20
            r10 = r21
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.m(j$.util.concurrent.l[], j$.util.concurrent.l[]):void");
    }

    public final long j() {
        c[] cVarArr = this.f1300c;
        long j5 = this.baseCount;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j5 += cVar.value;
                }
            }
        }
        return j5;
    }

    public final void n(l[] lVarArr, int i5) {
        int length = lVarArr.length;
        if (length < 64) {
            o(length << 1);
            return;
        }
        l k5 = k(lVarArr, i5);
        if (k5 != null && k5.f1323a >= 0) {
            synchronized (k5) {
                try {
                    if (k(lVarArr, i5) == k5) {
                        r rVar = null;
                        r rVar2 = null;
                        l lVar = k5;
                        while (lVar != null) {
                            th = new r(lVar.f1323a, lVar.f1324b, lVar.f1325c, (l) null, (r) null);
                            th.f1347h = rVar2;
                            if (rVar2 != null) {
                                rVar2.f1326d = th;
                            }
                            lVar = lVar.f1326d;
                            rVar2 = th;
                        }
                        h(lVarArr, i5, new q(rVar));
                    }
                } finally {
                    r rVar3 = th;
                }
            }
        }
    }

    public static l p(r rVar) {
        l lVar = null;
        l lVar2 = null;
        for (l lVar3 = rVar; lVar3 != null; lVar3 = lVar3.f1326d) {
            l lVar4 = new l(lVar3.f1323a, lVar3.f1324b, lVar3.f1325c);
            if (lVar2 == null) {
                lVar = lVar4;
            } else {
                lVar2.f1326d = lVar4;
            }
            lVar2 = lVar4;
        }
        return lVar;
    }
}
