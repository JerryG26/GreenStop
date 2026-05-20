package com.example.gamstop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RewardItem(val title: String, val cost: String)

class RewardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reward_page, container, false)

        val tvTotalPoints = view.findViewById<TextView>(R.id.txtTotalPoints)
        tvTotalPoints.text = "1250"

        val rewardsList = ArrayList<RewardItem>()
        rewardsList.add(RewardItem("You have been rewarded 50 points", "Click to redeem"))
        rewardsList.add(RewardItem("You have been rewarded 150 points", "Click to redeem"))
        rewardsList.add(RewardItem("You have been rewarded 250 points", "Click to redeem"))
        rewardsList.add(RewardItem("You have been rewarded 10 points", "Click to redeem"))
        rewardsList.add(RewardItem("You have been rewarded 100 points", "Click to redeem"))

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewRewards)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val myAdapter = RewardsAdapter(rewardsList, this)
        recyclerView.adapter = myAdapter

        return view
    }

    fun onRewardItemClicked(clickedReward: RewardItem) {
        val manager = parentFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, TransactionSuccessFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}

class RewardsAdapter(
    private val dataset: List<RewardItem>,
    private val fragmentRef: RewardFragment
) : RecyclerView.Adapter<RewardsAdapter.RewardViewHolder>() {

    class RewardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText = view.findViewById<TextView>(R.id.rewardTitle)
        val costText = view.findViewById<TextView>(R.id.rewardPointsCost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rewardlayout, parent, false)
        return RewardViewHolder(view)
    }

    override fun onBindViewHolder(holder: RewardViewHolder, position: Int) {
        val currentReward = dataset[position]

        holder.titleText.text = currentReward.title
        holder.costText.text = currentReward.cost

        holder.itemView.setOnClickListener {
            fragmentRef.onRewardItemClicked(currentReward)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}