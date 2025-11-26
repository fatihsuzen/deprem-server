package L3;

import H3.b;
import H3.k;
import J3.f;
import K3.e;
import W2.C2223l;
import W2.m;
import X2.C2242i;
import java.util.Arrays;
import kotlin.jvm.internal.t;

public final class I implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Enum[] f18461a;

    /* renamed from: b  reason: collision with root package name */
    private f f18462b;

    /* renamed from: c  reason: collision with root package name */
    private final C2223l f18463c;

    public I(String str, Enum[] enumArr) {
        t.e(str, "serialName");
        t.e(enumArr, "values");
        this.f18461a = enumArr;
        this.f18463c = m.b(new H(this, str));
    }

    private final f b(String str) {
        G g5 = new G(str, this.f18461a.length);
        for (Enum name : this.f18461a) {
            H0.p(g5, name.name(), false, 2, (Object) null);
        }
        return g5;
    }

    /* access modifiers changed from: private */
    public static final f c(I i5, String str) {
        f fVar = i5.f18462b;
        if (fVar == null) {
            return i5.b(str);
        }
        return fVar;
    }

    /* renamed from: d */
    public Enum deserialize(e eVar) {
        t.e(eVar, "decoder");
        int decodeEnum = eVar.decodeEnum(getDescriptor());
        if (decodeEnum >= 0) {
            Enum[] enumArr = this.f18461a;
            if (decodeEnum < enumArr.length) {
                return enumArr[decodeEnum];
            }
        }
        throw new k(decodeEnum + " is not among valid " + getDescriptor().a() + " enum values, values size is " + this.f18461a.length);
    }

    /* renamed from: e */
    public void serialize(K3.f fVar, Enum enumR) {
        t.e(fVar, "encoder");
        t.e(enumR, "value");
        int X4 = C2242i.X(this.f18461a, enumR);
        if (X4 != -1) {
            fVar.encodeEnum(getDescriptor(), X4);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(enumR);
        sb.append(" is not a valid enum ");
        sb.append(getDescriptor().a());
        sb.append(", must be one of ");
        String arrays = Arrays.toString(this.f18461a);
        t.d(arrays, "toString(...)");
        sb.append(arrays);
        throw new k(sb.toString());
    }

    public f getDescriptor() {
        return (f) this.f18463c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().a() + '>';
    }
}
