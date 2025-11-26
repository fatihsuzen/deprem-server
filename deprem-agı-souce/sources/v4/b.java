package v4;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;
import m4.d;

public class b extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public Toolbar f26049a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26050b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f26051c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintLayout f26052d;

    /* renamed from: e  reason: collision with root package name */
    public SearchView f26053e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f26054f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f26055g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f26056h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f26057i;

    /* renamed from: j  reason: collision with root package name */
    public d f26058j;

    /* renamed from: k  reason: collision with root package name */
    public Typeface f26059k;

    /* renamed from: l  reason: collision with root package name */
    public Typeface f26060l;

    public static final WindowInsetsCompat f(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        t.d(insets, "insets.getInsets(WindowI…Compat.Type.systemBars())");
        t.d(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return windowInsetsCompat;
    }

    public static void g(View view) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new a());
    }

    public void onCreate(Bundle bundle) {
        int i5;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 29) {
            i5 = 16974563;
        } else {
            i5 = 16974392;
        }
        setStyle(1, i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0184  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.t.e(r5, r0)
            super.onViewCreated(r5, r6)
            int r6 = E1.b.f2416j0
            android.view.View r6 = r5.findViewById(r6)
            androidx.appcompat.widget.Toolbar r6 = (androidx.appcompat.widget.Toolbar) r6
            r4.f26049a = r6
            int r6 = E1.b.toolbar_title
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r4.f26050b = r6
            int r6 = E1.b.toolbar_icon
            android.view.View r6 = r5.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r4.f26051c = r6
            int r6 = E1.b.toolbar_container
            android.view.View r6 = r5.findViewById(r6)
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            r4.f26052d = r6
            int r6 = E1.b.toolbar_search
            android.view.View r6 = r5.findViewById(r6)
            androidx.appcompat.widget.SearchView r6 = (androidx.appcompat.widget.SearchView) r6
            int r0 = androidx.appcompat.R.id.search_src_text
            android.view.View r0 = r6.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r4.f26054f = r0
            int r0 = androidx.appcompat.R.id.search_mag_icon
            android.view.View r0 = r6.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r4.f26055g = r0
            int r0 = androidx.appcompat.R.id.search_close_btn
            android.view.View r0 = r6.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r4.f26056h = r0
            r4.f26053e = r6
            int r6 = E1.b.toolbar_menu
            android.view.View r6 = r5.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r4.f26057i = r6
            g(r5)
            m4.c r5 = s4.c.f25856d
            r6 = 0
            if (r5 != 0) goto L_0x006c
            r0 = r6
            goto L_0x006e
        L_0x006c:
            android.graphics.Typeface r0 = r5.f25314a
        L_0x006e:
            r4.f26059k = r0
            if (r5 != 0) goto L_0x0074
            r5 = r6
            goto L_0x0076
        L_0x0074:
            android.graphics.Typeface r5 = r5.f25315b
        L_0x0076:
            r4.f26060l = r5
            m4.d r5 = s4.c.f25857e
            r4.f26058j = r5
            r0 = 32
            if (r5 != 0) goto L_0x0082
            goto L_0x01ad
        L_0x0082:
            java.lang.Integer r1 = r5.f25317b
            if (r1 != 0) goto L_0x0087
            goto L_0x009b
        L_0x0087:
            int r1 = r1.intValue()
            androidx.appcompat.widget.Toolbar r2 = r4.f26049a
            if (r2 != 0) goto L_0x0090
            goto L_0x0093
        L_0x0090:
            r2.setBackgroundColor(r1)
        L_0x0093:
            androidx.constraintlayout.widget.ConstraintLayout r2 = r4.f26052d
            if (r2 != 0) goto L_0x0098
            goto L_0x009b
        L_0x0098:
            r2.setBackgroundColor(r1)
        L_0x009b:
            java.lang.Integer r1 = r5.f25325j
            if (r1 != 0) goto L_0x00a0
            goto L_0x00c0
        L_0x00a0:
            int r1 = r1.intValue()
            android.widget.ImageView r2 = r4.f26051c
            if (r2 != 0) goto L_0x00a9
            goto L_0x00b0
        L_0x00a9:
            android.content.res.ColorStateList r3 = android.content.res.ColorStateList.valueOf(r1)
            r2.setImageTintList(r3)
        L_0x00b0:
            android.widget.ImageView r2 = r4.f26057i
            if (r2 != 0) goto L_0x00b5
            goto L_0x00bc
        L_0x00b5:
            android.content.res.ColorStateList r3 = android.content.res.ColorStateList.valueOf(r1)
            r2.setImageTintList(r3)
        L_0x00bc:
            android.widget.TextView r2 = r4.f26050b
            if (r2 != 0) goto L_0x00c2
        L_0x00c0:
            r1 = r6
            goto L_0x00c7
        L_0x00c2:
            r2.setTextColor(r1)
            W2.J r1 = W2.J.f19942a
        L_0x00c7:
            if (r1 != 0) goto L_0x013e
            android.widget.ImageView r1 = r4.f26051c
            if (r1 != 0) goto L_0x00ce
            goto L_0x00f0
        L_0x00ce:
            android.content.Context r2 = r4.requireContext()
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.uiMode
            r2 = r2 & 48
            android.content.Context r3 = r4.requireContext()
            if (r2 != r0) goto L_0x00e7
            int r2 = E1.a.colorWhite
            goto L_0x00e9
        L_0x00e7:
            int r2 = E1.a.colorBlack
        L_0x00e9:
            android.content.res.ColorStateList r2 = androidx.core.content.ContextCompat.getColorStateList(r3, r2)
            r1.setImageTintList(r2)
        L_0x00f0:
            android.widget.ImageView r1 = r4.f26057i
            if (r1 != 0) goto L_0x00f5
            goto L_0x0117
        L_0x00f5:
            android.content.Context r2 = r4.requireContext()
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.uiMode
            r2 = r2 & 48
            android.content.Context r3 = r4.requireContext()
            if (r2 != r0) goto L_0x010e
            int r2 = E1.a.colorWhite
            goto L_0x0110
        L_0x010e:
            int r2 = E1.a.colorBlack
        L_0x0110:
            android.content.res.ColorStateList r2 = androidx.core.content.ContextCompat.getColorStateList(r3, r2)
            r1.setImageTintList(r2)
        L_0x0117:
            android.widget.TextView r1 = r4.f26050b
            if (r1 != 0) goto L_0x011c
            goto L_0x013e
        L_0x011c:
            android.content.Context r2 = r4.requireContext()
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.uiMode
            r2 = r2 & 48
            android.content.Context r3 = r4.requireContext()
            if (r2 != r0) goto L_0x0135
            int r2 = E1.a.colorWhite
            goto L_0x0137
        L_0x0135:
            int r2 = E1.a.colorBlack
        L_0x0137:
            android.content.res.ColorStateList r2 = androidx.core.content.ContextCompat.getColorStateList(r3, r2)
            r1.setTextColor(r2)
        L_0x013e:
            java.lang.Integer r1 = r5.f25318c
            if (r1 != 0) goto L_0x0144
            r1 = r6
            goto L_0x0156
        L_0x0144:
            int r1 = r1.intValue()
            androidx.appcompat.widget.SearchView r2 = r4.f26053e
            if (r2 != 0) goto L_0x014d
            goto L_0x0154
        L_0x014d:
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r2.setBackgroundTintList(r1)
        L_0x0154:
            W2.J r1 = W2.J.f19942a
        L_0x0156:
            if (r1 != 0) goto L_0x017f
            androidx.appcompat.widget.SearchView r1 = r4.f26053e
            if (r1 != 0) goto L_0x015d
            goto L_0x017f
        L_0x015d:
            android.content.Context r2 = r1.getContext()
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            int r2 = r2.uiMode
            r2 = r2 & 48
            android.content.Context r3 = r1.getContext()
            if (r2 != r0) goto L_0x0176
            int r2 = E1.a.search_bar_dark_color
            goto L_0x0178
        L_0x0176:
            int r2 = E1.a.search_bar_light_color
        L_0x0178:
            android.content.res.ColorStateList r2 = androidx.core.content.ContextCompat.getColorStateList(r3, r2)
            r1.setBackgroundTintList(r2)
        L_0x017f:
            java.lang.Integer r5 = r5.f25319d
            if (r5 != 0) goto L_0x0184
            goto L_0x01ad
        L_0x0184:
            int r5 = r5.intValue()
            android.widget.EditText r6 = r4.f26054f
            if (r6 != 0) goto L_0x018d
            goto L_0x0193
        L_0x018d:
            r6.setTextColor(r5)
            r6.setHintTextColor(r5)
        L_0x0193:
            android.widget.ImageView r6 = r4.f26055g
            if (r6 != 0) goto L_0x0198
            goto L_0x019f
        L_0x0198:
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r5)
            r6.setImageTintList(r1)
        L_0x019f:
            android.widget.ImageView r6 = r4.f26056h
            if (r6 != 0) goto L_0x01a4
            goto L_0x01ab
        L_0x01a4:
            android.content.res.ColorStateList r5 = android.content.res.ColorStateList.valueOf(r5)
            r6.setImageTintList(r5)
        L_0x01ab:
            W2.J r6 = W2.J.f19942a
        L_0x01ad:
            if (r6 != 0) goto L_0x024b
            android.widget.ImageView r5 = r4.f26051c
            if (r5 != 0) goto L_0x01b4
            goto L_0x01d6
        L_0x01b4:
            android.content.Context r6 = r4.requireContext()
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.uiMode
            r6 = r6 & 48
            android.content.Context r1 = r4.requireContext()
            if (r6 != r0) goto L_0x01cd
            int r6 = E1.a.colorWhite
            goto L_0x01cf
        L_0x01cd:
            int r6 = E1.a.colorBlack
        L_0x01cf:
            android.content.res.ColorStateList r6 = androidx.core.content.ContextCompat.getColorStateList(r1, r6)
            r5.setImageTintList(r6)
        L_0x01d6:
            android.widget.ImageView r5 = r4.f26057i
            if (r5 != 0) goto L_0x01db
            goto L_0x01fd
        L_0x01db:
            android.content.Context r6 = r4.requireContext()
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.uiMode
            r6 = r6 & 48
            android.content.Context r1 = r4.requireContext()
            if (r6 != r0) goto L_0x01f4
            int r6 = E1.a.colorWhite
            goto L_0x01f6
        L_0x01f4:
            int r6 = E1.a.colorBlack
        L_0x01f6:
            android.content.res.ColorStateList r6 = androidx.core.content.ContextCompat.getColorStateList(r1, r6)
            r5.setImageTintList(r6)
        L_0x01fd:
            android.widget.TextView r5 = r4.f26050b
            if (r5 != 0) goto L_0x0202
            goto L_0x0224
        L_0x0202:
            android.content.Context r6 = r4.requireContext()
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.uiMode
            r6 = r6 & 48
            android.content.Context r1 = r4.requireContext()
            if (r6 != r0) goto L_0x021b
            int r6 = E1.a.colorWhite
            goto L_0x021d
        L_0x021b:
            int r6 = E1.a.colorBlack
        L_0x021d:
            android.content.res.ColorStateList r6 = androidx.core.content.ContextCompat.getColorStateList(r1, r6)
            r5.setTextColor(r6)
        L_0x0224:
            androidx.appcompat.widget.SearchView r5 = r4.f26053e
            if (r5 != 0) goto L_0x0229
            goto L_0x024b
        L_0x0229:
            android.content.Context r6 = r5.getContext()
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.uiMode
            r6 = r6 & 48
            android.content.Context r1 = r5.getContext()
            if (r6 != r0) goto L_0x0242
            int r6 = E1.a.search_bar_dark_color
            goto L_0x0244
        L_0x0242:
            int r6 = E1.a.search_bar_light_color
        L_0x0244:
            android.content.res.ColorStateList r6 = androidx.core.content.ContextCompat.getColorStateList(r1, r6)
            r5.setBackgroundTintList(r6)
        L_0x024b:
            android.graphics.Typeface r5 = r4.f26059k
            if (r5 != 0) goto L_0x0250
            goto L_0x0258
        L_0x0250:
            android.widget.TextView r6 = r4.f26050b
            if (r6 != 0) goto L_0x0255
            goto L_0x0258
        L_0x0255:
            r6.setTypeface(r5)
        L_0x0258:
            android.graphics.Typeface r5 = r4.f26060l
            if (r5 != 0) goto L_0x025d
            goto L_0x0261
        L_0x025d:
            android.widget.EditText r6 = r4.f26054f
            if (r6 != 0) goto L_0x0262
        L_0x0261:
            return
        L_0x0262:
            r6.setTypeface(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.b.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
