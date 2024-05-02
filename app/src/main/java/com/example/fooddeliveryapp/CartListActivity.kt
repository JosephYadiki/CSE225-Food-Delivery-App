//package com.example.fooddeliveryapp
//
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import android.widget.LinearLayout
//import android.widget.ScrollView
//import android.widget.TextView
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.material.floatingactionbutton.FloatingActionButton
//
//class CartListActivity : AppCompatActivity() {
//
//    private lateinit var adapter: RecyclerView.Adapter<*>
//    private lateinit var recyclerViewList: RecyclerView
//   // private lateinit var managementCart: ManagementCart
//    private lateinit var totalFeeTxt: TextView
//    private lateinit var taxTxt: TextView
//    private lateinit var deliveryTxt: TextView
//    private lateinit var totalTxt: TextView
//    private lateinit var emptyTxt: TextView
//    private lateinit var scrollView: ScrollView
//    private var tax: Double = 0.0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_cart_list)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//                managementCart = ManagementCart(this)
//
//                initView()
//                initList()
//                calculateCard()
//                bottomNavigation()
//            }
//
//            private fun bottomNavigation() {
//                val floatingActionButton = findViewById<FloatingActionButton>(R.id.card_btn)
//                val homeBtn = findViewById<LinearLayout>(R.id.homeBtn)
//
//                floatingActionButton.setOnClickListener {
//                    startActivity(Intent(this, CartListActivity::class.java))
//                }
//
//                homeBtn.setOnClickListener {
//                    startActivity(Intent(this, MainActivity::class.java))
//                }
//            }
//
//            private fun initList() {
//                val linearLayoutManager = LinearLayoutManager(this)
//                recyclerViewList.layoutManager = linearLayoutManager
//                adapter = CartListAdapter(managementCart.getListCard(), this, object : ChangeNumberItemsListener {
//                    override fun changed() {
//                        calculateCard()
//                    }
//                })
//
//                recyclerViewList.adapter = adapter
//                if (managementCart.getListCard().isEmpty()) {
//                    emptyTxt.visibility = View.VISIBLE
//                    scrollView.visibility = View.GONE
//                } else {
//                    emptyTxt.visibility = View.GONE
//                    scrollView.visibility = View.VISIBLE
//                }
//            }
//
//            private fun calculateCard() {
//                val percentTax = 0.02
//                val delivery = 10.0
//
//                tax = Math.round((managementCart.getTotalFee() * percentTax) * 100.0) / 100.0
//                val total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100.0) / 100.0
//                val itemTotal = Math.round(managementCart.getTotalFee() * 100.0) / 100.0
//
//                totalFeeTxt.text = "$itemTotal"
//                taxTxt.text = "$tax"
//                deliveryTxt.text = "$delivery"
//                totalTxt.text = "$total"
//            }
//
//            private fun initView() {
//                recyclerViewList = findViewById(R.id.recyclerview)
//                totalFeeTxt = findViewById(R.id.totalFeeTxt)
//                taxTxt = findViewById(R.id.taxTxt)
//                deliveryTxt = findViewById(R.id.deliveryTxt)
//                totalTxt = findViewById(R.id.totalTxt)
//                emptyTxt = findViewById(R.id.emptyTxt)
//                scrollView = findViewById(R.id.scrollView4)
//            }
//        }
//
//
