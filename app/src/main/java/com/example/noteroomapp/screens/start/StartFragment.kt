package com.example.noteroomapp.screens.start

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteroomapp.APP
import com.example.noteroomapp.R
import com.example.noteroomapp.adapter.NoteAdapter
import com.example.noteroomapp.databinding.ActivityMainBinding
import com.example.noteroomapp.databinding.FragmentStartBinding

/**
 * A fragment representing a list of Items.
 */
class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("inffffo","init startFragment")
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDb()
        recyclerView = binding.rvNote
        adapter = NoteAdapter()
        recyclerView.adapter =adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listnote ->
            listnote.asReversed()
            adapter.setList(listnote)
        }

        binding.btnNext.setOnClickListener{
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }
    }

}