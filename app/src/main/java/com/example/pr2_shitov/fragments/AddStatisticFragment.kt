package com.example.pr2_shitov.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pr2_shitov.R

class AddStatisticFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_statistic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinnerResult = view.findViewById<Spinner>(R.id.spinnerResult)
        val spinnerDifficult = view.findViewById<Spinner>(R.id.spinnerDifficult)
        val spinnerLevel = view.findViewById<Spinner>(R.id.spinnerLevel)
        val editError = view.findViewById<EditText>(R.id.editError)
        val editPoints = view.findViewById<EditText>(R.id.editPoints)
        val btnAdd = view.findViewById<Button>(R.id.btnAdd)

        val results = arrayOf("Победа", "Поражение", "Ничья")
        spinnerResult.adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_spinner_item, results
        )

        val difficulties = arrayOf("Лёгкая", "Средняя", "Сложная")
        spinnerDifficult.adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_spinner_item, difficulties
        )

        val levels = (1..10).map { it.toString() }.toTypedArray()
        spinnerLevel.adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_spinner_item, levels
        )

        btnAdd.setOnClickListener {
            val result = spinnerResult.selectedItem.toString()
            val difficult = spinnerDifficult.selectedItem.toString()
            val level = spinnerLevel.selectedItem.toString()
            val error = editError.text.toString()
            val points = editPoints.text.toString()

            if (error.isEmpty() || points.isEmpty()) {
                Toast.makeText(requireContext(), "Заполните ошибки и очки", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(
                requireContext(),
                "Результат: $result\nСложность: $difficult\nУровень: $level\nОшибок: $error\nОчков: $points",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}