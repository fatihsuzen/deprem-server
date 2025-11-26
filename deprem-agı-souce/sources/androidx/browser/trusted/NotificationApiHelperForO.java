package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class NotificationApiHelperForO {
    private NotificationApiHelperForO() {
    }

    @Nullable
    static Notification copyNotificationOntoChannel(Context context, NotificationManager notificationManager, Notification notification, String str, String str2) {
        notificationManager.createNotificationChannel(g.a(str, str2, 3));
        if (notificationManager.getNotificationChannel(str).getImportance() == 0) {
            return null;
        }
        Notification.Builder a5 = Notification.Builder.recoverBuilder(context, notification);
        Notification.Builder unused = a5.setChannelId(str);
        return a5.build();
    }

    static boolean isChannelEnabled(NotificationManager notificationManager, String str) {
        NotificationChannel a5 = notificationManager.getNotificationChannel(str);
        if (a5 == null || a5.getImportance() != 0) {
            return true;
        }
        return false;
    }
}
