package io.github.aungkothet.padc.assignment7.delegates

interface MovieDelegate {
    fun onDetailIconClicked(gsonMovieString: String?)
    fun showNnackBar(message:String)
}