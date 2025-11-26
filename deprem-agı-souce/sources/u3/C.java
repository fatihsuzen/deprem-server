package U3;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

public enum C {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    

    /* renamed from: a  reason: collision with root package name */
    final String f19317a;

    private C(String str) {
        this.f19317a = str;
    }

    public static C a(String str) {
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -503070503:
                if (str.equals("TLSv1.1")) {
                    c5 = 0;
                    break;
                }
                break;
            case -503070502:
                if (str.equals("TLSv1.2")) {
                    c5 = 1;
                    break;
                }
                break;
            case -503070501:
                if (str.equals("TLSv1.3")) {
                    c5 = 2;
                    break;
                }
                break;
            case 79201641:
                if (str.equals("SSLv3")) {
                    c5 = 3;
                    break;
                }
                break;
            case 79923350:
                if (str.equals("TLSv1")) {
                    c5 = 4;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return TLS_1_1;
            case 1:
                return TLS_1_2;
            case 2:
                return TLS_1_3;
            case 3:
                return SSL_3_0;
            case 4:
                return TLS_1_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    static List b(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a5 : strArr) {
            arrayList.add(a(a5));
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public String c() {
        return this.f19317a;
    }
}
