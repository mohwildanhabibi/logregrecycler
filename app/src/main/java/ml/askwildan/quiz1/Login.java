package ml.askwildan.quiz1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText txtUsername;
    EditText txtPassword;
    TextView txtRegister;
    Button btnLogin;
    ImageView togglePassword;
    Intent intent;
    boolean showPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtRegister = (TextView) findViewById(R.id.txtRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        togglePassword = (ImageView) findViewById(R.id.togglePassword);
        showPass = false;
    }

    public void login (View v){
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        if (username.matches("135150201111228") && password.matches("wildan")){
            intent = new Intent(this, MainRecycler.class);
            startActivity(intent);
        } else if (username.matches("") || password.matches("")) {
            Toast.makeText(getApplicationContext(), "Lengkapi telebih dahulu Username atau Password", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Kombinasi Username dan Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    public void register (View v){
        intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void showHidePassword (View v){
        if (showPass == false){
            txtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            showPass = true;
        } else {
            txtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            showPass = false;
        }
    }
}
