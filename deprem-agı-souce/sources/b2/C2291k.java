package b2;

import S1.i;
import android.content.Context;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;

/* renamed from: b2.k  reason: case insensitive filesystem */
public final class C2291k {
    public final boolean a(File file) {
        File[] listFiles;
        t.e(file, "f");
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                t.b(file2);
                a(file2);
            }
        }
        return file.delete();
    }

    public final String b(long j5) {
        if (j5 < 1000) {
            return String.valueOf(j5);
        }
        if (j5 < 1000000) {
            StringBuilder sb = new StringBuilder();
            Q q5 = Q.f24695a;
            String format = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(((double) j5) / ((double) 1000))}, 1));
            t.d(format, "format(...)");
            sb.append(format);
            sb.append('K');
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        Q q6 = Q.f24695a;
        String format2 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(((double) j5) / ((double) 1000000))}, 1));
        t.d(format2, "format(...)");
        sb2.append(format2);
        sb2.append('M');
        return sb2.toString();
    }

    public final String c(long j5) {
        double d5 = ((double) j5) / 1024.0d;
        if (d5 < 1024.0d) {
            StringBuilder sb = new StringBuilder();
            Q q5 = Q.f24695a;
            String format = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d5)}, 1));
            t.d(format, "format(...)");
            sb.append(format);
            sb.append(" KB");
            return sb.toString();
        }
        double d6 = (double) 1024;
        double d7 = d5 / d6;
        if (d7 < 1024.0d) {
            StringBuilder sb2 = new StringBuilder();
            Q q6 = Q.f24695a;
            String format2 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d7)}, 1));
            t.d(format2, "format(...)");
            sb2.append(format2);
            sb2.append(" MB");
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        Q q7 = Q.f24695a;
        String format3 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d7 / d6)}, 1));
        t.d(format3, "format(...)");
        sb3.append(format3);
        sb3.append(" GB");
        return sb3.toString();
    }

    public final String d(long j5, Context context) {
        t.e(context, "context");
        double d5 = ((double) j5) / 1024.0d;
        if (d5 < 1024.0d) {
            int i5 = i.kb_placeholder;
            Q q5 = Q.f24695a;
            String format = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d5)}, 1));
            t.d(format, "format(...)");
            String string = context.getString(i5, new Object[]{format});
            t.b(string);
            return string;
        }
        double d6 = (double) 1024;
        double d7 = d5 / d6;
        if (d7 < 1024.0d) {
            int i6 = i.mb_placeholder;
            Q q6 = Q.f24695a;
            String format2 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d7)}, 1));
            t.d(format2, "format(...)");
            String string2 = context.getString(i6, new Object[]{format2});
            t.b(string2);
            return string2;
        }
        int i7 = i.gb_placeholder;
        Q q7 = Q.f24695a;
        String format3 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(d7 / d6)}, 1));
        t.d(format3, "format(...)");
        String string3 = context.getString(i7, new Object[]{format3});
        t.b(string3);
        return string3;
    }
}
