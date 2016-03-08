package com.jabue.model

class Group implements Serializable {

    public enum GroupName {
        GROUP_ROOT,
        GROUP_HOST,
        GROUP_GUEST
    }

    String name
    Set<Authority> authorities

    static hasMany = [authorities: Authority]

    static mapping = {
        table 'groups'
        version false
        cache true
        authorities joinTable: [name:   'groups_authorities',
                                key:    'group_id',
                                column: 'authority_id']
    }

    static constraints = {
        name blank: false, unique: true
    }

    Group(String name) {
        this.name = name
    }

    @Override
    int hashCode() {
        name?.hashCode() ?: 0
    }

    @Override
    boolean equals(other) {
        is(other) || (other instanceof Group && other.name == name)
    }

    @Override
    String toString() {
        name
    }
}

