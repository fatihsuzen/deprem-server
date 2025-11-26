package com.uptodown.activities;

import D2.n;
import O1.C0736a0;
import O1.C0745b0;
import S1.k;
import W2.C2223l;
import W2.m;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.A;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import h2.S;
import h2.T;
import java.util.ArrayList;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.P;

public final class Gallery extends C1598a {

    /* renamed from: N  reason: collision with root package name */
    public static final a f13756N = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f13757K = m.b(new C0736a0(this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public ArrayList f13758L;

    /* renamed from: M  reason: collision with root package name */
    private final d f13759M = new d(this);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private final class b extends PagerAdapter {

        public static final class a implements A {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ T f13761a;

            a(T t5) {
                this.f13761a = t5;
            }

            public void a(Exception exc, Drawable drawable) {
                t.e(exc, "e");
                this.f13761a.f22638c.setVisibility(8);
            }

            public void b(Drawable drawable) {
            }

            public void c(Bitmap bitmap, s.e eVar) {
                t.e(bitmap, "bitmap");
                t.e(eVar, TypedValues.TransitionType.S_FROM);
                this.f13761a.f22637b.setImage(ImageSource.bitmap(bitmap));
                this.f13761a.f22638c.setVisibility(8);
            }
        }

        public b() {
        }

        /* access modifiers changed from: private */
        public static final void b(Gallery gallery, View view) {
            if (!UptodownApp.f13477F.Z()) {
                return;
            }
            if (gallery.l3().f22627c.getVisibility() == 0) {
                n nVar = new n(gallery);
                RelativeLayout relativeLayout = gallery.l3().f22627c;
                t.d(relativeLayout, "toolbarGallery");
                nVar.i(relativeLayout, R.anim.slide_to_top_toolbar);
                return;
            }
            n nVar2 = new n(gallery);
            RelativeLayout relativeLayout2 = gallery.l3().f22627c;
            t.d(relativeLayout2, "toolbarGallery");
            nVar2.h(relativeLayout2, R.anim.slide_in_top_toolbar);
        }

        public void destroyItem(ViewGroup viewGroup, int i5, Object obj) {
            t.e(viewGroup, "container");
            t.e(obj, "item");
            viewGroup.removeView((RelativeLayout) obj);
        }

        public int getCount() {
            if (Gallery.this.f13758L == null) {
                return 0;
            }
            ArrayList i32 = Gallery.this.f13758L;
            t.b(i32);
            return i32.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i5) {
            t.e(viewGroup, "container");
            T c5 = T.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            t.d(c5, "inflate(...)");
            c5.f22638c.setVisibility(0);
            a aVar = new a(c5);
            c5.f22637b.setTag(aVar);
            s h5 = s.h();
            ArrayList i32 = Gallery.this.f13758L;
            t.b(i32);
            h5.l(((P) i32.get(i5)).e()).l(R.drawable.shape_bg_placeholder).k(aVar);
            viewGroup.addView(c5.getRoot());
            c5.f22637b.setOnClickListener(new C1608k(Gallery.this));
            RelativeLayout b5 = c5.getRoot();
            t.d(b5, "getRoot(...)");
            return b5;
        }

        public boolean isViewFromObject(View view, Object obj) {
            t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            t.e(obj, "object");
            return view == obj;
        }
    }

    public static final class c implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Gallery f13762a;

        c(Gallery gallery) {
            this.f13762a = gallery;
        }

        public void onPageScrollStateChanged(int i5) {
        }

        public void onPageScrolled(int i5, float f5, int i6) {
        }

        public void onPageSelected(int i5) {
            this.f13762a.o3(i5);
        }
    }

    public static final class d extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Gallery f13763a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Gallery gallery) {
            super(true);
            this.f13763a = gallery;
        }

        public void handleOnBackPressed() {
            this.f13763a.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final S k3(Gallery gallery) {
        return S.c(gallery.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final S l3() {
        return (S) this.f13757K.getValue();
    }

    private final void m3(int i5) {
        l3().f22629e.setAdapter(new b());
        if (i5 > 0) {
            l3().f22629e.setCurrentItem(i5);
        }
        l3().f22629e.addOnPageChangeListener(new c(this));
        o3(i5);
        l3().f22628d.setTypeface(k.f32g.w());
        l3().f22626b.setOnClickListener(new C0745b0(this));
    }

    /* access modifiers changed from: private */
    public static final void n3(Gallery gallery, View view) {
        gallery.f13759M.handleOnBackPressed();
    }

    /* access modifiers changed from: private */
    public final void o3(int i5) {
        Integer num;
        TextView textView = l3().f22628d;
        Integer valueOf = Integer.valueOf(i5 + 1);
        ArrayList arrayList = this.f13758L;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        textView.setText(getString(R.string.gallery_item_count, new Object[]{valueOf, num}));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i5;
        Bundle bundleExtra;
        ArrayList arrayList;
        super.onCreate(bundle);
        setContentView((View) l3().getRoot());
        getOnBackPressedDispatcher().addCallback(this, this.f13759M);
        Intent intent = getIntent();
        if (!(intent == null || (bundleExtra = intent.getBundleExtra("bundle")) == null)) {
            if (bundleExtra.containsKey("images")) {
                if (Build.VERSION.SDK_INT >= 33) {
                    arrayList = bundleExtra.getParcelableArrayList("images", P.class);
                } else {
                    arrayList = bundleExtra.getParcelableArrayList("images");
                }
                this.f13758L = arrayList;
            }
            if (bundleExtra.containsKey("index")) {
                i5 = bundleExtra.getInt("index");
                m3(i5);
            }
        }
        i5 = 0;
        m3(i5);
    }
}
