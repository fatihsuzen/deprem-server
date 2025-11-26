package S2;

import E1.c;
import I2.k;
import I2.l;
import O2.j;
import P3.e;
import P3.f;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.h;
import c.i;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import v4.b;
import v4.p;

public final class d extends b implements c.b {

    /* renamed from: v  reason: collision with root package name */
    public static final String f19024v;

    /* renamed from: m  reason: collision with root package name */
    public Button f19025m;

    /* renamed from: n  reason: collision with root package name */
    public Button f19026n;

    /* renamed from: o  reason: collision with root package name */
    public RecyclerView f19027o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f19028p;

    /* renamed from: q  reason: collision with root package name */
    public ConstraintLayout f19029q;

    /* renamed from: r  reason: collision with root package name */
    public int f19030r;

    /* renamed from: s  reason: collision with root package name */
    public h f19031s;

    /* renamed from: t  reason: collision with root package name */
    public e f19032t;

    /* renamed from: u  reason: collision with root package name */
    public k f19033u;

    static {
        String name = d.class.getName();
        t.d(name, "StacksFragment::class.java.name");
        f19024v = name;
    }

    public static final void i(d dVar, View view) {
        t.e(dVar, "this$0");
        dVar.dismiss();
    }

    public static final void l(d dVar, View view) {
        t.e(dVar, "this$0");
        e eVar = dVar.f19032t;
        if (eVar == null) {
            t.w("viewModel");
            eVar = null;
        }
        int i5 = dVar.f19030r;
        ArrayList c5 = eVar.c(i5);
        int size = c5.size();
        int i6 = 0;
        int i7 = 0;
        while (i7 < size) {
            Object obj = c5.get(i7);
            i7++;
            eVar.f19034a.f18331r.unset(((i) obj).f894a.f18881a);
        }
        ArrayList d5 = eVar.d(i5);
        int size2 = d5.size();
        while (i6 < size2) {
            Object obj2 = d5.get(i6);
            i6++;
            eVar.f19034a.f18330q.unset(((i) obj2).f894a.f18881a);
        }
        dVar.m();
    }

    public static final void n(d dVar, View view) {
        t.e(dVar, "this$0");
        e eVar = dVar.f19032t;
        if (eVar == null) {
            t.w("viewModel");
            eVar = null;
        }
        int i5 = dVar.f19030r;
        ArrayList c5 = eVar.c(i5);
        int size = c5.size();
        int i6 = 0;
        int i7 = 0;
        while (i7 < size) {
            Object obj = c5.get(i7);
            i7++;
            eVar.f19034a.f18331r.set(((i) obj).f894a.f18881a);
        }
        ArrayList d5 = eVar.d(i5);
        int size2 = d5.size();
        while (i6 < size2) {
            Object obj2 = d5.get(i6);
            i6++;
            eVar.f19034a.f18330q.set(((i) obj2).f894a.f18881a);
        }
        dVar.m();
    }

