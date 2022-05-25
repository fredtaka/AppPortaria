package com.fsct.android.appportaria.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RegistroDatabase_Impl extends RegistroDatabase {
  private volatile RegistroDatabaseDao _registroDatabaseDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tabela_entrada_saida` (`registroId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cpf_pessoa` INTEGER NOT NULL, `hora_entrada_ms` INTEGER NOT NULL, `hora_saida_ms` INTEGER NOT NULL, `grupo_pessoa` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ceb15cbf811a02e936788b7638df6a3d')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `tabela_entrada_saida`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTabelaEntradaSaida = new HashMap<String, TableInfo.Column>(5);
        _columnsTabelaEntradaSaida.put("registroId", new TableInfo.Column("registroId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTabelaEntradaSaida.put("cpf_pessoa", new TableInfo.Column("cpf_pessoa", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTabelaEntradaSaida.put("hora_entrada_ms", new TableInfo.Column("hora_entrada_ms", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTabelaEntradaSaida.put("hora_saida_ms", new TableInfo.Column("hora_saida_ms", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTabelaEntradaSaida.put("grupo_pessoa", new TableInfo.Column("grupo_pessoa", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTabelaEntradaSaida = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTabelaEntradaSaida = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTabelaEntradaSaida = new TableInfo("tabela_entrada_saida", _columnsTabelaEntradaSaida, _foreignKeysTabelaEntradaSaida, _indicesTabelaEntradaSaida);
        final TableInfo _existingTabelaEntradaSaida = TableInfo.read(_db, "tabela_entrada_saida");
        if (! _infoTabelaEntradaSaida.equals(_existingTabelaEntradaSaida)) {
          return new RoomOpenHelper.ValidationResult(false, "tabela_entrada_saida(com.fsct.android.appportaria.database.Registro).\n"
                  + " Expected:\n" + _infoTabelaEntradaSaida + "\n"
                  + " Found:\n" + _existingTabelaEntradaSaida);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ceb15cbf811a02e936788b7638df6a3d", "887a97ecb27878f7e1a600aaeb1c1f05");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "tabela_entrada_saida");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `tabela_entrada_saida`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(RegistroDatabaseDao.class, RegistroDatabaseDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public RegistroDatabaseDao getRegistroDatabaseDao() {
    if (_registroDatabaseDao != null) {
      return _registroDatabaseDao;
    } else {
      synchronized(this) {
        if(_registroDatabaseDao == null) {
          _registroDatabaseDao = new RegistroDatabaseDao_Impl(this);
        }
        return _registroDatabaseDao;
      }
    }
  }
}
