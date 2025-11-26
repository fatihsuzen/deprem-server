package q1;

import java.util.HashMap;
import java.util.Map;
import n1.C1726c;

/* renamed from: q1.c  reason: case insensitive filesystem */
public class C1759c implements C1758b {

    /* renamed from: a  reason: collision with root package name */
    private Map f15882a = new HashMap();

    public boolean a(String str) {
        return this.f15882a.containsKey(str);
    }

    public void b(String str, C1726c cVar) {
        this.f15882a.put(str, cVar);
    }

    public C1726c get(String str) {
        return (C1726c) this.f15882a.get(str);
    }

    public Map getAll() {
        return new HashMap(this.f15882a);
    }
}
