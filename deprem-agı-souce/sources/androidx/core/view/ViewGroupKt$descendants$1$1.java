package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import k3.l;
import kotlin.jvm.internal.u;
import s3.C2751e;

final class ViewGroupKt$descendants$1$1 extends u implements l {
    public static final ViewGroupKt$descendants$1$1 INSTANCE = new ViewGroupKt$descendants$1$1();

    ViewGroupKt$descendants$1$1() {
        super(1);
    }

    public final Iterator<View> invoke(View view) {
        C2751e children;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null) {
            return null;
        }
        return children.iterator();
    }
}
