package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    int mCurrentConstraintNumber = -1;
    int mCurrentStateId = -1;
    int mDefaultState = -1;
    private SparseArray<State> mStateList = new SparseArray<>();

    static class State {
        int mConstraintID = -1;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants = new ArrayList<>();

        State(Context context, XmlPullParser xmlPullParser) {
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void add(Variant variant) {
            this.mVariants.add(variant);
        }

        public int findMatch(float f5, float f6) {
            for (int i5 = 0; i5 < this.mVariants.size(); i5++) {
                if (this.mVariants.get(i5).match(f5, f6)) {
                    return i5;
                }
            }
            return -1;
        }
    }

    static class Variant {
        int mConstraintID = -1;
        int mId;
        boolean mIsLayout;
        float mMaxHeight = Float.NaN;
        float mMaxWidth = Float.NaN;
        float mMinHeight = Float.NaN;
        float mMinWidth = Float.NaN;

        Variant(Context context, XmlPullParser xmlPullParser) {
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = obtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean match(float f5, float f6) {
            if (!Float.isNaN(this.mMinWidth) && f5 < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && f6 < this.mMinHeight) {
                return false;
            }
            if (!Float.isNaN(this.mMaxWidth) && f5 > this.mMaxWidth) {
                return false;
            }
            if (Float.isNaN(this.mMaxHeight) || f6 <= this.mMaxHeight) {
                return true;
            }
            return false;
        }
    }

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        load(context, xmlPullParser);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r11, org.xmlpull.v1.XmlPullParser r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Error parsing XML resource"
            java.lang.String r1 = "ConstraintLayoutStates"
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r12)
            int[] r3 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r2 = r11.obtainStyledAttributes(r2, r3)
            int r3 = r2.getIndexCount()
            r4 = 0
            r5 = r4
        L_0x0014:
            if (r5 >= r3) goto L_0x0029
            int r6 = r2.getIndex(r5)
            int r7 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r6 != r7) goto L_0x0026
            int r7 = r10.mDefaultState
            int r6 = r2.getResourceId(r6, r7)
            r10.mDefaultState = r6
        L_0x0026:
            int r5 = r5 + 1
            goto L_0x0014
        L_0x0029:
            r2.recycle()
            int r2 = r12.getEventType()     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            r3 = 0
        L_0x0031:
            r5 = 1
            if (r2 == r5) goto L_0x00a8
            java.lang.String r6 = "StateSet"
            r7 = 3
            r8 = 2
            if (r2 == r8) goto L_0x004e
            if (r2 == r7) goto L_0x003e
            goto L_0x009c
        L_0x003e:
            java.lang.String r2 = r12.getName()     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            boolean r2 = r6.equals(r2)     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            if (r2 == 0) goto L_0x009c
            goto L_0x00a8
        L_0x004a:
            r11 = move-exception
            goto L_0x00a1
        L_0x004c:
            r11 = move-exception
            goto L_0x00a5
        L_0x004e:
            java.lang.String r2 = r12.getName()     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            int r9 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            switch(r9) {
                case 80204913: goto L_0x0075;
                case 1301459538: goto L_0x006b;
                case 1382829617: goto L_0x0064;
                case 1901439077: goto L_0x005a;
                default: goto L_0x0059;
            }     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
        L_0x0059:
            goto L_0x007f
        L_0x005a:
            java.lang.String r5 = "Variant"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            if (r2 == 0) goto L_0x007f
            r5 = r7
            goto L_0x0080
        L_0x0064:
            boolean r2 = r2.equals(r6)     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            if (r2 == 0) goto L_0x007f
            goto L_0x0080
        L_0x006b:
            java.lang.String r5 = "LayoutDescription"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            if (r2 == 0) goto L_0x007f
            r5 = r4
            goto L_0x0080
        L_0x0075:
            java.lang.String r5 = "State"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            if (r2 == 0) goto L_0x007f
            r5 = r8
            goto L_0x0080
        L_0x007f:
            r5 = -1
        L_0x0080:
            if (r5 == r8) goto L_0x0090
            if (r5 == r7) goto L_0x0085
            goto L_0x009c
        L_0x0085:
            androidx.constraintlayout.widget.StateSet$Variant r2 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            r2.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            if (r3 == 0) goto L_0x009c
            r3.add(r2)     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            goto L_0x009c
        L_0x0090:
            androidx.constraintlayout.widget.StateSet$State r3 = new androidx.constraintlayout.widget.StateSet$State     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            r3.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$State> r2 = r10.mStateList     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            int r5 = r3.mId     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            r2.put(r5, r3)     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
        L_0x009c:
            int r2 = r12.next()     // Catch:{ XmlPullParserException -> 0x004c, IOException -> 0x004a }
            goto L_0x0031
        L_0x00a1:
            android.util.Log.e(r1, r0, r11)
            goto L_0x00a8
        L_0x00a5:
            android.util.Log.e(r1, r0, r11)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int convertToConstraintSet(int i5, int i6, float f5, float f6) {
        State state = this.mStateList.get(i6);
        if (state == null) {
            return i6;
        }
        int i7 = 0;
        if (f5 != -1.0f && f6 != -1.0f) {
            ArrayList<Variant> arrayList = state.mVariants;
            int size = arrayList.size();
            Variant variant = null;
            while (i7 < size) {
                Variant variant2 = arrayList.get(i7);
                i7++;
                Variant variant3 = variant2;
                if (variant3.match(f5, f6)) {
                    if (i5 != variant3.mConstraintID) {
                        variant = variant3;
                    }
                }
            }
            if (variant != null) {
                return variant.mConstraintID;
            }
            return state.mConstraintID;
        } else if (state.mConstraintID != i5) {
            ArrayList<Variant> arrayList2 = state.mVariants;
            int size2 = arrayList2.size();
            while (i7 < size2) {
                Variant variant4 = arrayList2.get(i7);
                i7++;
                if (i5 == variant4.mConstraintID) {
                }
            }
            return state.mConstraintID;
        }
        return i5;
    }

    public boolean needsToChange(int i5, float f5, float f6) {
        Object obj;
        int i6 = this.mCurrentStateId;
        if (i6 != i5) {
            return true;
        }
        if (i5 == -1) {
            obj = this.mStateList.valueAt(0);
        } else {
            obj = this.mStateList.get(i6);
        }
        State state = (State) obj;
        int i7 = this.mCurrentConstraintNumber;
        if ((i7 == -1 || !state.mVariants.get(i7).match(f5, f6)) && this.mCurrentConstraintNumber != state.findMatch(f5, f6)) {
            return true;
        }
        return false;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int i5, int i6, int i7) {
        return updateConstraints(-1, i5, (float) i6, (float) i7);
    }

    public int updateConstraints(int i5, int i6, float f5, float f6) {
        State state;
        int findMatch;
        if (i5 == i6) {
            if (i6 == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(this.mCurrentStateId);
            }
            if (state == null) {
                return -1;
            }
            if ((this.mCurrentConstraintNumber != -1 && state.mVariants.get(i5).match(f5, f6)) || i5 == (findMatch = state.findMatch(f5, f6))) {
                return i5;
            }
            if (findMatch == -1) {
                return state.mConstraintID;
            }
            return state.mVariants.get(findMatch).mConstraintID;
        }
        State state2 = this.mStateList.get(i6);
        if (state2 == null) {
            return -1;
        }
        int findMatch2 = state2.findMatch(f5, f6);
        if (findMatch2 == -1) {
            return state2.mConstraintID;
        }
        return state2.mVariants.get(findMatch2).mConstraintID;
    }
}
