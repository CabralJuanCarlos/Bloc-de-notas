package com.example.archivodetexto2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText edit1,edit2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edit1=(EditText)findViewById(R.id.editText0);
		edit2=(EditText)findViewById(R.id.editText1);
		
		Toast.makeText(this, "Bienvenida mi cochinita", Toast.LENGTH_LONG).show();
		
	}

	public void guardar(View w)
	{
		String nombre=edit1.getText().toString();
		String texto=edit2.getText().toString();
	
			try {
				OutputStreamWriter archi=new OutputStreamWriter(openFileOutput(nombre,Activity.MODE_PRIVATE));
				archi.write(texto);
				archi.flush();
				archi.close();
				edit1.setText("");
				edit2.setText("");
				Toast.makeText(this, "Nota de texto guardado.", Toast.LENGTH_LONG).show();
		}catch(IOException ex)
		{
			Toast.makeText(this, "ocurrio algun problema", Toast.LENGTH_LONG).show();
		}catch (IllegalArgumentException err)
		{
			Toast.makeText(this, "ocurrio algun problema", Toast.LENGTH_LONG).show();
		}
	}
	
	public void recuperar(View v)
	{
		String nombre=edit1.getText().toString();
		try {
			InputStreamReader archi=new InputStreamReader(openFileInput(nombre));
			BufferedReader br=new BufferedReader(archi);
			String linea=br.readLine();
			String contenido="";
			while(linea!=null)
			{
			 contenido = contenido+linea+"\n";
			 linea=br.readLine();
			}
			br.close();
			archi.close();
			edit2.setText(contenido);
			
			
			
			
		} catch (IOException err) {
			Toast.makeText(this, "ocuurio algun problema", Toast.LENGTH_LONG).show();

			
		}
		
		
			
	}
	public void ver(View v)
	{
		Intent intento1=new Intent(this,Textos.class);
		startActivity(intento1);
	}
	public void borrar(View v)
	{
		if(deleteFile(edit1.getText().toString()))
				{
			Toast.makeText(this, "Se borro el archivo mamolchita", Toast.LENGTH_LONG).show();
			edit1.setText("");
			edit2.setText("");
				}else
			{
					Toast.makeText(this, "No existe el archivo mamolchita", Toast.LENGTH_LONG).show();
			}
	}
}
 
