package Q2;

import J2.f;
import J2.u;
import P3.k;
import R2.c;
import T3.i;
import V2.a;
import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import kotlin.jvm.internal.t;
import m.l;
import o4.E;
import o4.j;
import o4.m;
import o4.p;

public final class o extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final u f18933a;

    /* renamed from: b  reason: collision with root package name */
    public final i f18934b;

    /* renamed from: c  reason: collision with root package name */
    public final f f18935c;

    /* renamed from: d  reason: collision with root package name */
    public final k f18936d;

    /* renamed from: e  reason: collision with root package name */
    public final E f18937e;

    /* renamed from: f  reason: collision with root package name */
    public final j f18938f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f18939g;

    /* renamed from: h  reason: collision with root package name */
    public final m4.i f18940h;

    /* renamed from: i  reason: collision with root package name */
    public final c f18941i;

    /* renamed from: j  reason: collision with root package name */
    public final p f18942j;

    public o(u uVar, i iVar, f fVar, k kVar, E e5, m mVar, boolean z4, m4.i iVar2, c cVar, p pVar) {
        t.e(uVar, "tcModel");
        t.e(iVar, "portalConfig");
        t.e(fVar, "googleVendorList");
        t.e(e5, "portalConfigRepository");
        t.e(mVar, "consentRepository");
        t.e(iVar2, "initScreen");
        t.e(cVar, "gbcPurposeResponse");
        t.e(pVar, "gbcConsentRepository");
        this.f18933a = uVar;
        this.f18934b = iVar;
        this.f18935c = fVar;
        this.f18936d = kVar;
        this.f18937e = e5;
        this.f18938f = mVar;
        this.f18939g = z4;
        this.f18940h = iVar2;
        this.f18941i = cVar;
        this.f18942j = pVar;
    }

    public final String a() {
        String str;
        if (a.e()) {
            str = this.f18940h.f25403i.f25335d;
        } else if (a.d()) {
            str = this.f18940h.f25404j.f25305c;
            if (str.length() == 0) {
                str = this.f18940h.f25396b;
            }
        } else {
            str = this.f18940h.f25396b;
        }
        if (l.f960a) {
            return t.n(str, this.f18941i.f18954b.f18949c);
        }
        return str;
    }

    public final void b() {
        String str = this.f18934b.f19281b.f19218I;
        if (str != null) {
            PrivacyEncodingMode privacyEncodingMode = PrivacyEncodingMode.GPP;
            if (str.equals(privacyEncodingMode.getValue())) {
                ((m) this.f18938f).b(privacyEncodingMode, true, true);
                return;
            }
        }
        String str2 = this.f18934b.f19281b.f19218I;
        if (str2 != null) {
            PrivacyEncodingMode privacyEncodingMode2 = PrivacyEncodingMode.TCF;
            if (str2.equals(privacyEncodingMode2.getValue())) {
                ((m) this.f18938f).b(privacyEncodingMode2, true, true);
                return;
            }
        }
        ((m) this.f18938f).b(PrivacyEncodingMode.TCF_AND_GPP, true, true);
    }
}
