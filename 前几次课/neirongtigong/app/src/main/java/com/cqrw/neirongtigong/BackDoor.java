package com.cqrw.neirongtigong;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class BackDoor extends ContentProvider {
    public BackDoor() {
    }
    Mydb db = null;
    private static final int SUCCESS=0;
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
   private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        matcher.addURI("com.cqrw.bd","cqrw",SUCCESS);
    }
    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if(matcher.match(uri)==SUCCESS){
            System.out.println(values.get("name"));
            if(db == null){
                db = new Mydb(getContext());
            }
            SQLiteDatabase sb = db.getWritableDatabase();
            sb.execSQL("insert into student(name,price) values('"+values.get("name")+"',"+values.get("price")+")");
            sb.close();
        }else{
            System.out.println("身份不对");
        }

        return null;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        System.out.println("11111");
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
