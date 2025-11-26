package androidx.lifecycle;

@Deprecated
public interface LifecycleRegistryOwner extends LifecycleOwner {
    /* bridge */ /* synthetic */ Lifecycle getLifecycle();

    LifecycleRegistry getLifecycle();
}
