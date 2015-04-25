import museetoulouse.MuseeService

class BootStrap {

    MuseeService museeService

    def init = { servletContext ->

        MuseeService.createJeuTest()
    }
    def destroy = {
    }
}
