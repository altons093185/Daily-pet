package com.example.dailypet_0115;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class remind_addschdule_doctor extends AppCompatActivity{

}
/*
public class remind_addschdule_doctor extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener{
private Button cancel;
private Button addsch;
private Button button;
private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind_addschdule_doctor);

    }  }
        /*
        cancel = findViewById(R.id.cancel);
        addsch = findViewById(R.id.addsch);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addsch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        button = findViewById(R.id.kind);
        button2 = findViewById(R.id.kind2);

        Calendar c = Calendar.getInstance();
        updateTimeText(c);
        updateDateText(c);


        Button buttonTimePicker = findViewById(R.id.kind);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        Button buttonCancelAlarm = findViewById(R.id.cancel);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });


        Button buttonDatePicker = findViewById(R.id.kind2);
        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        updateTimeText(c);
        startAlarm(c);

    }

    private void updateTimeText(Calendar c) {

        String timeText = DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        button.setText(timeText);
    }


    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }

    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        alarmManager.cancel(pendingIntent);
        //button.setText("選擇時間");
        //button2.setText("選擇日期");
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);

        updateDateText(c);
        startAlarm(c);

    }


    private void updateDateText(Calendar c) {

        //String dateText = DateFormat.getDateInstance(DateFormat.MEDIUM).format(c.getTime());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dateText = formatter.format(c.getTime());
        button2.setText(dateText);

        //button2.setText(dateText);
    }
}



        /*
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_remind_addschdule_doctor);
        cancel = findViewById(R.id.cancel);
        addsch = findViewById(R.id.addsch);
        Button addsch=(Button)findViewById(R.id.addsch);
        addsch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EditTextTel = (EditText) findViewById(R.id.newschtitle);
                String Tel = EditTextTel.getText().toString();

                EditText EditTextTime = (EditText) findViewById(R.id.kind);
                String Time = EditTextTime.getText().toString();

                EditText EditTextRepeat = (EditText) findViewById(R.id.newschrepeat);
                String Repeat = EditTextRepeat.getText().toString();

                EditText EditTextHint = (EditText) findViewById(R.id.newschhint);
                String Hint =EditTextHint.getText().toString();

                EditText EditTextMessage = (EditText) findViewById(R.id.newschmessage);
                String Message = EditTextMessage.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("Tel", Tel);
                bundle.putString("Time", Time);
                bundle.putString("Repeat", Repeat);
                bundle.putString("Hint", Hint);
                bundle.putString("Message", Message);

                Intent intent = new Intent();
                intent.setClass(remind_addschdule_doctor.this, remind_doctor.class);
                intent.putExtras(bundle); //將Bundle物件assign給intent
                startActivity(intent);


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}*/
