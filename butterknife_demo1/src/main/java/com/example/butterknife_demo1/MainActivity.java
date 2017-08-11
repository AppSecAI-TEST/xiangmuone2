package com.example.butterknife_demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注解：为了提高开发效率，为了提高程序效率
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.tv2)
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }
    @OnClick({R.id.tv,R.id.tv2})
    void translate(View view){

        switch (view.getId()){
            case R.id.tv:
                tv.setText("变形成功");
                Toast.makeText(MainActivity.this,"aaa",Toast.LENGTH_SHORT).show();
                break;

            case R.id.tv2:
                tv2.setText("变形也成功了");
                Toast.makeText(MainActivity.this,"bbb",Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
