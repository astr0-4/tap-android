package com.alexstroulger.tapandroid

import java.time.LocalDate

data class Dance(val name: String, val steps: List<StepSequence>, val id: String, val createdDate: LocalDate)
