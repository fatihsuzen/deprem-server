package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.w4  reason: case insensitive filesystem */
abstract class C1249w4 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f5615a = 100;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f5616b = 0;

    static int a(byte[] bArr, int i5, C1240v4 v4Var) {
        int i6 = i5 + 1;
        byte b5 = bArr[i5];
        if (b5 < 0) {
            return b(b5, bArr, i6, v4Var);
        }
        v4Var.f5608a = b5;
        return i6;
    }

    static int b(int i5, byte[] bArr, int i6, C1240v4 v4Var) {
        byte b5 = bArr[i6];
        int i7 = i6 + 1;
        int i8 = i5 & 127;
        if (b5 >= 0) {
            v4Var.f5608a = i8 | (b5 << 7);
            return i7;
        }
        int i9 = i8 | ((b5 & Byte.MAX_VALUE) << 7);
        int i10 = i6 + 2;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            v4Var.f5608a = i9 | (b6 << 14);
            return i10;
        }
        int i11 = i9 | ((b6 & Byte.MAX_VALUE) << 14);
        int i12 = i6 + 3;
        byte b7 = bArr[i10];
        if (b7 >= 0) {
            v4Var.f5608a = i11 | (b7 << 21);
            return i12;
        }
        int i13 = i11 | ((b7 & Byte.MAX_VALUE) << 21);
        int i14 = i6 + 4;
        byte b8 = bArr[i12];
        if (b8 >= 0) {
            v4Var.f5608a = i13 | (b8 << 28);
            return i14;
        }
        int i15 = i13 | ((b8 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i16 = i14 + 1;
            if (bArr[i14] < 0) {
                i14 = i16;
            } else {
                v4Var.f5608a = i15;
                return i16;
            }
        }
    }

    static int c(byte[] bArr, int i5, C1240v4 v4Var) {
        long j5 = (long) bArr[i5];
        int i6 = i5 + 1;
        if (j5 >= 0) {
            v4Var.f5609b = j5;
            return i6;
        }
        int i7 = i5 + 2;
        byte b5 = bArr[i6];
        long j6 = (j5 & 127) | (((long) (b5 & Byte.MAX_VALUE)) << 7);
        int i8 = 7;
        while (b5 < 0) {
            int i9 = i7 + 1;
            byte b6 = bArr[i7];
            i8 += 7;
            j6 |= ((long) (b6 & Byte.MAX_VALUE)) << i8;
            int i10 = i9;
            b5 = b6;
            i7 = i10;
        }
        v4Var.f5609b = j6;
        return i7;
    }

    static int d(byte[] bArr, int i5) {
        int i6 = (bArr[i5 + 1] & 255) << 8;
        return ((bArr[i5 + 3] & 255) << 24) | i6 | (bArr[i5] & 255) | ((bArr[i5 + 2] & 255) << 16);
    }

    static long e(byte[] bArr, int i5) {
        return (((long) bArr[i5]) & 255) | ((((long) bArr[i5 + 1]) & 255) << 8) | ((((long) bArr[i5 + 2]) & 255) << 16) | ((((long) bArr[i5 + 3]) & 255) << 24) | ((((long) bArr[i5 + 4]) & 255) << 32) | ((((long) bArr[i5 + 5]) & 255) << 40) | ((((long) bArr[i5 + 6]) & 255) << 48) | ((((long) bArr[i5 + 7]) & 255) << 56);
    }

    static int f(byte[] bArr, int i5, C1240v4 v4Var) {
        int i6;
        int i7;
        int i8;
        int a5 = a(bArr, i5, v4Var);
        int i9 = v4Var.f5608a;
        if (i9 < 0) {
            throw new C1170n5("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if (i9 == 0) {
            v4Var.f5610c = "";
            return a5;
        } else {
            int i10 = C1153l6.f5435a;
            int length = bArr.length;
            if ((((length - a5) - i9) | a5 | i9) >= 0) {
                int i11 = a5 + i9;
                char[] cArr = new char[i9];
                int i12 = 0;
                while (i6 < i11) {
                    byte b5 = bArr[i6];
                    if (!C1135j6.a(b5)) {
                        break;
                    }
                    a5 = i6 + 1;
                    cArr[i12] = (char) b5;
                    i12++;
                }
                int i13 = i12;
                while (i6 < i11) {
                    int i14 = i6 + 1;
                    byte b6 = bArr[i6];
                    if (C1135j6.a(b6)) {
                        cArr[i13] = (char) b6;
                        i13++;
                        i6 = i14;
                        while (i6 < i11) {
                            byte b7 = bArr[i6];
                            if (!C1135j6.a(b7)) {
                                break;
                            }
                            i6++;
                            cArr[i13] = (char) b7;
                            i13++;
                        }
                    } else {
                        if (b6 < -32) {
                            if (i14 < i11) {
                                i7 = i13 + 1;
                                i8 = i6 + 2;
                                C1135j6.b(b6, bArr[i14], cArr, i13);
                            } else {
                                throw new C1170n5("Protocol message had invalid UTF-8.");
                            }
                        } else if (b6 < -16) {
                            if (i14 < i11 - 1) {
                                i7 = i13 + 1;
                                int i15 = i6 + 2;
                                i8 = i6 + 3;
                                C1135j6.c(b6, bArr[i14], bArr[i15], cArr, i13);
                            } else {
                                throw new C1170n5("Protocol message had invalid UTF-8.");
                            }
                        } else if (i14 < i11 - 2) {
                            byte b8 = bArr[i14];
                            int i16 = i6 + 3;
                            i6 += 4;
                            C1135j6.d(b6, b8, bArr[i6 + 2], bArr[i16], cArr, i13);
                            i13 += 2;
                        } else {
                            throw new C1170n5("Protocol message had invalid UTF-8.");
                        }
                        i13 = i7;
                    }
                }
                v4Var.f5610c = new String(cArr, 0, i13);
                return i11;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(a5), Integer.valueOf(i9)}));
        }
    }

    static int g(byte[] bArr, int i5, C1240v4 v4Var) {
        int a5 = a(bArr, i5, v4Var);
        int i6 = v4Var.f5608a;
        if (i6 < 0) {
            throw new C1170n5("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if (i6 > bArr.length - a5) {
            throw new C1170n5("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } else if (i6 == 0) {
            v4Var.f5610c = H4.f4958b;
            return a5;
        } else {
            v4Var.f5610c = H4.k(bArr, a5, i6);
            return a5 + i6;
        }
    }

    static int h(Q5 q5, byte[] bArr, int i5, int i6, C1240v4 v4Var) {
        Object A4 = q5.A();
        Q5 q52 = q5;
        C1240v4 v4Var2 = v4Var;
        int j5 = j(A4, q52, bArr, i5, i6, v4Var2);
        q52.e(A4);
        v4Var2.f5610c = A4;
        return j5;
    }

    static int i(Q5 q5, byte[] bArr, int i5, int i6, int i7, C1240v4 v4Var) {
        Object A4 = q5.A();
        Q5 q52 = q5;
        C1240v4 v4Var2 = v4Var;
        int k5 = k(A4, q52, bArr, i5, i6, i7, v4Var2);
        q52.e(A4);
        v4Var2.f5610c = A4;
        return k5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int j(java.lang.Object r6, com.google.android.gms.internal.measurement.Q5 r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.measurement.C1240v4 r11) {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = b(r9, r8, r0, r11)
            int r9 = r11.f5608a
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x002d
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x002d
            int r10 = r11.f5612e
            int r10 = r10 + 1
            r11.f5612e = r10
            q(r10)
            int r4 = r3 + r9
            r1 = r6
            r0 = r7
            r2 = r8
            r5 = r11
            r0.f(r1, r2, r3, r4, r5)
            int r6 = r5.f5612e
            int r6 = r6 + -1
            r5.f5612e = r6
            r5.f5610c = r1
            return r4
        L_0x002d:
            com.google.android.gms.internal.measurement.n5 r6 = new com.google.android.gms.internal.measurement.n5
            java.lang.String r7 = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C1249w4.j(java.lang.Object, com.google.android.gms.internal.measurement.Q5, byte[], int, int, com.google.android.gms.internal.measurement.v4):int");
    }

    static int k(Object obj, Q5 q5, byte[] bArr, int i5, int i6, int i7, C1240v4 v4Var) {
        int i8 = v4Var.f5612e + 1;
        v4Var.f5612e = i8;
        q(i8);
        I5 i52 = (I5) q5;
        Object obj2 = obj;
        int z4 = i52.z(obj2, bArr, i5, i6, i7, v4Var);
        v4Var.f5612e--;
        v4Var.f5610c = obj2;
        return z4;
    }

    static int l(int i5, byte[] bArr, int i6, int i7, C1143k5 k5Var, C1240v4 v4Var) {
        C1098f5 f5Var = (C1098f5) k5Var;
        int a5 = a(bArr, i6, v4Var);
        f5Var.g(v4Var.f5608a);
        while (a5 < i7) {
            int a6 = a(bArr, a5, v4Var);
            if (i5 != v4Var.f5608a) {
                break;
            }
            a5 = a(bArr, a6, v4Var);
            f5Var.g(v4Var.f5608a);
        }
        return a5;
    }

    static int m(byte[] bArr, int i5, C1143k5 k5Var, C1240v4 v4Var) {
        C1098f5 f5Var = (C1098f5) k5Var;
        int a5 = a(bArr, i5, v4Var);
        int i6 = v4Var.f5608a + a5;
        while (a5 < i6) {
            a5 = a(bArr, a5, v4Var);
            f5Var.g(v4Var.f5608a);
        }
        if (a5 == i6) {
            return a5;
        }
        throw new C1170n5("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int n(Q5 q5, int i5, byte[] bArr, int i6, int i7, C1143k5 k5Var, C1240v4 v4Var) {
        int h5 = h(q5, bArr, i6, i7, v4Var);
        k5Var.add(v4Var.f5610c);
        while (h5 < i7) {
            int a5 = a(bArr, h5, v4Var);
            if (i5 != v4Var.f5608a) {
                break;
            }
            h5 = h(q5, bArr, a5, i7, v4Var);
            k5Var.add(v4Var.f5610c);
        }
        return h5;
    }

    static int o(int i5, byte[] bArr, int i6, int i7, C1072c6 c6Var, C1240v4 v4Var) {
        if ((i5 >>> 3) != 0) {
            int i8 = i5 & 7;
            if (i8 == 0) {
                C1240v4 v4Var2 = v4Var;
                int c5 = c(bArr, i6, v4Var2);
                c6Var.j(i5, Long.valueOf(v4Var2.f5609b));
                return c5;
            } else if (i8 == 1) {
                c6Var.j(i5, Long.valueOf(e(bArr, i6)));
                return i6 + 8;
            } else if (i8 == 2) {
                byte[] bArr2 = bArr;
                C1240v4 v4Var3 = v4Var;
                int a5 = a(bArr2, i6, v4Var3);
                int i9 = v4Var3.f5608a;
                if (i9 < 0) {
                    throw new C1170n5("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                } else if (i9 <= bArr2.length - a5) {
                    if (i9 == 0) {
                        c6Var.j(i5, H4.f4958b);
                    } else {
                        c6Var.j(i5, H4.k(bArr2, a5, i9));
                    }
                    return a5 + i9;
                } else {
                    throw new C1170n5("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
            } else if (i8 == 3) {
                int i10 = (i5 & -8) | 4;
                C1072c6 b5 = C1072c6.b();
                int i11 = v4Var.f5612e + 1;
                v4Var.f5612e = i11;
                q(i11);
                int i12 = 0;
                while (true) {
                    if (i6 >= i7) {
                        break;
                    }
                    int a6 = a(bArr, i6, v4Var);
                    int i13 = v4Var.f5608a;
                    if (i13 == i10) {
                        i12 = i13;
                        i6 = a6;
                        break;
                    }
                    i6 = o(i13, bArr, a6, i7, b5, v4Var);
                    i12 = i13;
                }
                C1240v4 v4Var4 = v4Var;
                v4Var4.f5612e--;
                if (i6 > i7 || i12 != i10) {
                    throw new C1170n5("Failed to parse the message.");
                }
                c6Var.j(i5, b5);
                return i6;
            } else if (i8 == 5) {
                c6Var.j(i5, Integer.valueOf(d(bArr, i6)));
                return i6 + 4;
            } else {
                throw new C1170n5("Protocol message contained an invalid tag (zero).");
            }
        } else {
            throw new C1170n5("Protocol message contained an invalid tag (zero).");
        }
    }

    static int p(int i5, byte[] bArr, int i6, int i7, C1240v4 v4Var) {
        if ((i5 >>> 3) != 0) {
            int i8 = i5 & 7;
            if (i8 == 0) {
                return c(bArr, i6, v4Var);
            }
            if (i8 == 1) {
                return i6 + 8;
            }
            if (i8 == 2) {
                return a(bArr, i6, v4Var) + v4Var.f5608a;
            }
            if (i8 == 3) {
                int i9 = (i5 & -8) | 4;
                int i10 = 0;
                while (i6 < i7) {
                    i6 = a(bArr, i6, v4Var);
                    i10 = v4Var.f5608a;
                    if (i10 == i9) {
                        break;
                    }
                    i6 = p(i10, bArr, i6, i7, v4Var);
                }
                if (i6 <= i7 && i10 == i9) {
                    return i6;
                }
                throw new C1170n5("Failed to parse the message.");
            } else if (i8 == 5) {
                return i6 + 4;
            } else {
                throw new C1170n5("Protocol message contained an invalid tag (zero).");
            }
        } else {
            throw new C1170n5("Protocol message contained an invalid tag (zero).");
        }
    }

    private static void q(int i5) {
        if (i5 >= f5615a) {
            throw new C1170n5("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
