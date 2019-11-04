package pupusas.app.pupusasyaprojectcli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONObject;
import com.loopj.android.http.*;
import cz.msebera.android.httpclient.Header;

public class SignUp extends AppCompatActivity {

    private EditText txtName, txtLastName, txtUserName, txtEmail, txtPhone, txtAddress, txtPassword, txtConfPassword;
    private EditText clave;
    private String user, pasw, url, resultado, n, a;
    private boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtName = findViewById(R.id.etNames);
        txtLastName = findViewById(R.id.etLastNames);
        txtEmail = findViewById(R.id.etEmail);
        txtPhone = findViewById(R.id.etPhone);
        txtAddress = findViewById(R.id.etAddress2);
        txtPassword = findViewById(R.id.etPassword);
        txtConfPassword = findViewById(R.id.etConfPassword);
        txtUserName = findViewById(R.id.etUserName);
    }

    public void Save(View view) {
        initSignUp();
    }

    private void initSignUp(){
        String name = txtName.getText().toString();
        String lastName = txtLastName.getText().toString();
        String email = txtEmail.getText().toString();
        String phone = txtPhone.getText().toString();
        String address = txtAddress.getText().toString();
        String password = txtPassword.getText().toString();
        String confPassword = txtConfPassword.getText().toString();
        String userName = txtUserName.getText().toString();

        if (password.equals(confPassword)){
            try {
                AsyncHttpClient client = new AsyncHttpClient();
                url = "https://pupusasapp.000webhostapp.com/SignUp.php";
                RequestParams parametros = new RequestParams();
                parametros.put("nombre", name);
                parametros.put("apellido", lastName);
                parametros.put("direccion", address);
                parametros.put("celular", phone);
                parametros.put("email", email);
                parametros.put("usuario", userName);
                parametros.put("contrasennia", password);

                client.post(url, parametros, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if (statusCode == 200){
                            try {
                                String respuesta = new String(responseBody);
                                JSONObject json = new JSONObject(respuesta);
                                if (json.names().get(0).equals("exito")){
                                    resultado = json.getString("exito");
                                    //Toast.makeText(SignUp.this, resultado, Toast.LENGTH_LONG).show();
                                    status = true;
                                }
                                else {
                                    resultado = "Acceso incorrecto";
                                    Toast.makeText(SignUp.this, resultado, Toast.LENGTH_LONG).show();
                                    status = false;
                                }
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }
                });

                if (status == true){
                    Intent openLogin = new Intent(SignUp.this, Login.class);
                    SignUp.this.startActivity(openLogin);
                    finish();
                }
            }
            catch (Exception e) {
                Toast.makeText(SignUp.this, "Revisar conexión a internet", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(SignUp.this, "Las contraseñas no coinciden.", Toast.LENGTH_LONG).show();
        }


    }
}
