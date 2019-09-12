package com.example.francy.progettoingegneriasistemidistribuiti;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
/*
public class MainActivity extends AppCompatActivity {

    public int cont = 0;
    public final int ID_RICHIESTA_PERMISSION = 1;
    public final int ID_RICHIESTA_PERMISSION_NETWORK = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Before("onButtonClick() && args(view)")
    public void RichiediPermessiLocalizzazione(View view) {
        cont++;
        Log.d("clickButton", "clickButton: Prova numero " + cont);
        Toast.makeText(MainActivity.this, "Richiesta di permesso inviata", Toast.LENGTH_SHORT).show();

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.SEND_SMS}, ID_RICHIESTA_PERMISSION);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ID_RICHIESTA_PERMISSION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission concessa: eseguiamo il codice
                    Log.d("clickButton", "Permesso di localizzazione concesso");
                } else {
                    // permission negata: provvediamo in qualche maniera
                    Log.d("clickButton", "Permesso di localizzazione negato");
                }
                return;
            }
            case ID_RICHIESTA_PERMISSION_NETWORK: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission concessa: eseguiamo il codice
                    Log.d("clickButton", "Permesso di network concesso");
                } else {
                    // permission negata: provvediamo in qualche maniera
                    Log.d("clickButton", "Permesso di network negato");
                }
                return;
            }
        }
    }

    public void ControllaPermessiLocalizzazione(View view) {
        // controlliamo se la permission è concessa
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            // se arriviamo qui è perchè la permission non è stata ancora concessa
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
                // mostriamo ulteriori informazioni all'utente riguardante l'uso della permission nell'app ed eventualmente richiediamo la permission
                Log.d("clickButton", "Controllo Localizzazione: Permesso di localizzazione concesso");
            } else {
                // se siamo qui è perchè non si è mostrata alcuna spiegazione all'utente, richiesta di permission
                Log.d("clickButton", "Controllo Localizzazione: Permesso di localizzazione negato, rieseguo la richiesta.");
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS}, ID_RICHIESTA_PERMISSION);
            }
        }
    }

    public void ControllaPermessiNetwork(View view) {
        // controlliamo se la permission è concessa
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
            // se arriviamo qui è perchè la permission non è stata ancora concessa
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_NETWORK_STATE)) {
                // mostriamo ulteriori informazioni all'utente riguardante l'uso della permission nell'app ed eventualmente richiediamo la permission
                Log.d("clickButton", "Controllo network: Permesso di network concesso");

            } else {
                // se siamo qui è perchè non si è mostrata alcuna spiegazione all'utente, richiesta di permission
                Log.d("clickButton", "Controllo Network: Permesso di network non presente, rieseguo la richiesta.");

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, ID_RICHIESTA_PERMISSION_NETWORK);
            }
        }
        else{
            Log.d("clickButton", "Permesso di network già garantito.");
        }
    }
}
*/

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.widget.Button;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


public class MainActivity extends AppCompatActivity {

    // Defining Buttons
    private Button storage, camera;

    // Defining Permission codes.
    // We can give any value
    // but unique for each permission.
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;

    @Override
    //@AnnotationTrace
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = findViewById(R.id.storage);
        camera = findViewById(R.id.camera);

        // Set Buttons on Click Listeners
        /*storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });*/

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                checkPermission(Manifest.permission.CAMERA,
                        CAMERA_PERMISSION_CODE);
            }
        });
    }

    //@AnnotationTrace
    // Function to check and request permission.
    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[] { permission },
                    requestCode);
        }
        else {
            Toast.makeText(MainActivity.this,
                    "Permission already granted",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }

    // This function is called when the user accepts or decline the permission.
    // Request Code is used to check which permission called this function.
    // This request code is provided when the user is prompt for permission.

    @Override
    //@AnnotationTrace
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super
                .onRequestPermissionsResult(requestCode,
                        permissions,
                        grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,
                        "Camera Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(MainActivity.this,
                        "Camera Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
        else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,
                        "Storage Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(MainActivity.this,
                        "Storage Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }


    private static final String POINTCUT_METHOD =
            "execution(void com.example.francy.progettoingegneriasistemidistribuiti.MainActivity.test()";

    //@AnnotationTrace
    public void test(){
        Log.d("clickButton", "test: invocata funzione");
    }

    //@AnnotationTrace
    public void StorageClick(View view) {
        Log.d("clickButton", "Click storageclisk");
        Prova(15, "Allik");
        test();
        Log.d("clickButton", "ritornato dalla funzione test.");
        /*checkPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                STORAGE_PERMISSION_CODE);*/
    }

    @Pointcut("execution(void *.onClick(..))")
    @Before("StorageClick() && args(view)")
    public void onClickAdvice(View view) {
        Log.d(DebugName.TAG, "onClickAdvice: Prima di StorageClick");
    }

    public static int Prova(int ciao, String Provaaa){
        Log.d(DebugName.TAG, " Prova: Metodo prova " + ciao + " - " + Provaaa);
        return 6;
    }


}
