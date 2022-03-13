import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import io.ktor.util.*
import kotlinx.coroutines.runBlocking

class QuizCreator {

    private val service = PostService.create()


    @OptIn(InternalAPI::class)
    fun sendOCRAPIrequest(byteArray: ByteArray): ImageBitmap {

        val pr = PostRequest(byteArray)


        val response = runBlocking { service.createPost(pr)}
        val decoded = response?.img_str?.decodeBase64Bytes()
        val im = org.jetbrains.skia.Image.makeFromEncoded(decoded)

        return im.toComposeImageBitmap()
    }


}