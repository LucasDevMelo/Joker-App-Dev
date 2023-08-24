package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem

class HomePresenter {

    fun findAllCategories(){

    }

    //simula uma requisição http
    private fun fakeRequest(){
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                Category("Categoria 1", 0xffface6e),
                Category("Categoria 2", 0xffecd16d),
                Category("Categoria 3", 0xffded36e),
                Category("Categoria 4", 0xffcfd571)
            )
        }, 2000)
    }
}