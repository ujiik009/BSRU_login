package followoftheking.ionic.io.authen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText user_text, pass_text;
    private Button btn_login, btn_register;
    private String str_user, str_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user_text = (EditText) findViewById(R.id.user_text);
        pass_text = (EditText) findViewById(R.id.pass_text);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"55555",Toast.LENGTH_SHORT).show();
                str_user = user_text.getText().toString().trim();
                str_pass = pass_text.getText().toString().trim();

                if(str_user.equals("") || str_pass.equals("")){
                    Toast.makeText(getApplicationContext(),"ป้อนข้อมูลไม่ครบ",Toast.LENGTH_SHORT).show();
                }else{
                    call_login call = new call_login(str_user, str_pass);
                    call.execute("http://172.19.74.40/BSRU/login.php");

                    try{
                        final String res_server = call.get();
                        JSONObject jsonObject = new JSONObject(res_server);
                        final Boolean status = jsonObject.getBoolean("status");
                        final String message = jsonObject.getString("message");

                        if(status == true){
                            Toast.makeText(getApplicationContext(),message.toString(),Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),message.toString(),Toast.LENGTH_SHORT).show();
                        }




                        Toast.makeText(getApplicationContext(),res_server.toString(),Toast.LENGTH_SHORT).show();
                    }catch (Exception e){

                    }
                }

            }
        });


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });














    }
}