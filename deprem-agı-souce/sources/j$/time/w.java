package j$.time;

import j$.time.zone.f;
import j$.time.zone.g;
import j$.time.zone.i;
import j$.util.Objects;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public final class w extends ZoneId {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f1215d = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: b  reason: collision with root package name */
    public final String f1216b;

    /* renamed from: c  reason: collision with root package name */
    public final transient f f1217c;

    public static w A(String str, boolean z4) {
        f fVar;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i5 = 0; i5 < length; i5++) {
                char charAt = str.charAt(i5);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i5 == 0) && ((charAt < '0' || charAt > '9' || i5 == 0) && ((charAt != '~' || i5 == 0) && ((charAt != '.' || i5 == 0) && ((charAt != '_' || i5 == 0) && ((charAt != '+' || i5 == 0) && (charAt != '-' || i5 == 0))))))))) {
                    throw new RuntimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                }
            }
            try {
                fVar = i.a(str);
            } catch (g e5) {
                if (!z4) {
                    fVar = null;
                } else {
                    throw e5;
                }
            }
            return new w(str, fVar);
        }
        throw new RuntimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
    }

    public w(String str, f fVar) {
        this.f1216b = str;
        this.f1217c = fVar;
    }

    public final String d() {
        return this.f1216b;
    }

    public final f v() {
        f fVar = this.f1217c;
        return fVar != null ? fVar : i.a(this.f1216b);
    }

    private Object writeReplace() {
        return new r((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void z(DataOutput dataOutput) {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.f1216b);
    }
}
