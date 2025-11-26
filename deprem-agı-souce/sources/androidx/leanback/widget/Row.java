package androidx.leanback.widget;

public class Row {
    private static final int FLAG_ID_USE_HEADER = 1;
    private static final int FLAG_ID_USE_ID = 0;
    private static final int FLAG_ID_USE_MASK = 1;
    private int mFlags = 1;
    private HeaderItem mHeaderItem;
    private long mId = -1;

    public Row(long j5, HeaderItem headerItem) {
        setId(j5);
        setHeaderItem(headerItem);
    }

    /* access modifiers changed from: package-private */
    public final int getFlags() {
        return this.mFlags;
    }

    public final HeaderItem getHeaderItem() {
        return this.mHeaderItem;
    }

    public final long getId() {
        if ((this.mFlags & 1) != 1) {
            return this.mId;
        }
        HeaderItem headerItem = getHeaderItem();
        if (headerItem != null) {
            return headerItem.getId();
        }
        return -1;
    }

    public boolean isRenderedAsRowView() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void setFlags(int i5, int i6) {
        this.mFlags = (i5 & i6) | (this.mFlags & (~i6));
    }

    public final void setHeaderItem(HeaderItem headerItem) {
        this.mHeaderItem = headerItem;
    }

    public final void setId(long j5) {
        this.mId = j5;
        setFlags(0, 1);
    }

    public Row(HeaderItem headerItem) {
        setHeaderItem(headerItem);
    }

    public Row() {
    }
}
