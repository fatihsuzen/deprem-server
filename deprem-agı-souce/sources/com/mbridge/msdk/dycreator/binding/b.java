package com.mbridge.msdk.dycreator.binding;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.dycreator.baseview.MBApkInfoView;
import com.mbridge.msdk.dycreator.baseview.MBFeedBack;
import com.mbridge.msdk.dycreator.baseview.MBLogoTextView;
import com.mbridge.msdk.dycreator.baseview.MBSplashClickView;
import com.mbridge.msdk.dycreator.baseview.MBSplashImageBgView;
import com.mbridge.msdk.dycreator.baseview.MBSplashPortView;
import com.mbridge.msdk.dycreator.baseview.MBSplashShakeView;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.d.a;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.e;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.g;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.g.i;
import com.mbridge.msdk.dycreator.listener.DyCountDownListenerWrapper;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f8598a;

    /* renamed from: b  reason: collision with root package name */
    private d f8599b = ((d) a.a().a(a.C0083a.VIEW_OBSERVER));

    /* renamed from: c  reason: collision with root package name */
    private c f8600c = ((c) a.a().a(a.C0083a.CLICK_OBSERVER));

    /* renamed from: d  reason: collision with root package name */
    private f f8601d = ((f) a.a().a(a.C0083a.EFFECT_OBSERVER));

    /* renamed from: e  reason: collision with root package name */
    private h f8602e = ((h) a.a().a(a.C0083a.REPORT_OBSERVER));

    /* renamed from: f  reason: collision with root package name */
    private BaseViewModel f8603f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public com.mbridge.msdk.shake.b f8604g;

    private b() {
    }

    public final void b(final View view) {
        AnonymousClass2 r02 = new e() {
            public final void a(Object obj) {
                try {
                    View view = view;
                    if (view instanceof InterBase) {
                        b.b(b.this, (InterBase) view, obj);
                    }
                } catch (Exception e5) {
                    af.b("MBDataBinding", e5.getMessage());
                }
            }
        };
        int id = view.getId();
        f fVar = this.f8601d;
        if (fVar != null) {
            fVar.a(r02, id);
        }
    }

    public final void c(final View view) {
        AnonymousClass3 r02 = new i() {
            public final void a(Object obj) {
                try {
                    View view = view;
                    if (view instanceof InterBase) {
                        b.c(b.this, (InterBase) view, obj);
                    }
                } catch (Exception e5) {
                    af.b("MBDataBinding", e5.getMessage());
                }
            }
        };
        int id = view.getId();
        d dVar = this.f8599b;
        if (dVar != null) {
            dVar.a(r02, id);
        }
    }

    public final void d(final View view) {
        if (view != null) {
            try {
                if (view instanceof InterBase) {
                    String actionDes = ((InterBase) view).getActionDes();
                    if (TextUtils.isEmpty(actionDes)) {
                        return;
                    }
                    if (actionDes.startsWith(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                        AnonymousClass4 r02 = new com.mbridge.msdk.dycreator.g.b() {
                            public final void a(Object obj) {
                                if (obj != null) {
                                    try {
                                        if (com.mbridge.msdk.dycreator.e.d.a(view, (com.mbridge.msdk.dycreator.f.a.a) obj)) {
                                            b.a(b.this, view, obj);
                                        }
                                    } catch (Exception e5) {
                                        af.b("MBDataBinding", e5.getMessage());
                                    }
                                }
                            }
                        };
                        int id = view.getId();
                        c cVar = this.f8600c;
                        if (cVar != null) {
                            cVar.a(r02, id);
                        }
                    } else if (!actionDes.equals("move")) {
                        if (!actionDes.equals("long_click")) {
                            actionDes.equals("wobble");
                        }
                    }
                }
            } catch (Exception e5) {
                af.b("MBDataBinding", e5.getMessage());
            }
        }
    }

    public static b a() {
        if (f8598a == null) {
            synchronized (b.class) {
                try {
                    if (f8598a == null) {
                        f8598a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8598a;
    }

    static /* synthetic */ void c(b bVar, InterBase interBase, Object obj) {
        if (interBase != null && obj != null) {
            String bindDataDes = interBase.getBindDataDes();
            if (!TextUtils.isEmpty(bindDataDes)) {
                try {
                    Object a5 = com.mbridge.msdk.dycreator.e.d.a(obj, bindDataDes);
                    if (a5 != null) {
                        if (interBase instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) interBase;
                            com.mbridge.msdk.dycreator.f.a.a aVar = (com.mbridge.msdk.dycreator.f.a.a) obj;
                            if (viewGroup instanceof MBSplashClickView) {
                                if (aVar.getEffectData() != null && aVar.getEffectData().isClickButtonVisible()) {
                                    if (!aVar.getEffectData().isShakeVisible()) {
                                        if (!TextUtils.isEmpty(a5.toString())) {
                                            viewGroup.setVisibility(0);
                                            ((MBSplashClickView) viewGroup).initView(a5.toString());
                                        }
                                    }
                                }
                                viewGroup.setVisibility(8);
                            }
                            if (!(viewGroup instanceof MBSplashShakeView)) {
                                return;
                            }
                            if (aVar.getEffectData() == null || !aVar.getEffectData().isShakeVisible()) {
                                viewGroup.setVisibility(8);
                            } else if (!TextUtils.isEmpty(a5.toString())) {
                                viewGroup.setVisibility(0);
                                ((MBSplashShakeView) viewGroup).initView(a5.toString());
                            }
                        } else if (interBase instanceof View) {
                            final View view = (View) interBase;
                            final com.mbridge.msdk.dycreator.f.a.a aVar2 = (com.mbridge.msdk.dycreator.f.a.a) obj;
                            try {
                                if (view instanceof TextView) {
                                    try {
                                        ((TextView) view).setText(String.valueOf(a5).replace("\\n", "\n"));
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                } else if (view instanceof ImageView) {
                                    if (a5 instanceof Integer) {
                                        ((ImageView) view).setImageResource(((Integer) a5).intValue());
                                    }
                                    if (a5 instanceof String) {
                                        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(a5.toString(), new com.mbridge.msdk.foundation.same.c.c() {
                                            public final void onFailedLoad(String str, String str2) {
                                                View view = view;
                                                if (view != null) {
                                                    ((ImageView) view).setBackgroundColor(-7829368);
                                                }
                                            }

                                            public final void onSuccessLoad(Bitmap bitmap, String str) {
                                                boolean z4;
                                                int i5;
                                                if (bitmap != null) {
                                                    try {
                                                        if (!bitmap.isRecycled()) {
                                                            if (bitmap.getWidth() > bitmap.getHeight()) {
                                                                z4 = true;
                                                            } else {
                                                                z4 = false;
                                                            }
                                                            if (aVar2.getEffectData().getOrientation() == 1) {
                                                                i5 = view.getResources().getConfiguration().orientation;
                                                            } else {
                                                                i5 = aVar2.getEffectData().getOrientation();
                                                            }
                                                            if (i5 == 1) {
                                                                if (z4) {
                                                                    View view = view;
                                                                    if (view instanceof MBSplashPortView) {
                                                                        if (view.getParent() != null) {
                                                                            ((ViewGroup) view.getParent()).setVisibility(8);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    } else if (view instanceof MBSplashImageBgView) {
                                                                        view.setVisibility(0);
                                                                        Bitmap a5 = ae.a(bitmap);
                                                                        ((MBSplashImageBgView) view).setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                                        ((MBSplashImageBgView) view).setImageBitmap(a5);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    View view2 = view;
                                                                    if (view2 instanceof MBSplashPortView) {
                                                                        view2.setVisibility(0);
                                                                        ((MBSplashPortView) view).setScaleType(ImageView.ScaleType.FIT_CENTER);
                                                                        ((MBSplashPortView) view).setImageBitmap(bitmap);
                                                                        return;
                                                                    } else if (view2 instanceof MBSplashImageBgView) {
                                                                        view2.setVisibility(8);
                                                                        return;
                                                                    } else if (view2 instanceof InterBase) {
                                                                        String effectDes = ((InterBase) view2).getEffectDes();
                                                                        ViewGroup viewGroup = (ViewGroup) view.getParent();
                                                                        if (viewGroup != null) {
                                                                            com.mbridge.msdk.dycreator.e.d.a(effectDes, viewGroup, true);
                                                                        }
                                                                    }
                                                                }
                                                            } else if (z4) {
                                                                View view3 = view;
                                                                if (view3 instanceof MBSplashPortView) {
                                                                    view3.setVisibility(0);
                                                                    ((MBSplashPortView) view).setScaleType(ImageView.ScaleType.FIT_XY);
                                                                    ((ImageView) view).setImageBitmap(bitmap);
                                                                    return;
                                                                } else if (view3 instanceof MBSplashImageBgView) {
                                                                    view3.setVisibility(8);
                                                                    ((MBSplashImageBgView) view).setImageBitmap(ae.a(bitmap));
                                                                    return;
                                                                } else if (view3 instanceof InterBase) {
                                                                    String effectDes2 = ((InterBase) view3).getEffectDes();
                                                                    ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                                                                    if (viewGroup2 != null) {
                                                                        com.mbridge.msdk.dycreator.e.d.a(effectDes2, viewGroup2, true);
                                                                    }
                                                                }
                                                            } else {
                                                                View view4 = view;
                                                                if (view4 instanceof MBSplashPortView) {
                                                                    view4.setVisibility(0);
                                                                    ((MBSplashPortView) view).setImageBitmap(bitmap);
                                                                    return;
                                                                } else if (view4 instanceof MBSplashImageBgView) {
                                                                    view4.setVisibility(0);
                                                                    Bitmap a6 = ae.a(bitmap);
                                                                    ((MBSplashImageBgView) view).setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                                    ((MBSplashImageBgView) view).setImageBitmap(a6);
                                                                    return;
                                                                } else if (view4 instanceof InterBase) {
                                                                    String effectDes3 = ((InterBase) view4).getEffectDes();
                                                                    ViewGroup viewGroup3 = (ViewGroup) view.getParent();
                                                                    if (viewGroup3 != null) {
                                                                        com.mbridge.msdk.dycreator.e.d.a(effectDes3, viewGroup3, true);
                                                                    }
                                                                }
                                                            }
                                                            ((ImageView) view).setImageBitmap(bitmap);
                                                            return;
                                                        }
                                                    } catch (Exception e5) {
                                                        af.b("MBDataBinding", e5.getMessage());
                                                        return;
                                                    }
                                                }
                                                ((ImageView) view).setBackgroundColor(-7829368);
                                            }
                                        });
                                    }
                                }
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
        }
    }

    public final synchronized void b() {
        try {
            c cVar = this.f8600c;
            if (cVar != null) {
                cVar.a();
            }
            d dVar = this.f8599b;
            if (dVar != null) {
                dVar.a();
            }
            f fVar = this.f8601d;
            if (fVar != null) {
                fVar.a();
            }
            if (this.f8603f != null) {
                this.f8603f = null;
            }
            if (this.f8604g != null) {
                this.f8604g = null;
            }
            if (f8598a != null) {
                f8598a = null;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final void a(final View view) {
        AnonymousClass1 r02 = new g() {
            public final void a(Object obj) {
                try {
                    View view = view;
                    if (view instanceof InterBase) {
                        b.a(b.this, (InterBase) view, obj);
                    }
                } catch (Exception e5) {
                    af.b("MBDataBinding", e5.getMessage());
                }
            }
        };
        int id = view.getId();
        h hVar = this.f8602e;
        if (hVar != null) {
            hVar.a(r02, id);
        }
    }

    public final void a(BaseViewModel baseViewModel) {
        this.f8603f = baseViewModel;
        if (baseViewModel != null) {
            baseViewModel.setClickSubject(this.f8600c);
            this.f8603f.setConcreteSubject(this.f8599b);
            this.f8603f.setEffectSubject(this.f8601d);
            this.f8603f.setReportSubject(this.f8602e);
        }
    }

    private com.mbridge.msdk.shake.b a(View view, MBSplashData mBSplashData) {
        b bVar;
        if (mBSplashData != null) {
            try {
                DyOption dyOption = mBSplashData.getDyOption();
                if (dyOption != null && dyOption.isShakeVisible() && this.f8604g == null) {
                    bVar = this;
                    final View view2 = view;
                    final MBSplashData mBSplashData2 = mBSplashData;
                    try {
                        bVar.f8604g = new com.mbridge.msdk.shake.b(dyOption.getShakeStrenght(), dyOption.getShakeTime() * 1000) {
                            public final void a() {
                                View view = view2;
                                if (view != null) {
                                    try {
                                        if (view.getGlobalVisibleRect(new Rect())) {
                                            SplashResData splashResData = new SplashResData();
                                            mBSplashData2.setClickType(4);
                                            splashResData.setBaseViewData(mBSplashData2);
                                            splashResData.seteAction(EAction.DOWNLOAD);
                                            EventBus.getDefault().post(splashResData);
                                            com.mbridge.msdk.shake.a.a().b(b.this.f8604g);
                                        }
                                    } catch (Exception e5) {
                                        af.b("MBDataBinding", e5.getMessage());
                                    }
                                }
                            }
                        };
                    } catch (Exception e5) {
                        e = e5;
                    }
                    return bVar.f8604g;
                }
            } catch (Exception e6) {
                e = e6;
                bVar = this;
                af.b("MBDataBinding", e.getMessage());
                return bVar.f8604g;
            }
        }
        bVar = this;
        return bVar.f8604g;
    }

    static /* synthetic */ void b(b bVar, InterBase interBase, Object obj) {
        final boolean z4;
        int i5;
        if (interBase != null && obj != null) {
            String effectDes = interBase.getEffectDes();
            if (!TextUtils.isEmpty(effectDes)) {
                try {
                    if (interBase instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) interBase;
                        com.mbridge.msdk.dycreator.f.a.a aVar = (com.mbridge.msdk.dycreator.f.a.a) obj;
                        if (effectDes != null) {
                            if (effectDes.equals("wobble") && (viewGroup instanceof MBSplashShakeView)) {
                                if (aVar.getEffectData().isShakeVisible()) {
                                    if (bVar.f8604g != null) {
                                        com.mbridge.msdk.shake.a.a().b(bVar.f8604g);
                                    }
                                    com.mbridge.msdk.shake.a.a().a(bVar.a(viewGroup, (MBSplashData) aVar));
                                } else if (bVar.f8604g != null) {
                                    com.mbridge.msdk.shake.a.a().b(bVar.f8604g);
                                }
                            }
                            if (effectDes.equals("visible") && (viewGroup instanceof MBApkInfoView)) {
                                if (!aVar.getEffectData().isApkInfoVisible()) {
                                    viewGroup.setVisibility(8);
                                } else if (!(aVar instanceof MBSplashData) || TextUtils.isEmpty(((MBSplashData) aVar).getAppInfo())) {
                                    viewGroup.setVisibility(4);
                                } else {
                                    viewGroup.setVisibility(0);
                                }
                            }
                            effectDes.equals("anim");
                        }
                    } else if (interBase instanceof View) {
                        final View view = (View) interBase;
                        if (effectDes != null) {
                            com.mbridge.msdk.dycreator.f.a.a aVar2 = (com.mbridge.msdk.dycreator.f.a.a) obj;
                            if (effectDes.equals("countdown") && (view instanceof TextView)) {
                                final String str = (String) ((TextView) view).getText();
                                final String t5 = ab.t(view.getContext());
                                DyOption effectData = aVar2.getEffectData();
                                if (effectData != null) {
                                    boolean isCanSkip = effectData.isCanSkip();
                                    i5 = effectData.getCountDownTime();
                                    z4 = isCanSkip;
                                } else {
                                    i5 = 5;
                                    z4 = false;
                                }
                                ((TextView) view).setText(com.mbridge.msdk.dycreator.e.d.a(z4, i5, str, t5));
                                ((com.mbridge.msdk.dycreator.f.a.a) obj).getEffectData().setDyCountDownListenerWrapper(new DyCountDownListenerWrapper() {
                                    public final void getCountDownValue(int i5) {
                                        if (i5 == 0) {
                                            SplashResData splashResData = new SplashResData();
                                            splashResData.seteAction(EAction.CLOSE);
                                            EventBus.getDefault().post(splashResData);
                                            return;
                                        }
                                        ((TextView) view).setText(com.mbridge.msdk.dycreator.e.d.a(z4, i5, str, t5));
                                    }
                                });
                            }
                            effectDes.equals("anim");
                            if (effectDes.equals("visible")) {
                                if (view instanceof MBFeedBack) {
                                    if (com.mbridge.msdk.foundation.d.b.a().b()) {
                                        view.setVisibility(0);
                                    } else {
                                        view.setVisibility(8);
                                    }
                                }
                                if ((view instanceof MBLogoTextView) && aVar2.getEffectData() != null && !aVar2.getEffectData().isLogoVisible()) {
                                    ((MBLogoTextView) view).setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                            }
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, InterBase interBase, Object obj) {
        if (interBase != null && obj != null) {
            String reportDes = interBase.getReportDes();
            if (!TextUtils.isEmpty(reportDes)) {
                try {
                    if ((obj instanceof com.mbridge.msdk.dycreator.f.a.a) && ((com.mbridge.msdk.dycreator.f.a.a) obj).getBindData() != null) {
                        interBase.setDynamicReport(reportDes, ((com.mbridge.msdk.dycreator.f.a.a) obj).getBindData());
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, View view, Object obj) {
        if (view != null && obj != null && (obj instanceof com.mbridge.msdk.dycreator.f.a.a)) {
            view.setOnClickListener(new a((com.mbridge.msdk.dycreator.f.a.a) obj));
        }
    }
}
