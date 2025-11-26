package n1;

import java.util.function.Predicate;
import p1.d;

public class s implements C1726c {

    /* renamed from: a  reason: collision with root package name */
    private Predicate f15629a = new r();

    /* renamed from: b  reason: collision with root package name */
    private Integer f15630b = null;

    public s(Integer num) {
        setValue(num);
    }

    public static /* synthetic */ boolean a(Integer num) {
        return true;
    }

    /* renamed from: b */
    public Integer getValue() {
        return this.f15630b;
    }

    public void setValue(Object obj) {
        Integer num = (Integer) obj;
        if (this.f15629a.test(num)) {
            this.f15630b = num;
            return;
        }
        throw new d("Invalid value '" + num + "'");
    }
}
