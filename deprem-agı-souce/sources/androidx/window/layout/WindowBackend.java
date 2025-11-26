package androidx.window.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;

public interface WindowBackend {
    void registerLayoutChangeCallback(Activity activity, Executor executor, Consumer<WindowLayoutInfo> consumer);

    void unregisterLayoutChangeCallback(Consumer<WindowLayoutInfo> consumer);
}
