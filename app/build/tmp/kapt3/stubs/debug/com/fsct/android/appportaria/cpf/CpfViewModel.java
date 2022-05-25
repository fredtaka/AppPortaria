package com.fsct.android.appportaria.cpf;

import java.lang.System;

/**
 * ViewModel for CpfFragment.
 *
 * @param registroKey The key of the current night we are working on.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/fsct/android/appportaria/cpf/CpfViewModel;", "Landroidx/lifecycle/ViewModel;", "registroKey", "", "dataSource", "Lcom/fsct/android/appportaria/database/RegistroDatabaseDao;", "(JLcom/fsct/android/appportaria/database/RegistroDatabaseDao;)V", "_navigateToRegentrada", "Landroidx/lifecycle/MutableLiveData;", "", "database", "getDatabase", "()Lcom/fsct/android/appportaria/database/RegistroDatabaseDao;", "navigateToRegentrada", "Landroidx/lifecycle/LiveData;", "getNavigateToRegentrada", "()Landroidx/lifecycle/LiveData;", "doneNavigating", "", "onSetSleepQuality", "quality", "", "app_debug"})
public final class CpfViewModel extends androidx.lifecycle.ViewModel {
    private final long registroKey = 0L;
    
    /**
     * Hold a reference to RegistroDatabase via its RegistroDatabaseDao.
     */
    @org.jetbrains.annotations.NotNull()
    private final com.fsct.android.appportaria.database.RegistroDatabaseDao database = null;
    
    /**
     * Variable that tells the fragment whether it should navigate to [SleepTrackerFragment].
     *
     * This is `private` because we don't want to expose the ability to set [MutableLiveData] to
     * the [Fragment]
     */
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _navigateToRegentrada = null;
    
    public CpfViewModel(long registroKey, @org.jetbrains.annotations.NotNull()
    com.fsct.android.appportaria.database.RegistroDatabaseDao dataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fsct.android.appportaria.database.RegistroDatabaseDao getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getNavigateToRegentrada() {
        return null;
    }
    
    /**
     * Call this immediately after navigating to [SleepTrackerFragment]
     */
    public final void doneNavigating() {
    }
    
    /**
     * Sets the sleep quality and updates the database.
     *
     * Then navigates back to the RegentradaFragment.
     */
    public final void onSetSleepQuality(int quality) {
    }
}