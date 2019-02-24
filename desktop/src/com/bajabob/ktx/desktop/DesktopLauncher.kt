package com.bajabob.ktx.desktop

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.bajabob.ktx.GameLauncher
import io.anuke.gif.GifRecorder

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
//        val config = LwjglApplicationConfiguration()
//        LwjglApplication(object : com.bajabob.ktx.GameLauncher() {
//
//            lateinit var recorder: GifRecorder
//
//            override fun create() {
//                recorder = GifRecorder(SpriteBatch())
//                super.create()
//            }
//
//            override fun render() {
//                if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
//                    recorder.takeScreenshot()
//                }
//                super.render()
//                recorder.update()
//            }
//        }, config)

        LwjglApplication(GameLauncher(), LwjglApplicationConfiguration())
    }
}
