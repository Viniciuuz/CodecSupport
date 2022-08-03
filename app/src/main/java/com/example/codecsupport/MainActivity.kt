package com.example.codecsupport

import android.media.MediaCodecList
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codecsupport.ui.theme.CodecSupportTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val codecs = MediaCodecList(MediaCodecList.ALL_CODECS).codecInfos

            LazyColumn{
                items(codecs.size){
                    Text(
                        text = codecs[it].name + " - HW: " + codecs[it].isHardwareAccelerated.toString(),
                        fontSize = 19.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                }
            }
        }
    }
}