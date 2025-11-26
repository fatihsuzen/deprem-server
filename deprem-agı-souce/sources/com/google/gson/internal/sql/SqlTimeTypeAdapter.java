package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.o;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import j1.C1679a;
import j1.b;
import j1.c;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

final class SqlTimeTypeAdapter extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    static final u f7760b = new u() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.c() == Time.class) {
                return new SqlTimeTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f7761a;

    /* renamed from: e */
    public Time b(C1679a aVar) {
        Time time;
        if (aVar.N() == b.NULL) {
            aVar.J();
            return null;
        }
        String L4 = aVar.L();
        synchronized (this) {
            TimeZone timeZone = this.f7761a.getTimeZone();
            try {
                time = new Time(this.f7761a.parse(L4).getTime());
                this.f7761a.setTimeZone(timeZone);
            } catch (ParseException e5) {
                throw new o("Failed parsing '" + L4 + "' as SQL Time; at path " + aVar.u(), e5);
            } catch (Throwable th) {
                this.f7761a.setTimeZone(timeZone);
                throw th;
            }
        }
        return time;
    }

    /* renamed from: f */
    public void d(c cVar, Time time) {
        String format;
        if (time == null) {
            cVar.z();
            return;
        }
        synchronized (this) {
            format = this.f7761a.format(time);
        }
        cVar.P(format);
    }

    private SqlTimeTypeAdapter() {
        this.f7761a = new SimpleDateFormat("hh:mm:ss a");
    }
}
