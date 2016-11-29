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

public class Register extends AppCompatActivity {

    TextView txtUsername;
    TextView txtPassword;
    TextView txtConfirmPassword;
    TextView txtEmail;
    TextView txtName;
    Button btnRegister;
    ImageView togglePassword;
    ImageView toggleConfirmPassword;
    Intent intent;
    boolean showPass;
    boolean showConfPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtName = (EditText) findViewById(R.id.txtName);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        togglePassword = (ImageView) findViewById(R.id.togglePassword);
        toggleConfirmPassword = (ImageView) findViewById(R.id.toggleConfirmPassword);

        showPass = false;
        showConfPass = false;

        togglePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showPass == false){
                    txtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showPass = true;
                } else {
                    txtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    showPass = false;
                }
            }
        });

        toggleConfirmPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showConfPass == false){
                    txtConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showConfPass = true;
                } else {
                    txtConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    showConfPass = false;
                }
            }
        });
    }

    public void register (View v){
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        String confirmPassword = txtConfirmPassword.getText().toString();
        String name = txtName.getText().toString();
        String email = txtEmail.getText().toString();

        if (username.matches("") || password.matches("") || confirmPassword.matches("") || name.matches("") || email.matches("")){
            Toast.makeText(getApplicationContext(), "Lengkapi telebih dahulu Isisan yang ada", Toast.LENGTH_SHORT).show();
        } else if (!password.matches(confirmPassword)){
            Toast.makeText(getApplicationContext(), "Password dan Confirm Password tidak sama", Toast.LENGTH_SHORT).show();
        } else {
            intent = new Intent(this, Login.class);
            startActivity(intent);
        }
    }
}
