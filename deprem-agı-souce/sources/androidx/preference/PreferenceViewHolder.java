package androidx.preference;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PreferenceViewHolder extends RecyclerView.ViewHolder {
    @Nullable
    private final Drawable mBackground;
    private final SparseArray<View> mCachedViews;
    private boolean mDividerAllowedAbove;
    private boolean mDividerAllowedBelow;
    private ColorStateList mTitleTextColors;

    PreferenceViewHolder(@NonNull View view) {
        super(view);
        SparseArray<View> sparseArray = new SparseArray<>(4);
        this.mCachedViews = sparseArray;
        TextView textView = (TextView) view.findViewById(16908310);
        sparseArray.put(16908310, textView);
        sparseArray.put(16908304, view.findViewById(16908304));
        sparseArray.put(16908294, view.findViewById(16908294));
        int i5 = R.id.icon_frame;
        sparseArray.put(i5, view.findViewById(i5));
        sparseArray.put(AndroidResources.ANDROID_R_ICON_FRAME, view.findViewById(AndroidResources.ANDROID_R_ICON_FRAME));
        this.mBackground = view.getBackground();
        if (textView != null) {
            this.mTitleTextColors = textView.getTextColors();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static PreferenceViewHolder createInstanceForTests(@NonNull View view) {
        return new PreferenceViewHolder(view);
    }

    public View findViewById(@IdRes int i5) {
        View view = this.mCachedViews.get(i5);
        if (view != null) {
            return view;
        }
        View findViewById = this.itemView.findViewById(i5);
        if (findViewById != null) {
            this.mCachedViews.put(i5, findViewById);
        }
        return findViewById;
    }

    public boolean isDividerAllowedAbove() {
        return this.mDividerAllowedAbove;
    }

    public boolean isDividerAllowedBelow() {
        return this.mDividerAllowedBelow;
    }

    /* access modifiers changed from: package-private */
    public void resetState() {
        Drawable background = this.itemView.getBackground();
        Drawable drawable = this.mBackground;
        if (background != drawable) {
            ViewCompat.setBackground(this.itemView, drawable);
        }
        TextView textView = (TextView) findViewById(16908310);
        if (textView != null && this.mTitleTextColors != null && !textView.getTextColors().equals(this.mTitleTextColors)) {
            textView.setTextColor(this.mTitleTextColors);
        }
    }

    public void setDividerAllowedAbove(boolean z4) {
        this.mDividerAllowedAbove = z4;
    }

    public void setDividerAllowedBelow(boolean z4) {
        this.mDividerAllowedBelow = z4;
    }
}
