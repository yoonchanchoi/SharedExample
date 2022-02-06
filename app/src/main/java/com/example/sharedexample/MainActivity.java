package com.example.sharedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save;
    String shared = "file";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("hong", "");                 // ""은default value값이므로 값이 들어갓을때는 무시하고 sharedPreferences의 값이 들어갑니다.
        et_save.setText(value);
    }


    @Override
    protected void onDestroy() {                                                        //해당   MainActivity를 나갔을때 해당 함수를 호출
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);    //파일을 읽기모드 열는것
        SharedPreferences.Editor editor = sharedPreferences.edit();                     // Editor는 해당 SharedPreferences라는 클래스 객체의 내장 함수로 해당 객체를 수정할수 있게 해주는 함수,
        String value = et_save.getText().toString();                                    // et_save가 문자열이지만 실질적으로 문자열되기 전 단계이므로 toString()으로 문자열 변환해준다(일단 안드에서 국룰.)
        editor.putString("hong",value);
        editor.commit();                                                                // 바귄 저장소 내용을 저장
    }
}