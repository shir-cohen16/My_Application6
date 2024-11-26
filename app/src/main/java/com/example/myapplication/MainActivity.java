package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = findViewById(R.id.tvTime);
        Button btnPickTime = findViewById(R.id.btnPickTime);

        btnPickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // קבלת הזמן הנוכחי
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                // יצירת דיאלוג לבחירת זמן
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        (view, selectedHour, selectedMinute) -> {
                            // עדכון ה-TextView עם הזמן שנבחר
                            String time = String.format("%02d:%02d", selectedHour, selectedMinute);
                            tvTime.setText(time);
                        }, hour, minute, true);

                // הצגת הדיאלוג
                timePickerDialog.show();
            }
        });
    }
}