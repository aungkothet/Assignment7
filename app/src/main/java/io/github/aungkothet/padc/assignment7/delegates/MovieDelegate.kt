package io.github.aungkothet.padc.assignment7.delegates

import io.github.aungkothet.padc.assignment7.data.vos.MovieVo

interface MovieDelegate {
    fun onDetailIconClicked(id: Int)
    fun showNnackBar(message:String)
}