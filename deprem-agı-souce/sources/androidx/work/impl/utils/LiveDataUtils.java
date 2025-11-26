package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LiveDataUtils {
    private LiveDataUtils() {
    }

    @SuppressLint({"LambdaLast"})
    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(LiveData<In> liveData, final Function<In, Out> function, final TaskExecutor taskExecutor) {
        final Object obj = new Object();
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<In>() {
            Out mCurrentOutput = null;

            public void onChanged(final In in) {
                TaskExecutor.this.executeOnTaskThread(new Runnable() {
                    public void run() {
                        synchronized (obj) {
                            try {
                                Out apply = function.apply(in);
                                AnonymousClass1 r22 = AnonymousClass1.this;
                                Out out = r22.mCurrentOutput;
                                if (out == null && apply != null) {
                                    r22.mCurrentOutput = apply;
                                    mediatorLiveData.postValue(apply);
                                } else if (out != null && !out.equals(apply)) {
                                    AnonymousClass1 r23 = AnonymousClass1.this;
                                    r23.mCurrentOutput = apply;
                                    mediatorLiveData.postValue(apply);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }
        });
        return mediatorLiveData;
    }
}
