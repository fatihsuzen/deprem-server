package androidx.sqlite.db;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class SupportSQLiteCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Api16Impl {
        public static final Api16Impl INSTANCE = new Api16Impl();

        private Api16Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final void cancel(CancellationSignal cancellationSignal) {
            t.e(cancellationSignal, "cancellationSignal");
            cancellationSignal.cancel();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final CancellationSignal createCancellationSignal() {
            return new CancellationSignal();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Api19Impl {
        public static final Api19Impl INSTANCE = new Api19Impl();

        private Api19Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final Uri getNotificationUri(Cursor cursor) {
            t.e(cursor, "cursor");
            Uri notificationUri = cursor.getNotificationUri();
            t.d(notificationUri, "getNotificationUri(...)");
            return notificationUri;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final boolean isLowRamDevice(ActivityManager activityManager) {
            t.e(activityManager, "activityManager");
            return activityManager.isLowRamDevice();
        }
    }

    @RequiresApi(21)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api21Impl {
        public static final Api21Impl INSTANCE = new Api21Impl();

        private Api21Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final File getNoBackupFilesDir(Context context) {
            t.e(context, "context");
            File noBackupFilesDir = context.getNoBackupFilesDir();
            t.d(noBackupFilesDir, "getNoBackupFilesDir(...)");
            return noBackupFilesDir;
        }
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api23Impl {
        public static final Api23Impl INSTANCE = new Api23Impl();

        private Api23Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setExtras(Cursor cursor, Bundle bundle) {
            t.e(cursor, "cursor");
            t.e(bundle, "extras");
            cursor.setExtras(bundle);
        }
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final List<Uri> getNotificationUris(Cursor cursor) {
            t.e(cursor, "cursor");
            List<Uri> notificationUris = cursor.getNotificationUris();
            t.b(notificationUris);
            return notificationUris;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setNotificationUris(Cursor cursor, ContentResolver contentResolver, List<? extends Uri> list) {
            t.e(cursor, "cursor");
            t.e(contentResolver, "cr");
            t.e(list, "uris");
            cursor.setNotificationUris(contentResolver, list);
        }
    }

    private SupportSQLiteCompat() {
    }
}
