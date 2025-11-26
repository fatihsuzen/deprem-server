package androidx.sqlite;

public interface SQLiteDriver {
    SQLiteConnection open(String str);
}
