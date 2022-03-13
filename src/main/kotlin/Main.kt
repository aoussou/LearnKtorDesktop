// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.ktor.util.*
import java.io.ByteArrayInputStream
import java.io.File

@OptIn(InternalAPI::class)
@Composable
@Preview
fun App() {

    val service = PostService.create()

    var text by remember { mutableStateOf("Hello, World!") }
    val quizFile = File("/home/john/dvpt/demo/quiz.png")
    val inputStream = quizFile.inputStream()
    val byteArray = inputStream.readBytes()

    val quizCreator = remember{QuizCreator()}
    val image = quizCreator.sendOCRAPIrequest(byteArray)
    MaterialTheme {

//        var posts by remember { mutableStateOf(emptyList<PostResponse>()) }
//        var list = mutableListOf<PostRequest>()
//        val pr = PostRequest(byteArray)
//
//        val postsState = produceState<List<PostResponse>>(
//            initialValue = emptyList(),
//            producer = {
//                value = listOf(service.createPost(pr) ?: PostResponse("value"))
//            }
//        )
//
//        if (postsState.value.isNotEmpty()){
//            val response1 = postsState.value[0]
//            val decoded = response1.img_str.decodeBase64Bytes()
//            val im = org.jetbrains.skia.Image.makeFromEncoded(decoded)
//
//            Column(
//                modifier = Modifier
//                    .fillMaxHeight(0.95F)
//                    .fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = BitmapPainter(image = im.toComposeImageBitmap()),
//                    contentDescription = null
//                )
//            }
//        }


        ImageDisplay(image)


    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
