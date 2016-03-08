package com.jabue.model

class Region implements Serializable {

    String name
    String englishName
    Integer displayOrder = 99

    static mapping = {
        table 'regions'
        version false
        cache true
    }

    static constraints = {
        name blank: false, unique: true
        englishName nullable: true
    }

}
