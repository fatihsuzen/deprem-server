package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    ConstraintLayout.LayoutParams mParams;
    View mView;

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mParams = (ConstraintLayout.LayoutParams) layoutParams;
            this.mView = view;
            return;
        }
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    private String sideToString(int i5) {
        switch (i5) {
            case 1:
                return TtmlNode.LEFT;
            case 2:
                return TtmlNode.RIGHT;
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return TtmlNode.END;
            default:
                return "undefined";
        }
    }

    public ConstraintProperties addToHorizontalChain(int i5, int i6) {
        int i7;
        int i8;
        if (i5 == 0) {
            i7 = 1;
        } else {
            i7 = 2;
        }
        connect(1, i5, i7, 0);
        if (i6 == 0) {
            i8 = 2;
        } else {
            i8 = 1;
        }
        connect(2, i6, i8, 0);
        if (i5 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i5)).connect(2, this.mView.getId(), 1, 0);
        }
        if (i6 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6)).connect(1, this.mView.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i5, int i6) {
        int i7;
        int i8;
        if (i5 == 0) {
            i7 = 6;
        } else {
            i7 = 7;
        }
        connect(6, i5, i7, 0);
        if (i6 == 0) {
            i8 = 7;
        } else {
            i8 = 6;
        }
        connect(7, i6, i8, 0);
        if (i5 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i5)).connect(7, this.mView.getId(), 6, 0);
        }
        if (i6 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6)).connect(6, this.mView.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i5, int i6) {
        int i7;
        int i8;
        if (i5 == 0) {
            i7 = 3;
        } else {
            i7 = 4;
        }
        connect(3, i5, i7, 0);
        if (i6 == 0) {
            i8 = 4;
        } else {
            i8 = 3;
        }
        connect(4, i6, i8, 0);
        if (i5 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i5)).connect(4, this.mView.getId(), 3, 0);
        }
        if (i6 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6)).connect(3, this.mView.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f5) {
        this.mView.setAlpha(f5);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int i5, int i6, int i7, int i8, int i9, int i10, float f5) {
        if (i7 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (i10 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f5 <= 0.0f || f5 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else if (i6 == 1 || i6 == 2) {
            connect(1, i5, i6, i7);
            connect(2, i8, i9, i10);
            this.mParams.horizontalBias = f5;
            return this;
        } else if (i6 == 6 || i6 == 7) {
            connect(6, i5, i6, i7);
            connect(7, i8, i9, i10);
            this.mParams.horizontalBias = f5;
            return this;
        } else {
            connect(3, i5, i6, i7);
            connect(4, i8, i9, i10);
            this.mParams.verticalBias = f5;
            return this;
        }
    }

    public ConstraintProperties centerHorizontally(int i5, int i6, int i7, int i8, int i9, int i10, float f5) {
        connect(1, i5, i6, i7);
        connect(2, i8, i9, i10);
        this.mParams.horizontalBias = f5;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i5, int i6, int i7, int i8, int i9, int i10, float f5) {
        connect(6, i5, i6, i7);
        connect(7, i8, i9, i10);
        this.mParams.horizontalBias = f5;
        return this;
    }

    public ConstraintProperties centerVertically(int i5, int i6, int i7, int i8, int i9, int i10, float f5) {
        connect(3, i5, i6, i7);
        connect(4, i8, i9, i10);
        this.mParams.verticalBias = f5;
        return this;
    }

    public ConstraintProperties connect(int i5, int i6, int i7, int i8) {
        switch (i5) {
            case 1:
                if (i7 == 1) {
                    ConstraintLayout.LayoutParams layoutParams = this.mParams;
                    layoutParams.leftToLeft = i6;
                    layoutParams.leftToRight = -1;
                } else if (i7 == 2) {
                    ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                    layoutParams2.leftToRight = i6;
                    layoutParams2.leftToLeft = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + sideToString(i7) + " undefined");
                }
                this.mParams.leftMargin = i8;
                return this;
            case 2:
                if (i7 == 1) {
                    ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                    layoutParams3.rightToLeft = i6;
                    layoutParams3.rightToRight = -1;
                } else if (i7 == 2) {
                    ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                    layoutParams4.rightToRight = i6;
                    layoutParams4.rightToLeft = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i7) + " undefined");
                }
                this.mParams.rightMargin = i8;
                return this;
            case 3:
                if (i7 == 3) {
                    ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                    layoutParams5.topToTop = i6;
                    layoutParams5.topToBottom = -1;
                    layoutParams5.baselineToBaseline = -1;
                    layoutParams5.baselineToTop = -1;
                    layoutParams5.baselineToBottom = -1;
                } else if (i7 == 4) {
                    ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                    layoutParams6.topToBottom = i6;
                    layoutParams6.topToTop = -1;
                    layoutParams6.baselineToBaseline = -1;
                    layoutParams6.baselineToTop = -1;
                    layoutParams6.baselineToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i7) + " undefined");
                }
                this.mParams.topMargin = i8;
                return this;
            case 4:
                if (i7 == 4) {
                    ConstraintLayout.LayoutParams layoutParams7 = this.mParams;
                    layoutParams7.bottomToBottom = i6;
                    layoutParams7.bottomToTop = -1;
                    layoutParams7.baselineToBaseline = -1;
                    layoutParams7.baselineToTop = -1;
                    layoutParams7.baselineToBottom = -1;
                } else if (i7 == 3) {
                    ConstraintLayout.LayoutParams layoutParams8 = this.mParams;
                    layoutParams8.bottomToTop = i6;
                    layoutParams8.bottomToBottom = -1;
                    layoutParams8.baselineToBaseline = -1;
                    layoutParams8.baselineToTop = -1;
                    layoutParams8.baselineToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i7) + " undefined");
                }
                this.mParams.bottomMargin = i8;
                return this;
            case 5:
                if (i7 == 5) {
                    ConstraintLayout.LayoutParams layoutParams9 = this.mParams;
                    layoutParams9.baselineToBaseline = i6;
                    layoutParams9.bottomToBottom = -1;
                    layoutParams9.bottomToTop = -1;
                    layoutParams9.topToTop = -1;
                    layoutParams9.topToBottom = -1;
                } else if (i7 == 3) {
                    ConstraintLayout.LayoutParams layoutParams10 = this.mParams;
                    layoutParams10.baselineToTop = i6;
                    layoutParams10.bottomToBottom = -1;
                    layoutParams10.bottomToTop = -1;
                    layoutParams10.topToTop = -1;
                    layoutParams10.topToBottom = -1;
                } else if (i7 == 4) {
                    ConstraintLayout.LayoutParams layoutParams11 = this.mParams;
                    layoutParams11.baselineToBottom = i6;
                    layoutParams11.bottomToBottom = -1;
                    layoutParams11.bottomToTop = -1;
                    layoutParams11.topToTop = -1;
                    layoutParams11.topToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i7) + " undefined");
                }
                this.mParams.baselineMargin = i8;
                return this;
            case 6:
                if (i7 == 6) {
                    ConstraintLayout.LayoutParams layoutParams12 = this.mParams;
                    layoutParams12.startToStart = i6;
                    layoutParams12.startToEnd = -1;
                } else if (i7 == 7) {
                    ConstraintLayout.LayoutParams layoutParams13 = this.mParams;
                    layoutParams13.startToEnd = i6;
                    layoutParams13.startToStart = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i7) + " undefined");
                }
                this.mParams.setMarginStart(i8);
                return this;
            case 7:
                if (i7 == 7) {
                    ConstraintLayout.LayoutParams layoutParams14 = this.mParams;
                    layoutParams14.endToEnd = i6;
                    layoutParams14.endToStart = -1;
                } else if (i7 == 6) {
                    ConstraintLayout.LayoutParams layoutParams15 = this.mParams;
                    layoutParams15.endToStart = i6;
                    layoutParams15.endToEnd = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i7) + " undefined");
                }
                this.mParams.setMarginEnd(i8);
                return this;
            default:
                throw new IllegalArgumentException(sideToString(i5) + " to " + sideToString(i7) + " unknown");
        }
    }

    public ConstraintProperties constrainDefaultHeight(int i5) {
        this.mParams.matchConstraintDefaultHeight = i5;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i5) {
        this.mParams.matchConstraintDefaultWidth = i5;
        return this;
    }

    public ConstraintProperties constrainHeight(int i5) {
        this.mParams.height = i5;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i5) {
        this.mParams.matchConstraintMaxHeight = i5;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i5) {
        this.mParams.matchConstraintMaxWidth = i5;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i5) {
        this.mParams.matchConstraintMinHeight = i5;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i5) {
        this.mParams.matchConstraintMinWidth = i5;
        return this;
    }

    public ConstraintProperties constrainWidth(int i5) {
        this.mParams.width = i5;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.mParams.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f5) {
        this.mView.setElevation(f5);
        return this;
    }

    public ConstraintProperties goneMargin(int i5, int i6) {
        switch (i5) {
            case 1:
                this.mParams.goneLeftMargin = i6;
                return this;
            case 2:
                this.mParams.goneRightMargin = i6;
                return this;
            case 3:
                this.mParams.goneTopMargin = i6;
                return this;
            case 4:
                this.mParams.goneBottomMargin = i6;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.goneStartMargin = i6;
                return this;
            case 7:
                this.mParams.goneEndMargin = i6;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties horizontalBias(float f5) {
        this.mParams.horizontalBias = f5;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i5) {
        this.mParams.horizontalChainStyle = i5;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f5) {
        this.mParams.horizontalWeight = f5;
        return this;
    }

    public ConstraintProperties margin(int i5, int i6) {
        switch (i5) {
            case 1:
                this.mParams.leftMargin = i6;
                return this;
            case 2:
                this.mParams.rightMargin = i6;
                return this;
            case 3:
                this.mParams.topMargin = i6;
                return this;
            case 4:
                this.mParams.bottomMargin = i6;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.setMarginStart(i6);
                return this;
            case 7:
                this.mParams.setMarginEnd(i6);
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeConstraints(int i5) {
        switch (i5) {
            case 1:
                ConstraintLayout.LayoutParams layoutParams = this.mParams;
                layoutParams.leftToRight = -1;
                layoutParams.leftToLeft = -1;
                layoutParams.leftMargin = -1;
                layoutParams.goneLeftMargin = Integer.MIN_VALUE;
                return this;
            case 2:
                ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                layoutParams2.rightToRight = -1;
                layoutParams2.rightToLeft = -1;
                layoutParams2.rightMargin = -1;
                layoutParams2.goneRightMargin = Integer.MIN_VALUE;
                return this;
            case 3:
                ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                layoutParams3.topToBottom = -1;
                layoutParams3.topToTop = -1;
                layoutParams3.topMargin = -1;
                layoutParams3.goneTopMargin = Integer.MIN_VALUE;
                return this;
            case 4:
                ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                layoutParams4.bottomToTop = -1;
                layoutParams4.bottomToBottom = -1;
                layoutParams4.bottomMargin = -1;
                layoutParams4.goneBottomMargin = Integer.MIN_VALUE;
                return this;
            case 5:
                this.mParams.baselineToBaseline = -1;
                return this;
            case 6:
                ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                layoutParams5.startToEnd = -1;
                layoutParams5.startToStart = -1;
                layoutParams5.setMarginStart(-1);
                this.mParams.goneStartMargin = Integer.MIN_VALUE;
                return this;
            case 7:
                ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                layoutParams6.endToStart = -1;
                layoutParams6.endToEnd = -1;
                layoutParams6.setMarginEnd(-1);
                this.mParams.goneEndMargin = Integer.MIN_VALUE;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i5 = layoutParams.leftToRight;
        int i6 = layoutParams.rightToLeft;
        if (i5 == -1 && i6 == -1) {
            int i7 = layoutParams.startToEnd;
            int i8 = layoutParams.endToStart;
            if (!(i7 == -1 && i8 == -1)) {
                ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i7));
                ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i8));
                ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                if (i7 != -1 && i8 != -1) {
                    constraintProperties.connect(7, i8, 6, 0);
                    constraintProperties2.connect(6, i5, 7, 0);
                } else if (!(i5 == -1 && i8 == -1)) {
                    int i9 = layoutParams2.rightToRight;
                    if (i9 != -1) {
                        constraintProperties.connect(7, i9, 7, 0);
                    } else {
                        int i10 = layoutParams2.leftToLeft;
                        if (i10 != -1) {
                            constraintProperties2.connect(6, i10, 6, 0);
                        }
                    }
                }
            }
            removeConstraints(6);
            removeConstraints(7);
            return this;
        }
        ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i5));
        ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6));
        ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
        if (i5 != -1 && i6 != -1) {
            constraintProperties3.connect(2, i6, 1, 0);
            constraintProperties4.connect(1, i5, 2, 0);
        } else if (!(i5 == -1 && i6 == -1)) {
            int i11 = layoutParams3.rightToRight;
            if (i11 != -1) {
                constraintProperties3.connect(2, i11, 2, 0);
            } else {
                int i12 = layoutParams3.leftToLeft;
                if (i12 != -1) {
                    constraintProperties4.connect(1, i12, 1, 0);
                }
            }
        }
        removeConstraints(1);
        removeConstraints(2);
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i5 = layoutParams.topToBottom;
        int i6 = layoutParams.bottomToTop;
        if (!(i5 == -1 && i6 == -1)) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i5));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6));
            ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
            if (i5 != -1 && i6 != -1) {
                constraintProperties.connect(4, i6, 3, 0);
                constraintProperties2.connect(3, i5, 4, 0);
            } else if (!(i5 == -1 && i6 == -1)) {
                int i7 = layoutParams2.bottomToBottom;
                if (i7 != -1) {
                    constraintProperties.connect(4, i7, 4, 0);
                } else {
                    int i8 = layoutParams2.topToTop;
                    if (i8 != -1) {
                        constraintProperties2.connect(3, i8, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public ConstraintProperties rotation(float f5) {
        this.mView.setRotation(f5);
        return this;
    }

    public ConstraintProperties rotationX(float f5) {
        this.mView.setRotationX(f5);
        return this;
    }

    public ConstraintProperties rotationY(float f5) {
        this.mView.setRotationY(f5);
        return this;
    }

    public ConstraintProperties scaleX(float f5) {
        this.mView.setScaleY(f5);
        return this;
    }

    public ConstraintProperties scaleY(float f5) {
        return this;
    }

    public ConstraintProperties transformPivot(float f5, float f6) {
        this.mView.setPivotX(f5);
        this.mView.setPivotY(f6);
        return this;
    }

    public ConstraintProperties transformPivotX(float f5) {
        this.mView.setPivotX(f5);
        return this;
    }

    public ConstraintProperties transformPivotY(float f5) {
        this.mView.setPivotY(f5);
        return this;
    }

    public ConstraintProperties translation(float f5, float f6) {
        this.mView.setTranslationX(f5);
        this.mView.setTranslationY(f6);
        return this;
    }

    public ConstraintProperties translationX(float f5) {
        this.mView.setTranslationX(f5);
        return this;
    }

    public ConstraintProperties translationY(float f5) {
        this.mView.setTranslationY(f5);
        return this;
    }

    public ConstraintProperties translationZ(float f5) {
        this.mView.setTranslationZ(f5);
        return this;
    }

    public ConstraintProperties verticalBias(float f5) {
        this.mParams.verticalBias = f5;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i5) {
        this.mParams.verticalChainStyle = i5;
        return this;
    }

    public ConstraintProperties verticalWeight(float f5) {
        this.mParams.verticalWeight = f5;
        return this;
    }

    public ConstraintProperties visibility(int i5) {
        this.mView.setVisibility(i5);
        return this;
    }

    public ConstraintProperties centerHorizontally(int i5) {
        if (i5 == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
            return this;
        }
        center(i5, 2, 0, i5, 1, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i5) {
        if (i5 == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
            return this;
        }
        center(i5, 7, 0, i5, 6, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerVertically(int i5) {
        if (i5 == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
            return this;
        }
        center(i5, 4, 0, i5, 3, 0, 0.5f);
        return this;
    }
}
