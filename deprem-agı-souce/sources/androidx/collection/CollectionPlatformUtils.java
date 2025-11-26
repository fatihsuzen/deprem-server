package androidx.collection;

public final class CollectionPlatformUtils {
    public static final CollectionPlatformUtils INSTANCE = new CollectionPlatformUtils();

    private CollectionPlatformUtils() {
    }

    public final IndexOutOfBoundsException createIndexOutOfBoundsException$collection() {
        return new ArrayIndexOutOfBoundsException();
    }
}
