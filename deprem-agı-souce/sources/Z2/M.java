package z2;

import U1.C2201a;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b2.C2279K;
import b2.C2291k;
import b2.C2301u;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.preferences.a;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.receivers.DownloadNotificationReceiver;
import com.uptodown.workers.DownloadWorker;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2642B;
import l2.C2647G;
import l2.C2652a;
import l2.C2657f;
import l2.C2668q;
import l2.T;
import l2.r;

public final class M {

    /* renamed from: a  reason: collision with root package name */
    public static final M f26506a = new M();

    private M() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void B(l2.T r13, android.content.Context r14) {
        /*
            r12 = this;
            java.lang.String r0 = "notification"
            java.lang.Object r0 = r14.getSystemService(r0)
            java.lang.String r1 = "null cannot be cast to non-null type android.app.NotificationManager"
            kotlin.jvm.internal.t.c(r0, r1)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            z2.B$a r1 = z2.C2940B.f26458v
            z2.B r1 = r1.a(r14)
            r1.a()
            r2 = 1
            r13.s(r2)
            r1.C1(r13)
            r1.m()
            r1 = 0
            r3 = 0
            android.content.pm.PackageManager r4 = r14.getPackageManager()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r5 = "getPackageManager(...)"
            kotlin.jvm.internal.t.d(r4, r5)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r13 = r13.h()     // Catch:{ Exception -> 0x0054 }
            android.content.pm.PackageInfo r13 = b2.C2301u.d(r4, r13, r1)     // Catch:{ Exception -> 0x0054 }
            android.content.pm.ApplicationInfo r4 = r13.applicationInfo     // Catch:{ Exception -> 0x0054 }
            if (r4 == 0) goto L_0x0054
            kotlin.jvm.internal.t.b(r4)     // Catch:{ Exception -> 0x0054 }
            android.content.pm.PackageManager r5 = r14.getPackageManager()     // Catch:{ Exception -> 0x0054 }
            android.graphics.drawable.Drawable r4 = r4.loadIcon(r5)     // Catch:{ Exception -> 0x0054 }
            android.content.pm.ApplicationInfo r13 = r13.applicationInfo     // Catch:{ Exception -> 0x0055 }
            kotlin.jvm.internal.t.b(r13)     // Catch:{ Exception -> 0x0055 }
            android.content.pm.PackageManager r5 = r14.getPackageManager()     // Catch:{ Exception -> 0x0055 }
            java.lang.CharSequence r13 = r13.loadLabel(r5)     // Catch:{ Exception -> 0x0055 }
            java.lang.String r3 = r13.toString()     // Catch:{ Exception -> 0x0055 }
            goto L_0x0055
        L_0x0054:
            r4 = r3
        L_0x0055:
            if (r3 == 0) goto L_0x00fb
            r13 = 2131952480(0x7f130360, float:1.9541404E38)
            java.lang.String r6 = r14.getString(r13)
            java.lang.String r13 = "getString(...)"
            kotlin.jvm.internal.t.d(r6, r13)
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r5[r1] = r3
            r3 = 2131952479(0x7f13035f, float:1.9541402E38)
            java.lang.String r3 = r14.getString(r3, r5)
            kotlin.jvm.internal.t.d(r3, r13)
            androidx.core.app.NotificationCompat$InboxStyle r13 = new androidx.core.app.NotificationCompat$InboxStyle
            r13.<init>()
            r13.setBigContentTitle(r6)
            r13.addLine(r3)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r7 = 10
            r5.append(r7)
            androidx.core.app.NotificationCompat$Builder r7 = new androidx.core.app.NotificationCompat$Builder
            java.lang.String r8 = "CHANNEL_ID_UPTODOWN"
            r7.<init>((android.content.Context) r14, (java.lang.String) r8)
            r7.setOnlyAlertOnce(r2)
            r12.I(r7)
            r7.setAutoCancel(r2)
            if (r4 == 0) goto L_0x00a2
            android.graphics.Bitmap r2 = r12.s(r4)
            r7.setLargeIcon((android.graphics.Bitmap) r2)
        L_0x00a2:
            r8 = 3600000(0x36ee80, double:1.7786363E-317)
            r7.setTimeoutAfter(r8)
            r7.setOngoing(r1)
            r7.setContentText(r3)
            r7.setStyle(r13)
            android.content.Intent r13 = new android.content.Intent
            java.lang.Class<com.uptodown.activities.Updates> r2 = com.uptodown.activities.Updates.class
            r13.<init>(r14, r2)
            androidx.core.app.TaskStackBuilder r3 = androidx.core.app.TaskStackBuilder.create(r14)
            java.lang.String r4 = "create(...)"
            kotlin.jvm.internal.t.d(r3, r4)
            r3.addParentStack((java.lang.Class<?>) r2)
            r3.addNextIntent(r13)
            int r13 = r12.u()
            android.app.PendingIntent r13 = r3.getPendingIntent(r1, r13)
            r7.setContentIntent(r13)
            r13 = 258(0x102, float:3.62E-43)
            android.app.Notification r1 = r7.build()
            r0.notify(r13, r1)
            com.uptodown.activities.preferences.a$a r13 = com.uptodown.activities.preferences.a.f15150a
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r13.Q0(r14, r0)
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = java.lang.String.valueOf(r0)
            java.lang.String r8 = r5.toString()
            r9 = 0
            r10 = 0
            r5 = r12
            r11 = r14
            r5.F(r6, r7, r8, r9, r10, r11)
        L_0x00fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.M.B(l2.T, android.content.Context):void");
    }

    private final void D(Context context) {
        int a5 = T.f24856k.a(context);
        if (a5 > 0) {
            E(context, a5);
            return;
        }
        Object systemService = context.getSystemService("notification");
        t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(258);
    }

    private final void E(Context context, int i5) {
        String string = context.getResources().getString(R.string.app_name);
        t.d(string, "getString(...)");
        String string2 = context.getString(R.string.updates_availables_notification, new Object[]{String.valueOf(i5)});
        t.d(string2, "getString(...)");
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle(string);
        inboxStyle.addLine(string2);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
        builder.setOnlyAlertOnce(true);
        I(builder);
        builder.setAutoCancel(false);
        builder.setOngoing(false);
        builder.setContentText(string2);
        builder.setStyle(inboxStyle);
        Class<Updates> cls = Updates.class;
        Intent intent = new Intent(context, cls);
        TaskStackBuilder create = TaskStackBuilder.create(context);
        t.d(create, "create(...)");
        create.addParentStack((Class<?>) cls);
        create.addNextIntent(intent);
        builder.setContentIntent(create.getPendingIntent(0, u()));
        builder.setNumber(i5);
        Object systemService = context.getSystemService("notification");
        t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(258, builder.build());
        a.f15150a.Q0(context, String.valueOf(System.currentTimeMillis()));
        F(string, String.valueOf(System.currentTimeMillis()), string2 + 10, (String) null, (String) null, context);
    }

    private final void F(String str, String str2, String str3, String str4, String str5, Context context) {
        C2642B b5 = new C2642B();
        b5.m(str);
        b5.l(str2);
        b5.k(str3);
        b5.i(str4);
        b5.j(str5);
        b5.h(context);
    }

    private final void H(NotificationCompat.Builder builder, int i5) {
        builder.setOnlyAlertOnce(true);
        I(builder);
        builder.setAutoCancel(false);
        builder.setOngoing(true);
        builder.setProgress(100, i5, false);
    }

    private final void I(NotificationCompat.Builder builder) {
        builder.setSmallIcon((int) R.drawable.vector_uptodown_notification);
    }

    private final void b(Context context, int i5) {
        String str;
        if (Build.VERSION.SDK_INT >= 24 && i5 > 0) {
            Object systemService = context.getSystemService("notification");
            t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            Iterator a5 = C2625c.a(activeNotifications);
            while (true) {
                if (!a5.hasNext()) {
                    str = null;
                    break;
                }
                StatusBarNotification statusBarNotification = (StatusBarNotification) a5.next();
                if (i5 == statusBarNotification.getId()) {
                    str = statusBarNotification.getGroupKey();
                    break;
                }
            }
            if (str != null) {
                Iterator a6 = C2625c.a(activeNotifications);
                while (a6.hasNext()) {
                    StatusBarNotification statusBarNotification2 = (StatusBarNotification) a6.next();
                    if (i5 != statusBarNotification2.getId() && t.a(statusBarNotification2.getGroupKey(), str)) {
                        return;
                    }
                }
                notificationManager.cancel(i5);
            }
        }
    }

    private final Bitmap s(Drawable drawable) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                Bitmap bitmap2 = bitmapDrawable.getBitmap();
                t.d(bitmap2, "getBitmap(...)");
                return bitmap2;
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            t.b(bitmap);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            t.b(bitmap);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    private final int t(Context context) {
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        int u02 = a5.u0();
        a5.m();
        if (u02 == 0) {
            return MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION;
        }
        return u02 + 1;
    }

    private final int u() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 201326592;
        }
        return 134217728;
    }

    private final void w(Context context, C2668q qVar, String str) {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        if (qVar != null) {
            str2 = qVar.i();
        } else {
            str2 = null;
        }
        if (str2 == null || str2.length() == 0) {
            if (qVar != null) {
                str3 = qVar.w();
            } else {
                str3 = null;
            }
            if (!(str3 == null || str3.length() == 0)) {
                t.b(qVar);
                str5 = qVar.w();
                t.b(str5);
            }
        } else {
            t.b(qVar);
            str5 = qVar.i();
            t.b(str5);
        }
        String str6 = str5;
        if (str == null || str.length() == 0) {
            str4 = context.getString(R.string.descarga_error);
        } else {
            str4 = context.getString(R.string.descarga_error) + str;
        }
        Object systemService = context.getSystemService("notification");
        t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
        I(builder);
        if (!(str6 == null || str6.length() == 0)) {
            builder.setContentTitle(str6);
        }
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str4));
        builder.setContentText(str4);
        builder.setAutoCancel(true);
        Class<MainActivity> cls = MainActivity.class;
        Intent intent = new Intent(context, cls);
        TaskStackBuilder create = TaskStackBuilder.create(context);
        t.d(create, "create(...)");
        create.addParentStack((Class<?>) cls);
        create.addNextIntent(intent);
        builder.setContentIntent(create.getPendingIntent(0, u()));
        Class<MyDownloads> cls2 = MyDownloads.class;
        Intent intent2 = new Intent(context, cls2);
        TaskStackBuilder create2 = TaskStackBuilder.create(context);
        t.d(create2, "create(...)");
        create2.addParentStack((Class<?>) cls2);
        create2.addNextIntent(intent2);
        builder.setContentIntent(create2.getPendingIntent(0, u()));
        notificationManager.notify(257, builder.build());
        F(str6, String.valueOf(System.currentTimeMillis()), str, (String) null, (String) null, context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void x(android.content.Context r13, l2.C2668q r14) {
        /*
            r12 = this;
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)
            java.lang.String r1 = r13.getPackageName()
            r0.setPackage(r1)
            java.util.ArrayList r1 = r14.o()
            int r1 = r1.size()
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x004e
            java.util.ArrayList r1 = r14.o()
            java.lang.Object r1 = r1.get(r2)
            l2.r r1 = (l2.r) r1
            java.lang.String r1 = r1.a()
            if (r1 == 0) goto L_0x004e
            java.io.File r1 = new java.io.File
            java.util.ArrayList r4 = r14.o()
            java.lang.Object r4 = r4.get(r2)
            l2.r r4 = (l2.r) r4
            java.lang.String r4 = r4.a()
            kotlin.jvm.internal.t.b(r4)
            r1.<init>(r4)
            z2.v r4 = new z2.v
            r4.<init>()
            android.net.Uri r1 = r4.w(r1, r13)
            java.lang.String r4 = "application/vnd.android.package-archive"
            r0.setDataAndType(r1, r4)
        L_0x004e:
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r1 < r4) goto L_0x0057
            r1 = 335544320(0x14000000, float:6.4623485E-27)
            goto L_0x0058
        L_0x0057:
            r1 = r2
        L_0x0058:
            android.app.PendingIntent r1 = android.app.PendingIntent.getActivity(r13, r2, r0, r1)
            if (r1 == 0) goto L_0x0155
            androidx.core.app.NotificationCompat$Builder r2 = new androidx.core.app.NotificationCompat$Builder
            java.lang.String r4 = "CHANNEL_ID_UPTODOWN"
            r2.<init>((android.content.Context) r13, (java.lang.String) r4)
            r12.I(r2)
            java.lang.String r6 = r14.i()
            r2.setContentTitle(r6)
            r5 = 2131951921(0x7f130131, float:1.954027E38)
            java.lang.String r8 = r13.getString(r5)
            java.lang.String r0 = "getString(...)"
            kotlin.jvm.internal.t.d(r8, r0)
            androidx.core.app.NotificationCompat$BigTextStyle r0 = new androidx.core.app.NotificationCompat$BigTextStyle
            r0.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r0 = r0.bigText(r8)
            r2.setStyle(r0)
            r2.setContentText(r8)
            r2.setAutoCancel(r3)
            java.lang.String r0 = r14.D()
            if (r0 == 0) goto L_0x00ab
            com.squareup.picasso.s r0 = com.squareup.picasso.s.h()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r7 = r14.D()     // Catch:{ Exception -> 0x00a7 }
            com.squareup.picasso.w r0 = r0.l(r7)     // Catch:{ Exception -> 0x00a7 }
            android.graphics.Bitmap r0 = r0.g()     // Catch:{ Exception -> 0x00a7 }
            r2.setLargeIcon((android.graphics.Bitmap) r0)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ab:
            java.lang.String r0 = "com.uptodown.APP_DOWNLOADED"
            r2.setGroup(r0)
            r2.setContentIntent(r1)
            java.lang.String r1 = "notification"
            java.lang.Object r1 = r13.getSystemService(r1)
            java.lang.String r7 = "null cannot be cast to non-null type android.app.NotificationManager"
            kotlin.jvm.internal.t.c(r1, r7)
            android.app.NotificationManager r1 = (android.app.NotificationManager) r1
            int r7 = android.os.Build.VERSION.SDK_INT
            r9 = 24
            if (r7 < r9) goto L_0x00f3
            androidx.core.app.NotificationCompat$Builder r7 = new androidx.core.app.NotificationCompat$Builder
            r7.<init>((android.content.Context) r13, (java.lang.String) r4)
            java.lang.String r4 = r13.getString(r5)
            androidx.core.app.NotificationCompat$Builder r4 = r7.setContentTitle(r4)
            r5 = 2131231602(0x7f080372, float:1.807929E38)
            androidx.core.app.NotificationCompat$Builder r4 = r4.setSmallIcon((int) r5)
            androidx.core.app.NotificationCompat$Builder r0 = r4.setGroup(r0)
            androidx.core.app.NotificationCompat$Builder r0 = r0.setAutoCancel(r3)
            androidx.core.app.NotificationCompat$Builder r0 = r0.setGroupSummary(r3)
            java.lang.String r3 = "setGroupSummary(...)"
            kotlin.jvm.internal.t.d(r0, r3)
            r3 = 6
            android.app.Notification r0 = r0.build()
            r1.notify(r3, r0)
        L_0x00f3:
            java.lang.String r0 = r14.w()
            r3 = -1
            if (r0 == 0) goto L_0x0122
            long r4 = r14.E()
            r9 = 0
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0122
            l2.a r0 = new l2.a
            java.lang.String r4 = r14.w()
            kotlin.jvm.internal.t.b(r4)
            long r9 = r14.E()
            r0.<init>(r4, r9)
            l2.a r4 = r0.f(r13)
            if (r4 == 0) goto L_0x011f
            int r0 = r4.a()
            goto L_0x0124
        L_0x011f:
            r4 = r0
            r0 = r3
            goto L_0x0124
        L_0x0122:
            r0 = 0
            goto L_0x011f
        L_0x0124:
            if (r0 != r3) goto L_0x013b
            int r0 = r12.t(r13)
            if (r4 == 0) goto L_0x012f
            r4.h(r0)
        L_0x012f:
            if (r4 == 0) goto L_0x0136
            l2.a$b r3 = l2.C2652a.b.DOWNLOADED
            r4.j(r3)
        L_0x0136:
            if (r4 == 0) goto L_0x013b
            r4.g(r13)
        L_0x013b:
            android.app.Notification r2 = r2.build()
            r1.notify(r0, r2)
            java.lang.String r10 = r14.i()
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = java.lang.String.valueOf(r0)
            java.lang.String r9 = "install"
            r5 = r12
            r11 = r13
            r5.F(r6, r7, r8, r9, r10, r11)
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.M.x(android.content.Context, l2.q):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ef, code lost:
        r2 = new l2.C2652a(r15, r10);
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void y(android.content.Context r14, java.lang.String r15) {
        /*
            r13 = this;
            r1 = 0
            r2 = 0
            android.content.pm.PackageManager r0 = r14.getPackageManager()     // Catch:{ Exception -> 0x0033 }
            java.lang.String r3 = "getPackageManager(...)"
            kotlin.jvm.internal.t.d(r0, r3)     // Catch:{ Exception -> 0x0033 }
            android.content.pm.PackageInfo r0 = b2.C2301u.d(r0, r15, r1)     // Catch:{ Exception -> 0x0033 }
            android.content.pm.ApplicationInfo r3 = r0.applicationInfo     // Catch:{ Exception -> 0x0033 }
            if (r3 == 0) goto L_0x0037
            kotlin.jvm.internal.t.b(r3)     // Catch:{ Exception -> 0x0033 }
            android.content.pm.PackageManager r4 = r14.getPackageManager()     // Catch:{ Exception -> 0x0033 }
            android.graphics.drawable.Drawable r3 = r3.loadIcon(r4)     // Catch:{ Exception -> 0x0033 }
            android.content.pm.ApplicationInfo r4 = r0.applicationInfo     // Catch:{ Exception -> 0x0030 }
            kotlin.jvm.internal.t.b(r4)     // Catch:{ Exception -> 0x0030 }
            android.content.pm.PackageManager r5 = r14.getPackageManager()     // Catch:{ Exception -> 0x0030 }
            java.lang.CharSequence r4 = r4.loadLabel(r5)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0030 }
            goto L_0x0039
        L_0x0030:
            r0 = move-exception
            r4 = r2
            goto L_0x0045
        L_0x0033:
            r0 = move-exception
            r3 = r2
            r4 = r3
            goto L_0x0045
        L_0x0037:
            r3 = r2
            r4 = r3
        L_0x0039:
            b2.j r5 = new b2.j     // Catch:{ Exception -> 0x0044 }
            r5.<init>()     // Catch:{ Exception -> 0x0044 }
            long r5 = r5.m(r0)     // Catch:{ Exception -> 0x0044 }
        L_0x0042:
            r7 = r4
            goto L_0x004b
        L_0x0044:
            r0 = move-exception
        L_0x0045:
            r0.printStackTrace()
            r5 = -1
            goto L_0x0042
        L_0x004b:
            if (r7 == 0) goto L_0x0139
            r0 = 255(0xff, float:3.57E-43)
            r13.d(r14, r0)
            android.content.pm.PackageManager r0 = r14.getPackageManager()
            android.content.Intent r0 = r0.getLaunchIntentForPackage(r15)
            if (r0 == 0) goto L_0x0139
            int r4 = android.os.Build.VERSION.SDK_INT
            r8 = 31
            if (r4 < r8) goto L_0x0065
            r8 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0066
        L_0x0065:
            r8 = r1
        L_0x0066:
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r14, r1, r0, r8)
            if (r0 == 0) goto L_0x0139
            androidx.core.app.NotificationCompat$Builder r1 = new androidx.core.app.NotificationCompat$Builder
            java.lang.String r8 = "CHANNEL_ID_UPTODOWN"
            r1.<init>((android.content.Context) r14, (java.lang.String) r8)
            r13.I(r1)
            r9 = 2131952477(0x7f13035d, float:1.9541398E38)
            r10 = r5
            java.lang.String r5 = r14.getString(r9)
            java.lang.String r6 = "getString(...)"
            kotlin.jvm.internal.t.d(r5, r6)
            r1.setContentTitle(r5)
            androidx.core.app.NotificationCompat$BigTextStyle r6 = new androidx.core.app.NotificationCompat$BigTextStyle
            r6.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r6 = r6.bigText(r7)
            r1.setStyle(r6)
            r1.setContentText(r7)
            r6 = 1
            r1.setAutoCancel(r6)
            if (r3 == 0) goto L_0x00a2
            android.graphics.Bitmap r3 = r13.s(r3)
            r1.setLargeIcon((android.graphics.Bitmap) r3)
        L_0x00a2:
            java.lang.String r3 = "com.uptodown.APP_INSTALLED"
            r1.setGroup(r3)
            r1.setContentIntent(r0)
            java.lang.String r0 = "notification"
            java.lang.Object r0 = r14.getSystemService(r0)
            java.lang.String r12 = "null cannot be cast to non-null type android.app.NotificationManager"
            kotlin.jvm.internal.t.c(r0, r12)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            r12 = 24
            if (r4 < r12) goto L_0x00e8
            androidx.core.app.NotificationCompat$Builder r4 = new androidx.core.app.NotificationCompat$Builder
            r4.<init>((android.content.Context) r14, (java.lang.String) r8)
            java.lang.String r8 = r14.getString(r9)
            androidx.core.app.NotificationCompat$Builder r4 = r4.setContentTitle(r8)
            r8 = 2131231602(0x7f080372, float:1.807929E38)
            androidx.core.app.NotificationCompat$Builder r4 = r4.setSmallIcon((int) r8)
            androidx.core.app.NotificationCompat$Builder r3 = r4.setGroup(r3)
            androidx.core.app.NotificationCompat$Builder r3 = r3.setAutoCancel(r6)
            androidx.core.app.NotificationCompat$Builder r3 = r3.setGroupSummary(r6)
            java.lang.String r4 = "setGroupSummary(...)"
            kotlin.jvm.internal.t.d(r3, r4)
            r4 = 7
            android.app.Notification r3 = r3.build()
            r0.notify(r4, r3)
        L_0x00e8:
            r3 = 0
            int r3 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            r4 = -1
            if (r3 <= 0) goto L_0x00ff
            l2.a r2 = new l2.a
            r2.<init>(r15, r10)
            l2.a r3 = r2.f(r14)
            if (r3 == 0) goto L_0x00ff
            int r2 = r3.a()
            goto L_0x0101
        L_0x00ff:
            r3 = r2
            r2 = r4
        L_0x0101:
            if (r2 != r4) goto L_0x0118
            int r2 = r13.t(r14)
            if (r3 == 0) goto L_0x010c
            r3.h(r2)
        L_0x010c:
            if (r3 == 0) goto L_0x0113
            l2.a$b r4 = l2.C2652a.b.INSTALLED
            r3.j(r4)
        L_0x0113:
            if (r3 == 0) goto L_0x0118
            r3.g(r14)
        L_0x0118:
            android.app.Notification r1 = r1.build()
            r0.notify(r2, r1)
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r6 = java.lang.String.valueOf(r0)
            java.lang.String r8 = "open_app"
            r4 = r13
            r10 = r14
            r9 = r15
            r4.F(r5, r6, r7, r8, r9, r10)
            r14 = 6
            r13.b(r10, r14)
            r14 = 8
            r13.b(r10, r14)
            goto L_0x013a
        L_0x0139:
            r4 = r13
        L_0x013a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.M.y(android.content.Context, java.lang.String):void");
    }

    public final void A(Context context, C2668q qVar, String str) {
        String str2;
        String str3;
        String str4;
        int i5;
        C2652a aVar;
        t.e(context, "context");
        Class<MyDownloads> cls = MyDownloads.class;
        Intent intent = new Intent(context, cls);
        if (!(qVar == null || qVar.o().size() != 1 || ((r) qVar.o().get(0)).a() == null)) {
            String a5 = ((r) qVar.o().get(0)).a();
            t.b(a5);
            if (new File(a5).exists()) {
                intent.putExtra("remoteInstallPath", ((r) qVar.o().get(0)).a());
            }
        }
        TaskStackBuilder create = TaskStackBuilder.create(context);
        t.d(create, "create(...)");
        create.addParentStack((Class<?>) cls);
        create.addNextIntent(intent);
        PendingIntent pendingIntent = create.getPendingIntent(0, u());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
        builder.setContentIntent(pendingIntent);
        I(builder);
        String string = context.getString(R.string.notification_remote_install_title);
        t.d(string, "getString(...)");
        builder.setContentTitle(string);
        String str5 = null;
        if (qVar != null) {
            str2 = qVar.i();
        } else {
            str2 = null;
        }
        String string2 = context.getString(R.string.notification_remote_install_msg, new Object[]{str, str2});
        t.d(string2, "getString(...)");
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(string2));
        builder.setContentText(string2);
        builder.setAutoCancel(true);
        if (qVar != null) {
            str3 = qVar.D();
        } else {
            str3 = null;
        }
        if (str3 != null) {
            try {
                builder.setLargeIcon(s.h().l(qVar.D()).g());
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        builder.setGroup("com.uptodown.REMOTE_APP_DOWNLOADED");
        Object systemService = context.getSystemService("notification");
        t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 24) {
            NotificationCompat.Builder groupSummary = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN").setContentTitle(context.getString(R.string.descarga_completada)).setSmallIcon((int) R.drawable.vector_uptodown_notification).setGroup("com.uptodown.REMOTE_APP_DOWNLOADED").setAutoCancel(true).setGroupSummary(true);
            t.d(groupSummary, "setGroupSummary(...)");
            notificationManager.notify(8, groupSummary.build());
        }
        if (qVar != null) {
            str4 = qVar.w();
        } else {
            str4 = null;
        }
        if (str4 == null || qVar.E() <= 0) {
            i5 = -1;
            aVar = null;
        } else {
            String w4 = qVar.w();
            t.b(w4);
            C2652a aVar2 = new C2652a(w4, qVar.E());
            aVar = aVar2.f(context);
            if (aVar != null) {
                i5 = aVar.a();
            } else {
                aVar = aVar2;
                i5 = -1;
            }
        }
        if (i5 == -1) {
            i5 = t(context);
            if (aVar != null) {
                aVar.h(i5);
            }
            if (aVar != null) {
                aVar.j(C2652a.b.DOWNLOADED);
            }
            if (aVar != null) {
                aVar.g(context);
            }
        }
        notificationManager.notify(i5, builder.build());
        if (qVar != null) {
            str5 = qVar.i();
        }
        Context context2 = context;
        F(string, String.valueOf(System.currentTimeMillis()), string2, "downloads", str5, context2);
        F f5 = new F(context2);
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "download_complete_notified");
        f5.d("remote_install", bundle);
    }

    public final void C(Context context, Uri uri) {
        t.e(context, "context");
        if (uri != null) {
            String string = context.getString(R.string.app_name);
            t.d(string, "getString(...)");
            String string2 = context.getString(R.string.notification_msg_update_uptodown);
            t.d(string2, "getString(...)");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(context.getPackageName());
            intent.setDataAndType(uri, "application/vnd.android.package-archive");
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, u());
            Object systemService = context.getSystemService("notification");
            t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
            I(builder);
            builder.setContentTitle(string);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(string2));
            builder.setContentText(string2);
            builder.setAutoCancel(true);
            builder.setContentIntent(activity);
            ((NotificationManager) systemService).notify(259, builder.build());
            F(string, String.valueOf(System.currentTimeMillis()), string2, "update_uptodown", uri.getPath(), context);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G(android.content.Context r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "ctx"
            kotlin.jvm.internal.t.e(r0, r1)
            boolean r1 = r18.a(r19)
            if (r1 != 0) goto L_0x0011
        L_0x000d:
            r4 = r18
            goto L_0x013a
        L_0x0011:
            S1.k$a r1 = S1.k.f32g
            android.app.Activity r1 = r1.g()
            if (r1 == 0) goto L_0x001a
            goto L_0x000d
        L_0x001a:
            com.uptodown.UptodownApp$a r1 = com.uptodown.UptodownApp.f13477F
            java.lang.String r2 = "GenerateQueueWorker"
            boolean r2 = r1.T(r2, r0)
            if (r2 == 0) goto L_0x0025
            goto L_0x000d
        L_0x0025:
            java.lang.String r2 = "DownloadUpdatesWorker"
            boolean r1 = r1.T(r2, r0)
            if (r1 == 0) goto L_0x002e
            goto L_0x000d
        L_0x002e:
            com.uptodown.activities.preferences.a$a r1 = com.uptodown.activities.preferences.a.f15150a
            java.lang.String r2 = r1.B(r0)
            int r2 = java.lang.Integer.parseInt(r2)
            r3 = -1
            r5 = 0
            r7 = 1
            if (r2 == r7) goto L_0x0048
            r8 = 2
            if (r2 == r8) goto L_0x0050
            r8 = 3
            if (r2 == r8) goto L_0x004c
            r8 = 4
            if (r2 == r8) goto L_0x004a
        L_0x0048:
            r8 = r5
            goto L_0x0053
        L_0x004a:
            r8 = r3
            goto L_0x0053
        L_0x004c:
            r8 = 604800000(0x240c8400, double:2.988109026E-315)
            goto L_0x0053
        L_0x0050:
            r8 = 86400000(0x5265c00, double:4.2687272E-316)
        L_0x0053:
            java.lang.String r1 = r1.q(r0)
            long r10 = java.lang.System.currentTimeMillis()
            r2 = 0
            if (r1 == 0) goto L_0x006d
            long r5 = java.lang.Long.parseLong(r1)
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0068
        L_0x0066:
            r1 = r2
            goto L_0x006e
        L_0x0068:
            long r8 = r8 + r5
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x0066
        L_0x006d:
            r1 = r7
        L_0x006e:
            if (r1 == 0) goto L_0x000d
            z2.B$a r1 = z2.C2940B.f26458v
            z2.B r1 = r1.a(r0)
            r1.a()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            l2.T$b r4 = l2.T.f24856k
            java.util.ArrayList r4 = r4.b(r0)
            java.util.Iterator r8 = r4.iterator()
            java.lang.String r9 = "iterator(...)"
            kotlin.jvm.internal.t.d(r8, r9)
            r9 = r2
        L_0x008e:
            boolean r12 = r8.hasNext()
            if (r12 == 0) goto L_0x00bc
            java.lang.Object r12 = r8.next()
            java.lang.String r13 = "next(...)"
            kotlin.jvm.internal.t.d(r12, r13)
            l2.T r12 = (l2.T) r12
            java.lang.String r13 = r12.h()
            l2.d r13 = r1.Y(r13)
            if (r13 == 0) goto L_0x008e
            boolean r13 = r13.C(r0)
            if (r13 == 0) goto L_0x008e
            int r13 = r12.g()
            if (r13 != r7) goto L_0x00b8
            int r9 = r9 + 1
            goto L_0x008e
        L_0x00b8:
            r3.add(r12)
            goto L_0x008e
        L_0x00bc:
            z2.F r8 = new z2.F
            r8.<init>(r0)
            android.os.Bundle r12 = new android.os.Bundle
            r12.<init>()
            int r13 = r4.size()
            if (r13 <= 0) goto L_0x0135
            int r4 = r4.size()
            java.lang.String r13 = "get(...)"
            java.lang.String r14 = "notificationUpdates"
            java.lang.String r15 = "type"
            if (r4 <= r9) goto L_0x0100
            int r4 = r3.size()
            if (r4 <= 0) goto L_0x00f5
            java.lang.Object r2 = r3.get(r2)
            kotlin.jvm.internal.t.d(r2, r13)
            l2.T r2 = (l2.T) r2
            r4 = r18
            r4.B(r2, r0)
            java.lang.String r0 = "shown_single"
            r12.putString(r15, r0)
            r8.d(r14, r12)
            goto L_0x0137
        L_0x00f5:
            r4 = r18
            java.lang.String r0 = "shown_single_failed"
            r12.putString(r15, r0)
            r8.d(r14, r12)
            goto L_0x0137
        L_0x0100:
            r4 = r18
            r16 = 259200000(0xf731400, double:1.280618154E-315)
            long r5 = r5 + r16
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x0137
            r18.D(r19)
            int r0 = r3.size()
        L_0x0112:
            if (r2 >= r0) goto L_0x012c
            java.lang.Object r5 = r3.get(r2)
            l2.T r5 = (l2.T) r5
            r5.s(r7)
            java.lang.Object r5 = r3.get(r2)
            kotlin.jvm.internal.t.d(r5, r13)
            l2.T r5 = (l2.T) r5
            r1.C1(r5)
            int r2 = r2 + 1
            goto L_0x0112
        L_0x012c:
            java.lang.String r0 = "shownMaxTimeUnnotified"
            r12.putString(r15, r0)
            r8.d(r14, r12)
            goto L_0x0137
        L_0x0135:
            r4 = r18
        L_0x0137:
            r1.m()
        L_0x013a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.M.G(android.content.Context):void");
    }

    public final boolean a(Context context) {
        t.e(context, "context");
        if (Build.VERSION.SDK_INT < 33) {
            return a.f15150a.a0(context);
        }
        if (!v(context) || !a.f15150a.a0(context)) {
            return false;
        }
        return true;
    }

    public final void c(Context context) {
        t.e(context, "context");
        Object systemService = context.getSystemService("notification");
        t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(8);
    }

    public final void d(Context context, int i5) {
        t.e(context, "context");
        Object systemService = context.getSystemService("notification");
        t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(i5);
    }

    public final void e(Context context) {
        t.e(context, "context");
        d(context, 261);
    }

    public final void f(Context context) {
        t.e(context, "context");
        d(context, 255);
    }

    public final void g(Context context) {
        t.e(context, "context");
        d(context, 259);
    }

    public final void h(Context context) {
        t.e(context, "context");
        d(context, 258);
    }

    public final void i(Context context) {
        t.e(context, "context");
        if (Build.VERSION.SDK_INT >= 24) {
            Object systemService = context.getSystemService("notification");
            t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            StatusBarNotification[] activeNotifications = ((NotificationManager) systemService).getActiveNotifications();
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            Iterator it = a5.X().iterator();
            t.d(it, "iterator(...)");
            boolean z4 = false;
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                C2652a aVar = (C2652a) next;
                Iterator a6 = C2625c.a(activeNotifications);
                while (true) {
                    if (a6.hasNext()) {
                        if (aVar.a() == ((StatusBarNotification) a6.next()).getId()) {
                            z4 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z4) {
                    a5.p(aVar);
                }
            }
            a5.m();
        }
    }

    public final void j(Context context) {
        String str;
        int i5;
        String str2;
        Intent intent;
        t.e(context, "context");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
        C2668q g5 = DownloadWorker.f21359d.g();
        if (g5 != null) {
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            ArrayList p02 = a5.p0();
            a5.m();
            Iterator it = p02.iterator();
            t.d(it, "iterator(...)");
            int i6 = 0;
            int i7 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                C2668q qVar = (C2668q) next;
                if (qVar.P()) {
                    if (qVar.x() == 0) {
                        i7++;
                    } else if (DownloadWorker.f21359d.j(qVar.h())) {
                        i6++;
                    }
                }
            }
            int i8 = i6 + i7;
            String i9 = g5.i();
            if (i9 == null || i9.length() == 0) {
                str = g5.w();
            } else {
                str = g5.i();
            }
            String str3 = context.getResources().getString(R.string.notification_line_downloading) + ' ' + str + " (" + g5.x() + context.getResources().getString(R.string.percent) + ')';
            H(builder, g5.x());
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            inboxStyle.addLine(new C2291k().d(g5.y(), context) + '/' + new C2291k().d(g5.z(), context));
            Class<DownloadNotificationReceiver> cls = DownloadNotificationReceiver.class;
            if (i7 > 0) {
                Q q5 = Q.f24695a;
                String string = context.getString(R.string.queue_downloading_counter);
                t.d(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i8)}, 1));
                t.d(format, "format(...)");
                inboxStyle.addLine(format);
                Intent intent2 = new Intent(context, cls);
                intent2.setAction("CANCEL_ALL");
                intent2.putExtra("download", g5);
                intent2.putExtra("notificationID", 261);
                builder.addAction(R.drawable.core_vector_cross, context.getString(R.string.dialog_update_all_button_cancel_all), PendingIntent.getBroadcast(context, 0, intent2, u()));
            }
            builder.setStyle(inboxStyle);
            builder.setContentTitle(str3);
            Class<MyDownloads> cls2 = MyDownloads.class;
            Intent intent3 = new Intent(context, cls2);
            TaskStackBuilder create = TaskStackBuilder.create(context);
            t.d(create, "create(...)");
            create.addParentStack((Class<?>) cls2);
            create.addNextIntent(intent3);
            builder.setContentIntent(create.getPendingIntent(0, u()));
            if (DownloadWorker.f21359d.h()) {
                intent = new Intent(context, cls);
                intent.setAction("RESUME");
                str2 = context.getString(R.string.updates_button_resume);
                i5 = R.drawable.vector_play_resume;
            } else {
                intent = new Intent(context, cls);
                intent.setAction("PAUSE");
                str2 = context.getString(R.string.action_pause);
                i5 = R.drawable.vector_pause;
            }
            builder.addAction(i5, str2, PendingIntent.getBroadcast(context, 0, intent, u()));
            Intent intent4 = new Intent(context, cls);
            intent4.setAction("CANCEL");
            intent4.putExtra("download", g5);
            intent4.putExtra("notificationID", 261);
            builder.addAction(R.drawable.core_vector_cross, context.getString(R.string.option_button_cancel), PendingIntent.getBroadcast(context, 0, intent4, u()));
        } else {
            builder.setOnlyAlertOnce(true);
            I(builder);
            builder.setAutoCancel(false);
            builder.setOngoing(true);
            String string2 = context.getString(R.string.preparing_update_download);
            t.d(string2, "getString(...)");
            builder.setContentTitle(string2);
        }
        Object systemService = context.getSystemService("notification");
        t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(261, builder.build());
    }

    public final void k(Context context) {
        t.e(context, "context");
        if (a(context)) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
            I(builder);
            String string = context.getString(R.string.new_update_available);
            t.d(string, "getString(...)");
            builder.setContentTitle(string);
            String string2 = context.getString(R.string.dialog_updates_available);
            t.d(string2, "getString(...)");
            builder.setContentText(string2);
            String K4 = a.f15150a.K(context);
            if (K4 != null) {
                builder.setContentIntent(PendingIntent.getActivity(context, 0, new Intent("android.intent.action.VIEW", Uri.parse(K4)), 201326592));
            }
            Object systemService = context.getSystemService("notification");
            t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).notify(264, builder.build());
            F(string, String.valueOf(System.currentTimeMillis()), string2, (String) null, (String) null, context);
        }
    }

    public final void l(Context context, C2668q qVar) {
        t.e(context, "context");
        t.e(qVar, "download");
        if (a(context) && a.f15150a.S(context)) {
            x(context, qVar);
        }
    }

    public final void m(Context context, String str) {
        t.e(context, "context");
        t.e(str, "packagename");
        if (a(context) && a.f15150a.Z(context)) {
            y(context, str);
        }
    }

    public final void n(Context context, String str) {
        t.e(context, "context");
        t.e(str, "contentText");
        if (a(context) && a.f15150a.Z(context)) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
            I(builder);
            String string = context.getString(R.string.installing);
            t.d(string, "getString(...)");
            builder.setContentTitle(string);
            builder.setContentText(str);
            builder.setProgress(100, 0, true);
            Object systemService = context.getSystemService("notification");
            t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).notify(255, builder.build());
            F(string, String.valueOf(System.currentTimeMillis()), str, (String) null, (String) null, context);
        }
    }

    public final void o(Context context, File file, boolean z4, int i5) {
        String str;
        Drawable d5;
        ApplicationInfo applicationInfo;
        Context context2 = context;
        File file2 = file;
        t.e(context2, "context");
        t.e(file2, "file");
        if (a(context) && new C2201a(context2).q()) {
            int i6 = i5 + 260;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(context2.getPackageName());
            intent.setDataAndType(new C2962v().w(file2, context2), "application/vnd.android.package-archive");
            intent.putExtra("notificationId", i6);
            PendingIntent activity = PendingIntent.getActivity(context2, 0, intent, Build.VERSION.SDK_INT >= 31 ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 0);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context2, "CHANNEL_ID_UPTODOWN");
            I(builder);
            String name = file2.getName();
            t.d(name, "getName(...)");
            if (t3.s.D(name, ".apk", false, 2, (Object) null)) {
                try {
                    PackageManager packageManager = context2.getPackageManager();
                    t.d(packageManager, "getPackageManager(...)");
                    String absolutePath = file2.getAbsolutePath();
                    t.d(absolutePath, "getAbsolutePath(...)");
                    PackageInfo c5 = C2301u.c(packageManager, absolutePath, 128);
                    if (!(c5 == null || (applicationInfo = c5.applicationInfo) == null)) {
                        t.b(applicationInfo);
                        Drawable loadIcon = applicationInfo.loadIcon(context2.getPackageManager());
                        t.d(loadIcon, "loadIcon(...)");
                        builder.setLargeIcon(s(loadIcon));
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } else {
                C2279K.a aVar = C2279K.f20490b;
                String name2 = file2.getName();
                t.d(name2, "getName(...)");
                if (aVar.a(name2) && (d5 = new C2279K().d(file2, context2)) != null) {
                    builder.setLargeIcon(s(d5));
                }
            }
            String name3 = file.getName();
            builder.setContentTitle(name3);
            if (z4) {
                Q q5 = Q.f24695a;
                String string = context2.getString(R.string.notification_installable_found);
                t.d(string, "getString(...)");
                String absolutePath2 = file.getAbsolutePath();
                t.d(absolutePath2, "getAbsolutePath(...)");
                String absolutePath3 = file.getAbsolutePath();
                t.d(absolutePath3, "getAbsolutePath(...)");
                String substring = absolutePath2.substring(0, t3.s.l0(absolutePath3, "/", 0, false, 6, (Object) null));
                t.d(substring, "substring(...)");
                str = String.format(string, Arrays.copyOf(new Object[]{substring}, 1));
                t.d(str, "format(...)");
            } else {
                Q q6 = Q.f24695a;
                String string2 = context2.getString(R.string.notification_installable_to_delete);
                t.d(string2, "getString(...)");
                String absolutePath4 = file.getAbsolutePath();
                t.d(absolutePath4, "getAbsolutePath(...)");
                String absolutePath5 = file.getAbsolutePath();
                t.d(absolutePath5, "getAbsolutePath(...)");
                String substring2 = absolutePath4.substring(0, t3.s.l0(absolutePath5, "/", 0, false, 6, (Object) null));
                t.d(substring2, "substring(...)");
                str = String.format(string2, Arrays.copyOf(new Object[]{substring2}, 1));
                t.d(str, "format(...)");
            }
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str));
            builder.setContentText(str);
            builder.setAutoCancel(true);
            builder.setGroup("com.uptodown.INSTALLABLE_FOUND");
            Intent intent2 = new Intent(context2, InstallerActivity.class);
            intent2.putExtra("realPath", file.getAbsolutePath());
            intent2.putExtra("action", "delete");
            intent2.putExtra("notificationId", i6);
            PendingIntent activity2 = PendingIntent.getActivity(context2, i6, intent2, u());
            StringBuilder sb = new StringBuilder();
            if (z4) {
                builder.addAction(R.drawable.vector_user_panel_my_apps, context2.getString(R.string.option_button_install), activity);
                builder.setContentIntent(activity);
                sb.append("install");
                sb.append(";");
            }
            builder.addAction(R.drawable.core_vector_cross, context2.getString(R.string.option_button_delete), activity2);
            sb.append("delete");
            Object systemService = context2.getSystemService("notification");
            t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (Build.VERSION.SDK_INT >= 24) {
                NotificationCompat.Builder groupSummary = new NotificationCompat.Builder(context2, "CHANNEL_ID_UPTODOWN").setContentTitle(str).setSmallIcon((int) R.drawable.vector_uptodown_notification).setGroup("com.uptodown.INSTALLABLE_FOUND").setAutoCancel(true).setGroupSummary(true);
                t.d(groupSummary, "setGroupSummary(...)");
                notificationManager.notify(5, groupSummary.build());
            }
            notificationManager.notify(i6, builder.build());
            F(name3, String.valueOf(System.currentTimeMillis()), str, sb.toString(), file.getAbsolutePath(), context2);
        }
    }

    public final void p(Context context, int i5, String str) {
        int i6;
        String format;
        t.e(context, "context");
        try {
            if (a(context)) {
                Intent intent = new Intent(context, SecurityActivity.class);
                intent.setPackage(context.getPackageName());
                if (Build.VERSION.SDK_INT >= 31) {
                    i6 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                } else {
                    i6 = 0;
                }
                PendingIntent activity = PendingIntent.getActivity(context, 0, intent, i6);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
                I(builder);
                builder.setContentIntent(activity);
                if (i5 > 0) {
                    if (i5 == 1 && str != null) {
                        if (str.length() != 0) {
                            Q q5 = Q.f24695a;
                            String string = context.getString(R.string.notification_app_positives_found);
                            t.d(string, "getString(...)");
                            format = String.format(string, Arrays.copyOf(new Object[]{context.getString(R.string.app_name), str}, 2));
                            t.d(format, "format(...)");
                            String str2 = format;
                            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str2));
                            builder.setContentText(str2);
                            builder.setAutoCancel(true);
                            Object systemService = context.getSystemService("notification");
                            t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                            ((NotificationManager) systemService).notify(256, builder.build());
                            F((String) null, String.valueOf(System.currentTimeMillis()), str2, "positive_apps", (String) null, context);
                        }
                    }
                    Q q6 = Q.f24695a;
                    String string2 = context.getString(R.string.notification_apps_positives_found);
                    t.d(string2, "getString(...)");
                    format = String.format(string2, Arrays.copyOf(new Object[]{context.getString(R.string.app_name), String.valueOf(i5)}, 2));
                    t.d(format, "format(...)");
                    String str22 = format;
                    builder.setStyle(new NotificationCompat.BigTextStyle().bigText(str22));
                    builder.setContentText(str22);
                    builder.setAutoCancel(true);
                    Object systemService2 = context.getSystemService("notification");
                    t.c(systemService2, "null cannot be cast to non-null type android.app.NotificationManager");
                    ((NotificationManager) systemService2).notify(256, builder.build());
                    F((String) null, String.valueOf(System.currentTimeMillis()), str22, "positive_apps", (String) null, context);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void q(Context context, C2657f fVar, int i5, Bitmap bitmap, C2647G g5) {
        int i6;
        C2657f fVar2 = fVar;
        Bitmap bitmap2 = bitmap;
        C2647G g6 = g5;
        t.e(context, "context");
        t.e(fVar2, "appInfo");
        t.e(g6, "preRegister");
        if (a(context)) {
            int i7 = i5 + 500;
            Intent intent = new Intent(context, AppDetailActivity.class);
            intent.putExtra("appInfo", fVar2);
            if (Build.VERSION.SDK_INT >= 31) {
                i6 = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            } else {
                i6 = 0;
            }
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, i6);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID_UPTODOWN");
            I(builder);
            builder.setContentIntent(activity);
            Q q5 = Q.f24695a;
            String string = context.getString(R.string.notification_upcoming_releases);
            t.d(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{fVar2.N(), context.getString(R.string.app_name)}, 2));
            t.d(format, "format(...)");
            if (bitmap2 != null) {
                builder.setLargeIcon(bitmap2);
            }
            builder.setContentIntent(activity);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(format));
            builder.setContentText(format);
            builder.setAutoCancel(true);
            builder.setGroup("com.uptodown.PREREGISTER");
            Object systemService = context.getSystemService("notification");
            t.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).notify(i7, builder.build());
            String valueOf = String.valueOf(System.currentTimeMillis());
            String valueOf2 = String.valueOf(fVar2.e());
            F((String) null, valueOf, format, "preregister", valueOf2, context);
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "notification_shown");
            new F(context).d("preregister", bundle);
        } else {
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            if (a5.z0(g6.b()) == null) {
                a5.Y0(g6);
            }
            a5.m();
        }
        g6.j(context);
    }

    public final void r(Context context, C2668q qVar, String str) {
        t.e(context, "context");
        if (a(context) && a.f15150a.S(context)) {
            A(context, qVar, str);
        }
    }

    public final boolean v(Context context) {
        t.e(context, "context");
        if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
            return true;
        }
        return false;
    }

    public final void z(Context context, C2668q qVar, String str) {
        t.e(context, "context");
        if (a(context) && a.f15150a.S(context)) {
            w(context, qVar, str);
        }
    }
}