    public final void d(i iVar) {
        t.e(iVar, "item");
        FragmentActivity activity = getActivity();
        if (activity != null && (iVar.f894a instanceof f)) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            String str = p.f26090y;
            if (supportFragmentManager.findFragmentByTag(str) == null) {
                FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
                e eVar = iVar.f894a;
                String str2 = eVar.f18882b;
                String a5 = ((f) eVar).a();
                String b5 = ((f) iVar.f894a).b();
                e eVar2 = this.f19032t;
                e eVar3 = null;
                if (eVar2 == null) {
                    t.w("viewModel");
                    eVar2 = null;
                }
                String str3 = eVar2.b().f25491b;
                e eVar4 = this.f19032t;
                if (eVar4 == null) {
                    t.w("viewModel");
                } else {
                    eVar3 = eVar4;
                }
                beginTransaction.add((Fragment) v4.k.b(str2, a5, b5, str3, eVar3.b().f25494e, iVar.f894a.f18881a, iVar.f897d, false, j.f18829a), str).commit();
            }
        }
    }

    public final void e(i iVar) {
        t.e(iVar, "item");
        e eVar = this.f19032t;
        e eVar2 = null;
        if (eVar == null) {
            t.w("viewModel");
            eVar = null;
        }
        eVar.getClass();
        t.e(iVar, "switchItem");
        int ordinal = iVar.f897d.ordinal();
        if (ordinal != 4) {
            if (ordinal == 7) {
                if (t.a(iVar.f895b, Boolean.TRUE)) {
                    eVar.f19034a.f18330q.set(iVar.f894a.f18881a);
                } else {
                    eVar.f19034a.f18330q.unset(iVar.f894a.f18881a);
                }
            }
        } else if (t.a(iVar.f895b, Boolean.TRUE)) {
            eVar.f19034a.f18331r.set(iVar.f894a.f18881a);
        } else {
            eVar.f19034a.f18331r.unset(iVar.f894a.f18881a);
        }
        e eVar3 = this.f19032t;
        if (eVar3 == null) {
            t.w("viewModel");
        } else {
            eVar2 = eVar3;
        }
        j(eVar2.a(this.f19030r));
    }

    public final ColorStateList h() {
        Integer num;
        m4.d dVar = this.f26058j;
        if (dVar == null || (num = dVar.f25330o) == null || dVar.f25331p == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{num.intValue(), dVar.f25331p.intValue()});
    }

    public final void j(LinkedHashSet linkedHashSet) {
        boolean z4;
        Button button = this.f19026n;
        boolean z5 = false;
        if (button != null) {
            if (!linkedHashSet.isEmpty()) {
                Iterator it = linkedHashSet.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((Boolean) it.next()).booleanValue()) {
                            z4 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z4 = false;
            button.setEnabled(z4);
        }
        Button button2 = this.f19025m;
        if (button2 != null) {
            if (!linkedHashSet.isEmpty()) {
                Iterator it2 = linkedHashSet.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((Boolean) it2.next()).booleanValue()) {
                            z5 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            button2.setEnabled(z5);
        }
    }

    public final ColorStateList k() {
        Integer num;
        m4.d dVar = this.f26058j;
        if (dVar == null || (num = dVar.f25328m) == null || dVar.f25329n == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}}, new int[]{num.intValue(), dVar.f25329n.intValue()});
    }

    public final void m() {
        h hVar = this.f19031s;
        e eVar = null;
        if (hVar == null) {
            t.w("switchAdapter");
            hVar = null;
        }
        e eVar2 = this.f19032t;
        if (eVar2 == null) {
            t.w("viewModel");
            eVar2 = null;
        }
        int i5 = this.f19030r;
        ArrayList c5 = eVar2.c(i5);
        c5.addAll(eVar2.d(i5));
        hVar.getClass();
        t.e(c5, "switchItems");
        hVar.f884a = c5;
        hVar.notifyDataSetChanged();
        e eVar3 = this.f19032t;
        if (eVar3 == null) {
            t.w("viewModel");
        } else {
            eVar = eVar3;
        }
        j(eVar.a(this.f19030r));
    }

    public final void o() {
        Button button = this.f19026n;
        if (button != null) {
            button.setText(getString(E1.e.disagree_to_all));
        }
        e eVar = this.f19032t;
        e eVar2 = null;
        if (eVar == null) {
            t.w("viewModel");
            eVar = null;
        }
        j(eVar.a(this.f19030r));
        Button button2 = this.f19026n;
        if (button2 != null) {
            button2.setOnClickListener(new b(this));
        }
        Button button3 = this.f19025m;
        if (button3 != null) {
            e eVar3 = this.f19032t;
            if (eVar3 == null) {
                t.w("viewModel");
            } else {
                eVar2 = eVar3;
            }
            button3.setText(eVar2.b().f25492c);
        }
        Button button4 = this.f19025m;
        if (button4 != null) {
            button4.setOnClickListener(new c(this));
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            t.d(viewModelStore, "viewModelStore");
            this.f19032t = (e) new ViewModelProvider(viewModelStore, (ViewModelProvider.Factory) new f()).get(e.class);
            ViewModelStore viewModelStore2 = activity.getViewModelStore();
            t.d(viewModelStore2, "it.viewModelStore");
            this.f19033u = (k) new ViewModelProvider(viewModelStore2, (ViewModelProvider.Factory) new l()).get(k.class);
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(c.dialog_stacks, viewGroup, false);
        t.d(inflate, "inflater.inflate(R.layou…stacks, container, false)");
        return inflate;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        t.e(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        k kVar = this.f19033u;
        if (kVar == null) {
            t.w("optionsViewModel");
            kVar = null;
        }
        kVar.f18242o.postValue(Boolean.TRUE);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        t.e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            requireActivity().getOnBackPressedDispatcher().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        int i5;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        String str;
        Map map;
        P3.i iVar;
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        this.f19025m = (Button) view.findViewById(E1.b.btn_agree_to_all);
        this.f19026n = (Button) view.findViewById(E1.b.btn_disagree_to_all);
        this.f19027o = (RecyclerView) view.findViewById(E1.b.rv_switch_item_list);
        this.f19028p = (TextView) view.findViewById(E1.b.tv_stack_name);
        this.f19029q = (ConstraintLayout) view.findViewById(E1.b.stacks_container);
        Bundle arguments = getArguments();
        if (arguments == null) {
            i5 = 0;
        } else {
            i5 = arguments.getInt("stack_id");
        }
        this.f19030r = i5;
        TextView textView = this.f19028p;
        h hVar = null;
        if (textView != null) {
            e eVar = this.f19032t;
            if (eVar == null) {
                t.w("viewModel");
                eVar = null;
            }
            int i6 = this.f19030r;
            P3.d dVar = eVar.f19034a.f18314a;
            if (dVar == null || (map = dVar.f18878j) == null || (iVar = (P3.i) map.get(String.valueOf(i6))) == null) {
                str = null;
            } else {
                str = iVar.f18882b;
            }
            textView.setText(str);
        }
        TextView textView2 = this.f26050b;
        if (textView2 != null) {
            e eVar2 = this.f19032t;
            if (eVar2 == null) {
                t.w("viewModel");
                eVar2 = null;
            }
            textView2.setText(eVar2.b().f25490a);
        }
        ImageView imageView = this.f26051c;
        if (imageView != null) {
            imageView.setOnClickListener(new a(this));
            e eVar3 = this.f19032t;
            if (eVar3 == null) {
                t.w("viewModel");
                eVar3 = null;
            }
            imageView.setContentDescription(eVar3.b().f25495f);
        }
        m4.d dVar2 = this.f26058j;
        if (dVar2 != null) {
            Integer num5 = dVar2.f25322g;
            if (num5 != null) {
                int intValue = num5.intValue();
                ConstraintLayout constraintLayout = this.f19029q;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(intValue);
                }
            }
            Integer num6 = dVar2.f25324i;
            if (num6 != null) {
                int intValue2 = num6.intValue();
                TextView textView3 = this.f19028p;
                if (textView3 != null) {
                    textView3.setTextColor(intValue2);
                }
            }
            Typeface typeface = this.f26060l;
            if (typeface != null) {
                TextView textView4 = this.f19028p;
                if (textView4 != null) {
                    textView4.setTypeface(typeface);
                }
                Button button = this.f19025m;
                if (button != null) {
                    button.setTypeface(typeface);
                }
                Button button2 = this.f19026n;
                if (button2 != null) {
                    button2.setTypeface(typeface);
                }
            }
            Button button3 = this.f19025m;
            if (button3 != null) {
                ColorStateList k5 = k();
                if (k5 != null) {
                    button3.setTextColor(k5);
                }
                ColorStateList h5 = h();
                if (h5 != null) {
                    button3.setBackgroundTintList(h5);
                }
            }
            Button button4 = this.f19026n;
            if (button4 != null) {
                ColorStateList k6 = k();
                if (k6 != null) {
                    button4.setTextColor(k6);
                }
                ColorStateList h6 = h();
                if (h6 != null) {
                    button4.setBackgroundTintList(h6);
                }
            }
        }
        e eVar4 = this.f19032t;
        if (eVar4 == null) {
            t.w("viewModel");
            eVar4 = null;
        }
        int i7 = this.f19030r;
        ArrayList c5 = eVar4.c(i7);
        c5.addAll(eVar4.d(i7));
        m4.d dVar3 = this.f26058j;
        if (dVar3 == null) {
            num = null;
        } else {
            num = dVar3.f25324i;
        }
        if (dVar3 == null) {
            num2 = null;
        } else {
            num2 = dVar3.f25320e;
        }
        if (dVar3 == null) {
            num3 = null;
        } else {
            num3 = dVar3.f25321f;
        }
        if (dVar3 == null) {
            num4 = null;
        } else {
            num4 = dVar3.f25316a;
        }
        this.f19031s = new h((List) c5, (c.b) this, (String) null, num, num2, num3, num4, (Typeface) null, this.f26060l, 268);
        RecyclerView recyclerView = this.f19027o;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            h hVar2 = this.f19031s;
            if (hVar2 == null) {
                t.w("switchAdapter");
            } else {
                hVar = hVar2;
            }
            recyclerView.setAdapter(hVar);
        }
        o();
    }
}
