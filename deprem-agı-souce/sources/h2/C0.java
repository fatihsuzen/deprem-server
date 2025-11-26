package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

public final class C0 implements ViewBinding {

    /* renamed from: A  reason: collision with root package name */
    public final Toolbar f22283A;

    /* renamed from: B  reason: collision with root package name */
    public final C2449y0 f22284B;

    /* renamed from: C  reason: collision with root package name */
    public final TextView f22285C;

    /* renamed from: D  reason: collision with root package name */
    public final C2447x0 f22286D;

    /* renamed from: E  reason: collision with root package name */
    public final C2451z0 f22287E;

    /* renamed from: F  reason: collision with root package name */
    public final B0 f22288F;

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f22289a;

    /* renamed from: b  reason: collision with root package name */
    public final C2449y0 f22290b;

    /* renamed from: c  reason: collision with root package name */
    public final C2449y0 f22291c;

    /* renamed from: d  reason: collision with root package name */
    public final C2449y0 f22292d;

    /* renamed from: e  reason: collision with root package name */
    public final C2449y0 f22293e;

    /* renamed from: f  reason: collision with root package name */
    public final A0 f22294f;

    /* renamed from: g  reason: collision with root package name */
    public final C2451z0 f22295g;

    /* renamed from: h  reason: collision with root package name */
    public final A0 f22296h;

    /* renamed from: i  reason: collision with root package name */
    public final C2451z0 f22297i;

    /* renamed from: j  reason: collision with root package name */
    public final A0 f22298j;

    /* renamed from: k  reason: collision with root package name */
    public final C2449y0 f22299k;

    /* renamed from: l  reason: collision with root package name */
    public final C2447x0 f22300l;

    /* renamed from: m  reason: collision with root package name */
    public final A0 f22301m;

    /* renamed from: n  reason: collision with root package name */
    public final A0 f22302n;

    /* renamed from: o  reason: collision with root package name */
    public final C2449y0 f22303o;

    /* renamed from: p  reason: collision with root package name */
    public final LinearLayout f22304p;

    /* renamed from: q  reason: collision with root package name */
    public final C2447x0 f22305q;

    /* renamed from: r  reason: collision with root package name */
    public final C2447x0 f22306r;

    /* renamed from: s  reason: collision with root package name */
    public final A0 f22307s;

    /* renamed from: t  reason: collision with root package name */
    public final C2447x0 f22308t;

    /* renamed from: u  reason: collision with root package name */
    public final C2447x0 f22309u;

    /* renamed from: v  reason: collision with root package name */
    public final C2449y0 f22310v;

    /* renamed from: w  reason: collision with root package name */
    public final A0 f22311w;

    /* renamed from: x  reason: collision with root package name */
    public final LinearLayout f22312x;

    /* renamed from: y  reason: collision with root package name */
    public final C2447x0 f22313y;

    /* renamed from: z  reason: collision with root package name */
    public final A0 f22314z;

    private C0(LinearLayout linearLayout, C2449y0 y0Var, C2449y0 y0Var2, C2449y0 y0Var3, C2449y0 y0Var4, A0 a02, C2451z0 z0Var, A0 a03, C2451z0 z0Var2, A0 a04, C2449y0 y0Var5, C2447x0 x0Var, A0 a05, A0 a06, C2449y0 y0Var6, LinearLayout linearLayout2, C2447x0 x0Var2, C2447x0 x0Var3, A0 a07, C2447x0 x0Var4, C2447x0 x0Var5, C2449y0 y0Var7, A0 a08, LinearLayout linearLayout3, C2447x0 x0Var6, A0 a09, Toolbar toolbar, C2449y0 y0Var8, TextView textView, C2447x0 x0Var7, C2451z0 z0Var3, B0 b02) {
        this.f22289a = linearLayout;
        this.f22290b = y0Var;
        this.f22291c = y0Var2;
        this.f22292d = y0Var3;
        this.f22293e = y0Var4;
        this.f22294f = a02;
        this.f22295g = z0Var;
        this.f22296h = a03;
        this.f22297i = z0Var2;
        this.f22298j = a04;
        this.f22299k = y0Var5;
        this.f22300l = x0Var;
        this.f22301m = a05;
        this.f22302n = a06;
        this.f22303o = y0Var6;
        this.f22304p = linearLayout2;
        this.f22305q = x0Var2;
        this.f22306r = x0Var3;
        this.f22307s = a07;
        this.f22308t = x0Var4;
        this.f22309u = x0Var5;
        this.f22310v = y0Var7;
        this.f22311w = a08;
        this.f22312x = linearLayout3;
        this.f22313y = x0Var6;
        this.f22314z = a09;
        this.f22283A = toolbar;
        this.f22284B = y0Var8;
        this.f22285C = textView;
        this.f22286D = x0Var7;
        this.f22287E = z0Var3;
        this.f22288F = b02;
    }

