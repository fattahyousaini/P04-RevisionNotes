package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	TextView tvNote;
	ArrayAdapter aa;
	ArrayList<Note> note;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		lv = findViewById(R.id.lv);
		tvNote = findViewById(R.id.textViewNote);

		//TODO implement the Custom ListView
		DBHelper db = new DBHelper(SecondActivity.this);
		note = db.getAllNotes();

		aa = new RevisionNotesArrayAdapter(this, R.layout.row, note);
		lv.setAdapter(aa);
	}


}
