package com.finazzi.distquake;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class C extends SQLiteOpenHelper {
    C(Context context) {
        super(context, "Chat.db", (SQLiteDatabase.CursorFactory) null, 13);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE chat_allusers (_id INTEGER PRIMARY KEY,user_id_from INTEGER,user_id_to INTEGER,nick_from TEXT,nick_to TEXT,date TEXT,message TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_preview (user_id_from INTEGER PRIMARY KEY,nick_from TEXT,read TEXT,date TEXT,message TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_ita (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_es (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_eng (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_fr (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_el (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_tr (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_in (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_tag (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_jp (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_pt (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_blk (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_hu (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_ar (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_ro (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_th (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_my (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE chat_public_mod (_id INTEGER PRIMARY KEY,id_db INTEGER,user_code INTEGER,nick TEXT,date TEXT,message TEXT,message_code INTEGER,moderator INTEGER,self INTEGER,sent INTEGER,received INTEGER,error INTEGER,country INTEGER,pro INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE friendship (_id INTEGER PRIMARY KEY,user_id_from INTEGER,user_id_to INTEGER,nick_from TEXT,nick_to TEXT,requested INTEGER,declined INTEGER,friend INTEGER,randcode INTEGER,date TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE ranking (_id INTEGER PRIMARY KEY,nick TEXT,country INTEGER,detected INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE blocked_users (_id INTEGER PRIMARY KEY,nick TEXT,user_code INTEGER)");
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
        onUpgrade(sQLiteDatabase, i8, i9);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i8, int i9) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_allusers");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_preview");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_ita");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_es");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_eng");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_fr");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_el");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_tr");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_in");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_tag");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_jp");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_pt");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_blk");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_hu");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_ar");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_ro");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_th");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_my");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_public_mod");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS friendship");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ranking");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS blocked_users");
        onCreate(sQLiteDatabase);
    }
}
