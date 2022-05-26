package com.example.shalatapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shalatapp.adapter.BatalShalatAdapter
import com.example.shalatapp.databinding.FragmentBatalShalatBinding
import com.example.shalatapp.model.BatalShalatItem
import com.example.shalatapp.model.DalilShalatItem
import com.example.shalatapp.network.RetrofitInterface
import com.example.shalatapp.network.RetrofitService
import kotlinx.coroutines.launch

class FragmentBatalShalat : Fragment() {

    private lateinit var binding : FragmentBatalShalatBinding
    private lateinit var batalShalatAdapter : BatalShalatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBatalShalatBinding.inflate(inflater,container,false)

        batalShalatAdapter = BatalShalatAdapter()
        binding.recyclerBatalShalat.adapter = batalShalatAdapter
        binding.recyclerBatalShalat.setHasFixedSize(true)
        binding.recyclerBatalShalat.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val requestDataBatalShalat = retrofitService.getDataBatalShalat()
            // Kondisi saat sukses show data
            if (requestDataBatalShalat.isSuccessful) {
                val dataBatalShalat = requestDataBatalShalat.body() as List<DalilShalatItem>
                batalShalatAdapter.addData(dataBatalShalat)
                batalShalatAdapter.notifyDataSetChanged()
            }
        }
    }
}