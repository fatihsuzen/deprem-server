package l4;

import X2.C2242i;
import X2.C2250q;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import kotlin.jvm.internal.t;
import t3.C2780d;
import t3.s;

public abstract class e {
    public static final String a(String str) {
        String str2 = str;
        t.e(str2, "<this>");
        return C2250q.V(s.G0(str2, new String[]{" "}, false, 0, 6, (Object) null), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, c.f25240a, 30, (Object) null);
    }

    public static final String b(String str) {
        t.e(str, "<this>");
        MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
        byte[] bytes = str.getBytes(C2780d.f25888b);
        t.d(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes);
        t.d(digest, "bytes");
        return C2242i.d0(digest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, d.f25241a, 30, (Object) null);
    }
}
