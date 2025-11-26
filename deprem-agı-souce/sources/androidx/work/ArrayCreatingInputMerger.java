package androidx.work;

import androidx.work.Data;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;

public final class ArrayCreatingInputMerger extends InputMerger {
    private final Object concatenateArrayAndNonArray(Object obj, Object obj2, Class<?> cls) {
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(cls, length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj2);
        t.b(newInstance);
        return newInstance;
    }

    private final Object concatenateArrays(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Class<?> componentType = obj.getClass().getComponentType();
        t.b(componentType);
        Object newInstance = Array.newInstance(componentType, length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        t.b(newInstance);
        return newInstance;
    }

    private final Object createArrayFor(Object obj, Class<?> cls) {
        Object newInstance = Array.newInstance(cls, 1);
        Array.set(newInstance, 0, obj);
        t.b(newInstance);
        return newInstance;
    }

    public Data merge(List<Data> list) {
        Class cls;
        t.e(list, "inputs");
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        for (Data keyValueMap : list) {
            Iterator<Map.Entry<String, Object>> it = keyValueMap.getKeyValueMap().entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry next = it.next();
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value != null) {
                        cls = value.getClass();
                    } else {
                        cls = String.class;
                    }
                    Object obj = hashMap.get(str);
                    if (obj != null) {
                        Class<?> cls2 = obj.getClass();
                        if (t.a(cls2, cls)) {
                            t.c(value, "null cannot be cast to non-null type kotlin.Any");
                            value = concatenateArrays(obj, value);
                        } else if (t.a(cls2.getComponentType(), cls)) {
                            value = concatenateArrayAndNonArray(obj, value, cls);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else if (cls.isArray()) {
                        t.c(value, "null cannot be cast to non-null type kotlin.Any");
                    } else {
                        value = createArrayFor(value, cls);
                    }
                    hashMap.put(str, value);
                }
            }
        }
        builder.putAll((Map<String, ? extends Object>) hashMap);
        return builder.build();
    }
}
