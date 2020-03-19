package com.tracyogata.labapp.Models

class Model {
    var Desc: String? = null
    var Name : String? = null


    constructor():this("","") {

    }


    constructor(Desc: String?, Name: String?) {
        this.Desc = Desc
        this.Name = Name
    }
}