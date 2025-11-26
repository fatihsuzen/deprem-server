package u2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import l2.C2655d;
import z2.P;

public final class l extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private int f25981a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f25982b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f25983c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f25984d = -1;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f25985e;

    public static final class a extends ImageCardView {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f25986a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(l lVar, Context context) {
            super(context);
            this.f25986a = lVar;
        }

        public void setSelected(boolean z4) {
            this.f25986a.b(this, z4);
            super.setSelected(z4);
        }
    }

    /* access modifiers changed from: private */
    public final void b(ImageCardView imageCardView, boolean z4) {
        int i5;
        int i6;
        if (z4) {
            i5 = this.f25981a;
        } else {
            i5 = this.f25982b;
        }
        if (z4) {
            i6 = this.f25984d;
        } else {
            i6 = this.f25983c;
        }
        imageCardView.setBackgroundColor(i5);
        imageCardView.findViewById(R.id.info_field).setBackgroundColor(i5);
        View findViewById = imageCardView.findViewById(R.id.title_text);
        t.c(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(i6);
        View findViewById2 = imageCardView.findViewById(R.id.content_text);
        t.c(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(i6);
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        t.e(obj, "item");
        View view = viewHolder.view;
        t.c(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
        ImageCardView imageCardView = (ImageCardView) view;
        if (obj instanceof C2655d) {
            C2655d dVar = (C2655d) obj;
            imageCardView.setTitleText(dVar.m());
            Context context = imageCardView.getContext();
            t.d(context, "getContext(...)");
            imageCardView.setContentText(dVar.u(context));
            P p5 = P.f26510a;
            Context context2 = viewHolder.view.getContext();
            t.d(context2, "getContext(...)");
            String o5 = dVar.o();
            t.b(o5);
            Drawable j5 = p5.j(context2, o5);
            Resources resources = imageCardView.getResources();
            imageCardView.setMainImageDimensions(resources.getDimensionPixelSize(R.dimen.tv_card_height), resources.getDimensionPixelSize(R.dimen.tv_card_height));
            if (j5 != null) {
                imageCardView.setMainImage(j5);
            } else {
                imageCardView.setMainImage(this.f25985e);
            }
            imageCardView.setPadding(18, 18, 18, 18);
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "parent");
        this.f25982b = ContextCompat.getColor(viewGroup.getContext(), R.color.background_color);
        this.f25981a = ContextCompat.getColor(viewGroup.getContext(), R.color.background_color);
        this.f25983c = ContextCompat.getColor(viewGroup.getContext(), R.color.text_primary);
        this.f25984d = ContextCompat.getColor(viewGroup.getContext(), R.color.text_secundary);
        this.f25985e = ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.vector_uptodown_logo_disabled);
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
