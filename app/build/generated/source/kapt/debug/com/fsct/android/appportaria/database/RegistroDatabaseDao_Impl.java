package com.fsct.android.appportaria.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RegistroDatabaseDao_Impl implements RegistroDatabaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Registro> __insertionAdapterOfRegistro;

  private final EntityDeletionOrUpdateAdapter<Registro> __updateAdapterOfRegistro;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  public RegistroDatabaseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRegistro = new EntityInsertionAdapter<Registro>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tabela_entrada_saida` (`registroId`,`cpf_pessoa`,`hora_entrada_ms`,`hora_saida_ms`,`grupo_pessoa`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Registro value) {
        stmt.bindLong(1, value.getRegistroId());
        stmt.bindLong(2, value.getCpfPessoa());
        stmt.bindLong(3, value.getHoraEntradaMs());
        stmt.bindLong(4, value.getHoraSaidaMs());
        stmt.bindLong(5, value.getGrupoPessoa());
      }
    };
    this.__updateAdapterOfRegistro = new EntityDeletionOrUpdateAdapter<Registro>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tabela_entrada_saida` SET `registroId` = ?,`cpf_pessoa` = ?,`hora_entrada_ms` = ?,`hora_saida_ms` = ?,`grupo_pessoa` = ? WHERE `registroId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Registro value) {
        stmt.bindLong(1, value.getRegistroId());
        stmt.bindLong(2, value.getCpfPessoa());
        stmt.bindLong(3, value.getHoraEntradaMs());
        stmt.bindLong(4, value.getHoraSaidaMs());
        stmt.bindLong(5, value.getGrupoPessoa());
        stmt.bindLong(6, value.getRegistroId());
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tabela_entrada_saida";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Registro evento, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRegistro.insert(evento);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final Registro evento, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfRegistro.handle(evento);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object clear(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClear.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfClear.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object get(final long key, final Continuation<? super Registro> continuation) {
    final String _sql = "SELECT * from tabela_entrada_saida WHERE registroId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, key);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Registro>() {
      @Override
      public Registro call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRegistroId = CursorUtil.getColumnIndexOrThrow(_cursor, "registroId");
          final int _cursorIndexOfCpfPessoa = CursorUtil.getColumnIndexOrThrow(_cursor, "cpf_pessoa");
          final int _cursorIndexOfHoraEntradaMs = CursorUtil.getColumnIndexOrThrow(_cursor, "hora_entrada_ms");
          final int _cursorIndexOfHoraSaidaMs = CursorUtil.getColumnIndexOrThrow(_cursor, "hora_saida_ms");
          final int _cursorIndexOfGrupoPessoa = CursorUtil.getColumnIndexOrThrow(_cursor, "grupo_pessoa");
          final Registro _result;
          if(_cursor.moveToFirst()) {
            final long _tmpRegistroId;
            _tmpRegistroId = _cursor.getLong(_cursorIndexOfRegistroId);
            final char _tmpCpfPessoa;
            _tmpCpfPessoa = (char) _cursor.getInt(_cursorIndexOfCpfPessoa);
            final long _tmpHoraEntradaMs;
            _tmpHoraEntradaMs = _cursor.getLong(_cursorIndexOfHoraEntradaMs);
            final long _tmpHoraSaidaMs;
            _tmpHoraSaidaMs = _cursor.getLong(_cursorIndexOfHoraSaidaMs);
            final int _tmpGrupoPessoa;
            _tmpGrupoPessoa = _cursor.getInt(_cursorIndexOfGrupoPessoa);
            _result = new Registro(_tmpRegistroId,_tmpCpfPessoa,_tmpHoraEntradaMs,_tmpHoraSaidaMs,_tmpGrupoPessoa);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<Registro>> getTodosRegistros() {
    final String _sql = "SELECT * FROM tabela_entrada_saida ORDER BY registroId DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tabela_entrada_saida"}, false, new Callable<List<Registro>>() {
      @Override
      public List<Registro> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRegistroId = CursorUtil.getColumnIndexOrThrow(_cursor, "registroId");
          final int _cursorIndexOfCpfPessoa = CursorUtil.getColumnIndexOrThrow(_cursor, "cpf_pessoa");
          final int _cursorIndexOfHoraEntradaMs = CursorUtil.getColumnIndexOrThrow(_cursor, "hora_entrada_ms");
          final int _cursorIndexOfHoraSaidaMs = CursorUtil.getColumnIndexOrThrow(_cursor, "hora_saida_ms");
          final int _cursorIndexOfGrupoPessoa = CursorUtil.getColumnIndexOrThrow(_cursor, "grupo_pessoa");
          final List<Registro> _result = new ArrayList<Registro>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Registro _item;
            final long _tmpRegistroId;
            _tmpRegistroId = _cursor.getLong(_cursorIndexOfRegistroId);
            final char _tmpCpfPessoa;
            _tmpCpfPessoa = (char) _cursor.getInt(_cursorIndexOfCpfPessoa);
            final long _tmpHoraEntradaMs;
            _tmpHoraEntradaMs = _cursor.getLong(_cursorIndexOfHoraEntradaMs);
            final long _tmpHoraSaidaMs;
            _tmpHoraSaidaMs = _cursor.getLong(_cursorIndexOfHoraSaidaMs);
            final int _tmpGrupoPessoa;
            _tmpGrupoPessoa = _cursor.getInt(_cursorIndexOfGrupoPessoa);
            _item = new Registro(_tmpRegistroId,_tmpCpfPessoa,_tmpHoraEntradaMs,_tmpHoraSaidaMs,_tmpGrupoPessoa);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getEsseRegistro(final Continuation<? super Registro> continuation) {
    final String _sql = "SELECT * FROM tabela_entrada_saida ORDER BY registroId DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Registro>() {
      @Override
      public Registro call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRegistroId = CursorUtil.getColumnIndexOrThrow(_cursor, "registroId");
          final int _cursorIndexOfCpfPessoa = CursorUtil.getColumnIndexOrThrow(_cursor, "cpf_pessoa");
          final int _cursorIndexOfHoraEntradaMs = CursorUtil.getColumnIndexOrThrow(_cursor, "hora_entrada_ms");
          final int _cursorIndexOfHoraSaidaMs = CursorUtil.getColumnIndexOrThrow(_cursor, "hora_saida_ms");
          final int _cursorIndexOfGrupoPessoa = CursorUtil.getColumnIndexOrThrow(_cursor, "grupo_pessoa");
          final Registro _result;
          if(_cursor.moveToFirst()) {
            final long _tmpRegistroId;
            _tmpRegistroId = _cursor.getLong(_cursorIndexOfRegistroId);
            final char _tmpCpfPessoa;
            _tmpCpfPessoa = (char) _cursor.getInt(_cursorIndexOfCpfPessoa);
            final long _tmpHoraEntradaMs;
            _tmpHoraEntradaMs = _cursor.getLong(_cursorIndexOfHoraEntradaMs);
            final long _tmpHoraSaidaMs;
            _tmpHoraSaidaMs = _cursor.getLong(_cursorIndexOfHoraSaidaMs);
            final int _tmpGrupoPessoa;
            _tmpGrupoPessoa = _cursor.getInt(_cursorIndexOfGrupoPessoa);
            _result = new Registro(_tmpRegistroId,_tmpCpfPessoa,_tmpHoraEntradaMs,_tmpHoraSaidaMs,_tmpGrupoPessoa);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
