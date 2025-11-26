package q1;

import java.util.HashMap;
import java.util.Map;
import n1.C1725b;

/* renamed from: q1.a  reason: case insensitive filesystem */
public class C1757a implements C1758b {

    /* renamed from: a  reason: collision with root package name */
    private Map f15881a = new HashMap();

    public boolean a(String str) {
        return this.f15881a.containsKey(str);
    }

    /* renamed from: b */
    public C1725b get(String str) {
        return (C1725b) this.f15881a.get(str);
    }

    public void c(String str, C1725b bVar) {
        this.f15881a.put(str, bVar);
    }

    public void d(C1758b bVar) {
        this.f15881a.clear();
        this.f15881a.putAll(bVar.getAll());
    }

    public Map getAll() {
        return new HashMap(this.f15881a);
    }
}
