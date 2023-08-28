package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.tutorial.jokerappdev.HomePresentation.HomePresenter
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

  private lateinit var presenter: HomePresenter
  private val adapter = GroupieAdapter()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter = HomePresenter(this)

    //View <---> presenter
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_home, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main)
    recyclerView.layoutManager = LinearLayoutManager(requireContext())

    presenter.findAllCategories()

    val adapter = GroupieAdapter()
    recyclerView.adapter = adapter

    adapter.notifyDataSetChanged()
  }

  fun showCategories(categries : List<CategoryItem>){
    adapter.addAll(categries)
    adapter.notifyDataSetChanged()
  }

}