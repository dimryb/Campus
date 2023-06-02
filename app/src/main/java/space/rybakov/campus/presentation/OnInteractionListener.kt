package space.rybakov.campus.presentation

import space.rybakov.campus.entities.Ad

interface OnInteractionListener {
    fun onClick(ad: Ad)
}