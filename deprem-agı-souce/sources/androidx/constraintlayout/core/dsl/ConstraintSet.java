package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;

public class ConstraintSet {
    ArrayList<Constraint> mConstraints = new ArrayList<>();
    ArrayList<Helper> mHelpers = new ArrayList<>();
    private final String mName;

    public ConstraintSet(String str) {
        this.mName = str;
    }

    public void add(Constraint constraint) {
        this.mConstraints.add(constraint);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.mName + ":{\n");
        int i5 = 0;
        if (!this.mConstraints.isEmpty()) {
            ArrayList<Constraint> arrayList = this.mConstraints;
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                Constraint constraint = arrayList.get(i6);
                i6++;
                sb.append(constraint.toString());
            }
        }
        if (!this.mHelpers.isEmpty()) {
            ArrayList<Helper> arrayList2 = this.mHelpers;
            int size2 = arrayList2.size();
            while (i5 < size2) {
                Helper helper = arrayList2.get(i5);
                i5++;
                sb.append(helper.toString());
            }
        }
        sb.append("},\n");
        return sb.toString();
    }

    public void add(Helper helper) {
        this.mHelpers.add(helper);
    }
}
