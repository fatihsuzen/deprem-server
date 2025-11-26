package androidx.constraintlayout.core.parser;

import androidx.annotation.NonNull;
import j$.util.Objects;
import java.io.PrintStream;
import java.util.ArrayList;

public class CLContainer extends CLElement {
    ArrayList<CLElement> mElements = new ArrayList<>();

    public CLContainer(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLContainer(cArr);
    }

    public void add(CLElement cLElement) {
        this.mElements.add(cLElement);
        if (CLParser.sDebug) {
            PrintStream printStream = System.out;
            printStream.println("added element " + cLElement + " to " + this);
        }
    }

    public void clear() {
        this.mElements.clear();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLContainer)) {
            return false;
        }
        return this.mElements.equals(((CLContainer) obj).mElements);
    }

    public CLElement get(String str) throws CLParsingException {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList.get(i5);
            i5++;
            CLKey cLKey = (CLKey) cLElement;
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        throw new CLParsingException("no element for key <" + str + ">", this);
    }

    public CLArray getArray(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        throw new CLParsingException("no array found for key <" + str + ">, found [" + cLElement.getStrClass() + "] : " + cLElement, this);
    }

    public CLArray getArrayOrCreate(String str) {
        CLArray arrayOrNull = getArrayOrNull(str);
        if (arrayOrNull != null) {
            return arrayOrNull;
        }
        CLArray cLArray = new CLArray(new char[0]);
        put(str, cLArray);
        return cLArray;
    }

    public CLArray getArrayOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLArray) {
            return (CLArray) orNull;
        }
        return null;
    }

    public boolean getBoolean(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        throw new CLParsingException("no boolean found for key <" + str + ">, found [" + cLElement.getStrClass() + "] : " + cLElement, this);
    }

    public float getFloat(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        throw new CLParsingException("no float found for key <" + str + ">, found [" + cLElement.getStrClass() + "] : " + cLElement, this);
    }

    public float getFloatOrNaN(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLNumber) {
            return orNull.getFloat();
        }
        return Float.NaN;
    }

    public int getInt(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        throw new CLParsingException("no int found for key <" + str + ">, found [" + cLElement.getStrClass() + "] : " + cLElement, this);
    }

    public CLObject getObject(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        throw new CLParsingException("no object found for key <" + str + ">, found [" + cLElement.getStrClass() + "] : " + cLElement, this);
    }

    public CLObject getObjectOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLObject) {
            return (CLObject) orNull;
        }
        return null;
    }

    public CLElement getOrNull(String str) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList.get(i5);
            i5++;
            CLKey cLKey = (CLKey) cLElement;
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        return null;
    }

    public String getString(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        String strClass = cLElement != null ? cLElement.getStrClass() : null;
        throw new CLParsingException("no string found for key <" + str + ">, found [" + strClass + "] : " + cLElement, this);
    }

    public String getStringOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public boolean has(String str) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList.get(i5);
            i5++;
            CLElement cLElement2 = cLElement;
            if ((cLElement2 instanceof CLKey) && ((CLKey) cLElement2).content().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.mElements, Integer.valueOf(super.hashCode()));
    }

    public ArrayList<String> names() {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList2.get(i5);
            i5++;
            CLElement cLElement2 = cLElement;
            if (cLElement2 instanceof CLKey) {
                arrayList.add(((CLKey) cLElement2).content());
            }
        }
        return arrayList;
    }

    public void put(String str, CLElement cLElement) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement2 = arrayList.get(i5);
            i5++;
            CLKey cLKey = (CLKey) cLElement2;
            if (cLKey.content().equals(str)) {
                cLKey.set(cLElement);
                return;
            }
        }
        this.mElements.add((CLKey) CLKey.allocate(str, cLElement));
    }

    public void putNumber(String str, float f5) {
        put(str, new CLNumber(f5));
    }

    public void putString(String str, String str2) {
        CLString cLString = new CLString(str2.toCharArray());
        cLString.setStart(0);
        cLString.setEnd((long) (str2.length() - 1));
        put(str, cLString);
    }

    public void remove(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            CLElement cLElement = arrayList2.get(i6);
            i6++;
            CLElement cLElement2 = cLElement;
            if (((CLKey) cLElement2).content().equals(str)) {
                arrayList.add(cLElement2);
            }
        }
        int size2 = arrayList.size();
        while (i5 < size2) {
            Object obj = arrayList.get(i5);
            i5++;
            this.mElements.remove((CLElement) obj);
        }
    }

    public int size() {
        return this.mElements.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList.get(i5);
            i5++;
            CLElement cLElement2 = cLElement;
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append(cLElement2);
        }
        return super.toString() + " = <" + sb + " >";
    }

    @NonNull
    public CLContainer clone() {
        CLContainer cLContainer = (CLContainer) super.clone();
        ArrayList<CLElement> arrayList = new ArrayList<>(this.mElements.size());
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            CLElement cLElement = arrayList2.get(i5);
            i5++;
            CLElement clone = cLElement.clone();
            clone.setContainer(cLContainer);
            arrayList.add(clone);
        }
        cLContainer.mElements = arrayList;
        return cLContainer;
    }

    public String getStringOrNull(int i5) {
        CLElement orNull = getOrNull(i5);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public float getFloat(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        throw new CLParsingException("no float at index " + i5, this);
    }

    public int getInt(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        throw new CLParsingException("no int at index " + i5, this);
    }

    public CLElement getOrNull(int i5) {
        if (i5 < 0 || i5 >= this.mElements.size()) {
            return null;
        }
        return this.mElements.get(i5);
    }

    public CLElement get(int i5) throws CLParsingException {
        if (i5 >= 0 && i5 < this.mElements.size()) {
            return this.mElements.get(i5);
        }
        throw new CLParsingException("no element at index " + i5, this);
    }

    public CLArray getArray(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        throw new CLParsingException("no array at index " + i5, this);
    }

    public boolean getBoolean(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        throw new CLParsingException("no boolean at index " + i5, this);
    }

    public CLObject getObject(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        throw new CLParsingException("no object at index " + i5, this);
    }

    public String getString(int i5) throws CLParsingException {
        CLElement cLElement = get(i5);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        throw new CLParsingException("no string at index " + i5, this);
    }
}
