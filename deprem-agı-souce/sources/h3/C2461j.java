package h3;

import W2.J;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.t;
import s3.C2751e;
import s3.C2754h;

/* renamed from: h3.j  reason: case insensitive filesystem */
public abstract class C2461j {
    public static final long b(Reader reader, Writer writer, int i5) {
        t.e(reader, "<this>");
        t.e(writer, "out");
        char[] cArr = new char[i5];
        int read = reader.read(cArr);
        long j5 = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j5 += (long) read;
            read = reader.read(cArr);
        }
        return j5;
    }

    public static /* synthetic */ long c(Reader reader, Writer writer, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 8192;
        }
        return b(reader, writer, i5);
    }

    public static final void d(Reader reader, l lVar) {
        BufferedReader bufferedReader;
        t.e(reader, "<this>");
        t.e(lVar, "action");
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader, 8192);
        }
        try {
            for (Object invoke : e(bufferedReader)) {
                lVar.invoke(invoke);
            }
            J j5 = J.f19942a;
            C2453b.a(bufferedReader, (Throwable) null);
        } catch (Throwable th) {
            C2453b.a(bufferedReader, th);
            throw th;
        }
    }

    public static final C2751e e(BufferedReader bufferedReader) {
        t.e(bufferedReader, "<this>");
        return C2754h.e(new C2459h(bufferedReader));
    }

    public static final List f(Reader reader) {
        t.e(reader, "<this>");
        ArrayList arrayList = new ArrayList();
        d(reader, new C2460i(arrayList));
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final J g(ArrayList arrayList, String str) {
        t.e(str, "it");
        arrayList.add(str);
        return J.f19942a;
    }

    public static final String h(Reader reader) {
        t.e(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        c(reader, stringWriter, 0, 2, (Object) null);
        String stringWriter2 = stringWriter.toString();
        t.d(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}
