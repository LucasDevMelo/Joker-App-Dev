package co.tiagoaguiar.tutorial.jokerappdev.HomePresentation

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(private val view: HomeFragment) {

    //View tem que ter conexao com a camada de presenter
    //Presenter tem que ter conexao com a camada de view
    fun findAllCategories() {
        fakeRequest()
    }

    //notificar se os dados chegaram com sucesso
    fun onSucess(response: List<Category>){
        val categories = mutableListOf<CategoryItem>()

        for(category in response){
            categories.add(CategoryItem(category))
        }

        view.showCategories(categories)
    }


    //SIMULA UMA REQUISIÇÃO WEB
    private fun fakeRequest(){
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                Category("Categoria 1", 0xffface6e),
                Category("Categoria 2", 0xffecd16d),
                Category("Categoria 3", 0xffded36e),
                Category("Categoria 3", 0xffded36e)
            )

            //aqui a lista já está pronta

            onSucess(response)
        }, 2000)
    }
}