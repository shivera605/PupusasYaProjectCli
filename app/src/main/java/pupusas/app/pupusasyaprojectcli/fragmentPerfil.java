package pupusas.app.pupusasyaprojectcli;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class fragmentPerfil extends AppCompatActivity {
    private TextView etusuario, etNombre, etDireccion, etemail1, etCelu, etid, etUsuario1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_perfil);

        etid = findViewById(R.id.codCliente);
        etNombre = findViewById(R.id.cNombre);
        etDireccion = findViewById(R.id.cDireccion);
        etemail1 = findViewById(R.id.cEmail);
        etCelu = findViewById(R.id.cCelular);
        etUsuario1 = findViewById(R.id.codUsuario);


        Intent i = this.getIntent();
        String id = i.getStringExtra("id");
        String name = i.getStringExtra("name");
        String direccion = i.getStringExtra("direccion");
        String email = i.getStringExtra("email");
        String cel1 = i.getStringExtra("tel");
        String cusuar = i.getStringExtra("cusuar");

        etid.setText("Código de cliente: " + id );
        etNombre.setText("Nombre de cliente: "+name);
        etUsuario1.setText("Usuario " + cusuar );
        etDireccion.setText("Direccion: " + direccion );
        etemail1.setText("Email: " + email );
        etCelu.setText("Celular: " + cel1 );

    }
}
