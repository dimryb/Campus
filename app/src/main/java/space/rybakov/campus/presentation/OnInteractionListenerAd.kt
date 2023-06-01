package space.rybakov.campus.presentation

import space.rybakov.campus.entities.Ad

interface OnInteractionListenerAd {
    fun onLike(ad: Ad)
}