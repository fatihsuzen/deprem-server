package androidx.constraintlayout.core.parser;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

public class CLObject extends CLContainer implements Iterable<CLKey> {

    private static class CLObjectIterator implements Iterator<CLKey> {
        int mIndex = 0;
        CLObject mObject;

        CLObjectIterator(CLObject cLObject) {
            this.mObject = cLObject;
        }

        public boolean hasNext() {
            if (this.mIndex < this.mObject.size()) {
                return true;
            }
            return false;
        }

        public CLKey next() {
            CLKey cLKey = (CLKey) this.mObject.mElements.get(this.mIndex);
            this.mIndex++;
            return cLKey;
        }
    }

    public CLObject(char[] cArr) {
        super(cArr);
    }

    public static CLObject allocate(char[] cArr) {
        return new CLObject(cArr);
    }

    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this);
    }

    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "{ ");
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        boolean z4 = true;
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList.get(i5);
            i5++;
            CLElement cLElement2 = cLElement;
            if (!z4) {
                sb.append(", ");
            } else {
                z4 = false;
            }
            sb.append(cLElement2.toJSON());
        }
        sb.append(" }");
        return sb.toString();
    }

    public String toFormattedJSON(int i5, int i6) {
        StringBuilder sb = new StringBuilder(getDebugName());
        sb.append("{\n");
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        boolean z4 = true;
        int i7 = 0;
        while (i7 < size) {
            CLElement cLElement = arrayList.get(i7);
            i7++;
            CLElement cLElement2 = cLElement;
            if (!z4) {
                sb.append(",\n");
            } else {
                z4 = false;
            }
            sb.append(cLElement2.toFormattedJSON(CLElement.sBaseIndent + i5, i6 - 1));
        }
        sb.append("\n");
        addIndent(sb, i5);
        sb.append("}");
        return sb.toString();
    }

    @NonNull
    public CLObject clone() {
        return (CLObject) super.clone();
    }
}
