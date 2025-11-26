package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StateListSizeChange {
    private static final int INITIAL_CAPACITY = 10;
    @NonNull
    private SizeChange defaultSizeChange;
    @NonNull
    SizeChange[] sizeChanges = new SizeChange[10];
    int stateCount;
    @NonNull
    int[][] stateSpecs = new int[10][];

    public static class SizeChangeAmount {
        float amount;
        SizeChangeType type;

        SizeChangeAmount(SizeChangeType sizeChangeType, float f5) {
            this.type = sizeChangeType;
            this.amount = f5;
        }

        public int getChange(@Px int i5) {
            SizeChangeType sizeChangeType = this.type;
            if (sizeChangeType == SizeChangeType.PERCENT) {
                return (int) (this.amount * ((float) i5));
            }
            if (sizeChangeType == SizeChangeType.PIXELS) {
                return (int) this.amount;
            }
            return 0;
        }
    }

    public enum SizeChangeType {
        PERCENT,
        PIXELS
    }

    private void addStateSizeChange(@NonNull int[] iArr, @NonNull SizeChange sizeChange) {
        int i5 = this.stateCount;
        if (i5 == 0 || iArr.length == 0) {
            this.defaultSizeChange = sizeChange;
        }
        if (i5 >= this.stateSpecs.length) {
            growArray(i5, i5 + 10);
        }
        int[][] iArr2 = this.stateSpecs;
        int i6 = this.stateCount;
        iArr2[i6] = iArr;
        this.sizeChanges[i6] = sizeChange;
        this.stateCount = i6 + 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038 A[Catch:{ all -> 0x004c, all -> 0x0060, NotFoundException | IOException | XmlPullParserException -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052 A[SYNTHETIC, Splitter:B:23:0x0052] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.material.shape.StateListSizeChange create(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.NonNull android.content.res.TypedArray r6, @androidx.annotation.StyleableRes int r7) {
        /*
            r0 = 0
            int r6 = r6.getResourceId(r7, r0)
            r7 = 0
            if (r6 != 0) goto L_0x0009
            return r7
        L_0x0009:
            android.content.res.Resources r0 = r5.getResources()
            java.lang.String r0 = r0.getResourceTypeName(r6)
            java.lang.String r1 = "xml"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001a
            return r7
        L_0x001a:
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x0065 }
            android.content.res.XmlResourceParser r6 = r0.getXml(r6)     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x0065 }
            com.google.android.material.shape.StateListSizeChange r0 = new com.google.android.material.shape.StateListSizeChange     // Catch:{ all -> 0x004c }
            r0.<init>()     // Catch:{ all -> 0x004c }
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r6)     // Catch:{ all -> 0x004c }
        L_0x002b:
            int r2 = r6.next()     // Catch:{ all -> 0x004c }
            r3 = 2
            if (r2 == r3) goto L_0x0036
            r4 = 1
            if (r2 == r4) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r2 != r3) goto L_0x0052
            java.lang.String r2 = r6.getName()     // Catch:{ all -> 0x004c }
            java.lang.String r3 = "selector"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x004e
            android.content.res.Resources$Theme r2 = r5.getTheme()     // Catch:{ all -> 0x004c }
            r0.loadSizeChangeFromItems(r5, r6, r1, r2)     // Catch:{ all -> 0x004c }
            goto L_0x004e
        L_0x004c:
            r5 = move-exception
            goto L_0x005a
        L_0x004e:
            r6.close()     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x0065 }
            return r0
        L_0x0052:
            org.xmlpull.v1.XmlPullParserException r5 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ all -> 0x004c }
            java.lang.String r0 = "No start tag found"
            r5.<init>(r0)     // Catch:{ all -> 0x004c }
            throw r5     // Catch:{ all -> 0x004c }
        L_0x005a:
            if (r6 == 0) goto L_0x0064
            r6.close()     // Catch:{ all -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r6 = move-exception
            r5.addSuppressed(r6)     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x0065 }
        L_0x0064:
            throw r5     // Catch:{ NotFoundException | IOException | XmlPullParserException -> 0x0065 }
        L_0x0065:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.StateListSizeChange.create(android.content.Context, android.content.res.TypedArray, int):com.google.android.material.shape.StateListSizeChange");
    }

    @Nullable
    private SizeChangeAmount getSizeChangeAmount(@NonNull TypedArray typedArray, int i5, @Nullable SizeChangeAmount sizeChangeAmount) {
        TypedValue peekValue = typedArray.peekValue(i5);
        if (peekValue != null) {
            int i6 = peekValue.type;
            if (i6 == 5) {
                return new SizeChangeAmount(SizeChangeType.PIXELS, (float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i6 == 6) {
                return new SizeChangeAmount(SizeChangeType.PERCENT, peekValue.getFraction(1.0f, 1.0f));
            }
        }
        return sizeChangeAmount;
    }

    private void growArray(int i5, int i6) {
        int[][] iArr = new int[i6][];
        System.arraycopy(this.stateSpecs, 0, iArr, 0, i5);
        this.stateSpecs = iArr;
        SizeChange[] sizeChangeArr = new SizeChange[i6];
        System.arraycopy(this.sizeChanges, 0, sizeChangeArr, 0, i5);
        this.sizeChanges = sizeChangeArr;
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

    private void loadSizeChangeFromItems(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
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
                        typedArray = resources.obtainAttributes(attributeSet, R.styleable.StateListSizeChange);
                    } else {
                        typedArray = theme.obtainStyledAttributes(attributeSet, R.styleable.StateListSizeChange, 0, 0);
                    }
                    SizeChangeAmount sizeChangeAmount = getSizeChangeAmount(typedArray, R.styleable.StateListSizeChange_widthChange, (SizeChangeAmount) null);
                    typedArray.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr = new int[attributeCount];
                    int i5 = 0;
                    for (int i6 = 0; i6 < attributeCount; i6++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                        if (attributeNameResource != R.attr.widthChange) {
                            int i7 = i5 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr[i5] = attributeNameResource;
                            i5 = i7;
                        }
                    }
                    addStateSizeChange(StateSet.trimStateSet(iArr, i5), new SizeChange(sizeChangeAmount));
                }
            } else {
                return;
            }
        }
    }

    @NonNull
    public SizeChange getDefaultSizeChange() {
        return this.defaultSizeChange;
    }

    public int getMaxWidthChange(@Px int i5) {
        float max;
        int i6 = -i5;
        for (int i7 = 0; i7 < this.stateCount; i7++) {
            SizeChangeAmount sizeChangeAmount = this.sizeChanges[i7].widthChange;
            SizeChangeType sizeChangeType = sizeChangeAmount.type;
            if (sizeChangeType == SizeChangeType.PIXELS) {
                max = Math.max((float) i6, sizeChangeAmount.amount);
            } else if (sizeChangeType == SizeChangeType.PERCENT) {
                max = Math.max((float) i6, ((float) i5) * sizeChangeAmount.amount);
            }
            i6 = (int) max;
        }
        return i6;
    }

    @NonNull
    public SizeChange getSizeChangeForState(@NonNull int[] iArr) {
        int indexOfStateSet = indexOfStateSet(iArr);
        if (indexOfStateSet < 0) {
            indexOfStateSet = indexOfStateSet(StateSet.WILD_CARD);
        }
        if (indexOfStateSet < 0) {
            return this.defaultSizeChange;
        }
        return this.sizeChanges[indexOfStateSet];
    }

    public boolean isStateful() {
        if (this.stateCount > 1) {
            return true;
        }
        return false;
    }

    public static class SizeChange {
        @Nullable
        public SizeChangeAmount widthChange;

        SizeChange(@Nullable SizeChangeAmount sizeChangeAmount) {
            this.widthChange = sizeChangeAmount;
        }

        SizeChange(@NonNull SizeChange sizeChange) {
            SizeChangeAmount sizeChangeAmount = sizeChange.widthChange;
            this.widthChange = new SizeChangeAmount(sizeChangeAmount.type, sizeChangeAmount.amount);
        }
    }
}
