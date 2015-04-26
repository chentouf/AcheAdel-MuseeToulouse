package museetoulouse

class PrincipaleController {

    RechercheMuseeService rechercheMuseeService

    def index() {

    }

    def recherche() {
        def offsetTmp = params.int('offset') ?: 0
        def museeList = rechercheMuseeService.rechercheMusees(params.nomMusee, params.codePostal, params.nomRue, 5, offsetTmp)
        params.max = 5;
        render(view: 'index', model: [museeInstanceList: museeList, museeInstanceCount: museeList.getTotalCount(), params: params])
    }
}