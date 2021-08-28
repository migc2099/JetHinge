package com.migc.jethinge.ui.model

data class UserInfo(
    val pictures: List<String>,
    val answers: Map<String, String>,
    val visibleInfo: Map<String, Boolean>
)

data class UserVitals(
    val firstName: String,
    val lastName: String,
    val gender: String,
    val pronouns: String,
    val sexuality: String,
    val age: Int,
    val height: String,
    val location: String,
    val ethnicity: String,
    val children: String,
    val familyPlans: String,
    val covidVaccine: String
)

data class UserVirtues(
    val work: String,
    val jobTitle: String,
    val school: String,
    val educationLevel: String,
    val religionBeliefs: String,
    val hometown: String,
    val politics: String
)

data class UserVices(
    val drinking: String,
    val smoking: String,
    val marijuana: String,
    val drugs: String
)