package cl.individual.viernes280723.vista.listing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.individual.viernes280723.R
import cl.individual.viernes280723.databinding.FragmentListBinding
import cl.individual.viernes280723.vista.BarViewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val barAdapter = BarAdapter()
    private val viewModel: BarViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        initRecyclerView()
        loadData()
        initListener()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.recAddedProducts.adapter = barAdapter
    }

    private fun loadData() {
        viewModel.getItemList().observe(viewLifecycleOwner) {
            barAdapter.setData(it)
        }
    }

    private fun initListener() {
        binding.btnAddItem.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }
}



