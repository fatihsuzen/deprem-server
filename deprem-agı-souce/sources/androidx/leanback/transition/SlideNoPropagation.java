package androidx.leanback.transition;

import android.content.Context;
import android.transition.Slide;
import android.transition.TransitionPropagation;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SlideNoPropagation extends Slide {
    public SlideNoPropagation() {
    }

    public void setSlideEdge(int i5) {
        super.setSlideEdge(i5);
        setPropagation((TransitionPropagation) null);
    }

    public SlideNoPropagation(int i5) {
        super(i5);
    }

    public SlideNoPropagation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
