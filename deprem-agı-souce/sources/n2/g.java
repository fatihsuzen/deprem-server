package N2;

import L2.e;
import L2.f;
import com.inmobi.cmp.core.model.Vector;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public abstract class g {
    public static Vector a(String str) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        t.e(str, "value");
        boolean z4 = true;
        Vector vector = new Vector((Map) null, 1, (C2633k) null);
        Map map = e.f18404a;
        f fVar = f.MAX_ID;
        t.e(fVar, "key");
        Map map2 = e.f18405b;
        Integer num = (Integer) map2.get(fVar);
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.intValue();
        }
        String substring = str.substring(0, i5);
        t.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        t.e(fVar, "key");
        Integer num2 = (Integer) map2.get(fVar);
        if (num2 == null) {
            i6 = 0;
        } else {
            i6 = num2.intValue();
        }
        int a5 = d.a(i6, substring);
        t.e(fVar, "key");
        Integer num3 = (Integer) map2.get(fVar);
        if (num3 == null) {
            i7 = 0;
        } else {
            i7 = num3.intValue();
        }
        String valueOf = String.valueOf(str.charAt(i7));
        f fVar2 = f.ENCODING_TYPE;
        t.e(fVar2, "key");
        Integer num4 = (Integer) map2.get(fVar2);
        if (num4 == null) {
            i8 = 0;
        } else {
            i8 = num4.intValue();
        }
        int a6 = d.a(i8, valueOf);
        if (a6 != 0) {
            if (a6 == 1) {
                z4 = true;
            } else {
                throw new L2.g(t.n("h.m", ": Too large value to encode into VectorEncodingType"));
            }
        }
        t.e(fVar2, "key");
        Integer num5 = (Integer) map2.get(fVar2);
        if (num5 == null) {
            i9 = 0;
        } else {
            i9 = num5.intValue();
        }
        int i21 = i7 + i9;
        if (z4) {
            f fVar3 = f.NUM_ENTRIES;
            t.e(fVar3, "key");
            Integer num6 = (Integer) map2.get(fVar3);
            if (num6 == null) {
                i11 = 0;
            } else {
                i11 = num6.intValue();
            }
            String substring2 = str.substring(i21, i11);
            t.d(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            t.e(fVar3, "key");
            Integer num7 = (Integer) map2.get(fVar3);
            if (num7 == null) {
                i12 = 0;
            } else {
                i12 = num7.intValue();
            }
            int a7 = d.a(i12, substring2);
            t.e(fVar3, "key");
            Integer num8 = (Integer) map2.get(fVar3);
            if (num8 == null) {
                i13 = 0;
            } else {
                i13 = num8.intValue();
            }
            i10 = i21 + i13;
            if (a7 >= 0) {
                int i22 = 0;
                while (true) {
                    int i23 = i22 + 1;
                    String valueOf2 = String.valueOf(str.charAt(i10));
                    t.e(valueOf2, "value");
                    boolean a8 = t.a(valueOf2, "1");
                    Map map3 = e.f18404a;
                    f fVar4 = f.SINGLE_OR_RANGE;
                    t.e(fVar4, "key");
                    Map map4 = e.f18405b;
                    Integer num9 = (Integer) map4.get(fVar4);
                    if (num9 == null) {
                        i14 = 0;
                    } else {
                        i14 = num9.intValue();
                    }
                    int i24 = i10 + i14;
                    f fVar5 = f.VENDOR_ID;
                    t.e(fVar5, "key");
                    Integer num10 = (Integer) map4.get(fVar5);
                    if (num10 == null) {
                        i15 = 0;
                    } else {
                        i15 = num10.intValue();
                    }
                    String substring3 = str.substring(i24, i15);
                    t.d(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    t.e(fVar5, "key");
                    Integer num11 = (Integer) map4.get(fVar5);
                    if (num11 == null) {
                        i16 = 0;
                    } else {
                        i16 = num11.intValue();
                    }
                    int a9 = d.a(i16, substring3);
                    t.e(fVar5, "key");
                    Integer num12 = (Integer) map4.get(fVar5);
                    if (num12 == null) {
                        i17 = 0;
                    } else {
                        i17 = num12.intValue();
                    }
                    i10 = i24 + i17;
                    if (a8) {
                        t.e(fVar5, "key");
                        Integer num13 = (Integer) map4.get(fVar5);
                        if (num13 == null) {
                            i18 = 0;
                        } else {
                            i18 = num13.intValue();
                        }
                        String substring4 = str.substring(i10, i18);
                        t.d(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
                        t.e(fVar5, "key");
                        Integer num14 = (Integer) map4.get(fVar5);
                        if (num14 == null) {
                            i19 = 0;
                        } else {
                            i19 = num14.intValue();
                        }
                        int a10 = d.a(i19, substring4);
                        t.e(fVar5, "key");
                        Integer num15 = (Integer) map4.get(fVar5);
                        if (num15 == null) {
                            i20 = 0;
                        } else {
                            i20 = num15.intValue();
                        }
                        i10 += i20;
                        if (a9 <= a10) {
                            while (true) {
                                int i25 = a9 + 1;
                                vector.set(a9);
                                if (a9 == a10) {
                                    break;
                                }
                                a9 = i25;
                            }
                        }
                    } else {
                        vector.set(a9);
                    }
                    if (i22 == a7) {
                        break;
                    }
                    i22 = i23;
                }
            }
        } else {
            int i26 = i21 + a5;
            String substring5 = str.substring(i21, i26);
            t.d(substring5, "this as java.lang.String…ing(startIndex, endIndex)");
            vector = c.a(a5, substring5);
            i10 = i26;
        }
        vector.setBitLength(i10);
        return vector;
    }
}
