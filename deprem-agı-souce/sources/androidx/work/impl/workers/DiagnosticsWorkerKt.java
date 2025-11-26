package androidx.work.impl.workers;

import X2.C2250q;
import androidx.work.Logger;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.t;

public final class DiagnosticsWorkerKt {
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("DiagnosticsWrkr");
        t.d(tagWithPrefix, "tagWithPrefix(...)");
        TAG = tagWithPrefix;
    }

    private static final String workSpecRow(WorkSpec workSpec, String str, Integer num, String str2) {
        return 10 + workSpec.id + "\t " + workSpec.workerClassName + "\t " + num + "\t " + workSpec.state.name() + "\t " + str + "\t " + str2 + 9;
    }

    /* access modifiers changed from: private */
    public static final String workSpecRows(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List<WorkSpec> list) {
        Integer num;
        StringBuilder sb = new StringBuilder();
        sb.append("\n Id \t Class Name\t " + "Job Id" + "\t State\t Unique Name\t Tags\t");
        for (WorkSpec workSpec : list) {
            SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(WorkSpecKt.generationalId(workSpec));
            if (systemIdInfo != null) {
                num = Integer.valueOf(systemIdInfo.systemId);
            } else {
                num = null;
            }
            sb.append(workSpecRow(workSpec, C2250q.V(workNameDao.getNamesForWorkSpecId(workSpec.id), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null), num, C2250q.V(workTagDao.getTagsForWorkSpecId(workSpec.id), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null)));
        }
        return sb.toString();
    }
}
