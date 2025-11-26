package com.google.android.material.navigation;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class DividerMenuItem implements MenuItem {
    DividerMenuItem() {
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    @Nullable
    public ActionProvider getActionProvider() {
        return null;
    }

    @Nullable
    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return 0;
    }

    public int getGroupId() {
        return 0;
    }

    @Nullable
    public Drawable getIcon() {
        return null;
    }

    @Nullable
    public Intent getIntent() {
        return null;
    }

    public int getItemId() {
        return 0;
    }

    @Nullable
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return 0;
    }

    public int getOrder() {
        return 0;
    }

    @Nullable
    public SubMenu getSubMenu() {
        return null;
    }

    @Nullable
    public CharSequence getTitle() {
        return null;
    }

    @Nullable
    public CharSequence getTitleCondensed() {
        return null;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return false;
    }

    public boolean isChecked() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }

    public boolean isVisible() {
        return false;
    }

    @NonNull
    public MenuItem setActionProvider(@Nullable ActionProvider actionProvider) {
        return null;
    }

    @NonNull
    public MenuItem setActionView(int i5) {
        return null;
    }

    @NonNull
    public MenuItem setAlphabeticShortcut(char c5) {
        return null;
    }

    @NonNull
    public MenuItem setCheckable(boolean z4) {
        return null;
    }

    @NonNull
    public MenuItem setChecked(boolean z4) {
        return null;
    }

    @NonNull
    public MenuItem setEnabled(boolean z4) {
        return null;
    }

    @NonNull
    public MenuItem setIcon(int i5) {
        return null;
    }

    @NonNull
    public MenuItem setIntent(@Nullable Intent intent) {
        return null;
    }

    @NonNull
    public MenuItem setNumericShortcut(char c5) {
        return null;
    }

    @NonNull
    public MenuItem setOnActionExpandListener(@Nullable MenuItem.OnActionExpandListener onActionExpandListener) {
        return null;
    }

    @NonNull
    public MenuItem setOnMenuItemClickListener(@Nullable MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return null;
    }

    @NonNull
    public MenuItem setShortcut(char c5, char c6) {
        return null;
    }

    public void setShowAsAction(int i5) {
    }

    @NonNull
    public MenuItem setShowAsActionFlags(int i5) {
        return null;
    }

    @NonNull
    public MenuItem setTitle(int i5) {
        return null;
    }

    @NonNull
    public MenuItem setTitleCondensed(@Nullable CharSequence charSequence) {
        return null;
    }

    @NonNull
    public MenuItem setVisible(boolean z4) {
        return null;
    }

    @NonNull
    public MenuItem setActionView(@Nullable View view) {
        return null;
    }

    @NonNull
    public MenuItem setIcon(@Nullable Drawable drawable) {
        return null;
    }

    @NonNull
    public MenuItem setTitle(@Nullable CharSequence charSequence) {
        return null;
    }
}
