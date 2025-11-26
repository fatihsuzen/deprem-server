package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.o;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import j1.C1679a;
import j1.b;
import j1.c;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

final class SqlDateTypeAdapter extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    static final u f7758b = new u() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.c() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f7759a;

    /* renamed from: e */
    public Date b(C1679a aVar) {
        Date date;
        if (aVar.N() == b.NULL) {
            aVar.J();
            return null;
        }
        String L4 = aVar.L();
        synchronized (this) {
            TimeZone timeZone = this.f7759a.getTimeZone();
            try {
                date = new Date(this.f7759a.parse(L4).getTime());
                this.f7759a.setTimeZone(timeZone);
            } catch (ParseException e5) {
                throw new o("Failed parsing '" + L4 + "' as SQL Date; at path " + aVar.u(), e5);
            } catch (Throwable th) {
                this.f7759a.setTimeZone(timeZone);
                throw th;
            }
        }
        return date;
    }

    /* renamed from: f */
    public void d(c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.z();
            return;
        }
        synchronized (this) {
            format = this.f7759a.format(date);
        }
        cVar.P(format);
    }

    private SqlDateTypeAdapter() {
        this.f7759a = new SimpleDateFormat("MMM d, yyyy");
    }
}
