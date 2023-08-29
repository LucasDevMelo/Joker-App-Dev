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
        view.showProgress()
        fakeRequest()
    }

    fun onError(message: String){
        view.showFailure(message)
    }

    //notificar se os dados chegaram com sucesso
    fun onSucess(response: List<String>){
//        val categories = mutableListOf<CategoryItem>()
//
//        for(category in response){
//            categories.add(CategoryItem(category))
//        }


        //forma mais enxuta
        //o map mapeia o novo objeto que queremos trabalhar
        val categories = response.map{Category(it, 0xFFF0000)}

        view.showCategories(categories)
    }

    fun onComplete(){
        view.hideProgress()
    }

    //SIMULA UMA REQUISIÇÃO WEB
    private fun fakeRequest(){
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Categoria 1",
                "Categoria 2",
                "Categoria 3",
                "Categoria 3",
            )

            //aqui a lista já está pronta


            //DEVOLVER FALHA OU SUCESSO
            onSucess(response)
            //onError("FALHA NA CONEXÃO. TENTE NOVAMENTE MAIS TARDE")

            onComplete()
        }, 2000)
    }
}