package n1;

import java.util.function.Predicate;
import p1.d;

public class q implements C1726c {

    /* renamed from: a  reason: collision with root package name */
    private Predicate f15627a;

    /* renamed from: b  reason: collision with root package name */
    private Character f15628b = null;

    public q(Character ch, Predicate predicate) {
        this.f15627a = predicate;
        setValue(ch);
    }

    /* renamed from: a */
    public Character getValue() {
        return this.f15628b;
    }

    public void setValue(Object obj) {
        Character valueOf = Character.valueOf(obj.toString().charAt(0));
        if (this.f15627a.test(valueOf)) {
            this.f15628b = valueOf;
            return;
        }
        throw new d("Invalid value '" + valueOf + "'");
    }
}
