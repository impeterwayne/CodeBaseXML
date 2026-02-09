package com.genesys.core.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.genesys.core.database.converters.TemplateListConverter;
import com.genesys.core.database.entity.TemplateCollectionsEntity;
import com.genesys.core.model.template.Template;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TemplateCollectionsDao_Impl implements TemplateCollectionsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TemplateCollectionsEntity> __insertionAdapterOfTemplateCollectionsEntity;

  private TemplateListConverter __templateListConverter;

  private final SharedSQLiteStatement __preparedStmtOfClearAllTemplateCollections;

  public TemplateCollectionsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTemplateCollectionsEntity = new EntityInsertionAdapter<TemplateCollectionsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `TemplateCollectionsEntity` (`id`,`code`,`name`,`sort`,`templates`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final TemplateCollectionsEntity entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getCode());
        statement.bindString(3, entity.getName());
        statement.bindLong(4, entity.getSort());
        final String _tmp = __templateListConverter().fromList(entity.getTemplates());
        statement.bindString(5, _tmp);
      }
    };
    this.__preparedStmtOfClearAllTemplateCollections = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM TemplateCollectionsEntity";
        return _query;
      }
    };
  }

  @Override
  public Object insertTemplateCollections(final List<TemplateCollectionsEntity> collections,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTemplateCollectionsEntity.insert(collections);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearAllTemplateCollections(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearAllTemplateCollections.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearAllTemplateCollections.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllTemplateCollections(
      final Continuation<? super List<TemplateCollectionsEntity>> $completion) {
    final String _sql = "SELECT * FROM TemplateCollectionsEntity ORDER BY sort ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<TemplateCollectionsEntity>>() {
      @Override
      @NonNull
      public List<TemplateCollectionsEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfSort = CursorUtil.getColumnIndexOrThrow(_cursor, "sort");
          final int _cursorIndexOfTemplates = CursorUtil.getColumnIndexOrThrow(_cursor, "templates");
          final List<TemplateCollectionsEntity> _result = new ArrayList<TemplateCollectionsEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TemplateCollectionsEntity _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpCode;
            _tmpCode = _cursor.getString(_cursorIndexOfCode);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final int _tmpSort;
            _tmpSort = _cursor.getInt(_cursorIndexOfSort);
            final List<Template> _tmpTemplates;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfTemplates);
            final List<Template> _tmp_1 = __templateListConverter().fromString(_tmp);
            if (_tmp_1 == null) {
              throw new IllegalStateException("Expected NON-NULL 'java.util.List<com.genesys.core.model.template.Template>', but it was NULL.");
            } else {
              _tmpTemplates = _tmp_1;
            }
            _item = new TemplateCollectionsEntity(_tmpId,_tmpCode,_tmpName,_tmpSort,_tmpTemplates);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Arrays.asList(TemplateListConverter.class);
  }

  private synchronized TemplateListConverter __templateListConverter() {
    if (__templateListConverter == null) {
      __templateListConverter = __db.getTypeConverter(TemplateListConverter.class);
    }
    return __templateListConverter;
  }
}
