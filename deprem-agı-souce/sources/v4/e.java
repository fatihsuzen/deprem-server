package v4;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import com.inmobi.cmp.data.model.ChoiceColor;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import m4.d;
import o4.C2707b;
import w3.M;

public final class e extends l implements p {

    /* renamed from: a  reason: collision with root package name */
    public int f26064a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f26065b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(f fVar, C2308e eVar) {
        super(2, eVar);
        this.f26065b = fVar;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new e(this.f26065b, eVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        M m5 = (M) obj;
        return new e(this.f26065b, (C2308e) obj2).invokeSuspend(J.f19942a);
    }

    public final Object invokeSuspend(Object obj) {
        d dVar;
        Object f5 = C2316b.f();
        int i5 = this.f26064a;
        if (i5 == 0) {
            u.b(obj);
            C2707b bVar = this.f26065b.f26067b;
            this.f26064a = 1;
            ChoiceColor choiceColor = bVar.f25565a;
            if (choiceColor != null) {
                bVar.f25567c.getClass();
                t.e(choiceColor, "colorResources");
                dVar = new d(choiceColor.getDividerColor(), choiceColor.getTabBackgroundColor(), choiceColor.getSearchBarBackgroundColor(), choiceColor.getSearchBarForegroundColor(), choiceColor.getToggleActiveColor(), choiceColor.getToggleInactiveColor(), choiceColor.getGlobalBackgroundColor(), choiceColor.getTitleTextColor(), choiceColor.getBodyTextColor(), choiceColor.getTabTextColor(), choiceColor.getMenuTextColor(), choiceColor.getLinkTextColor(), choiceColor.getButtonTextColor(), choiceColor.getButtonDisabledTextColor(), choiceColor.getButtonBackgroundColor(), choiceColor.getButtonDisabledBackgroundColor());
            } else {
                ChoiceColor choiceColor2 = bVar.f25566b;
                if (choiceColor2 != null) {
                    bVar.f25567c.getClass();
                    t.e(choiceColor2, "colorResources");
                    dVar = new d(choiceColor2.getDividerColor(), choiceColor2.getTabBackgroundColor(), choiceColor2.getSearchBarBackgroundColor(), choiceColor2.getSearchBarForegroundColor(), choiceColor2.getToggleActiveColor(), choiceColor2.getToggleInactiveColor(), choiceColor2.getGlobalBackgroundColor(), choiceColor2.getTitleTextColor(), choiceColor2.getBodyTextColor(), choiceColor2.getTabTextColor(), choiceColor2.getMenuTextColor(), choiceColor2.getLinkTextColor(), choiceColor2.getButtonTextColor(), choiceColor2.getButtonDisabledTextColor(), choiceColor2.getButtonBackgroundColor(), choiceColor2.getButtonDisabledBackgroundColor());
                } else {
                    dVar = null;
                }
            }
            if (dVar == f5) {
                return f5;
            }
            return dVar;
        } else if (i5 == 1) {
            u.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
