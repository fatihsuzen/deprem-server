package androidx.privacysandbox.ads.adservices.common;

import X2.T;
import android.adservices.common.AdData;
import android.adservices.common.AdFilters;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@SuppressLint({"ClassVerificationFailure"})
public final class AdData {
    private final Set<Integer> adCounterKeys;
    private final AdFilters adFilters;
    private final String adRenderId;
    private final String metadata;
    private final Uri renderUri;

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    private static final class Ext10Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final android.adservices.common.AdData convertAdData(AdData adData) {
                AdFilters adFilters;
                t.e(adData, "adData");
                AdData.Builder a5 = g.a().setMetadata(adData.getMetadata()).setRenderUri(adData.getRenderUri()).setAdCounterKeys(adData.getAdCounterKeys());
                AdFilters adFilters2 = adData.getAdFilters();
                if (adFilters2 != null) {
                    adFilters = adFilters2.convertToAdServices$ads_adservices_release();
                } else {
                    adFilters = null;
                }
                android.adservices.common.AdData a6 = f.a(a5.setAdFilters(adFilters).setAdRenderId(adData.getAdRenderId()));
                t.d(a6, "Builder()\n              …                 .build()");
                return a6;
            }

            private Companion() {
            }
        }

        private Ext10Impl() {
        }
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    private static final class Ext4Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final android.adservices.common.AdData convertAdData(AdData adData) {
                t.e(adData, "adData");
                if (!adData.getAdCounterKeys().isEmpty()) {
                    Log.w("AdData", "adCounterKeys is ignored. Min version to use adCounterKeys is API 33 ext 8 or API 31/32 ext 9");
                }
                if (adData.getAdFilters() != null) {
                    Log.w("AdData", "adFilters is ignored. Min version to use adFilters is API 33 ext 8 or API 31/32 ext 9");
                }
                if (adData.getAdRenderId() != null) {
                    Log.w("AdData", "adRenderId is ignored. Min version to use adRenderId is API 31 ext 10");
                }
                android.adservices.common.AdData a5 = g.a().setMetadata(adData.getMetadata()).setRenderUri(adData.getRenderUri()).build();
                t.d(a5, "Builder()\n              …                 .build()");
                return a5;
            }

            private Companion() {
            }
        }

        private Ext4Impl() {
        }
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    private static final class Ext8Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final android.adservices.common.AdData convertAdData(AdData adData) {
                AdFilters adFilters;
                t.e(adData, "adData");
                if (adData.getAdRenderId() != null) {
                    Log.w("AdData", "adRenderId is ignored. Min version to use adRenderId is API 31 ext 10");
                }
                AdData.Builder a5 = g.a().setMetadata(adData.getMetadata()).setRenderUri(adData.getRenderUri()).setAdCounterKeys(adData.getAdCounterKeys());
                AdFilters adFilters2 = adData.getAdFilters();
                if (adFilters2 != null) {
                    adFilters = adFilters2.convertToAdServices$ads_adservices_release();
                } else {
                    adFilters = null;
                }
                android.adservices.common.AdData a6 = a5.setAdFilters(adFilters).build();
                t.d(a6, "Builder()\n              …                 .build()");
                return a6;
            }

            private Companion() {
            }
        }

        private Ext8Impl() {
        }
    }

    @ExperimentalFeatures.Ext10OptIn
    public AdData(Uri uri, String str, Set<Integer> set, AdFilters adFilters2, String str2) {
        t.e(uri, "renderUri");
        t.e(str, TtmlNode.TAG_METADATA);
        t.e(set, "adCounterKeys");
        this.renderUri = uri;
        this.metadata = str;
        this.adCounterKeys = set;
        this.adFilters = adFilters2;
        this.adRenderId = str2;
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.AdData convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            return Ext10Impl.Companion.convertAdData(this);
        }
        if (adServicesInfo.adServicesVersion() >= 8 || adServicesInfo.extServicesVersionS() >= 9) {
            return Ext8Impl.Companion.convertAdData(this);
        }
        return Ext4Impl.Companion.convertAdData(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdData)) {
            return false;
        }
        AdData adData = (AdData) obj;
        if (!t.a(this.renderUri, adData.renderUri) || !t.a(this.metadata, adData.metadata) || !t.a(this.adCounterKeys, adData.adCounterKeys) || !t.a(this.adFilters, adData.adFilters) || !t.a(this.adRenderId, adData.adRenderId)) {
            return false;
        }
        return true;
    }

    public final Set<Integer> getAdCounterKeys() {
        return this.adCounterKeys;
    }

    public final AdFilters getAdFilters() {
        return this.adFilters;
    }

    public final String getAdRenderId() {
        return this.adRenderId;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final Uri getRenderUri() {
        return this.renderUri;
    }

    public int hashCode() {
        int i5;
        int hashCode = ((((this.renderUri.hashCode() * 31) + this.metadata.hashCode()) * 31) + this.adCounterKeys.hashCode()) * 31;
        AdFilters adFilters2 = this.adFilters;
        int i6 = 0;
        if (adFilters2 != null) {
            i5 = adFilters2.hashCode();
        } else {
            i5 = 0;
        }
        int i7 = (hashCode + i5) * 31;
        String str = this.adRenderId;
        if (str != null) {
            i6 = str.hashCode();
        }
        return i7 + i6;
    }

    public String toString() {
        return "AdData: renderUri=" + this.renderUri + ", metadata='" + this.metadata + "', adCounterKeys=" + this.adCounterKeys + ", adFilters=" + this.adFilters + ", adRenderId=" + this.adRenderId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdData(Uri uri, String str, Set set, AdFilters adFilters2, String str2, int i5, C2633k kVar) {
        this(uri, str, (i5 & 4) != 0 ? T.d() : set, (i5 & 8) != 0 ? null : adFilters2, (i5 & 16) != 0 ? null : str2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdData(Uri uri, String str, Set set, AdFilters adFilters2, int i5, C2633k kVar) {
        this(uri, str, (i5 & 4) != 0 ? T.d() : set, (i5 & 8) != 0 ? null : adFilters2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @ExperimentalFeatures.Ext8OptIn
    public AdData(Uri uri, String str, Set<Integer> set, AdFilters adFilters2) {
        this(uri, str, set, adFilters2, (String) null);
        t.e(uri, "renderUri");
        t.e(str, TtmlNode.TAG_METADATA);
        t.e(set, "adCounterKeys");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdData(Uri uri, String str) {
        this(uri, str, T.d(), (AdFilters) null);
        t.e(uri, "renderUri");
        t.e(str, TtmlNode.TAG_METADATA);
    }
}
