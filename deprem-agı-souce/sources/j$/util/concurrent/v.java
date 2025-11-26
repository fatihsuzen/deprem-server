package j$.util.concurrent;

public final class v extends ThreadLocal {
    public final Object initialValue() {
        return new ThreadLocalRandom(0);
    }
}
