package D0;

import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class b implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT);
    }
}
