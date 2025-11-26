package R1;

import S1.k;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import k2.C2591a;
import k2.C2611v;
import kotlin.jvm.internal.t;
import l2.C2657f;

/* renamed from: R1.i  reason: case insensitive filesystem */
public final class C0978i extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final C2611v f4218a;

    /* renamed from: b  reason: collision with root package name */
    private final C2591a f4219b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f4220c = new ArrayList();

    /* renamed from: R1.i$a */
    public final class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private C2611v f4221a;

        /* renamed from: b  reason: collision with root package name */
        private C2591a f4222b;

        /* renamed from: c  reason: collision with root package name */
        private final ImageView f4223c;

        /* renamed from: d  reason: collision with root package name */
        private final TextView f4224d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f4225e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C0978i f4226f;

        /* renamed from: R1.i$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0058a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f4227a;

            /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    l2.f$c[] r0 = l2.C2657f.c.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    l2.f$c r1 = l2.C2657f.c.TRENDING     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    l2.f$c r1 = l2.C2657f.c.LATEST     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    l2.f$c r1 = l2.C2657f.c.UPDATE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    l2.f$c r1 = l2.C2657f.c.PROMOTED     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    l2.f$c r1 = l2.C2657f.c.EDITOR_CHOICE     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    f4227a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: R1.C0978i.a.C0058a.<clinit>():void");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(C0978i iVar, View view, C2611v vVar, C2591a aVar) {
            super(view);
            t.e(view, "itemView");
            t.e(aVar, "actionsClickListener");
            this.f4226f = iVar;
            this.f4221a = vVar;
            this.f4222b = aVar;
            this.f4223c = (ImageView) view.findViewById(R.id.iv_feature_home);
            TextView textView = (TextView) view.findViewById(R.id.tv_tag_feature_home);
            this.f4224d = textView;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_name_feature_home);
            this.f4225e = textView2;
            k.a aVar2 = k.f32g;
            textView.setTypeface(aVar2.w());
            textView2.setTypeface(aVar2.w());
        }

        /* access modifiers changed from: private */
        public static final void d(a aVar, C2657f fVar, View view) {
            if (aVar.f4221a != null && aVar.getBindingAdapterPosition() != -1) {
                C2611v vVar = aVar.f4221a;
                t.b(vVar);
                vVar.b(fVar);
            }
        }

        /* access modifiers changed from: private */
        public static final boolean e(a aVar, C2657f fVar, int i5, View view) {
            aVar.f4222b.a(fVar, i5);
            return true;
        }

        private final void f() {
            this.f4224d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.bg_dev_on_board));
            this.f4224d.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.main_dark_grey));
        }

        private final void g() {
            this.f4224d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_tag_latest));
        }

        private final void h() {
            this.f4224d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_tag_promoted));
        }

        private final void i() {
            this.f4224d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_tag_trending));
        }

        private final void j() {
            this.f4224d.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.shape_bg_accent_green));
        }

        public final void c(C2657f fVar, int i5) {
            t.e(fVar, "appInfo");
            UptodownApp.a aVar = UptodownApp.f13477F;
            int F4 = aVar.F();
            int dimension = (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_s);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(F4, -2);
            layoutParams.setMargins(dimension, 0, dimension, 0);
            this.itemView.setLayoutParams(layoutParams);
            if (fVar.u0() != C2657f.c.NONE) {
                this.f4224d.setText(fVar.t0());
                this.f4224d.setVisibility(0);
                this.f4224d.setTextColor(ContextCompat.getColor(this.itemView.getContext(), R.color.white));
                int i6 = C0058a.f4227a[fVar.u0().ordinal()];
                if (i6 == 1) {
                    i();
                } else if (i6 == 2) {
                    g();
                } else if (i6 == 3) {
                    j();
                } else if (i6 == 4) {
                    h();
                } else if (i6 == 5) {
                    f();
                }
            }
            this.f4225e.setText(fVar.N());
            this.f4223c.setLayoutParams(new RelativeLayout.LayoutParams(-1, aVar.w()));
            w f5 = s.h().l(fVar.y()).f();
            Context context = this.itemView.getContext();
            t.d(context, "getContext(...)");
            f5.n(aVar.f0(context)).i(this.f4223c);
            this.f4223c.setOnClickListener(new C0976g(this, fVar));
            this.f4223c.setOnLongClickListener(new C0977h(this, fVar, i5));
        }
    }

    public C0978i(C2611v vVar, C2591a aVar) {
        t.e(aVar, "actionsClickListener");
        this.f4218a = vVar;
        this.f4219b = aVar;
    }

    public final ArrayList a() {
        return this.f4220c;
    }

    /* renamed from: b */
    public void onBindViewHolder(a aVar, int i5) {
        t.e(aVar, "holder");
        int size = i5 % this.f4220c.size();
        Object obj = this.f4220c.get(size);
        t.d(obj, "get(...)");
        aVar.c((C2657f) obj, size);
    }

    /* renamed from: c */
    public a onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_fragment_header_image, viewGroup, false);
        t.b(inflate);
        return new a(this, inflate, this.f4218a, this.f4219b);
    }

    public final void d(ArrayList arrayList) {
        t.e(arrayList, "headerPrograms");
        ArrayList arrayList2 = this.f4220c;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f4220c.size() * 100;
    }
}
