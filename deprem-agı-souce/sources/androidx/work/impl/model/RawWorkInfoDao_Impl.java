package androidx.work.impl.model;

import W2.J;
import X2.C2250q;
import X2.M;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.RoomSQLiteQuery;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.NetworkRequestCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;
import z3.C2972e;

public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    public static final Companion Companion = new Companion((C2633k) null);
    private final RoomDatabase __db;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final List<C2733c> getRequiredConverters() {
            return C2250q.g();
        }

        private Companion() {
        }
    }

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        t.e(roomDatabase, "__db");
        this.__db = roomDatabase;
    }

    private final void __fetchRelationshipWorkProgressAsandroidxWorkData(SQLiteConnection sQLiteConnection, ArrayMap<String, List<Data>> arrayMap) {
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                RelationUtil.recursiveFetchArrayMap(arrayMap, true, new C0435i(this, sQLiteConnection));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            StringUtil.appendPlaceholders(sb, keySet.size());
            sb.append(")");
            String sb2 = sb.toString();
            t.d(sb2, "toString(...)");
            SQLiteStatement prepare = sQLiteConnection.prepare(sb2);
            int i5 = 1;
            for (String bindText : keySet) {
                prepare.bindText(i5, bindText);
                i5++;
            }
            try {
                int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "work_spec_id");
                if (columnIndex != -1) {
                    while (prepare.step()) {
                        List list = arrayMap.get(prepare.getText(columnIndex));
                        if (list != null) {
                            list.add(Data.Companion.fromByteArray(prepare.getBlob(0)));
                        }
                    }
                    prepare.close();
                }
            } finally {
                prepare.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final J __fetchRelationshipWorkProgressAsandroidxWorkData$lambda$4(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        t.e(arrayMap, "_tmpMap");
        rawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection, arrayMap);
        return J.f19942a;
    }

    private final void __fetchRelationshipWorkTagAsjavaLangString(SQLiteConnection sQLiteConnection, ArrayMap<String, List<String>> arrayMap) {
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                RelationUtil.recursiveFetchArrayMap(arrayMap, true, new C0439m(this, sQLiteConnection));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            StringUtil.appendPlaceholders(sb, keySet.size());
            sb.append(")");
            String sb2 = sb.toString();
            t.d(sb2, "toString(...)");
            SQLiteStatement prepare = sQLiteConnection.prepare(sb2);
            int i5 = 1;
            for (String bindText : keySet) {
                prepare.bindText(i5, bindText);
                i5++;
            }
            try {
                int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "work_spec_id");
                if (columnIndex != -1) {
                    while (prepare.step()) {
                        List list = arrayMap.get(prepare.getText(columnIndex));
                        if (list != null) {
                            list.add(prepare.getText(0));
                        }
                    }
                    prepare.close();
                }
            } finally {
                prepare.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final J __fetchRelationshipWorkTagAsjavaLangString$lambda$3(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection, ArrayMap arrayMap) {
        t.e(arrayMap, "_tmpMap");
        rawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection, arrayMap);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final List getWorkInfoPojos$lambda$0(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection) {
        long j5;
        long j6;
        long j7;
        int i5;
        long j8;
        long j9;
        ArrayMap arrayMap;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z4;
        boolean z5;
        int i16;
        int i17;
        boolean z6;
        boolean z7;
        int i18;
        boolean z8;
        boolean z9;
        int i19;
        long j11;
        long j12;
        int i20;
        RawWorkInfoDao_Impl rawWorkInfoDao_Impl2 = rawWorkInfoDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            roomRawQuery.getBindingFunction().invoke(prepare);
            int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "id");
            int columnIndex2 = SQLiteStatementUtil.getColumnIndex(prepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndex3 = SQLiteStatementUtil.getColumnIndex(prepare, "output");
            int columnIndex4 = SQLiteStatementUtil.getColumnIndex(prepare, "initial_delay");
            int columnIndex5 = SQLiteStatementUtil.getColumnIndex(prepare, "interval_duration");
            int columnIndex6 = SQLiteStatementUtil.getColumnIndex(prepare, "flex_duration");
            int columnIndex7 = SQLiteStatementUtil.getColumnIndex(prepare, "run_attempt_count");
            int columnIndex8 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_policy");
            int columnIndex9 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_delay_duration");
            int columnIndex10 = SQLiteStatementUtil.getColumnIndex(prepare, "last_enqueue_time");
            int columnIndex11 = SQLiteStatementUtil.getColumnIndex(prepare, "period_count");
            int columnIndex12 = SQLiteStatementUtil.getColumnIndex(prepare, "generation");
            String str2 = "getValue(...)";
            int columnIndex13 = SQLiteStatementUtil.getColumnIndex(prepare, "next_schedule_time_override");
            int columnIndex14 = SQLiteStatementUtil.getColumnIndex(prepare, "stop_reason");
            int columnIndex15 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_type");
            int columnIndex16 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_request");
            int columnIndex17 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_charging");
            int columnIndex18 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_device_idle");
            int columnIndex19 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_battery_not_low");
            int columnIndex20 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_storage_not_low");
            int columnIndex21 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_content_update_delay");
            int columnIndex22 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_max_content_delay");
            int columnIndex23 = SQLiteStatementUtil.getColumnIndex(prepare, "content_uri_triggers");
            ArrayMap arrayMap2 = new ArrayMap();
            int i21 = columnIndex12;
            ArrayMap arrayMap3 = new ArrayMap();
            while (prepare.step()) {
                int i22 = columnIndex11;
                String text = prepare.getText(columnIndex);
                if (!arrayMap2.containsKey(text)) {
                    i20 = columnIndex10;
                    arrayMap2.put(text, new ArrayList());
                } else {
                    i20 = columnIndex10;
                }
                String text2 = prepare.getText(columnIndex);
                if (!arrayMap3.containsKey(text2)) {
                    arrayMap3.put(text2, new ArrayList());
                }
                columnIndex11 = i22;
                columnIndex10 = i20;
            }
            int i23 = columnIndex10;
            int i24 = columnIndex11;
            prepare.reset();
            rawWorkInfoDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap2);
            rawWorkInfoDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap3);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                if (columnIndex != -1) {
                    String text3 = prepare.getText(columnIndex);
                    if (columnIndex2 != -1) {
                        WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndex2));
                        if (columnIndex3 != -1) {
                            Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(columnIndex3));
                            if (columnIndex4 == -1) {
                                j5 = 0;
                            } else {
                                j5 = prepare.getLong(columnIndex4);
                            }
                            if (columnIndex5 == -1) {
                                j6 = 0;
                            } else {
                                j6 = prepare.getLong(columnIndex5);
                            }
                            if (columnIndex6 == -1) {
                                j7 = 0;
                            } else {
                                j7 = prepare.getLong(columnIndex6);
                            }
                            boolean z10 = false;
                            if (columnIndex7 == -1) {
                                i5 = 0;
                            } else {
                                i5 = (int) prepare.getLong(columnIndex7);
                            }
                            if (columnIndex8 != -1) {
                                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndex8));
                                if (columnIndex9 == -1) {
                                    j8 = 0;
                                } else {
                                    j8 = prepare.getLong(columnIndex9);
                                }
                                int i25 = i23;
                                if (i25 == -1) {
                                    j9 = 0;
                                } else {
                                    j9 = prepare.getLong(i25);
                                }
                                int i26 = i24;
                                if (i26 == -1) {
                                    arrayMap = arrayMap2;
                                    i6 = 0;
                                    i7 = -1;
                                } else {
                                    arrayMap = arrayMap2;
                                    i6 = (int) prepare.getLong(i26);
                                    i7 = -1;
                                }
                                int i27 = i21;
                                if (i27 == i7) {
                                    i8 = columnIndex2;
                                    i9 = columnIndex3;
                                    i10 = 0;
                                } else {
                                    i8 = columnIndex2;
                                    i9 = columnIndex3;
                                    i10 = (int) prepare.getLong(i27);
                                }
                                int i28 = columnIndex13;
                                if (i28 == i7) {
                                    j10 = 0;
                                } else {
                                    j10 = prepare.getLong(i28);
                                }
                                int i29 = columnIndex14;
                                if (i29 == i7) {
                                    i11 = columnIndex4;
                                    i12 = columnIndex5;
                                    i13 = 0;
                                } else {
                                    i11 = columnIndex4;
                                    i12 = columnIndex5;
                                    i13 = (int) prepare.getLong(i29);
                                }
                                int i30 = columnIndex15;
                                if (i30 != i7) {
                                    int i31 = i28;
                                    int i32 = i29;
                                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i30));
                                    int i33 = columnIndex16;
                                    if (i33 != i7) {
                                        NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i33));
                                        int i34 = columnIndex17;
                                        if (i34 == i7) {
                                            i14 = i30;
                                            i15 = i31;
                                            z5 = false;
                                        } else {
                                            i14 = i30;
                                            i15 = i31;
                                            if (((int) prepare.getLong(i34)) != 0) {
                                                z4 = true;
                                            } else {
                                                z4 = false;
                                            }
                                            z5 = z4;
                                        }
                                        int i35 = columnIndex18;
                                        if (i35 == i7) {
                                            i16 = i33;
                                            i17 = i34;
                                            z7 = false;
                                        } else {
                                            i16 = i33;
                                            i17 = i34;
                                            if (((int) prepare.getLong(i35)) != 0) {
                                                z6 = true;
                                            } else {
                                                z6 = false;
                                            }
                                            z7 = z6;
                                        }
                                        int i36 = columnIndex19;
                                        if (i36 == i7) {
                                            i18 = i35;
                                            z9 = false;
                                        } else {
                                            i18 = i35;
                                            if (((int) prepare.getLong(i36)) != 0) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            z9 = z8;
                                        }
                                        int i37 = columnIndex20;
                                        if (i37 == i7) {
                                            i19 = i16;
                                        } else {
                                            i19 = i16;
                                            if (((int) prepare.getLong(i37)) != 0) {
                                                z10 = true;
                                            }
                                        }
                                        int i38 = columnIndex21;
                                        boolean z11 = z10;
                                        if (i38 == i7) {
                                            j11 = 0;
                                        } else {
                                            j11 = prepare.getLong(i38);
                                        }
                                        int i39 = columnIndex22;
                                        if (i39 == i7) {
                                            j12 = 0;
                                        } else {
                                            j12 = prepare.getLong(i39);
                                        }
                                        int i40 = i27;
                                        int i41 = columnIndex23;
                                        if (i41 != i7) {
                                            Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z5, z7, z9, z11, j11, j12, WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i41)));
                                            columnIndex23 = i41;
                                            ArrayMap arrayMap4 = arrayMap;
                                            Object i42 = M.i(arrayMap4, prepare.getText(columnIndex));
                                            ArrayMap arrayMap5 = arrayMap4;
                                            String str3 = str2;
                                            t.d(i42, str3);
                                            List list = (List) i42;
                                            Object i43 = M.i(arrayMap3, prepare.getText(columnIndex));
                                            t.d(i43, str3);
                                            arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints, i5, intToBackoffPolicy, j8, j9, i6, i10, j10, i13, list, (List) i43));
                                            str2 = str3;
                                            columnIndex21 = i38;
                                            columnIndex22 = i39;
                                            arrayMap2 = arrayMap5;
                                            columnIndex4 = i11;
                                            columnIndex5 = i12;
                                            i24 = i26;
                                            columnIndex14 = i32;
                                            columnIndex15 = i14;
                                            columnIndex17 = i17;
                                            columnIndex18 = i18;
                                            columnIndex13 = i15;
                                            columnIndex19 = i36;
                                            columnIndex2 = i8;
                                            i21 = i40;
                                            columnIndex16 = i19;
                                            columnIndex20 = i37;
                                            columnIndex3 = i9;
                                            i23 = i25;
                                        } else {
                                            throw new IllegalStateException("Missing value for a NON-NULL column 'content_uri_triggers', found NULL value instead.");
                                        }
                                    } else {
                                        throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_request', found NULL value instead.");
                                    }
                                } else {
                                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_type', found NULL value instead.");
                                }
                            } else {
                                throw new IllegalStateException("Missing value for a NON-NULL column 'backoff_policy', found NULL value instead.");
                            }
                        } else {
                            throw new IllegalStateException("Missing value for a NON-NULL column 'output', found NULL value instead.");
                        }
                    } else {
                        throw new IllegalStateException("Missing value for a NON-NULL column 'state', found NULL value instead.");
                    }
                } else {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'id', found NULL value instead.");
                }
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkInfoPojosFlow$lambda$2(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection) {
        long j5;
        long j6;
        long j7;
        int i5;
        long j8;
        long j9;
        ArrayMap arrayMap;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z4;
        boolean z5;
        int i16;
        int i17;
        boolean z6;
        boolean z7;
        int i18;
        boolean z8;
        boolean z9;
        int i19;
        long j11;
        long j12;
        int i20;
        RawWorkInfoDao_Impl rawWorkInfoDao_Impl2 = rawWorkInfoDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            roomRawQuery.getBindingFunction().invoke(prepare);
            int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "id");
            int columnIndex2 = SQLiteStatementUtil.getColumnIndex(prepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndex3 = SQLiteStatementUtil.getColumnIndex(prepare, "output");
            int columnIndex4 = SQLiteStatementUtil.getColumnIndex(prepare, "initial_delay");
            int columnIndex5 = SQLiteStatementUtil.getColumnIndex(prepare, "interval_duration");
            int columnIndex6 = SQLiteStatementUtil.getColumnIndex(prepare, "flex_duration");
            int columnIndex7 = SQLiteStatementUtil.getColumnIndex(prepare, "run_attempt_count");
            int columnIndex8 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_policy");
            int columnIndex9 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_delay_duration");
            int columnIndex10 = SQLiteStatementUtil.getColumnIndex(prepare, "last_enqueue_time");
            int columnIndex11 = SQLiteStatementUtil.getColumnIndex(prepare, "period_count");
            int columnIndex12 = SQLiteStatementUtil.getColumnIndex(prepare, "generation");
            String str2 = "getValue(...)";
            int columnIndex13 = SQLiteStatementUtil.getColumnIndex(prepare, "next_schedule_time_override");
            int columnIndex14 = SQLiteStatementUtil.getColumnIndex(prepare, "stop_reason");
            int columnIndex15 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_type");
            int columnIndex16 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_request");
            int columnIndex17 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_charging");
            int columnIndex18 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_device_idle");
            int columnIndex19 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_battery_not_low");
            int columnIndex20 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_storage_not_low");
            int columnIndex21 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_content_update_delay");
            int columnIndex22 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_max_content_delay");
            int columnIndex23 = SQLiteStatementUtil.getColumnIndex(prepare, "content_uri_triggers");
            ArrayMap arrayMap2 = new ArrayMap();
            int i21 = columnIndex12;
            ArrayMap arrayMap3 = new ArrayMap();
            while (prepare.step()) {
                int i22 = columnIndex11;
                String text = prepare.getText(columnIndex);
                if (!arrayMap2.containsKey(text)) {
                    i20 = columnIndex10;
                    arrayMap2.put(text, new ArrayList());
                } else {
                    i20 = columnIndex10;
                }
                String text2 = prepare.getText(columnIndex);
                if (!arrayMap3.containsKey(text2)) {
                    arrayMap3.put(text2, new ArrayList());
                }
                columnIndex11 = i22;
                columnIndex10 = i20;
            }
            int i23 = columnIndex10;
            int i24 = columnIndex11;
            prepare.reset();
            rawWorkInfoDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap2);
            rawWorkInfoDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap3);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                if (columnIndex != -1) {
                    String text3 = prepare.getText(columnIndex);
                    if (columnIndex2 != -1) {
                        WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndex2));
                        if (columnIndex3 != -1) {
                            Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(columnIndex3));
                            if (columnIndex4 == -1) {
                                j5 = 0;
                            } else {
                                j5 = prepare.getLong(columnIndex4);
                            }
                            if (columnIndex5 == -1) {
                                j6 = 0;
                            } else {
                                j6 = prepare.getLong(columnIndex5);
                            }
                            if (columnIndex6 == -1) {
                                j7 = 0;
                            } else {
                                j7 = prepare.getLong(columnIndex6);
                            }
                            boolean z10 = false;
                            if (columnIndex7 == -1) {
                                i5 = 0;
                            } else {
                                i5 = (int) prepare.getLong(columnIndex7);
                            }
                            if (columnIndex8 != -1) {
                                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndex8));
                                if (columnIndex9 == -1) {
                                    j8 = 0;
                                } else {
                                    j8 = prepare.getLong(columnIndex9);
                                }
                                int i25 = i23;
                                if (i25 == -1) {
                                    j9 = 0;
                                } else {
                                    j9 = prepare.getLong(i25);
                                }
                                int i26 = i24;
                                if (i26 == -1) {
                                    arrayMap = arrayMap2;
                                    i6 = 0;
                                    i7 = -1;
                                } else {
                                    arrayMap = arrayMap2;
                                    i6 = (int) prepare.getLong(i26);
                                    i7 = -1;
                                }
                                int i27 = i21;
                                if (i27 == i7) {
                                    i8 = columnIndex2;
                                    i9 = columnIndex3;
                                    i10 = 0;
                                } else {
                                    i8 = columnIndex2;
                                    i9 = columnIndex3;
                                    i10 = (int) prepare.getLong(i27);
                                }
                                int i28 = columnIndex13;
                                if (i28 == i7) {
                                    j10 = 0;
                                } else {
                                    j10 = prepare.getLong(i28);
                                }
                                int i29 = columnIndex14;
                                if (i29 == i7) {
                                    i11 = columnIndex4;
                                    i12 = columnIndex5;
                                    i13 = 0;
                                } else {
                                    i11 = columnIndex4;
                                    i12 = columnIndex5;
                                    i13 = (int) prepare.getLong(i29);
                                }
                                int i30 = columnIndex15;
                                if (i30 != i7) {
                                    int i31 = i28;
                                    int i32 = i29;
                                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i30));
                                    int i33 = columnIndex16;
                                    if (i33 != i7) {
                                        NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i33));
                                        int i34 = columnIndex17;
                                        if (i34 == i7) {
                                            i14 = i30;
                                            i15 = i31;
                                            z5 = false;
                                        } else {
                                            i14 = i30;
                                            i15 = i31;
                                            if (((int) prepare.getLong(i34)) != 0) {
                                                z4 = true;
                                            } else {
                                                z4 = false;
                                            }
                                            z5 = z4;
                                        }
                                        int i35 = columnIndex18;
                                        if (i35 == i7) {
                                            i16 = i33;
                                            i17 = i34;
                                            z7 = false;
                                        } else {
                                            i16 = i33;
                                            i17 = i34;
                                            if (((int) prepare.getLong(i35)) != 0) {
                                                z6 = true;
                                            } else {
                                                z6 = false;
                                            }
                                            z7 = z6;
                                        }
                                        int i36 = columnIndex19;
                                        if (i36 == i7) {
                                            i18 = i35;
                                            z9 = false;
                                        } else {
                                            i18 = i35;
                                            if (((int) prepare.getLong(i36)) != 0) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            z9 = z8;
                                        }
                                        int i37 = columnIndex20;
                                        if (i37 == i7) {
                                            i19 = i16;
                                        } else {
                                            i19 = i16;
                                            if (((int) prepare.getLong(i37)) != 0) {
                                                z10 = true;
                                            }
                                        }
                                        int i38 = columnIndex21;
                                        boolean z11 = z10;
                                        if (i38 == i7) {
                                            j11 = 0;
                                        } else {
                                            j11 = prepare.getLong(i38);
                                        }
                                        int i39 = columnIndex22;
                                        if (i39 == i7) {
                                            j12 = 0;
                                        } else {
                                            j12 = prepare.getLong(i39);
                                        }
                                        int i40 = i27;
                                        int i41 = columnIndex23;
                                        if (i41 != i7) {
                                            Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z5, z7, z9, z11, j11, j12, WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i41)));
                                            columnIndex23 = i41;
                                            ArrayMap arrayMap4 = arrayMap;
                                            Object i42 = M.i(arrayMap4, prepare.getText(columnIndex));
                                            ArrayMap arrayMap5 = arrayMap4;
                                            String str3 = str2;
                                            t.d(i42, str3);
                                            List list = (List) i42;
                                            Object i43 = M.i(arrayMap3, prepare.getText(columnIndex));
                                            t.d(i43, str3);
                                            arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints, i5, intToBackoffPolicy, j8, j9, i6, i10, j10, i13, list, (List) i43));
                                            str2 = str3;
                                            columnIndex21 = i38;
                                            columnIndex22 = i39;
                                            arrayMap2 = arrayMap5;
                                            columnIndex4 = i11;
                                            columnIndex5 = i12;
                                            i24 = i26;
                                            columnIndex14 = i32;
                                            columnIndex15 = i14;
                                            columnIndex17 = i17;
                                            columnIndex18 = i18;
                                            columnIndex13 = i15;
                                            columnIndex19 = i36;
                                            columnIndex2 = i8;
                                            i21 = i40;
                                            columnIndex16 = i19;
                                            columnIndex20 = i37;
                                            columnIndex3 = i9;
                                            i23 = i25;
                                        } else {
                                            throw new IllegalStateException("Missing value for a NON-NULL column 'content_uri_triggers', found NULL value instead.");
                                        }
                                    } else {
                                        throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_request', found NULL value instead.");
                                    }
                                } else {
                                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_type', found NULL value instead.");
                                }
                            } else {
                                throw new IllegalStateException("Missing value for a NON-NULL column 'backoff_policy', found NULL value instead.");
                            }
                        } else {
                            throw new IllegalStateException("Missing value for a NON-NULL column 'output', found NULL value instead.");
                        }
                    } else {
                        throw new IllegalStateException("Missing value for a NON-NULL column 'state', found NULL value instead.");
                    }
                } else {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'id', found NULL value instead.");
                }
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static final List getWorkInfoPojosLiveData$lambda$1(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection) {
        long j5;
        long j6;
        long j7;
        int i5;
        long j8;
        long j9;
        ArrayMap arrayMap;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z4;
        boolean z5;
        int i16;
        int i17;
        boolean z6;
        boolean z7;
        int i18;
        boolean z8;
        boolean z9;
        int i19;
        long j11;
        long j12;
        int i20;
        RawWorkInfoDao_Impl rawWorkInfoDao_Impl2 = rawWorkInfoDao_Impl;
        SQLiteConnection sQLiteConnection2 = sQLiteConnection;
        t.e(sQLiteConnection2, "_connection");
        SQLiteStatement prepare = sQLiteConnection2.prepare(str);
        try {
            roomRawQuery.getBindingFunction().invoke(prepare);
            int columnIndex = SQLiteStatementUtil.getColumnIndex(prepare, "id");
            int columnIndex2 = SQLiteStatementUtil.getColumnIndex(prepare, MRAIDCommunicatorUtil.KEY_STATE);
            int columnIndex3 = SQLiteStatementUtil.getColumnIndex(prepare, "output");
            int columnIndex4 = SQLiteStatementUtil.getColumnIndex(prepare, "initial_delay");
            int columnIndex5 = SQLiteStatementUtil.getColumnIndex(prepare, "interval_duration");
            int columnIndex6 = SQLiteStatementUtil.getColumnIndex(prepare, "flex_duration");
            int columnIndex7 = SQLiteStatementUtil.getColumnIndex(prepare, "run_attempt_count");
            int columnIndex8 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_policy");
            int columnIndex9 = SQLiteStatementUtil.getColumnIndex(prepare, "backoff_delay_duration");
            int columnIndex10 = SQLiteStatementUtil.getColumnIndex(prepare, "last_enqueue_time");
            int columnIndex11 = SQLiteStatementUtil.getColumnIndex(prepare, "period_count");
            int columnIndex12 = SQLiteStatementUtil.getColumnIndex(prepare, "generation");
            String str2 = "getValue(...)";
            int columnIndex13 = SQLiteStatementUtil.getColumnIndex(prepare, "next_schedule_time_override");
            int columnIndex14 = SQLiteStatementUtil.getColumnIndex(prepare, "stop_reason");
            int columnIndex15 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_type");
            int columnIndex16 = SQLiteStatementUtil.getColumnIndex(prepare, "required_network_request");
            int columnIndex17 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_charging");
            int columnIndex18 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_device_idle");
            int columnIndex19 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_battery_not_low");
            int columnIndex20 = SQLiteStatementUtil.getColumnIndex(prepare, "requires_storage_not_low");
            int columnIndex21 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_content_update_delay");
            int columnIndex22 = SQLiteStatementUtil.getColumnIndex(prepare, "trigger_max_content_delay");
            int columnIndex23 = SQLiteStatementUtil.getColumnIndex(prepare, "content_uri_triggers");
            ArrayMap arrayMap2 = new ArrayMap();
            int i21 = columnIndex12;
            ArrayMap arrayMap3 = new ArrayMap();
            while (prepare.step()) {
                int i22 = columnIndex11;
                String text = prepare.getText(columnIndex);
                if (!arrayMap2.containsKey(text)) {
                    i20 = columnIndex10;
                    arrayMap2.put(text, new ArrayList());
                } else {
                    i20 = columnIndex10;
                }
                String text2 = prepare.getText(columnIndex);
                if (!arrayMap3.containsKey(text2)) {
                    arrayMap3.put(text2, new ArrayList());
                }
                columnIndex11 = i22;
                columnIndex10 = i20;
            }
            int i23 = columnIndex10;
            int i24 = columnIndex11;
            prepare.reset();
            rawWorkInfoDao_Impl2.__fetchRelationshipWorkTagAsjavaLangString(sQLiteConnection2, arrayMap2);
            rawWorkInfoDao_Impl2.__fetchRelationshipWorkProgressAsandroidxWorkData(sQLiteConnection2, arrayMap3);
            ArrayList arrayList = new ArrayList();
            while (prepare.step()) {
                if (columnIndex != -1) {
                    String text3 = prepare.getText(columnIndex);
                    if (columnIndex2 != -1) {
                        WorkInfo.State intToState = WorkTypeConverters.intToState((int) prepare.getLong(columnIndex2));
                        if (columnIndex3 != -1) {
                            Data fromByteArray = Data.Companion.fromByteArray(prepare.getBlob(columnIndex3));
                            if (columnIndex4 == -1) {
                                j5 = 0;
                            } else {
                                j5 = prepare.getLong(columnIndex4);
                            }
                            if (columnIndex5 == -1) {
                                j6 = 0;
                            } else {
                                j6 = prepare.getLong(columnIndex5);
                            }
                            if (columnIndex6 == -1) {
                                j7 = 0;
                            } else {
                                j7 = prepare.getLong(columnIndex6);
                            }
                            boolean z10 = false;
                            if (columnIndex7 == -1) {
                                i5 = 0;
                            } else {
                                i5 = (int) prepare.getLong(columnIndex7);
                            }
                            if (columnIndex8 != -1) {
                                BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy((int) prepare.getLong(columnIndex8));
                                if (columnIndex9 == -1) {
                                    j8 = 0;
                                } else {
                                    j8 = prepare.getLong(columnIndex9);
                                }
                                int i25 = i23;
                                if (i25 == -1) {
                                    j9 = 0;
                                } else {
                                    j9 = prepare.getLong(i25);
                                }
                                int i26 = i24;
                                if (i26 == -1) {
                                    arrayMap = arrayMap2;
                                    i6 = 0;
                                    i7 = -1;
                                } else {
                                    arrayMap = arrayMap2;
                                    i6 = (int) prepare.getLong(i26);
                                    i7 = -1;
                                }
                                int i27 = i21;
                                if (i27 == i7) {
                                    i8 = columnIndex2;
                                    i9 = columnIndex3;
                                    i10 = 0;
                                } else {
                                    i8 = columnIndex2;
                                    i9 = columnIndex3;
                                    i10 = (int) prepare.getLong(i27);
                                }
                                int i28 = columnIndex13;
                                if (i28 == i7) {
                                    j10 = 0;
                                } else {
                                    j10 = prepare.getLong(i28);
                                }
                                int i29 = columnIndex14;
                                if (i29 == i7) {
                                    i11 = columnIndex4;
                                    i12 = columnIndex5;
                                    i13 = 0;
                                } else {
                                    i11 = columnIndex4;
                                    i12 = columnIndex5;
                                    i13 = (int) prepare.getLong(i29);
                                }
                                int i30 = columnIndex15;
                                if (i30 != i7) {
                                    int i31 = i28;
                                    int i32 = i29;
                                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType((int) prepare.getLong(i30));
                                    int i33 = columnIndex16;
                                    if (i33 != i7) {
                                        NetworkRequestCompat networkRequest$work_runtime_release = WorkTypeConverters.toNetworkRequest$work_runtime_release(prepare.getBlob(i33));
                                        int i34 = columnIndex17;
                                        if (i34 == i7) {
                                            i14 = i30;
                                            i15 = i31;
                                            z5 = false;
                                        } else {
                                            i14 = i30;
                                            i15 = i31;
                                            if (((int) prepare.getLong(i34)) != 0) {
                                                z4 = true;
                                            } else {
                                                z4 = false;
                                            }
                                            z5 = z4;
                                        }
                                        int i35 = columnIndex18;
                                        if (i35 == i7) {
                                            i16 = i33;
                                            i17 = i34;
                                            z7 = false;
                                        } else {
                                            i16 = i33;
                                            i17 = i34;
                                            if (((int) prepare.getLong(i35)) != 0) {
                                                z6 = true;
                                            } else {
                                                z6 = false;
                                            }
                                            z7 = z6;
                                        }
                                        int i36 = columnIndex19;
                                        if (i36 == i7) {
                                            i18 = i35;
                                            z9 = false;
                                        } else {
                                            i18 = i35;
                                            if (((int) prepare.getLong(i36)) != 0) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            z9 = z8;
                                        }
                                        int i37 = columnIndex20;
                                        if (i37 == i7) {
                                            i19 = i16;
                                        } else {
                                            i19 = i16;
                                            if (((int) prepare.getLong(i37)) != 0) {
                                                z10 = true;
                                            }
                                        }
                                        int i38 = columnIndex21;
                                        boolean z11 = z10;
                                        if (i38 == i7) {
                                            j11 = 0;
                                        } else {
                                            j11 = prepare.getLong(i38);
                                        }
                                        int i39 = columnIndex22;
                                        if (i39 == i7) {
                                            j12 = 0;
                                        } else {
                                            j12 = prepare.getLong(i39);
                                        }
                                        int i40 = i27;
                                        int i41 = columnIndex23;
                                        if (i41 != i7) {
                                            Constraints constraints = new Constraints(networkRequest$work_runtime_release, intToNetworkType, z5, z7, z9, z11, j11, j12, WorkTypeConverters.byteArrayToSetOfTriggers(prepare.getBlob(i41)));
                                            columnIndex23 = i41;
                                            ArrayMap arrayMap4 = arrayMap;
                                            Object i42 = M.i(arrayMap4, prepare.getText(columnIndex));
                                            ArrayMap arrayMap5 = arrayMap4;
                                            String str3 = str2;
                                            t.d(i42, str3);
                                            List list = (List) i42;
                                            Object i43 = M.i(arrayMap3, prepare.getText(columnIndex));
                                            t.d(i43, str3);
                                            arrayList.add(new WorkSpec.WorkInfoPojo(text3, intToState, fromByteArray, j5, j6, j7, constraints, i5, intToBackoffPolicy, j8, j9, i6, i10, j10, i13, list, (List) i43));
                                            str2 = str3;
                                            columnIndex21 = i38;
                                            columnIndex22 = i39;
                                            arrayMap2 = arrayMap5;
                                            columnIndex4 = i11;
                                            columnIndex5 = i12;
                                            i24 = i26;
                                            columnIndex14 = i32;
                                            columnIndex15 = i14;
                                            columnIndex17 = i17;
                                            columnIndex18 = i18;
                                            columnIndex13 = i15;
                                            columnIndex19 = i36;
                                            columnIndex2 = i8;
                                            i21 = i40;
                                            columnIndex16 = i19;
                                            columnIndex20 = i37;
                                            columnIndex3 = i9;
                                            i23 = i25;
                                        } else {
                                            throw new IllegalStateException("Missing value for a NON-NULL column 'content_uri_triggers', found NULL value instead.");
                                        }
                                    } else {
                                        throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_request', found NULL value instead.");
                                    }
                                } else {
                                    throw new IllegalStateException("Missing value for a NON-NULL column 'required_network_type', found NULL value instead.");
                                }
                            } else {
                                throw new IllegalStateException("Missing value for a NON-NULL column 'backoff_policy', found NULL value instead.");
                            }
                        } else {
                            throw new IllegalStateException("Missing value for a NON-NULL column 'output', found NULL value instead.");
                        }
                    } else {
                        throw new IllegalStateException("Missing value for a NON-NULL column 'state', found NULL value instead.");
                    }
                } else {
                    throw new IllegalStateException("Missing value for a NON-NULL column 'id', found NULL value instead.");
                }
            }
            prepare.close();
            return arrayList;
        } catch (Throwable th) {
            prepare.close();
            throw th;
        }
    }

    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery supportSQLiteQuery) {
        t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        RoomRawQuery roomRawQuery = RoomSQLiteQuery.Companion.copyFrom(supportSQLiteQuery).toRoomRawQuery();
        return (List) DBUtil.performBlocking(this.__db, true, false, new C0436j(roomRawQuery.getSql(), roomRawQuery, this));
    }

    public C2972e getWorkInfoPojosFlow(SupportSQLiteQuery supportSQLiteQuery) {
        t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        RoomRawQuery roomRawQuery = RoomSQLiteQuery.Companion.copyFrom(supportSQLiteQuery).toRoomRawQuery();
        return FlowUtil.createFlow(this.__db, false, new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, new C0437k(roomRawQuery.getSql(), roomRawQuery, this));
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(SupportSQLiteQuery supportSQLiteQuery) {
        t.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        RoomRawQuery roomRawQuery = RoomSQLiteQuery.Companion.copyFrom(supportSQLiteQuery).toRoomRawQuery();
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, (l) new C0438l(roomRawQuery.getSql(), roomRawQuery, this));
    }
}
