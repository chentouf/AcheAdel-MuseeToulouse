package museetoulouse

class PrincipaleController {

    RechercheMuseeService rechercheMuseeService

    def index() { }

    def recherche() {
        def museeList = rechercheMuseeService.searchMusees(params.nomMusee, params.codePostal, params.nomRue)
        render(model:[museeInstanceList: museeList, museeInstanceCount: museeList.size()])
    }
}
