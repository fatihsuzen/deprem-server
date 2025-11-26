package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Constraint;
import java.util.HashMap;
import java.util.Map;

public class Helper {
    protected static final Map<Constraint.Side, String> sideMap;
    protected static final Map<Type, String> typeMap;
    protected String config;
    protected Map<String, String> configMap = new HashMap();
    protected final String name;
    protected HelperType type = null;

    public static final class HelperType {
        final String mName;

        public HelperType(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    public enum Type {
        VERTICAL_GUIDELINE,
        HORIZONTAL_GUIDELINE,
        VERTICAL_CHAIN,
        HORIZONTAL_CHAIN,
        BARRIER
    }

    static {
        HashMap hashMap = new HashMap();
        sideMap = hashMap;
        hashMap.put(Constraint.Side.LEFT, "'left'");
        hashMap.put(Constraint.Side.RIGHT, "'right'");
        hashMap.put(Constraint.Side.TOP, "'top'");
        hashMap.put(Constraint.Side.BOTTOM, "'bottom'");
        hashMap.put(Constraint.Side.START, "'start'");
        hashMap.put(Constraint.Side.END, "'end'");
        hashMap.put(Constraint.Side.BASELINE, "'baseline'");
        HashMap hashMap2 = new HashMap();
        typeMap = hashMap2;
        hashMap2.put(Type.VERTICAL_GUIDELINE, "vGuideline");
        hashMap2.put(Type.HORIZONTAL_GUIDELINE, "hGuideline");
        hashMap2.put(Type.VERTICAL_CHAIN, "vChain");
        hashMap2.put(Type.HORIZONTAL_CHAIN, "hChain");
        hashMap2.put(Type.BARRIER, "barrier");
    }

    public Helper(String str, HelperType helperType) {
        this.name = str;
        this.type = helperType;
    }

    public static void main(String[] strArr) {
        System.out.println(new Barrier("abc", "['a1', 'b2']").toString());
    }

    public void append(Map<String, String> map, StringBuilder sb) {
        if (!map.isEmpty()) {
            for (String next : map.keySet()) {
                sb.append(next);
                sb.append(":");
                sb.append(map.get(next));
                sb.append(",\n");
            }
        }
    }

    public Map<String, String> convertConfigToMap() {
        String str = this.config;
        if (str == null || str.length() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < this.config.length(); i7++) {
            char charAt = this.config.charAt(i7);
            if (charAt == ':') {
                str2 = sb.toString();
                sb.setLength(0);
            } else if (charAt == ',' && i5 == 0 && i6 == 0) {
                hashMap.put(str2, sb.toString());
                sb.setLength(0);
                str2 = "";
            } else if (charAt != ' ') {
                if (charAt == '[') {
                    i5++;
                } else if (charAt == ']') {
                    i5--;
                } else if (charAt == '{') {
                    i6++;
                } else if (charAt == '}') {
                    i6--;
                }
                sb.append(charAt);
            }
        }
        hashMap.put(str2, sb.toString());
        return hashMap;
    }

    public String getConfig() {
        return this.config;
    }

    public String getId() {
        return this.name;
    }

    public HelperType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.name + ":{\n");
        if (this.type != null) {
            sb.append("type:'");
            sb.append(this.type.toString());
            sb.append("',\n");
        }
        Map<String, String> map = this.configMap;
        if (map != null) {
            append(map, sb);
        }
        sb.append("},\n");
        return sb.toString();
    }

    public Helper(String str, HelperType helperType, String str2) {
        this.name = str;
        this.type = helperType;
        this.config = str2;
        this.configMap = convertConfigToMap();
    }
}
