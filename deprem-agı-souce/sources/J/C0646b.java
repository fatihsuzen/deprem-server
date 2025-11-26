package J;

import S.a;
import a0.C0999e;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import j$.util.Objects;
import java.lang.ref.SoftReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: J.b  reason: case insensitive filesystem */
public abstract class C0646b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static SoftReference f2617a;

    /* renamed from: b  reason: collision with root package name */
    private static SoftReference f2618b;

    private final int e(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if (Objects.equals(intent.getAction(), "com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
            c(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    /* access modifiers changed from: protected */
    public Executor a() {
        ExecutorService executorService;
        synchronized (C0646b.class) {
            try {
                SoftReference softReference = f2617a;
                if (softReference != null) {
                    executorService = (ExecutorService) softReference.get();
                } else {
                    executorService = null;
                }
                if (executorService == null) {
                    C0999e.a();
                    executorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new a("firebase-iid-executor")));
                    f2617a = new SoftReference(executorService);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    /* access modifiers changed from: protected */
    public abstract int b(Context context, C0645a aVar);

    /* access modifiers changed from: protected */
    public abstract void c(Context context, Bundle bundle);

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d(Intent intent, Context context, boolean z4, BroadcastReceiver.PendingResult pendingResult) {
        Intent intent2;
        int i5;
        Intent intent3 = intent;
        Context context2 = context;
        BroadcastReceiver.PendingResult pendingResult2 = pendingResult;
        try {
            Parcelable parcelableExtra = intent3.getParcelableExtra("wrapped_intent");
            Executor executor = null;
            if (parcelableExtra instanceof Intent) {
                intent2 = (Intent) parcelableExtra;
            } else {
                intent2 = null;
            }
            if (intent2 != null) {
                i5 = e(context2, intent2);
            } else if (intent3.getExtras() == null) {
                i5 = 500;
            } else {
                C0645a aVar = new C0645a(intent3);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                synchronized (C0646b.class) {
                    SoftReference softReference = f2618b;
                    if (softReference != null) {
                        executor = (Executor) softReference.get();
                    }
                    if (executor == null) {
                        C0999e.a();
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("pscm-ack-executor"));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        executor = Executors.unconfigurableExecutorService(threadPoolExecutor);
                        f2618b = new SoftReference(executor);
                    }
                }
                executor.execute(new o(context2, aVar, countDownLatch));
                int b5 = b(context2, aVar);
                try {
                    if (!countDownLatch.await(TimeUnit.SECONDS.toMillis(1), TimeUnit.MILLISECONDS)) {
                        Log.w("CloudMessagingReceiver", "Message ack timed out");
                    }
                } catch (InterruptedException e5) {
                    Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e5.toString()));
                }
                i5 = b5;
            }
            if (z4 && pendingResult2 != null) {
                pendingResult2.setResultCode(i5);
            }
            if (pendingResult2 != null) {
                pendingResult2.finish();
            }
        } catch (Throwable th) {
            if (pendingResult2 != null) {
                pendingResult2.finish();
            }
            throw th;
        }
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Intent intent2 = intent;
            a().execute(new p(this, intent2, context, isOrderedBroadcast(), goAsync()));
        }
    }
}
