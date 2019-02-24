package com.bajabob.ktx

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.ScreenViewport
import ktx.actors.onClick
import ktx.app.KtxScreen
import ktx.log.info
import ktx.scene2d.table
import ktx.scene2d.textButton


class OptionsScreen: KtxScreen {

    private val screenWidth = Gdx.graphics.width.toFloat()
    private val screenHeight = Gdx.graphics.height.toFloat()
    private val stage by lazy { Stage(ScreenViewport()) }

    override fun show() {
        super.show()

        val root = table {
            textButton(text = "Title Screen").onClick {
                info { "Title screen clicked" }
                GameLauncher.game.nextScreen("title")
            }
            // Packing the root window:
            pack()
        }

        root.setPosition((screenWidth/2), screenHeight/2, Align.center)

        Gdx.input.setInputProcessor(stage)
        stage.addActor(root)
    }

    override fun render(delta: Float) {
        super.render(delta)
        Gdx.gl.glClearColor(0f, 0f, 1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.act()
        stage.draw()
    }
}