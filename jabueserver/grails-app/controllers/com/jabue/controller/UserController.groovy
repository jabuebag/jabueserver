package com.jabue.controller

import com.jabue.domain.Group
import com.jabue.domain.User

class UserController {

    def index() {
        render "here is the controller of user"
    }

    def test() {
        User user = new User(username: 'jabue', email: 'test@test.com', password: 'test')
        user.group = Group.findByName(Group.GroupName.GROUP_GUEST)
        def useReturn = user.save()

        if (useReturn) {
            println 'Save Successfully!'
        }

        render "User Save Successfully!"
    }
}
