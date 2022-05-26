package com.example.shalatapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shalatapp.adapter.ShalatAdapter
import com.example.shalatapp.databinding.FragmentShalatBinding
import com.example.shalatapp.model.ShalatItem
import com.example.shalatapp.network.RetrofitInterface
import com.example.shalatapp.network.RetrofitService
import kotlinx.coroutines.launch

class FragmentShalat : Fragment() {

    private lateinit var binding: FragmentShalatBinding
    private lateinit var shalatAdapter: ShalatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShalatBinding.inflate(inflater, container, false)

        shalatAdapter = ShalatAdapter()
        binding.recyclerShalat.setHasFixedSize(true)
        binding.recyclerShalat.layoutManager = LinearLayoutManager(context)
        binding.recyclerShalat.adapter = shalatAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)

        viewLifecycleOwner.lifecycleScope.launch {
            val requestDataShalat = retrofitService.getDataShalatWajib()
            // Kondisi saat sukses show data
            if (requestDataShalat.isSuccessful) {
                val dataShalat = requestDataShalat.body() as List<ShalatItem>
                shalatAdapter.addData(dataShalat)
                shalatAdapter.notifyDataSetChanged()
            }
        }
    }
}