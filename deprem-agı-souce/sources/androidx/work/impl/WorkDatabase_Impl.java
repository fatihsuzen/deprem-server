package androidx.work.impl;

import W2.C2223l;
import W2.m;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.RawWorkInfoDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class WorkDatabase_Impl extends WorkDatabase {
    private final C2223l _dependencyDao = m.b(new j(this));
    private final C2223l _preferenceDao = m.b(new o(this));
    private final C2223l _rawWorkInfoDao = m.b(new p(this));
    private final C2223l _systemIdInfoDao = m.b(new l(this));
    private final C2223l _workNameDao = m.b(new m(this));
    private final C2223l _workProgressDao = m.b(new n(this));
    private final C2223l _workSpecDao = m.b(new i(this));
    private final C2223l _workTagDao = m.b(new k(this));

    /* access modifiers changed from: private */
    public static final DependencyDao_Impl _dependencyDao$lambda$1(WorkDatabase_Impl workDatabase_Impl) {
        return new DependencyDao_Impl(workDatabase_Impl);
    }

    /* access modifiers changed from: private */
    public static final PreferenceDao_Impl _preferenceDao$lambda$6(WorkDatabase_Impl workDatabase_Impl) {
        return new PreferenceDao_Impl(workDatabase_Impl);
    }

    /* access modifiers changed from: private */
    public static final RawWorkInfoDao_Impl _rawWorkInfoDao$lambda$7(WorkDatabase_Impl workDatabase_Impl) {
        return new RawWorkInfoDao_Impl(workDatabase_Impl);
    }

    /* access modifiers changed from: private */
    public static final SystemIdInfoDao_Impl _systemIdInfoDao$lambda$3(WorkDatabase_Impl workDatabase_Impl) {
        return new SystemIdInfoDao_Impl(workDatabase_Impl);
    }

    /* access modifiers changed from: private */
    public static final WorkNameDao_Impl _workNameDao$lambda$4(WorkDatabase_Impl workDatabase_Impl) {
        return new WorkNameDao_Impl(workDatabase_Impl);
    }

    /* access modifiers changed from: private */
    public static final WorkProgressDao_Impl _workProgressDao$lambda$5(WorkDatabase_Impl workDatabase_Impl) {
        return new WorkProgressDao_Impl(workDatabase_Impl);
    }

    /* access modifiers changed from: private */
    public static final WorkSpecDao_Impl _workSpecDao$lambda$0(WorkDatabase_Impl workDatabase_Impl) {
        return new WorkSpecDao_Impl(workDatabase_Impl);
    }

    /* access modifiers changed from: private */
    public static final WorkTagDao_Impl _workTagDao$lambda$2(WorkDatabase_Impl workDatabase_Impl) {
        return new WorkTagDao_Impl(workDatabase_Impl);
    }

    public void clearAllTables() {
        super.performClear(true, "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    public List<Migration> createAutoMigrations(Map<C2733c, ? extends AutoMigrationSpec> map) {
        t.e(map, "autoMigrationSpecs");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WorkDatabase_AutoMigration_13_14_Impl());
        arrayList.add(new WorkDatabase_AutoMigration_14_15_Impl());
        arrayList.add(new WorkDatabase_AutoMigration_16_17_Impl());
        arrayList.add(new WorkDatabase_AutoMigration_17_18_Impl());
        arrayList.add(new WorkDatabase_AutoMigration_18_19_Impl());
        arrayList.add(new WorkDatabase_AutoMigration_19_20_Impl());
        arrayList.add(new WorkDatabase_AutoMigration_20_21_Impl());
        arrayList.add(new WorkDatabase_AutoMigration_22_23_Impl());
        arrayList.add(new WorkDatabase_AutoMigration_23_24_Impl());
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    public DependencyDao dependencyDao() {
        return (DependencyDao) this._dependencyDao.getValue();
    }

    public Set<C2733c> getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    /* access modifiers changed from: protected */
    public Map<C2733c, List<C2733c>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(M.b(WorkSpecDao.class), WorkSpecDao_Impl.Companion.getRequiredConverters());
        linkedHashMap.put(M.b(DependencyDao.class), DependencyDao_Impl.Companion.getRequiredConverters());
        linkedHashMap.put(M.b(WorkTagDao.class), WorkTagDao_Impl.Companion.getRequiredConverters());
        linkedHashMap.put(M.b(SystemIdInfoDao.class), SystemIdInfoDao_Impl.Companion.getRequiredConverters());
        linkedHashMap.put(M.b(WorkNameDao.class), WorkNameDao_Impl.Companion.getRequiredConverters());
        linkedHashMap.put(M.b(WorkProgressDao.class), WorkProgressDao_Impl.Companion.getRequiredConverters());
        linkedHashMap.put(M.b(PreferenceDao.class), PreferenceDao_Impl.Companion.getRequiredConverters());
        linkedHashMap.put(M.b(RawWorkInfoDao.class), RawWorkInfoDao_Impl.Companion.getRequiredConverters());
        return linkedHashMap;
    }

    public PreferenceDao preferenceDao() {
        return (PreferenceDao) this._preferenceDao.getValue();
    }

    public RawWorkInfoDao rawWorkInfoDao() {
        return (RawWorkInfoDao) this._rawWorkInfoDao.getValue();
    }

    public SystemIdInfoDao systemIdInfoDao() {
        return (SystemIdInfoDao) this._systemIdInfoDao.getValue();
    }

    public WorkNameDao workNameDao() {
        return (WorkNameDao) this._workNameDao.getValue();
    }

    public WorkProgressDao workProgressDao() {
        return (WorkProgressDao) this._workProgressDao.getValue();
    }

    public WorkSpecDao workSpecDao() {
        return (WorkSpecDao) this._workSpecDao.getValue();
    }

    public WorkTagDao workTagDao() {
        return (WorkTagDao) this._workTagDao.getValue();
    }

    /* access modifiers changed from: protected */
    public RoomOpenDelegate createOpenDelegate() {
        return new WorkDatabase_Impl$createOpenDelegate$_openDelegate$1(this);
    }
}
