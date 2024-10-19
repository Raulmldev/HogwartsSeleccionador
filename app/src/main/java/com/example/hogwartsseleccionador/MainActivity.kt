package com.example.hogwartsseleccionador

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializar MediaPlayer con el sonido
        mediaPlayer = MediaPlayer.create(this, R.raw.potter)
        // Reproducción en bucle
        mediaPlayer?.isLooping = true

        // Cogemos el botón nuevo alumno y creamos el evento listener
        val btnNuevoAlumno: Button = findViewById(R.id.btnNuevoAlumno)
        btnNuevoAlumno.setOnClickListener {
            val intent = Intent(this, NuevoAlumno::class.java)
            startActivity(intent)
        }

        // Botón para acceder a los listados de Alumnos
        val btnListadoAlumnos: Button = findViewById(R.id.btnListaAlumnos)
        btnListadoAlumnos.setOnClickListener {
            val intent = Intent(this, EligeCasa::class.java)
            startActivity(intent)
        }
    }
    //Comenzar la reproducción cuando la actividad se vuelve visible
    override fun onStart() {
        super.onStart()
        mediaPlayer?.start()
    }
    //Pausa la reproducción cuando la actividad ya no está visible
    override fun onStop() {
        super.onStop()
        mediaPlayer?.pause()
    }
    // Liberar recursos del reproductor de música
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer=null
    }
}