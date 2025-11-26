package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

public interface EngagementSignalsCallback {
    void onGreatestScrollPercentageIncreased(@IntRange(from = 1, to = 100) int i5, @NonNull Bundle bundle);

    void onSessionEnded(boolean z4, @NonNull Bundle bundle);

    void onVerticalScrollEvent(boolean z4, @NonNull Bundle bundle);
}
