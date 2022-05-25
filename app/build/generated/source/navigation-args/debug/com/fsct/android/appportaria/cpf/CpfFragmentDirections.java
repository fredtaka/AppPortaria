package com.fsct.android.appportaria.cpf;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.fsct.android.appportaria.R;

public class CpfFragmentDirections {
  private CpfFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionCpfFragmentToRegentradaFragment() {
    return new ActionOnlyNavDirections(R.id.action_cpfFragment_to_regentradaFragment);
  }
}
