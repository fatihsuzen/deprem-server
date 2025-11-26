package androidx.customview.poolingcontainer;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import kotlin.jvm.internal.t;

public final class PoolingContainer {
    private static final int IsPoolingContainerTag = R.id.is_pooling_container_tag;
    private static final int PoolingContainerListenerHolderTag = R.id.pooling_container_listener_holder_tag;

    @SuppressLint({"ExecutorRegistration"})
    public static final void addPoolingContainerListener(View view, PoolingContainerListener poolingContainerListener) {
        t.e(view, "<this>");
        t.e(poolingContainerListener, "listener");
        getPoolingContainerListenerHolder(view).addListener(poolingContainerListener);
    }

    public static final void callPoolingContainerOnRelease(View view) {
        t.e(view, "<this>");
        for (View poolingContainerListenerHolder : ViewKt.getAllViews(view)) {
            getPoolingContainerListenerHolder(poolingContainerListenerHolder).onRelease();
        }
    }

    public static final void callPoolingContainerOnReleaseForChildren(ViewGroup viewGroup) {
        t.e(viewGroup, "<this>");
        for (View poolingContainerListenerHolder : ViewGroupKt.getChildren(viewGroup)) {
            getPoolingContainerListenerHolder(poolingContainerListenerHolder).onRelease();
        }
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View view) {
        int i5 = PoolingContainerListenerHolderTag;
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(i5);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(i5, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    public static final boolean isPoolingContainer(View view) {
        Boolean bool;
        t.e(view, "<this>");
        Object tag = view.getTag(IsPoolingContainerTag);
        if (tag instanceof Boolean) {
            bool = (Boolean) tag;
        } else {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean isWithinPoolingContainer(View view) {
        t.e(view, "<this>");
        for (ViewParent viewParent : ViewKt.getAncestors(view)) {
            if ((viewParent instanceof View) && isPoolingContainer((View) viewParent)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void removePoolingContainerListener(View view, PoolingContainerListener poolingContainerListener) {
        t.e(view, "<this>");
        t.e(poolingContainerListener, "listener");
        getPoolingContainerListenerHolder(view).removeListener(poolingContainerListener);
    }

    public static final void setPoolingContainer(View view, boolean z4) {
        t.e(view, "<this>");
        view.setTag(IsPoolingContainerTag, Boolean.valueOf(z4));
    }
}
