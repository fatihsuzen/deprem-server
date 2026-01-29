// Android 14+ Foreground Service Type Fix
// Bu dosya gerekirse MainActivity.kt'ye eklenebilir

// ForegroundServiceType için sabitler
import android.content.pm.ServiceInfo
import android.os.Build

// Service başlatırken foreground type belirtme örneği:
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) { // Android 14+
    startForeground(
        notificationId,
        notification,
        ServiceInfo.FOREGROUND_SERVICE_TYPE_LOCATION or 
        ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE
    )
} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) { // Android 10+
    startForeground(notificationId, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_LOCATION)
} else {
    startForeground(notificationId, notification)
}

// Not: Bu kod flutter_foreground_task paketi tarafından otomatik olarak yapılıyor
// Sadece referans amaçlı burada gösterilmiştir
