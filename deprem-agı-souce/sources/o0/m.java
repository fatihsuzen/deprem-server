package o0;

import N.C0722p;

public abstract class m extends Exception {
    protected m() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(String str) {
        super(str);
        C0722p.f(str, "Detail message must not be empty");
    }
}
