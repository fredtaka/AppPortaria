package com.fsct.android.appportaria.cpf;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CpfFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CpfFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private CpfFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CpfFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CpfFragmentArgs __result = new CpfFragmentArgs();
    bundle.setClassLoader(CpfFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("registroKey")) {
      long registroKey;
      registroKey = bundle.getLong("registroKey");
      __result.arguments.put("registroKey", registroKey);
    } else {
      throw new IllegalArgumentException("Required argument \"registroKey\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CpfFragmentArgs fromSavedStateHandle(@NonNull SavedStateHandle savedStateHandle) {
    CpfFragmentArgs __result = new CpfFragmentArgs();
    if (savedStateHandle.contains("registroKey")) {
      long registroKey;
      registroKey = savedStateHandle.get("registroKey");
      __result.arguments.put("registroKey", registroKey);
    } else {
      throw new IllegalArgumentException("Required argument \"registroKey\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public long getRegistroKey() {
    return (long) arguments.get("registroKey");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("registroKey")) {
      long registroKey = (long) arguments.get("registroKey");
      __result.putLong("registroKey", registroKey);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("registroKey")) {
      long registroKey = (long) arguments.get("registroKey");
      __result.set("registroKey", registroKey);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    CpfFragmentArgs that = (CpfFragmentArgs) object;
    if (arguments.containsKey("registroKey") != that.arguments.containsKey("registroKey")) {
      return false;
    }
    if (getRegistroKey() != that.getRegistroKey()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (int)(getRegistroKey() ^ (getRegistroKey() >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "CpfFragmentArgs{"
        + "registroKey=" + getRegistroKey()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull CpfFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(long registroKey) {
      this.arguments.put("registroKey", registroKey);
    }

    @NonNull
    public CpfFragmentArgs build() {
      CpfFragmentArgs result = new CpfFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setRegistroKey(long registroKey) {
      this.arguments.put("registroKey", registroKey);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    public long getRegistroKey() {
      return (long) arguments.get("registroKey");
    }
  }
}
