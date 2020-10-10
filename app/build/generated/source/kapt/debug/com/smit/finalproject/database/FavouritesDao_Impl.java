package com.smit.finalproject.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FavouritesDao_Impl implements FavouritesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavouritesEntity> __insertionAdapterOfFavouritesEntity;

  private final EntityDeletionOrUpdateAdapter<FavouritesEntity> __deletionAdapterOfFavouritesEntity;

  public FavouritesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavouritesEntity = new EntityInsertionAdapter<FavouritesEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Favourites` (`restaurant_id`,`resName`,`resRating`,`resCost`,`resImage`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouritesEntity value) {
        if (value.getRestaurant_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getRestaurant_id());
        }
        if (value.getResName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getResName());
        }
        if (value.getResRating() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getResRating());
        }
        if (value.getResCost() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getResCost());
        }
        if (value.getResImage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getResImage());
        }
      }
    };
    this.__deletionAdapterOfFavouritesEntity = new EntityDeletionOrUpdateAdapter<FavouritesEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Favourites` WHERE `restaurant_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FavouritesEntity value) {
        if (value.getRestaurant_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getRestaurant_id());
        }
      }
    };
  }

  @Override
  public void insertItem(final FavouritesEntity favouritesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFavouritesEntity.insert(favouritesEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void removeItem(final FavouritesEntity favouritesEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfFavouritesEntity.handle(favouritesEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<FavouritesEntity> getAllItems() {
    final String _sql = "SELECT * FROM favourites";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRestaurantId = CursorUtil.getColumnIndexOrThrow(_cursor, "restaurant_id");
      final int _cursorIndexOfResName = CursorUtil.getColumnIndexOrThrow(_cursor, "resName");
      final int _cursorIndexOfResRating = CursorUtil.getColumnIndexOrThrow(_cursor, "resRating");
      final int _cursorIndexOfResCost = CursorUtil.getColumnIndexOrThrow(_cursor, "resCost");
      final int _cursorIndexOfResImage = CursorUtil.getColumnIndexOrThrow(_cursor, "resImage");
      final List<FavouritesEntity> _result = new ArrayList<FavouritesEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final FavouritesEntity _item;
        final String _tmpRestaurant_id;
        _tmpRestaurant_id = _cursor.getString(_cursorIndexOfRestaurantId);
        final String _tmpResName;
        _tmpResName = _cursor.getString(_cursorIndexOfResName);
        final String _tmpResRating;
        _tmpResRating = _cursor.getString(_cursorIndexOfResRating);
        final String _tmpResCost;
        _tmpResCost = _cursor.getString(_cursorIndexOfResCost);
        final String _tmpResImage;
        _tmpResImage = _cursor.getString(_cursorIndexOfResImage);
        _item = new FavouritesEntity(_tmpRestaurant_id,_tmpResName,_tmpResRating,_tmpResCost,_tmpResImage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public FavouritesEntity getResById(final String resId) {
    final String _sql = "SELECT * FROM favourites WHERE restaurant_id= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (resId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, resId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRestaurantId = CursorUtil.getColumnIndexOrThrow(_cursor, "restaurant_id");
      final int _cursorIndexOfResName = CursorUtil.getColumnIndexOrThrow(_cursor, "resName");
      final int _cursorIndexOfResRating = CursorUtil.getColumnIndexOrThrow(_cursor, "resRating");
      final int _cursorIndexOfResCost = CursorUtil.getColumnIndexOrThrow(_cursor, "resCost");
      final int _cursorIndexOfResImage = CursorUtil.getColumnIndexOrThrow(_cursor, "resImage");
      final FavouritesEntity _result;
      if(_cursor.moveToFirst()) {
        final String _tmpRestaurant_id;
        _tmpRestaurant_id = _cursor.getString(_cursorIndexOfRestaurantId);
        final String _tmpResName;
        _tmpResName = _cursor.getString(_cursorIndexOfResName);
        final String _tmpResRating;
        _tmpResRating = _cursor.getString(_cursorIndexOfResRating);
        final String _tmpResCost;
        _tmpResCost = _cursor.getString(_cursorIndexOfResCost);
        final String _tmpResImage;
        _tmpResImage = _cursor.getString(_cursorIndexOfResImage);
        _result = new FavouritesEntity(_tmpRestaurant_id,_tmpResName,_tmpResRating,_tmpResCost,_tmpResImage);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
