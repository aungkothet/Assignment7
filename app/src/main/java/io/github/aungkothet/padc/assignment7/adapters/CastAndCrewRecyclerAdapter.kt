package io.github.aungkothet.padc.assignment7.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.aungkothet.padc.assignment7.R
import io.github.aungkothet.padc.assignment7.data.vos.CastVo
import io.github.aungkothet.padc.assignment7.views.holders.CastViewHolder

class CastAndCrewRecyclerAdapter() :
    BaseRecyclerAdapter<CastViewHolder, CastVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cast_item, parent, false)
        return CastViewHolder(view)
    }
}