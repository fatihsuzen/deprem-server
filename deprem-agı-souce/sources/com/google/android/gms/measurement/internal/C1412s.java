package com.google.android.gms.measurement.internal;

import N.C0722p;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.internal.measurement.N2;
import com.google.android.gms.internal.measurement.O2;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import j$.util.Objects;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.s  reason: case insensitive filesystem */
public final class C1412s {

    /* renamed from: a  reason: collision with root package name */
    private final String f6699a;

    /* renamed from: b  reason: collision with root package name */
    private long f6700b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C1426u f6701c;

    public C1412s(C1426u uVar, String str) {
        Objects.requireNonNull(uVar);
        this.f6701c = uVar;
        C0722p.e(str);
        this.f6699a = str;
        this.f6700b = -1;
    }

    public final List a() {
        List arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.f6701c.u0().query("raw_events", new String[]{"rowid", RewardPlus.NAME, CampaignEx.JSON_KEY_TIMESTAMP, "metadata_fingerprint", DataSchemeDataSource.SCHEME_DATA, "realtime"}, "app_id = ? and rowid > ?", new String[]{this.f6699a, String.valueOf(this.f6700b)}, (String) null, (String) null, "rowid", "1000");
            if (cursor.moveToFirst()) {
                do {
                    boolean z4 = false;
                    long j5 = cursor.getLong(0);
                    long j6 = cursor.getLong(3);
                    if (cursor.getLong(5) == 1) {
                        z4 = true;
                    }
                    byte[] blob = cursor.getBlob(4);
                    if (j5 > this.f6700b) {
                        this.f6700b = j5;
                    }
                    try {
                        N2 n22 = (N2) u6.W(O2.P(), blob);
                        String string = cursor.getString(1);
                        if (string == null) {
                            string = "";
                        }
                        n22.E(string);
                        n22.H(cursor.getLong(2));
                        arrayList.add(new r(j5, j6, z4, (O2) n22.o()));
                    } catch (IOException e5) {
                        this.f6701c.f5730a.a().o().c("Data loss. Failed to merge raw event. appId", C1402q2.x(this.f6699a), e5);
                    }
                } while (cursor.moveToNext());
            } else {
                arrayList = Collections.EMPTY_LIST;
            }
        } catch (SQLiteException e6) {
            this.f6701c.f5730a.a().o().c("Data loss. Error querying raw events batch. appId", C1402q2.x(this.f6699a), e6);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }

    public C1412s(C1426u uVar, String str, long j5) {
        Objects.requireNonNull(uVar);
        this.f6701c = uVar;
        C0722p.e(str);
        this.f6699a = str;
        this.f6700b = uVar.b0("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j5)}, -1);
    }
}
