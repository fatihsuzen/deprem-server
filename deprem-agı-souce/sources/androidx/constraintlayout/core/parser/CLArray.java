package androidx.constraintlayout.core.parser;

import java.util.ArrayList;

public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    /* access modifiers changed from: protected */
    public String toFormattedJSON(int i5, int i6) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i6 > 0 || json.length() + i5 >= CLElement.sMaxLine) {
            sb.append("[\n");
            ArrayList<CLElement> arrayList = this.mElements;
            int size = arrayList.size();
            int i7 = 0;
            boolean z4 = true;
            while (i7 < size) {
                CLElement cLElement = arrayList.get(i7);
                i7++;
                CLElement cLElement2 = cLElement;
                if (!z4) {
                    sb.append(",\n");
                } else {
                    z4 = false;
                }
                addIndent(sb, CLElement.sBaseIndent + i5);
                sb.append(cLElement2.toFormattedJSON(CLElement.sBaseIndent + i5, i6 - 1));
            }
            sb.append("\n");
            addIndent(sb, i5);
            sb.append("]");
        } else {
            sb.append(json);
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "[");
        boolean z4 = true;
        for (int i5 = 0; i5 < this.mElements.size(); i5++) {
            if (!z4) {
                sb.append(", ");
            } else {
                z4 = false;
            }
            sb.append(this.mElements.get(i5).toJSON());
        }
        return sb + "]";
    }
}
