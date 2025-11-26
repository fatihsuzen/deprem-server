package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.r4  reason: case insensitive filesystem */
public abstract class C1204r4 implements E5 {
    private static void e(List list, int i5) {
        int size = list.size() - i5;
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 26);
        sb.append("Element at index ");
        sb.append(size);
        sb.append(" is null.");
        String sb2 = sb.toString();
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 >= i5) {
                list.remove(size2);
            } else {
                throw new NullPointerException(sb2);
            }
        }
    }

    protected static void h(Iterable iterable, List list) {
        byte[] bArr = C1152l5.f5434b;
        iterable.getClass();
        if (iterable instanceof C1188p5) {
            List A4 = ((C1188p5) iterable).A();
            C1188p5 p5Var = (C1188p5) list;
            int size = list.size();
            for (Object next : A4) {
                if (next == null) {
                    int size2 = p5Var.size() - size;
                    StringBuilder sb = new StringBuilder(String.valueOf(size2).length() + 26);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    int size3 = p5Var.size();
                    while (true) {
                        size3--;
                        if (size3 >= size) {
                            p5Var.remove(size3);
                        } else {
                            throw new NullPointerException(sb2);
                        }
                    }
                } else if (next instanceof H4) {
                    H4 h42 = (H4) next;
                    p5Var.B();
                } else if (next instanceof byte[]) {
                    byte[] bArr2 = (byte[]) next;
                    H4.k(bArr2, 0, bArr2.length);
                    p5Var.B();
                } else {
                    p5Var.add((String) next);
                }
            }
        } else if (!(iterable instanceof M5)) {
            if (iterable instanceof Collection) {
                int size4 = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size4);
                } else if (list instanceof O5) {
                    ((O5) list).f(list.size() + size4);
                }
            }
            int size5 = list.size();
            if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
                for (Object next2 : iterable) {
                    if (next2 == null) {
                        e(list, size5);
                    }
                    list.add(next2);
                }
                return;
            }
            List list2 = (List) iterable;
            int size6 = list2.size();
            for (int i5 = 0; i5 < size6; i5++) {
                Object obj = list2.get(i5);
                if (obj == null) {
                    e(list, size5);
                }
                list.add(obj);
            }
        } else {
            list.addAll((Collection) iterable);
        }
    }

    public abstract C1204r4 f(byte[] bArr, int i5, int i6);

    public abstract C1204r4 g(byte[] bArr, int i5, int i6, R4 r42);

    public final /* synthetic */ E5 l(byte[] bArr, R4 r42) {
        return g(bArr, 0, bArr.length, r42);
    }

    public final /* synthetic */ E5 v(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }
}
