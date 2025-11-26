package androidx.datastore.core;

public interface Storage<T> {
    StorageConnection<T> createConnection();
}
