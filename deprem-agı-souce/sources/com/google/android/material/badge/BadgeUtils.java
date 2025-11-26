package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;

@ExperimentalBadgeUtils
public class BadgeUtils {
    private static final String LOG_TAG = "BadgeUtils";

    private BadgeUtils() {
    }

    /* access modifiers changed from: private */
    public static void attachBadgeContentDescription(@NonNull final BadgeDrawable badgeDrawable, @NonNull final View view) {
        if (Build.VERSION.SDK_INT < 29 || !ViewCompat.hasAccessibilityDelegate(view)) {
            ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() {
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setContentDescription(BadgeUtils.getBadgeAnchorContentDescription(view, badgeDrawable));
                }
            });
        } else {
            ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat(view.getAccessibilityDelegate()) {
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setContentDescription(BadgeUtils.getBadgeAnchorContentDescription(view, badgeDrawable));
                }
            });
        }
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull View view) {
        attachBadgeDrawable(badgeDrawable, view, (FrameLayout) null);
    }

    @NonNull
    public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context context, @NonNull ParcelableSparseArray parcelableSparseArray) {
        BadgeDrawable badgeDrawable;
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i5 = 0; i5 < parcelableSparseArray.size(); i5++) {
            int keyAt = parcelableSparseArray.keyAt(i5);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i5);
            if (state != null) {
                badgeDrawable = BadgeDrawable.createFromSavedState(context, state);
            } else {
                badgeDrawable = null;
            }
            sparseArray.put(keyAt, badgeDrawable);
        }
        return sparseArray;
    }

    @NonNull
    public static ParcelableSparseArray createParcelableBadgeStates(@NonNull SparseArray<BadgeDrawable> sparseArray) {
        BadgeState.State state;
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i5 = 0; i5 < sparseArray.size(); i5++) {
            int keyAt = sparseArray.keyAt(i5);
            BadgeDrawable valueAt = sparseArray.valueAt(i5);
            if (valueAt != null) {
                state = valueAt.getSavedState();
            } else {
                state = null;
            }
            parcelableSparseArray.put(keyAt, state);
        }
        return parcelableSparseArray;
    }

    private static void detachBadgeContentDescription(@NonNull final View view) {
        if (Build.VERSION.SDK_INT < 29 || !ViewCompat.hasAccessibilityDelegate(view)) {
            ViewCompat.setAccessibilityDelegate(view, (AccessibilityDelegateCompat) null);
        } else {
            ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat(view.getAccessibilityDelegate()) {
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setContentDescription(view.getContentDescription());
                }
            });
        }
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable badgeDrawable, @NonNull View view) {
        if (badgeDrawable != null) {
            if (badgeDrawable.getCustomBadgeParent() != null) {
                badgeDrawable.getCustomBadgeParent().setForeground((Drawable) null);
            } else {
                view.getOverlay().remove(badgeDrawable);
            }
        }
    }

    /* access modifiers changed from: private */
    public static CharSequence getBadgeAnchorContentDescription(View view, BadgeDrawable badgeDrawable) {
        CharSequence contentDescription = badgeDrawable.getContentDescription();
        if (contentDescription != null) {
            return contentDescription;
        }
        return view.getContentDescription();
    }

    @VisibleForTesting
    static void removeToolbarOffset(BadgeDrawable badgeDrawable) {
        badgeDrawable.setAdditionalHorizontalOffset(0);
        badgeDrawable.setAdditionalVerticalOffset(0);
    }

    public static void setBadgeDrawableBounds(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.updateBadgeCoordinates(view, frameLayout);
    }

    @VisibleForTesting
    static void setToolbarOffset(BadgeDrawable badgeDrawable, Resources resources) {
        badgeDrawable.setAdditionalHorizontalOffset(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        badgeDrawable.setAdditionalVerticalOffset(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    public static void updateBadgeBounds(@NonNull Rect rect, float f5, float f6, float f7, float f8) {
        rect.set((int) (f5 - f7), (int) (f6 - f8), (int) (f5 + f7), (int) (f6 + f8));
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        setBadgeDrawableBounds(badgeDrawable, view, frameLayout);
        if (badgeDrawable.getCustomBadgeParent() != null) {
            badgeDrawable.getCustomBadgeParent().setForeground(badgeDrawable);
        } else {
            view.getOverlay().add(badgeDrawable);
        }
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i5) {
        if (badgeDrawable != null) {
            ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(toolbar, i5);
            if (actionMenuItemView != null) {
                removeToolbarOffset(badgeDrawable);
                detachBadgeDrawable(badgeDrawable, actionMenuItemView);
                detachBadgeContentDescription(actionMenuItemView);
                return;
            }
            Log.w(LOG_TAG, "Trying to remove badge from a null menuItemView: " + i5);
        }
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable badgeDrawable, @NonNull Toolbar toolbar, @IdRes int i5) {
        attachBadgeDrawable(badgeDrawable, toolbar, i5, (FrameLayout) null);
    }

    public static void attachBadgeDrawable(@NonNull final BadgeDrawable badgeDrawable, @NonNull final Toolbar toolbar, @IdRes final int i5, @Nullable final FrameLayout frameLayout) {
        toolbar.post(new Runnable() {
            public void run() {
                ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(Toolbar.this, i5);
                if (actionMenuItemView != null) {
                    BadgeUtils.setToolbarOffset(badgeDrawable, Toolbar.this.getResources());
                    BadgeUtils.attachBadgeDrawable(badgeDrawable, (View) actionMenuItemView, frameLayout);
                    BadgeUtils.attachBadgeContentDescription(badgeDrawable, actionMenuItemView);
                }
            }
        });
    }
}
