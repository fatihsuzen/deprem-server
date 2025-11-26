package j$.time.zone;

import j$.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.TimeZone;

public final class a implements Externalizable {
    private static final long serialVersionUID = -8885321777449118786L;

    /* renamed from: a  reason: collision with root package name */
    public byte f1219a;

    /* renamed from: b  reason: collision with root package name */
    public Object f1220b;

    public a() {
    }

    public a(byte b5, Object obj) {
        this.f1219a = b5;
        this.f1220b = obj;
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        byte b5 = this.f1219a;
        Object obj = this.f1220b;
        objectOutput.writeByte(b5);
        if (b5 == 1) {
            f fVar = (f) obj;
            objectOutput.writeInt(fVar.f1241a.length);
            for (long c5 : fVar.f1241a) {
                c(c5, objectOutput);
            }
            for (ZoneOffset d5 : fVar.f1242b) {
                d(d5, objectOutput);
            }
            objectOutput.writeInt(fVar.f1243c.length);
            for (long c6 : fVar.f1243c) {
                c(c6, objectOutput);
            }
            for (ZoneOffset d6 : fVar.f1245e) {
                d(d6, objectOutput);
            }
            objectOutput.writeByte(fVar.f1246f.length);
            for (e b6 : fVar.f1246f) {
                b6.b(objectOutput);
            }
        } else if (b5 == 2) {
            b bVar = (b) obj;
            c(bVar.f1222a, objectOutput);
            d(bVar.f1224c, objectOutput);
            d(bVar.f1225d, objectOutput);
        } else if (b5 == 3) {
            ((e) obj).b(objectOutput);
        } else if (b5 == 100) {
            objectOutput.writeUTF(((f) obj).f1247g.getID());
        } else {
            throw new InvalidClassException("Unknown serialized type");
        }
    }

    public final void readExternal(ObjectInput objectInput) {
        Object obj;
        long[] jArr;
        byte readByte = objectInput.readByte();
        this.f1219a = readByte;
        if (readByte == 1) {
            long[] jArr2 = f.f1237i;
            int readInt = objectInput.readInt();
            if (readInt == 0) {
                jArr = jArr2;
            } else {
                jArr = new long[readInt];
            }
            for (int i5 = 0; i5 < readInt; i5++) {
                jArr[i5] = a(objectInput);
            }
            int i6 = readInt + 1;
            ZoneOffset[] zoneOffsetArr = new ZoneOffset[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                zoneOffsetArr[i7] = b(objectInput);
            }
            int readInt2 = objectInput.readInt();
            if (readInt2 != 0) {
                jArr2 = new long[readInt2];
            }
            long[] jArr3 = jArr2;
            for (int i8 = 0; i8 < readInt2; i8++) {
                jArr3[i8] = a(objectInput);
            }
            int i9 = readInt2 + 1;
            ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                zoneOffsetArr2[i10] = b(objectInput);
            }
            int readByte2 = objectInput.readByte();
            e[] eVarArr = readByte2 == 0 ? f.f1238j : new e[readByte2];
            for (int i11 = 0; i11 < readByte2; i11++) {
                eVarArr[i11] = e.a(objectInput);
            }
            obj = new f(jArr, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
        } else if (readByte == 2) {
            int i12 = b.f1221e;
            long a5 = a(objectInput);
            ZoneOffset b5 = b(objectInput);
            ZoneOffset b6 = b(objectInput);
            if (!b5.equals(b6)) {
                obj = new b(a5, b5, b6);
            } else {
                throw new IllegalArgumentException("Offsets must not be equal");
            }
        } else if (readByte == 3) {
            obj = e.a(objectInput);
        } else if (readByte == 100) {
            obj = new f(TimeZone.getTimeZone(objectInput.readUTF()));
        } else {
            throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f1220b = obj;
    }

    private Object readResolve() {
        return this.f1220b;
    }

    public static ZoneOffset b(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.C(dataInput.readInt()) : ZoneOffset.C(readByte * 900);
    }

    public static void c(long j5, DataOutput dataOutput) {
        if (j5 < -4575744000L || j5 >= 10413792000L || j5 % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j5);
            return;
        }
        int i5 = (int) ((j5 + 4575744000L) / 900);
        dataOutput.writeByte((i5 >>> 16) & 255);
        dataOutput.writeByte((i5 >>> 8) & 255);
        dataOutput.writeByte(i5 & 255);
    }

    public static long a(DataInput dataInput) {
        byte readByte = dataInput.readByte() & 255;
        if (readByte == 255) {
            return dataInput.readLong();
        }
        return (((long) (((readByte << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255))) * 900) - 4575744000L;
    }

    public static void d(ZoneOffset zoneOffset, DataOutput dataOutput) {
        int i5 = zoneOffset.f1021b;
        int i6 = i5 % 900 == 0 ? i5 / 900 : 127;
        dataOutput.writeByte(i6);
        if (i6 == 127) {
            dataOutput.writeInt(i5);
        }
    }
}
