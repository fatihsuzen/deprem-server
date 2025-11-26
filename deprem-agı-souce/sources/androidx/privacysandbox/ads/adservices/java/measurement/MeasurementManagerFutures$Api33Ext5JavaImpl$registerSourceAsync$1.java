package androidx.privacysandbox.ads.adservices.java.measurement;

import W2.J;
import W2.u;
import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import w3.M;

@f(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1", f = "MeasurementManagerFutures.kt", l = {143}, m = "invokeSuspend")
final class MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1 extends l implements p {
    final /* synthetic */ Uri $attributionSource;
    final /* synthetic */ InputEvent $inputEvent;
    int label;
    final /* synthetic */ MeasurementManagerFutures.Api33Ext5JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(MeasurementManagerFutures.Api33Ext5JavaImpl api33Ext5JavaImpl, Uri uri, InputEvent inputEvent, C2308e eVar) {
        super(2, eVar);
        this.this$0 = api33Ext5JavaImpl;
        this.$attributionSource = uri;
        this.$inputEvent = inputEvent;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this.this$0, this.$attributionSource, this.$inputEvent, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            MeasurementManager access$getMMeasurementManager$p = this.this$0.mMeasurementManager;
            Uri uri = this.$attributionSource;
            InputEvent inputEvent = this.$inputEvent;
            this.label = 1;
            if (access$getMMeasurementManager$p.registerSource(uri, inputEvent, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
