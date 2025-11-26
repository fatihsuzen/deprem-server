package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.tracker.network.h;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f9312a;

    /* renamed from: b  reason: collision with root package name */
    public final List<h> f9313b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f9314c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9315d;

    public a(int i5, byte[] bArr, List<h> list) {
        this(i5, bArr, a(list), list);
    }

    private static Map<String, String> a(List<h> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (h next : list) {
            treeMap.put(next.a(), next.b());
        }
        return treeMap;
    }

    private a(int i5, byte[] bArr, Map<String, String> map, List<h> list) {
        this.f9315d = i5;
        this.f9312a = bArr;
        this.f9314c = map;
        if (list == null) {
            this.f9313b = null;
        } else {
            this.f9313b = DesugarCollections.unmodifiableList(list);
        }
    }
}
