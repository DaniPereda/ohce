package application

import domain.Status

interface OhceService {
    fun analyzeFirstWord():String
    fun analyzeNewWord():Status
}