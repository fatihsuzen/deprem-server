package Q2;

import W2.J;
import W2.u;
import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintSet;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

public final class a extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap f18901a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f18902b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Bitmap bitmap, m mVar, C2308e eVar) {
        super(2, eVar);
        this.f18901a = bitmap;
        this.f18902b = mVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new a(this.f18901a, this.f18902b, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new a(this.f18901a, this.f18902b, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        C2316b.f();
        u.b(obj);
        Bitmap bitmap = this.f18901a;
        if (bitmap != null) {
            m mVar = this.f18902b;
            ImageView imageView = mVar.f18918b;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
            ImageView imageView2 = mVar.f18918b;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
        m mVar2 = this.f18902b;
        String str = m.f18916m;
        mVar2.getClass();
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mVar2.f18917a);
        ImageView imageView3 = mVar2.f18918b;
        if (imageView3 != null && imageView3.getVisibility() == 0) {
            ImageView imageView4 = mVar2.f18918b;
            if (imageView4 != null) {
                Button button = mVar2.f18919c;
                if (button != null) {
                    constraintSet.connect(button.getId(), 4, imageView4.getId(), 4);
                }
                constraintSet.applyTo(mVar2.f18917a);
            }
        } else {
            TextView textView = mVar2.f18924h;
            if (textView != null) {
                Button button2 = mVar2.f18919c;
                if (button2 != null) {
                    constraintSet.connect(button2.getId(), 4, textView.getId(), 4);
                }
                constraintSet.applyTo(mVar2.f18917a);
            }
        }
        return J.f19942a;
    }
}
