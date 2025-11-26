package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.util.Arrays;
import java.util.Collection;
import k3.l;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class ViewModelProviders {
    public static final ViewModelProviders INSTANCE = new ViewModelProviders();
    private static final String VIEW_MODEL_PROVIDER_DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";

    private ViewModelProviders() {
    }

    public final ViewModelProvider.Factory createInitializerFactory$lifecycle_viewmodel_release(Collection<? extends ViewModelInitializer<?>> collection) {
        t.e(collection, "initializers");
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) collection.toArray(new ViewModelInitializer[0]);
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }

    public final <VM extends ViewModel> VM createViewModelFromInitializers$lifecycle_viewmodel_release(C2733c cVar, CreationExtras creationExtras, ViewModelInitializer<?>... viewModelInitializerArr) {
        VM vm;
        ViewModelInitializer<?> viewModelInitializer;
        l initializer$lifecycle_viewmodel_release;
        t.e(cVar, "modelClass");
        t.e(creationExtras, "extras");
        t.e(viewModelInitializerArr, "initializers");
        int length = viewModelInitializerArr.length;
        int i5 = 0;
        while (true) {
            vm = null;
            if (i5 >= length) {
                viewModelInitializer = null;
                break;
            }
            viewModelInitializer = viewModelInitializerArr[i5];
            if (t.a(viewModelInitializer.getClazz$lifecycle_viewmodel_release(), cVar)) {
                break;
            }
            i5++;
        }
        if (!(viewModelInitializer == null || (initializer$lifecycle_viewmodel_release = viewModelInitializer.getInitializer$lifecycle_viewmodel_release()) == null)) {
            vm = (ViewModel) initializer$lifecycle_viewmodel_release.invoke(creationExtras);
        }
        if (vm != null) {
            return vm;
        }
        throw new IllegalArgumentException(("No initializer set for given class " + CanonicalName_jvmKt.getCanonicalName(cVar)).toString());
    }

    public final CreationExtras getDefaultCreationExtras$lifecycle_viewmodel_release(ViewModelStoreOwner viewModelStoreOwner) {
        t.e(viewModelStoreOwner, "owner");
        if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            return ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras();
        }
        return CreationExtras.Empty.INSTANCE;
    }

    public final ViewModelProvider.Factory getDefaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner viewModelStoreOwner) {
        t.e(viewModelStoreOwner, "owner");
        if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            return ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory();
        }
        return DefaultViewModelProviderFactory.INSTANCE;
    }

    public final <T extends ViewModel> String getDefaultKey$lifecycle_viewmodel_release(C2733c cVar) {
        t.e(cVar, "modelClass");
        String canonicalName = CanonicalName_jvmKt.getCanonicalName(cVar);
        if (canonicalName != null) {
            return "androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final <VM extends ViewModel> VM unsupportedCreateViewModel$lifecycle_viewmodel_release() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    public final ViewModelProvider.Factory createInitializerFactory$lifecycle_viewmodel_release(ViewModelInitializer<?>... viewModelInitializerArr) {
        t.e(viewModelInitializerArr, "initializers");
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
