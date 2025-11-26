package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class KeyFrames {
    private static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    private static final String CUSTOM_METHOD = "CustomMethod";
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        sKeyMakers = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor((Class[]) null));
            sKeyMakers.put(TypedValues.PositionType.NAME, KeyPosition.class.getConstructor((Class[]) null));
            sKeyMakers.put(TypedValues.CycleType.NAME, KeyCycle.class.getConstructor((Class[]) null));
            sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor((Class[]) null));
            sKeyMakers.put(TypedValues.TriggerType.NAME, KeyTrigger.class.getConstructor((Class[]) null));
        } catch (NoSuchMethodException e5) {
            Log.e(TAG, "unable to load", e5);
        }
    }

    public KeyFrames() {
    }

    static String name(int i5, Context context) {
        return context.getResources().getResourceEntryName(i5);
    }

    public void addAllFrames(MotionController motionController) {
        ArrayList arrayList = this.mFramesMap.get(-1);
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
    }

    public void addFrames(MotionController motionController) {
        ArrayList arrayList = this.mFramesMap.get(Integer.valueOf(motionController.mId));
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
        ArrayList arrayList2 = this.mFramesMap.get(-1);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList2.get(i5);
                i5++;
                Key key = (Key) obj;
                if (key.matches(((ConstraintLayout.LayoutParams) motionController.mView.getLayoutParams()).constraintTag)) {
                    motionController.addKey(key);
                }
            }
        }
    }

    public void addKey(Key key) {
        if (!this.mFramesMap.containsKey(Integer.valueOf(key.mTargetId))) {
            this.mFramesMap.put(Integer.valueOf(key.mTargetId), new ArrayList());
        }
        ArrayList arrayList = this.mFramesMap.get(Integer.valueOf(key.mTargetId));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i5) {
        return this.mFramesMap.get(Integer.valueOf(i5));
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KeyFrames(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            r8 = this;
            java.lang.String r0 = "Error parsing XML resource"
            java.lang.String r1 = "KeyFrames"
            r8.<init>()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r8.mFramesMap = r2
            int r2 = r10.getEventType()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r3 = 0
        L_0x0013:
            r4 = 1
            if (r2 == r4) goto L_0x00f9
            r5 = 3
            r6 = 2
            if (r2 == r6) goto L_0x0032
            if (r2 == r5) goto L_0x001e
            goto L_0x00ec
        L_0x001e:
            java.lang.String r2 = "KeyFrameSet"
            java.lang.String r4 = r10.getName()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            boolean r2 = r2.equals(r4)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            if (r2 == 0) goto L_0x00ec
            goto L_0x00f9
        L_0x002c:
            r9 = move-exception
            goto L_0x00f2
        L_0x002f:
            r9 = move-exception
            goto L_0x00f6
        L_0x0032:
            java.lang.String r2 = r10.getName()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<? extends androidx.constraintlayout.motion.widget.Key>> r7 = sKeyMakers     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            boolean r7 = r7.containsKey(r2)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            if (r7 == 0) goto L_0x00c9
            int r3 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r7 = 4
            switch(r3) {
                case -300573030: goto L_0x006f;
                case -298435811: goto L_0x0065;
                case 540053991: goto L_0x005b;
                case 1153397896: goto L_0x0051;
                case 1308496505: goto L_0x0047;
                default: goto L_0x0046;
            }     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
        L_0x0046:
            goto L_0x0079
        L_0x0047:
            java.lang.String r3 = "KeyTrigger"
            boolean r3 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            if (r3 == 0) goto L_0x0079
            r3 = r7
            goto L_0x007a
        L_0x0051:
            java.lang.String r3 = "KeyPosition"
            boolean r3 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            if (r3 == 0) goto L_0x0079
            r3 = r4
            goto L_0x007a
        L_0x005b:
            java.lang.String r3 = "KeyCycle"
            boolean r3 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            if (r3 == 0) goto L_0x0079
            r3 = r6
            goto L_0x007a
        L_0x0065:
            java.lang.String r3 = "KeyAttribute"
            boolean r3 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            if (r3 == 0) goto L_0x0079
            r3 = 0
            goto L_0x007a
        L_0x006f:
            java.lang.String r3 = "KeyTimeCycle"
            boolean r3 = r2.equals(r3)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            if (r3 == 0) goto L_0x0079
            r3 = r5
            goto L_0x007a
        L_0x0079:
            r3 = -1
        L_0x007a:
            if (r3 == 0) goto L_0x00b8
            if (r3 == r4) goto L_0x00b2
            if (r3 == r6) goto L_0x00ac
            if (r3 == r5) goto L_0x00a6
            if (r3 != r7) goto L_0x008a
            androidx.constraintlayout.motion.widget.KeyTrigger r2 = new androidx.constraintlayout.motion.widget.KeyTrigger     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            goto L_0x00bd
        L_0x008a:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r10.<init>()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            java.lang.String r3 = "Key "
            r10.append(r3)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r10.append(r2)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            java.lang.String r2 = " not found"
            r10.append(r2)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            java.lang.String r10 = r10.toString()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r9.<init>(r10)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            throw r9     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
        L_0x00a6:
            androidx.constraintlayout.motion.widget.KeyTimeCycle r2 = new androidx.constraintlayout.motion.widget.KeyTimeCycle     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            goto L_0x00bd
        L_0x00ac:
            androidx.constraintlayout.motion.widget.KeyCycle r2 = new androidx.constraintlayout.motion.widget.KeyCycle     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            goto L_0x00bd
        L_0x00b2:
            androidx.constraintlayout.motion.widget.KeyPosition r2 = new androidx.constraintlayout.motion.widget.KeyPosition     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            goto L_0x00bd
        L_0x00b8:
            androidx.constraintlayout.motion.widget.KeyAttributes r2 = new androidx.constraintlayout.motion.widget.KeyAttributes     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
        L_0x00bd:
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r10)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r2.load(r9, r3)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r8.addKey(r2)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            r3 = r2
            goto L_0x00ec
        L_0x00c9:
            java.lang.String r4 = "CustomAttribute"
            boolean r4 = r2.equalsIgnoreCase(r4)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            if (r4 == 0) goto L_0x00db
            if (r3 == 0) goto L_0x00ec
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r2 = r3.mCustomConstraints     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            if (r2 == 0) goto L_0x00ec
            androidx.constraintlayout.widget.ConstraintAttribute.parse(r9, r10, r2)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            goto L_0x00ec
        L_0x00db:
            java.lang.String r4 = "CustomMethod"
            boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            if (r2 == 0) goto L_0x00ec
            if (r3 == 0) goto L_0x00ec
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r2 = r3.mCustomConstraints     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            if (r2 == 0) goto L_0x00ec
            androidx.constraintlayout.widget.ConstraintAttribute.parse(r9, r10, r2)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
        L_0x00ec:
            int r2 = r10.next()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x002c }
            goto L_0x0013
        L_0x00f2:
            android.util.Log.e(r1, r0, r9)
            goto L_0x00f9
        L_0x00f6:
            android.util.Log.e(r1, r0, r9)
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyFrames.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
