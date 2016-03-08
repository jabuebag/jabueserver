package com.jabue.model

import com.jabue.model.User

class Listing implements Serializable {

    public enum Status {
        DRAFT, PENDING, PUBLISHED, OFFLINE, REJECTED;
    }

    String title
    String introduction
    String description
    String assemblePoint
    Double price
    String status = Status.DRAFT.toString()
    Integer quantity
    Date dateUpdated = new Date()
    Date dateCreated = new Date()

    Image coverImage
    Image coverImageLong
    User owner;
    Region region;

    static mapping = {
        table 'listings'
        coverImage column: 'cover_image_id', lazy: false
        coverImageLong column: 'cover_image_long_id', lazy: false
        region lazy: false
    }

    static belongsTo = [
            owner : User,
            region: Region
    ]

    static constraints = {
        title blank: false
        introduction nullable: true
        description nullable: true
        assemblePoint nullable: true
        price nullable: true
        quantity nullable: true
        coverImage nullable: true
        coverImageLong nullable: true
        region nullable: true
        owner nullable: true
    }

}
