package com.satriopndt.kicawcapstone.ui.scan

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.satriopndt.kicawcapstone.BuildConfig
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.getImageUri
import com.satriopndt.kicawcapstone.navigation.Screen
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme
import com.satriopndt.kicawcapstone.ui.theme.blueBackground
import com.satriopndt.kicawcapstone.ui.theme.greenToska
import java.util.Objects

@Composable
fun ScanScreen(
    context: Context = LocalContext.current,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    var currentImageUri: Uri? = null

    var captureImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }

    val launcherCamera =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicture()) {
            captureImageUri = currentImageUri!!
        }

    val galleryLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent(), onResult = { uri ->
        uri?.let {
            currentImageUri = it
        }
    })

    fun startCamera() {
        currentImageUri = context.getImageUri(context)
        launcherCamera.launch(currentImageUri)
    }


    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            startCamera()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(blueBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .background(blueBackground),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .padding(45.dp)
                    .fillMaxWidth()
                    .height(420.dp)
            ) {
                if (captureImageUri.path?.isNotEmpty() == true) {
                    AsyncImage(
                        model = captureImageUri,
                        contentDescription = null,
                        modifier = modifier
                            .fillMaxSize()
                            .rotate(360f)
                            .clip(RoundedCornerShape(15.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                }

            }

        }
        Row(modifier = Modifier) {
            androidx.compose.material.Button(
                modifier = modifier
                    .clip(RoundedCornerShape(12.dp)),
                onClick = { galleryLauncher.launch("image/jpg/png") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Icon(imageVector = Icons.Default.Photo, contentDescription = null)
            }

            Spacer(modifier = Modifier.width(85.dp))

            androidx.compose.material.Button(
                modifier = modifier
                    .clip(RoundedCornerShape(12.dp)), onClick = {
                    val permissionCheckResult =
                        ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                    if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                        startCamera()
                    } else {
                        // Request a permission
                        permissionLauncher.launch(Manifest.permission.CAMERA)
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Icon(
                    imageVector = Icons.Default.CameraAlt,
                    contentDescription = null
                )
            }
        }

        /*
        Button Scan
         */
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 40.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            androidx.compose.material.Button(
                modifier = Modifier
                    .width(200.dp),
                onClick = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0)
                    }
                },
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = greenToska)

            ) {
                Text(
                    text = "Scan",
                    color = colorResource(id = R.color.white),
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScan() {
    KicawCapstoneTheme {
        ScanScreen(navController = rememberNavController())
    }
}