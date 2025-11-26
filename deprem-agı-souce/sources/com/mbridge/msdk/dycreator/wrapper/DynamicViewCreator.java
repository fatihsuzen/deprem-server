package com.mbridge.msdk.dycreator.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.b.a;
import com.mbridge.msdk.dycreator.e.f;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.viewmodel.MBCommonViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBRewardViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.af;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DynamicViewCreator {

    /* renamed from: a  reason: collision with root package name */
    private static volatile DynamicViewCreator f8754a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f8755b = -201;

    /* renamed from: com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8756a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mbridge.msdk.dycreator.wrapper.DyAdType[] r0 = com.mbridge.msdk.dycreator.wrapper.DyAdType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8756a = r0
                com.mbridge.msdk.dycreator.wrapper.DyAdType r1 = com.mbridge.msdk.dycreator.wrapper.DyAdType.SPLASH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8756a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.wrapper.DyAdType r1 = com.mbridge.msdk.dycreator.wrapper.DyAdType.REWARD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator.AnonymousClass1.<clinit>():void");
        }
    }

    private DynamicViewCreator() {
        b.a().a(c.m().c());
    }

    private View a(Context context, DyOption dyOption) {
        List<String> fileDirs;
        ViewGroup viewGroup;
        if (dyOption == null || (fileDirs = dyOption.getFileDirs()) == null) {
            return null;
        }
        int i5 = 0;
        ViewGroup viewGroup2 = null;
        int i6 = 0;
        while (i6 < fileDirs.size()) {
            try {
                if (!TextUtils.isEmpty(fileDirs.get(i6))) {
                    if (i6 == 0) {
                        viewGroup2 = (ViewGroup) f.a(context).a(fileDirs.get(i6));
                    } else {
                        String str = fileDirs.get(i6);
                        if (!(context == null || viewGroup2 == null || TextUtils.isEmpty(str))) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                String string = jSONObject.getString("folder_dir");
                                if (!TextUtils.isEmpty(string)) {
                                    JSONArray jSONArray = new JSONArray(jSONObject.optString("ext_template"));
                                    if (jSONArray.length() != 0) {
                                        int i7 = i5;
                                        while (i7 < jSONArray.length()) {
                                            JSONObject jSONObject2 = jSONArray.getJSONObject(i7);
                                            if (jSONObject2 != null) {
                                                View a5 = f.a(context).a(string + File.separator + jSONObject2.optString(RewardPlus.NAME));
                                                if (a5 != null) {
                                                    JSONObject jSONObject3 = jSONObject2.getJSONObject(TtmlNode.TAG_LAYOUT);
                                                    if (jSONObject3 != null) {
                                                        try {
                                                            String optString = jSONObject3.optString("parent_id");
                                                            if (!TextUtils.isEmpty(optString)) {
                                                                viewGroup = (ViewGroup) f.a(context).a(viewGroup2, optString);
                                                            } else {
                                                                viewGroup = viewGroup2;
                                                            }
                                                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
                                                            if (layoutParams != null) {
                                                                String optString2 = jSONObject3.optString("below", "");
                                                                if (!TextUtils.isEmpty(optString2)) {
                                                                    layoutParams.addRule(3, optString2.hashCode());
                                                                }
                                                                String optString3 = jSONObject3.optString("left_of", "");
                                                                if (!TextUtils.isEmpty(optString3)) {
                                                                    layoutParams.addRule(i5, optString3.hashCode());
                                                                }
                                                                String optString4 = jSONObject3.optString("right_of", "");
                                                                if (!TextUtils.isEmpty(optString4)) {
                                                                    layoutParams.addRule(1, optString4.hashCode());
                                                                }
                                                                int optInt = jSONObject3.optInt("index", -2);
                                                                int optInt2 = jSONObject3.optInt("visibility", -1);
                                                                if (optInt2 != -1) {
                                                                    a5.setVisibility(optInt2);
                                                                }
                                                                if (optInt != -2) {
                                                                    viewGroup.addView(a5, optInt, layoutParams);
                                                                } else {
                                                                    viewGroup.addView(a5, layoutParams);
                                                                }
                                                            }
                                                        } catch (Exception e5) {
                                                            af.b("DynamicViewCreator", e5.getMessage());
                                                        }
                                                    } else {
                                                        viewGroup2.addView(a5, 3);
                                                    }
                                                }
                                            }
                                            i7++;
                                            i5 = 0;
                                        }
                                    }
                                }
                            } catch (Exception e6) {
                                af.b("DynamicViewCreator", e6.getMessage());
                            }
                        }
                    }
                }
                i6++;
                i5 = 0;
            } catch (Exception e7) {
                af.b("DynamicViewCreator", e7.getMessage());
            }
        }
        return viewGroup2;
    }

    public static DynamicViewCreator getInstance() {
        if (f8754a == null) {
            synchronized (DynamicViewCreator.class) {
                try {
                    if (f8754a == null) {
                        f8754a = new DynamicViewCreator();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f8754a;
    }

    public void createDynamicView(DyOption dyOption, DynamicViewBackListener dynamicViewBackListener) {
        boolean z4;
        BaseViewModel baseViewModel;
        BaseViewModel mBSplashViewVModel;
        if (dyOption == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_DYNAMIC_OPTION));
        } else if (dynamicViewBackListener != null) {
            Context c5 = c.m().c();
            if (c5 == null) {
                dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_CONTEXT));
                return;
            }
            boolean z5 = false;
            if (dyOption.getCampaignEx() == null) {
                dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_CAMPAIGN));
                z4 = false;
            } else {
                z4 = true;
            }
            if (dyOption.getFile() != null || dyOption.getFileDirs() == null) {
                z5 = z4;
            } else {
                dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.BIND_DATA_FILE_OR_DIR));
            }
            if (z5) {
                try {
                    View a5 = a(c5, dyOption);
                    if (a5 == null) {
                        dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.FILE_CREATE_VIEW_FILE));
                        return;
                    }
                    int i5 = AnonymousClass1.f8756a[dyOption.getDyAdType().ordinal()];
                    if (i5 == 1) {
                        mBSplashViewVModel = new MBSplashViewVModel(dyOption);
                    } else if (i5 != 2) {
                        baseViewModel = new MBCommonViewVModel();
                        baseViewModel.setDynamicViewBackListener(dynamicViewBackListener);
                        com.mbridge.msdk.dycreator.binding.b.a().a(baseViewModel);
                        baseViewModel.setModelDataAndBind();
                        dynamicViewBackListener.viewCreatedSuccess(a5);
                    } else {
                        mBSplashViewVModel = new MBRewardViewVModel(dyOption);
                    }
                    baseViewModel = mBSplashViewVModel;
                    baseViewModel.setDynamicViewBackListener(dynamicViewBackListener);
                    com.mbridge.msdk.dycreator.binding.b.a().a(baseViewModel);
                    baseViewModel.setModelDataAndBind();
                    dynamicViewBackListener.viewCreatedSuccess(a5);
                } catch (Exception e5) {
                    af.b("DynamicViewCreator", e5.getMessage());
                    dynamicViewBackListener.viewCreateFail(new a(f8755b, e5.getMessage()));
                }
            }
        }
    }

    public View createDynamicView(DyOption dyOption) {
        Context c5;
        if (dyOption == null || (c5 = c.m().c()) == null) {
            return null;
        }
        return a(c5, dyOption);
    }
}
