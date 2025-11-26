package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.utils.ProcessUtils;
import b3.C2308e;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.t;
import w3.M;
import z3.C2974g;

public final class UnfinishedWorkListenerKt {
    private static final int DELAY_MS = 30000;
    /* access modifiers changed from: private */
    public static final long MAX_DELAY_MS = TimeUnit.HOURS.toMillis(1);
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("UnfinishedWorkListener");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    public static final void maybeLaunchUnfinishedWorkListener(M m5, Context context, Configuration configuration, WorkDatabase workDatabase) {
        t.e(m5, "<this>");
        t.e(context, "appContext");
        t.e(configuration, "configuration");
        t.e(workDatabase, "db");
        if (ProcessUtils.isDefaultProcess(context, configuration)) {
            C2974g.s(C2974g.w(C2974g.j(C2974g.i(C2974g.y(workDatabase.workSpecDao().hasUnfinishedWorkFlow(), new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$1((C2308e) null)))), new UnfinishedWorkListenerKt$maybeLaunchUnfinishedWorkListener$2(context, (C2308e) null)), m5);
        }
    }
}
