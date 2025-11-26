package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface MenuView {

    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl menuItemImpl, int i5);

        boolean prefersCondensedTitle();

        void setCheckable(boolean z4);

        void setChecked(boolean z4);

        void setEnabled(boolean z4);

        void setIcon(Drawable drawable);

        void setShortcut(boolean z4, char c5);

        void setTitle(CharSequence charSequence);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(MenuBuilder menuBuilder);
}
