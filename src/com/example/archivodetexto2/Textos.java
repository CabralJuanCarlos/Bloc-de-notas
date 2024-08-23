package com.example.archivodetexto2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Textos extends Activity {
	
	ListView lista;
	String[] archivo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textos);
		
		lista=(ListView)findViewById(R.id.listView1);
		archivo=fileList();
		
		ArrayAdapter<String> adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,archivo);
		lista.setAdapter(adaptador1);
		
		lista.setOnItemClickListener (new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intento1=new Intent(Textos.this,Archivo.class);
				intento1.putExtra("dato", archivo[arg2]);
				startActivity(intento1);
				
			}});
	}

	

}
