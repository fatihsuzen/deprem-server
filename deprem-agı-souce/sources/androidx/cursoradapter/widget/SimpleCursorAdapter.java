package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
    private CursorToStringConverter mCursorToStringConverter;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn = -1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] mTo;
    private ViewBinder mViewBinder;

    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    public interface ViewBinder {
        boolean setViewValue(View view, Cursor cursor, int i5);
    }

    @Deprecated
    public SimpleCursorAdapter(Context context, int i5, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i5, cursor);
        this.mTo = iArr;
        this.mOriginalFrom = strArr;
        findColumns(cursor, strArr);
    }

    private void findColumns(Cursor cursor, String[] strArr) {
        if (cursor != null) {
            int length = strArr.length;
            int[] iArr = this.mFrom;
            if (iArr == null || iArr.length != length) {
                this.mFrom = new int[length];
            }
            for (int i5 = 0; i5 < length; i5++) {
                this.mFrom[i5] = cursor.getColumnIndexOrThrow(strArr[i5]);
            }
            return;
        }
        this.mFrom = null;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        boolean z4;
        ViewBinder viewBinder = this.mViewBinder;
        int[] iArr = this.mTo;
        int length = iArr.length;
        int[] iArr2 = this.mFrom;
        for (int i5 = 0; i5 < length; i5++) {
            View findViewById = view.findViewById(iArr[i5]);
            if (findViewById != null) {
                if (viewBinder != null) {
                    z4 = viewBinder.setViewValue(findViewById, cursor, iArr2[i5]);
                } else {
                    z4 = false;
                }
                if (z4) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i5]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof TextView) {
                        setViewText((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        setViewImage((ImageView) findViewById, string);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] strArr, int[] iArr) {
        this.mOriginalFrom = strArr;
        this.mTo = iArr;
        findColumns(cursor, strArr);
        super.changeCursor(cursor);
    }

    public CharSequence convertToString(Cursor cursor) {
        CursorToStringConverter cursorToStringConverter = this.mCursorToStringConverter;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.convertToString(cursor);
        }
        int i5 = this.mStringConversionColumn;
        if (i5 > -1) {
            return cursor.getString(i5);
        }
        return super.convertToString(cursor);
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        this.mCursorToStringConverter = cursorToStringConverter;
    }

    public void setStringConversionColumn(int i5) {
        this.mStringConversionColumn = i5;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.mViewBinder = viewBinder;
    }

    public void setViewImage(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void setViewText(TextView textView, String str) {
        textView.setText(str);
    }

    public Cursor swapCursor(Cursor cursor) {
        findColumns(cursor, this.mOriginalFrom);
        return super.swapCursor(cursor);
    }

    public SimpleCursorAdapter(Context context, int i5, Cursor cursor, String[] strArr, int[] iArr, int i6) {
        super(context, i5, cursor, i6);
        this.mTo = iArr;
        this.mOriginalFrom = strArr;
        findColumns(cursor, strArr);
    }
}
