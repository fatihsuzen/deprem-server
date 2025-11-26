package androidx.leanback.transition;

import android.graphics.Rect;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class TransitionEpicenterCallback {
    public abstract Rect onGetEpicenter(Object obj);
}
