package T3;

import com.inmobi.cmp.data.model.ChoiceColor;
import kotlin.jvm.internal.t;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final String f19295a;

    /* renamed from: b  reason: collision with root package name */
    public final ChoiceColor f19296b;

    /* renamed from: c  reason: collision with root package name */
    public final ChoiceColor f19297c;

    public l(String str, ChoiceColor choiceColor, ChoiceColor choiceColor2) {
        t.e(str, "themeMode");
        this.f19295a = str;
        this.f19296b = choiceColor;
        this.f19297c = choiceColor2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (t.a(this.f19295a, lVar.f19295a) && t.a(this.f19296b, lVar.f19296b) && t.a(this.f19297c, lVar.f19297c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i5;
        int hashCode = this.f19295a.hashCode() * 31;
        ChoiceColor choiceColor = this.f19296b;
        int i6 = 0;
        if (choiceColor == null) {
            i5 = 0;
        } else {
            i5 = choiceColor.hashCode();
        }
        int i7 = (hashCode + i5) * 31;
        ChoiceColor choiceColor2 = this.f19297c;
        if (choiceColor2 != null) {
            i6 = choiceColor2.hashCode();
        }
        return i7 + i6;
    }

    public final String toString() {
        return "ThemeConfig(themeMode=" + this.f19295a + ", lightModeColors=" + this.f19296b + ", darkModeColors=" + this.f19297c + ')';
    }
}
