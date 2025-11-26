package androidx.leanback.widget;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.RowPresenter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class InvisibleRowPresenter extends RowPresenter {
    public InvisibleRowPresenter() {
        setHeaderPresenter((RowHeaderPresenter) null);
    }

    /* access modifiers changed from: protected */
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(0, 0));
        return new RowPresenter.ViewHolder(relativeLayout);
    }
}
