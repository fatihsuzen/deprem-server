package j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import j$.time.LocalDateTime;
import j$.time.g;
import j$.time.temporal.n;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class s extends C0455a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final s f1072c = new s();
    private static final long serialVersionUID = -1440403870442975015L;

    public final m l(int i5) {
        if (i5 == 0) {
            return t.BCE;
        }
        if (i5 == 1) {
            return t.CE;
        }
        throw new RuntimeException("Invalid era: " + i5);
    }

    public final String d() {
        return ExifInterface.TAG_RW2_ISO;
    }

    public final String j() {
        return "iso8601";
    }

    public final C0456b o(n nVar) {
        return g.x(nVar);
    }

    private s() {
    }

    public final C0459e p(LocalDateTime localDateTime) {
        return LocalDateTime.w(localDateTime);
    }

    public static boolean f(long j5) {
        if ((3 & j5) == 0) {
            return j5 % 100 != 0 || j5 % 400 == 0;
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new E((byte) 1, this);
    }
}
