package com.example.cecyapp.layout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.cecyapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FormularioRegistro extends AppCompatActivity {
    //se crea el spiner para la selección de tipo de usario
    private Spinner spinner;
    //se agregan lo edittext referente al formulario
    private EditText etId, etNombres, etApellidos, etEdad, etDireccion, etContraseña, etCorreo, etCelular;
    //se agrega el boton de registro
    private Button btnRegistrar;

    //variable de datos qe se registraran
    private int id=0, edad=0;
    private String nombre="", apellidos="", correo="", contraseña="", direccion="", celular="";

    //se crea la variable de autenticación de firabase
    FirebaseAuth mAuth;
    //se crea la variable de la base de datos
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_registro);
        //se inician los
        etId= (EditText) findViewById(R.id.etId);
        etNombres = (EditText) findViewById(R.id.etNombreRegistro);
        etApellidos = (EditText) findViewById(R.id.etApellido);
        etEdad = (EditText) findViewById(R.id.etEdad);
        etDireccion = (EditText) findViewById(R.id.etDireccion);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etContraseña = (EditText) findViewById(R.id.etContraseña);
        etCelular = (EditText) findViewById(R.id.etCelular);
        spinner = (Spinner) findViewById(R.id.spinnerTipoUser);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        String [] opciones= {"Tipo de usario", "Cliente", "Modista"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = Integer.parseInt(etId.getText().toString());
                nombre = etNombres.getText().toString();
                apellidos= etApellidos.getText().toString();
                edad= Integer.parseInt(etEdad.getText().toString());
                direccion = etDireccion.getText().toString();
                correo = etCorreo.getText().toString();
                contraseña = etContraseña.getText().toString();
                celular= etCelular.getText().toString();
                //se guarda donde seleccionara el tipo de usario
                if(spinner.getSelectedItemPosition()>0) {
                    String seleccion = spinner.getSelectedItem().toString();
                }else{
                    Toast.makeText(getApplicationContext(), "No ha seleccionado el tipo de usario",Toast.LENGTH_LONG).show();
                }

                //se valida que ningun campo se encuentre vació
                if(id!=0 && edad != 0 && !nombre.isEmpty() && !apellidos.isEmpty() && !direccion.isEmpty() && !celular.isEmpty() && !correo.isEmpty() && !contraseña.isEmpty()){
                    //se valida que la contraseña tenga más de 6 caracteres
                    if(contraseña.length()>6) {
                        registrarUsario();
                    }else{
                        Toast.makeText(getApplicationContext(), "La contraseña debe de tener más de 6 caracteres",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "¡Error! S e encuentra algun campo vació, por favor llenar todos",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void registrarUsario() {
        //se registra el usario por medio de database
        mAuth.createUserWithEmailAndPassword(correo, contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isComplete()){
                   if(spinner.getSelectedItemPosition()==1){
                       Map<String , Object> map = new HashMap<>();
                       map.put("nombres",nombre);
                       map.put("id",id);
                       map.put("apellidos",apellidos);
                       map.put("edad",edad);
                       map.put("correo",correo);
                       map.put("contraseña",contraseña);
                       map.put("celular",celular);

                       String idObt = mAuth.getCurrentUser().getUid();
                      // mDatabase.child("cliente").child(idObt).setValue();
                   }else if(spinner.getSelectedItemPosition()==2){
                       String idObte = mAuth.getCurrentUser().getUid();
                       //mDatabase.child("modista").child(idObte).setValue();
                   }
                   //
                }
                }

        });
    }
}
