package u2;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.leanback.widget.DetailsOverviewLogoPresenter;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.t;

/* renamed from: u2.c  reason: case insensitive filesystem */
public final class C2794c extends DetailsOverviewLogoPresenter {

    /* renamed from: u2.c$a */
    public static final class a extends DetailsOverviewLogoPresenter.ViewHolder {
        public a(View view) {
            super(view);
        }

        public FullWidthDetailsOverviewRowPresenter getParentPresenter() {
            FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter = this.mParentPresenter;
            t.d(fullWidthDetailsOverviewRowPresenter, "mParentPresenter");
            return fullWidthDetailsOverviewRowPresenter;
        }

        public FullWidthDetailsOverviewRowPresenter.ViewHolder getParentViewHolder() {
            FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = this.mParentViewHolder;
            t.d(viewHolder, "mParentViewHolder");
            return viewHolder;
        }
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        t.e(obj, "item");
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        View view = viewHolder.view;
        t.c(view, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) view).setImageDrawable(detailsOverviewRow.getImageDrawable());
        a aVar = (a) viewHolder;
        if (isBoundToImage(aVar, detailsOverviewRow)) {
            aVar.getParentPresenter().notifyOnBindLogo(aVar.getParentViewHolder());
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lb_fullwidth_details_overview_logo, viewGroup, false);
        t.c(inflate, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) inflate;
        Resources resources = viewGroup.getResources();
        imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(resources.getDimensionPixelSize(R.dimen.tv_detail_thumb_width), resources.getDimensionPixelSize(R.dimen.tv_detail_thumb_height)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new a(imageView);
    }
}
