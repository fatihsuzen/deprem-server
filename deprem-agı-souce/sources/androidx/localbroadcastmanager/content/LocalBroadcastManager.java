package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<>();
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<>();
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers = new HashMap<>();

    private static final class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent intent2, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent2;
            this.receivers = arrayList;
        }
    }

    private static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.receiver);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.dead) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    @NonNull
    public static LocalBroadcastManager getInstance(@NonNull Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            try {
                if (mInstance == null) {
                    mInstance = new LocalBroadcastManager(context.getApplicationContext());
                }
                localBroadcastManager = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return localBroadcastManager;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r3 >= r1) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        r4 = r2[r3];
        r5 = r4.receivers.size();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        if (r6 >= r5) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        r7 = r4.receivers.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (r7.dead != false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        r7.receiver.onReceive(r10.mAppContext, r4.intent);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executePendingBroadcasts() {
        /*
            r10 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord>> r0 = r10.mReceivers
            monitor-enter(r0)
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r1 = r10.mPendingBroadcasts     // Catch:{ all -> 0x000d }
            int r1 = r1.size()     // Catch:{ all -> 0x000d }
            if (r1 > 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            return
        L_0x000d:
            r1 = move-exception
            goto L_0x0046
        L_0x000f:
            androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord[] r2 = new androidx.localbroadcastmanager.content.LocalBroadcastManager.BroadcastRecord[r1]     // Catch:{ all -> 0x000d }
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r3 = r10.mPendingBroadcasts     // Catch:{ all -> 0x000d }
            r3.toArray(r2)     // Catch:{ all -> 0x000d }
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r3 = r10.mPendingBroadcasts     // Catch:{ all -> 0x000d }
            r3.clear()     // Catch:{ all -> 0x000d }
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            r0 = 0
            r3 = r0
        L_0x001e:
            if (r3 >= r1) goto L_0x0000
            r4 = r2[r3]
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord> r5 = r4.receivers
            int r5 = r5.size()
            r6 = r0
        L_0x0029:
            if (r6 >= r5) goto L_0x0043
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord> r7 = r4.receivers
            java.lang.Object r7 = r7.get(r6)
            androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord r7 = (androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord) r7
            boolean r8 = r7.dead
            if (r8 != 0) goto L_0x0040
            android.content.BroadcastReceiver r7 = r7.receiver
            android.content.Context r8 = r10.mAppContext
            android.content.Intent r9 = r4.intent
            r7.onReceive(r8, r9)
        L_0x0040:
            int r6 = r6 + 1
            goto L_0x0029
        L_0x0043:
            int r3 = r3 + 1
            goto L_0x001e
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.localbroadcastmanager.content.LocalBroadcastManager.executePendingBroadcasts():void");
    }

    public void registerReceiver(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            try {
                ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
                ArrayList arrayList = this.mReceivers.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.mReceivers.put(broadcastReceiver, arrayList);
                }
                arrayList.add(receiverRecord);
                for (int i5 = 0; i5 < intentFilter.countActions(); i5++) {
                    String action = intentFilter.getAction(i5);
                    ArrayList arrayList2 = this.mActions.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.mActions.put(action, arrayList2);
                    }
                    arrayList2.add(receiverRecord);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x015c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x015e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendBroadcast(@androidx.annotation.NonNull android.content.Intent r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord>> r2 = r1.mReceivers
            monitor-enter(r2)
            java.lang.String r4 = r0.getAction()     // Catch:{ all -> 0x0055 }
            android.content.Context r3 = r1.mAppContext     // Catch:{ all -> 0x0055 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x0055 }
            java.lang.String r5 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x0055 }
            android.net.Uri r7 = r0.getData()     // Catch:{ all -> 0x0055 }
            java.lang.String r6 = r0.getScheme()     // Catch:{ all -> 0x0055 }
            java.util.Set r8 = r0.getCategories()     // Catch:{ all -> 0x0055 }
            int r3 = r0.getFlags()     // Catch:{ all -> 0x0055 }
            r3 = r3 & 8
            if (r3 == 0) goto L_0x002b
            r12 = 1
            goto L_0x002c
        L_0x002b:
            r12 = 0
        L_0x002c:
            if (r12 == 0) goto L_0x0058
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r9.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r13 = "Resolving type "
            r9.append(r13)     // Catch:{ all -> 0x0055 }
            r9.append(r5)     // Catch:{ all -> 0x0055 }
            java.lang.String r13 = " scheme "
            r9.append(r13)     // Catch:{ all -> 0x0055 }
            r9.append(r6)     // Catch:{ all -> 0x0055 }
            java.lang.String r13 = " of intent "
            r9.append(r13)     // Catch:{ all -> 0x0055 }
            r9.append(r0)     // Catch:{ all -> 0x0055 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0055 }
            android.util.Log.v(r3, r9)     // Catch:{ all -> 0x0055 }
            goto L_0x0058
        L_0x0055:
            r0 = move-exception
            goto L_0x0161
        L_0x0058:
            java.util.HashMap<java.lang.String, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord>> r3 = r1.mActions     // Catch:{ all -> 0x0055 }
            java.lang.String r9 = r0.getAction()     // Catch:{ all -> 0x0055 }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ all -> 0x0055 }
            r13 = r3
            java.util.ArrayList r13 = (java.util.ArrayList) r13     // Catch:{ all -> 0x0055 }
            if (r13 == 0) goto L_0x015d
            if (r12 == 0) goto L_0x007f
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r9.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r14 = "Action list: "
            r9.append(r14)     // Catch:{ all -> 0x0055 }
            r9.append(r13)     // Catch:{ all -> 0x0055 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0055 }
            android.util.Log.v(r3, r9)     // Catch:{ all -> 0x0055 }
        L_0x007f:
            r3 = 0
            r14 = r3
            r15 = 0
        L_0x0082:
            int r3 = r13.size()     // Catch:{ all -> 0x0055 }
            if (r15 >= r3) goto L_0x012e
            java.lang.Object r3 = r13.get(r15)     // Catch:{ all -> 0x0055 }
            androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord r3 = (androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord) r3     // Catch:{ all -> 0x0055 }
            if (r12 == 0) goto L_0x00a8
            java.lang.String r9 = "LocalBroadcastManager"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r10.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r11 = "Matching against filter "
            r10.append(r11)     // Catch:{ all -> 0x0055 }
            android.content.IntentFilter r11 = r3.filter     // Catch:{ all -> 0x0055 }
            r10.append(r11)     // Catch:{ all -> 0x0055 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0055 }
            android.util.Log.v(r9, r10)     // Catch:{ all -> 0x0055 }
        L_0x00a8:
            boolean r9 = r3.broadcasting     // Catch:{ all -> 0x0055 }
            if (r9 == 0) goto L_0x00b9
            if (r12 == 0) goto L_0x00b5
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.String r9 = "  Filter's target already added"
            android.util.Log.v(r3, r9)     // Catch:{ all -> 0x0055 }
        L_0x00b5:
            r17 = r4
            goto L_0x0128
        L_0x00b9:
            r9 = r3
            android.content.IntentFilter r3 = r9.filter     // Catch:{ all -> 0x0055 }
            r10 = r9
            java.lang.String r9 = "LocalBroadcastManager"
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0055 }
            if (r3 < 0) goto L_0x00f4
            if (r12 == 0) goto L_0x00e4
            java.lang.String r9 = "LocalBroadcastManager"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r11.<init>()     // Catch:{ all -> 0x0055 }
            r17 = r4
            java.lang.String r4 = "  Filter matched!  match=0x"
            r11.append(r4)     // Catch:{ all -> 0x0055 }
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ all -> 0x0055 }
            r11.append(r3)     // Catch:{ all -> 0x0055 }
            java.lang.String r3 = r11.toString()     // Catch:{ all -> 0x0055 }
            android.util.Log.v(r9, r3)     // Catch:{ all -> 0x0055 }
            goto L_0x00e6
        L_0x00e4:
            r17 = r4
        L_0x00e6:
            if (r14 != 0) goto L_0x00ed
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0055 }
            r14.<init>()     // Catch:{ all -> 0x0055 }
        L_0x00ed:
            r14.add(r10)     // Catch:{ all -> 0x0055 }
            r3 = 1
            r10.broadcasting = r3     // Catch:{ all -> 0x0055 }
            goto L_0x0128
        L_0x00f4:
            r17 = r4
            if (r12 == 0) goto L_0x0128
            r4 = -4
            if (r3 == r4) goto L_0x0110
            r4 = -3
            if (r3 == r4) goto L_0x010d
            r4 = -2
            if (r3 == r4) goto L_0x010a
            r4 = -1
            if (r3 == r4) goto L_0x0107
            java.lang.String r3 = "unknown reason"
            goto L_0x0112
        L_0x0107:
            java.lang.String r3 = "type"
            goto L_0x0112
        L_0x010a:
            java.lang.String r3 = "data"
            goto L_0x0112
        L_0x010d:
            java.lang.String r3 = "action"
            goto L_0x0112
        L_0x0110:
            java.lang.String r3 = "category"
        L_0x0112:
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r9.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r10 = "  Filter did not match: "
            r9.append(r10)     // Catch:{ all -> 0x0055 }
            r9.append(r3)     // Catch:{ all -> 0x0055 }
            java.lang.String r3 = r9.toString()     // Catch:{ all -> 0x0055 }
            android.util.Log.v(r4, r3)     // Catch:{ all -> 0x0055 }
        L_0x0128:
            int r15 = r15 + 1
            r4 = r17
            goto L_0x0082
        L_0x012e:
            if (r14 == 0) goto L_0x015d
            r3 = 0
        L_0x0131:
            int r4 = r14.size()     // Catch:{ all -> 0x0055 }
            if (r3 >= r4) goto L_0x0143
            java.lang.Object r4 = r14.get(r3)     // Catch:{ all -> 0x0055 }
            androidx.localbroadcastmanager.content.LocalBroadcastManager$ReceiverRecord r4 = (androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord) r4     // Catch:{ all -> 0x0055 }
            r5 = 0
            r4.broadcasting = r5     // Catch:{ all -> 0x0055 }
            int r3 = r3 + 1
            goto L_0x0131
        L_0x0143:
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord> r3 = r1.mPendingBroadcasts     // Catch:{ all -> 0x0055 }
            androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord r4 = new androidx.localbroadcastmanager.content.LocalBroadcastManager$BroadcastRecord     // Catch:{ all -> 0x0055 }
            r4.<init>(r0, r14)     // Catch:{ all -> 0x0055 }
            r3.add(r4)     // Catch:{ all -> 0x0055 }
            android.os.Handler r0 = r1.mHandler     // Catch:{ all -> 0x0055 }
            r3 = 1
            boolean r0 = r0.hasMessages(r3)     // Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x015b
            android.os.Handler r0 = r1.mHandler     // Catch:{ all -> 0x0055 }
            r0.sendEmptyMessage(r3)     // Catch:{ all -> 0x0055 }
        L_0x015b:
            monitor-exit(r2)     // Catch:{ all -> 0x0055 }
            return r3
        L_0x015d:
            monitor-exit(r2)     // Catch:{ all -> 0x0055 }
            r16 = 0
            return r16
        L_0x0161:
            monitor-exit(r2)     // Catch:{ all -> 0x0055 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.localbroadcastmanager.content.LocalBroadcastManager.sendBroadcast(android.content.Intent):boolean");
    }

    public void sendBroadcastSync(@NonNull Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(@NonNull BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            try {
                ArrayList remove = this.mReceivers.remove(broadcastReceiver);
                if (remove != null) {
                    for (int size = remove.size() - 1; size >= 0; size--) {
                        ReceiverRecord receiverRecord = (ReceiverRecord) remove.get(size);
                        receiverRecord.dead = true;
                        for (int i5 = 0; i5 < receiverRecord.filter.countActions(); i5++) {
                            String action = receiverRecord.filter.getAction(i5);
                            ArrayList arrayList = this.mActions.get(action);
                            if (arrayList != null) {
                                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                    ReceiverRecord receiverRecord2 = (ReceiverRecord) arrayList.get(size2);
                                    if (receiverRecord2.receiver == broadcastReceiver) {
                                        receiverRecord2.dead = true;
                                        arrayList.remove(size2);
                                    }
                                }
                                if (arrayList.size() <= 0) {
                                    this.mActions.remove(action);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
