package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;

public class KeyFrames {
    ArrayList<Keys> mKeys = new ArrayList<>();

    public void add(Keys keys) {
        this.mKeys.add(keys);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.mKeys.isEmpty()) {
            sb.append("keyFrames:{\n");
            ArrayList<Keys> arrayList = this.mKeys;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Keys keys = arrayList.get(i5);
                i5++;
                sb.append(keys.toString());
            }
            sb.append("},\n");
        }
        return sb.toString();
    }
}
