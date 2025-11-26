package androidx.leanback.preference;

import android.annotation.SuppressLint;
import android.app.Fragment;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import androidx.leanback.transition.FadeAndShortSlide;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class LeanbackPreferenceFragmentTransitionHelperApi21 {
    private LeanbackPreferenceFragmentTransitionHelperApi21() {
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void addTransitions(Fragment fragment) {
        FadeAndShortSlide fadeAndShortSlide = new FadeAndShortSlide(GravityCompat.START);
        FadeAndShortSlide fadeAndShortSlide2 = new FadeAndShortSlide(GravityCompat.END);
        fragment.setEnterTransition(fadeAndShortSlide2);
        fragment.setExitTransition(fadeAndShortSlide);
        fragment.setReenterTransition(fadeAndShortSlide);
        fragment.setReturnTransition(fadeAndShortSlide2);
    }

    static void addTransitions(androidx.fragment.app.Fragment fragment) {
        FadeAndShortSlide fadeAndShortSlide = new FadeAndShortSlide(GravityCompat.START);
        FadeAndShortSlide fadeAndShortSlide2 = new FadeAndShortSlide(GravityCompat.END);
        fragment.setEnterTransition(fadeAndShortSlide2);
        fragment.setExitTransition(fadeAndShortSlide);
        fragment.setReenterTransition(fadeAndShortSlide);
        fragment.setReturnTransition(fadeAndShortSlide2);
    }
}
