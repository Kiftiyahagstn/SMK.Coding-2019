package com.kiftiyahagstn.smklpicoding


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiftiyahagstn.smklpicoding.connection.ConfigRetrofit
import com.kiftiyahagstn.smklpicoding.connection.MovieInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movie.view.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {
    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_movie, container, false)

        getLisMovie()

//        val list = Movie.listMovie
//                as ArrayList<MovieModel>
//        val layoutManager =
//            LinearLayoutManager(activity)
//        val adapter =
//            MovieAdapter(list, activity!!.applicationContext)
//
//        return rootView.rv_movie.apply {
//            setLayoutManager(layoutManager)
//            setAdapter(adapter)
//        }
        return rootView
    }

    private fun getLisMovie() {
        val movieNowPlaying =
            ConfigRetrofit.retrofitConfig()
                .create(MovieInterface::class.java)
                .getListMovieNowPlaying(
                    "98cd59998ca23ec98a533ecbb7883464"
                )
        movieNowPlaying
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                //Menerima response yang berhasil

                val list = response.results
                val layoutManager =
                    LinearLayoutManager(activity)
                val adapter = MovieAdapter(list, activity!!.applicationContext)

                rootView.rv_movie.apply {
                    setLayoutManager(layoutManager)
                    setAdapter(adapter)
                }
            }, {
                //Menerima response yang gagal
            })
    }

}
