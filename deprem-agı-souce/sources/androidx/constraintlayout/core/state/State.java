package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.core.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.FlowReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.constraintlayout.core.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.core.state.helpers.VerticalChainReference;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import b.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class State {
    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = 0;
    static final int UNKNOWN = -1;
    ArrayList<Object> mBaselineNeeded;
    ArrayList<ConstraintWidget> mBaselineNeededWidgets;
    boolean mDirtyBaselineNeededWidgets;
    private CorePixelDp mDpToPixel;
    protected HashMap<Object, HelperReference> mHelperReferences = new HashMap<>();
    private boolean mIsLtr = true;
    private int mNumHelpers;
    public final ConstraintReference mParent;
    protected HashMap<Object, Reference> mReferences = new HashMap<>();
    HashMap<String, ArrayList<String>> mTags = new HashMap<>();

    public enum Chain {
        SPREAD,
        SPREAD_INSIDE,
        PACKED;
        
        public static Map<String, Chain> chainMap;
        public static Map<String, Integer> valueMap;

        static {
            Chain chain;
            Chain chain2;
            Chain chain3;
            chainMap = new HashMap();
            valueMap = new HashMap();
            chainMap.put("packed", chain3);
            chainMap.put("spread_inside", chain2);
            chainMap.put("spread", chain);
            valueMap.put("packed", 2);
            valueMap.put("spread_inside", 1);
            valueMap.put("spread", 0);
        }

        public static Chain getChainByString(String str) {
            if (chainMap.containsKey(str)) {
                return chainMap.get(str);
            }
            return null;
        }

        public static int getValueByString(String str) {
            if (valueMap.containsKey(str)) {
                return valueMap.get(str).intValue();
            }
            return -1;
        }
    }

    public enum Constraint {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        TOP_TO_BASELINE,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BOTTOM_TO_BASELINE,
        BASELINE_TO_BASELINE,
        BASELINE_TO_TOP,
        BASELINE_TO_BOTTOM,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY,
        CIRCULAR_CONSTRAINT
    }

    public enum Direction {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        HORIZONTAL_FLOW,
        VERTICAL_FLOW,
        GRID,
        ROW,
        COLUMN,
        FLOW
    }

    public enum Wrap {
        NONE,
        CHAIN,
        ALIGNED;
        
        public static Map<String, Integer> valueMap;
        public static Map<String, Wrap> wrapMap;

        static {
            Wrap wrap;
            Wrap wrap2;
            Wrap wrap3;
            wrapMap = new HashMap();
            valueMap = new HashMap();
            wrapMap.put("none", wrap);
            wrapMap.put("chain", wrap2);
            wrapMap.put("aligned", wrap3);
            valueMap.put("none", 0);
            valueMap.put("chain", 3);
            valueMap.put("aligned", 2);
        }

        public static Wrap getChainByString(String str) {
            if (wrapMap.containsKey(str)) {
                return wrapMap.get(str);
            }
            return null;
        }

        public static int getValueByString(String str) {
            if (valueMap.containsKey(str)) {
                return valueMap.get(str).intValue();
            }
            return -1;
        }
    }

    public State() {
        ConstraintReference constraintReference = new ConstraintReference(this);
        this.mParent = constraintReference;
        this.mNumHelpers = 0;
        this.mBaselineNeeded = new ArrayList<>();
        this.mBaselineNeededWidgets = new ArrayList<>();
        this.mDirtyBaselineNeededWidgets = true;
        Integer num = PARENT;
        constraintReference.setKey(num);
        this.mReferences.put(num, constraintReference);
    }

    private String createHelperKey() {
        StringBuilder sb = new StringBuilder();
        sb.append("__HELPER_KEY_");
        int i5 = this.mNumHelpers;
        this.mNumHelpers = i5 + 1;
        sb.append(i5);
        sb.append("__");
        return sb.toString();
    }

    public void apply(ConstraintWidgetContainer constraintWidgetContainer) {
        HelperReference helperReference;
        HelperWidget helperWidget;
        HelperWidget helperWidget2;
        constraintWidgetContainer.removeAllChildren();
        this.mParent.getWidth().apply(this, constraintWidgetContainer, 0);
        this.mParent.getHeight().apply(this, constraintWidgetContainer, 1);
        for (Object next : this.mHelperReferences.keySet()) {
            HelperWidget helperWidget3 = this.mHelperReferences.get(next).getHelperWidget();
            if (helperWidget3 != null) {
                Reference reference = this.mReferences.get(next);
                if (reference == null) {
                    reference = constraints(next);
                }
                reference.setConstraintWidget(helperWidget3);
            }
        }
        for (Object next2 : this.mReferences.keySet()) {
            Reference reference2 = this.mReferences.get(next2);
            if (!(reference2 == this.mParent || !(reference2.getFacade() instanceof HelperReference) || (helperWidget2 = ((HelperReference) reference2.getFacade()).getHelperWidget()) == null)) {
                Reference reference3 = this.mReferences.get(next2);
                if (reference3 == null) {
                    reference3 = constraints(next2);
                }
                reference3.setConstraintWidget(helperWidget2);
            }
        }
        for (Object obj : this.mReferences.keySet()) {
            Reference reference4 = this.mReferences.get(obj);
            if (reference4 != this.mParent) {
                ConstraintWidget constraintWidget = reference4.getConstraintWidget();
                constraintWidget.setDebugName(reference4.getKey().toString());
                constraintWidget.setParent((ConstraintWidget) null);
                if (reference4.getFacade() instanceof GuidelineReference) {
                    reference4.apply();
                }
                constraintWidgetContainer.add(constraintWidget);
            } else {
                reference4.setConstraintWidget(constraintWidgetContainer);
            }
        }
        for (Object obj2 : this.mHelperReferences.keySet()) {
            HelperReference helperReference2 = this.mHelperReferences.get(obj2);
            if (helperReference2.getHelperWidget() != null) {
                ArrayList<Object> arrayList = helperReference2.mReferences;
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj3 = arrayList.get(i5);
                    i5++;
                    helperReference2.getHelperWidget().add(this.mReferences.get(obj3).getConstraintWidget());
                }
                helperReference2.apply();
            } else {
                helperReference2.apply();
            }
        }
        for (Object obj4 : this.mReferences.keySet()) {
            Reference reference5 = this.mReferences.get(obj4);
            if (!(reference5 == this.mParent || !(reference5.getFacade() instanceof HelperReference) || (helperWidget = helperReference.getHelperWidget()) == null)) {
                ArrayList<Object> arrayList2 = (helperReference = (HelperReference) reference5.getFacade()).mReferences;
                int size2 = arrayList2.size();
                int i6 = 0;
                while (i6 < size2) {
                    Object obj5 = arrayList2.get(i6);
                    i6++;
                    Reference reference6 = this.mReferences.get(obj5);
                    if (reference6 != null) {
                        helperWidget.add(reference6.getConstraintWidget());
                    } else if (obj5 instanceof Reference) {
                        helperWidget.add(((Reference) obj5).getConstraintWidget());
                    } else {
                        System.out.println("couldn't find reference for " + obj5);
                    }
                }
                reference5.apply();
            }
        }
        for (Object next3 : this.mReferences.keySet()) {
            Reference reference7 = this.mReferences.get(next3);
            reference7.apply();
            ConstraintWidget constraintWidget2 = reference7.getConstraintWidget();
            if (!(constraintWidget2 == null || next3 == null)) {
                constraintWidget2.stringId = next3.toString();
            }
        }
    }

    public BarrierReference barrier(Object obj, Direction direction) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof BarrierReference)) {
            BarrierReference barrierReference = new BarrierReference(this);
            barrierReference.setBarrierDirection(direction);
            constraints.setFacade(barrierReference);
        }
        return (BarrierReference) constraints.getFacade();
    }

    public void baselineNeededFor(Object obj) {
        this.mBaselineNeeded.add(obj);
        this.mDirtyBaselineNeededWidgets = true;
    }

    public AlignHorizontallyReference centerHorizontally(Object... objArr) {
        AlignHorizontallyReference alignHorizontallyReference = (AlignHorizontallyReference) helper((Object) null, Helper.ALIGN_HORIZONTALLY);
        alignHorizontallyReference.add(objArr);
        return alignHorizontallyReference;
    }

    public AlignVerticallyReference centerVertically(Object... objArr) {
        AlignVerticallyReference alignVerticallyReference = (AlignVerticallyReference) helper((Object) null, Helper.ALIGN_VERTICALLY);
        alignVerticallyReference.add(objArr);
        return alignVerticallyReference;
    }

    public ConstraintReference constraints(Object obj) {
        Reference reference = this.mReferences.get(obj);
        if (reference == null) {
            reference = createConstraintReference(obj);
            this.mReferences.put(obj, reference);
            reference.setKey(obj);
        }
        if (reference instanceof ConstraintReference) {
            return (ConstraintReference) reference;
        }
        return null;
    }

    public int convertDimension(Object obj) {
        if (obj instanceof Float) {
            return Math.round(((Float) obj).floatValue());
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public ConstraintReference createConstraintReference(Object obj) {
        return new ConstraintReference(this);
    }

    public void directMapping() {
        for (Object next : this.mReferences.keySet()) {
            ConstraintReference constraints = constraints(next);
            if (w.a(constraints)) {
                constraints.setView(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public CorePixelDp getDpToPixel() {
        return this.mDpToPixel;
    }

    public FlowReference getFlow(Object obj, boolean z4) {
        FlowReference flowReference;
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof FlowReference)) {
            if (z4) {
                flowReference = new FlowReference(this, Helper.VERTICAL_FLOW);
            } else {
                flowReference = new FlowReference(this, Helper.HORIZONTAL_FLOW);
            }
            constraints.setFacade(flowReference);
        }
        return (FlowReference) constraints.getFacade();
    }

    @NonNull
    public GridReference getGrid(@NonNull Object obj, @NonNull String str) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof GridReference)) {
            Helper helper = Helper.GRID;
            if (str.charAt(0) == 'r') {
                helper = Helper.ROW;
            } else if (str.charAt(0) == 'c') {
                helper = Helper.COLUMN;
            }
            constraints.setFacade(new GridReference(this, helper));
        }
        return (GridReference) constraints.getFacade();
    }

    public FlowReference getHorizontalFlow() {
        return (FlowReference) helper((Object) null, Helper.HORIZONTAL_FLOW);
    }

    public ArrayList<String> getIdsForTag(String str) {
        if (this.mTags.containsKey(str)) {
            return this.mTags.get(str);
        }
        return null;
    }

    public FlowReference getVerticalFlow() {
        return (FlowReference) helper((Object) null, Helper.VERTICAL_FLOW);
    }

    public GuidelineReference guideline(Object obj, int i5) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof GuidelineReference)) {
            GuidelineReference guidelineReference = new GuidelineReference(this);
            guidelineReference.setOrientation(i5);
            guidelineReference.setKey(obj);
            constraints.setFacade(guidelineReference);
        }
        return (GuidelineReference) constraints.getFacade();
    }

    public State height(Dimension dimension) {
        return setHeight(dimension);
    }

    public HelperReference helper(Object obj, Helper helper) {
        if (obj == null) {
            obj = createHelperKey();
        }
        HelperReference helperReference = this.mHelperReferences.get(obj);
        if (helperReference == null) {
            switch (helper.ordinal()) {
                case 0:
                    helperReference = new HorizontalChainReference(this);
                    break;
                case 1:
                    helperReference = new VerticalChainReference(this);
                    break;
                case 2:
                    helperReference = new AlignHorizontallyReference(this);
                    break;
                case 3:
                    helperReference = new AlignVerticallyReference(this);
                    break;
                case 4:
                    helperReference = new BarrierReference(this);
                    break;
                case 6:
                case 7:
                    helperReference = new FlowReference(this, helper);
                    break;
                case 8:
                case 9:
                case 10:
                    helperReference = new GridReference(this, helper);
                    break;
                default:
                    helperReference = new HelperReference(this, helper);
                    break;
            }
            helperReference.setKey(obj);
            this.mHelperReferences.put(obj, helperReference);
        }
        return helperReference;
    }

    public HorizontalChainReference horizontalChain() {
        return (HorizontalChainReference) helper((Object) null, Helper.HORIZONTAL_CHAIN);
    }

    public GuidelineReference horizontalGuideline(Object obj) {
        return guideline(obj, 0);
    }

    public boolean isBaselineNeeded(ConstraintWidget constraintWidget) {
        if (this.mDirtyBaselineNeededWidgets) {
            this.mBaselineNeededWidgets.clear();
            ArrayList<Object> arrayList = this.mBaselineNeeded;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                ConstraintWidget constraintWidget2 = this.mReferences.get(obj).getConstraintWidget();
                if (constraintWidget2 != null) {
                    this.mBaselineNeededWidgets.add(constraintWidget2);
                }
            }
            this.mDirtyBaselineNeededWidgets = false;
        }
        return this.mBaselineNeededWidgets.contains(constraintWidget);
    }

    @Deprecated
    public boolean isLtr() {
        return this.mIsLtr;
    }

    public boolean isRtl() {
        return !this.mIsLtr;
    }

    public void map(Object obj, Object obj2) {
        ConstraintReference constraints = constraints(obj);
        if (constraints != null) {
            constraints.setView(obj2);
        }
    }

    /* access modifiers changed from: package-private */
    public Reference reference(Object obj) {
        return this.mReferences.get(obj);
    }

    public void reset() {
        for (Object obj : this.mReferences.keySet()) {
            this.mReferences.get(obj).getConstraintWidget().reset();
        }
        this.mReferences.clear();
        this.mReferences.put(PARENT, this.mParent);
        this.mHelperReferences.clear();
        this.mTags.clear();
        this.mBaselineNeeded.clear();
        this.mDirtyBaselineNeededWidgets = true;
    }

    public boolean sameFixedHeight(int i5) {
        return this.mParent.getHeight().equalsFixedValue(i5);
    }

    public boolean sameFixedWidth(int i5) {
        return this.mParent.getWidth().equalsFixedValue(i5);
    }

    public void setDpToPixel(CorePixelDp corePixelDp) {
        this.mDpToPixel = corePixelDp;
    }

    public State setHeight(Dimension dimension) {
        this.mParent.setHeight(dimension);
        return this;
    }

    @Deprecated
    public void setLtr(boolean z4) {
        this.mIsLtr = z4;
    }

    public void setRtl(boolean z4) {
        this.mIsLtr = !z4;
    }

    public void setTag(String str, String str2) {
        ArrayList arrayList;
        ConstraintReference constraints = constraints(str);
        if (w.a(constraints)) {
            constraints.setTag(str2);
            if (!this.mTags.containsKey(str2)) {
                arrayList = new ArrayList();
                this.mTags.put(str2, arrayList);
            } else {
                arrayList = this.mTags.get(str2);
            }
            arrayList.add(str);
        }
    }

    public State setWidth(Dimension dimension) {
        this.mParent.setWidth(dimension);
        return this;
    }

    public VerticalChainReference verticalChain() {
        return (VerticalChainReference) helper((Object) null, Helper.VERTICAL_CHAIN);
    }

    public GuidelineReference verticalGuideline(Object obj) {
        return guideline(obj, 1);
    }

    public State width(Dimension dimension) {
        return setWidth(dimension);
    }

    public FlowReference getHorizontalFlow(Object... objArr) {
        FlowReference flowReference = (FlowReference) helper((Object) null, Helper.HORIZONTAL_FLOW);
        flowReference.add(objArr);
        return flowReference;
    }

    public FlowReference getVerticalFlow(Object... objArr) {
        FlowReference flowReference = (FlowReference) helper((Object) null, Helper.VERTICAL_FLOW);
        flowReference.add(objArr);
        return flowReference;
    }

    public HorizontalChainReference horizontalChain(Object... objArr) {
        HorizontalChainReference horizontalChainReference = (HorizontalChainReference) helper((Object) null, Helper.HORIZONTAL_CHAIN);
        horizontalChainReference.add(objArr);
        return horizontalChainReference;
    }

    public VerticalChainReference verticalChain(Object... objArr) {
        VerticalChainReference verticalChainReference = (VerticalChainReference) helper((Object) null, Helper.VERTICAL_CHAIN);
        verticalChainReference.add(objArr);
        return verticalChainReference;
    }
}
