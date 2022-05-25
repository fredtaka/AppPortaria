package com.fsct.android.appportaria.databinding;
import com.fsct.android.appportaria.R;
import com.fsct.android.appportaria.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRegentradaBindingImpl extends FragmentRegentradaBinding implements com.fsct.android.appportaria.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.registro_list, 3);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRegentradaBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private FragmentRegentradaBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.Button) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[3]
            , (android.widget.Button) bindings[2]
            );
        this.entradaSaida.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.stopButton.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.fsct.android.appportaria.generated.callback.OnClickListener(this, 1);
        mCallback2 = new com.fsct.android.appportaria.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.regentradaViewModel == variableId) {
            setRegentradaViewModel((com.fsct.android.appportaria.regentradatracker.RegentradaViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRegentradaViewModel(@Nullable com.fsct.android.appportaria.regentradatracker.RegentradaViewModel RegentradaViewModel) {
        this.mRegentradaViewModel = RegentradaViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.regentradaViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeRegentradaViewModelStopButtonVisible((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
            case 1 :
                return onChangeRegentradaViewModelStartButtonVisible((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeRegentradaViewModelStopButtonVisible(androidx.lifecycle.LiveData<java.lang.Boolean> RegentradaViewModelStopButtonVisible, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRegentradaViewModelStartButtonVisible(androidx.lifecycle.LiveData<java.lang.Boolean> RegentradaViewModelStartButtonVisible, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.Boolean regentradaViewModelStartButtonVisibleGetValue = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxRegentradaViewModelStartButtonVisibleGetValue = false;
        java.lang.Boolean regentradaViewModelStopButtonVisibleGetValue = null;
        androidx.lifecycle.LiveData<java.lang.Boolean> regentradaViewModelStopButtonVisible = null;
        androidx.lifecycle.LiveData<java.lang.Boolean> regentradaViewModelStartButtonVisible = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxRegentradaViewModelStopButtonVisibleGetValue = false;
        com.fsct.android.appportaria.regentradatracker.RegentradaViewModel regentradaViewModel = mRegentradaViewModel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (regentradaViewModel != null) {
                        // read regentradaViewModel.stopButtonVisible
                        regentradaViewModelStopButtonVisible = regentradaViewModel.getStopButtonVisible();
                    }
                    updateLiveDataRegistration(0, regentradaViewModelStopButtonVisible);


                    if (regentradaViewModelStopButtonVisible != null) {
                        // read regentradaViewModel.stopButtonVisible.getValue()
                        regentradaViewModelStopButtonVisibleGetValue = regentradaViewModelStopButtonVisible.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(regentradaViewModel.stopButtonVisible.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxRegentradaViewModelStopButtonVisibleGetValue = androidx.databinding.ViewDataBinding.safeUnbox(regentradaViewModelStopButtonVisibleGetValue);
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (regentradaViewModel != null) {
                        // read regentradaViewModel.startButtonVisible
                        regentradaViewModelStartButtonVisible = regentradaViewModel.getStartButtonVisible();
                    }
                    updateLiveDataRegistration(1, regentradaViewModelStartButtonVisible);


                    if (regentradaViewModelStartButtonVisible != null) {
                        // read regentradaViewModel.startButtonVisible.getValue()
                        regentradaViewModelStartButtonVisibleGetValue = regentradaViewModelStartButtonVisible.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(regentradaViewModel.startButtonVisible.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxRegentradaViewModelStartButtonVisibleGetValue = androidx.databinding.ViewDataBinding.safeUnbox(regentradaViewModelStartButtonVisibleGetValue);
            }
        }
        // batch finished
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            this.entradaSaida.setEnabled(androidxDatabindingViewDataBindingSafeUnboxRegentradaViewModelStartButtonVisibleGetValue);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.entradaSaida.setOnClickListener(mCallback1);
            this.stopButton.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.stopButton.setEnabled(androidxDatabindingViewDataBindingSafeUnboxRegentradaViewModelStopButtonVisibleGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // regentradaViewModel != null
                boolean regentradaViewModelJavaLangObjectNull = false;
                // regentradaViewModel
                com.fsct.android.appportaria.regentradatracker.RegentradaViewModel regentradaViewModel = mRegentradaViewModel;



                regentradaViewModelJavaLangObjectNull = (regentradaViewModel) != (null);
                if (regentradaViewModelJavaLangObjectNull) {


                    regentradaViewModel.onEntradaSaida();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // regentradaViewModel != null
                boolean regentradaViewModelJavaLangObjectNull = false;
                // regentradaViewModel
                com.fsct.android.appportaria.regentradatracker.RegentradaViewModel regentradaViewModel = mRegentradaViewModel;



                regentradaViewModelJavaLangObjectNull = (regentradaViewModel) != (null);
                if (regentradaViewModelJavaLangObjectNull) {


                    regentradaViewModel.onStop();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): regentradaViewModel.stopButtonVisible
        flag 1 (0x2L): regentradaViewModel.startButtonVisible
        flag 2 (0x3L): regentradaViewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}