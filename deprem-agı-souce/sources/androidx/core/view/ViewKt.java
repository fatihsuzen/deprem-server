package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.exifinterface.media.ExifInterface;
import b3.C2308e;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.t;
import s3.C2751e;
import s3.C2754h;

public final class ViewKt {
    public static final void doOnAttach(View view, l lVar) {
        if (view.isAttachedToWindow()) {
            lVar.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnAttach$1(view, lVar));
        }
    }

    public static final void doOnDetach(View view, l lVar) {
        if (!view.isAttachedToWindow()) {
            lVar.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnDetach$1(view, lVar));
        }
    }

    public static final void doOnLayout(View view, l lVar) {
        if (!view.isLaidOut() || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(lVar));
        } else {
            lVar.invoke(view);
        }
    }

    public static final void doOnNextLayout(View view, l lVar) {
        view.addOnLayoutChangeListener(new ViewKt$doOnNextLayout$1(lVar));
    }

    public static final OneShotPreDrawListener doOnPreDraw(View view, l lVar) {
        return OneShotPreDrawListener.add(view, new ViewKt$doOnPreDraw$1(lVar, view));
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        if (view.isLaidOut()) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-((float) view.getScrollX()), -((float) view.getScrollY()));
            view.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final C2751e getAllViews(View view) {
        return C2754h.b(new ViewKt$allViews$1(view, (C2308e) null));
    }

    public static final C2751e getAncestors(View view) {
        return C2754h.f(view.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        }
        return 0;
    }

    public static final int getMarginLeft(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart();
        }
        return 0;
    }

    public static final int getMarginTop(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(View view) {
        if (view.getVisibility() == 8) {
            return true;
        }
        return false;
    }

    public static final boolean isInvisible(View view) {
        if (view.getVisibility() == 4) {
            return true;
        }
        return false;
    }

    public static final boolean isVisible(View view) {
        if (view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public static final Runnable postDelayed(View view, long j5, C2616a aVar) {
        ViewKt$postDelayed$runnable$1 viewKt$postDelayed$runnable$1 = new ViewKt$postDelayed$runnable$1(aVar);
        view.postDelayed(viewKt$postDelayed$runnable$1, j5);
        return viewKt$postDelayed$runnable$1;
    }

    public static final Runnable postOnAnimationDelayed(View view, long j5, C2616a aVar) {
        L l5 = new L(aVar);
        view.postOnAnimationDelayed(l5, j5);
        return l5;
    }

    /* access modifiers changed from: private */
    public static final void postOnAnimationDelayed$lambda$1(C2616a aVar) {
        aVar.invoke();
    }

    public static final void setGone(View view, boolean z4) {
        int i5;
        if (z4) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        view.setVisibility(i5);
    }

    public static final void setInvisible(View view, boolean z4) {
        int i5;
        if (z4) {
            i5 = 4;
        } else {
            i5 = 0;
        }
        view.setVisibility(i5);
    }

    public static final void setPadding(View view, @Px int i5) {
        view.setPadding(i5, i5, i5, i5);
    }

    public static final void setVisible(View view, boolean z4) {
        int i5;
        if (z4) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        view.setVisibility(i5);
    }

    public static final void updateLayoutParams(View view, l lVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            lVar.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, l lVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        t.k(1, ExifInterface.GPS_DIRECTION_TRUE);
        lVar.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(View view, @Px int i5, @Px int i6, @Px int i7, @Px int i8) {
        view.setPadding(i5, i6, i7, i8);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i5 = view.getPaddingLeft();
        }
        if ((i9 & 2) != 0) {
            i6 = view.getPaddingTop();
        }
        if ((i9 & 4) != 0) {
            i7 = view.getPaddingRight();
        }
        if ((i9 & 8) != 0) {
            i8 = view.getPaddingBottom();
        }
        view.setPadding(i5, i6, i7, i8);
    }

    public static final void updatePaddingRelative(View view, @Px int i5, @Px int i6, @Px int i7, @Px int i8) {
        view.setPaddingRelative(i5, i6, i7, i8);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i5 = view.getPaddingStart();
        }
        if ((i9 & 2) != 0) {
            i6 = view.getPaddingTop();
        }
        if ((i9 & 4) != 0) {
            i7 = view.getPaddingEnd();
        }
        if ((i9 & 8) != 0) {
            i8 = view.getPaddingBottom();
        }
        view.setPaddingRelative(i5, i6, i7, i8);
    }
}
