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
public final class CartDao_Impl implements CartDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CartEntity> __insertionAdapterOfCartEntity;

  private final EntityDeletionOrUpdateAdapter<CartEntity> __deletionAdapterOfCartEntity;

  public CartDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCartEntity = new EntityInsertionAdapter<CartEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Cart` (`itemId`,`itemName`,`itemCost`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CartEntity value) {
        if (value.getItemId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getItemId());
        }
        if (value.getItemName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getItemName());
        }
        if (value.getItemCost() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getItemCost());
        }
      }
    };
    this.__deletionAdapterOfCartEntity = new EntityDeletionOrUpdateAdapter<CartEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Cart` WHERE `itemId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CartEntity value) {
        if (value.getItemId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getItemId());
        }
      }
    };
  }

  @Override
  public void insertItem(final CartEntity cartEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCartEntity.insert(cartEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void removeItem(final CartEntity cartEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCartEntity.handle(cartEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<CartEntity> getAllItems() {
    final String _sql = "SELECT * FROM cart";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemId");
      final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
      final int _cursorIndexOfItemCost = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCost");
      final List<CartEntity> _result = new ArrayList<CartEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final CartEntity _item;
        final String _tmpItemId;
        _tmpItemId = _cursor.getString(_cursorIndexOfItemId);
        final String _tmpItemName;
        _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
        final String _tmpItemCost;
        _tmpItemCost = _cursor.getString(_cursorIndexOfItemCost);
        _item = new CartEntity(_tmpItemId,_tmpItemName,_tmpItemCost);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public CartEntity getItemById(final String itemId) {
    final String _sql = "SELECT * FROM cart WHERE itemId= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (itemId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, itemId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfItemId = CursorUtil.getColumnIndexOrThrow(_cursor, "itemId");
      final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
      final int _cursorIndexOfItemCost = CursorUtil.getColumnIndexOrThrow(_cursor, "itemCost");
      final CartEntity _result;
      if(_cursor.moveToFirst()) {
        final String _tmpItemId;
        _tmpItemId = _cursor.getString(_cursorIndexOfItemId);
        final String _tmpItemName;
        _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
        final String _tmpItemCost;
        _tmpItemCost = _cursor.getString(_cursorIndexOfItemCost);
        _result = new CartEntity(_tmpItemId,_tmpItemName,_tmpItemCost);
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
