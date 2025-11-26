package n;

import E1.b;
import E1.c;
import E1.f;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;

public abstract class a extends BottomSheetDialogFragment {
    public final void f() {
        FragmentActivity activity;
        if (isAdded() && (activity = getActivity()) != null) {
            activity.isFinishing();
            if ((!true) && isResumed()) {
                dismiss();
            }
        }
    }

    public abstract void g(ViewStub viewStub);

    public final void onCancel(DialogInterface dialogInterface) {
        t.e(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, f.SheetDialog);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.base_bottom_sheet, viewGroup, false);
        t.d(inflate, "inflater.inflate(R.layou…_sheet, container, false)");
        ViewStub viewStub = (ViewStub) inflate.findViewById(b.container_vs);
        if (viewStub == null) {
            return inflate;
        }
        g(viewStub);
        return inflate;
    }

    public final void onResume() {
        View view;
        Resources resources;
        DisplayMetrics displayMetrics;
        super.onResume();
        View view2 = getView();
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
            if (view != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(view);
                t.d(from, "from(parentView)");
                Context context = getContext();
                if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                    int i5 = displayMetrics.heightPixels;
                    from.setPeekHeight(i5);
                    ViewStub viewStub = (ViewStub) view.findViewById(b.container_vs);
                    if (viewStub != null) {
                        viewStub.inflate().setMinimumHeight((int) (((double) i5) * 0.25d));
                    }
                }
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        ViewStub viewStub = (ViewStub) view.findViewById(b.container_vs);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(b.container_fl);
        ImageView imageView = (ImageView) view.findViewById(b.img_view);
    }
}
