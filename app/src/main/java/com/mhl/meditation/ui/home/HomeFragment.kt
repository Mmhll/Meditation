package com.mhl.meditation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.mhl.meditation.R
import com.mhl.meditation.databinding.FragmentHomeBinding
import com.mhl.meditation.extras
import com.mhl.meditation.recadapters.*
import com.mhl.meditation.retroshit.ApiRet
import com.mhl.meditation.retroshit.MyRetrofit
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val feelRecycler : RecyclerView = root.findViewById(R.id.feelings_recycle)
        val nickname : TextView = root.findViewById(R.id.textNick)
        val stateRecycler : RecyclerView = root.findViewById(R.id.state_recycle)
        val retrofit = MyRetrofit().getRetrofit()
        val retroApi = retrofit.create(ApiRet::class.java)
        val callFeel : Call<feel> = retroApi.getFeelings()
        val callQuotes : Call<quotes> = retroApi.getQuotes()
        callFeel.enqueue(object : Callback<feel>{
            override fun onResponse(call: Call<feel>, response: Response<feel>) {
                if (response.isSuccessful){
                    feelRecycler.adapter =
                        response.body()?.let { FeelRecycler(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<feel>, t: Throwable) {
                Log.d("TAAAG", t.message.toString())
            }

        })
        callQuotes.enqueue(object : Callback<quotes>{
            override fun onResponse(call: Call<quotes>, response: Response<quotes>) {
                if (response.isSuccessful){
                    stateRecycler.adapter =
                        response.body()?.let { StateRecycler(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<quotes>, t: Throwable) {
            }
        })

        return root
    }
}