package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
public final class MaterialSharedAxis extends MaterialVisibility<VisibilityAnimatorProvider> {
    @AttrRes
    private static final int DEFAULT_THEMED_DURATION_ATTR = R.attr.motionDurationLong1;
    @AttrRes
    private static final int DEFAULT_THEMED_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: X  reason: collision with root package name */
    public static final int f7142X = 0;

    /* renamed from: Y  reason: collision with root package name */
    public static final int f7143Y = 1;

    /* renamed from: Z  reason: collision with root package name */
    public static final int f7144Z = 2;
    private final int axis;
    private final boolean forward;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public MaterialSharedAxis(int i5, boolean z4) {
        super(createPrimaryAnimatorProvider(i5, z4), createSecondaryAnimatorProvider());
        this.axis = i5;
        this.forward = z4;
    }

    private static VisibilityAnimatorProvider createPrimaryAnimatorProvider(int i5, boolean z4) {
        int i6;
        int i7;
        if (i5 == 0) {
            if (z4) {
                i6 = GravityCompat.END;
            } else {
                i6 = GravityCompat.START;
            }
            return new SlideDistanceProvider(i6);
        } else if (i5 == 1) {
            if (z4) {
                i7 = 80;
            } else {
                i7 = 48;
            }
            return new SlideDistanceProvider(i7);
        } else if (i5 == 2) {
            return new ScaleProvider(z4);
        } else {
            throw new IllegalArgumentException("Invalid axis: " + i5);
        }
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        return new FadeThroughProvider();
    }

    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.addAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    public int getAxis() {
        return this.axis;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int getDurationThemeAttrResId(boolean z4) {
        return DEFAULT_THEMED_DURATION_ATTR;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int getEasingThemeAttrResId(boolean z4) {
        return DEFAULT_THEMED_EASING_ATTR;
    }

    @NonNull
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isForward() {
        return this.forward;
    }

    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return super.removeAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }
}
