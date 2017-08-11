package com.example.zuheshi_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AddSubView av;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        av = (AddSubView)findViewById(R.id.av);
        av.setMaxValue(10);
        av.setmOnNumberChangerListener(new AddSubView.OnNumberChangerListener() {
            @Override
            public void OnNumberChanger(int value) {
                //属于我自己的业务逻辑
                Toast.makeText(MainActivity.this, "变化的数量值"+value, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
