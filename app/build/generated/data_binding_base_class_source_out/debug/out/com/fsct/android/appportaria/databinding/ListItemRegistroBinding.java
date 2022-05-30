// Generated by data binding compiler. Do not edit!
package com.fsct.android.appportaria.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.fsct.android.appportaria.R;
import com.fsct.android.appportaria.database.Registro;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ListItemRegistroBinding extends ViewDataBinding {
  @NonNull
  public final TextView nomeAchado;

  @NonNull
  public final TextView registroEntrada;

  @NonNull
  public final TextView registroSaida;

  @Bindable
  protected Registro mEntradasaida;

  protected ListItemRegistroBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView nomeAchado, TextView registroEntrada, TextView registroSaida) {
    super(_bindingComponent, _root, _localFieldCount);
    this.nomeAchado = nomeAchado;
    this.registroEntrada = registroEntrada;
    this.registroSaida = registroSaida;
  }

  public abstract void setEntradasaida(@Nullable Registro entradasaida);

  @Nullable
  public Registro getEntradasaida() {
    return mEntradasaida;
  }

  @NonNull
  public static ListItemRegistroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.list_item_registro, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ListItemRegistroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ListItemRegistroBinding>inflateInternal(inflater, R.layout.list_item_registro, root, attachToRoot, component);
  }

  @NonNull
  public static ListItemRegistroBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.list_item_registro, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ListItemRegistroBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ListItemRegistroBinding>inflateInternal(inflater, R.layout.list_item_registro, null, false, component);
  }

  public static ListItemRegistroBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ListItemRegistroBinding bind(@NonNull View view, @Nullable Object component) {
    return (ListItemRegistroBinding)bind(component, view, R.layout.list_item_registro);
  }
}