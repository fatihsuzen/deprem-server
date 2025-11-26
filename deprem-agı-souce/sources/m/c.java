package m;

import E1.a;
import E1.e;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import b3.C2308e;
import c.i;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.model.Regulations;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;
import m4.d;
import v4.b;
import w3.C2865c0;
import w3.C2896s0;
import w3.C2908y0;
import w3.O;

public final class c extends b implements c.b {

    /* renamed from: q  reason: collision with root package name */
    public static final String f939q;

    /* renamed from: m  reason: collision with root package name */
    public TextView f940m;

    /* renamed from: n  reason: collision with root package name */
    public Button f941n;

    /* renamed from: o  reason: collision with root package name */
    public NestedScrollView f942o;

    /* renamed from: p  reason: collision with root package name */
    public e f943p;

    static {
        String simpleName = c.class.getSimpleName();
        t.d(simpleName, "GBCFragment::class.java.simpleName");
        f939q = simpleName;
    }

    public static final void h(c cVar, View view) {
        t.e(cVar, "this$0");
        e eVar = cVar.f943p;
        if (eVar == null) {
            t.w("viewModel");
            eVar = null;
        }
        F1.b bVar = new F1.b(DisplayStatus.DISMISSED, "User dismissed GBC screen", Regulations.NA, true);
        eVar.getClass();
        t.e(bVar, "displayInfo");
        ChoiceCmpCallback choiceCmpCallback = eVar.f946b;
        if (choiceCmpCallback != null) {
            choiceCmpCallback.onCMPUIStatusChanged(bVar);
        }
        cVar.dismiss();
        FragmentActivity activity = cVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void i(c cVar, View view) {
        g gVar;
        t.e(cVar, "this$0");
        Fragment findFragmentByTag = cVar.getChildFragmentManager().findFragmentByTag(g.f949g);
        if (findFragmentByTag instanceof g) {
            gVar = (g) findFragmentByTag;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            gVar.f();
        }
        e eVar = cVar.f943p;
        if (eVar == null) {
            t.w("viewModel");
            eVar = null;
        }
        eVar.getClass();
        C2908y0 unused = C2876i.d(C2896s0.f26313a, C2865c0.b(), (O) null, new d((C2308e) null), 2, (Object) null);
        cVar.dismiss();
        FragmentActivity activity = cVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void d(i iVar) {
        t.e(iVar, "item");
    }

    public final void e(i iVar) {
        t.e(iVar, "item");
    }

    public final void onCancel(DialogInterface dialogInterface) {
        t.e(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        e eVar = this.f943p;
        if (eVar == null) {
            t.w("viewModel");
            eVar = null;
        }
        F1.b bVar = new F1.b(DisplayStatus.DISMISSED, "User dismissed GBC screen", Regulations.NA, true);
        eVar.getClass();
        t.e(bVar, "displayInfo");
        ChoiceCmpCallback choiceCmpCallback = eVar.f946b;
        if (choiceCmpCallback != null) {
            choiceCmpCallback.onCMPUIStatusChanged(bVar);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity() != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            t.d(viewModelStore, "viewModelStore");
            this.f943p = (e) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new f()).get(e.class);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(E1.c.gbc_privacy_screen, viewGroup, false);
        t.d(inflate, "inflater.inflate(R.layou…screen, container, false)");
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        TextView textView2;
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f940m = (TextView) view.findViewById(E1.b.tv_gbc_description);
        this.f941n = (Button) view.findViewById(E1.b.btn_save_and_exit);
        this.f942o = (NestedScrollView) view.findViewById(E1.b.sv_container);
        e eVar = null;
        getChildFragmentManager().beginTransaction().add(E1.b.gbc_fragment_container, (Fragment) new g(), g.f949g).addToBackStack((String) null).commit();
        TextView textView3 = this.f26050b;
        if (textView3 != null) {
            e eVar2 = this.f943p;
            if (eVar2 == null) {
                t.w("viewModel");
                eVar2 = null;
            }
            String str = eVar2.f947c.f18954b.f18947a;
            if (str.length() == 0) {
                str = getString(e.we_value_your_privacy);
                t.d(str, "getString(R.string.we_value_your_privacy)");
            }
            textView3.setText(str);
        }
        TextView textView4 = this.f940m;
        if (textView4 != null) {
            e eVar3 = this.f943p;
            if (eVar3 == null) {
                t.w("viewModel");
                eVar3 = null;
            }
            String str2 = eVar3.f947c.f18954b.f18949c;
            if (str2.length() == 0) {
                str2 = getString(e.gbc_description);
                t.d(str2, "getString(R.string.gbc_description)");
            }
            textView4.setText(str2);
        }
        TextView textView5 = this.f940m;
        if (textView5 != null) {
            textView5.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context = getContext();
        if (!(context == null || (textView2 = this.f940m) == null)) {
            textView2.setLinkTextColor(ContextCompat.getColor(context, a.colorBlueAccent));
        }
        Button button = this.f941n;
        if (button != null) {
            e eVar4 = this.f943p;
            if (eVar4 == null) {
                t.w("viewModel");
            } else {
                eVar = eVar4;
            }
            String str3 = eVar.f947c.f18954b.f18950d;
            if (str3.length() == 0) {
                str3 = getString(e.save_and_exit);
                t.d(str3, "getString(R.string.save_and_exit)");
            }
            button.setText(str3);
        }
        ImageView imageView = this.f26051c;
        if (imageView != null) {
            imageView.setOnClickListener(new a(this));
        }
        Button button2 = this.f941n;
        if (button2 != null) {
            button2.setOnClickListener(new b(this));
        }
        d dVar = this.f26058j;
        if (dVar != null) {
            Integer num = dVar.f25322g;
            if (num != null) {
                view.setBackgroundColor(num.intValue());
            }
            Integer num2 = dVar.f25316a;
            if (num2 != null) {
                int intValue = num2.intValue();
                NestedScrollView nestedScrollView = this.f942o;
                if (nestedScrollView != null) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(2.0f);
                    gradientDrawable.setStroke(4, intValue);
                    nestedScrollView.setBackground(gradientDrawable);
                }
            }
            Integer num3 = dVar.f25324i;
            if (num3 != null) {
                int intValue2 = num3.intValue();
                TextView textView6 = this.f940m;
                if (textView6 != null) {
                    textView6.setTextColor(intValue2);
                }
            }
            Integer num4 = dVar.f25330o;
            if (num4 != null) {
                int intValue3 = num4.intValue();
                Button button3 = this.f941n;
                if (button3 != null) {
                    button3.setBackgroundColor(intValue3);
                }
            }
            Integer num5 = dVar.f25328m;
            if (num5 != null) {
                int intValue4 = num5.intValue();
                Button button4 = this.f941n;
                if (button4 != null) {
                    button4.setTextColor(intValue4);
                }
            }
        }
        Typeface typeface = this.f26060l;
        if (typeface != null && (textView = this.f940m) != null) {
            textView.setTypeface(typeface);
        }
    }
}
