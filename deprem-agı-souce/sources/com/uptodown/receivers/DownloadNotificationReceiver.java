package com.uptodown.receivers;

import android.content.BroadcastReceiver;
import kotlin.jvm.internal.C2633k;

public final class DownloadNotificationReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21155a = new a((C2633k) null);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        r0 = com.uptodown.workers.DownloadWorker.f21359d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r6, android.content.Intent r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L_0x0007
            java.lang.String r0 = r7.getAction()
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            if (r0 == 0) goto L_0x00b1
            int r1 = r0.hashCode()
            r2 = 261(0x105, float:3.66E-43)
            r3 = -1
            java.lang.String r4 = "notificationID"
            switch(r1) {
                case -1919974852: goto L_0x006b;
                case -1881097171: goto L_0x005c;
                case 75902422: goto L_0x004d;
                case 1980572282: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x00b1
        L_0x0018:
            java.lang.String r1 = "CANCEL"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x00b1
        L_0x0022:
            int r7 = r7.getIntExtra(r4, r3)
            if (r7 != r2) goto L_0x00b1
            com.uptodown.workers.DownloadWorker$a r0 = com.uptodown.workers.DownloadWorker.f21359d
            l2.q r1 = r0.g()
            if (r1 == 0) goto L_0x00b1
            r0.a(r1)
            if (r6 == 0) goto L_0x00b1
            r1.T(r6)
            z2.v r0 = new z2.v
            r0.<init>()
            java.util.ArrayList r0 = r0.l(r6)
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00b1
            z2.M r0 = z2.M.f26506a
            r0.d(r6, r7)
            return
        L_0x004d:
            java.lang.String r6 = "PAUSE"
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L_0x0056
            goto L_0x00b1
        L_0x0056:
            com.uptodown.workers.DownloadWorker$a r6 = com.uptodown.workers.DownloadWorker.f21359d
            r6.n()
            return
        L_0x005c:
            java.lang.String r6 = "RESUME"
            boolean r6 = r0.equals(r6)
            if (r6 != 0) goto L_0x0065
            goto L_0x00b1
        L_0x0065:
            com.uptodown.workers.DownloadWorker$a r6 = com.uptodown.workers.DownloadWorker.f21359d
            r6.o()
            return
        L_0x006b:
            java.lang.String r1 = "CANCEL_ALL"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0074
            goto L_0x00b1
        L_0x0074:
            int r7 = r7.getIntExtra(r4, r3)
            if (r7 != r2) goto L_0x00b1
            if (r6 == 0) goto L_0x00b1
            com.uptodown.workers.DownloadWorker$a r0 = com.uptodown.workers.DownloadWorker.f21359d
            l2.q r1 = r0.g()
            z2.v r2 = new z2.v
            r2.<init>()
            java.util.ArrayList r2 = r2.l(r6)
            if (r1 == 0) goto L_0x0093
            r0.a(r1)
            r1.T(r6)
        L_0x0093:
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x00ac
            int r0 = r2.size()
            r1 = 0
        L_0x009e:
            if (r1 >= r0) goto L_0x00ac
            java.lang.Object r3 = r2.get(r1)
            int r1 = r1 + 1
            l2.q r3 = (l2.C2668q) r3
            r3.T(r6)
            goto L_0x009e
        L_0x00ac:
            z2.M r0 = z2.M.f26506a
            r0.d(r6, r7)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.receivers.DownloadNotificationReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
