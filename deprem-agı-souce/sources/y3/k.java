package Y3;

import U3.v;
import java.net.ProtocolException;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final v f20224a;

    /* renamed from: b  reason: collision with root package name */
    public final int f20225b;

    /* renamed from: c  reason: collision with root package name */
    public final String f20226c;

    public k(v vVar, int i5, String str) {
        this.f20224a = vVar;
        this.f20225b = i5;
        this.f20226c = str;
    }

    public static k a(String str) {
        int i5;
        v vVar;
        String str2;
        if (str.startsWith("HTTP/1.")) {
            i5 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                vVar = v.HTTP_1_0;
            } else if (charAt == 1) {
                vVar = v.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            vVar = v.HTTP_1_0;
            i5 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i6 = i5 + 3;
        if (str.length() >= i6) {
            try {
                int parseInt = Integer.parseInt(str.substring(i5, i6));
                if (str.length() <= i6) {
                    str2 = "";
                } else if (str.charAt(i6) == ' ') {
                    str2 = str.substring(i5 + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new k(vVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f20224a == v.HTTP_1_0) {
            str = "HTTP/1.0";
        } else {
            str = "HTTP/1.1";
        }
        sb.append(str);
        sb.append(' ');
        sb.append(this.f20225b);
        if (this.f20226c != null) {
            sb.append(' ');
            sb.append(this.f20226c);
        }
        return sb.toString();
    }
}
