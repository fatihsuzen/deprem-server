package androidx.sqlite;

public interface SQLiteConnection extends AutoCloseable {
    void close();

    SQLiteStatement prepare(String str);
}
