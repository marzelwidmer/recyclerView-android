package ch.keepcalm.recyclerview_android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recycleView_main.setBackgroundColor(Color.LTGRAY)
        recycleView_main.layoutManager = LinearLayoutManager(this)
        recycleView_main.adapter =  MainAdapter()
    }
}
