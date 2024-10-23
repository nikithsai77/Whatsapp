package com.android.whatsapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.whatsapp.R
import com.android.whatsapp.ui.theme.WhatsappTheme

@Composable
fun AppBarComponents() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(MaterialTheme.colorScheme.primary)
        .padding(16.dp),
       verticalAlignment = Alignment.CenterVertically)
    {
        Text(text = stringResource(id = R.string.app_name),
             style = TextStyle(
                 fontSize = 20.sp,
                 fontWeight = FontWeight.SemiBold,
                 color = MaterialTheme.colorScheme.tertiary
             )
        )

        Spacer(modifier = Modifier.weight(1f))
        IconComposable(drawable = R.drawable.ic_camera)

        Spacer(modifier = Modifier.size(20.dp))
        IconComposable(drawable = R.drawable.ic_search)

        Spacer(modifier = Modifier.size(20.dp))
        IconComposable(drawable = R.drawable.ic_more)
    }
}

@Composable
fun IconComposable(drawable: Int) {
    Icon(painter = painterResource(drawable), contentDescription = "Icon Image", tint = MaterialTheme.colorScheme.tertiary)
}

@Preview(showBackground = true)
@Composable
fun AppBarComponentsPreview() {
    WhatsappTheme {
        AppBarComponents()
    }
}
