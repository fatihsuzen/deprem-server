package u2;

import S1.k;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.squareup.picasso.s;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import l2.C2657f;
import s2.C2746c;

public final class d extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private int f25970a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f25971b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f25972c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f25973d = -1;

    public static final class a extends ImageCardView {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f25974a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar, Context context) {
            super(context);
            this.f25974a = dVar;
        }

        public void setSelected(boolean z4) {
            this.f25974a.b(this, z4);
            super.setSelected(z4);
        }
    }

    /* access modifiers changed from: private */
    public final void b(ImageCardView imageCardView, boolean z4) {
        int i5;
        int i6;
        if (z4) {
            i5 = this.f25970a;
        } else {
            i5 = this.f25971b;
        }
        if (z4) {
            i6 = this.f25973d;
        } else {
            i6 = this.f25972c;
        }
        imageCardView.setBackgroundColor(i5);
        View findViewById = imageCardView.findViewById(R.id.info_field);
        if (findViewById != null) {
            findViewById.setBackgroundColor(i5);
        }
        TextView textView = (TextView) imageCardView.findViewById(R.id.title_text);
        if (textView != null) {
            textView.setTextColor(i6);
        }
        TextView textView2 = (TextView) imageCardView.findViewById(R.id.content_text);
        if (textView2 != null) {
            textView2.setTextColor(i6);
        }
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        t.e(obj, "item");
        View view = viewHolder.view;
        t.c(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
        ImageCardView imageCardView = (ImageCardView) view;
        if (obj instanceof C2657f) {
            C2657f fVar = (C2657f) obj;
            imageCardView.setTitleText(fVar.N());
            imageCardView.setContentText(fVar.o0());
            TextView textView = (TextView) imageCardView.findViewById(R.id.title_text);
            if (textView != null) {
                textView.setVisibility(0);
                textView.setTextColor(this.f25972c);
                textView.setTypeface(k.f32g.w());
            }
            TextView textView2 = (TextView) imageCardView.findViewById(R.id.content_text);
            if (textView2 != null) {
                textView2.setVisibility(0);
                textView2.setTextColor(this.f25972c);
                textView2.setTypeface(k.f32g.x());
                textView2.setMaxLines(2);
                textView2.setLines(2);
            }
            Resources resources = imageCardView.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.tv_card_height);
            imageCardView.setMainImageDimensions(dimensionPixelSize, resources.getDimensionPixelSize(R.dimen.tv_card_height));
            s.h().l(fVar.F(dimensionPixelSize)).l(R.drawable.shape_bg_placeholder).i(imageCardView.getMainImageView());
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.margin_m);
            imageCardView.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        } else if (obj instanceof C2746c) {
            Resources resources2 = imageCardView.getResources();
            imageCardView.setMainImageDimensions(resources2.getDimensionPixelSize(R.dimen.tv_card_height) / 2, resources2.getDimensionPixelSize(R.dimen.tv_card_height) / 2);
            int dimensionPixelSize3 = resources2.getDimensionPixelSize(R.dimen.margin_m) * 5;
            imageCardView.setPadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
            imageCardView.setMainImage(ContextCompat.getDrawable(imageCardView.getContext(), R.drawable.vector_plus));
            TextView textView3 = (TextView) imageCardView.findViewById(R.id.title_text);
            if (textView3 != null) {
                textView3.setVisibility(8);
                textView3.setText("");
            }
            TextView textView4 = (TextView) imageCardView.findViewById(R.id.content_text);
            if (textView4 != null) {
                textView4.setVisibility(8);
                textView4.setText("");
            }
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "parent");
        if (viewGroup.getContext() == null) {
            return null;
        }
        this.f25971b = ContextCompat.getColor(viewGroup.getContext(), R.color.background_color);
        this.f25970a = ContextCompat.getColor(viewGroup.getContext(), R.color.background_color);
        this.f25972c = ContextCompat.getColor(viewGroup.getContext(), R.color.text_secundary);
        this.f25973d = ContextCompat.getColor(viewGroup.getContext(), R.color.text_primary);
        a aVar = new a(this, viewGroup.getContext());
        aVar.setFocusable(true);
        aVar.setFocusableInTouchMode(true);
        b(aVar, false);
        return new Presenter.ViewHolder(aVar);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        t.e(viewHolder, "viewHolder");
        View view = viewHolder.view;
        t.c(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
        ImageCardView imageCardView = (ImageCardView) view;
        imageCardView.setBadgeImage((Drawable) null);
        imageCardView.setMainImage((Drawable) null);
    }
}
