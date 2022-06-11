package com.abora.nfcreader

import android.app.PendingIntent
import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.nfc.tech.Ndef
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var nfcAdapter: NfcAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nfcAdapter = NfcAdapter.getDefaultAdapter(this)

    }


    override fun onResume() {
        super.onResume()
        NfcUtil.enableNFCInForeground(nfcAdapter,this,javaClass)
    }

    override fun onPause() {
        super.onPause()
        NfcUtil.disableNFCInForeground(nfcAdapter,this)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(applicationContext, NfcUtil.getDataFromTag(intent), Toast.LENGTH_LONG).show()
        NfcUtil.getDataFromTag(intent)
    }


}