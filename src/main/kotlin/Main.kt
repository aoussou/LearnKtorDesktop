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

    val quizFile = File("/home/john/dvpt/demo/quiz.png")
    val inputStream = quizFile.inputStream()
    val byteArray = inputStream.readBytes()

    val quizCreator = remember{QuizCreator()}
    val image = quizCreator.sendOCRAPIrequest(byteArray)
    MaterialTheme {
        ImageDisplay(image)
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
