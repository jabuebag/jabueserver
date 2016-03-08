package com.jabue.model

class Authority implements Serializable {

    String name

    public enum AuthorityName {
        ROLE_GUEST,
        ROLE_HOST,
        ROLE_ROOT
    }

    static mapping = {
        table 'authorities'
        version false
        cache true
    }

    static constraints = {
        name blank: false, unique: true
    }

    Authority(String name) {
        this.name = name
    }

    @Override
    int hashCode() {
        name?.hashCode() ?: 0
    }

    @Override
    boolean equals(other) {
        is(other) || (other instanceof Authority && other.name == name)
    }

    @Override
    String toString() {
        name
    }
}
