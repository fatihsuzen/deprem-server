package androidx.window.embedding;

import W2.J;
import X2.C2250q;
import X2.T;
import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@ExperimentalWindowApi
public final class SplitController {
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public static volatile SplitController globalInstance = null;
    /* access modifiers changed from: private */
    public static final ReentrantLock globalLock = new ReentrantLock();
    public static final boolean sDebug = false;
    private final EmbeddingBackend embeddingBackend;
    private Set<? extends EmbeddingRule> staticSplitRules;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final SplitController getInstance() {
            if (SplitController.globalInstance == null) {
                ReentrantLock access$getGlobalLock$cp = SplitController.globalLock;
                access$getGlobalLock$cp.lock();
                try {
                    if (SplitController.globalInstance == null) {
                        SplitController.globalInstance = new SplitController((C2633k) null);
                    }
                    J j5 = J.f19942a;
                    access$getGlobalLock$cp.unlock();
                } catch (Throwable th) {
                    access$getGlobalLock$cp.unlock();
                    throw th;
                }
            }
            SplitController access$getGlobalInstance$cp = SplitController.globalInstance;
            t.b(access$getGlobalInstance$cp);
            return access$getGlobalInstance$cp;
        }

        public final void initialize(Context context, int i5) {
            t.e(context, "context");
            Set<EmbeddingRule> parseSplitRules$window_release = new SplitRuleParser().parseSplitRules$window_release(context, i5);
            SplitController instance = getInstance();
            if (parseSplitRules$window_release == null) {
                parseSplitRules$window_release = T.d();
            }
            instance.setStaticSplitRules(parseSplitRules$window_release);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SplitController(C2633k kVar) {
        this();
    }

    public static final SplitController getInstance() {
        return Companion.getInstance();
    }

    public static final void initialize(Context context, int i5) {
        Companion.initialize(context, i5);
    }

    /* access modifiers changed from: private */
    public final void setStaticSplitRules(Set<? extends EmbeddingRule> set) {
        this.staticSplitRules = set;
        this.embeddingBackend.setSplitRules(set);
    }

    public final void addSplitListener(Activity activity, Executor executor, Consumer<List<SplitInfo>> consumer) {
        t.e(activity, "activity");
        t.e(executor, "executor");
        t.e(consumer, "consumer");
        this.embeddingBackend.registerSplitListenerForActivity(activity, executor, consumer);
    }

    public final void clearRegisteredRules() {
        this.embeddingBackend.setSplitRules(this.staticSplitRules);
    }

    public final Set<EmbeddingRule> getSplitRules() {
        return C2250q.r0(this.embeddingBackend.getSplitRules());
    }

    public final boolean isSplitSupported() {
        return this.embeddingBackend.isSplitSupported();
    }

    public final void registerRule(EmbeddingRule embeddingRule) {
        t.e(embeddingRule, "rule");
        this.embeddingBackend.registerRule(embeddingRule);
    }

    public final void removeSplitListener(Consumer<List<SplitInfo>> consumer) {
        t.e(consumer, "consumer");
        this.embeddingBackend.unregisterSplitListenerForActivity(consumer);
    }

    public final void unregisterRule(EmbeddingRule embeddingRule) {
        t.e(embeddingRule, "rule");
        this.embeddingBackend.unregisterRule(embeddingRule);
    }

    private SplitController() {
        this.embeddingBackend = ExtensionEmbeddingBackend.Companion.getInstance();
        this.staticSplitRules = T.d();
    }
}
