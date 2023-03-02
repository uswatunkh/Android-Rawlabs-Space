package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidrawlabspace.R
import com.example.androidrawlabspace.databinding.ActivitybottomsheetBinding
import com.example.androidrawlabspace.databinding.BottomsheetlayoutBinding
import com.example.androidrawlabspace.databinding.ErrorStateBinding
import com.example.androidrawlabspace.databinding.SelectAddressBinding
import android.R.layout.simple_list_item_1
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrawlabspace.databinding.RuangBinding
import com.example.androidrawlabspace.databinding.SelectAddressNoresultBinding


class DialogBottomsheet : AppCompatActivity(){
    private lateinit var binding : ActivitybottomsheetBinding
    private lateinit var binding2 : BottomsheetlayoutBinding

    private lateinit var recyclerView : RecyclerView
    private lateinit var searchlist : ArrayList<SearchItem>
    private lateinit var searchAdapter: SearchAdapter


    //private lateinit var recyclerView : RecyclerView
    private lateinit var ruanglist : ArrayList<RuangItem>
    private lateinit var ruangAdapter: RuangAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitybottomsheetBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.botttomSheet.setOnClickListener{
            ruang()



        }


    }


    private fun showDialog() {

//        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.bottomsheetlayout);
        val dialog = Dialog(this)
        val binding2 = BottomsheetlayoutBinding.bind(layoutInflater.inflate(R.layout.bottomsheetlayout, null))
//        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        binding2 = BottomsheetlayoutBinding.inflate(layoutInflater)
        dialog.setContentView(binding2.root)

        binding2.layoutEdit.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(this@DialogBottomsheet, "Edit is Clicked", Toast.LENGTH_SHORT).show()
        }
        binding2.layoutShare.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(this@DialogBottomsheet, "Share is Clicked", Toast.LENGTH_SHORT).show()
        }
        binding2.layoutUpload.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(this@DialogBottomsheet, "Upload is Clicked", Toast.LENGTH_SHORT).show()
        }
        binding2.layoutPrint.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(this@DialogBottomsheet, "Print is Clicked", Toast.LENGTH_SHORT).show()
        }


        dialog.show()
        dialog.getWindow()



        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1000);
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog.window?.setGravity(Gravity.BOTTOM);
    }

    private fun showDialogErrorState() {

        val dialog = Dialog(this)
        val binding2 = ErrorStateBinding.bind(layoutInflater.inflate(R.layout.error_state, null))

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding2.root)

        dialog.show()
        dialog.getWindow()



        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1200);

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog.window?.setGravity(Gravity.BOTTOM);
    }

    private fun showDialogErrorMaintenance() {

        val dialog = Dialog(this)
        val binding2 = ErrorStateBinding.bind(layoutInflater.inflate(R.layout.error_state, null))

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding2.root)

        dialog.show()
        dialog.getWindow()



        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1050);

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog.window?.setGravity(Gravity.BOTTOM);
        binding2.imageError.setImageDrawable(getResources().getDrawable(R.drawable.maintenance))
        binding2.textError.setText(getResources().getString(R.string.errorMaintenance1))
        binding2.textErrortwo.setText(getResources().getString(R.string.errorMaintenance2))
        binding2.btnError.setText(getResources().getString(R.string.btnMaintenance))

    }

    private fun showDialogSearch() {

        val dialog = Dialog(this)
        val binding2 = SelectAddressBinding.bind(layoutInflater.inflate(R.layout.select_address, null))

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding2.root)

        dialog.show()
        dialog.getWindow()

        //dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1500);

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog.window?.setGravity(Gravity.BOTTOM);
        binding2.idedit.hint = "Street, address"

        //recyclerView = findViewById(R.id.recycler)
        binding2.recycler.setHasFixedSize(true)
        binding2.recycler.layoutManager = LinearLayoutManager(this)

        searchlist = ArrayList()

        searchlist.add(SearchItem("Ruang Kerja","Ruko Dr. Sardjito, Terban, Gondokusuman"))
        searchlist.add(SearchItem("Kolektif Collaboration Space","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman"))
        searchlist.add(SearchItem("Srawung Galih","Jalan Brigjen Katamso, Keparakan, Kecamatan Mergangsan, Jogja"))


        searchAdapter = SearchAdapter(searchlist)
        binding2.recycler.adapter = searchAdapter





//        val address = listOf("Ruang Kerja", "Kolektif Collaboration Space", "Srawung Galih");
//
//        binding2.ruang.adapter = ArrayAdapter(this, simple_list_item_1, address)


//        for (x in address) {
//            binding2.ruang.setText("$x")
//        };

    }

    private fun showDialogNoSearch() {

        val dialog = Dialog(this)
        val binding2 = SelectAddressNoresultBinding.bind(layoutInflater.inflate(R.layout.select_address_noresult, null))

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding2.root)

        dialog.show()
        dialog.getWindow()


        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1500);

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        dialog.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
        dialog.window?.setGravity(Gravity.BOTTOM);

    }

    private fun ruang() {
        val dialog = Dialog(this)
        val binding2 = RuangBinding.bind(layoutInflater.inflate(R.layout.ruang, null))

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding2.root)

        dialog.show()
        dialog.getWindow()

        //dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,1500);

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
//        dialog.window?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
//        dialog.window?.setGravity(Gravity.BOTTOM);
        //binding2.idedit.hint = "Street, address"

        //recyclerView = findViewById(R.id.recycler)
        binding2.recycler.setHasFixedSize(true)
        binding2.recycler.layoutManager = LinearLayoutManager(this)

        ruanglist = ArrayList()

        ruanglist.add(RuangItem(R.drawable.pic ,"Ruang Kerja","Ruko Dr. Sardjito, Terban, Gondokusuman"))
        ruanglist.add(RuangItem(R.drawable.pic,"Kolektif Collaboration Space","Jl Watugede 58 Wonorejo, Sariharjo, Ngaglik, Sleman"))
        ruanglist.add(RuangItem(R.drawable.pic,"Srawung Galih","Jalan Brigjen Katamso, Keparakan, Kecamatan Mergangsan, Jogja"))


        ruangAdapter = RuangAdapter(ruanglist)
        binding2.recycler.adapter = ruangAdapter
    }




}