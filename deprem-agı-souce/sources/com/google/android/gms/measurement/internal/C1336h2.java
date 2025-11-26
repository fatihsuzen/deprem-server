package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.internal.measurement.C1075d0;
import j$.util.Objects;

/* renamed from: com.google.android.gms.measurement.internal.h2  reason: case insensitive filesystem */
final class C1336h2 extends C1075d0 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C1344i2 f6456a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1336h2(C1344i2 i2Var, Context context, String str) {
        super(context, "google_app_measurement_local.db", (SQLiteDatabase.CursorFactory) null, 1);
        Objects.requireNonNull(i2Var);
        this.f6456a = i2Var;
    }

    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e5) {
            throw e5;
        } catch (SQLiteException unused) {
            X2 x22 = this.f6456a.f5730a;
            x22.a().o().a("Opening the local database failed, dropping and recreating it");
            x22.w();
            if (!x22.e().getDatabasePath("google_app_measurement_local.db").delete()) {
                x22.a().o().b("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e6) {
                this.f6456a.f5730a.a().o().b("Failed to open local database. Events will bypass local storage", e6);
                return null;
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        C1433v.b(this.f6456a.f5730a.a(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        C1433v.a(this.f6456a.f5730a.a(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", C1344i2.f6483e);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
    }
}
