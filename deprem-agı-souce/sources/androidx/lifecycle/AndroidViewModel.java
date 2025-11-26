package androidx.lifecycle;

import android.app.Application;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.t;

public class AndroidViewModel extends ViewModel {
    private final Application application;

    public AndroidViewModel(Application application2) {
        t.e(application2, MimeTypes.BASE_TYPE_APPLICATION);
        this.application = application2;
    }

    public <T extends Application> T getApplication() {
        T t5 = this.application;
        t.c(t5, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t5;
    }
}
