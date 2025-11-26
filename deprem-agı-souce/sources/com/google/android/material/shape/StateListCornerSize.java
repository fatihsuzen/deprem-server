package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StateListCornerSize {
    private static final int INITIAL_CAPACITY = 10;
    @NonNull
    CornerSize[] cornerSizes = new CornerSize[10];
    @NonNull
    private CornerSize defaultCornerSize;
    int stateCount;
    @NonNull
    int[][] stateSpecs = new int[10][];

    private void addStateCornerSize(@NonNull int[] iArr, @NonNull CornerSize cornerSize) {
        int i5 = this.stateCount;
        if (i5 == 0 || iArr.length == 0) {
            this.defaultCornerSize = cornerSize;
        }
        if (i5 >= this.stateSpecs.length) {
            growArray(i5, i5 + 10);
        }
        int[][] iArr2 = this.stateSpecs;
        int i6 = this.stateCount;
        iArr2[i6] = iArr;
        this.cornerSizes[i6] = cornerSize;
        this.stateCount = i6 + 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047 A[Catch:{ all -> 0x005b, all -> 0x006f, NotFoundException | IOException | XmlPullParserException -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[SYNTHETIC, Splitter:B:25:0x0061] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.material.shape.StateListCornerSize create(@androidx.annotation.NonNull android.content.Context r4, @androidx.annotation.NonNull android.content.res.TypedArray r5, @androidx.annotation.StyleableRes int r6, @androidx.annotation.NonNull com.google.android.material.shape.CornerSize r7) {
        /*
            r0 = 0
            int r0 = r5.getResourceId(r6, r0)
            if (r0 != 0) goto L_0x0010
            com.google.android.material.shape.CornerSize r4 = com.google.android.material.shape.ShapeAppearanceModel.getCornerSize(r5, r6, r7)
            com.google.android.material.shape.StateListCornerSize r4 = create(r4)
            return r4
        L_0x0010:
            android.content.res.Resources r1 = r4.getResources()
            java.lang.String r1 = r1.getResourceTypeName(r0)
            java.lang.String r2 = "xml"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0029
            com.google.android.material.shape.CornerSize r4 = com.google.android.material.shape.ShapeAppearanceModel.getCornerSize(r5, r6, r7)
            com.google.android.material.shape.StateListCornerSize r4 = create(r4)
            return r4
        L_0x0029:
            android.content.res.Resources r5 = r4.getResources()     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x0074 }
            android.content.res.XmlResourceParser r5 = r5.getXml(r0)     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x0074 }
            com.google.android.material.shape.StateListCornerSize r6 = new com.google.android.material.shape.StateListCornerSize     // Catch:{ all -> 0x005b }
            r6.<init>()     // Catch:{ all -> 0x005b }
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)     // Catch:{ all -> 0x005b }
        L_0x003a:
            int r1 = r5.next()     // Catch:{ all -> 0x005b }
            r2 = 2
            if (r1 == r2) goto L_0x0045
            r3 = 1
            if (r1 == r3) goto L_0x0045
            goto L_0x003a
        L_0x0045:
            if (r1 != r2) goto L_0x0061
            java.lang.String r1 = r5.getName()     // Catch:{ all -> 0x005b }
            java.lang.String r2 = "selector"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x005d
            android.content.res.Resources$Theme r1 = r4.getTheme()     // Catch:{ all -> 0x005b }
            r6.loadCornerSizesFromItems(r4, r5, r0, r1)     // Catch:{ all -> 0x005b }
            goto L_0x005d
        L_0x005b:
            r4 = move-exception
            goto L_0x0069
        L_0x005d:
            r5.close()     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x0074 }
            return r6
        L_0x0061:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ all -> 0x005b }
            java.lang.String r6 = "No start tag found"
            r4.<init>(r6)     // Catch:{ all -> 0x005b }
            throw r4     // Catch:{ all -> 0x005b }
        L_0x0069:
            if (r5 == 0) goto L_0x0073
            r5.close()     // Catch:{ all -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r5 = move-exception
            r4.addSuppressed(r5)     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x0074 }
        L_0x0073:
            throw r4     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x0074 }
        L_0x0074:
            com.google.android.material.shape.StateListCornerSize r4 = create(r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.StateListCornerSize.create(android.content.Context, android.content.res.TypedArray, int, com.google.android.material.shape.CornerSize):com.google.android.material.shape.StateListCornerSize");
    }

    private void growArray(int i5, int i6) {
        int[][] iArr = new int[i6][];
        System.arraycopy(this.stateSpecs, 0, iArr, 0, i5);
        this.stateSpecs = iArr;
        CornerSize[] cornerSizeArr = new CornerSize[i6];
        System.arraycopy(this.cornerSizes, 0, cornerSizeArr, 0, i5);
        this.cornerSizes = cornerSizeArr;
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

    private void loadCornerSizesFromItems(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
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
                        typedArray = resources.obtainAttributes(attributeSet, R.styleable.ShapeAppearance);
                    } else {
                        typedArray = theme.obtainStyledAttributes(attributeSet, R.styleable.ShapeAppearance, 0, 0);
                    }
                    CornerSize cornerSize = ShapeAppearanceModel.getCornerSize(typedArray, R.styleable.ShapeAppearance_cornerSize, new AbsoluteCornerSize(0.0f));
                    typedArray.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr = new int[attributeCount];
                    int i5 = 0;
                    for (int i6 = 0; i6 < attributeCount; i6++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                        if (attributeNameResource != R.attr.cornerSize) {
                            int i7 = i5 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr[i5] = attributeNameResource;
                            i5 = i7;
                        }
                    }
                    addStateCornerSize(StateSet.trimStateSet(iArr, i5), cornerSize);
                }
            } else {
                return;
            }
        }
    }

    @NonNull
    public CornerSize getCornerSizeForState(@NonNull int[] iArr) {
        int indexOfStateSet = indexOfStateSet(iArr);
        if (indexOfStateSet < 0) {
            indexOfStateSet = indexOfStateSet(StateSet.WILD_CARD);
        }
        if (indexOfStateSet < 0) {
            return this.defaultCornerSize;
        }
        return this.cornerSizes[indexOfStateSet];
    }

    @NonNull
    public CornerSize getDefaultCornerSize() {
        return this.defaultCornerSize;
    }

    public boolean isStateful() {
        if (this.stateCount > 1) {
            return true;
        }
        return false;
    }

    @NonNull
    public StateListCornerSize withTransformedCornerSizes(@NonNull ShapeAppearanceModel.CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        StateListCornerSize stateListCornerSize = new StateListCornerSize();
        stateListCornerSize.stateCount = this.stateCount;
        int[][] iArr = new int[this.stateSpecs.length][];
        stateListCornerSize.stateSpecs = iArr;
        int[][] iArr2 = this.stateSpecs;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        stateListCornerSize.cornerSizes = new CornerSize[this.cornerSizes.length];
        for (int i5 = 0; i5 < this.stateCount; i5++) {
            stateListCornerSize.cornerSizes[i5] = cornerSizeUnaryOperator.apply(this.cornerSizes[i5]);
        }
        return stateListCornerSize;
    }

    @NonNull
    public static StateListCornerSize create(@NonNull CornerSize cornerSize) {
        StateListCornerSize stateListCornerSize = new StateListCornerSize();
        stateListCornerSize.addStateCornerSize(StateSet.WILD_CARD, cornerSize);
        return stateListCornerSize;
    }
}
