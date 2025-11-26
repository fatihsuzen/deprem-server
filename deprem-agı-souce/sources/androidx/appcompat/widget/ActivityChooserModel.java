package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import j$.util.DesugarCollections;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ActivityChooserModel extends DataSetObservable {
    static final String ATTRIBUTE_ACTIVITY = "activity";
    static final String ATTRIBUTE_TIME = "time";
    static final String ATTRIBUTE_WEIGHT = "weight";
    static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    static final String LOG_TAG = "ActivityChooserModel";
    static final String TAG_HISTORICAL_RECORD = "historical-record";
    static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
    private static final Object sRegistryLock = new Object();
    private final List<ActivityResolveInfo> mActivities = new ArrayList();
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter = new DefaultSorter();
    boolean mCanReadHistoricalData = true;
    final Context mContext;
    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
    private boolean mHistoricalRecordsChanged = true;
    final String mHistoryFileName;
    private int mHistoryMaxSize = 50;
    private final Object mInstanceLock = new Object();
    private Intent mIntent;
    private boolean mReadShareHistoryCalled = false;
    private boolean mReloadActivities = false;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo2) {
            this.resolveInfo = resolveInfo2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[" + "resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal((double) this.weight) + "]";
        }

        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    private static final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<ComponentName, ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();

        DefaultSorter() {
        }

        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.mPackageNameToActivityMap;
            map.clear();
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                ActivityResolveInfo activityResolveInfo = list.get(i5);
                activityResolveInfo.weight = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f5 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight += historicalRecord.weight * f5;
                    f5 *= WEIGHT_DECAY_COEFFICIENT;
                }
            }
            Collections.sort(list);
        }
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j5, float f5) {
            this(ComponentName.unflattenFromString(str), j5, f5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.activity)) {
                return false;
            }
            if (this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i5;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                i5 = 0;
            } else {
                i5 = componentName.hashCode();
            }
            long j5 = this.time;
            return ((((i5 + 31) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public String toString() {
            return "[" + "; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal((double) this.weight) + "]";
        }

        public HistoricalRecord(ComponentName componentName, long j5, float f5) {
            this.activity = componentName;
            this.time = j5;
            this.weight = f5;
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        PersistHistoryAsyncTask() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
            if (r15 != null) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0096, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b5, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d4, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                java.lang.String r2 = "Error writing historical record file: "
                r3 = 0
                r4 = r15[r3]
                java.util.List r4 = (java.util.List) r4
                r5 = 1
                r15 = r15[r5]
                java.lang.String r15 = (java.lang.String) r15
                r6 = 0
                androidx.appcompat.widget.ActivityChooserModel r7 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ FileNotFoundException -> 0x00e2 }
                android.content.Context r7 = r7.mContext     // Catch:{ FileNotFoundException -> 0x00e2 }
                java.io.FileOutputStream r15 = r7.openFileOutput(r15, r3)     // Catch:{ FileNotFoundException -> 0x00e2 }
                org.xmlpull.v1.XmlSerializer r7 = android.util.Xml.newSerializer()
                r7.setOutput(r15, r6)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r8 = "UTF-8"
                java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startDocument(r8, r9)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                int r8 = r4.size()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r9 = r3
            L_0x002f:
                if (r9 >= r8) goto L_0x006a
                java.lang.Object r10 = r4.remove(r3)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord r10 = (androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord) r10     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "activity"
                android.content.ComponentName r12 = r10.activity     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r12 = r12.flattenToString()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "time"
                long r12 = r10.time     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "weight"
                float r10 = r10.weight     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r10)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.endTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                int r9 = r9 + 1
                goto L_0x002f
            L_0x0061:
                r0 = move-exception
                goto L_0x00d8
            L_0x0064:
                r0 = move-exception
                goto L_0x007a
            L_0x0066:
                r0 = move-exception
                goto L_0x0099
            L_0x0068:
                r0 = move-exception
                goto L_0x00b8
            L_0x006a:
                r7.endTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.endDocument()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r5
                if (r15 == 0) goto L_0x00d7
            L_0x0076:
                r15.close()     // Catch:{ IOException -> 0x00d7 }
                goto L_0x00d7
            L_0x007a:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.LOG_TAG     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.mHistoryFileName     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x0099:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.LOG_TAG     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.mHistoryFileName     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x00b8:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.LOG_TAG     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.mHistoryFileName     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.mCanReadHistoricalData = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x00d7:
                return r6
            L_0x00d8:
                androidx.appcompat.widget.ActivityChooserModel r1 = androidx.appcompat.widget.ActivityChooserModel.this
                r1.mCanReadHistoricalData = r5
                if (r15 == 0) goto L_0x00e1
                r15.close()     // Catch:{ IOException -> 0x00e1 }
            L_0x00e1:
                throw r0
            L_0x00e2:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.LOG_TAG
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                r3.append(r15)
                java.lang.String r15 = r3.toString()
                android.util.Log.e(r1, r15, r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.PersistHistoryAsyncTask.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private ActivityChooserModel(Context context, String str) {
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = str;
            return;
        }
        this.mHistoryFileName = str + HISTORY_FILE_EXTENSION;
    }

    private boolean addHistoricalRecord(HistoricalRecord historicalRecord) {
        boolean add = this.mHistoricalRecords.add(historicalRecord);
        if (add) {
            this.mHistoricalRecordsChanged = true;
            pruneExcessiveHistoricalRecordsIfNeeded();
            persistHistoricalDataIfNeeded();
            sortActivitiesIfNeeded();
            notifyChanged();
        }
        return add;
    }

    private void ensureConsistentState() {
        boolean loadActivitiesIfNeeded = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (loadActivitiesIfNeeded) {
            sortActivitiesIfNeeded();
            notifyChanged();
        }
    }

    public static ActivityChooserModel get(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (sRegistryLock) {
            try {
                Map<String, ActivityChooserModel> map = sDataModelRegistry;
                activityChooserModel = map.get(str);
                if (activityChooserModel == null) {
                    activityChooserModel = new ActivityChooserModel(context, str);
                    map.put(str, activityChooserModel);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return activityChooserModel;
    }

    private boolean loadActivitiesIfNeeded() {
        if (!this.mReloadActivities || this.mIntent == null) {
            return false;
        }
        this.mReloadActivities = false;
        this.mActivities.clear();
        List<ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = queryIntentActivities.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.mActivities.add(new ActivityResolveInfo(queryIntentActivities.get(i5)));
        }
        return true;
    }

    private void persistHistoricalDataIfNeeded() {
        if (!this.mReadShareHistoryCalled) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.mHistoricalRecordsChanged) {
            this.mHistoricalRecordsChanged = false;
            if (!TextUtils.isEmpty(this.mHistoryFileName)) {
                new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.mHistoricalRecords), this.mHistoryFileName});
            }
        }
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int size = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (size > 0) {
            this.mHistoricalRecordsChanged = true;
            for (int i5 = 0; i5 < size; i5++) {
                HistoricalRecord remove = this.mHistoricalRecords.remove(0);
            }
        }
    }

    private boolean readHistoricalDataIfNeeded() {
        if (!this.mCanReadHistoricalData || !this.mHistoricalRecordsChanged || TextUtils.isEmpty(this.mHistoryFileName)) {
            return false;
        }
        this.mCanReadHistoricalData = false;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readHistoricalDataImpl() {
        /*
            r10 = this;
            java.lang.String r0 = "Error reading historical recrod file: "
            android.content.Context r1 = r10.mContext     // Catch:{ FileNotFoundException -> 0x00c6 }
            java.lang.String r2 = r10.mHistoryFileName     // Catch:{ FileNotFoundException -> 0x00c6 }
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ FileNotFoundException -> 0x00c6 }
            org.xmlpull.v1.XmlPullParser r2 = android.util.Xml.newPullParser()     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            java.lang.String r3 = "UTF-8"
            r2.setInput(r1, r3)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            r3 = 0
        L_0x0014:
            r4 = 1
            if (r3 == r4) goto L_0x0027
            r5 = 2
            if (r3 == r5) goto L_0x0027
            int r3 = r2.next()     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            goto L_0x0014
        L_0x001f:
            r0 = move-exception
            goto L_0x00c0
        L_0x0022:
            r2 = move-exception
            goto L_0x008b
        L_0x0024:
            r2 = move-exception
            goto L_0x00a7
        L_0x0027:
            java.lang.String r3 = "historical-records"
            java.lang.String r5 = r2.getName()     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            if (r3 == 0) goto L_0x0083
            java.util.List<androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord> r3 = r10.mHistoricalRecords     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            r3.clear()     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
        L_0x0038:
            int r5 = r2.next()     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            if (r5 != r4) goto L_0x0044
            if (r1 == 0) goto L_0x00c6
            r1.close()     // Catch:{  }
            return
        L_0x0044:
            r6 = 3
            if (r5 == r6) goto L_0x0038
            r6 = 4
            if (r5 != r6) goto L_0x004b
            goto L_0x0038
        L_0x004b:
            java.lang.String r5 = r2.getName()     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            java.lang.String r6 = "historical-record"
            boolean r5 = r6.equals(r5)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            if (r5 == 0) goto L_0x007b
            java.lang.String r5 = "activity"
            r6 = 0
            java.lang.String r5 = r2.getAttributeValue(r6, r5)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            java.lang.String r7 = "time"
            java.lang.String r7 = r2.getAttributeValue(r6, r7)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            long r7 = java.lang.Long.parseLong(r7)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            java.lang.String r9 = "weight"
            java.lang.String r6 = r2.getAttributeValue(r6, r9)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord r9 = new androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            r9.<init>((java.lang.String) r5, (long) r7, (float) r6)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            r3.add(r9)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            goto L_0x0038
        L_0x007b:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            java.lang.String r3 = "Share records file not well-formed."
            r2.<init>(r3)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            throw r2     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
        L_0x0083:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            java.lang.String r3 = "Share records file does not start with historical-records tag."
            r2.<init>(r3)     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
            throw r2     // Catch:{ XmlPullParserException -> 0x0024, IOException -> 0x0022 }
        L_0x008b:
            java.lang.String r3 = LOG_TAG     // Catch:{ all -> 0x001f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x001f }
            r4.<init>()     // Catch:{ all -> 0x001f }
            r4.append(r0)     // Catch:{ all -> 0x001f }
            java.lang.String r0 = r10.mHistoryFileName     // Catch:{ all -> 0x001f }
            r4.append(r0)     // Catch:{ all -> 0x001f }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x001f }
            android.util.Log.e(r3, r0, r2)     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x00c6
        L_0x00a3:
            r1.close()     // Catch:{  }
            goto L_0x00c6
        L_0x00a7:
            java.lang.String r3 = LOG_TAG     // Catch:{ all -> 0x001f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x001f }
            r4.<init>()     // Catch:{ all -> 0x001f }
            r4.append(r0)     // Catch:{ all -> 0x001f }
            java.lang.String r0 = r10.mHistoryFileName     // Catch:{ all -> 0x001f }
            r4.append(r0)     // Catch:{ all -> 0x001f }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x001f }
            android.util.Log.e(r3, r0, r2)     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x00c6
            goto L_0x00a3
        L_0x00c0:
            if (r1 == 0) goto L_0x00c5
            r1.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x00c5:
            throw r0
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.readHistoricalDataImpl():void");
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter == null || this.mIntent == null || this.mActivities.isEmpty() || this.mHistoricalRecords.isEmpty()) {
            return false;
        }
        this.mActivitySorter.sort(this.mIntent, this.mActivities, DesugarCollections.unmodifiableList(this.mHistoricalRecords));
        return true;
    }

    public Intent chooseActivity(int i5) {
        synchronized (this.mInstanceLock) {
            try {
                if (this.mIntent == null) {
                    return null;
                }
                ensureConsistentState();
                ActivityInfo activityInfo = this.mActivities.get(i5).resolveInfo.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                Intent intent = new Intent(this.mIntent);
                intent.setComponent(componentName);
                if (this.mActivityChoserModelPolicy != null) {
                    if (this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(intent))) {
                        return null;
                    }
                }
                addHistoricalRecord(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
                return intent;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo getActivity(int i5) {
        ResolveInfo resolveInfo;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            resolveInfo = this.mActivities.get(i5).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mActivities.size();
        }
        return size;
    }

    public int getActivityIndex(ResolveInfo resolveInfo) {
        synchronized (this.mInstanceLock) {
            try {
                ensureConsistentState();
                List<ActivityResolveInfo> list = this.mActivities;
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (list.get(i5).resolveInfo == resolveInfo) {
                        return i5;
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            try {
                ensureConsistentState();
                if (this.mActivities.isEmpty()) {
                    return null;
                }
                ResolveInfo resolveInfo = this.mActivities.get(0).resolveInfo;
                return resolveInfo;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getHistoryMaxSize() {
        int i5;
        synchronized (this.mInstanceLock) {
            i5 = this.mHistoryMaxSize;
        }
        return i5;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setActivitySorter(androidx.appcompat.widget.ActivityChooserModel.ActivitySorter r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mInstanceLock
            monitor-enter(r0)
            androidx.appcompat.widget.ActivityChooserModel$ActivitySorter r1 = r2.mActivitySorter     // Catch:{ all -> 0x0009 }
            if (r1 != r3) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0009:
            r3 = move-exception
            goto L_0x0018
        L_0x000b:
            r2.mActivitySorter = r3     // Catch:{ all -> 0x0009 }
            boolean r3 = r2.sortActivitiesIfNeeded()     // Catch:{ all -> 0x0009 }
            if (r3 == 0) goto L_0x0016
            r2.notifyChanged()     // Catch:{ all -> 0x0009 }
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.setActivitySorter(androidx.appcompat.widget.ActivityChooserModel$ActivitySorter):void");
    }

    public void setDefaultActivity(int i5) {
        float f5;
        synchronized (this.mInstanceLock) {
            try {
                ensureConsistentState();
                ActivityResolveInfo activityResolveInfo = this.mActivities.get(i5);
                ActivityResolveInfo activityResolveInfo2 = this.mActivities.get(0);
                if (activityResolveInfo2 != null) {
                    f5 = (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f;
                } else {
                    f5 = 1.0f;
                }
                ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                addHistoricalRecord(new HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f5));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setHistoryMaxSize(int r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mInstanceLock
            monitor-enter(r0)
            int r1 = r2.mHistoryMaxSize     // Catch:{ all -> 0x0009 }
            if (r1 != r3) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0009:
            r3 = move-exception
            goto L_0x001b
        L_0x000b:
            r2.mHistoryMaxSize = r3     // Catch:{ all -> 0x0009 }
            r2.pruneExcessiveHistoricalRecordsIfNeeded()     // Catch:{ all -> 0x0009 }
            boolean r3 = r2.sortActivitiesIfNeeded()     // Catch:{ all -> 0x0009 }
            if (r3 == 0) goto L_0x0019
            r2.notifyChanged()     // Catch:{ all -> 0x0009 }
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.setHistoryMaxSize(int):void");
    }

    public void setIntent(Intent intent) {
        synchronized (this.mInstanceLock) {
            try {
                if (this.mIntent != intent) {
                    this.mIntent = intent;
                    this.mReloadActivities = true;
                    ensureConsistentState();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.mInstanceLock) {
            this.mActivityChoserModelPolicy = onChooseActivityListener;
        }
    }
}
