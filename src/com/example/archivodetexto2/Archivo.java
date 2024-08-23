package com.example.archivodetexto2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Archivo extends Activity {
	EditText edt1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_archivo);
		
		edt1=(EditText)findViewById(R.id.editText2);
		Bundle b=getIntent().getExtras();
		String s=b.getString("dato");
		
		try{
			InputStreamReader aux=new InputStreamReader(openFileInput(s));
			BufferedReader br=new BufferedReader(aux);
			String linea=br.readLine();
			String contenido="";
			while(linea!=null)
			{
			 contenido = contenido+linea+"\n";
			 linea=br.readLine();
			}
			br.close();
			aux.close();
			edt1.setText(contenido);
			
		}catch(IOException err)
		{
			Toast.makeText(this, "Hubo un error", Toast.LENGTH_LONG).show();
		}
		
		
	}
	public void volver(View v)
	{
	finish();	
	}
	
	

}
