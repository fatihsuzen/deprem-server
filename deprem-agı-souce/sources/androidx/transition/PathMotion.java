package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

public abstract class PathMotion {
    public PathMotion() {
    }

    @NonNull
    public abstract Path getPath(float f5, float f6, float f7, float f8);

    public PathMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
    }
}
