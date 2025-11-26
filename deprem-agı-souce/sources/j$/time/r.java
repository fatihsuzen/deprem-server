package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.com.android.tools.r8.a;
import j$.util.Objects;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

public final class r implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* renamed from: a  reason: collision with root package name */
    public byte f1173a;

    /* renamed from: b  reason: collision with root package name */
    public Object f1174b;

    public r() {
    }

    public r(byte b5, Object obj) {
        this.f1173a = b5;
        this.f1174b = obj;
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        byte b5 = this.f1173a;
        Object obj = this.f1174b;
        objectOutput.writeByte(b5);
        switch (b5) {
            case 1:
                Duration duration = (Duration) obj;
                objectOutput.writeLong(duration.f1004a);
                objectOutput.writeInt(duration.f1005b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.f1007a);
                objectOutput.writeInt(instant.f1008b);
                return;
            case 3:
                g gVar = (g) obj;
                objectOutput.writeInt(gVar.f1144a);
                objectOutput.writeByte(gVar.f1145b);
                objectOutput.writeByte(gVar.f1146c);
                return;
            case 4:
                ((j) obj).K(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                g gVar2 = localDateTime.f1011a;
                objectOutput.writeInt(gVar2.f1144a);
                objectOutput.writeByte(gVar2.f1145b);
                objectOutput.writeByte(gVar2.f1146c);
                localDateTime.f1012b.K(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.f1023a;
                g gVar3 = localDateTime2.f1011a;
                objectOutput.writeInt(gVar3.f1144a);
                objectOutput.writeByte(gVar3.f1145b);
                objectOutput.writeByte(gVar3.f1146c);
                localDateTime2.f1012b.K(objectOutput);
                zonedDateTime.f1024b.F(objectOutput);
                zonedDateTime.f1025c.z(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((w) obj).f1216b);
                return;
            case 8:
                ((ZoneOffset) obj).F(objectOutput);
                return;
            case 9:
                p pVar = (p) obj;
                pVar.f1167a.K(objectOutput);
                pVar.f1168b.F(objectOutput);
                return;
            case 10:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.f1014a;
                g gVar4 = localDateTime3.f1011a;
                objectOutput.writeInt(gVar4.f1144a);
                objectOutput.writeByte(gVar4.f1145b);
                objectOutput.writeByte(gVar4.f1146c);
                localDateTime3.f1012b.K(objectOutput);
                offsetDateTime.f1015b.F(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((t) obj).f1178a);
                return;
            case 12:
                v vVar = (v) obj;
                objectOutput.writeInt(vVar.f1213a);
                objectOutput.writeByte(vVar.f1214b);
                return;
            case 13:
                n nVar = (n) obj;
                objectOutput.writeByte(nVar.f1163a);
                objectOutput.writeByte(nVar.f1164b);
                return;
            case 14:
                q qVar = (q) obj;
                objectOutput.writeInt(qVar.f1170a);
                objectOutput.writeInt(qVar.f1171b);
                objectOutput.writeInt(qVar.f1172c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public final void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        this.f1173a = readByte;
        this.f1174b = a(readByte, objectInput);
    }

    public static Object a(byte b5, ObjectInput objectInput) {
        switch (b5) {
            case 1:
                Duration duration = Duration.f1003c;
                long readLong = objectInput.readLong();
                long readInt = (long) objectInput.readInt();
                return Duration.e(a.x(readLong, a.B(readInt, C.NANOS_PER_SECOND)), (int) a.A(readInt, C.NANOS_PER_SECOND));
            case 2:
                Instant instant = Instant.f1006c;
                return Instant.w(objectInput.readLong(), (long) objectInput.readInt());
            case 3:
                g gVar = g.f1142d;
                return g.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return j.F(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f1009c;
                g gVar2 = g.f1142d;
                return LocalDateTime.y(g.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), j.F(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.f1009c;
                g gVar3 = g.f1142d;
                LocalDateTime y4 = LocalDateTime.y(g.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), j.F(objectInput));
                ZoneOffset E4 = ZoneOffset.E(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(y4, "localDateTime");
                Objects.requireNonNull(E4, TypedValues.CycleType.S_WAVE_OFFSET);
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || E4.equals(zoneId)) {
                    return new ZonedDateTime(y4, zoneId, E4);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case 7:
                int i5 = w.f1215d;
                return ZoneId.w(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.E(objectInput);
            case 9:
                int i6 = p.f1166c;
                return new p(j.F(objectInput), ZoneOffset.E(objectInput));
            case 10:
                int i7 = OffsetDateTime.f1013c;
                g gVar4 = g.f1142d;
                return new OffsetDateTime(LocalDateTime.y(g.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), j.F(objectInput)), ZoneOffset.E(objectInput));
            case 11:
                int i8 = t.f1177b;
                return t.v(objectInput.readInt());
            case 12:
                int i9 = v.f1212c;
                int readInt2 = objectInput.readInt();
                byte readByte = objectInput.readByte();
                j$.time.temporal.a.YEAR.k((long) readInt2);
                j$.time.temporal.a.MONTH_OF_YEAR.k((long) readByte);
                return new v(readInt2, readByte);
            case 13:
                int i10 = n.f1162c;
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                l y5 = l.y(readByte2);
                Objects.requireNonNull(y5, "month");
                j$.time.temporal.a.DAY_OF_MONTH.k((long) readByte3);
                if (readByte3 <= y5.x()) {
                    return new n(y5.getValue(), readByte3);
                }
                String name = y5.name();
                throw new RuntimeException("Illegal value for DayOfMonth field, value " + readByte3 + " is not valid for month " + name);
            case 14:
                q qVar = q.f1169d;
                int readInt3 = objectInput.readInt();
                int readInt4 = objectInput.readInt();
                int readInt5 = objectInput.readInt();
                if ((readInt3 | readInt4 | readInt5) == 0) {
                    return q.f1169d;
                }
                return new q(readInt3, readInt4, readInt5);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f1174b;
    }
}
