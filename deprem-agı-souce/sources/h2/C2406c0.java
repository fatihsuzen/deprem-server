package h2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: h2.c0  reason: case insensitive filesystem */
public final class C2406c0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f22849a;

    /* renamed from: b  reason: collision with root package name */
    public final View f22850b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f22851c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f22852d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f22853e;

    private C2406c0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView) {
        this.f22849a = relativeLayout;
        this.f22850b = view;
        this.f22851c = recyclerView;
        this.f22852d = toolbar;
        this.f22853e = textView;
    }

    public static C2406c0 a(View view) {
        int i5 = R.id.loading_view_language_settings;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.loading_view_language_settings);
        if (findChildViewById != null) {
            i5 = R.id.rv_languages;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_languages);
            if (recyclerView != null) {
                i5 = R.id.toolbar_lang_settings;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar_lang_settings);
                if (toolbar != null) {
                    i5 = R.id.tv_title_lang_settings;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title_lang_settings);
                    if (textView != null) {
                        return new C2406c0((RelativeLayout) view, findChildViewById, recyclerView, toolbar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C2406c0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C2406c0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.language_settings, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f22849a;
    }
}
