package com.msaggik.languagetranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText textIn; // переводимое слово или фраза
    private TextView textOut; // переведённое слово или фраза

    private static HashMap<String, String> ruIt = new HashMap<>();
    private static HashMap<String, String> itRu = new HashMap<>();

    String radioValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textIn = findViewById(R.id.textIn);
        textOut = findViewById(R.id.textOut);
        RadioButton btnRuIt = findViewById(R.id.radioButtonItRu);

        RadioButton btnItRu = findViewById(R.id.radioButtonRuIt);
        Button btn = findViewById(R.id.button);

        dataInfo();

        View.OnClickListener listenerRadio = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioBtn = (RadioButton) view;

                if (radioBtn.getId() == R.id.radioButtonRuIt) {
                    radioValue = "ru";
                } else if (radioBtn.getId() == R.id.radioButtonItRu) {
                    radioValue = "it";
                } else {
                    radioValue = "empty";
                }
            }
        };

        btnRuIt.setOnClickListener(listenerRadio);
        btnItRu.setOnClickListener(listenerRadio);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataIn = textIn.getText().toString();
                String translation = null;

                switch (radioValue) {
                    case "ru":
                        translation = ruIt.get(dataIn);
                        break;
                    case "en":
                        translation = itRu.get(dataIn);
                        break;
                }

                if (translation != null) {
                    textOut.setText(translation);
                } else {
                    textOut.setText("В словаре такого слова не нашлось");
                }
            }
        });
    }

    public static void dataInfo() {
        ruIt.put("я","Io"); ////
        ruIt.put("ты","TU");
        ruIt.put("он","lui");
        ruIt.put("она","lei");
        ruIt.put("мы","LORO");
        ruIt.put("они","CIAO");
        ruIt.put("привет","COME VA");
        ruIt.put("как дела ","CHE FARE");
        ruIt.put("КАК ПОГОДА","COME IL TEMPO");

        itRu.put("Io","я");
        itRu.put("TU","ты");
        itRu.put("lui","он");
        itRu.put("lei","она");
        itRu.put("LORO","мы");
        itRu.put("COME VA","привет");
        itRu.put("CHE FARE","как дела");
        itRu.put("COME IL TEMPO","КАК ПОГОДА"); //можно ещё добавить слова
    }
}
