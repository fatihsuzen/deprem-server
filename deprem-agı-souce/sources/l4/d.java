package l4;

import java.util.Arrays;
import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

public final class d extends u implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final d f25241a = new d();

    public d() {
        super(1);
    }

    public final Object invoke(Object obj) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(((Number) obj).byteValue())}, 1));
        t.d(format, "format(this, *args)");
        return format;
    }
}
