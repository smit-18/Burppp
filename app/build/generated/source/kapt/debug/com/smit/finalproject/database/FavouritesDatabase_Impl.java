package com.smit.finalproject.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FavouritesDatabase_Impl extends FavouritesDatabase {
  private volatile FavouritesDao _favouritesDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Favourites` (`restaurant_id` TEXT NOT NULL, `resName` TEXT NOT NULL, `resRating` TEXT NOT NULL, `resCost` TEXT NOT NULL, `resImage` TEXT NOT NULL, PRIMARY KEY(`restaurant_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd2be196e3f2f0609a67975a7a0e55834')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Favourites`");
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
        final HashMap<String, TableInfo.Column> _columnsFavourites = new HashMap<String, TableInfo.Column>(5);
        _columnsFavourites.put("restaurant_id", new TableInfo.Column("restaurant_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavourites.put("resName", new TableInfo.Column("resName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavourites.put("resRating", new TableInfo.Column("resRating", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavourites.put("resCost", new TableInfo.Column("resCost", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavourites.put("resImage", new TableInfo.Column("resImage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFavourites = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFavourites = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavourites = new TableInfo("Favourites", _columnsFavourites, _foreignKeysFavourites, _indicesFavourites);
        final TableInfo _existingFavourites = TableInfo.read(_db, "Favourites");
        if (! _infoFavourites.equals(_existingFavourites)) {
          return new RoomOpenHelper.ValidationResult(false, "Favourites(com.smit.finalproject.database.FavouritesEntity).\n"
                  + " Expected:\n" + _infoFavourites + "\n"
                  + " Found:\n" + _existingFavourites);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "d2be196e3f2f0609a67975a7a0e55834", "6818ecaa6d904bbdd0d27b0bb06471f4");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Favourites");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Favourites`");
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
  public FavouritesDao favouritesDao() {
    if (_favouritesDao != null) {
      return _favouritesDao;
    } else {
      synchronized(this) {
        if(_favouritesDao == null) {
          _favouritesDao = new FavouritesDao_Impl(this);
        }
        return _favouritesDao;
      }
    }
  }
}
