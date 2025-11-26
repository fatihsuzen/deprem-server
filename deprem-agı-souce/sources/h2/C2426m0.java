package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.m0  reason: case insensitive filesystem */
public final class C2426m0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f23341a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23342b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f23343c;

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f23344d;

    /* renamed from: e  reason: collision with root package name */
    public final SwitchCompat f23345e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23346f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f23347g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f23348h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f23349i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f23350j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f23351k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f23352l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f23353m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f23354n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f23355o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f23356p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f23357q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f23358r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f23359s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f23360t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f23361u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f23362v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f23363w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f23364x;

    /* renamed from: y  reason: collision with root package name */
    public final TextView f23365y;

    /* renamed from: z  reason: collision with root package name */
    public final View f23366z;

    private C2426m0(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, SwitchCompat switchCompat, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, View view) {
        this.f23341a = relativeLayout;
        this.f23342b = imageView;
        this.f23343c = relativeLayout2;
        this.f23344d = relativeLayout3;
        this.f23345e = switchCompat;
        this.f23346f = textView;
        this.f23347g = textView2;
        this.f23348h = textView3;
        this.f23349i = textView4;
        this.f23350j = textView5;
        this.f23351k = textView6;
        this.f23352l = textView7;
        this.f23353m = textView8;
        this.f23354n = textView9;
        this.f23355o = textView10;
        this.f23356p = textView11;
        this.f23357q = textView12;
        this.f23358r = textView13;
        this.f23359s = textView14;
        this.f23360t = textView15;
        this.f23361u = textView16;
        this.f23362v = textView17;
        this.f23363w = textView18;
        this.f23364x = textView19;
        this.f23365y = textView20;
        this.f23366z = view;
    }

    public static C2426m0 a(View view) {
        View view2 = view;
        int i5 = R.id.iv_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_icon);
        if (imageView != null) {
            i5 = R.id.rl_exclude;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_exclude);
            if (relativeLayout != null) {
                i5 = R.id.rl_header;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_header);
                if (relativeLayout2 != null) {
                    i5 = R.id.sc_exclude;
                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view2, R.id.sc_exclude);
                    if (switchCompat != null) {
                        i5 = R.id.tv_app_installed_details;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_installed_details);
                        if (textView != null) {
                            i5 = R.id.tv_app_name;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_name);
                            if (textView2 != null) {
                                i5 = R.id.tv_backup;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_backup);
                                if (textView3 != null) {
                                    i5 = R.id.tv_check_updates;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_check_updates);
                                    if (textView4 != null) {
                                        i5 = R.id.tv_exclude;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_exclude);
                                        if (textView5 != null) {
                                            i5 = R.id.tv_ignore_version;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_ignore_version);
                                            if (textView6 != null) {
                                                i5 = R.id.tv_nsd_send;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_nsd_send);
                                                if (textView7 != null) {
                                                    i5 = R.id.tv_old_versions;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_old_versions);
                                                    if (textView8 != null) {
                                                        i5 = R.id.tv_open;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_open);
                                                        if (textView9 != null) {
                                                            i5 = R.id.tv_see_on_uptodown;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_see_on_uptodown);
                                                            if (textView10 != null) {
                                                                i5 = R.id.tv_share;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_share);
                                                                if (textView11 != null) {
                                                                    i5 = R.id.tv_title_app_general_management;
                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_app_general_management);
                                                                    if (textView12 != null) {
                                                                        i5 = R.id.tv_title_info_and_share;
                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_info_and_share);
                                                                        if (textView13 != null) {
                                                                            i5 = R.id.tv_title_security;
                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_security);
                                                                            if (textView14 != null) {
                                                                                i5 = R.id.tv_title_update_config;
                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_update_config);
                                                                                if (textView15 != null) {
                                                                                    i5 = R.id.tv_uninstall;
                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_uninstall);
                                                                                    if (textView16 != null) {
                                                                                        i5 = R.id.tv_update;
                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_update);
                                                                                        if (textView17 != null) {
                                                                                            i5 = R.id.tv_version_changelog_details;
                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_version_changelog_details);
                                                                                            if (textView18 != null) {
                                                                                                i5 = R.id.tv_version_details;
                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_version_details);
                                                                                                if (textView19 != null) {
                                                                                                    i5 = R.id.tv_virustotal_report;
                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_virustotal_report);
                                                                                                    if (textView20 != null) {
                                                                                                        i5 = R.id.v_outside_header;
                                                                                                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.v_outside_header);
                                                                                                        if (findChildViewById != null) {
                                                                                                            return new C2426m0((RelativeLayout) view2, imageView, relativeLayout, relativeLayout2, switchCompat, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, findChildViewById);
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

    public static C2426m0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2426m0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.myappsupdates_options_dialog, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f23341a;
    }
}
