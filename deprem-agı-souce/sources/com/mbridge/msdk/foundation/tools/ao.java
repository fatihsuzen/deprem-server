package com.mbridge.msdk.foundation.tools;

import androidx.work.WorkInfo;
import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.LinkedHashSet;
import java.util.Set;

final class ao implements FastKV.a<Set<String>> {

    /* renamed from: a  reason: collision with root package name */
    static final ao f9666a = new ao();

    private ao() {
    }

    public final /* synthetic */ byte[] a(Object obj) {
        Set<String> set = (Set) obj;
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i5 = 0;
        int i6 = 0;
        for (String str : set) {
            if (str == null) {
                i5 += 5;
                iArr[i6] = -1;
            } else {
                int a5 = q.a(str);
                strArr[i6] = str;
                iArr[i6] = a5;
                i5 += ((a5 >> 7) == 0 ? 1 : (a5 >> 14) == 0 ? 2 : (a5 >> 21) == 0 ? 3 : (a5 >> 28) == 0 ? 4 : 5) + a5;
            }
            i6++;
        }
        q qVar = new q(i5);
        for (int i7 = 0; i7 < size; i7++) {
            int i8 = iArr[i7];
            int i9 = qVar.f9736b;
            int i10 = i8;
            while ((i10 & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
                qVar.f9735a[i9] = (byte) ((i10 & 127) | 128);
                i10 >>>= 7;
                i9++;
            }
            qVar.f9735a[i9] = (byte) i10;
            qVar.f9736b = i9 + 1;
            if (i8 >= 0) {
                qVar.b(strArr[i7]);
            }
        }
        return qVar.f9735a;
    }

    public final String a() {
        return "StringSet";
    }

    public final /* synthetic */ Object a(byte[] bArr, int i5, int i6) {
        int i7;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i6 > 0) {
            q qVar = new q(bArr, i5);
            int i8 = i5 + i6;
            while (true) {
                i7 = qVar.f9736b;
                if (i7 >= i8) {
                    break;
                }
                byte[] bArr2 = qVar.f9735a;
                int i9 = i7 + 1;
                qVar.f9736b = i9;
                byte b5 = bArr2[i7];
                if ((b5 >> 7) != 0) {
                    int i10 = i7 + 2;
                    qVar.f9736b = i10;
                    b5 = (b5 & Byte.MAX_VALUE) | (bArr2[i9] << 7);
                    if ((b5 >> 14) != 0) {
                        byte b6 = b5 & 16383;
                        int i11 = i7 + 3;
                        qVar.f9736b = i11;
                        byte b7 = b6 | (bArr2[i10] << 14);
                        if ((b7 >> 21) == 0) {
                            b5 = b7;
                        } else {
                            int i12 = i7 + 4;
                            qVar.f9736b = i12;
                            b5 = (bArr2[i11] << 21) | (b7 & 2097151);
                            if ((b5 >> 28) != 0) {
                                qVar.f9736b = i7 + 5;
                                b5 = (268435455 & b5) | (bArr2[i12] << 28);
                            }
                        }
                    }
                }
                linkedHashSet.add(qVar.a((int) b5));
            }
            if (i7 != i8) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}
