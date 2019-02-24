package com.bajabob.ktx

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.scene2d.Scene2DSkin

class GameLauncher : KtxGame<KtxScreen>() {

    private val gameScreens: Map<String, Class<out KtxScreen>> by lazy {

        val titleScreen = TitleScreen::class.java
        addScreen(titleScreen, TitleScreen())

        val optionsScreen = OptionsScreen::class.java
        addScreen(optionsScreen, OptionsScreen())

        mapOf(
                "title" to titleScreen,
                "options" to optionsScreen
        )
    }

    private var nextScreen: String? = null

    override fun create() {
        super.create()

        Scene2DSkin.defaultSkin = Skin(Gdx.files.internal("skin/metal-ui.json"))

        nextScreen("title")

        game = this
    }

    override fun render() {
        super.render()

        val tmp = nextScreen
        if (tmp != null) {
            gameScreens[tmp]?.let { setScreen(it) }
            nextScreen = null
        }
    }

    override fun dispose() {
        super.dispose()
    }

    fun nextScreen(name: String) {
        if (!gameScreens.containsKey(name)) {
            throw IllegalArgumentException("No screen by that name exists. Maybe it has not been added to the map yet?")
        }
        nextScreen = name
    }

    companion object {
        lateinit var game: GameLauncher
    }

}
