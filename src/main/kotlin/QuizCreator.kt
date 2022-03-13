import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import io.ktor.util.*
import kotlinx.coroutines.runBlocking

class QuizCreator {

    private val service = PostService.create()

    @OptIn(InternalAPI::class)

    @Composable
    fun sendOCRAPIrequest(byteArray: ByteArray): ImageBitmap {

        val pr = PostRequest(byteArray)



            val postsState = runBlocking {
                produceState<List<PostResponse>>(
                initialValue = emptyList(),
                producer = {
//                value = listOf(service.createPost(pr) ?: PostResponse("value"))
//                    value = runBlocking {service.getPosts() }
                    value = listOf(service.createPost(pr) ?: PostResponse("value"))


        }
                )

            }

        val response1 = postsState.value[0]
        val decoded = response1.img_str.decodeBase64Bytes()
        val im = org.jetbrains.skia.Image.makeFromEncoded(decoded)

        return im.toComposeImageBitmap()
    }


}