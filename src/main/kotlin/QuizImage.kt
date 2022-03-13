import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import java.io.File
import java.io.InputStream
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths

class QuizImage {

    private lateinit var inputStream: InputStream
    lateinit var bitmap: ImageBitmap
    var isDownloaded by mutableStateOf(false)
    var imageURLString by mutableStateOf("")

    fun updateURL(newURLString: String){
        imageURLString = newURLString
    }

    fun downloadFile(fileName: String) {
        val ext = File(imageURLString).extension
//        URL(imageURLString).openStream().use { Files.copy(it, Paths.get("$fileName.$ext")) }

        inputStream = URL(imageURLString).openStream()
        bitmap = loadImageBitmap(inputStream)
        isDownloaded = true

    }



}