package androidx.work;

import X2.C2242i;
import X2.C2250q;
import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.TypeConverter;
import b.w;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import h3.C2453b;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class Data {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final Data EMPTY = new Builder().build();
    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_DATA_BYTES = 10240;
    private static final String NULL_STRING_V1 = "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d";
    private static final short STREAM_MAGIC = -21521;
    private static final short STREAM_VERSION = 1;
    private static final byte TYPE_BOOLEAN = 1;
    private static final byte TYPE_BOOLEAN_ARRAY = 8;
    private static final byte TYPE_BYTE = 2;
    private static final byte TYPE_BYTE_ARRAY = 9;
    private static final byte TYPE_DOUBLE = 6;
    private static final byte TYPE_DOUBLE_ARRAY = 13;
    private static final byte TYPE_FLOAT = 5;
    private static final byte TYPE_FLOAT_ARRAY = 12;
    private static final byte TYPE_INTEGER = 3;
    private static final byte TYPE_INTEGER_ARRAY = 10;
    private static final byte TYPE_LONG = 4;
    private static final byte TYPE_LONG_ARRAY = 11;
    private static final byte TYPE_NULL = 0;
    private static final byte TYPE_STRING = 7;
    private static final byte TYPE_STRING_ARRAY = 14;
    /* access modifiers changed from: private */
    public final Map<String, Object> values;

    public static final class Builder {
        private final Map<String, Object> values = new LinkedHashMap();

        private final Builder putDirect(String str, Object obj) {
            this.values.put(str, obj);
            return this;
        }

        public final Data build() {
            Data data = new Data((Map<String, ?>) this.values);
            Data.Companion.toByteArrayInternalV1(data);
            return data;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final Builder put(String str, Object obj) {
            t.e(str, "key");
            Map<String, Object> map = this.values;
            if (obj == null) {
                obj = null;
            } else {
                C2733c b5 = M.b(obj.getClass());
                if (!t.a(b5, M.b(Boolean.TYPE)) && !t.a(b5, M.b(Byte.TYPE)) && !t.a(b5, M.b(Integer.TYPE)) && !t.a(b5, M.b(Long.TYPE)) && !t.a(b5, M.b(Float.TYPE)) && !t.a(b5, M.b(Double.TYPE)) && !t.a(b5, M.b(String.class)) && !t.a(b5, M.b(Boolean[].class)) && !t.a(b5, M.b(Byte[].class)) && !t.a(b5, M.b(Integer[].class)) && !t.a(b5, M.b(Long[].class)) && !t.a(b5, M.b(Float[].class)) && !t.a(b5, M.b(Double[].class)) && !t.a(b5, M.b(String[].class))) {
                    if (t.a(b5, M.b(boolean[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((boolean[]) obj);
                    } else if (t.a(b5, M.b(byte[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((byte[]) obj);
                    } else if (t.a(b5, M.b(int[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((int[]) obj);
                    } else if (t.a(b5, M.b(long[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((long[]) obj);
                    } else if (t.a(b5, M.b(float[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((float[]) obj);
                    } else if (t.a(b5, M.b(double[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((double[]) obj);
                    } else {
                        throw new IllegalArgumentException("Key " + str + " has invalid type " + b5);
                    }
                }
            }
            map.put(str, obj);
            return this;
        }

        public final Builder putAll(Data data) {
            t.e(data, DataSchemeDataSource.SCHEME_DATA);
            putAll((Map<String, ? extends Object>) data.values);
            return this;
        }

        public final Builder putBoolean(String str, boolean z4) {
            t.e(str, "key");
            return putDirect(str, Boolean.valueOf(z4));
        }

        public final Builder putBooleanArray(String str, boolean[] zArr) {
            t.e(str, "key");
            t.e(zArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(zArr));
            return this;
        }

        public final Builder putByte(String str, byte b5) {
            t.e(str, "key");
            return putDirect(str, Byte.valueOf(b5));
        }

        public final Builder putByteArray(String str, byte[] bArr) {
            t.e(str, "key");
            t.e(bArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(bArr));
            return this;
        }

        public final Builder putDouble(String str, double d5) {
            t.e(str, "key");
            return putDirect(str, Double.valueOf(d5));
        }

        public final Builder putDoubleArray(String str, double[] dArr) {
            t.e(str, "key");
            t.e(dArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(dArr));
            return this;
        }

        public final Builder putFloat(String str, float f5) {
            t.e(str, "key");
            return putDirect(str, Float.valueOf(f5));
        }

        public final Builder putFloatArray(String str, float[] fArr) {
            t.e(str, "key");
            t.e(fArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(fArr));
            return this;
        }

        public final Builder putInt(String str, int i5) {
            t.e(str, "key");
            return putDirect(str, Integer.valueOf(i5));
        }

        public final Builder putIntArray(String str, int[] iArr) {
            t.e(str, "key");
            t.e(iArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(iArr));
            return this;
        }

        public final Builder putLong(String str, long j5) {
            t.e(str, "key");
            return putDirect(str, Long.valueOf(j5));
        }

        public final Builder putLongArray(String str, long[] jArr) {
            t.e(str, "key");
            t.e(jArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(jArr));
            return this;
        }

        public final Builder putString(String str, String str2) {
            t.e(str, "key");
            return putDirect(str, str2);
        }

        public final Builder putStringArray(String str, String[] strArr) {
            t.e(str, "key");
            t.e(strArr, "value");
            return putDirect(str, strArr);
        }

        public final Builder putAll(Map<String, ? extends Object> map) {
            t.e(map, "values");
            for (Map.Entry next : map.entrySet()) {
                put((String) next.getKey(), next.getValue());
            }
            return this;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private static final boolean fromByteArray$isObjectStream(ByteArrayInputStream byteArrayInputStream) {
            byte[] bArr = new byte[2];
            byteArrayInputStream.read(bArr);
            byte b5 = (byte) -21267;
            boolean z4 = false;
            if (bArr[0] == ((byte) 16777132) && bArr[1] == b5) {
                z4 = true;
            }
            byteArrayInputStream.reset();
            return z4;
        }

        private static final void fromByteArray$readHeader(DataInputStream dataInputStream) {
            short readShort = dataInputStream.readShort();
            if (readShort == -21521) {
                short readShort2 = dataInputStream.readShort();
                if (readShort2 != 1) {
                    throw new IllegalStateException(("Unsupported version number: " + readShort2).toString());
                }
                return;
            }
            throw new IllegalStateException(("Magic number doesn't match: " + readShort).toString());
        }

        private static final Object fromByteArray$readValue(DataInputStream dataInputStream, byte b5) {
            if (b5 == 0) {
                return null;
            }
            if (b5 == 1) {
                return Boolean.valueOf(dataInputStream.readBoolean());
            }
            if (b5 == 2) {
                return Byte.valueOf(dataInputStream.readByte());
            }
            if (b5 == 3) {
                return Integer.valueOf(dataInputStream.readInt());
            }
            if (b5 == 4) {
                return Long.valueOf(dataInputStream.readLong());
            }
            if (b5 == 5) {
                return Float.valueOf(dataInputStream.readFloat());
            }
            if (b5 == 6) {
                return Double.valueOf(dataInputStream.readDouble());
            }
            if (b5 == 7) {
                return dataInputStream.readUTF();
            }
            int i5 = 0;
            if (b5 == 8) {
                int readInt = dataInputStream.readInt();
                Boolean[] boolArr = new Boolean[readInt];
                while (i5 < readInt) {
                    boolArr[i5] = Boolean.valueOf(dataInputStream.readBoolean());
                    i5++;
                }
                return boolArr;
            } else if (b5 == 9) {
                int readInt2 = dataInputStream.readInt();
                Byte[] bArr = new Byte[readInt2];
                while (i5 < readInt2) {
                    bArr[i5] = Byte.valueOf(dataInputStream.readByte());
                    i5++;
                }
                return bArr;
            } else if (b5 == 10) {
                int readInt3 = dataInputStream.readInt();
                Integer[] numArr = new Integer[readInt3];
                while (i5 < readInt3) {
                    numArr[i5] = Integer.valueOf(dataInputStream.readInt());
                    i5++;
                }
                return numArr;
            } else if (b5 == 11) {
                int readInt4 = dataInputStream.readInt();
                Long[] lArr = new Long[readInt4];
                while (i5 < readInt4) {
                    lArr[i5] = Long.valueOf(dataInputStream.readLong());
                    i5++;
                }
                return lArr;
            } else if (b5 == 12) {
                int readInt5 = dataInputStream.readInt();
                Float[] fArr = new Float[readInt5];
                while (i5 < readInt5) {
                    fArr[i5] = Float.valueOf(dataInputStream.readFloat());
                    i5++;
                }
                return fArr;
            } else if (b5 == 13) {
                int readInt6 = dataInputStream.readInt();
                Double[] dArr = new Double[readInt6];
                while (i5 < readInt6) {
                    dArr[i5] = Double.valueOf(dataInputStream.readDouble());
                    i5++;
                }
                return dArr;
            } else if (b5 == 14) {
                int readInt7 = dataInputStream.readInt();
                String[] strArr = new String[readInt7];
                while (i5 < readInt7) {
                    String readUTF = dataInputStream.readUTF();
                    if (t.a(readUTF, Data.NULL_STRING_V1)) {
                        readUTF = null;
                    }
                    strArr[i5] = readUTF;
                    i5++;
                }
                return strArr;
            } else {
                throw new IllegalStateException("Unsupported type " + b5);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.Double} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.Double} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: java.lang.Float} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.Float} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.lang.Long} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: java.lang.Long} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: java.lang.Byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: java.lang.Byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v22, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v24, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r12v0 */
        /* JADX WARNING: type inference failed for: r12v25 */
        /* JADX WARNING: type inference failed for: r12v26 */
        /* JADX WARNING: type inference failed for: r12v27 */
        /* JADX WARNING: type inference failed for: r12v28 */
        /* JADX WARNING: type inference failed for: r12v29 */
        /* JADX WARNING: type inference failed for: r12v30 */
        /* JADX WARNING: type inference failed for: r12v31 */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static final void toByteArrayInternalV1$writeArray(java.io.DataOutputStream r14, java.lang.Object[] r15) {
            /*
                java.lang.Class r0 = r15.getClass()
                r3.c r0 = kotlin.jvm.internal.M.b(r0)
                java.lang.Class<java.lang.Boolean[]> r1 = java.lang.Boolean[].class
                r3.c r1 = kotlin.jvm.internal.M.b(r1)
                boolean r1 = kotlin.jvm.internal.t.a(r0, r1)
                r2 = 14
                r3 = 13
                r4 = 12
                r5 = 11
                r6 = 10
                r7 = 9
                r8 = 8
                if (r1 == 0) goto L_0x0024
                r0 = r8
                goto L_0x0077
            L_0x0024:
                java.lang.Class<java.lang.Byte[]> r1 = java.lang.Byte[].class
                r3.c r1 = kotlin.jvm.internal.M.b(r1)
                boolean r1 = kotlin.jvm.internal.t.a(r0, r1)
                if (r1 == 0) goto L_0x0032
                r0 = r7
                goto L_0x0077
            L_0x0032:
                java.lang.Class<java.lang.Integer[]> r1 = java.lang.Integer[].class
                r3.c r1 = kotlin.jvm.internal.M.b(r1)
                boolean r1 = kotlin.jvm.internal.t.a(r0, r1)
                if (r1 == 0) goto L_0x0040
                r0 = r6
                goto L_0x0077
            L_0x0040:
                java.lang.Class<java.lang.Long[]> r1 = java.lang.Long[].class
                r3.c r1 = kotlin.jvm.internal.M.b(r1)
                boolean r1 = kotlin.jvm.internal.t.a(r0, r1)
                if (r1 == 0) goto L_0x004e
                r0 = r5
                goto L_0x0077
            L_0x004e:
                java.lang.Class<java.lang.Float[]> r1 = java.lang.Float[].class
                r3.c r1 = kotlin.jvm.internal.M.b(r1)
                boolean r1 = kotlin.jvm.internal.t.a(r0, r1)
                if (r1 == 0) goto L_0x005c
                r0 = r4
                goto L_0x0077
            L_0x005c:
                java.lang.Class<java.lang.Double[]> r1 = java.lang.Double[].class
                r3.c r1 = kotlin.jvm.internal.M.b(r1)
                boolean r1 = kotlin.jvm.internal.t.a(r0, r1)
                if (r1 == 0) goto L_0x006a
                r0 = r3
                goto L_0x0077
            L_0x006a:
                java.lang.Class<java.lang.String[]> r1 = java.lang.String[].class
                r3.c r1 = kotlin.jvm.internal.M.b(r1)
                boolean r0 = kotlin.jvm.internal.t.a(r0, r1)
                if (r0 == 0) goto L_0x011d
                r0 = r2
            L_0x0077:
                r14.writeByte(r0)
                int r1 = r15.length
                r14.writeInt(r1)
                int r1 = r15.length
                r9 = 0
                r10 = r9
            L_0x0081:
                if (r10 >= r1) goto L_0x011c
                r11 = r15[r10]
                r12 = 0
                if (r0 != r8) goto L_0x009c
                boolean r13 = r11 instanceof java.lang.Boolean
                if (r13 == 0) goto L_0x008f
                r12 = r11
                java.lang.Boolean r12 = (java.lang.Boolean) r12
            L_0x008f:
                if (r12 == 0) goto L_0x0096
                boolean r11 = r12.booleanValue()
                goto L_0x0097
            L_0x0096:
                r11 = r9
            L_0x0097:
                r14.writeBoolean(r11)
                goto L_0x0118
            L_0x009c:
                if (r0 != r7) goto L_0x00b2
                boolean r13 = r11 instanceof java.lang.Byte
                if (r13 == 0) goto L_0x00a5
                r12 = r11
                java.lang.Byte r12 = (java.lang.Byte) r12
            L_0x00a5:
                if (r12 == 0) goto L_0x00ac
                byte r11 = r12.byteValue()
                goto L_0x00ad
            L_0x00ac:
                r11 = r9
            L_0x00ad:
                r14.writeByte(r11)
                goto L_0x0118
            L_0x00b2:
                if (r0 != r6) goto L_0x00c7
                boolean r13 = r11 instanceof java.lang.Integer
                if (r13 == 0) goto L_0x00bb
                r12 = r11
                java.lang.Integer r12 = (java.lang.Integer) r12
            L_0x00bb:
                if (r12 == 0) goto L_0x00c2
                int r11 = r12.intValue()
                goto L_0x00c3
            L_0x00c2:
                r11 = r9
            L_0x00c3:
                r14.writeInt(r11)
                goto L_0x0118
            L_0x00c7:
                if (r0 != r5) goto L_0x00dd
                boolean r13 = r11 instanceof java.lang.Long
                if (r13 == 0) goto L_0x00d0
                r12 = r11
                java.lang.Long r12 = (java.lang.Long) r12
            L_0x00d0:
                if (r12 == 0) goto L_0x00d7
                long r11 = r12.longValue()
                goto L_0x00d9
            L_0x00d7:
                r11 = 0
            L_0x00d9:
                r14.writeLong(r11)
                goto L_0x0118
            L_0x00dd:
                if (r0 != r4) goto L_0x00f2
                boolean r13 = r11 instanceof java.lang.Float
                if (r13 == 0) goto L_0x00e6
                r12 = r11
                java.lang.Float r12 = (java.lang.Float) r12
            L_0x00e6:
                if (r12 == 0) goto L_0x00ed
                float r11 = r12.floatValue()
                goto L_0x00ee
            L_0x00ed:
                r11 = 0
            L_0x00ee:
                r14.writeFloat(r11)
                goto L_0x0118
            L_0x00f2:
                if (r0 != r3) goto L_0x0108
                boolean r13 = r11 instanceof java.lang.Double
                if (r13 == 0) goto L_0x00fb
                r12 = r11
                java.lang.Double r12 = (java.lang.Double) r12
            L_0x00fb:
                if (r12 == 0) goto L_0x0102
                double r11 = r12.doubleValue()
                goto L_0x0104
            L_0x0102:
                r11 = 0
            L_0x0104:
                r14.writeDouble(r11)
                goto L_0x0118
            L_0x0108:
                if (r0 != r2) goto L_0x0118
                boolean r13 = r11 instanceof java.lang.String
                if (r13 == 0) goto L_0x0111
                r12 = r11
                java.lang.String r12 = (java.lang.String) r12
            L_0x0111:
                if (r12 != 0) goto L_0x0115
                java.lang.String r12 = "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d"
            L_0x0115:
                r14.writeUTF(r12)
            L_0x0118:
                int r10 = r10 + 1
                goto L_0x0081
            L_0x011c:
                return
            L_0x011d:
                java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unsupported value type "
                r0.append(r1)
                java.lang.Class r15 = r15.getClass()
                r3.c r15 = kotlin.jvm.internal.M.b(r15)
                java.lang.String r15 = r15.a()
                r0.append(r15)
                java.lang.String r15 = r0.toString()
                r14.<init>(r15)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.Companion.toByteArrayInternalV1$writeArray(java.io.DataOutputStream, java.lang.Object[]):void");
        }

        private static final void toByteArrayInternalV1$writeEntry(DataOutputStream dataOutputStream, String str, Object obj) {
            if (obj == null) {
                dataOutputStream.writeByte(0);
            } else if (obj instanceof Boolean) {
                dataOutputStream.writeByte(1);
                dataOutputStream.writeBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                dataOutputStream.writeByte(2);
                dataOutputStream.writeByte(((Number) obj).byteValue());
            } else if (obj instanceof Integer) {
                dataOutputStream.writeByte(3);
                dataOutputStream.writeInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                dataOutputStream.writeByte(4);
                dataOutputStream.writeLong(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                dataOutputStream.writeByte(5);
                dataOutputStream.writeFloat(((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                dataOutputStream.writeByte(6);
                dataOutputStream.writeDouble(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                dataOutputStream.writeByte(7);
                dataOutputStream.writeUTF((String) obj);
            } else if (obj instanceof Object[]) {
                toByteArrayInternalV1$writeArray(dataOutputStream, (Object[]) obj);
            } else {
                throw new IllegalArgumentException("Unsupported value type " + M.b(obj.getClass()).c());
            }
            dataOutputStream.writeUTF(str);
        }

        private static final void toByteArrayInternalV1$writeHeader(DataOutputStream dataOutputStream) {
            dataOutputStream.writeShort(-21521);
            dataOutputStream.writeShort(1);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            h3.C2453b.a(r8, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
            throw r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0074, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            h3.C2453b.a(r8, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0078, code lost:
            throw r3;
         */
        @androidx.room.TypeConverter
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.work.Data fromByteArray(byte[] r8) {
            /*
                r7 = this;
                java.lang.String r0 = "Error in Data#fromByteArray: "
                java.lang.String r1 = "bytes"
                kotlin.jvm.internal.t.e(r8, r1)
                int r1 = r8.length
                r2 = 10240(0x2800, float:1.4349E-41)
                if (r1 > r2) goto L_0x0096
                int r1 = r8.length
                if (r1 != 0) goto L_0x0012
                androidx.work.Data r8 = androidx.work.Data.EMPTY
                return r8
            L_0x0012:
                java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
                r1.<init>()
                java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
                r2.<init>(r8)     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
                boolean r8 = fromByteArray$isObjectStream(r2)     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
                r3 = 0
                r4 = 0
                if (r8 == 0) goto L_0x004d
                java.io.ObjectInputStream r8 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
                r8.<init>(r2)     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
                int r2 = r8.readInt()     // Catch:{ all -> 0x003d }
            L_0x002d:
                if (r3 >= r2) goto L_0x003f
                java.lang.String r5 = r8.readUTF()     // Catch:{ all -> 0x003d }
                java.lang.Object r6 = r8.readObject()     // Catch:{ all -> 0x003d }
                r1.put(r5, r6)     // Catch:{ all -> 0x003d }
                int r3 = r3 + 1
                goto L_0x002d
            L_0x003d:
                r2 = move-exception
                goto L_0x0047
            L_0x003f:
                h3.C2453b.a(r8, r4)     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
                goto L_0x0090
            L_0x0043:
                r8 = move-exception
                goto L_0x0079
            L_0x0045:
                r8 = move-exception
                goto L_0x0085
            L_0x0047:
                throw r2     // Catch:{ all -> 0x0048 }
            L_0x0048:
                r3 = move-exception
                h3.C2453b.a(r8, r2)     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
                throw r3     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
            L_0x004d:
                java.io.DataInputStream r8 = new java.io.DataInputStream     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
                r8.<init>(r2)     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
                fromByteArray$readHeader(r8)     // Catch:{ all -> 0x006d }
                int r2 = r8.readInt()     // Catch:{ all -> 0x006d }
            L_0x0059:
                if (r3 >= r2) goto L_0x006f
                byte r5 = r8.readByte()     // Catch:{ all -> 0x006d }
                java.lang.Object r5 = fromByteArray$readValue(r8, r5)     // Catch:{ all -> 0x006d }
                java.lang.String r6 = r8.readUTF()     // Catch:{ all -> 0x006d }
                r1.put(r6, r5)     // Catch:{ all -> 0x006d }
                int r3 = r3 + 1
                goto L_0x0059
            L_0x006d:
                r2 = move-exception
                goto L_0x0073
            L_0x006f:
                h3.C2453b.a(r8, r4)     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
                goto L_0x0090
            L_0x0073:
                throw r2     // Catch:{ all -> 0x0074 }
            L_0x0074:
                r3 = move-exception
                h3.C2453b.a(r8, r2)     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
                throw r3     // Catch:{ IOException -> 0x0045, ClassNotFoundException -> 0x0043 }
            L_0x0079:
                java.lang.String r2 = androidx.work.Data_Kt.TAG
                androidx.work.Logger r3 = androidx.work.Logger.get()
                r3.error(r2, r0, r8)
                goto L_0x0090
            L_0x0085:
                java.lang.String r2 = androidx.work.Data_Kt.TAG
                androidx.work.Logger r3 = androidx.work.Logger.get()
                r3.error(r2, r0, r8)
            L_0x0090:
                androidx.work.Data r8 = new androidx.work.Data
                r8.<init>((java.util.Map<java.lang.String, ?>) r1)
                return r8
            L_0x0096:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
                r8.<init>(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.Companion.fromByteArray(byte[]):androidx.work.Data");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x006d, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            h3.C2453b.a(r0, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0071, code lost:
            throw r1;
         */
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final byte[] toByteArrayInternalV0(androidx.work.Data r5) {
            /*
                r4 = this;
                java.lang.String r0 = "data"
                kotlin.jvm.internal.t.e(r5, r0)
                java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x005a }
                r0.<init>()     // Catch:{ IOException -> 0x005a }
                java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0064 }
                r1.<init>(r0)     // Catch:{ all -> 0x0064 }
                int r2 = r5.size()     // Catch:{ all -> 0x003f }
                r1.writeInt(r2)     // Catch:{ all -> 0x003f }
                java.util.Map r5 = r5.values     // Catch:{ all -> 0x003f }
                java.util.Set r5 = r5.entrySet()     // Catch:{ all -> 0x003f }
                java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x003f }
            L_0x0022:
                boolean r2 = r5.hasNext()     // Catch:{ all -> 0x003f }
                if (r2 == 0) goto L_0x0041
                java.lang.Object r2 = r5.next()     // Catch:{ all -> 0x003f }
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x003f }
                java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x003f }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x003f }
                java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x003f }
                r1.writeUTF(r3)     // Catch:{ all -> 0x003f }
                r1.writeObject(r2)     // Catch:{ all -> 0x003f }
                goto L_0x0022
            L_0x003f:
                r5 = move-exception
                goto L_0x0066
            L_0x0041:
                W2.J r5 = W2.J.f19942a     // Catch:{ all -> 0x003f }
                r5 = 0
                h3.C2453b.a(r1, r5)     // Catch:{ all -> 0x0064 }
                h3.C2453b.a(r0, r5)     // Catch:{ IOException -> 0x005a }
                int r5 = r0.size()     // Catch:{ IOException -> 0x005a }
                r1 = 10240(0x2800, float:1.4349E-41)
                if (r5 > r1) goto L_0x005c
                byte[] r5 = r0.toByteArray()     // Catch:{ IOException -> 0x005a }
                kotlin.jvm.internal.t.b(r5)     // Catch:{ IOException -> 0x005a }
                return r5
            L_0x005a:
                r5 = move-exception
                goto L_0x0072
            L_0x005c:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x005a }
                java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
                r5.<init>(r0)     // Catch:{ IOException -> 0x005a }
                throw r5     // Catch:{ IOException -> 0x005a }
            L_0x0064:
                r5 = move-exception
                goto L_0x006c
            L_0x0066:
                throw r5     // Catch:{ all -> 0x0067 }
            L_0x0067:
                r2 = move-exception
                h3.C2453b.a(r1, r5)     // Catch:{ all -> 0x0064 }
                throw r2     // Catch:{ all -> 0x0064 }
            L_0x006c:
                throw r5     // Catch:{ all -> 0x006d }
            L_0x006d:
                r1 = move-exception
                h3.C2453b.a(r0, r5)     // Catch:{ IOException -> 0x005a }
                throw r1     // Catch:{ IOException -> 0x005a }
            L_0x0072:
                java.lang.String r0 = androidx.work.Data_Kt.TAG
                androidx.work.Logger r1 = androidx.work.Logger.get()
                java.lang.String r2 = "Error in Data#toByteArray: "
                r1.error(r0, r2, r5)
                r5 = 0
                byte[] r5 = new byte[r5]
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.Companion.toByteArrayInternalV0(androidx.work.Data):byte[]");
        }

        @TypeConverter
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final byte[] toByteArrayInternalV1(Data data) {
            t.e(data, DataSchemeDataSource.SCHEME_DATA);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    toByteArrayInternalV1$writeHeader(dataOutputStream);
                    dataOutputStream.writeInt(data.size());
                    for (Map.Entry entry : data.values.entrySet()) {
                        toByteArrayInternalV1$writeEntry(dataOutputStream, (String) entry.getKey(), entry.getValue());
                    }
                    dataOutputStream.flush();
                    if (dataOutputStream.size() <= 10240) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        C2453b.a(dataOutputStream, (Throwable) null);
                        t.b(byteArray);
                        return byteArray;
                    }
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                } catch (Throwable th) {
                    C2453b.a(dataOutputStream, th);
                    throw th;
                }
            } catch (IOException e5) {
                Logger.get().error(Data_Kt.TAG, "Error in Data#toByteArray: ", e5);
                return new byte[0];
            }
        }

        private Companion() {
        }
    }

    public Data(Data data) {
        t.e(data, "other");
        this.values = new HashMap(data.values);
    }

    @TypeConverter
    public static final Data fromByteArray(byte[] bArr) {
        return Companion.fromByteArray(bArr);
    }

    private final /* synthetic */ <T> T getOrDefault(String str, T t5) {
        T t6 = this.values.get(str);
        t.k(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (w.a(t6)) {
            return t6;
        }
        return t5;
    }

    private final /* synthetic */ <T, TArray> TArray getTypedArray(String str, p pVar) {
        Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (!w.a(objArr)) {
            return null;
        }
        Integer valueOf = Integer.valueOf(objArr.length);
        t.j();
        return pVar.invoke(valueOf, new Data$getTypedArray$1(obj));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final byte[] toByteArrayInternalV0(Data data) {
        return Companion.toByteArrayInternalV0(data);
    }

    @TypeConverter
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final byte[] toByteArrayInternalV1(Data data) {
        return Companion.toByteArrayInternalV1(data);
    }

    /* access modifiers changed from: private */
    public static final CharSequence toString$lambda$7$lambda$6(Map.Entry entry) {
        t.e(entry, "<destruct>");
        Object value = entry.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append((String) entry.getKey());
        sb.append(" : ");
        if (value instanceof Object[]) {
            value = Arrays.toString((Object[]) value);
            t.d(value, "toString(...)");
        }
        sb.append(value);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.a(Data.class, obj.getClass())) {
            return false;
        }
        Data data = (Data) obj;
        Set<String> keySet = this.values.keySet();
        if (!t.a(keySet, data.values.keySet())) {
            return false;
        }
        for (String next : keySet) {
            Object obj2 = this.values.get(next);
            Object obj3 = data.values.get(next);
            if (obj2 != null && obj3 != null) {
                if (obj2 instanceof Object[]) {
                    Object[] objArr = (Object[]) obj2;
                    if (obj3 instanceof Object[]) {
                        z4 = C2242i.d(objArr, (Object[]) obj3);
                        continue;
                    }
                }
                z4 = t.a(obj2, obj3);
                continue;
            } else if (obj2 == obj3) {
                z4 = true;
                continue;
            } else {
                z4 = false;
                continue;
            }
            if (!z4) {
                return false;
            }
        }
        return true;
    }

    public final boolean getBoolean(String str, boolean z4) {
        t.e(str, "key");
        Object valueOf = Boolean.valueOf(z4);
        Object obj = this.values.get(str);
        if (obj instanceof Boolean) {
            valueOf = obj;
        }
        return ((Boolean) valueOf).booleanValue();
    }

    public final boolean[] getBooleanArray(String str) {
        t.e(str, "key");
        Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (!w.a(objArr)) {
            return null;
        }
        int length = objArr.length;
        Data$getBooleanArray$$inlined$getTypedArray$1 data$getBooleanArray$$inlined$getTypedArray$1 = new Data$getBooleanArray$$inlined$getTypedArray$1(obj);
        boolean[] zArr = new boolean[length];
        for (int i5 = 0; i5 < length; i5++) {
            zArr[i5] = ((Boolean) data$getBooleanArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i5))).booleanValue();
        }
        return zArr;
    }

    public final byte getByte(String str, byte b5) {
        t.e(str, "key");
        Object valueOf = Byte.valueOf(b5);
        Object obj = this.values.get(str);
        if (obj instanceof Byte) {
            valueOf = obj;
        }
        return ((Number) valueOf).byteValue();
    }

    public final byte[] getByteArray(String str) {
        t.e(str, "key");
        Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (!w.a(objArr)) {
            return null;
        }
        int length = objArr.length;
        Data$getByteArray$$inlined$getTypedArray$1 data$getByteArray$$inlined$getTypedArray$1 = new Data$getByteArray$$inlined$getTypedArray$1(obj);
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            bArr[i5] = ((Number) data$getByteArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i5))).byteValue();
        }
        return bArr;
    }

    public final double getDouble(String str, double d5) {
        t.e(str, "key");
        Object valueOf = Double.valueOf(d5);
        Object obj = this.values.get(str);
        if (obj instanceof Double) {
            valueOf = obj;
        }
        return ((Number) valueOf).doubleValue();
    }

    public final double[] getDoubleArray(String str) {
        t.e(str, "key");
        Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (!w.a(objArr)) {
            return null;
        }
        int length = objArr.length;
        Data$getDoubleArray$$inlined$getTypedArray$1 data$getDoubleArray$$inlined$getTypedArray$1 = new Data$getDoubleArray$$inlined$getTypedArray$1(obj);
        double[] dArr = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr[i5] = ((Number) data$getDoubleArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i5))).doubleValue();
        }
        return dArr;
    }

    public final float getFloat(String str, float f5) {
        t.e(str, "key");
        Object valueOf = Float.valueOf(f5);
        Object obj = this.values.get(str);
        if (obj instanceof Float) {
            valueOf = obj;
        }
        return ((Number) valueOf).floatValue();
    }

    public final float[] getFloatArray(String str) {
        t.e(str, "key");
        Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (!w.a(objArr)) {
            return null;
        }
        int length = objArr.length;
        Data$getFloatArray$$inlined$getTypedArray$1 data$getFloatArray$$inlined$getTypedArray$1 = new Data$getFloatArray$$inlined$getTypedArray$1(obj);
        float[] fArr = new float[length];
        for (int i5 = 0; i5 < length; i5++) {
            fArr[i5] = ((Number) data$getFloatArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i5))).floatValue();
        }
        return fArr;
    }

    public final int getInt(String str, int i5) {
        t.e(str, "key");
        Object valueOf = Integer.valueOf(i5);
        Object obj = this.values.get(str);
        if (obj instanceof Integer) {
            valueOf = obj;
        }
        return ((Number) valueOf).intValue();
    }

    public final int[] getIntArray(String str) {
        t.e(str, "key");
        Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (!w.a(objArr)) {
            return null;
        }
        int length = objArr.length;
        Data$getIntArray$$inlined$getTypedArray$1 data$getIntArray$$inlined$getTypedArray$1 = new Data$getIntArray$$inlined$getTypedArray$1(obj);
        int[] iArr = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = ((Number) data$getIntArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i5))).intValue();
        }
        return iArr;
    }

    public final Map<String, Object> getKeyValueMap() {
        Map<String, Object> unmodifiableMap = DesugarCollections.unmodifiableMap(this.values);
        t.d(unmodifiableMap, "unmodifiableMap(...)");
        return unmodifiableMap;
    }

    public final long getLong(String str, long j5) {
        t.e(str, "key");
        Object valueOf = Long.valueOf(j5);
        Object obj = this.values.get(str);
        if (obj instanceof Long) {
            valueOf = obj;
        }
        return ((Number) valueOf).longValue();
    }

    public final long[] getLongArray(String str) {
        t.e(str, "key");
        Object obj = this.values.get(str);
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (!w.a(objArr)) {
            return null;
        }
        int length = objArr.length;
        Data$getLongArray$$inlined$getTypedArray$1 data$getLongArray$$inlined$getTypedArray$1 = new Data$getLongArray$$inlined$getTypedArray$1(obj);
        long[] jArr = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            jArr[i5] = ((Number) data$getLongArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i5))).longValue();
        }
        return jArr;
    }

    public final String getString(String str) {
        t.e(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.String[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String[] getStringArray(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.t.e(r5, r0)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.values
            java.lang.Object r5 = r0.get(r5)
            boolean r0 = r5 instanceof java.lang.Object[]
            if (r0 == 0) goto L_0x0031
            r0 = r5
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            boolean r1 = b.w.a(r0)
            if (r1 == 0) goto L_0x0031
            int r0 = r0.length
            androidx.work.Data$getStringArray$$inlined$getTypedArray$1 r1 = new androidx.work.Data$getStringArray$$inlined$getTypedArray$1
            r1.<init>(r5)
            java.lang.String[] r5 = new java.lang.String[r0]
            r2 = 0
        L_0x0021:
            if (r2 >= r0) goto L_0x0030
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r1.invoke(r3)
            r5[r2] = r3
            int r2 = r2 + 1
            goto L_0x0021
        L_0x0030:
            return r5
        L_0x0031:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.getStringArray(java.lang.String):java.lang.String[]");
    }

    public final /* synthetic */ <T> boolean hasKey$work_runtime_release(String str) {
        t.e(str, "key");
        t.k(4, ExifInterface.GPS_DIRECTION_TRUE);
        return hasKeyWithValueOfType(str, Object.class);
    }

    public final <T> boolean hasKeyWithValueOfType(String str, Class<T> cls) {
        t.e(str, "key");
        t.e(cls, "klass");
        Object obj = this.values.get(str);
        if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i5;
        int i6 = 0;
        for (Map.Entry next : this.values.entrySet()) {
            Object value = next.getValue();
            if (value instanceof Object[]) {
                i5 = Objects.hashCode(next.getKey()) ^ C2242i.b((Object[]) value);
            } else {
                i5 = next.hashCode();
            }
            i6 += i5;
        }
        return i6 * 31;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int size() {
        return this.values.size();
    }

    public final byte[] toByteArray() {
        return Companion.toByteArrayInternalV1(this);
    }

    public String toString() {
        return "Data {" + C2250q.V(this.values.entrySet(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new a(), 31, (Object) null) + "}";
    }

    public Data(Map<String, ?> map) {
        t.e(map, "values");
        this.values = new HashMap(map);
    }
}
