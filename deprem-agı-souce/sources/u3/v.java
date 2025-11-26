package U3;

import java.io.IOException;

public enum v {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    QUIC("quic");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f19642a;

    private v(String str) {
        this.f19642a = str;
    }

    public static v a(String str) {
        v vVar = HTTP_1_0;
        if (str.equals(vVar.f19642a)) {
            return vVar;
        }
        v vVar2 = HTTP_1_1;
        if (str.equals(vVar2.f19642a)) {
            return vVar2;
        }
        v vVar3 = HTTP_2;
        if (str.equals(vVar3.f19642a)) {
            return vVar3;
        }
        v vVar4 = SPDY_3;
        if (str.equals(vVar4.f19642a)) {
            return vVar4;
        }
        v vVar5 = QUIC;
        if (str.equals(vVar5.f19642a)) {
            return vVar5;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f19642a;
    }
}
