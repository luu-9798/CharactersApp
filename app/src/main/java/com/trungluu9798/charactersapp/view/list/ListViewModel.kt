package com.trungluu9798.charactersapp.view.list

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.trungluu9798.charactersapp.model.Data
import com.trungluu9798.charactersapp.model.RelatedTopics
import com.trungluu9798.charactersapp.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel: ViewModel() {
    private val dataLiveData = MutableLiveData<Data>()
    fun getDataLiveData(): LiveData<Data> = dataLiveData

    private val retrofitInstance = RetrofitInstance()

    var selected: RelatedTopics? = null

    fun getData(query: String) {
        viewModelScope.launch {
            retrofitInstance.getData(query).enqueue(object: Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {
                    dataLiveData.setValue(response.body())
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {
                    Log.d("TAB_X", "Fail")
                }
            })
        }
    }

    class PortraitViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass != ListViewModel::class.java) {
                throw RuntimeException("Incorrect use of CharacterListViewModel.Factory, likely cause: Static import of wrong Factory class")
            }
            @Suppress("UNCHECKED_CAST")
            return ListViewModel() as T
        }
    }
}