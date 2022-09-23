package com.example.whitelabelpdi.domain.models

import com.example.whitelabelpdi.view.model.ClassesView

data class ClassesDomain(
    var idClass: String,
    var nameClass: String,
    var numberGradeClass: String,
    var subjectClass: String
)

fun ClassesDomain.asView(): ClassesView =
    ClassesView(
        idClass = this.idClass,
        nameClass = this.nameClass,
        numberGradeClass = this.numberGradeClass,
        subjectClass = this.subjectClass,
    )