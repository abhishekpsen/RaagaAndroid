package com.abhishekpsen.raagaandroid;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

	private DBAssetHelper db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		db = new DBAssetHelper(this);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, db.getAllRaagas());

		getListView().setAdapter(adapter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		db.close();
	}

}