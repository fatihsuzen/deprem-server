package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    @Nullable
    private static Field sFieldsMaskField;
    @Nullable
    private static Integer sHasBearingAccuracyMask;
    @Nullable
    private static Integer sHasSpeedAccuracyMask;
    @Nullable
    private static Integer sHasVerticalAccuracyMask;
    @Nullable
    private static Method sSetIsFromMockProviderMethod;

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float getBearingAccuracyDegrees(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        @DoNotInline
        static float getSpeedAccuracyMetersPerSecond(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        @DoNotInline
        static float getVerticalAccuracyMeters(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        @DoNotInline
        static boolean hasBearingAccuracy(Location location) {
            return location.hasBearingAccuracy();
        }

        @DoNotInline
        static boolean hasSpeedAccuracy(Location location) {
            return location.hasSpeedAccuracy();
        }

        @DoNotInline
        static boolean hasVerticalAccuracy(Location location) {
            return location.hasVerticalAccuracy();
        }

        @DoNotInline
        static void removeBearingAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasBearingAccuracyMask())));
            } catch (NoSuchFieldException e5) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e5);
                throw noSuchFieldError;
            } catch (IllegalAccessException e6) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e6);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        static void removeSpeedAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasSpeedAccuracyMask())));
            } catch (NoSuchFieldException e5) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e5);
                throw noSuchFieldError;
            } catch (IllegalAccessException e6) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e6);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        static void removeVerticalAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasVerticalAccuracyMask())));
            } catch (IllegalAccessException | NoSuchFieldException e5) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e5);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        static void setBearingAccuracyDegrees(Location location, float f5) {
            location.setBearingAccuracyDegrees(f5);
        }

        @DoNotInline
        static void setSpeedAccuracyMetersPerSecond(Location location, float f5) {
            location.setSpeedAccuracyMetersPerSecond(f5);
        }

        @DoNotInline
        static void setVerticalAccuracyMeters(Location location, float f5) {
            location.setVerticalAccuracyMeters(f5);
        }
    }

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void removeBearingAccuracy(Location location) {
            Location location2 = location;
            if (location2.hasBearingAccuracy()) {
                String provider = location2.getProvider();
                long time = location2.getTime();
                long elapsedRealtimeNanos = location2.getElapsedRealtimeNanos();
                double latitude = location2.getLatitude();
                double longitude = location2.getLongitude();
                boolean hasAltitude = location2.hasAltitude();
                double altitude = location2.getAltitude();
                boolean hasSpeed = location2.hasSpeed();
                float speed = location2.getSpeed();
                boolean hasBearing = location2.hasBearing();
                boolean z4 = hasAltitude;
                float bearing = location2.getBearing();
                boolean hasAccuracy = location2.hasAccuracy();
                boolean z5 = hasSpeed;
                float accuracy = location2.getAccuracy();
                boolean hasVerticalAccuracy = location2.hasVerticalAccuracy();
                boolean z6 = hasBearing;
                float verticalAccuracyMeters = location2.getVerticalAccuracyMeters();
                boolean hasSpeedAccuracy = location2.hasSpeedAccuracy();
                float f5 = verticalAccuracyMeters;
                float speedAccuracyMetersPerSecond = location2.getSpeedAccuracyMetersPerSecond();
                Bundle extras = location2.getExtras();
                location2.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (z4) {
                    location2.setAltitude(altitude);
                }
                if (z5) {
                    location2.setSpeed(speed);
                }
                if (z6) {
                    location2.setBearing(bearing);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(accuracy);
                }
                if (hasVerticalAccuracy) {
                    location2.setVerticalAccuracyMeters(f5);
                }
                if (hasSpeedAccuracy) {
                    location2.setBearingAccuracyDegrees(speedAccuracyMetersPerSecond);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }

        @DoNotInline
        static void removeSpeedAccuracy(Location location) {
            Location location2 = location;
            if (location2.hasSpeedAccuracy()) {
                String provider = location2.getProvider();
                long time = location2.getTime();
                long elapsedRealtimeNanos = location2.getElapsedRealtimeNanos();
                double latitude = location2.getLatitude();
                double longitude = location2.getLongitude();
                boolean hasAltitude = location2.hasAltitude();
                double altitude = location2.getAltitude();
                boolean hasSpeed = location2.hasSpeed();
                float speed = location2.getSpeed();
                boolean hasBearing = location2.hasBearing();
                boolean z4 = hasAltitude;
                float bearing = location2.getBearing();
                boolean hasAccuracy = location2.hasAccuracy();
                boolean z5 = hasSpeed;
                float accuracy = location2.getAccuracy();
                boolean hasVerticalAccuracy = location2.hasVerticalAccuracy();
                boolean z6 = hasBearing;
                float verticalAccuracyMeters = location2.getVerticalAccuracyMeters();
                boolean hasBearingAccuracy = location2.hasBearingAccuracy();
                float f5 = verticalAccuracyMeters;
                float bearingAccuracyDegrees = location2.getBearingAccuracyDegrees();
                Bundle extras = location2.getExtras();
                location2.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (z4) {
                    location2.setAltitude(altitude);
                }
                if (z5) {
                    location2.setSpeed(speed);
                }
                if (z6) {
                    location2.setBearing(bearing);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(accuracy);
                }
                if (hasVerticalAccuracy) {
                    location2.setVerticalAccuracyMeters(f5);
                }
                if (hasBearingAccuracy) {
                    location2.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }

        @DoNotInline
        static void removeVerticalAccuracy(Location location) {
            Location location2 = location;
            if (location2.hasVerticalAccuracy()) {
                String provider = location2.getProvider();
                long time = location2.getTime();
                long elapsedRealtimeNanos = location2.getElapsedRealtimeNanos();
                double latitude = location2.getLatitude();
                double longitude = location2.getLongitude();
                boolean hasAltitude = location2.hasAltitude();
                double altitude = location2.getAltitude();
                boolean hasSpeed = location2.hasSpeed();
                float speed = location2.getSpeed();
                boolean hasBearing = location2.hasBearing();
                boolean z4 = hasAltitude;
                float bearing = location2.getBearing();
                boolean hasAccuracy = location2.hasAccuracy();
                boolean z5 = hasSpeed;
                float accuracy = location2.getAccuracy();
                boolean hasSpeedAccuracy = location2.hasSpeedAccuracy();
                boolean z6 = hasBearing;
                float speedAccuracyMetersPerSecond = location2.getSpeedAccuracyMetersPerSecond();
                boolean hasBearingAccuracy = location2.hasBearingAccuracy();
                float f5 = speedAccuracyMetersPerSecond;
                float bearingAccuracyDegrees = location2.getBearingAccuracyDegrees();
                Bundle extras = location2.getExtras();
                location2.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (z4) {
                    location2.setAltitude(altitude);
                }
                if (z5) {
                    location2.setSpeed(speed);
                }
                if (z6) {
                    location2.setBearing(bearing);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(accuracy);
                }
                if (hasSpeedAccuracy) {
                    location2.setSpeedAccuracyMetersPerSecond(f5);
                }
                if (hasBearingAccuracy) {
                    location2.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void removeBearingAccuracy(Location location) {
            if (location.hasBearingAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.removeBearingAccuracy(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }

        @DoNotInline
        static void removeSpeedAccuracy(Location location) {
            if (location.hasSpeedAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.removeSpeedAccuracy(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }

        @DoNotInline
        static void removeVerticalAccuracy(Location location) {
            if (location.hasVerticalAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.removeVerticalAccuracy(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }
    }

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static void removeBearingAccuracy(Location location) {
            location.removeBearingAccuracy();
        }

        @DoNotInline
        static void removeSpeedAccuracy(Location location) {
            location.removeSpeedAccuracy();
        }

        @DoNotInline
        static void removeVerticalAccuracy(Location location) {
            location.removeVerticalAccuracy();
        }
    }

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static float getMslAltitudeAccuracyMeters(Location location) {
            return location.getMslAltitudeAccuracyMeters();
        }

        @DoNotInline
        static double getMslAltitudeMeters(Location location) {
            return location.getMslAltitudeMeters();
        }

        @DoNotInline
        static boolean hasMslAltitude(Location location) {
            return location.hasMslAltitude();
        }

        @DoNotInline
        static boolean hasMslAltitudeAccuracy(Location location) {
            return location.hasMslAltitudeAccuracy();
        }

        @DoNotInline
        static void removeMslAltitude(Location location) {
            location.removeMslAltitude();
        }

        @DoNotInline
        static void removeMslAltitudeAccuracy(Location location) {
            location.removeMslAltitudeAccuracy();
        }

        @DoNotInline
        static void setMslAltitudeAccuracyMeters(Location location, float f5) {
            location.setMslAltitudeAccuracyMeters(f5);
        }

        @DoNotInline
        static void setMslAltitudeMeters(Location location, double d5) {
            location.setMslAltitudeMeters(d5);
        }
    }

    private LocationCompat() {
    }

    private static boolean containsExtra(@NonNull Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras == null || !extras.containsKey(str)) {
            return false;
        }
        return true;
    }

    public static float getBearingAccuracyDegrees(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getBearingAccuracyDegrees(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    }

    public static long getElapsedRealtimeMillis(@NonNull Location location) {
        return TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
    }

    public static long getElapsedRealtimeNanos(@NonNull Location location) {
        return location.getElapsedRealtimeNanos();
    }

    @SuppressLint({"BlockedPrivateApi"})
    static Field getFieldsMaskField() throws NoSuchFieldException {
        if (sFieldsMaskField == null) {
            Field declaredField = Location.class.getDeclaredField("mFieldsMask");
            sFieldsMaskField = declaredField;
            declaredField.setAccessible(true);
        }
        return sFieldsMaskField;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int getHasBearingAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasBearingAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasBearingAccuracyMask = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return sHasBearingAccuracyMask.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int getHasSpeedAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasSpeedAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasSpeedAccuracyMask = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return sHasSpeedAccuracyMask.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int getHasVerticalAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasVerticalAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasVerticalAccuracyMask = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return sHasVerticalAccuracyMask.intValue();
    }

    @FloatRange(from = 0.0d)
    public static float getMslAltitudeAccuracyMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getMslAltitudeAccuracyMeters(location);
        }
        return getOrCreateExtras(location).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static double getMslAltitudeMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getMslAltitudeMeters(location);
        }
        return getOrCreateExtras(location).getDouble(EXTRA_MSL_ALTITUDE);
    }

    private static Bundle getOrCreateExtras(@NonNull Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras;
        }
        location.setExtras(new Bundle());
        return location.getExtras();
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
            sSetIsFromMockProviderMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sSetIsFromMockProviderMethod;
    }

    public static float getSpeedAccuracyMetersPerSecond(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getSpeedAccuracyMetersPerSecond(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    }

    public static float getVerticalAccuracyMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getVerticalAccuracyMeters(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_VERTICAL_ACCURACY, 0.0f);
    }

    public static boolean hasBearingAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasBearingAccuracy(location);
        }
        return containsExtra(location, EXTRA_BEARING_ACCURACY);
    }

    public static boolean hasMslAltitude(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.hasMslAltitude(location);
        }
        return containsExtra(location, EXTRA_MSL_ALTITUDE);
    }

    public static boolean hasMslAltitudeAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.hasMslAltitudeAccuracy(location);
        }
        return containsExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasSpeedAccuracy(location);
        }
        return containsExtra(location, EXTRA_SPEED_ACCURACY);
    }

    public static boolean hasVerticalAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasVerticalAccuracy(location);
        }
        return containsExtra(location, EXTRA_VERTICAL_ACCURACY);
    }

    public static boolean isMock(@NonNull Location location) {
        return location.isFromMockProvider();
    }

    public static void removeBearingAccuracy(@NonNull Location location) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33) {
            Api33Impl.removeBearingAccuracy(location);
        } else if (i5 >= 29) {
            Api29Impl.removeBearingAccuracy(location);
        } else if (i5 >= 28) {
            Api28Impl.removeBearingAccuracy(location);
        } else if (i5 >= 26) {
            Api26Impl.removeBearingAccuracy(location);
        } else {
            removeExtra(location, EXTRA_BEARING_ACCURACY);
        }
    }

    private static void removeExtra(@NonNull Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            extras.remove(str);
            if (extras.isEmpty()) {
                location.setExtras((Bundle) null);
            }
        }
    }

    public static void removeMslAltitude(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.removeMslAltitude(location);
        } else {
            removeExtra(location, EXTRA_MSL_ALTITUDE);
        }
    }

    public static void removeMslAltitudeAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.removeMslAltitudeAccuracy(location);
        } else {
            removeExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
        }
    }

    public static void removeSpeedAccuracy(@NonNull Location location) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33) {
            Api33Impl.removeSpeedAccuracy(location);
        } else if (i5 >= 29) {
            Api29Impl.removeSpeedAccuracy(location);
        } else if (i5 >= 28) {
            Api28Impl.removeSpeedAccuracy(location);
        } else if (i5 >= 26) {
            Api26Impl.removeSpeedAccuracy(location);
        } else {
            removeExtra(location, EXTRA_SPEED_ACCURACY);
        }
    }

    public static void removeVerticalAccuracy(@NonNull Location location) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33) {
            Api33Impl.removeVerticalAccuracy(location);
        } else if (i5 >= 29) {
            Api29Impl.removeVerticalAccuracy(location);
        } else if (i5 >= 28) {
            Api28Impl.removeVerticalAccuracy(location);
        } else if (i5 >= 26) {
            Api26Impl.removeVerticalAccuracy(location);
        } else {
            removeExtra(location, EXTRA_VERTICAL_ACCURACY);
        }
    }

    public static void setBearingAccuracyDegrees(@NonNull Location location, float f5) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setBearingAccuracyDegrees(location, f5);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_BEARING_ACCURACY, f5);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static void setMock(@NonNull Location location, boolean z4) {
        try {
            getSetIsFromMockProviderMethod().invoke(location, new Object[]{Boolean.valueOf(z4)});
        } catch (NoSuchMethodException e5) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e5);
            throw noSuchMethodError;
        } catch (IllegalAccessException e6) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e6);
            throw illegalAccessError;
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static void setMslAltitudeAccuracyMeters(@NonNull Location location, @FloatRange(from = 0.0d) float f5) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setMslAltitudeAccuracyMeters(location, f5);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, f5);
        }
    }

    public static void setMslAltitudeMeters(@NonNull Location location, double d5) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setMslAltitudeMeters(location, d5);
        } else {
            getOrCreateExtras(location).putDouble(EXTRA_MSL_ALTITUDE, d5);
        }
    }

    public static void setSpeedAccuracyMetersPerSecond(@NonNull Location location, float f5) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setSpeedAccuracyMetersPerSecond(location, f5);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_SPEED_ACCURACY, f5);
        }
    }

    public static void setVerticalAccuracyMeters(@NonNull Location location, float f5) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setVerticalAccuracyMeters(location, f5);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_VERTICAL_ACCURACY, f5);
        }
    }
}
