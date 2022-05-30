package com.fsct.android.appportaria;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.fsct.android.appportaria.databinding.FragmentCpfBindingImpl;
import com.fsct.android.appportaria.databinding.FragmentLoginBindingImpl;
import com.fsct.android.appportaria.databinding.FragmentRegentradaBindingImpl;
import com.fsct.android.appportaria.databinding.ListItemRegistroBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTCPF = 1;

  private static final int LAYOUT_FRAGMENTLOGIN = 2;

  private static final int LAYOUT_FRAGMENTREGENTRADA = 3;

  private static final int LAYOUT_LISTITEMREGISTRO = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fsct.android.appportaria.R.layout.fragment_cpf, LAYOUT_FRAGMENTCPF);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fsct.android.appportaria.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fsct.android.appportaria.R.layout.fragment_regentrada, LAYOUT_FRAGMENTREGENTRADA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fsct.android.appportaria.R.layout.list_item_registro, LAYOUT_LISTITEMREGISTRO);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTCPF: {
          if ("layout/fragment_cpf_0".equals(tag)) {
            return new FragmentCpfBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_cpf is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREGENTRADA: {
          if ("layout/fragment_regentrada_0".equals(tag)) {
            return new FragmentRegentradaBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_regentrada is invalid. Received: " + tag);
        }
        case  LAYOUT_LISTITEMREGISTRO: {
          if ("layout/list_item_registro_0".equals(tag)) {
            return new ListItemRegistroBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for list_item_registro is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "cpfViewModel");
      sKeys.put(2, "entradasaida");
      sKeys.put(3, "regentradaViewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/fragment_cpf_0", com.fsct.android.appportaria.R.layout.fragment_cpf);
      sKeys.put("layout/fragment_login_0", com.fsct.android.appportaria.R.layout.fragment_login);
      sKeys.put("layout/fragment_regentrada_0", com.fsct.android.appportaria.R.layout.fragment_regentrada);
      sKeys.put("layout/list_item_registro_0", com.fsct.android.appportaria.R.layout.list_item_registro);
    }
  }
}
