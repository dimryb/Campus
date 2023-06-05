package space.rybakov.campus.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import hilt_aggregated_deps._dagger_hilt_android_internal_lifecycle_DefaultViewModelFactories_ActivityEntryPoint
import space.rybakov.campus.R
import space.rybakov.campus.databinding.FragmentHomeBinding
import space.rybakov.campus.entities.ScheduleDate
import java.time.LocalDate
import java.util.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding == null!")

    private val viewModel: MainViewModel by activityViewModels()

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

        val date = LocalDate.now()
        viewModel.setDate(ScheduleDate(date.year, date.monthValue, date.dayOfMonth))

        createGroupsSpinner()
        setupClickListeners()
        observeViewModel()
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

    private fun setupClickListeners() {
        binding.panelTop.calendarButton.setOnClickListener {
            binding.calendar.visibility = View.VISIBLE

            viewModel.calendarVisible.value = true
            viewModel.schedulerVisible.value = false
        }
        binding.calendar.setOnDateChangedListener { _, year, monthIndex, day ->
            binding.calendar.firstDayOfWeek
            viewModel.setDate(ScheduleDate(year = year, month = monthIndex + 1, day = day))
            viewModel.calendarVisible.value = false
            viewModel.schedulerVisible.value = true
        }
    }

    private fun observeViewModel() {
        viewModel.calendarVisible.observe(viewLifecycleOwner) {
            binding.calendar.visibility = if (it) View.VISIBLE else View.GONE
        }
        viewModel.textDate.observe(viewLifecycleOwner){
            binding.panelTop.date.text = it
        }
        viewModel.schedulerVisible.observe(viewLifecycleOwner) {
            binding.schedulerList.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

}