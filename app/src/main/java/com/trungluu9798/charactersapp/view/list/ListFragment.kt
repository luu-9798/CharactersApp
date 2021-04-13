package com.trungluu9798.charactersapp.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trungluu9798.charactersapp.MainActivity
import com.trungluu9798.charactersapp.R
import com.trungluu9798.charactersapp.model.Data


class ListFragment: Fragment() {
    private lateinit var viewModel: ListViewModel
    private lateinit var observer: Observer<Data>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViewModel()
        setUpObserver()
        val query = getString(R.string.query)
        viewModel.getData(query)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        setUpRecyclerView()
    }

    private fun setUpViewModel() {
        val viewModelFactory = ListViewModel.PortraitViewModelFactory()
        viewModel = ViewModelProvider(context as AppCompatActivity, viewModelFactory)
                .get(ListViewModel::class.java)
    }

    private fun setUpObserver() {
        observer = Observer<Data> { setUpRecyclerView() }
        viewModel.getDataLiveData().observe(requireActivity(), observer)
    }

    private fun setUpRecyclerView() {
        val data = viewModel.getDataLiveData().value
        val adapter = ListAdapter(data, ::itemOnClickListener)
        recyclerView = requireActivity().findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }


    private fun itemOnClickListener(position: Int) {
        viewModel.selected = (recyclerView.adapter as ListAdapter).getItem(position)
        (activity as MainActivity).replaceFragment()
    }
}