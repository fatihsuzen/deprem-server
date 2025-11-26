package androidx.work.impl.utils;

import X2.C2250q;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.ArrayList;
import java.util.UUID;
import k3.l;
import kotlin.jvm.internal.t;

public final class RawQueries {
    private static final void bindings(StringBuilder sb, int i5) {
        if (i5 > 0) {
            ArrayList arrayList = new ArrayList(i5);
            for (int i6 = 0; i6 < i5; i6++) {
                arrayList.add("?");
            }
            sb.append(C2250q.V(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null));
        }
    }

    public static final SupportSQLiteQuery toRawQuery(WorkQuery workQuery) {
        t.e(workQuery, "<this>");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("SELECT * FROM workspec");
        String str = " AND";
        String str2 = " WHERE";
        if (!workQuery.getStates().isEmpty()) {
            Iterable<WorkInfo.State> states = workQuery.getStates();
            ArrayList arrayList2 = new ArrayList(C2250q.p(states, 10));
            for (WorkInfo.State stateToInt : states) {
                arrayList2.add(Integer.valueOf(WorkTypeConverters.stateToInt(stateToInt)));
            }
            sb.append(str2 + " state IN (");
            bindings(sb, arrayList2.size());
            sb.append(")");
            arrayList.addAll(arrayList2);
            str2 = str;
        }
        if (!workQuery.getIds().isEmpty()) {
            Iterable<UUID> ids = workQuery.getIds();
            ArrayList arrayList3 = new ArrayList(C2250q.p(ids, 10));
            for (UUID uuid : ids) {
                arrayList3.add(uuid.toString());
            }
            sb.append(str2 + " id IN (");
            bindings(sb, workQuery.getIds().size());
            sb.append(")");
            arrayList.addAll(arrayList3);
            str2 = str;
        }
        if (!workQuery.getTags().isEmpty()) {
            sb.append(str2 + " id IN (SELECT work_spec_id FROM worktag WHERE tag IN (");
            bindings(sb, workQuery.getTags().size());
            sb.append("))");
            arrayList.addAll(workQuery.getTags());
        } else {
            str = str2;
        }
        if (!workQuery.getUniqueWorkNames().isEmpty()) {
            sb.append(str + " id IN (SELECT work_spec_id FROM workname WHERE name IN (");
            bindings(sb, workQuery.getUniqueWorkNames().size());
            sb.append("))");
            arrayList.addAll(workQuery.getUniqueWorkNames());
        }
        sb.append(";");
        String sb2 = sb.toString();
        t.d(sb2, "toString(...)");
        return new SimpleSQLiteQuery(sb2, arrayList.toArray(new Object[0]));
    }
}
