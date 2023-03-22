package com.example.androidrawlabspace.rawlabspace.screen.fragment

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ErrorStateBinding
import com.example.androidrawlabspace.databinding.FilterBinding
import com.example.androidrawlabspace.databinding.FragmentHomeBinding
import com.example.androidrawlabspace.databinding.SelectAddressBinding
import com.example.androidrawlabspace.rawlabspace.screen.DetailRuang.DetailRuang
import com.example.androidrawlabspace.rawlabspace.shared.ui.*
import java.nio.file.DirectoryStream.Filter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentHome : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var searchlist : ArrayList<SearchItem>
    private lateinit var searchAdapter: SearchAdapter

    private lateinit var recyclerViewruang : RecyclerView
    private lateinit var ruang_home_list : ArrayList<RuangHomeItem>
    private lateinit var ruang_home_Adapter: RuangHomeAdapter

    private lateinit var ruanglist : ArrayList<RuangItem>
    private lateinit var ruangAdapter: RuangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.bind(
            inflater.inflate(
                R.layout.fragment_home ,
                container,
                false
            )
        )

        //showDialogErrorState()
        showDialogErrorMaintenance()
        binding.filter.setOnClickListener{
            filter()
//            startActivity(Intent(activity , DialogBottomsheet::class.java))
        }


        binding.recycler.setHasFixedSize(true)
        binding.recycler.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL,false)

        ruang_home_list = ArrayList()

        ruang_home_list.add(RuangHomeItem(R.drawable.imageruanghome,"Ruang Kerja","IDR 200K","Ruko Dr. Sardjito, Terban, Gondokusuman", "per day"))
        ruang_home_list.add(RuangHomeItem(R.drawable.imageruanghome,"Srawung Galih","IDR 300K","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman", "per day"))
        ruang_home_list.add(RuangHomeItem(R.drawable.imageruanghome,"Kolektif Collaboration Space","IDR 200K","Ruko Dr. Sardjito, Terban, Gondokusuman", "per day"))
        ruang_home_list.add(RuangHomeItem(R.drawable.imageruanghome,"Ruang Kerja","IDR 200K","Ruko Dr. Sardjito, Terban, Gondokusuman", "per day"))
        ruang_home_list.add(RuangHomeItem(R.drawable.imageruanghome,"Ruang Kerja","IDR 200K","Ruko Dr. Sardjito, Terban, Gondokusuman", "per day"))
        ruang_home_list.add(RuangHomeItem(R.drawable.imageruanghome,"Ruang Kerja","IDR 200K","Ruko Dr. Sardjito, Terban, Gondokusuman", "per day"))

        ruang_home_Adapter = RuangHomeAdapter(ruang_home_list)
        binding.recycler.adapter = ruang_home_Adapter


        binding.recyclerBottom.setHasFixedSize(true)
        binding.recyclerBottom.layoutManager = LinearLayoutManager(context)

        ruanglist = ArrayList()

        ruanglist.add(RuangItem(R.drawable.pic ,"Ruang Kerja","Ruko Dr. Sardjito, Terban, Gondokusuman"))
        ruanglist.add(RuangItem(R.drawable.pic,"Kolektif Collaboration Space","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman"))
        ruanglist.add(RuangItem(R.drawable.pic,"Srawung Galih","Jalan Brigjen Katamso, Keparakan, Kecamatan Mergangsan, Jogja"))


        ruangAdapter = RuangAdapter(ruanglist)
        binding.recyclerBottom.adapter = ruangAdapter

        ruang_home_Adapter.onItemClick = {
            val intent = Intent(activity, DetailRuang::class.java)
            intent.putExtra("ruanghome",it)
            startActivity(intent)

        }



        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)


//        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
//        val edit: ImageView = requireView().findViewById<View>(R.id.filter) as ImageView
//
//
//        edit.setOnClickListener { view ->
//            Log.d("btnSetup", "Selected")
////            showDialogSearch()
//            startActivity(Intent(activity , DialogBottomsheet::class.java))
//        }
//
//        // Return the fragment view/layout
//        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentHome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

     fun showDialogSearchHome() {

        val dialog = context?.let { Dialog(it) }
        val binding2 = SelectAddressBinding.bind(layoutInflater.inflate(R.layout.select_address, null))

        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(binding2.root)


        dialog?.getWindow()

        //dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog?.setCanceledOnTouchOutside(false);
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1500);

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog?.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog?.window?.setGravity(Gravity.BOTTOM);
        binding2.idedit.hint = "Street, address"

        //recyclerView = findViewById(R.id.recycler)
        binding2.recycler.setHasFixedSize(true)
        binding2.recycler.layoutManager = LinearLayoutManager(context?.getApplicationContext())

        searchlist = ArrayList()

        searchlist.add(SearchItem("Ruang Kerja","Ruko Dr. Sardjito, Terban, Gondokusuman"))
        searchlist.add(SearchItem("Kolektif Collaboration Space","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman"))
        searchlist.add(SearchItem("Srawung Galih","Jalan Brigjen Katamso, Keparakan, Kecamatan Mergangsan, Jogja"))
        searchlist.add(SearchItem("Ruang Kerja","Ruko Dr. Sardjito, Terban, Gondokusuman"))
        searchlist.add(SearchItem("Kolektif Collaboration Space","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman"))
        searchlist.add(SearchItem("Srawung Galih","Jalan Brigjen Katamso, Keparakan, Kecamatan Mergangsan, Jogja"))
        searchlist.add(SearchItem("Ruang Kerja","Ruko Dr. Sardjito, Terban, Gondokusuman"))
        searchlist.add(SearchItem("Kolektif Collaboration Space","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman"))
        searchlist.add(SearchItem("Srawung Galih","Jalan Brigjen Katamso, Keparakan, Kecamatan Mergangsan, Jogja"))


        searchAdapter = SearchAdapter(searchlist)
        binding2.recycler.adapter = searchAdapter


        dialog?.show()






    }

    fun filter() {

        val dialog = context?.let { Dialog(it) }
        val binding2 = FilterBinding.bind(layoutInflater.inflate(R.layout.filter, null))

        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(binding2.root)

        dialog?.show()
        dialog?.getWindow()



        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1600);

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog?.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog?.window?.setGravity(Gravity.BOTTOM);
    }


    fun showDialogErrorState() {

        val dialog = context?.let { Dialog(it) }
        val binding2 = ErrorStateBinding.bind(layoutInflater.inflate(R.layout.error_state, null))

        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(binding2.root)

        dialog?.show()
        dialog?.getWindow()



        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1200);

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog?.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog?.window?.setGravity(Gravity.BOTTOM);
    }

    private fun showDialogErrorMaintenance() {

        val dialog = context?.let { Dialog(it) }
        val binding2 = ErrorStateBinding.bind(layoutInflater.inflate(R.layout.error_state, null))

        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setContentView(binding2.root)

        dialog?.show()
        dialog?.getWindow()



        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1050);

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog?.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog?.window?.setGravity(Gravity.BOTTOM);
        binding2.imageError.setImageDrawable(getResources().getDrawable(R.drawable.maintenance))
        binding2.textError.setText(getResources().getString(R.string.errorMaintenance1))
        binding2.textErrortwo.setText(getResources().getString(R.string.errorMaintenance2))
        binding2.btnError.setText(getResources().getString(R.string.btnMaintenance))

    }
}