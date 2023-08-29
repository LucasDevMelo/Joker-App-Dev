package co.tiagoaguiar.tutorial.jokerappdev.HomePresentation

import android.os.Handler
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.ListCategoryCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
    ) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onError(response: String){
        view.showFailure(response)
    }

    override fun onSuccess(response: List<String>){
        val categories = response.map{Category(it, 0xFFF0000)}

        view.showCategories(categories)
    }

    override fun onComplete(){
        view.hideProgress()
    }
}