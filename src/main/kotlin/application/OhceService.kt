package application

import domain.Status

interface OhceService {
    fun analyzeNewWord():Status
}