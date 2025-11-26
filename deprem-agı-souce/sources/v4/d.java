package v4;

import F1.b;
import G2.f;
import Q2.m;
import W2.J;
import W2.u;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b3.C2308e;
import c3.C2316b;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.Regulations;
import com.inmobi.cmp.presentation.components.CmpActivity;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import k3.p;
import k4.h;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import m4.i;
import r4.a;
import s4.c;
import w3.C2865c0;
import w3.C2872g;
import w3.M;

public final class d extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f26062a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmpActivity f26063b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(CmpActivity cmpActivity, C2308e eVar) {
        super(2, eVar);
        this.f26063b = cmpActivity;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new d(this.f26063b, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new d(this.f26063b, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        boolean z4;
        Object f5 = C2316b.f();
        int i5 = this.f26062a;
        f fVar = null;
        if (i5 == 0) {
            u.b(obj);
            f fVar2 = this.f26063b.f7848a;
            if (fVar2 != null) {
                this.f26062a = 1;
                obj = C2872g.g(C2865c0.b(), new e(fVar2, (C2308e) null), this);
                if (obj == f5) {
                    return f5;
                }
            }
            return J.f19942a;
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        c.f25857e = (m4.d) obj;
        CmpActivity cmpActivity = this.f26063b;
        int i6 = CmpActivity.f7847b;
        Bundle extras = cmpActivity.getIntent().getExtras();
        if (extras == null) {
            str = null;
        } else {
            str = extras.getString("EXTRA_ACTION");
        }
        if (str != null) {
            int hashCode = str.hashCode();
            boolean z5 = false;
            if (hashCode != -2113348999) {
                if (hashCode != -1969243076) {
                    if (hashCode != 1166950650) {
                        if (hashCode == 1517267649 && str.equals("ACTION_SHOW_CCPA_SCREEN")) {
                            if (!cmpActivity.isFinishing()) {
                                ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
                                if (choiceCmp.isViewModelAvailable$app_release()) {
                                    boolean z6 = m.l.f960a;
                                    cmpActivity.l(h.CCPA, false);
                                    FragmentManager supportFragmentManager = cmpActivity.getSupportFragmentManager();
                                    t.d(supportFragmentManager, "supportFragmentManager");
                                    if (!supportFragmentManager.isDestroyed() && !supportFragmentManager.isStateSaved()) {
                                        supportFragmentManager.beginTransaction().add((Fragment) new u4.d(), u4.d.f26017w).commit();
                                    }
                                    ChoiceCmpCallback callback = choiceCmp.getCallback();
                                    if (callback != null) {
                                        callback.onCMPUIStatusChanged(new b(DisplayStatus.VISIBLE, "US Regulation Screen shown", Regulations.CCPA, z6));
                                    }
                                } else {
                                    ChoiceCmpCallback callback2 = choiceCmp.getCallback();
                                    if (callback2 != null) {
                                        callback2.onCmpError(ChoiceError.MISSING_INITIALIZATION);
                                    }
                                    cmpActivity.finish();
                                }
                            }
                            return J.f19942a;
                        }
                    } else if (str.equals("ACTION_SHOW_CMP_DIALOG")) {
                        Bundle extras2 = cmpActivity.getIntent().getExtras();
                        if (extras2 != null) {
                            z5 = extras2.getBoolean("EXTRA_FORCE", false);
                        }
                        i d5 = c.o().d();
                        if (d5.f25395a.length() <= 0 || d5.f25396b.length() <= 0 || d5.f25397c.length() <= 0 || d5.f25398d.length() <= 0) {
                            ChoiceCmpCallback callback3 = ChoiceCmp.INSTANCE.getCallback();
                            if (callback3 != null) {
                                callback3.onCmpError(ChoiceError.MISSING_INIT_SCREEN_TEXTS);
                            }
                            cmpActivity.finish();
                            return J.f19942a;
                        }
                        boolean z7 = m.l.f960a;
                        cmpActivity.l(h.GDPR, !z5);
                        m mVar = new m();
                        String simpleName = m.class.getSimpleName();
                        t.d(simpleName, "PrivacyBottomSheet::class.java.simpleName");
                        if (!cmpActivity.isFinishing()) {
                            FragmentManager supportFragmentManager2 = cmpActivity.getSupportFragmentManager();
                            t.d(supportFragmentManager2, "supportFragmentManager");
                            if (!supportFragmentManager2.isDestroyed() && !supportFragmentManager2.isStateSaved()) {
                                mVar.show(supportFragmentManager2, simpleName);
                            }
                        }
                        f fVar3 = cmpActivity.f7848a;
                        if (fVar3 != null) {
                            fVar = fVar3;
                        } else {
                            t.w("viewModel");
                        }
                        fVar.f26066a.j(r4.b.GDPR_SHOWN, true);
                        if (m.l.f960a) {
                            a aVar = fVar.f26066a;
                            t.e(aVar, "storage");
                            aVar.j(r4.b.GBC_SHOWN, true);
                        }
                        ChoiceCmpCallback callback4 = ChoiceCmp.INSTANCE.getCallback();
                        if (callback4 != null) {
                            callback4.onCMPUIStatusChanged(new b(DisplayStatus.VISIBLE, "GDPR screen shown", Regulations.GDPR, z7));
                        }
                        return J.f19942a;
                    }
                } else if (str.equals("ACTION_SHOW_GBC_SCREEN")) {
                    if (!cmpActivity.isFinishing()) {
                        ChoiceCmp choiceCmp2 = ChoiceCmp.INSTANCE;
                        if (choiceCmp2.isViewModelAvailable$app_release()) {
                            cmpActivity.l(h.NR, false);
                            FragmentManager supportFragmentManager3 = cmpActivity.getSupportFragmentManager();
                            t.d(supportFragmentManager3, "supportFragmentManager");
                            if (!supportFragmentManager3.isDestroyed() && !supportFragmentManager3.isStateSaved()) {
                                supportFragmentManager3.beginTransaction().add((Fragment) new m.c(), m.c.f939q).commit();
                            }
                            ChoiceCmpCallback callback5 = choiceCmp2.getCallback();
                            if (callback5 != null) {
                                callback5.onCMPUIStatusChanged(new b(DisplayStatus.VISIBLE, "GBC screen shown", Regulations.NA, true));
                            }
                        } else {
                            ChoiceCmpCallback callback6 = choiceCmp2.getCallback();
                            if (callback6 != null) {
                                callback6.onCmpError(ChoiceError.MISSING_INITIALIZATION);
                            }
                            cmpActivity.finish();
                        }
                    }
                    return J.f19942a;
                }
            } else if (str.equals("ACTION_SHOW_US_REGULATION_SCREEN")) {
                Bundle extras3 = cmpActivity.getIntent().getExtras();
                if (extras3 == null) {
                    z4 = false;
                } else {
                    z4 = extras3.getBoolean("EXTRA_FORCE", false);
                }
                if (!cmpActivity.isFinishing()) {
                    ChoiceCmp choiceCmp3 = ChoiceCmp.INSTANCE;
                    if (choiceCmp3.isViewModelAvailable$app_release()) {
                        boolean z8 = m.l.f960a;
                        f fVar4 = cmpActivity.f7848a;
                        if (fVar4 != null) {
                            fVar = fVar4;
                        } else {
                            t.w("viewModel");
                        }
                        if (fVar.f26068c.f19281b.f19222M) {
                            String str2 = c.f25865m;
                            t.e(R3.h.f18998a, MRAIDCommunicatorUtil.KEY_STATE);
                            if (t.a(str2, DownloadCommon.DOWNLOAD_REPORT_CANCEL)) {
                                cmpActivity.l(h.CCPA, false);
                                FragmentManager supportFragmentManager4 = cmpActivity.getSupportFragmentManager();
                                t.d(supportFragmentManager4, "supportFragmentManager");
                                if (!supportFragmentManager4.isDestroyed() && !supportFragmentManager4.isStateSaved()) {
                                    supportFragmentManager4.beginTransaction().add((Fragment) new u4.d(), u4.d.f26017w).commit();
                                }
                                ChoiceCmpCallback callback7 = choiceCmp3.getCallback();
                                if (callback7 != null) {
                                    callback7.onCMPUIStatusChanged(new b(DisplayStatus.VISIBLE, "US Regulation Screen shown", Regulations.CCPA, z8));
                                }
                            }
                        }
                        cmpActivity.l(h.MSPA, !z4);
                        FragmentManager supportFragmentManager5 = cmpActivity.getSupportFragmentManager();
                        t.d(supportFragmentManager5, "supportFragmentManager");
                        if (!supportFragmentManager5.isDestroyed() && !supportFragmentManager5.isStateSaved()) {
                            supportFragmentManager5.beginTransaction().add((Fragment) new f(), f.f18144x).commit();
                        }
                        ChoiceCmpCallback callback8 = choiceCmp3.getCallback();
                        if (callback8 != null) {
                            callback8.onCMPUIStatusChanged(new b(DisplayStatus.VISIBLE, "US Regulation Screen shown", Regulations.MSPA, z8));
                        }
                    } else {
                        ChoiceCmpCallback callback9 = choiceCmp3.getCallback();
                        if (callback9 != null) {
                            callback9.onCmpError(ChoiceError.MISSING_INITIALIZATION);
                        }
                        cmpActivity.finish();
                    }
                }
                return J.f19942a;
            }
        }
        cmpActivity.finish();
        return J.f19942a;
    }
}
