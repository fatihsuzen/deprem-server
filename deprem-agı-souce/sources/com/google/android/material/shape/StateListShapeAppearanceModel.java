package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import com.google.android.material.R;
import com.google.android.material.shape.ShapeAppearanceModel;
import j$.util.Objects;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StateListShapeAppearanceModel {
    public static final int CORNER_BOTTOM_LEFT = 4;
    public static final int CORNER_BOTTOM_RIGHT = 8;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 2;
    private static final int INITIAL_CAPACITY = 10;
    @Nullable
    final StateListCornerSize bottomLeftCornerSizeOverride;
    @Nullable
    final StateListCornerSize bottomRightCornerSizeOverride;
    @NonNull
    final ShapeAppearanceModel defaultShape;
    @NonNull
    final ShapeAppearanceModel[] shapeAppearanceModels;
    final int stateCount;
    @NonNull
    final int[][] stateSpecs;
    @Nullable
    final StateListCornerSize topLeftCornerSizeOverride;
    @Nullable
    final StateListCornerSize topRightCornerSizeOverride;

    public static final class Builder {
        /* access modifiers changed from: private */
        @Nullable
        public StateListCornerSize bottomLeftCornerSizeOverride;
        /* access modifiers changed from: private */
        @Nullable
        public StateListCornerSize bottomRightCornerSizeOverride;
        /* access modifiers changed from: private */
        @NonNull
        public ShapeAppearanceModel defaultShape;
        /* access modifiers changed from: private */
        @NonNull
        public ShapeAppearanceModel[] shapeAppearanceModels;
        /* access modifiers changed from: private */
        public int stateCount;
        /* access modifiers changed from: private */
        @NonNull
        public int[][] stateSpecs;
        /* access modifiers changed from: private */
        @Nullable
        public StateListCornerSize topLeftCornerSizeOverride;
        /* access modifiers changed from: private */
        @Nullable
        public StateListCornerSize topRightCornerSizeOverride;

        private boolean containsFlag(int i5, int i6) {
            return (i6 | i5) == i5;
        }

        private void growArray(int i5, int i6) {
            int[][] iArr = new int[i6][];
            System.arraycopy(this.stateSpecs, 0, iArr, 0, i5);
            this.stateSpecs = iArr;
            ShapeAppearanceModel[] shapeAppearanceModelArr = new ShapeAppearanceModel[i6];
            System.arraycopy(this.shapeAppearanceModels, 0, shapeAppearanceModelArr, 0, i5);
            this.shapeAppearanceModels = shapeAppearanceModelArr;
        }

        private void initialize() {
            this.defaultShape = new ShapeAppearanceModel();
            this.stateSpecs = new int[10][];
            this.shapeAppearanceModels = new ShapeAppearanceModel[10];
        }

        @NonNull
        public Builder addStateShapeAppearanceModel(@NonNull int[] iArr, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
            int i5 = this.stateCount;
            if (i5 == 0 || iArr.length == 0) {
                this.defaultShape = shapeAppearanceModel;
            }
            if (i5 >= this.stateSpecs.length) {
                growArray(i5, i5 + 10);
            }
            int[][] iArr2 = this.stateSpecs;
            int i6 = this.stateCount;
            iArr2[i6] = iArr;
            this.shapeAppearanceModels[i6] = shapeAppearanceModel;
            this.stateCount = i6 + 1;
            return this;
        }

        @Nullable
        public StateListShapeAppearanceModel build() {
            if (this.stateCount == 0) {
                return null;
            }
            return new StateListShapeAppearanceModel(this);
        }

        @NonNull
        public Builder setCornerSizeOverride(@NonNull StateListCornerSize stateListCornerSize, int i5) {
            if (containsFlag(i5, 1)) {
                this.topLeftCornerSizeOverride = stateListCornerSize;
            }
            if (containsFlag(i5, 2)) {
                this.topRightCornerSizeOverride = stateListCornerSize;
            }
            if (containsFlag(i5, 4)) {
                this.bottomLeftCornerSizeOverride = stateListCornerSize;
            }
            if (containsFlag(i5, 8)) {
                this.bottomRightCornerSizeOverride = stateListCornerSize;
            }
            return this;
        }

        @NonNull
        public Builder withTransformedCornerSizes(@NonNull ShapeAppearanceModel.CornerSizeUnaryOperator cornerSizeUnaryOperator) {
            ShapeAppearanceModel[] shapeAppearanceModelArr = new ShapeAppearanceModel[this.shapeAppearanceModels.length];
            for (int i5 = 0; i5 < this.stateCount; i5++) {
                shapeAppearanceModelArr[i5] = this.shapeAppearanceModels[i5].withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            this.shapeAppearanceModels = shapeAppearanceModelArr;
            StateListCornerSize stateListCornerSize = this.topLeftCornerSizeOverride;
            if (stateListCornerSize != null) {
                this.topLeftCornerSizeOverride = stateListCornerSize.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            StateListCornerSize stateListCornerSize2 = this.topRightCornerSizeOverride;
            if (stateListCornerSize2 != null) {
                this.topRightCornerSizeOverride = stateListCornerSize2.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            StateListCornerSize stateListCornerSize3 = this.bottomLeftCornerSizeOverride;
            if (stateListCornerSize3 != null) {
                this.bottomLeftCornerSizeOverride = stateListCornerSize3.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            StateListCornerSize stateListCornerSize4 = this.bottomRightCornerSizeOverride;
            if (stateListCornerSize4 != null) {
                this.bottomRightCornerSizeOverride = stateListCornerSize4.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            return this;
        }

        public Builder(@NonNull StateListShapeAppearanceModel stateListShapeAppearanceModel) {
            int i5 = stateListShapeAppearanceModel.stateCount;
            this.stateCount = i5;
            this.defaultShape = stateListShapeAppearanceModel.defaultShape;
            int[][] iArr = stateListShapeAppearanceModel.stateSpecs;
            int[][] iArr2 = new int[iArr.length][];
            this.stateSpecs = iArr2;
            this.shapeAppearanceModels = new ShapeAppearanceModel[stateListShapeAppearanceModel.shapeAppearanceModels.length];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            System.arraycopy(stateListShapeAppearanceModel.shapeAppearanceModels, 0, this.shapeAppearanceModels, 0, this.stateCount);
            this.topLeftCornerSizeOverride = stateListShapeAppearanceModel.topLeftCornerSizeOverride;
            this.topRightCornerSizeOverride = stateListShapeAppearanceModel.topRightCornerSizeOverride;
            this.bottomLeftCornerSizeOverride = stateListShapeAppearanceModel.bottomLeftCornerSizeOverride;
            this.bottomRightCornerSizeOverride = stateListShapeAppearanceModel.bottomRightCornerSizeOverride;
        }

        public Builder(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
            initialize();
            addStateShapeAppearanceModel(StateSet.WILD_CARD, shapeAppearanceModel);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x001f A[Catch:{ all -> 0x0033, all -> 0x0047, NotFoundException | IOException | XmlPullParserException -> 0x004c }] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0039 A[SYNTHETIC, Splitter:B:18:0x0039] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private Builder(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.XmlRes int r6) {
            /*
                r4 = this;
                r4.<init>()
                r4.initialize()
                android.content.res.Resources r0 = r5.getResources()     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x004c }
                android.content.res.XmlResourceParser r6 = r0.getXml(r6)     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x004c }
                android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r6)     // Catch:{ all -> 0x0033 }
            L_0x0012:
                int r1 = r6.next()     // Catch:{ all -> 0x0033 }
                r2 = 2
                if (r1 == r2) goto L_0x001d
                r3 = 1
                if (r1 == r3) goto L_0x001d
                goto L_0x0012
            L_0x001d:
                if (r1 != r2) goto L_0x0039
                java.lang.String r1 = r6.getName()     // Catch:{ all -> 0x0033 }
                java.lang.String r2 = "selector"
                boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0033 }
                if (r1 == 0) goto L_0x0035
                android.content.res.Resources$Theme r1 = r5.getTheme()     // Catch:{ all -> 0x0033 }
                com.google.android.material.shape.StateListShapeAppearanceModel.loadShapeAppearanceModelsFromItems(r4, r5, r6, r0, r1)     // Catch:{ all -> 0x0033 }
                goto L_0x0035
            L_0x0033:
                r5 = move-exception
                goto L_0x0041
            L_0x0035:
                r6.close()     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x004c }
                return
            L_0x0039:
                org.xmlpull.v1.XmlPullParserException r5 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ all -> 0x0033 }
                java.lang.String r0 = "No start tag found"
                r5.<init>(r0)     // Catch:{ all -> 0x0033 }
                throw r5     // Catch:{ all -> 0x0033 }
            L_0x0041:
                if (r6 == 0) goto L_0x004b
                r6.close()     // Catch:{ all -> 0x0047 }
                goto L_0x004b
            L_0x0047:
                r6 = move-exception
                r5.addSuppressed(r6)     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x004c }
            L_0x004b:
                throw r5     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x004c }
            L_0x004c:
                r4.initialize()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.StateListShapeAppearanceModel.Builder.<init>(android.content.Context, int):void");
        }
    }

    @Nullable
    public static StateListShapeAppearanceModel create(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i5) {
        int resourceId = typedArray.getResourceId(i5, 0);
        if (resourceId != 0 && Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return new Builder(context, resourceId).build();
        }
        return null;
    }

    private int indexOfStateSet(int[] iArr) {
        int[][] iArr2 = this.stateSpecs;
        for (int i5 = 0; i5 < this.stateCount; i5++) {
            if (StateSet.stateSetMatches(iArr2[i5], iArr)) {
                return i5;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static void loadShapeAppearanceModelsFromItems(@NonNull Builder builder, @NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArray;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    Resources resources = context.getResources();
                    if (theme == null) {
                        typedArray = resources.obtainAttributes(attributeSet, R.styleable.MaterialShape);
                    } else {
                        typedArray = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, 0, 0);
                    }
                    ShapeAppearanceModel build = ShapeAppearanceModel.builder(context, typedArray.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0), typedArray.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0)).build();
                    typedArray.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr = new int[attributeCount];
                    int i5 = 0;
                    for (int i6 = 0; i6 < attributeCount; i6++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                        if (!(attributeNameResource == R.attr.shapeAppearance || attributeNameResource == R.attr.shapeAppearanceOverlay)) {
                            int i7 = i5 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr[i5] = attributeNameResource;
                            i5 = i7;
                        }
                    }
                    builder.addStateShapeAppearanceModel(StateSet.trimStateSet(iArr, i5), build);
                }
            } else {
                return;
            }
        }
    }

    public static int swapCornerPositionRtl(int i5) {
        int i6 = i5 & 5;
        return ((i5 & 10) >> 1) | (i6 << 1);
    }

    @NonNull
    public ShapeAppearanceModel getDefaultShape(boolean z4) {
        if (!z4 || (this.topLeftCornerSizeOverride == null && this.topRightCornerSizeOverride == null && this.bottomLeftCornerSizeOverride == null && this.bottomRightCornerSizeOverride == null)) {
            return this.defaultShape;
        }
        ShapeAppearanceModel.Builder builder = this.defaultShape.toBuilder();
        StateListCornerSize stateListCornerSize = this.topLeftCornerSizeOverride;
        if (stateListCornerSize != null) {
            builder.setTopLeftCornerSize(stateListCornerSize.getDefaultCornerSize());
        }
        StateListCornerSize stateListCornerSize2 = this.topRightCornerSizeOverride;
        if (stateListCornerSize2 != null) {
            builder.setTopRightCornerSize(stateListCornerSize2.getDefaultCornerSize());
        }
        StateListCornerSize stateListCornerSize3 = this.bottomLeftCornerSizeOverride;
        if (stateListCornerSize3 != null) {
            builder.setBottomLeftCornerSize(stateListCornerSize3.getDefaultCornerSize());
        }
        StateListCornerSize stateListCornerSize4 = this.bottomRightCornerSizeOverride;
        if (stateListCornerSize4 != null) {
            builder.setBottomRightCornerSize(stateListCornerSize4.getDefaultCornerSize());
        }
        return builder.build();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public ShapeAppearanceModel getShapeForState(@NonNull int[] iArr) {
        int indexOfStateSet = indexOfStateSet(iArr);
        if (indexOfStateSet < 0) {
            indexOfStateSet = indexOfStateSet(StateSet.WILD_CARD);
        }
        if (this.topLeftCornerSizeOverride == null && this.topRightCornerSizeOverride == null && this.bottomLeftCornerSizeOverride == null && this.bottomRightCornerSizeOverride == null) {
            return this.shapeAppearanceModels[indexOfStateSet];
        }
        ShapeAppearanceModel.Builder builder = this.shapeAppearanceModels[indexOfStateSet].toBuilder();
        StateListCornerSize stateListCornerSize = this.topLeftCornerSizeOverride;
        if (stateListCornerSize != null) {
            builder.setTopLeftCornerSize(stateListCornerSize.getCornerSizeForState(iArr));
        }
        StateListCornerSize stateListCornerSize2 = this.topRightCornerSizeOverride;
        if (stateListCornerSize2 != null) {
            builder.setTopRightCornerSize(stateListCornerSize2.getCornerSizeForState(iArr));
        }
        StateListCornerSize stateListCornerSize3 = this.bottomLeftCornerSizeOverride;
        if (stateListCornerSize3 != null) {
            builder.setBottomLeftCornerSize(stateListCornerSize3.getCornerSizeForState(iArr));
        }
        StateListCornerSize stateListCornerSize4 = this.bottomRightCornerSizeOverride;
        if (stateListCornerSize4 != null) {
            builder.setBottomRightCornerSize(stateListCornerSize4.getCornerSizeForState(iArr));
        }
        return builder.build();
    }

    public int getStateCount() {
        return this.stateCount;
    }

    public boolean isStateful() {
        StateListCornerSize stateListCornerSize;
        StateListCornerSize stateListCornerSize2;
        StateListCornerSize stateListCornerSize3;
        StateListCornerSize stateListCornerSize4;
        if (this.stateCount > 1 || (((stateListCornerSize = this.topLeftCornerSizeOverride) != null && stateListCornerSize.isStateful()) || (((stateListCornerSize2 = this.topRightCornerSizeOverride) != null && stateListCornerSize2.isStateful()) || (((stateListCornerSize3 = this.bottomLeftCornerSizeOverride) != null && stateListCornerSize3.isStateful()) || ((stateListCornerSize4 = this.bottomRightCornerSizeOverride) != null && stateListCornerSize4.isStateful()))))) {
            return true;
        }
        return false;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public StateListShapeAppearanceModel withTransformedCornerSizes(@NonNull ShapeAppearanceModel.CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return toBuilder().withTransformedCornerSizes(cornerSizeUnaryOperator).build();
    }

    private StateListShapeAppearanceModel(@NonNull Builder builder) {
        this.stateCount = builder.stateCount;
        this.defaultShape = builder.defaultShape;
        this.stateSpecs = builder.stateSpecs;
        this.shapeAppearanceModels = builder.shapeAppearanceModels;
        this.topLeftCornerSizeOverride = builder.topLeftCornerSizeOverride;
        this.topRightCornerSizeOverride = builder.topRightCornerSizeOverride;
        this.bottomLeftCornerSizeOverride = builder.bottomLeftCornerSizeOverride;
        this.bottomRightCornerSizeOverride = builder.bottomRightCornerSizeOverride;
    }
}
