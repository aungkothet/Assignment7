package io.github.aungkothet.padc.assignment7.views.holders

import android.view.View
import com.bumptech.glide.Glide
import io.github.aungkothet.padc.assignment7.R
import io.github.aungkothet.padc.assignment7.data.vos.CastVo
import kotlinx.android.synthetic.main.cast_item.view.*

class CastViewHolder(itemView: View):BaseViewHolder<CastVo>(itemView){

    override fun bindData(data: CastVo) {
        itemView.tv_cast_name.text  = data.name
        Glide.with(itemView).load(R.drawable.cast3).into(itemView.img_cast)
    }

}