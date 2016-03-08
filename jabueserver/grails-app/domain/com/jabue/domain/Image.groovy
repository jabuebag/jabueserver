package com.jabue.model

class Image implements Serializable {

    String path
    String title
    Integer width
    Integer height
    Date dateUpdated

    static mapping = {
        table 'images'
        version false
    }

    static constraints = {
        path blank: false, unique: true, maxSize: 1024
        title nullable: true, maxSize: 128
        width nullable: true
        height nullable: true
        dateUpdated nullable: true
    }

}
