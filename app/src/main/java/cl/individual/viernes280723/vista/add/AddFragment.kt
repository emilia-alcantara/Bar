package cl.individual.viernes280723.vista.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import cl.individual.viernes280723.R
import cl.individual.viernes280723.databinding.FragmentAddBinding
import cl.individual.viernes280723.vista.BarViewModel

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private val viewModel: BarViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(inflater, container, false)
        initListeners()

        return binding.root
    }

    private fun initListeners() {
        binding.btnSave.setOnClickListener{
            val producto = binding.editProduct.text.toString()
            val cantidad = binding.editCant.text.toString().toInt()
            val precio = binding.editPrice.text.toString().toInt()

            viewModel.insertItem(producto, cantidad, precio)

            showSuccessMessage()
            cleanUI()

        }
    }

    private fun showSuccessMessage() {
        Toast.makeText(requireContext(), getString(R.string.success_message), Toast.LENGTH_LONG).show()
    }

    private fun cleanUI() {
        binding.editProduct.setText("")
        binding.editPrice.setText("")
        binding.editCant.setText("")

    }

}