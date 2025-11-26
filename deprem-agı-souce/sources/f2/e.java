package f2;

import S1.f;
import S1.i;
import S1.k;
import X1.C2230g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;
import b2.C2276H;
import b2.C2289i;
import b2.C2291k;
import java.io.File;
import kotlin.jvm.internal.t;
import t3.s;

public final class e extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2230g f21615a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f21616b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f21617c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f21618d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f21619e;

    /* renamed from: f  reason: collision with root package name */
    private final CheckBox f21620f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view, C2230g gVar) {
        super(view);
        t.e(view, "itemView");
        t.e(gVar, "listener");
        this.f21615a = gVar;
        View findViewById = view.findViewById(f.iv_icon_file_item);
        t.d(findViewById, "findViewById(...)");
        this.f21616b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(f.tv_name_file_item);
        t.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f21617c = textView;
        View findViewById3 = view.findViewById(f.tv_date_file_item);
        t.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f21618d = textView2;
        View findViewById4 = view.findViewById(f.tv_size_file_item);
        t.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f21619e = textView3;
        View findViewById5 = view.findViewById(f.cb_checked_file_item);
        t.d(findViewById5, "findViewById(...)");
        this.f21620f = (CheckBox) findViewById5;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.w());
    }

    /* access modifiers changed from: private */
    public static final void d(e eVar, Object obj, View view) {
        int absoluteAdapterPosition = eVar.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition != -1) {
            eVar.f21615a.a(obj, absoluteAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean e(e eVar, Object obj, View view) {
        int absoluteAdapterPosition = eVar.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition == -1) {
            return true;
        }
        eVar.f21615a.b(obj, absoluteAdapterPosition);
        return true;
    }

    public final void c(Object obj, boolean z4, boolean z5) {
        long j5;
        boolean z6;
        String str;
        String str2;
        Drawable drawable;
        t.e(obj, "file");
        this.itemView.setOnClickListener(new c(this, obj));
        this.itemView.setOnLongClickListener(new d(this, obj));
        if (obj instanceof File) {
            File file = (File) obj;
            str2 = file.getName();
            str = new C2289i().k(file.lastModified());
            z6 = file.isDirectory();
            j5 = file.length();
        } else if (obj instanceof DocumentFile) {
            DocumentFile documentFile = (DocumentFile) obj;
            str2 = documentFile.getName();
            str = new C2289i().k(documentFile.lastModified());
            z6 = documentFile.isDirectory();
            j5 = documentFile.length();
        } else {
            j5 = 0;
            str2 = null;
            str = null;
            z6 = false;
        }
        if (str2 != null) {
            this.f21617c.setText(str2);
            if (z6) {
                this.f21619e.setText(k.f32g.h().getString(i.core_directory_elementes_count, new Object[]{new C2289i().d(obj)}));
                drawable = AppCompatResources.getDrawable(this.f21617c.getContext(), S1.e.core_vector_folder);
            } else {
                TextView textView = this.f21619e;
                C2291k kVar = new C2291k();
                Context context = this.itemView.getContext();
                t.d(context, "getContext(...)");
                textView.setText(kVar.d(j5, context));
                if (s.D(str2, ".apk", false, 2, (Object) null)) {
                    C2276H h5 = C2276H.f20479a;
                    if (h5.a().get(str2) != null) {
                        drawable = (Drawable) h5.a().get(str2);
                    } else {
                        drawable = AppCompatResources.getDrawable(this.f21617c.getContext(), S1.e.core_vector_apk);
                    }
                } else if (s.D(str2, ".xapk", false, 2, (Object) null) || s.D(str2, ".apks", false, 2, (Object) null)) {
                    drawable = AppCompatResources.getDrawable(this.f21617c.getContext(), S1.e.core_vector_xapk);
                } else if (s.D(str2, ".zip", false, 2, (Object) null)) {
                    drawable = AppCompatResources.getDrawable(this.f21617c.getContext(), S1.e.core_vector_zip);
                } else {
                    drawable = AppCompatResources.getDrawable(this.f21617c.getContext(), S1.e.core_vector_file);
                }
            }
            this.f21616b.setImageDrawable(drawable);
        }
        if (str != null) {
            this.f21618d.setText(str);
        }
        if (z4) {
            this.f21620f.setVisibility(0);
            this.f21619e.setVisibility(4);
            this.f21620f.setChecked(z5);
            return;
        }
        this.f21620f.setVisibility(8);
        this.f21619e.setVisibility(0);
    }
}
