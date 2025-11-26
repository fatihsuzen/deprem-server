package P0;

public interface j {

    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f3887a;

        private a(int i5) {
            this.f3887a = i5;
        }

        public int b() {
            return this.f3887a;
        }
    }

    a b(String str);
}
