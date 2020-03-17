package top.jsonlu.xposed.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Author:JsonLu
 * DateTime:2020/3/17 18:07
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class MainActivity extends AppCompatActivity implements OnClickListener {

    public EditText et_username;
    private EditText et_password;

    public Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        bt_login = findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                Toast.makeText(this, "password:" + et_password.getText().toString(), Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

}
