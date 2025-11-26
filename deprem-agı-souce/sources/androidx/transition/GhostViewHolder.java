package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class GhostViewHolder extends FrameLayout {
    private boolean mAttached = true;
    @NonNull
    private ViewGroup mParent;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static float getZ(View view) {
            return view.getZ();
        }
    }

    GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.mParent = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, this);
        this.mParent.getOverlay().add(this);
    }

    static GhostViewHolder getHolder(@NonNull ViewGroup viewGroup) {
        return (GhostViewHolder) viewGroup.getTag(R.id.ghost_view_holder);
    }

    private int getInsertIndex(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i5 = 0;
        while (i5 <= childCount) {
            int i6 = (i5 + childCount) / 2;
            getParents(((GhostViewPort) getChildAt(i6)).mView, arrayList2);
            if (isOnTop(arrayList, (ArrayList<View>) arrayList2)) {
                i5 = i6 + 1;
            } else {
                childCount = i6 - 1;
            }
            arrayList2.clear();
        }
        return i5;
    }

    private static void getParents(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            getParents((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean isOnTop(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i5 = 1; i5 < min; i5++) {
            View view = arrayList.get(i5);
            View view2 = arrayList2.get(i5);
            if (view != view2) {
                return isOnTop(view, view2);
            }
        }
        return arrayList2.size() == min;
    }

    /* access modifiers changed from: package-private */
    public void addGhostView(GhostViewPort ghostViewPort) {
        ArrayList arrayList = new ArrayList();
        getParents(ghostViewPort.mView, arrayList);
        int insertIndex = getInsertIndex(arrayList);
        if (insertIndex < 0 || insertIndex >= getChildCount()) {
            addView(ghostViewPort);
        } else {
            addView(ghostViewPort, insertIndex);
        }
    }

    public void onViewAdded(View view) {
        if (this.mAttached) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.mParent.setTag(R.id.ghost_view_holder, (Object) null);
            this.mParent.getOverlay().remove(this);
            this.mAttached = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void popToOverlayTop() {
        if (this.mAttached) {
            this.mParent.getOverlay().remove(this);
            this.mParent.getOverlay().add(this);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    private static boolean isOnTop(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Api21Impl.getZ(view) != Api21Impl.getZ(view2)) {
            return Api21Impl.getZ(view) > Api21Impl.getZ(view2);
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(ViewGroupUtils.getChildDrawingOrder(viewGroup, i5));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                return true;
            }
        }
        return true;
    }
}
