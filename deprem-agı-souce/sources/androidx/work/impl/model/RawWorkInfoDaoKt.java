package androidx.work.impl.model;

import androidx.sqlite.db.SupportSQLiteQuery;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;
import w3.I;
import z3.C2972e;

public final class RawWorkInfoDaoKt {
    public static final C2972e getWorkInfoPojosFlow(RawWorkInfoDao rawWorkInfoDao, I i5, SupportSQLiteQuery supportSQLiteQuery) {
        t.e(rawWorkInfoDao, "<this>");
        t.e(i5, "dispatcher");
        t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        return WorkSpecDaoKt.dedup(rawWorkInfoDao.getWorkInfoPojosFlow(supportSQLiteQuery), i5);
    }
}
