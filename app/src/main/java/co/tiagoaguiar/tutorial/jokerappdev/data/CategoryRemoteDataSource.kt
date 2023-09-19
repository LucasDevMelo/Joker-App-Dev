package co.tiagoaguiar.tutorial.jokerappdev.data

import android.os.Handler
import android.os.Looper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryRemoteDataSource {

    fun findAllCategories(callback: ListCategoryCallback){
        HTTPClient.retrofit() //Aqui tem a instância do Retrofit pronta
            .create(ChuckNorrisAPI :: class.java)//ESPECIFICA QUAL É A INTERFACE QUE ELE PRECISA CRIAR UMA CLASSE COMPLETA PRA CHAMAR NO SERVIDOR
            .findAllCategories(HTTPClient.API_KEY)
            .enqueue(object : Callback<List<String>> {//PARA DIZER QUE A CHAMADA SERÁ ENFILEIRADA
                override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                    if ( response.isSuccessful){
                        val categories = response.body()
                        callback.onSuccess(categories ?: emptyList())
                    } else {
                        //este erro pode ocorrer quando o servidor devolve status de erro <500
                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Erro desconhecido")
                    }
                    callback.onComplete()
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    callback.onError(t.message ?: "Erro internp!")
                    callback.onComplete()
                }

            })
    }
}