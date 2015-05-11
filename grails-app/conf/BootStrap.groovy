import grails.plugin.springsecurity.SpringSecurityService
import grails.util.Environment
import museetoulouse.MuseeService
import util.museetoulouse.auth.*

class BootStrap {

    MuseeService museeService
    SpringSecurityService springSecurityService

    def init = { servletContext ->
        museeService.createJeuTest()
        def adminRole = Role.findOrSaveWhere(authority: 'ROLE_ADMIN')
        def auth = Role.findOrSaveWhere(authority: 'IS_AUTHENTICATED_FULLY')

        def me = User.findOrSaveWhere(username:'a.chentouf', password:'me', nom: 'chentouf', prenom: 'anass', email: 'a.chentouf@isae.fr')
        def bob = User.findOrSaveWhere(username:'bob', password:'bob', nom: 'bob', prenom: 'bob', email: 'bob@isae.fr')

        if (!me.authorities.contains(adminRole)){
            UserRole.create(me,adminRole,true)
        }
        if (!bob.authorities.contains(auth)){
            UserRole.create(bob,auth,true)
        }

    }
    def destroy = {
    }
}
