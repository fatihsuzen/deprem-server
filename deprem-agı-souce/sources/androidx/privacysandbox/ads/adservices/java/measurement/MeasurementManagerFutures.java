package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.measurement.DeletionRequest;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.SourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebTriggerRegistrationRequest;
import b3.C2308e;
import b3.C2312i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import n0.C1722d;
import w3.C2865c0;
import w3.N;
import w3.O;

public abstract class MeasurementManagerFutures {
    public static final Companion Companion = new Companion((C2633k) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final MeasurementManagerFutures from(Context context) {
            t.e(context, "context");
            MeasurementManager obtain = MeasurementManager.Companion.obtain(context);
            if (obtain != null) {
                return new Api33Ext5JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final MeasurementManagerFutures from(Context context) {
        return Companion.from(context);
    }

    public abstract C1722d deleteRegistrationsAsync(DeletionRequest deletionRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract C1722d getMeasurementApiStatusAsync();

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract C1722d registerSourceAsync(Uri uri, InputEvent inputEvent);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    @ExperimentalFeatures.RegisterSourceOptIn
    public abstract C1722d registerSourceAsync(SourceRegistrationRequest sourceRegistrationRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract C1722d registerTriggerAsync(Uri uri);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract C1722d registerWebSourceAsync(WebSourceRegistrationRequest webSourceRegistrationRequest);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract C1722d registerWebTriggerAsync(WebTriggerRegistrationRequest webTriggerRegistrationRequest);

    private static final class Api33Ext5JavaImpl extends MeasurementManagerFutures {
        /* access modifiers changed from: private */
        public final MeasurementManager mMeasurementManager;

        public Api33Ext5JavaImpl(MeasurementManager measurementManager) {
            t.e(measurementManager, "mMeasurementManager");
            this.mMeasurementManager = measurementManager;
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C1722d deleteRegistrationsAsync(DeletionRequest deletionRequest) {
            t.e(deletionRequest, "deletionRequest");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1(this, deletionRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C1722d getMeasurementApiStatusAsync() {
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1(this, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C1722d registerSourceAsync(Uri uri, InputEvent inputEvent) {
            t.e(uri, "attributionSource");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this, uri, inputEvent, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C1722d registerTriggerAsync(Uri uri) {
            t.e(uri, "trigger");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1(this, uri, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C1722d registerWebSourceAsync(WebSourceRegistrationRequest webSourceRegistrationRequest) {
            t.e(webSourceRegistrationRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(this, webSourceRegistrationRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @DoNotInline
        public C1722d registerWebTriggerAsync(WebTriggerRegistrationRequest webTriggerRegistrationRequest) {
            t.e(webTriggerRegistrationRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1(this, webTriggerRegistrationRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }

        @DoNotInline
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        @ExperimentalFeatures.RegisterSourceOptIn
        public C1722d registerSourceAsync(SourceRegistrationRequest sourceRegistrationRequest) {
            t.e(sourceRegistrationRequest, "request");
            return CoroutineAdapterKt.asListenableFuture$default(C2876i.b(N.a(C2865c0.a()), (C2312i) null, (O) null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$2(this, sourceRegistrationRequest, (C2308e) null), 3, (Object) null), (Object) null, 1, (Object) null);
        }
    }
}
