package r0;

import java.util.Arrays;
import java.util.List;

public class s extends t {

    /* renamed from: a  reason: collision with root package name */
    private final List f16376a;

    public s(List list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f16376a = list;
    }
}
