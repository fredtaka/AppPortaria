package com.fsct.android.appportaria.databinding;
import com.fsct.android.appportaria.R;
import com.fsct.android.appportaria.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentCpfBindingImpl extends FragmentCpfBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title_text, 1);
        sViewsWithIds.put(R.id.editTextNumberCpf, 2);
        sViewsWithIds.put(R.id.consultacpfbutton, 3);
        sViewsWithIds.put(R.id.texto_barra, 4);
        sViewsWithIds.put(R.id.nome_achado, 5);
        sViewsWithIds.put(R.id.aviso_usuario, 6);
        sViewsWithIds.put(R.id.entrada_button, 7);
        sViewsWithIds.put(R.id.saida_button, 8);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentCpfBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentCpfBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[6]
            , (android.widget.Button) bindings[3]
            , (android.widget.EditText) bindings[2]
            , (android.widget.Button) bindings[7]
            , (android.widget.TextView) bindings[5]
            , (android.widget.Button) bindings[8]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.cpfViewModel == variableId) {
            setCpfViewModel((com.fsct.android.appportaria.cpf.CpfViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCpfViewModel(@Nullable com.fsct.android.appportaria.cpf.CpfViewModel CpfViewModel) {
        this.mCpfViewModel = CpfViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): cpfViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}