package J;

import O.C0732a;
import O.C0734c;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* renamed from: J.a  reason: case insensitive filesystem */
public final class C0645a extends C0732a {
    @NonNull
    public static final Parcelable.Creator<C0645a> CREATOR = new C0648d();

    /* renamed from: a  reason: collision with root package name */
    final Intent f2616a;

    public C0645a(Intent intent) {
        this.f2616a = intent;
    }

    public Intent c() {
        return this.f2616a;
    }

    public String d() {
        String stringExtra = this.f2616a.getStringExtra("google.message_id");
        if (stringExtra == null) {
            return this.f2616a.getStringExtra("message_id");
        }
        return stringExtra;
    }

    /* access modifiers changed from: package-private */
    public final Integer f() {
        if (this.f2616a.hasExtra("google.product_id")) {
            return Integer.valueOf(this.f2616a.getIntExtra("google.product_id", 0));
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        int a5 = C0734c.a(parcel);
        C0734c.o(parcel, 1, this.f2616a, i5, false);
        C0734c.b(parcel, a5);
    }
}
