package com.mbridge.msdk.tracker.network;

import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final int f11655a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f11656b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f11657c;

    /* renamed from: d  reason: collision with root package name */
    public final List<h> f11658d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f11659e;

    /* renamed from: f  reason: collision with root package name */
    public final long f11660f;

    public r(int i5, byte[] bArr, boolean z4, long j5, List<h> list) {
        this(i5, bArr, a(list), list, z4, j5);
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

    private r(int i5, byte[] bArr, Map<String, String> map, List<h> list, boolean z4, long j5) {
        this.f11655a = i5;
        this.f11656b = bArr;
        this.f11657c = map;
        if (list == null) {
            this.f11658d = null;
        } else {
            this.f11658d = DesugarCollections.unmodifiableList(list);
        }
        this.f11659e = z4;
        this.f11660f = j5;
    }
}
