package R1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import h2.f1;
import h2.g1;
import java.util.ArrayList;
import k2.C2596f;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2659h;

public final class M extends RecyclerView.Adapter {

    /* renamed from: g  reason: collision with root package name */
    public static final a f4080g = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f4081a;

    /* renamed from: b  reason: collision with root package name */
    private final C2596f f4082b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4083c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4084d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4085e;

    /* renamed from: f  reason: collision with root package name */
    private int f4086f;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private g1 f4087a;

        /* renamed from: b  reason: collision with root package name */
        private final C2596f f4088b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f4089c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ M f4090d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(M m5, g1 g1Var, C2596f fVar, Context context) {
            super(g1Var.getRoot());
            t.e(g1Var, "binding");
            t.e(fVar, "listener");
            t.e(context, "context");
            this.f4090d = m5;
            this.f4087a = g1Var;
            this.f4088b = fVar;
            this.f4089c = context;
        }

        /* access modifiers changed from: private */
        public static final void c(b bVar, C2659h hVar, int i5, View view) {
            bVar.f4088b.a(hVar, i5);
        }

        public final void b(C2659h hVar, int i5, boolean z4) {
            t.e(hVar, "avatar");
            s.h().l(hVar.c()).n(UptodownApp.f13477F.g0(this.f4089c)).l(R.drawable.shape_avatar_item).i(this.f4087a.f23086b);
            this.f4087a.f23086b.setOnClickListener(new N(this, hVar, i5));
            if (z4) {
                this.f4087a.f23089e.setBackground(ContextCompat.getDrawable(this.f4089c, R.drawable.shape_avatar_selected_turbo_item));
                this.f4087a.f23087c.setVisibility(0);
            } else {
                this.f4087a.f23089e.setBackground((Drawable) null);
                this.f4087a.f23087c.setVisibility(8);
            }
            if (this.f4090d.f4085e) {
                this.f4087a.f23088d.setVisibility(8);
            } else {
                this.f4087a.f23088d.setVisibility(0);
            }
        }
    }

    public final class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private f1 f4091a;

        /* renamed from: b  reason: collision with root package name */
        private final C2596f f4092b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f4093c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ M f4094d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(M m5, f1 f1Var, C2596f fVar, Context context) {
            super(f1Var.getRoot());
            t.e(f1Var, "binding");
            t.e(fVar, "listener");
            t.e(context, "context");
            this.f4094d = m5;
            this.f4091a = f1Var;
            this.f4092b = fVar;
            this.f4093c = context;
        }

        /* access modifiers changed from: private */
        public static final void c(c cVar, C2659h hVar, int i5, View view) {
            cVar.f4092b.b(hVar, i5);
        }

        public final void b(C2659h hVar, int i5, int i6, boolean z4) {
            t.e(hVar, "avatar");
            s.h().l(hVar.c()).n(UptodownApp.f13477F.g0(this.f4093c)).l(R.drawable.shape_avatar_item).i(this.f4091a.f23065b);
            this.f4091a.f23065b.setOnClickListener(new O(this, hVar, i5));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i6);
            int dimension = (int) this.f4093c.getResources().getDimension(R.dimen.margin_m);
            if (z4) {
                layoutParams.setMargins(dimension, dimension, dimension, dimension);
                this.f4091a.getRoot().setLayoutParams(layoutParams);
                this.f4091a.getRoot().animate().scaleX(1.2f).scaleY(1.2f).setDuration(200).start();
                this.f4091a.f23066c.setVisibility(0);
                this.f4091a.f23067d.setBackground(ContextCompat.getDrawable(this.f4093c, R.drawable.shape_avatar_selected_item));
                return;
            }
            layoutParams.setMargins(dimension, dimension, dimension, dimension);
            this.f4091a.getRoot().setLayoutParams(layoutParams);
            this.f4091a.getRoot().animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
            this.f4091a.f23067d.setBackground((Drawable) null);
            this.f4091a.f23066c.setVisibility(8);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ M(java.util.ArrayList r2, k2.C2596f r3, int r4, int r5, boolean r6, int r7, kotlin.jvm.internal.C2633k r8) {
        /*
            r1 = this;
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r5 = r0
        L_0x0006:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x0011
            r7 = r0
        L_0x000b:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x0013
        L_0x0011:
            r7 = r6
            goto L_0x000b
        L_0x0013:
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.M.<init>(java.util.ArrayList, k2.f, int, int, boolean, int, kotlin.jvm.internal.k):void");
    }

    public final ArrayList b() {
        return this.f4081a;
    }

    public final int c() {
        return this.f4086f;
    }

    public final void d(int i5) {
        this.f4086f = i5;
    }

    public int getItemCount() {
        return this.f4081a.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
        t.e(viewHolder, "viewHolder");
        Object obj = this.f4081a.get(i5);
        t.d(obj, "get(...)");
        C2659h hVar = (C2659h) obj;
        boolean z4 = false;
        if (viewHolder instanceof c) {
            c cVar = (c) viewHolder;
            int i6 = this.f4084d;
            if (this.f4086f == i5) {
                z4 = true;
            }
            cVar.b(hVar, i5, i6, z4);
        } else if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            if (this.f4086f == i5) {
                z4 = true;
            }
            bVar.b(hVar, i5, z4);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        t.e(viewGroup, "viewGroup");
        int i6 = this.f4083c;
        if (i6 == 0) {
            f1 c5 = f1.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            t.d(c5, "inflate(...)");
            C2596f fVar = this.f4082b;
            Context context = viewGroup.getContext();
            t.d(context, "getContext(...)");
            return new c(this, c5, fVar, context);
        } else if (i6 == 1) {
            g1 c6 = g1.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            t.d(c6, "inflate(...)");
            C2596f fVar2 = this.f4082b;
            Context context2 = viewGroup.getContext();
            t.d(context2, "getContext(...)");
            return new b(this, c6, fVar2, context2);
        } else {
            throw new IllegalArgumentException("ViewHolder unknown!!");
        }
    }

    public M(ArrayList arrayList, C2596f fVar, int i5, int i6, boolean z4) {
        t.e(arrayList, "avatars");
        t.e(fVar, "listener");
        this.f4081a = arrayList;
        this.f4082b = fVar;
        this.f4083c = i5;
        this.f4084d = i6;
        this.f4085e = z4;
        this.f4086f = -1;
    }
}
