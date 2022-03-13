import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import java.io.InputStream
import java.net.URL

@Composable
fun ImageDisplay(
    imageBitmap : ImageBitmap
) {


    Column(
        modifier = Modifier
            .fillMaxHeight(0.95F)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = BitmapPainter(image = imageBitmap),
            contentDescription = null
        )
    }

}