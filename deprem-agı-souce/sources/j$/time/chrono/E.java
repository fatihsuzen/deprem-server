package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.g;
import j$.time.j;
import j$.time.temporal.a;
import j$.time.temporal.r;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

public final class E implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;

    /* renamed from: a  reason: collision with root package name */
    public byte f1032a;

    /* renamed from: b  reason: collision with root package name */
    public Object f1033b;

    public E() {
    }

    public E(byte b5, Object obj) {
        this.f1032a = b5;
        this.f1033b = obj;
    }

    public final void writeExternal(ObjectOutput objectOutput) {
        byte b5 = this.f1032a;
        Object obj = this.f1033b;
        objectOutput.writeByte(b5);
        switch (b5) {
            case 1:
                objectOutput.writeUTF(((C0455a) obj).d());
                return;
            case 2:
                C0461g gVar = (C0461g) obj;
                objectOutput.writeObject(gVar.f1043a);
                objectOutput.writeObject(gVar.f1044b);
                return;
            case 3:
                k kVar = (k) obj;
                objectOutput.writeObject(kVar.f1052a);
                objectOutput.writeObject(kVar.f1053b);
                objectOutput.writeObject(kVar.f1054c);
                return;
            case 4:
                x xVar = (x) obj;
                xVar.getClass();
                objectOutput.writeInt(r.a(xVar, a.YEAR));
                objectOutput.writeByte(r.a(xVar, a.MONTH_OF_YEAR));
                objectOutput.writeByte(r.a(xVar, a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((y) obj).f1083a);
                return;
            case 6:
                q qVar = (q) obj;
                objectOutput.writeObject(qVar.f1067a);
                objectOutput.writeInt(r.a(qVar, a.YEAR));
                objectOutput.writeByte(r.a(qVar, a.MONTH_OF_YEAR));
                objectOutput.writeByte(r.a(qVar, a.DAY_OF_MONTH));
                return;
            case 7:
                C c5 = (C) obj;
                c5.getClass();
                objectOutput.writeInt(r.a(c5, a.YEAR));
                objectOutput.writeByte(r.a(c5, a.MONTH_OF_YEAR));
                objectOutput.writeByte(r.a(c5, a.DAY_OF_MONTH));
                return;
            case 8:
                I i5 = (I) obj;
                i5.getClass();
                objectOutput.writeInt(r.a(i5, a.YEAR));
                objectOutput.writeByte(r.a(i5, a.MONTH_OF_YEAR));
                objectOutput.writeByte(r.a(i5, a.DAY_OF_MONTH));
                return;
            case 9:
                C0462h hVar = (C0462h) obj;
                objectOutput.writeUTF(hVar.f1046a.d());
                objectOutput.writeInt(hVar.f1047b);
                objectOutput.writeInt(hVar.f1048c);
                objectOutput.writeInt(hVar.f1049d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public final void readExternal(ObjectInput objectInput) {
        Object obj;
        byte readByte = objectInput.readByte();
        this.f1032a = readByte;
        switch (readByte) {
            case 1:
                ConcurrentHashMap concurrentHashMap = C0455a.f1039a;
                obj = j$.com.android.tools.r8.a.E(objectInput.readUTF());
                break;
            case 2:
                obj = ((C0456b) objectInput.readObject()).s((j) objectInput.readObject());
                break;
            case 3:
                obj = ((C0459e) objectInput.readObject()).i((ZoneOffset) objectInput.readObject()).m((ZoneId) objectInput.readObject());
                break;
            case 4:
                g gVar = x.f1077d;
                int readInt = objectInput.readInt();
                byte readByte2 = objectInput.readByte();
                byte readByte3 = objectInput.readByte();
                v.f1075c.getClass();
                obj = new x(g.D(readInt, readByte2, readByte3));
                break;
            case 5:
                y yVar = y.f1081d;
                obj = y.l(objectInput.readByte());
                break;
            case 6:
                o oVar = (o) objectInput.readObject();
                int readInt2 = objectInput.readInt();
                byte readByte4 = objectInput.readByte();
                byte readByte5 = objectInput.readByte();
                oVar.getClass();
                obj = new q(oVar, readInt2, readByte4, readByte5);
                break;
            case 7:
                int readInt3 = objectInput.readInt();
                byte readByte6 = objectInput.readByte();
                byte readByte7 = objectInput.readByte();
                A.f1028c.getClass();
                obj = new C(g.D(readInt3 + 1911, readByte6, readByte7));
                break;
            case 8:
                int readInt4 = objectInput.readInt();
                byte readByte8 = objectInput.readByte();
                byte readByte9 = objectInput.readByte();
                G.f1035c.getClass();
                obj = new I(g.D(readInt4 - 543, readByte8, readByte9));
                break;
            case 9:
                int i5 = C0462h.f1045e;
                obj = new C0462h(j$.com.android.tools.r8.a.E(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.f1033b = obj;
    }

    private Object readResolve() {
        return this.f1033b;
    }
}
