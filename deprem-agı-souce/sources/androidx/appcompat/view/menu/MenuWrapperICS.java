package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu != null) {
            this.mWrappedObject = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(charSequence));
    }

    public int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        MenuItem[] menuItemArr3 = menuItemArr;
        if (menuItemArr3 != null) {
            menuItemArr2 = new MenuItem[menuItemArr3.length];
        } else {
            menuItemArr2 = null;
        }
        MenuItem[] menuItemArr4 = menuItemArr2;
        int addIntentOptions = this.mWrappedObject.addIntentOptions(i5, i6, i7, componentName, intentArr, intent, i8, menuItemArr4);
        if (menuItemArr4 != null) {
            int length = menuItemArr4.length;
            for (int i9 = 0; i9 < length; i9++) {
                menuItemArr3[i9] = getMenuItemWrapper(menuItemArr4[i9]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(charSequence));
    }

    public void clear() {
        internalClear();
        this.mWrappedObject.clear();
    }

    public void close() {
        this.mWrappedObject.close();
    }

    public MenuItem findItem(int i5) {
        return getMenuItemWrapper(this.mWrappedObject.findItem(i5));
    }

    public MenuItem getItem(int i5) {
        return getMenuItemWrapper(this.mWrappedObject.getItem(i5));
    }

    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    public boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return this.mWrappedObject.isShortcutKey(i5, keyEvent);
    }

    public boolean performIdentifierAction(int i5, int i6) {
        return this.mWrappedObject.performIdentifierAction(i5, i6);
    }

    public boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        return this.mWrappedObject.performShortcut(i5, keyEvent, i6);
    }

    public void removeGroup(int i5) {
        internalRemoveGroup(i5);
        this.mWrappedObject.removeGroup(i5);
    }

    public void removeItem(int i5) {
        internalRemoveItem(i5);
        this.mWrappedObject.removeItem(i5);
    }

    public void setGroupCheckable(int i5, boolean z4, boolean z5) {
        this.mWrappedObject.setGroupCheckable(i5, z4, z5);
    }

    public void setGroupEnabled(int i5, boolean z4) {
        this.mWrappedObject.setGroupEnabled(i5, z4);
    }

    public void setGroupVisible(int i5, boolean z4) {
        this.mWrappedObject.setGroupVisible(i5, z4);
    }

    public void setQwertyMode(boolean z4) {
        this.mWrappedObject.setQwertyMode(z4);
    }

    public int size() {
        return this.mWrappedObject.size();
    }

    public MenuItem add(int i5) {
        return getMenuItemWrapper(this.mWrappedObject.add(i5));
    }

    public SubMenu addSubMenu(int i5) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i5));
    }

    public MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return getMenuItemWrapper(this.mWrappedObject.add(i5, i6, i7, charSequence));
    }

    public SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i5, i6, i7, charSequence));
    }

    public MenuItem add(int i5, int i6, int i7, int i8) {
        return getMenuItemWrapper(this.mWrappedObject.add(i5, i6, i7, i8));
    }

    public SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return getSubMenuWrapper(this.mWrappedObject.addSubMenu(i5, i6, i7, i8));
    }
}
