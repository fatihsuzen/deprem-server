package androidx.work;

import androidx.work.Data;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;

public final class OverwritingInputMerger extends InputMerger {
    public Data merge(List<Data> list) {
        t.e(list, "inputs");
        Data.Builder builder = new Data.Builder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Data keyValueMap : list) {
            linkedHashMap.putAll(keyValueMap.getKeyValueMap());
        }
        builder.putAll((Map<String, ? extends Object>) linkedHashMap);
        return builder.build();
    }
}
