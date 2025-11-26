package androidx.room;

import androidx.annotation.RequiresApi;
import d3.C2344a;
import d3.C2345b;

public final class FtsOptions {
    public static final FtsOptions INSTANCE = new FtsOptions();
    public static final String TOKENIZER_ICU = "icu";
    public static final String TOKENIZER_PORTER = "porter";
    public static final String TOKENIZER_SIMPLE = "simple";
    @RequiresApi(21)
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    public enum MatchInfo {
        FTS3,
        FTS4;

        static {
            MatchInfo[] $values;
            $ENTRIES = C2345b.a($values);
        }

        public static C2344a getEntries() {
            return $ENTRIES;
        }
    }

    public enum Order {
        ASC,
        DESC;

        static {
            Order[] $values;
            $ENTRIES = C2345b.a($values);
        }

        public static C2344a getEntries() {
            return $ENTRIES;
        }
    }

    private FtsOptions() {
    }
}
