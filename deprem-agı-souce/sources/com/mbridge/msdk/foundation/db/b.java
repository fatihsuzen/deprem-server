package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.d;
import com.mbridge.msdk.foundation.tools.af;
import java.util.ArrayList;
import java.util.List;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f8946a;

    private b(f fVar) {
        super(fVar);
    }

    public static b a(Context context) {
        if (f8946a == null) {
            synchronized (b.class) {
                try {
                    if (f8946a == null) {
                        f8946a = new b(g.a(context));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8946a;
    }

    public final int b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || getWritableDatabase() == null) {
            return 0;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_replace", 1);
            return getWritableDatabase().update("bid_replace_campaign", contentValues, "bid_unit_id" + " = ? AND " + "expect_bid_token" + " = ?", new String[]{str2, str});
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public final void a(String str, List<CampaignEx> list) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
            try {
                String requestId = list.get(0).getRequestId();
                String encryptPrice = list.get(0).getEncryptPrice();
                String campaignUnitId = list.get(0).getCampaignUnitId();
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("bid_unit_id", campaignUnitId);
                    contentValues.put("expect_bid_token", str);
                    contentValues.put("expect_encrypt_price", "");
                    contentValues.put("real_request_id", requestId);
                    contentValues.put("real_encrypt_price", encryptPrice);
                    contentValues.put("real_token_rule", 1);
                    contentValues.put("is_replace", 0);
                    writableDatabase.insert("bid_replace_campaign", (String) null, contentValues);
                    af.b("HBOPTIMIZE", "插入数据到对应关系表 期望 bidToken 值" + str + "+ 用于替换期望Offer 的RequestId " + requestId);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final List<d> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Cursor cursor = null;
            try {
                synchronized (new Object()) {
                    cursor = getReadableDatabase().rawQuery("SELECT * FROM bid_replace_campaign WHERE " + "bid_unit_id" + " = ? AND " + "real_request_id" + " = ?", new String[]{str, str2});
                }
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        while (cursor.moveToNext()) {
                            d dVar = new d();
                            String string = cursor.getString(cursor.getColumnIndex("bid_unit_id"));
                            String string2 = cursor.getString(cursor.getColumnIndex("expect_bid_token"));
                            String string3 = cursor.getString(cursor.getColumnIndex("expect_encrypt_price"));
                            String string4 = cursor.getString(cursor.getColumnIndex("real_request_id"));
                            String string5 = cursor.getString(cursor.getColumnIndex("real_encrypt_price"));
                            int i5 = cursor.getInt(cursor.getColumnIndex("real_token_rule"));
                            int i6 = cursor.getInt(cursor.getColumnIndex("is_replace"));
                            dVar.a(string);
                            dVar.b(string2);
                            dVar.c(string3);
                            dVar.e(string4);
                            dVar.d(string5);
                            dVar.b(i5);
                            dVar.a(i6);
                            arrayList.add(dVar);
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return arrayList;
                }
            } catch (Exception e5) {
                af.b("BidReplaceCampaignDao", e5.getLocalizedMessage());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return arrayList;
    }

    public final int a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            return writableDatabase.delete("bid_replace_campaign", "is_replace = 0", (String[]) null);
        } catch (Exception e5) {
            af.b("BidReplaceCampaignDao", e5.getLocalizedMessage());
            return 0;
        }
    }

    public final int a(String str) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            return writableDatabase.delete("bid_replace_campaign", "real_request_id = ? AND is_replace = 1", new String[]{str});
        } catch (Exception e5) {
            af.b("BidReplaceCampaignDao", e5.getLocalizedMessage());
            return 0;
        }
    }

    public final int a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || getWritableDatabase() == null) {
            return 0;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("expect_encrypt_price", str3);
            return getWritableDatabase().update("bid_replace_campaign", contentValues, "bid_unit_id" + " = ? AND " + "expect_bid_token" + " = ?", new String[]{str2, str});
        } catch (Exception e5) {
            e5.printStackTrace();
            return 0;
        }
    }
}
