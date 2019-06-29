package com.tjr.alim.profilmhs.ui.Fragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tjr.alim.profilmhs.BuildConfig
import com.tjr.alim.profilmhs.R
import com.tjr.alim.profilmhs.model.DataItemModel
import com.tjr.alim.profilmhs.rest.ApiService
import com.tjr.alim.profilmhs.rest.RetroConfig
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.fragment_profil.view.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class  ProfilFragment : Fragment() {
    private var items: ArrayList<DataItemModel> = arrayListOf()
    private lateinit var npmTexView: TextView
    private lateinit var nik: TextView
    private lateinit var nisn: TextView
    private lateinit var tahun_masuk : TextView
    private lateinit var ivImageProfile: CircleImageView
    private lateinit var tgl_msk: TextView
    private lateinit var kelamin: TextView
    private lateinit var transpor: TextView
    private lateinit var dosen_wali: TextView
    private lateinit var kelas: TextView
    private lateinit var ktlhr: TextView
    private lateinit var tlhr: TextView
    private lateinit var agama: TextView
    private lateinit var almt: TextView
    private lateinit var rt: TextView
    private lateinit var rw: TextView
    private lateinit var dusun: TextView
    private lateinit var kec: TextView
    private lateinit var prop: TextView
    private lateinit var telp: TextView
    private lateinit var kalmt: TextView
    private lateinit var kpos: TextView
    private lateinit var email: TextView
    private lateinit var darah: TextView
    private lateinit var alamat_kos: TextView
    private lateinit var ayah: TextView
    private lateinit var ibu: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_profil, container, false)
        ivImageProfile = view.ivImageProfile
        npmTexView = view.tvNpm
        nik = view.tvNik
        nisn = view.tvNISN
        npmTexView.text = "16670095"
        tahun_masuk = view.tvThn
        tgl_msk = view.tvTgl
        kelamin = view.tvJenis
        transpor = view.tvTransportasi
        dosen_wali = view.tvKodeDosen
        kelas = view.tvKelas
        ktlhr = view.tvKotalahir
        tlhr = view.tvTgllahir
        agama = view.tvAgama
        almt = view.tvAlamat
        rt = view.tvRt
        rw = view.tvRw
        dusun = view.tvDs
        kec = view.tvKec
        prop = view.tvKdprov
        telp = view.tvTlp
        kalmt = view.tvKdalamat
        kpos = view.tvKdpos
        email = view.tvEmail
        darah = view.tvGoldarah
        alamat_kos = view.tvKos
        ayah = view.tvAyah
        ibu = view.tvIbu

        getDatas()

        return view;
    }

    private fun getDatas() {
        val apiService: ApiService = RetroConfig.provideApi()
        apiService.getProfil()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items.clear()
                items = it.data as ArrayList<DataItemModel>
                for (i: Int in items.indices) {
                    nik.text = items.get(i).nik
                    nisn.text = items.get(i).nisn
                    tahun_masuk.text = items.get(i).tahunMasuk
                    tgl_msk.text = items.get(i).tglMsk
                    transpor.text = items.get(i).transpor
                    dosen_wali.text = items.get(i).dosenWali
                    kelas.text = items.get(i).kelas
                    ktlhr.text = items.get(i).ktlhr
                    tlhr.text = items.get(i).tlhr
                    agama.text = "Islam"
                    almt.text = items.get(i).almt
                    rt.text = items.get(i).rt
                    rw.text = items.get(i).rw
                    dusun.text = items.get(i).dusun
                    kec.text = items.get(i).kec
                    prop.text = items.get(i).prop
                    telp.text = items.get(i).telp
                    kalmt.text = items.get(i).kalmt
                    kpos.text = items.get(i).kpos
                    email.text = items.get(i).email
                    darah.text = items.get(i).darah
                    alamat_kos.text = items.get(i).alamatKos
                    ayah.text = items.get(i).ayah
                    ibu.text = items.get(i).ibu
                    activity?.let { it1 ->
                        Glide.with(it1).load("http://informatika.upgris.ac.id/mobile/image/" + items.get(i).foto)
                            .override(512, 512).error(R.drawable.error_image).into(ivImageProfile)
                    }
                }
            }, {
                error("Error" + it.message)
            })
    }
}