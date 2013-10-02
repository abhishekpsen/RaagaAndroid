package com.abhishekpsen.raagaandroid;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBAssetHelper extends SQLiteAssetHelper {

	private static final String DB_NAME = "Raaga";
	private static final int DB_VERSION = 1;

	public DBAssetHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	List<String> getAllRaagas() {
		SQLiteDatabase db = this.getReadableDatabase();
		List<String> allRaagas = new ArrayList<String>();
		Cursor mycursor = db.rawQuery("SELECT name FROM raagadetails", null);

		if (mycursor.moveToFirst()) {
			do {
				allRaagas.add(mycursor.getString(0));
			} while (mycursor.moveToNext());
		}

		mycursor.close();
		db.close();
		return allRaagas;
	}

}
