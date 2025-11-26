package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.u;
import j1.C1679a;
import j1.c;
import java.sql.Timestamp;
import java.util.Date;

class SqlTimestampTypeAdapter extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    static final u f7762b = new u() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.c() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.l(Date.class));
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final TypeAdapter f7763a;

    /* renamed from: e */
    public Timestamp b(C1679a aVar) {
        Date date = (Date) this.f7763a.b(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    /* renamed from: f */
    public void d(c cVar, Timestamp timestamp) {
        this.f7763a.d(cVar, timestamp);
    }

    private SqlTimestampTypeAdapter(TypeAdapter typeAdapter) {
        this.f7763a = typeAdapter;
    }
}
