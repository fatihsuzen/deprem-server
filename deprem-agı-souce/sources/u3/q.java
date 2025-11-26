package U3;

import V3.c;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f19554a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List f19555a = new ArrayList(20);

        private void e(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (!str.isEmpty()) {
                int length = str.length();
                for (int i5 = 0; i5 < length; i5++) {
                    char charAt = str.charAt(i5);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(c.o("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i5), str));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    int i6 = 0;
                    while (i6 < length2) {
                        char charAt2 = str2.charAt(i6);
                        if ((charAt2 > 31 || charAt2 == 9) && charAt2 < 127) {
                            i6++;
                        } else {
                            throw new IllegalArgumentException(c.o("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i6), str, str2));
                        }
                    }
                    return;
                }
                throw new NullPointerException("value for name " + str + " == null");
            } else {
                throw new IllegalArgumentException("name is empty");
            }
        }

        public a a(String str, String str2) {
            e(str, str2);
            return c(str, str2);
        }

        /* access modifiers changed from: package-private */
        public a b(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return c(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return c("", str.substring(1));
            }
            return c("", str);
        }

        /* access modifiers changed from: package-private */
        public a c(String str, String str2) {
            this.f19555a.add(str);
            this.f19555a.add(str2.trim());
            return this;
        }

        public q d() {
            return new q(this);
        }

        public String f(String str) {
            for (int size = this.f19555a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.f19555a.get(size))) {
                    return (String) this.f19555a.get(size + 1);
                }
            }
            return null;
        }

        public a g(String str) {
            int i5 = 0;
            while (i5 < this.f19555a.size()) {
                if (str.equalsIgnoreCase((String) this.f19555a.get(i5))) {
                    this.f19555a.remove(i5);
                    this.f19555a.remove(i5);
                    i5 -= 2;
                }
                i5 += 2;
            }
            return this;
        }

        public a h(String str, String str2) {
            e(str, str2);
            g(str);
            c(str, str2);
            return this;
        }
    }

    q(a aVar) {
        List list = aVar.f19555a;
        this.f19554a = (String[]) list.toArray(new String[list.size()]);
    }

    private static String b(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public String a(String str) {
        return b(this.f19554a, str);
    }

    public String c(int i5) {
        return this.f19554a[i5 * 2];
    }

    public a d() {
        a aVar = new a();
        Collections.addAll(aVar.f19555a, this.f19554a);
        return aVar;
    }

    public int e() {
        return this.f19554a.length / 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q) || !Arrays.equals(((q) obj).f19554a, this.f19554a)) {
            return false;
        }
        return true;
    }

    public String f(int i5) {
        return this.f19554a[(i5 * 2) + 1];
    }

    public List g(String str) {
        int e5 = e();
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < e5; i5++) {
            if (str.equalsIgnoreCase(c(i5))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(f(i5));
            }
        }
        if (arrayList != null) {
            return DesugarCollections.unmodifiableList(arrayList);
        }
        return Collections.EMPTY_LIST;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f19554a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int e5 = e();
        for (int i5 = 0; i5 < e5; i5++) {
            sb.append(c(i5));
            sb.append(": ");
            sb.append(f(i5));
            sb.append("\n");
        }
        return sb.toString();
    }
}
