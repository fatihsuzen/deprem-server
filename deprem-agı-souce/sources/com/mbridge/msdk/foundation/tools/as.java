package com.mbridge.msdk.foundation.tools;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public final class as {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f9669a = false;

    private static int a(View view, ViewGroup viewGroup) {
        int i5 = 0;
        while (i5 < viewGroup.getChildCount() && viewGroup.getChildAt(i5) != view) {
            i5++;
        }
        return i5;
    }

    private static boolean a(View view, View view2, int i5) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        view2.getGlobalVisibleRect(rect2);
        if (Rect.intersects(rect, rect2)) {
            int min = Math.min(rect.right, rect2.right) - Math.max(rect.left, rect2.left);
            int min2 = Math.min(rect.bottom, rect2.bottom) - Math.max(rect.top, rect2.top);
            if ((i5 == 1 || min * min2 * 2 < view.getMeasuredHeight() * view.getMeasuredWidth()) && (i5 != 1 || min * min2 < view.getMeasuredHeight() * view.getMeasuredWidth())) {
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean a(View view, ViewGroup viewGroup, int i5) {
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            af.b("ViewUtils", "View Judge : Start Loop");
            View childAt = viewGroup.getChildAt(i6);
            if (childAt.getVisibility() == 0 && a(view, childAt, i5)) {
                if ((childAt instanceof WebView) && childAt.getVisibility() == 0) {
                    af.b("ViewUtils", "View Judge : View Covered by WebView.");
                    f9669a = true;
                }
                if (a(childAt)) {
                    af.b("ViewUtils", "View Judge : View Covered and Cover ViewGroup is not transparent.");
                    f9669a = true;
                }
                if (f9669a) {
                    break;
                } else if (childAt instanceof ViewGroup) {
                    a(view, (ViewGroup) childAt, i5);
                }
            }
        }
        return f9669a;
    }

    public static boolean a(View view, int i5) {
        if (view == null) {
            return true;
        }
        if (view.getVisibility() != 0) {
            af.b("ViewUtils", "Banner Judge : Banner's not visible.");
            return true;
        }
        float f5 = 0.5f;
        if (view.getAlpha() < 0.5f) {
            af.b("ViewUtils", "Banner Judge : Banner's alpha must set up 50%.");
            return true;
        } else if (view.getParent() == null || !(view.getParent() instanceof ViewGroup) || ((ViewGroup) view.getParent()).getVisibility() == 0) {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            if (i5 == 1) {
                f5 = 0.0f;
            }
            boolean z4 = ((float) ((rect.bottom - rect.top) * (rect.right - rect.left))) > ((float) (view.getMeasuredHeight() * view.getMeasuredWidth())) * f5;
            boolean z5 = globalVisibleRect && z4;
            af.b("ViewUtils", "View Judge : partVisible is " + globalVisibleRect + " halfPercentVisible is " + z4);
            StringBuilder sb = new StringBuilder();
            sb.append("View Judge : totalViewVisible is ");
            sb.append(z5);
            af.b("ViewUtils", sb.toString());
            if (!z5) {
                return true;
            }
            ViewGroup viewGroup = view;
            while (viewGroup.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                for (int a5 = a(viewGroup, viewGroup2) + 1; a5 < viewGroup2.getChildCount(); a5++) {
                    View childAt = viewGroup2.getChildAt(a5);
                    if (childAt.getVisibility() == 0 && a(view, childAt, i5)) {
                        if (childAt instanceof ViewGroup) {
                            ViewGroup viewGroup3 = (ViewGroup) childAt;
                            if (viewGroup3.getChildCount() > 0) {
                                af.b("ViewUtils", "View Judge : Covered by ViewGroup.");
                                boolean a6 = a(view, viewGroup3, i5);
                                f9669a = false;
                                if (a6) {
                                    return true;
                                }
                            }
                        }
                        if (a(childAt)) {
                            af.b("ViewUtils", "View Judge : View Covered and Cover View is not transparent.");
                            return true;
                        }
                    }
                }
                viewGroup = viewGroup2;
            }
            af.b("ViewUtils", "View Judge : Well done, View is not covered.");
            return false;
        } else {
            af.b("ViewUtils", "View Judge : View's container is not visible.");
            return true;
        }
    }

    private static boolean a(View view) {
        if ((view == null || !(view.getTag() instanceof String) || !"mb_wm".equals(view.getTag())) && view.getBackground() != null && view.getBackground().getAlpha() > 127 && view.getAlpha() > 0.5f) {
            return true;
        }
        return false;
    }
}
