package com.quickapp.emergencyaid;





import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper

{
	private static final String TABLE_NAME = "myTable1";
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_Phone = "phone";
	
	public DataBaseHelper(Context context, String name,CursorFactory factory, int version) 
    {
	           super(context, name, factory, version);
	}
	@Override
	public void onCreate(SQLiteDatabase _db) 
	{
			
			
			String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"+ KEY_Phone +" INTEGER NOT NULL)";
			_db.execSQL(CREATE_CONTACTS_TABLE);
			
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) 
	{
			Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");
	
			_db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
			
			onCreate(_db);
			
			
	}
	
	public void add(String name, String number) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put(KEY_NAME, name);
		values.put(KEY_Phone, number);
		
		db.insert(TABLE_NAME, null, values);
		db.close();

	}
	Cursor display() {
		String select = "SELECT * FROM " + TABLE_NAME;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(select, null);
		return c;
	}
	public void delete(String string) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor c=db.rawQuery("delete from "+TABLE_NAME+" where "+KEY_NAME+"='"+string+"'", null);
		
		if(c!=null){
			c.moveToFirst();
		}
		c.close();
	}
	 
	  

}
