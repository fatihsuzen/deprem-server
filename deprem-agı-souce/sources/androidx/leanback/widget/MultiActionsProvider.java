package androidx.leanback.widget;

import android.graphics.drawable.Drawable;

public interface MultiActionsProvider {

    public static class MultiAction {
        private Drawable[] mDrawables;
        private long mId;
        private int mIndex = 0;

        public MultiAction(long j5) {
            this.mId = j5;
        }

        public Drawable getCurrentDrawable() {
            return this.mDrawables[this.mIndex];
        }

        public Drawable[] getDrawables() {
            return this.mDrawables;
        }

        public long getId() {
            return this.mId;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public void incrementIndex() {
            int i5;
            int i6 = this.mIndex;
            if (i6 < this.mDrawables.length - 1) {
                i5 = i6 + 1;
            } else {
                i5 = 0;
            }
            setIndex(i5);
        }

        public void setDrawables(Drawable[] drawableArr) {
            this.mDrawables = drawableArr;
            if (this.mIndex > drawableArr.length - 1) {
                this.mIndex = drawableArr.length - 1;
            }
        }

        public void setIndex(int i5) {
            this.mIndex = i5;
        }
    }

    MultiAction[] getActions();
}
