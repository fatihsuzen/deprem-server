package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.B;
import com.google.gson.internal.v;
import com.google.gson.o;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import h1.C1671a;
import j$.util.Objects;
import j1.C1679a;
import j1.b;
import j1.c;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter {

    /* renamed from: c  reason: collision with root package name */
    public static final u f7612c = new u() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.c() == Date.class) {
                return new DefaultDateTypeAdapter(a.f7615b, 2, 2);
            }
            return null;
        }

        public String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final a f7613a;

    /* renamed from: b  reason: collision with root package name */
    private final List f7614b;

    public static abstract class a {

        /* renamed from: b  reason: collision with root package name */
        public static final a f7615b = new C0076a(Date.class);

        /* renamed from: a  reason: collision with root package name */
        private final Class f7616a;

        /* renamed from: com.google.gson.internal.bind.DefaultDateTypeAdapter$a$a  reason: collision with other inner class name */
        class C0076a extends a {
            C0076a(Class cls) {
                super(cls);
            }

            /* access modifiers changed from: protected */
            public Date a(Date date) {
                return date;
            }
        }

        protected a(Class cls) {
            this.f7616a = cls;
        }

        /* access modifiers changed from: protected */
        public abstract Date a(Date date);
    }

    private Date e(C1679a aVar) {
        TimeZone timeZone;
        String L4 = aVar.L();
        synchronized (this.f7614b) {
            try {
                for (DateFormat dateFormat : this.f7614b) {
                    timeZone = dateFormat.getTimeZone();
                    Date parse = dateFormat.parse(L4);
                    dateFormat.setTimeZone(timeZone);
                    return parse;
                }
                try {
                    return C1671a.c(L4, new ParsePosition(0));
                } catch (ParseException e5) {
                    throw new o("Failed parsing '" + L4 + "' as Date; at path " + aVar.u(), e5);
                }
            } catch (ParseException unused) {
                dateFormat.setTimeZone(timeZone);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: f */
    public Date b(C1679a aVar) {
        if (aVar.N() == b.NULL) {
            aVar.J();
            return null;
        }
        return this.f7613a.a(e(aVar));
    }

    /* renamed from: g */
    public void d(c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.z();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f7614b.get(0);
        synchronized (this.f7614b) {
            format = dateFormat.format(date);
        }
        cVar.P(format);
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.f7614b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private DefaultDateTypeAdapter(a aVar, int i5, int i6) {
        ArrayList arrayList = new ArrayList();
        this.f7614b = arrayList;
        Objects.requireNonNull(aVar);
        this.f7613a = aVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i5, i6, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i5, i6));
        }
        if (v.c()) {
            arrayList.add(B.c(i5, i6));
        }
    }
}
