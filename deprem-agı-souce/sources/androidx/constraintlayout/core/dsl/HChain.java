package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Chain;
import androidx.constraintlayout.core.dsl.Constraint;
import androidx.constraintlayout.core.dsl.Helper;
import java.util.Map;

public class HChain extends Chain {
    private HAnchor mEnd = new HAnchor(Constraint.HSide.END);
    private HAnchor mLeft = new HAnchor(Constraint.HSide.LEFT);
    private HAnchor mRight = new HAnchor(Constraint.HSide.RIGHT);
    private HAnchor mStart = new HAnchor(Constraint.HSide.START);

    public class HAnchor extends Chain.Anchor {
        HAnchor(Constraint.HSide hSide) {
            super(Constraint.Side.valueOf(hSide.name()));
        }
    }

    public HChain(String str) {
        super(str);
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.HORIZONTAL_CHAIN));
    }

    public HAnchor getEnd() {
        return this.mEnd;
    }

    public HAnchor getLeft() {
        return this.mLeft;
    }

    public HAnchor getRight() {
        return this.mRight;
    }

    public HAnchor getStart() {
        return this.mStart;
    }

    public void linkToEnd(Constraint.HAnchor hAnchor) {
        linkToEnd(hAnchor, 0);
    }

    public void linkToLeft(Constraint.HAnchor hAnchor) {
        linkToLeft(hAnchor, 0);
    }

    public void linkToRight(Constraint.HAnchor hAnchor) {
        linkToRight(hAnchor, 0);
    }

    public void linkToStart(Constraint.HAnchor hAnchor) {
        linkToStart(hAnchor, 0);
    }

    public void linkToEnd(Constraint.HAnchor hAnchor, int i5) {
        linkToEnd(hAnchor, i5, Integer.MIN_VALUE);
    }

    public void linkToLeft(Constraint.HAnchor hAnchor, int i5) {
        linkToLeft(hAnchor, i5, Integer.MIN_VALUE);
    }

    public void linkToRight(Constraint.HAnchor hAnchor, int i5) {
        linkToRight(hAnchor, i5, Integer.MIN_VALUE);
    }

    public void linkToStart(Constraint.HAnchor hAnchor, int i5) {
        linkToStart(hAnchor, i5, Integer.MIN_VALUE);
    }

    public void linkToEnd(Constraint.HAnchor hAnchor, int i5, int i6) {
        HAnchor hAnchor2 = this.mEnd;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i5;
        hAnchor2.mGoneMargin = i6;
        this.configMap.put(TtmlNode.END, hAnchor2.toString());
    }

    public void linkToLeft(Constraint.HAnchor hAnchor, int i5, int i6) {
        HAnchor hAnchor2 = this.mLeft;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i5;
        hAnchor2.mGoneMargin = i6;
        this.configMap.put(TtmlNode.LEFT, hAnchor2.toString());
    }

    public void linkToRight(Constraint.HAnchor hAnchor, int i5, int i6) {
        HAnchor hAnchor2 = this.mRight;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i5;
        hAnchor2.mGoneMargin = i6;
        this.configMap.put(TtmlNode.RIGHT, hAnchor2.toString());
    }

    public void linkToStart(Constraint.HAnchor hAnchor, int i5, int i6) {
        HAnchor hAnchor2 = this.mStart;
        hAnchor2.mConnection = hAnchor;
        hAnchor2.mMargin = i5;
        hAnchor2.mGoneMargin = i6;
        this.configMap.put("start", hAnchor2.toString());
    }

    public HChain(String str, String str2) {
        super(str);
        this.config = str2;
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.HORIZONTAL_CHAIN));
        Map<String, String> convertConfigToMap = convertConfigToMap();
        this.configMap = convertConfigToMap;
        if (convertConfigToMap.containsKey("contains")) {
            Ref.addStringToReferences(this.configMap.get("contains"), this.references);
        }
    }
}
