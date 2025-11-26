package K2;

import E1.c;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import m4.d;
import v4.b;

public final class g extends b {

    /* renamed from: o  reason: collision with root package name */
    public static final String f18399o;

    /* renamed from: m  reason: collision with root package name */
    public d f18400m;

    /* renamed from: n  reason: collision with root package name */
    public c f18401n;

    static {
        String simpleName = g.class.getSimpleName();
        t.d(simpleName, "PartnersDisclosuresFragment::class.java.simpleName");
        f18399o = simpleName;
    }

    public static final void h(g gVar, View view) {
        t.e(gVar, "this$0");
        gVar.dismiss();
    }

    public final void onCreate(Bundle bundle) {
        c cVar;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            cVar = null;
        } else {
            cVar = (c) V2.b.a(arguments, "partner_disclosure_args", c.class);
        }
        if (cVar == null) {
            cVar = new c((List) new ArrayList());
        }
        this.f18401n = cVar;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = activity.getViewModelStore();
            t.d(viewModelStore, "viewModelStore");
            this.f18400m = (d) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new e()).get(d.class);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_partners_disclosures, viewGroup, false);
        t.d(inflate, "inflater.inflate(R.layou…osures, container, false)");
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Integer num;
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(E1.b.rv_disclosures);
        d dVar = null;
        if (recyclerView != null) {
            c cVar = this.f18401n;
            if (cVar == null) {
                t.w("args");
                cVar = null;
            }
            recyclerView.setAdapter(new v4.g(cVar.f18396a));
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
        TextView textView = this.f26050b;
        if (textView != null) {
            d dVar2 = this.f18400m;
            if (dVar2 == null) {
                t.w("viewModel");
                dVar2 = null;
            }
            textView.setText(dVar2.f18397a.f25473a);
        }
        ImageView imageView = this.f26051c;
        if (imageView != null) {
            imageView.setOnClickListener(new f(this));
            d dVar3 = this.f18400m;
            if (dVar3 == null) {
                t.w("viewModel");
            } else {
                dVar = dVar3;
            }
            imageView.setContentDescription(dVar.f18397a.f25474b);
        }
        d dVar4 = this.f26058j;
        if (dVar4 != null && (num = dVar4.f25322g) != null) {
            view.setBackgroundColor(num.intValue());
        }
    }
}
