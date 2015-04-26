import museetoulouse.MuseeService

class BootStrap {

    MuseeService museeService

    def init = { servletContext ->

        museeService.createJeuTest()
    }
    def destroy = {
    }
}
