package com.example.mybroadcastreceiver

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mybroadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnPermission?.setOnClickListener(this)


    }
    var requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){ isGranted ->
        if (isGranted){
            Toast.makeText(this,"Sms receiver permisson diterima", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Sms receiver permisson ditolak", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?){
        when(v?.id){
            R.id.btn_permission -> requestPermissionLauncher.launch(android.Manifest.permission.RECEIVE_SMS)

        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
