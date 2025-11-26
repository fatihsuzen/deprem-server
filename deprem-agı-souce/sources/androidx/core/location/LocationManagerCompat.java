package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.GnssMeasurementsEvent;
import android.location.GnssMeasurementsEvent$Callback;
import android.location.GnssStatus;
import android.location.GnssStatus$Callback;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import j$.util.Objects;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class LocationManagerCompat {
    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5;
    private static Field sContextField;
    private static Method sGnssRequestBuilderBuildMethod;
    private static Class<?> sGnssRequestBuilderClass;
    @GuardedBy("sLocationListeners")
    static final WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> sLocationListeners = new WeakHashMap<>();
    private static Method sRegisterGnssMeasurementsCallbackMethod;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean registerGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
            return locationManager.registerGnssMeasurementsCallback(gnssMeasurementsEvent$Callback);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static boolean registerGnssStatusCallback(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
            boolean z4;
            if (handler != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4);
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                try {
                    PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap.get(callback);
                    if (preRGnssStatusTransport == null) {
                        preRGnssStatusTransport = new PreRGnssStatusTransport(callback);
                    } else {
                        preRGnssStatusTransport.unregister();
                    }
                    preRGnssStatusTransport.register(executor);
                    if (!locationManager.registerGnssStatusCallback(preRGnssStatusTransport, handler)) {
                        return false;
                    }
                    simpleArrayMap.put(callback, preRGnssStatusTransport);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @DoNotInline
        static void unregisterGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
            locationManager.unregisterGnssMeasurementsCallback(gnssMeasurementsEvent$Callback);
        }

        @DoNotInline
        static void unregisterGnssStatusCallback(LocationManager locationManager, Object obj) {
            if (obj instanceof PreRGnssStatusTransport) {
                ((PreRGnssStatusTransport) obj).unregister();
            }
            locationManager.unregisterGnssStatusCallback((GnssStatus$Callback) obj);
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean registerGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback, @NonNull Handler handler) {
            return locationManager.registerGnssMeasurementsCallback(gnssMeasurementsEvent$Callback, handler);
        }
    }

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static String getGnssHardwareModelName(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        @DoNotInline
        static int getGnssYearOfHardware(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        @DoNotInline
        static boolean isLocationEnabled(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesExecutorMethod;

        private Api30Impl() {
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static void getCurrentLocation(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
            Objects.requireNonNull(consumer);
            locationManager.getCurrentLocation(str, cancellationSignal, executor, new s(consumer));
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static boolean registerGnssStatusCallback(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                try {
                    GnssStatusTransport gnssStatusTransport = (GnssStatusTransport) simpleArrayMap.get(callback);
                    if (gnssStatusTransport == null) {
                        gnssStatusTransport = new GnssStatusTransport(callback);
                    }
                    if (!locationManager.registerGnssStatusCallback(executor, gnssStatusTransport)) {
                        return false;
                    }
                    simpleArrayMap.put(callback, gnssStatusTransport);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @DoNotInline
        public static boolean tryRequestLocationUpdates(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, Executor executor, LocationListenerCompat locationListenerCompat) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    if (sLocationRequestClass == null) {
                        sLocationRequestClass = Class.forName("android.location.LocationRequest");
                    }
                    if (sRequestLocationUpdatesExecutorMethod == null) {
                        Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, Executor.class, LocationListener.class});
                        sRequestLocationUpdatesExecutorMethod = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                    if (locationRequest != null) {
                        sRequestLocationUpdatesExecutorMethod.invoke(locationManager, new Object[]{locationRequest, executor, locationListenerCompat});
                        return true;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
                }
            }
            return false;
        }
    }

    @RequiresApi(31)
    private static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean hasProvider(LocationManager locationManager, @NonNull String str) {
            return locationManager.hasProvider(str);
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean registerGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
            return locationManager.registerGnssMeasurementsCallback(executor, gnssMeasurementsEvent$Callback);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static void requestLocationUpdates(LocationManager locationManager, @NonNull String str, @NonNull LocationRequest locationRequest, @NonNull Executor executor, @NonNull LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    private static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler = new Handler(Looper.getMainLooper());
        @Nullable
        Runnable mTimeoutRunnable;
        @GuardedBy("this")
        private boolean mTriggered;

        CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
            this.mLocationManager = locationManager;
            this.mExecutor = executor;
            this.mConsumer = consumer;
        }

        public static /* synthetic */ void a(CancellableLocationListener cancellableLocationListener) {
            cancellableLocationListener.mTimeoutRunnable = null;
            cancellableLocationListener.onLocationChanged((Location) null);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        private void cleanup() {
            this.mConsumer = null;
            this.mLocationManager.removeUpdates(this);
            Runnable runnable = this.mTimeoutRunnable;
            if (runnable != null) {
                this.mTimeoutHandler.removeCallbacks(runnable);
                this.mTimeoutRunnable = null;
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void cancel() {
            synchronized (this) {
                try {
                    if (!this.mTriggered) {
                        this.mTriggered = true;
                        cleanup();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@Nullable Location location) {
            synchronized (this) {
                try {
                    if (!this.mTriggered) {
                        this.mTriggered = true;
                        this.mExecutor.execute(new u(this.mConsumer, location));
                        cleanup();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@NonNull String str) {
            onLocationChanged((Location) null);
        }

        public void onProviderEnabled(@NonNull String str) {
        }

        public void onStatusChanged(String str, int i5, Bundle bundle) {
        }

        @SuppressLint({"MissingPermission"})
        public void startTimeout(long j5) {
            synchronized (this) {
                try {
                    if (!this.mTriggered) {
                        t tVar = new t(this);
                        this.mTimeoutRunnable = tVar;
                        this.mTimeoutHandler.postDelayed(tVar, j5);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static class GnssListenersHolder {
        @GuardedBy("sGnssMeasurementListeners")
        static final SimpleArrayMap<GnssMeasurementsEvent$Callback, GnssMeasurementsEvent$Callback> sGnssMeasurementListeners = new SimpleArrayMap<>();
        @GuardedBy("sGnssStatusListeners")
        static final SimpleArrayMap<Object, Object> sGnssStatusListeners = new SimpleArrayMap<>();

        private GnssListenersHolder() {
        }
    }

    @RequiresApi(24)
    private static class GnssMeasurementsTransport extends GnssMeasurementsEvent$Callback {
        final GnssMeasurementsEvent$Callback mCallback;
        @Nullable
        volatile Executor mExecutor;

        GnssMeasurementsTransport(@NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback, @NonNull Executor executor) {
            this.mCallback = gnssMeasurementsEvent$Callback;
            this.mExecutor = executor;
        }

        public static /* synthetic */ void a(GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (gnssMeasurementsTransport.mExecutor == executor) {
                gnssMeasurementsTransport.mCallback.onGnssMeasurementsReceived(gnssMeasurementsEvent);
            }
        }

        public static /* synthetic */ void b(GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, int i5) {
            if (gnssMeasurementsTransport.mExecutor == executor) {
                gnssMeasurementsTransport.mCallback.onStatusChanged(i5);
            }
        }

        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new x(this, executor, gnssMeasurementsEvent));
            }
        }

        public void onStatusChanged(int i5) {
            Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new y(this, executor, i5));
            }
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    @RequiresApi(30)
    private static class GnssStatusTransport extends GnssStatus$Callback {
        final GnssStatusCompat.Callback mCallback;

        GnssStatusTransport(GnssStatusCompat.Callback callback) {
            boolean z4;
            if (callback != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "invalid null callback");
            this.mCallback = callback;
        }

        public void onFirstFix(int i5) {
            this.mCallback.onFirstFix(i5);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
        }

        public void onStarted() {
            this.mCallback.onStarted();
        }

        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    private static class GpsStatusTransport implements GpsStatus.Listener {
        final GnssStatusCompat.Callback mCallback;
        @Nullable
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            boolean z4;
            if (callback != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback;
        }

        public static /* synthetic */ void a(GpsStatusTransport gpsStatusTransport, Executor executor) {
            if (gpsStatusTransport.mExecutor == executor) {
                gpsStatusTransport.mCallback.onStopped();
            }
        }

        public static /* synthetic */ void b(GpsStatusTransport gpsStatusTransport, Executor executor) {
            if (gpsStatusTransport.mExecutor == executor) {
                gpsStatusTransport.mCallback.onStarted();
            }
        }

        public static /* synthetic */ void c(GpsStatusTransport gpsStatusTransport, Executor executor, int i5) {
            if (gpsStatusTransport.mExecutor == executor) {
                gpsStatusTransport.mCallback.onFirstFix(i5);
            }
        }

        public static /* synthetic */ void d(GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
            if (gpsStatusTransport.mExecutor == executor) {
                gpsStatusTransport.mCallback.onSatelliteStatusChanged(gnssStatusCompat);
            }
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i5) {
            GpsStatus gpsStatus;
            Executor executor = this.mExecutor;
            if (executor != null) {
                if (i5 == 1) {
                    executor.execute(new z(this, executor));
                } else if (i5 == 2) {
                    executor.execute(new A(this, executor));
                } else if (i5 == 3) {
                    GpsStatus gpsStatus2 = this.mLocationManager.getGpsStatus((GpsStatus) null);
                    if (gpsStatus2 != null) {
                        executor.execute(new B(this, executor, gpsStatus2.getTimeToFirstFix()));
                    }
                } else if (i5 == 4 && (gpsStatus = this.mLocationManager.getGpsStatus((GpsStatus) null)) != null) {
                    executor.execute(new C(this, executor, GnssStatusCompat.wrap(gpsStatus)));
                }
            }
        }

        public void register(Executor executor) {
            boolean z4;
            if (this.mExecutor == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkState(z4);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private static final class InlineHandlerExecutor implements Executor {
        private final Handler mHandler;

        InlineHandlerExecutor(@NonNull Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        public void execute(@NonNull Runnable runnable) {
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                runnable.run();
            } else if (!this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }

    private static class LocationListenerKey {
        final LocationListenerCompat mListener;
        final String mProvider;

        LocationListenerKey(String str, LocationListenerCompat locationListenerCompat) {
            this.mProvider = (String) ObjectsCompat.requireNonNull(str, "invalid null provider");
            this.mListener = (LocationListenerCompat) ObjectsCompat.requireNonNull(locationListenerCompat, "invalid null listener");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LocationListenerKey)) {
                return false;
            }
            LocationListenerKey locationListenerKey = (LocationListenerKey) obj;
            if (!this.mProvider.equals(locationListenerKey.mProvider) || !this.mListener.equals(locationListenerKey.mListener)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mProvider, this.mListener);
        }
    }

    @RequiresApi(24)
    private static class PreRGnssStatusTransport extends GnssStatus$Callback {
        final GnssStatusCompat.Callback mCallback;
        @Nullable
        volatile Executor mExecutor;

        PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            boolean z4;
            if (callback != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "invalid null callback");
            this.mCallback = callback;
        }

        public static /* synthetic */ void a(PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
            if (preRGnssStatusTransport.mExecutor == executor) {
                preRGnssStatusTransport.mCallback.onStopped();
            }
        }

        public static /* synthetic */ void b(PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i5) {
            if (preRGnssStatusTransport.mExecutor == executor) {
                preRGnssStatusTransport.mCallback.onFirstFix(i5);
            }
        }

        public static /* synthetic */ void c(PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
            if (preRGnssStatusTransport.mExecutor == executor) {
                preRGnssStatusTransport.mCallback.onStarted();
            }
        }

        public static /* synthetic */ void d(PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
            if (preRGnssStatusTransport.mExecutor == executor) {
                preRGnssStatusTransport.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(gnssStatus));
            }
        }

        public void onFirstFix(int i5) {
            Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new J(this, executor, i5));
            }
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new K(this, executor, gnssStatus));
            }
        }

        public void onStarted() {
            Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new M(this, executor));
            }
        }

        public void onStopped() {
            Executor executor = this.mExecutor;
            if (executor != null) {
                executor.execute(new L(this, executor));
            }
        }

        public void register(Executor executor) {
            boolean z4;
            boolean z5 = false;
            if (executor != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "invalid null executor");
            if (this.mExecutor == null) {
                z5 = true;
            }
            Preconditions.checkState(z5);
            this.mExecutor = executor;
        }

        public void unregister() {
            this.mExecutor = null;
        }
    }

    private LocationManagerCompat() {
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @Deprecated
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable androidx.core.os.CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        getCurrentLocation(locationManager, str, cancellationSignal != null ? (CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, executor, consumer);
    }

    @Nullable
    public static String getGnssHardwareModelName(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssHardwareModelName(locationManager);
        }
        return null;
    }

    public static int getGnssYearOfHardware(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getGnssYearOfHardware(locationManager);
        }
        return 0;
    }

    public static boolean hasProvider(@NonNull LocationManager locationManager, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.hasProvider(locationManager, str);
        }
        if (locationManager.getAllProviders().contains(str)) {
            return true;
        }
        try {
            if (locationManager.getProvider(str) != null) {
                return true;
            }
            return false;
        } catch (SecurityException unused) {
        }
    }

    public static boolean isLocationEnabled(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.isLocationEnabled(locationManager);
        }
        if (locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps")) {
            return true;
        }
        return false;
    }

    @RequiresApi(24)
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback, @NonNull Handler handler) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 > 30) {
            return Api24Impl.registerGnssMeasurementsCallback(locationManager, gnssMeasurementsEvent$Callback, handler);
        }
        if (i5 == 30) {
            return registerGnssMeasurementsCallbackOnR(locationManager, ExecutorCompat.create(handler), gnssMeasurementsEvent$Callback);
        }
        SimpleArrayMap<GnssMeasurementsEvent$Callback, GnssMeasurementsEvent$Callback> simpleArrayMap = GnssListenersHolder.sGnssMeasurementListeners;
        synchronized (simpleArrayMap) {
            try {
                unregisterGnssMeasurementsCallback(locationManager, gnssMeasurementsEvent$Callback);
                if (!Api24Impl.registerGnssMeasurementsCallback(locationManager, gnssMeasurementsEvent$Callback, handler)) {
                    return false;
                }
                simpleArrayMap.put(gnssMeasurementsEvent$Callback, gnssMeasurementsEvent$Callback);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RequiresApi(30)
    private static boolean registerGnssMeasurementsCallbackOnR(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        if (Build.VERSION.SDK_INT == 30) {
            try {
                if (sGnssRequestBuilderClass == null) {
                    sGnssRequestBuilderClass = Class.forName("android.location.GnssRequest$Builder");
                }
                if (sGnssRequestBuilderBuildMethod == null) {
                    Method declaredMethod = sGnssRequestBuilderClass.getDeclaredMethod("build", (Class[]) null);
                    sGnssRequestBuilderBuildMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                if (sRegisterGnssMeasurementsCallbackMethod == null) {
                    Method declaredMethod2 = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", new Class[]{Class.forName("android.location.GnssRequest"), Executor.class, o.a()});
                    sRegisterGnssMeasurementsCallbackMethod = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                Object invoke = sRegisterGnssMeasurementsCallbackMethod.invoke(locationManager, new Object[]{sGnssRequestBuilderBuildMethod.invoke(sGnssRequestBuilderClass.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null), (Object[]) null), executor, gnssMeasurementsEvent$Callback});
                if (invoke == null || !((Boolean) invoke).booleanValue()) {
                    return false;
                }
                return true;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            }
        } else {
            throw new IllegalStateException();
        }
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
        }
        return registerGnssStatusCallback(locationManager, (Executor) new InlineHandlerExecutor(handler), callback);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @GuardedBy("sLocationListeners")
    static void registerLocationListenerTransport(LocationManager locationManager, LocationListenerTransport locationListenerTransport) {
        LocationListenerTransport locationListenerTransport2;
        WeakReference put = sLocationListeners.put(locationListenerTransport.getKey(), new WeakReference(locationListenerTransport));
        if (put != null) {
            locationListenerTransport2 = (LocationListenerTransport) put.get();
        } else {
            locationListenerTransport2 = null;
        }
        if (locationListenerTransport2 != null) {
            locationListenerTransport2.unregister();
            locationManager.removeUpdates(locationListenerTransport2);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void removeUpdates(@NonNull LocationManager locationManager, @NonNull LocationListenerCompat locationListenerCompat) {
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> weakHashMap = sLocationListeners;
        synchronized (weakHashMap) {
            try {
                ArrayList arrayList = null;
                for (WeakReference<LocationListenerTransport> weakReference : weakHashMap.values()) {
                    LocationListenerTransport locationListenerTransport = (LocationListenerTransport) weakReference.get();
                    if (locationListenerTransport != null) {
                        LocationListenerKey key = locationListenerTransport.getKey();
                        if (key.mListener == locationListenerCompat) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(key);
                            locationListenerTransport.unregister();
                            locationManager.removeUpdates(locationListenerTransport);
                        }
                    }
                }
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        i5++;
                        sLocationListeners.remove((LocationListenerKey) obj);
                    }
                }
            } finally {
                while (true) {
                }
            }
        }
        locationManager.removeUpdates(locationListenerCompat);
    }

    /* JADX INFO: finally extract failed */
    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull Executor executor, @NonNull LocationListenerCompat locationListenerCompat) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 31) {
            Api31Impl.requestLocationUpdates(locationManager, str, locationRequestCompat.toLocationRequest(), executor, locationListenerCompat);
        } else if (i5 < 30 || !Api30Impl.tryRequestLocationUpdates(locationManager, str, locationRequestCompat, executor, locationListenerCompat)) {
            LocationListenerTransport locationListenerTransport = new LocationListenerTransport(new LocationListenerKey(str, locationListenerCompat), executor);
            if (!Api19Impl.tryRequestLocationUpdates(locationManager, str, locationRequestCompat, locationListenerTransport)) {
                synchronized (sLocationListeners) {
                    try {
                        LocationManager locationManager2 = locationManager;
                        locationManager2.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerTransport, Looper.getMainLooper());
                        registerLocationListenerTransport(locationManager2, locationListenerTransport);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    @RequiresApi(24)
    public static void unregisterGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api24Impl.unregisterGnssMeasurementsCallback(locationManager, gnssMeasurementsEvent$Callback);
            return;
        }
        SimpleArrayMap<GnssMeasurementsEvent$Callback, GnssMeasurementsEvent$Callback> simpleArrayMap = GnssListenersHolder.sGnssMeasurementListeners;
        synchronized (simpleArrayMap) {
            try {
                GnssMeasurementsEvent$Callback a5 = C0312n.a(simpleArrayMap.remove(gnssMeasurementsEvent$Callback));
                if (a5 != null) {
                    if (a5 instanceof GnssMeasurementsTransport) {
                        ((GnssMeasurementsTransport) a5).unregister();
                    }
                    Api24Impl.unregisterGnssMeasurementsCallback(locationManager, a5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void unregisterGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 24) {
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                try {
                    Object remove = simpleArrayMap.remove(callback);
                    if (remove != null) {
                        Api24Impl.unregisterGnssStatusCallback(locationManager, remove);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        SimpleArrayMap<Object, Object> simpleArrayMap2 = GnssListenersHolder.sGnssStatusListeners;
        synchronized (simpleArrayMap2) {
            try {
                GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) simpleArrayMap2.remove(callback);
                if (gpsStatusTransport != null) {
                    gpsStatusTransport.unregister();
                    locationManager.removeGpsStatusListener(gpsStatusTransport);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static class LocationListenerTransport implements LocationListener {
        final Executor mExecutor;
        @Nullable
        volatile LocationListenerKey mKey;

        LocationListenerTransport(@Nullable LocationListenerKey locationListenerKey, Executor executor) {
            this.mKey = locationListenerKey;
            this.mExecutor = executor;
        }

        public static /* synthetic */ void a(LocationListenerTransport locationListenerTransport, String str) {
            LocationListenerKey locationListenerKey = locationListenerTransport.mKey;
            if (locationListenerKey != null) {
                locationListenerKey.mListener.onProviderEnabled(str);
            }
        }

        public static /* synthetic */ void b(LocationListenerTransport locationListenerTransport, String str, int i5, Bundle bundle) {
            LocationListenerKey locationListenerKey = locationListenerTransport.mKey;
            if (locationListenerKey != null) {
                locationListenerKey.mListener.onStatusChanged(str, i5, bundle);
            }
        }

        public static /* synthetic */ void c(LocationListenerTransport locationListenerTransport, Location location) {
            LocationListenerKey locationListenerKey = locationListenerTransport.mKey;
            if (locationListenerKey != null) {
                locationListenerKey.mListener.onLocationChanged(location);
            }
        }

        public static /* synthetic */ void d(LocationListenerTransport locationListenerTransport, List list) {
            LocationListenerKey locationListenerKey = locationListenerTransport.mKey;
            if (locationListenerKey != null) {
                locationListenerKey.mListener.onLocationChanged(list);
            }
        }

        public static /* synthetic */ void e(LocationListenerTransport locationListenerTransport, String str) {
            LocationListenerKey locationListenerKey = locationListenerTransport.mKey;
            if (locationListenerKey != null) {
                locationListenerKey.mListener.onProviderDisabled(str);
            }
        }

        public static /* synthetic */ void f(LocationListenerTransport locationListenerTransport, int i5) {
            LocationListenerKey locationListenerKey = locationListenerTransport.mKey;
            if (locationListenerKey != null) {
                locationListenerKey.mListener.onFlushComplete(i5);
            }
        }

        public LocationListenerKey getKey() {
            return (LocationListenerKey) ObjectsCompat.requireNonNull(this.mKey);
        }

        public void onFlushComplete(int i5) {
            if (this.mKey != null) {
                this.mExecutor.execute(new H(this, i5));
            }
        }

        public void onLocationChanged(@NonNull Location location) {
            if (this.mKey != null) {
                this.mExecutor.execute(new G(this, location));
            }
        }

        public void onProviderDisabled(@NonNull String str) {
            if (this.mKey != null) {
                this.mExecutor.execute(new E(this, str));
            }
        }

        public void onProviderEnabled(@NonNull String str) {
            if (this.mKey != null) {
                this.mExecutor.execute(new D(this, str));
            }
        }

        public void onStatusChanged(String str, int i5, Bundle bundle) {
            if (this.mKey != null) {
                this.mExecutor.execute(new I(this, str, i5, bundle));
            }
        }

        public void unregister() {
            this.mKey = null;
        }

        public void onLocationChanged(@NonNull List<Location> list) {
            if (this.mKey != null) {
                this.mExecutor.execute(new F(this, list));
            }
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void getCurrentLocation(@NonNull LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.getCurrentLocation(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation == null || SystemClock.elapsedRealtime() - LocationCompat.getElapsedRealtimeMillis(lastKnownLocation) >= 10000) {
            CancellableLocationListener cancellableLocationListener = new CancellableLocationListener(locationManager, executor, consumer);
            locationManager.requestLocationUpdates(str, 0, 0.0f, cancellableLocationListener, Looper.getMainLooper());
            if (cancellationSignal != null) {
                cancellationSignal.setOnCancelListener(new q(cancellableLocationListener));
            }
            cancellableLocationListener.startTimeout(30000);
            return;
        }
        executor.execute(new p(consumer, lastKnownLocation));
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssStatusCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return registerGnssStatusCallback(locationManager, (Handler) null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return registerGnssStatusCallback(locationManager, new Handler(myLooper), executor, callback);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0081, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0096, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0097 */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cd A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e2 A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00eb A[SYNTHETIC, Splitter:B:74:0x00eb] */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean registerGnssStatusCallback(android.location.LocationManager r9, android.os.Handler r10, java.util.concurrent.Executor r11, androidx.core.location.GnssStatusCompat.Callback r12) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L_0x000b
            boolean r9 = androidx.core.location.LocationManagerCompat.Api30Impl.registerGnssStatusCallback(r9, r10, r11, r12)
            return r9
        L_0x000b:
            r1 = 24
            if (r0 < r1) goto L_0x0014
            boolean r9 = androidx.core.location.LocationManagerCompat.Api24Impl.registerGnssStatusCallback(r9, r10, r11, r12)
            return r9
        L_0x0014:
            r0 = 0
            r1 = 1
            if (r10 == 0) goto L_0x001a
            r2 = r1
            goto L_0x001b
        L_0x001a:
            r2 = r0
        L_0x001b:
            androidx.core.util.Preconditions.checkArgument(r2)
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r2 = androidx.core.location.LocationManagerCompat.GnssListenersHolder.sGnssStatusListeners
            monitor-enter(r2)
            java.lang.Object r3 = r2.get(r12)     // Catch:{ all -> 0x002f }
            androidx.core.location.LocationManagerCompat$GpsStatusTransport r3 = (androidx.core.location.LocationManagerCompat.GpsStatusTransport) r3     // Catch:{ all -> 0x002f }
            if (r3 != 0) goto L_0x0032
            androidx.core.location.LocationManagerCompat$GpsStatusTransport r3 = new androidx.core.location.LocationManagerCompat$GpsStatusTransport     // Catch:{ all -> 0x002f }
            r3.<init>(r9, r12)     // Catch:{ all -> 0x002f }
            goto L_0x0035
        L_0x002f:
            r9 = move-exception
            goto L_0x010a
        L_0x0032:
            r3.unregister()     // Catch:{ all -> 0x002f }
        L_0x0035:
            r3.register(r11)     // Catch:{ all -> 0x002f }
            java.util.concurrent.FutureTask r11 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x002f }
            androidx.core.location.r r4 = new androidx.core.location.r     // Catch:{ all -> 0x002f }
            r4.<init>(r9, r3)     // Catch:{ all -> 0x002f }
            r11.<init>(r4)     // Catch:{ all -> 0x002f }
            android.os.Looper r9 = android.os.Looper.myLooper()     // Catch:{ all -> 0x002f }
            android.os.Looper r4 = r10.getLooper()     // Catch:{ all -> 0x002f }
            if (r9 != r4) goto L_0x0050
            r11.run()     // Catch:{ all -> 0x002f }
            goto L_0x0056
        L_0x0050:
            boolean r9 = r10.post(r11)     // Catch:{ all -> 0x002f }
            if (r9 == 0) goto L_0x00f3
        L_0x0056:
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x00ac, TimeoutException -> 0x00aa }
            r4 = 5
            long r4 = r9.toNanos(r4)     // Catch:{ ExecutionException -> 0x00ac, TimeoutException -> 0x00aa }
            long r6 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x00ac, TimeoutException -> 0x00aa }
            long r6 = r6 + r4
            r9 = r0
        L_0x0064:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            java.lang.Object r4 = r11.get(r4, r8)     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            boolean r4 = r4.booleanValue()     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            if (r4 == 0) goto L_0x008c
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r4 = androidx.core.location.LocationManagerCompat.GnssListenersHolder.sGnssStatusListeners     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            r4.put(r12, r3)     // Catch:{ InterruptedException -> 0x0097, ExecutionException -> 0x0089, TimeoutException -> 0x0086, all -> 0x0082 }
            if (r9 == 0) goto L_0x0080
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002f }
            r9.interrupt()     // Catch:{ all -> 0x002f }
        L_0x0080:
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            return r1
        L_0x0082:
            r10 = move-exception
            r0 = r9
            goto L_0x00e9
        L_0x0086:
            r11 = move-exception
            r0 = r9
            goto L_0x00ae
        L_0x0089:
            r10 = move-exception
            r0 = r9
            goto L_0x00c5
        L_0x008c:
            if (r9 == 0) goto L_0x0095
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002f }
            r9.interrupt()     // Catch:{ all -> 0x002f }
        L_0x0095:
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            return r0
        L_0x0097:
            long r4 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x00a5, TimeoutException -> 0x00a2, all -> 0x009f }
            long r4 = r6 - r4
            r9 = r1
            goto L_0x0064
        L_0x009f:
            r10 = move-exception
            r0 = r1
            goto L_0x00e9
        L_0x00a2:
            r11 = move-exception
            r0 = r1
            goto L_0x00ae
        L_0x00a5:
            r10 = move-exception
            r0 = r1
            goto L_0x00c5
        L_0x00a8:
            r10 = move-exception
            goto L_0x00e9
        L_0x00aa:
            r11 = move-exception
            goto L_0x00ae
        L_0x00ac:
            r10 = move-exception
            goto L_0x00c5
        L_0x00ae:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a8 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a8 }
            r12.<init>()     // Catch:{ all -> 0x00a8 }
            r12.append(r10)     // Catch:{ all -> 0x00a8 }
            java.lang.String r10 = " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread"
            r12.append(r10)     // Catch:{ all -> 0x00a8 }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x00a8 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x00a8 }
            throw r9     // Catch:{ all -> 0x00a8 }
        L_0x00c5:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a8 }
            boolean r9 = r9 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x00a8 }
            if (r9 != 0) goto L_0x00e2
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a8 }
            boolean r9 = r9 instanceof java.lang.Error     // Catch:{ all -> 0x00a8 }
            if (r9 == 0) goto L_0x00dc
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a8 }
            java.lang.Error r9 = (java.lang.Error) r9     // Catch:{ all -> 0x00a8 }
            throw r9     // Catch:{ all -> 0x00a8 }
        L_0x00dc:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a8 }
            r9.<init>(r10)     // Catch:{ all -> 0x00a8 }
            throw r9     // Catch:{ all -> 0x00a8 }
        L_0x00e2:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a8 }
            java.lang.RuntimeException r9 = (java.lang.RuntimeException) r9     // Catch:{ all -> 0x00a8 }
            throw r9     // Catch:{ all -> 0x00a8 }
        L_0x00e9:
            if (r0 == 0) goto L_0x00f2
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002f }
            r9.interrupt()     // Catch:{ all -> 0x002f }
        L_0x00f2:
            throw r10     // Catch:{ all -> 0x002f }
        L_0x00f3:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002f }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x002f }
            r11.<init>()     // Catch:{ all -> 0x002f }
            r11.append(r10)     // Catch:{ all -> 0x002f }
            java.lang.String r10 = " is shutting down"
            r11.append(r10)     // Catch:{ all -> 0x002f }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x002f }
            r9.<init>(r10)     // Catch:{ all -> 0x002f }
            throw r9     // Catch:{ all -> 0x002f }
        L_0x010a:
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.location.LocationManagerCompat.registerGnssStatusCallback(android.location.LocationManager, android.os.Handler, java.util.concurrent.Executor, androidx.core.location.GnssStatusCompat$Callback):boolean");
    }

    @RequiresApi(24)
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean registerGnssMeasurementsCallback(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent$Callback gnssMeasurementsEvent$Callback) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 > 30) {
            return Api31Impl.registerGnssMeasurementsCallback(locationManager, executor, gnssMeasurementsEvent$Callback);
        }
        if (i5 == 30) {
            return registerGnssMeasurementsCallbackOnR(locationManager, executor, gnssMeasurementsEvent$Callback);
        }
        SimpleArrayMap<GnssMeasurementsEvent$Callback, GnssMeasurementsEvent$Callback> simpleArrayMap = GnssListenersHolder.sGnssMeasurementListeners;
        synchronized (simpleArrayMap) {
            try {
                GnssMeasurementsTransport gnssMeasurementsTransport = new GnssMeasurementsTransport(gnssMeasurementsEvent$Callback, executor);
                unregisterGnssMeasurementsCallback(locationManager, gnssMeasurementsEvent$Callback);
                if (!Api24Impl.registerGnssMeasurementsCallback(locationManager, gnssMeasurementsTransport)) {
                    return false;
                }
                simpleArrayMap.put(gnssMeasurementsEvent$Callback, gnssMeasurementsTransport);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static class Api19Impl {
        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesLooperMethod;

        private Api19Impl() {
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        static boolean tryRequestLocationUpdates(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerTransport locationListenerTransport) {
            try {
                if (sLocationRequestClass == null) {
                    sLocationRequestClass = Class.forName("android.location.LocationRequest");
                }
                if (sRequestLocationUpdatesLooperMethod == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});
                    sRequestLocationUpdatesLooperMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    synchronized (LocationManagerCompat.sLocationListeners) {
                        sRequestLocationUpdatesLooperMethod.invoke(locationManager, new Object[]{locationRequest, locationListenerTransport, Looper.getMainLooper()});
                        LocationManagerCompat.registerLocationListenerTransport(locationManager, locationListenerTransport);
                    }
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }

        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        static boolean tryRequestLocationUpdates(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerCompat locationListenerCompat, Looper looper) {
            try {
                if (sLocationRequestClass == null) {
                    sLocationRequestClass = Class.forName("android.location.LocationRequest");
                }
                if (sRequestLocationUpdatesLooperMethod == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{sLocationRequestClass, LocationListener.class, Looper.class});
                    sRequestLocationUpdatesLooperMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest locationRequest = locationRequestCompat.toLocationRequest(str);
                if (locationRequest != null) {
                    sRequestLocationUpdatesLooperMethod.invoke(locationManager, new Object[]{locationRequest, locationListenerCompat, looper});
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void requestLocationUpdates(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull LocationListenerCompat locationListenerCompat, @NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.requestLocationUpdates(locationManager, str, locationRequestCompat.toLocationRequest(), ExecutorCompat.create(new Handler(looper)), locationListenerCompat);
        } else if (!Api19Impl.tryRequestLocationUpdates(locationManager, str, locationRequestCompat, locationListenerCompat, looper)) {
            locationManager.requestLocationUpdates(str, locationRequestCompat.getIntervalMillis(), locationRequestCompat.getMinUpdateDistanceMeters(), locationListenerCompat, looper);
        }
    }
}
