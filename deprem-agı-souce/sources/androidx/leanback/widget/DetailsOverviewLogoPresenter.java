package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.leanback.R;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.Presenter;

public class DetailsOverviewLogoPresenter extends Presenter {

    public static class ViewHolder extends Presenter.ViewHolder {
        protected FullWidthDetailsOverviewRowPresenter mParentPresenter;
        protected FullWidthDetailsOverviewRowPresenter.ViewHolder mParentViewHolder;
        private boolean mSizeFromDrawableIntrinsic;

        public ViewHolder(View view) {
            super(view);
        }

        public FullWidthDetailsOverviewRowPresenter getParentPresenter() {
            return this.mParentPresenter;
        }

        public FullWidthDetailsOverviewRowPresenter.ViewHolder getParentViewHolder() {
            return this.mParentViewHolder;
        }

        public boolean isSizeFromDrawableIntrinsic() {
            return this.mSizeFromDrawableIntrinsic;
        }

        public void setSizeFromDrawableIntrinsic(boolean z4) {
            this.mSizeFromDrawableIntrinsic = z4;
        }
    }

    public boolean isBoundToImage(ViewHolder viewHolder, DetailsOverviewRow detailsOverviewRow) {
        if (detailsOverviewRow == null || detailsOverviewRow.getImageDrawable() == null) {
            return false;
        }
        return true;
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        float f5;
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        ImageView imageView = (ImageView) viewHolder.view;
        imageView.setImageDrawable(detailsOverviewRow.getImageDrawable());
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (isBoundToImage(viewHolder2, detailsOverviewRow)) {
            if (viewHolder2.isSizeFromDrawableIntrinsic()) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = detailsOverviewRow.getImageDrawable().getIntrinsicWidth();
                layoutParams.height = detailsOverviewRow.getImageDrawable().getIntrinsicHeight();
                if (imageView.getMaxWidth() > 0 || imageView.getMaxHeight() > 0) {
                    float f6 = 1.0f;
                    if (imageView.getMaxWidth() <= 0 || layoutParams.width <= imageView.getMaxWidth()) {
                        f5 = 1.0f;
                    } else {
                        f5 = ((float) imageView.getMaxWidth()) / ((float) layoutParams.width);
                    }
                    if (imageView.getMaxHeight() > 0 && layoutParams.height > imageView.getMaxHeight()) {
                        f6 = ((float) imageView.getMaxHeight()) / ((float) layoutParams.height);
                    }
                    float min = Math.min(f5, f6);
                    layoutParams.width = (int) (((float) layoutParams.width) * min);
                    layoutParams.height = (int) (((float) layoutParams.height) * min);
                }
                imageView.setLayoutParams(layoutParams);
            }
            viewHolder2.mParentPresenter.notifyOnBindLogo(viewHolder2.mParentViewHolder);
        }
    }

    public View onCreateView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lb_fullwidth_details_overview_logo, viewGroup, false);
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        boolean z4;
        View onCreateView = onCreateView(viewGroup);
        ViewHolder viewHolder = new ViewHolder(onCreateView);
        ViewGroup.LayoutParams layoutParams = onCreateView.getLayoutParams();
        if (layoutParams.width == -2 && layoutParams.height == -2) {
            z4 = true;
        } else {
            z4 = false;
        }
        viewHolder.setSizeFromDrawableIntrinsic(z4);
        return viewHolder;
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
    }

    public void setContext(ViewHolder viewHolder, FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder2, FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter) {
        viewHolder.mParentViewHolder = viewHolder2;
        viewHolder.mParentPresenter = fullWidthDetailsOverviewRowPresenter;
    }
}
