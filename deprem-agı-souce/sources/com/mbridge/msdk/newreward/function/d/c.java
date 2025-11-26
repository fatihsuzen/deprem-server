package com.mbridge.msdk.newreward.function.d;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mbridge.msdk.newreward.function.common.DatabaseUtils;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f10919a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10920b = new a();

    /* renamed from: c  reason: collision with root package name */
    private a f10921c;

    private static final class a extends SQLiteOpenHelper {
        public a() {
            super(com.mbridge.msdk.foundation.controller.c.m().c(), MBridgeCommon.Database.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (DatabaseUtils.isDatabaseAvailable(sQLiteDatabase)) {
                sQLiteDatabase.execSQL("create table if not exists campaign(_id integer primary key autoincrement,ad_type integer,app_id text,unit_id text,placement_id text,request_id text,local_id text,bid_token text,header_bidding integer,load_start_time integer,state integer,session_id text,system_id text,backup_id text,parent_session_id text,template integer,invalid_time integer,invalid_time_2 integer,invalid_time_backup integer,ecppv integer,show_count integer,token_rule integer,r_index text,s_show_index text,data text)");
            }
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
            if (DatabaseUtils.isDatabaseAvailable(sQLiteDatabase)) {
                sQLiteDatabase.execSQL("drop table if exists campaign");
                sQLiteDatabase.execSQL("create table if not exists campaign(_id integer primary key autoincrement,ad_type integer,app_id text,unit_id text,placement_id text,request_id text,local_id text,bid_token text,header_bidding integer,load_start_time integer,state integer,session_id text,system_id text,backup_id text,parent_session_id text,template integer,invalid_time integer,invalid_time_2 integer,invalid_time_backup integer,ecppv integer,show_count integer,token_rule integer,r_index text,s_show_index text,data text)");
            }
        }
    }

    private c() {
    }

    public static c a() {
        if (f10919a == null) {
            synchronized (c.class) {
                try {
                    if (f10919a == null) {
                        f10919a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10919a;
    }

    private SQLiteDatabase c() {
        try {
            return this.f10920b.getWritableDatabase();
        } catch (Exception unused) {
            return null;
        }
    }

    public final a b() {
        if (this.f10921c == null) {
            this.f10921c = new a(c());
        }
        return this.f10921c;
    }
}
