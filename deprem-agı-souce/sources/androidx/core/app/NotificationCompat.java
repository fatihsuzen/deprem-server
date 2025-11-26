package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.app.Person;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import j$.util.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_WORKOUT = "workout";
    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ANSWER_COLOR = "android.answerColor";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ANSWER_INTENT = "android.answerIntent";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_IS_VIDEO = "android.callIsVideo";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_PERSON = "android.callPerson";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_PERSON_COMPAT = "android.callPersonCompat";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_TYPE = "android.callType";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COLORIZED = "android.colorized";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_DECLINE_COLOR = "android.declineColor";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_DECLINE_INTENT = "android.declineIntent";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HANG_UP_INTENT = "android.hangUpIntent";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGES = "android.messages";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";
    @SuppressLint({"ActionValue"})
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE = "android.picture";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS = "android.progress";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SMALL_ICON = "android.icon";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUB_TEXT = "android.subText";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEMPLATE = "android.template";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT = "android.text";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE = "android.title";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_ICON = "android.verificationIcon";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_ICON_COMPAT = "android.verificationIconCompat";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_TEXT = "android.verificationText";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    @SuppressLint({"ActionValue"})
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_ACTION_BUTTONS = 3;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    private static final String TAG = "NotifCompat";
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    public static class Action {
        static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
        static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
        public static final int SEMANTIC_ACTION_ARCHIVE = 5;
        public static final int SEMANTIC_ACTION_CALL = 10;
        public static final int SEMANTIC_ACTION_DELETE = 4;
        public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
        public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
        public static final int SEMANTIC_ACTION_MUTE = 6;
        public static final int SEMANTIC_ACTION_NONE = 0;
        public static final int SEMANTIC_ACTION_REPLY = 1;
        public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
        public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
        public static final int SEMANTIC_ACTION_UNMUTE = 7;
        @Nullable
        public PendingIntent actionIntent;
        @Deprecated
        public int icon;
        private boolean mAllowGeneratedReplies;
        private boolean mAuthenticationRequired;
        private final RemoteInput[] mDataOnlyRemoteInputs;
        final Bundle mExtras;
        @Nullable
        private IconCompat mIcon;
        private final boolean mIsContextual;
        private final RemoteInput[] mRemoteInputs;
        private final int mSemanticAction;
        boolean mShowsUserInterface;
        public CharSequence title;

        public static final class Builder {
            private boolean mAllowGeneratedReplies;
            private boolean mAuthenticationRequired;
            private final Bundle mExtras;
            private final IconCompat mIcon;
            private final PendingIntent mIntent;
            private boolean mIsContextual;
            private ArrayList<RemoteInput> mRemoteInputs;
            private int mSemanticAction;
            private boolean mShowsUserInterface;
            private final CharSequence mTitle;

            @RequiresApi(20)
            static class Api20Impl {
                private Api20Impl() {
                }

                @DoNotInline
                static Bundle getExtras(Notification.Action action) {
                    return action.getExtras();
                }

                @DoNotInline
                static RemoteInput[] getRemoteInputs(Notification.Action action) {
                    return action.getRemoteInputs();
                }
            }

            @RequiresApi(23)
            static class Api23Impl {
                private Api23Impl() {
                }

                @DoNotInline
                static Icon getIcon(Notification.Action action) {
                    return action.getIcon();
                }
            }

            @RequiresApi(24)
            static class Api24Impl {
                private Api24Impl() {
                }

                @DoNotInline
                static boolean getAllowGeneratedReplies(Notification.Action action) {
                    return action.getAllowGeneratedReplies();
                }
            }

            @RequiresApi(28)
            static class Api28Impl {
                private Api28Impl() {
                }

                @DoNotInline
                static int getSemanticAction(Notification.Action action) {
                    return action.getSemanticAction();
                }
            }

            @RequiresApi(29)
            static class Api29Impl {
                private Api29Impl() {
                }

                @DoNotInline
                static boolean isContextual(Notification.Action action) {
                    return action.isContextual();
                }
            }

            @RequiresApi(31)
            static class Api31Impl {
                private Api31Impl() {
                }

                @DoNotInline
                static boolean isAuthenticationRequired(Notification.Action action) {
                    return action.isAuthenticationRequired();
                }
            }

            public Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, true, 0, true, false, false);
            }

            private void checkContextualActionNullFields() {
                if (this.mIsContextual && this.mIntent == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            @NonNull
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            public static Builder fromAndroidAction(@NonNull Notification.Action action) {
                Builder builder;
                if (Api23Impl.getIcon(action) != null) {
                    builder = new Builder(IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(action)), action.title, action.actionIntent);
                } else {
                    builder = new Builder(action.icon, action.title, action.actionIntent);
                }
                RemoteInput[] remoteInputs = Api20Impl.getRemoteInputs(action);
                if (!(remoteInputs == null || remoteInputs.length == 0)) {
                    for (RemoteInput fromPlatform : remoteInputs) {
                        builder.addRemoteInput(RemoteInput.fromPlatform(fromPlatform));
                    }
                }
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 24) {
                    builder.mAllowGeneratedReplies = Api24Impl.getAllowGeneratedReplies(action);
                }
                if (i5 >= 28) {
                    builder.setSemanticAction(Api28Impl.getSemanticAction(action));
                }
                if (i5 >= 29) {
                    builder.setContextual(Api29Impl.isContextual(action));
                }
                if (i5 >= 31) {
                    builder.setAuthenticationRequired(Api31Impl.isAuthenticationRequired(action));
                }
                builder.addExtras(Api20Impl.getExtras(action));
                return builder;
            }

            @NonNull
            public Builder addExtras(@Nullable Bundle bundle) {
                if (bundle != null) {
                    this.mExtras.putAll(bundle);
                }
                return this;
            }

            @NonNull
            public Builder addRemoteInput(@Nullable RemoteInput remoteInput) {
                if (this.mRemoteInputs == null) {
                    this.mRemoteInputs = new ArrayList<>();
                }
                if (remoteInput != null) {
                    this.mRemoteInputs.add(remoteInput);
                }
                return this;
            }

            /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.Object[]] */
            /* JADX WARNING: Multi-variable type inference failed */
            @androidx.annotation.NonNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public androidx.core.app.NotificationCompat.Action build() {
                /*
                    r17 = this;
                    r0 = r17
                    r0.checkContextualActionNullFields()
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.ArrayList<androidx.core.app.RemoteInput> r3 = r0.mRemoteInputs
                    if (r3 == 0) goto L_0x0030
                    int r4 = r3.size()
                    r5 = 0
                L_0x0018:
                    if (r5 >= r4) goto L_0x0030
                    java.lang.Object r6 = r3.get(r5)
                    int r5 = r5 + 1
                    androidx.core.app.RemoteInput r6 = (androidx.core.app.RemoteInput) r6
                    boolean r7 = r6.isDataOnly()
                    if (r7 == 0) goto L_0x002c
                    r1.add(r6)
                    goto L_0x0018
                L_0x002c:
                    r2.add(r6)
                    goto L_0x0018
                L_0x0030:
                    boolean r3 = r1.isEmpty()
                    r4 = 0
                    if (r3 == 0) goto L_0x0039
                    r11 = r4
                    goto L_0x0046
                L_0x0039:
                    int r3 = r1.size()
                    androidx.core.app.RemoteInput[] r3 = new androidx.core.app.RemoteInput[r3]
                    java.lang.Object[] r1 = r1.toArray(r3)
                    androidx.core.app.RemoteInput[] r1 = (androidx.core.app.RemoteInput[]) r1
                    r11 = r1
                L_0x0046:
                    boolean r1 = r2.isEmpty()
                    if (r1 == 0) goto L_0x004e
                L_0x004c:
                    r10 = r4
                    goto L_0x005c
                L_0x004e:
                    int r1 = r2.size()
                    androidx.core.app.RemoteInput[] r1 = new androidx.core.app.RemoteInput[r1]
                    java.lang.Object[] r1 = r2.toArray(r1)
                    r4 = r1
                    androidx.core.app.RemoteInput[] r4 = (androidx.core.app.RemoteInput[]) r4
                    goto L_0x004c
                L_0x005c:
                    androidx.core.app.NotificationCompat$Action r5 = new androidx.core.app.NotificationCompat$Action
                    androidx.core.graphics.drawable.IconCompat r6 = r0.mIcon
                    java.lang.CharSequence r7 = r0.mTitle
                    android.app.PendingIntent r8 = r0.mIntent
                    android.os.Bundle r9 = r0.mExtras
                    boolean r12 = r0.mAllowGeneratedReplies
                    int r13 = r0.mSemanticAction
                    boolean r14 = r0.mShowsUserInterface
                    boolean r15 = r0.mIsContextual
                    boolean r1 = r0.mAuthenticationRequired
                    r16 = r1
                    r5.<init>((androidx.core.graphics.drawable.IconCompat) r6, (java.lang.CharSequence) r7, (android.app.PendingIntent) r8, (android.os.Bundle) r9, (androidx.core.app.RemoteInput[]) r10, (androidx.core.app.RemoteInput[]) r11, (boolean) r12, (int) r13, (boolean) r14, (boolean) r15, (boolean) r16)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Action.Builder.build():androidx.core.app.NotificationCompat$Action");
            }

            @NonNull
            public Builder extend(@NonNull Extender extender) {
                extender.extend(this);
                return this;
            }

            @NonNull
            public Bundle getExtras() {
                return this.mExtras;
            }

            @NonNull
            public Builder setAllowGeneratedReplies(boolean z4) {
                this.mAllowGeneratedReplies = z4;
                return this;
            }

            @NonNull
            public Builder setAuthenticationRequired(boolean z4) {
                this.mAuthenticationRequired = z4;
                return this;
            }

            @NonNull
            public Builder setContextual(boolean z4) {
                this.mIsContextual = z4;
                return this;
            }

            @NonNull
            public Builder setSemanticAction(int i5) {
                this.mSemanticAction = i5;
                return this;
            }

            @NonNull
            public Builder setShowsUserInterface(boolean z4) {
                this.mShowsUserInterface = z4;
                return this;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public Builder(int i5, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(i5 != 0 ? IconCompat.createWithResource((Resources) null, "", i5) : null, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, true, 0, true, false, false);
            }

            public Builder(@NonNull Action action) {
                this(action.getIconCompat(), action.title, action.actionIntent, new Bundle(action.mExtras), action.getRemoteInputs(), action.getAllowGeneratedReplies(), action.getSemanticAction(), action.mShowsUserInterface, action.isContextual(), action.isAuthenticationRequired());
            }

            private Builder(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @NonNull Bundle bundle, @Nullable RemoteInput[] remoteInputArr, boolean z4, int i5, boolean z5, boolean z6, boolean z7) {
                ArrayList<RemoteInput> arrayList;
                this.mAllowGeneratedReplies = true;
                this.mShowsUserInterface = true;
                this.mIcon = iconCompat;
                this.mTitle = Builder.limitCharSequenceLength(charSequence);
                this.mIntent = pendingIntent;
                this.mExtras = bundle;
                if (remoteInputArr == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList<>(Arrays.asList(remoteInputArr));
                }
                this.mRemoteInputs = arrayList;
                this.mAllowGeneratedReplies = z4;
                this.mSemanticAction = i5;
                this.mShowsUserInterface = z5;
                this.mIsContextual = z6;
                this.mAuthenticationRequired = z7;
            }
        }

        public interface Extender {
            @NonNull
            Builder extend(@NonNull Builder builder);
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SemanticAction {
        }

        public static final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final int FLAG_HINT_DISPLAY_INLINE = 4;
            private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags = 1;
            private CharSequence mInProgressLabel;

            public WearableExtender() {
            }

            private void setFlag(int i5, boolean z4) {
                if (z4) {
                    this.mFlags = i5 | this.mFlags;
                    return;
                }
                this.mFlags = (~i5) & this.mFlags;
            }

            @NonNull
            public Builder extend(@NonNull Builder builder) {
                Bundle bundle = new Bundle();
                int i5 = this.mFlags;
                if (i5 != 1) {
                    bundle.putInt(KEY_FLAGS, i5);
                }
                CharSequence charSequence = this.mInProgressLabel;
                if (charSequence != null) {
                    bundle.putCharSequence(KEY_IN_PROGRESS_LABEL, charSequence);
                }
                CharSequence charSequence2 = this.mConfirmLabel;
                if (charSequence2 != null) {
                    bundle.putCharSequence(KEY_CONFIRM_LABEL, charSequence2);
                }
                CharSequence charSequence3 = this.mCancelLabel;
                if (charSequence3 != null) {
                    bundle.putCharSequence(KEY_CANCEL_LABEL, charSequence3);
                }
                builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
                return builder;
            }

            @Deprecated
            @Nullable
            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            @Deprecated
            @Nullable
            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public boolean getHintDisplayActionInline() {
                if ((this.mFlags & 4) != 0) {
                    return true;
                }
                return false;
            }

            public boolean getHintLaunchesActivity() {
                if ((this.mFlags & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Deprecated
            @Nullable
            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                if ((this.mFlags & 1) != 0) {
                    return true;
                }
                return false;
            }

            @NonNull
            public WearableExtender setAvailableOffline(boolean z4) {
                setFlag(1, z4);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setCancelLabel(@Nullable CharSequence charSequence) {
                this.mCancelLabel = charSequence;
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setConfirmLabel(@Nullable CharSequence charSequence) {
                this.mConfirmLabel = charSequence;
                return this;
            }

            @NonNull
            public WearableExtender setHintDisplayActionInline(boolean z4) {
                setFlag(4, z4);
                return this;
            }

            @NonNull
            public WearableExtender setHintLaunchesActivity(boolean z4) {
                setFlag(2, z4);
                return this;
            }

            @NonNull
            @Deprecated
            public WearableExtender setInProgressLabel(@Nullable CharSequence charSequence) {
                this.mInProgressLabel = charSequence;
                return this;
            }

            @NonNull
            public WearableExtender clone() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.mFlags = this.mFlags;
                wearableExtender.mInProgressLabel = this.mInProgressLabel;
                wearableExtender.mConfirmLabel = this.mConfirmLabel;
                wearableExtender.mCancelLabel = this.mCancelLabel;
                return wearableExtender;
            }

            public WearableExtender(@NonNull Action action) {
                Bundle bundle = action.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (bundle != null) {
                    this.mFlags = bundle.getInt(KEY_FLAGS, 1);
                    this.mInProgressLabel = bundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = bundle.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = bundle.getCharSequence(KEY_CANCEL_LABEL);
                }
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Action(int i5, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(i5 != 0 ? IconCompat.createWithResource((Resources) null, "", i5) : null, charSequence, pendingIntent);
        }

        @Nullable
        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public boolean getAllowGeneratedReplies() {
            return this.mAllowGeneratedReplies;
        }

        @Nullable
        public RemoteInput[] getDataOnlyRemoteInputs() {
            return this.mDataOnlyRemoteInputs;
        }

        @NonNull
        public Bundle getExtras() {
            return this.mExtras;
        }

        @Deprecated
        public int getIcon() {
            return this.icon;
        }

        @Nullable
        public IconCompat getIconCompat() {
            int i5;
            if (this.mIcon == null && (i5 = this.icon) != 0) {
                this.mIcon = IconCompat.createWithResource((Resources) null, "", i5);
            }
            return this.mIcon;
        }

        @Nullable
        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public int getSemanticAction() {
            return this.mSemanticAction;
        }

        public boolean getShowsUserInterface() {
            return this.mShowsUserInterface;
        }

        @Nullable
        public CharSequence getTitle() {
            return this.title;
        }

        public boolean isAuthenticationRequired() {
            return this.mAuthenticationRequired;
        }

        public boolean isContextual() {
            return this.mIsContextual;
        }

        public Action(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (RemoteInput[]) null, (RemoteInput[]) null, true, 0, true, false, false);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        Action(int i5, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable RemoteInput[] remoteInputArr, @Nullable RemoteInput[] remoteInputArr2, boolean z4, int i6, boolean z5, boolean z6, boolean z7) {
            this(i5 != 0 ? IconCompat.createWithResource((Resources) null, "", i5) : null, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z4, i6, z5, z6, z7);
        }

        Action(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable RemoteInput[] remoteInputArr, @Nullable RemoteInput[] remoteInputArr2, boolean z4, int i5, boolean z5, boolean z6, boolean z7) {
            this.mShowsUserInterface = true;
            this.mIcon = iconCompat;
            if (iconCompat != null && iconCompat.getType() == 2) {
                this.icon = iconCompat.getResId();
            }
            this.title = Builder.limitCharSequenceLength(charSequence);
            this.actionIntent = pendingIntent;
            this.mExtras = bundle == null ? new Bundle() : bundle;
            this.mRemoteInputs = remoteInputArr;
            this.mDataOnlyRemoteInputs = remoteInputArr2;
            this.mAllowGeneratedReplies = z4;
            this.mSemanticAction = i5;
            this.mShowsUserInterface = z5;
            this.mIsContextual = z6;
            this.mAuthenticationRequired = z7;
        }
    }

    @RequiresApi(20)
    static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        static boolean getAllowFreeFormInput(RemoteInput remoteInput) {
            return remoteInput.getAllowFreeFormInput();
        }

        @DoNotInline
        static CharSequence[] getChoices(RemoteInput remoteInput) {
            return remoteInput.getChoices();
        }

        @DoNotInline
        static Bundle getExtras(Notification.Action action) {
            return action.getExtras();
        }

        @DoNotInline
        static String getGroup(Notification notification) {
            return notification.getGroup();
        }

        @DoNotInline
        static CharSequence getLabel(RemoteInput remoteInput) {
            return remoteInput.getLabel();
        }

        @DoNotInline
        static RemoteInput[] getRemoteInputs(Notification.Action action) {
            return action.getRemoteInputs();
        }

        @DoNotInline
        static String getResultKey(RemoteInput remoteInput) {
            return remoteInput.getResultKey();
        }

        @DoNotInline
        static String getSortKey(Notification notification) {
            return notification.getSortKey();
        }

        @DoNotInline
        static Bundle getExtras(RemoteInput remoteInput) {
            return remoteInput.getExtras();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static Icon getIcon(Notification.Action action) {
            return action.getIcon();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static boolean getAllowGeneratedReplies(Notification.Action action) {
            return action.getAllowGeneratedReplies();
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int getBadgeIconType(Notification notification) {
            return notification.getBadgeIconType();
        }

        @DoNotInline
        static String getChannelId(Notification notification) {
            return notification.getChannelId();
        }

        @DoNotInline
        static int getGroupAlertBehavior(Notification notification) {
            return notification.getGroupAlertBehavior();
        }

        @DoNotInline
        static CharSequence getSettingsText(Notification notification) {
            return notification.getSettingsText();
        }

        @DoNotInline
        static String getShortcutId(Notification notification) {
            return notification.getShortcutId();
        }

        @DoNotInline
        static long getTimeoutAfter(Notification notification) {
            return notification.getTimeoutAfter();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int getSemanticAction(Notification.Action action) {
            return action.getSemanticAction();
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
            return notification.getAllowSystemGeneratedContextualActions();
        }

        @DoNotInline
        static Notification.BubbleMetadata getBubbleMetadata(Notification notification) {
            return notification.getBubbleMetadata();
        }

        @DoNotInline
        static int getEditChoicesBeforeSending(RemoteInput remoteInput) {
            return remoteInput.getEditChoicesBeforeSending();
        }

        @DoNotInline
        static LocusId getLocusId(Notification notification) {
            return notification.getLocusId();
        }

        @DoNotInline
        static boolean isContextual(Notification.Action action) {
            return action.isContextual();
        }
    }

    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean isAuthenticationRequired(Notification.Action action) {
            return action.isAuthenticationRequired();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeIconType {
    }

    public static class BigPictureStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
        private IconCompat mBigLargeIcon;
        private boolean mBigLargeIconSet;
        private CharSequence mPictureContentDescription;
        private IconCompat mPictureIcon;
        private boolean mShowBigPictureWhenCollapsed;

        @RequiresApi(23)
        private static class Api23Impl {
            private Api23Impl() {
            }

            @RequiresApi(23)
            static void setBigLargeIcon(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        @RequiresApi(31)
        private static class Api31Impl {
            private Api31Impl() {
            }

            @RequiresApi(31)
            static void setBigPicture(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            @RequiresApi(31)
            static void setContentDescription(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            @RequiresApi(31)
            static void showBigPictureWhenCollapsed(Notification.BigPictureStyle bigPictureStyle, boolean z4) {
                bigPictureStyle.showBigPictureWhenCollapsed(z4);
            }
        }

        public BigPictureStyle() {
        }

        @Nullable
        private static IconCompat asIconCompat(@Nullable Parcelable parcelable) {
            if (parcelable == null) {
                return null;
            }
            if (parcelable instanceof Icon) {
                return IconCompat.createFromIcon((Icon) parcelable);
            }
            if (parcelable instanceof Bitmap) {
                return IconCompat.createWithBitmap((Bitmap) parcelable);
            }
            return null;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static IconCompat getPictureIcon(@Nullable Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            Parcelable parcelable = bundle.getParcelable(NotificationCompat.EXTRA_PICTURE);
            if (parcelable != null) {
                return asIconCompat(parcelable);
            }
            return asIconCompat(bundle.getParcelable(NotificationCompat.EXTRA_PICTURE_ICON));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Context context;
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            IconCompat iconCompat = this.mPictureIcon;
            Context context2 = null;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    if (notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder) {
                        context = ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).getContext();
                    } else {
                        context = null;
                    }
                    Api31Impl.setBigPicture(bigContentTitle, this.mPictureIcon.toIcon(context));
                } else if (iconCompat.getType() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.mPictureIcon.getBitmap());
                }
            }
            if (this.mBigLargeIconSet) {
                if (this.mBigLargeIcon == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    if (notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder) {
                        context2 = ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).getContext();
                    }
                    Api23Impl.setBigLargeIcon(bigContentTitle, this.mBigLargeIcon.toIcon(context2));
                }
            }
            if (this.mSummaryTextSet) {
                bigContentTitle.setSummaryText(this.mSummaryText);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                Api31Impl.showBigPictureWhenCollapsed(bigContentTitle, this.mShowBigPictureWhenCollapsed);
                Api31Impl.setContentDescription(bigContentTitle, this.mPictureContentDescription);
            }
        }

        @NonNull
        public BigPictureStyle bigLargeIcon(@Nullable Bitmap bitmap) {
            this.mBigLargeIcon = bitmap == null ? null : IconCompat.createWithBitmap(bitmap);
            this.mBigLargeIconSet = true;
            return this;
        }

        @NonNull
        public BigPictureStyle bigPicture(@Nullable Bitmap bitmap) {
            this.mPictureIcon = bitmap == null ? null : IconCompat.createWithBitmap(bitmap);
            return this;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_LARGE_ICON_BIG);
            bundle.remove(NotificationCompat.EXTRA_PICTURE);
            bundle.remove(NotificationCompat.EXTRA_PICTURE_ICON);
            bundle.remove(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            if (bundle.containsKey(NotificationCompat.EXTRA_LARGE_ICON_BIG)) {
                this.mBigLargeIcon = asIconCompat(bundle.getParcelable(NotificationCompat.EXTRA_LARGE_ICON_BIG));
                this.mBigLargeIconSet = true;
            }
            this.mPictureIcon = getPictureIcon(bundle);
            this.mShowBigPictureWhenCollapsed = bundle.getBoolean(NotificationCompat.EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED);
        }

        @NonNull
        public BigPictureStyle setBigContentTitle(@Nullable CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @RequiresApi(31)
        @NonNull
        public BigPictureStyle setContentDescription(@Nullable CharSequence charSequence) {
            this.mPictureContentDescription = charSequence;
            return this;
        }

        @NonNull
        public BigPictureStyle setSummaryText(@Nullable CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }

        @RequiresApi(31)
        @NonNull
        public BigPictureStyle showBigPictureWhenCollapsed(boolean z4) {
            this.mShowBigPictureWhenCollapsed = z4;
            return this;
        }

        public BigPictureStyle(@Nullable Builder builder) {
            setBuilder(builder);
        }

        @RequiresApi(31)
        @NonNull
        public BigPictureStyle bigPicture(@Nullable Icon icon) {
            this.mPictureIcon = IconCompat.createFromIcon(icon);
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public BigPictureStyle bigLargeIcon(@Nullable Icon icon) {
            this.mBigLargeIcon = icon == null ? null : IconCompat.createFromIcon(icon);
            this.mBigLargeIconSet = true;
            return this;
        }
    }

    public static class BigTextStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
        private CharSequence mBigText;

        public BigTextStyle() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle bundle) {
            super.addCompatExtras(bundle);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
            if (this.mSummaryTextSet) {
                bigText.setSummaryText(this.mSummaryText);
            }
        }

        @NonNull
        public BigTextStyle bigText(@Nullable CharSequence charSequence) {
            this.mBigText = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_BIG_TEXT);
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.mBigText = bundle.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        }

        @NonNull
        public BigTextStyle setBigContentTitle(@Nullable CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public BigTextStyle setSummaryText(@Nullable CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }

        public BigTextStyle(@Nullable Builder builder) {
            setBuilder(builder);
        }
    }

    public static final class BubbleMetadata {
        private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
        private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
        private PendingIntent mDeleteIntent;
        private int mDesiredHeight;
        @DimenRes
        private int mDesiredHeightResId;
        private int mFlags;
        private IconCompat mIcon;
        private PendingIntent mPendingIntent;
        private String mShortcutId;

        @RequiresApi(29)
        private static class Api29Impl {
            private Api29Impl() {
            }

            @RequiresApi(29)
            @Nullable
            static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                Builder suppressNotification = new Builder(bubbleMetadata.getIntent(), IconCompat.createFromIcon(bubbleMetadata.getIcon())).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return suppressNotification.build();
            }

            @RequiresApi(29)
            @Nullable
            static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(bubbleMetadata.getIcon().toIcon()).setIntent(bubbleMetadata.getIntent()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    suppressNotification.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    suppressNotification.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return suppressNotification.build();
            }
        }

        @RequiresApi(30)
        private static class Api30Impl {
            private Api30Impl() {
            }

            @RequiresApi(30)
            @Nullable
            static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata bubbleMetadata) {
                Builder builder;
                if (bubbleMetadata == null) {
                    return null;
                }
                if (bubbleMetadata.getShortcutId() != null) {
                    builder = new Builder(bubbleMetadata.getShortcutId());
                } else {
                    builder = new Builder(bubbleMetadata.getIntent(), IconCompat.createFromIcon(bubbleMetadata.getIcon()));
                }
                builder.setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setDeleteIntent(bubbleMetadata.getDeleteIntent()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return builder.build();
            }

            @RequiresApi(30)
            @Nullable
            static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata bubbleMetadata) {
                Notification.BubbleMetadata.Builder builder;
                if (bubbleMetadata == null) {
                    return null;
                }
                if (bubbleMetadata.getShortcutId() != null) {
                    builder = new Notification.BubbleMetadata.Builder(bubbleMetadata.getShortcutId());
                } else {
                    builder = new Notification.BubbleMetadata.Builder(bubbleMetadata.getIntent(), bubbleMetadata.getIcon().toIcon());
                }
                builder.setDeleteIntent(bubbleMetadata.getDeleteIntent()).setAutoExpandBubble(bubbleMetadata.getAutoExpandBubble()).setSuppressNotification(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    builder.setDesiredHeight(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    builder.setDesiredHeightResId(bubbleMetadata.getDesiredHeightResId());
                }
                return builder.build();
            }
        }

        public static final class Builder {
            private PendingIntent mDeleteIntent;
            private int mDesiredHeight;
            @DimenRes
            private int mDesiredHeightResId;
            private int mFlags;
            private IconCompat mIcon;
            private PendingIntent mPendingIntent;
            private String mShortcutId;

            @Deprecated
            public Builder() {
            }

            @NonNull
            private Builder setFlag(int i5, boolean z4) {
                if (z4) {
                    this.mFlags = i5 | this.mFlags;
                    return this;
                }
                this.mFlags = (~i5) & this.mFlags;
                return this;
            }

            @NonNull
            public BubbleMetadata build() {
                String str = this.mShortcutId;
                if (str == null && this.mPendingIntent == null) {
                    throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                } else if (str == null && this.mIcon == null) {
                    throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                } else {
                    BubbleMetadata bubbleMetadata = new BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, str);
                    bubbleMetadata.setFlags(this.mFlags);
                    return bubbleMetadata;
                }
            }

            @NonNull
            public Builder setAutoExpandBubble(boolean z4) {
                setFlag(1, z4);
                return this;
            }

            @NonNull
            public Builder setDeleteIntent(@Nullable PendingIntent pendingIntent) {
                this.mDeleteIntent = pendingIntent;
                return this;
            }

            @NonNull
            public Builder setDesiredHeight(@Dimension(unit = 0) int i5) {
                this.mDesiredHeight = Math.max(i5, 0);
                this.mDesiredHeightResId = 0;
                return this;
            }

            @NonNull
            public Builder setDesiredHeightResId(@DimenRes int i5) {
                this.mDesiredHeightResId = i5;
                this.mDesiredHeight = 0;
                return this;
            }

            @NonNull
            public Builder setIcon(@NonNull IconCompat iconCompat) {
                if (this.mShortcutId != null) {
                    throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                } else if (iconCompat != null) {
                    this.mIcon = iconCompat;
                    return this;
                } else {
                    throw new NullPointerException("Bubbles require non-null icon");
                }
            }

            @NonNull
            public Builder setIntent(@NonNull PendingIntent pendingIntent) {
                if (this.mShortcutId != null) {
                    throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
                } else if (pendingIntent != null) {
                    this.mPendingIntent = pendingIntent;
                    return this;
                } else {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
            }

            @NonNull
            public Builder setSuppressNotification(boolean z4) {
                setFlag(2, z4);
                return this;
            }

            @RequiresApi(30)
            public Builder(@NonNull String str) {
                if (!TextUtils.isEmpty(str)) {
                    this.mShortcutId = str;
                    return;
                }
                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }

            public Builder(@NonNull PendingIntent pendingIntent, @NonNull IconCompat iconCompat) {
                if (pendingIntent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                } else if (iconCompat != null) {
                    this.mPendingIntent = pendingIntent;
                    this.mIcon = iconCompat;
                } else {
                    throw new NullPointerException("Bubbles require non-null icon");
                }
            }
        }

        @Nullable
        public static BubbleMetadata fromPlatform(@Nullable Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 30) {
                return Api30Impl.fromPlatform(bubbleMetadata);
            }
            if (i5 == 29) {
                return Api29Impl.fromPlatform(bubbleMetadata);
            }
            return null;
        }

        @Nullable
        public static Notification.BubbleMetadata toPlatform(@Nullable BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 30) {
                return Api30Impl.toPlatform(bubbleMetadata);
            }
            if (i5 == 29) {
                return Api29Impl.toPlatform(bubbleMetadata);
            }
            return null;
        }

        public boolean getAutoExpandBubble() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            return false;
        }

        @Nullable
        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        @Dimension(unit = 0)
        public int getDesiredHeight() {
            return this.mDesiredHeight;
        }

        @DimenRes
        public int getDesiredHeightResId() {
            return this.mDesiredHeightResId;
        }

        @SuppressLint({"InvalidNullConversion"})
        @Nullable
        public IconCompat getIcon() {
            return this.mIcon;
        }

        @SuppressLint({"InvalidNullConversion"})
        @Nullable
        public PendingIntent getIntent() {
            return this.mPendingIntent;
        }

        @Nullable
        public String getShortcutId() {
            return this.mShortcutId;
        }

        public boolean isNotificationSuppressed() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void setFlags(int i5) {
            this.mFlags = i5;
        }

        private BubbleMetadata(@Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable IconCompat iconCompat, int i5, @DimenRes int i6, int i7, @Nullable String str) {
            this.mPendingIntent = pendingIntent;
            this.mIcon = iconCompat;
            this.mDesiredHeight = i5;
            this.mDesiredHeightResId = i6;
            this.mDeleteIntent = pendingIntent2;
            this.mFlags = i7;
            this.mShortcutId = str;
        }
    }

    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Action> mActions;
        boolean mAllowSystemGeneratedContextualActions;
        int mBadgeIcon;
        RemoteViews mBigContentView;
        BubbleMetadata mBubbleMetadata;
        String mCategory;
        String mChannelId;
        boolean mChronometerCountDown;
        int mColor;
        boolean mColorized;
        boolean mColorizedSet;
        CharSequence mContentInfo;
        PendingIntent mContentIntent;
        CharSequence mContentText;
        CharSequence mContentTitle;
        RemoteViews mContentView;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Context mContext;
        Bundle mExtras;
        int mFgsDeferBehavior;
        PendingIntent mFullScreenIntent;
        int mGroupAlertBehavior;
        String mGroupKey;
        boolean mGroupSummary;
        RemoteViews mHeadsUpContentView;
        ArrayList<Action> mInvisibleActions;
        IconCompat mLargeIcon;
        boolean mLocalOnly;
        LocusIdCompat mLocusId;
        Notification mNotification;
        int mNumber;
        @Deprecated
        public ArrayList<String> mPeople;
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ArrayList<Person> mPersonList;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        CharSequence[] mRemoteInputHistory;
        CharSequence mSettingsText;
        String mShortcutId;
        boolean mShowWhen;
        boolean mSilent;
        Object mSmallIcon;
        String mSortKey;
        Style mStyle;
        CharSequence mSubText;
        RemoteViews mTickerView;
        long mTimeout;
        boolean mUseChronometer;
        int mVisibility;

        @RequiresApi(21)
        static class Api21Impl {
            private Api21Impl() {
            }

            @DoNotInline
            static AudioAttributes build(AudioAttributes.Builder builder) {
                return builder.build();
            }

            @DoNotInline
            static AudioAttributes.Builder createBuilder() {
                return new AudioAttributes.Builder();
            }

            @DoNotInline
            static AudioAttributes.Builder setContentType(AudioAttributes.Builder builder, int i5) {
                return builder.setContentType(i5);
            }

            @DoNotInline
            static AudioAttributes.Builder setLegacyStreamType(AudioAttributes.Builder builder, int i5) {
                return builder.setLegacyStreamType(i5);
            }

            @DoNotInline
            static AudioAttributes.Builder setUsage(AudioAttributes.Builder builder, int i5) {
                return builder.setUsage(i5);
            }
        }

        @RequiresApi(23)
        static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            static Icon getLargeIcon(Notification notification) {
                return notification.getLargeIcon();
            }

            @DoNotInline
            static Icon getSmallIcon(Notification notification) {
                return notification.getSmallIcon();
            }
        }

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static RemoteViews createBigContentView(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }

            @DoNotInline
            static RemoteViews createContentView(Notification.Builder builder) {
                return builder.createContentView();
            }

            @DoNotInline
            static RemoteViews createHeadsUpContentView(Notification.Builder builder) {
                return builder.createHeadsUpContentView();
            }

            @DoNotInline
            static Notification.Builder recoverBuilder(Context context, Notification notification) {
                return Notification.Builder.recoverBuilder(context, notification);
            }
        }

        public Builder(@NonNull Context context, @NonNull Notification notification) {
            this(context, NotificationCompat.getChannelId(notification));
            ArrayList parcelableArrayList;
            Bundle bundle = notification.extras;
            Style extractStyleFromNotification = Style.extractStyleFromNotification(notification);
            setContentTitle(NotificationCompat.getContentTitle(notification)).setContentText(NotificationCompat.getContentText(notification)).setContentInfo(NotificationCompat.getContentInfo(notification)).setSubText(NotificationCompat.getSubText(notification)).setSettingsText(NotificationCompat.getSettingsText(notification)).setStyle(extractStyleFromNotification).setGroup(NotificationCompat.getGroup(notification)).setGroupSummary(NotificationCompat.isGroupSummary(notification)).setLocusId(NotificationCompat.getLocusId(notification)).setWhen(notification.when).setShowWhen(NotificationCompat.getShowWhen(notification)).setUsesChronometer(NotificationCompat.getUsesChronometer(notification)).setAutoCancel(NotificationCompat.getAutoCancel(notification)).setOnlyAlertOnce(NotificationCompat.getOnlyAlertOnce(notification)).setOngoing(NotificationCompat.getOngoing(notification)).setLocalOnly(NotificationCompat.getLocalOnly(notification)).setLargeIcon(notification.largeIcon).setBadgeIconType(NotificationCompat.getBadgeIconType(notification)).setCategory(NotificationCompat.getCategory(notification)).setBubbleMetadata(NotificationCompat.getBubbleMetadata(notification)).setNumber(notification.number).setTicker(notification.tickerText).setContentIntent(notification.contentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(notification.fullScreenIntent, NotificationCompat.getHighPriority(notification)).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setDefaults(notification.defaults).setPriority(notification.priority).setColor(NotificationCompat.getColor(notification)).setVisibility(NotificationCompat.getVisibility(notification)).setPublicVersion(NotificationCompat.getPublicVersion(notification)).setSortKey(NotificationCompat.getSortKey(notification)).setTimeoutAfter(NotificationCompat.getTimeoutAfter(notification)).setShortcutId(NotificationCompat.getShortcutId(notification)).setProgress(bundle.getInt(NotificationCompat.EXTRA_PROGRESS_MAX), bundle.getInt(NotificationCompat.EXTRA_PROGRESS), bundle.getBoolean(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE)).setAllowSystemGeneratedContextualActions(NotificationCompat.getAllowSystemGeneratedContextualActions(notification)).setSmallIcon(notification.icon, notification.iconLevel).addExtras(getExtrasWithoutDuplicateData(notification, extractStyleFromNotification));
            this.mSmallIcon = Api23Impl.getSmallIcon(notification);
            Icon largeIcon = Api23Impl.getLargeIcon(notification);
            if (largeIcon != null) {
                this.mLargeIcon = IconCompat.createFromIcon(largeIcon);
            }
            Notification.Action[] actionArr = notification.actions;
            int i5 = 0;
            if (!(actionArr == null || actionArr.length == 0)) {
                for (Notification.Action fromAndroidAction : actionArr) {
                    addAction(Action.Builder.fromAndroidAction(fromAndroidAction).build());
                }
            }
            List<Action> invisibleActions = NotificationCompat.getInvisibleActions(notification);
            if (!invisibleActions.isEmpty()) {
                for (Action addInvisibleAction : invisibleActions) {
                    addInvisibleAction(addInvisibleAction);
                }
            }
            String[] stringArray = notification.extras.getStringArray(NotificationCompat.EXTRA_PEOPLE);
            if (!(stringArray == null || stringArray.length == 0)) {
                for (String addPerson : stringArray) {
                    addPerson(addPerson);
                }
            }
            if (Build.VERSION.SDK_INT >= 28 && (parcelableArrayList = notification.extras.getParcelableArrayList(NotificationCompat.EXTRA_PEOPLE_LIST)) != null && !parcelableArrayList.isEmpty()) {
                int size = parcelableArrayList.size();
                while (i5 < size) {
                    Object obj = parcelableArrayList.get(i5);
                    i5++;
                    addPerson(Person.fromAndroidPerson(j.a(obj)));
                }
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 24 && bundle.containsKey(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN)) {
                setChronometerCountDown(bundle.getBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN));
            }
            if (i6 >= 26 && bundle.containsKey(NotificationCompat.EXTRA_COLORIZED)) {
                setColorized(bundle.getBoolean(NotificationCompat.EXTRA_COLORIZED));
            }
        }

        @Nullable
        private static Bundle getExtrasWithoutDuplicateData(@NonNull Notification notification, @Nullable Style style) {
            if (notification.extras == null) {
                return null;
            }
            Bundle bundle = new Bundle(notification.extras);
            bundle.remove(NotificationCompat.EXTRA_TITLE);
            bundle.remove(NotificationCompat.EXTRA_TEXT);
            bundle.remove(NotificationCompat.EXTRA_INFO_TEXT);
            bundle.remove(NotificationCompat.EXTRA_SUB_TEXT);
            bundle.remove(NotificationCompat.EXTRA_CHANNEL_ID);
            bundle.remove(NotificationCompat.EXTRA_CHANNEL_GROUP_ID);
            bundle.remove(NotificationCompat.EXTRA_SHOW_WHEN);
            bundle.remove(NotificationCompat.EXTRA_PROGRESS);
            bundle.remove(NotificationCompat.EXTRA_PROGRESS_MAX);
            bundle.remove(NotificationCompat.EXTRA_PROGRESS_INDETERMINATE);
            bundle.remove(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN);
            bundle.remove(NotificationCompat.EXTRA_COLORIZED);
            bundle.remove(NotificationCompat.EXTRA_PEOPLE_LIST);
            bundle.remove(NotificationCompat.EXTRA_PEOPLE);
            bundle.remove(NotificationCompatExtras.EXTRA_SORT_KEY);
            bundle.remove(NotificationCompatExtras.EXTRA_GROUP_KEY);
            bundle.remove(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
            bundle.remove(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
            bundle.remove(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
            Bundle bundle2 = bundle.getBundle("android.car.EXTENSIONS");
            if (bundle2 != null) {
                Bundle bundle3 = new Bundle(bundle2);
                bundle3.remove("invisible_actions");
                bundle.putBundle("android.car.EXTENSIONS", bundle3);
            }
            if (style != null) {
                style.clearCompatExtraKeys(bundle);
            }
            return bundle;
        }

        @Nullable
        protected static CharSequence limitCharSequenceLength(@Nullable CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > MAX_CHARSEQUENCE_LENGTH) {
                return charSequence.subSequence(0, MAX_CHARSEQUENCE_LENGTH);
            }
            return charSequence;
        }

        private void setFlag(int i5, boolean z4) {
            if (z4) {
                Notification notification = this.mNotification;
                notification.flags = i5 | notification.flags;
                return;
            }
            Notification notification2 = this.mNotification;
            notification2.flags = (~i5) & notification2.flags;
        }

        private boolean useExistingRemoteView() {
            Style style = this.mStyle;
            if (style == null || !style.displayCustomViewInline()) {
                return true;
            }
            return false;
        }

        @NonNull
        public Builder addAction(int i5, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this.mActions.add(new Action(i5, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        public Builder addExtras(@Nullable Bundle bundle) {
            if (bundle != null) {
                Bundle bundle2 = this.mExtras;
                if (bundle2 == null) {
                    this.mExtras = new Bundle(bundle);
                    return this;
                }
                bundle2.putAll(bundle);
            }
            return this;
        }

        @RequiresApi(21)
        @NonNull
        public Builder addInvisibleAction(int i5, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this.mInvisibleActions.add(new Action(i5, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        @Deprecated
        public Builder addPerson(@Nullable String str) {
            if (str != null && !str.isEmpty()) {
                this.mPeople.add(str);
            }
            return this;
        }

        @NonNull
        public Notification build() {
            return new NotificationCompatBuilder(this).build();
        }

        @NonNull
        public Builder clearActions() {
            this.mActions.clear();
            return this;
        }

        @NonNull
        public Builder clearInvisibleActions() {
            this.mInvisibleActions.clear();
            Bundle bundle = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (bundle != null) {
                Bundle bundle2 = new Bundle(bundle);
                bundle2.remove("invisible_actions");
                this.mExtras.putBundle("android.car.EXTENSIONS", bundle2);
            }
            return this;
        }

        @NonNull
        public Builder clearPeople() {
            this.mPersonList.clear();
            this.mPeople.clear();
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @Nullable
        public RemoteViews createBigContentView() {
            RemoteViews makeBigContentView;
            if (this.mBigContentView != null && useExistingRemoteView()) {
                return this.mBigContentView;
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            Style style = this.mStyle;
            if (style != null && (makeBigContentView = style.makeBigContentView(notificationCompatBuilder)) != null) {
                return makeBigContentView;
            }
            Notification build = notificationCompatBuilder.build();
            if (Build.VERSION.SDK_INT >= 24) {
                return Api24Impl.createBigContentView(Api24Impl.recoverBuilder(this.mContext, build));
            }
            return build.bigContentView;
        }

        @SuppressLint({"BuilderSetStyle"})
        @Nullable
        public RemoteViews createContentView() {
            RemoteViews makeContentView;
            if (this.mContentView != null && useExistingRemoteView()) {
                return this.mContentView;
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            Style style = this.mStyle;
            if (style != null && (makeContentView = style.makeContentView(notificationCompatBuilder)) != null) {
                return makeContentView;
            }
            Notification build = notificationCompatBuilder.build();
            if (Build.VERSION.SDK_INT >= 24) {
                return Api24Impl.createContentView(Api24Impl.recoverBuilder(this.mContext, build));
            }
            return build.contentView;
        }

        @SuppressLint({"BuilderSetStyle"})
        @Nullable
        public RemoteViews createHeadsUpContentView() {
            RemoteViews makeHeadsUpContentView;
            int i5 = Build.VERSION.SDK_INT;
            if (this.mHeadsUpContentView != null && useExistingRemoteView()) {
                return this.mHeadsUpContentView;
            }
            NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
            Style style = this.mStyle;
            if (style != null && (makeHeadsUpContentView = style.makeHeadsUpContentView(notificationCompatBuilder)) != null) {
                return makeHeadsUpContentView;
            }
            Notification build = notificationCompatBuilder.build();
            if (i5 >= 24) {
                return Api24Impl.createHeadsUpContentView(Api24Impl.recoverBuilder(this.mContext, build));
            }
            return build.headsUpContentView;
        }

        @NonNull
        public Builder extend(@NonNull Extender extender) {
            extender.extend(this);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getBigContentView() {
            return this.mBigContentView;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public BubbleMetadata getBubbleMetadata() {
            return this.mBubbleMetadata;
        }

        @ColorInt
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getColor() {
            return this.mColor;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getContentView() {
            return this.mContentView;
        }

        @NonNull
        public Bundle getExtras() {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            return this.mExtras;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getForegroundServiceBehavior() {
            return this.mFgsDeferBehavior;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews getHeadsUpContentView() {
            return this.mHeadsUpContentView;
        }

        @NonNull
        @Deprecated
        public Notification getNotification() {
            return build();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public int getPriority() {
            return this.mPriority;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public long getWhenIfShowing() {
            if (this.mShowWhen) {
                return this.mNotification.when;
            }
            return 0;
        }

        @NonNull
        public Builder setAllowSystemGeneratedContextualActions(boolean z4) {
            this.mAllowSystemGeneratedContextualActions = z4;
            return this;
        }

        @NonNull
        public Builder setAutoCancel(boolean z4) {
            setFlag(16, z4);
            return this;
        }

        @NonNull
        public Builder setBadgeIconType(int i5) {
            this.mBadgeIcon = i5;
            return this;
        }

        @NonNull
        public Builder setBubbleMetadata(@Nullable BubbleMetadata bubbleMetadata) {
            this.mBubbleMetadata = bubbleMetadata;
            return this;
        }

        @NonNull
        public Builder setCategory(@Nullable String str) {
            this.mCategory = str;
            return this;
        }

        @NonNull
        public Builder setChannelId(@NonNull String str) {
            this.mChannelId = str;
            return this;
        }

        @RequiresApi(24)
        @NonNull
        public Builder setChronometerCountDown(boolean z4) {
            this.mChronometerCountDown = z4;
            getExtras().putBoolean(NotificationCompat.EXTRA_CHRONOMETER_COUNT_DOWN, z4);
            return this;
        }

        @NonNull
        public Builder setColor(@ColorInt int i5) {
            this.mColor = i5;
            return this;
        }

        @NonNull
        public Builder setColorized(boolean z4) {
            this.mColorized = z4;
            this.mColorizedSet = true;
            return this;
        }

        @NonNull
        public Builder setContent(@Nullable RemoteViews remoteViews) {
            this.mNotification.contentView = remoteViews;
            return this;
        }

        @NonNull
        public Builder setContentInfo(@Nullable CharSequence charSequence) {
            this.mContentInfo = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setContentIntent(@Nullable PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        @NonNull
        public Builder setContentText(@Nullable CharSequence charSequence) {
            this.mContentText = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setContentTitle(@Nullable CharSequence charSequence) {
            this.mContentTitle = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setCustomBigContentView(@Nullable RemoteViews remoteViews) {
            this.mBigContentView = remoteViews;
            return this;
        }

        @NonNull
        public Builder setCustomContentView(@Nullable RemoteViews remoteViews) {
            this.mContentView = remoteViews;
            return this;
        }

        @NonNull
        public Builder setCustomHeadsUpContentView(@Nullable RemoteViews remoteViews) {
            this.mHeadsUpContentView = remoteViews;
            return this;
        }

        @NonNull
        public Builder setDefaults(int i5) {
            Notification notification = this.mNotification;
            notification.defaults = i5;
            if ((i5 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @NonNull
        public Builder setDeleteIntent(@Nullable PendingIntent pendingIntent) {
            this.mNotification.deleteIntent = pendingIntent;
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        @NonNull
        public Builder setForegroundServiceBehavior(int i5) {
            this.mFgsDeferBehavior = i5;
            return this;
        }

        @NonNull
        public Builder setFullScreenIntent(@Nullable PendingIntent pendingIntent, boolean z4) {
            this.mFullScreenIntent = pendingIntent;
            setFlag(128, z4);
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String str) {
            this.mGroupKey = str;
            return this;
        }

        @NonNull
        public Builder setGroupAlertBehavior(int i5) {
            this.mGroupAlertBehavior = i5;
            return this;
        }

        @NonNull
        public Builder setGroupSummary(boolean z4) {
            this.mGroupSummary = z4;
            return this;
        }

        @NonNull
        public Builder setLargeIcon(@Nullable Bitmap bitmap) {
            IconCompat iconCompat;
            if (bitmap == null) {
                iconCompat = null;
            } else {
                iconCompat = IconCompat.createWithBitmap(NotificationCompat.reduceLargeIconSize(this.mContext, bitmap));
            }
            this.mLargeIcon = iconCompat;
            return this;
        }

        @NonNull
        public Builder setLights(@ColorInt int i5, int i6, int i7) {
            int i8;
            Notification notification = this.mNotification;
            notification.ledARGB = i5;
            notification.ledOnMS = i6;
            notification.ledOffMS = i7;
            if (i6 == 0 || i7 == 0) {
                i8 = 0;
            } else {
                i8 = 1;
            }
            notification.flags = i8 | (notification.flags & -2);
            return this;
        }

        @NonNull
        public Builder setLocalOnly(boolean z4) {
            this.mLocalOnly = z4;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat locusIdCompat) {
            this.mLocusId = locusIdCompat;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setNotificationSilent() {
            this.mSilent = true;
            return this;
        }

        @NonNull
        public Builder setNumber(int i5) {
            this.mNumber = i5;
            return this;
        }

        @NonNull
        public Builder setOngoing(boolean z4) {
            setFlag(2, z4);
            return this;
        }

        @NonNull
        public Builder setOnlyAlertOnce(boolean z4) {
            setFlag(8, z4);
            return this;
        }

        @NonNull
        public Builder setPriority(int i5) {
            this.mPriority = i5;
            return this;
        }

        @NonNull
        public Builder setProgress(int i5, int i6, boolean z4) {
            this.mProgressMax = i5;
            this.mProgress = i6;
            this.mProgressIndeterminate = z4;
            return this;
        }

        @NonNull
        public Builder setPublicVersion(@Nullable Notification notification) {
            this.mPublicVersion = notification;
            return this;
        }

        @NonNull
        public Builder setRemoteInputHistory(@Nullable CharSequence[] charSequenceArr) {
            this.mRemoteInputHistory = charSequenceArr;
            return this;
        }

        @NonNull
        public Builder setSettingsText(@Nullable CharSequence charSequence) {
            this.mSettingsText = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setShortcutId(@Nullable String str) {
            this.mShortcutId = str;
            return this;
        }

        @NonNull
        public Builder setShortcutInfo(@Nullable ShortcutInfoCompat shortcutInfoCompat) {
            if (shortcutInfoCompat != null) {
                this.mShortcutId = shortcutInfoCompat.getId();
                if (this.mLocusId == null) {
                    if (shortcutInfoCompat.getLocusId() != null) {
                        this.mLocusId = shortcutInfoCompat.getLocusId();
                    } else if (shortcutInfoCompat.getId() != null) {
                        this.mLocusId = new LocusIdCompat(shortcutInfoCompat.getId());
                    }
                }
                if (this.mContentTitle == null) {
                    setContentTitle(shortcutInfoCompat.getShortLabel());
                }
            }
            return this;
        }

        @NonNull
        public Builder setShowWhen(boolean z4) {
            this.mShowWhen = z4;
            return this;
        }

        @NonNull
        public Builder setSilent(boolean z4) {
            this.mSilent = z4;
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public Builder setSmallIcon(@NonNull IconCompat iconCompat) {
            this.mSmallIcon = iconCompat.toIcon(this.mContext);
            return this;
        }

        @NonNull
        public Builder setSortKey(@Nullable String str) {
            this.mSortKey = str;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri) {
            Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder usage = Api21Impl.setUsage(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), 5);
            this.mNotification.audioAttributes = Api21Impl.build(usage);
            return this;
        }

        @NonNull
        public Builder setStyle(@Nullable Style style) {
            if (this.mStyle != style) {
                this.mStyle = style;
                if (style != null) {
                    style.setBuilder(this);
                }
            }
            return this;
        }

        @NonNull
        public Builder setSubText(@Nullable CharSequence charSequence) {
            this.mSubText = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setTicker(@Nullable CharSequence charSequence) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public Builder setTimeoutAfter(long j5) {
            this.mTimeout = j5;
            return this;
        }

        @NonNull
        public Builder setUsesChronometer(boolean z4) {
            this.mUseChronometer = z4;
            return this;
        }

        @NonNull
        public Builder setVibrate(@Nullable long[] jArr) {
            this.mNotification.vibrate = jArr;
            return this;
        }

        @NonNull
        public Builder setVisibility(int i5) {
            this.mVisibility = i5;
            return this;
        }

        @NonNull
        public Builder setWhen(long j5) {
            this.mNotification.when = j5;
            return this;
        }

        @NonNull
        public Builder addAction(@Nullable Action action) {
            if (action != null) {
                this.mActions.add(action);
            }
            return this;
        }

        @RequiresApi(21)
        @NonNull
        public Builder addInvisibleAction(@Nullable Action action) {
            if (action != null) {
                this.mInvisibleActions.add(action);
            }
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int i5) {
            this.mNotification.icon = i5;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTicker(@Nullable CharSequence charSequence, @Nullable RemoteViews remoteViews) {
            this.mNotification.tickerText = limitCharSequenceLength(charSequence);
            this.mTickerView = remoteViews;
            return this;
        }

        @NonNull
        public Builder addPerson(@Nullable Person person) {
            if (person != null) {
                this.mPersonList.add(person);
            }
            return this;
        }

        @NonNull
        public Builder setSmallIcon(int i5, int i6) {
            Notification notification = this.mNotification;
            notification.icon = i5;
            notification.iconLevel = i6;
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public Builder setLargeIcon(@Nullable Icon icon) {
            this.mLargeIcon = icon == null ? null : IconCompat.createFromIcon(icon);
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri, int i5) {
            Notification notification = this.mNotification;
            notification.sound = uri;
            notification.audioStreamType = i5;
            AudioAttributes.Builder legacyStreamType = Api21Impl.setLegacyStreamType(Api21Impl.setContentType(Api21Impl.createBuilder(), 4), i5);
            this.mNotification.audioAttributes = Api21Impl.build(legacyStreamType);
            return this;
        }

        public Builder(@NonNull Context context, @NonNull String str) {
            this.mActions = new ArrayList<>();
            this.mPersonList = new ArrayList<>();
            this.mInvisibleActions = new ArrayList<>();
            this.mShowWhen = true;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            this.mBadgeIcon = 0;
            this.mGroupAlertBehavior = 0;
            this.mFgsDeferBehavior = 0;
            Notification notification = new Notification();
            this.mNotification = notification;
            this.mContext = context;
            this.mChannelId = str;
            notification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            this.mPeople = new ArrayList<>();
            this.mAllowSystemGeneratedContextualActions = true;
        }

        @Deprecated
        public Builder(@NonNull Context context) {
            this(context, (String) null);
        }
    }

    public static class CallStyle extends Style {
        public static final int CALL_TYPE_INCOMING = 1;
        public static final int CALL_TYPE_ONGOING = 2;
        public static final int CALL_TYPE_SCREENING = 3;
        public static final int CALL_TYPE_UNKNOWN = 0;
        private static final String KEY_ACTION_PRIORITY = "key_action_priority";
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$CallStyle";
        private Integer mAnswerButtonColor;
        private PendingIntent mAnswerIntent;
        private int mCallType;
        private Integer mDeclineButtonColor;
        private PendingIntent mDeclineIntent;
        private PendingIntent mHangUpIntent;
        private boolean mIsVideo;
        private Person mPerson;
        private IconCompat mVerificationIcon;
        private CharSequence mVerificationText;

        @RequiresApi(20)
        static class Api20Impl {
            private Api20Impl() {
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
            static Notification.Action.Builder createActionBuilder(int i5, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(i5, charSequence, pendingIntent);
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
        }

        @RequiresApi(23)
        static class Api23Impl {
            private Api23Impl() {
            }

            @DoNotInline
            static Parcelable castToParcelable(Icon icon) {
                return icon;
            }

            @DoNotInline
            static Notification.Action.Builder createActionBuilder(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            @DoNotInline
            static void setLargeIcon(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
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
            static Parcelable castToParcelable(Person person) {
                return person;
            }
        }

        @RequiresApi(31)
        static class Api31Impl {
            private Api31Impl() {
            }

            @DoNotInline
            static Notification.CallStyle forIncomingCall(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            @DoNotInline
            static Notification.CallStyle forOngoingCall(@NonNull Person person, @NonNull PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            @DoNotInline
            static Notification.CallStyle forScreeningCall(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            @DoNotInline
            static Notification.CallStyle setAnswerButtonColorHint(Notification.CallStyle callStyle, @ColorInt int i5) {
                return callStyle.setAnswerButtonColorHint(i5);
            }

            @DoNotInline
            static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean z4) {
                return builder.setAuthenticationRequired(z4);
            }

            @DoNotInline
            static Notification.CallStyle setDeclineButtonColorHint(Notification.CallStyle callStyle, @ColorInt int i5) {
                return callStyle.setDeclineButtonColorHint(i5);
            }

            @DoNotInline
            static Notification.CallStyle setIsVideo(Notification.CallStyle callStyle, boolean z4) {
                return callStyle.setIsVideo(z4);
            }

            @DoNotInline
            static Notification.CallStyle setVerificationIcon(Notification.CallStyle callStyle, @Nullable Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            @DoNotInline
            static Notification.CallStyle setVerificationText(Notification.CallStyle callStyle, @Nullable CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Retention(RetentionPolicy.SOURCE)
        public @interface CallType {
        }

        public CallStyle() {
        }

        @NonNull
        public static CallStyle forIncomingCall(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
            Objects.requireNonNull(pendingIntent, "declineIntent is required");
            Objects.requireNonNull(pendingIntent2, "answerIntent is required");
            return new CallStyle(1, person, (PendingIntent) null, pendingIntent, pendingIntent2);
        }

        @NonNull
        public static CallStyle forOngoingCall(@NonNull Person person, @NonNull PendingIntent pendingIntent) {
            Objects.requireNonNull(pendingIntent, "hangUpIntent is required");
            return new CallStyle(2, person, pendingIntent, (PendingIntent) null, (PendingIntent) null);
        }

        @NonNull
        public static CallStyle forScreeningCall(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
            Objects.requireNonNull(pendingIntent, "hangUpIntent is required");
            Objects.requireNonNull(pendingIntent2, "answerIntent is required");
            return new CallStyle(3, person, pendingIntent, (PendingIntent) null, pendingIntent2);
        }

        @Nullable
        private String getDefaultText() {
            int i5 = this.mCallType;
            if (i5 == 1) {
                return this.mBuilder.mContext.getResources().getString(R.string.call_notification_incoming_text);
            }
            if (i5 == 2) {
                return this.mBuilder.mContext.getResources().getString(R.string.call_notification_ongoing_text);
            }
            if (i5 != 3) {
                return null;
            }
            return this.mBuilder.mContext.getResources().getString(R.string.call_notification_screening_text);
        }

        private boolean isActionAddedByCallStyle(Action action) {
            if (action == null || !action.getExtras().getBoolean(KEY_ACTION_PRIORITY)) {
                return false;
            }
            return true;
        }

        @RequiresApi(20)
        @NonNull
        private Action makeAction(int i5, int i6, Integer num, int i7, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(ContextCompat.getColor(this.mBuilder.mContext, i7));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(this.mBuilder.mContext.getResources().getString(i6));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            Action build = new Action.Builder(IconCompat.createWithResource(this.mBuilder.mContext, i5), (CharSequence) spannableStringBuilder, pendingIntent).build();
            build.getExtras().putBoolean(KEY_ACTION_PRIORITY, true);
            return build;
        }

        @RequiresApi(20)
        @Nullable
        private Action makeAnswerAction() {
            int i5;
            int i6;
            int i7 = R.drawable.ic_call_answer_video;
            int i8 = R.drawable.ic_call_answer;
            PendingIntent pendingIntent = this.mAnswerIntent;
            if (pendingIntent == null) {
                return null;
            }
            boolean z4 = this.mIsVideo;
            if (z4) {
                i5 = i7;
            } else {
                i5 = i8;
            }
            if (z4) {
                i6 = R.string.call_notification_answer_video_action;
            } else {
                i6 = R.string.call_notification_answer_action;
            }
            return makeAction(i5, i6, this.mAnswerButtonColor, R.color.call_notification_answer_color, pendingIntent);
        }

        @RequiresApi(20)
        @NonNull
        private Action makeNegativeAction() {
            int i5 = R.drawable.ic_call_decline;
            PendingIntent pendingIntent = this.mDeclineIntent;
            if (pendingIntent == null) {
                return makeAction(i5, R.string.call_notification_hang_up_action, this.mDeclineButtonColor, R.color.call_notification_decline_color, this.mHangUpIntent);
            }
            return makeAction(i5, R.string.call_notification_decline_action, this.mDeclineButtonColor, R.color.call_notification_decline_color, pendingIntent);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putInt(NotificationCompat.EXTRA_CALL_TYPE, this.mCallType);
            bundle.putBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO, this.mIsVideo);
            Person person = this.mPerson;
            if (person != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable(NotificationCompat.EXTRA_CALL_PERSON, Api28Impl.castToParcelable(person.toAndroidPerson()));
                } else {
                    bundle.putParcelable(NotificationCompat.EXTRA_CALL_PERSON_COMPAT, person.toBundle());
                }
            }
            IconCompat iconCompat = this.mVerificationIcon;
            if (iconCompat != null) {
                bundle.putParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON, Api23Impl.castToParcelable(iconCompat.toIcon(this.mBuilder.mContext)));
            }
            bundle.putCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT, this.mVerificationText);
            bundle.putParcelable(NotificationCompat.EXTRA_ANSWER_INTENT, this.mAnswerIntent);
            bundle.putParcelable(NotificationCompat.EXTRA_DECLINE_INTENT, this.mDeclineIntent);
            bundle.putParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT, this.mHangUpIntent);
            Integer num = this.mAnswerButtonColor;
            if (num != null) {
                bundle.putInt(NotificationCompat.EXTRA_ANSWER_COLOR, num.intValue());
            }
            Integer num2 = this.mDeclineButtonColor;
            if (num2 != null) {
                bundle.putInt(NotificationCompat.EXTRA_DECLINE_COLOR, num2.intValue());
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            CharSequence charSequence;
            int i5 = Build.VERSION.SDK_INT;
            Notification.CallStyle callStyle = null;
            if (i5 >= 31) {
                int i6 = this.mCallType;
                if (i6 == 1) {
                    callStyle = Api31Impl.forIncomingCall(this.mPerson.toAndroidPerson(), this.mDeclineIntent, this.mAnswerIntent);
                } else if (i6 == 2) {
                    callStyle = Api31Impl.forOngoingCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent);
                } else if (i6 == 3) {
                    callStyle = Api31Impl.forScreeningCall(this.mPerson.toAndroidPerson(), this.mHangUpIntent, this.mAnswerIntent);
                } else if (Log.isLoggable(NotificationCompat.TAG, 3)) {
                    Log.d(NotificationCompat.TAG, "Unrecognized call type in CallStyle: " + String.valueOf(this.mCallType));
                }
                if (callStyle != null) {
                    callStyle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                    Integer num = this.mAnswerButtonColor;
                    if (num != null) {
                        Api31Impl.setAnswerButtonColorHint(callStyle, num.intValue());
                    }
                    Integer num2 = this.mDeclineButtonColor;
                    if (num2 != null) {
                        Api31Impl.setDeclineButtonColorHint(callStyle, num2.intValue());
                    }
                    Api31Impl.setVerificationText(callStyle, this.mVerificationText);
                    IconCompat iconCompat = this.mVerificationIcon;
                    if (iconCompat != null) {
                        Api31Impl.setVerificationIcon(callStyle, iconCompat.toIcon(this.mBuilder.mContext));
                    }
                    Api31Impl.setIsVideo(callStyle, this.mIsVideo);
                    return;
                }
                return;
            }
            Notification.Builder builder = notificationBuilderWithBuilderAccessor.getBuilder();
            Person person = this.mPerson;
            if (person != null) {
                charSequence = person.getName();
            } else {
                charSequence = null;
            }
            builder.setContentTitle(charSequence);
            Bundle bundle = this.mBuilder.mExtras;
            if (bundle != null && bundle.containsKey(NotificationCompat.EXTRA_TEXT)) {
                callStyle = this.mBuilder.mExtras.getCharSequence(NotificationCompat.EXTRA_TEXT);
            }
            if (callStyle == null) {
                callStyle = getDefaultText();
            }
            builder.setContentText(callStyle);
            Person person2 = this.mPerson;
            if (person2 != null) {
                if (person2.getIcon() != null) {
                    Api23Impl.setLargeIcon(builder, this.mPerson.getIcon().toIcon(this.mBuilder.mContext));
                }
                if (i5 >= 28) {
                    Api28Impl.addPerson(builder, this.mPerson.toAndroidPerson());
                } else {
                    Api21Impl.addPerson(builder, this.mPerson.getUri());
                }
            }
            Api21Impl.setCategory(builder, NotificationCompat.CATEGORY_CALL);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return true;
        }

        @RequiresApi(20)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @NonNull
        public ArrayList<Action> getActionsListWithSystemActions() {
            Action makeNegativeAction = makeNegativeAction();
            Action makeAnswerAction = makeAnswerAction();
            ArrayList<Action> arrayList = new ArrayList<>(3);
            arrayList.add(makeNegativeAction);
            ArrayList<Action> arrayList2 = this.mBuilder.mActions;
            int i5 = 2;
            if (arrayList2 != null) {
                int size = arrayList2.size();
                int i6 = 0;
                while (i6 < size) {
                    Action action = arrayList2.get(i6);
                    i6++;
                    Action action2 = action;
                    if (action2.isContextual()) {
                        arrayList.add(action2);
                    } else if (!isActionAddedByCallStyle(action2) && i5 > 1) {
                        arrayList.add(action2);
                        i5--;
                    }
                    if (makeAnswerAction != null && i5 == 1) {
                        arrayList.add(makeAnswerAction);
                        i5--;
                    }
                }
            }
            if (makeAnswerAction != null && i5 >= 1) {
                arrayList.add(makeAnswerAction);
            }
            return arrayList;
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            Integer num;
            super.restoreFromCompatExtras(bundle);
            this.mCallType = bundle.getInt(NotificationCompat.EXTRA_CALL_TYPE);
            this.mIsVideo = bundle.getBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO);
            if (Build.VERSION.SDK_INT >= 28 && bundle.containsKey(NotificationCompat.EXTRA_CALL_PERSON)) {
                this.mPerson = Person.fromAndroidPerson(j.a(bundle.getParcelable(NotificationCompat.EXTRA_CALL_PERSON)));
            } else if (bundle.containsKey(NotificationCompat.EXTRA_CALL_PERSON_COMPAT)) {
                this.mPerson = Person.fromBundle(bundle.getBundle(NotificationCompat.EXTRA_CALL_PERSON_COMPAT));
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON)) {
                this.mVerificationIcon = IconCompat.createFromIcon((Icon) bundle.getParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON));
            } else if (bundle.containsKey(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT)) {
                this.mVerificationIcon = IconCompat.createFromBundle(bundle.getBundle(NotificationCompat.EXTRA_VERIFICATION_ICON_COMPAT));
            }
            this.mVerificationText = bundle.getCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT);
            this.mAnswerIntent = (PendingIntent) bundle.getParcelable(NotificationCompat.EXTRA_ANSWER_INTENT);
            this.mDeclineIntent = (PendingIntent) bundle.getParcelable(NotificationCompat.EXTRA_DECLINE_INTENT);
            this.mHangUpIntent = (PendingIntent) bundle.getParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT);
            Integer num2 = null;
            if (bundle.containsKey(NotificationCompat.EXTRA_ANSWER_COLOR)) {
                num = Integer.valueOf(bundle.getInt(NotificationCompat.EXTRA_ANSWER_COLOR));
            } else {
                num = null;
            }
            this.mAnswerButtonColor = num;
            if (bundle.containsKey(NotificationCompat.EXTRA_DECLINE_COLOR)) {
                num2 = Integer.valueOf(bundle.getInt(NotificationCompat.EXTRA_DECLINE_COLOR));
            }
            this.mDeclineButtonColor = num2;
        }

        @NonNull
        public CallStyle setAnswerButtonColorHint(@ColorInt int i5) {
            this.mAnswerButtonColor = Integer.valueOf(i5);
            return this;
        }

        @NonNull
        public CallStyle setDeclineButtonColorHint(@ColorInt int i5) {
            this.mDeclineButtonColor = Integer.valueOf(i5);
            return this;
        }

        @NonNull
        public CallStyle setIsVideo(boolean z4) {
            this.mIsVideo = z4;
            return this;
        }

        @RequiresApi(23)
        @NonNull
        public CallStyle setVerificationIcon(@Nullable Icon icon) {
            this.mVerificationIcon = icon == null ? null : IconCompat.createFromIcon(icon);
            return this;
        }

        @NonNull
        public CallStyle setVerificationText(@Nullable CharSequence charSequence) {
            this.mVerificationText = charSequence;
            return this;
        }

        public CallStyle(@Nullable Builder builder) {
            setBuilder(builder);
        }

        @NonNull
        public CallStyle setVerificationIcon(@Nullable Bitmap bitmap) {
            this.mVerificationIcon = IconCompat.createWithBitmap(bitmap);
            return this;
        }

        private CallStyle(int i5, @NonNull Person person, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3) {
            if (person == null || TextUtils.isEmpty(person.getName())) {
                throw new IllegalArgumentException("person must have a non-empty a name");
            }
            this.mCallType = i5;
            this.mPerson = person;
            this.mAnswerIntent = pendingIntent3;
            this.mDeclineIntent = pendingIntent2;
            this.mHangUpIntent = pendingIntent;
        }
    }

    public static class DecoratedCustomViewStyle extends Style {
        private static final int MAX_ACTION_BUTTONS = 3;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static Notification.Style createDecoratedCustomViewStyle() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        private RemoteViews createRemoteViews(RemoteViews remoteViews, boolean z4) {
            int min;
            int i5 = 0;
            RemoteViews applyStandardTemplate = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
            applyStandardTemplate.removeAllViews(R.id.actions);
            List<Action> nonContextualActions = getNonContextualActions(this.mBuilder.mActions);
            if (!z4 || nonContextualActions == null || (min = Math.min(nonContextualActions.size(), 3)) <= 0) {
                i5 = 8;
            } else {
                for (int i6 = 0; i6 < min; i6++) {
                    applyStandardTemplate.addView(R.id.actions, generateActionButton(nonContextualActions.get(i6)));
                }
            }
            applyStandardTemplate.setViewVisibility(R.id.actions, i5);
            applyStandardTemplate.setViewVisibility(R.id.action_divider, i5);
            buildIntoRemoteViews(applyStandardTemplate, remoteViews);
            return applyStandardTemplate;
        }

        private RemoteViews generateActionButton(Action action) {
            boolean z4;
            int i5;
            if (action.actionIntent == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            String packageName = this.mBuilder.mContext.getPackageName();
            if (z4) {
                i5 = R.layout.notification_action_tombstone;
            } else {
                i5 = R.layout.notification_action;
            }
            RemoteViews remoteViews = new RemoteViews(packageName, i5);
            IconCompat iconCompat = action.getIconCompat();
            if (iconCompat != null) {
                remoteViews.setImageViewBitmap(R.id.action_image, createColoredBitmap(iconCompat, R.color.notification_action_color_filter));
            }
            remoteViews.setTextViewText(R.id.action_text, action.title);
            if (!z4) {
                remoteViews.setOnClickPendingIntent(R.id.action_container, action.actionIntent);
            }
            remoteViews.setContentDescription(R.id.action_container, action.title);
            return remoteViews;
        }

        private static List<Action> getNonContextualActions(List<Action> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Action next : list) {
                if (!next.isContextual()) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(Api24Impl.createDecoratedCustomViewStyle());
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return true;
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView();
            if (bigContentView == null) {
                bigContentView = this.mBuilder.getContentView();
            }
            if (bigContentView == null) {
                return null;
            }
            return createRemoteViews(bigContentView, true);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT < 24 && this.mBuilder.getContentView() != null) {
                return createRemoteViews(this.mBuilder.getContentView(), false);
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews remoteViews;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView();
            if (headsUpContentView != null) {
                remoteViews = headsUpContentView;
            } else {
                remoteViews = this.mBuilder.getContentView();
            }
            if (headsUpContentView == null) {
                return null;
            }
            return createRemoteViews(remoteViews, true);
        }
    }

    public interface Extender {
        @NonNull
        Builder extend(@NonNull Builder builder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface GroupAlertBehavior {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NotificationVisibility {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ServiceNotificationBehavior {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamType {
    }

    public static abstract class Style {
        CharSequence mBigContentTitle;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        protected Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet = false;

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static void setChronometerCountDown(RemoteViews remoteViews, int i5, boolean z4) {
                remoteViews.setChronometerCountDown(i5, z4);
            }
        }

        private int calculateTopPadding() {
            Resources resources = this.mBuilder.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
            float constrain = (constrain(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - constrain) * ((float) dimensionPixelSize)) + (constrain * ((float) dimensionPixelSize2)));
        }

        private static float constrain(float f5, float f6, float f7) {
            return f5 < f6 ? f6 : f5 > f7 ? f7 : f5;
        }

        @Nullable
        static Style constructCompatStyleByName(@Nullable String str) {
            if (str == null) {
                return null;
            }
            char c5 = 65535;
            switch (str.hashCode()) {
                case -716705180:
                    if (str.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -171946061:
                    if (str.equals("androidx.core.app.NotificationCompat$BigPictureStyle")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 714386739:
                    if (str.equals("androidx.core.app.NotificationCompat$CallStyle")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 912942987:
                    if (str.equals("androidx.core.app.NotificationCompat$InboxStyle")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 919595044:
                    if (str.equals("androidx.core.app.NotificationCompat$BigTextStyle")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 2090799565:
                    if (str.equals("androidx.core.app.NotificationCompat$MessagingStyle")) {
                        c5 = 5;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    return new DecoratedCustomViewStyle();
                case 1:
                    return new BigPictureStyle();
                case 2:
                    return new CallStyle();
                case 3:
                    return new InboxStyle();
                case 4:
                    return new BigTextStyle();
                case 5:
                    return new MessagingStyle();
                default:
                    return null;
            }
        }

        @Nullable
        private static Style constructCompatStyleByPlatformName(@Nullable String str) {
            if (str == null) {
                return null;
            }
            if (str.equals(Notification.BigPictureStyle.class.getName())) {
                return new BigPictureStyle();
            }
            if (str.equals(Notification.BigTextStyle.class.getName())) {
                return new BigTextStyle();
            }
            if (str.equals(Notification.InboxStyle.class.getName())) {
                return new InboxStyle();
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (str.equals(m.a().getName())) {
                    return new MessagingStyle();
                }
                if (str.equals(n.a().getName())) {
                    return new DecoratedCustomViewStyle();
                }
            }
            return null;
        }

        @Nullable
        static Style constructCompatStyleForBundle(@NonNull Bundle bundle) {
            Style constructCompatStyleByName = constructCompatStyleByName(bundle.getString(NotificationCompat.EXTRA_COMPAT_TEMPLATE));
            if (constructCompatStyleByName != null) {
                return constructCompatStyleByName;
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_SELF_DISPLAY_NAME) || bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                return new MessagingStyle();
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_PICTURE) || bundle.containsKey(NotificationCompat.EXTRA_PICTURE_ICON)) {
                return new BigPictureStyle();
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_BIG_TEXT)) {
                return new BigTextStyle();
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_TEXT_LINES)) {
                return new InboxStyle();
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_CALL_TYPE)) {
                return new CallStyle();
            }
            return constructCompatStyleByPlatformName(bundle.getString(NotificationCompat.EXTRA_TEMPLATE));
        }

        @Nullable
        static Style constructStyleForExtras(@NonNull Bundle bundle) {
            Style constructCompatStyleForBundle = constructCompatStyleForBundle(bundle);
            if (constructCompatStyleForBundle == null) {
                return null;
            }
            try {
                constructCompatStyleForBundle.restoreFromCompatExtras(bundle);
                return constructCompatStyleForBundle;
            } catch (ClassCastException unused) {
                return null;
            }
        }

        private Bitmap createIconWithBackground(int i5, int i6, int i7, int i8) {
            int i9 = R.drawable.notification_icon_background;
            if (i8 == 0) {
                i8 = 0;
            }
            Bitmap createColoredBitmap = createColoredBitmap(i9, i8, i6);
            Canvas canvas = new Canvas(createColoredBitmap);
            Drawable mutate = this.mBuilder.mContext.getResources().getDrawable(i5).mutate();
            mutate.setFilterBitmap(true);
            int i10 = (i6 - i7) / 2;
            int i11 = i7 + i10;
            mutate.setBounds(i10, i10, i11, i11);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return createColoredBitmap;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Style extractStyleFromNotification(@NonNull Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            if (extras == null) {
                return null;
            }
            return constructStyleForExtras(extras);
        }

        private void hideNormalContent(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R.id.title, 8);
            remoteViews.setViewVisibility(R.id.text2, 8);
            remoteViews.setViewVisibility(R.id.text, 8);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void addCompatExtras(@NonNull Bundle bundle) {
            if (this.mSummaryTextSet) {
                bundle.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.mSummaryText);
            }
            CharSequence charSequence = this.mBigContentTitle;
            if (charSequence != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, charSequence);
            }
            String className = getClassName();
            if (className != null) {
                bundle.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, className);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x013c  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0180  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0185  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0187  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0190  */
        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.widget.RemoteViews applyStandardTemplate(boolean r13, int r14, boolean r15) {
            /*
                r12 = this;
                androidx.core.app.NotificationCompat$Builder r0 = r12.mBuilder
                android.content.Context r0 = r0.mContext
                android.content.res.Resources r0 = r0.getResources()
                android.widget.RemoteViews r1 = new android.widget.RemoteViews
                androidx.core.app.NotificationCompat$Builder r2 = r12.mBuilder
                android.content.Context r2 = r2.mContext
                java.lang.String r2 = r2.getPackageName()
                r1.<init>(r2, r14)
                androidx.core.app.NotificationCompat$Builder r14 = r12.mBuilder
                r14.getPriority()
                int r14 = android.os.Build.VERSION.SDK_INT
                androidx.core.app.NotificationCompat$Builder r2 = r12.mBuilder
                androidx.core.graphics.drawable.IconCompat r3 = r2.mLargeIcon
                r7 = 0
                if (r3 == 0) goto L_0x0064
                int r2 = androidx.core.R.id.icon
                r1.setViewVisibility(r2, r7)
                androidx.core.app.NotificationCompat$Builder r3 = r12.mBuilder
                androidx.core.graphics.drawable.IconCompat r3 = r3.mLargeIcon
                android.graphics.Bitmap r3 = r12.createColoredBitmap((androidx.core.graphics.drawable.IconCompat) r3, (int) r7)
                r1.setImageViewBitmap(r2, r3)
                if (r13 == 0) goto L_0x0095
                androidx.core.app.NotificationCompat$Builder r13 = r12.mBuilder
                android.app.Notification r13 = r13.mNotification
                int r13 = r13.icon
                if (r13 == 0) goto L_0x0095
                int r13 = androidx.core.R.dimen.notification_right_icon_size
                int r13 = r0.getDimensionPixelSize(r13)
                int r2 = androidx.core.R.dimen.notification_small_icon_background_padding
                int r2 = r0.getDimensionPixelSize(r2)
                int r2 = r2 * 2
                int r2 = r13 - r2
                androidx.core.app.NotificationCompat$Builder r3 = r12.mBuilder
                android.app.Notification r4 = r3.mNotification
                int r4 = r4.icon
                int r3 = r3.getColor()
                android.graphics.Bitmap r13 = r12.createIconWithBackground(r4, r13, r2, r3)
                int r2 = androidx.core.R.id.right_icon
                r1.setImageViewBitmap(r2, r13)
                r1.setViewVisibility(r2, r7)
                goto L_0x0095
            L_0x0064:
                if (r13 == 0) goto L_0x0095
                android.app.Notification r13 = r2.mNotification
                int r13 = r13.icon
                if (r13 == 0) goto L_0x0095
                int r13 = androidx.core.R.id.icon
                r1.setViewVisibility(r13, r7)
                int r2 = androidx.core.R.dimen.notification_large_icon_width
                int r2 = r0.getDimensionPixelSize(r2)
                int r3 = androidx.core.R.dimen.notification_big_circle_margin
                int r3 = r0.getDimensionPixelSize(r3)
                int r2 = r2 - r3
                int r3 = androidx.core.R.dimen.notification_small_icon_size_as_large
                int r3 = r0.getDimensionPixelSize(r3)
                androidx.core.app.NotificationCompat$Builder r4 = r12.mBuilder
                android.app.Notification r5 = r4.mNotification
                int r5 = r5.icon
                int r4 = r4.getColor()
                android.graphics.Bitmap r2 = r12.createIconWithBackground(r5, r2, r3, r4)
                r1.setImageViewBitmap(r13, r2)
            L_0x0095:
                androidx.core.app.NotificationCompat$Builder r13 = r12.mBuilder
                java.lang.CharSequence r13 = r13.mContentTitle
                if (r13 == 0) goto L_0x00a0
                int r2 = androidx.core.R.id.title
                r1.setTextViewText(r2, r13)
            L_0x00a0:
                androidx.core.app.NotificationCompat$Builder r13 = r12.mBuilder
                java.lang.CharSequence r13 = r13.mContentText
                r8 = 1
                if (r13 == 0) goto L_0x00ae
                int r2 = androidx.core.R.id.text
                r1.setTextViewText(r2, r13)
                r13 = r8
                goto L_0x00af
            L_0x00ae:
                r13 = r7
            L_0x00af:
                androidx.core.app.NotificationCompat$Builder r2 = r12.mBuilder
                java.lang.CharSequence r3 = r2.mContentInfo
                r9 = 8
                if (r3 == 0) goto L_0x00c2
                int r13 = androidx.core.R.id.info
                r1.setTextViewText(r13, r3)
                r1.setViewVisibility(r13, r7)
            L_0x00bf:
                r13 = r8
                r10 = r13
                goto L_0x00fc
            L_0x00c2:
                int r2 = r2.mNumber
                if (r2 <= 0) goto L_0x00f6
                int r13 = androidx.core.R.integer.status_bar_notification_info_maxnum
                int r13 = r0.getInteger(r13)
                androidx.core.app.NotificationCompat$Builder r2 = r12.mBuilder
                int r2 = r2.mNumber
                if (r2 <= r13) goto L_0x00de
                int r13 = androidx.core.R.id.info
                int r2 = androidx.core.R.string.status_bar_notification_info_overflow
                java.lang.String r2 = r0.getString(r2)
                r1.setTextViewText(r13, r2)
                goto L_0x00f0
            L_0x00de:
                java.text.NumberFormat r13 = java.text.NumberFormat.getIntegerInstance()
                int r2 = androidx.core.R.id.info
                androidx.core.app.NotificationCompat$Builder r3 = r12.mBuilder
                int r3 = r3.mNumber
                long r3 = (long) r3
                java.lang.String r13 = r13.format(r3)
                r1.setTextViewText(r2, r13)
            L_0x00f0:
                int r13 = androidx.core.R.id.info
                r1.setViewVisibility(r13, r7)
                goto L_0x00bf
            L_0x00f6:
                int r2 = androidx.core.R.id.info
                r1.setViewVisibility(r2, r9)
                r10 = r7
            L_0x00fc:
                androidx.core.app.NotificationCompat$Builder r2 = r12.mBuilder
                java.lang.CharSequence r2 = r2.mSubText
                if (r2 == 0) goto L_0x0130
                int r3 = androidx.core.R.id.text
                r1.setTextViewText(r3, r2)
                androidx.core.app.NotificationCompat$Builder r2 = r12.mBuilder
                java.lang.CharSequence r2 = r2.mContentText
                if (r2 == 0) goto L_0x012b
                int r4 = androidx.core.R.id.text2
                r1.setTextViewText(r4, r2)
                r1.setViewVisibility(r4, r7)
                if (r15 == 0) goto L_0x0121
                int r15 = androidx.core.R.dimen.notification_subtext_size
                int r15 = r0.getDimensionPixelSize(r15)
                float r15 = (float) r15
                r1.setTextViewTextSize(r3, r7, r15)
            L_0x0121:
                int r2 = androidx.core.R.id.line1
                r5 = 0
                r6 = 0
                r3 = 0
                r4 = 0
                r1.setViewPadding(r2, r3, r4, r5, r6)
                goto L_0x0130
            L_0x012b:
                int r15 = androidx.core.R.id.text2
                r1.setViewVisibility(r15, r9)
            L_0x0130:
                androidx.core.app.NotificationCompat$Builder r15 = r12.mBuilder
                long r2 = r15.getWhenIfShowing()
                r4 = 0
                int r15 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r15 == 0) goto L_0x0180
                androidx.core.app.NotificationCompat$Builder r15 = r12.mBuilder
                boolean r15 = r15.mUseChronometer
                if (r15 == 0) goto L_0x016f
                int r15 = androidx.core.R.id.chronometer
                r1.setViewVisibility(r15, r7)
                androidx.core.app.NotificationCompat$Builder r0 = r12.mBuilder
                long r2 = r0.getWhenIfShowing()
                long r4 = android.os.SystemClock.elapsedRealtime()
                long r10 = java.lang.System.currentTimeMillis()
                long r4 = r4 - r10
                long r2 = r2 + r4
                java.lang.String r0 = "setBase"
                r1.setLong(r15, r0, r2)
                java.lang.String r0 = "setStarted"
                r1.setBoolean(r15, r0, r8)
                androidx.core.app.NotificationCompat$Builder r0 = r12.mBuilder
                boolean r0 = r0.mChronometerCountDown
                if (r0 == 0) goto L_0x0181
                r2 = 24
                if (r14 < r2) goto L_0x0181
                androidx.core.app.NotificationCompat.Style.Api24Impl.setChronometerCountDown(r1, r15, r0)
                goto L_0x0181
            L_0x016f:
                int r14 = androidx.core.R.id.time
                r1.setViewVisibility(r14, r7)
                androidx.core.app.NotificationCompat$Builder r15 = r12.mBuilder
                long r2 = r15.getWhenIfShowing()
                java.lang.String r15 = "setTime"
                r1.setLong(r14, r15, r2)
                goto L_0x0181
            L_0x0180:
                r8 = r10
            L_0x0181:
                int r14 = androidx.core.R.id.right_side
                if (r8 == 0) goto L_0x0187
                r15 = r7
                goto L_0x0188
            L_0x0187:
                r15 = r9
            L_0x0188:
                r1.setViewVisibility(r14, r15)
                int r14 = androidx.core.R.id.line3
                if (r13 == 0) goto L_0x0190
                goto L_0x0191
            L_0x0190:
                r7 = r9
            L_0x0191:
                r1.setViewVisibility(r14, r7)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.Style.applyStandardTemplate(boolean, int, boolean):android.widget.RemoteViews");
        }

        @Nullable
        public Notification build() {
            Builder builder = this.mBuilder;
            if (builder != null) {
                return builder.build();
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
            hideNormalContent(remoteViews);
            int i5 = R.id.notification_main_column;
            remoteViews.removeAllViews(i5);
            remoteViews.addView(i5, remoteViews2.clone());
            remoteViews.setViewVisibility(i5, 0);
            RemoteViews remoteViews3 = remoteViews;
            remoteViews3.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            bundle.remove(NotificationCompat.EXTRA_SUMMARY_TEXT);
            bundle.remove(NotificationCompat.EXTRA_TITLE_BIG);
            bundle.remove(NotificationCompat.EXTRA_COMPAT_TEMPLATE);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bitmap createColoredBitmap(int i5, int i6) {
            return createColoredBitmap(i5, i6, 0);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public boolean displayCustomViewInline() {
            return false;
        }

        /* access modifiers changed from: protected */
        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            if (bundle.containsKey(NotificationCompat.EXTRA_SUMMARY_TEXT)) {
                this.mSummaryText = bundle.getCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT);
                this.mSummaryTextSet = true;
            }
            this.mBigContentTitle = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
        }

        public void setBuilder(@Nullable Builder builder) {
            if (this.mBuilder != builder) {
                this.mBuilder = builder;
                if (builder != null) {
                    builder.setStyle(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public Bitmap createColoredBitmap(@NonNull IconCompat iconCompat, int i5) {
            return createColoredBitmap(iconCompat, i5, 0);
        }

        private Bitmap createColoredBitmap(int i5, int i6, int i7) {
            return createColoredBitmap(IconCompat.createWithResource(this.mBuilder.mContext, i5), i6, i7);
        }

        private Bitmap createColoredBitmap(@NonNull IconCompat iconCompat, int i5, int i6) {
            Drawable loadDrawable = iconCompat.loadDrawable(this.mBuilder.mContext);
            int intrinsicWidth = i6 == 0 ? loadDrawable.getIntrinsicWidth() : i6;
            if (i6 == 0) {
                i6 = loadDrawable.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i6, Bitmap.Config.ARGB_8888);
            loadDrawable.setBounds(0, 0, intrinsicWidth, i6);
            if (i5 != 0) {
                loadDrawable.mutate().setColorFilter(new PorterDuffColorFilter(i5, PorterDuff.Mode.SRC_IN));
            }
            loadDrawable.draw(new Canvas(createBitmap));
            return createBitmap;
        }
    }

    public static final class WearableExtender implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_BIG_PICTURE_AMBIENT = 32;
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_BRIDGE_TAG = "bridgeTag";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISMISSAL_ID = "dismissalId";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        @Deprecated
        public static final int SCREEN_TIMEOUT_LONG = -1;
        @Deprecated
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        @Deprecated
        public static final int SIZE_DEFAULT = 0;
        @Deprecated
        public static final int SIZE_FULL_SCREEN = 5;
        @Deprecated
        public static final int SIZE_LARGE = 4;
        @Deprecated
        public static final int SIZE_MEDIUM = 3;
        @Deprecated
        public static final int SIZE_SMALL = 2;
        @Deprecated
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions = new ArrayList<>();
        private Bitmap mBackground;
        private String mBridgeTag;
        private int mContentActionIndex = -1;
        private int mContentIcon;
        private int mContentIconGravity = 8388613;
        private int mCustomContentHeight;
        private int mCustomSizePreset = 0;
        private String mDismissalId;
        private PendingIntent mDisplayIntent;
        private int mFlags = 1;
        private int mGravity = 80;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages = new ArrayList<>();

        @RequiresApi(20)
        static class Api20Impl {
            private Api20Impl() {
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
            public static Action getActionCompatFromAction(ArrayList<Parcelable> arrayList, int i5) {
                return NotificationCompat.getActionCompatFromAction((Notification.Action) arrayList.get(i5));
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
        }

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean z4) {
                return builder.setAllowGeneratedReplies(z4);
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
        }

        public WearableExtender() {
        }

        @RequiresApi(20)
        private static Notification.Action getActionFromActionCompat(Action action) {
            Icon icon;
            Bundle bundle;
            int i5 = Build.VERSION.SDK_INT;
            IconCompat iconCompat = action.getIconCompat();
            if (iconCompat == null) {
                icon = null;
            } else {
                icon = iconCompat.toIcon();
            }
            Notification.Action.Builder createBuilder = Api23Impl.createBuilder(icon, action.getTitle(), action.getActionIntent());
            if (action.getExtras() != null) {
                bundle = new Bundle(action.getExtras());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
            if (i5 >= 24) {
                Api24Impl.setAllowGeneratedReplies(createBuilder, action.getAllowGeneratedReplies());
            }
            if (i5 >= 31) {
                Api31Impl.setAuthenticationRequired(createBuilder, action.isAuthenticationRequired());
            }
            Api20Impl.addExtras(createBuilder, bundle);
            RemoteInput[] remoteInputs = action.getRemoteInputs();
            if (remoteInputs != null) {
                for (RemoteInput addRemoteInput : RemoteInput.fromCompat(remoteInputs)) {
                    Api20Impl.addRemoteInput(createBuilder, addRemoteInput);
                }
            }
            return Api20Impl.build(createBuilder);
        }

        private void setFlag(int i5, boolean z4) {
            if (z4) {
                this.mFlags = i5 | this.mFlags;
                return;
            }
            this.mFlags = (~i5) & this.mFlags;
        }

        @NonNull
        public WearableExtender addAction(@NonNull Action action) {
            this.mActions.add(action);
            return this;
        }

        @NonNull
        public WearableExtender addActions(@NonNull List<Action> list) {
            this.mActions.addAll(list);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPage(@NonNull Notification notification) {
            this.mPages.add(notification);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender addPages(@NonNull List<Notification> list) {
            this.mPages.addAll(list);
            return this;
        }

        @NonNull
        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        @NonNull
        public Builder extend(@NonNull Builder builder) {
            Bundle bundle = new Bundle();
            if (!this.mActions.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.mActions.size());
                ArrayList<Action> arrayList2 = this.mActions;
                int size = arrayList2.size();
                int i5 = 0;
                while (i5 < size) {
                    Action action = arrayList2.get(i5);
                    i5++;
                    arrayList.add(getActionFromActionCompat(action));
                }
                bundle.putParcelableArrayList(KEY_ACTIONS, arrayList);
            }
            int i6 = this.mFlags;
            if (i6 != 1) {
                bundle.putInt(KEY_FLAGS, i6);
            }
            PendingIntent pendingIntent = this.mDisplayIntent;
            if (pendingIntent != null) {
                bundle.putParcelable(KEY_DISPLAY_INTENT, pendingIntent);
            }
            if (!this.mPages.isEmpty()) {
                ArrayList<Notification> arrayList3 = this.mPages;
                bundle.putParcelableArray(KEY_PAGES, (Parcelable[]) arrayList3.toArray(new Notification[arrayList3.size()]));
            }
            Bitmap bitmap = this.mBackground;
            if (bitmap != null) {
                bundle.putParcelable(KEY_BACKGROUND, bitmap);
            }
            int i7 = this.mContentIcon;
            if (i7 != 0) {
                bundle.putInt(KEY_CONTENT_ICON, i7);
            }
            int i8 = this.mContentIconGravity;
            if (i8 != 8388613) {
                bundle.putInt(KEY_CONTENT_ICON_GRAVITY, i8);
            }
            int i9 = this.mContentActionIndex;
            if (i9 != -1) {
                bundle.putInt(KEY_CONTENT_ACTION_INDEX, i9);
            }
            int i10 = this.mCustomSizePreset;
            if (i10 != 0) {
                bundle.putInt(KEY_CUSTOM_SIZE_PRESET, i10);
            }
            int i11 = this.mCustomContentHeight;
            if (i11 != 0) {
                bundle.putInt(KEY_CUSTOM_CONTENT_HEIGHT, i11);
            }
            int i12 = this.mGravity;
            if (i12 != 80) {
                bundle.putInt(KEY_GRAVITY, i12);
            }
            int i13 = this.mHintScreenTimeout;
            if (i13 != 0) {
                bundle.putInt(KEY_HINT_SCREEN_TIMEOUT, i13);
            }
            String str = this.mDismissalId;
            if (str != null) {
                bundle.putString(KEY_DISMISSAL_ID, str);
            }
            String str2 = this.mBridgeTag;
            if (str2 != null) {
                bundle.putString(KEY_BRIDGE_TAG, str2);
            }
            builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
            return builder;
        }

        @NonNull
        public List<Action> getActions() {
            return this.mActions;
        }

        @Deprecated
        @Nullable
        public Bitmap getBackground() {
            return this.mBackground;
        }

        @Nullable
        public String getBridgeTag() {
            return this.mBridgeTag;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        @Deprecated
        public int getContentIcon() {
            return this.mContentIcon;
        }

        @Deprecated
        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            return false;
        }

        @Deprecated
        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        @Deprecated
        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        @Nullable
        public String getDismissalId() {
            return this.mDismissalId;
        }

        @Deprecated
        @Nullable
        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        @Deprecated
        public int getGravity() {
            return this.mGravity;
        }

        @Deprecated
        public boolean getHintAmbientBigPicture() {
            if ((this.mFlags & 32) != 0) {
                return true;
            }
            return false;
        }

        @Deprecated
        public boolean getHintAvoidBackgroundClipping() {
            if ((this.mFlags & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean getHintContentIntentLaunchesActivity() {
            if ((this.mFlags & 64) != 0) {
                return true;
            }
            return false;
        }

        @Deprecated
        public boolean getHintHideIcon() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        @Deprecated
        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        @Deprecated
        public boolean getHintShowBackgroundOnly() {
            if ((this.mFlags & 4) != 0) {
                return true;
            }
            return false;
        }

        @NonNull
        @Deprecated
        public List<Notification> getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            if ((this.mFlags & 8) != 0) {
                return true;
            }
            return false;
        }

        @NonNull
        @Deprecated
        public WearableExtender setBackground(@Nullable Bitmap bitmap) {
            this.mBackground = bitmap;
            return this;
        }

        @NonNull
        public WearableExtender setBridgeTag(@Nullable String str) {
            this.mBridgeTag = str;
            return this;
        }

        @NonNull
        public WearableExtender setContentAction(int i5) {
            this.mContentActionIndex = i5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIcon(int i5) {
            this.mContentIcon = i5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setContentIconGravity(int i5) {
            this.mContentIconGravity = i5;
            return this;
        }

        @NonNull
        public WearableExtender setContentIntentAvailableOffline(boolean z4) {
            setFlag(1, z4);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomContentHeight(int i5) {
            this.mCustomContentHeight = i5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setCustomSizePreset(int i5) {
            this.mCustomSizePreset = i5;
            return this;
        }

        @NonNull
        public WearableExtender setDismissalId(@Nullable String str) {
            this.mDismissalId = str;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setDisplayIntent(@Nullable PendingIntent pendingIntent) {
            this.mDisplayIntent = pendingIntent;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setGravity(int i5) {
            this.mGravity = i5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAmbientBigPicture(boolean z4) {
            setFlag(32, z4);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintAvoidBackgroundClipping(boolean z4) {
            setFlag(16, z4);
            return this;
        }

        @NonNull
        public WearableExtender setHintContentIntentLaunchesActivity(boolean z4) {
            setFlag(64, z4);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintHideIcon(boolean z4) {
            setFlag(2, z4);
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintScreenTimeout(int i5) {
            this.mHintScreenTimeout = i5;
            return this;
        }

        @NonNull
        @Deprecated
        public WearableExtender setHintShowBackgroundOnly(boolean z4) {
            setFlag(4, z4);
            return this;
        }

        @NonNull
        public WearableExtender setStartScrollBottom(boolean z4) {
            setFlag(8, z4);
            return this;
        }

        @NonNull
        public WearableExtender clone() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.mActions = new ArrayList<>(this.mActions);
            wearableExtender.mFlags = this.mFlags;
            wearableExtender.mDisplayIntent = this.mDisplayIntent;
            wearableExtender.mPages = new ArrayList<>(this.mPages);
            wearableExtender.mBackground = this.mBackground;
            wearableExtender.mContentIcon = this.mContentIcon;
            wearableExtender.mContentIconGravity = this.mContentIconGravity;
            wearableExtender.mContentActionIndex = this.mContentActionIndex;
            wearableExtender.mCustomSizePreset = this.mCustomSizePreset;
            wearableExtender.mCustomContentHeight = this.mCustomContentHeight;
            wearableExtender.mGravity = this.mGravity;
            wearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
            wearableExtender.mDismissalId = this.mDismissalId;
            wearableExtender.mBridgeTag = this.mBridgeTag;
            return wearableExtender;
        }

        public WearableExtender(@NonNull Notification notification) {
            Bundle extras = NotificationCompat.getExtras(notification);
            Bundle bundle = extras != null ? extras.getBundle(EXTRA_WEARABLE_EXTENSIONS) : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEY_ACTIONS);
                if (parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    Action[] actionArr = new Action[size];
                    for (int i5 = 0; i5 < size; i5++) {
                        actionArr[i5] = Api20Impl.getActionCompatFromAction(parcelableArrayList, i5);
                    }
                    Collections.addAll(this.mActions, actionArr);
                }
                this.mFlags = bundle.getInt(KEY_FLAGS, 1);
                this.mDisplayIntent = (PendingIntent) bundle.getParcelable(KEY_DISPLAY_INTENT);
                Notification[] notificationArrayFromBundle = NotificationCompat.getNotificationArrayFromBundle(bundle, KEY_PAGES);
                if (notificationArrayFromBundle != null) {
                    Collections.addAll(this.mPages, notificationArrayFromBundle);
                }
                this.mBackground = (Bitmap) bundle.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = bundle.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = bundle.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
                this.mContentActionIndex = bundle.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = bundle.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = bundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = bundle.getInt(KEY_GRAVITY, 80);
                this.mHintScreenTimeout = bundle.getInt(KEY_HINT_SCREEN_TIMEOUT);
                this.mDismissalId = bundle.getString(KEY_DISMISSAL_ID);
                this.mBridgeTag = bundle.getString(KEY_BRIDGE_TAG);
            }
        }
    }

    @Nullable
    public static Action getAction(@NonNull Notification notification, int i5) {
        return getActionCompatFromAction(notification.actions[i5]);
    }

    @RequiresApi(20)
    @NonNull
    static Action getActionCompatFromAction(@NonNull Notification.Action action) {
        RemoteInput[] remoteInputArr;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        int i7;
        Notification.Action action2 = action;
        RemoteInput[] remoteInputs = Api20Impl.getRemoteInputs(action2);
        IconCompat iconCompat = null;
        boolean z6 = false;
        if (remoteInputs == null) {
            remoteInputArr = null;
        } else {
            RemoteInput[] remoteInputArr2 = new RemoteInput[remoteInputs.length];
            for (int i8 = 0; i8 < remoteInputs.length; i8++) {
                RemoteInput remoteInput = remoteInputs[i8];
                String resultKey = Api20Impl.getResultKey(remoteInput);
                CharSequence label = Api20Impl.getLabel(remoteInput);
                CharSequence[] choices = Api20Impl.getChoices(remoteInput);
                boolean allowFreeFormInput = Api20Impl.getAllowFreeFormInput(remoteInput);
                if (Build.VERSION.SDK_INT >= 29) {
                    i7 = Api29Impl.getEditChoicesBeforeSending(remoteInput);
                } else {
                    i7 = 0;
                }
                remoteInputArr2[i8] = new RemoteInput(resultKey, label, choices, allowFreeFormInput, i7, Api20Impl.getExtras(remoteInput), (Set<String>) null);
            }
            remoteInputArr = remoteInputArr2;
        }
        int i9 = Build.VERSION.SDK_INT;
        if (i9 < 24) {
            z4 = Api20Impl.getExtras(action2).getBoolean("android.support.allowGeneratedReplies");
        } else if (Api20Impl.getExtras(action2).getBoolean("android.support.allowGeneratedReplies") || Api24Impl.getAllowGeneratedReplies(action2)) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z7 = z4;
        boolean z8 = Api20Impl.getExtras(action2).getBoolean("android.support.action.showsUserInterface", true);
        if (i9 >= 28) {
            i5 = Api28Impl.getSemanticAction(action2);
        } else {
            i5 = Api20Impl.getExtras(action2).getInt("android.support.action.semanticAction", 0);
        }
        int i10 = i5;
        if (i9 >= 29) {
            z5 = Api29Impl.isContextual(action2);
        } else {
            z5 = false;
        }
        if (i9 >= 31) {
            z6 = Api31Impl.isAuthenticationRequired(action2);
        }
        boolean z9 = z6;
        if (Api23Impl.getIcon(action2) == null && (i6 = action2.icon) != 0) {
            return new Action(i6, action2.title, action2.actionIntent, Api20Impl.getExtras(action2), remoteInputArr, (RemoteInput[]) null, z7, i10, z8, z5, z9);
        }
        if (Api23Impl.getIcon(action2) != null) {
            iconCompat = IconCompat.createFromIconOrNullIfZeroResId(Api23Impl.getIcon(action2));
        }
        return new Action(iconCompat, action2.title, action2.actionIntent, Api20Impl.getExtras(action2), remoteInputArr, (RemoteInput[]) null, z7, i10, z8, z5, z9);
    }

    public static int getActionCount(@NonNull Notification notification) {
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static boolean getAllowSystemGeneratedContextualActions(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getAllowSystemGeneratedContextualActions(notification);
        }
        return false;
    }

    public static boolean getAutoCancel(@NonNull Notification notification) {
        if ((notification.flags & 16) != 0) {
            return true;
        }
        return false;
    }

    public static int getBadgeIconType(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getBadgeIconType(notification);
        }
        return 0;
    }

    @Nullable
    public static BubbleMetadata getBubbleMetadata(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return BubbleMetadata.fromPlatform(Api29Impl.getBubbleMetadata(notification));
        }
        return null;
    }

    @Nullable
    public static String getCategory(@NonNull Notification notification) {
        return notification.category;
    }

    @Nullable
    public static String getChannelId(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getChannelId(notification);
        }
        return null;
    }

    public static int getColor(@NonNull Notification notification) {
        return notification.color;
    }

    @Nullable
    public static CharSequence getContentInfo(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    @Nullable
    public static CharSequence getContentText(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TEXT);
    }

    @Nullable
    public static CharSequence getContentTitle(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    @Nullable
    public static Bundle getExtras(@NonNull Notification notification) {
        return notification.extras;
    }

    @Nullable
    public static String getGroup(@NonNull Notification notification) {
        return Api20Impl.getGroup(notification);
    }

    public static int getGroupAlertBehavior(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getGroupAlertBehavior(notification);
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static boolean getHighPriority(@NonNull Notification notification) {
        if ((notification.flags & 128) != 0) {
            return true;
        }
        return false;
    }

    @RequiresApi(21)
    @NonNull
    public static List<Action> getInvisibleActions(@NonNull Notification notification) {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = notification.extras.getBundle("android.car.EXTENSIONS");
        if (!(bundle2 == null || (bundle = bundle2.getBundle("invisible_actions")) == null)) {
            for (int i5 = 0; i5 < bundle.size(); i5++) {
                arrayList.add(NotificationCompatJellybean.getActionFromBundle(bundle.getBundle(Integer.toString(i5))));
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(@NonNull Notification notification) {
        if ((notification.flags & 256) != 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public static LocusIdCompat getLocusId(@NonNull Notification notification) {
        LocusId locusId;
        if (Build.VERSION.SDK_INT < 29 || (locusId = Api29Impl.getLocusId(notification)) == null) {
            return null;
        }
        return LocusIdCompat.toLocusIdCompat(locusId);
    }

    @NonNull
    static Notification[] getNotificationArrayFromBundle(@NonNull Bundle bundle, @NonNull String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        for (int i5 = 0; i5 < parcelableArray.length; i5++) {
            notificationArr[i5] = (Notification) parcelableArray[i5];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static boolean getOngoing(@NonNull Notification notification) {
        if ((notification.flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean getOnlyAlertOnce(@NonNull Notification notification) {
        if ((notification.flags & 8) != 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public static List<Person> getPeople(@NonNull Notification notification) {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        if (Build.VERSION.SDK_INT >= 28) {
            ArrayList parcelableArrayList = notification.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                int size = parcelableArrayList.size();
                while (i5 < size) {
                    Object obj = parcelableArrayList.get(i5);
                    i5++;
                    arrayList.add(Person.fromAndroidPerson(j.a(obj)));
                }
            }
        } else {
            String[] stringArray = notification.extras.getStringArray(EXTRA_PEOPLE);
            if (!(stringArray == null || stringArray.length == 0)) {
                int length = stringArray.length;
                while (i5 < length) {
                    arrayList.add(new Person.Builder().setUri(stringArray[i5]).build());
                    i5++;
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static Notification getPublicVersion(@NonNull Notification notification) {
        return notification.publicVersion;
    }

    @Nullable
    public static CharSequence getSettingsText(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getSettingsText(notification);
        }
        return null;
    }

    @Nullable
    public static String getShortcutId(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getShortcutId(notification);
        }
        return null;
    }

    public static boolean getShowWhen(@NonNull Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    @Nullable
    public static String getSortKey(@NonNull Notification notification) {
        return Api20Impl.getSortKey(notification);
    }

    @Nullable
    public static CharSequence getSubText(@NonNull Notification notification) {
        return notification.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getTimeoutAfter(notification);
        }
        return 0;
    }

    public static boolean getUsesChronometer(@NonNull Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(@NonNull Notification notification) {
        return notification.visibility;
    }

    public static boolean isGroupSummary(@NonNull Notification notification) {
        if ((notification.flags & 512) != 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Bitmap reduceLargeIconSize(@NonNull Context context, @Nullable Bitmap bitmap) {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
    }

    public static final class CarExtender implements Extender {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String KEY_AUTHOR = "author";
        private static final String KEY_MESSAGES = "messages";
        private static final String KEY_ON_READ = "on_read";
        private static final String KEY_ON_REPLY = "on_reply";
        private static final String KEY_PARTICIPANTS = "participants";
        private static final String KEY_REMOTE_INPUT = "remote_input";
        private static final String KEY_TEXT = "text";
        private static final String KEY_TIMESTAMP = "timestamp";
        private int mColor = 0;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        @RequiresApi(20)
        static class Api20Impl {
            private Api20Impl() {
            }

            @DoNotInline
            static RemoteInput.Builder addExtras(RemoteInput.Builder builder, Bundle bundle) {
                return builder.addExtras(bundle);
            }

            @DoNotInline
            static RemoteInput build(RemoteInput.Builder builder) {
                return builder.build();
            }

            @DoNotInline
            static Parcelable castToParcelable(RemoteInput remoteInput) {
                return remoteInput;
            }

            @DoNotInline
            static RemoteInput.Builder createBuilder(String str) {
                return new RemoteInput.Builder(str);
            }

            @DoNotInline
            static boolean getAllowFreeFormInput(RemoteInput remoteInput) {
                return remoteInput.getAllowFreeFormInput();
            }

            @DoNotInline
            static CharSequence[] getChoices(RemoteInput remoteInput) {
                return remoteInput.getChoices();
            }

            @DoNotInline
            static Bundle getExtras(RemoteInput remoteInput) {
                return remoteInput.getExtras();
            }

            @DoNotInline
            static CharSequence getLabel(RemoteInput remoteInput) {
                return remoteInput.getLabel();
            }

            @DoNotInline
            static String getResultKey(RemoteInput remoteInput) {
                return remoteInput.getResultKey();
            }

            @DoNotInline
            static RemoteInput.Builder setAllowFreeFormInput(RemoteInput.Builder builder, boolean z4) {
                return builder.setAllowFreeFormInput(z4);
            }

            @DoNotInline
            static RemoteInput.Builder setChoices(RemoteInput.Builder builder, CharSequence[] charSequenceArr) {
                return builder.setChoices(charSequenceArr);
            }

            @DoNotInline
            static RemoteInput.Builder setLabel(RemoteInput.Builder builder, CharSequence charSequence) {
                return builder.setLabel(charSequence);
            }
        }

        @RequiresApi(29)
        static class Api29Impl {
            private Api29Impl() {
            }

            @DoNotInline
            static int getEditChoicesBeforeSending(RemoteInput remoteInput) {
                return remoteInput.getEditChoicesBeforeSending();
            }
        }

        @Deprecated
        public static class UnreadConversation {
            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            public static class Builder {
                private long mLatestTimestamp;
                private final List<String> mMessages = new ArrayList();
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public Builder(@NonNull String str) {
                    this.mParticipant = str;
                }

                @NonNull
                public Builder addMessage(@Nullable String str) {
                    if (str != null) {
                        this.mMessages.add(str);
                    }
                    return this;
                }

                @NonNull
                public UnreadConversation build() {
                    List<String> list = this.mMessages;
                    return new UnreadConversation((String[]) list.toArray(new String[list.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                }

                @NonNull
                public Builder setLatestTimestamp(long j5) {
                    this.mLatestTimestamp = j5;
                    return this;
                }

                @NonNull
                public Builder setReadPendingIntent(@Nullable PendingIntent pendingIntent) {
                    this.mReadPendingIntent = pendingIntent;
                    return this;
                }

                @NonNull
                public Builder setReplyAction(@Nullable PendingIntent pendingIntent, @Nullable RemoteInput remoteInput) {
                    this.mRemoteInput = remoteInput;
                    this.mReplyPendingIntent = pendingIntent;
                    return this;
                }
            }

            UnreadConversation(@Nullable String[] strArr, @Nullable RemoteInput remoteInput, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable String[] strArr2, long j5) {
                this.mMessages = strArr;
                this.mRemoteInput = remoteInput;
                this.mReadPendingIntent = pendingIntent2;
                this.mReplyPendingIntent = pendingIntent;
                this.mParticipants = strArr2;
                this.mLatestTimestamp = j5;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            @Nullable
            public String[] getMessages() {
                return this.mMessages;
            }

            @Nullable
            public String getParticipant() {
                String[] strArr = this.mParticipants;
                if (strArr.length > 0) {
                    return strArr[0];
                }
                return null;
            }

            @Nullable
            public String[] getParticipants() {
                return this.mParticipants;
            }

            @Nullable
            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            @Nullable
            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            @Nullable
            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        public CarExtender() {
        }

        @RequiresApi(21)
        private static Bundle getBundleForUnreadConversation(@NonNull UnreadConversation unreadConversation) {
            String str;
            Bundle bundle = new Bundle();
            if (unreadConversation.getParticipants() == null || unreadConversation.getParticipants().length <= 1) {
                str = null;
            } else {
                str = unreadConversation.getParticipants()[0];
            }
            int length = unreadConversation.getMessages().length;
            Parcelable[] parcelableArr = new Parcelable[length];
            for (int i5 = 0; i5 < length; i5++) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", unreadConversation.getMessages()[i5]);
                bundle2.putString(KEY_AUTHOR, str);
                parcelableArr[i5] = bundle2;
            }
            bundle.putParcelableArray(KEY_MESSAGES, parcelableArr);
            RemoteInput remoteInput = unreadConversation.getRemoteInput();
            if (remoteInput != null) {
                RemoteInput.Builder createBuilder = Api20Impl.createBuilder(remoteInput.getResultKey());
                Api20Impl.setLabel(createBuilder, remoteInput.getLabel());
                Api20Impl.setChoices(createBuilder, remoteInput.getChoices());
                Api20Impl.setAllowFreeFormInput(createBuilder, remoteInput.getAllowFreeFormInput());
                Api20Impl.addExtras(createBuilder, remoteInput.getExtras());
                bundle.putParcelable(KEY_REMOTE_INPUT, Api20Impl.castToParcelable(Api20Impl.build(createBuilder)));
            }
            bundle.putParcelable(KEY_ON_REPLY, unreadConversation.getReplyPendingIntent());
            bundle.putParcelable(KEY_ON_READ, unreadConversation.getReadPendingIntent());
            bundle.putStringArray(KEY_PARTICIPANTS, unreadConversation.getParticipants());
            bundle.putLong("timestamp", unreadConversation.getLatestTimestamp());
            return bundle;
        }

        @RequiresApi(21)
        private static UnreadConversation getUnreadConversationFromBundle(@Nullable Bundle bundle) {
            String[] strArr;
            RemoteInput remoteInput;
            Bundle bundle2 = bundle;
            if (bundle2 == null) {
                return null;
            }
            Parcelable[] parcelableArray = bundle2.getParcelableArray(KEY_MESSAGES);
            int i5 = 0;
            if (parcelableArray != null) {
                int length = parcelableArray.length;
                String[] strArr2 = new String[length];
                int i6 = 0;
                while (i6 < length) {
                    Parcelable parcelable = parcelableArray[i6];
                    if (parcelable instanceof Bundle) {
                        String string = ((Bundle) parcelable).getString("text");
                        strArr2[i6] = string;
                        if (string != null) {
                            i6++;
                        }
                    }
                    return null;
                }
                strArr = strArr2;
            } else {
                strArr = null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle2.getParcelable(KEY_ON_READ);
            PendingIntent pendingIntent2 = (PendingIntent) bundle2.getParcelable(KEY_ON_REPLY);
            RemoteInput remoteInput2 = (RemoteInput) bundle2.getParcelable(KEY_REMOTE_INPUT);
            String[] stringArray = bundle2.getStringArray(KEY_PARTICIPANTS);
            if (stringArray == null || stringArray.length != 1) {
                return null;
            }
            if (remoteInput2 != null) {
                String resultKey = Api20Impl.getResultKey(remoteInput2);
                CharSequence label = Api20Impl.getLabel(remoteInput2);
                CharSequence[] choices = Api20Impl.getChoices(remoteInput2);
                boolean allowFreeFormInput = Api20Impl.getAllowFreeFormInput(remoteInput2);
                if (Build.VERSION.SDK_INT >= 29) {
                    i5 = Api29Impl.getEditChoicesBeforeSending(remoteInput2);
                }
                remoteInput = new RemoteInput(resultKey, label, choices, allowFreeFormInput, i5, Api20Impl.getExtras(remoteInput2), (Set<String>) null);
            } else {
                remoteInput = null;
            }
            return new UnreadConversation(strArr, remoteInput, pendingIntent2, pendingIntent, stringArray, bundle2.getLong("timestamp"));
        }

        @NonNull
        public Builder extend(@NonNull Builder builder) {
            Bundle bundle = new Bundle();
            Bitmap bitmap = this.mLargeIcon;
            if (bitmap != null) {
                bundle.putParcelable(EXTRA_LARGE_ICON, bitmap);
            }
            int i5 = this.mColor;
            if (i5 != 0) {
                bundle.putInt(EXTRA_COLOR, i5);
            }
            UnreadConversation unreadConversation = this.mUnreadConversation;
            if (unreadConversation != null) {
                bundle.putBundle(EXTRA_CONVERSATION, getBundleForUnreadConversation(unreadConversation));
            }
            builder.getExtras().putBundle(EXTRA_CAR_EXTENDER, bundle);
            return builder;
        }

        @ColorInt
        public int getColor() {
            return this.mColor;
        }

        @Nullable
        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        @Deprecated
        @Nullable
        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        @NonNull
        public CarExtender setColor(@ColorInt int i5) {
            this.mColor = i5;
            return this;
        }

        @NonNull
        public CarExtender setLargeIcon(@Nullable Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        @NonNull
        @Deprecated
        public CarExtender setUnreadConversation(@Nullable UnreadConversation unreadConversation) {
            this.mUnreadConversation = unreadConversation;
            return this;
        }

        public CarExtender(@NonNull Notification notification) {
            Bundle bundle;
            if (NotificationCompat.getExtras(notification) == null) {
                bundle = null;
            } else {
                bundle = NotificationCompat.getExtras(notification).getBundle(EXTRA_CAR_EXTENDER);
            }
            if (bundle != null) {
                this.mLargeIcon = (Bitmap) bundle.getParcelable(EXTRA_LARGE_ICON);
                this.mColor = bundle.getInt(EXTRA_COLOR, 0);
                this.mUnreadConversation = getUnreadConversationFromBundle(bundle.getBundle(EXTRA_CONVERSATION));
            }
        }
    }

    public static class InboxStyle extends Style {
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
        private ArrayList<CharSequence> mTexts = new ArrayList<>();

        public InboxStyle() {
        }

        @NonNull
        public InboxStyle addLine(@Nullable CharSequence charSequence) {
            if (charSequence != null) {
                this.mTexts.add(Builder.limitCharSequenceLength(charSequence));
            }
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(this.mBigContentTitle);
            if (this.mSummaryTextSet) {
                bigContentTitle.setSummaryText(this.mSummaryText);
            }
            ArrayList<CharSequence> arrayList = this.mTexts;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                CharSequence charSequence = arrayList.get(i5);
                i5++;
                bigContentTitle.addLine(charSequence);
            }
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_TEXT_LINES);
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.mTexts.clear();
            if (bundle.containsKey(NotificationCompat.EXTRA_TEXT_LINES)) {
                Collections.addAll(this.mTexts, bundle.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES));
            }
        }

        @NonNull
        public InboxStyle setBigContentTitle(@Nullable CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        @NonNull
        public InboxStyle setSummaryText(@Nullable CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }

        public InboxStyle(@Nullable Builder builder) {
            setBuilder(builder);
        }
    }

    public static final class TvExtender implements Extender {
        static final String EXTRA_CHANNEL_ID = "channel_id";
        static final String EXTRA_CONTENT_INTENT = "content_intent";
        static final String EXTRA_DELETE_INTENT = "delete_intent";
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        private static final String EXTRA_FLAGS = "flags";
        static final String EXTRA_SUPPRESS_SHOW_OVER_APPS = "suppressShowOverApps";
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        static final String EXTRA_TV_EXTENDER = "android.tv.EXTENSIONS";
        private static final int FLAG_AVAILABLE_ON_TV = 1;
        private static final String TAG = "TvExtender";
        private String mChannelId;
        private PendingIntent mContentIntent;
        private PendingIntent mDeleteIntent;
        private int mFlags;
        private boolean mSuppressShowOverApps;

        public TvExtender() {
            this.mFlags = 1;
        }

        @NonNull
        public Builder extend(@NonNull Builder builder) {
            if (Build.VERSION.SDK_INT < 26) {
                return builder;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(EXTRA_FLAGS, this.mFlags);
            bundle.putString(EXTRA_CHANNEL_ID, this.mChannelId);
            bundle.putBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS, this.mSuppressShowOverApps);
            PendingIntent pendingIntent = this.mContentIntent;
            if (pendingIntent != null) {
                bundle.putParcelable(EXTRA_CONTENT_INTENT, pendingIntent);
            }
            PendingIntent pendingIntent2 = this.mDeleteIntent;
            if (pendingIntent2 != null) {
                bundle.putParcelable(EXTRA_DELETE_INTENT, pendingIntent2);
            }
            builder.getExtras().putBundle(EXTRA_TV_EXTENDER, bundle);
            return builder;
        }

        @Nullable
        public String getChannelId() {
            return this.mChannelId;
        }

        @Nullable
        public PendingIntent getContentIntent() {
            return this.mContentIntent;
        }

        @Nullable
        public PendingIntent getDeleteIntent() {
            return this.mDeleteIntent;
        }

        public boolean isAvailableOnTv() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean isSuppressShowOverApps() {
            return this.mSuppressShowOverApps;
        }

        @NonNull
        public TvExtender setChannelId(@Nullable String str) {
            this.mChannelId = str;
            return this;
        }

        @NonNull
        public TvExtender setContentIntent(@Nullable PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        @NonNull
        public TvExtender setDeleteIntent(@Nullable PendingIntent pendingIntent) {
            this.mDeleteIntent = pendingIntent;
            return this;
        }

        @NonNull
        public TvExtender setSuppressShowOverApps(boolean z4) {
            this.mSuppressShowOverApps = z4;
            return this;
        }

        public TvExtender(@NonNull Notification notification) {
            Bundle bundle;
            if (Build.VERSION.SDK_INT >= 26) {
                Bundle bundle2 = notification.extras;
                if (bundle2 == null) {
                    bundle = null;
                } else {
                    bundle = bundle2.getBundle(EXTRA_TV_EXTENDER);
                }
                if (bundle != null) {
                    this.mFlags = bundle.getInt(EXTRA_FLAGS);
                    this.mChannelId = bundle.getString(EXTRA_CHANNEL_ID);
                    this.mSuppressShowOverApps = bundle.getBoolean(EXTRA_SUPPRESS_SHOW_OVER_APPS);
                    this.mContentIntent = (PendingIntent) bundle.getParcelable(EXTRA_CONTENT_INTENT);
                    this.mDeleteIntent = (PendingIntent) bundle.getParcelable(EXTRA_DELETE_INTENT);
                }
            }
        }
    }

    public static class MessagingStyle extends Style {
        public static final int MAXIMUM_RETAINED_MESSAGES = 25;
        private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";
        @Nullable
        private CharSequence mConversationTitle;
        private final List<Message> mHistoricMessages = new ArrayList();
        @Nullable
        private Boolean mIsGroupConversation;
        private final List<Message> mMessages = new ArrayList();
        private Person mUser;

        @RequiresApi(24)
        static class Api24Impl {
            private Api24Impl() {
            }

            @DoNotInline
            static Notification.MessagingStyle addMessage(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addMessage(message);
            }

            @DoNotInline
            static Notification.MessagingStyle createMessagingStyle(CharSequence charSequence) {
                return new Notification.MessagingStyle(charSequence);
            }

            @DoNotInline
            static Notification.MessagingStyle setConversationTitle(Notification.MessagingStyle messagingStyle, CharSequence charSequence) {
                return messagingStyle.setConversationTitle(charSequence);
            }
        }

        @RequiresApi(26)
        static class Api26Impl {
            private Api26Impl() {
            }

            @DoNotInline
            static Notification.MessagingStyle addHistoricMessage(Notification.MessagingStyle messagingStyle, Notification.MessagingStyle.Message message) {
                return messagingStyle.addHistoricMessage(message);
            }
        }

        @RequiresApi(28)
        static class Api28Impl {
            private Api28Impl() {
            }

            @DoNotInline
            static Notification.MessagingStyle createMessagingStyle(android.app.Person person) {
                return new Notification.MessagingStyle(person);
            }

            @DoNotInline
            static Notification.MessagingStyle setGroupConversation(Notification.MessagingStyle messagingStyle, boolean z4) {
                return messagingStyle.setGroupConversation(z4);
            }
        }

        MessagingStyle() {
        }

        @Nullable
        public static MessagingStyle extractMessagingStyleFromNotification(@NonNull Notification notification) {
            Style extractStyleFromNotification = Style.extractStyleFromNotification(notification);
            if (extractStyleFromNotification instanceof MessagingStyle) {
                return (MessagingStyle) extractStyleFromNotification;
            }
            return null;
        }

        @Nullable
        private Message findLatestIncomingMessage() {
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                Message message = this.mMessages.get(size);
                if (message.getPerson() != null && !TextUtils.isEmpty(message.getPerson().getName())) {
                    return message;
                }
            }
            if (this.mMessages.isEmpty()) {
                return null;
            }
            List<Message> list = this.mMessages;
            return list.get(list.size() - 1);
        }

        private boolean hasMessagesWithoutSender() {
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                Message message = this.mMessages.get(size);
                if (message.getPerson() != null && message.getPerson().getName() == null) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        private TextAppearanceSpan makeFontColorSpan(int i5) {
            return new TextAppearanceSpan((String) null, 0, 0, ColorStateList.valueOf(i5), (ColorStateList) null);
        }

        private CharSequence makeMessageLine(@NonNull Message message) {
            CharSequence charSequence;
            BidiFormatter instance = BidiFormatter.getInstance();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            CharSequence charSequence2 = "";
            if (message.getPerson() == null) {
                charSequence = charSequence2;
            } else {
                charSequence = message.getPerson().getName();
            }
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            int i5 = ViewCompat.MEASURED_STATE_MASK;
            if (isEmpty) {
                charSequence = this.mUser.getName();
                if (this.mBuilder.getColor() != 0) {
                    i5 = this.mBuilder.getColor();
                }
            }
            CharSequence unicodeWrap = instance.unicodeWrap(charSequence);
            spannableStringBuilder.append(unicodeWrap);
            spannableStringBuilder.setSpan(makeFontColorSpan(i5), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
            if (message.getText() != null) {
                charSequence2 = message.getText();
            }
            spannableStringBuilder.append("  ").append(instance.unicodeWrap(charSequence2));
            return spannableStringBuilder;
        }

        public void addCompatExtras(@NonNull Bundle bundle) {
            super.addCompatExtras(bundle);
            bundle.putCharSequence(NotificationCompat.EXTRA_SELF_DISPLAY_NAME, this.mUser.getName());
            bundle.putBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER, this.mUser.toBundle());
            bundle.putCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE, this.mConversationTitle);
            if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                bundle.putCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE, this.mConversationTitle);
            }
            if (!this.mMessages.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_MESSAGES, Message.getBundleArrayForMessages(this.mMessages));
            }
            if (!this.mHistoricMessages.isEmpty()) {
                bundle.putParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES, Message.getBundleArrayForMessages(this.mHistoricMessages));
            }
            Boolean bool = this.mIsGroupConversation;
            if (bool != null) {
                bundle.putBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION, bool.booleanValue());
            }
        }

        @NonNull
        public MessagingStyle addHistoricMessage(@Nullable Message message) {
            if (message != null) {
                this.mHistoricMessages.add(message);
                if (this.mHistoricMessages.size() > 25) {
                    this.mHistoricMessages.remove(0);
                }
            }
            return this;
        }

        @NonNull
        @Deprecated
        public MessagingStyle addMessage(@Nullable CharSequence charSequence, long j5, @Nullable CharSequence charSequence2) {
            this.mMessages.add(new Message(charSequence, j5, new Person.Builder().setName(charSequence2).build()));
            if (this.mMessages.size() > 25) {
                this.mMessages.remove(0);
            }
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            boolean z4;
            CharSequence charSequence;
            CharSequence charSequence2;
            Notification.MessagingStyle messagingStyle;
            setGroupConversation(isGroupConversation());
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 24) {
                if (i5 >= 28) {
                    messagingStyle = Api28Impl.createMessagingStyle(this.mUser.toAndroidPerson());
                } else {
                    messagingStyle = Api24Impl.createMessagingStyle(this.mUser.getName());
                }
                for (Message androidMessage : this.mMessages) {
                    Api24Impl.addMessage(l.a(messagingStyle), androidMessage.toAndroidMessage());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    for (Message androidMessage2 : this.mHistoricMessages) {
                        Api26Impl.addHistoricMessage(l.a(messagingStyle), androidMessage2.toAndroidMessage());
                    }
                }
                if (this.mIsGroupConversation.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                    Api24Impl.setConversationTitle(l.a(messagingStyle), this.mConversationTitle);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    Api28Impl.setGroupConversation(l.a(messagingStyle), this.mIsGroupConversation.booleanValue());
                }
                messagingStyle.setBuilder(notificationBuilderWithBuilderAccessor.getBuilder());
                return;
            }
            Message findLatestIncomingMessage = findLatestIncomingMessage();
            if (this.mConversationTitle != null && this.mIsGroupConversation.booleanValue()) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.mConversationTitle);
            } else if (findLatestIncomingMessage != null) {
                notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
                if (findLatestIncomingMessage.getPerson() != null) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(findLatestIncomingMessage.getPerson().getName());
                }
            }
            if (findLatestIncomingMessage != null) {
                Notification.Builder builder = notificationBuilderWithBuilderAccessor.getBuilder();
                if (this.mConversationTitle != null) {
                    charSequence2 = makeMessageLine(findLatestIncomingMessage);
                } else {
                    charSequence2 = findLatestIncomingMessage.getText();
                }
                builder.setContentText(charSequence2);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.mConversationTitle != null || hasMessagesWithoutSender()) {
                z4 = true;
            } else {
                z4 = false;
            }
            for (int size = this.mMessages.size() - 1; size >= 0; size--) {
                Message message = this.mMessages.get(size);
                if (z4) {
                    charSequence = makeMessageLine(message);
                } else {
                    charSequence = message.getText();
                }
                if (size != this.mMessages.size() - 1) {
                    spannableStringBuilder.insert(0, "\n");
                }
                spannableStringBuilder.insert(0, charSequence);
            }
            new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle((CharSequence) null).bigText(spannableStringBuilder);
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void clearCompatExtraKeys(@NonNull Bundle bundle) {
            super.clearCompatExtraKeys(bundle);
            bundle.remove(NotificationCompat.EXTRA_MESSAGING_STYLE_USER);
            bundle.remove(NotificationCompat.EXTRA_SELF_DISPLAY_NAME);
            bundle.remove(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            bundle.remove(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            bundle.remove(NotificationCompat.EXTRA_MESSAGES);
            bundle.remove(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            bundle.remove(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION);
        }

        /* access modifiers changed from: protected */
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public String getClassName() {
            return TEMPLATE_CLASS_NAME;
        }

        @Nullable
        public CharSequence getConversationTitle() {
            return this.mConversationTitle;
        }

        @NonNull
        public List<Message> getHistoricMessages() {
            return this.mHistoricMessages;
        }

        @NonNull
        public List<Message> getMessages() {
            return this.mMessages;
        }

        @NonNull
        public Person getUser() {
            return this.mUser;
        }

        @Deprecated
        @Nullable
        public CharSequence getUserDisplayName() {
            return this.mUser.getName();
        }

        public boolean isGroupConversation() {
            Builder builder = this.mBuilder;
            if (builder == null || builder.mContext.getApplicationInfo().targetSdkVersion >= 28 || this.mIsGroupConversation != null) {
                Boolean bool = this.mIsGroupConversation;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } else if (this.mConversationTitle != null) {
                return true;
            } else {
                return false;
            }
        }

        /* access modifiers changed from: protected */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void restoreFromCompatExtras(@NonNull Bundle bundle) {
            super.restoreFromCompatExtras(bundle);
            this.mMessages.clear();
            if (bundle.containsKey(NotificationCompat.EXTRA_MESSAGING_STYLE_USER)) {
                this.mUser = Person.fromBundle(bundle.getBundle(NotificationCompat.EXTRA_MESSAGING_STYLE_USER));
            } else {
                this.mUser = new Person.Builder().setName(bundle.getString(NotificationCompat.EXTRA_SELF_DISPLAY_NAME)).build();
            }
            CharSequence charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_CONVERSATION_TITLE);
            this.mConversationTitle = charSequence;
            if (charSequence == null) {
                this.mConversationTitle = bundle.getCharSequence(NotificationCompat.EXTRA_HIDDEN_CONVERSATION_TITLE);
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(NotificationCompat.EXTRA_MESSAGES);
            if (parcelableArray != null) {
                this.mMessages.addAll(Message.getMessagesFromBundleArray(parcelableArray));
            }
            Parcelable[] parcelableArray2 = bundle.getParcelableArray(NotificationCompat.EXTRA_HISTORIC_MESSAGES);
            if (parcelableArray2 != null) {
                this.mHistoricMessages.addAll(Message.getMessagesFromBundleArray(parcelableArray2));
            }
            if (bundle.containsKey(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION)) {
                this.mIsGroupConversation = Boolean.valueOf(bundle.getBoolean(NotificationCompat.EXTRA_IS_GROUP_CONVERSATION));
            }
        }

        @NonNull
        public MessagingStyle setConversationTitle(@Nullable CharSequence charSequence) {
            this.mConversationTitle = charSequence;
            return this;
        }

        @NonNull
        public MessagingStyle setGroupConversation(boolean z4) {
            this.mIsGroupConversation = Boolean.valueOf(z4);
            return this;
        }

        @Deprecated
        public MessagingStyle(@NonNull CharSequence charSequence) {
            this.mUser = new Person.Builder().setName(charSequence).build();
        }

        public static final class Message {
            static final String KEY_DATA_MIME_TYPE = "type";
            static final String KEY_DATA_URI = "uri";
            static final String KEY_EXTRAS_BUNDLE = "extras";
            static final String KEY_NOTIFICATION_PERSON = "sender_person";
            static final String KEY_PERSON = "person";
            static final String KEY_SENDER = "sender";
            static final String KEY_TEXT = "text";
            static final String KEY_TIMESTAMP = "time";
            @Nullable
            private String mDataMimeType;
            @Nullable
            private Uri mDataUri;
            private Bundle mExtras;
            @Nullable
            private final Person mPerson;
            private final CharSequence mText;
            private final long mTimestamp;

            @RequiresApi(24)
            static class Api24Impl {
                private Api24Impl() {
                }

                @DoNotInline
                static Notification.MessagingStyle.Message createMessage(CharSequence charSequence, long j5, CharSequence charSequence2) {
                    return new Notification.MessagingStyle.Message(charSequence, j5, charSequence2);
                }

                @DoNotInline
                static Notification.MessagingStyle.Message setData(Notification.MessagingStyle.Message message, String str, Uri uri) {
                    return message.setData(str, uri);
                }
            }

            @RequiresApi(28)
            static class Api28Impl {
                private Api28Impl() {
                }

                @DoNotInline
                static Parcelable castToParcelable(android.app.Person person) {
                    return person;
                }

                @DoNotInline
                static Notification.MessagingStyle.Message createMessage(CharSequence charSequence, long j5, android.app.Person person) {
                    return new Notification.MessagingStyle.Message(charSequence, j5, person);
                }
            }

            public Message(@Nullable CharSequence charSequence, long j5, @Nullable Person person) {
                this.mExtras = new Bundle();
                this.mText = charSequence;
                this.mTimestamp = j5;
                this.mPerson = person;
            }

            @NonNull
            static Bundle[] getBundleArrayForMessages(@NonNull List<Message> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    bundleArr[i5] = list.get(i5).toBundle();
                }
                return bundleArr;
            }

            @Nullable
            static Message getMessageFromBundle(@NonNull Bundle bundle) {
                Person person;
                try {
                    if (bundle.containsKey("text")) {
                        if (bundle.containsKey(KEY_TIMESTAMP)) {
                            if (bundle.containsKey(KEY_PERSON)) {
                                person = Person.fromBundle(bundle.getBundle(KEY_PERSON));
                            } else if (bundle.containsKey(KEY_NOTIFICATION_PERSON) && Build.VERSION.SDK_INT >= 28) {
                                person = Person.fromAndroidPerson(j.a(bundle.getParcelable(KEY_NOTIFICATION_PERSON)));
                            } else if (bundle.containsKey(KEY_SENDER)) {
                                person = new Person.Builder().setName(bundle.getCharSequence(KEY_SENDER)).build();
                            } else {
                                person = null;
                            }
                            Message message = new Message(bundle.getCharSequence("text"), bundle.getLong(KEY_TIMESTAMP), person);
                            if (bundle.containsKey("type") && bundle.containsKey(KEY_DATA_URI)) {
                                message.setData(bundle.getString("type"), (Uri) bundle.getParcelable(KEY_DATA_URI));
                            }
                            if (bundle.containsKey(KEY_EXTRAS_BUNDLE)) {
                                message.getExtras().putAll(bundle.getBundle(KEY_EXTRAS_BUNDLE));
                            }
                            return message;
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @NonNull
            static List<Message> getMessagesFromBundleArray(@NonNull Parcelable[] parcelableArr) {
                Message messageFromBundle;
                ArrayList arrayList = new ArrayList(parcelableArr.length);
                for (Bundle bundle : parcelableArr) {
                    if ((bundle instanceof Bundle) && (messageFromBundle = getMessageFromBundle(bundle)) != null) {
                        arrayList.add(messageFromBundle);
                    }
                }
                return arrayList;
            }

            @NonNull
            private Bundle toBundle() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.mText;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong(KEY_TIMESTAMP, this.mTimestamp);
                Person person = this.mPerson;
                if (person != null) {
                    bundle.putCharSequence(KEY_SENDER, person.getName());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable(KEY_NOTIFICATION_PERSON, Api28Impl.castToParcelable(this.mPerson.toAndroidPerson()));
                    } else {
                        bundle.putBundle(KEY_PERSON, this.mPerson.toBundle());
                    }
                }
                String str = this.mDataMimeType;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.mDataUri;
                if (uri != null) {
                    bundle.putParcelable(KEY_DATA_URI, uri);
                }
                Bundle bundle2 = this.mExtras;
                if (bundle2 != null) {
                    bundle.putBundle(KEY_EXTRAS_BUNDLE, bundle2);
                }
                return bundle;
            }

            @Nullable
            public String getDataMimeType() {
                return this.mDataMimeType;
            }

            @Nullable
            public Uri getDataUri() {
                return this.mDataUri;
            }

            @NonNull
            public Bundle getExtras() {
                return this.mExtras;
            }

            @Nullable
            public Person getPerson() {
                return this.mPerson;
            }

            @Deprecated
            @Nullable
            public CharSequence getSender() {
                Person person = this.mPerson;
                if (person == null) {
                    return null;
                }
                return person.getName();
            }

            @Nullable
            public CharSequence getText() {
                return this.mText;
            }

            public long getTimestamp() {
                return this.mTimestamp;
            }

            @NonNull
            public Message setData(@Nullable String str, @Nullable Uri uri) {
                this.mDataMimeType = str;
                this.mDataUri = uri;
                return this;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.app.Person} */
            /* JADX WARNING: type inference failed for: r3v0 */
            /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.CharSequence] */
            /* JADX WARNING: type inference failed for: r3v5 */
            /* JADX WARNING: type inference failed for: r3v6 */
            /* access modifiers changed from: package-private */
            /* JADX WARNING: Multi-variable type inference failed */
            @androidx.annotation.RequiresApi(24)
            @androidx.annotation.NonNull
            @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public android.app.Notification.MessagingStyle.Message toAndroidMessage() {
                /*
                    r6 = this;
                    androidx.core.app.Person r0 = r6.getPerson()
                    int r1 = android.os.Build.VERSION.SDK_INT
                    r2 = 28
                    r3 = 0
                    if (r1 < r2) goto L_0x001f
                    java.lang.CharSequence r1 = r6.getText()
                    long r4 = r6.getTimestamp()
                    if (r0 != 0) goto L_0x0016
                    goto L_0x001a
                L_0x0016:
                    android.app.Person r3 = r0.toAndroidPerson()
                L_0x001a:
                    android.app.Notification$MessagingStyle$Message r0 = androidx.core.app.NotificationCompat.MessagingStyle.Message.Api28Impl.createMessage(r1, r4, r3)
                    goto L_0x0032
                L_0x001f:
                    java.lang.CharSequence r1 = r6.getText()
                    long r4 = r6.getTimestamp()
                    if (r0 != 0) goto L_0x002a
                    goto L_0x002e
                L_0x002a:
                    java.lang.CharSequence r3 = r0.getName()
                L_0x002e:
                    android.app.Notification$MessagingStyle$Message r0 = androidx.core.app.NotificationCompat.MessagingStyle.Message.Api24Impl.createMessage(r1, r4, r3)
                L_0x0032:
                    java.lang.String r1 = r6.getDataMimeType()
                    if (r1 == 0) goto L_0x0043
                    java.lang.String r1 = r6.getDataMimeType()
                    android.net.Uri r2 = r6.getDataUri()
                    androidx.core.app.NotificationCompat.MessagingStyle.Message.Api24Impl.setData(r0, r1, r2)
                L_0x0043:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.MessagingStyle.Message.toAndroidMessage():android.app.Notification$MessagingStyle$Message");
            }

            @Deprecated
            public Message(@Nullable CharSequence charSequence, long j5, @Nullable CharSequence charSequence2) {
                this(charSequence, j5, new Person.Builder().setName(charSequence2).build());
            }
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable CharSequence charSequence, long j5, @Nullable Person person) {
            addMessage(new Message(charSequence, j5, person));
            return this;
        }

        @NonNull
        public MessagingStyle addMessage(@Nullable Message message) {
            if (message != null) {
                this.mMessages.add(message);
                if (this.mMessages.size() > 25) {
                    this.mMessages.remove(0);
                }
            }
            return this;
        }

        public MessagingStyle(@NonNull Person person) {
            if (!TextUtils.isEmpty(person.getName())) {
                this.mUser = person;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }
    }
}