    public static C0 a(View view) {
        View view2 = view;
        int i5 = R.id.about_app_setting;
        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.about_app_setting);
        if (findChildViewById != null) {
            C2449y0 a5 = C2449y0.a(findChildViewById);
            i5 = R.id.about_uptodown_setting;
            View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.about_uptodown_setting);
            if (findChildViewById2 != null) {
                C2449y0 a6 = C2449y0.a(findChildViewById2);
                i5 = R.id.ads_setting;
                View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.ads_setting);
                if (findChildViewById3 != null) {
                    C2449y0 a7 = C2449y0.a(findChildViewById3);
                    i5 = R.id.advanced_setting;
                    View findChildViewById4 = ViewBindings.findChildViewById(view2, R.id.advanced_setting);
                    if (findChildViewById4 != null) {
                        C2449y0 a8 = C2449y0.a(findChildViewById4);
                        i5 = R.id.allow_animations_switch_setting;
                        View findChildViewById5 = ViewBindings.findChildViewById(view2, R.id.allow_animations_switch_setting);
                        if (findChildViewById5 != null) {
                            A0 a9 = A0.a(findChildViewById5);
                            i5 = R.id.auto_play_video_setting;
                            View findChildViewById6 = ViewBindings.findChildViewById(view2, R.id.auto_play_video_setting);
                            if (findChildViewById6 != null) {
                                C2451z0 a10 = C2451z0.a(findChildViewById6);
                                i5 = R.id.auto_update_root_switch_setting;
                                View findChildViewById7 = ViewBindings.findChildViewById(view2, R.id.auto_update_root_switch_setting);
                                if (findChildViewById7 != null) {
                                    A0 a11 = A0.a(findChildViewById7);
                                    i5 = R.id.data_saver_setting;
                                    View findChildViewById8 = ViewBindings.findChildViewById(view2, R.id.data_saver_setting);
                                    if (findChildViewById8 != null) {
                                        C2451z0 a12 = C2451z0.a(findChildViewById8);
                                        i5 = R.id.downloads_notification_setting;
                                        View findChildViewById9 = ViewBindings.findChildViewById(view2, R.id.downloads_notification_setting);
                                        if (findChildViewById9 != null) {
                                            A0 a13 = A0.a(findChildViewById9);
                                            i5 = R.id.feedback_setting;
                                            View findChildViewById10 = ViewBindings.findChildViewById(view2, R.id.feedback_setting);
                                            if (findChildViewById10 != null) {
                                                C2449y0 a14 = C2449y0.a(findChildViewById10);
                                                i5 = R.id.file_management_category;
                                                View findChildViewById11 = ViewBindings.findChildViewById(view2, R.id.file_management_category);
                                                if (findChildViewById11 != null) {
                                                    C2447x0 a15 = C2447x0.a(findChildViewById11);
                                                    i5 = R.id.installable_files_notification_setting;
                                                    View findChildViewById12 = ViewBindings.findChildViewById(view2, R.id.installable_files_notification_setting);
                                                    if (findChildViewById12 != null) {
                                                        A0 a16 = A0.a(findChildViewById12);
                                                        i5 = R.id.installations_notification_setting;
                                                        View findChildViewById13 = ViewBindings.findChildViewById(view2, R.id.installations_notification_setting);
                                                        if (findChildViewById13 != null) {
                                                            A0 a17 = A0.a(findChildViewById13);
                                                            i5 = R.id.language_setting;
                                                            View findChildViewById14 = ViewBindings.findChildViewById(view2, R.id.language_setting);
                                                            if (findChildViewById14 != null) {
                                                                C2449y0 a18 = C2449y0.a(findChildViewById14);
                                                                i5 = R.id.ll_preferences_list;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_preferences_list);
                                                                if (linearLayout != null) {
                                                                    i5 = R.id.more_info_category;
                                                                    View findChildViewById15 = ViewBindings.findChildViewById(view2, R.id.more_info_category);
                                                                    if (findChildViewById15 != null) {
                                                                        C2447x0 a19 = C2447x0.a(findChildViewById15);
                                                                        i5 = R.id.notifications_category;
                                                                        View findChildViewById16 = ViewBindings.findChildViewById(view2, R.id.notifications_category);
                                                                        if (findChildViewById16 != null) {
                                                                            C2447x0 a20 = C2447x0.a(findChildViewById16);
                                                                            i5 = R.id.only_wifi_switch_setting;
                                                                            View findChildViewById17 = ViewBindings.findChildViewById(view2, R.id.only_wifi_switch_setting);
                                                                            if (findChildViewById17 != null) {
                                                                                A0 a21 = A0.a(findChildViewById17);
                                                                                i5 = R.id.performance_category;
                                                                                View findChildViewById18 = ViewBindings.findChildViewById(view2, R.id.performance_category);
                                                                                if (findChildViewById18 != null) {
                                                                                    C2447x0 a22 = C2447x0.a(findChildViewById18);
                                                                                    i5 = R.id.privacy_and_policy_category;
                                                                                    View findChildViewById19 = ViewBindings.findChildViewById(view2, R.id.privacy_and_policy_category);
                                                                                    if (findChildViewById19 != null) {
                                                                                        C2447x0 a23 = C2447x0.a(findChildViewById19);
                                                                                        i5 = R.id.privacy_setting;
                                                                                        View findChildViewById20 = ViewBindings.findChildViewById(view2, R.id.privacy_setting);
                                                                                        if (findChildViewById20 != null) {
                                                                                            C2449y0 a24 = C2449y0.a(findChildViewById20);
                                                                                            i5 = R.id.quick_install_root_switch_setting;
                                                                                            View findChildViewById21 = ViewBindings.findChildViewById(view2, R.id.quick_install_root_switch_setting);
                                                                                            if (findChildViewById21 != null) {
                                                                                                A0 a25 = A0.a(findChildViewById21);
                                                                                                LinearLayout linearLayout2 = (LinearLayout) view2;
                                                                                                i5 = R.id.root_category;
                                                                                                View findChildViewById22 = ViewBindings.findChildViewById(view2, R.id.root_category);
                                                                                                if (findChildViewById22 != null) {
                                                                                                    C2447x0 a26 = C2447x0.a(findChildViewById22);
                                                                                                    i5 = R.id.show_notifications_setting;
                                                                                                    View findChildViewById23 = ViewBindings.findChildViewById(view2, R.id.show_notifications_setting);
                                                                                                    if (findChildViewById23 != null) {
                                                                                                        A0 a27 = A0.a(findChildViewById23);
                                                                                                        i5 = R.id.toolbar_preferences;
                                                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_preferences);
                                                                                                        if (toolbar != null) {
                                                                                                            i5 = R.id.tos_setting;
                                                                                                            View findChildViewById24 = ViewBindings.findChildViewById(view2, R.id.tos_setting);
                                                                                                            if (findChildViewById24 != null) {
                                                                                                                C2449y0 a28 = C2449y0.a(findChildViewById24);
                                                                                                                i5 = R.id.tv_toolbar_title_preferences;
                                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_toolbar_title_preferences);
                                                                                                                if (textView != null) {
                                                                                                                    i5 = R.id.updates_category;
                                                                                                                    View findChildViewById25 = ViewBindings.findChildViewById(view2, R.id.updates_category);
                                                                                                                    if (findChildViewById25 != null) {
                                                                                                                        C2447x0 a29 = C2447x0.a(findChildViewById25);
                                                                                                                        i5 = R.id.updates_notification_setting;
                                                                                                                        View findChildViewById26 = ViewBindings.findChildViewById(view2, R.id.updates_notification_setting);
                                                                                                                        if (findChildViewById26 != null) {
                                                                                                                            C2451z0 a30 = C2451z0.a(findChildViewById26);
                                                                                                                            i5 = R.id.updates_setting;
                                                                                                                            View findChildViewById27 = ViewBindings.findChildViewById(view2, R.id.updates_setting);
                                                                                                                            if (findChildViewById27 != null) {
                                                                                                                                return new C0(linearLayout2, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, linearLayout, a19, a20, a21, a22, a23, a24, a25, linearLayout2, a26, a27, toolbar, a28, textView, a29, a30, B0.a(findChildViewById27));
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i5)));
    }

    public static C0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.preferences_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f22289a;
    }
}
