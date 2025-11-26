package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class FragmentContainerView extends FrameLayout {
    private View.OnApplyWindowInsetsListener applyWindowInsetsListener;
    private final List<View> disappearingFragmentChildren;
    private boolean drawDisappearingViewsFirst;
    private final List<View> transitioningFragmentViews;

    @RequiresApi(20)
    public static final class Api20Impl {
        public static final Api20Impl INSTANCE = new Api20Impl();

        private Api20Impl() {
        }

        public final WindowInsets onApplyWindowInsets(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
            t.e(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            t.e(view, "v");
            t.e(windowInsets, "insets");
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            t.d(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return onApplyWindowInsets;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (C2633k) null);
        t.e(context, "context");
    }

    private final void addDisappearingFragmentView(View view) {
        if (this.transitioningFragmentViews.contains(view)) {
            this.disappearingFragmentChildren.add(view);
        }
    }

    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        t.e(view, "child");
        if (FragmentManager.getViewFragment(view) != null) {
            super.addView(view, i5, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @RequiresApi(20)
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat;
        t.e(windowInsets, "insets");
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        t.d(windowInsetsCompat2, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.applyWindowInsetsListener;
        if (onApplyWindowInsetsListener != null) {
            Api20Impl api20Impl = Api20Impl.INSTANCE;
            t.b(onApplyWindowInsetsListener);
            windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(api20Impl.onApplyWindowInsets(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            windowInsetsCompat = ViewCompat.onApplyWindowInsets(this, windowInsetsCompat2);
        }
        t.d(windowInsetsCompat, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!windowInsetsCompat.isConsumed()) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewCompat.dispatchApplyWindowInsets(getChildAt(i5), windowInsetsCompat);
            }
        }
        return windowInsets;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        t.e(canvas, "canvas");
        if (this.drawDisappearingViewsFirst) {
            for (View drawChild : this.disappearingFragmentChildren) {
                super.drawChild(canvas, drawChild, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j5) {
        t.e(canvas, "canvas");
        t.e(view, "child");
        if (!this.drawDisappearingViewsFirst || this.disappearingFragmentChildren.isEmpty() || !this.disappearingFragmentChildren.contains(view)) {
            return super.drawChild(canvas, view, j5);
        }
        return false;
    }

    public void endViewTransition(View view) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        this.transitioningFragmentViews.remove(view);
        if (this.disappearingFragmentChildren.remove(view)) {
            this.drawDisappearingViewsFirst = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        return FragmentManager.findFragmentManager(this).findFragmentById(getId());
    }

    @RequiresApi(20)
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        t.e(windowInsets, "insets");
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                View childAt = getChildAt(childCount);
                t.d(childAt, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
                addDisappearingFragmentView(childAt);
            } else {
                super.removeAllViewsInLayout();
                return;
            }
        }
    }

    public void removeView(View view) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        addDisappearingFragmentView(view);
        super.removeView(view);
    }

    public void removeViewAt(int i5) {
        View childAt = getChildAt(i5);
        t.d(childAt, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        addDisappearingFragmentView(childAt);
        super.removeViewAt(i5);
    }

    public void removeViewInLayout(View view) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i5, int i6) {
        int i7 = i5 + i6;
        for (int i8 = i5; i8 < i7; i8++) {
            View childAt = getChildAt(i8);
            t.d(childAt, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            addDisappearingFragmentView(childAt);
        }
        super.removeViews(i5, i6);
    }

    public void removeViewsInLayout(int i5, int i6) {
        int i7 = i5 + i6;
        for (int i8 = i5; i8 < i7; i8++) {
            View childAt = getChildAt(i8);
            t.d(childAt, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            addDisappearingFragmentView(childAt);
        }
        super.removeViewsInLayout(i5, i6);
    }

    public final void setDrawDisappearingViewsLast(boolean z4) {
        this.drawDisappearingViewsFirst = z4;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        t.e(onApplyWindowInsetsListener, "listener");
        this.applyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    public void startViewTransition(View view) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        if (view.getParent() == this) {
            this.transitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context) {
        super(context);
        t.e(context, "context");
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i5, int i6, C2633k kVar) {
        this(context, attributeSet, (i6 & 4) != 0 ? 0 : i5);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        String str;
        t.e(context, "context");
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] iArr = R.styleable.FragmentContainerView;
            t.d(iArr, "FragmentContainerView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        super(context, attributeSet);
        String str;
        t.e(context, "context");
        t.e(attributeSet, "attrs");
        t.e(fragmentManager, "fm");
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = R.styleable.FragmentContainerView;
        t.d(iArr, "FragmentContainerView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment findFragmentById = fragmentManager.findFragmentById(id);
        if (classAttribute != null && findFragmentById == null) {
            if (id == -1) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment instantiate = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), classAttribute);
            t.d(instantiate, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            instantiate.onInflate(context, attributeSet, (Bundle) null);
            fragmentManager.beginTransaction().setReorderingAllowed(true).add((ViewGroup) this, instantiate, string).commitNowAllowingStateLoss();
        }
        fragmentManager.onContainerAvailable(this);
    }
}
