package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvNote;
    EditText etNote;
    RadioGroup rg;
    RadioButton rb;
    Button btnInsertNote, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = findViewById(R.id.editTextNote);
        rg = findViewById(R.id.radioGroupStars);
        btnInsertNote = findViewById(R.id.buttonInsertNote);
        btnShowList = findViewById(R.id.buttonShowList);

        btnInsertNote.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int selectedButtonId = rg.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertNote(etNote.getText().toString(), rb.getText());
                db.close();
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
