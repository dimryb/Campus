package space.rybakov.campus.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import space.rybakov.campus.R
import space.rybakov.campus.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding == null!")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        createGroupsSpinner()
        return binding.root
    }

    private fun createGroupsSpinner() {
        val groupNames = arrayOf<String?>("ФББ-92", "ФББ-93", "ФББ-94", "ФББ-95", "ФББ-96")
        ArrayAdapter(requireContext(), R.layout.spinner_list, groupNames).also { adapter ->
            val spinner: Spinner = binding.panelTop.groupsSpinner
            spinner.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}