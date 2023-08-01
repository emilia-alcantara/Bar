package cl.individual.viernes280723.vista.add

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
        initTextWatcher()
        initListener()


        return binding.root
    }

    private fun initTextWatcher() {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val cant = binding.editCant.text.toString()
                val price = binding.editPrice.text.toString()

                val cantidad = if (cant.isNotEmpty()) cant.toInt() else 0
                val precio = if (price.isNotEmpty()) price.toInt() else 0
                val total = cantidad * precio

                binding.txtTotalNum.text = total.toString()
            }

        }

        binding.editCant.addTextChangedListener(textWatcher)
    }

    private fun initListener() {
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