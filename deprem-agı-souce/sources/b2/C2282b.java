package b2;

import java.io.InputStream;
import java.util.jar.JarFile;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.C2780d;

/* renamed from: b2.b  reason: case insensitive filesystem */
public final class C2282b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f20687b = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f20688a = new StringBuilder();

    /* renamed from: b2.b$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private final String a(byte[] bArr, int i5, int i6, int i7) {
        if (i7 < 0) {
            return null;
        }
        return b(bArr, i6 + d(bArr, i5 + (i7 * 4)));
    }

    private final String b(byte[] bArr, int i5) {
        int i6 = ((bArr[i5 + 1] << 8) & 65280) | (bArr[i5] & 255);
        byte[] bArr2 = new byte[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            bArr2[i7] = bArr[i5 + 2 + (i7 * 2)];
        }
        return new String(bArr2, C2780d.f25888b);
    }

    private final void c(byte[] bArr) {
        int i5;
        String str;
        int d5 = (d(bArr, 16) * 4) + 36;
        int d6 = d(bArr, 12);
        int i6 = d6;
        while (true) {
            if (i6 >= bArr.length - 4) {
                break;
            } else if (d(bArr, i6) == 1048834) {
                d6 = i6;
                break;
            } else {
                i6 += 4;
            }
        }
        int i7 = 0;
        while (i5 < bArr.length) {
            int d7 = d(bArr, i5);
            int d8 = d(bArr, i5 + 20);
            switch (d7) {
                case 1048834:
                    int d9 = d(bArr, i5 + 28);
                    i5 += 36;
                    String a5 = a(bArr, 36, d5, d8);
                    StringBuilder sb = new StringBuilder();
                    for (int i8 = 0; i8 < d9; i8++) {
                        int d10 = d(bArr, i5 + 4);
                        int d11 = d(bArr, i5 + 8);
                        int d12 = d(bArr, i5 + 16);
                        i5 += 20;
                        String a6 = a(bArr, 36, d5, d10);
                        if (d11 != -1) {
                            str = a(bArr, 36, d5, d11);
                        } else {
                            str = String.valueOf(d12);
                        }
                        sb.append(' ' + a6 + "=\"" + str + '\"');
                    }
                    e(i7, '<' + a5 + sb + '>');
                    i7++;
                    break;
                case 1048835:
                    i7--;
                    i5 += 24;
                    e(i7, "</" + a(bArr, 36, d5, d8) + '>');
                    break;
                default:
                    return;
            }
        }
    }

    private final int d(byte[] bArr, int i5) {
        return (bArr[i5] & 255) | ((bArr[i5 + 3] << 24) & -16777216) | ((bArr[i5 + 2] << 16) & 16711680) | ((bArr[i5 + 1] << 8) & 65280);
    }

    private final void e(int i5, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = "                                             ".substring(0, (int) Math.min((double) (i5 * 2), (double) 45));
        t.d(substring, "substring(...)");
        sb.append(substring);
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = this.f20688a;
        sb3.append(sb2);
        sb3.append(10);
    }

    public final String f(String str) {
        try {
            JarFile jarFile = new JarFile(str);
            InputStream inputStream = jarFile.getInputStream(jarFile.getEntry("AndroidManifest.xml"));
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            c(bArr);
        } catch (Exception unused) {
        }
        String sb = this.f20688a.toString();
        t.d(sb, "toString(...)");
        return sb;
    }
}
