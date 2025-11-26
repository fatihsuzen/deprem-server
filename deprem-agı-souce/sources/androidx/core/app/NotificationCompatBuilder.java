package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private final List<Bundle> mActionExtrasList = new ArrayList();
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private final Bundle mExtras = new Bundle();
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static Notification.Builder addAction(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        @DoNotInline
        static Notification.Action.Builder addExtras(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        @DoNotInline
        static Notification.Action.Builder addRemoteInput(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        @DoNotInline
        static Notification.Action build(Notification.Action.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static Notification.Action.Builder createBuilder(int i5, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i5, charSequence, pendingIntent);
        }

        @DoNotInline
        static String getGroup(Notification notification) {
            return notification.getGroup();
        }

        @DoNotInline
        static Notification.Builder setGroup(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        @DoNotInline
        static Notification.Builder setGroupSummary(Notification.Builder builder, boolean z4) {
            return builder.setGroupSummary(z4);
        }

        @DoNotInline
        static Notification.Builder setLocalOnly(Notification.Builder builder, boolean z4) {
            return builder.setLocalOnly(z4);
        }

        @DoNotInline
        static Notification.Builder setSortKey(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Notification.Builder addPerson(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        @DoNotInline
        static Notification.Builder setCategory(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        @DoNotInline
        static Notification.Builder setColor(Notification.Builder builder, int i5) {
            return builder.setColor(i5);
        }

        @DoNotInline
        static Notification.Builder setPublicVersion(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        @DoNotInline
        static Notification.Builder setSound(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        @DoNotInline
        static Notification.Builder setVisibility(Notification.Builder builder, int i5) {
            return builder.setVisibility(i5);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static Notification.Action.Builder createBuilder(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        @DoNotInline
        static Notification.Builder setLargeIcon(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        @DoNotInline
        static Notification.Builder setSmallIcon(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean z4) {
            return builder.setAllowGeneratedReplies(z4);
        }

        @DoNotInline
        static Notification.Builder setCustomBigContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder setCustomContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder setCustomHeadsUpContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder setRemoteInputHistory(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static Notification.Builder createBuilder(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        @DoNotInline
        static Notification.Builder setBadgeIconType(Notification.Builder builder, int i5) {
            return builder.setBadgeIconType(i5);
        }

        @DoNotInline
        static Notification.Builder setColorized(Notification.Builder builder, boolean z4) {
            return builder.setColorized(z4);
        }

        @DoNotInline
        static Notification.Builder setGroupAlertBehavior(Notification.Builder builder, int i5) {
            return builder.setGroupAlertBehavior(i5);
        }

        @DoNotInline
        static Notification.Builder setSettingsText(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        @DoNotInline
        static Notification.Builder setShortcutId(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        @DoNotInline
        static Notification.Builder setTimeoutAfter(Notification.Builder builder, long j5) {
            return builder.setTimeoutAfter(j5);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Notification.Builder addPerson(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        @DoNotInline
        static Notification.Action.Builder setSemanticAction(Notification.Action.Builder builder, int i5) {
            return builder.setSemanticAction(i5);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder builder, boolean z4) {
            return builder.setAllowSystemGeneratedContextualActions(z4);
        }

        @DoNotInline
        static Notification.Builder setBubbleMetadata(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        @DoNotInline
        static Notification.Action.Builder setContextual(Notification.Action.Builder builder, boolean z4) {
            return builder.setContextual(z4);
        }

        @DoNotInline
        static Notification.Builder setLocusId(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean z4) {
            return builder.setAuthenticationRequired(z4);
        }

        @DoNotInline
        static Notification.Builder setForegroundServiceBehavior(Notification.Builder builder, int i5) {
            return builder.setForegroundServiceBehavior(i5);
        }
    }

    NotificationCompatBuilder(NotificationCompat.Builder builder) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Icon icon;
        List<String> list;
        int i5;
        this.mBuilderCompat = builder;
        Context context = builder.mContext;
        this.mContext = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.mBuilder = Api26Impl.createBuilder(context, builder.mChannelId);
        } else {
            this.mBuilder = new Notification.Builder(builder.mContext);
        }
        Notification notification = builder.mNotification;
        Notification.Builder lights = this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.mTickerView).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        int i6 = 0;
        if ((notification.flags & 2) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z4);
        if ((notification.flags & 8) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z5);
        if ((notification.flags & 16) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z6).setDefaults(notification.defaults).setContentTitle(builder.mContentTitle).setContentText(builder.mContentText).setContentInfo(builder.mContentInfo).setContentIntent(builder.mContentIntent).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = builder.mFullScreenIntent;
        if ((notification.flags & 128) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        deleteIntent.setFullScreenIntent(pendingIntent, z7).setNumber(builder.mNumber).setProgress(builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
        Notification.Builder builder2 = this.mBuilder;
        IconCompat iconCompat = builder.mLargeIcon;
        if (iconCompat == null) {
            icon = null;
        } else {
            icon = iconCompat.toIcon(context);
        }
        Api23Impl.setLargeIcon(builder2, icon);
        this.mBuilder.setSubText(builder.mSubText).setUsesChronometer(builder.mUseChronometer).setPriority(builder.mPriority);
        NotificationCompat.Style style = builder.mStyle;
        if (style instanceof NotificationCompat.CallStyle) {
            ArrayList<NotificationCompat.Action> actionsListWithSystemActions = ((NotificationCompat.CallStyle) style).getActionsListWithSystemActions();
            int size = actionsListWithSystemActions.size();
            int i7 = 0;
            while (i7 < size) {
                NotificationCompat.Action action = actionsListWithSystemActions.get(i7);
                i7++;
                addAction(action);
            }
        } else {
            ArrayList<NotificationCompat.Action> arrayList = builder.mActions;
            int size2 = arrayList.size();
            int i8 = 0;
            while (i8 < size2) {
                NotificationCompat.Action action2 = arrayList.get(i8);
                i8++;
                addAction(action2);
            }
        }
        Bundle bundle = builder.mExtras;
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        int i9 = Build.VERSION.SDK_INT;
        this.mContentView = builder.mContentView;
        this.mBigContentView = builder.mBigContentView;
        this.mBuilder.setShowWhen(builder.mShowWhen);
        Api20Impl.setLocalOnly(this.mBuilder, builder.mLocalOnly);
        Api20Impl.setGroup(this.mBuilder, builder.mGroupKey);
        Api20Impl.setSortKey(this.mBuilder, builder.mSortKey);
        Api20Impl.setGroupSummary(this.mBuilder, builder.mGroupSummary);
        this.mGroupAlertBehavior = builder.mGroupAlertBehavior;
        Api21Impl.setCategory(this.mBuilder, builder.mCategory);
        Api21Impl.setColor(this.mBuilder, builder.mColor);
        Api21Impl.setVisibility(this.mBuilder, builder.mVisibility);
        Api21Impl.setPublicVersion(this.mBuilder, builder.mPublicVersion);
        Api21Impl.setSound(this.mBuilder, notification.sound, notification.audioAttributes);
        if (i9 < 28) {
            list = combineLists(getPeople(builder.mPersonList), builder.mPeople);
        } else {
            list = builder.mPeople;
        }
        if (list != null && !list.isEmpty()) {
            for (String addPerson : list) {
                Api21Impl.addPerson(this.mBuilder, addPerson);
            }
        }
        this.mHeadsUpContentView = builder.mHeadsUpContentView;
        if (builder.mInvisibleActions.size() > 0) {
            Bundle bundle2 = builder.getExtras().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i10 = 0; i10 < builder.mInvisibleActions.size(); i10++) {
                bundle4.putBundle(Integer.toString(i10), NotificationCompatJellybean.getBundleForAction(builder.mInvisibleActions.get(i10)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle2);
            this.mExtras.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i11 = Build.VERSION.SDK_INT;
        Object obj = builder.mSmallIcon;
        if (obj != null) {
            Api23Impl.setSmallIcon(this.mBuilder, obj);
        }
        if (i11 >= 24) {
            this.mBuilder.setExtras(builder.mExtras);
            Api24Impl.setRemoteInputHistory(this.mBuilder, builder.mRemoteInputHistory);
            RemoteViews remoteViews = builder.mContentView;
            if (remoteViews != null) {
                Api24Impl.setCustomContentView(this.mBuilder, remoteViews);
            }
            RemoteViews remoteViews2 = builder.mBigContentView;
            if (remoteViews2 != null) {
                Api24Impl.setCustomBigContentView(this.mBuilder, remoteViews2);
            }
            RemoteViews remoteViews3 = builder.mHeadsUpContentView;
            if (remoteViews3 != null) {
                Api24Impl.setCustomHeadsUpContentView(this.mBuilder, remoteViews3);
            }
        }
        if (i11 >= 26) {
            Api26Impl.setBadgeIconType(this.mBuilder, builder.mBadgeIcon);
            Api26Impl.setSettingsText(this.mBuilder, builder.mSettingsText);
            Api26Impl.setShortcutId(this.mBuilder, builder.mShortcutId);
            Api26Impl.setTimeoutAfter(this.mBuilder, builder.mTimeout);
            Api26Impl.setGroupAlertBehavior(this.mBuilder, builder.mGroupAlertBehavior);
            if (builder.mColorizedSet) {
                Api26Impl.setColorized(this.mBuilder, builder.mColorized);
            }
            if (!TextUtils.isEmpty(builder.mChannelId)) {
                this.mBuilder.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (i11 >= 28) {
            ArrayList<Person> arrayList2 = builder.mPersonList;
            int size3 = arrayList2.size();
            while (i6 < size3) {
                Person person = arrayList2.get(i6);
                i6++;
                Api28Impl.addPerson(this.mBuilder, person.toAndroidPerson());
            }
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 29) {
            Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, builder.mAllowSystemGeneratedContextualActions);
            Api29Impl.setBubbleMetadata(this.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(builder.mBubbleMetadata));
            LocusIdCompat locusIdCompat = builder.mLocusId;
            if (locusIdCompat != null) {
                Api29Impl.setLocusId(this.mBuilder, locusIdCompat.toLocusId());
            }
        }
        if (i12 >= 31 && (i5 = builder.mFgsDeferBehavior) != 0) {
            Api31Impl.setForegroundServiceBehavior(this.mBuilder, i5);
        }
        if (builder.mSilent) {
            if (this.mBuilderCompat.mGroupSummary) {
                this.mGroupAlertBehavior = 2;
            } else {
                this.mGroupAlertBehavior = 1;
            }
            this.mBuilder.setVibrate((long[]) null);
            this.mBuilder.setSound((Uri) null);
            int i13 = notification.defaults & -4;
            notification.defaults = i13;
            this.mBuilder.setDefaults(i13);
            if (i12 >= 26) {
                if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey)) {
                    Api20Impl.setGroup(this.mBuilder, NotificationCompat.GROUP_KEY_SILENT);
                }
                Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
            }
        }
    }

    private void addAction(NotificationCompat.Action action) {
        Icon icon;
        Bundle bundle;
        IconCompat iconCompat = action.getIconCompat();
        if (iconCompat != null) {
            icon = iconCompat.toIcon();
        } else {
            icon = null;
        }
        Notification.Action.Builder createBuilder = Api23Impl.createBuilder(icon, action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (RemoteInput addRemoteInput : RemoteInput.fromCompat(action.getRemoteInputs())) {
                Api20Impl.addRemoteInput(createBuilder, addRemoteInput);
            }
        }
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 24) {
            Api24Impl.setAllowGeneratedReplies(createBuilder, action.getAllowGeneratedReplies());
        }
        bundle.putInt("android.support.action.semanticAction", action.getSemanticAction());
        if (i5 >= 28) {
            Api28Impl.setSemanticAction(createBuilder, action.getSemanticAction());
        }
        if (i5 >= 29) {
            Api29Impl.setContextual(createBuilder, action.isContextual());
        }
        if (i5 >= 31) {
            Api31Impl.setAuthenticationRequired(createBuilder, action.isAuthenticationRequired());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        Api20Impl.addExtras(createBuilder, bundle);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(createBuilder));
    }

    @Nullable
    private static List<String> combineLists(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    @Nullable
    private static List<String> getPeople(@Nullable List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Person resolveToLegacyUri : list) {
            arrayList.add(resolveToLegacyUri.resolveToLegacyUri());
        }
        return arrayList;
    }

    private void removeSoundAndVibration(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    public Notification build() {
        RemoteViews remoteViews;
        Bundle extras;
        RemoteViews makeHeadsUpContentView;
        RemoteViews makeBigContentView;
        NotificationCompat.Style style = this.mBuilderCompat.mStyle;
        if (style != null) {
            style.apply(this);
        }
        if (style != null) {
            remoteViews = style.makeContentView(this);
        } else {
            remoteViews = null;
        }
        Notification buildInternal = buildInternal();
        if (remoteViews != null) {
            buildInternal.contentView = remoteViews;
        } else {
            RemoteViews remoteViews2 = this.mBuilderCompat.mContentView;
            if (remoteViews2 != null) {
                buildInternal.contentView = remoteViews2;
            }
        }
        if (!(style == null || (makeBigContentView = style.makeBigContentView(this)) == null)) {
            buildInternal.bigContentView = makeBigContentView;
        }
        if (!(style == null || (makeHeadsUpContentView = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this)) == null)) {
            buildInternal.headsUpContentView = makeHeadsUpContentView;
        }
        if (!(style == null || (extras = NotificationCompat.getExtras(buildInternal)) == null)) {
            style.addCompatExtras(extras);
        }
        return buildInternal;
    }

    /* access modifiers changed from: protected */
    public Notification buildInternal() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            return this.mBuilder.build();
        }
        if (i5 >= 24) {
            Notification build = this.mBuilder.build();
            if (this.mGroupAlertBehavior != 0) {
                if (!(Api20Impl.getGroup(build) == null || (build.flags & 512) == 0 || this.mGroupAlertBehavior != 2)) {
                    removeSoundAndVibration(build);
                }
                if (Api20Impl.getGroup(build) != null && (build.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                    removeSoundAndVibration(build);
                }
            }
            return build;
        }
        this.mBuilder.setExtras(this.mExtras);
        Notification build2 = this.mBuilder.build();
        RemoteViews remoteViews = this.mContentView;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.mBigContentView;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.mHeadsUpContentView;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.mGroupAlertBehavior != 0) {
            if (!(Api20Impl.getGroup(build2) == null || (build2.flags & 512) == 0 || this.mGroupAlertBehavior != 2)) {
                removeSoundAndVibration(build2);
            }
            if (Api20Impl.getGroup(build2) != null && (build2.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                removeSoundAndVibration(build2);
            }
        }
        return build2;
    }

    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    /* access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }
}
