package pupusas.app.pupusasyaprojectcli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView m;
    NotificationManager nm;
    public static final int NOTIFICACION_ID=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        m = findViewById(R.id.tvMessage);

        Intent i = this.getIntent();
        String name = i.getStringExtra("n");
        String lastName = i.getStringExtra("a");
        m.setText("Bienvenid@ " + name + " " + lastName);
    }

    public  void Notificacion(View view){

        Intent intent= new Intent(this, MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);

        NotificationCompat.Builder builder= new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.drawable.stat_notify_sync);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher1));
        builder.setContentTitle("Notificacion PupusasYa");
        builder.setContentText("Su Pedido esta LISTO");
        builder.setSubText("Toca para ver la notificacion.");

        NotificationManager notificationManager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICACION_ID,builder.build());

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Al destruiir la aplicacion de la pila de aplicaciones , el Mensaje de la barra tambien se destruye.
        nm.cancel(NOTIFICACION_ID);
    }
}
